package week4.day1;

public class APIClient {

	public void sendRequest(String endpoint) {
		System.out.println("API REQUEST VERSION 1");
		System.out.println("EndPoint: " + endpoint);

	}

	public void sendRequest(String endpoint, String requestBody, boolean requestStatus) {
		System.out.println("API REQUEST VERSION 2");
		System.out.println("EndPoint: " + endpoint);
		System.out.println("RequestBody: " + requestBody);

		if (requestStatus) {
			System.out.println("Request was successful");

		} else {

			System.out.println("Request Failed");

		}

	}

	public static void main(String[] args) {
		APIClient apiclient = new APIClient();
		apiclient.sendRequest("https://APIClient//version1");
		apiclient.sendRequest("https://APIClient//version2",
				"name: New Balance, newFlag: false, sequence: 10, url: /s/new-balance-4399-46801, tag: , childDetails: []",
				true);

	}
}
