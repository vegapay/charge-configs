package tech.vegapay.charges.entity.charge;

import com.google.gson.Gson;
import lombok.Data;
import tech.vegapay.charges.entity.ChargeConfig;

import java.util.UUID;

@Data
public class ChargesDTO {

    public ChargeConfig[] chargeConfig;

    public static Charges fromDTO(ChargesDTO chargesDTO) {
        Gson gson = new Gson();
        Charges charges = new Charges();
        charges.setChargeConfig(gson.toJson(chargesDTO.getChargeConfig()));
        charges.setId(UUID.randomUUID().toString());
        return charges;
    }
}
