package root.hospital.department;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import root.human.doctor.Surgeon;

import java.math.BigDecimal;
import java.util.List;

public class DepartmentSurgery extends Department<Surgeon> {

    private static final Logger LOGGER = LogManager.getLogger(DepartmentSurgery.class);

    public DepartmentSurgery(String name) {
        super(name);
    }

    @Override
    public void calculateDoctorsPrice() {
        BigDecimal result = new BigDecimal("0");
        List<Surgeon> doctors = super.getDoctor();
        for (Surgeon doctor : doctors) {
            result = result.add(doctor.getPrice());
            LOGGER.info(doctor.getName() + " " + doctor.getPrice());
        }
        LOGGER.info(this.getName() + " total price: " + result);
    }
}