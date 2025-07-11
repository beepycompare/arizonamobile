package ru.mrlargha.commonui.elements.radial_menu;

import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
/* compiled from: SectorData.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\u000bB)\b\u0016\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\u000fJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003JE\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020\u0003HÖ\u0001J\t\u0010#\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011¨\u0006$"}, d2 = {"Lru/mrlargha/commonui/elements/radial_menu/SectorData;", "", "sectorId", "", "imageResourceId", "title", "", "caption", "strCode", NotificationCompat.CATEGORY_STATUS, "<init>", "(IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "id", "action", "Lru/mrlargha/commonui/elements/radial_menu/Action;", "(ILru/mrlargha/commonui/elements/radial_menu/Action;Ljava/lang/String;I)V", "getSectorId", "()I", "getImageResourceId", "getTitle", "()Ljava/lang/String;", "getCaption", "getStrCode", "getStatus", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SectorData {
    private final String caption;
    private final int imageResourceId;
    private final int sectorId;
    private final int status;
    private final String strCode;
    private final String title;

    public static /* synthetic */ SectorData copy$default(SectorData sectorData, int i, int i2, String str, String str2, String str3, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = sectorData.sectorId;
        }
        if ((i4 & 2) != 0) {
            i2 = sectorData.imageResourceId;
        }
        if ((i4 & 4) != 0) {
            str = sectorData.title;
        }
        if ((i4 & 8) != 0) {
            str2 = sectorData.caption;
        }
        if ((i4 & 16) != 0) {
            str3 = sectorData.strCode;
        }
        if ((i4 & 32) != 0) {
            i3 = sectorData.status;
        }
        String str4 = str3;
        int i5 = i3;
        return sectorData.copy(i, i2, str, str2, str4, i5);
    }

    public final int component1() {
        return this.sectorId;
    }

    public final int component2() {
        return this.imageResourceId;
    }

    public final String component3() {
        return this.title;
    }

    public final String component4() {
        return this.caption;
    }

    public final String component5() {
        return this.strCode;
    }

    public final int component6() {
        return this.status;
    }

    public final SectorData copy(int i, int i2, String title, String caption, String strCode, int i3) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(caption, "caption");
        Intrinsics.checkNotNullParameter(strCode, "strCode");
        return new SectorData(i, i2, title, caption, strCode, i3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SectorData) {
            SectorData sectorData = (SectorData) obj;
            return this.sectorId == sectorData.sectorId && this.imageResourceId == sectorData.imageResourceId && Intrinsics.areEqual(this.title, sectorData.title) && Intrinsics.areEqual(this.caption, sectorData.caption) && Intrinsics.areEqual(this.strCode, sectorData.strCode) && this.status == sectorData.status;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((Integer.hashCode(this.sectorId) * 31) + Integer.hashCode(this.imageResourceId)) * 31) + this.title.hashCode()) * 31) + this.caption.hashCode()) * 31) + this.strCode.hashCode()) * 31) + Integer.hashCode(this.status);
    }

    public String toString() {
        int i = this.sectorId;
        int i2 = this.imageResourceId;
        String str = this.title;
        String str2 = this.caption;
        String str3 = this.strCode;
        return "SectorData(sectorId=" + i + ", imageResourceId=" + i2 + ", title=" + str + ", caption=" + str2 + ", strCode=" + str3 + ", status=" + this.status + ")";
    }

    public SectorData(int i, int i2, String title, String caption, String strCode, int i3) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(caption, "caption");
        Intrinsics.checkNotNullParameter(strCode, "strCode");
        this.sectorId = i;
        this.imageResourceId = i2;
        this.title = title;
        this.caption = caption;
        this.strCode = strCode;
        this.status = i3;
    }

    public final int getSectorId() {
        return this.sectorId;
    }

    public final int getImageResourceId() {
        return this.imageResourceId;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getCaption() {
        return this.caption;
    }

    public /* synthetic */ SectorData(int i, int i2, String str, String str2, String str3, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, str, str2, (i4 & 16) != 0 ? "" : str3, (i4 & 32) != 0 ? 0 : i3);
    }

    public final String getStrCode() {
        return this.strCode;
    }

    public final int getStatus() {
        return this.status;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SectorData(int i, Action action, String strCode, int i2) {
        this(i, action.getIconResource(), StringsKt.replaceFirst$default(action.getTitle(), " ", "\n", false, 4, (Object) null), "", strCode, i2);
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(strCode, "strCode");
    }
}
