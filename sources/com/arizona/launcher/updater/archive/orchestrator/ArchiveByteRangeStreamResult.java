package com.arizona.launcher.updater.archive.orchestrator;

import com.arizona.launcher.updater.archive.range.StrongEtag;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ArchiveManifestResolver.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bp\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveByteRangeStreamResult;", "", "Success", "Failure", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveByteRangeStreamResult$Failure;", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveByteRangeStreamResult$Success;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface ArchiveByteRangeStreamResult {

    /* compiled from: ArchiveManifestResolver.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J)\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0014\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0083\u0004J\n\u0010\u0018\u001a\u00020\u0019HÖ\u0081\u0004J\n\u0010\u001a\u001a\u00020\u0005HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fÊ\u0001\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\u0003\u0010\u0000¨\u0006\u001b"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveByteRangeStreamResult$Success;", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveByteRangeStreamResult;", "strongEtag", "Lcom/arizona/launcher/updater/archive/range/StrongEtag;", "effectiveUrl", "", "byteCount", "", "<init>", "(Lcom/arizona/launcher/updater/archive/range/StrongEtag;Ljava/lang/String;J)V", "getStrongEtag", "()Lcom/arizona/launcher/updater/archive/range/StrongEtag;", "getEffectiveUrl", "()Ljava/lang/String;", "getByteCount", "()J", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Success implements ArchiveByteRangeStreamResult {
        public static final int $stable = StrongEtag.$stable;
        private final long byteCount;
        private final String effectiveUrl;
        private final StrongEtag strongEtag;

        public static /* synthetic */ Success copy$default(Success success, StrongEtag strongEtag, String str, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                strongEtag = success.strongEtag;
            }
            if ((i & 2) != 0) {
                str = success.effectiveUrl;
            }
            if ((i & 4) != 0) {
                j = success.byteCount;
            }
            return success.copy(strongEtag, str, j);
        }

        public final StrongEtag component1() {
            return this.strongEtag;
        }

        public final String component2() {
            return this.effectiveUrl;
        }

        public final long component3() {
            return this.byteCount;
        }

        public final Success copy(StrongEtag strongEtag, String effectiveUrl, long j) {
            Intrinsics.checkNotNullParameter(effectiveUrl, "effectiveUrl");
            return new Success(strongEtag, effectiveUrl, j);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Success) {
                Success success = (Success) obj;
                return Intrinsics.areEqual(this.strongEtag, success.strongEtag) && Intrinsics.areEqual(this.effectiveUrl, success.effectiveUrl) && this.byteCount == success.byteCount;
            }
            return false;
        }

        public int hashCode() {
            StrongEtag strongEtag = this.strongEtag;
            return ((((strongEtag == null ? 0 : strongEtag.hashCode()) * 31) + this.effectiveUrl.hashCode()) * 31) + Long.hashCode(this.byteCount);
        }

        public String toString() {
            StrongEtag strongEtag = this.strongEtag;
            String str = this.effectiveUrl;
            return "Success(strongEtag=" + strongEtag + ", effectiveUrl=" + str + ", byteCount=" + this.byteCount + ")";
        }

        public Success(StrongEtag strongEtag, String effectiveUrl, long j) {
            Intrinsics.checkNotNullParameter(effectiveUrl, "effectiveUrl");
            this.strongEtag = strongEtag;
            this.effectiveUrl = effectiveUrl;
            this.byteCount = j;
        }

        public final StrongEtag getStrongEtag() {
            return this.strongEtag;
        }

        public final String getEffectiveUrl() {
            return this.effectiveUrl;
        }

        public final long getByteCount() {
            return this.byteCount;
        }
    }

    /* compiled from: ArchiveManifestResolver.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\rJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0007HÆ\u0003J0\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0015J\u0014\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0083\u0004J\n\u0010\u001a\u001a\u00020\u0005HÖ\u0081\u0004J\n\u0010\u001b\u001a\u00020\u0007HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010Ê\u0001\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u001c"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveByteRangeStreamResult$Failure;", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveByteRangeStreamResult;", "code", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveByteRangeErrorCode;", "httpStatus", "", "detail", "", "<init>", "(Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveByteRangeErrorCode;Ljava/lang/Integer;Ljava/lang/String;)V", "getCode", "()Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveByteRangeErrorCode;", "getHttpStatus", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getDetail", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "(Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveByteRangeErrorCode;Ljava/lang/Integer;Ljava/lang/String;)Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveByteRangeStreamResult$Failure;", "equals", "", "other", "", "hashCode", "toString", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Failure implements ArchiveByteRangeStreamResult {
        public static final int $stable = 0;
        private final ArchiveByteRangeErrorCode code;
        private final String detail;
        private final Integer httpStatus;

        public static /* synthetic */ Failure copy$default(Failure failure, ArchiveByteRangeErrorCode archiveByteRangeErrorCode, Integer num, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                archiveByteRangeErrorCode = failure.code;
            }
            if ((i & 2) != 0) {
                num = failure.httpStatus;
            }
            if ((i & 4) != 0) {
                str = failure.detail;
            }
            return failure.copy(archiveByteRangeErrorCode, num, str);
        }

        public final ArchiveByteRangeErrorCode component1() {
            return this.code;
        }

        public final Integer component2() {
            return this.httpStatus;
        }

        public final String component3() {
            return this.detail;
        }

        public final Failure copy(ArchiveByteRangeErrorCode code, Integer num, String str) {
            Intrinsics.checkNotNullParameter(code, "code");
            return new Failure(code, num, str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Failure) {
                Failure failure = (Failure) obj;
                return this.code == failure.code && Intrinsics.areEqual(this.httpStatus, failure.httpStatus) && Intrinsics.areEqual(this.detail, failure.detail);
            }
            return false;
        }

        public int hashCode() {
            int hashCode = this.code.hashCode() * 31;
            Integer num = this.httpStatus;
            int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
            String str = this.detail;
            return hashCode2 + (str != null ? str.hashCode() : 0);
        }

        public String toString() {
            ArchiveByteRangeErrorCode archiveByteRangeErrorCode = this.code;
            Integer num = this.httpStatus;
            return "Failure(code=" + archiveByteRangeErrorCode + ", httpStatus=" + num + ", detail=" + this.detail + ")";
        }

        public Failure(ArchiveByteRangeErrorCode code, Integer num, String str) {
            Intrinsics.checkNotNullParameter(code, "code");
            this.code = code;
            this.httpStatus = num;
            this.detail = str;
        }

        public /* synthetic */ Failure(ArchiveByteRangeErrorCode archiveByteRangeErrorCode, Integer num, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(archiveByteRangeErrorCode, (i & 2) != 0 ? null : num, (i & 4) != 0 ? null : str);
        }

        public final ArchiveByteRangeErrorCode getCode() {
            return this.code;
        }

        public final Integer getHttpStatus() {
            return this.httpStatus;
        }

        public final String getDetail() {
            return this.detail;
        }
    }
}
