package it.academy.service;

import it.academy.dao.interfaces.DocumentDao;
import it.academy.entity.Document;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Setter
@Getter
@Service
public class DocumentDeleteService {

    @Autowired
    DocumentDao documentDao;

    public void deleteDocument(String id) {

        documentDao.deleteById(id);

    }

}
