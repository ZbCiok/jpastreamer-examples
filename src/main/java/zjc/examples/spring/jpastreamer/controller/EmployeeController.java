package zjc.examples.spring.jpastreamer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zjc.examples.spring.jpastreamer.dto.EmployeeDTO;
import zjc.examples.spring.jpastreamer.dto.EmployeeWithDetailsDTO;
import zjc.examples.spring.jpastreamer.repository.EmployeeRepository;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeRepository repository;

    public EmployeeController(EmployeeRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/greater-than/{salary}")
    public List<EmployeeDTO> findBySalaryGreaterThan(@PathVariable("salary") int salary) {
        return findBySalaryGreaterThan(salary);
    }

    @GetMapping("/offset/{offset}/limit/{limit}")
    public List<EmployeeDTO> findAllWithPagination(@PathVariable("offset") int offset,
                                                   @PathVariable("limit") int limit) {
        return repository.findAllWithPagination(offset, limit);
    }

    @GetMapping("/{id}")
    public EmployeeWithDetailsDTO findById(@PathVariable("id") Integer id) {
        return repository.findById(id);
    }
}
