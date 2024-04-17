package assn05;

import java.util.ArrayList;
import java.util.List;

public class SimpleEmergencyRoom {
    private List<Patient> patients;

    public SimpleEmergencyRoom() {patients = new ArrayList<>();}

    // TODO (Task 1): dequeue
    public Patient dequeue() {
        Patient max = patients.get(0);
        int maxIndex = 0;
        for (int i = 1; i < patients.size(); i++){
            if (0 > max.compareTo(patients.get(i))){
                max = patients.get(i);
                maxIndex = i;
            }
        }
        patients.remove(maxIndex);
        return max;
    }

    public <V, P> void addPatient(V value, P priority) {
        Patient patient = new Patient(value, (Integer) priority);
        patients.add(patient);
    }

    public <V> void addPatient(V value) {
        Patient patient = new Patient(value);
        patients.add(patient);
    }

    public List getPatients() {
        return patients;
    }

    public int size() {
        return patients.size();
    }

}
