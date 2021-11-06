package com.example.predavanjademo.entities;

import com.example.predavanjademo.converters.Type1Converter;
import com.example.predavanjademo.converters.VoltageLevelConverter;
import com.example.predavanjademo.enums.*;
import com.example.predavanjademo.mappers.SubstationMapper;
import com.example.predavanjademo.services.SubstationService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Table(name = "interruption")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Interruption {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;

        @Column(name = "voltage")
        @Convert(converter = VoltageLevelConverter.class)
        private VoltageLevel voltageLevel;

        @Column(name = "interrupt_number")
        private Integer interruptionNumber;

        @ManyToOne
        @JoinColumn(name = "substation_id")
        private Substation substation;

        @Column(name = "number_of_customers")
        private Integer numberOfCustomers;

        @Column
        @Convert(converter = Type1Converter.class)
        private Type1 type1;

        @Column
        @Enumerated(EnumType.STRING)
        private Type2 type2;

        @Column
        @Enumerated(EnumType.STRING)
        private Type3 type3;

        @Column
        @Enumerated(EnumType.STRING)
        private Type4 type4;

        @Column(name = "failure_object")
        private String failureObject;

        @Column(name = "failure_protection")
        private String failureProtection;

        @Column(name = "cause_object")
        private String causeObject;

        @Column
        private Boolean cable;

        @Column
        private String description;

        @Column
        private String dispatch;

        @Column(name = "plan_beginning")
        @Temporal(TemporalType.TIMESTAMP)
        @DateTimeFormat(pattern = "dd-MM-yyyy hh:mm:ss")
        private Date planBeginning;

        @Column(name = "plan_end")
        @Temporal(TemporalType.TIMESTAMP)
        @DateTimeFormat(pattern = "dd-MM-yyyy hh:mm:ss")
        private Date planEnd;

        @Column(name = "realization_beginning")
        @Temporal(TemporalType.TIMESTAMP)
        @DateTimeFormat(pattern = "dd-MM-yyyy hh:mm:ss")
        private Date realizationBeginning;

        @Column(name = "realization_end")
        @Temporal(TemporalType.TIMESTAMP)
        @DateTimeFormat(pattern = "dd-MM-yyyy hh:mm:ss")
        private Date realizationEnd;

        @Column(name = "duration_before")
        private Long durationBefore;

        @Column(name="duration_after")
        private Long durationAfter;

        @Column(name="duration_unplanned")
        private Long durationUnplanned;

        @Column(name="duration_planned")
        private Long durationPlanned;

        @Column
        private Long duration;

        public Interruption(VoltageLevel voltageLevel, Integer interruptionNumber,
                            Substation substation, Integer numberOfCustomers, Type1 type1, Type2 type2, Type3 type3,
                            Type4 type4, String failureObject, String failureProtection, String causeObject,
                            Boolean cable, String description, String dispatch, Date planBeginning, Date planEnd,
                            Date realizationBeginning, Date realizationEnd, Long durationBefore, Long durationAfter,
                            Long durationPlanned, Long durationUnplanned, Long duration)
        {

                this.voltageLevel = voltageLevel;
                this.interruptionNumber = interruptionNumber;
                this.substation = substation;
                this.numberOfCustomers = numberOfCustomers;
                this.type1 = type1;
                this.type2 = type2;
                this.type3 = type3;
                this.type4 = type4;
                this.failureObject = failureObject;
                this.failureProtection = failureProtection;
                this.causeObject = causeObject;
                this.cable = cable;
                this.description = description;
                this.dispatch = dispatch;
                this.planBeginning = planBeginning;
                this.planEnd = planEnd;
                this.realizationBeginning = realizationBeginning;
                this.realizationEnd = realizationEnd;
                this.durationBefore = durationBefore;
                this.durationAfter = durationAfter;
                this.durationPlanned = durationPlanned;
                this.durationUnplanned = durationUnplanned;
                this.duration = duration;
        }




        @Override
        public String toString() {
                return "Interruption{" +
                        "id=" + id +
                        ", voltageLevel=" + voltageLevel +
                        ", interruptionNumber=" + interruptionNumber +
                        ", substation=" + substation +
                        ", numberOfCustomers=" + numberOfCustomers +
                        ", type1=" + type1 +
                        ", type2=" + type2 +
                        ", type3=" + type3 +
                        ", type4=" + type4 +
                        ", failureObject='" + failureObject + '\'' +
                        ", failureProtection='" + failureProtection + '\'' +
                        ", causeObject='" + causeObject + '\'' +
                        ", cable=" + cable +
                        ", description='" + description + '\'' +
                        ", dispatch='" + dispatch + '\'' +
                        ", planBeginning=" + planBeginning +
                        ", planEnd=" + planEnd +
                        ", realizationBeginning=" + realizationBeginning +
                        ", realizationEnd=" + realizationEnd +
                        ", durationBefore=" + durationBefore +
                        ", durationAfter=" + durationAfter +
                        ", durationUnplanned=" + durationUnplanned +
                        ", durationPlanned=" + durationPlanned +
                        ", duration=" + duration +
                        '}';
        }

}
