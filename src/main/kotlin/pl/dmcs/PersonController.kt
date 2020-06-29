package pl.dmcs

import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.*

const val PATH_SLASH = "/"
const val PATH_ID = "/{id}"
const val PATH_INIT = "/init"

@Controller
class PersonController(private val service: PersonService) {


    @Post(PATH_INIT)
    fun initData(@Body data: List<Person>) {
        return service.fillData(data)
    }

    @Get(PATH_ID)
    fun getSinglePersonMethod(@PathVariable id: Int): HttpResponse<Person> {
        return service.findById(id)
    }

    @Get(PATH_SLASH)
    fun getPersonsMethod(): HttpResponse<List<Person>> {
        return service.getAll()
    }

    @Post(PATH_SLASH)
    fun postMethod(@Body person: Person): HttpResponse<Person> {
        return service.insert(person)
    }

    @Put(PATH_ID)
    fun putMethod(@PathVariable id: Int, @Body person: Person): HttpResponse<Person> {
        return service.update(id, person)
    }

    @Delete(PATH_ID)
    fun deleteMethod(@PathVariable id: Int): HttpResponse<Boolean> {
        return service.delete(id)
    }

}