package it.academy.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Entity
@Table(name = "T_PERSON_WHO_CONCLUDED_CONTRACT")
@AllArgsConstructor
@NoArgsConstructor
public class PersonWhoConcludedContract {
    @Id
    @Column(name = "P_PERSON_WHO_CONCLUDED_CONTRACT_ID")
    @GeneratedValue(generator = "uuid-generator")
    @GenericGenerator(name = "uuid-generator", strategy = "uuid")
    private String personWhoConcludedContractId;

    @Column(name = "P_PERSON_WHO_CONCLUDED_CONTRACT")
    private String personWhoConcludedContract;
}
