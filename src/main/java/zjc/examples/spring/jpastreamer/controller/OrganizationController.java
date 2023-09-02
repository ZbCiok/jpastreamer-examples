package zjc.examples.spring.jpastreamer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zjc.examples.spring.jpastreamer.dto.OrganizationDTO;
import zjc.examples.spring.jpastreamer.repository.OrganizationRepository;

import java.util.List;

@RestController
@RequestMapping("/organizations")
public class OrganizationController {

    private final OrganizationRepository repository;

    public OrganizationController(OrganizationRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<OrganizationDTO> findAll() {
        return repository.listAll();
    }
}
