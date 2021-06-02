package it.academy.service;

import it.academy.dao.interfaces.DocumentDao;
import it.academy.dao.interfaces.DocumentFilterDao;
import it.academy.entity.Author;
import it.academy.entity.Document;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.print.Doc;
import java.util.List;

import static org.junit.Assert.*;

@ContextConfiguration(classes = {JpaTestConfig.class, AppConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class DocumentDeleteServiceTest {

    @Autowired
    DocumentDeleteService documentDeleteService;

    @Test
    public void deleteDocument() {

        DocumentDao documentDao=Mockito.mock(DocumentDao.class);

        Document document1 = new Document();
        document1.setDocumentId("1");
        document1.setAuthor(new Author(null,"Author1"));

        Document document2 = new Document();
        document2.setDocumentId("2");
        document2.setAuthor(new Author(null,"Author2"));

        Mockito
                .when(documentDao.findAll())
                .thenReturn(List.of(document1, document2));

        documentDeleteService.setDocumentDao(documentDao);

        documentDeleteService.deleteDocument("1");

        //Then
        final DocumentDao dao = documentDeleteService.getDocumentDao();

        assertNotNull(documentDao);
        assertEquals(2, documentDao.findAll().size());


    }
}