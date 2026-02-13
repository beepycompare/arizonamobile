package io.appmetrica.analytics.impl;

import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.impl.bd  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0145bd {

    /* renamed from: a  reason: collision with root package name */
    public final String f919a;
    public final boolean b;

    public C0145bd(String str, boolean z) {
        this.f919a = str;
        this.b = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C0145bd) {
            C0145bd c0145bd = (C0145bd) obj;
            return Intrinsics.areEqual(this.f919a, c0145bd.f919a) && this.b == c0145bd.b;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int hashCode = this.f919a.hashCode() * 31;
        boolean z = this.b;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return hashCode + i;
    }

    public final String toString() {
        return "ModuleStatus(moduleName=" + this.f919a + ", loaded=" + this.b + ')';
    }
}
