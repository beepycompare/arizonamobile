package io.appmetrica.analytics.impl;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.impl.z3  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0738z3 implements Z7 {

    /* renamed from: a  reason: collision with root package name */
    public final Map f1224a;
    public final Y7 b;

    public C0738z3(Map<String, String> map, Y7 y7) {
        this.f1224a = map;
        this.b = y7;
    }

    public final C0738z3 a(Map<String, String> map, Y7 y7) {
        return new C0738z3(map, y7);
    }

    public final Map<String, String> b() {
        return this.f1224a;
    }

    public final Y7 c() {
        return this.b;
    }

    public final Map<String, String> d() {
        return this.f1224a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C0738z3) {
            C0738z3 c0738z3 = (C0738z3) obj;
            return Intrinsics.areEqual(this.f1224a, c0738z3.f1224a) && this.b == c0738z3.b;
        }
        return false;
    }

    public final int hashCode() {
        Map map = this.f1224a;
        return this.b.hashCode() + ((map == null ? 0 : map.hashCode()) * 31);
    }

    public final String toString() {
        return "Candidate(clids=" + this.f1224a + ", source=" + this.b + ')';
    }

    public static C0738z3 a(C0738z3 c0738z3, Map map, Y7 y7, int i, Object obj) {
        if ((i & 1) != 0) {
            map = c0738z3.f1224a;
        }
        if ((i & 2) != 0) {
            y7 = c0738z3.b;
        }
        c0738z3.getClass();
        return new C0738z3(map, y7);
    }

    @Override // io.appmetrica.analytics.impl.Z7
    public final Y7 a() {
        return this.b;
    }
}
