package db;

import jakarta.persistence.*;
@Entity
public class Laptop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String brand;
    private Double price;
    private Integer stock;
    private Integer cpu;
    private Double cpuFrequency;
    private Double ramGb;
    @Enumerated(value = EnumType.STRING)
    private MemoryType memoryType;
    public enum MemoryType {
        SSD, HDD;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getCpu() {
        return cpu;
    }

    public void setCpu(Integer cpu) {
        this.cpu = cpu;
    }

    public Double getCpuFrequency() {
        return cpuFrequency;
    }

    public void setCpuFrequency(Double cpuFrequency) {
        this.cpuFrequency = cpuFrequency;
    }

    public Double getRamGb() {
        return ramGb;
    }

    public void setRamGb(Double ramGb) {
        this.ramGb = ramGb;
    }

    public MemoryType getMemoryType() {
        return memoryType;
    }

    public void setMemoryType(MemoryType memoryType) {
        this.memoryType = memoryType;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", cpu=" + cpu +
                ", cpuFrequency=" + cpuFrequency +
                ", ram=" + ramGb +
                ", memoryType=" + memoryType +
                '}';
    }
    public static LaptopBuilder builder() {
        return new LaptopBuilder();
    }
    public static class LaptopBuilder {
        private static Laptop instance = new Laptop();

        public LaptopBuilder name(String name) {
            instance.name = name;
            return this;
        }
        public LaptopBuilder price(Double price) {
            instance.price = price;
            return this;
        }

        public LaptopBuilder stock(Integer stock) {
            instance.stock = stock;
            return this;
        }
        public LaptopBuilder cpu(Integer cpu) {
            instance.cpu = cpu;
            return this;
        }
        public LaptopBuilder cpuFrequency(Double cpuFrequency) {
            instance.cpuFrequency = cpuFrequency;
            return this;
        }
        public LaptopBuilder ramGb(Double ramGb) {
            instance.ramGb = ramGb;
            return this;
        }
        public LaptopBuilder memoryType(MemoryType memoryType) {
            instance.memoryType = memoryType;
            return this;
        }
        public Laptop build() {
            return instance;
        }
    }
}
