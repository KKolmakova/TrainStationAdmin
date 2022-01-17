package com.kolmakova.util;

import com.kolmakova.dto.DocumentDTO;
import com.kolmakova.entities.Passenger;
import com.kolmakova.types.DocumentType;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

public class PassengerUtils {

    public static Specification<Passenger> getWithParams(String name, String surname, DocumentDTO documentDTO, String documentSeries) {
        Specification<Passenger> specification = Specification.where(null);

        if (StringUtils.isNotEmpty(name)) {
            specification = specification.and(matchesName(name));
        }
        if (StringUtils.isNotEmpty(surname)) {
            specification = specification.and(matchesSurname(surname));
        }
        if (documentDTO != null) {
            if (documentDTO.getType() != null) {
                specification = specification.and(matchesDocumentType(documentDTO.getType()));
            }
        }
        if (StringUtils.isNotEmpty(documentSeries)) {
            specification = specification.and(matchesDocumentSeries(documentSeries));
        }

        return specification;
    }

    private static Specification<Passenger> matchesName(String name) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("name"), name);
    }

    private static Specification<Passenger> matchesSurname(String surname) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("surname"), surname);
    }

    private static Specification<Passenger> matchesDocumentType(DocumentType documentType) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("documentType").get("type"), documentType);
    }

    private static Specification<Passenger> matchesDocumentSeries(String documentSeries) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("documentSeries"), documentSeries);
    }
}
