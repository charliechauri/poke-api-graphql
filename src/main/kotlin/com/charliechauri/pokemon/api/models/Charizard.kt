package com.charliechauri.pokemon.api.models

import com.expediagroup.graphql.generator.annotations.GraphQLDescription

@GraphQLDescription(
    """
    Pokemon that knows the power of fire!
    Weak against water types, strong against grass type
    """
)
class Charizard: BasicTypePokemon {
    val fireAttacks: Array<String> = arrayOf("flameThrower")
    override val weight = "100"
}