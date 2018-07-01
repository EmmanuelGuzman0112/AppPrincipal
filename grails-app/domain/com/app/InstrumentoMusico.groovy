package com.app

class InstrumentoMusico
{
    String experiencia

    static belongsTo = [ instrumento : Instrumento, perfil : Perfil ]

    static constraints =
	{
		perfil nullable: false
		instrumento nullable: false
		experiencia nullable: false
	}
}
