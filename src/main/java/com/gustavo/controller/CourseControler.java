package com.gustavo.controller;

import com.gustavo.dto.CourseDTO;
import com.gustavo.dto.CoursePageDTO;
import com.gustavo.service.CourseService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequestMapping({"/api/courses"})
public class CourseControler {
   public final CourseService courseService;

   public CourseControler(CourseService courseService) {
      this.courseService = courseService;
   }

   @GetMapping
   public CoursePageDTO list(@RequestParam(defaultValue = "0") @PositiveOrZero int page, @RequestParam(defaultValue = "10") @Positive @Max(100L) int pageSize) {
      return this.courseService.list(page, pageSize);
   }

   @GetMapping({"/{id}"})
   public CourseDTO findById(@PathVariable @NotNull @Positive Long id) {
      return this.courseService.findById(id);
   }

   @PostMapping
   @ResponseStatus(
      code = HttpStatus.CREATED
   )
   public CourseDTO create(@RequestBody @Valid @NotNull CourseDTO course) {
      return this.courseService.create(course);
   }

   @PutMapping({"/{id}"})
   public CourseDTO update(@PathVariable @NotNull @Positive Long id, @RequestBody @Valid CourseDTO course) {
      return this.courseService.update(id, course);
   }

   @DeleteMapping({"/{id}"})
   @ResponseStatus(
      code = HttpStatus.NO_CONTENT
   )
   public void delete(@PathVariable @NotNull @Positive Long id) {
      this.courseService.delete(id);
   }
}