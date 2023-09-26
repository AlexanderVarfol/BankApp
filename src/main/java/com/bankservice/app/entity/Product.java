package com.bankservice.app.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.security.Timestamp;
import java.util.List;
import java.util.Objects;

import static jakarta.persistence.CascadeType.*;

@Entity
@Table(name = "products")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @JoinColumn(name = "manager_Id")
    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {MERGE, PERSIST, REFRESH})
    private Manager manager;

    @Column(name = "Product_status")
    private int status;

    @Column(name = "currency_Code")
    private int currencyCode;

    @Column(name = "interest_Rate")
    private int interestRate;

    @Column(name = "Produckt_limit")
    private int limit;

    @Column(name = "created_At")
    private Timestamp createdAt;

    @Column(name = "updated_At")
    private Timestamp updatedAt;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY,          //OneToMany - долден быть контейнер
            orphanRemoval = true, cascade = {MERGE, PERSIST, REFRESH})
    private List<Manager> managers;

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", managerId=" + manager +
                ", status=" + status +
                ", currencyCode=" + currencyCode +
                ", interestRate=" + interestRate +
                ", limit=" + limit +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id && manager == product.manager && Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, manager);
    }
}