package ru.job4j.prof;

/**
 * Class Doctor.
 */
public class Doctor extends Profession {
    public Doctor(String name, String profession) {
        super(name, profession);
    }

    /**
     * Method treat.
     * @param patient
     * @return
     */
    public boolean treat(Patient patient) {
        return true;
    }

    /**
     * Method test.
     * @param patient
     * @return Diagnose
     */
    public Diagnose test(Patient patient) {
        Diagnose diag = null;
        return diag;
    }
}
