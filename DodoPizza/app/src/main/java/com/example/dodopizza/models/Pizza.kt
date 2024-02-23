package com.example.dodopizza.models

import java.util.UUID

data class Pizza(
    val id: String = UUID.randomUUID().toString(),
    val title: String,
    val description: String,
    val image: Int,
    val cost: String,
    val shortDescription: String,
    val costSecond: String
)
