package pl.dmcs

import io.micronaut.http.HttpResponse
import javax.inject.Singleton

interface PersonService {
    fun fillData(data: List<Person>)
    fun update(id: Int, person: Person): HttpResponse<Person>
    fun insert(person: Person): HttpResponse<Person>
    fun findById(id: Int): HttpResponse<Person>
    fun delete(id: Int): HttpResponse<Boolean>
    fun getAll(): HttpResponse<List<Person>>
}

@Singleton
class PersonServiceImpl(private val repository: PersonRepository) : PersonService {

    override fun fillData(data: List<Person>) {
        repository.fill(data)
    }

    override fun update(id: Int, person: Person): HttpResponse<Person> {
        return HttpResponse.ok(repository.update(id, person))
    }

    override fun insert(person: Person): HttpResponse<Person> {
        return HttpResponse.ok(repository.insert(person))
    }

    override fun findById(id: Int): HttpResponse<Person> {
        val person = repository.findById(id) ?: return HttpResponse.notFound()
        return HttpResponse.ok(person)
    }

    override fun delete(id: Int): HttpResponse<Boolean> {
        return HttpResponse.ok(repository.delete(id))
    }

    override fun getAll(): HttpResponse<List<Person>> {
        return HttpResponse.ok(repository.getAll())
    }

}


