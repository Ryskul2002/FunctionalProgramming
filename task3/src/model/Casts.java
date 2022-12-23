package model;

import java.util.Objects;

public class Casts {
    private String fullName;
    private String role;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Casts casts = (Casts) o;
        return Objects.equals(fullName, casts.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, role);
    }

    @Override
    public String toString() {
        return "Casts{" +
                "fullName='" + fullName + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
