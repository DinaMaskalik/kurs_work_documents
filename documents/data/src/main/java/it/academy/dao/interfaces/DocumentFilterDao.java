package it.academy.dao.interfaces;

import it.academy.entity.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.awt.print.Pageable;
import java.util.List;

public interface DocumentFilterDao extends JpaRepository<Document, String> {

    @Query("select distinct a.author from Author a ")
    List<String> getAuthor();

    @Query("select distinct doc.documentName from DocumentName doc")
    List<String> getDocumentName();

    @Query("select distinct d.personWhoConcludedContract " +
            "from PersonWhoConcludedContract d")
    List<String> getPersonWhoConcludedContract();

    @Query("select distinct d.personWithWhomTheContractWasSigned " +
            "from PersonWithWhomTheContractWasSigned d")
    List<String> getPersonWithWhomTheContractWasSigned();

//    @Query("select d from Document d where d.author = ?1")
//    List<Document> getFilterDocument(String result, Pageable pageable);

    @Query("select d from Document d " +
            "join d.author a " +
            "where a.author = ?1")
    List<Document> findByAuthor(String author);

    @Query("select d from Document d " +
            "join d.documentName doc " +
            "where doc.documentName = ?1")
    List<Document> findByDocumentName(String name);

    @Query("select d from Document d " +
            "join d.personWhoConcludedContract pw " +
            "where pw.personWhoConcludedContract = ?1")
    List<Document> findByPersonWhoConcludedContract(String person);

    @Query("select d from Document d " +
            "join d.author a " +
            "join d.personWhoConcludedContract pw "+
            "where a.author = ?1 " +
            "and pw.personWhoConcludedContract = ?2")
    List<Document> findByAuthorAndPersonWhoConcludedContract(String author, String person);

    @Query("select d from Document d " +
            "join d.documentName doc " +
            "join d.author a " +
            "where a.author = ?1 " +
            "and doc.documentName = ?2")
    List<Document> findByAuthorAndName(String author, String name);

    @Query("select d from Document d " +
            "join d.documentName doc " +
            "join d.personWhoConcludedContract pw "+
            "where pw.personWhoConcludedContract = ?1 " +
            "and doc.documentName = ?2")
    List<Document> findByPersonWhoConcludedContractAndName(String person, String name);

    @Query("select d from Document d " +
            "join d.documentName doc " +
            "join d.author a " +
            "join d.personWhoConcludedContract pw "+
            "where a.author = ?1 " +
            "and doc.documentName = ?2 " +
            "and pw.personWhoConcludedContract = ?3")
    List<Document> findByAuthorAndDocumentNameAndPersonWhoConcludedContract(String author, String name, String person);


}
