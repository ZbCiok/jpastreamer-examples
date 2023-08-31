package zjc.examples.spring.jpastreamer.dto;

import lombok.Getter;
import zjc.examples.spring.jpastreamer.model.Department;

import java.util.Objects;

//public record DepartmentDTO(Integer id, String name) {
//    public DepartmentDTO(Department department) {
//        this(department.getId(), department.getName());
//    }
//}

@Getter
public class DepartmentDTO {
    private final Integer id;
    private final String name;

    public DepartmentDTO(Department department) {
        this.id = department.getId();
        this.name = department.getName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DepartmentDTO that = (DepartmentDTO) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "DepartmentDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
