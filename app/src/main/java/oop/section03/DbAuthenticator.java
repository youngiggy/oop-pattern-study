package oop.section03;

public class DbAuthenticator extends Authenticator {
    @Override
    protected boolean doAuthenticate(String id, String pw) {
        //Ldap과 다른 인증 실패 케이스를 추가하기 위한 인위적인 코드
        return ! (pw.length() == 0);
    }
}
