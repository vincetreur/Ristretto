Ristretto
============

A short shot of Espresso.

>A shorthand extension on top of Espresso.

Espresso's consistency makes it really easy to learn.

Want to match a view with a specific id? Use `withId(R.id.some_id)`.
Need to match with a piece of text? Use `withText(R.id.some_text)`
or `withText("some text)`.
Awesome, consistent and it's very clear what it is you are doing.

However...

After a few hours writing test code you'll find you're code being a little bit to verbose.
Not anymore.

Why should you need to explicitly specify that you are matching with some text if you are passing in some text as a parameter? Some for the view id, you can already see that it is a view id.

Ristretto allows you to write the same test code as you already write, but less verbose.
Let's see some examples.

##Espresso vs Ristretto

Simple replacements

| *Espresso* | *Ristretto* |
| ---- | ---- |
| `withId(R.id.some_id)` | `with(R.id.some_id)` |
| `withText(R.string.some_text)` | `with(R.string.some_text)` |
| `withText("some text")` | `with("some text")` |

In combination with `onView()`

| *Espresso* | *Ristretto* |
| ---- | ---- |
| `onView(withId(R.id.some_id))` | `withView(R.id.some_id)` |
| `onView(withText(R.string.some_text))` | `withView(R.string.some_text)` |
| `onView(withText("some text"))` | `withView("some text")` |

For displayed views

| *Espresso* | *Ristretto* |
| ---- | ---- |
| `onView(allOf(withId(R.id.some_id), isDisplayed()))` | `withDisplayedView(R.id.some_id)` |
| `onView(allOf(withText(R.string.some_text), isDisplayed()))` | `withDisplayedView(R.string.some_text)` |
| `onView(allOf(withText("some text"), isDisplayed()))` | `withDisplayedView("some text")` |

Ordering does not matter.
`onView(allOf(withId(R.id.some_id), isDisplayed()))` is equal to `onView(allOf(isDisplayed(), withId(R.id.some_id)))`.


##How to use

Configure your `build.gradle` and add one dependency and you are ready to go.

```groovy
dependencies {
    androidTestCompile project("com.appsingularity:ristretto:1.0.0")
}
```

##How to learn

Ristretto comes with a set of lint checks that will point out all the places where you can write Ristretto shorthand instead of the longform Espresso.
Just add the Ristretto Lint dependency to your `build.gradle`
```groovy
dependencies {
    compile project("com.appsingularity:ristretto-lint:1.0.0")
}
```
>This will add only the generated `BuildConfig` (with only 1 method) to your code base. But the default Prouard or DexGaurd configuration will strip it out for you since nobody is using it.

###ProGuard
Since Ristretto adds no code to your app (except for the `BuildConfig`) you can safely use Ristretto in combination with ProGuard or DexGuard.

#Version

Version 1.0.0
- Initial release.

#License

    Copyright 2017 Vince M. Treur

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
