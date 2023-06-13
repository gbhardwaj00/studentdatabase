package studentdatabase.studentdatabase.models;

import jakarta.persistence.*;

@Entity
@Table(name = "students")
public class Student {
    //Creating a serial data type for 'sid'
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sid;

    //creating other attributes for students relation
    private String name;
    private Integer weight;
    private Integer height;
    private String hairColor;
    private Double gpa;

    //declaring contructors
    public Student() {
    }
    
    public Student(String name, Integer weight, Integer height, String hairColor, Double gpa) {
        this.name = name;
        this.weight = weight;
        this.height = height;
        this.hairColor = hairColor;
        this.gpa = gpa;
    }

    //declaring getters and setters
    public String getName() {
        return name;
    }
    public Integer getWeight() {
        return weight;
    }
    public Integer getHeight() {
        return height;
    }
    public String getHairColor() {
        return hairColor;
    }
    public Double getGpa() {
        return gpa;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setWeight(Integer weight) {
        this.weight = weight;
    }
    public void setHeight(Integer height) {
        this.height = height;
    }
    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }
    public void setGpa(Double gpa) {
        this.gpa = gpa;
    }
    public int getSid() {
        return sid;
    }
    public void setSid(int sid) {
        this.sid = sid;
    }
    
}
