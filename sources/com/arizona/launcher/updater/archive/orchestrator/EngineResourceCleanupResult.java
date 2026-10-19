package com.arizona.launcher.updater.archive.orchestrator;

import com.arizona.launcher.UpdateServiceContract;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: EngineResourceGenerationMigration.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bp\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/EngineResourceCleanupResult;", "", "Success", "Failure", "Lcom/arizona/launcher/updater/archive/orchestrator/EngineResourceCleanupResult$Failure;", "Lcom/arizona/launcher/updater/archive/orchestrator/EngineResourceCleanupResult$Success;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface EngineResourceCleanupResult {

    /* compiled from: EngineResourceGenerationMigration.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004Ê\u0001\f\b\r\u0012\b\b\u000e\u0012\u0004\b\u0003\u0010\u0002¨\u0006\f"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/EngineResourceCleanupResult$Success;", "Lcom/arizona/launcher/updater/archive/orchestrator/EngineResourceCleanupResult;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Success implements EngineResourceCleanupResult {
        public static final int $stable = 0;
        public static final Success INSTANCE = new Success();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Success) {
                Success success = (Success) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -1366207258;
        }

        public String toString() {
            return "Success";
        }

        private Success() {
        }
    }

    /* compiled from: EngineResourceGenerationMigration.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0005HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bÊ\u0001\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0016"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/EngineResourceCleanupResult$Failure;", "Lcom/arizona/launcher/updater/archive/orchestrator/EngineResourceCleanupResult;", "code", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdateCheckBlockCode;", UpdateServiceContract.BundleKey.DETAIL, "", "<init>", "(Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdateCheckBlockCode;Ljava/lang/String;)V", "getCode", "()Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdateCheckBlockCode;", "getDetail", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Failure implements EngineResourceCleanupResult {
        public static final int $stable = 0;
        private final ArchiveUpdateCheckBlockCode code;
        private final String detail;

        public static /* synthetic */ Failure copy$default(Failure failure, ArchiveUpdateCheckBlockCode archiveUpdateCheckBlockCode, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                archiveUpdateCheckBlockCode = failure.code;
            }
            if ((i & 2) != 0) {
                str = failure.detail;
            }
            return failure.copy(archiveUpdateCheckBlockCode, str);
        }

        public final ArchiveUpdateCheckBlockCode component1() {
            return this.code;
        }

        public final String component2() {
            return this.detail;
        }

        public final Failure copy(ArchiveUpdateCheckBlockCode code, String detail) {
            Intrinsics.checkNotNullParameter(code, "code");
            Intrinsics.checkNotNullParameter(detail, "detail");
            return new Failure(code, detail);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Failure) {
                Failure failure = (Failure) obj;
                return this.code == failure.code && Intrinsics.areEqual(this.detail, failure.detail);
            }
            return false;
        }

        public int hashCode() {
            return (this.code.hashCode() * 31) + this.detail.hashCode();
        }

        public String toString() {
            ArchiveUpdateCheckBlockCode archiveUpdateCheckBlockCode = this.code;
            return "Failure(code=" + archiveUpdateCheckBlockCode + ", detail=" + this.detail + ")";
        }

        public Failure(ArchiveUpdateCheckBlockCode code, String detail) {
            Intrinsics.checkNotNullParameter(code, "code");
            Intrinsics.checkNotNullParameter(detail, "detail");
            this.code = code;
            this.detail = detail;
        }

        public final ArchiveUpdateCheckBlockCode getCode() {
            return this.code;
        }

        public final String getDetail() {
            return this.detail;
        }
    }
}
