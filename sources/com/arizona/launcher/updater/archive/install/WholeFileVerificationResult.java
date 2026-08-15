package com.arizona.launcher.updater.archive.install;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: WholeFileCrc32Verifier.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bp\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lcom/arizona/launcher/updater/archive/install/WholeFileVerificationResult;", "", "Success", "Failure", "Lcom/arizona/launcher/updater/archive/install/WholeFileVerificationResult$Failure;", "Lcom/arizona/launcher/updater/archive/install/WholeFileVerificationResult$Success;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface WholeFileVerificationResult {

    /* compiled from: WholeFileCrc32Verifier.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0083\u0004J\n\u0010\u0011\u001a\u00020\u0012HÖ\u0081\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bÊ\u0001\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0015"}, d2 = {"Lcom/arizona/launcher/updater/archive/install/WholeFileVerificationResult$Success;", "Lcom/arizona/launcher/updater/archive/install/WholeFileVerificationResult;", "size", "", "crc32", "<init>", "(JJ)V", "getSize", "()J", "getCrc32", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Success implements WholeFileVerificationResult {
        public static final int $stable = 0;
        private final long crc32;
        private final long size;

        public static /* synthetic */ Success copy$default(Success success, long j, long j2, int i, Object obj) {
            if ((i & 1) != 0) {
                j = success.size;
            }
            if ((i & 2) != 0) {
                j2 = success.crc32;
            }
            return success.copy(j, j2);
        }

        public final long component1() {
            return this.size;
        }

        public final long component2() {
            return this.crc32;
        }

        public final Success copy(long j, long j2) {
            return new Success(j, j2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Success) {
                Success success = (Success) obj;
                return this.size == success.size && this.crc32 == success.crc32;
            }
            return false;
        }

        public int hashCode() {
            return (Long.hashCode(this.size) * 31) + Long.hashCode(this.crc32);
        }

        public String toString() {
            long j = this.size;
            return "Success(size=" + j + ", crc32=" + this.crc32 + ")";
        }

        public Success(long j, long j2) {
            this.size = j;
            this.crc32 = j2;
        }

        public final long getSize() {
            return this.size;
        }

        public final long getCrc32() {
            return this.crc32;
        }
    }

    /* compiled from: WholeFileCrc32Verifier.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\fJ0\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0014\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0083\u0004J\n\u0010\u0018\u001a\u00020\u0019HÖ\u0081\u0004J\n\u0010\u001a\u001a\u00020\u001bHÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000e\u0010\fÊ\u0001\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u001c"}, d2 = {"Lcom/arizona/launcher/updater/archive/install/WholeFileVerificationResult$Failure;", "Lcom/arizona/launcher/updater/archive/install/WholeFileVerificationResult;", "code", "Lcom/arizona/launcher/updater/archive/install/WholeFileVerificationErrorCode;", "actualSize", "", "actualCrc32", "<init>", "(Lcom/arizona/launcher/updater/archive/install/WholeFileVerificationErrorCode;Ljava/lang/Long;Ljava/lang/Long;)V", "getCode", "()Lcom/arizona/launcher/updater/archive/install/WholeFileVerificationErrorCode;", "getActualSize", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getActualCrc32", "component1", "component2", "component3", "copy", "(Lcom/arizona/launcher/updater/archive/install/WholeFileVerificationErrorCode;Ljava/lang/Long;Ljava/lang/Long;)Lcom/arizona/launcher/updater/archive/install/WholeFileVerificationResult$Failure;", "equals", "", "other", "", "hashCode", "", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Failure implements WholeFileVerificationResult {
        public static final int $stable = 0;
        private final Long actualCrc32;
        private final Long actualSize;
        private final WholeFileVerificationErrorCode code;

        public static /* synthetic */ Failure copy$default(Failure failure, WholeFileVerificationErrorCode wholeFileVerificationErrorCode, Long l, Long l2, int i, Object obj) {
            if ((i & 1) != 0) {
                wholeFileVerificationErrorCode = failure.code;
            }
            if ((i & 2) != 0) {
                l = failure.actualSize;
            }
            if ((i & 4) != 0) {
                l2 = failure.actualCrc32;
            }
            return failure.copy(wholeFileVerificationErrorCode, l, l2);
        }

        public final WholeFileVerificationErrorCode component1() {
            return this.code;
        }

        public final Long component2() {
            return this.actualSize;
        }

        public final Long component3() {
            return this.actualCrc32;
        }

        public final Failure copy(WholeFileVerificationErrorCode code, Long l, Long l2) {
            Intrinsics.checkNotNullParameter(code, "code");
            return new Failure(code, l, l2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Failure) {
                Failure failure = (Failure) obj;
                return this.code == failure.code && Intrinsics.areEqual(this.actualSize, failure.actualSize) && Intrinsics.areEqual(this.actualCrc32, failure.actualCrc32);
            }
            return false;
        }

        public int hashCode() {
            int hashCode = this.code.hashCode() * 31;
            Long l = this.actualSize;
            int hashCode2 = (hashCode + (l == null ? 0 : l.hashCode())) * 31;
            Long l2 = this.actualCrc32;
            return hashCode2 + (l2 != null ? l2.hashCode() : 0);
        }

        public String toString() {
            WholeFileVerificationErrorCode wholeFileVerificationErrorCode = this.code;
            Long l = this.actualSize;
            return "Failure(code=" + wholeFileVerificationErrorCode + ", actualSize=" + l + ", actualCrc32=" + this.actualCrc32 + ")";
        }

        public Failure(WholeFileVerificationErrorCode code, Long l, Long l2) {
            Intrinsics.checkNotNullParameter(code, "code");
            this.code = code;
            this.actualSize = l;
            this.actualCrc32 = l2;
        }

        public /* synthetic */ Failure(WholeFileVerificationErrorCode wholeFileVerificationErrorCode, Long l, Long l2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(wholeFileVerificationErrorCode, (i & 2) != 0 ? null : l, (i & 4) != 0 ? null : l2);
        }

        public final WholeFileVerificationErrorCode getCode() {
            return this.code;
        }

        public final Long getActualSize() {
            return this.actualSize;
        }

        public final Long getActualCrc32() {
            return this.actualCrc32;
        }
    }
}
