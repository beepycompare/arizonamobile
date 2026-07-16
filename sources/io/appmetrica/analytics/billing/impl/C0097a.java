package io.appmetrica.analytics.billing.impl;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.billing.impl.a  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0097a {

    /* renamed from: a  reason: collision with root package name */
    public final List f261a;
    public final boolean b;

    public C0097a(List list, boolean z) {
        this.f261a = list;
        this.b = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C0097a) {
            C0097a c0097a = (C0097a) obj;
            return Intrinsics.areEqual(this.f261a, c0097a.f261a) && this.b == c0097a.b;
        }
        return false;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.b) + (this.f261a.hashCode() * 31);
    }

    public final String toString() {
        return "AutoInappCollectingInfo(billingInfos=" + this.f261a + ", firstInappCheckOccurred=" + this.b + ')';
    }
}
