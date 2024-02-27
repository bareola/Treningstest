package com.example.mintreningsplayground.data

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color
import java.time.Duration

data class StyrkeExercise(
 val name: String,
 val description: String,
 val image: Int,
 val videoLink: String,
 val sets: Int?=1,
 val duration: Int?=0
)
