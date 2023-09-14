package com.matb.basicpokedex.home.data.repository

import com.matb.basicpokedex.home.data.mapper.toDomain
import com.matb.basicpokedex.home.data.remote.HomeApi
import com.matb.basicpokedex.home.domain.model.PokemonPreview
import com.matb.basicpokedex.home.domain.repository.HomeRepository
import java.util.concurrent.CancellationException

/**
 * Created by meldricktb$ on 13/09/23$.
 */
class HomeRepositoryImpl(
    private val api: HomeApi
) : HomeRepository {
    override suspend fun getPokemons(): Result<List<PokemonPreview>> {
        return try {
            val result = api.getPokemons()
            val mapped = result.results.map { it.toDomain() }
            Result.success(mapped)
        } catch (e: CancellationException) {
            throw e
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}