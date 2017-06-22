package br.edu.ifsul.controle;


import br.edu.ifsul.dao.AlunoDAO;
import br.edu.ifsul.dao.CursoDAO;
import br.edu.ifsul.dao.OrientadorDAO;
import br.edu.ifsul.dao.PublicacaoDAO;
import br.edu.ifsul.modelo.Orientador;
import br.edu.ifsul.modelo.Aluno;
import br.edu.ifsul.modelo.Curso;
import br.edu.ifsul.modelo.Publicacao;
import br.edu.ifsul.util.Util;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named(value = "controleAluno")
@SessionScoped
public class ControleAluno implements Serializable {

    @EJB
    private AlunoDAO<Aluno> daoAluno;
    private Aluno objeto;    
    private Boolean editando;
    @EJB
    private OrientadorDAO<Orientador> daoOrientador;
    @EJB
    private CursoDAO<Curso> daoCurso;
    private Curso curso;
    private Boolean editandoCurso;
    @EJB
    private PublicacaoDAO<Publicacao> daoPublicacao;
    private Publicacao publicacao;
    private Boolean editandoPublicacao;
    
    public ControleAluno(){
        editando = false;
    }
    
    public String listar(){
        setEditando(false);
        return "privado/aluno/listar?faces-redirect=true";
    }

    public void novo(){
        objeto = new Aluno();
        setEditando(true);
    }
    
    public void alterar(Integer id){
        try {
            objeto = daoAluno.getObjectById(id);
            setEditando(true);
        } catch (Exception e){
            Util.mensagemErro("Erro ao recuperar objeto: "+
                    Util.getMensagemErro(e));
        }
    }

    public void excluir(Integer id){
        try {
            objeto = daoAluno.getObjectById(id);
            daoAluno.remove(objeto);
            Util.mensagemInformacao("Objeto removido com sucesso!");
        } catch (Exception e){
            Util.mensagemErro("Erro ao remover objeto: "+
                    Util.getMensagemErro(e));
        }
    }    
    
    public void salvar(){
        try {
            if (objeto.getId() == null){
                daoAluno.persist(objeto);
            } else {
                daoAluno.merge(objeto);
            }
            Util.mensagemInformacao("Objeto persistido com sucesso!");
            setEditando(false);
        } catch (Exception e){
            Util.mensagemErro("Erro ao persistir objeto: " + 
                    Util.getMensagemErro(e));
        }
    }    

    public AlunoDAO<Aluno> getDao() {
        return daoAluno;
    }

    public void setDao(AlunoDAO<Aluno> daoAluno) {
        this.daoAluno = daoAluno;
    }

    public Aluno getObjeto() {
        return objeto;
    }

    public void setObjeto(Aluno objeto) {
        this.objeto = objeto;
    }

    public OrientadorDAO<Orientador> getDaoOrientador() {
        return daoOrientador;
    }

    public void setDaoOrientador(OrientadorDAO<Orientador> daoOrientador) {
        this.daoOrientador = daoOrientador;
    }

    public Boolean getEditando() {
        return editando;
    }

    public void setEditando(Boolean editando) {
        this.editando = editando;
    }

    public CursoDAO<Curso> getDaoCurso() {
        return daoCurso;
    }

    public void setDaoCurso(CursoDAO<Curso> daoCurso) {
        this.daoCurso = daoCurso;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Boolean getEditandoCurso() {
        return editandoCurso;
    }

    public void setEditandoCurso(Boolean editandoCurso) {
        this.editandoCurso = editandoCurso;
    }

    public PublicacaoDAO<Publicacao> getDaoPublicacao() {
        return daoPublicacao;
    }

    public void setDaoPublicacao(PublicacaoDAO<Publicacao> daoPublicacao) {
        this.daoPublicacao = daoPublicacao;
    }

    public Publicacao getPublicacao() {
        return publicacao;
    }

    public void setPublicacao(Publicacao publicacao) {
        this.publicacao = publicacao;
    }

    public Boolean getEditandoPublicacao() {
        return editandoPublicacao;
    }

    public void setEditandoPublicacao(Boolean editandoPublicacao) {
        this.editandoPublicacao = editandoPublicacao;
    }
}
