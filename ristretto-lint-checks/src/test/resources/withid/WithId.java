import static android.support.test.espresso.Espresso.onView;
import static com.appsingularity.ristretto.Ristretto.withView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

public class WithId {

    public void foo() {
        withId(R.id.some_id).check(matches(isDisplayed())).perform(click());
        onView(withId(R.id.some_id)).check(matches(isDisplayed())).perform(click());
        withView(withId(R.id.some_id)).check(matches(isDisplayed())).perform(click());
    }

}
