package com.gustavo.enums.converters;

import com.gustavo.enums.Status;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import java.util.stream.Stream;

@Converter(
   autoApply = true
)
public class StatusConverter implements AttributeConverter<Status, String> {
   public String convertToDatabaseColumn(Status status) {
      return status == null ? null : status.getValue();
   }

   public Status convertToEntityAttribute(String value) {
      return value == null ? null : (Status)Stream.of(Status.values()).filter((c) -> {
         return c.getValue().equals(value);
      }).findFirst().orElseThrow(IllegalArgumentException::new);
   }
}