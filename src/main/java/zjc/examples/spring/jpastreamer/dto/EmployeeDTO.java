package zjc.examples.spring.jpastreamer.dto;

import zjc.examples.spring.jpastreamer.model.Employee;

public record EmployeeDTO(
        Integer id,
        String name,
        String position,
        int salary
) {
    public EmployeeDTO(Employee emp) {
        this(emp.getId(), emp.getName(), emp.getPosition(), emp.getSalary());
    }
}
