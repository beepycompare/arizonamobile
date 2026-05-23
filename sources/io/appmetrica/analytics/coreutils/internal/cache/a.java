package io.appmetrica.analytics.coreutils.internal.cache;

import io.appmetrica.analytics.locationapi.internal.ILastKnownUpdater;
/* loaded from: classes5.dex */
public final class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LocationDataCacheUpdateScheduler f355a;

    public a(LocationDataCacheUpdateScheduler locationDataCacheUpdateScheduler) {
        this.f355a = locationDataCacheUpdateScheduler;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ILastKnownUpdater iLastKnownUpdater;
        iLastKnownUpdater = this.f355a.b;
        iLastKnownUpdater.updateLastKnown();
    }
}
