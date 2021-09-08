package by.belarusian.farmer.controller;

import by.belarusian.farmer.model.Harvest;
import by.belarusian.farmer.model.TaxDocument;
import by.belarusian.farmer.service.TaxDocumentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/tax")
public class TaxDocumentController {

    private final TaxDocumentService service;

    public TaxDocumentController(TaxDocumentService service) {
        this.service = service;
    }

    @GetMapping("/createDocuments")
    public ResponseEntity<?> createDocument() {
        try {
            final List<TaxDocument> taxDocuments = service.createTaxDocument();
            System.out.printf("GET /createDocuments return %d objects", taxDocuments.size());
            return ResponseEntity.ok(taxDocuments);
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred while creating document", HttpStatus.NOT_ACCEPTABLE);
        }
    }
}
