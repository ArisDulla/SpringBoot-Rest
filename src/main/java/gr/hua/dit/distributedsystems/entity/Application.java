package gr.hua.dit.distributedsystems.entity;

import javax.persistence.*;
import java.util.Arrays;

@Entity
@Table(name = "application")
public class Application {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "enabled")
    private boolean enabled;

    @Column(name = "enabled2")
    private boolean enabled2;

    @Column(name = "info" )
    private String info;

    public Application() {
    }

    public Application(String firstName, String lastName, String email, boolean enabled2,boolean enabled , String info) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.enabled2 = enabled2;
        this.info = info;
        this.enabled=enabled;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }


    @Lob
    private byte[] data;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Application{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", enabled=" + enabled +
                ", enabled2=" + enabled2 +
                ", info='" + info + '\'' +
                ", data=" + Arrays.toString(data) +
                '}';
    }

    public boolean isEnabled() {
        return enabled;
    }
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isEnabled2() {
        return enabled2;
    }
    public void setEnabled2(boolean enabled2) {
        this.enabled2 = enabled2;
    }


    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
}