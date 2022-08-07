package root.human.patient.prescription.procedure;

import java.math.BigDecimal;

public class ProcedureInternal extends Procedure{
    public ProcedureInternal(String name, String description, BigDecimal price, int quantity) {
        super(name, description, price, quantity);
    }
}
