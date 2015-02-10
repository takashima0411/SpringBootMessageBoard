package sample.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Data
public class Board {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @Size(max = 30,min = 1)
    private String title;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "board")
    private List<Message> messages;

}
