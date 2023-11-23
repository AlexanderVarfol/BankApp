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

    @JoinColumn(name = "account_id")
    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {MERGE, PERSIST, REFRESH})
    private Account account;

    @JoinColumn(name = "product_id")
    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {MERGE, PERSIST, REFRESH})
    private Product product;

    @Column(name = "interest_rate")
    private double interestRate;

    @JoinColumn(name = "argement_status")
    @Enumerated(EnumType.STRING)
    private int status;

    @Column(name = "agreement_sum")
    private double sum;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "updated_at")
    private Timestamp updatedAt;

    @Override
    public String toString() {
        return "Agreement{" +
                "id=" + id +
                ", account=" + account +
                ", product=" + product +
                ", interestRate=" + interestRate +
                ", agreement_status=" + agreement_status +
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
        return id == agreement.id && Double.compare(interestRate, agreement.interestRate) == 0 && agreement_status == agreement.agreement_status && Double.compare(sum, agreement.sum) == 0 && Objects.equals(account, agreement.account) && Objects.equals(product, agreement.product) && Objects.equals(createdAt, agreement.createdAt) && Objects.equals(updatedAt, agreement.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, account, product, interestRate, agreement_status, sum, createdAt, updatedAt);
    }
}


