package io.appmetrica.analytics.gpllibrary.internal;

import io.appmetrica.analytics.gpllibrary.internal.GplLibraryWrapper;
/* loaded from: classes4.dex */
public interface IGplLibraryWrapper {
    void startLocationUpdates(GplLibraryWrapper.Priority priority) throws Throwable;

    void stopLocationUpdates() throws Throwable;

    void updateLastKnownLocation() throws Throwable;
}
