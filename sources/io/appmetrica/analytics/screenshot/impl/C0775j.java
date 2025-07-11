package io.appmetrica.analytics.screenshot.impl;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.screenshot.impl.j  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0775j {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f1303a;
    public final List b;
    public final long c;

    public C0775j(boolean z, List list, long j) {
        this.f1303a = z;
        this.b = list;
        this.c = j;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (Intrinsics.areEqual(C0775j.class, obj != null ? obj.getClass() : null)) {
            if (obj != null) {
                C0775j c0775j = (C0775j) obj;
                return this.f1303a == c0775j.f1303a && Intrinsics.areEqual(this.b, c0775j.b) && this.c == c0775j.c;
            }
            throw new NullPointerException("null cannot be cast to non-null type io.appmetrica.analytics.screenshot.impl.config.client.model.ClientSideContentObserverCaptorConfig");
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.b.hashCode();
        return Long.hashCode(this.c) + ((hashCode + (Boolean.hashCode(this.f1303a) * 31)) * 31);
    }

    public final String toString() {
        return "ClientSideContentObserverCaptorConfig(enabled=" + this.f1303a + ", mediaStoreColumnNames=" + this.b + ", detectWindowSeconds=" + this.c + ')';
    }

    public C0775j(C0790z c0790z) {
        this(c0790z.b(), c0790z.c(), c0790z.a());
    }
}
