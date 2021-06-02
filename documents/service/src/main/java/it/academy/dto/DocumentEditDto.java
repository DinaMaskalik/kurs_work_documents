package it.academy.dto;

import lombok.Data;

@Data
public class DocumentEditDto {

    private String documentName;

    private String content;

    private String personWithWhomTheContractWasSigned;

    private String personWhoConcludedContract;

    private Long periodOfExecution;
}
