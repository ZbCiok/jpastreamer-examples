package zjc.examples.spring.jpastreamer.dto;

import lombok.Getter;
import zjc.examples.spring.jpastreamer.model.Employee;

import java.util.Objects;

//public record EmployeeDTO(
//        Integer id,
//        String name,
//        String position,
//        int salary
//) {
//    public EmployeeDTO(Employee emp) {
//        this(emp.getId(), emp.getName(), emp.getPosition(), emp.getSalary());
//    }
//}

@Getter
public class EmployeeDTO {

    private final Integer id;
    private final String name;
    private String position;
    private int salary;

    public EmployeeDTO(Employee employee) {
        this.id = employee.getId();
        this.name = employee.getName();
        this.position = employee.getPosition();
        this.salary = employee.getSalary();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeDTO that = (EmployeeDTO) o;
        return salary == that.salary && Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(position, that.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, position, salary);
    }

    @Override
    public String toString() {
        return "EmployeeDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                '}';
    }
}
