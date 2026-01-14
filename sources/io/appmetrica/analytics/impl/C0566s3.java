package io.appmetrica.analytics.impl;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.impl.s3  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0566s3 implements Q7 {

    /* renamed from: a  reason: collision with root package name */
    public final C0541r3 f1217a;
    public final List b;

    public C0566s3(C0541r3 c0541r3, List<C0541r3> list) {
        this.f1217a = c0541r3;
        this.b = list;
    }

    public final C0566s3 a(C0541r3 c0541r3, List<C0541r3> list) {
        return new C0566s3(c0541r3, list);
    }

    @Override // io.appmetrica.analytics.impl.Q7
    public final Object b() {
        return this.f1217a;
    }

    public final C0541r3 c() {
        return this.f1217a;
    }

    public final List<C0541r3> d() {
        return this.b;
    }

    public final C0541r3 e() {
        return this.f1217a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C0566s3) {
            C0566s3 c0566s3 = (C0566s3) obj;
            return Intrinsics.areEqual(this.f1217a, c0566s3.f1217a) && Intrinsics.areEqual(this.b, c0566s3.b);
        }
        return false;
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.f1217a.hashCode() * 31);
    }

    public final String toString() {
        return "ClidsInfo(chosen=" + this.f1217a + ", candidates=" + this.b + ')';
    }

    public static C0566s3 a(C0566s3 c0566s3, C0541r3 c0541r3, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            c0541r3 = c0566s3.f1217a;
        }
        if ((i & 2) != 0) {
            list = c0566s3.b;
        }
        c0566s3.getClass();
        return new C0566s3(c0541r3, list);
    }

    @Override // io.appmetrica.analytics.impl.Q7
    public final List<C0541r3> a() {
        return this.b;
    }
}
