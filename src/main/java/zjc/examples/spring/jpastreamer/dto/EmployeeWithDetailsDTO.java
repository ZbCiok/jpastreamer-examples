package zjc.examples.spring.jpastreamer.dto;

import lombok.Getter;
import zjc.examples.spring.jpastreamer.model.Employee;

import java.util.Objects;

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
//
//@Getter
//public class EmployeeWithDetailsDTO {
//
//    private final Integer id;
//    private final String name;
//    private final String position;
//    private final int salary;
//    private final  String organizationName;
//    private final String departmentName;
//
//    public EmployeeWithDetailsDTO(Employee employee) {
//        this.id = employee.getId();
//        this.name = employee.getName();
//        this.position = employee.getPosition();
//        this.salary = employee.getSalary();
//        this.organizationName = employee.getOrganization().getName();
//        this.departmentName = employee.getDepartment().getName();
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        EmployeeWithDetailsDTO that = (EmployeeWithDetailsDTO) o;
//        return salary == that.salary && Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(position, that.position) && Objects.equals(organizationName, that.organizationName) && Objects.equals(departmentName, that.departmentName);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id, name, position, salary, organizationName, departmentName);
//    }
//
//    @Override
//    public String toString() {
//        return "EmployeeWithDetailsDTO{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", position='" + position + '\'' +
//                ", salary=" + salary +
//                ", organizationName='" + organizationName + '\'' +
//                ", departmentName='" + departmentName + '\'' +
//                '}';
//    }
//}
//
