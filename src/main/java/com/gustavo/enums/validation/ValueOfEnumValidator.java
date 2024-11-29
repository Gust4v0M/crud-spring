package com.gustavo.enums.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ValueOfEnumValidator implements ConstraintValidator<ValueOfEnum, CharSequence> {
   private List<String> acceptedValues;

   public void initialize(ValueOfEnum annotation) {
      this.acceptedValues = (List)Stream.of((Enum[])annotation.enumClass().getEnumConstants()).map(Enum::toString).collect(Collectors.toList());
   }

   public boolean isValid(CharSequence value, ConstraintValidatorContext context) {
      return value == null ? true : this.acceptedValues.contains(value.toString());
   }
}