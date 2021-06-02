package it.academy.dao.interfaces;

import it.academy.entity.Content;
import it.academy.entity.Document;
import it.academy.entity.DocumentName;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@ContextConfiguration(classes = JpaTestConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class DocumentDaoTest extends BaseTest {

    @Autowired
    DocumentDao documentDao;

    @Test
    public void findAll() {

        cleanInsert("documentTest.xml");

        final List<Document> author = documentDao.findAllBy(PageRequest.of(0, 4));

        assertNotNull(author);
        assertEquals(4, documentDao.count());

        deleteDataset();
    }

    @Test
    public void findByDocumentId() {
        cleanInsert("documentTest.xml");

        final Document byDocumentId = documentDao.findByDocumentId("1");

        assertNotNull(byDocumentId);
    }

    @Test
    public void searchDocument() {
        cleanInsert("documentTest.xml");

        final int countSearchResults = documentDao.countSearchResults("1");

        final List<Document> documents = documentDao.searchDocument("1", PageRequest.of(0, countSearchResults+1));

        assertNotNull(documents);
        assertEquals(1, countSearchResults+1);
    }



}