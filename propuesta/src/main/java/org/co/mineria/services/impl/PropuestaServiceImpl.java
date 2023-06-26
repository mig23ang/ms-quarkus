package org.co.mineria.services.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.co.mineria.dao.contract.PropuestaDAO;
import org.co.mineria.dao.entity.PropuestaEntity;
import org.co.mineria.dto.PropuestaDTO;
import org.co.mineria.dto.PropuestaDetallesDTO;
import org.co.mineria.message.KafkaEvent;
import org.co.mineria.services.contract.IPropuestaService;
import org.co.mineria.utils.PropuestaMapper;

import java.util.Date;
import java.util.Optional;
import java.util.logging.Logger;

@ApplicationScoped
public class PropuestaServiceImpl implements IPropuestaService {

    private final Logger LOG = Logger.getLogger(PropuestaServiceImpl.class.getName());

    @Inject
    PropuestaDAO propuestaDAO;

    @Inject
    KafkaEvent kafkaEvent;

    @Inject
    PropuestaMapper propuestaMapper;

    @Override
    public PropuestaDetallesDTO findFullPropuesta(long id) {

        LOG.info("Inicia buscando propuesta por id: {}" + id);
        try {
            PropuestaEntity propuestaEntity = propuestaDAO.findById(id);
            return PropuestaDetallesDTO.builder().propuestaId(propuestaEntity.getId())
                    .propuestaValidaDias(propuestaEntity.getPropuestaValidaDias())
                    .pais(propuestaEntity.getPais())
                    .priceTonelada(propuestaEntity.getPriceTonelada())
                    .cliente(propuestaEntity.getCliente())
                    .toneladas(propuestaEntity.getToneladas())
                    .build();
        } catch (Exception e) {

            LOG.info("Error buscando propuesta por id: {}" + id);
            return null;
        }
    }

    @Override
    @Transactional
    public void crearPropuesta(PropuestaDetallesDTO propuestaDetallesDTO) {

        LOG.info("Inicia creando propuesta: " + propuestaDetallesDTO);
        PropuestaDTO propuestaDTO = buildAndSavePropuesta(propuestaDetallesDTO);

        LOG.info("Finaliza creando propuesta: " + propuestaDTO);
        kafkaEvent.sendNewEventKafka(propuestaDTO);

    }

    @Override
    @Transactional
    public void actualizarPropuesta(PropuestaDetallesDTO propuestaDetallesDTO) {

        LOG.info("Inicia actualizando propuesta: {}" + propuestaDetallesDTO);
        try {
            PropuestaEntity propuestaEntity = propuestaMapper.propuestaDTOToEntity(propuestaDetallesDTO);
            PropuestaDTO propuestaDTO = propuestaMapper.propuestaEntityToDTO(propuestaEntity);
            propuestaDAO.persist(propuestaEntity);
            LOG.info("Finaliza actualizando propuesta: {}" + propuestaDetallesDTO);

            kafkaEvent.sendNewEventKafka(propuestaDTO);
        } catch (Exception e) {
            LOG.info("Error actualizando propuesta: {}" + propuestaDetallesDTO);

        }
    }

    @Override
    @Transactional
    public void eliminarPropuesta(Long id) {

        LOG.info("Inicia eliminando propuesta por id: {}" + id);
        try {
            propuestaDAO.deleteById(id);
            LOG.info("Finaliza eliminando propuesta por id: {}" + id);
        } catch (Exception e) {
            LOG.info("Error eliminando propuesta por id: {}" + id);
        }

    }

    //metodo para crear la propuesta agregando el usuario y la fecha de creacion
    private PropuestaDTO buildAndSavePropuesta(PropuestaDetallesDTO propuestaDetallesDTO) {
        try {
            PropuestaEntity propuestaEntity = new PropuestaEntity();
            propuestaEntity.setCreado(new Date());
            propuestaEntity.setPropuestaValidaDias(propuestaDetallesDTO.getPropuestaValidaDias());
            propuestaEntity.setCliente(propuestaDetallesDTO.getCliente());
            propuestaEntity.setPriceTonelada(propuestaDetallesDTO.getPriceTonelada());

            propuestaDAO.persist(propuestaEntity);

            Optional<PropuestaEntity> propuestaOptional = propuestaDAO.findByCliente(propuestaEntity.getCliente());
            if (propuestaOptional.isPresent()) {
                PropuestaEntity savedPropuestaEntity = propuestaOptional.get();
                return PropuestaDTO.builder()
                        .propuestaId(savedPropuestaEntity.getId())
                        .priceTonelada(savedPropuestaEntity.getPriceTonelada())
                        .cliente(savedPropuestaEntity.getCliente())
                        .build();
            } else {
                // Manejar el caso en que no se encuentre la propuesta guardada
                LOG.warning("No se pudo encontrar la propuesta guardada para el cliente: " + propuestaDetallesDTO.getCliente());
                return null;
            }
        } catch (Exception e) {
            LOG.info("Error creando propuesta: " + propuestaDetallesDTO);
            return null;
        }
    }

}

