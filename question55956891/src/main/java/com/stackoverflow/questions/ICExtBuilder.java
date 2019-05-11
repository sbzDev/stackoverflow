package com.stackoverflow.questions55956891;

import java.util.Date;

public class ICExtBuilder {

    private ICExt instance;

    private ICExtBuilder() {
        instance = new ICExt();
    }

    public static ICExtBuilder newInstance() {
        return new ICExtBuilder();
    }

    public ICExt build() {
        return instance;
    }

    public ICExtBuilder aa() {
        instance.setAa(new ICExt.AA());
        return this;
    }

    public ICExtBuilder pa1(String value) {
        instance.getAa().setPa1(value);
        return this;
    }

    public ICExtBuilder pa2() {
        instance.getAa().setPa2(new ICExt.PA2());
        return this;
    }

    public ICExtBuilder ffgag() {
        instance.getAa().getPa2().setFfgag(new ICExt.FFGAG());
        return this;
    }

    public ICExtBuilder kicuc() {
        instance.getAa().getPa2().getFfgag().setKicuc(new ICExt.KICUC());
        return this;
    }

    public ICExtBuilder rCatName(String value) {
        instance
                .getAa()
                    .getPa2()
                        .getFfgag()
                            .getKicuc()
                                .setRCatName(value);
        return this;
    }

    public ICExtBuilder params() {
        instance.getAa().getPa2().getFfgag().getKicuc().setParams(new ICExt.Params());
        return this;
    }

    public ICExtBuilder repCatId(String value) {
        instance.getAa().getPa2().getFfgag().getKicuc().getParams().setRepCatId(value);
        return this;
    }

    public ICExtBuilder reqId(String value) {
        instance.getAa().getPa2().getFfgag().getKicuc().getParams().setReqId(value);
        return this;
    }

    public ICExtBuilder fName(String value) {
        instance.getAa().getPa2().getFfgag().getKicuc().getParams().setFName(value);
        return this;
    }

    public ICExtBuilder endDate(Date value) {
        instance.getAa().getPa2().getFfgag().getKicuc().getParams().setEndDate(value);
        return this;
    }

    public ICExtBuilder emploee(ICExt.Employee value) {
        instance.getAa().getPa2().getFfgag().getKicuc().getEmployees().add(value);
        return this;
    }

    public ICExtBuilder lDataGroupId(String value) {
        instance.getAa().getPa2().getFfgag().getKicuc().getParams().setLDataGroupId(value);
        return this;
    }

    public ICExtBuilder acParamGroupId(String value) {
        instance.getAa().getPa2().getFfgag().getKicuc().getParams().setAcParamGroupId(value);
        return this;
    }
}
