package com.exo1.exo1.controller;

import com.exo1.exo1.dto.TacheDTO;
import com.exo1.exo1.entity.OrderItem;
import com.exo1.exo1.mapper.TacheMapper;
import com.exo1.exo1.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/taches")
public class TacheController {

    private final OrderItemService orderItemService;
    private final TacheMapper tacheMapper;

    @Autowired
    public TacheController(OrderItemService orderItemService, TacheMapper tacheMapper) {
        this.orderItemService = orderItemService;
        this.tacheMapper = tacheMapper;
    }

    @GetMapping
    public List<TacheDTO> getAllTaches() {
        return orderItemService.findAll()
                .stream()
                .map(tacheMapper::orderItemToTacheDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TacheDTO> getTacheById(@PathVariable Long id) {
        return orderItemService.findById(id)
                .map(tacheMapper::orderItemToTacheDTO)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<TacheDTO> createTache(@RequestBody TacheDTO tacheDTO) {
        OrderItem orderItem = tacheMapper.tacheDTOToOrderItem(tacheDTO);
        OrderItem createdOrderItem = orderItemService.save(orderItem);
        TacheDTO createdTacheDTO = tacheMapper.orderItemToTacheDTO(createdOrderItem);
        return new ResponseEntity<>(createdTacheDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TacheDTO> updateTache(@PathVariable Long id, @RequestBody TacheDTO tacheDTO) {
        if (!orderItemService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        OrderItem orderItem = tacheMapper.tacheDTOToOrderItem(tacheDTO);
        orderItem.setId(id);
        OrderItem updatedOrderItem = orderItemService.save(orderItem);
        TacheDTO updatedTacheDTO = tacheMapper.orderItemToTacheDTO(updatedOrderItem);
        return ResponseEntity.ok(updatedTacheDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTache(@PathVariable Long id) {
        if (!orderItemService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        orderItemService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
