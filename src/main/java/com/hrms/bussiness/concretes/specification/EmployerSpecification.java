package com.hrms.bussiness.concretes.specification;

import com.hrms.entities.concretes.Employer;
import com.hrms.entities.dto.EmployerDto;
import org.springframework.stereotype.Component;
import org.springframework.data.jpa.domain.Specification;
import static org.springframework.data.jpa.domain.Specification.where;

@Component
public class EmployerSpecification extends BaseSpecification<Employer, EmployerDto> {

    @Override
    public Specification<Employer> getFilter(EmployerDto employerDto) {
        return where(firmNameContains(employerDto.getFirmName()))
                .and(emailContains(employerDto.getEmail()))
                .and(webSiteContains(employerDto.getWebSite()))
                .and(telNoContains(employerDto.getTelNo()));
    }

    private Specification<Employer> firmNameContains(String firmName) {
        return employerAttributeContains("firmName", firmName);
    }

    private Specification<Employer> webSiteContains(String webSite) {
        return employerAttributeContains("webSite", webSite);
    }

    private Specification<Employer> emailContains(String email) {
        return personAttributeContains("email", email);
    }

    private Specification<Employer> telNoContains(String telNo) {
        return personAttributeContains("telNo", telNo);
    }

    private Specification<Employer> employerAttributeContains(String attribute, String value) {
        return (root, query, cb) -> {
            if(value == null) {
                return null;
            }

            return cb.like(
                    cb.lower(root.get(attribute)),
                    containsLowerCase(value)
            );
        };
    }

    private Specification<Employer> personAttributeContains(String attribute, String value) {
        return (root, query, cb) -> {
            if(value == null) {
                return null;
            }

            return cb.like(
                    cb.lower(root.get("person").get(attribute)),
                    containsLowerCase(value)
            );
        };
    }


}
