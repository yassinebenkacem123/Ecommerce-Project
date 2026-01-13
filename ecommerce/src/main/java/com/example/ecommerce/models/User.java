package com.example.ecommerce.models;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="users", uniqueConstraints = {
    @UniqueConstraint(columnNames = "username"),
    @UniqueConstraint(columnNames = "email")
})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @NotBlank(message =  "User name required.")
    @Size(min=3,max = 50, message = "Username must be between 3 and 50 characters")

    private String username;

    @NotBlank(message = "You must provide an email.")
    @Email(message = "Enter a valid email.")
    @Size(max=50)
    private String email;
    
    @NotBlank(message = "You must provide a password.")
    @Size(max=50)
    private String password;

    @ManyToMany(
        cascade = {CascadeType.PERSIST, CascadeType.MERGE},
        fetch = FetchType.EAGER
    )
    @JoinTable(
        name = "user_adress",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns =  @JoinColumn(name = "adress_id")
    )
    Set<Adress> userAdresses = new HashSet<>();

    @ManyToMany(
        cascade = {CascadeType.PERSIST, CascadeType.MERGE},
        fetch = FetchType.EAGER
    )
    @JoinTable(
        name = "user_role",
        joinColumns =  @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    Set<Role> userRoles = new HashSet<>();

    @ToString.Exclude
    @OneToMany(
        mappedBy = "user",
        cascade = {CascadeType.MERGE, CascadeType.PERSIST},
        orphanRemoval = true
    )
    @JsonIgnore
    private Set<Product> sellerProducts = new HashSet<>();
    

}
