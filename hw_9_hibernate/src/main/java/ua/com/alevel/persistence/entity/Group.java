package ua.com.alevel.persistence.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "groups_table")
public class Group extends BaseEntity {

    private String name;

    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "group")
    private Set<Student> students;

    public Group() {
        super();
        this.students = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }
}
