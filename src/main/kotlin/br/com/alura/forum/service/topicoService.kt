package br.com.alura.forum.service

import br.com.alura.forum.dto.AtualizacaoTopicoForm
import br.com.alura.forum.dto.NovoTopicoForm
import br.com.alura.forum.dto.TopicoView
import br.com.alura.forum.exception.NotFoundExeption
import br.com.alura.forum.mapper.TopicoFormMapper
import br.com.alura.forum.mapper.TopicoViewMapper
import br.com.alura.forum.model.Topico
import br.com.alura.forum.repository.TopicoRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.util.stream.Collectors
import kotlin.collections.ArrayList

@Service
class topicoService(
    private var topicosRepository: TopicoRepository,
    private val topicoViewMapper: TopicoViewMapper,
    private val topicoFormMapper: TopicoFormMapper,
    private val notFoundMessega: String = "Topico nao encontrado"
) {

    fun listar(): List<TopicoView>{
        val topicos = topicosRepository.findAll()
        return topicos.stream().map {
            t -> topicoViewMapper.map(t)
        }.collect(Collectors.toList())
    }

    fun buscarPorId(id: Long): TopicoView {
        val topico = topicosRepository.findById(id).orElseThrow{NotFoundExeption(notFoundMessega)}
        return topicoViewMapper.map(topico)
    }

    fun cadastrar(dto: NovoTopicoForm): TopicoView {
        val topico = topicoFormMapper.map(dto)
        topicosRepository.save(topico)
        return topicoViewMapper.map(topico)
    }

    fun atualizar(form: AtualizacaoTopicoForm): TopicoView {
        val topico = topicosRepository.findById(form.id).orElseThrow{ NotFoundExeption(notFoundMessega) }
        topico.titulo = form.titulo
        topico.mensagem = form.mensagem
        topicosRepository.save(topico)
        return topicoViewMapper.map(topico)
    }

    fun deletar(id: Long) {
        topicosRepository.deleteById(id)
    }


}