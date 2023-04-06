package filters;

import db.Laptop;

public class LaptopFilters {
    Filter<String> nameFilter;
    Filter<String> brandFilter;
    Filter<Double> priceFilter;
    Filter<Integer> stockFilter;
    Filter<Integer> cpuFilter;
    Filter<Double> cpuFrequencyFilter;
    Filter<Double> ramGbFilter;
    Filter<Laptop.MemoryType> memoryTypeFilter;

    public LaptopFilters(LaptopFiltersBuilder lfb) {
        this.nameFilter = lfb.nameFilter;
        this.brandFilter = lfb.brandFilter;
        this.priceFilter = lfb.priceFilter;
        this.stockFilter = lfb.stockFilter;
        this.cpuFilter = lfb.cpuFilter;
        this.cpuFrequencyFilter = lfb.cpuFrequencyFilter;
        this.ramGbFilter = lfb.ramGbFilter;
        this.memoryTypeFilter = lfb.memoryTypeFilter;
    }

    public Filter<String> getNameFilter() {
        return nameFilter;
    }

    public Filter<String> getBrandFilter() {
        return brandFilter;
    }

    public Filter<Double> getPriceFilter() {
        return priceFilter;
    }

    public Filter<Integer> getStockFilter() {
        return stockFilter;
    }

    public Filter<Integer> getCpuFilter() {
        return cpuFilter;
    }

    public Filter<Double> getCpuFrequencyFilter() {
        return cpuFrequencyFilter;
    }

    public Filter<Double> getRamGbFilter() {
        return ramGbFilter;
    }

    public Filter<Laptop.MemoryType> getMemoryTypeFilter() {
        return memoryTypeFilter;
    }

    public static class LaptopFiltersBuilder {
        Filter<String> nameFilter;
        Filter<String> brandFilter;
        Filter<Double> priceFilter;
        Filter<Integer> stockFilter;
        Filter<Integer> cpuFilter;
        Filter<Double> cpuFrequencyFilter;
        Filter<Double> ramGbFilter;
        Filter<Laptop.MemoryType> memoryTypeFilter;


        public LaptopFiltersBuilder nameFilter(Filter<String> filter) {
            this.nameFilter = filter;
            return this;
        }
        public LaptopFiltersBuilder brandFilter(Filter<String> filter) {
            this.brandFilter = filter;
            return this;
        }
        public LaptopFiltersBuilder priceFilter(Filter<Double> filter) {
            this.priceFilter = filter;
            return this;
        }
        public LaptopFiltersBuilder stockFilter(Filter<Integer> filter) {
            this.stockFilter = filter;
            return this;
        }
        public LaptopFiltersBuilder cpuFilter(Filter<Integer> filter) {
            this.cpuFilter = filter;
            return this;
        }
        public LaptopFiltersBuilder cpuFrequencyFilter(Filter<Double> filter) {
            this.cpuFrequencyFilter = filter;
            return this;
        }
        public LaptopFiltersBuilder ramGbFilter(Filter<Double> filter) {
            this.ramGbFilter = filter;
            return this;
        }
        public LaptopFiltersBuilder memoryTypeFilter(Filter<Laptop.MemoryType> filter) {
            this.memoryTypeFilter = filter;
            return this;
        }
        public LaptopFilters build() {
            return new LaptopFilters(this);
        }
    }
}
