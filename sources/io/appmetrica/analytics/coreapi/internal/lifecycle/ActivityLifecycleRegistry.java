package io.appmetrica.analytics.coreapi.internal.lifecycle;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J)\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0007\"\u00020\bH'¢\u0006\u0002\u0010\tJ)\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0007\"\u00020\bH'¢\u0006\u0002\u0010\t¨\u0006\u000b"}, d2 = {"Lio/appmetrica/analytics/coreapi/internal/lifecycle/ActivityLifecycleRegistry;", "", "registerListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lio/appmetrica/analytics/coreapi/internal/lifecycle/ActivityLifecycleListener;", "events", "", "Lio/appmetrica/analytics/coreapi/internal/lifecycle/ActivityEvent;", "(Lio/appmetrica/analytics/coreapi/internal/lifecycle/ActivityLifecycleListener;[Lio/appmetrica/analytics/coreapi/internal/lifecycle/ActivityEvent;)V", "unregisterListener", "core-api_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface ActivityLifecycleRegistry {
    void registerListener(ActivityLifecycleListener activityLifecycleListener, ActivityEvent... activityEventArr);

    void unregisterListener(ActivityLifecycleListener activityLifecycleListener, ActivityEvent... activityEventArr);
}
