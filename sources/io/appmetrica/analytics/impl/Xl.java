package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.modulesapi.internal.network.NetworkClientWithCacheControl;
import io.appmetrica.analytics.modulesapi.internal.network.SimpleNetworkApi;
import io.appmetrica.analytics.networktasks.internal.CacheControlHttpsConnectionPerformer;
/* loaded from: classes5.dex */
public final class Xl implements SimpleNetworkApi {

    /* renamed from: a  reason: collision with root package name */
    public final CacheControlHttpsConnectionPerformer f842a = new CacheControlHttpsConnectionPerformer(((C0181cm) Na.k().z()).getSslSocketFactory());

    @Override // io.appmetrica.analytics.modulesapi.internal.network.SimpleNetworkApi
    public final void performRequestWithCacheControl(String str, NetworkClientWithCacheControl networkClientWithCacheControl) {
        this.f842a.performConnection(str, new C0627u3(networkClientWithCacheControl));
    }
}
