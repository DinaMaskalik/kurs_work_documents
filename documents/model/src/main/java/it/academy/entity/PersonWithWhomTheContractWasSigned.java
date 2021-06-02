package it.academy.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Entity
@Table(name = "T_PERSON_WITH_WHOM")
@AllArgsConstructor
@NoArgsConstructor
public class PersonWithWhomTheContractWasSigned {
    @Id
    @Column(name = "P_PERSON_WITH_WHOM_ID")
    @GeneratedValue(generator = "uuid-generator")
    @GenericGenerator(name = "uuid-generator", strategy = "uuid")
    private String personWithWhomTheContractWasSignedId;

    @Column(name = "P_PERSON_WITH_WHOM")
    private String personWithWhomTheContractWasSigned;
}
