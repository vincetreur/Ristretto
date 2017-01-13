import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.action.ViewActions;
import static android.support.test.espresso.action.ViewAction;
import static android.support.test.espresso.Espresso;
import static android.support.test.espresso.matcher.ViewMatchers;
import static com.appsingularity.ristretto.RistrettoViewMatchers;

public class OnViewWithIdNoImport {

    public void foo() {
        Espresso.onView(ViewMatchers.withId(R.id.some_id)).check(matches(ViewMatchers.isDisplayed())).perform(ViewAction.click());
        Espresso.onView(ViewMatchers.withText(R.string.some_text)).check(matches(ViewMatchers.isDisplayed())).perform(ViewAction.click());
        Espresso.onView(ViewMatchers.withText("some text")).check(matches(isDisplayed())).perform(ViewAction.click());

        Espresso.onView(RistrettoViewMatchers.with(R.id.some_id)).check(matches(ViewMatchers.isDisplayed())).perform(ViewAction.click());
        Espresso.onView(RistrettoViewMatchers.with(R.string.some_text)).check(matches(ViewMatchers.isDisplayed())).perform(ViewAction.click());
        Espresso.onView(RistrettoViewMatchers.with("some text")).check(matches(ViewMatchers.isDisplayed())).perform(ViewAction.click());
    }

}
