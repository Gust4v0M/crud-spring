package com.gustavo.enums;

public enum Status {
   ACTIVE("Ativo"),
   INACTIVE("Inativo");

   private String value;

   private Status(String status) {
      this.value = status;
   }

   public String getValue() {
      return this.value;
   }

   public String geString() {
      return this.value;
   }

   // $FF: synthetic method
   private static Status[] $values() {
      return new Status[]{ACTIVE, INACTIVE};
   }
}