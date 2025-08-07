package ru.rustore.sdk.metrics.internal;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class J {

    /* renamed from: a  reason: collision with root package name */
    public final String f1412a;
    public final byte[] b;

    public J(String uuid, byte[] serializedMetricsEvent) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        Intrinsics.checkNotNullParameter(serializedMetricsEvent, "serializedMetricsEvent");
        this.f1412a = uuid;
        this.b = serializedMetricsEvent;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (Intrinsics.areEqual(J.class, obj != null ? obj.getClass() : null)) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type ru.rustore.sdk.metrics.internal.data.dto.PersistentMetricsEventDto");
            J j = (J) obj;
            return Intrinsics.areEqual(this.f1412a, j.f1412a) && Arrays.equals(this.b, j.b);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(this.b) + (this.f1412a.hashCode() * 31);
    }
}
