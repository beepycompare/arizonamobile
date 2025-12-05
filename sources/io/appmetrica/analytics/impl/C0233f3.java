package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.modulesapi.internal.network.NetworkClientWithCacheControl;
import io.appmetrica.analytics.networktasks.internal.CacheControlHttpsConnectionPerformer;
/* renamed from: io.appmetrica.analytics.impl.f3  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0233f3 implements CacheControlHttpsConnectionPerformer.Client {

    /* renamed from: a  reason: collision with root package name */
    public final NetworkClientWithCacheControl f965a;

    public C0233f3(NetworkClientWithCacheControl networkClientWithCacheControl) {
        this.f965a = networkClientWithCacheControl;
    }

    @Override // io.appmetrica.analytics.networktasks.internal.CacheControlHttpsConnectionPerformer.Client
    public final String getOldETag() {
        return this.f965a.getETag();
    }

    @Override // io.appmetrica.analytics.networktasks.internal.CacheControlHttpsConnectionPerformer.Client
    public final void onError() {
        this.f965a.onError();
    }

    @Override // io.appmetrica.analytics.networktasks.internal.CacheControlHttpsConnectionPerformer.Client
    public final void onNotModified() {
        this.f965a.onNotModified();
    }

    @Override // io.appmetrica.analytics.networktasks.internal.CacheControlHttpsConnectionPerformer.Client
    public final void onResponse(String str, byte[] bArr) {
        this.f965a.onResponse(str, bArr);
    }
}
