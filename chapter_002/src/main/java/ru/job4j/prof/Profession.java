package ru.job4j.prof;

/**
 * Class Profession.
 */
public class Profession {
    protected String name;
    protected String profession;

    public Profession(String name, String profession) {
        this.name = name;
        this.profession = profession;
    }

    /**
     * Getter name
     *
     * @return
     */
    public String getName() {
        return name;
    }

}
