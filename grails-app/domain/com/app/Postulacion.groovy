package com.app

class Postulacion
{
	String descripcion

	static belongsTo = [ usuario : Usuario, generoMusical : GeneroMusical, instrumento : Instrumento ]

    static constraints =
    {
    	descripcion nullable: false
    	usuario nullable: false
    	generoMusical nullable: false
    	instrumento nullable: false
    }
}
