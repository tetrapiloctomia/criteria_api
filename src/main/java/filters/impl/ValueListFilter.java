package filters.impl;

import filters.Filter;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import java.util.ArrayList;
import java.util.List;

public class ValueListFilter<T> implements Filter {
    String name;
    List<T> values = new ArrayList<>();

    public ValueListFilter(String name, List<T> values) {
        this.name = name;
        this.values = values;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Predicate getPredicate(CriteriaBuilder builder, Root root) {
        CriteriaBuilder.In<T> inClause = builder.in(root.get(name));
        values.forEach(inClause::value);
        return inClause;
    }
}
