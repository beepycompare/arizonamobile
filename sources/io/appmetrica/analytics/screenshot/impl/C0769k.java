package io.appmetrica.analytics.screenshot.impl;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.screenshot.impl.k  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0769k {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f1367a;
    public final List b;
    public final long c;

    public C0769k(boolean z, List list, long j) {
        this.f1367a = z;
        this.b = list;
        this.c = j;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (Intrinsics.areEqual(C0769k.class, obj != null ? obj.getClass() : null)) {
            if (obj != null) {
                C0769k c0769k = (C0769k) obj;
                return this.f1367a == c0769k.f1367a && Intrinsics.areEqual(this.b, c0769k.b) && this.c == c0769k.c;
            }
            throw new NullPointerException("null cannot be cast to non-null type io.appmetrica.analytics.screenshot.impl.config.client.model.ClientSideContentObserverCaptorConfig");
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.b.hashCode();
        return Long.hashCode(this.c) + ((hashCode + (Boolean.hashCode(this.f1367a) * 31)) * 31);
    }

    public final String toString() {
        return "ClientSideContentObserverCaptorConfig(enabled=" + this.f1367a + ", mediaStoreColumnNames=" + this.b + ", detectWindowSeconds=" + this.c + ')';
    }

    public C0769k(B b) {
        this(b.b(), b.c(), b.a());
    }
}
