package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.modulesapi.internal.network.NetworkClientWithCacheControl;
import io.appmetrica.analytics.networktasks.internal.CacheControlHttpsConnectionPerformer;
/* renamed from: io.appmetrica.analytics.impl.u3  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0627u3 implements CacheControlHttpsConnectionPerformer.Client {

    /* renamed from: a  reason: collision with root package name */
    public final NetworkClientWithCacheControl f1223a;

    public C0627u3(NetworkClientWithCacheControl networkClientWithCacheControl) {
        this.f1223a = networkClientWithCacheControl;
    }

    @Override // io.appmetrica.analytics.networktasks.internal.CacheControlHttpsConnectionPerformer.Client
    public final String getOldETag() {
        return this.f1223a.getETag();
    }

    @Override // io.appmetrica.analytics.networktasks.internal.CacheControlHttpsConnectionPerformer.Client
    public final void onError() {
        this.f1223a.onError();
    }

    @Override // io.appmetrica.analytics.networktasks.internal.CacheControlHttpsConnectionPerformer.Client
    public final void onNotModified() {
        this.f1223a.onNotModified();
    }

    @Override // io.appmetrica.analytics.networktasks.internal.CacheControlHttpsConnectionPerformer.Client
    public final void onResponse(String str, byte[] bArr) {
        this.f1223a.onResponse(str, bArr);
    }
}
