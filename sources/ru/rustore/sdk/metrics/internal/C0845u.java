package ru.rustore.sdk.metrics.internal;

import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;
@JvmInline
/* renamed from: ru.rustore.sdk.metrics.internal.u  reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C0845u {

    /* renamed from: a  reason: collision with root package name */
    public final String f1604a;

    public final boolean equals(Object obj) {
        return (obj instanceof C0845u) && Intrinsics.areEqual(this.f1604a, ((C0845u) obj).f1604a);
    }

    public final int hashCode() {
        return this.f1604a.hashCode();
    }

    public final String toString() {
        return "MetricsEventUuid(value=" + this.f1604a + ')';
    }
}
