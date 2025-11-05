package ru.rustore.sdk.metrics.internal;

import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;
@JvmInline
/* loaded from: classes6.dex */
public final class d0 {

    /* renamed from: a  reason: collision with root package name */
    public final String f1496a;

    public final boolean equals(Object obj) {
        return (obj instanceof d0) && Intrinsics.areEqual(this.f1496a, ((d0) obj).f1496a);
    }

    public final int hashCode() {
        return this.f1496a.hashCode();
    }

    public final String toString() {
        return "VersionName(value=" + this.f1496a + ')';
    }
}
