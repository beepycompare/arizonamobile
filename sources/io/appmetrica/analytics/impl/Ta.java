package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.identifiers.AdvertisingIdsHolder;
import io.appmetrica.analytics.coreapi.internal.identifiers.SimpleAdvertisingIdGetter;
/* loaded from: classes4.dex */
public interface Ta extends SimpleAdvertisingIdGetter, InterfaceC0316hm {
    AdvertisingIdsHolder a();

    AdvertisingIdsHolder a(Qi qi);

    /* synthetic */ void a(C0190cm c0190cm);

    void b(boolean z);

    AdvertisingIdsHolder getIdentifiers();

    void init();
}
