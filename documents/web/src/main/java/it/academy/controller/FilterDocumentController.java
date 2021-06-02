package it.academy.controller;

import it.academy.dto.FilterDto;
import it.academy.entity.Document;
import it.academy.service.FilterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class FilterDocumentController {

    @Autowired
    FilterService filterService;

    @GetMapping("/document/filter")
    public String getFilter(
            Model model
    ) {
        model.addAttribute("name", filterService.getDocumentName());

        model.addAttribute("author", filterService.getAuthorList());

        model.addAttribute("whoCreate", filterService.getPersonWhoConcludedContract());

//        model.addAttribute("withWhom", filterService.getPersonWithWhomTheContractWasSigned());

        return "filter";
    }

    @PostMapping("/document/filter")
    public String getFilterResult(
            @ModelAttribute FilterDto filterDto,
            Model model
    ) {
        final List<Document> filterDocument = filterService.getFilterDocument(filterDto);

        model.addAttribute("documentsList", filterDocument);

        return "filter-result";
    }
}
