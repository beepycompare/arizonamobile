package ru.rustore.sdk.core.config;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: RuStoreInternalConfig.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lru/rustore/sdk/core/config/RuStoreInternalConfig;", "", "sdkType", "Lru/rustore/sdk/core/config/SdkType;", "(Lru/rustore/sdk/core/config/SdkType;)V", "getSdkType", "()Lru/rustore/sdk/core/config/SdkType;", "Companion", "sdk-public-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RuStoreInternalConfig {
    public static final Companion Companion = new Companion(null);
    private final SdkType sdkType;

    public /* synthetic */ RuStoreInternalConfig(SdkType sdkType, DefaultConstructorMarker defaultConstructorMarker) {
        this(sdkType);
    }

    private RuStoreInternalConfig(SdkType sdkType) {
        this.sdkType = sdkType;
    }

    public final SdkType getSdkType() {
        return this.sdkType;
    }

    /* compiled from: RuStoreInternalConfig.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0006¨\u0006\b"}, d2 = {"Lru/rustore/sdk/core/config/RuStoreInternalConfig$Companion;", "", "()V", "create", "Lru/rustore/sdk/core/config/RuStoreInternalConfig;", "map", "", "", "sdk-public-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ RuStoreInternalConfig create$default(Companion companion, Map map, int i, Object obj) {
            if ((i & 1) != 0) {
                map = null;
            }
            return companion.create(map);
        }

        public final RuStoreInternalConfig create(Map<String, ? extends Object> map) {
            if (map != null) {
                SdkType fromMap = SdkType.Companion.fromMap(map);
                if (fromMap == null) {
                    fromMap = SdkType.KOTLIN;
                }
                return new RuStoreInternalConfig(fromMap, null);
            }
            return new RuStoreInternalConfig(SdkType.KOTLIN, null);
        }
    }
}
