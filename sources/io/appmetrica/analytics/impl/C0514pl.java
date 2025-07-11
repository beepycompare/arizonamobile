package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.modulesapi.internal.network.NetworkClientWithCacheControl;
import io.appmetrica.analytics.modulesapi.internal.network.SimpleNetworkApi;
import io.appmetrica.analytics.networktasks.internal.CacheControlHttpsConnectionPerformer;
/* renamed from: io.appmetrica.analytics.impl.pl  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0514pl implements SimpleNetworkApi {

    /* renamed from: a  reason: collision with root package name */
    public final CacheControlHttpsConnectionPerformer f994a = new CacheControlHttpsConnectionPerformer(((C0713xl) Ga.j().y()).getSslSocketFactory());

    @Override // io.appmetrica.analytics.modulesapi.internal.network.SimpleNetworkApi
    public final void performRequestWithCacheControl(String str, NetworkClientWithCacheControl networkClientWithCacheControl) {
        this.f994a.performConnection(str, new A3(networkClientWithCacheControl));
    }
}
