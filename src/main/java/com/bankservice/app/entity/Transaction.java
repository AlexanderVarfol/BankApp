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
@Table(name = "transactions")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
    @Id
    @Column(name = "id")
    private int id;

    @JoinColumn(name = "debit_account_id")
    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {MERGE, PERSIST, REFRESH})
    private Account debitAccount;

    @JoinColumn(name = "credit_account_id")
    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {MERGE, PERSIST, REFRESH})
    private Account creditAccount;

    @Column(name = "type")
    private int type;

    @Column(name = "amount")
    private String amount;

    @Column(name = "description")
    private char description;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", debitAccount=" + debitAccount +
                ", creditAccount=" + creditAccount +
                ", type=" + type +
                ", amount='" + amount + '\'' +
                ", description=" + description +
                ", createdAt=" + createdAt +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return id == that.id && debitAccount == that.debitAccount && creditAccount == that.creditAccount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, debitAccount, creditAccount);
    }
}
