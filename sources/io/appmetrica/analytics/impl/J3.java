package io.appmetrica.analytics.impl;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class J3 implements InterfaceC0322i8 {

    /* renamed from: a  reason: collision with root package name */
    public final I3 f607a;
    public final List b;

    public J3(I3 i3, List<I3> list) {
        this.f607a = i3;
        this.b = list;
    }

    public final J3 a(I3 i3, List<I3> list) {
        return new J3(i3, list);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0322i8
    public final Object b() {
        return this.f607a;
    }

    public final I3 c() {
        return this.f607a;
    }

    public final List<I3> d() {
        return this.b;
    }

    public final I3 e() {
        return this.f607a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof J3) {
            J3 j3 = (J3) obj;
            return Intrinsics.areEqual(this.f607a, j3.f607a) && Intrinsics.areEqual(this.b, j3.b);
        }
        return false;
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.f607a.hashCode() * 31);
    }

    public final String toString() {
        return "ClidsInfo(chosen=" + this.f607a + ", candidates=" + this.b + ')';
    }

    public static J3 a(J3 j3, I3 i3, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            i3 = j3.f607a;
        }
        if ((i & 2) != 0) {
            list = j3.b;
        }
        j3.getClass();
        return new J3(i3, list);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0322i8
    public final List<I3> a() {
        return this.b;
    }
}
