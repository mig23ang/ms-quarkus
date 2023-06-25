package org.co.mineria.utils;

import jakarta.inject.Singleton;
import org.co.mineria.dao.entity.PropuestaEntity;
import org.co.mineria.dto.PropuestaDTO;
import org.co.mineria.dto.PropuestaDetallesDTO;
import org.modelmapper.ModelMapper;

@Singleton
public class PropuestaMapper {

    // vamos a mappar la propuesta de PropuestaDetallesDTO a PropuestaEntity y viceversa

    private ModelMapper modelMapper;

    public PropuestaMapper() {
        this.modelMapper = new ModelMapper();
    }

    public PropuestaEntity propuestaDTOToEntity(PropuestaDetallesDTO propuestaDetallesDTO) {
        return modelMapper.map(propuestaDetallesDTO, PropuestaEntity.class);
    }

    public PropuestaDetallesDTO propuestaentityToDTO(PropuestaEntity propuestaEntity) {
        return modelMapper.map(propuestaEntity, PropuestaDetallesDTO.class);
    }

    //propuestaEntityToPropuestaDTO

    public PropuestaDTO propuestaEntityToDTO(PropuestaEntity propuestaEntity) {
        return modelMapper.map(propuestaEntity, PropuestaDTO.class);
    }

}
