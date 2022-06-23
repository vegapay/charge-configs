package tech.vegapay.charges.entity;

import lombok.Data;
import tech.vegapay.charges.entity.charge.ChargesType;

@Data
public class PerDayCharge {
    ChargesType chargesType;
    int value;
    boolean inclusiveOfGST;
}