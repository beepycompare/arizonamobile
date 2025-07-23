package io.appmetrica.analytics.screenshot.impl;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.screenshot.impl.j  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0777j {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f1306a;
    public final List b;
    public final long c;

    public C0777j(boolean z, List list, long j) {
        this.f1306a = z;
        this.b = list;
        this.c = j;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (Intrinsics.areEqual(C0777j.class, obj != null ? obj.getClass() : null)) {
            if (obj != null) {
                C0777j c0777j = (C0777j) obj;
                return this.f1306a == c0777j.f1306a && Intrinsics.areEqual(this.b, c0777j.b) && this.c == c0777j.c;
            }
            throw new NullPointerException("null cannot be cast to non-null type io.appmetrica.analytics.screenshot.impl.config.client.model.ClientSideContentObserverCaptorConfig");
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.b.hashCode();
        return Long.hashCode(this.c) + ((hashCode + (Boolean.hashCode(this.f1306a) * 31)) * 31);
    }

    public final String toString() {
        return "ClientSideContentObserverCaptorConfig(enabled=" + this.f1306a + ", mediaStoreColumnNames=" + this.b + ", detectWindowSeconds=" + this.c + ')';
    }

    public C0777j(C0792z c0792z) {
        this(c0792z.b(), c0792z.c(), c0792z.a());
    }
}
