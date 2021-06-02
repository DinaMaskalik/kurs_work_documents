package it.academy.controller;

import it.academy.entity.Document;
import it.academy.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class SearchDocumentController {

    private String searchValue;

    @Autowired
    SearchService searchService;

    @PostMapping("/document/search")
    public String searchDocument(
            @RequestParam(name = "searchParam", defaultValue = "") String searchParam,
            @RequestParam(name = "pageNumber", defaultValue = "1") String pageNumber,
            @RequestParam(name = "sort", required = false) String sortValue,
            Model model
    ) {
        if (!"".equals(searchParam.trim())) {
            searchValue = searchParam;
        } else {
            searchParam = searchValue;
        }

        if (
                searchParam != null
        ) {
            final int countDocumentInPage = 5;

            final List<Document> documents = searchService.searchDocument(pageNumber, countDocumentInPage, sortValue, searchParam);

            model.addAttribute("documentsList", documents);

            model.addAttribute("pageCount", searchService.getNumberOfPage(countDocumentInPage, searchParam));

            return "search-document";
        }


        return "redirect:/document";


    }
}
