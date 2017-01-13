import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static com.appsingularity.ristretto.RistrettoViewMatchers.with;
import static org.hamcrest.core.AllOf.allOf;

public class AllOfAllOfWithIsDisplayedNoParent {

    public void foo() {
        allOf(withId(R.id.some_id), isDisplayed()).perform(click());
        allOf(withText(R.string.some_text), isDisplayed()).perform(click());
        allOf(withText("some text"), isDisplayed()).perform(click());
        allOf(with("some text"), isDisplayed()).perform(click());
        
        allOf(isDisplayed(), withId(R.id.some_id)).perform(click());
        allOf(isDisplayed(), withText(R.string.some_text)).perform(click());
        allOf(isDisplayed(), withText("some text")).perform(click());
        allOf(isDisplayed(), with("some text")).perform(click());
    }

}
