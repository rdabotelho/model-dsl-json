package com.m2r.mdsljson.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Domain {
    private String type;
    private String name;
    private Boolean isEntity;
    private Boolean isEnum;
    private Map<String, String> params = new HashMap<>();
    private List<DomainAttribute> attributes = new ArrayList<>();

    public Domain() {
    }

    public Domain(String type, String name, Boolean isEntity, Boolean isEnum) {
        this.type = type;
        this.name = name;
        this.isEntity = isEntity;
        this.isEnum = isEnum;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getEntity() {
        return isEntity;
    }

    public void setEntity(Boolean entity) {
        isEntity = entity;
    }

    public Boolean getEnum() {
        return isEnum;
    }

    public void setEnum(Boolean anEnum) {
        isEnum = anEnum;
    }

    public Map<String, String> getParams() {
        return params;
    }

    public void setParams(Map<String, String> params) {
        this.params = params;
    }

    public List<DomainAttribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<DomainAttribute> attributes) {
        this.attributes = attributes;
    }

    @Override
    public String toString() {
        return String.format("{\"type\":\"%s\",\"name\":\"%s\",\"isEntity\":\"%s\",\"isEnum\":\"%s\",\"params\":%s,\"attributes\":%s}",
                    (type != null ? type : ""),
                    (name != null ? name : ""),
                    (isEntity != null ? isEntity : ""),
                    (isEnum != null ? isEnum : ""),
                    (!params.isEmpty() ? params.entrySet().stream().map(it -> String.format("\"%s\":\"%s\"", it.getKey(), it.getValue()))
                            .reduce((b,a) -> b + "," + a )
                            .map(it -> "{" + it + "}")
                            .get(): "{}"),
                    (attributes != null ? attributes : "[]")
                );
    }

}
