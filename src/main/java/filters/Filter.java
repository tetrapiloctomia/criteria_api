package filters;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public interface Filter<T> {
    String getName();
    Predicate getPredicate(CriteriaBuilder builder, Root<?> root);
}
