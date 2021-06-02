package it.academy.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NonNull;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Value;
//import org.hibernate.validator.constraints.NotEmpty;

@Data
public class DocumentSaveDto {

    @NotBlank
    @Size(min = 2)
    private String documentName;

    @NotBlank
    @Size(min = 5)
    private String author;

    @NotBlank
    @Size(min = 5)
    private String personWithWhomTheContractWasSigned;

    @NotBlank
    @Size(min = 5)
    private String personWhoConcludedContract;

    @NotNull
    @Min(0)
    private Long periodOfExecution;

    @NotBlank
    @Size(min = 5)
    private String content;
}
