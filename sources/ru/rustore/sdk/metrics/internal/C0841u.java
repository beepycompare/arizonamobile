package ru.rustore.sdk.metrics.internal;

import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;
@JvmInline
/* renamed from: ru.rustore.sdk.metrics.internal.u  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0841u {

    /* renamed from: a  reason: collision with root package name */
    public final String f1470a;

    public final boolean equals(Object obj) {
        return (obj instanceof C0841u) && Intrinsics.areEqual(this.f1470a, ((C0841u) obj).f1470a);
    }

    public final int hashCode() {
        return this.f1470a.hashCode();
    }

    public final String toString() {
        return "MetricsEventUuid(value=" + this.f1470a + ')';
    }
}
