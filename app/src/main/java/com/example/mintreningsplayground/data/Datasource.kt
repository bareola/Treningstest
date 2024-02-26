package com.example.mintreningsplayground.data
import com.example.mintreningsplayground.R

class Datasource {
    val styrkeExercises = listOf(
        StyrkeExercise(
            name = "Bench press",
            description = "A compound exercise that works the chest, shoulders, and triceps.",
            image = R.drawable.simplified_benchpress_illustration,
            videoLink = "https://youtu.be/dQw4w9WgXcQ?si=0ppuAhkxvs5_9Ms1",
            numberOfSets = 3,
            setsCompleted = 0
        ),
        StyrkeExercise(
            name = "Squat",
            description = "A compound exercise that works the quads, hamstrings, and glutes.",
            image = R.drawable.simplified_benchpress_illustration,
            videoLink = "https://youtu.be/dQw4w9WgXcQ?si=0ppuAhkxvs5_9Ms1",
            numberOfSets = 3,
            setsCompleted = 0
        )
    )

    val utholdenhetExercises = listOf(
        UtholdenhetExercise(
            name = "Running",
            description = "A cardiovascular exercise that works the entire body.",
            image = R.drawable.benchpress,
            videoLink = "https://youtu.be/dQw4w9WgXcQ?si=0ppuAhkxvs5_9Ms1",
            duration = 30,
            distance = 5
        ),
        UtholdenhetExercise(
            name = "Swimming",
            description = "A full-body workout that is easy on the joints.",
            image = R.drawable.benchpress,
            videoLink = "https://youtu.be/dQw4w9WgXcQ?si=0ppuAhkxvs5_9Ms1",
            duration = 30,
            distance = 1000
        )
    )
}