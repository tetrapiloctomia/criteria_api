package main;

import db.Laptop;
import filters.Filter;
import filters.LaptopFilters;
import filters.impl.ExactValueFilter;
import filters.impl.LessThanFilter;
import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import java.sql.ResultSet;
import java.util.List;
import java.util.Random;

public class Runner {
      private static Predicate getPredicate(CriteriaBuilder builder, Root<Laptop> root, LaptopFilters filters) {
        Predicate predicate = builder.conjunction();

        if(filters.getNameFilter() != null) {
            predicate = builder.and(predicate, filters.getNameFilter().getPredicate(builder, root));
        }
        if(filters.getBrandFilter() != null) {
            predicate = builder.and(predicate, filters.getBrandFilter().getPredicate(builder, root));
        }
        if(filters.getPriceFilter() != null) {
            predicate = builder.and(predicate, filters.getPriceFilter().getPredicate(builder, root));
        }
        if(filters.getStockFilter() != null) {
            predicate = builder.and(predicate, filters.getStockFilter().getPredicate(builder, root));
        }
        if(filters.getCpuFilter() != null) {
            predicate = builder.and(predicate, filters.getCpuFilter().getPredicate(builder, root));
        }
        if(filters.getCpuFrequencyFilter() != null) {
            predicate = builder.and(predicate, filters.getCpuFrequencyFilter().getPredicate(builder, root));
        }
        if(filters.getRamGbFilter() != null) {
            predicate = builder.and(predicate, filters.getRamGbFilter().getPredicate(builder, root));
        }
        if(filters.getMemoryTypeFilter() != null) {
            predicate = builder.and(predicate, filters.getMemoryTypeFilter().getPredicate(builder, root));
        }
        return predicate;
    }
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("criteria_api");
        EntityManager em = emf.createEntityManager();


        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Laptop> query = builder.createQuery(Laptop.class); //
        Root<Laptop> root = query.from(Laptop.class);

        LaptopFilters filters = new LaptopFilters.LaptopFiltersBuilder()
                .brandFilter(new ExactValueFilter<String>("brand", "lenovo"))
                .priceFilter(new LessThanFilter<Double>("price", 6000.0))
                .build();
        Predicate predicate = getPredicate(builder, root, filters);

        query.where(predicate);
        TypedQuery<Laptop> typedQuery = em.createQuery(query);
        List<Laptop> laptops = typedQuery.getResultList();
        laptops.forEach(System.out::println);
    }
}
