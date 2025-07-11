package ru.mrlargha.arizonaui.mobile.domain.obj;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: MobilePhoneObject.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003JO\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\u0005HÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000e¨\u0006#"}, d2 = {"Lru/mrlargha/arizonaui/mobile/domain/obj/CatchAppInfo;", "", "type", "", "housesCount", "", "businessesCount", "timeLeft", "statusButtonPermission", "totalCount", "buttonText", "<init>", "(Ljava/lang/String;IIIIILjava/lang/String;)V", "getType", "()Ljava/lang/String;", "getHousesCount", "()I", "getBusinessesCount", "getTimeLeft", "getStatusButtonPermission", "getTotalCount", "getButtonText", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "ArizonaUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CatchAppInfo {
    private final int businessesCount;
    private final String buttonText;
    private final int housesCount;
    private final int statusButtonPermission;
    private final int timeLeft;
    private final int totalCount;
    private final String type;

    public static /* synthetic */ CatchAppInfo copy$default(CatchAppInfo catchAppInfo, String str, int i, int i2, int i3, int i4, int i5, String str2, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            str = catchAppInfo.type;
        }
        if ((i6 & 2) != 0) {
            i = catchAppInfo.housesCount;
        }
        if ((i6 & 4) != 0) {
            i2 = catchAppInfo.businessesCount;
        }
        if ((i6 & 8) != 0) {
            i3 = catchAppInfo.timeLeft;
        }
        if ((i6 & 16) != 0) {
            i4 = catchAppInfo.statusButtonPermission;
        }
        if ((i6 & 32) != 0) {
            i5 = catchAppInfo.totalCount;
        }
        if ((i6 & 64) != 0) {
            str2 = catchAppInfo.buttonText;
        }
        int i7 = i5;
        String str3 = str2;
        int i8 = i4;
        int i9 = i2;
        return catchAppInfo.copy(str, i, i9, i3, i8, i7, str3);
    }

    public final String component1() {
        return this.type;
    }

    public final int component2() {
        return this.housesCount;
    }

    public final int component3() {
        return this.businessesCount;
    }

    public final int component4() {
        return this.timeLeft;
    }

    public final int component5() {
        return this.statusButtonPermission;
    }

    public final int component6() {
        return this.totalCount;
    }

    public final String component7() {
        return this.buttonText;
    }

    public final CatchAppInfo copy(String type, int i, int i2, int i3, int i4, int i5, String buttonText) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(buttonText, "buttonText");
        return new CatchAppInfo(type, i, i2, i3, i4, i5, buttonText);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CatchAppInfo) {
            CatchAppInfo catchAppInfo = (CatchAppInfo) obj;
            return Intrinsics.areEqual(this.type, catchAppInfo.type) && this.housesCount == catchAppInfo.housesCount && this.businessesCount == catchAppInfo.businessesCount && this.timeLeft == catchAppInfo.timeLeft && this.statusButtonPermission == catchAppInfo.statusButtonPermission && this.totalCount == catchAppInfo.totalCount && Intrinsics.areEqual(this.buttonText, catchAppInfo.buttonText);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((this.type.hashCode() * 31) + Integer.hashCode(this.housesCount)) * 31) + Integer.hashCode(this.businessesCount)) * 31) + Integer.hashCode(this.timeLeft)) * 31) + Integer.hashCode(this.statusButtonPermission)) * 31) + Integer.hashCode(this.totalCount)) * 31) + this.buttonText.hashCode();
    }

    public String toString() {
        String str = this.type;
        int i = this.housesCount;
        int i2 = this.businessesCount;
        int i3 = this.timeLeft;
        int i4 = this.statusButtonPermission;
        int i5 = this.totalCount;
        return "CatchAppInfo(type=" + str + ", housesCount=" + i + ", businessesCount=" + i2 + ", timeLeft=" + i3 + ", statusButtonPermission=" + i4 + ", totalCount=" + i5 + ", buttonText=" + this.buttonText + ")";
    }

    public CatchAppInfo(String type, int i, int i2, int i3, int i4, int i5, String buttonText) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(buttonText, "buttonText");
        this.type = type;
        this.housesCount = i;
        this.businessesCount = i2;
        this.timeLeft = i3;
        this.statusButtonPermission = i4;
        this.totalCount = i5;
        this.buttonText = buttonText;
    }

    public final String getType() {
        return this.type;
    }

    public final int getHousesCount() {
        return this.housesCount;
    }

    public final int getBusinessesCount() {
        return this.businessesCount;
    }

    public final int getTimeLeft() {
        return this.timeLeft;
    }

    public final int getStatusButtonPermission() {
        return this.statusButtonPermission;
    }

    public final int getTotalCount() {
        return this.totalCount;
    }

    public final String getButtonText() {
        return this.buttonText;
    }
}
