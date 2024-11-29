    package com.gustavo.enums;

public enum Category {
   BACK_END("Back-end"),
   FRONT_END("Front-end");

   private String value;

   private Category(String value) {
      this.value = value;
   }

   public String getValue() {
      return this.value;
   }

   public String toString() {
      return this.value;
   }

   // $FF: synthetic method
   private static Category[] $values() {
      return new Category[]{BACK_END, FRONT_END};
   }
}
    