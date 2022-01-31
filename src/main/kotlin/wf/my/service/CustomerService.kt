package wf.my.service

import wf.my.domain.Customer
import wf.my.domain.CustomerId
import wf.my.domain.CustomerName
import java.util.UUID

class CustomerService(private val customerRepository: CustomerRepository) {
    suspend fun getOne(customerId: CustomerId): Customer =
        customerRepository.findOne(customerId)
            ?: throw IllegalStateException("Customer not found for id =$customerId")

    suspend fun save(customer: Customer) = customerRepository.save(customer)

    suspend fun getAll(): List<Customer> = customerRepository.getAll()
}


class CustomerRepository {
    fun findOne(customerId: CustomerId): Customer? = Customer(customerId, CustomerName("random"))

    fun getAll(): List<Customer> = listOf(
        Customer(CustomerId(UUID(0, 1)), CustomerName("one")),
        Customer(CustomerId(UUID(0, 2)), CustomerName("two")),
        Customer(CustomerId(UUID(0, 3)), CustomerName("three")),
    )

    fun save(customer: Customer) {
        println("==========save start=============")
        println("save to storage: $customer")
        println("==========save end  =============")
    }
}
