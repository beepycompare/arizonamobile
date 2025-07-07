package com.arizona.common.model;

import androidx.core.internal.view.SupportMenu;
import com.arizona.common.ui.AvatarView;
import io.appmetrica.analytics.impl.L2;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: AvatarData.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0003\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\bHÆ\u0003J3\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001c"}, d2 = {"Lcom/arizona/common/model/AvatarData;", "", "imageUrl", "", "statusColor", "", L2.g, "scaleType", "Lcom/arizona/common/ui/AvatarView$ScaleType;", "<init>", "(Ljava/lang/String;IILcom/arizona/common/ui/AvatarView$ScaleType;)V", "getImageUrl", "()Ljava/lang/String;", "getStatusColor", "()I", "getBackground", "getScaleType", "()Lcom/arizona/common/ui/AvatarView$ScaleType;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "CommonLibs_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AvatarData {
    private final int background;
    private final String imageUrl;
    private final AvatarView.ScaleType scaleType;
    private final int statusColor;

    public static /* synthetic */ AvatarData copy$default(AvatarData avatarData, String str, int i, int i2, AvatarView.ScaleType scaleType, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = avatarData.imageUrl;
        }
        if ((i3 & 2) != 0) {
            i = avatarData.statusColor;
        }
        if ((i3 & 4) != 0) {
            i2 = avatarData.background;
        }
        if ((i3 & 8) != 0) {
            scaleType = avatarData.scaleType;
        }
        return avatarData.copy(str, i, i2, scaleType);
    }

    public final String component1() {
        return this.imageUrl;
    }

    public final int component2() {
        return this.statusColor;
    }

    public final int component3() {
        return this.background;
    }

    public final AvatarView.ScaleType component4() {
        return this.scaleType;
    }

    public final AvatarData copy(String str, int i, int i2, AvatarView.ScaleType scaleType) {
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
        return new AvatarData(str, i, i2, scaleType);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AvatarData) {
            AvatarData avatarData = (AvatarData) obj;
            return Intrinsics.areEqual(this.imageUrl, avatarData.imageUrl) && this.statusColor == avatarData.statusColor && this.background == avatarData.background && this.scaleType == avatarData.scaleType;
        }
        return false;
    }

    public int hashCode() {
        String str = this.imageUrl;
        return ((((((str == null ? 0 : str.hashCode()) * 31) + Integer.hashCode(this.statusColor)) * 31) + Integer.hashCode(this.background)) * 31) + this.scaleType.hashCode();
    }

    public String toString() {
        String str = this.imageUrl;
        int i = this.statusColor;
        int i2 = this.background;
        return "AvatarData(imageUrl=" + str + ", statusColor=" + i + ", background=" + i2 + ", scaleType=" + this.scaleType + ")";
    }

    public AvatarData(String str, int i, int i2, AvatarView.ScaleType scaleType) {
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
        this.imageUrl = str;
        this.statusColor = i;
        this.background = i2;
        this.scaleType = scaleType;
    }

    public final String getImageUrl() {
        return this.imageUrl;
    }

    public final int getStatusColor() {
        return this.statusColor;
    }

    public final int getBackground() {
        return this.background;
    }

    public /* synthetic */ AvatarData(String str, int i, int i2, AvatarView.ScaleType scaleType, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : str, i, (i3 & 4) != 0 ? SupportMenu.CATEGORY_MASK : i2, (i3 & 8) != 0 ? AvatarView.ScaleType.MINIMAL : scaleType);
    }

    public final AvatarView.ScaleType getScaleType() {
        return this.scaleType;
    }
}
