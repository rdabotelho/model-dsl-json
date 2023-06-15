package com.m2r.mdsljson.model;

import java.util.HashMap;
import java.util.Map;

public class DomainAttribute {

    private String type;
    private String name;
    private Boolean isBasic;
    private Boolean isEntity;
    private Boolean isEnum;
    private Boolean isList;
    private Boolean isOneToOne;
    private Boolean isOneToMany;
    private Boolean isManyToOne;
    private Boolean isManyToMany;
    private String parent;
    private Map<String, String> params = new HashMap<>();

    public DomainAttribute() {
    }

    public DomainAttribute(String type, String name, Boolean isBasic, Boolean isEntity, Boolean isEnum, Boolean isList, Boolean isOneToOne, Boolean isOneToMany, Boolean isManyToOne, Boolean isManyToMany, String parent) {
        this.type = type;
        this.name = name;
        this.isBasic = isBasic;
        this.isEntity = isEntity;
        this.isEnum = isEnum;
        this.isList = isList;
        this.isOneToOne = isOneToOne;
        this.isOneToMany = isOneToMany;
        this.isManyToOne = isManyToOne;
        this.isManyToMany = isManyToMany;
        this.parent = parent;
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

    public Boolean getBasic() {
        return isBasic;
    }

    public void setBasic(Boolean basic) {
        isBasic = basic;
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

    public Boolean getList() {
        return isList;
    }

    public void setList(Boolean list) {
        isList = list;
    }

    public Boolean getOneToOne() {
        return isOneToOne;
    }

    public void setOneToOne(Boolean oneToOne) {
        isOneToOne = oneToOne;
    }

    public Boolean getOneToMany() {
        return isOneToMany;
    }

    public void setOneToMany(Boolean oneToMany) {
        isOneToMany = oneToMany;
    }

    public Boolean getManyToOne() {
        return isManyToOne;
    }

    public void setManyToOne(Boolean manyToOne) {
        isManyToOne = manyToOne;
    }

    public Boolean getManyToMany() {
        return isManyToMany;
    }

    public void setManyToMany(Boolean manyToMany) {
        isManyToMany = manyToMany;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public Map<String, String> getParams() {
        return params;
    }

    public void setParams(Map<String, String> params) {
        this.params = params;
    }

    @Override
    public String toString() {
        return String.format("{\"type\":\"%s\",\"name\":\"%s\",\"isEntity\":\"%s\",\"isEnum\":\"%s\",\"isBasic\":\"%s\"," +
                        "\"isList\":\"%s\",\"isOneToOne\":\"%s\",\"isOneToMany\":\"%s\",\"isManyToOne\":\"%s\"," +
                        "\"isManyToMany\":\"%s\",\"parent\":\"%s\",\"params\":%s}",
                (type != null ? type : ""),
                (name != null ? name : ""),
                (isEntity != null ? isEntity : ""),
                (isEnum != null ? isEnum : ""),
                (isBasic != null ? isBasic : ""),
                (isList != null ? isList : ""),
                (isOneToOne != null ? isOneToOne : ""),
                (isOneToMany != null ? isOneToMany : ""),
                (isManyToOne != null ? isManyToOne : ""),
                (isManyToMany != null ? isManyToMany : ""),
                (parent != null ? parent : ""),
                (!params.isEmpty() ? params.entrySet().stream().map(it -> String.format("\"%s\":\"%s\"", it.getKey(), it.getValue()))
                        .reduce((b,a) -> b + "," + a )
                        .map(it -> "{" + it + "}")
                        .get(): "{}")
        );
    }

}
