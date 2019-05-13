package com.stackoverflow.questions;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.util.List;

@XStreamAlias("root")
public class Root {

    String notes;

    @XStreamAlias("category_alpha")
    CategoryAlpha categoryAlpha;


    @XStreamAlias("category_beta")
    List<C> listC;

    static class CategoryAlpha {

        @XStreamAlias("list_a")
        List<A> listA;

        @XStreamAlias("list_b")
        List<B> listB;
    }

    @XStreamAlias("class_a_object")
    static class A {
    }

    @XStreamAlias("class_b_object")
    static class B {
    }

    @XStreamAlias("class_c_object")
    static class C {
    }
}
