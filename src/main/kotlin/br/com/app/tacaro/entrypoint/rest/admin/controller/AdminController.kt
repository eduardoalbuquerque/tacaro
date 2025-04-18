package br.com.app.tacaro.entrypoint.rest.admin.controller

import br.com.app.tacaro.core.ports.EntrypointAdminPort
import br.com.app.tacaro.entrypoint.rest.admin.dto.Marca
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/admin")
class AdminController(
    private val entrypointAdminPort: EntrypointAdminPort,
) {

    @GetMapping("/marcas")
    fun getMarcas(): List<Marca> {
        return listOf(Marca(marcaNome = "GROW", observacao = "Brinquedos infantis"))
    }

    @GetMapping("/marcas/{MarcaId}")
    fun getMarcaById(marcaId: Long): Marca {
        return Marca(marcaId = 150L, marcaNome = "GROW", observacao = "Brinquedos infantis")
    }

    @PostMapping("/marca")
    fun cadastrarMarca(@RequestBody marca: Marca){
        entrypointAdminPort.cadastrarMarca(marca)
    }

}
