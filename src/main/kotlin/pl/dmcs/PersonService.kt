package pl.dmcs

import io.micronaut.http.HttpResponse
import javax.inject.Singleton

interface PersonService {
    fun fillData(data: List<Person>): HttpResponse<List<Person>>
    fun delete(): HttpResponse<Boolean>
    fun getAll(): HttpResponse<List<Person>>
}

@Singleton
class PersonServiceImpl(private val repository: PersonRepository) : PersonService {

    override fun fillData(data: List<Person>): HttpResponse<List<Person>> {
        return HttpResponse.ok(repository.fill(data))
    }


    override fun delete(): HttpResponse<Boolean> {
        return HttpResponse.ok(repository.delete())
    }

    override fun getAll(): HttpResponse<List<Person>> {
        return HttpResponse.ok(repository.getAll())
    }

}
