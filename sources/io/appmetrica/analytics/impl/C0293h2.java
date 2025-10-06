package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.appsetid.internal.AppSetIdListener;
import io.appmetrica.analytics.coreapi.internal.identifiers.AppSetId;
import io.appmetrica.analytics.coreapi.internal.identifiers.AppSetIdScope;
/* renamed from: io.appmetrica.analytics.impl.h2  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0293h2 implements AppSetIdListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0319i2 f905a;

    public C0293h2(C0319i2 c0319i2) {
        this.f905a = c0319i2;
    }

    @Override // io.appmetrica.analytics.appsetid.internal.AppSetIdListener
    public final void onAppSetIdRetrieved(String str, AppSetIdScope appSetIdScope) {
        this.f905a.c = new AppSetId(str, appSetIdScope);
        this.f905a.d.countDown();
    }

    @Override // io.appmetrica.analytics.appsetid.internal.AppSetIdListener
    public final void onFailure(Throwable th) {
        this.f905a.d.countDown();
    }
}
