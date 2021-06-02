package it.academy.service;

import it.academy.dao.interfaces.DocumentDao;
import it.academy.dto.DocumentSaveDto;
import it.academy.dto.transform.TransformDocumentSaveDtoInDocumentEntity;
import it.academy.entity.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DocumentSaveService {

    @Autowired
    DocumentDao documentDao;

    @Autowired
    TransformDocumentSaveDtoInDocumentEntity transformDocumentSaveDtoInDocumentEntity;

    @Transactional
    public void saveNewDocument(DocumentSaveDto documentSaveDto) {

        final Document document = transformDocumentSaveDtoInDocumentEntity.transform(documentSaveDto);

        documentDao.save(document);
    }
}
