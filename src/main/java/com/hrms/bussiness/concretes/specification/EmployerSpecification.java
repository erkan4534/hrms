package com.hrms.bussiness.concretes.specification;

import com.hrms.entities.concretes.Employer;
import org.springframework.stereotype.Component;
import org.springframework.data.jpa.domain.Specification;
import static org.springframework.data.jpa.domain.Specification.where;

@Component
public class EmployerSpecification extends BaseSpecification<Employer, Employer> {

    @Override
    public Specification<Employer> getFilter(Employer employer) {
        return where(firmNameContains(employer.getFirmName()))
                .and(emailContains(employer.getPerson()!=null?employer.getPerson().getEmail():null))
                .and(webSiteContains(employer.getWebSite()))
                .and(telNoContains(employer.getPerson()!=null?employer.getPerson().getTelNo():null));
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
