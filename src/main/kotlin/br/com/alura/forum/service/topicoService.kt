package br.com.alura.forum.service

import br.com.alura.forum.model.Curso
import br.com.alura.forum.model.Topico
import br.com.alura.forum.model.Usuario
import org.springframework.stereotype.Service
import java.util.*
import kotlin.collections.ArrayList

@Service
class topicoService(
    private var topicos: kotlin.collections.List<Topico> = ArrayList()
) {

    fun listar(): List<Topico>{
        return topicos
    }

    fun buscarPorId(id: Long): Topico {
        return topicos.stream().filter { t ->
            t.id == id
        }.findFirst().get()
    }

    fun cadastrar(topico: Topico) {
        topicos.plus(topico)
    }


}