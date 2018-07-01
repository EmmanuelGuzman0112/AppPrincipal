package com.app

class Rol
{
	String nombre

    static hasMany = [ integrante : Integrante ]

    static constraints =
	{
	 nombre unique: true, nullable: false
	 integrante nullable: true
 	}

 	String toString() { return nombre}
}
