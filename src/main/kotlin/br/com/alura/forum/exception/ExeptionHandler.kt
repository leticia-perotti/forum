package br.com.alura.forum.exception

import br.com.alura.forum.dto.ErrorView
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest

@RestControllerAdvice
class ExeptionHandler {

    @ExceptionHandler(NotFoundExeption::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun handleNotFound(exeption: NotFoundExeption,
                        request: HttpServletRequest): ErrorView {
        return ErrorView(
            status = HttpStatus.NOT_FOUND.value(),
            error = HttpStatus.NOT_FOUND.name,
            message = exeption.message,
            path = request.servletPath
        )
    }
}