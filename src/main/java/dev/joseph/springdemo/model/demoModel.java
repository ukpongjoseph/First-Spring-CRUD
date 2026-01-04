package dev.joseph.springdemo.model;
import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;


public record demoModel(
    Integer id,
    @NotBlank
    String title,
    String desc,
    LocalDateTime dateCreated,
    LocalDateTime dateUpdated,
    String url,
    Status status,
    Type modelType
) 
{

}
