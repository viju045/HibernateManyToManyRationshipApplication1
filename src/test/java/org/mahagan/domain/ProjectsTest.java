package org.mahagan.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

class ProjectsTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link Projects}
     *   <li>{@link Projects#setEmployees(Set)}
     *   <li>{@link Projects#setProjectDomain(String)}
     *   <li>{@link Projects#setProjectId(int)}
     *   <li>{@link Projects#setProjectName(String)}
     *   <li>{@link Projects#setProjectVersion(String)}
     *   <li>{@link Projects#getEmployees()}
     *   <li>{@link Projects#getProjectDomain()}
     *   <li>{@link Projects#getProjectId()}
     *   <li>{@link Projects#getProjectName()}
     *   <li>{@link Projects#getProjectVersion()}
     * </ul>
     */
    @Test
    void testConstructor() {
        Projects actualProjects = new Projects();
        HashSet<Employees> employees = new HashSet<>();
        actualProjects.setEmployees(employees);
        actualProjects.setProjectDomain("Project Domain");
        actualProjects.setProjectId(1);
        actualProjects.setProjectName("Project Name");
        actualProjects.setProjectVersion("1.0.2");
        assertSame(employees, actualProjects.getEmployees());
        assertEquals("Project Domain", actualProjects.getProjectDomain());
        assertEquals(1, actualProjects.getProjectId());
        assertEquals("Project Name", actualProjects.getProjectName());
        assertEquals("1.0.2", actualProjects.getProjectVersion());
    }
}

