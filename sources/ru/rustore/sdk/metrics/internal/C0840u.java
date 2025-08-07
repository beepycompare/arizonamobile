package ru.rustore.sdk.metrics.internal;

import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;
@JvmInline
/* renamed from: ru.rustore.sdk.metrics.internal.u  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0840u {

    /* renamed from: a  reason: collision with root package name */
    public final String f1455a;

    public final boolean equals(Object obj) {
        return (obj instanceof C0840u) && Intrinsics.areEqual(this.f1455a, ((C0840u) obj).f1455a);
    }

    public final int hashCode() {
        return this.f1455a.hashCode();
    }

    public final String toString() {
        return "MetricsEventUuid(value=" + this.f1455a + ')';
    }
}
