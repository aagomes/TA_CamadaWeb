package br.edu.ifsul.converters;

import br.edu.ifsul.modelo.Orientador;
import java.io.Serializable;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@FacesConverter(value = "converterOrientador")
public class ConverterOrientador implements Converter, Serializable {
    
    @PersistenceContext(unitName = "TA-Trabalho2-6N1-Web_PU")
    private EntityManager em;    

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        if (string == null || string.equals("Selecione um registro")){
            return null;
        }
        return em.find(Orientador.class, Integer.parseInt(string));
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        if (o == null){
            return null;
        }
        Orientador obj = (Orientador) o;
        return obj.getNome().toString();
    }   
}
