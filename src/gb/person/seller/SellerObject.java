package com.company.gb.person.seller;

import java.util.Objects;

public class SellerObject {
    private final String name;
    private final String lastName;

    public SellerObject(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    public String name() {
        return name;
    }

    public String lastName() {
        return lastName;
    }

    @Override public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        SellerObject other = (SellerObject) obj;
        return Objects.equals(name, other.name) && Objects.equals(lastName, other.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, lastName);
    }
}