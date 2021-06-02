package it.academy.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Table(name = "T_DOCUMENT_NAME")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class DocumentName {

    @Id
    @Column(name = "DN_DOCUMENT_NAME_ID")
    @GeneratedValue(generator = "uuid-generator")
    @GenericGenerator(name = "uuid-generator", strategy = "uuid")
    private String documentNameId;

    @Column(name = "DN_DOCUMENT_NAME")
    private String documentName;
}
