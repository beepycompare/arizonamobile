package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.identifiers.AdvertisingIdsHolder;
import io.appmetrica.analytics.coreapi.internal.identifiers.SimpleAdvertisingIdGetter;
/* renamed from: io.appmetrica.analytics.impl.ab  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public interface InterfaceC0121ab extends SimpleAdvertisingIdGetter, InterfaceC0619tm {
    AdvertisingIdsHolder a();

    AdvertisingIdsHolder a(InterfaceC0181cj interfaceC0181cj);

    /* synthetic */ void a(C0494om c0494om);

    void b(boolean z);

    void c(boolean z);

    AdvertisingIdsHolder getIdentifiers();

    void init();
}
