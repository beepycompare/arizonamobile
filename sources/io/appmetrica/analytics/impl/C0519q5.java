package io.appmetrica.analytics.impl;

import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.impl.q5  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0519q5 implements Rc {

    /* renamed from: a  reason: collision with root package name */
    public final String f1184a;

    public C0519q5(String str) {
        this.f1184a = str;
    }

    public final C0519q5 a(String str) {
        return new C0519q5(str);
    }

    public final String b() {
        return this.f1184a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C0519q5) && Intrinsics.areEqual(this.f1184a, ((C0519q5) obj).f1184a);
    }

    public final int hashCode() {
        return this.f1184a.hashCode();
    }

    public final String toString() {
        return "ConstantModuleEntryPointProvider(className=" + this.f1184a + ')';
    }

    public static C0519q5 a(C0519q5 c0519q5, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = c0519q5.f1184a;
        }
        c0519q5.getClass();
        return new C0519q5(str);
    }

    @Override // io.appmetrica.analytics.impl.Rc
    public final String a() {
        return this.f1184a;
    }
}
