package it.academy.entity;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import javax.print.Doc;
import java.util.List;

import static org.junit.Assert.*;

public class DocumentTest extends BaseTest{

    @Test
    public void read() {
        cleanInsert("documentTest.xml");

        final List<Document> document = sessionFactory.openSession()
                .createQuery("from Document ", Document.class)
                .list();

        assertNotNull(document);
        assertEquals(4, document.size());

        deleteDataset();

    }

    @Test
    public void add() {
        final Session session = sessionFactory.openSession();

        final Transaction transaction = session.beginTransaction();

        DocumentName documentName = new DocumentName();
        documentName.setDocumentName("Name1");

        Content content= new Content();
        content.setContent("Content1");

        Document document = new Document();
        document.setContent(content);
        document.setDocumentName(documentName);
//        document.setAuthor("Author1");
//        document.setPeriodOfExecution(44l);
//        document.setPersonWhoConcludedContract("111");
//        document.setPersonWithWhomTheContractWasSigned("111");


        session.save(document);
        transaction.commit();

        assertEquals(1,
                session.createQuery("from Document ", Document.class)
                        .list()
                        .size()
        );


    }

    @Test
    public void delete() {
        cleanInsert("documentTest.xml");

        final Session session = sessionFactory.openSession();

        final Transaction transaction = session.beginTransaction();

        final List<Document> document =
                session
                        .createQuery("from Document ", Document.class)
                        .list();

        document.forEach(session::delete);
        transaction.commit();


        assertEquals(
                0,
                session.createQuery("from Document ").list().size()
        );
    }

}