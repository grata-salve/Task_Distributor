import {environment} from "../../environments/environment";

export class AppConstants {
  private static OAUTH2_URL = `${environment.apiBaseUrl}/oauth2/authorization/`;
  private static REDIRECT_URL = "?redirect_uri=http://localhost:8081/login";
  public static GOOGLE_AUTH_URL = AppConstants.OAUTH2_URL + "google" + AppConstants.REDIRECT_URL;
  public static FACEBOOK_AUTH_URL = AppConstants.OAUTH2_URL + "facebook" + AppConstants.REDIRECT_URL;
}
