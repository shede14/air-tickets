package ua.com.shede.airtickets.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Table(name = "roles_has_customers")
public class RolesHasCustomers {
    @Id
    private Long id;

    private Long role_id;
    private Long customer_id;
}
