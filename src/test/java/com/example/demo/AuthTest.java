public class AuthTest {
    public static void main(String[] args) {
       Account.getAccountInformation(Authorize.getToken(Authorize.getAccessToken()));
    }
}
