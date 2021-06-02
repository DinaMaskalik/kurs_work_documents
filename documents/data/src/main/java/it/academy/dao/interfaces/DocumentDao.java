package it.academy.dao.interfaces;

//import it.academy.dto.DocumentViewDto;

import it.academy.entity.Document;
import it.academy.entity.DocumentName;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DocumentDao extends JpaRepository<Document, String> {

    List<Document> findAllBy(Pageable pageable);

    Document findByDocumentId(String id);

    @Query("select d from Document d " +
            "join d.content c " +
            "join d.documentName doc " +
            "join d.author a " +
            "join d.personWhoConcludedContract pw " +
            "join d.personWithWhomTheContractWasSigned pwh " +
            "where doc.documentName like %?1% or " +
            "c.content like %?1% or " +
            "a.author like %?1% or " +
            "pw.personWhoConcludedContract like %?1% or " +
            "pwh.personWithWhomTheContractWasSigned like %?1%")
    List<Document> searchDocument(String searchParam, Pageable pageable);

    @Query("select count(d) from Document d " +
            "join d.content c " +
            "join d.documentName doc " +
            "join d.author a " +
            "join d.personWhoConcludedContract pw " +
            "join d.personWithWhomTheContractWasSigned pwh " +
            "where doc.documentName like %?1% or " +
            "c.content like %?1% or " +
            "a.author like %?1% or " +
            "pw.personWhoConcludedContract like %?1% or " +
            "pwh.personWithWhomTheContractWasSigned like %?1%")
    int countSearchResults(String searchParam);

    @Query("select d.author from Document d ")
    List<String> getName();
}
