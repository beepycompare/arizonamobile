package io.appmetrica.analytics.impl;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.impl.t3  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0587t3 implements R7 {

    /* renamed from: a  reason: collision with root package name */
    public final C0562s3 f1211a;
    public final List b;

    public C0587t3(C0562s3 c0562s3, List<C0562s3> list) {
        this.f1211a = c0562s3;
        this.b = list;
    }

    public final C0587t3 a(C0562s3 c0562s3, List<C0562s3> list) {
        return new C0587t3(c0562s3, list);
    }

    @Override // io.appmetrica.analytics.impl.R7
    public final Object b() {
        return this.f1211a;
    }

    public final C0562s3 c() {
        return this.f1211a;
    }

    public final List<C0562s3> d() {
        return this.b;
    }

    public final C0562s3 e() {
        return this.f1211a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C0587t3) {
            C0587t3 c0587t3 = (C0587t3) obj;
            return Intrinsics.areEqual(this.f1211a, c0587t3.f1211a) && Intrinsics.areEqual(this.b, c0587t3.b);
        }
        return false;
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.f1211a.hashCode() * 31);
    }

    public final String toString() {
        return "ClidsInfo(chosen=" + this.f1211a + ", candidates=" + this.b + ')';
    }

    public static C0587t3 a(C0587t3 c0587t3, C0562s3 c0562s3, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            c0562s3 = c0587t3.f1211a;
        }
        if ((i & 2) != 0) {
            list = c0587t3.b;
        }
        c0587t3.getClass();
        return new C0587t3(c0562s3, list);
    }

    @Override // io.appmetrica.analytics.impl.R7
    public final List<C0562s3> a() {
        return this.b;
    }
}
