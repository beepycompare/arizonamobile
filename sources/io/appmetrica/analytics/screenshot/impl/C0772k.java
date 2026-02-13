package io.appmetrica.analytics.screenshot.impl;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.screenshot.impl.k  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0772k {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f1475a;
    public final List b;
    public final long c;

    public C0772k(boolean z, List list, long j) {
        this.f1475a = z;
        this.b = list;
        this.c = j;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (Intrinsics.areEqual(C0772k.class, obj != null ? obj.getClass() : null)) {
            if (obj != null) {
                C0772k c0772k = (C0772k) obj;
                return this.f1475a == c0772k.f1475a && Intrinsics.areEqual(this.b, c0772k.b) && this.c == c0772k.c;
            }
            throw new NullPointerException("null cannot be cast to non-null type io.appmetrica.analytics.screenshot.impl.config.client.model.ClientSideContentObserverCaptorConfig");
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.b.hashCode();
        return Long.hashCode(this.c) + ((hashCode + (Boolean.hashCode(this.f1475a) * 31)) * 31);
    }

    public final String toString() {
        return "ClientSideContentObserverCaptorConfig(enabled=" + this.f1475a + ", mediaStoreColumnNames=" + this.b + ", detectWindowSeconds=" + this.c + ')';
    }

    public C0772k(B b) {
        this(b.b(), b.c(), b.a());
    }
}
