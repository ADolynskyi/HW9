package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.*;
import org.apache.log4j.Logger;
import org.example.data_base_entities.Apartment;
import org.example.data_base_entities.Building;
import org.example.data_base_entities.Resident;
import org.example.data_base_entities.ResidentApartment;

import java.util.List;

public class CriteriaAPI {
    private static final Logger logger = Logger.getLogger(CriteriaAPI.class);

    public List<Object[]> carEntranceCriteriaSelect(EntityManager entityManager) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Object[]> criteriaQuery = criteriaBuilder.createQuery(Object[].class);
        Root<Resident> residentRoot = criteriaQuery.from(Resident.class);
        Join<Resident, ResidentApartment> residentApartmentJoin = residentRoot.join("residentApartment", JoinType.INNER);
        Join<ResidentApartment, Apartment> apartmentJoin = residentApartmentJoin.join("apartment", JoinType.INNER);
        Join<Apartment, Building> buildingJoin = apartmentJoin.join("building", JoinType.INNER);

        criteriaQuery.multiselect(
                residentRoot.get("id"),
                residentRoot.get("firstName"),
                residentRoot.get("familyName"),
                residentRoot.get("email"),
                apartmentJoin.get("id"),
                apartmentJoin.get("area"),
                buildingJoin.get("name"),
                buildingJoin.get("street"),
                buildingJoin.get("number")
        );

        Predicate carPermissionPredicate = criteriaBuilder.equal(residentRoot.get("driveInPermission"), false);

        Subquery<Long> subquery = criteriaQuery.subquery(Long.class);
        Root<ResidentApartment> subqueryRoot = subquery.from(ResidentApartment.class);
        subquery.select(subqueryRoot.get("resident").get("id"))
                .groupBy(subqueryRoot.get("resident"))
                .having(criteriaBuilder.lt(criteriaBuilder.count(subqueryRoot), 2L));

        criteriaQuery.where(criteriaBuilder.and(carPermissionPredicate, criteriaBuilder.in(residentRoot.get("id")).value(subquery)));

        List<Object[]> results = entityManager.createQuery(criteriaQuery).getResultList();
        logger.debug("list is got");
        return results;
    }
}
