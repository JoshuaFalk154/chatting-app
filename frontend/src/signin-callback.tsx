import { useEffect } from "react";
import { userManager } from "./helpers/auth_helper";

export default function SigninCallback() {
  useEffect(() => {
    userManager.signinRedirectCallback().then(() => {
      window.location.href = "/";
    });
  }, []);

  return <div>Signing in...</div>;
}
