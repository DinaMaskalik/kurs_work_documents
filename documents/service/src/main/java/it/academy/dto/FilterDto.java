package it.academy.dto;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

@Data
public class FilterDto {

    private String myName;

    private String myAuthor;

    private String myWhoCreate;

}
