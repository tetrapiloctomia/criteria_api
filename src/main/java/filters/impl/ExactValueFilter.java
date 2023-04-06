package filters.impl;

import filters.Filter;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class ExactValueFilter<T> implements Filter {
    private String name;
    private T value;

    public ExactValueFilter(String name, T value) {
        this.name = name;
        this.value = value;
    }
    @Override
    public String getName() {
        return name;
    }

    @Override
    public Predicate getPredicate(CriteriaBuilder builder, Root root) {
        return builder.equal(root.get(name), value);
    }
}
