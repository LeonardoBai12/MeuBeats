package io.lb.meubeats.user_feature.domain.repository

interface UserRepository {
    fun insertUser(email: String, password: String)
    fun getUser(email: String, password: String)
}