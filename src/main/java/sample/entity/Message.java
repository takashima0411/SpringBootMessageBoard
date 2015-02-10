package sample.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Data
public class Message {

    @Id
    @GeneratedValue
    private long id;

    @NotNull
    @Size(max = 250,min = 1)
    private String body;

    @ManyToOne(targetEntity = Board.class)
    private Board board;
}
