package cz.skywall.kguards

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class KGuardsTest {

    @Test
    fun `given nullable vals when guarded then vals smart-casted to nonnull`() {
        val a: String? = null
        val b: String? = "str"

        guard(a, b) { _a, _b ->
            print("${_a.length} ${_b.length}")
        }
    }

    @Test
    fun `given one null and one nonnull val when guarded then block not called`() {
        val a: String? = null
        val b: String? = "str"

        guard(a, b) { _, _ ->
            assert(false)
        }

        assert(true)
    }

    @Test
    fun `given nonnull values when guarded then block called`() {
        val a: String? = "str"
        val b: String? = "str"

        var called = false

        guard(a, b) { _, _ ->
            called = true
        }

        assertTrue(called)
    }

    @Test
    fun `given class instance with nullable vars when guarded then smart-casted to nonnull`() {
        class A {
            var a: String? = null
            var b: String? = "str"
        }

        val a = A()

        guard(a.a, a.b) { _a, _b ->
            _a.length
            _b.length
        }
    }

    @Test
    fun `given first value as null and second nonnull when guarded then guard returns false`() {
        val a: String? = null
        val b: String? = "str"

        val passed = guard(a, b) { _, _ -> }

        assertFalse(passed)
    }

    @Test
    fun `given first value as nonnull and second null when guarded then guard returns false`() {
        val a: String? = "str"
        val b: String? = null

        val passed = guard(a, b) { _, _ -> }

        assertFalse(passed)
    }

    @Test
    fun `given both values nonnull when guarded then guard returns true`() {
        val a: String? = "str"
        val b: String? = "str"

        val passed = guard(a, b) { _, _ -> }

        assertTrue(passed)
    }

    @Test
    fun `given three nonnull values when guarded then block runs`() {
        val a: String? = "str"
        val b: String? = "str"
        val c: String? = "str"

        var called = false

        guard(a, b, c) { _, _, _ ->
            called = true
        }

        assertTrue(called)
    }

    @Test
    fun `given four nonnull values when guarded then block runs`() {
        val a: String? = "str"
        val b: String? = "str"
        val c: String? = "str"
        val d: String? = "str"

        var called = false

        guard(a, b, c, d) { _, _, _, _ ->
            called = true
        }

        assertTrue(called)
    }

    @Test
    fun `given five nonnull values when guarded then block runs`() {
        val a: String? = "str"
        val b: String? = "str"
        val c: String? = "str"
        val d: String? = "str"
        val e: String? = "str"

        var called = false

        guard(a, b, c, d, e) { _, _, _, _, _ ->
            called = true
        }

        assertTrue(called)
    }

    @Test
    fun `given six nonnull values when guarded then block runs`() {
        val a: String? = "str"
        val b: String? = "str"
        val c: String? = "str"
        val d: String? = "str"
        val e: String? = "str"
        val f: String? = "str"

        var called = false

        guard(a, b, c, d, e, f) { _, _, _, _, _, _ ->
            called = true
        }

        assertTrue(called)
    }
}