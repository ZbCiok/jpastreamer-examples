package zjc.examples.spring.jpastreamer.repository;

import com.speedment.jpastreamer.application.JPAStreamer;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import zjc.examples.spring.jpastreamer.dto.OrganizationDTO;
import zjc.examples.spring.jpastreamer.log.LogController;
import zjc.examples.spring.jpastreamer.model.Organization;
import zjc.examples.spring.jpastreamer.model.Organization$;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository
@ApplicationScoped
public class OrganizationRepository implements PanacheRepository<OrganizationDTO> {

    private static final Logger LOGGER = LoggerFactory.getLogger(LogController.class);

    @Inject
    JPAStreamer jpaStreamer;
    private Stream<Organization> organizationStream() { return jpaStreamer.stream(Organization.class); }

    public List<OrganizationDTO> listAll() {
        return organizationStream()
                .sorted(Organization$.name)
                .map(OrganizationDTO::new)
                .collect(Collectors.toList());
    }
}
