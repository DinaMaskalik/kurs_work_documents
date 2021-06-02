package it.academy.dto.transform;

import it.academy.dto.DocumentEditDto;
import it.academy.entity.Document;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
public class TransformDocumentEditDtoInDocumentEntity {

    public Document transformDocumentEditDto(Document document, DocumentEditDto documentEditDto){

        document.getContent().setContent(documentEditDto.getContent());
        document.getDocumentName().setDocumentName(documentEditDto.getDocumentName());
        document.getPeriodOfExecution().setPeriodOfExecution(documentEditDto.getPeriodOfExecution());
        document.getPersonWhoConcludedContract()
                .setPersonWhoConcludedContract(
                        documentEditDto.getPersonWhoConcludedContract()
                );
        document.getPersonWithWhomTheContractWasSigned()
                .setPersonWithWhomTheContractWasSigned(
                        documentEditDto.getPersonWithWhomTheContractWasSigned()
                );

        System.out.println(document);
        return document;

    }

}
