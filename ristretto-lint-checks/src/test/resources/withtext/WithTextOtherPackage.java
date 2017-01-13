import static android.support.test.espresso.Espresso.onView;
import static com.appsingularity.ristretto.Ristretto.withView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static com.example.ViewMatchers.withText;

public class WithTextOtherPackage {

    public void foo() {
        withText(R.string.some_text).check(matches(isDisplayed())).perform(click());
        onView(withText(R.string.some_text)).check(matches(isDisplayed())).perform(click());
        withView(withText(R.string.some_text)).check(matches(isDisplayed())).perform(click());

        withText("some text").check(matches(isDisplayed())).perform(click());
        onView(withText("some text")).check(matches(isDisplayed())).perform(click());
        withView(withText("some text")).check(matches(isDisplayed())).perform(click());
    }

}
