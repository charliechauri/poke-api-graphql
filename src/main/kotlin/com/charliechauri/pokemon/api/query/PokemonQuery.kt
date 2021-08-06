package com.charliechauri.pokemon.api.query

import com.charliechauri.pokemon.api.adapters.PokemonAdapter
import com.charliechauri.pokemon.api.models.Charizard
import com.charliechauri.pokemon.api.models.Blastoise
import com.charliechauri.pokemon.api.models.Pokemon
import com.expediagroup.graphql.generator.annotations.GraphQLDescription
import com.expediagroup.graphql.generator.annotations.GraphQLUnion
import com.expediagroup.graphql.server.operations.Query
import kotlinx.coroutines.coroutineScope
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class PokemonQuery : Query {
    private val logger = LoggerFactory.getLogger(PokemonQuery::class.java)

    @GraphQLDescription("Example query that uses coroutines")
    suspend fun getPokemonByName(name: String): Pokemon = coroutineScope {
        val pokemonAdapter = PokemonAdapter()

        pokemonAdapter.getPokemonByName(name)
    }

    @GraphQLDescription("Ash's pokemons")
    @GraphQLUnion(name = "AshPokemons", possibleTypes = [Charizard::class, Blastoise::class])
    suspend fun getAshPokemon(): Any = coroutineScope {
        Charizard()
    }
}
