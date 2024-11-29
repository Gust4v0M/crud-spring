package com.gustavo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

@Entity
public class Lesson {
   @Id
   @GeneratedValue(
      strategy = GenerationType.AUTO
   )
   private long id;
   @NotBlank
   @NotNull
   @Length(
      min = 5,
      max = 100
   )
   @Column(
      length = 100,
      nullable = false
   )
   private String name;
   @NotBlank
   @NotNull
   @Length(
      min = 10,
      max = 11
   )
   @Column(
      length = 11,
      nullable = false
   )
   private String youtubeUrl;
   @NotNull
   @ManyToOne(
      fetch = FetchType.LAZY,
      optional = false
   )
   @JoinColumn(
      name = "course_id",
      nullable = false
   )
   @JsonProperty(
      access = Access.WRITE_ONLY
   )
   private Course course;

   public long getId() {
      return this.id;
   }

   public String toString() {
      return "Lesson [id=" + this.id + ", name=" + this.name + ", youtubeUrl=" + this.youtubeUrl + ", course=" + this.course + "]";
   }

   public void setId(long id) {
      this.id = id;
   }

   public String getName() {
      return this.name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getYoutubeUrl() {
      return this.youtubeUrl;
   }

   public void setYoutubeUrl(String youtubeUrl) {
      this.youtubeUrl = youtubeUrl;
   }

   public Course getCourse() {
      return this.course;
   }

   public void setCourse(Course course) {
      this.course = course;
   }
}