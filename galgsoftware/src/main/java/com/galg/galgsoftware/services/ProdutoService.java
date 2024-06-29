package com.galg.galgsoftware;

import com.escolavr.pdv.dtos.CreateProdutoDto;
import com.escolavr.pdv.entities.Produto;
import com.escolavr.pdv.exceptions.NotFoundException;
import com.escolavr.pdv.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
    private final ProdutoRepository produtoRepository;
    @Autowired
    public ProdutoService(ProdutoRepository produtoRepository){
        this.produtoRepository = produtoRepository;
    }

    public List<Produto> findAll(){
        return produtoRepository.findAll();
    }

    public Produto create(CreateProdutoDto dto) throws NotFoundException {
        if(dto.id() != null){
            Optional<Produto> optionalProduto = produtoRepository.findById(dto.id());

             optionalProduto.orElseThrow(NotFoundException::new);

             Produto produto = optionalProduto.get();

             produto.setDescricao(dto.descricao());
             produto.setCodigoBarras(dto.codigoBarras());
             produto.setPrecoVenda(dto.precoVenda());
             produto.setTipoEmbalagem(dto.tipoEmbalagem());

             return produtoRepository.save(produto);
        }

        Produto produto = new Produto(
                dto.codigoBarras(),
                dto.descricao(),
                dto.precoVenda(),
                dto.tipoEmbalagem()
        );

        return produtoRepository.save(produto);
    }
}
