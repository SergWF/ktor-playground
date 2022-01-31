package wf.my.plugins

import io.ktor.server.application.Application
import org.koin.core.context.startKoin
import org.koin.dsl.module
import wf.my.service.CustomerRepository
import wf.my.service.CustomerService

fun Application.configureDI() {
    val diModule = module {
        single { CustomerRepository() }
        single { CustomerService(get()) }
    }
    startKoin {
        modules(diModule)
    }
}


