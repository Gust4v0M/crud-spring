package com.gustavo.enums.converters;

import com.gustavo.enums.Category;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import java.util.stream.Stream;

@Converter(
   autoApply = true
)
public class CategoryConverter implements AttributeConverter<Category, String> {
   public String convertToDatabaseColumn(Category category) {
      return category == null ? null : category.getValue();
   }

   public Category convertToEntityAttribute(String value) {
      return value == null ? null : (Category)Stream.of(Category.values()).filter((c) -> {
         return c.getValue().equals(value);
      }).findFirst().orElseThrow(IllegalArgumentException::new);
   }
}