package zjc.examples.spring.jpastreamer.dto;

import lombok.Getter;
import zjc.examples.spring.jpastreamer.model.Organization;

import java.util.Objects;

//public record OrganizationDTO(Integer id, String name) {
//    public OrganizationDTO(Organization organization) {
//        this(organization.getId(), organization.getName());
//    }
//}

@Getter
public class OrganizationDTO {

    private final Integer id;
    private final String name;


    public OrganizationDTO(Organization organization) {
        this.id = organization.getId();
        this.name = organization.getName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrganizationDTO that = (OrganizationDTO) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "OrganizationDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
