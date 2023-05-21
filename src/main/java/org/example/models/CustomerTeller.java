package org.example.models;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.models.Customer;
import org.example.models.Teller;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CustomerTeller {
    @EmbeddedId
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @EmbeddedId
    @ManyToOne
    @JoinColumn(name = "teller_id")
    private Teller teller;
}
