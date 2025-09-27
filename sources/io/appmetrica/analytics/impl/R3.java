package io.appmetrica.analytics.impl;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes4.dex */
public final class R3 implements InterfaceC0479o8 {

    /* renamed from: a  reason: collision with root package name */
    public final Q3 f650a;
    public final List b;

    public R3(Q3 q3, List<Q3> list) {
        this.f650a = q3;
        this.b = list;
    }

    public final R3 a(Q3 q3, List<Q3> list) {
        return new R3(q3, list);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0479o8
    public final Object b() {
        return this.f650a;
    }

    public final Q3 c() {
        return this.f650a;
    }

    public final List<Q3> d() {
        return this.b;
    }

    public final Q3 e() {
        return this.f650a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof R3) {
            R3 r3 = (R3) obj;
            return Intrinsics.areEqual(this.f650a, r3.f650a) && Intrinsics.areEqual(this.b, r3.b);
        }
        return false;
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.f650a.hashCode() * 31);
    }

    public final String toString() {
        return "ClidsInfo(chosen=" + this.f650a + ", candidates=" + this.b + ')';
    }

    public static R3 a(R3 r3, Q3 q3, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            q3 = r3.f650a;
        }
        if ((i & 2) != 0) {
            list = r3.b;
        }
        r3.getClass();
        return new R3(q3, list);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0479o8
    public final List<Q3> a() {
        return this.b;
    }
}
