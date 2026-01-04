package dev.joseph.springdemo.model;
import java.time.LocalDateTime;

public record demoModel(
    Integer id,
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
