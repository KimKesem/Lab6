package org.client.BasicPerson;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.client.ClientStuff.HowToGetId;

import java.util.Date;

public class Person implements Comparable<Person>, HowToGetId {
    private int id;
    private String name;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm a z")
    private Date creationDate;
    private Double height;
    private float weight;
    private String passportID;

    private HairColor HairColor;
    public Person(){

    }


    public Person(int id, String name, String passportID, Coordinates coordinates, Date creationDate,
                  Double height, float weight, HairColor HairColor)  {
        this.id = id;
        this.name = name;
        this.passportID=passportID;
        this.creationDate = creationDate;
        this.height = height;
        this.weight = weight;
        this.HairColor = HairColor;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public Double getHeight() {
        return height;
    }
    public void setHeight(Double height) {
        this.height = height;
    }
    public float getWeight() {
        return weight;
    }
    public void setWeight(float weight) {
        this.weight = weight;
    }
    public String getPassportID(){return passportID;}
    public void setPassportID(String passportID){this.passportID=passportID;}

    @Override
    public String toString() {
        return " Name: " + this.getName()+"; Passport: "+this.getPassportID() + "; Height: " + this.getHeight() + "; Weight: " + this.getWeight();
    }

    @Override
    public int compareTo(Person o) {
        if (this.getHeight() > o.getHeight()) {
            return 1;
        } else if (this.getHeight() == o.getHeight()) {
            return 0;
        } else {
            return -1;
        }
    }

    @Override
    public int weDoGetID() {
        return id;
    }
}