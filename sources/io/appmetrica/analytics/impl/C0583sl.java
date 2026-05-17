package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.modulesapi.internal.network.NetworkClientWithCacheControl;
import io.appmetrica.analytics.modulesapi.internal.network.SimpleNetworkApi;
import io.appmetrica.analytics.networktasks.internal.CacheControlHttpsConnectionPerformer;
/* renamed from: io.appmetrica.analytics.impl.sl  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0583sl implements SimpleNetworkApi {

    /* renamed from: a  reason: collision with root package name */
    public final CacheControlHttpsConnectionPerformer f1229a = new CacheControlHttpsConnectionPerformer(((Al) C0448na.k().z()).getSslSocketFactory());

    @Override // io.appmetrica.analytics.modulesapi.internal.network.SimpleNetworkApi
    public final void performRequestWithCacheControl(String str, NetworkClientWithCacheControl networkClientWithCacheControl) {
        this.f1229a.performConnection(str, new C0211e3(networkClientWithCacheControl));
    }
}
