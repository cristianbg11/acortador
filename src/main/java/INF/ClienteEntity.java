package INF;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "CLIENTE", schema = "PUBLIC", catalog = "ACORTADOR")
public class ClienteEntity {
    private int id;
    private String navegador;
    private String ip;
    private String sistema;
    private Date fecha;
    private UsuarioEntity usuarioByUsuarioId;
    private UrlEntity urlByUrlId;

    @Id
    @Column(name = "ID", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "NAVEGADOR", nullable = true, length = 80)
    public String getNavegador() {
        return navegador;
    }

    public void setNavegador(String navegador) {
        this.navegador = navegador;
    }

    @Basic
    @Column(name = "IP", nullable = true, length = 50)
    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @Basic
    @Column(name = "SISTEMA", nullable = true, length = 100)
    public String getSistema() {
        return sistema;
    }

    public void setSistema(String sistema) {
        this.sistema = sistema;
    }

    @Basic
    @Column(name = "FECHA", nullable = true)
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClienteEntity that = (ClienteEntity) o;
        return id == that.id &&
                Objects.equals(navegador, that.navegador) &&
                Objects.equals(ip, that.ip) &&
                Objects.equals(sistema, that.sistema) &&
                Objects.equals(fecha, that.fecha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, navegador, ip, sistema, fecha);
    }

    @ManyToOne
    @JoinColumn(name = "USUARIO_ID", referencedColumnName = "ID")
    public UsuarioEntity getUsuarioByUsuarioId() {
        return usuarioByUsuarioId;
    }

    public void setUsuarioByUsuarioId(UsuarioEntity usuarioByUsuarioId) {
        this.usuarioByUsuarioId = usuarioByUsuarioId;
    }

    @ManyToOne
    @JoinColumn(name = "URL_ID", referencedColumnName = "ID")
    public UrlEntity getUrlByUrlId() {
        return urlByUrlId;
    }

    public void setUrlByUrlId(UrlEntity urlByUrlId) {
        this.urlByUrlId = urlByUrlId;
    }
}
