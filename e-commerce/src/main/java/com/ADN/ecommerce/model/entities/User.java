package com.ADN.ecommerce.model.entities;

import com.ADN.ecommerce.security.enums.Role;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Table
@Entity
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private String password;

    @OneToMany(mappedBy = "user")
    private List<Purchase> pruchases;

    @OneToMany(mappedBy = "reseller")
    private List<Purchase> sellings;
    
    /*@ManyToOne
    @JoinColumn(name = "rol_id")
    private Rol rol;
    */
    
    @Enumerated(EnumType.STRING)
    private Role role;

}
