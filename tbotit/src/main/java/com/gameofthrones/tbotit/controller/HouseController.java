package com.gameofthrones.tbotit.controller;


import com.gameofthrones.tbotit.controller.DTO.HouseDTO;
import com.gameofthrones.tbotit.domain.entity.model.HouseModel;
import com.gameofthrones.tbotit.domain.exception.DomainException;
import com.gameofthrones.tbotit.services.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
    public ResponseEntity<HouseModel> updateHouse (@PathVariable Long houseId, @RequestBody HouseModel houseModel) {
       try{
           HouseModel updateHouse = houseService.updateHouse(houseId, houseModel);
           return ResponseEntity.ok(updateHouse);
       }catch (RuntimeException e) {
           return ResponseEntity.notFound().build();
       }
    }

    @DeleteMapping("{houseId}")
    public ResponseEntity<Void> deleteHouseById (@PathVariable Long houseId) {
       houseService.deleteHouseBtyId(houseId);
       return ResponseEntity.noContent().build();
    }

    @ExceptionHandler(DomainException.class)
    public ResponseEntity<String> capturar(DomainException e) {
       return ResponseEntity.badRequest().body(e.getMessage());


    }

}


