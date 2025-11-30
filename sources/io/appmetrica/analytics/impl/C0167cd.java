package io.appmetrica.analytics.impl;

import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.impl.cd  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0167cd {

    /* renamed from: a  reason: collision with root package name */
    public final String f831a;
    public final boolean b;

    public C0167cd(String str, boolean z) {
        this.f831a = str;
        this.b = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C0167cd) {
            C0167cd c0167cd = (C0167cd) obj;
            return Intrinsics.areEqual(this.f831a, c0167cd.f831a) && this.b == c0167cd.b;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int hashCode = this.f831a.hashCode() * 31;
        boolean z = this.b;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return hashCode + i;
    }

    public final String toString() {
        return "ModuleStatus(moduleName=" + this.f831a + ", loaded=" + this.b + ')';
    }
}
