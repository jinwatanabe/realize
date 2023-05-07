package com.sample

import io.quarkus.runtime.annotations.RegisterForReflection
import jakarta.ws.rs.GET
import jakarta.ws.rs.Path
import jakarta.ws.rs.core.Response

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
