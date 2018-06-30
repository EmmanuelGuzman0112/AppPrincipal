package com.app

class Banda
{
	String nombre

	static hasMany = [ integrante : Integrante, busqueda : Busqueda]

    static constraints =
    {
    	nombre unique: true, nullable: false
    }
}
