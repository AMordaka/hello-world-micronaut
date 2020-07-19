package pl.dmcs

import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.*

const val PATH_SLASH = "/"

@Controller(PATH_SLASH)
class PersonController(private val service: PersonService) {

    @Post(PATH_SLASH)
    fun initData(@Body data: List<Person>): HttpResponse<List<Person>> {
        return service.fillData(data)
    }

    @Get(PATH_SLASH)
    fun getMethod(): HttpResponse<List<Person>> {
        return service.getAll()
    }

    @Put(PATH_SLASH)
    fun putMethod(@Body data: List<Person>): HttpResponse<List<Person>> {
        return service.fillData(data)
    }

    @Delete(PATH_SLASH)
    fun deleteMethod(): HttpResponse<Boolean> {
        return service.delete()
    }
}
