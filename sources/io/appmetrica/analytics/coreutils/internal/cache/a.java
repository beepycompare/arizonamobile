package io.appmetrica.analytics.coreutils.internal.cache;

import io.appmetrica.analytics.locationapi.internal.ILastKnownUpdater;
/* loaded from: classes4.dex */
public final class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LocationDataCacheUpdateScheduler f270a;

    public a(LocationDataCacheUpdateScheduler locationDataCacheUpdateScheduler) {
        this.f270a = locationDataCacheUpdateScheduler;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ILastKnownUpdater iLastKnownUpdater;
        iLastKnownUpdater = this.f270a.b;
        iLastKnownUpdater.updateLastKnown();
    }
}
