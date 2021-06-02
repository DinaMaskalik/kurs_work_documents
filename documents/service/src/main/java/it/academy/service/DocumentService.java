package it.academy.service;

import it.academy.dao.interfaces.DocumentDao;
//import it.academy.dao.interfaces.DocumentViewDao;
//import it.academy.dto.DocumentViewDto;
//import it.academy.dao.interfaces.DocumentViewDao;
import it.academy.entity.Document;
import it.academy.sort.SortValueFromDocumentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DocumentService {

    @Value("name")
    private String sortValue;

    @Autowired
    DocumentDao documentDao;

    @Autowired
    SortValueFromDocumentEntity sortValueFromDocumentEntity;

    public List<Document> getAllDocument(String pageNumber, int countDocumentInPage, String sortValue) {

        if(sortValue!=null) {
            this.sortValue = sortValue;
        }else{
            sortValue=this.sortValue;
        }

        String value = sortValueFromDocumentEntity.getSortValue(sortValue);

        Pageable pageable = PageRequest.of(
                Integer.parseInt(pageNumber) - 1,
                countDocumentInPage,
                Sort.by(value)
        );
        return documentDao.findAllBy(pageable);

    }

    public double getNumberOfPage(int countDocumentInPage) {

        long allDocumentCount = documentDao.count();

        if (allDocumentCount % countDocumentInPage == 0) {
            return Math.floor(allDocumentCount / countDocumentInPage);
        } else {
            return Math.floor(allDocumentCount / countDocumentInPage) + 1;
        }

    }

//    public List<String> getName(){
//        return documentDao.getName();
//    }
}
