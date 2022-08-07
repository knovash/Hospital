package root.utils;

import root.human.doctor.Surgeon;
import root.human.property.Address;
import root.human.property.Credit;

import java.math.BigDecimal;

public class Test {

    public static void main(String[] args) {
        System.out.println("some tests:");

        Address adr1 = new Address("Belarus", "Minsk", "Pushkina", 11);
        Address adr2 = new Address("Belarus", "Minsk", "Pushkina", 11);
        System.out.println("adr1 tostr: " + adr1.toString());
        System.out.println("adr2 tostr: " + adr2.toString());
        System.out.println(adr1 == adr2);
        System.out.println("adr1 eq adr2 " + adr1.equals(adr2));
        System.out.println("adr1 hash: " + adr1.hashCode());
        System.out.println("adr2 hash: " + adr2.hashCode());





        Surgeon sur = new Surgeon("Ivan");
        sur.makeDiagnosis();
        sur.makePrescription();
        sur.doOperation();



        Credit cred1 = new Credit("Prior", "USD", new BigDecimal(999));
        Credit cred2 = new Credit("Prior", "USD", new BigDecimal(999));
        System.out.println("cred1 tostr: " + cred1.toString());
        System.out.println("cred2 tostr: " + cred2.toString());
        System.out.println("cred1 eq cred2 " + cred1.equals(cred2));
//        Cardiologist card = new Cardiologist("Petr");
//        card.makeDiagnosis();
//        System.out.println(card.makeDiagnosis());
//
//        Doctor doc1 = hospital.getDepartments()[0].getDoctor()[0];
//        doc1.makeDiagnosis();
//        System.out.println(doc1.makeDiagnosis());
//
//        String s = ((Function) card).makeDiagnosis();
//        System.out.println("s= " + s);
//        String d = ((Function) doc1).makeDiagnosis();
//        System.out.println("d= " + d);
    }
}
