package com.matb.basicpokedex.detail.data

import com.matb.basicpokedex.detail.data.mapper.toDomain
import com.matb.basicpokedex.detail.data.remote.dto.DetailApi
import com.matb.basicpokedex.detail.domain.model.PokemonDetail
import com.matb.basicpokedex.detail.domain.repository.DetailRepository
import java.util.concurrent.CancellationException

/**
 * Created by meldricktb$ on 13/09/23$.
 */
class DetailRepositoryImpl(
    private val api: DetailApi
) : DetailRepository {
    override suspend fun getPokemonDetail(id: Int): Result<PokemonDetail> {
        return try {
            val response = api.getPokemonDetail(id)
            Result.success(response.toDomain())
        } catch (e: CancellationException) {
            throw e
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}