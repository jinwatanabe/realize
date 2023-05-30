package com.sample.rest

import io.quarkus.runtime.annotations.RegisterForReflection
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.core.Response

@Path("/v1/systems")
class SystemResource {
    @GET
    @Path("ping")
    fun ping(): Response {
        return Response.ok("pong").build()
    }
}

@RegisterForReflection
data class Ping(val message: String)
