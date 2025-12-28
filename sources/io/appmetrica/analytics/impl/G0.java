package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ndkcrashesapi.internal.NativeCrashSource;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class G0 {

    /* renamed from: a  reason: collision with root package name */
    public final NativeCrashSource f585a;
    public final String b;
    public final String c;
    public final String d;
    public final long e;
    public final H0 f;

    public G0(NativeCrashSource nativeCrashSource, String str, String str2, String str3, long j, H0 h0) {
        this.f585a = nativeCrashSource;
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = j;
        this.f = h0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof G0) {
            G0 g0 = (G0) obj;
            return this.f585a == g0.f585a && Intrinsics.areEqual(this.b, g0.b) && Intrinsics.areEqual(this.c, g0.c) && Intrinsics.areEqual(this.d, g0.d) && this.e == g0.e && Intrinsics.areEqual(this.f, g0.f);
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
