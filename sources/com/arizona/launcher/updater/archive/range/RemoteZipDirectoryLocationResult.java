package com.arizona.launcher.updater.archive.range;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: RemoteZipIndexModels.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bp\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lcom/arizona/launcher/updater/archive/range/RemoteZipDirectoryLocationResult;", "", "Success", "Failure", "Lcom/arizona/launcher/updater/archive/range/RemoteZipDirectoryLocationResult$Failure;", "Lcom/arizona/launcher/updater/archive/range/RemoteZipDirectoryLocationResult$Success;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface RemoteZipDirectoryLocationResult {

    /* compiled from: RemoteZipIndexModels.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007Ê\u0001\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0012"}, d2 = {"Lcom/arizona/launcher/updater/archive/range/RemoteZipDirectoryLocationResult$Success;", "Lcom/arizona/launcher/updater/archive/range/RemoteZipDirectoryLocationResult;", FirebaseAnalytics.Param.LOCATION, "Lcom/arizona/launcher/updater/archive/range/RemoteZipDirectoryLocation;", "<init>", "(Lcom/arizona/launcher/updater/archive/range/RemoteZipDirectoryLocation;)V", "getLocation", "()Lcom/arizona/launcher/updater/archive/range/RemoteZipDirectoryLocation;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Success implements RemoteZipDirectoryLocationResult {
        public static final int $stable = 0;
        private final RemoteZipDirectoryLocation location;

        public static /* synthetic */ Success copy$default(Success success, RemoteZipDirectoryLocation remoteZipDirectoryLocation, int i, Object obj) {
            if ((i & 1) != 0) {
                remoteZipDirectoryLocation = success.location;
            }
            return success.copy(remoteZipDirectoryLocation);
        }

        public final RemoteZipDirectoryLocation component1() {
            return this.location;
        }

        public final Success copy(RemoteZipDirectoryLocation location) {
            Intrinsics.checkNotNullParameter(location, "location");
            return new Success(location);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Success) && Intrinsics.areEqual(this.location, ((Success) obj).location);
        }

        public int hashCode() {
            return this.location.hashCode();
        }

        public String toString() {
            return "Success(location=" + this.location + ")";
        }

        public Success(RemoteZipDirectoryLocation location) {
            Intrinsics.checkNotNullParameter(location, "location");
            this.location = location;
        }

        public final RemoteZipDirectoryLocation getLocation() {
            return this.location;
        }
    }

    /* compiled from: RemoteZipIndexModels.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007Ê\u0001\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0012"}, d2 = {"Lcom/arizona/launcher/updater/archive/range/RemoteZipDirectoryLocationResult$Failure;", "Lcom/arizona/launcher/updater/archive/range/RemoteZipDirectoryLocationResult;", "code", "Lcom/arizona/launcher/updater/archive/range/RemoteZipIndexErrorCode;", "<init>", "(Lcom/arizona/launcher/updater/archive/range/RemoteZipIndexErrorCode;)V", "getCode", "()Lcom/arizona/launcher/updater/archive/range/RemoteZipIndexErrorCode;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Failure implements RemoteZipDirectoryLocationResult {
        public static final int $stable = 0;
        private final RemoteZipIndexErrorCode code;

        public static /* synthetic */ Failure copy$default(Failure failure, RemoteZipIndexErrorCode remoteZipIndexErrorCode, int i, Object obj) {
            if ((i & 1) != 0) {
                remoteZipIndexErrorCode = failure.code;
            }
            return failure.copy(remoteZipIndexErrorCode);
        }

        public final RemoteZipIndexErrorCode component1() {
            return this.code;
        }

        public final Failure copy(RemoteZipIndexErrorCode code) {
            Intrinsics.checkNotNullParameter(code, "code");
            return new Failure(code);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Failure) && this.code == ((Failure) obj).code;
        }

        public int hashCode() {
            return this.code.hashCode();
        }

        public String toString() {
            return "Failure(code=" + this.code + ")";
        }

        public Failure(RemoteZipIndexErrorCode code) {
            Intrinsics.checkNotNullParameter(code, "code");
            this.code = code;
        }

        public final RemoteZipIndexErrorCode getCode() {
            return this.code;
        }
    }
}
