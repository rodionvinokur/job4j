package ru.job4j.track;

import java.util.Arrays;

/**
 * Item.
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
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
        String ret = System.lineSeparator();
        sb.append(String.format("Номер заявки:%4s%s%s", "", id != null ? id : "", ret));
        sb.append(String.format("Имя заявки:%6s%s%s", "", name != null ? name : "", ret));
        sb.append(String.format("Дата создания:%3s%tF %<tT%s", "", created, ret));
        sb.append(String.format("Описание заявки:%1s%s%s", "", desc, ret));
        if (comments != null) {
            for (String s : comments) {
                sb.append(String.format("Комментар. заявки: %s%s", s, ret));
            }
        }
        sb.append("-----------------------------------------------------");
        return sb.toString();
    }
}
