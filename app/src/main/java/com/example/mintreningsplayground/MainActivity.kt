package com.example.mintreningsplayground

import android.content.Intent
import android.graphics.drawable.shapes.Shape
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.material3.CenterAlignedTopAppBar
import com.example.mintreningsplayground.data.Datasource
import com.example.mintreningsplayground.data.StyrkeExercise
import com.example.mintreningsplayground.ui.theme.AppTheme
import com.example.mintreningsplayground.ui.theme.Typography


class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			AppTheme { // A surface container using the 'background' color from the theme
				Surface(
					modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
				) {
					TopAppBar()
				}
			}
		}
	}
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar() {
	Scaffold(modifier = Modifier.fillMaxSize(), topBar = {
		CenterAlignedTopAppBar(colors = TopAppBarDefaults.topAppBarColors(
			containerColor = MaterialTheme.colorScheme.primaryContainer,
			titleContentColor = MaterialTheme.colorScheme.primary,

		), title = {
			Row(
				modifier = Modifier.fillMaxWidth(),
				horizontalArrangement = Arrangement.SpaceEvenly
			) {
				Image(
					painterResource(R.drawable.ic_action_name),
					contentDescription = null,
					modifier = Modifier.size(
						dimensionResource(id = R.dimen.icon_size)
					)
				)
				Text(
					stringResource(R.string.app_name),
					style = Typography.displayLarge,
					modifier = Modifier.align(Alignment.CenterVertically)
				)
			}
			Row {
				Divider (
					color = MaterialTheme.colorScheme.primary,
					modifier = Modifier
						.height(1.dp)
						.fillMaxWidth()
				)
			}
		})
	}) { innerPadding ->
		AppContent(modifier = Modifier.padding(innerPadding))
	}
}

@Composable
fun AppContent(modifier: Modifier = Modifier) {
	var totalSetsComplete by remember { mutableStateOf(0) }
	var exercisesComplete by remember { mutableStateOf(0) }
	var selectedButton by remember { mutableStateOf("Cardio") }
	Column(modifier = modifier) {
		WorkoutButtons(selectedButton = selectedButton, onButtonSelected = { selectedButton = it })
		WorkoutSummary(totalSetsComplete, exercisesComplete, totalSets = if (selectedButton == "Strength") {
			Datasource().styrkeExercises.sumOf { it.sets!! }
		} else {
			Datasource().cardioExercises.sumOf { it.sets!! }
		}, totalExercises = if (selectedButton == "Strength") {
			Datasource().styrkeExercises.size
		} else {
			Datasource().cardioExercises.size
		})
		when (selectedButton) {
			"Strength" -> ExerciseList(Datasource().styrkeExercises,
				onSetComplete = { totalSetsComplete++ },
				onExerciseComplete = { exercisesComplete++ },
		)

			"Cardio" -> ExerciseList(Datasource().cardioExercises,
				onSetComplete = { totalSetsComplete++ },
				onExerciseComplete = { exercisesComplete++ },
		)
		}

	}
}

@Composable
fun WorkoutSummary(totalSetsComplete: Int, exercisesComplete: Int, totalSets: Int, totalExercises: Int) {
	Text(text = stringResource(R.string.workout_summary, totalExercises,totalSets), style = Typography.bodyMedium)
	Text(
		text = stringResource(R.string.workout_summary_exercise, exercisesComplete),
		style = Typography.bodyMedium
	)
	Text(
		text = stringResource(R.string.workout_summary_set, totalSetsComplete),
		style = Typography.bodyMedium
	)
}

@Composable
fun WorkoutButtons(selectedButton: String, onButtonSelected: (String) -> Unit) {
	Row(horizontalArrangement = Arrangement.SpaceEvenly, modifier = Modifier.fillMaxWidth()) {
		OutlinedButton(
			onClick = { onButtonSelected("Strength") },
			enabled = selectedButton != "Strength",
			shape = MaterialTheme.shapes.small,
			border = BorderStroke(2.dp, MaterialTheme.colorScheme.primary)
		) {
			Text(
				stringResource(R.string.strenght), style = Typography.labelSmall
			)
		}

		OutlinedButton(
			onClick = { onButtonSelected("Cardio") },
			enabled = selectedButton != "Cardio",
			shape = MaterialTheme.shapes.small,
			border = BorderStroke(2.dp, MaterialTheme.colorScheme.primary)
		) {
			Text(stringResource(R.string.cardio), style = Typography.labelSmall)
		}
	}
}

@Composable
fun ExerciseCard(
	exercise: StyrkeExercise,
	modifier: Modifier = Modifier,
	isExpanded: Boolean = false,
	onSetComplete: (Int) -> Unit,
	onExerciseComplete: () -> Unit
) {
	var expanded by remember { mutableStateOf(isExpanded) }
	val context = LocalContext.current
	var setCompletionStatus = remember {
		mutableStateListOf(*Array<Boolean>(exercise.sets!!) { false })
	}
	Card(
		modifier = modifier
			.padding(dimensionResource(id = R.dimen.padding_small))
			.fillMaxWidth()
			.clickable(onClick = { expanded = !expanded })

	) {
		Row(horizontalArrangement = Arrangement.SpaceBetween) {
			Text(
				text = exercise.name,
				style = Typography.displayMedium,
				modifier = Modifier
					.align(Alignment.CenterVertically)
					.padding(dimensionResource(id = R.dimen.padding_small))
			)
			Spacer(Modifier.weight(1f))
			Image(
				painter = painterResource(
					id = if (expanded) {
						R.drawable.collapse_icon
					} else {
						R.drawable.expand
					}
				),
				contentDescription = null,
				alignment = Alignment.CenterEnd,
				modifier = Modifier
					.align(Alignment.CenterVertically)
					.size(
						dimensionResource(id = R.dimen.expand_icon)
					)
			)
		}
		if (expanded) Row {
			Column {
				ExerciseIcon(exercise)
				Text(text = stringResource(id = R.string.video),
					style = Typography.bodyLarge,
					modifier = Modifier
						.clickable {
							val intent = Intent(Intent.ACTION_VIEW, Uri.parse(exercise.videoLink))
							context.startActivity(intent)
						}
						.padding(dimensionResource(id = R.dimen.padding_small))
						.align(Alignment.CenterHorizontally))
			}
			Column(modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_small))) {

				Text(
					text = exercise.description,
					style = Typography.bodyMedium,
					modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_small))
				)
				if (exercise.duration != 0 && exercise.sets == 1) {
					Row {
						Text(
							text = stringResource(R.string.duration, exercise.duration!!),
							style = Typography.bodyLarge,
							modifier = Modifier.align(Alignment.CenterVertically)
						)
						Spacer(Modifier.weight(1f))
						Switch(
							checked = setCompletionStatus[0], onCheckedChange = { isChecked ->
								setCompletionStatus[0] = isChecked
								if (isChecked) {
									onSetComplete(1)
									if (setCompletionStatus.all { it }) {
										onExerciseComplete()
									}
								}
							}, modifier = Modifier.align(Alignment.CenterVertically)
						)
					}
				} else {
					for (i in 1..exercise.sets!!) {
						Row {
							Text(
								text = stringResource(id = R.string.setcomplete, i),
								style = Typography.bodyLarge,
								modifier = Modifier.align(Alignment.CenterVertically)
							)
							Spacer(Modifier.weight(1f))
							Switch(
								checked = setCompletionStatus[i - 1],
								onCheckedChange = { isChecked ->
									setCompletionStatus[i - 1] = isChecked
									if (isChecked) {
										onSetComplete(i)
										if (setCompletionStatus.all { it }) {
											onExerciseComplete()
										}
									}
								},
								modifier = Modifier.align(Alignment.CenterVertically)
							)
						}
					}
				}
			}
		}
	}
}

@Composable
fun ExerciseIcon(icon: StyrkeExercise, modifier: Modifier = Modifier) {
	Image(
		painterResource(id = icon.image), contentDescription = null, modifier = modifier.size(
			dimensionResource(id = R.dimen.icon_size)
		)
	)
}

@Composable
fun ExerciseList(
	exercises: List<StyrkeExercise>,
	onSetComplete: (Int) -> Unit,
	onExerciseComplete: () -> Unit,
) {
	LazyColumn(content = {
		items(exercises) { exercise ->
			ExerciseCard(
				exercise = exercise,
				isExpanded = true,
				onSetComplete = onSetComplete,
				onExerciseComplete = onExerciseComplete
			)
		}
	})
}

@Preview
@Composable
fun PreviewTopAppBar() {
	AppTheme {
		TopAppBar()
	}
}