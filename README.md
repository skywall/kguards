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
Project level `build.gradle`:
```groovy
allprojects {
    repositories {
        maven { url 'https://jitpack.io' }
    }
}
```

Module level `app/build.gradle`:
```groovy
dependencies {
    implementation 'com.github.skywall:kguards:1.0.0'
}
```

### Licence
```
MIT License

Copyright (c) 2020 Lukáš Sztefek

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.```