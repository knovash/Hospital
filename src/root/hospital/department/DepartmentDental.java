package root.hospital.department;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import root.human.doctor.Dentist;

import java.math.BigDecimal;
import java.util.List;

public class DepartmentDental extends Department<Dentist> {

    private static final Logger LOGGER = LogManager.getLogger(DepartmentDental.class);

    public DepartmentDental(String name) {
        super(name);
    }

    @Override
    public void calculateDoctorsPrice() {
        BigDecimal result = new BigDecimal("0");
        List<Dentist> doctors = super.getDoctor();
        for (Dentist doctor : doctors) {
            result = result.add(doctor.getPrice());
            LOGGER.info(doctor.getName() + " " + doctor.getPrice());
        }
        LOGGER.info(this.getName() + " total price: " + result);
    }
}