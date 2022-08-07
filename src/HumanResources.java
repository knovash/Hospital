public class HumanResources {

    // Methods
    public Doctor[] hireDoctor(Hospital hospital, Doctor[] array, int number, String name, String specialty, int price) {
        hospital.credit = hospital.credit - price;
        array[number] = new Doctor(name, specialty, price);
        System.out.println("Hired new doctor: " + name + " " + specialty + " salory $" + price + " credit $" + hospital.credit);
        return array;
    }

    public Doctor[] dismissDoctor(Doctor[] array, int number) {
        System.out.println("Dismissed doctor: " + array[number].getName() + " " + array[number].getSpecialty());
        array[number] = new Doctor("", "", 0);
        return array;
    }


    // Getters and Setters


}