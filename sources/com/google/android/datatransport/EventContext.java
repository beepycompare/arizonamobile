package com.google.android.datatransport;

import com.google.android.datatransport.AutoValue_EventContext;
/* loaded from: classes3.dex */
public abstract class EventContext {

    /* loaded from: classes3.dex */
    public static abstract class Builder {
        public abstract EventContext build();

        public abstract Builder setExperimentIdsClear(byte[] bArr);

        public abstract Builder setExperimentIdsEncrypted(byte[] bArr);

        public abstract Builder setPseudonymousId(String str);
    }

    public abstract byte[] getExperimentIdsClear();

    public abstract byte[] getExperimentIdsEncrypted();

    public abstract String getPseudonymousId();

    public static Builder builder() {
        return new AutoValue_EventContext.Builder();
    }
}
