package io.appmetrica.analytics.impl;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes4.dex */
public final class O3 implements InterfaceC0285g8 {

    /* renamed from: a  reason: collision with root package name */
    public final N3 f562a;
    public final List b;

    public O3(N3 n3, List<N3> list) {
        this.f562a = n3;
        this.b = list;
    }

    public final O3 a(N3 n3, List<N3> list) {
        return new O3(n3, list);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0285g8
    public final Object b() {
        return this.f562a;
    }

    public final N3 c() {
        return this.f562a;
    }

    public final List<N3> d() {
        return this.b;
    }

    public final N3 e() {
        return this.f562a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof O3) {
            O3 o3 = (O3) obj;
            return Intrinsics.areEqual(this.f562a, o3.f562a) && Intrinsics.areEqual(this.b, o3.b);
        }
        return false;
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.f562a.hashCode() * 31);
    }

    public final String toString() {
        return "ClidsInfo(chosen=" + this.f562a + ", candidates=" + this.b + ')';
    }

    public static O3 a(O3 o3, N3 n3, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            n3 = o3.f562a;
        }
        if ((i & 2) != 0) {
            list = o3.b;
        }
        o3.getClass();
        return new O3(n3, list);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0285g8
    public final List<N3> a() {
        return this.b;
    }
}
