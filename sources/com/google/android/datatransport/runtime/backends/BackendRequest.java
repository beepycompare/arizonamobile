package com.google.android.datatransport.runtime.backends;

import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.backends.AutoValue_BackendRequest;
/* loaded from: classes3.dex */
public abstract class BackendRequest {

    /* loaded from: classes3.dex */
    public static abstract class Builder {
        public abstract BackendRequest build();

        public abstract Builder setEvents(Iterable<EventInternal> iterable);

        public abstract Builder setExtras(byte[] bArr);
    }

    public abstract Iterable<EventInternal> getEvents();

    public abstract byte[] getExtras();

    public static BackendRequest create(Iterable<EventInternal> iterable) {
        return builder().setEvents(iterable).build();
    }

    public static Builder builder() {
        return new AutoValue_BackendRequest.Builder();
    }
}
