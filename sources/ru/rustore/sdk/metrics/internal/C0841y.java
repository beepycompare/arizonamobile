package ru.rustore.sdk.metrics.internal;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
/* renamed from: ru.rustore.sdk.metrics.internal.y  reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C0841y {

    /* renamed from: a  reason: collision with root package name */
    public final String f1467a;
    public final String b;
    public final Map<String, String> c;
    public final long d;

    public C0841y() {
        throw null;
    }

    public C0841y(String uuid, String eventName, Map eventData, long j) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(eventData, "eventData");
        this.f1467a = uuid;
        this.b = eventName;
        this.c = eventData;
        this.d = j;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C0841y) {
            C0841y c0841y = (C0841y) obj;
            return Intrinsics.areEqual(this.f1467a, c0841y.f1467a) && Intrinsics.areEqual(this.b, c0841y.b) && Intrinsics.areEqual(this.c, c0841y.c) && this.d == c0841y.d;
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.b.hashCode();
        int hashCode2 = this.c.hashCode();
        return Long.hashCode(this.d) + ((hashCode2 + ((hashCode + (this.f1467a.hashCode() * 31)) * 31)) * 31);
    }

    public final String toString() {
        return "MigrationDtoVer2(uuid=" + ((Object) ("MetricsEventUuid(value=" + this.f1467a + ')')) + ", eventName=" + this.b + ", eventData=" + this.c + ", eventTimeStamp=" + this.d + ')';
    }
}
