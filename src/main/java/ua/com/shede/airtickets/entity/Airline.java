package ua.com.shede.airtickets.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "airlines")
public class Airline {
    @Id
    private Long id;
    private String airlineName;
    private String contactNumber;
    private String airlineWebsite;
}
