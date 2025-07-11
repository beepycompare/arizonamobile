package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.appsetid.internal.AppSetIdListener;
import io.appmetrica.analytics.coreapi.internal.identifiers.AppSetId;
import io.appmetrica.analytics.coreapi.internal.identifiers.AppSetIdScope;
/* renamed from: io.appmetrica.analytics.impl.f2  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0246f2 implements AppSetIdListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0271g2 f830a;

    public C0246f2(C0271g2 c0271g2) {
        this.f830a = c0271g2;
    }

    @Override // io.appmetrica.analytics.appsetid.internal.AppSetIdListener
    public final void onAppSetIdRetrieved(String str, AppSetIdScope appSetIdScope) {
        this.f830a.c = new AppSetId(str, appSetIdScope);
        this.f830a.d.countDown();
    }

    @Override // io.appmetrica.analytics.appsetid.internal.AppSetIdListener
    public final void onFailure(Throwable th) {
        this.f830a.d.countDown();
    }
}
