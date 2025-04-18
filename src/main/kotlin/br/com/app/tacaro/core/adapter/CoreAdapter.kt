package br.com.app.tacaro.core.adapter

import br.com.app.tacaro.core.model.MarcaCore
import br.com.app.tacaro.core.ports.EntrypointAdminPort
import br.com.app.tacaro.entrypoint.rest.admin.dto.Marca
import org.springframework.stereotype.Service

@Service
class CoreAdapter(): EntrypointAdminPort {
    override fun cadastrarMarca(marca: Marca): MarcaCore {
        return MarcaCore(
            marcaId = 1L,
            marcaNome = "São Joaquim",
            observacao = "Verificar sempre a validade",
        )
    }
}