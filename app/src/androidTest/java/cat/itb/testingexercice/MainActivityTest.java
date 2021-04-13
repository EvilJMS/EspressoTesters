package cat.itb.testingexercice;

import androidx.test.espresso.Espresso;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isChecked;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {
    public static String USER_TO_BE_TYPED="EvilJMS";
    public static String PASS_TO_BE_TYPED="123456789";

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void textviewAndButtonOnActivityMainAreDisplayed() {
        onView(withId(R.id.title)).check(matches(isDisplayed()));
        onView(withId(R.id.botonTest)).check(matches(isDisplayed()));
    }

    @Test
    public void checkTextOfElementsInActivityMain() {
        onView(withId(R.id.title)).check(matches(withText(R.string.main_activity_title)));
        onView(withId(R.id.botonTest)).check(matches(withText(R.string.next)));
    }

    @Test
    public void nextButton_is_clickable_and_text_changes_to_back_when_click() {
        onView(withId(R.id.botonTest)).check(matches(isClickable()));
        onView(withId(R.id.botonTest)).perform(click()).check(matches(withText(R.string.backText)));
    }

    @Test
    public void login_form_behaviour() {
        onView(withId(R.id.userEditText)).perform(typeText(USER_TO_BE_TYPED)).check(matches(withText(USER_TO_BE_TYPED)));
        onView(withId(R.id.passwordEditText)).perform(typeText(PASS_TO_BE_TYPED)).check(matches(withText(PASS_TO_BE_TYPED)));
        //onView(withId(R.id.botonTest)).perform(click()).check(matches(withText(R.string.backText)));
    }

    @Test
    public void changeActivityButtonConfirmClick(){
        onView(withId(R.id.botonTest)).perform(click());
        onView(withId(R.id.secondActivity)).check(matches(withId(R.id.secondActivity)));
    }

    @Test
    public void confirmBackButtonGoesBackToMainActivity(){
        onView(withId(R.id.botonTest)).perform(click());
        onView(withId(R.id.secondActivity)).check(matches(withId(R.id.secondActivity)));
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.MainActivity)).check(matches(withId(R.id.MainActivity)));
    }

    @Test
    public void confirmAndroidBackButtonGoesBackToMainActivity(){
        onView(withId(R.id.botonTest)).perform(click());
        onView(withId(R.id.secondActivity)).check(matches(withId(R.id.secondActivity)));
        Espresso.pressBack();
        onView(withId(R.id.MainActivity)).check(matches(withId(R.id.MainActivity)));
    }
    @Test
    public void largeTestFunction(){
        onView(withId(R.id.userEditText)).perform(typeText(USER_TO_BE_TYPED), closeSoftKeyboard()).check(matches(withText(USER_TO_BE_TYPED)));
        onView(withId(R.id.passwordEditText)).perform(typeText(PASS_TO_BE_TYPED), closeSoftKeyboard()).check(matches(withText(PASS_TO_BE_TYPED)));
        onView(withId(R.id.botonTest)).perform(click());
        onView(withId(R.id.secondActivity)).check(matches(withId(R.id.secondActivity)));
        onView(withId(R.id.secondTitle)).check(matches(withText("Welcome back "+USER_TO_BE_TYPED)));
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.MainActivity)).check(matches(withId(R.id.MainActivity)));
        onView(withId(R.id.userEditText)).check(matches(withText("")));
        onView(withId(R.id.passwordEditText)).check(matches(withText("")));
    }




}
