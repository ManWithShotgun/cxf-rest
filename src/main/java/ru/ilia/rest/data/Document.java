package ru.ilia.rest.data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

/**
 * Created by ILIA on 11.04.2017.
 */
@XmlRootElement(name = "Document")
public class Document {

    private long id;
    private String name;
    private ArrayList<Chapter> chapters=new ArrayList<Chapter>();

    public Document() {
    }

    public Document(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Chapter> getChapters() {
        return chapters;
    }

    public void setChapters(ArrayList<Chapter> chapters) {
        this.chapters = chapters;
    }

    public int minimumLengthChapter(){
        int min=Integer.MAX_VALUE;
        for (Chapter chapter : chapters){
            if(chapter.getPagesCount()<min){
                min=chapter.getPagesCount();
            }
        }
        return min;
    }

    public void printDocument() {
        System.out.println("Document:");
        System.out.println("\tid:"+this.id);
        System.out.println("\tName:"+this.name);

        System.out.println("\tChapters");
        for(Chapter chapter : chapters){
            System.out.println("\t\tChapter:");
            System.out.println("\t\t\tid: "+chapter.getId());
            System.out.println("\t\t\tNumber: "+chapter.getNumber());
            System.out.println("\t\t\tPages: "+chapter.getPagesCount());
        }
    }
}
