package com.app

class Perfil
{
	 Usuario usuario
	 String formacion
	 String estilo

	static constraints =
	{
	 formacion nullable: true
	 usuario unique: true, nullable: false
	 estilo nullable: true
	 generoMusical nullable: true
 	}

 	static hasMany = [ instrumentomusico : InstrumentoMusico, generoMusical : GeneroMusical ]

 	String toString() { return usuario}
 }
