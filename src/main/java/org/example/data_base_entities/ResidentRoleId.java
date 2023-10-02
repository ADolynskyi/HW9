package org.example.data_base_entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ResidentRoleId implements Serializable {
    public ResidentRoleId(){}
    public ResidentRoleId(long roleId, long residentId) {
        this.roleId = roleId;
        this.residentId = residentId;
    }

    @Column(name = "role_id")
    private long roleId;
    @Column(name="resident_id")
    private long residentId;

    public long getRoleId() {
        return roleId;
    }

    public long getResidentId() {
        return residentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResidentRoleId that = (ResidentRoleId) o;
        return roleId == that.roleId && residentId == that.residentId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleId, residentId);
    }
}
