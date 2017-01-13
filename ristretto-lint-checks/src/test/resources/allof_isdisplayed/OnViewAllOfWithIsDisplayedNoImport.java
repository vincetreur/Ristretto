import android.support.test.espresso.Espresso;
import android.support.test.espresso.ViewAction;
import android.support.test.espresso.matcher.ViewMatchers;

import com.appsingularity.ristretto.Ristretto;
import com.appsingularity.ristretto.RistrettoViewMatchers;

import org.hamcrest.CoreMatchers;
import org.hamcrest.Matchers;
import org.hamcrest.core.AllOf;

public class OnViewAllOfWithIsDisplayedNoImport {

    public void fooAllOf() {
        Espresso.onView(AllOf.allOf(ViewMatchers.withId(R.id.some_id), ViewMatchers.isDisplayed())).perform(ViewAction.click());
        Espresso.onView(AllOf.allOf(ViewMatchers.withText(R.string.some_text), ViewMatchers.isDisplayed())).perform(ViewAction.click());
        Espresso.onView(AllOf.allOf(ViewMatchers.withText("some text"), ViewMatchers.isDisplayed())).perform(ViewAction.click());
        Espresso.onView(AllOf.allOf(RistrettoViewMatchers.with("some text"), ViewMatchers.isDisplayed())).perform(ViewAction.click());
        Ristretto.withView(AllOf.allOf(ViewMatchers.withId(R.id.some_id), ViewMatchers.isDisplayed())).perform(ViewAction.click());
        Ristretto.withView(AllOf.allOf(ViewMatchers.withText(R.string.some_text), ViewMatchers.isDisplayed())).perform(ViewAction.click());
        Ristretto.withView(AllOf.allOf(ViewMatchers.withText("some text"), ViewMatchers.isDisplayed())).perform(ViewAction.click());
        Ristretto.withView(AllOf.allOf(RistrettoViewMatchers.with("some text"), ViewMatchers.isDisplayed())).perform(ViewAction.click());
        
        Espresso.onView(AllOf.allOf(ViewMatchers.isDisplayed(), ViewMatchers.withId(R.id.some_id))).perform(ViewAction.click());
        Espresso.onView(AllOf.allOf(ViewMatchers.isDisplayed(), ViewMatchers.withText(R.string.some_text))).perform(ViewAction.click());
        Espresso.onView(AllOf.allOf(ViewMatchers.isDisplayed(), ViewMatchers.withText("some text"))).perform(ViewAction.click());
        Espresso.onView(AllOf.allOf(ViewMatchers.isDisplayed(), RistrettoViewMatchers.with("some text"))).perform(ViewAction.click());
        Ristretto.withView(AllOf.allOf(ViewMatchers.isDisplayed(), ViewMatchers.withId(R.id.some_id))).perform(ViewAction.click());
        Ristretto.withView(AllOf.allOf(ViewMatchers.isDisplayed(), ViewMatchers.withText(R.string.some_text))).perform(ViewAction.click());
        Ristretto.withView(AllOf.allOf(ViewMatchers.isDisplayed(), ViewMatchers.withText("some text"))).perform(ViewAction.click());
        Ristretto.withView(AllOf.allOf(ViewMatchers.isDisplayed(), RistrettoViewMatchers.with("some text"))).perform(ViewAction.click());
    }

    public void fooMatchers() {
        Espresso.onView(Matchers.allOf(ViewMatchers.withId(R.id.some_id), ViewMatchers.isDisplayed())).perform(ViewAction.click());
        Espresso.onView(Matchers.allOf(ViewMatchers.withText(R.string.some_text), ViewMatchers.isDisplayed())).perform(ViewAction.click());
        Espresso.onView(Matchers.allOf(ViewMatchers.withText("some text"), ViewMatchers.isDisplayed())).perform(ViewAction.click());
        Espresso.onView(Matchers.allOf(RistrettoViewMatchers.with("some text"), ViewMatchers.isDisplayed())).perform(ViewAction.click());
        Ristretto.withView(Matchers.allOf(ViewMatchers.withId(R.id.some_id), ViewMatchers.isDisplayed())).perform(ViewAction.click());
        Ristretto.withView(Matchers.allOf(ViewMatchers.withText(R.string.some_text), ViewMatchers.isDisplayed())).perform(ViewAction.click());
        Ristretto.withView(Matchers.allOf(ViewMatchers.withText("some text"), ViewMatchers.isDisplayed())).perform(ViewAction.click());
        Ristretto.withView(Matchers.allOf(RistrettoViewMatchers.with("some text"), ViewMatchers.isDisplayed())).perform(ViewAction.click());

        Espresso.onView(Matchers.allOf(ViewMatchers.isDisplayed(), ViewMatchers.withId(R.id.some_id))).perform(ViewAction.click());
        Espresso.onView(Matchers.allOf(ViewMatchers.isDisplayed(), ViewMatchers.withText(R.string.some_text))).perform(ViewAction.click());
        Espresso.onView(Matchers.allOf(ViewMatchers.isDisplayed(), ViewMatchers.withText("some text"))).perform(ViewAction.click());
        Espresso.onView(Matchers.allOf(ViewMatchers.isDisplayed(), RistrettoViewMatchers.with("some text"))).perform(ViewAction.click());
        Ristretto.withView(Matchers.allOf(ViewMatchers.isDisplayed(), ViewMatchers.withId(R.id.some_id))).perform(ViewAction.click());
        Ristretto.withView(Matchers.allOf(ViewMatchers.isDisplayed(), ViewMatchers.withText(R.string.some_text))).perform(ViewAction.click());
        Ristretto.withView(Matchers.allOf(ViewMatchers.isDisplayed(), ViewMatchers.withText("some text"))).perform(ViewAction.click());
        Ristretto.withView(Matchers.allOf(ViewMatchers.isDisplayed(), RistrettoViewMatchers.with("some text"))).perform(ViewAction.click());
    }

    public void fooCoreMatchers() {
        Espresso.onView(CoreMatchers.allOf(ViewMatchers.withId(R.id.some_id), ViewMatchers.isDisplayed())).perform(ViewAction.click());
        Espresso.onView(CoreMatchers.allOf(ViewMatchers.withText(R.string.some_text), ViewMatchers.isDisplayed())).perform(ViewAction.click());
        Espresso.onView(CoreMatchers.allOf(ViewMatchers.withText("some text"), ViewMatchers.isDisplayed())).perform(ViewAction.click());
        Espresso.onView(CoreMatchers.allOf(RistrettoViewMatchers.with("some text"), ViewMatchers.isDisplayed())).perform(ViewAction.click());
        Ristretto.withView(CoreMatchers.allOf(ViewMatchers.withId(R.id.some_id), ViewMatchers.isDisplayed())).perform(ViewAction.click());
        Ristretto.withView(CoreMatchers.allOf(ViewMatchers.withText(R.string.some_text), ViewMatchers.isDisplayed())).perform(ViewAction.click());
        Ristretto.withView(CoreMatchers.allOf(ViewMatchers.withText("some text"), ViewMatchers.isDisplayed())).perform(ViewAction.click());
        Ristretto.withView(CoreMatchers.allOf(RistrettoViewMatchers.with("some text"), ViewMatchers.isDisplayed())).perform(ViewAction.click());

        Espresso.onView(CoreMatchers.allOf(ViewMatchers.isDisplayed(), ViewMatchers.withId(R.id.some_id))).perform(ViewAction.click());
        Espresso.onView(CoreMatchers.allOf(ViewMatchers.isDisplayed(), ViewMatchers.withText(R.string.some_text))).perform(ViewAction.click());
        Espresso.onView(CoreMatchers.allOf(ViewMatchers.isDisplayed(), ViewMatchers.withText("some text"))).perform(ViewAction.click());
        Espresso.onView(CoreMatchers.allOf(ViewMatchers.isDisplayed(), RistrettoViewMatchers.with("some text"))).perform(ViewAction.click());
        Ristretto.withView(CoreMatchers.allOf(ViewMatchers.isDisplayed(), ViewMatchers.withId(R.id.some_id))).perform(ViewAction.click());
        Ristretto.withView(CoreMatchers.allOf(ViewMatchers.isDisplayed(), ViewMatchers.withText(R.string.some_text))).perform(ViewAction.click());
        Ristretto.withView(CoreMatchers.allOf(ViewMatchers.isDisplayed(), ViewMatchers.withText("some text"))).perform(ViewAction.click());
        Ristretto.withView(CoreMatchers.allOf(ViewMatchers.isDisplayed(), RistrettoViewMatchers.with("some text"))).perform(ViewAction.click());
    }

}
