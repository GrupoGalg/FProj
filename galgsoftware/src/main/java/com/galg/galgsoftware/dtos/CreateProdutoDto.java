package com.galg.galgsoftware.dtos;

import java.math.BigDecimal;

public record CreateProdutoDto (
        Long id,
        String codigoBarras,
        BigDecimal precoVenda,
        String descricao,
        String tipoEmbalagem){

}
