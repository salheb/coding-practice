package net.julionogueira

import jakarta.ws.rs.GET
import jakarta.ws.rs.Path
import jakarta.ws.rs.Produces
import jakarta.ws.rs.core.MediaType

import net.julionogueira.ztm.sectionthree.*

@Path("/hello")
class GreetingResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    fun hello() = "Hello from Quarkus REST"

    @GET
    @Path("/test")
    @Produces(MediaType.TEXT_PLAIN)
    fun callTest(): String {
        val test = TestClass()
        return test.runTest()
    }
}

@Path("/ztm-exercises")
class ExercisesResource {
    @GET
    @Path("/3/find-nemo/")
    @Produces(MediaType.TEXT_PLAIN)
    fun findNemo(): String {
        val exercises = Exercises()
        val myList = listOf("dory","daddy","nem")
        return exercises.findNemo(myList)
    }
}