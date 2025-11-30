package ru.rustore.sdk.metrics.internal;

import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;
@JvmInline
/* renamed from: ru.rustore.sdk.metrics.internal.u  reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C0830u {

    /* renamed from: a  reason: collision with root package name */
    public final String f1520a;

    public final boolean equals(Object obj) {
        return (obj instanceof C0830u) && Intrinsics.areEqual(this.f1520a, ((C0830u) obj).f1520a);
    }

    public final int hashCode() {
        return this.f1520a.hashCode();
    }

    public final String toString() {
        return "MetricsEventUuid(value=" + this.f1520a + ')';
    }
}
