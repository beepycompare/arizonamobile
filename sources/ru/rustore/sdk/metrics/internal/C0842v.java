package ru.rustore.sdk.metrics.internal;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
/* renamed from: ru.rustore.sdk.metrics.internal.v  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0842v {

    /* renamed from: a  reason: collision with root package name */
    public final String f1471a;
    public final String b;
    public final Map<String, String> c;

    public C0842v() {
        throw null;
    }

    public C0842v(String uuid, String eventName, Map eventData) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(eventData, "eventData");
        this.f1471a = uuid;
        this.b = eventName;
        this.c = eventData;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C0842v) {
            C0842v c0842v = (C0842v) obj;
            return Intrinsics.areEqual(this.f1471a, c0842v.f1471a) && Intrinsics.areEqual(this.b, c0842v.b) && Intrinsics.areEqual(this.c, c0842v.c);
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.b.hashCode();
        return this.c.hashCode() + ((hashCode + (this.f1471a.hashCode() * 31)) * 31);
    }

    public final String toString() {
        return "MigrationDtoVer1(uuid=" + ((Object) ("MetricsEventUuid(value=" + this.f1471a + ')')) + ", eventName=" + this.b + ", eventData=" + this.c + ')';
    }
}
