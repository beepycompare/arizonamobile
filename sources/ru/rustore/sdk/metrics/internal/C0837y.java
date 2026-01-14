package ru.rustore.sdk.metrics.internal;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
/* renamed from: ru.rustore.sdk.metrics.internal.y  reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C0837y {

    /* renamed from: a  reason: collision with root package name */
    public final String f1629a;
    public final String b;
    public final Map<String, String> c;
    public final long d;

    public C0837y() {
        throw null;
    }

    public C0837y(String uuid, String eventName, Map eventData, long j) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(eventData, "eventData");
        this.f1629a = uuid;
        this.b = eventName;
        this.c = eventData;
        this.d = j;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C0837y) {
            C0837y c0837y = (C0837y) obj;
            return Intrinsics.areEqual(this.f1629a, c0837y.f1629a) && Intrinsics.areEqual(this.b, c0837y.b) && Intrinsics.areEqual(this.c, c0837y.c) && this.d == c0837y.d;
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.b.hashCode();
        int hashCode2 = this.c.hashCode();
        return Long.hashCode(this.d) + ((hashCode2 + ((hashCode + (this.f1629a.hashCode() * 31)) * 31)) * 31);
    }

    public final String toString() {
        return "MigrationDtoVer2(uuid=" + ((Object) ("MetricsEventUuid(value=" + this.f1629a + ')')) + ", eventName=" + this.b + ", eventData=" + this.c + ", eventTimeStamp=" + this.d + ')';
    }
}
