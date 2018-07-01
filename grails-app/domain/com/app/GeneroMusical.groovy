package com.app

class GeneroMusical
{
	String nombre

	static hasMany = [ perfiles : Perfil , postulacion : Postulacion ]
	static belongsTo = [ Usuario, Perfil ]

    static constraints =
	{
		nombre unique: true, nullable: false
	 	perfiles nullable: true
 	}

 	String toString() { return nombre}
}
