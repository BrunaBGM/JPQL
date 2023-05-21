package org.example.valueobjects;

import jakarta.persistence.Embeddable;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Embeddable
public class Address {
    private String ZipCode;
    private String Street;
    private String StreetNumber;
    private String City;
}
