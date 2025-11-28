package io.appmetrica.analytics.impl;

import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.impl.x5  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0690x5 implements Yc {

    /* renamed from: a  reason: collision with root package name */
    public final String f1198a;

    public C0690x5(String str) {
        this.f1198a = str;
    }

    public final C0690x5 a(String str) {
        return new C0690x5(str);
    }

    public final String b() {
        return this.f1198a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C0690x5) && Intrinsics.areEqual(this.f1198a, ((C0690x5) obj).f1198a);
    }

    public final int hashCode() {
        return this.f1198a.hashCode();
    }

    public final String toString() {
        return "ConstantModuleEntryPointProvider(className=" + this.f1198a + ')';
    }

    public static C0690x5 a(C0690x5 c0690x5, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = c0690x5.f1198a;
        }
        c0690x5.getClass();
        return new C0690x5(str);
    }

    @Override // io.appmetrica.analytics.impl.Yc
    public final String a() {
        return this.f1198a;
    }
}
