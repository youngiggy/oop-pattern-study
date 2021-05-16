package oop.section03;

public abstract class Authenticator {
    public Auth createAuth(String id, String pw) {
        if (! doAuthenticate(id, pw)) {
            throw new AuthException();
        }
        return new Auth(id);
    }

    protected abstract boolean doAuthenticate(String id, String pw);
}
