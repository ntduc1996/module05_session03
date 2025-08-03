package ra.session03_btvn.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Admin {
    private int id;
    private String username;
    private String password;

    public Admin(String username, String password) {
    }
}
