package io.appmetrica.analytics.impl;

import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.impl.cd  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0166cd {

    /* renamed from: a  reason: collision with root package name */
    public final String f914a;
    public final boolean b;

    public C0166cd(String str, boolean z) {
        this.f914a = str;
        this.b = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C0166cd) {
            C0166cd c0166cd = (C0166cd) obj;
            return Intrinsics.areEqual(this.f914a, c0166cd.f914a) && this.b == c0166cd.b;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int hashCode = this.f914a.hashCode() * 31;
        boolean z = this.b;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return hashCode + i;
    }

    public final String toString() {
        return "ModuleStatus(moduleName=" + this.f914a + ", loaded=" + this.b + ')';
    }
}
