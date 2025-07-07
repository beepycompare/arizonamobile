package ru.rustore.sdk.core.feature.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.rustore.sdk.core.exception.RuStoreException;
/* compiled from: FeatureAvailabilityResult.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lru/rustore/sdk/core/feature/model/FeatureAvailabilityResult;", "", "()V", "Available", "Unavailable", "Lru/rustore/sdk/core/feature/model/FeatureAvailabilityResult$Available;", "Lru/rustore/sdk/core/feature/model/FeatureAvailabilityResult$Unavailable;", "sdk-public-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class FeatureAvailabilityResult {
    public /* synthetic */ FeatureAvailabilityResult(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private FeatureAvailabilityResult() {
    }

    /* compiled from: FeatureAvailabilityResult.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lru/rustore/sdk/core/feature/model/FeatureAvailabilityResult$Available;", "Lru/rustore/sdk/core/feature/model/FeatureAvailabilityResult;", "()V", "sdk-public-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Available extends FeatureAvailabilityResult {
        public static final Available INSTANCE = new Available();

        private Available() {
            super(null);
        }
    }

    /* compiled from: FeatureAvailabilityResult.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lru/rustore/sdk/core/feature/model/FeatureAvailabilityResult$Unavailable;", "Lru/rustore/sdk/core/feature/model/FeatureAvailabilityResult;", "cause", "Lru/rustore/sdk/core/exception/RuStoreException;", "(Lru/rustore/sdk/core/exception/RuStoreException;)V", "getCause", "()Lru/rustore/sdk/core/exception/RuStoreException;", "sdk-public-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Unavailable extends FeatureAvailabilityResult {
        private final RuStoreException cause;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Unavailable(RuStoreException cause) {
            super(null);
            Intrinsics.checkNotNullParameter(cause, "cause");
            this.cause = cause;
        }

        public final RuStoreException getCause() {
            return this.cause;
        }
    }
}
