package it.academy.dto.transform;

import it.academy.dto.DocumentSaveDto;
import it.academy.entity.*;
import org.springframework.stereotype.Component;

@Component
public class TransformDocumentSaveDtoInDocumentEntity {

    public Document transform(DocumentSaveDto documentSaveDto) {

        Document document = new Document();

        document.setContent(new Content(null, documentSaveDto.getContent()));
        document.setDocumentName(new DocumentName(null, documentSaveDto.getDocumentName()));
        document.setAuthor(new Author(null, documentSaveDto.getAuthor()));
        document.setPersonWithWhomTheContractWasSigned(
                new PersonWithWhomTheContractWasSigned(
                        null,
                        documentSaveDto.getPersonWithWhomTheContractWasSigned()
                )
        );
        document.setPersonWhoConcludedContract(
                new PersonWhoConcludedContract(null,
                documentSaveDto.getPersonWhoConcludedContract()
                )
        );

        document.setPeriodOfExecution(
                new PeriodOfExecution(null,
                documentSaveDto.getPeriodOfExecution()
                )
        );
        document.setCreateDate(new java.sql.Date((new java.util.Date()).getTime()));

        return document;

    }
}
