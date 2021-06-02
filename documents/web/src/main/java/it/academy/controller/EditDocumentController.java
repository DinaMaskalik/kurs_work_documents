package it.academy.controller;

import it.academy.dto.DocumentEditDto;
import it.academy.entity.Document;
import it.academy.service.DocumentEditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EditDocumentController {

    @Autowired
    DocumentEditService editService;

    @GetMapping("/document/edit/{id}")
    public String editDocument(
            @PathVariable(name = "id") String id,
            Model model
    ) {
        final Document document = editService.findDocument(id);

        model.addAttribute("document", document);

        return "edit-document";
    }

    @PostMapping("/document/edit/{id}")
    public String addDocument(
            @PathVariable(name = "id") String id,
            @ModelAttribute DocumentEditDto documentEditDto
    ) {
        final Document document = editService.findDocument(id);

        System.out.println(documentEditDto);
        editService.editDocument(document, documentEditDto);

        return "redirect:/document";
    }
}
