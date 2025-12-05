package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.identifiers.AdvertisingIdsHolder;
import io.appmetrica.analytics.coreapi.internal.identifiers.SimpleAdvertisingIdGetter;
/* loaded from: classes5.dex */
public interface Ba extends SimpleAdvertisingIdGetter, InterfaceC0407lm {
    AdvertisingIdsHolder a();

    AdvertisingIdsHolder a(Hi hi);

    @Override // io.appmetrica.analytics.impl.InterfaceC0407lm
    /* synthetic */ void a(C0278gm c0278gm);

    void b(boolean z);

    void c(boolean z);

    AdvertisingIdsHolder getIdentifiers();

    void init();
}
