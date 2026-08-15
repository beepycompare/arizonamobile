package com.arizona.launcher.updater.apk;

import com.arizona.launcher.updater.http.UpdateMetadataHttpResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: LauncherUpdateController.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bp\u0018\u00002\u00020\u0001:\u0004\u0002\u0003\u0004\u0005\u0082\u0001\u0004\u0006\u0007\b\t¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lcom/arizona/launcher/updater/apk/LauncherUpdateCheckOutcome;", "", "Success", "ServerEmpty", "RequestFailed", "InvalidMetadata", "Lcom/arizona/launcher/updater/apk/LauncherUpdateCheckOutcome$InvalidMetadata;", "Lcom/arizona/launcher/updater/apk/LauncherUpdateCheckOutcome$RequestFailed;", "Lcom/arizona/launcher/updater/apk/LauncherUpdateCheckOutcome$ServerEmpty;", "Lcom/arizona/launcher/updater/apk/LauncherUpdateCheckOutcome$Success;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface LauncherUpdateCheckOutcome {

    /* compiled from: LauncherUpdateController.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0083\u0004J\n\u0010\r\u001a\u00020\u000eHÖ\u0081\u0004J\n\u0010\u000f\u001a\u00020\u0010HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007Ê\u0001\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0011"}, d2 = {"Lcom/arizona/launcher/updater/apk/LauncherUpdateCheckOutcome$Success;", "Lcom/arizona/launcher/updater/apk/LauncherUpdateCheckOutcome;", "needsUpdate", "", "<init>", "(Z)V", "getNeedsUpdate", "()Z", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Success implements LauncherUpdateCheckOutcome {
        public static final int $stable = 0;
        private final boolean needsUpdate;

        public static /* synthetic */ Success copy$default(Success success, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = success.needsUpdate;
            }
            return success.copy(z);
        }

        public final boolean component1() {
            return this.needsUpdate;
        }

        public final Success copy(boolean z) {
            return new Success(z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Success) && this.needsUpdate == ((Success) obj).needsUpdate;
        }

        public int hashCode() {
            return Boolean.hashCode(this.needsUpdate);
        }

        public String toString() {
            return "Success(needsUpdate=" + this.needsUpdate + ")";
        }

        public Success(boolean z) {
            this.needsUpdate = z;
        }

        public final boolean getNeedsUpdate() {
            return this.needsUpdate;
        }
    }

    /* compiled from: LauncherUpdateController.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004Ê\u0001\f\b\r\u0012\b\b\u000e\u0012\u0004\b\u0003\u0010\u0002¨\u0006\f"}, d2 = {"Lcom/arizona/launcher/updater/apk/LauncherUpdateCheckOutcome$ServerEmpty;", "Lcom/arizona/launcher/updater/apk/LauncherUpdateCheckOutcome;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class ServerEmpty implements LauncherUpdateCheckOutcome {
        public static final int $stable = 0;
        public static final ServerEmpty INSTANCE = new ServerEmpty();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ServerEmpty) {
                ServerEmpty serverEmpty = (ServerEmpty) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -1665940167;
        }

        public String toString() {
            return "ServerEmpty";
        }

        private ServerEmpty() {
        }
    }

    /* compiled from: LauncherUpdateController.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007Ê\u0001\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\u0003\u0010\u0000¨\u0006\u0012"}, d2 = {"Lcom/arizona/launcher/updater/apk/LauncherUpdateCheckOutcome$RequestFailed;", "Lcom/arizona/launcher/updater/apk/LauncherUpdateCheckOutcome;", "result", "Lcom/arizona/launcher/updater/http/UpdateMetadataHttpResult;", "<init>", "(Lcom/arizona/launcher/updater/http/UpdateMetadataHttpResult;)V", "getResult", "()Lcom/arizona/launcher/updater/http/UpdateMetadataHttpResult;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class RequestFailed implements LauncherUpdateCheckOutcome {
        public static final int $stable = 8;
        private final UpdateMetadataHttpResult result;

        public static /* synthetic */ RequestFailed copy$default(RequestFailed requestFailed, UpdateMetadataHttpResult updateMetadataHttpResult, int i, Object obj) {
            if ((i & 1) != 0) {
                updateMetadataHttpResult = requestFailed.result;
            }
            return requestFailed.copy(updateMetadataHttpResult);
        }

        public final UpdateMetadataHttpResult component1() {
            return this.result;
        }

        public final RequestFailed copy(UpdateMetadataHttpResult result) {
            Intrinsics.checkNotNullParameter(result, "result");
            return new RequestFailed(result);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof RequestFailed) && Intrinsics.areEqual(this.result, ((RequestFailed) obj).result);
        }

        public int hashCode() {
            return this.result.hashCode();
        }

        public String toString() {
            return "RequestFailed(result=" + this.result + ")";
        }

        public RequestFailed(UpdateMetadataHttpResult result) {
            Intrinsics.checkNotNullParameter(result, "result");
            this.result = result;
        }

        public final UpdateMetadataHttpResult getResult() {
            return this.result;
        }
    }

    /* compiled from: LauncherUpdateController.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004Ê\u0001\f\b\r\u0012\b\b\u000e\u0012\u0004\b\u0003\u0010\u0002¨\u0006\f"}, d2 = {"Lcom/arizona/launcher/updater/apk/LauncherUpdateCheckOutcome$InvalidMetadata;", "Lcom/arizona/launcher/updater/apk/LauncherUpdateCheckOutcome;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class InvalidMetadata implements LauncherUpdateCheckOutcome {
        public static final int $stable = 0;
        public static final InvalidMetadata INSTANCE = new InvalidMetadata();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof InvalidMetadata) {
                InvalidMetadata invalidMetadata = (InvalidMetadata) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -1712854987;
        }

        public String toString() {
            return "InvalidMetadata";
        }

        private InvalidMetadata() {
        }
    }
}
