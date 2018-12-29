package ru.job4j.cache;

/**
 * Created by slevi on 26.12.2018.
 */
public final class Base implements Cloneable {
    private final int id;
    private final int version;
    private final String name;

    public Base(int id, int version, String name) {
        this.id = id;
        this.version = version;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Base{" +
                "id=" + id +
                ", version=" + version +
                ", name='" + name + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public int getVersion() {
        return version;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Base base = (Base) o;

        if (getId() != base.getId()) return false;
        return getVersion() == base.getVersion();
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + getVersion();
        return result;
    }

    @Override
    public Base clone() {
        Base tmp;
        try {
            return tmp = (Base) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
