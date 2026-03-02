package ru.rustore.sdk.metrics.internal;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
/* renamed from: ru.rustore.sdk.metrics.internal.v  reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C0833v {

    /* renamed from: a  reason: collision with root package name */
    public final String f1627a;
    public final String b;
    public final Map<String, String> c;

    public C0833v() {
        throw null;
    }

    public C0833v(String uuid, String eventName, Map eventData) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(eventData, "eventData");
        this.f1627a = uuid;
        this.b = eventName;
        this.c = eventData;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C0833v) {
            C0833v c0833v = (C0833v) obj;
            return Intrinsics.areEqual(this.f1627a, c0833v.f1627a) && Intrinsics.areEqual(this.b, c0833v.b) && Intrinsics.areEqual(this.c, c0833v.c);
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.b.hashCode();
        return this.c.hashCode() + ((hashCode + (this.f1627a.hashCode() * 31)) * 31);
    }

    public final String toString() {
        return "MigrationDtoVer1(uuid=" + ((Object) ("MetricsEventUuid(value=" + this.f1627a + ')')) + ", eventName=" + this.b + ", eventData=" + this.c + ')';
    }
}
