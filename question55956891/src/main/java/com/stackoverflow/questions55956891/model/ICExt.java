package com.stackoverflow.questions55956891.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ICExt")
@XmlAccessorType(XmlAccessType.FIELD)
@EqualsAndHashCode
@Setter
@Getter
@ToString
public class ICExt {
    @XmlElement(name = "AA")
    private AA aa;
}
