package filters.impl;

import filters.Filter;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class RangeFilter<T extends Comparable<T>> implements Filter<T> {
    private String name;
    private T upper;
    private T lower;
    @Override
    public String getName() {
        return name;
    }

    @Override
    public Predicate getPredicate(CriteriaBuilder builder, Root<?> root) {
        return builder.between(root.get(name), lower, upper);
    }
}
