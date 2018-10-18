package ru.job4j.bank;

/**
 * Account
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class Account {
    private double value;
    private String requisites;

    public Account(double value, String requisites) {
        this.value = value;
        this.requisites = requisites;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public Account(String requisites) {
        this.value = 0;
        this.requisites = requisites;
    }

    public double getValue() {
        return value;
    }

    public String getRequisites() {
        return requisites;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        return this.getRequisites().equals(((Account) o).getRequisites());
    }

    @Override
    public int hashCode() {
        return getRequisites().hashCode();
    }
}
