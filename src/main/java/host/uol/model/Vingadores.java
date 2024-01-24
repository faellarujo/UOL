package host.uol.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class Vingadores {

    @JsonProperty("vingadores")
    ArrayList<Vingador> vingadores;

    public ArrayList<Vingador> getVingadores() {
        return this.vingadores; }

    public void setVingadores(ArrayList<Vingador> vingadores) {
        this.vingadores = vingadores; }

}
