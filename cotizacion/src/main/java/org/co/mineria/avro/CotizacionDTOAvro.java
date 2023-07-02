package org.co.mineria.avro;


import org.apache.avro.specific.SpecificData;
import org.apache.avro.util.Utf8;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@org.apache.avro.specific.AvroGenerated
public class CotizacionDTOAvro extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -8909961508163098800L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"CotizacionDTOAvro\",\"namespace\":\"org.co.mineria.avro\",\"fields\":[{\"name\":\"date\",\"type\":[\"null\",\"long\"],\"default\":null},{\"name\":\"actualPrice\",\"type\":[\"null\",\"string\"],\"default\":null}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<CotizacionDTOAvro> ENCODER =
      new BinaryMessageEncoder<CotizacionDTOAvro>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<CotizacionDTOAvro> DECODER =
      new BinaryMessageDecoder<CotizacionDTOAvro>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<CotizacionDTOAvro> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<CotizacionDTOAvro> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<CotizacionDTOAvro> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<CotizacionDTOAvro>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this CotizacionDTOAvro to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a CotizacionDTOAvro from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a CotizacionDTOAvro instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static CotizacionDTOAvro fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

   private java.lang.Long date;
   private java.lang.CharSequence actualPrice;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public CotizacionDTOAvro() {}

  /**
   * All-args constructor.
   * @param date The new value for date
   * @param actualPrice The new value for actualPrice
   */
  public CotizacionDTOAvro(java.lang.Long date, java.lang.CharSequence actualPrice) {
    this.date = date;
    this.actualPrice = actualPrice;
  }

  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return date;
    case 1: return actualPrice;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: date = (java.lang.Long)value$; break;
    case 1: actualPrice = (java.lang.CharSequence)value$; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'date' field.
   * @return The value of the 'date' field.
   */
  public java.lang.Long getDate() {
    return date;
  }


  /**
   * Sets the value of the 'date' field.
   * @param value the value to set.
   */
  public void setDate(java.lang.Long value) {
    this.date = value;
  }

  /**
   * Gets the value of the 'actualPrice' field.
   * @return The value of the 'actualPrice' field.
   */
  public java.lang.CharSequence getActualPrice() {
    return actualPrice;
  }


  /**
   * Sets the value of the 'actualPrice' field.
   * @param value the value to set.
   */
  public void setActualPrice(java.lang.CharSequence value) {
    this.actualPrice = value;
  }

  /**
   * Creates a new CotizacionDTOAvro RecordBuilder.
   * @return A new CotizacionDTOAvro RecordBuilder
   */
  public static org.co.mineria.avro.CotizacionDTOAvro.Builder newBuilder() {
    return new org.co.mineria.avro.CotizacionDTOAvro.Builder();
  }

  /**
   * Creates a new CotizacionDTOAvro RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new CotizacionDTOAvro RecordBuilder
   */
  public static org.co.mineria.avro.CotizacionDTOAvro.Builder newBuilder(org.co.mineria.avro.CotizacionDTOAvro.Builder other) {
    if (other == null) {
      return new org.co.mineria.avro.CotizacionDTOAvro.Builder();
    } else {
      return new org.co.mineria.avro.CotizacionDTOAvro.Builder(other);
    }
  }

  /**
   * Creates a new CotizacionDTOAvro RecordBuilder by copying an existing CotizacionDTOAvro instance.
   * @param other The existing instance to copy.
   * @return A new CotizacionDTOAvro RecordBuilder
   */
  public static org.co.mineria.avro.CotizacionDTOAvro.Builder newBuilder(org.co.mineria.avro.CotizacionDTOAvro other) {
    if (other == null) {
      return new org.co.mineria.avro.CotizacionDTOAvro.Builder();
    } else {
      return new org.co.mineria.avro.CotizacionDTOAvro.Builder(other);
    }
  }

  /**
   * RecordBuilder for CotizacionDTOAvro instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<CotizacionDTOAvro>
    implements org.apache.avro.data.RecordBuilder<CotizacionDTOAvro> {

    private java.lang.Long date;
    private java.lang.CharSequence actualPrice;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(org.co.mineria.avro.CotizacionDTOAvro.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.date)) {
        this.date = data().deepCopy(fields()[0].schema(), other.date);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.actualPrice)) {
        this.actualPrice = data().deepCopy(fields()[1].schema(), other.actualPrice);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
    }

    /**
     * Creates a Builder by copying an existing CotizacionDTOAvro instance
     * @param other The existing instance to copy.
     */
    private Builder(org.co.mineria.avro.CotizacionDTOAvro other) {
      super(SCHEMA$);
      if (isValidValue(fields()[0], other.date)) {
        this.date = data().deepCopy(fields()[0].schema(), other.date);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.actualPrice)) {
        this.actualPrice = data().deepCopy(fields()[1].schema(), other.actualPrice);
        fieldSetFlags()[1] = true;
      }
    }

    /**
      * Gets the value of the 'date' field.
      * @return The value.
      */
    public java.lang.Long getDate() {
      return date;
    }


    /**
      * Sets the value of the 'date' field.
      * @param value The value of 'date'.
      * @return This builder.
      */
    public org.co.mineria.avro.CotizacionDTOAvro.Builder setDate(java.lang.Long value) {
      validate(fields()[0], value);
      this.date = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'date' field has been set.
      * @return True if the 'date' field has been set, false otherwise.
      */
    public boolean hasDate() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'date' field.
      * @return This builder.
      */
    public org.co.mineria.avro.CotizacionDTOAvro.Builder clearDate() {
      date = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'actualPrice' field.
      * @return The value.
      */
    public java.lang.CharSequence getActualPrice() {
      return actualPrice;
    }


    /**
      * Sets the value of the 'actualPrice' field.
      * @param value The value of 'actualPrice'.
      * @return This builder.
      */
    public org.co.mineria.avro.CotizacionDTOAvro.Builder setActualPrice(java.lang.CharSequence value) {
      validate(fields()[1], value);
      this.actualPrice = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'actualPrice' field has been set.
      * @return True if the 'actualPrice' field has been set, false otherwise.
      */
    public boolean hasActualPrice() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'actualPrice' field.
      * @return This builder.
      */
    public org.co.mineria.avro.CotizacionDTOAvro.Builder clearActualPrice() {
      actualPrice = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public CotizacionDTOAvro build() {
      try {
        CotizacionDTOAvro record = new CotizacionDTOAvro();
        record.date = fieldSetFlags()[0] ? this.date : (java.lang.Long) defaultValue(fields()[0]);
        record.actualPrice = fieldSetFlags()[1] ? this.actualPrice : (java.lang.CharSequence) defaultValue(fields()[1]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<CotizacionDTOAvro>
    WRITER$ = (org.apache.avro.io.DatumWriter<CotizacionDTOAvro>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<CotizacionDTOAvro>
    READER$ = (org.apache.avro.io.DatumReader<CotizacionDTOAvro>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    if (this.date == null) {
      out.writeIndex(0);
      out.writeNull();
    } else {
      out.writeIndex(1);
      out.writeLong(this.date);
    }

    if (this.actualPrice == null) {
      out.writeIndex(0);
      out.writeNull();
    } else {
      out.writeIndex(1);
      out.writeString(this.actualPrice);
    }

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      if (in.readIndex() != 1) {
        in.readNull();
        this.date = null;
      } else {
        this.date = in.readLong();
      }

      if (in.readIndex() != 1) {
        in.readNull();
        this.actualPrice = null;
      } else {
        this.actualPrice = in.readString(this.actualPrice instanceof Utf8 ? (Utf8)this.actualPrice : null);
      }

    } else {
      for (int i = 0; i < 2; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          if (in.readIndex() != 1) {
            in.readNull();
            this.date = null;
          } else {
            this.date = in.readLong();
          }
          break;

        case 1:
          if (in.readIndex() != 1) {
            in.readNull();
            this.actualPrice = null;
          } else {
            this.actualPrice = in.readString(this.actualPrice instanceof Utf8 ? (Utf8)this.actualPrice : null);
          }
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}










