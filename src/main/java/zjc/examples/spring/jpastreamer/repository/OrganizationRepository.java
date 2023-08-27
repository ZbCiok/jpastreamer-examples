package zjc.examples.spring.jpastreamer.repository;

import com.speedment.jpastreamer.application.JPAStreamer;
import org.springframework.stereotype.Repository;
import zjc.examples.spring.jpastreamer.dto.DepartmentDTO;
import zjc.examples.spring.jpastreamer.dto.OrganizationDTO;
import zjc.examples.spring.jpastreamer.model.Department;
import zjc.examples.spring.jpastreamer.model.Department$;
import zjc.examples.spring.jpastreamer.model.Organization;
import zjc.examples.spring.jpastreamer.model.Organization$;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class OrganizationRepository {

    private final JPAStreamer streamer;

    public OrganizationRepository(JPAStreamer streamer) { this.streamer = streamer; }

    public List<OrganizationDTO> findAll() {
        return streamer.stream(Organization.class)
                .sorted(Organization$.name)
                .map(OrganizationDTO::new)
                .collect(Collectors.toList());
    }
}
