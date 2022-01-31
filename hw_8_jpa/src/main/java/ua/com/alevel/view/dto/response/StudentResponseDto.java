package ua.com.alevel.view.dto.response;

import ua.com.alevel.persistence.entity.Group;
import ua.com.alevel.persistence.entity.Student;

public class StudentResponseDto extends ResponseDto {

    private String firstName;
    private String lastName;
    private Group group;

    public StudentResponseDto() {
    }

    public StudentResponseDto(Student student) {
        this.firstName = student.getFirstName();
        this.lastName = student.getLastName();
        if (student.getGroup() != null) {
            this.group = student.getGroup();
        }
        super.setId(student.getId());
        super.setCreated(student.getCreated());
        super.setUpdated(student.getUpdated());
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}
