package root.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import root.human.Human;
import root.human.doctor.Surgeon;
import root.human.property.Address;
import root.human.property.Credit;

import java.math.BigDecimal;

public class Test {

    private static Logger LOGGER = LogManager.getLogger(Test.class);

    public static void main(String[] args) {

        LOGGER.info("some tests:");

        Address adr1 = new Address("Belarus", "Minsk", "Pushkina", 11);
        Address adr2 = new Address("Belarus", "Minsk", "Pushkina", 11);
        LOGGER.info("adr1 tostr: " + adr1.toString());
        LOGGER.info("adr2 tostr: " + adr2.toString());

        LOGGER.info("adr1 eq adr2 " + adr1.equals(adr2));
        LOGGER.info("adr1 hash: " + adr1.hashCode());
        LOGGER.info("adr2 hash: " + adr2.hashCode());





        Surgeon sur = new Surgeon("Ivan");
        sur.makeDiagnosis();
        sur.makePrescription();
        sur.doOperation();



        Credit cred1 = new Credit("Prior", "USD", new BigDecimal(999));
        Credit cred2 = new Credit("Prior", "USD", new BigDecimal(999));
        LOGGER.info("cred1 tostr: " + cred1.toString());
        LOGGER.info("cred2 tostr: " + cred2.toString());
        LOGGER.info("cred1 eq cred2 " + cred1.equals(cred2));
//        Cardiologist card = new Cardiologist("Petr");
//        card.makeDiagnosis();
//        LOGGER.info(card.makeDiagnosis());
//
//        Doctor doc1 = hospital.getDepartments()[0].getDoctor()[0];
//        doc1.makeDiagnosis();
//        LOGGER.info(doc1.makeDiagnosis());
//
//        String s = ((Function) card).makeDiagnosis();
//        LOGGER.info("s= " + s);
//        String d = ((Function) doc1).makeDiagnosis();
//        LOGGER.info("d= " + d);

        // test try catch
//        LOGGER.info("test 1 try");
//
////        patients[0].setToDoctor("NewName");
//        patients[0].setName("NewN_ame"); //uncheck
////        patients[0].setDateOfBirth(LocalDate.now().minusYears(200)); //check
//        LOGGER.info("test 2 try");
//        try {
//            patients[0].setName("NewName");
//            patients[0].setToDoctor("NewToDoc");
////            System.out.println(3/0);
//            patients[0].setDateOfBirth(LocalDate.now().minusYears(200));
//        } catch (NameException e) {
//            LOGGER.error("catch NameException e.getMessage, e = " + e.getMessage(), e);
//        } catch (DateException e) {
//            LOGGER.error("catch DateException e.getMessage, e = " + e.getMessage(), e);
//        } catch (Exception e) {
//            LOGGER.error("catch Exception e.getMessage, e = " + e.getMessage(), e);
//        } finally {
//            LOGGER.info("Event error in Patient: ");
//        }
//
//
//        System.out.println("sys.out name: " + patients[0].getName());

//        LOGGER.info("test 2 try");
//        try {
//            patients[0].setDateOfBirth(LocalDate.now().minusYears(200));
//        } catch (DateException e) {
//            LOGGER.error("e.getMessage, e = " + e.getMessage(), e);
//        }
//
//        LOGGER.info("test 3 try");
//        try {
//            patients[0].setDateOfBirth(LocalDate.now().plusYears(2));
//        } catch (DateException e) {
//            LOGGER.error("e.getMessage, e = " + e.getMessage(), e);
//        }
//
//        LOGGER.info("test 4 try");
//        try {
//            patients[0].setDateOfBirth(LocalDate.now().minusYears(20));
//        } catch (DateException e) {
//            LOGGER.error("e.getMessage, e = " + e.getMessage(), e);
//        }

    }
}
