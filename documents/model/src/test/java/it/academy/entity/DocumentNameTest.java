package it.academy.entity;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class DocumentNameTest extends BaseTest {

    @Test
    public void read() {
        cleanInsert("documentNameTest.xml");

        final List<DocumentName> documentName = sessionFactory.openSession()
                .createQuery("from DocumentName ", DocumentName.class)
                .list();

        assertNotNull(documentName);
        assertEquals(4, documentName.size());

        deleteDataset();

    }

    @Test
    public void add() {
        final Session session = sessionFactory.openSession();

        final Transaction transaction = session.beginTransaction();

        DocumentName documentName = new DocumentName();
        documentName.setDocumentName("Name1");

        session.save(documentName);
        transaction.commit();

        assertEquals(1,
                session.createQuery("from DocumentName", DocumentName.class)
                        .list()
                        .size()
        );


    }

    @Test
    public void delete() {
        cleanInsert("documentNameTest.xml");

        final Session session = sessionFactory.openSession();

        final Transaction transaction = session.beginTransaction();

        final List<DocumentName> documentName =
                session
                        .createQuery("from DocumentName ", DocumentName.class)
                        .list();

        documentName.forEach(session::delete);
        transaction.commit();


        assertEquals(
                0,
                session.createQuery("from DocumentName ").list().size()
        );
    }

}