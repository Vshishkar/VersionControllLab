package by.tc.vcl.dao.user.auth;

public class Authentication {

    public static boolean comparePasswords(String aPassword,String bPassword){
        return  aPassword.equals(bPassword);
    }

    public static boolean compareUsernames(String aUsername,String bUsername){
        return  aUsername.equals(bUsername);
    }

    private Authentication(){};

}
