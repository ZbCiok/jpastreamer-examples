package zjc.examples.spring.jpastreamer.dto;

import lombok.Getter;
import zjc.examples.spring.jpastreamer.model.Department;

public record DepartmentDTO(Integer id, String name) {
    public DepartmentDTO(Department department) {
        this(department.getId(), department.getName());
    }
}