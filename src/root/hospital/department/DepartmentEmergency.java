package root.hospital.department;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import root.human.doctor.Emergency;

import java.math.BigDecimal;
import java.util.List;

public class DepartmentEmergency extends Department<Emergency> {

    private static final Logger LOGGER = LogManager.getLogger(DepartmentEmergency.class);

    public DepartmentEmergency(String name) {
        super(name);
    }

    @Override
    public void calculateDoctorsPrice() {
        BigDecimal result = new BigDecimal("0");
        List<Emergency> doctors = super.getDoctor();
        for (Emergency doctor : doctors) {
            result = result.add(doctor.getPrice());
            LOGGER.info(doctor.getName() + " " + doctor.getPrice());
        }
        LOGGER.info(this.getName() + " total price: " + result);
    }
}