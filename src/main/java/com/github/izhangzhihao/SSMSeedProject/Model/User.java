package com.github.izhangzhihao.SSMSeedProject.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

import static java.util.stream.Collectors.toList;


@ToString
@AllArgsConstructor
@NoArgsConstructor
public final class User implements UserDetails {

    private static final long serialVersionUID = 4050428243965732995L;

    @Getter
    @Setter
    private String username;

    @Setter
    private String passWord;

    @Getter
    @Setter
    private List<Role> roles;

    @Getter
    @Setter
    private boolean isAccountExpired;

    @Getter
    @Setter
    private boolean isLocked;

    @Getter
    @Setter
    private boolean isCredentialsExpired;

    @Getter
    @Setter
    private Address address;

    public User(String userName) {
        this.username = userName;
    }

    /**
     * Returns the authorities granted to the user. Cannot return <code>null</code>.
     *
     * @return the authorities, sorted by natural key (never <code>null</code>)
     */
    @JsonIgnore
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles
                .stream()
                .map(role -> new SimpleGrantedAuthority(role.getRoleName()))
                .collect(toList());
    }

    /**
     * Returns the password used to authenticate the user.
     *
     * @return the password
     */
    @JsonIgnore
    @Override
    public String getPassword() {
        return passWord;
    }

    /**
     * Indicates whether the user's account has expired. An expired account cannot be
     * authenticated.
     *
     * @return <code>true</code> if the user's account is valid (ie non-expired),
     * <code>false</code> if no longer valid (ie expired)
     */
    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return !this.isAccountExpired;
    }

    /**
     * Indicates whether the user is locked or unlocked. A locked user cannot be
     * authenticated.
     *
     * @return <code>true</code> if the user is not locked, <code>false</code> otherwise
     */
    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return !this.isLocked;
    }

    /**
     * Indicates whether the user's credentials (password) has expired. Expired
     * credentials prevent authentication.
     *
     * @return <code>true</code> if the user's credentials are valid (ie non-expired),
     * <code>false</code> if no longer valid (ie expired)
     */
    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return !this.isCredentialsExpired;
    }

    /**
     * Indicates whether the user is enabled or disabled. A disabled user cannot be
     * authenticated.
     *
     * @return <code>true</code> if the user is enabled, <code>false</code> otherwise
     */
    @JsonIgnore
    @Override
    public boolean isEnabled() {
        return !this.isLocked;
    }
}