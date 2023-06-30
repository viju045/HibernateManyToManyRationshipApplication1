package org.mahagan.domain;

import jakarta.persistence.*;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "emp")
public class Employees {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int empId;
    private String empName;
    private String empAddress;
    @ManyToMany(targetEntity = Projects.class, cascade = {CascadeType.ALL})
    @JoinTable(name = "employee_project",joinColumns = {@JoinColumn(name = "empId")},
            inverseJoinColumns = {@JoinColumn(name = "projectId")})
    Set<Projects> projects = new HashSet<Projects>();

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpAddress() {
        return empAddress;
    }

    public void setEmpAddress(String empAddress) {
        this.empAddress = empAddress;
    }

    public Set<Projects> getProjects() {
        return projects;
    }

    public void setProjects(Set<Projects> projects) {
        this.projects = projects;
    }
}
