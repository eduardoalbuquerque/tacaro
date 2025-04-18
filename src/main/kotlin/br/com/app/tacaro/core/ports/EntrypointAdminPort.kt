package br.com.app.tacaro.core.ports

import br.com.app.tacaro.core.model.MarcaCore
import br.com.app.tacaro.entrypoint.rest.admin.dto.Marca

interface EntrypointAdminPort {
    fun cadastrarMarca(marca: Marca): MarcaCore
}