package ua.com.shede.airtickets.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Passenger {
    private Long id;
    private String passengerName;
    private int passengerAge;
    private String gender;
    private Long customerId;
}
