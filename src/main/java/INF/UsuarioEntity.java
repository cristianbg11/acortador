package INF;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "USUARIO", schema = "PUBLIC", catalog = "ACORTADOR")
public class UsuarioEntity {
    public int id;
    public String nombre;
    public String username;
    public String password;
    public Boolean administrador;
    public Collection<ClienteEntity> clientesById;

    public UsuarioEntity() {

    }

    public UsuarioEntity(int i, String cristian, String admin, String s, boolean b) {
    }

    @Id
    @Column(name = "ID", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "NOMBRE", nullable = true, length = 50)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Basic
    @Column(name = "USERNAME", nullable = true, length = 50)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "PASSWORD", nullable = true, length = 50)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "ADMINISTRADOR", nullable = true)
    public Boolean getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Boolean administrador) {
        this.administrador = administrador;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsuarioEntity that = (UsuarioEntity) o;
        return id == that.id &&
                Objects.equals(nombre, that.nombre) &&
                Objects.equals(username, that.username) &&
                Objects.equals(password, that.password) &&
                Objects.equals(administrador, that.administrador);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, username, password, administrador);
    }

    @OneToMany(mappedBy = "usuarioByUsuarioId", cascade = CascadeType.ALL)
    public Collection<ClienteEntity> getClientesById() {
        return clientesById;
    }

    public void setClientesById(Collection<ClienteEntity> clientesById) {
        this.clientesById = clientesById;
    }
}
