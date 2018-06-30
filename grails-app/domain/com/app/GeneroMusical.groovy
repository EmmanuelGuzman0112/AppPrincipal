package com.app

class GeneroMusical
{
	String nombre

	static hasMany = [ perfiles : Perfil ]
	static belongsTo = [ Usuario, Perfil ] //P

    static constraints =
	{
		nombre unique: true, nullable: false
	 	perfiles nullable: true
 	}
}
