package zjc.examples.spring.jpastreamer.dto;

import lombok.Getter;
import zjc.examples.spring.jpastreamer.model.Employee;

public record EmployeeWithDetailsDTO(
        Integer id,
        String name,
        String position,
        int salary,
        String organizationName,
        String departmentName
) {
    public EmployeeWithDetailsDTO(Employee emp) {
        this(
                emp.getId(),
                emp.getName(),
                emp.getPosition(),
                emp.getSalary(),
                emp.getOrganization().getName(),
                emp.getDepartment().getName());
    }

    @Override
    public Integer id() {
        return id;
    }

    @Override
    public String departmentName() {
        return departmentName;
    }

    @Override
    public String organizationName() {
        return organizationName;
    }
}
