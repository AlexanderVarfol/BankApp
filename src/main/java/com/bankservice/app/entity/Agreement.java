package com.bankservice.app.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.security.Timestamp;
import java.util.Objects;

import static jakarta.persistence.CascadeType.*;

@Entity
@Table(name = "agreements")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Agreement {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "account_Id")
    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {MERGE, PERSIST, REFRESH})
    private Account account;

    @JoinColumn(name = "product_Id")
    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {MERGE, PERSIST, REFRESH})
    private Product product;

    @Column(name = "interest_Rate")
    private double interestRate;

    @Column(name = "status")
    private int status;

    @Column(name = "sum")
    private double sum;

    @Column(name = "created_At")
    private Timestamp createdAt;

    @Column(name = "updated_At")
    private Timestamp updatedAt;

    @Override
    public String toString() {
        return "Agreement{" +
                "id=" + id +
                ", accountId=" + account +
                ", productId=" + product +
                ", interestRate=" + interestRate +
                ", status=" + status +
                ", sum=" + sum +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Agreement agreement = (Agreement) o;
        return id == agreement.id && account == agreement.account && product == agreement.product;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, account, product);
    }
}

