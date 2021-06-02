package it.academy.service;

import it.academy.dao.interfaces.DocumentDao;
import it.academy.dao.interfaces.DocumentFilterDao;
import it.academy.dto.FilterDto;
import it.academy.entity.Document;
import it.academy.service.util.ConvertListForJavaScript;
import it.academy.sort.SortValueFromDocumentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilterService {

    @Autowired
    DocumentFilterDao documentFilterDao;

    @Autowired
    DocumentDao documentDao;

    @Autowired
    ConvertListForJavaScript convertListForJavaScript;

    @Autowired
    SortValueFromDocumentEntity sortValueFromDocumentEntity;

    public String getAuthorList() {
        return convertListForJavaScript.convertList(documentFilterDao.getAuthor());
    }

    public String getDocumentName() {
        return convertListForJavaScript.convertList(documentFilterDao.getDocumentName());
    }

    public String getPersonWhoConcludedContract() {
        return convertListForJavaScript.convertList(documentFilterDao.getPersonWhoConcludedContract());
    }

    public List<Document> getFilterDocument(FilterDto filterDto) {

        if ("".equals(filterDto.getMyName())
                && "".equals(filterDto.getMyAuthor())
                && "".equals(filterDto.getMyWhoCreate())){
            return documentDao.findAll();
        }

        if("".equals(filterDto.getMyName())
                && "".equals(filterDto.getMyAuthor())){
            return documentFilterDao.findByPersonWhoConcludedContract(filterDto.getMyWhoCreate());
        }

        if("".equals(filterDto.getMyName())
                && "".equals(filterDto.getMyWhoCreate())){
            return documentFilterDao.findByAuthor(filterDto.getMyAuthor());
        }

        if("".equals(filterDto.getMyWhoCreate())
                && "".equals(filterDto.getMyAuthor())){
            return documentFilterDao.findByDocumentName(filterDto.getMyName());
        }

        if("".equals(filterDto.getMyName())){
            return documentFilterDao.findByAuthorAndPersonWhoConcludedContract(
                    filterDto.getMyAuthor(),
                    filterDto.getMyWhoCreate()
            );
        }

        if("".equals(filterDto.getMyAuthor())){
            return documentFilterDao.findByPersonWhoConcludedContractAndName(
                    filterDto.getMyWhoCreate(),
                    filterDto.getMyName());
        }

        if("".equals(filterDto.getMyWhoCreate())){
            return documentFilterDao.findByAuthorAndName(
                    filterDto.getMyAuthor(),
                    filterDto.getMyName()
            );
        }

        return documentFilterDao.findByAuthorAndDocumentNameAndPersonWhoConcludedContract(
                filterDto.getMyAuthor(),
                filterDto.getMyName(),
                filterDto.getMyWhoCreate()
        );

    }

}
