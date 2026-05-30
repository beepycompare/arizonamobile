package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ndkcrashesapi.internal.NativeCrashSource;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class I0 {

    /* renamed from: a  reason: collision with root package name */
    public final NativeCrashSource f585a;
    public final String b;
    public final String c;
    public final String d;
    public final long e;
    public final J0 f;

    public I0(NativeCrashSource nativeCrashSource, String str, String str2, String str3, long j, J0 j0) {
        this.f585a = nativeCrashSource;
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = j;
        this.f = j0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof I0) {
            I0 i0 = (I0) obj;
            return this.f585a == i0.f585a && Intrinsics.areEqual(this.b, i0.b) && Intrinsics.areEqual(this.c, i0.c) && Intrinsics.areEqual(this.d, i0.d) && this.e == i0.e && Intrinsics.areEqual(this.f, i0.f);
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.b.hashCode();
        int hashCode2 = this.c.hashCode();
        int hashCode3 = this.d.hashCode();
        int hashCode4 = Long.hashCode(this.e);
        return this.f.hashCode() + ((hashCode4 + ((hashCode3 + ((hashCode2 + ((hashCode + (this.f585a.hashCode() * 31)) * 31)) * 31)) * 31)) * 31);
    }

    public final String toString() {
        return "AppMetricaNativeCrash(source=" + this.f585a + ", handlerVersion=" + this.b + ", uuid=" + this.c + ", dumpFile=" + this.d + ", creationTime=" + this.e + ", metadata=" + this.f + ')';
    }
}
