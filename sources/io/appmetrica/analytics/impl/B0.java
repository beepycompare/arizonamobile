package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ndkcrashesapi.internal.NativeCrashSource;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes4.dex */
public final class B0 {

    /* renamed from: a  reason: collision with root package name */
    public final NativeCrashSource f346a;
    public final String b;
    public final String c;
    public final String d;
    public final long e;
    public final C0 f;

    public B0(NativeCrashSource nativeCrashSource, String str, String str2, String str3, long j, C0 c0) {
        this.f346a = nativeCrashSource;
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = j;
        this.f = c0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof B0) {
            B0 b0 = (B0) obj;
            return this.f346a == b0.f346a && Intrinsics.areEqual(this.b, b0.b) && Intrinsics.areEqual(this.c, b0.c) && Intrinsics.areEqual(this.d, b0.d) && this.e == b0.e && Intrinsics.areEqual(this.f, b0.f);
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.b.hashCode();
        int hashCode2 = this.c.hashCode();
        int hashCode3 = this.d.hashCode();
        int hashCode4 = Long.hashCode(this.e);
        return this.f.hashCode() + ((hashCode4 + ((hashCode3 + ((hashCode2 + ((hashCode + (this.f346a.hashCode() * 31)) * 31)) * 31)) * 31)) * 31);
    }

    public final String toString() {
        return "AppMetricaNativeCrash(source=" + this.f346a + ", handlerVersion=" + this.b + ", uuid=" + this.c + ", dumpFile=" + this.d + ", creationTime=" + this.e + ", metadata=" + this.f + ')';
    }
}
