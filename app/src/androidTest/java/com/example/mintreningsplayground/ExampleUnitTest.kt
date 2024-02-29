import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsEnabled
import androidx.compose.ui.test.assertIsNotEnabled
import androidx.compose.ui.test.assertTextContains
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.mintreningsplayground.MainActivity
import com.example.mintreningsplayground.R
import com.example.mintreningsplayground.data.Datasource
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import kotlin.random.Random

@RunWith(AndroidJUnit4::class)
class ExampleUnitTest {

	@get:Rule
	val composeTestRule = createAndroidComposeRule<MainActivity>()

	@Test
	fun testStrengthButtonEnabled() {
		composeTestRule.onNodeWithText("Strength").assertIsEnabled()
		composeTestRule.onNodeWithText("Cardio").assertIsNotEnabled()
	}

	@Test
	fun testTotalSetsAndExercisesMatchDataCollections() {
		val exercises = Datasource().cardioExercises
		val expectedOutput = composeTestRule.activity.getString(
			R.string.workout_summary,
			exercises.size,
			exercises.sumOf { it.sets!! })
		composeTestRule.onNodeWithText("Total number of exercises and sets", substring = true).assertTextEquals(expectedOutput)
	}
@Test
fun testCheckedSetsMatchesText1() {
	//TODO: Write a test that checks that the text of the checked off sets matches the expected output
	val switches = composeTestRule.onAllNodes(hasTestTag("switch"))
	val numberOfSwitchesToFlip = Random.nextInt(1, switches.fetchSemanticsNodes().size + 1)

	for (i in 0 until numberOfSwitchesToFlip) {
		switches[i].performClick()
	}
	composeTestRule.onNodeWithText("Total number of complete sets (all exercises): $numberOfSwitchesToFlip", substring = true).assertIsDisplayed()
}}
