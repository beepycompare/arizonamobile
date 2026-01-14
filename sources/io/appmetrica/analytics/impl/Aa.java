package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.identifiers.AdvertisingIdsHolder;
import io.appmetrica.analytics.coreapi.internal.identifiers.SimpleAdvertisingIdGetter;
/* loaded from: classes5.dex */
public interface Aa extends SimpleAdvertisingIdGetter, InterfaceC0386km {
    AdvertisingIdsHolder a();

    AdvertisingIdsHolder a(Gi gi);

    @Override // io.appmetrica.analytics.impl.InterfaceC0386km
    /* synthetic */ void a(C0257fm c0257fm);

    void b(boolean z);

    void c(boolean z);

    AdvertisingIdsHolder getIdentifiers();

    void init();
}
