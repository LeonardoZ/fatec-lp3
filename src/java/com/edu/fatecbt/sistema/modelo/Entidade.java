package com.edu.fatecbt.sistema.modelo;

public class Entidade {

    private int cod;

    public Entidade() {
        cod = 0;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public void setCod(String cod) {
        setCod(cod.isEmpty() ? 0 : Integer.valueOf(cod));
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.cod;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Entidade other = (Entidade) obj;
        if (this.cod != other.cod) {
            return false;
        }
        return true;
    }

}
