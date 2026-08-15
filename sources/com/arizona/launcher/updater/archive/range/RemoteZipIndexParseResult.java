package com.arizona.launcher.updater.archive.range;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: RemoteZipIndexModels.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bp\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lcom/arizona/launcher/updater/archive/range/RemoteZipIndexParseResult;", "", "Success", "Failure", "Lcom/arizona/launcher/updater/archive/range/RemoteZipIndexParseResult$Failure;", "Lcom/arizona/launcher/updater/archive/range/RemoteZipIndexParseResult$Success;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface RemoteZipIndexParseResult {

    /* compiled from: RemoteZipIndexModels.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007Ê\u0001\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\u0003\u0010\u0000¨\u0006\u0012"}, d2 = {"Lcom/arizona/launcher/updater/archive/range/RemoteZipIndexParseResult$Success;", "Lcom/arizona/launcher/updater/archive/range/RemoteZipIndexParseResult;", FirebaseAnalytics.Param.INDEX, "Lcom/arizona/launcher/updater/archive/range/RemoteZipIndex;", "<init>", "(Lcom/arizona/launcher/updater/archive/range/RemoteZipIndex;)V", "getIndex", "()Lcom/arizona/launcher/updater/archive/range/RemoteZipIndex;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Success implements RemoteZipIndexParseResult {
        public static final int $stable = Sha256Digest.$stable;
        private final RemoteZipIndex index;

        public static /* synthetic */ Success copy$default(Success success, RemoteZipIndex remoteZipIndex, int i, Object obj) {
            if ((i & 1) != 0) {
                remoteZipIndex = success.index;
            }
            return success.copy(remoteZipIndex);
        }

        public final RemoteZipIndex component1() {
            return this.index;
        }

        public final Success copy(RemoteZipIndex index) {
            Intrinsics.checkNotNullParameter(index, "index");
            return new Success(index);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Success) && Intrinsics.areEqual(this.index, ((Success) obj).index);
        }

        public int hashCode() {
            return this.index.hashCode();
        }

        public String toString() {
            return "Success(index=" + this.index + ")";
        }

        public Success(RemoteZipIndex index) {
            Intrinsics.checkNotNullParameter(index, "index");
            this.index = index;
        }

        public final RemoteZipIndex getIndex() {
            return this.index;
        }
    }

    /* compiled from: RemoteZipIndexModels.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0005HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bÊ\u0001\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0016"}, d2 = {"Lcom/arizona/launcher/updater/archive/range/RemoteZipIndexParseResult$Failure;", "Lcom/arizona/launcher/updater/archive/range/RemoteZipIndexParseResult;", "code", "Lcom/arizona/launcher/updater/archive/range/RemoteZipIndexErrorCode;", "entryPath", "", "<init>", "(Lcom/arizona/launcher/updater/archive/range/RemoteZipIndexErrorCode;Ljava/lang/String;)V", "getCode", "()Lcom/arizona/launcher/updater/archive/range/RemoteZipIndexErrorCode;", "getEntryPath", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Failure implements RemoteZipIndexParseResult {
        public static final int $stable = 0;
        private final RemoteZipIndexErrorCode code;
        private final String entryPath;

        public static /* synthetic */ Failure copy$default(Failure failure, RemoteZipIndexErrorCode remoteZipIndexErrorCode, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                remoteZipIndexErrorCode = failure.code;
            }
            if ((i & 2) != 0) {
                str = failure.entryPath;
            }
            return failure.copy(remoteZipIndexErrorCode, str);
        }

        public final RemoteZipIndexErrorCode component1() {
            return this.code;
        }

        public final String component2() {
            return this.entryPath;
        }

        public final Failure copy(RemoteZipIndexErrorCode code, String str) {
            Intrinsics.checkNotNullParameter(code, "code");
            return new Failure(code, str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Failure) {
                Failure failure = (Failure) obj;
                return this.code == failure.code && Intrinsics.areEqual(this.entryPath, failure.entryPath);
            }
            return false;
        }

        public int hashCode() {
            int hashCode = this.code.hashCode() * 31;
            String str = this.entryPath;
            return hashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            RemoteZipIndexErrorCode remoteZipIndexErrorCode = this.code;
            return "Failure(code=" + remoteZipIndexErrorCode + ", entryPath=" + this.entryPath + ")";
        }

        public Failure(RemoteZipIndexErrorCode code, String str) {
            Intrinsics.checkNotNullParameter(code, "code");
            this.code = code;
            this.entryPath = str;
        }

        public /* synthetic */ Failure(RemoteZipIndexErrorCode remoteZipIndexErrorCode, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(remoteZipIndexErrorCode, (i & 2) != 0 ? null : str);
        }

        public final RemoteZipIndexErrorCode getCode() {
            return this.code;
        }

        public final String getEntryPath() {
            return this.entryPath;
        }
    }
}
