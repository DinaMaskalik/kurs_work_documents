package it.academy.dao.interfaces;

import it.academy.entity.Document;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@ContextConfiguration(classes = JpaTestConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class DocumentFilterDaoTest extends BaseTest {

    @Autowired
    DocumentFilterDao documentFilterDao;

    @Test
    public void getFilterParameter(){
        cleanInsert("documentTest.xml");

        final List<String> author = documentFilterDao.getAuthor();

        assertNotNull(author);

        assertEquals(4,author.size());

        deleteDataset();
    }

    @Test
    public void getFilterResultWithOneParameter1(){

        cleanInsert("documentTest.xml");

        final List<Document> name = documentFilterDao.findByDocumentName("Name1");

        assertNotNull(name);
        assertEquals(1,name.size());

        deleteDataset();

    }

    @Test
    public void getFilterResultWithOneParameter2(){

        cleanInsert("documentTest.xml");

        final List<Document> personWhoConcludedContract
                = documentFilterDao.findByPersonWhoConcludedContract("111");

        assertNotNull(personWhoConcludedContract);
        assertEquals(1,personWhoConcludedContract.size());

        deleteDataset();

    }
    @Test
    public void getFilterResultWithOneParameter3(){

        cleanInsert("documentTest.xml");

        final List<Document> author = documentFilterDao.findByAuthor("Author1");
        final List<Document> name = documentFilterDao.findByDocumentName("Name1");
        final List<Document> personWhoConcludedContract
                = documentFilterDao.findByPersonWhoConcludedContract("111");

        assertNotNull(author);
        assertNotNull(name);
        assertNotNull(personWhoConcludedContract);
        assertEquals(1,author.size());
        assertEquals(1,name.size());
        assertEquals(1,personWhoConcludedContract.size());

        deleteDataset();

    }

    @Test
    public void getFilterResultWithTwoParameter1(){

        cleanInsert("documentTest.xml");

        final List<Document> authorAndName =
                documentFilterDao.findByAuthorAndName("Author1", "Name1");

        assertNotNull(authorAndName);
        assertEquals(1,authorAndName.size());

        deleteDataset();

    }

    @Test
    public void getFilterResultWithTwoParameter2(){

        cleanInsert("documentTest.xml");

        final List<Document> personWhoConcludedContractAndName
                = documentFilterDao.findByPersonWhoConcludedContractAndName("111", "Name1");

        assertNotNull(personWhoConcludedContractAndName);
        assertEquals(1,personWhoConcludedContractAndName.size());

        deleteDataset();

    }

    @Test
    public void getFilterResultWithTwoParameter3(){

        cleanInsert("documentTest.xml");

        final List<Document> authorAndPersonWhoConcludedContract
                = documentFilterDao.findByAuthorAndPersonWhoConcludedContract("Author2", "222");

        assertNotNull(authorAndPersonWhoConcludedContract);
        assertEquals(1,authorAndPersonWhoConcludedContract.size());

        deleteDataset();

    }

    @Test
    public void getFilterResultWithThreeParameter(){

        cleanInsert("documentTest.xml");

        final List<Document> authorAndDocumentNameAndPersonWhoConcludedContract =
                documentFilterDao.findByAuthorAndDocumentNameAndPersonWhoConcludedContract(
                        "Author1", "Name1", "111");

        assertNotNull(authorAndDocumentNameAndPersonWhoConcludedContract);

        assertEquals(1,authorAndDocumentNameAndPersonWhoConcludedContract.size());

        deleteDataset();

    }



}