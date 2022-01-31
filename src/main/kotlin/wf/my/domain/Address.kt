package wf.my.domain

import kotlinx.serialization.Serializable

@Serializable
data class Address(
    val country: Country,
    val city: City,
    val postcode: Postcode,
    val street: Street,
    val house: House,
    val flat: Flat?
)

@JvmInline
@Serializable
value class Country(val value: String) {
    init {
        assert(value.isNotBlank()) { "Country can't be empty" }
    }

}

@JvmInline
@Serializable
value class City(val value: String) {
    init {
        assert(value.isNotBlank()) { "City can't be empty" }
    }

}

@JvmInline
@Serializable
value class Postcode(val value: String) {
    init {
        assert(value.isNotBlank()) { "Postcode can't be empty" }
    }

}

@JvmInline
@Serializable
value class Street(val value: String) {
    init {
        assert(value.isNotBlank()) { "Street can't be empty" }
    }

}

@JvmInline
@Serializable
value class House(val value: String) {
    init {
        assert(value.isNotBlank()) { "House can't be empty" }
    }

}

@JvmInline
@Serializable
value class Flat(val value: String) {
    init {
        assert(value.isNotBlank()) { "Flat can't be empty" }
    }

}
