package br.com.alura.forum.dto

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

data class AtualizacaoTopicoForm(
    @field:NotNull
    val id: Long,
    @field:NotEmpty(message = "O campo não pode ser nulo")
    @field:Size(min =5, max =100, message = "Titulo deve ter entre 5 e 100 caracteres")
    val titulo: String,
    @field:NotEmpty(message = "O campo não pode ser nulo")
    val mensagem: String

) {

}
