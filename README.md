## KGuards
[![](https://jitpack.io/v/skywall/KGuards.svg)](https://jitpack.io/#skywall/KGuards)
![Check Master](https://github.com/skywall/KGuards/workflows/Check%20Master/badge.svg?branch=master)

Set of simple functions which transforms nested `let` calls into the single one. For example, imagine three nested `let` statements:
```kotlin
class Test {
    var a: String? = null
    var b: String? = null
    var c: String? = null

    fun foo() {
        a?.let { _a ->
            b?.let { _b ->
                c?.let { _c ->
                    bar(_a, _b, _c)
                }
            }
        }
    }

    fun bar(a: String, b: String, c: String) { }
}
```

KGuards library allows you to wrap this into the single function:
```kotlin
class Test {
    var a: String? = null
    var b: String? = null
    var c: String? = null

    fun foo() {
        guard(a, b, c) { _a, _b, _c ->
            bar(_a, _b, _c) //
        }
    }

    fun bar(a: String, b: String, c: String) { }
}
```

Function `guard` returns `true` whether all of the values weren't null and guarded
block were called. It returns `false` whenever at least one guarded variable is `null`.

### Download
build.gradle:
```groovy
allprojects {
    repositories {
        maven { url 'https://jitpack.io' }
    }
}
```

app/build.gradle:
```groovy
dependencies {
    implementation 'com.github.skywall:kguards:1.0.0'
}
```