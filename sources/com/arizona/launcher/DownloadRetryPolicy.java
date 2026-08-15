package com.arizona.launcher;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.arizona.launcher.DownloadRetryDecision;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
/* compiled from: DownloadRetryPolicy.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u0000  2\u00020\u0001:\u0001 B6\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012#\b\u0002\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\n\u0010\u000bJ/\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0013¢\u0006\u0002\u0010\u0017J\u0018\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u001f\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u0013H\u0002¢\u0006\u0002\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0015\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u0013H\u0000¢\u0006\u0002\b\u001fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR)\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000Ê\u0001\f\b\"\u0012\b\b#\u0012\u0004\b\u0003\u0010\u0002¨\u0006!"}, d2 = {"Lcom/arizona/launcher/DownloadRetryPolicy;", "", "config", "Lcom/arizona/launcher/DownloadRetryConfig;", "jitterMs", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "upperBoundMs", "<init>", "(Lcom/arizona/launcher/DownloadRetryConfig;Lkotlin/jvm/functions/Function1;)V", "getConfig", "()Lcom/arizona/launcher/DownloadRetryConfig;", "decide", "Lcom/arizona/launcher/DownloadRetryDecision;", "kind", "Lcom/arizona/launcher/DownloadFailureKind;", "consumedRetries", "", "hasValidatedNetwork", "", "httpStatus", "(Lcom/arizona/launcher/DownloadFailureKind;IZLjava/lang/Integer;)Lcom/arizona/launcher/DownloadRetryDecision;", "decideNetworkRelated", "decideGenericIo", "decideHttp", "(ILjava/lang/Integer;)Lcom/arizona/launcher/DownloadRetryDecision;", "maybeRetry", "exponentialUpperBoundMs", "attemptIndex", "exponentialUpperBoundMs$app", "Companion", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DownloadRetryPolicy {
    public static final int $stable = 0;
    private final DownloadRetryConfig config;
    private final Function1<Long, Long> jitterMs;
    public static final Companion Companion = new Companion(null);
    private static final Set<Integer> RETRYABLE_HTTP_STATUSES = SetsKt.setOf((Object[]) new Integer[]{408, Integer.valueOf((int) TypedValues.CycleType.TYPE_WAVE_PHASE), 429, 500, Integer.valueOf((int) TypedValues.PositionType.TYPE_DRAWPATH), Integer.valueOf((int) TypedValues.PositionType.TYPE_PERCENT_WIDTH), Integer.valueOf((int) TypedValues.PositionType.TYPE_PERCENT_HEIGHT)});
    private static final Function1<Long, Long> DEFAULT_JITTER = new Function1() { // from class: com.arizona.launcher.DownloadRetryPolicy$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return Long.valueOf(DownloadRetryPolicy.DEFAULT_JITTER$lambda$0(((Long) obj).longValue()));
        }
    };

    /* compiled from: DownloadRetryPolicy.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DownloadFailureKind.values().length];
            try {
                iArr[DownloadFailureKind.CONNECTION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DownloadFailureKind.TIMEOUT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[DownloadFailureKind.DNS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[DownloadFailureKind.IO.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[DownloadFailureKind.HTTP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[DownloadFailureKind.OTHER.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public DownloadRetryPolicy() {
        this(null, null, 3, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DownloadRetryPolicy(DownloadRetryConfig config, Function1<? super Long, Long> jitterMs) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(jitterMs, "jitterMs");
        this.config = config;
        this.jitterMs = jitterMs;
    }

    public /* synthetic */ DownloadRetryPolicy(DownloadRetryConfig downloadRetryConfig, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new DownloadRetryConfig(false, 0, 0L, 0L, 15, null) : downloadRetryConfig, (i & 2) != 0 ? DEFAULT_JITTER : function1);
    }

    public final DownloadRetryConfig getConfig() {
        return this.config;
    }

    public static /* synthetic */ DownloadRetryDecision decide$default(DownloadRetryPolicy downloadRetryPolicy, DownloadFailureKind downloadFailureKind, int i, boolean z, Integer num, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            num = null;
        }
        return downloadRetryPolicy.decide(downloadFailureKind, i, z, num);
    }

    public final DownloadRetryDecision decide(DownloadFailureKind kind, int i, boolean z, Integer num) {
        Intrinsics.checkNotNullParameter(kind, "kind");
        if (i < 0) {
            throw new IllegalArgumentException(("consumedRetries must be >= 0, was " + i).toString());
        }
        if (!this.config.getEnabled()) {
            return DownloadRetryDecision.Disabled.INSTANCE;
        }
        switch (WhenMappings.$EnumSwitchMapping$0[kind.ordinal()]) {
            case 1:
            case 2:
            case 3:
                return decideNetworkRelated(i, z);
            case 4:
                return decideGenericIo(z);
            case 5:
                return decideHttp(i, num);
            case 6:
                return DownloadRetryDecision.DoNotRetry.INSTANCE;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    private final DownloadRetryDecision decideNetworkRelated(int i, boolean z) {
        if (!z) {
            return DownloadRetryDecision.WaitForValidatedNetwork.INSTANCE;
        }
        return maybeRetry(i);
    }

    private final DownloadRetryDecision decideGenericIo(boolean z) {
        if (!z) {
            return DownloadRetryDecision.WaitForValidatedNetwork.INSTANCE;
        }
        return DownloadRetryDecision.DoNotRetry.INSTANCE;
    }

    private final DownloadRetryDecision decideHttp(int i, Integer num) {
        if (num == null || !RETRYABLE_HTTP_STATUSES.contains(num)) {
            return DownloadRetryDecision.DoNotRetry.INSTANCE;
        }
        return maybeRetry(i);
    }

    private final DownloadRetryDecision maybeRetry(int i) {
        if (i >= this.config.getMaxRetries()) {
            return DownloadRetryDecision.DoNotRetry.INSTANCE;
        }
        int i2 = i + 1;
        long exponentialUpperBoundMs$app = exponentialUpperBoundMs$app(i);
        return new DownloadRetryDecision.Retry(RangesKt.coerceIn(this.jitterMs.invoke(Long.valueOf(exponentialUpperBoundMs$app)).longValue(), 0L, exponentialUpperBoundMs$app), i2);
    }

    public final long exponentialUpperBoundMs$app(int i) {
        long baseDelayMs = this.config.getBaseDelayMs();
        long capDelayMs = this.config.getCapDelayMs();
        if (baseDelayMs <= 0 || capDelayMs <= 0) {
            return 0L;
        }
        if (i <= 0) {
            return Math.min(baseDelayMs, capDelayMs);
        }
        if (baseDelayMs < capDelayMs) {
            long j = capDelayMs / baseDelayMs;
            if (i < 63) {
                long j2 = 1 << i;
                if (j2 <= j) {
                    return Math.min(baseDelayMs * j2, capDelayMs);
                }
            }
        }
        return capDelayMs;
    }

    /* compiled from: DownloadRetryPolicy.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/arizona/launcher/DownloadRetryPolicy$Companion;", "", "<init>", "()V", "RETRYABLE_HTTP_STATUSES", "", "", "getRETRYABLE_HTTP_STATUSES", "()Ljava/util/Set;", "DEFAULT_JITTER", "Lkotlin/Function1;", "", "getDEFAULT_JITTER", "()Lkotlin/jvm/functions/Function1;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Set<Integer> getRETRYABLE_HTTP_STATUSES() {
            return DownloadRetryPolicy.RETRYABLE_HTTP_STATUSES;
        }

        public final Function1<Long, Long> getDEFAULT_JITTER() {
            return DownloadRetryPolicy.DEFAULT_JITTER;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final long DEFAULT_JITTER$lambda$0(long j) {
        if (j <= 0) {
            return 0L;
        }
        if (j == Long.MAX_VALUE) {
            return ThreadLocalRandom.current().nextLong(0L, Long.MAX_VALUE);
        }
        return ThreadLocalRandom.current().nextLong(0L, j + 1);
    }
}
