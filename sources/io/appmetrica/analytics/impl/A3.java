package io.appmetrica.analytics.impl;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class A3 implements W7 {

    /* renamed from: a  reason: collision with root package name */
    public final C0738z3 f389a;
    public final List b;

    public A3(C0738z3 c0738z3, List<C0738z3> list) {
        this.f389a = c0738z3;
        this.b = list;
    }

    public final A3 a(C0738z3 c0738z3, List<C0738z3> list) {
        return new A3(c0738z3, list);
    }

    @Override // io.appmetrica.analytics.impl.W7
    public final Object b() {
        return this.f389a;
    }

    public final C0738z3 c() {
        return this.f389a;
    }

    public final List<C0738z3> d() {
        return this.b;
    }

    public final C0738z3 e() {
        return this.f389a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof A3) {
            A3 a3 = (A3) obj;
            return Intrinsics.areEqual(this.f389a, a3.f389a) && Intrinsics.areEqual(this.b, a3.b);
        }
        return false;
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.f389a.hashCode() * 31);
    }

    public final String toString() {
        return "ClidsInfo(chosen=" + this.f389a + ", candidates=" + this.b + ')';
    }

    public static A3 a(A3 a3, C0738z3 c0738z3, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            c0738z3 = a3.f389a;
        }
        if ((i & 2) != 0) {
            list = a3.b;
        }
        a3.getClass();
        return new A3(c0738z3, list);
    }

    @Override // io.appmetrica.analytics.impl.W7
    public final List<C0738z3> a() {
        return this.b;
    }
}
