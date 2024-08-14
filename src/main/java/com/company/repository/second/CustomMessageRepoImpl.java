package com.company.repository.second;

import com.company.dto.MessageCriteria;
import com.company.entity.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;


@Repository
@RequiredArgsConstructor
public class CustomMessageRepoImpl implements CustomMessageRepo {

    @PersistenceContext
    private final EntityManager entityManager;

    @Override
    public List<Message> getMessageList(MessageCriteria criteria) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Message> cq = cb.createQuery(Message.class);
        Root<Message> root = cq.from(Message.class);

        List<Predicate> predicateList = getPredicateList(criteria, cb, root);
        Order sortOrder = getSortOrder(criteria, cb, root);

        cq.select(root);
        cq.where(predicateList.toArray(new Predicate[0]));
        cq.orderBy(sortOrder);

        return entityManager.createQuery(cq)
                .setFirstResult(criteria.getPage() * criteria.getSize())
                .setMaxResults(criteria.getSize())
                .getResultList();
    }

    @Override
    public Long getTotalCount(MessageCriteria criteria) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> countQuery = cb.createQuery(Long.class);

        Root<Message> rootCount = countQuery.from(Message.class);
        List<Predicate> predicateList = getPredicateList(criteria, cb, rootCount);

        countQuery.select(cb.count(rootCount)).where(cb.and(predicateList.toArray(new Predicate[0])));

        return entityManager.createQuery(countQuery).getSingleResult();
    }

    private List<Predicate> getPredicateList(MessageCriteria criteria, CriteriaBuilder cb, Root<Message> root) {
        List<Predicate> predicateList = new ArrayList<>();
        if (StringUtils.hasText(criteria.getKey())) {
            predicateList.add(cb.like(cb.upper(root.get("key")), "%" + criteria.getKey().toUpperCase() + "%"));
        }

        return predicateList;
    }

    private Order getSortOrder(MessageCriteria criteria, CriteriaBuilder cb, Root<Message> root) {
        Expression<?> expression = root.get("id");
        if (StringUtils.hasText(criteria.getSortBy())) {
            switch (criteria.getSortBy()) {
                case "key":
                    expression = root.get("key");
                    break;
                case "message":
                    expression = root.get("message");
                    break;
                default:
                    expression = root.get("id");
            }
        }
        return "ASC".equalsIgnoreCase(criteria.getSortDirection()) ? cb.asc(expression) : cb.desc(expression);
    }
}
