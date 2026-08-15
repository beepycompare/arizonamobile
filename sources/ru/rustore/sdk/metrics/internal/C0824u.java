package ru.rustore.sdk.metrics.internal;

import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;
@JvmInline
/* renamed from: ru.rustore.sdk.metrics.internal.u  reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C0824u {

    /* renamed from: a  reason: collision with root package name */
    public final String f1561a;

    public final boolean equals(Object obj) {
        return (obj instanceof C0824u) && Intrinsics.areEqual(this.f1561a, ((C0824u) obj).f1561a);
    }

    public final int hashCode() {
        return this.f1561a.hashCode();
    }

    public final String toString() {
        return "MetricsEventUuid(value=" + this.f1561a + ')';
    }
}
