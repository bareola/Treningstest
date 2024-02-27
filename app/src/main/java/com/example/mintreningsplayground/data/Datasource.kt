package com.example.mintreningsplayground.data

import com.example.mintreningsplayground.R

class Datasource {
	val styrkeExercises = listOf(
		StyrkeExercise(
			name = "Bench press",
			description = "A compound exercise that works the chest, shoulders, and triceps.",
			image = R.drawable.benchpress,
			videoLink = "https://youtu.be/dQw4w9WgXcQ?si=0ppuAhkxvs5_9Ms1",
			sets = 3
		), StyrkeExercise(
			name = "Squat",
			description = "A compound exercise that works the quads, hamstrings, and glutes.",
			image = R.drawable.squat,
			videoLink = "https://youtu.be/dQw4w9WgXcQ?si=0ppuAhkxvs5_9Ms1",
			sets = 3

		), StyrkeExercise(
			name = "Deadlift",
			description = "A compound exercise that works the entire body.",
			image = R.drawable.deadlift,
			videoLink = "https://youtu.be/dQw4w9WgXcQ?si=0ppuAhkxvs5_9Ms1",
			sets = 3
		), StyrkeExercise(
			name = "Pull-up",
			description = "A compound exercise that works the back and biceps.",
			image = R.drawable.pullup,
			videoLink = "https://youtu.be/dQw4w9WgXcQ?si=0ppuAhkxvs5_9Ms1",
			sets = 3
		)
	)

	val cardioExercises = listOf(
		StyrkeExercise(
			name = "Running",
			description = "A cardiovascular exercise that works the entire body.",
			image = R.drawable.running,
			videoLink = "https://youtu.be/dQw4w9WgXcQ?si=0ppuAhkxvs5_9Ms1",
			duration = 30
		), StyrkeExercise(
			name = "Kettlebell swings",
			description = "A full-body workout that is easy on the joints. 10 reps",
			image = R.drawable.kbswings,
			videoLink = "https://youtu.be/dQw4w9WgXcQ?si=0ppuAhkxvs5_9Ms1",
			sets = 3
		), StyrkeExercise(
			name = "Jumping Jacks",
			description = "Jumping jacks are a full-body workout that can be done anywhere. Do 10 reps",
			image = R.drawable.jumpingjack,
			videoLink = "https://youtu.be/dQw4w9WgXcQ?si=0ppuAhkxvs5_9Ms1",
			sets = 3
		), StyrkeExercise(
			name = "Burpees",
			description = "Burpees are a full-body workout that can be done anywhere. Do 10 reps",
			image = R.drawable.burpee,
			videoLink = "https://youtu.be/dQw4w9WgXcQ?si=0ppuAhkxvs5_9Ms1",
			sets = 3
		)
	)
}