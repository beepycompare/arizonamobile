package io.appmetrica.analytics.screenshot.impl;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.screenshot.impl.j  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0788j {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f1452a;
    public final List b;
    public final long c;

    public C0788j(boolean z, List list, long j) {
        this.f1452a = z;
        this.b = list;
        this.c = j;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C0788j) {
            C0788j c0788j = (C0788j) obj;
            return this.f1452a == c0788j.f1452a && Intrinsics.areEqual(this.b, c0788j.b) && this.c == c0788j.c;
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
}
