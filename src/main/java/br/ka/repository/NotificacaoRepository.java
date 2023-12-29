package br.ka.repository;

import br.ka.model.Notificacao;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class NotificacaoRepository implements PanacheRepository<Notificacao> {
    public List<Notificacao> findByNome(String nome) {
        if (nome == null)
            return null;
        return find("UPPER(nome) LIKE ?1 ", "%" + nome.toUpperCase() + "%").list();
    }
}
