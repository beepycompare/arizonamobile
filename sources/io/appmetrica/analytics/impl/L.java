package io.appmetrica.analytics.impl;

import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class L {

    /* renamed from: a  reason: collision with root package name */
    public final M f637a;
    public final M b;
    public final M c;

    public L(M m, M m2, M m3) {
        this.f637a = m;
        this.b = m2;
        this.c = m3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (Intrinsics.areEqual(L.class, obj != null ? obj.getClass() : null)) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type io.appmetrica.analytics.impl.id.AdvIdGetterController.CanTrackIdentifiers");
            L l = (L) obj;
            return this.f637a == l.f637a && this.b == l.b && this.c == l.c;
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.b.hashCode();
        return this.c.hashCode() + ((hashCode + (this.f637a.hashCode() * 31)) * 31);
    }

    public final String toString() {
        return "CanTrackIdentifiers(canTrackGaid=" + this.f637a + ", canTrackHoaid=" + this.b + ", canTrackYandexAdvId=" + this.c + ')';
    }
}
