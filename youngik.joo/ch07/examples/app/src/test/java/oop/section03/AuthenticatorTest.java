package oop.section03;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AuthenticatorTest {
    @Test
    void canCreateLdapAuthenticatorAuth() {
        LdapAuthenticator sut = new LdapAuthenticator();
        sut.createAuth("testId", "testPw");
    }

    @Test
    void canCreateDbAuthenticatorAuth() {
        DbAuthenticator sut = new DbAuthenticator();
        sut.createAuth("testId", "testPw");
    }

    @Test
    void throwsIfUnavailableOnLdapAuthenticator() {
        LdapAuthenticator sut = new LdapAuthenticator();
        assertThrows(AuthException.class, () -> sut.createAuth("testId", null));
    }

    @Test
    void throwsIfUnavailableOnDbAuthenticator() {
        DbAuthenticator sut = new DbAuthenticator();
        assertThrows(AuthException.class, () -> sut.createAuth("testId", ""));
    }
}
