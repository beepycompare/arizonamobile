package io.appmetrica.analytics;

import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public class PreloadInfo {

    /* renamed from: a  reason: collision with root package name */
    private final String f202a;
    private final Map b;

    /* loaded from: classes4.dex */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        private final String f203a;
        private final HashMap b;

        /* synthetic */ Builder(String str, int i) {
            this(str);
        }

        public PreloadInfo build() {
            return new PreloadInfo(this, 0);
        }

        public Builder setAdditionalParams(String str, String str2) {
            if (str != null && str2 != null) {
                this.b.put(str, str2);
            }
            return this;
        }

        private Builder(String str) {
            this.f203a = str;
            this.b = new HashMap();
        }
    }

    /* synthetic */ PreloadInfo(Builder builder, int i) {
        this(builder);
    }

    public static Builder newBuilder(String str) {
        return new Builder(str, 0);
    }

    public Map<String, String> getAdditionalParams() {
        return this.b;
    }

    public String getTrackingId() {
        return this.f202a;
    }

    private PreloadInfo(Builder builder) {
        this.f202a = builder.f203a;
        this.b = CollectionUtils.unmodifiableMapCopy(builder.b);
    }
}
