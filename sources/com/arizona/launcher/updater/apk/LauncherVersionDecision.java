package com.arizona.launcher.updater.apk;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: LauncherUpdatePolicies.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bp\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lcom/arizona/launcher/updater/apk/LauncherVersionDecision;", "", "Valid", "InvalidMetadata", "Lcom/arizona/launcher/updater/apk/LauncherVersionDecision$InvalidMetadata;", "Lcom/arizona/launcher/updater/apk/LauncherVersionDecision$Valid;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface LauncherVersionDecision {

    /* compiled from: LauncherUpdatePolicies.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003J)\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0014\u0010\u0014\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0083\u0004J\n\u0010\u0017\u001a\u00020\u0005HÖ\u0081\u0004J\n\u0010\u0018\u001a\u00020\u0007HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fÊ\u0001\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0019"}, d2 = {"Lcom/arizona/launcher/updater/apk/LauncherVersionDecision$Valid;", "Lcom/arizona/launcher/updater/apk/LauncherVersionDecision;", "needsUpdate", "", "serverVersionCode", "", "serverVersionName", "", "<init>", "(ZILjava/lang/String;)V", "getNeedsUpdate", "()Z", "getServerVersionCode", "()I", "getServerVersionName", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "toString", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Valid implements LauncherVersionDecision {
        public static final int $stable = 0;
        private final boolean needsUpdate;
        private final int serverVersionCode;
        private final String serverVersionName;

        public static /* synthetic */ Valid copy$default(Valid valid, boolean z, int i, String str, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                z = valid.needsUpdate;
            }
            if ((i2 & 2) != 0) {
                i = valid.serverVersionCode;
            }
            if ((i2 & 4) != 0) {
                str = valid.serverVersionName;
            }
            return valid.copy(z, i, str);
        }

        public final boolean component1() {
            return this.needsUpdate;
        }

        public final int component2() {
            return this.serverVersionCode;
        }

        public final String component3() {
            return this.serverVersionName;
        }

        public final Valid copy(boolean z, int i, String str) {
            return new Valid(z, i, str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Valid) {
                Valid valid = (Valid) obj;
                return this.needsUpdate == valid.needsUpdate && this.serverVersionCode == valid.serverVersionCode && Intrinsics.areEqual(this.serverVersionName, valid.serverVersionName);
            }
            return false;
        }

        public int hashCode() {
            int hashCode = ((Boolean.hashCode(this.needsUpdate) * 31) + Integer.hashCode(this.serverVersionCode)) * 31;
            String str = this.serverVersionName;
            return hashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            boolean z = this.needsUpdate;
            int i = this.serverVersionCode;
            return "Valid(needsUpdate=" + z + ", serverVersionCode=" + i + ", serverVersionName=" + this.serverVersionName + ")";
        }

        public Valid(boolean z, int i, String str) {
            this.needsUpdate = z;
            this.serverVersionCode = i;
            this.serverVersionName = str;
        }

        public final boolean getNeedsUpdate() {
            return this.needsUpdate;
        }

        public final int getServerVersionCode() {
            return this.serverVersionCode;
        }

        public final String getServerVersionName() {
            return this.serverVersionName;
        }
    }

    /* compiled from: LauncherUpdatePolicies.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004Ê\u0001\f\b\r\u0012\b\b\u000e\u0012\u0004\b\u0003\u0010\u0002¨\u0006\f"}, d2 = {"Lcom/arizona/launcher/updater/apk/LauncherVersionDecision$InvalidMetadata;", "Lcom/arizona/launcher/updater/apk/LauncherVersionDecision;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class InvalidMetadata implements LauncherVersionDecision {
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
            return -2008222750;
        }

        public String toString() {
            return "InvalidMetadata";
        }

        private InvalidMetadata() {
        }
    }
}
