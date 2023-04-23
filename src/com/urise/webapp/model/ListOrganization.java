package com.urise.webapp.model;

import java.util.List;
import java.util.Objects;

public class ListOrganization extends Section{
    private final List<Organization> list;

    public ListOrganization(List<Organization> list) {
        Objects.requireNonNull(list, "List must not be null");
        this.list = list;
    }
    public List<Organization> getList() {
        return list;
    }

    @Override
    public String toString() {
        return list.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ListOrganization that = (ListOrganization) o;

        return list.equals(that.list);
    }

    @Override
    public int hashCode() {
        return list.hashCode();
    }
}
