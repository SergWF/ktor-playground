package wf.my.plugins.route

import io.ktor.server.application.call
import io.ktor.server.locations.Location
import io.ktor.server.locations.get
import io.ktor.server.response.respond
import io.ktor.server.routing.Route

@Location("")
class RootLocaltion

fun Route.rootRoute() {

    get<RootLocaltion> {
        call.respond("Hello World!")
    }
}
