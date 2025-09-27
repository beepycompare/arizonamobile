package io.appmetrica.analytics.screenshot.impl;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.screenshot.impl.j  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0779j {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f1326a;
    public final List b;
    public final long c;

    public C0779j(boolean z, List list, long j) {
        this.f1326a = z;
        this.b = list;
        this.c = j;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (Intrinsics.areEqual(C0779j.class, obj != null ? obj.getClass() : null)) {
            if (obj != null) {
                C0779j c0779j = (C0779j) obj;
                return this.f1326a == c0779j.f1326a && Intrinsics.areEqual(this.b, c0779j.b) && this.c == c0779j.c;
            }
            throw new NullPointerException("null cannot be cast to non-null type io.appmetrica.analytics.screenshot.impl.config.client.model.ClientSideContentObserverCaptorConfig");
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.b.hashCode();
        return Long.hashCode(this.c) + ((hashCode + (Boolean.hashCode(this.f1326a) * 31)) * 31);
    }

    public final String toString() {
        return "ClientSideContentObserverCaptorConfig(enabled=" + this.f1326a + ", mediaStoreColumnNames=" + this.b + ", detectWindowSeconds=" + this.c + ')';
    }

    public C0779j(C0794z c0794z) {
        this(c0794z.b(), c0794z.c(), c0794z.a());
    }
}
