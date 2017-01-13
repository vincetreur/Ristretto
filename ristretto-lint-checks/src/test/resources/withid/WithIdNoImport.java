import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.action.ViewActions;
import static android.support.test.espresso.action.ViewAction;
import static android.support.test.espresso.Espresso;
import static android.support.test.espresso.matcher.ViewMatchers;
import static com.appsingularity.ristretto.Ristretto;

public class WithIdNoImport {

    public void foo() {
        ViewMatchers.withId(R.id.some_id).check(matches(isDisplayed())).perform(ViewAction.click());
        Espresso.onView(ViewMatchers.withId(R.id.some_id)).check(matches(isDisplayed())).perform(ViewAction.click());
        Ristretto.withView(ViewMatchers.withId(R.id.some_id)).check(matches(isDisplayed())).perform(ViewAction.click());
    }

}
