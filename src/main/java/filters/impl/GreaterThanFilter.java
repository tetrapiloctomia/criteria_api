package filters.impl;

import filters.Filter;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class GreaterThanFilter<T extends Comparable<T>> implements Filter<T> {
    private final String name;
    private final T value;

    public GreaterThanFilter(String name, T value) {
        this.name = name;
        this.value = value;
    }
    @Override
    public String getName() {
        return name;
    }

    @Override
    public Predicate getPredicate(CriteriaBuilder builder, Root<?> root) {
        return builder.greaterThan(root.get(name), value);
    }
}
