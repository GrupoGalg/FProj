package com.galg.galgsoftware;

import com.escolavr.pdv.dtos.CreateProdutoDto;
import com.escolavr.pdv.dtos.ReadProdutoDto;
import com.escolavr.pdv.entities.Produto;
import com.escolavr.pdv.services.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/produtos")
@RequiredArgsConstructor
public class ProdutoController {
    private final ProdutoService produtoService;

    @GetMapping(value = "/")
    public List<ReadProdutoDto> getAll(){
        List<Produto> listProdutos = produtoService.findAll();
        List<ReadProdutoDto> listProdutosDto = new ArrayList<>();

        for (Produto produto : listProdutos){
            listProdutosDto.add(new ReadProdutoDto(
                    produto.getDescricao(),
                    produto.getCodigoBarras(),
                    produto.getPrecoVenda()
            ));
        }

        return listProdutosDto;
    }

    @PutMapping("/")
    public ReadProdutoDto createProduto(@RequestBody CreateProdutoDto dto){
        try {
            Produto produto = produtoService.create(dto);

            return new ReadProdutoDto(
                    produto.getDescricao(),
                    produto.getCodigoBarras(),
                    produto.getPrecoVenda()
            );
        } catch(Exception ex) {
            System.out.print(ex);
            return null;
        }
    }
}
