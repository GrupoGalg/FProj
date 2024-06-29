package com.galg.galgsoftware;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class Venda {
    @Id
    private Long id;

    @Column(name = "datahora_inicio", nullable = false)
    private LocalDate dataHoraInicio;

    @Column(name = "datahora_termino")
    private LocalDate dataHoraTermino;

    @Column(length = 255)
    private String observacao;

    @OneToMany
    private List<VendaItem> listVendaItens;
}
