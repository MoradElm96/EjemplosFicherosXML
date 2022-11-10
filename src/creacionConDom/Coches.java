/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package creacionConDom;

/**
 *
 * @author alumnotd
 */
public class Coches {
    int id;
    String marca,modelo,color;
    int matriculacion;

    public Coches(int id, String marca, String modelo, String color, int matriculacion) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.matriculacion = matriculacion;
    }

    public Coches(String marca, String modelo, String color, int matriculacion) {
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.matriculacion = matriculacion;
    }

    
    
    
    public Coches() {
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getMatriculacion() {
        return matriculacion;
    }

    public void setMatriculacion(int matriculacion) {
        this.matriculacion = matriculacion;
    }

    @Override
    public String toString() {
        return "Coches{" + "id=" + id + ", marca=" + marca + ", modelo=" + modelo + ", color=" + color + ", matriculacion=" + matriculacion + '}';
    }
    
    

    
}
