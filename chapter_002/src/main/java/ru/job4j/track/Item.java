package ru.job4j.track;

/**
 * Created by slevi on 01.09.2018.
 */
public class Item {
    private String id;
    private String name;
    private String desc;
    private long created;
    private String[] comments;

    public Item(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public long getCreated() {
        return created;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String[] getComments() {
        return comments;
    }
}
