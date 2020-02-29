package cz.skywall.kguards

fun <A, B> guard(a: A?, b: B?, block: (a: A, b: B) -> Unit): Boolean {
    return a?.let { _a ->
        b?.let { _b ->
            block.invoke(_a, _b)
            return true
        }
    } ?: false
}

fun <A, B, C> guard(a: A?, b: B?, c: C?, block: (a: A, b: B, c: C) -> Unit): Boolean {
    return a?.let { _a ->
        b?.let { _b ->
            c?.let { _c ->
                block.invoke(_a, _b, _c)
                return true
            }
        }
    } ?: false
}

fun <A, B, C, D> guard(a: A?, b: B?, c: C?, d: D?, block: (a: A, b: B, c: C, d: D) -> Unit): Boolean {
    return a?.let { _a ->
        b?.let { _b ->
            c?.let { _c ->
                d?.let { _d ->
                    block.invoke(_a, _b, _c, _d)
                    return true
                }
            }
        }
    } ?: false
}

fun <A, B, C, D, E> guard(a: A?, b: B?, c: C?, d: D?, e: E?, block: (a: A, b: B, c: C, d: D, e: E) -> Unit): Boolean {
    return a?.let { _a ->
        b?.let { _b ->
            c?.let { _c ->
                d?.let { _d ->
                    e?.let { _e ->
                        block.invoke(_a, _b, _c, _d, _e)
                        return true
                    }
                }
            }
        }
    } ?: false
}

fun <A, B, C, D, E, F> guard(
    a: A?,
    b: B?,
    c: C?,
    d: D?,
    e: E?,
    f: F?,
    block: (a: A, b: B, c: C, d: D, e: E, f: F) -> Unit
): Boolean {
    return a?.let { _a ->
        b?.let { _b ->
            c?.let { _c ->
                d?.let { _d ->
                    e?.let { _e ->
                        f?.let { _f ->
                            block.invoke(_a, _b, _c, _d, _e, _f)
                            return true
                        }
                    }
                }
            }
        }
    } ?: false
}
