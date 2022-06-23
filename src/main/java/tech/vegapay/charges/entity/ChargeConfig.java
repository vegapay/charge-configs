package tech.vegapay.charges.entity;

import lombok.Data;

@Data
public class ChargeConfig {
    String category;
    int startRange;
    int endRange;
}
