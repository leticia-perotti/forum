package br.com.alura.forum.service

import br.com.alura.forum.model.Curso
import br.com.alura.forum.model.Usuario
import br.com.alura.forum.repository.UsuarioRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.util.*

@Service
class UsuarioService (
    private val usuarioRepository: UsuarioRepository
){
    fun buscarPoId(id: Long): Usuario {
        return usuarioRepository.findByIdOrNull(id)!!
    }

}
