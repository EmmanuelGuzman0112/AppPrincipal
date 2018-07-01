package com.app

class Instrumento
{
    String nombre

    static hasMany = [ instrumentomusico : InstrumentoMusico, busqueda : Busqueda, postulacion : Postulacion ]

    static constraints =
	{
		nombre unique: true, nullable: false
 	}

 	String toString() { return nombre}
}
