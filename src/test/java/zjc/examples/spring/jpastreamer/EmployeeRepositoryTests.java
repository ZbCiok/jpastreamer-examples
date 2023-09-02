package zjc.examples.spring.jpastreamer;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import zjc.examples.spring.jpastreamer.dto.EmployeeDTO;
import zjc.examples.spring.jpastreamer.dto.EmployeeWithDetailsDTO;
import zjc.examples.spring.jpastreamer.repository.EmployeeRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class EmployeeRepositoryTests {

    @Autowired
    private EmployeeRepository repository;

    @Test
    void findByIdWithDetails() {
        EmployeeWithDetailsDTO dto = repository.findById(1);
        assertNotNull(dto);
        assertNotNull(dto.departmentName());     //.getDepartmentName());
        assertNotNull(dto.organizationName());   //getOrganizationName());
        assertEquals(dto.id(), 1);         //getId(), 1);
    }

    @Test
    void findAllWithPagination() {
        List<EmployeeDTO> all = repository.findAllWithPagination(0, 3);
        assertEquals(3, all.size());
    }

    @Test
    void findBySalaryGreaterThan() {
        List<EmployeeDTO> employees = repository.findBySalaryGreaterThan(25000);
        assertEquals(3, employees.size());
    }
}
