package host.uol.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Vingador {

    @JsonProperty("codinome")
    private String codinome;

    public String getCodinome() {
        return this.codinome; }
    public void setCodinome(String codinome) {
        this.codinome = codinome; }

}
