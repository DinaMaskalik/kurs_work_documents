package it.academy.controller;

import com.sun.xml.bind.v2.TODO;
import it.academy.service.DocumentDeleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DeleteDocumentController {

    @Autowired
    DocumentDeleteService documentDeleteService;

    @PostMapping("/document/delete/{id}")
    public String deleteDocument(
            @PathVariable(name = "id") String id
    ){

        documentDeleteService.deleteDocument(id);

        return "redirect:/document";
    }
}
