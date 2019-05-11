/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Ejercicios2;

import java.io.Serializable;

/**
 * @proyecto Tema10-Ficheros
 * @fecha 22-abr-2019 17:47:40
 * @author SantiPG
 */import java.io.*;

/**Clase agenda
 * 
 * @author SantiPG
 */
public class Agenda implements Serializable{

        private String nombre, direccion, email;
        private long telefono;
        
        /**Constructor
         * 
         * @param nom: nombre
         * @param dir: dirección
         * @param email: correo electronico
         * @param tel: telefono de contacto
         */
        public Agenda(String nom, String dir, String email, long tel) {
            this.nombre = nom;
            this.direccion = dir;
            this.email = email;
            this.telefono = tel;
        }
        
        /**
         * metodo para imprimir entradas de la agenda
         * @return String con los datos
         */
        public String toString(){
            return nombre+", "+direccion+", "+email+", "+telefono;
        }
        
        /**
         * Getter del nombre
         * @return nombre
         */
        public String getNombre() {
            return nombre;
        }
        
        /**
         * Setter del nombre
         * @param nombre: establece nombre
         */
        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getDireccion() {
            return direccion;
        }

        public void setDireccion(String direccion) {
            this.direccion = direccion;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public long getTelefono() {
            return telefono;
        }

        public void setTelefono(long telefono) {
            this.telefono = telefono;
        }

        public Agenda() {
            nombre = " ";
            direccion = " ";
            email = " ";
            telefono = 0;
        }

    }
