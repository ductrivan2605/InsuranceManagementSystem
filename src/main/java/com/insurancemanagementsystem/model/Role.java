package com.insurancemanagementsystem.model;

import java.util.Arrays;
//import java.util.List;

public enum Role {
    SYSTEM_ADMIN,
    INSURANCE_MANAGER,
    INSURANCE_SURVEYOR,
    DEPENDENT,
    POLICY_HOLDER,
    POLICY_OWNER,
<<<<<<< Updated upstream
    USER;  // Add USER role here
=======
    USER;
>>>>>>> Stashed changes

    public boolean contains(Role role) {
        return Arrays.asList(Role.values()).contains(role);
    }
}