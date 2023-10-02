package org.example.data_base_entities;

import jakarta.persistence.*;

@Table(name ="resident_role")
@Entity
public class ResidentRole {
    @EmbeddedId
    private ResidentRoleId residentRoleId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "resident_id")
    Osbb osbb;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id")
    Role role;

}
