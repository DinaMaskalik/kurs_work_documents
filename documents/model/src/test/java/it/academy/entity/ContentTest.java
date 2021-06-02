package it.academy.entity;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ContentTest extends BaseTest {

    @Test
    public void read() {
        cleanInsert("contentTest.xml");

        final List<Content> content = sessionFactory.openSession()
                .createQuery("from Content ", Content.class)
                .list();

        assertNotNull(content);
        assertEquals(4, content.size());

        deleteDataset();

    }

    @Test
    public void add() {
        final Session session = sessionFactory.openSession();

        final Transaction transaction = session.beginTransaction();

        Content content = new Content();
        content.setContent("Content1");

        session.save(content);
        transaction.commit();

        assertEquals(1,
                session.createQuery("from Content ", Content.class)
                        .list()
                        .size()
        );


    }

    @Test
    public void delete() {
        cleanInsert("contentTest.xml");

        final Session session = sessionFactory.openSession();

        final Transaction transaction = session.beginTransaction();

        final List<Content> content =
                session
                        .createQuery("from Content ", Content.class)
                        .list();

        content.forEach(session::delete);
        transaction.commit();


        assertEquals(
                0,
                session.createQuery("from Content").list().size()
        );
    }

}