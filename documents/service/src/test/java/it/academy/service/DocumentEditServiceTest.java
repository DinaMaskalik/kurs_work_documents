//package it.academy.service;
//
//import it.academy.dao.interfaces.DocumentDao;
//import it.academy.dto.DocumentEditDto;
//import it.academy.dto.transform.TransformDocumentEditDtoInDocumentEntity;
//import it.academy.entity.Document;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import java.util.List;
//
//import static org.junit.Assert.*;
//
//@ContextConfiguration(classes = {JpaTestConfig.class, AppConfig.class})
//@RunWith(SpringJUnit4ClassRunner.class)
//public class DocumentEditServiceTest {
//
//    @Autowired
//    DocumentEditService editService;
//
//    @Test
//    public void deleteDocument() {
//
//        DocumentDao documentDao= Mockito.mock(DocumentDao.class);
//        TransformDocumentEditDtoInDocumentEntity dto =
//                Mockito.mock(TransformDocumentEditDtoInDocumentEntity.class);
//
//        Document document1 = new Document();
//        document1.setDocumentId("1");
//        document1.setAuthor("Author");
//
//        Document document2 = new Document();
//        document2.setDocumentId("2");
//        document2.setAuthor("Author2");
//
//        DocumentEditDto document3 = new DocumentEditDto();
//        document3.setPersonWhoConcludedContract("Name3");
//        document3.setPersonWithWhomTheContractWasSigned("Content3");
//
////        TransformDocumentEditDtoInDocumentEntity dto =
////                Mockito.mock(TransformDocumentEditDtoInDocumentEntity.class);
//
//        Mockito
//                .when(documentDao.findAll())
//                .thenReturn(List.of(document1, document2));
//        Mockito
//                .when(editService.transformDocumentEditDtoInDocumentEntity)
//                .thenReturn(dto);
//
//        editService.setDocumentDao(documentDao);
//
//        final Document document = editService.editDocument(document2, document3);
//
//        //Then
//
//        assertNotNull(document);
//        assertEquals("Name3", document.getPersonWhoConcludedContract());
//
//
//    }
//
//}