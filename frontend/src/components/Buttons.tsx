import { login, logout, getUser } from "../helpers/auth_helper";

export default function AuthButtons() {
  const handleLogin = () => login();
  const handleLogout = () => logout();
  const handleGetUser = async () => {
    const user = await getUser();
    console.log(user);
  };

  return (
    <div>
      <button onClick={handleLogin}>Login</button>
      <button onClick={handleLogout}>Logout</button>
      <button onClick={handleGetUser}>Check User</button>
    </div>
  );
}
