package wf.my.domain

import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import java.util.UUID

data class Customer(
    val id: CustomerId?,
    val name: CustomerName
)

@JvmInline
@Serializable
value class CustomerId(@Contextual val value: UUID) {
    companion object {
        fun from(strVal: String): CustomerId = CustomerId(UUID.fromString(strVal))
    }
}


@JvmInline
@Serializable
value class CustomerName(val value: String) {
    init {
        assert(value.isNotBlank()) { "Customer's name can't be empty" }
    }
}
