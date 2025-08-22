package ru.rustore.sdk.metrics.internal;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
/* renamed from: ru.rustore.sdk.metrics.internal.v  reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C0838v {

    /* renamed from: a  reason: collision with root package name */
    public final String f1466a;
    public final String b;
    public final Map<String, String> c;

    public C0838v() {
        throw null;
    }

    public C0838v(String uuid, String eventName, Map eventData) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(eventData, "eventData");
        this.f1466a = uuid;
        this.b = eventName;
        this.c = eventData;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C0838v) {
            C0838v c0838v = (C0838v) obj;
            return Intrinsics.areEqual(this.f1466a, c0838v.f1466a) && Intrinsics.areEqual(this.b, c0838v.b) && Intrinsics.areEqual(this.c, c0838v.c);
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.b.hashCode();
        return this.c.hashCode() + ((hashCode + (this.f1466a.hashCode() * 31)) * 31);
    }

    public final String toString() {
        return "MigrationDtoVer1(uuid=" + ((Object) ("MetricsEventUuid(value=" + this.f1466a + ')')) + ", eventName=" + this.b + ", eventData=" + this.c + ')';
    }
}
