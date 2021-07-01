package com.charliechauri.pokemon.api.models

import com.expediagroup.graphql.generator.annotations.GraphQLDescription
import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
@GraphQLDescription("Represent a pokemon!")
class Pokemon (
    @GraphQLDescription("Pokemon number")
    val id: Int,
    @GraphQLDescription("Pokemon identifier eg: Pikachu")
    val name: String,
    @GraphQLDescription("Pokemon weight")
    val weight: Int,
    @GraphQLDescription("""
    Types associated to a pokemon that help to identify
    its weaknesses and strengths against other pokemon
    """)
    val types: Array<PokemonType>,
    @GraphQLDescription("URLs to get pokemon images")
    val sprites: Sprites
   ) {}