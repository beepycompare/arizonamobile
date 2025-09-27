package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ndkcrashesapi.internal.NativeCrashSource;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes4.dex */
public final class D0 {

    /* renamed from: a  reason: collision with root package name */
    public final NativeCrashSource f400a;
    public final String b;
    public final String c;
    public final String d;
    public final long e;
    public final E0 f;

    public D0(NativeCrashSource nativeCrashSource, String str, String str2, String str3, long j, E0 e0) {
        this.f400a = nativeCrashSource;
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = j;
        this.f = e0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof D0) {
            D0 d0 = (D0) obj;
            return this.f400a == d0.f400a && Intrinsics.areEqual(this.b, d0.b) && Intrinsics.areEqual(this.c, d0.c) && Intrinsics.areEqual(this.d, d0.d) && this.e == d0.e && Intrinsics.areEqual(this.f, d0.f);
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.b.hashCode();
        int hashCode2 = this.c.hashCode();
        int hashCode3 = this.d.hashCode();
        int hashCode4 = Long.hashCode(this.e);
        return this.f.hashCode() + ((hashCode4 + ((hashCode3 + ((hashCode2 + ((hashCode + (this.f400a.hashCode() * 31)) * 31)) * 31)) * 31)) * 31);
    }

    public final String toString() {
        return "AppMetricaNativeCrash(source=" + this.f400a + ", handlerVersion=" + this.b + ", uuid=" + this.c + ", dumpFile=" + this.d + ", creationTime=" + this.e + ", metadata=" + this.f + ')';
    }
}
