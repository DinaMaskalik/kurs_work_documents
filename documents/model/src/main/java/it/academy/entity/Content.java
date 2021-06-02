package it.academy.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Entity
@Table(name = "T_CONTENT")
@AllArgsConstructor
@NoArgsConstructor
public class Content {

    @Id
    @Column(name = "C_CONTENT_ID")
    @GeneratedValue(generator = "uuid-generator")
    @GenericGenerator(name = "uuid-generator", strategy = "uuid")
    private String contentId;

    @Column(name = "C_CONTENT")
    private String content;
}
