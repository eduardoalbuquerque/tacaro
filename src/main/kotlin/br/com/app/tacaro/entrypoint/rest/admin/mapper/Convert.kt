package br.com.app.tacaro.entrypoint.rest.admin.mapper

import br.com.app.tacaro.core.model.MarcaCore
import br.com.app.tacaro.entrypoint.rest.admin.dto.Marca

fun marcaToMarcaCore(marca: Marca) =
    MarcaCore(
        marcaId = marca.marcaId,
        marcaNome = marca.marcaNome,
        observacao = marca.observacao,
    )
