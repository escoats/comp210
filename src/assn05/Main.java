package assn05;

public class Main {

    public static void main(String[] args) {
        testP1();
        testP2();
        testP3();
        testP4();
    }

    // test Part 1
    public static void testP1(){
        /*
        Part 1 - Write some tests to convince yourself that your code for Part 1 is working
         */
        SimpleEmergencyRoom emergency = new SimpleEmergencyRoom();

        emergency.addPatient("lizzie", 10);
        emergency.addPatient("chandon", 4);
        emergency.addPatient("amanda", 15);
        emergency.addPatient("kuhu", 6);
        emergency.addPatient("olivia", 8);
        emergency.addPatient("jada", 2);
        emergency.dequeue();
        emergency.dequeue();
    }

    // test Part 2
    public static void testP2(){
               /*
        Part 2 - Write some tests to convince yourself that your code for Part 2 is working
         */
        MaxBinHeapER hospital = new MaxBinHeapER();
        hospital.enqueue("lizzie", 1);
        hospital.enqueue("chandon", 4);
        hospital.enqueue("kuhu", 10);
        hospital.enqueue("olivia", 12);
        hospital.enqueue("amanda", 3);
        hospital.enqueue("jada", 1);
        hospital.enqueue("leah", 2);
        hospital.enqueue("maanya", 0);
        hospital.enqueue("catherine", 6);
        hospital.dequeue();
        System.out.println(hospital.toString());
        hospital.updatePriority("maanya", 100);
        hospital.updatePriority("jada", 15);
        hospital.updatePriority("catherine", 0);
    }

    /*
    Part 3
     */
    public static void testP3(){
        MaxBinHeapER transfer = new MaxBinHeapER(makePatients());
        Prioritized[] arr = transfer.getAsArray();
        for(int i = 0; i < transfer.size(); i++) {
            System.out.println("Value: " + arr[i].getValue()
                    + ", Priority: " + arr[i].getPriority());
        }
    }

    /*
    Part 4
     */
    public static void testP4() {
               /*
        Part 4 - Write some tests to convince yourself that your code for Part 4 is working
         */
        double[] results = compareRuntimes();
        System.out.println("Time to DQ (inefficient): " + results[0]);
        System.out.println("Time to DQ (efficient): " + results[2]);
        System.out.println("Avg DQ time (inefficient): " + results[1]);
        System.out.println("Avg DQ time (efficient): " + results[3]);
    }

    public static void fillER(MaxBinHeapER complexER) {
        for(int i = 0; i < 100000; i++) {
            complexER.enqueue(i);
        }
    }
    public static void fillER(SimpleEmergencyRoom simpleER) {
        for(int i = 0; i < 100000; i++) {
            simpleER.addPatient(i);
        }
    }

    public static Patient[] makePatients() {
        Patient[] patients = new Patient[10];
        for(int i = 0; i < 10; i++) {
            patients[i] = new Patient(i);
        }
        return patients;
    }

    public static double[] compareRuntimes() {
        // Array which you will populate as part of Part 4
        double[] results = new double[4];

        SimpleEmergencyRoom simplePQ = new SimpleEmergencyRoom();
        fillER(simplePQ);

        // Code for (Task 4.1) Here
        long beforeDQ = System.nanoTime();
        for (int i = 0; i < simplePQ.size(); i++){
            simplePQ.dequeue();
        }
        long afterDQ = System.nanoTime();
        double timeToDQ = afterDQ - beforeDQ;
        double avgDQTime = timeToDQ/100000;
        results[0] = timeToDQ;
        results[1] = avgDQTime;

        MaxBinHeapER binHeap = new MaxBinHeapER();
        fillER(binHeap);

        // Code for (Task 4.2) Here
        beforeDQ = System.nanoTime();
        binHeap.dequeue();
        for (int i = 0; i < binHeap.size(); i++){
            binHeap.dequeue();
        }
        afterDQ = System.nanoTime();
        timeToDQ = afterDQ - beforeDQ;
        avgDQTime = timeToDQ/100000;
        results[2] = timeToDQ;
        results[3] = avgDQTime;
        return results;
    }

}
