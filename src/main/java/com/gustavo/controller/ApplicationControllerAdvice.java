package com.gustavo.controler;

import com.gustavo.exception.RecordNotFoundException;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Path;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@RestControllerAdvice
public class ApplicationControllerAdvice {
   @ExceptionHandler({RecordNotFoundException.class})
   @ResponseStatus(HttpStatus.NOT_FOUND)
   public String handleNotFoundException(RecordNotFoundException ex) {
      return ex.getMessage();
   }

   @ExceptionHandler({MethodArgumentNotValidException.class})
   @ResponseStatus(HttpStatus.BAD_REQUEST)
   public String handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
      return (String)ex.getBindingResult().getFieldErrors().stream().map((error) -> {
         String var10000 = error.getField();
         return var10000 + " " + error.getDefaultMessage();
      }).reduce("", (acc, error) -> {
         return acc + error + "\n";
      });
   }

   @ExceptionHandler({ConstraintViolationException.class})
   @ResponseStatus(HttpStatus.BAD_REQUEST)
   public String handleConstraintViolationException(ConstraintViolationException ex) {
      return (String)ex.getConstraintViolations().stream().map((error) -> {
         Path var10000 = error.getPropertyPath();
         return var10000 + " " + error.getMessage();
      }).reduce("", (acc, error) -> {
         return acc + error + "\n";
      });
   }

   @ExceptionHandler({MethodArgumentTypeMismatchException.class})
   @ResponseStatus(HttpStatus.BAD_REQUEST)
   public String handleMethodArgumentTypeMismatchExceotion(MethodArgumentTypeMismatchException ex) {
      if (ex != null && ex.getRequiredType() != null) {
         String type = ex.getRequiredType().getName();
         String[] typeParts = type.split("\\.");
         String typeName = typeParts[typeParts.length - 1];
         String var10000 = ex.getName();
         return var10000 + " should be of type " + typeName;
      } else {
         return "Argument type not valid";
      }
   }
}