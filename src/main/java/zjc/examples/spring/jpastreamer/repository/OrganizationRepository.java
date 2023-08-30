package zjc.examples.spring.jpastreamer.repository;

import com.speedment.common.codegen.model.Interface;
import com.speedment.jpastreamer.application.JPAStreamer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import zjc.examples.spring.jpastreamer.dto.OrganizationDTO;
import zjc.examples.spring.jpastreamer.log.LogController;
import zjc.examples.spring.jpastreamer.model.Organization;
import zjc.examples.spring.jpastreamer.model.Organization$;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class OrganizationRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(LogController.class);
    private final JPAStreamer  streamer;

    public OrganizationRepository(JPAStreamer streamer) { this.streamer = streamer; }

    public List<OrganizationDTO> findAll() {
        LOGGER.info("OrganizationRepository::findAll");
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

    interface DoInJPA {
        public void doInJPA();
    }

//    public void save() {
//        final EntityManagerFactory emf = Persistence.createEntityManagerFactory("testdb");
//        final EntityManager em = emf.createEntityManager();
//
//        Organization organization = DoInJPA(entityManager -> {
//            Organization org = new Organization()
//                    .setName("High-Performance Java Persistence")
//                    .setAuthor("Vlad Mihalcea");
//
//            Session session = em.unwrap(Session.class);
//            session.persist(org);
//            session.close();
//
//            LOGGER.info(
//                    "Saving the Book entity with the id: {}",
//                    id
//            );
//        });
//
//        em.close();
//        emf.close();
//    }
}
