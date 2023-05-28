import {environment} from "../../environments/environment";

export class AppConstants {
  private static OAUTH2_URL = `${environment.apiBaseUrl}/oauth2/authorization/`;
  private static REDIRECT_URL = "?redirect_uri=http://localhost:8081/login";

  private static google = environment.apiBaseUrl + "/oauth2/authorize/google?redirect_uri=" +
    "http://localhost:3000/oauth2/redirect"

  public static GOOGLE_AUTH_URL = environment.apiBaseUrl + "/oauth2/authorize/google?redirect_uri=" +
    "http://localhost:4200/oauth2/redirect"
  public static FACEBOOK_AUTH_URL = AppConstants.OAUTH2_URL + "facebook" + AppConstants.REDIRECT_URL;
}
