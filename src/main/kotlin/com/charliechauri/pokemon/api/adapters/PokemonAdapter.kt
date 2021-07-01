package com.charliechauri.pokemon.api.adapters

import com.charliechauri.pokemon.api.models.Pokemon
import com.expediagroup.graphql.generator.annotations.GraphQLDescription
import io.ktor.client.*
import io.ktor.client.engine.apache.*
import io.ktor.client.features.*
import io.ktor.client.features.json.*
import io.ktor.client.request.*
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import org.slf4j.LoggerFactory

class PokemonAdapter {
    private val client = HttpClient(Apache) {
        install(JsonFeature)
    }
    private val endpoint = "https://pokeapi.co/api/v2"
    private val logger = LoggerFactory.getLogger(PokemonAdapter::class.java)

    @GraphQLDescription("""
    Get a pokemon by name 
    """)
    suspend fun getPokemonByName(name: String): Pokemon = coroutineScope {
        // To see all properties available go to: https://pokeapi.co/api/v2/pokemon/ditto
        val request: Deferred<Pokemon> = async {
            val url = "$endpoint/pokemon/$name"

            logger.info("Get pokemon from: $url")
            client.get(url)
        }

        try {
            val pokemon = request.await()

            pokemon
        } catch (e: ClientRequestException) {
            logger.error(e.toString())

            throw Exception("Not able to found a pokemon")
        }
    }
}