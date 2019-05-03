package com.stackoverflow.questions55956891.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@Setter
@Getter
@XmlAccessorType(XmlAccessType.FIELD)
@EqualsAndHashCode
public class PA2 {
    @XmlElement(name = "FFGAG")
    private FFGAG ffgag;
}
