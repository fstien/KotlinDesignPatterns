package kot.prototype

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration


@Serializable
class Person(var names: Array<String>, var address: Address)

@Serializable
class Address(var number: Int, var street: String)


fun Person.copy() : Person {
    val json = Json(JsonConfiguration.Stable)
    val jsonData = json.stringify(Person.serializer(), this)
    return json.parse(Person.serializer(), jsonData)
}