package com.arizona.launcher.updater.archive.orchestrator;

import com.arizona.launcher.UpdateServiceContract;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ViceCityArchiveContentManager.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bp\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ViceCityArchiveContentInspection;", "", "Success", "Failure", "Lcom/arizona/launcher/updater/archive/orchestrator/ViceCityArchiveContentInspection$Failure;", "Lcom/arizona/launcher/updater/archive/orchestrator/ViceCityArchiveContentInspection$Success;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface ViceCityArchiveContentInspection {

    /* compiled from: ViceCityArchiveContentManager.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007Ê\u0001\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0012"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ViceCityArchiveContentInspection$Success;", "Lcom/arizona/launcher/updater/archive/orchestrator/ViceCityArchiveContentInspection;", "totalBytes", "", "<init>", "(J)V", "getTotalBytes", "()J", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Success implements ViceCityArchiveContentInspection {
        public static final int $stable = 0;
        private final long totalBytes;

        public static /* synthetic */ Success copy$default(Success success, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                j = success.totalBytes;
            }
            return success.copy(j);
        }

        public final long component1() {
            return this.totalBytes;
        }

        public final Success copy(long j) {
            return new Success(j);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Success) && this.totalBytes == ((Success) obj).totalBytes;
        }

        public int hashCode() {
            return Long.hashCode(this.totalBytes);
        }

        public String toString() {
            return "Success(totalBytes=" + this.totalBytes + ")";
        }

        public Success(long j) {
            this.totalBytes = j;
        }

        public final long getTotalBytes() {
            return this.totalBytes;
        }
    }

    /* compiled from: ViceCityArchiveContentManager.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007Ê\u0001\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0011"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ViceCityArchiveContentInspection$Failure;", "Lcom/arizona/launcher/updater/archive/orchestrator/ViceCityArchiveContentInspection;", UpdateServiceContract.BundleKey.DETAIL, "", "<init>", "(Ljava/lang/String;)V", "getDetail", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Failure implements ViceCityArchiveContentInspection {
        public static final int $stable = 0;
        private final String detail;

        public static /* synthetic */ Failure copy$default(Failure failure, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = failure.detail;
            }
            return failure.copy(str);
        }

        public final String component1() {
            return this.detail;
        }

        public final Failure copy(String detail) {
            Intrinsics.checkNotNullParameter(detail, "detail");
            return new Failure(detail);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Failure) && Intrinsics.areEqual(this.detail, ((Failure) obj).detail);
        }

        public int hashCode() {
            return this.detail.hashCode();
        }

        public String toString() {
            return "Failure(detail=" + this.detail + ")";
        }

        public Failure(String detail) {
            Intrinsics.checkNotNullParameter(detail, "detail");
            this.detail = detail;
        }

        public final String getDetail() {
            return this.detail;
        }
    }
}
