package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.identifiers.AdvertisingIdsHolder;
import io.appmetrica.analytics.coreapi.internal.identifiers.SimpleAdvertisingIdGetter;
/* loaded from: classes5.dex */
public interface Ha extends SimpleAdvertisingIdGetter, InterfaceC0483om {
    AdvertisingIdsHolder a();

    AdvertisingIdsHolder a(Li li);

    @Override // io.appmetrica.analytics.impl.InterfaceC0483om
    /* synthetic */ void a(C0356jm c0356jm);

    void b(boolean z);

    void c(boolean z);

    AdvertisingIdsHolder getIdentifiers();

    void init();
}
