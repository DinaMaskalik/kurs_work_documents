package it.academy.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Entity
@Table(name = "T_AUTHOR")
@AllArgsConstructor
@NoArgsConstructor
public class Author {
    @Id
    @Column(name = "A_AUTHOR_ID")
    @GeneratedValue(generator = "uuid-generator")
    @GenericGenerator(name = "uuid-generator", strategy = "uuid")
    private String authorId;

    @Column(name = "A_AUTHOR")
    private String author;
}
