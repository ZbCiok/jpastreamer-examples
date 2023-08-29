package zjc.examples.spring.jpastreamer;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import zjc.examples.spring.jpastreamer.dto.OrganizationDTO;
import zjc.examples.spring.jpastreamer.repository.OrganizationRepository;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class OrganizationRepositoryTests {

    @Autowired
    private OrganizationRepository repository;

    @Test
    void findAll() {
        List<OrganizationDTO> all = repository.findAll();
        assertEquals(2, all.size());
    }

    // update Organization.name
    @Test
    public void update() {
        repository.update();
    }
}
