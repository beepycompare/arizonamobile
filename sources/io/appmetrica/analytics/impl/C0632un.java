package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.data.TempCacheStorage;
import java.util.Collection;
/* renamed from: io.appmetrica.analytics.impl.un  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0632un implements TempCacheStorage {

    /* renamed from: a  reason: collision with root package name */
    public final TempCacheStorage f1252a;

    public C0632un(Context context, Tm tm, TempCacheStorage tempCacheStorage) {
        this.f1252a = tempCacheStorage;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.TempCacheStorage
    public final TempCacheStorage.Entry get(String str) {
        return this.f1252a.get(str);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.TempCacheStorage
    public final long put(String str, long j, byte[] bArr) {
        return this.f1252a.put(str, j, bArr);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.TempCacheStorage
    public final void remove(long j) {
        this.f1252a.remove(j);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.TempCacheStorage
    public final void removeOlderThan(String str, long j) {
        this.f1252a.removeOlderThan(str, j);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.TempCacheStorage
    public final Collection<TempCacheStorage.Entry> get(String str, int i) {
        return this.f1252a.get(str, i);
    }
}
