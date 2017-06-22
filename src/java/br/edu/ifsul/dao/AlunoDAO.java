package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Aluno;
import java.io.Serializable;
import javax.ejb.Stateful;
import javax.persistence.Query;

@Stateful

public class AlunoDAO<T> extends DAOGenerico<Aluno> implements Serializable {

    public  AlunoDAO(){
        super();
        super.classePersistente = Aluno.class;
    }
        @Override
    public Aluno getObjectById(Integer id)throws Exception{
        // inicializando a lista para não lazy inicilization exception
       Aluno obj = (Aluno) em.find(classePersistente, id);
       obj.getPublicacoes().size();
        return obj;
    }
    public Aluno LocalizaPorNomeAluno(String aluno){
        Query query = em.createQuery("from Aluno where upper(aluno) = :aluno");
        query.setParameter("aluno", aluno.toUpperCase());
        Aluno obj = (Aluno) query.getSingleResult();
        obj.getPublicacoes().size();
        return obj;
    }        
}
