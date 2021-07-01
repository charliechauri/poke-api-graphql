package com.charliechauri.pokemon.api.models

data class Type(val name: String, val url: String) {}

data class PokemonType(val slot: Int, val type: Type) {}