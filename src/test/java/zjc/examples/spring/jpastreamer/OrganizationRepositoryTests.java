package zjc.examples.spring.jpastreamer;

import io.quarkus.test.TestTransaction;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.Modifying;
import zjc.examples.spring.jpastreamer.dto.OrganizationDTO;
import zjc.examples.spring.jpastreamer.repository.OrganizationRepository;
import zjc.examples.spring.jpastreamer.model.Organization;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class OrganizationRepositoryTests {

    @Autowired
    private OrganizationRepository repository;


    @Test
    void findAll() {
        List<OrganizationDTO> all = repository.listAll();
        assertEquals(2, all.size());
    }

//    @Modifying
//    public int update(String query, String name) { //, Integer id) {
//
//        return repository.update(query, name);
//    }
//    @Test
//    @TestTransaction
//    void update1() {
//        int id = update("name = 'Org1.03' where id = ?1", "name='xxxxx'");
//    }
}