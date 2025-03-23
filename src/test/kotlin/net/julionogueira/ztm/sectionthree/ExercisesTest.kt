package net.julionogueira.ztm.sectionthree

import io.quarkus.test.junit.QuarkusTest
import io.restassured.RestAssured.given
import org.hamcrest.CoreMatchers.`is`
import org.junit.jupiter.api.Test

@QuarkusTest
class ExercisesTest {
    @Test
    fun testFindNemoEndpoint() {
        given()
            .`when`().get("/ztm-exercises/3/find-nemo")
            .then()
            .statusCode(200)
            .body(`is`("Never found nemo =/ ."))
    }

    @Test
    fun testMergeSortedArrays(){

    }

}