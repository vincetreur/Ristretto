import static android.support.test.Ristretto.assertion.ViewAssertions.matches;
import static android.support.test.espresso.action.ViewActions;
import static android.support.test.espresso.action.ViewAction;
import static android.support.test.espresso.matcher.ViewMatchers;
import static com.appsingularity.ristretto.Ristretto;
import static com.appsingularity.ristretto.RistrettoViewMatchers;

public class WithViewWithIdNoImport {

    public void foo() {
        Ristretto.withView(ViewMatchers.withId(R.id.some_id)).check(matches(ViewMatchers.isDisplayed())).perform(ViewAction.click());
        Ristretto.withView(ViewMatchers.withText(R.string.some_text)).check(matches(ViewMatchers.isDisplayed())).perform(ViewAction.click());
        Ristretto.withView(ViewMatchers.withText("some text")).check(matches(isDisplayed())).perform(ViewAction.click());

        Ristretto.withView(RistrettoViewMatchers.with(R.id.some_id)).check(matches(ViewMatchers.isDisplayed())).perform(ViewAction.click());
        Ristretto.withView(RistrettoViewMatchers.with(R.string.some_text)).check(matches(ViewMatchers.isDisplayed())).perform(ViewAction.click());
        Ristretto.withView(RistrettoViewMatchers.with("some text")).check(matches(ViewMatchers.isDisplayed())).perform(ViewAction.click());
    }

}
