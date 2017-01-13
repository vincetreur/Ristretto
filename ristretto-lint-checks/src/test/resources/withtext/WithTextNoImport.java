import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.action.ViewActions;
import static android.support.test.espresso.action.ViewAction;
import static android.support.test.espresso.Espresso;
import static android.support.test.espresso.matcher.ViewMatchers;
import static com.appsingularity.ristretto.Ristretto;

public class WithTextNoImport {

    public void foo() {
        ViewMatchers.withText(R.string.some_text).check(matches(isDisplayed())).perform(ViewAction.click());
        Espresso.onView(ViewMatchers.withText(R.string.some_text)).check(matches(isDisplayed())).perform(ViewAction.click());
        Ristretto.withView(ViewMatchers.withText(R.string.some_text)).check(matches(isDisplayed())).perform(ViewAction.click());

        ViewMatchers.withText("some text").check(matches(isDisplayed())).perform(ViewAction.click());
        Espresso.onView(ViewMatchers.withText("some text")).check(matches(isDisplayed())).perform(ViewAction.click());
        Ristretto.withView(ViewMatchers.withText("some text")).check(matches(isDisplayed())).perform(ViewAction.click());
    }

}
