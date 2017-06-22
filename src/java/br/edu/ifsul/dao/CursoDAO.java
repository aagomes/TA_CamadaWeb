package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Curso;
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
public class CursoDAO<T> extends DAOGenerico<Curso> implements Serializable {

    public CursoDAO(){
        super();
        super.classePersistente = Curso.class;
    }
    
    public T getObjectById(String id)throws Exception{
        return (T) em.find(classePersistente, id);
    }
}
