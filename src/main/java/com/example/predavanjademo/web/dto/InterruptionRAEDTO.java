package com.example.predavanjademo.web.dto;

import com.example.predavanjademo.enums.Type2;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InterruptionRAEDTO {
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy")
    private Date dateBeginning;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="hh:mm:ss")
    private Date timeBeginning;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy")
    private Date dateEnd;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="hh:mm:ss")
    private Date timeEnd;
    private Type2 type2;
    private Long durationTime;
    private Integer numberOfCustomers;
    private String causeObject;
    private Boolean cable;
}
