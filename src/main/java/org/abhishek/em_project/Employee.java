package org.abhishek.em_project;

import lombok.Data;

@Data
public class Employee {
    private Long id;
    private String name;
    private String phone;
    private String email;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

}
