package ru.job4j.store;

import java.util.*;

/**
 * Info
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class Info<User> {
    private List<User> currentUsers;
    private List<User> previousUsers;
    private int added;
    private int deleted;
    private int changed;

    public int getAdded() {
        return added;
    }

    public void setAdded(int added) {
        this.added = added;
    }

    public int getDeleted() {
        return deleted;
    }

    public void setDeleted(int deleted) {
        this.deleted = deleted;
    }

    public int getChanged() {
        return changed;
    }

    public void setChanged(int changed) {
        this.changed = changed;
    }

    public Info(List<User> currentUsers, List<User> previousUsers) {
        this.currentUsers = currentUsers;
        this.previousUsers = previousUsers;

        this.calcCounts();
    }

    private void calcCounts() {
        Set<User> sets = new HashSet<>();
        added = getSubstuction(sets, previousUsers, currentUsers);
        sets.clear();
        deleted = getSubstuction(sets, currentUsers, previousUsers);
        sets = new TreeSet<>();
        changed = getSubstuction(sets, currentUsers, previousUsers) - deleted;
    }

    private int getSubstuction(Set<User> sets, List<User> u1, List<User> u2) {
        sets.addAll(u1);
        int sizeOld = sets.size();
        sets.addAll(u2);
        int sizeNew = sets.size();
        return sizeNew - sizeOld;
    }

}
