/*
Copyright 2016 Integration Partners B.V.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/
package nl.nn.adapterframework.webcontrol.api;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
* Register custom errorHandler for the API.
* 
* @author	Niels Meijer
*/

@Provider
public class ApiExceptionHandler implements ExceptionMapper<ApiException>
{
	@Override
	@Produces(MediaType.TEXT_PLAIN)
	public Response toResponse(ApiException exception) {
		ResponseBuilder response = Response.status(Status.INTERNAL_SERVER_ERROR);

		String message = exception.getMessage();
		if(message != null)
			response.entity(("{\"status\":\"error\", \"error\":\"" + exception.getMessage() + "\"}")).type(MediaType.APPLICATION_JSON);

		return response.build();
	}
}