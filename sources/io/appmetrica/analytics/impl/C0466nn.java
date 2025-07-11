package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.data.TempCacheStorage;
import java.util.Collection;
/* renamed from: io.appmetrica.analytics.impl.nn  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0466nn implements TempCacheStorage {

    /* renamed from: a  reason: collision with root package name */
    public final TempCacheStorage f962a;

    public C0466nn(Context context, Pm pm, TempCacheStorage tempCacheStorage) {
        this.f962a = tempCacheStorage;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.TempCacheStorage
    public final TempCacheStorage.Entry get(String str) {
        return this.f962a.get(str);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.TempCacheStorage
    public final long put(String str, long j, byte[] bArr) {
        return this.f962a.put(str, j, bArr);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.TempCacheStorage
    public final void remove(long j) {
        this.f962a.remove(j);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.TempCacheStorage
    public final void removeOlderThan(String str, long j) {
        this.f962a.removeOlderThan(str, j);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.TempCacheStorage
    public final Collection<TempCacheStorage.Entry> get(String str, int i) {
        return this.f962a.get(str, i);
    }
}
