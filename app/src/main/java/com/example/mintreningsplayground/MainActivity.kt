package com.example.mintreningsplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.mintreningsplayground.data.Datasource
import com.example.mintreningsplayground.data.StyrkeExercise
import com.example.mintreningsplayground.ui.theme.MinTreningsplaygroundTheme
import com.example.mintreningsplayground.ui.theme.Typography
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MinTreningsplaygroundTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                }
            }
        }
    }
}

@Composable
fun ExerciseCard(exercise: StyrkeExercise) {
    var expanded by remember {mutableStateOf(false)}
    Card(modifier = Modifier
        .fillMaxWidth()
        .clickable(onClick = { expanded = !expanded }))
    {
        Row {
            Text(text = exercise.name, style = Typography.headlineMedium)
        }
        if (expanded)
        Row {
            ExerciseIcon(exercise)
            Column (modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_small))) {

                Text(text = exercise.description, style = Typography.bodyLarge)
                for (i in 1..exercise.numberOfSets) {
                    Switch(checked = false, onCheckedChange = {/*TODO*/ })
                    Text(
                        text = stringResource(id = R.string.setcomplete, i),
                        style = Typography.bodyLarge
                    )
                }
            }
        }
    }
}

@Composable
fun ExerciseIcon(icon: StyrkeExercise, modifier: Modifier = Modifier) {
    Image(
        painterResource(id = icon.image),
        contentDescription = null,
        modifier = modifier.size(dimensionResource(id = R.dimen.icon_size)
        )
    )
}

@Preview
@Composable
fun PreviewExerciseCard() {
    MinTreningsplaygroundTheme {
        ExerciseCard(exercise = Datasource().styrkeExercises.first())
    }
}
