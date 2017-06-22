package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Publicacao;
import java.io.Serializable;
import javax.ejb.Stateful;

/**
 *
 * @author Prof. Me. Jorge Luis Boeira Bavaresco
 * @param <T>
 * @email jorge.bavaresco@passofundo.ifsul.edu.br
 * @organization IFSUL - Campus Passo Fundo
 */
@Stateful
public class PublicacaoDAO<T> extends DAOGenerico<Publicacao> implements Serializable {

    public PublicacaoDAO(){
        super();
        super.classePersistente = Publicacao.class;
    }
    
    public T getObjectById(String titulo)throws Exception{
        return (T) em.find(classePersistente, titulo);
    }
}
