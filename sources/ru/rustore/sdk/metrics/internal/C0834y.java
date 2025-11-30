package ru.rustore.sdk.metrics.internal;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
/* renamed from: ru.rustore.sdk.metrics.internal.y  reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C0834y {

    /* renamed from: a  reason: collision with root package name */
    public final String f1522a;
    public final String b;
    public final Map<String, String> c;
    public final long d;

    public C0834y() {
        throw null;
    }

    public C0834y(String uuid, String eventName, Map eventData, long j) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(eventData, "eventData");
        this.f1522a = uuid;
        this.b = eventName;
        this.c = eventData;
        this.d = j;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C0834y) {
            C0834y c0834y = (C0834y) obj;
            return Intrinsics.areEqual(this.f1522a, c0834y.f1522a) && Intrinsics.areEqual(this.b, c0834y.b) && Intrinsics.areEqual(this.c, c0834y.c) && this.d == c0834y.d;
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.b.hashCode();
        int hashCode2 = this.c.hashCode();
        return Long.hashCode(this.d) + ((hashCode2 + ((hashCode + (this.f1522a.hashCode() * 31)) * 31)) * 31);
    }

    public final String toString() {
        return "MigrationDtoVer2(uuid=" + ((Object) ("MetricsEventUuid(value=" + this.f1522a + ')')) + ", eventName=" + this.b + ", eventData=" + this.c + ", eventTimeStamp=" + this.d + ')';
    }
}
