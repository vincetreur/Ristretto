import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Ristretto.withView;
import static android.support.test.espresso.action.ViewActions.click;
import static com.example.ViewMatchers.withId;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;

public class WithIdOtherPackage {

    public void foo() {
        withId(R.id.some_id).check(matches(isDisplayed())).perform(click());
        onView(withId(R.id.some_id)).check(matches(isDisplayed())).perform(click());
        withView(withId(R.id.some_id)).check(matches(isDisplayed())).perform(click());
    }

}
