package br.com.alura.forum.mapper

import br.com.alura.forum.dto.NovoTopicoForm
import br.com.alura.forum.model.Topico
import br.com.alura.forum.service.CursoService
import br.com.alura.forum.service.UsuarioService
import org.springframework.stereotype.Component

@Component
class TopicoFormMapper(
    private var cursoService: CursoService,
    private val usuarioService: UsuarioService,
) {
    fun map(dto: NovoTopicoForm): Topico {
        return Topico (
            titulo = dto.titulo,
            mensagem = dto.mensagem,
            curso = cursoService.buscarPoId(dto.idCurso),
            autor = usuarioService.buscarPoId(dto.idAutor)
        )
    }

}
