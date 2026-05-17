package io.appmetrica.analytics.impl;

import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.impl.q5  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0518q5 implements Rc {

    /* renamed from: a  reason: collision with root package name */
    public final String f1189a;

    public C0518q5(String str) {
        this.f1189a = str;
    }

    public final C0518q5 a(String str) {
        return new C0518q5(str);
    }

    public final String b() {
        return this.f1189a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C0518q5) && Intrinsics.areEqual(this.f1189a, ((C0518q5) obj).f1189a);
    }

    public final int hashCode() {
        return this.f1189a.hashCode();
    }

    public final String toString() {
        return "ConstantModuleEntryPointProvider(className=" + this.f1189a + ')';
    }

    public static C0518q5 a(C0518q5 c0518q5, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = c0518q5.f1189a;
        }
        c0518q5.getClass();
        return new C0518q5(str);
    }

    @Override // io.appmetrica.analytics.impl.Rc
    public final String a() {
        return this.f1189a;
    }
}
