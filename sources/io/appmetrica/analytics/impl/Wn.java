package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.TempCacheStorage;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class Wn implements TempCacheStorage.Entry {

    /* renamed from: a  reason: collision with root package name */
    public final long f831a;
    public final String b;
    public final long c;
    public final byte[] d;

    public Wn(long j, String str, long j2, byte[] bArr) {
        this.f831a = j;
        this.b = str;
        this.c = j2;
        this.d = bArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (Intrinsics.areEqual(Wn.class, obj != null ? obj.getClass() : null)) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type io.appmetrica.analytics.impl.db.storage.TempCacheEntry");
            Wn wn = (Wn) obj;
            if (this.f831a == wn.f831a && Intrinsics.areEqual(this.b, wn.b) && this.c == wn.c) {
                return Arrays.equals(this.d, wn.d);
            }
            return false;
        }
        return false;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.TempCacheStorage.Entry
    public final byte[] getData() {
        return this.d;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.TempCacheStorage.Entry
    public final long getId() {
        return this.f831a;
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
        return Arrays.hashCode(this.d) + ((hashCode2 + ((hashCode + (Long.hashCode(this.f831a) * 31)) * 31)) * 31);
    }

    public final String toString() {
        return "TempCacheEntry(id=" + this.f831a + ", scope='" + this.b + "', timestamp=" + this.c + ", data=array[" + this.d.length + "])";
    }
}
