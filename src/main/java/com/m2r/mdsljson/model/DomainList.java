package com.m2r.mdsljson.model;

import java.util.ArrayList;
import java.util.List;

public class DomainList {

    private List<Domain> domains = new ArrayList<>();

    public DomainList() {
    }

    public DomainList(List<Domain> domains) {
        this.domains = domains;
    }

    public List<Domain> getDomains() {
        return domains;
    }

    public void setDomains(List<Domain> domains) {
        this.domains = domains;
    }

    @Override
    public String toString() {
        return String.format("{\"domains\": %s}", domains.toString());
    }

}
