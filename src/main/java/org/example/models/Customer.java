package org.example.models;

import java.util.List;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.models.account.Account;
import org.example.valueobjects.Address;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;
    @Embedded
    private Address address;
    private String phoneNo;
    private int acctNo;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Account> accounts;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL,
        orphanRemoval = true)
    private List<Loan> loans;

    @ManyToOne
    @JoinColumn(name = "bank_id")
    private Bank bank;

    @OneToMany(mappedBy = "customer")
    private List<CustomerTeller> tellers;
}
