package com.gustavo.dto;

import java.util.List;

public record CoursePageDTO(List<CourseDTO> courses, long totalElements, int totalPages) {
   public CoursePageDTO(List<CourseDTO> courses, long totalElements, int totalPages) {
      this.courses = courses;
      this.totalElements = totalElements;
      this.totalPages = totalPages;
   }

   public List<CourseDTO> courses() {
      return this.courses;
   }

   public long totalElements() {
      return this.totalElements;
   }

   public int totalPages() {
      return this.totalPages;
   }
}
    