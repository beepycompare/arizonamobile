package ru.rustore.sdk.metrics.internal;

import kotlin.jvm.internal.Intrinsics;
import ru.rustore.sdk.metrics.MetricsEvent;
/* loaded from: classes6.dex */
public final class P {

    /* renamed from: a  reason: collision with root package name */
    public final String f1594a;
    public final String b;
    public final String c;
    public final String d;
    public final MetricsEvent e;

    public P(String packageName, String uuid, String userId, String str, MetricsEvent metricsEvent) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(metricsEvent, "metricsEvent");
        this.f1594a = packageName;
        this.b = uuid;
        this.c = userId;
        this.d = str;
        this.e = metricsEvent;
    }

    public final boolean equals(Object obj) {
        boolean areEqual;
        if (this == obj) {
            return true;
        }
        if (Intrinsics.areEqual(P.class, obj != null ? obj.getClass() : null)) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type ru.rustore.sdk.metrics.internal.data.dto.RemoteMetricsEventDto");
            P p = (P) obj;
            if (Intrinsics.areEqual(this.f1594a, p.f1594a) && Intrinsics.areEqual(this.b, p.b) && Intrinsics.areEqual(this.c, p.c)) {
                String str = this.d;
                String str2 = p.d;
                if (str == null) {
                    if (str2 == null) {
                        areEqual = true;
                    }
                    areEqual = false;
                } else {
                    if (str2 != null) {
                        areEqual = Intrinsics.areEqual(str, str2);
                    }
                    areEqual = false;
                }
                return areEqual && Intrinsics.areEqual(this.e, p.e);
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = (this.c.hashCode() + ((this.b.hashCode() + (this.f1594a.hashCode() * 31)) * 31)) * 31;
        String str = this.d;
        d0 d0Var = str != null ? new d0(str) : null;
        return this.e.hashCode() + ((hashCode + (d0Var != null ? d0Var.f1609a.hashCode() : 0)) * 31);
    }
}
