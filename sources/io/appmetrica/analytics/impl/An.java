package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.TempCacheStorage;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes4.dex */
public final class An implements TempCacheStorage.Entry {

    /* renamed from: a  reason: collision with root package name */
    public final long f357a;
    public final String b;
    public final long c;
    public final byte[] d;

    public An(long j, String str, long j2, byte[] bArr) {
        this.f357a = j;
        this.b = str;
        this.c = j2;
        this.d = bArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (Intrinsics.areEqual(An.class, obj != null ? obj.getClass() : null)) {
            if (obj != null) {
                An an = (An) obj;
                if (this.f357a == an.f357a && Intrinsics.areEqual(this.b, an.b) && this.c == an.c) {
                    return Arrays.equals(this.d, an.d);
                }
                return false;
            }
            throw new NullPointerException("null cannot be cast to non-null type io.appmetrica.analytics.impl.db.storage.TempCacheEntry");
        }
        return false;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.TempCacheStorage.Entry
    public final byte[] getData() {
        return this.d;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.TempCacheStorage.Entry
    public final long getId() {
        return this.f357a;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.TempCacheStorage.Entry
    public final String getScope() {
        return this.b;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.TempCacheStorage.Entry
    public final long getTimestamp() {
        return this.c;
    }

    public final int hashCode() {
        int hashCode = this.b.hashCode();
        int hashCode2 = Long.hashCode(this.c);
        return Arrays.hashCode(this.d) + ((hashCode2 + ((hashCode + (Long.hashCode(this.f357a) * 31)) * 31)) * 31);
    }

    public final String toString() {
        return "TempCacheEntry(id=" + this.f357a + ", scope='" + this.b + "', timestamp=" + this.c + ", data=array[" + this.d.length + "])";
    }
}
