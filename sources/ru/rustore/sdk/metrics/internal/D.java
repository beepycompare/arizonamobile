package ru.rustore.sdk.metrics.internal;

import kotlin.jvm.internal.Intrinsics;
import ru.rustore.sdk.metrics.MetricsEvent;
/* loaded from: classes6.dex */
public final class D {

    /* renamed from: a  reason: collision with root package name */
    public final String f1414a;
    public final MetricsEvent b;

    public D(String uuid, MetricsEvent metricsEvent) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        Intrinsics.checkNotNullParameter(metricsEvent, "metricsEvent");
        this.f1414a = uuid;
        this.b = metricsEvent;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (Intrinsics.areEqual(D.class, obj != null ? obj.getClass() : null)) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type ru.rustore.sdk.metrics.internal.domain.model.PersistentMetricsEvent");
            D d = (D) obj;
            return Intrinsics.areEqual(this.f1414a, d.f1414a) && Intrinsics.areEqual(this.b, d.b);
        }
        return false;
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.f1414a.hashCode() * 31);
    }
}
