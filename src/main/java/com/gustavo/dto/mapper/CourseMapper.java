package com.gustavo.dto.mapper;

import com.gustavo.dto.CourseDTO;
import com.gustavo.dto.LessonDTO;
import com.gustavo.enums.Category;
import com.gustavo.model.Course;
import com.gustavo.model.Lesson;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class CourseMapper {
   public CourseDTO toDTO(Course course) {
      if (course == null) {
         return null;
      } else {
         List<LessonDTO> lessons = (List)course.getLessons().stream().map((lesson) -> {
            return new LessonDTO(lesson.getId(), lesson.getName(), lesson.getYoutubeUrl());
         }).collect(Collectors.toList());
         return new CourseDTO(course.getId(), course.getName(), course.getCategory().getValue(), lessons);
      }
   }

   public Course toEntity(CourseDTO courseDTO) {
      if (courseDTO == null) {
         return null;
      } else {
         Course course = new Course();
         if (courseDTO.id() != null) {
            course.setId(courseDTO.id());
         }

         course.setName(courseDTO.name());
         course.setCategory(this.convertCategoryValue(courseDTO.category()));
         List<Lesson> lessons = (List)courseDTO.lessons().stream().map((lessonDTO) -> {
            Lesson lesson = new Lesson();
            if (lessonDTO.id() != null) {
               lesson.setId(lessonDTO.id());
            }

            lesson.setName(lessonDTO.name());
            lesson.setYoutubeUrl(lessonDTO.youtubeUrl());
            lesson.setCourse(course);
            return lesson;
         }).collect(Collectors.toList());
         course.setLessons(lessons);
         return course;
      }
   }

   public Category convertCategoryValue(String value) {
      if (value == null) {
         return null;
      } else {
         byte var3 = -1;
         switch(value.hashCode()) {
         case -2110547179:
            if (value.equals("Back-end")) {
               var3 = 1;
            }
            break;
         case 2130558743:
            if (value.equals("Front-end")) {
               var3 = 0;
            }
         }

         Category var10000;
         switch(var3) {
         case 0:
            var10000 = Category.FRONT_END;
            break;
         case 1:
            var10000 = Category.BACK_END;
            break;
         default:
            throw new IllegalArgumentException("Categoria-Invalida: " + value);
         }

         return var10000;
      }
   }
}
    