package edu.utl.rubenRamos.lasPalmasSystem.entity.model;

public final class UserSession {

    private static UserSession instance;

    private String userName;
    private String privileges;
    private Usuario usuario;

    private UserSession(Usuario usuario) {
        this.usuario = usuario;
        this.userName = usuario.getUsuario();
        this.privileges = usuario.getPrivilegios();
    }

    public static UserSession getInstace(Usuario usuario) {
        if (instance == null) {
            instance = new UserSession(usuario);
        }
        return instance;
    }

    public void cleanUserSession() {
        usuario = null;
        userName = null;
        privileges = null;
    }

    @Override
    public String toString() {
        return "UserSession{" +
                "userName='" + userName + '\'' +
                ", privileges=" + privileges +
                '}';
    }
}