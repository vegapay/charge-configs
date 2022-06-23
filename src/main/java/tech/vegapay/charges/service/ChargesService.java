package tech.vegapay.charges.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.vegapay.charges.entity.charge.Charges;
import tech.vegapay.charges.entity.charge.ChargesDTO;
import tech.vegapay.charges.repository.ChargesRepo;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ChargesService {

    @Autowired
    ChargesRepo chargesRepo;

    public Charges createCharge(ChargesDTO chargesDTO) {
        Charges charges = ChargesDTO.fromDTO(chargesDTO);
        return chargesRepo.save(charges);
    }

    public List<Charges> listAllCharges() {
        return chargesRepo.findAll();
    }

    public Optional<Charges> getCharge(UUID id) {
        return chargesRepo.findById(id);
    }

    public Charges updateCharge(Charges Charges) {
        return chargesRepo.save(Charges);
    }
}
