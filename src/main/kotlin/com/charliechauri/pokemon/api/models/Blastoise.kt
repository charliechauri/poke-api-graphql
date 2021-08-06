package com.charliechauri.pokemon.api.models

import com.expediagroup.graphql.generator.annotations.GraphQLDescription

@GraphQLDescription(
    """
    Pokemon that knows the power of water!
    Weak against grass types, strong against fire type
    """
)
class Blastoise: BasicTypePokemon {
    val waterAttacks: Array<String> = arrayOf("hydro pump")
    override val weight: String
        get() = "100"
}
