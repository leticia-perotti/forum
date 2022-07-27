package br.com.alura.forum.service

import br.com.alura.forum.model.Curso
import br.com.alura.forum.repository.CursoRepositoty
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.util.*

@Service
class CursoService (
    private val cursoRepositoty: CursoRepositoty
        ){

    fun buscarPoId(id: Long): Curso{
        return cursoRepositoty.findByIdOrNull(id)!!
    }

}
