package io.appmetrica.analytics.screenshot.impl;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.screenshot.impl.k  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0768k {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f1452a;
    public final List b;
    public final long c;

    public C0768k(boolean z, List list, long j) {
        this.f1452a = z;
        this.b = list;
        this.c = j;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (Intrinsics.areEqual(C0768k.class, obj != null ? obj.getClass() : null)) {
            if (obj != null) {
                C0768k c0768k = (C0768k) obj;
                return this.f1452a == c0768k.f1452a && Intrinsics.areEqual(this.b, c0768k.b) && this.c == c0768k.c;
            }
            throw new NullPointerException("null cannot be cast to non-null type io.appmetrica.analytics.screenshot.impl.config.client.model.ClientSideContentObserverCaptorConfig");
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.b.hashCode();
        return Long.hashCode(this.c) + ((hashCode + (Boolean.hashCode(this.f1452a) * 31)) * 31);
    }

    public final String toString() {
        return "ClientSideContentObserverCaptorConfig(enabled=" + this.f1452a + ", mediaStoreColumnNames=" + this.b + ", detectWindowSeconds=" + this.c + ')';
    }

    public C0768k(B b) {
        this(b.b(), b.c(), b.a());
    }
}
