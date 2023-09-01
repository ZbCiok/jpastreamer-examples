package zjc.examples.spring.jpastreamer.repository;

import com.speedment.jpastreamer.application.JPAStreamer;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import zjc.examples.spring.jpastreamer.dto.DepartmentDTO;
import zjc.examples.spring.jpastreamer.dto.EmployeeDTO;
import zjc.examples.spring.jpastreamer.log.LogController;
import zjc.examples.spring.jpastreamer.model.Department;
import zjc.examples.spring.jpastreamer.model.Department$;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository
public class DepartmentRepository implements PanacheRepository<DepartmentDTO> {

    private static final Logger LOGGER = LoggerFactory.getLogger(LogController.class);

    @Inject
    JPAStreamer jpaStreamer;

    private Stream<Department> departmentStream() {
        return jpaStreamer.stream(Department.class);
    }

    public List<DepartmentDTO> listAll() {
        return departmentStream()
                .sorted(Department$.name)
                .map(DepartmentDTO::new)
                .collect(Collectors.toList());
    }

    public String findByTitle(String name) {
        return Objects.requireNonNull(
                departmentStream()
                .filter(Department$.name.equal(name))
                .findFirst().orElse(null)
                ).getName();
    }

    public long getNumberOfEmployees(Integer id) {
        return departmentStream()
                .filter(Department$.id.equal(id))
                .map(Department::getEmployees)
                .mapToLong(Set::size)
                .sum();
    }

    public List<EmployeeDTO> getEmployees(Integer id) {
        return departmentStream()
                .filter(Department$.id.equal(id))
                .map(Department::getEmployees)
                .flatMap(Set::stream)
                .map(EmployeeDTO::new)
                .collect(Collectors.toList());
    }
}
