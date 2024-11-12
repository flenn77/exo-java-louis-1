package com.exo1.exo1.controller;

import com.exo1.exo1.dto.ProjetDTO;
import com.exo1.exo1.entity.Product;
import com.exo1.exo1.mapper.ProjetMapper;
import com.exo1.exo1.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/projets")
public class ProjetController {

    private final ProductService productService;
    private final ProjetMapper projetMapper;

    @Autowired
    public ProjetController(ProductService productService, ProjetMapper projetMapper) {
        this.productService = productService;
        this.projetMapper = projetMapper;
    }

    @GetMapping
    public List<ProjetDTO> getAllProjets() {
        return productService.findAll()
                .stream()
                .map(projetMapper::productToProjetDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjetDTO> getProjetById(@PathVariable Long id) {
        return productService.findById(id)
                .map(projetMapper::productToProjetDTO)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ProjetDTO> createProjet(@RequestBody ProjetDTO projetDTO) {
        Product product = projetMapper.projetDTOToProduct(projetDTO);
        Product createdProduct = productService.save(product);
        ProjetDTO createdProjetDTO = projetMapper.productToProjetDTO(createdProduct);
        return new ResponseEntity<>(createdProjetDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProjetDTO> updateProjet(@PathVariable Long id, @RequestBody ProjetDTO projetDTO) {
        if (!productService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        Product product = projetMapper.projetDTOToProduct(projetDTO);
        product.setId(id);
        Product updatedProduct = productService.save(product);
        ProjetDTO updatedProjetDTO = projetMapper.productToProjetDTO(updatedProduct);
        return ResponseEntity.ok(updatedProjetDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProjet(@PathVariable Long id) {
        if (!productService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        productService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
