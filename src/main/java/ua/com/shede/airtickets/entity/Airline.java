package ua.com.shede.airtickets.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Airline {
    private Long id;
    private String airlineName;
    private String contactNumber;
    private String airlineWebsite;
}
