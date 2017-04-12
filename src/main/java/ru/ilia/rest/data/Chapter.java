package ru.ilia.rest.data;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by ILIA on 11.04.2017.
 */
@XmlRootElement(name = "Chapter")
public class Chapter {

    private long id;
    private int number;
    private int pagesCount;

    public Chapter() {
    }

    public Chapter(long id, int number, int pagesCount) {
        this.id = id;
        this.number = number;
        this.pagesCount = pagesCount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getPagesCount() {
        return pagesCount;
    }

    public void setPagesCount(int pagesCount) {
        this.pagesCount = pagesCount;
    }
}
