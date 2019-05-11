package com.stackoverflow.questions;

public class EmployeeBuilder {
    private ICExt.Employee instance;

    private EmployeeBuilder() {
        instance = new ICExt.Employee();
    }

    public static EmployeeBuilder newInstance() {
        return new EmployeeBuilder();
    }

    public ICExt.Employee build() {
        return instance;
    }

    public EmployeeBuilder emplRec() {
        instance.setEmplRec(new ICExt.EmplRec());
        return this;
    }

    public EmployeeBuilder empId(String value) {
        instance.getEmplRec().setEmpId(value);
        return this;
    }

    public EmployeeBuilder salary(String value) {
        instance.getEmplRec().setSalary(value);
        return this;
    }
}
