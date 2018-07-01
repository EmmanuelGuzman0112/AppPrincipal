package com.app

class Usuario
{
	 String nombre
	 String apellido
	 String mail
	 String password

	 static constraints =
	 {
		 nombre nullable: false
		 apellido nullable: false
		 mail unique: true, nullable: false
		 password nullable: false
		 perfil nullable: true
	 }

	 static hasOne = [ perfil : Perfil]
	 static hasMany = [ integrante : Integrante, postulacion : Postulacion ]
}
