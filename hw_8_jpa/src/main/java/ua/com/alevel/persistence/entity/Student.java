package ua.com.alevel.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name = "students_table")
public class Student extends BaseEntity {

    private String first_name;
    private String last_name;

    @ManyToOne()
    @JoinColumn(name = "group_id", referencedColumnName = "id")
    private Group group;

    public Student() {
        super();
    }

    public String getFirstName() {
        return first_name;
    }

    public void setFirstName(String firstName) {
        this.first_name = firstName;
    }

    public String getLastName() {
        return last_name;
    }

    public void setLastName(String lastName) {
        this.last_name = lastName;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}
