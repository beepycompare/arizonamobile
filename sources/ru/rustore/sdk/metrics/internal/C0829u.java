package ru.rustore.sdk.metrics.internal;

import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;
@JvmInline
/* renamed from: ru.rustore.sdk.metrics.internal.u  reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C0829u {

    /* renamed from: a  reason: collision with root package name */
    public final String f1603a;

    public final boolean equals(Object obj) {
        return (obj instanceof C0829u) && Intrinsics.areEqual(this.f1603a, ((C0829u) obj).f1603a);
    }

    public final int hashCode() {
        return this.f1603a.hashCode();
    }

    public final String toString() {
        return "MetricsEventUuid(value=" + this.f1603a + ')';
    }
}
