package it.academy.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
@Table(name = "T_DOCUMENT")
@AllArgsConstructor
@NoArgsConstructor
public class Document {

    @Id
    @Column(name = "D_DOCUMENT_ID")
    @GeneratedValue(generator = "uuid-generator")
    @GenericGenerator(name = "uuid-generator", strategy = "uuid")
    private String documentId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "D_DOCUMENT_NAME")
    private DocumentName documentName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "D_CONTENT")
    private Content content;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "D_AUTHOR")
    private Author author;

    @Column(name = "D_CREATE_DATE")
    private Date createDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "D_PERSON_WITH_WHOM_THE_CONTRACT_WAS_SIGNED")
    private PersonWithWhomTheContractWasSigned personWithWhomTheContractWasSigned;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "D_PERSON_WHO_CONCLUDED_CONTRACT")
    private PersonWhoConcludedContract personWhoConcludedContract;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "D_PERIOD_OF_EXECUTION")
    private PeriodOfExecution periodOfExecution;
}
