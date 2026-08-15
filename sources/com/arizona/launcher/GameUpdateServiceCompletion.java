package com.arizona.launcher;

import com.arizona.launcher.updater.http.UpdateMetadataHttpResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: GameUpdateServiceFlow.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bp\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004\u0082\u0001\u0003\u0005\u0006\u0007¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lcom/arizona/launcher/GameUpdateServiceCompletion;", "", "Prepared", "MetadataFailed", "ServerEmpty", "Lcom/arizona/launcher/GameUpdateServiceCompletion$MetadataFailed;", "Lcom/arizona/launcher/GameUpdateServiceCompletion$Prepared;", "Lcom/arizona/launcher/GameUpdateServiceCompletion$ServerEmpty;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface GameUpdateServiceCompletion {

    /* compiled from: GameUpdateServiceFlow.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0083\u0004J\n\u0010\r\u001a\u00020\u000eHÖ\u0081\u0004J\n\u0010\u000f\u001a\u00020\u0010HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007Ê\u0001\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0011"}, d2 = {"Lcom/arizona/launcher/GameUpdateServiceCompletion$Prepared;", "Lcom/arizona/launcher/GameUpdateServiceCompletion;", "successfully", "", "<init>", "(Z)V", "getSuccessfully", "()Z", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Prepared implements GameUpdateServiceCompletion {
        public static final int $stable = 0;
        private final boolean successfully;

        public static /* synthetic */ Prepared copy$default(Prepared prepared, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = prepared.successfully;
            }
            return prepared.copy(z);
        }

        public final boolean component1() {
            return this.successfully;
        }

        public final Prepared copy(boolean z) {
            return new Prepared(z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Prepared) && this.successfully == ((Prepared) obj).successfully;
        }

        public int hashCode() {
            return Boolean.hashCode(this.successfully);
        }

        public String toString() {
            return "Prepared(successfully=" + this.successfully + ")";
        }

        public Prepared(boolean z) {
            this.successfully = z;
        }

        public final boolean getSuccessfully() {
            return this.successfully;
        }
    }

    /* compiled from: GameUpdateServiceFlow.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007Ê\u0001\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\u0003\u0010\u0000¨\u0006\u0012"}, d2 = {"Lcom/arizona/launcher/GameUpdateServiceCompletion$MetadataFailed;", "Lcom/arizona/launcher/GameUpdateServiceCompletion;", "failure", "Lcom/arizona/launcher/updater/http/UpdateMetadataHttpResult;", "<init>", "(Lcom/arizona/launcher/updater/http/UpdateMetadataHttpResult;)V", "getFailure", "()Lcom/arizona/launcher/updater/http/UpdateMetadataHttpResult;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class MetadataFailed implements GameUpdateServiceCompletion {
        public static final int $stable = 8;
        private final UpdateMetadataHttpResult failure;

        public static /* synthetic */ MetadataFailed copy$default(MetadataFailed metadataFailed, UpdateMetadataHttpResult updateMetadataHttpResult, int i, Object obj) {
            if ((i & 1) != 0) {
                updateMetadataHttpResult = metadataFailed.failure;
            }
            return metadataFailed.copy(updateMetadataHttpResult);
        }

        public final UpdateMetadataHttpResult component1() {
            return this.failure;
        }

        public final MetadataFailed copy(UpdateMetadataHttpResult failure) {
            Intrinsics.checkNotNullParameter(failure, "failure");
            return new MetadataFailed(failure);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof MetadataFailed) && Intrinsics.areEqual(this.failure, ((MetadataFailed) obj).failure);
        }

        public int hashCode() {
            return this.failure.hashCode();
        }

        public String toString() {
            return "MetadataFailed(failure=" + this.failure + ")";
        }

        public MetadataFailed(UpdateMetadataHttpResult failure) {
            Intrinsics.checkNotNullParameter(failure, "failure");
            this.failure = failure;
        }

        public final UpdateMetadataHttpResult getFailure() {
            return this.failure;
        }
    }

    /* compiled from: GameUpdateServiceFlow.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004Ê\u0001\f\b\r\u0012\b\b\u000e\u0012\u0004\b\u0003\u0010\u0002¨\u0006\f"}, d2 = {"Lcom/arizona/launcher/GameUpdateServiceCompletion$ServerEmpty;", "Lcom/arizona/launcher/GameUpdateServiceCompletion;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class ServerEmpty implements GameUpdateServiceCompletion {
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
            return 2017241503;
        }

        public String toString() {
            return "ServerEmpty";
        }

        private ServerEmpty() {
        }
    }
}
