package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.identifiers.AdvertisingIdsHolder;
import io.appmetrica.analytics.coreapi.internal.identifiers.SimpleAdvertisingIdGetter;
/* loaded from: classes5.dex */
public interface Aa extends SimpleAdvertisingIdGetter, InterfaceC0385km {
    AdvertisingIdsHolder a();

    AdvertisingIdsHolder a(Gi gi);

    @Override // io.appmetrica.analytics.impl.InterfaceC0385km
    /* synthetic */ void a(C0256fm c0256fm);

    void b(boolean z);

    void c(boolean z);

    AdvertisingIdsHolder getIdentifiers();

    void init();
}
