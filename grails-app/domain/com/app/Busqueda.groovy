package com.app

class Busqueda
{
	Date fechaExp
	String experiencia

	static belongsTo = [ instrumento : Instrumento, banda : Banda ]

    static constraints =
    {
    	banda nullable: false
    	instrumento nullable: false
    	experiencia nullable: false
    	fechaExp nullable: false
    }

    String toString() { return banda}
}
