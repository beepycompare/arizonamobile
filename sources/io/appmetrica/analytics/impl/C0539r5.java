package io.appmetrica.analytics.impl;

import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.impl.r5  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0539r5 implements Sc {

    /* renamed from: a  reason: collision with root package name */
    public final String f1195a;

    public C0539r5(String str) {
        this.f1195a = str;
    }

    public final C0539r5 a(String str) {
        return new C0539r5(str);
    }

    public final String b() {
        return this.f1195a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C0539r5) && Intrinsics.areEqual(this.f1195a, ((C0539r5) obj).f1195a);
    }

    public final int hashCode() {
        return this.f1195a.hashCode();
    }

    public final String toString() {
        return "ConstantModuleEntryPointProvider(className=" + this.f1195a + ')';
    }

    public static C0539r5 a(C0539r5 c0539r5, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = c0539r5.f1195a;
        }
        c0539r5.getClass();
        return new C0539r5(str);
    }

    @Override // io.appmetrica.analytics.impl.Sc
    public final String a() {
        return this.f1195a;
    }
}
