package wf.my.plugins

import io.ktor.server.application.Application
import io.ktor.server.application.install
import io.ktor.server.locations.Locations
import io.ktor.server.routing.routing
import org.koin.java.KoinJavaComponent.inject
import wf.my.plugins.route.customerRoute
import wf.my.plugins.route.rootRoute
import wf.my.service.CustomerService

fun Application.configureRouting() {
    install(Locations) {
    }

    val customerService: CustomerService by inject(CustomerService::class.java)


    routing {
        // no authentication requires
        rootRoute()
        // authentication requires
//        authenticate() {
        customerRoute(customerService)
//        }
    }
}
