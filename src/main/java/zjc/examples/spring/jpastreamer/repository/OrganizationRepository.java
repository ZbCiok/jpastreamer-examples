package zjc.examples.spring.jpastreamer.repository;

import com.speedment.jpastreamer.application.JPAStreamer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.springframework.stereotype.Repository;
import zjc.examples.spring.jpastreamer.dto.OrganizationDTO;
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

    // update Organization.name
    public void update() {
        final EntityManagerFactory emf = Persistence.createEntityManagerFactory("testdb");
        final EntityManager em = emf.createEntityManager();
        streamer.stream(EntityManagerFactory.class);

        String oldName = "Org1.02";
        String newName = "Org1.03";

        try {
            em.getTransaction().begin();;
            streamer.stream(Organization.class)
                    .filter(Organization$.name.equal(oldName))
                    .forEach(f -> {
                        f.setName(newName);
                        System.out.println("New name: = " + f.getName());
                        em.merge(f);
                    });
            em.getTransaction().commit();
        } catch(Exception e) {
            System.out.println(e.getMessage());
            em.getTransaction().rollback();
        }

        em.close();
        emf.close();
    }
}
