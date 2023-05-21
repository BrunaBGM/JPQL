package org.example.valueobjects;

import jakarta.persistence.Embeddable;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@Embeddable
public class Location {
    private String ZipCode;
    private String Street;
    private String StreetNumber;
    private String City;
}
