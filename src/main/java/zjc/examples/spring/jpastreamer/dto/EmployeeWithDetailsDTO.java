package zjc.examples.spring.jpastreamer.dto;

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
        this(emp.getId(), emp.getName(), emp.getPosition(), emp.getSalary(),
                emp.getOrganization().getName(),
                emp.getDepartment().getName());
    }
}
