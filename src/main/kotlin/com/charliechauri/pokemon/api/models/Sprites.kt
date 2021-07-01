package com.charliechauri.pokemon.api.models

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class Sprites(val front_default: String, val back_default: String) {}