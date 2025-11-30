package io.appmetrica.analytics.impl;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.impl.s3  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0563s3 implements U7 {

    /* renamed from: a  reason: collision with root package name */
    public final Map f1111a;
    public final T7 b;

    public C0563s3(Map<String, String> map, T7 t7) {
        this.f1111a = map;
        this.b = t7;
    }

    public final C0563s3 a(Map<String, String> map, T7 t7) {
        return new C0563s3(map, t7);
    }

    public final Map<String, String> b() {
        return this.f1111a;
    }

    public final T7 c() {
        return this.b;
    }

    public final Map<String, String> d() {
        return this.f1111a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C0563s3) {
            C0563s3 c0563s3 = (C0563s3) obj;
            return Intrinsics.areEqual(this.f1111a, c0563s3.f1111a) && this.b == c0563s3.b;
        }
        return false;
    }

    public final int hashCode() {
        Map map = this.f1111a;
        return this.b.hashCode() + ((map == null ? 0 : map.hashCode()) * 31);
    }

    public final String toString() {
        return "Candidate(clids=" + this.f1111a + ", source=" + this.b + ')';
    }

    public static C0563s3 a(C0563s3 c0563s3, Map map, T7 t7, int i, Object obj) {
        if ((i & 1) != 0) {
            map = c0563s3.f1111a;
        }
        if ((i & 2) != 0) {
            t7 = c0563s3.b;
        }
        c0563s3.getClass();
        return new C0563s3(map, t7);
    }

    @Override // io.appmetrica.analytics.impl.U7
    public final T7 a() {
        return this.b;
    }
}
