package ua.com.shede.airtickets.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@NoArgsConstructor
@Table(name = "message")
public class Message {
    @Id
    private Long id;
    private String data;

    public Message(String data) {
        this.data = data;
    }
}
