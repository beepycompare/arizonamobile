package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.identifiers.AdvertisingIdsHolder;
import io.appmetrica.analytics.coreapi.internal.identifiers.SimpleAdvertisingIdGetter;
/* renamed from: io.appmetrica.analytics.impl.ab  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public interface InterfaceC0120ab extends SimpleAdvertisingIdGetter, InterfaceC0618tm {
    AdvertisingIdsHolder a();

    AdvertisingIdsHolder a(InterfaceC0180cj interfaceC0180cj);

    /* synthetic */ void a(C0493om c0493om);

    void b(boolean z);

    void c(boolean z);

    AdvertisingIdsHolder getIdentifiers();

    void init();
}
