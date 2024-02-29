package com.example.mintreningsplayground.data

import com.example.mintreningsplayground.R

class Datasource {
	val styrkeExercises = listOf(
		StyrkeExercise(
			name = "Bench press",
			description = "Pull shoulder blades back and down, and press the bar straight up. 10 reps.",
			image = R.drawable.benchpress,
			videoLink = "https://youtu.be/dQw4w9WgXcQ?si=0ppuAhkxvs5_9Ms1",
			sets = 3
		), StyrkeExercise(
			name = "Squat",
			description = "Stand with feet shoulder-width apart, and lower your hips until your thighs are parallel to the floor. 10 reps.",
			image = R.drawable.squat,
			videoLink = "https://youtu.be/dQw4w9WgXcQ?si=0ppuAhkxvs5_9Ms1",
			sets = 3

		), StyrkeExercise(
			name = "Deadlift",
			description = "Stand with feet shoulder-width apart, and pull the bar up along your legs. 10 reps.",
			image = R.drawable.deadlift,
			videoLink = "https://youtu.be/dQw4w9WgXcQ?si=0ppuAhkxvs5_9Ms1",
			sets = 3
		), StyrkeExercise(
			name = "Pull-up",
			description = "Hang from a bar with your hands shoulder-width apart, and pull your chest up to the bar. 10 reps.",
			image = R.drawable.pullup,
			videoLink = "https://youtu.be/dQw4w9WgXcQ?si=0ppuAhkxvs5_9Ms1",
			sets = 3
		)
	)

	val cardioExercises = listOf(
		StyrkeExercise(
			name = "Running",
			description = "Run with a comfortable pace where you are able to talk.",
			image = R.drawable.running,
			videoLink = "https://youtu.be/dQw4w9WgXcQ?si=0ppuAhkxvs5_9Ms1",
			duration = 30
		), StyrkeExercise(
			name = "Kettlebell swings",
			description = "Swing the kettlebell between your legs and up to shoulder height. 10 reps.",
			image = R.drawable.kbswings,
			videoLink = "https://youtu.be/dQw4w9WgXcQ?si=0ppuAhkxvs5_9Ms1",
			sets = 3
		), StyrkeExercise(
			name = "Jumping Jacks",
			description = "Jump up and spread your legs and arms out to the side. 10 reps.",
			image = R.drawable.jumpingjack,
			videoLink = "https://youtu.be/dQw4w9WgXcQ?si=0ppuAhkxvs5_9Ms1",
			sets = 3
		), StyrkeExercise(
			name = "Burpees",
			description = "Squat down, jump back into a push-up position, do a push-up, jump back to a squat, and jump up. 10 reps.",
			image = R.drawable.burpee,
			videoLink = "https://youtu.be/dQw4w9WgXcQ?si=0ppuAhkxvs5_9Ms1",
			sets = 3
		)
	)
}