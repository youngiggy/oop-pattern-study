package oop.section03;

public class LdapAuthenticator extends Authenticator {
    @Override
    protected boolean doAuthenticate(String id, String pw) {
        //Db와 다른 인증 실패 케이스를 추가하기 위한 인위적인 코드
        return ! (pw == null);
    }
}
