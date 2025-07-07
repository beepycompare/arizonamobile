package io.appmetrica.analytics.screenshot.impl;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.screenshot.impl.j  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0783j {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f1302a;
    public final List b;
    public final long c;

    public C0783j(boolean z, List list, long j) {
        this.f1302a = z;
        this.b = list;
        this.c = j;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (Intrinsics.areEqual(C0783j.class, obj != null ? obj.getClass() : null)) {
            if (obj != null) {
                C0783j c0783j = (C0783j) obj;
                return this.f1302a == c0783j.f1302a && Intrinsics.areEqual(this.b, c0783j.b) && this.c == c0783j.c;
            }
            throw new NullPointerException("null cannot be cast to non-null type io.appmetrica.analytics.screenshot.impl.config.client.model.ClientSideContentObserverCaptorConfig");
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.b.hashCode();
        return Long.hashCode(this.c) + ((hashCode + (Boolean.hashCode(this.f1302a) * 31)) * 31);
    }

    public final String toString() {
        return "ClientSideContentObserverCaptorConfig(enabled=" + this.f1302a + ", mediaStoreColumnNames=" + this.b + ", detectWindowSeconds=" + this.c + ')';
    }

    public C0783j(C0798z c0798z) {
        this(c0798z.b(), c0798z.c(), c0798z.a());
    }
}
