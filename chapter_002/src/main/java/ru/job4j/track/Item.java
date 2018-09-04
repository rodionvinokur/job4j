package ru.job4j.track;

import java.util.Arrays;

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

    public void setCreated(long created) {
        this.created = created;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Номер заявки:\t\t%s\n", id != null ? id : ""));
        sb.append(String.format("Имя заявки:\t\t\t%s\n", name != null ? name : ""));
        sb.append(String.format("Дата создания:\t\t%tF %<tT\n", created));
        sb.append(String.format("Описание заявки:\t%s\n", desc));
        if (comments != null) {
            for (String s : comments) {
                sb.append(String.format("Комментар. заявки:\t%s\n", s));
            }
        }
        sb.append("-----------------------------------------------------");
        return sb.toString();
    }
}
