package com.example.mintreningsplayground.data
import com.example.mintreningsplayground.R

class Datasource {
    val styrkeExercises = listOf(
        StyrkeExercise(
            name = "Bench press",
            description = "A compound exercise that works the chest, shoulders, and triceps.",
            image = R.drawable.simplified_benchpress_illustration,
            videoLink = "https://www.youtube.com/watch?v=H414_4v0fTM",
            numberOfSets = 3,
            setsCompleted = 0
        ),
        StyrkeExercise(
            name = "Squat",
            description = "A compound exercise that works the quads, hamstrings, and glutes.",
            image = R.drawable.simplified_benchpress_illustration,
            videoLink = "https://www.youtube.com/watch?v=wYREQkVtvEc",
            numberOfSets = 3,
            setsCompleted = 0
        )
    )

    val utholdenhetExercises = listOf(
        UtholdenhetExercise(
            name = "Running",
            description = "A cardiovascular exercise that works the entire body.",
            image = R.drawable.benchpress,
            videoLink = "https://www.youtube.com/watch?v=K80m_R82uFk",
            duration = 30,
            distance = 5
        ),
        UtholdenhetExercise(
            name = "Swimming",
            description = "A full-body workout that is easy on the joints.",
            image = R.drawable.benchpress,
            videoLink = "https://www.youtube.com/watch?v=J4v_d_872Cs",
            duration = 30,
            distance = 1000
        )
    )
}