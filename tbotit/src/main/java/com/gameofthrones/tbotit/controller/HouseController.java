package com.gameofthrones.tbotit.controller;


import com.gameofthrones.tbotit.controller.DTO.HouseDTO;
import com.gameofthrones.tbotit.domain.entity.model.HouseModel;
import com.gameofthrones.tbotit.domain.exception.DomainException;
import com.gameofthrones.tbotit.services.HouseService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/got")
public class HouseController {

   @Autowired
    HouseService houseService;

   @PostMapping
    public ResponseEntity<HouseModel> cadastrarCasa(@RequestBody HouseModel house){
       HouseModel dadosDaCasa = houseService.salvarHouse(house);
       return new ResponseEntity<>(dadosDaCasa, HttpStatus.CREATED);
   }

    @GetMapping("{houseId}")
    public ResponseEntity<HouseModel> findHouseById(@PathVariable Long houseId) {
       Optional<HouseModel> houses = houseService.getHouseById(houseId);
        return houses.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<HouseModel>> listarCasas() {
       List<HouseModel> houses = houseService.getAllHouses();
       return ResponseEntity.ok(houses);
    }

    @PatchMapping("{houseId}")
    public ResponseEntity<HouseModel> updateHouse (@PathVariable Long houseId, @RequestBody HouseDTO houseDTO) {
       try{
           HouseModel updatedHouse = houseService.updateHouse(houseId, houseDTO);
           return ResponseEntity.ok(updatedHouse);
       }catch (DomainException e) {
           return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
       }catch (RuntimeException e) {
           return ResponseEntity.notFound().build();
    }
    }

    @DeleteMapping("{houseId}")
    public ResponseEntity<Void> deleteHouseById (@PathVariable Long houseId) {
            houseService.deleteHouseById(houseId);
            return ResponseEntity.noContent().build();
    }

    @ExceptionHandler(DomainException.class)
    public ResponseEntity<Object> capturar(DomainException e) {
        Map<String, Object> body = new HashMap<>();
        body.put("message", e.getMessage());
       return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);


    }

}


