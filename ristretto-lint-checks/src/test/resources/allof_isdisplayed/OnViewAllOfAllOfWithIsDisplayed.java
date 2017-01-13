
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static com.appsingularity.ristretto.Ristretto.withView;
import static com.appsingularity.ristretto.RistrettoViewMatchers.with;
import static org.hamcrest.core.AllOf.allOf;

public class OnViewAllOfAllOfWithIsDisplayed {

    public void foo() {
        onView(allOf(withId(R.id.some_id), isDisplayed())).perform(click());   
        onView(allOf(withText(R.string.some_text), isDisplayed())).perform(click());
        onView(allOf(withText("some text"), isDisplayed())).perform(click());
        onView(allOf(with("some text"), isDisplayed())).perform(click());
        withView(allOf(withId(R.id.some_id), isDisplayed())).perform(click()); 
        withView(allOf(withText(R.string.some_text), isDisplayed())).perform(click());
        withView(allOf(withText("some text"), isDisplayed())).perform(click());
        withView(allOf(with("some text"), isDisplayed())).perform(click());
        
        onView(allOf(isDisplayed(), withId(R.id.some_id))).perform(click());   
        onView(allOf(isDisplayed(), withText(R.string.some_text))).perform(click());
        onView(allOf(isDisplayed(), withText("some text"))).perform(click());
        onView(allOf(isDisplayed(), with("some text"))).perform(click());
        withView(allOf(isDisplayed(), withId(R.id.some_id))).perform(click()); 
        withView(allOf(isDisplayed(), withText(R.string.some_text))).perform(click());
        withView(allOf(isDisplayed(), withText("some text"))).perform(click());
        withView(allOf(isDisplayed(), with("some text"))).perform(click());
    }

}
