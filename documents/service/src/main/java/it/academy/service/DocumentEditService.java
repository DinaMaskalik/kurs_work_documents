package it.academy.service;

import it.academy.dao.interfaces.DocumentDao;
import it.academy.dto.DocumentEditDto;
import it.academy.dto.transform.TransformDocumentEditDtoInDocumentEntity;
import it.academy.entity.Document;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Setter
@Getter
@Service
public class DocumentEditService {

    @Autowired
    DocumentDao documentDao;

    @Autowired
    TransformDocumentEditDtoInDocumentEntity transformDocumentEditDtoInDocumentEntity;

    public Document findDocument(String id) {
        return documentDao.findByDocumentId(id);
    }

    @Transactional
    public Document editDocument(Document document, DocumentEditDto documentEditDto) {

        Document transformDocumentEditDto = transformDocumentEditDtoInDocumentEntity.transformDocumentEditDto(document, documentEditDto);

        documentDao.save(transformDocumentEditDto);

        return transformDocumentEditDto;
    }
}
