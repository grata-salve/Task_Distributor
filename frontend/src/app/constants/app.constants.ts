export const API_BASE_URL = 'http://localhost:8080'

// OAuth URLs
export const OAUTH2_REDIRECT_URI = 'http://localhost:4200/oauth2/redirect'
export const GOOGLE_AUTH_URL = API_BASE_URL + '/oauth2/authorize/google?redirect_uri=' + OAUTH2_REDIRECT_URI
export const FACEBOOK_AUTH_URL = API_BASE_URL + '/oauth2/authorize/facebook?redirect_uri=' + OAUTH2_REDIRECT_URI
export const GITHUB_AUTH_URL = API_BASE_URL + '/oauth2/authorize/github?redirect_uri=' + OAUTH2_REDIRECT_URI

// Cookies
export const COOKIE_EXPIRY_DAYS = 1
export const ACCESS_TOKEN = 'accessToken'

// Storage
export const USER = 'user'
