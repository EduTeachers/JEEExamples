package cz.educanet;

import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;

import java.io.IOException;
import java.util.Map;

@Named
@RequestScoped
public class QueryParamExample {

    public String getQueryParam() {
        Map<String, String> map = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        return map.get("a");
    }

    public void doSomething() throws IOException {

        FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
    }

}
