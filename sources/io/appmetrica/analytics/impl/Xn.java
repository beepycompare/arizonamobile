package io.appmetrica.analytics.impl;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class Xn {

    /* renamed from: a  reason: collision with root package name */
    public final String f844a;
    public final long b;
    public final byte[] c;

    public Xn(String str, long j, byte[] bArr) {
        this.f844a = str;
        this.b = j;
        this.c = bArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (Intrinsics.areEqual(Xn.class, obj != null ? obj.getClass() : null)) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type io.appmetrica.analytics.impl.db.storage.TempCachePutTask");
            Xn xn = (Xn) obj;
            if (Intrinsics.areEqual(this.f844a, xn.f844a) && this.b == xn.b) {
                return Arrays.equals(this.c, xn.c);
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = Long.hashCode(this.b);
        return Arrays.hashCode(this.c) + ((hashCode + (this.f844a.hashCode() * 31)) * 31);
    }

    public final String toString() {
        return "TempCachePutTask(scope='" + this.f844a + "', timestamp=" + this.b + ", data=" + this.c + ')';
    }
}
