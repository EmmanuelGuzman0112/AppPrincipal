package com.app

class Integrante
{
    static belongsTo = [ usuario : Usuario, rol : Rol, banda : Banda ]

    static constraints =
	{
	 usuario nullable: false
	 rol nullable: false
 	}

 	String toString() { return usuario}
}
