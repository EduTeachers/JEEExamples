package cz.educanet;

import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;

import java.io.IOException;
import java.util.Map;

@Named
@RequestScoped
public class ParamExampleBean {

    public String getSecondParam() {
        Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();

        return params.get("my-second-param");
    }

    public void doSomethingSpecial() throws IOException {
        // Something special!

        FacesContext.getCurrentInstance().getExternalContext().redirect("other.xhtml");
        // return "other.xhtml";
    }

}
