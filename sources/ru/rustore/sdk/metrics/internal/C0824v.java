package ru.rustore.sdk.metrics.internal;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
/* renamed from: ru.rustore.sdk.metrics.internal.v  reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C0824v {

    /* renamed from: a  reason: collision with root package name */
    public final String f1562a;
    public final String b;
    public final Map<String, String> c;

    public C0824v() {
        throw null;
    }

    public C0824v(String uuid, String eventName, Map eventData) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(eventData, "eventData");
        this.f1562a = uuid;
        this.b = eventName;
        this.c = eventData;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C0824v) {
            C0824v c0824v = (C0824v) obj;
            return Intrinsics.areEqual(this.f1562a, c0824v.f1562a) && Intrinsics.areEqual(this.b, c0824v.b) && Intrinsics.areEqual(this.c, c0824v.c);
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.b.hashCode();
        return this.c.hashCode() + ((hashCode + (this.f1562a.hashCode() * 31)) * 31);
    }

    public final String toString() {
        return "MigrationDtoVer1(uuid=" + ((Object) ("MetricsEventUuid(value=" + this.f1562a + ')')) + ", eventName=" + this.b + ", eventData=" + this.c + ')';
    }
}
