package com.stackoverflow.questions55956891.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.util.Date;

@Setter
@Getter
@XmlAccessorType(XmlAccessType.FIELD)
@EqualsAndHashCode
public class Params {
    @XmlElement(name = "req_id")
    private String reqId;

    @XmlElement(name = "sdate")
    private Date startDate;

    @XmlElement(name = "rep_cat_id")
    private String repCatId;

    @XmlElement(name = "ldata_group_id")
    private String lDataGroupId;

    @XmlElement(name = "ac_param_group_id")
    private String acParamGroupId;

    @XmlElement(name = "edate")
    private Date endDate;

    @XmlElement(name = "FNAME")
    private String fName;
}
