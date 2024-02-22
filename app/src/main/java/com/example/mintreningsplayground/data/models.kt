package com.example.mintreningsplayground.data

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color

data class StyrkeExercise(
    val name: String,
    val description: String,
  @DrawableRes  val image: Int,
    val videoLink: String,
    val numberOfSets: Int,
    val setsCompleted: Int
)

data class UtholdenhetExercise(
    val name: String,
    val description: String,
    @DrawableRes val image: Int,
    val videoLink: String,
    val duration: Int,
    val distance: Int
)