package it.academy.service;

import it.academy.dao.interfaces.DocumentDao;
import it.academy.entity.Document;
import it.academy.sort.SortValueFromDocumentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchService {

    @Value("name")
    private String sortValue;

    @Autowired
    DocumentDao documentDao;

    @Autowired
    SortValueFromDocumentEntity sortValueFromDocumentEntity;

    public List<Document> searchDocument(String pageNumber, int countDocumentInPage, String sortValue, String searchParam) {

        if (sortValue != null) {
            this.sortValue = sortValue;
        } else {
            sortValue = this.sortValue;
        }

        String value = sortValueFromDocumentEntity.getSortValue(sortValue);

        Pageable pageable = PageRequest.of(
                Integer.parseInt(pageNumber) - 1,
                countDocumentInPage,
                Sort.by(value)
        );
        return documentDao.searchDocument(searchParam, pageable);
    }

    public double getNumberOfPage(int countDocumentInPage, String searchParam) {

        long allDocumentCount = documentDao.countSearchResults(searchParam);

        if (allDocumentCount % countDocumentInPage == 0) {
            return Math.floor(allDocumentCount / countDocumentInPage);
        } else {
            return Math.floor(allDocumentCount / countDocumentInPage) + 1;
        }

    }
}
