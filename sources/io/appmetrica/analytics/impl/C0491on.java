package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.TempCacheStorage;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.impl.on  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0491on implements TempCacheStorage.Entry {

    /* renamed from: a  reason: collision with root package name */
    public final long f981a;
    public final String b;
    public final long c;
    public final byte[] d;

    public C0491on(long j, String str, long j2, byte[] bArr) {
        this.f981a = j;
        this.b = str;
        this.c = j2;
        this.d = bArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (Intrinsics.areEqual(C0491on.class, obj != null ? obj.getClass() : null)) {
            if (obj != null) {
                C0491on c0491on = (C0491on) obj;
                if (this.f981a == c0491on.f981a && Intrinsics.areEqual(this.b, c0491on.b) && this.c == c0491on.c) {
                    return Arrays.equals(this.d, c0491on.d);
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
        return this.f981a;
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
        return Arrays.hashCode(this.d) + ((hashCode2 + ((hashCode + (Long.hashCode(this.f981a) * 31)) * 31)) * 31);
    }

    public final String toString() {
        return "TempCacheEntry(id=" + this.f981a + ", scope='" + this.b + "', timestamp=" + this.c + ", data=array[" + this.d.length + "])";
    }
}
