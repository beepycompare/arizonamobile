package com.arizona.launcher;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
/* compiled from: TransferSpeedMeter.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u0000 \u00192\u00020\u0001:\u0002\u0018\u0019B!\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0004J\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\u0013J\u0015\u0010\u0014\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0015\u001a\u00020\u0004¢\u0006\u0002\u0010\u0016J\b\u0010\u0017\u001a\u00020\rH\u0002R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000Ê\u0001\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\u0003\u0010\u0000¨\u0006\u001a"}, d2 = {"Lcom/arizona/launcher/TransferSpeedMeter;", "", "nowNanos", "Lkotlin/Function0;", "", "windowNanos", "<init>", "(Lkotlin/jvm/functions/Function0;J)V", "samples", "Ljava/util/ArrayDeque;", "Lcom/arizona/launcher/TransferSpeedMeter$Sample;", "totalRecordedBytes", "reset", "", "addBytes", "byteCount", "bytesPerSecond", "", "speedLabel", "", "estimatedRemainingMillis", "remainingBytes", "(J)Ljava/lang/Long;", "appendCurrentSample", "Sample", "Companion", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class TransferSpeedMeter {
    @Deprecated
    public static final long DEFAULT_WINDOW_NANOS = 5000000000L;
    @Deprecated
    public static final double MILLIS_PER_SECOND = 1000.0d;
    @Deprecated
    public static final double MIN_USEFUL_BYTES_PER_SECOND = 0.1d;
    @Deprecated
    public static final double NANOS_PER_SECOND = 1.0E9d;
    private final Function0<Long> nowNanos;
    private final ArrayDeque<Sample> samples;
    private long totalRecordedBytes;
    private final long windowNanos;
    private static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public TransferSpeedMeter() {
        this(null, 0L, 3, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TransferSpeedMeter.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    /* renamed from: com.arizona.launcher.TransferSpeedMeter$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function0<Long> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(0, System.class, "nanoTime", "nanoTime()J", 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Long invoke() {
            return Long.valueOf(System.nanoTime());
        }
    }

    public TransferSpeedMeter(Function0<Long> nowNanos, long j) {
        Intrinsics.checkNotNullParameter(nowNanos, "nowNanos");
        this.nowNanos = nowNanos;
        this.windowNanos = j;
        this.samples = new ArrayDeque<>();
        if (j <= 0) {
            throw new IllegalArgumentException("windowNanos must be positive".toString());
        }
        reset();
    }

    public /* synthetic */ TransferSpeedMeter(AnonymousClass1 anonymousClass1, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? AnonymousClass1.INSTANCE : anonymousClass1, (i & 2) != 0 ? DEFAULT_WINDOW_NANOS : j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: TransferSpeedMeter.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/arizona/launcher/TransferSpeedMeter$Sample;", "", "atNanos", "", "totalBytes", "<init>", "(JJ)V", "getAtNanos", "()J", "getTotalBytes", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Sample {
        private final long atNanos;
        private final long totalBytes;

        public static /* synthetic */ Sample copy$default(Sample sample, long j, long j2, int i, Object obj) {
            if ((i & 1) != 0) {
                j = sample.atNanos;
            }
            if ((i & 2) != 0) {
                j2 = sample.totalBytes;
            }
            return sample.copy(j, j2);
        }

        public final long component1() {
            return this.atNanos;
        }

        public final long component2() {
            return this.totalBytes;
        }

        public final Sample copy(long j, long j2) {
            return new Sample(j, j2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Sample) {
                Sample sample = (Sample) obj;
                return this.atNanos == sample.atNanos && this.totalBytes == sample.totalBytes;
            }
            return false;
        }

        public int hashCode() {
            return (Long.hashCode(this.atNanos) * 31) + Long.hashCode(this.totalBytes);
        }

        public String toString() {
            long j = this.atNanos;
            return "Sample(atNanos=" + j + ", totalBytes=" + this.totalBytes + ")";
        }

        public Sample(long j, long j2) {
            this.atNanos = j;
            this.totalBytes = j2;
        }

        public final long getAtNanos() {
            return this.atNanos;
        }

        public final long getTotalBytes() {
            return this.totalBytes;
        }
    }

    public final void reset() {
        this.totalRecordedBytes = 0L;
        this.samples.clear();
        this.samples.addLast(new Sample(this.nowNanos.invoke().longValue(), 0L));
    }

    public final void addBytes(long j) {
        if (j <= 0) {
            return;
        }
        long j2 = this.totalRecordedBytes;
        this.totalRecordedBytes = Long.MAX_VALUE - j2 >= j ? j2 + j : Long.MAX_VALUE;
        appendCurrentSample();
    }

    public final double bytesPerSecond() {
        appendCurrentSample();
        if (this.samples.size() < 2) {
            return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        }
        Sample first = this.samples.getFirst();
        Sample last = this.samples.getLast();
        long atNanos = last.getAtNanos() - first.getAtNanos();
        long totalBytes = last.getTotalBytes() - first.getTotalBytes();
        return (atNanos <= 0 || totalBytes <= 0) ? FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE : (totalBytes * 1.0E9d) / atNanos;
    }

    public final String speedLabel() {
        return Companion.formatBytesPerSecond(bytesPerSecond());
    }

    public final Long estimatedRemainingMillis(long j) {
        if (j <= 0) {
            return 0L;
        }
        double bytesPerSecond = bytesPerSecond();
        if (Math.abs(bytesPerSecond) > Double.MAX_VALUE || bytesPerSecond <= 0.1d) {
            return null;
        }
        return Long.valueOf(MathKt.roundToLong(RangesKt.coerceAtMost((j * 1000.0d) / bytesPerSecond, 9.223372036854776E18d)));
    }

    private final void appendCurrentSample() {
        long longValue = this.nowNanos.invoke().longValue();
        Sample sample = (Sample) CollectionsKt.lastOrNull(this.samples);
        if (sample != null && sample.getAtNanos() == longValue) {
            this.samples.removeLast();
        }
        this.samples.addLast(new Sample(longValue, this.totalRecordedBytes));
        long j = longValue - this.windowNanos;
        while (this.samples.size() > 2 && ((Sample) CollectionsKt.elementAt(this.samples, 1)).getAtNanos() <= j) {
            this.samples.removeFirst();
        }
    }

    /* compiled from: TransferSpeedMeter.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/arizona/launcher/TransferSpeedMeter$Companion;", "", "<init>", "()V", "NANOS_PER_SECOND", "", "MILLIS_PER_SECOND", "MIN_USEFUL_BYTES_PER_SECOND", "DEFAULT_WINDOW_NANOS", "", "formatBytesPerSecond", "", "bytesPerSecond", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String formatBytesPerSecond(double d) {
            if (Math.abs(d) > Double.MAX_VALUE || d <= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                return "0 B/s";
            }
            int i = 0;
            String[] strArr = {"B/s", "KB/s", "MB/s", "GB/s", "TB/s"};
            while (d >= 1000.0d && i < ArraysKt.getLastIndex(strArr)) {
                d /= 1000.0d;
                i++;
            }
            if (i == 0) {
                return MathKt.roundToLong(d) + " " + strArr[i];
            }
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format(Locale.US, "%.1f %s", Arrays.copyOf(new Object[]{Double.valueOf(d), strArr[i]}, 2));
            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
            return format;
        }
    }
}
