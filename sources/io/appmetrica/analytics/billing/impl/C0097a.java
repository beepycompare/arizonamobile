package io.appmetrica.analytics.billing.impl;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.billing.impl.a  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0097a {

    /* renamed from: a  reason: collision with root package name */
    public final List f207a;
    public final boolean b;

    public C0097a(List list, boolean z) {
        this.f207a = list;
        this.b = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C0097a) {
            C0097a c0097a = (C0097a) obj;
            return Intrinsics.areEqual(this.f207a, c0097a.f207a) && this.b == c0097a.b;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int hashCode = this.f207a.hashCode() * 31;
        boolean z = this.b;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return hashCode + i;
    }

    public final String toString() {
        return "AutoInappCollectingInfo(billingInfos=" + this.f207a + ", firstInappCheckOccurred=" + this.b + ')';
    }
}
