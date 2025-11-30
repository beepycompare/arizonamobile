package ru.rustore.sdk.metrics.internal;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
/* renamed from: ru.rustore.sdk.metrics.internal.v  reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C0831v {

    /* renamed from: a  reason: collision with root package name */
    public final String f1521a;
    public final String b;
    public final Map<String, String> c;

    public C0831v() {
        throw null;
    }

    public C0831v(String uuid, String eventName, Map eventData) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(eventData, "eventData");
        this.f1521a = uuid;
        this.b = eventName;
        this.c = eventData;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C0831v) {
            C0831v c0831v = (C0831v) obj;
            return Intrinsics.areEqual(this.f1521a, c0831v.f1521a) && Intrinsics.areEqual(this.b, c0831v.b) && Intrinsics.areEqual(this.c, c0831v.c);
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.b.hashCode();
        return this.c.hashCode() + ((hashCode + (this.f1521a.hashCode() * 31)) * 31);
    }

    public final String toString() {
        return "MigrationDtoVer1(uuid=" + ((Object) ("MetricsEventUuid(value=" + this.f1521a + ')')) + ", eventName=" + this.b + ", eventData=" + this.c + ')';
    }
}
