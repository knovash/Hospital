package root.human.patient.prescription.medicine;

public class Test {

    public static void main(String[] args) {

//    Injection injection = new Injection(22);
//    Pill pill = new Pill("ddd");
//    injection.sleep();
//    pill.say();
//    injection.showInfo();
//    pill.showInfo();

//    Info info1 = new Injection(2);
//    Info info2 = new Pill("sss");
//    info1.showInfo();
//    info2.showInfo();
//    output(info1);
//    output(info2);

        Injection injection = new Injection(44);
        Pill pill = new Pill("ffff");
        output(injection);
        output(pill);

        System.out.println("tostring " + pill.toString());
        System.out.println("hash " + pill.hashCode());
        System.out.println("tostring " + injection.toString());
        System.out.println("hash " + injection.hashCode());
    }

    public static void output(Info info) {
        info.showInfo();
    }
}
