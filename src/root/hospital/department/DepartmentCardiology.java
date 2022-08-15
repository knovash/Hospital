package root.hospital.department;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import root.human.doctor.Cardiologist;

import java.math.BigDecimal;
import java.util.List;

public class DepartmentCardiology extends Department<Cardiologist> {

    private static final Logger LOGGER = LogManager.getLogger(DepartmentCardiology.class);

    public DepartmentCardiology(String name) {
        super(name);
    }

    public void calculateDoctorsPrice() {
        BigDecimal result = new BigDecimal("0");
        List<Cardiologist> doctors = super.getDoctor();
        for (Cardiologist doctor : doctors) {
            result = result.add(doctor.getPrice());
            LOGGER.info(doctor.getName() + " " + doctor.getPrice());
        }
        LOGGER.info(this.getName() + " total price: " + result);
    }
}
