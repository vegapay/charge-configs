package tech.vegapay.charges.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.vegapay.charges.entity.Charges;
import tech.vegapay.charges.entity.ChargesDTO;
import tech.vegapay.charges.service.ChargesService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@CrossOrigin()
@RestController()
@RequestMapping("/charges")
public class ChargesController {

    @Autowired
    ChargesService chargesService;

    @PostMapping("/create")
    public ResponseEntity<Charges> create(@RequestBody ChargesDTO charges) {
        try {
            return new ResponseEntity<>(chargesService.createCharge(charges), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    @GetMapping("/list")
//    public ResponseEntity<List<Charges>> list() {
//        try {
//            List<Charges> list = chargesService.listAllCharges();
//            if (list.isEmpty() || list.size() == 0) {
//                return new ResponseEntity<List<Charges>>(HttpStatus.NO_CONTENT);
//            }
//
//            return new ResponseEntity<List<Charges>>(list, HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Charges> get(@PathVariable UUID id) {
        Optional<Charges> Transaction = chargesService.getCharge(id);

        if (Transaction.isPresent()) {
            return new ResponseEntity<Charges>(Transaction.get(), HttpStatus.OK);
        }

        return new ResponseEntity<Charges>(HttpStatus.NOT_FOUND);
    }

//    @PutMapping("/update/{id}")
//    public ResponseEntity<Charges> update(@RequestBody Charges charges) {
//
//        try {
//            return new ResponseEntity<Charges>(chargesService.updateCharge(charges), HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
}
