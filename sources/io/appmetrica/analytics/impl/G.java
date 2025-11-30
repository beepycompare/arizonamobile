package io.appmetrica.analytics.impl;

import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class G {

    /* renamed from: a  reason: collision with root package name */
    public final int f486a;
    public final int b;
    public final int c;

    public G(int i, int i2, int i3) {
        this.f486a = i;
        this.b = i2;
        this.c = i3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (Intrinsics.areEqual(G.class, obj != null ? obj.getClass() : null)) {
            if (obj != null) {
                G g = (G) obj;
                return this.f486a == g.f486a && this.b == g.b && this.c == g.c;
            }
            throw new NullPointerException("null cannot be cast to non-null type io.appmetrica.analytics.impl.id.AdvIdGetterController.CanTrackIdentifiers");
        }
        return false;
    }

    public final int hashCode() {
        int a2 = L7.a(this.b);
        return L7.a(this.c) + ((a2 + (L7.a(this.f486a) * 31)) * 31);
    }

    public final String toString() {
        return "CanTrackIdentifiers(canTrackGaid=" + H.a(this.f486a) + ", canTrackHoaid=" + H.a(this.b) + ", canTrackYandexAdvId=" + H.a(this.c) + ')';
    }
}
