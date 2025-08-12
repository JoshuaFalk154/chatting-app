import { callApi } from "../helpers/axios_helper";

export default function SomeComponent() {
  const handleFetch = async () => {
    try {
      const response = await callApi();
      console.log(response.data);
    } catch (e) {
      console.error(e);
    }
  };

  return <button onClick={handleFetch}>Fetch Data</button>;
}
