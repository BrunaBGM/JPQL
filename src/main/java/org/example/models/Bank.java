package org.example.models;

import jakarta.persistence.*;
import lombok.*;
import org.example.models.account.Savings;
import org.example.valueobjects.Location;
import org.hibernate.annotations.GenericGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@Entity
public class Bank {

    @Id
    //@GeneratedValue(strategy = GenerationType.UUID)
    //@Column(name = "id", updatable = false, unique = true, nullable = false)

    //@GeneratedValue(generator = "uuid2")
    //@GenericGenerator(name = "uuid2", strategy = "uuid2")
    //@Column(columnDefinition = "BINARY(16)")

    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String name;
    @Embedded
    private Location location;

    @OneToMany(mappedBy = "bank", fetch = FetchType.LAZY)
    private List<Customer> customers;

    @OneToMany(mappedBy = "bank", fetch = FetchType.LAZY)
    private List<Teller> tellers;

    public Bank(String name) {
        this.name = name;
    }
}
