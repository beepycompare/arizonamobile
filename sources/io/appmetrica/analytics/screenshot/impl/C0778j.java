package io.appmetrica.analytics.screenshot.impl;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.screenshot.impl.j  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0778j {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f1306a;
    public final List b;
    public final long c;

    public C0778j(boolean z, List list, long j) {
        this.f1306a = z;
        this.b = list;
        this.c = j;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (Intrinsics.areEqual(C0778j.class, obj != null ? obj.getClass() : null)) {
            if (obj != null) {
                C0778j c0778j = (C0778j) obj;
                return this.f1306a == c0778j.f1306a && Intrinsics.areEqual(this.b, c0778j.b) && this.c == c0778j.c;
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

    public C0778j(C0793z c0793z) {
        this(c0793z.b(), c0793z.c(), c0793z.a());
    }
}
