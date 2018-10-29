package ru.job4j.part;

/**
 * Department
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class Department implements Comparable<Department> {
    private String depName;

    public Department(String depName) {
        super();
        this.depName = depName;
    }

    public String getDepName() {
        return depName;
    }

    @Override
    public int compareTo(Department o) {
        return this.depName.compareTo(o.getDepName());
    }

    public int reverseCompareTo(Department o) {
        String[] left = this.depName.split("\\\\");
        String[] right = o.getDepName().split("\\\\");
        int result = 0;
        for (int i = 0; i < Integer.min(left.length, right.length) && result == 0; i++) {
            result = right[i].compareTo(left[i]);
        }
        return result != 0
                ? result
                : Integer.compare(left.length, right.length);
    }

    @Override
    public String toString() {
        return depName;
    }

}