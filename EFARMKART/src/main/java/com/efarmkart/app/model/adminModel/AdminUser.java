package com.efarmkart.app.model.adminModel;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

import org.apache.catalina.AccessLog;

import com.efarmkart.app.enumuration.Role;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AdminUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private String email;
    private boolean isActive;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Role role;

    @OneToMany(mappedBy = "adminUser", cascade = CascadeType.ALL)
    private List<com.efarmkart.app.model.adminModel.AccessLog> accessLogs;
}