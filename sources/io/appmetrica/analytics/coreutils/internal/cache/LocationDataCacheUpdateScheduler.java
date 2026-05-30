package io.appmetrica.analytics.coreutils.internal.cache;

import io.appmetrica.analytics.coreapi.internal.cache.CacheUpdateScheduler;
import io.appmetrica.analytics.coreapi.internal.cache.UpdateConditionsChecker;
import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
import io.appmetrica.analytics.locationapi.internal.ILastKnownUpdater;
import java.util.concurrent.TimeUnit;
/* loaded from: classes5.dex */
public class LocationDataCacheUpdateScheduler implements CacheUpdateScheduler {

    /* renamed from: a  reason: collision with root package name */
    private final ICommonExecutor f355a;
    private final ILastKnownUpdater b;
    private final UpdateConditionsChecker c;
    private final a d = new a(this);
    private final b e = new b(this);

    public LocationDataCacheUpdateScheduler(ICommonExecutor iCommonExecutor, ILastKnownUpdater iLastKnownUpdater, UpdateConditionsChecker updateConditionsChecker, String str) {
        this.f355a = iCommonExecutor;
        this.b = iLastKnownUpdater;
        this.c = updateConditionsChecker;
        String.format("[LocationDataCacheUpdateScheduler-%s]", str);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.cache.CacheUpdateScheduler
    public void onStateUpdated() {
        this.f355a.remove(this.d);
        this.f355a.executeDelayed(this.d, 90L, TimeUnit.SECONDS);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.cache.CacheUpdateScheduler
    public void scheduleUpdateIfNeededNow() {
        this.f355a.execute(this.e);
    }

    public void startUpdates() {
        onStateUpdated();
    }

    public void stopUpdates() {
        this.f355a.remove(this.d);
        this.f355a.remove(this.e);
    }
}
