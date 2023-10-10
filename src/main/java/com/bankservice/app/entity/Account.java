package com.bankservice.app.entity;

import com.bankservice.app.entity.enums.AccountType;
import com.bankservice.app.entity.enums.CurrencyCode;
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
@Table(name = "accounts")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    @Id
    @Column(name= "id" )
    private int id;

    @Column(name = "account_name")
    private String name;

    @Column(name = "account_type")
    private AccountType type;

    @Column(name = "account_status")
    private boolean status;

    @Column(name = "balance")
    private double balance;

    @Column(name = "currency_code")
    private CurrencyCode currencyCode; //

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "updated_at")
    private Timestamp updatedAt;

    @OneToOne(cascade = {MERGE, PERSIST, REFRESH})
    @JoinColumn(name = "client_id" , referencedColumnName = "id")
    private Client client;

    @OneToMany(mappedBy = "account", fetch = FetchType.LAZY,
            orphanRemoval = true, cascade = {MERGE, PERSIST, REFRESH})
    private List<Agreement> agreementList;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return id == account.id && client == account.client;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, client);
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", client_id=" + client +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", status=" + status +
                ", balance=" + balance +
                ", currencyCode=" + currencyCode +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}