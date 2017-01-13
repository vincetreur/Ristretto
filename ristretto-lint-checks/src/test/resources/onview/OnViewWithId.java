import static android.support.test.espresso.Espresso.onView;
import static com.appsingularity.ristretto.RistrettoViewMatchers.with;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.action.ViewActions.click;

public class OnViewWithId {

    public void foo() {
        onView(withId(R.id.some_id)).check(matches(isDisplayed())).perform(click());
        onView(withText(R.string.some_text)).check(matches(isDisplayed())).perform(click());
        onView(withText("some text")).check(matches(isDisplayed())).perform(click());

        onView(with(R.id.some_id)).check(matches(isDisplayed())).perform(click());
        onView(with(R.string.some_text)).check(matches(isDisplayed())).perform(click());
        onView(with("some text")).check(matches(isDisplayed())).perform(click());
    }

}
