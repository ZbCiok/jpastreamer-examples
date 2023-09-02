package zjc.examples.spring.jpastreamer.repository;

import com.speedment.jpastreamer.application.JPAStreamer;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import zjc.examples.spring.jpastreamer.dto.DepartmentDTO;
import zjc.examples.spring.jpastreamer.dto.EmployeeDTO;
import zjc.examples.spring.jpastreamer.dto.EmployeeWithDetailsDTO;
import zjc.examples.spring.jpastreamer.log.LogController;
import zjc.examples.spring.jpastreamer.model.Department;
import zjc.examples.spring.jpastreamer.model.Department$;
import zjc.examples.spring.jpastreamer.model.Employee;
import zjc.examples.spring.jpastreamer.model.Employee$;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.speedment.jpastreamer.streamconfiguration.StreamConfiguration.of;

@Repository
public class EmployeeRepository  implements PanacheRepository<EmployeeDTO> {

    private static final Logger LOGGER = LoggerFactory.getLogger(LogController.class);

    @Inject
    JPAStreamer jpaStreamer;
    private Stream<Employee> employeeStream() { return jpaStreamer.stream(Employee.class); }


    public List<EmployeeDTO> listAll() {
        return employeeStream()
                .sorted(Employee$.name)
                .map(EmployeeDTO::new)
                .collect(Collectors.toList());
    }

    public List<EmployeeDTO> findBySalaryGreaterThan(final int salary) {
        return employeeStream()
                .filter(Employee$.salary.greaterThan(salary))
                .sorted(Employee$.salary)
                .map(EmployeeDTO::new)
                .collect(Collectors.toList());
    }

    public List<EmployeeDTO> findAllWithPagination(final int offset,
                                                   final int limit) {
        return employeeStream()
                .skip(offset)
                .limit(limit)
                .map(EmployeeDTO::new)
                .collect(Collectors.toList());
    }

    // TODO
    public EmployeeWithDetailsDTO findById(final Integer id) {
        return jpaStreamer.stream(of(Employee.class)
                        .joining(Employee$.department)
                        .joining(Employee$.organization))
                .filter(Employee$.id.equal(id))
                .map(EmployeeWithDetailsDTO::new)
                .findFirst()
                .orElseThrow();
    }
}
