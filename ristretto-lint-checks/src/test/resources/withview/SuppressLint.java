import static android.support.test.espresso.Ristretto.withView;
import static com.appsingularity.ristretto.RistrettoViewMatchers.with;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.action.ViewActions.click;

public class SuppressLint {

    @SuppressLint("RistrettoWithView")
    public void foo() {
        withView(withId(R.id.some_id)).check(matches(isDisplayed())).perform(click());
        withView(withText(R.string.some_text)).check(matches(isDisplayed())).perform(click());
        withView(withText("some text")).check(matches(isDisplayed())).perform(click());

        withView(with(R.id.some_id)).check(matches(isDisplayed())).perform(click());
        withView(with(R.string.some_text)).check(matches(isDisplayed())).perform(click());
        withView(with("some text")).check(matches(isDisplayed())).perform(click());
    }

}
