package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.appsetid.internal.AppSetIdListener;
import io.appmetrica.analytics.coreapi.internal.identifiers.AppSetId;
import io.appmetrica.analytics.coreapi.internal.identifiers.AppSetIdScope;
/* renamed from: io.appmetrica.analytics.impl.a2  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0103a2 implements AppSetIdListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0129b2 f886a;

    public C0103a2(C0129b2 c0129b2) {
        this.f886a = c0129b2;
    }

    @Override // io.appmetrica.analytics.appsetid.internal.AppSetIdListener
    public final void onAppSetIdRetrieved(String str, AppSetIdScope appSetIdScope) {
        this.f886a.c = new AppSetId(str, appSetIdScope);
        this.f886a.d.countDown();
    }

    @Override // io.appmetrica.analytics.appsetid.internal.AppSetIdListener
    public final void onFailure(Throwable th) {
        this.f886a.d.countDown();
    }
}
