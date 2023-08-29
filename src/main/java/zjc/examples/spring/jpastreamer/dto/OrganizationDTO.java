package zjc.examples.spring.jpastreamer.dto;

import zjc.examples.spring.jpastreamer.model.Organization;

public record OrganizationDTO(Integer id, String name) {
    public OrganizationDTO(Organization organization) {
        this(organization.getId(), organization.getName());
    }
}
