package com.gustavo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.gustavo.enums.Category;
import com.gustavo.enums.validation.ValueOfEnum;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.util.List;
import org.hibernate.validator.constraints.Length;

public record CourseDTO(Long id, @NotBlank @NotNull @Length(min = 5,max = 100) String name, @NotNull @Length(max = 10) @ValueOfEnum(enumClass = Category.class) String category, @NotNull @NotEmpty @Valid List<LessonDTO> lessons) {
   public CourseDTO(@JsonProperty("_id") Long id, @NotBlank @NotNull @Length(min = 5,max = 100) String name, @NotNull @Length(max = 10) @ValueOfEnum(enumClass = Category.class) String category, @NotNull @NotEmpty @Valid List<LessonDTO> lessons) {
      this.id = id;
      this.name = name;
      this.category = category;
      this.lessons = lessons;
   }

   @JsonProperty("_id")
   public Long id() {
      return this.id;
   }

   @NotBlank
   @NotNull
   @Length(
      min = 5,
      max = 100
   )
   public String name() {
      return this.name;
   }

   @NotNull
   @Length(
      max = 10
   )
   @ValueOfEnum(
      enumClass = Category.class
   )
   public String category() {
      return this.category;
   }

   @NotNull
   @NotEmpty
   @Valid
   public List<LessonDTO> lessons() {
      return this.lessons;
   }
}