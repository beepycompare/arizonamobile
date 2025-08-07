package ru.rustore.sdk.metrics.internal;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
/* renamed from: ru.rustore.sdk.metrics.internal.v  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0841v {

    /* renamed from: a  reason: collision with root package name */
    public final String f1456a;
    public final String b;
    public final Map<String, String> c;

    public C0841v() {
        throw null;
    }

    public C0841v(String uuid, String eventName, Map eventData) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(eventData, "eventData");
        this.f1456a = uuid;
        this.b = eventName;
        this.c = eventData;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C0841v) {
            C0841v c0841v = (C0841v) obj;
            return Intrinsics.areEqual(this.f1456a, c0841v.f1456a) && Intrinsics.areEqual(this.b, c0841v.b) && Intrinsics.areEqual(this.c, c0841v.c);
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.b.hashCode();
        return this.c.hashCode() + ((hashCode + (this.f1456a.hashCode() * 31)) * 31);
    }

    public final String toString() {
        return "MigrationDtoVer1(uuid=" + ((Object) ("MetricsEventUuid(value=" + this.f1456a + ')')) + ", eventName=" + this.b + ", eventData=" + this.c + ')';
    }
}
