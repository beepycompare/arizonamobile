package com.miami.game.core.api.model.response;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: HwVersion.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/miami/game/core/api/model/response/HwVersion;", "", "allowVersion", "", "allowVersionName", "", "<init>", "(ILjava/lang/String;)V", "getAllowVersion", "()I", "getAllowVersionName", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "api-model_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class HwVersion {
    @SerializedName("allow_version")
    private final int allowVersion;
    @SerializedName("allow_version_name")
    private final String allowVersionName;

    public static /* synthetic */ HwVersion copy$default(HwVersion hwVersion, int i, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = hwVersion.allowVersion;
        }
        if ((i2 & 2) != 0) {
            str = hwVersion.allowVersionName;
        }
        return hwVersion.copy(i, str);
    }

    public final int component1() {
        return this.allowVersion;
    }

    public final String component2() {
        return this.allowVersionName;
    }

    public final HwVersion copy(int i, String allowVersionName) {
        Intrinsics.checkNotNullParameter(allowVersionName, "allowVersionName");
        return new HwVersion(i, allowVersionName);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof HwVersion) {
            HwVersion hwVersion = (HwVersion) obj;
            return this.allowVersion == hwVersion.allowVersion && Intrinsics.areEqual(this.allowVersionName, hwVersion.allowVersionName);
        }
        return false;
    }

    public int hashCode() {
        return (Integer.hashCode(this.allowVersion) * 31) + this.allowVersionName.hashCode();
    }

    public String toString() {
        int i = this.allowVersion;
        return "HwVersion(allowVersion=" + i + ", allowVersionName=" + this.allowVersionName + ")";
    }

    public HwVersion(int i, String allowVersionName) {
        Intrinsics.checkNotNullParameter(allowVersionName, "allowVersionName");
        this.allowVersion = i;
        this.allowVersionName = allowVersionName;
    }

    public final int getAllowVersion() {
        return this.allowVersion;
    }

    public final String getAllowVersionName() {
        return this.allowVersionName;
    }
}
