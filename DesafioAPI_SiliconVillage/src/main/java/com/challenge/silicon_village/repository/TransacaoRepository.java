package com.challenge.silicon_village.repository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.challenge.silicon_village.model.Transacao;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, Long> {

	List<Transacao> findByContaIdConta(Long idConta);

	List<Transacao> findByContaIdContaAndDataBetween(Long idConta, Date dataInicio, Date dataFim);

	List<Transacao> findByContaPessoaCpf(String cpf);

	@Query("SELECT t FROM Transacao t WHERE t.conta.pessoa.cpf = :cpf AND t.data BETWEEN :dataInicio AND :dataFim")
	List<Transacao> findByCpfAndPeriodo(@Param("cpf") String cpf, @Param("dataInicio") LocalDateTime dataInicio, @Param("dataFim") LocalDateTime dataFim);

}
