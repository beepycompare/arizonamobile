package ru.rustore.sdk.metrics.internal;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
/* renamed from: ru.rustore.sdk.metrics.internal.y  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0844y {

    /* renamed from: a  reason: collision with root package name */
    public final String f1457a;
    public final String b;
    public final Map<String, String> c;
    public final long d;

    public C0844y() {
        throw null;
    }

    public C0844y(String uuid, String eventName, Map eventData, long j) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(eventData, "eventData");
        this.f1457a = uuid;
        this.b = eventName;
        this.c = eventData;
        this.d = j;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C0844y) {
            C0844y c0844y = (C0844y) obj;
            return Intrinsics.areEqual(this.f1457a, c0844y.f1457a) && Intrinsics.areEqual(this.b, c0844y.b) && Intrinsics.areEqual(this.c, c0844y.c) && this.d == c0844y.d;
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.b.hashCode();
        int hashCode2 = this.c.hashCode();
        return Long.hashCode(this.d) + ((hashCode2 + ((hashCode + (this.f1457a.hashCode() * 31)) * 31)) * 31);
    }

    public final String toString() {
        return "MigrationDtoVer2(uuid=" + ((Object) ("MetricsEventUuid(value=" + this.f1457a + ')')) + ", eventName=" + this.b + ", eventData=" + this.c + ", eventTimeStamp=" + this.d + ')';
    }
}
