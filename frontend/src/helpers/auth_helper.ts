import { UserManager } from "oidc-client-ts";

const settings = {
  authority: "http://localhost:8181/realms/chatapp/",
  client_id: "frontend",
  // redirect_uri: "http://localhost:5173/signin-callback",
  redirect_uri: "http://localhost:5173/signin-callback",
  response_type: "code",
  scope: "openid profile",
  automaticSilentRenew: false,
  monitorSession: false,
};

export const userManager = new UserManager(settings);

export const getUser = () => {
  return userManager.getUser();
};

export const login = () => {
  return userManager.signinRedirect();
};

export const logout = () => {
  return userManager.signoutRedirect();
};
