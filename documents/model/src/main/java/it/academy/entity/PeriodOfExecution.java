package it.academy.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Entity
@Table(name = "T_PERIOD_OF_EXECUTION")
@AllArgsConstructor
@NoArgsConstructor
public class PeriodOfExecution {
    @Id
    @Column(name = "P_PERIOD_OF_EXECUTION_ID")
    @GeneratedValue(generator = "uuid-generator")
    @GenericGenerator(name = "uuid-generator", strategy = "uuid")
    private String periodOfExecutionId;

    @Column(name = "P_PERIOD_OF_EXECUTION")
    private Long periodOfExecution;
}
