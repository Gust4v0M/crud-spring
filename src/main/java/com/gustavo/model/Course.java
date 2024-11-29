package com.gustavo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.gustavo.enums.Category;
import com.gustavo.enums.Status;
import com.gustavo.enums.converters.CategoryConverter;
import com.gustavo.enums.converters.StatusConverter;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.validator.constraints.Length;

@Entity
@SQLDelete(
   sql = "UPDATE Course SET status = 'Inativo' where id = ? AND status = 'Ativo'"
)
public class Course {
   @Id
   @GeneratedValue(
      strategy = GenerationType.AUTO
   )
   @JsonProperty("_id")
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
   @NotNull
   @Column(
      nullable = false
   )
   @Convert(
      converter = CategoryConverter.class
   )
   private Category category;
   @NotNull
   @Column(
      length = 10,
      nullable = false
   )
   @Convert(
      converter = StatusConverter.class
   )
   private Status status;
   @NotNull
   @NotEmpty
   @Valid
   @OneToMany(
      cascade = {CascadeType.ALL},
      orphanRemoval = true,
      mappedBy = "course"
   )
   private List<Lesson> lessons;

   public Course() {
      this.status = Status.ACTIVE;
      this.lessons = new ArrayList();
   }

   public long getId() {
      return this.id;
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

   public Category getCategory() {
      return this.category;
   }

   public void setCategory(Category category) {
      this.category = category;
   }

   public Status getStatus() {
      return this.status;
   }

   public void setStatus(Status status) {
      this.status = status;
   }

   public List<Lesson> getLessons() {
      return this.lessons;
   }

   public void setLessons(List<Lesson> lessons) {
      this.lessons = lessons;
   }
}