package wf.my.plugins.route

import io.ktor.client.call.body
import io.ktor.client.plugins.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import io.ktor.server.testing.testApplication
import java.util.UUID
import kotlin.test.Test
import kotlin.test.assertEquals

internal class CustomerRouteTest {

    @Test
    fun `should return customer by id`() = testApplication() {
        val testClient = createClient {
            install(ContentNegotiation) {
                json()
            }
        }
        val id = UUID(1, 1)
        val name = "random"
        val actual = testClient.get("/customer/${id}").body<CustomerOutDto>()
        val expected = CustomerOutDto(id, name)
        assertEquals(expected, actual)
    }
}
