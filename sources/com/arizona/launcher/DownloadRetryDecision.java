package com.arizona.launcher;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: DownloadRetryPolicy.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0004\b\t\n\u000bÊ\u0001\f\b\r\u0012\b\b\u000e\u0012\u0004\b\u0003\u0010\u0000¨\u0006\f"}, d2 = {"Lcom/arizona/launcher/DownloadRetryDecision;", "", "<init>", "()V", "Disabled", "WaitForValidatedNetwork", "Retry", "DoNotRetry", "Lcom/arizona/launcher/DownloadRetryDecision$Disabled;", "Lcom/arizona/launcher/DownloadRetryDecision$DoNotRetry;", "Lcom/arizona/launcher/DownloadRetryDecision$Retry;", "Lcom/arizona/launcher/DownloadRetryDecision$WaitForValidatedNetwork;", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class DownloadRetryDecision {
    public static final int $stable = 8;

    public /* synthetic */ DownloadRetryDecision(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private DownloadRetryDecision() {
    }

    /* compiled from: DownloadRetryPolicy.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004Ê\u0001\f\b\r\u0012\b\b\u000e\u0012\u0004\b\u0003\u0010\u0002¨\u0006\f"}, d2 = {"Lcom/arizona/launcher/DownloadRetryDecision$Disabled;", "Lcom/arizona/launcher/DownloadRetryDecision;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Disabled extends DownloadRetryDecision {
        public static final int $stable = 0;
        public static final Disabled INSTANCE = new Disabled();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Disabled) {
                Disabled disabled = (Disabled) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 1674430753;
        }

        public String toString() {
            return "Disabled";
        }

        private Disabled() {
            super(null);
        }
    }

    /* compiled from: DownloadRetryPolicy.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004Ê\u0001\f\b\r\u0012\b\b\u000e\u0012\u0004\b\u0003\u0010\u0002¨\u0006\f"}, d2 = {"Lcom/arizona/launcher/DownloadRetryDecision$WaitForValidatedNetwork;", "Lcom/arizona/launcher/DownloadRetryDecision;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class WaitForValidatedNetwork extends DownloadRetryDecision {
        public static final int $stable = 0;
        public static final WaitForValidatedNetwork INSTANCE = new WaitForValidatedNetwork();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof WaitForValidatedNetwork) {
                WaitForValidatedNetwork waitForValidatedNetwork = (WaitForValidatedNetwork) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 1085046319;
        }

        public String toString() {
            return "WaitForValidatedNetwork";
        }

        private WaitForValidatedNetwork() {
            super(null);
        }
    }

    /* compiled from: DownloadRetryPolicy.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0005HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0015HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bÊ\u0001\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0016"}, d2 = {"Lcom/arizona/launcher/DownloadRetryDecision$Retry;", "Lcom/arizona/launcher/DownloadRetryDecision;", "afterMs", "", "nextAttempt", "", "<init>", "(JI)V", "getAfterMs", "()J", "getNextAttempt", "()I", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Retry extends DownloadRetryDecision {
        public static final int $stable = 0;
        private final long afterMs;
        private final int nextAttempt;

        public static /* synthetic */ Retry copy$default(Retry retry, long j, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                j = retry.afterMs;
            }
            if ((i2 & 2) != 0) {
                i = retry.nextAttempt;
            }
            return retry.copy(j, i);
        }

        public final long component1() {
            return this.afterMs;
        }

        public final int component2() {
            return this.nextAttempt;
        }

        public final Retry copy(long j, int i) {
            return new Retry(j, i);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Retry) {
                Retry retry = (Retry) obj;
                return this.afterMs == retry.afterMs && this.nextAttempt == retry.nextAttempt;
            }
            return false;
        }

        public int hashCode() {
            return (Long.hashCode(this.afterMs) * 31) + Integer.hashCode(this.nextAttempt);
        }

        public String toString() {
            long j = this.afterMs;
            return "Retry(afterMs=" + j + ", nextAttempt=" + this.nextAttempt + ")";
        }

        public Retry(long j, int i) {
            super(null);
            this.afterMs = j;
            this.nextAttempt = i;
        }

        public final long getAfterMs() {
            return this.afterMs;
        }

        public final int getNextAttempt() {
            return this.nextAttempt;
        }
    }

    /* compiled from: DownloadRetryPolicy.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004Ê\u0001\f\b\r\u0012\b\b\u000e\u0012\u0004\b\u0003\u0010\u0002¨\u0006\f"}, d2 = {"Lcom/arizona/launcher/DownloadRetryDecision$DoNotRetry;", "Lcom/arizona/launcher/DownloadRetryDecision;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class DoNotRetry extends DownloadRetryDecision {
        public static final int $stable = 0;
        public static final DoNotRetry INSTANCE = new DoNotRetry();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof DoNotRetry) {
                DoNotRetry doNotRetry = (DoNotRetry) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 527401637;
        }

        public String toString() {
            return "DoNotRetry";
        }

        private DoNotRetry() {
            super(null);
        }
    }
}
