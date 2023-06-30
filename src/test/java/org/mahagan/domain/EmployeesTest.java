package org.mahagan.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

class EmployeesTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link Employees}
     *   <li>{@link Employees#setEmpAddress(String)}
     *   <li>{@link Employees#setEmpId(int)}
     *   <li>{@link Employees#setEmpName(String)}
     *   <li>{@link Employees#setProjects(Set)}
     *   <li>{@link Employees#getEmpAddress()}
     *   <li>{@link Employees#getEmpId()}
     *   <li>{@link Employees#getEmpName()}
     *   <li>{@link Employees#getProjects()}
     * </ul>
     */
    @Test
    void testConstructor() {
        Employees actualEmployees = new Employees();
        actualEmployees.setEmpAddress("42 Main St");
        actualEmployees.setEmpId(1);
        actualEmployees.setEmpName("Emp Name");
        HashSet<Projects> projects = new HashSet<>();
        actualEmployees.setProjects(projects);
        assertEquals("42 Main St", actualEmployees.getEmpAddress());
        assertEquals(1, actualEmployees.getEmpId());
        assertEquals("Emp Name", actualEmployees.getEmpName());
        assertSame(projects, actualEmployees.getProjects());
    }
}

