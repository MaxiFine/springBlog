package com.maxBlog.BlogApp.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "_user", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class User  implements UserDetails {

    @Id
    @GeneratedValue
    private Integer id;

    private String firstname;
    private String lastname;
    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    /*
     Entity relationship for the user to be a foreign key in the
     BlogEntity and the CommentEntity
     so the "author" field here is what will be passed and
     referenced in other entities.
    */
    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private List<BlogEntity> blogEntities;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List
                .of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getUsername() {
        return email;  // using email as UserName
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override  // return user password
    public String getPassword(){ return password; }
}
