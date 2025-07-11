package io.appmetrica.analytics.location.impl;

import io.appmetrica.analytics.locationapi.internal.CacheArguments;
/* loaded from: classes4.dex */
public final class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ i f1187a;
    public final /* synthetic */ k b;

    public j(k kVar, i iVar) {
        this.b = kVar;
        this.f1187a = iVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        p pVar = this.b.c;
        i iVar = this.f1187a;
        pVar.f1193a = iVar;
        CacheArguments cacheArguments = iVar.b;
        pVar.b.updateCacheControl(cacheArguments.getRefreshPeriod(), cacheArguments.getOutdatedTimeInterval());
    }
}
