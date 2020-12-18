package br.edu.cesmac.si.nolweb.converter;

import br.edu.cesmac.si.nolweb.domain.Fabricante;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;
/*
@Named
@FacesConverter(value = "converterExtensao", forClass = Fabricante.class)
public class ConverterFabricante implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (VerificadorUtil.naoEstaNuloOuVazio(value)) {
            return this.getAttributesFrom(component).get(value);
        }
        return null;
    }
    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (VerificadorUtil.naoEstaNuloOuVazio(value)) {
            Extensao extensao = (Extensao) value;
            this.addAttribute(component, extensao);
            return extensao.getSequencial().toString();
        }
        return (String) value;
    }
    protected void addAttribute(UIComponent component, Extensao o) {
        String key = o.getSequencial().toString();
        this.getAttributesFrom(component).put(key, o);
    }
    protected Map<String, Object> getAttributesFrom(UIComponent component) {
        return component.getAttributes();
    }
}*/