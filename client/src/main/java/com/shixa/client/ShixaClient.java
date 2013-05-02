package com.shixa.client;

import java.util.Collections;


import com.linkedin.common.callback.FutureCallback;
import com.linkedin.common.util.None;
import com.linkedin.r2.RemoteInvocationException;
import com.linkedin.r2.transport.common.Client;
import com.linkedin.r2.transport.common.bridge.client.TransportClientAdapter;
import com.linkedin.r2.transport.http.client.HttpClientFactory;
import com.linkedin.restli.client.Request;
import com.linkedin.restli.client.Response;
import com.linkedin.restli.client.ResponseFuture;
import com.linkedin.restli.client.RestClient;
import com.linkedin.restli.common.EmptyRecord;
import com.shixa.formats.*;

public class ShixaClient {
	
	private static final UsersBuilders _userbuilders = new UsersBuilders();
	
	public static void main(String[] args) throws RemoteInvocationException {
		 // Create an HttpClient and wrap it in an abstraction layer
	    final HttpClientFactory http = new HttpClientFactory();
	    
	    final Client r2Client = new TransportClientAdapter(
                http.getClient(Collections.<String, String>emptyMap()));
	    
	 // Create a RestClient to talk to localhost:8080
	    RestClient restClient = new RestClient(r2Client, "http://localhost:8080/server/");
	    
	    // Generate a random ID for a fortune cookie, in the range 0-5
	    User user = new User();
	    user.setEmail("xavier@qa.com");
	    user.setPassword("1234566");
	    user.setUsername("xavierqa");
	    
	    UsersCreateBuilder createbuilder = _userbuilders.create();
	    Request<EmptyRecord> createreq = createbuilder.input(user).build();
	    
	    // Send the request and wait for a response
	    final ResponseFuture<EmptyRecord> getFuture = restClient.sendRequest(createreq);
	    final Response<EmptyRecord> resp = getFuture.getResponse();
	    
	 // Print the response
	    System.out.println("here ------------->");
	    System.out.println(resp.getStatus());
	    System.out.println("<-------------->");

	    // shutdown
	    restClient.shutdown(new FutureCallback<None>());
	    http.shutdown(new FutureCallback<None>());
	    
	    
	   /* final ResponseFuture<EmptyRecord> createFuture1 = (ResponseFuture<EmptyRecord>) _userbuilders.create().input(user).build();
	    try {
			final Response<EmptyRecord> createResp1 = createFuture1.getResponse();
			// HTTP header Location also shows the relative URI of the created resource
		    final long newPhotoId = Long.parseLong(createResp1.getId());
		    respWriter.println("New photo ID: " + newPhotoId);

		} catch (RemoteInvocationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}

}
