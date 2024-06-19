package com.example.androidmvvmprojectbase.data.source.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.androidmvvmprojectbase.data.Dog

@Entity(tableName = "dog")
data class LocalDog(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String?,
    val image: String?,
    val description: String?,
    val minLife: Int?,
    val maxLife: Int?
)

fun LocalDog.toDog() = Dog(
    id = id.toString(),
    name = name,
    image = image,
    description = description,
    minLife = minLife,
    maxLife = maxLife
)

fun List<LocalDog>.toListDog() = map {
    it.toDog()
}

fun Dog.toLocalDog() = LocalDog(
    id = id.toInt(),
    name = name,
    image = image,
    description = description,
    minLife = minLife,
    maxLife = maxLife
)

fun List<Dog>.toListLocalDog() = map {
    it.toLocalDog()
}