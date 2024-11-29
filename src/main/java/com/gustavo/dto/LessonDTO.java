package com.gustavo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public record LessonDTO(Long id, @NotNull @NotBlank @Length(min = 5,max = 100) String name, @NotNull @NotBlank @Length(min = 10,max = 11) String youtubeUrl) {
   public LessonDTO(Long id, @NotNull @NotBlank @Length(min = 5,max = 100) String name, @NotNull @NotBlank @Length(min = 10,max = 11) String youtubeUrl) {
      this.id = id;
      this.name = name;
      this.youtubeUrl = youtubeUrl;
   }

   public Long id() {
      return this.id;
   }

   @NotNull
   @NotBlank
   @Length(
      min = 5,
      max = 100
   )
   public String name() {
      return this.name;
   }

   @NotNull
   @NotBlank
   @Length(
      min = 10,
      max = 11
   )
   public String youtubeUrl() {
      return this.youtubeUrl;
   }
}