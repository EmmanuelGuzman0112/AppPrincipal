package com.app

class Instrumento
{
    String nombre

    static hasMany = [ instrumentomusico : InstrumentoMusico, busqueda : Busqueda ]

    static constraints =
	{
	 nombre unique: true, nullable: false
 	}
}
