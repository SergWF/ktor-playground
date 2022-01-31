package wf.my.plugins.route

import io.ktor.server.application.call
import io.ktor.server.locations.Location
import io.ktor.server.locations.get
import io.ktor.server.locations.post
import io.ktor.server.locations.put
import io.ktor.server.request.receive
import io.ktor.server.response.respond
import io.ktor.server.routing.Route
import kotlinx.serialization.Serializable
import wf.my.domain.Customer
import wf.my.domain.CustomerId
import wf.my.domain.CustomerName
import wf.my.plugins.UUIDSerializer
import wf.my.service.CustomerService
import java.util.UUID

@Location("/customer")
class CustomerLocation

@Location("/customer/{id}")
class CustomerLocationById(val id: UUID)


fun Route.customerRoute(customerService: CustomerService) {
    get<CustomerLocation> {
        call.respond(customerService.getAll().map { it.asGetDto() })
    }
    get<CustomerLocationById> { r ->
        call.respond(customerService.getOne(customerId = CustomerId(r.id)).asGetDto())
    }
    post<CustomerLocation> {
        call.receive(CustomerInDto::class)
            .toCustomer()
            .apply { customerService::save }
    }
    put<CustomerLocationById> { location ->
        call.receive(CustomerInDto::class)
            .toCustomer(location.id)
            .apply { customerService::save }
    }
}

@Serializable
data class CustomerOutDto(
    @Serializable(with = UUIDSerializer::class)
    val id: UUID,
    val name: String
)

data class CustomerInDto(val name: String) {
    fun toCustomer(id: UUID? = null): Customer =
        Customer(id?.let { CustomerId(it) }, CustomerName(name))
}

fun Customer.asGetDto(): CustomerOutDto = CustomerOutDto(
    id = this.id?.value ?: throw IllegalStateException("CustomerId can't be null here"),
    name = this.name.value
)
