package root.medicine.procedure;

import java.math.BigDecimal;

public class ProcedureExternal extends Procedure{

    public ProcedureExternal(String name, String description, BigDecimal price, int quantity) {
        super(name, description, price);
    }
}
