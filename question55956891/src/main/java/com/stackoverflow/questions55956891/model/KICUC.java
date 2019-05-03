package com.stackoverflow.questions55956891.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.util.LinkedList;
import java.util.List;

@Setter
@Getter
@XmlAccessorType(XmlAccessType.FIELD)
@EqualsAndHashCode
public class KICUC {
    @XmlElement(name = "R_CAT_NAME")
    private String rCatName;

    @XmlElement(name = "Employees")
    private List<Employee> employees = new LinkedList<>();

    @XmlElement(name = "params")
    private Params params;
}
