package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.TempCacheStorage;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.impl.wn  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0683wn implements TempCacheStorage.Entry {

    /* renamed from: a  reason: collision with root package name */
    public final long f1193a;
    public final String b;
    public final long c;
    public final byte[] d;

    public C0683wn(long j, String str, long j2, byte[] bArr) {
        this.f1193a = j;
        this.b = str;
        this.c = j2;
        this.d = bArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (Intrinsics.areEqual(C0683wn.class, obj != null ? obj.getClass() : null)) {
            if (obj != null) {
                C0683wn c0683wn = (C0683wn) obj;
                if (this.f1193a == c0683wn.f1193a && Intrinsics.areEqual(this.b, c0683wn.b) && this.c == c0683wn.c) {
                    return Arrays.equals(this.d, c0683wn.d);
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
        return this.f1193a;
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
        return Arrays.hashCode(this.d) + ((hashCode2 + ((hashCode + (Long.hashCode(this.f1193a) * 31)) * 31)) * 31);
    }

    public final String toString() {
        return "TempCacheEntry(id=" + this.f1193a + ", scope='" + this.b + "', timestamp=" + this.c + ", data=array[" + this.d.length + "])";
    }
}
