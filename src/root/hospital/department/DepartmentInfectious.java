package root.hospital.department;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import root.human.doctor.Infectiologist;

import java.math.BigDecimal;
import java.util.List;

public class DepartmentInfectious extends Department<Infectiologist> {

    private static final Logger LOGGER = LogManager.getLogger(DepartmentInfectious.class);

    public DepartmentInfectious(String name) {
        super(name);
    }

    @Override
    public void calculateDoctorsPrice() {
        BigDecimal result = new BigDecimal("0");
        List<Infectiologist> doctors = super.getDoctor();
        for (Infectiologist doctor : doctors) {
            result = result.add(doctor.getPrice());
            LOGGER.info(doctor.getName() + " " + doctor.getPrice());
        }
        LOGGER.info(this.getName() + " total price: " + result);
    }
}