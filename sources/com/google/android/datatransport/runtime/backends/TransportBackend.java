package com.google.android.datatransport.runtime.backends;

import com.google.android.datatransport.runtime.EventInternal;
/* loaded from: classes3.dex */
public interface TransportBackend {
    EventInternal decorate(EventInternal eventInternal);

    BackendResponse send(BackendRequest backendRequest);
}
