package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.appsetid.internal.AppSetIdListener;
import io.appmetrica.analytics.coreapi.internal.identifiers.AppSetId;
import io.appmetrica.analytics.coreapi.internal.identifiers.AppSetIdScope;
/* renamed from: io.appmetrica.analytics.impl.m2  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0419m2 implements AppSetIdListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0445n2 f1088a;

    public C0419m2(C0445n2 c0445n2) {
        this.f1088a = c0445n2;
    }

    @Override // io.appmetrica.analytics.appsetid.internal.AppSetIdListener
    public final void onAppSetIdRetrieved(String str, AppSetIdScope appSetIdScope) {
        this.f1088a.c = new AppSetId(str, appSetIdScope);
        this.f1088a.d.countDown();
    }

    @Override // io.appmetrica.analytics.appsetid.internal.AppSetIdListener
    public final void onFailure(Throwable th) {
        this.f1088a.d.countDown();
    }
}
