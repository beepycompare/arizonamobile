package io.appmetrica.analytics.modulesapi.internal.service;

import kotlin.Metadata;
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\b"}, d2 = {"Lio/appmetrica/analytics/modulesapi/internal/service/ServiceWakeLock;", "", "acquireWakeLock", "", "wakeLockId", "", "releaseWakeLock", "", "modules-api_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface ServiceWakeLock {
    boolean acquireWakeLock(String str);

    void releaseWakeLock(String str);
}
