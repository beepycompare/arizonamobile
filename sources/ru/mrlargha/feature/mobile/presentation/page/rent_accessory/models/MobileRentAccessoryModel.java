package ru.mrlargha.feature.mobile.presentation.page.rent_accessory.models;

import android.content.Context;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.utils.UtilsKt;
import ru.mrlargha.feature.mobile.presentation.page.rent_accessory.adapters.MobileRentAccessoryMainAdapter;
/* compiled from: MobileRentAccessoryModel.kt */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001b\b\u0086\b\u0018\u00002\u00020\u0001Bµ\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0003\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0003\u0012\u0006\u0010\u0017\u001a\u00020\u0003\u0012\u0006\u0010\u0018\u001a\u00020\u0003\u0012\u0006\u0010\u0019\u001a\u00020\u0003\u0012\u0006\u0010\u001a\u001a\u00020\u0007\u0012\u0006\u0010\u001b\u001a\u00020\u0003\u0012\u0006\u0010\u001c\u001a\u00020\u0003¢\u0006\u0004\b\u001d\u0010\u001eJ\u000e\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020CJ\u000e\u0010D\u001a\u00020A2\u0006\u0010B\u001a\u00020CJ\u000e\u0010E\u001a\u00020\t2\u0006\u0010F\u001a\u00020GJ\t\u0010H\u001a\u00020\u0003HÆ\u0003J\t\u0010I\u001a\u00020\u0003HÆ\u0003J\t\u0010J\u001a\u00020\u0003HÆ\u0003J\t\u0010K\u001a\u00020\u0007HÆ\u0003J\t\u0010L\u001a\u00020\tHÆ\u0003J\t\u0010M\u001a\u00020\tHÆ\u0003J\t\u0010N\u001a\u00020\tHÆ\u0003J\u000f\u0010O\u001a\b\u0012\u0004\u0012\u00020\u000e0\rHÆ\u0003J\t\u0010P\u001a\u00020\u0003HÆ\u0003J\t\u0010Q\u001a\u00020\u0003HÆ\u0003J\t\u0010R\u001a\u00020\u0007HÆ\u0003J\t\u0010S\u001a\u00020\u0003HÆ\u0003J\t\u0010T\u001a\u00020\u0003HÆ\u0003J\t\u0010U\u001a\u00020\u0015HÆ\u0003J\t\u0010V\u001a\u00020\u0003HÆ\u0003J\t\u0010W\u001a\u00020\u0003HÆ\u0003J\t\u0010X\u001a\u00020\u0003HÆ\u0003J\t\u0010Y\u001a\u00020\u0003HÆ\u0003J\t\u0010Z\u001a\u00020\u0007HÆ\u0003J\t\u0010[\u001a\u00020\u0003HÆ\u0003J\t\u0010\\\u001a\u00020\u0003HÆ\u0003Já\u0001\u0010]\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00072\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00032\b\b\u0002\u0010\u0019\u001a\u00020\u00032\b\b\u0002\u0010\u001a\u001a\u00020\u00072\b\b\u0002\u0010\u001b\u001a\u00020\u00032\b\b\u0002\u0010\u001c\u001a\u00020\u0003HÆ\u0001J\u0014\u0010^\u001a\u00020A2\b\u0010_\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010`\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010a\u001a\u00020\u0007HÖ\u0081\u0004R%\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u0092\u0002\f\b!\u0012\b\b\"\u0012\u0004\b\b(\u0002¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R%\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004\u0092\u0002\f\b!\u0012\b\b\"\u0012\u0004\b\b(\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010 R%\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004\u0092\u0002\f\b!\u0012\b\b\"\u0012\u0004\b\b(\u0005¢\u0006\b\n\u0000\u001a\u0004\b$\u0010 R%\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004\u0092\u0002\f\b!\u0012\b\b\"\u0012\u0004\b\b(\u0006¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R%\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004\u0092\u0002\f\b!\u0012\b\b\"\u0012\u0004\b\b()¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R%\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004\u0092\u0002\f\b!\u0012\b\b\"\u0012\u0004\b\b(+¢\u0006\b\n\u0000\u001a\u0004\b*\u0010(R%\u0010\u000b\u001a\u00020\t8\u0006X\u0087\u0004\u0092\u0002\f\b!\u0012\b\b\"\u0012\u0004\b\b(-¢\u0006\b\n\u0000\u001a\u0004\b,\u0010(R+\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0006X\u0087\u0004\u0092\u0002\f\b!\u0012\b\b\"\u0012\u0004\b\b(\f¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R%\u0010\u000f\u001a\u00020\u00038\u0006X\u0087\u0004\u0092\u0002\f\b!\u0012\b\b\"\u0012\u0004\b\b(\u000f¢\u0006\b\n\u0000\u001a\u0004\b0\u0010 R%\u0010\u0010\u001a\u00020\u00038\u0006X\u0087\u0004\u0092\u0002\f\b!\u0012\b\b\"\u0012\u0004\b\b(\u0010¢\u0006\b\n\u0000\u001a\u0004\b1\u0010 R%\u0010\u0011\u001a\u00020\u00078\u0006X\u0087\u0004\u0092\u0002\f\b!\u0012\b\b\"\u0012\u0004\b\b(3¢\u0006\b\n\u0000\u001a\u0004\b2\u0010&R%\u0010\u0012\u001a\u00020\u00038\u0006X\u0087\u0004\u0092\u0002\f\b!\u0012\b\b\"\u0012\u0004\b\b(\u0012¢\u0006\b\n\u0000\u001a\u0004\b4\u0010 R%\u0010\u0013\u001a\u00020\u00038\u0006X\u0087\u0004\u0092\u0002\f\b!\u0012\b\b\"\u0012\u0004\b\b(\u0013¢\u0006\b\n\u0000\u001a\u0004\b5\u0010 R%\u0010\u0014\u001a\u00020\u00158\u0006X\u0087\u0004\u0092\u0002\f\b!\u0012\b\b\"\u0012\u0004\b\b(\u0014¢\u0006\b\n\u0000\u001a\u0004\b6\u00107R%\u0010\u0016\u001a\u00020\u00038\u0006X\u0087\u0004\u0092\u0002\f\b!\u0012\b\b\"\u0012\u0004\b\b(\u0016¢\u0006\b\n\u0000\u001a\u0004\b8\u0010 R%\u0010\u0017\u001a\u00020\u00038\u0006X\u0087\u0004\u0092\u0002\f\b!\u0012\b\b\"\u0012\u0004\b\b(\u0017¢\u0006\b\n\u0000\u001a\u0004\b9\u0010 R%\u0010\u0018\u001a\u00020\u00038\u0006X\u0087\u0004\u0092\u0002\f\b!\u0012\b\b\"\u0012\u0004\b\b(\u0018¢\u0006\b\n\u0000\u001a\u0004\b:\u0010 R%\u0010\u0019\u001a\u00020\u00038\u0006X\u0087\u0004\u0092\u0002\f\b!\u0012\b\b\"\u0012\u0004\b\b(\u0019¢\u0006\b\n\u0000\u001a\u0004\b;\u0010 R%\u0010\u001a\u001a\u00020\u00078\u0006X\u0087\u0004\u0092\u0002\f\b!\u0012\b\b\"\u0012\u0004\b\b(\u001a¢\u0006\b\n\u0000\u001a\u0004\b<\u0010&R%\u0010\u001b\u001a\u00020\u00038\u0006X\u0087\u0004\u0092\u0002\f\b!\u0012\b\b\"\u0012\u0004\b\b(\u001b¢\u0006\b\n\u0000\u001a\u0004\b=\u0010 R%\u0010\u001c\u001a\u00020\u00038\u0006X\u0087\u0004\u0092\u0002\f\b!\u0012\b\b\"\u0012\u0004\b\b(?¢\u0006\b\n\u0000\u001a\u0004\b>\u0010 ¨\u0006b"}, d2 = {"Lru/mrlargha/feature/mobile/presentation/page/rent_accessory/models/MobileRentAccessoryModel;", "", "bizID", "", "category", "cost", "description", "", "enterX", "", "enterY", "enterZ", "items", "", "Lru/mrlargha/feature/mobile/presentation/page/rent_accessory/models/MobileRentAccessoryModelItem;", "listID", "listUID", "nickName", "ownerPlayerUID", "rating", "rentEndUnix", "", "rentPlayerID", "rentPlayerUID", "status", "type", "posName", "bizPercent", "bizPercentColorBg", "<init>", "(IIILjava/lang/String;DDDLjava/util/List;IILjava/lang/String;IIJIIIILjava/lang/String;II)V", "getBizID", "()I", "Lcom/google/gson/annotations/SerializedName;", "value", "getCategory", "getCost", "getDescription", "()Ljava/lang/String;", "getEnterX", "()D", "Enter_X", "getEnterY", "Enter_Y", "getEnterZ", "Enter_Z", "getItems", "()Ljava/util/List;", "getListID", "getListUID", "getNickName", "NickName", "getOwnerPlayerUID", "getRating", "getRentEndUnix", "()J", "getRentPlayerID", "getRentPlayerUID", "getStatus", "getType", "getPosName", "getBizPercent", "getBizPercentColorBg", "bizPercentColorBG", "getIsMy", "", "context", "Landroid/content/Context;", "getIsRent", "calculateDistanceToEnter", "userPositon", "Lru/mrlargha/feature/mobile/presentation/page/rent_accessory/adapters/MobileRentAccessoryMainAdapter$Companion$UserPosition;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "copy", "equals", "other", "hashCode", "toString", "mobile"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class MobileRentAccessoryModel {
    @SerializedName("bizID")
    private final int bizID;
    @SerializedName("bizPercent")
    private final int bizPercent;
    @SerializedName("bizPercentColorBG")
    private final int bizPercentColorBg;
    @SerializedName("category")
    private final int category;
    @SerializedName("cost")
    private final int cost;
    @SerializedName("description")
    private final String description;
    @SerializedName("Enter_X")
    private final double enterX;
    @SerializedName("Enter_Y")
    private final double enterY;
    @SerializedName("Enter_Z")
    private final double enterZ;
    @SerializedName("items")
    private final List<MobileRentAccessoryModelItem> items;
    @SerializedName("listID")
    private final int listID;
    @SerializedName("listUID")
    private final int listUID;
    @SerializedName("NickName")
    private final String nickName;
    @SerializedName("ownerPlayerUID")
    private final int ownerPlayerUID;
    @SerializedName("posName")
    private final String posName;
    @SerializedName("rating")
    private final int rating;
    @SerializedName("rentEndUnix")
    private final long rentEndUnix;
    @SerializedName("rentPlayerID")
    private final int rentPlayerID;
    @SerializedName("rentPlayerUID")
    private final int rentPlayerUID;
    @SerializedName("status")
    private final int status;
    @SerializedName("type")
    private final int type;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MobileRentAccessoryModel copy$default(MobileRentAccessoryModel mobileRentAccessoryModel, int i, int i2, int i3, String str, double d, double d2, double d3, List list, int i4, int i5, String str2, int i6, int i7, long j, int i8, int i9, int i10, int i11, String str3, int i12, int i13, int i14, Object obj) {
        int i15;
        int i16;
        int i17 = (i14 & 1) != 0 ? mobileRentAccessoryModel.bizID : i;
        int i18 = (i14 & 2) != 0 ? mobileRentAccessoryModel.category : i2;
        int i19 = (i14 & 4) != 0 ? mobileRentAccessoryModel.cost : i3;
        String str4 = (i14 & 8) != 0 ? mobileRentAccessoryModel.description : str;
        double d4 = (i14 & 16) != 0 ? mobileRentAccessoryModel.enterX : d;
        double d5 = (i14 & 32) != 0 ? mobileRentAccessoryModel.enterY : d2;
        double d6 = (i14 & 64) != 0 ? mobileRentAccessoryModel.enterZ : d3;
        List<MobileRentAccessoryModelItem> list2 = (i14 & 128) != 0 ? mobileRentAccessoryModel.items : list;
        int i20 = (i14 & 256) != 0 ? mobileRentAccessoryModel.listID : i4;
        int i21 = (i14 & 512) != 0 ? mobileRentAccessoryModel.listUID : i5;
        String str5 = (i14 & 1024) != 0 ? mobileRentAccessoryModel.nickName : str2;
        int i22 = i17;
        int i23 = (i14 & 2048) != 0 ? mobileRentAccessoryModel.ownerPlayerUID : i6;
        int i24 = (i14 & 4096) != 0 ? mobileRentAccessoryModel.rating : i7;
        int i25 = i18;
        long j2 = (i14 & 8192) != 0 ? mobileRentAccessoryModel.rentEndUnix : j;
        int i26 = (i14 & 16384) != 0 ? mobileRentAccessoryModel.rentPlayerID : i8;
        int i27 = (32768 & i14) != 0 ? mobileRentAccessoryModel.rentPlayerUID : i9;
        int i28 = (i14 & 65536) != 0 ? mobileRentAccessoryModel.status : i10;
        int i29 = (i14 & 131072) != 0 ? mobileRentAccessoryModel.type : i11;
        String str6 = (i14 & 262144) != 0 ? mobileRentAccessoryModel.posName : str3;
        int i30 = (i14 & 524288) != 0 ? mobileRentAccessoryModel.bizPercent : i12;
        if ((i14 & 1048576) != 0) {
            i16 = i30;
            i15 = mobileRentAccessoryModel.bizPercentColorBg;
        } else {
            i15 = i13;
            i16 = i30;
        }
        return mobileRentAccessoryModel.copy(i22, i25, i19, str4, d4, d5, d6, list2, i20, i21, str5, i23, i24, j2, i26, i27, i28, i29, str6, i16, i15);
    }

    public final int component1() {
        return this.bizID;
    }

    public final int component10() {
        return this.listUID;
    }

    public final String component11() {
        return this.nickName;
    }

    public final int component12() {
        return this.ownerPlayerUID;
    }

    public final int component13() {
        return this.rating;
    }

    public final long component14() {
        return this.rentEndUnix;
    }

    public final int component15() {
        return this.rentPlayerID;
    }

    public final int component16() {
        return this.rentPlayerUID;
    }

    public final int component17() {
        return this.status;
    }

    public final int component18() {
        return this.type;
    }

    public final String component19() {
        return this.posName;
    }

    public final int component2() {
        return this.category;
    }

    public final int component20() {
        return this.bizPercent;
    }

    public final int component21() {
        return this.bizPercentColorBg;
    }

    public final int component3() {
        return this.cost;
    }

    public final String component4() {
        return this.description;
    }

    public final double component5() {
        return this.enterX;
    }

    public final double component6() {
        return this.enterY;
    }

    public final double component7() {
        return this.enterZ;
    }

    public final List<MobileRentAccessoryModelItem> component8() {
        return this.items;
    }

    public final int component9() {
        return this.listID;
    }

    public final MobileRentAccessoryModel copy(int i, int i2, int i3, String description, double d, double d2, double d3, List<MobileRentAccessoryModelItem> items, int i4, int i5, String nickName, int i6, int i7, long j, int i8, int i9, int i10, int i11, String posName, int i12, int i13) {
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(nickName, "nickName");
        Intrinsics.checkNotNullParameter(posName, "posName");
        return new MobileRentAccessoryModel(i, i2, i3, description, d, d2, d3, items, i4, i5, nickName, i6, i7, j, i8, i9, i10, i11, posName, i12, i13);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MobileRentAccessoryModel) {
            MobileRentAccessoryModel mobileRentAccessoryModel = (MobileRentAccessoryModel) obj;
            return this.bizID == mobileRentAccessoryModel.bizID && this.category == mobileRentAccessoryModel.category && this.cost == mobileRentAccessoryModel.cost && Intrinsics.areEqual(this.description, mobileRentAccessoryModel.description) && Double.compare(this.enterX, mobileRentAccessoryModel.enterX) == 0 && Double.compare(this.enterY, mobileRentAccessoryModel.enterY) == 0 && Double.compare(this.enterZ, mobileRentAccessoryModel.enterZ) == 0 && Intrinsics.areEqual(this.items, mobileRentAccessoryModel.items) && this.listID == mobileRentAccessoryModel.listID && this.listUID == mobileRentAccessoryModel.listUID && Intrinsics.areEqual(this.nickName, mobileRentAccessoryModel.nickName) && this.ownerPlayerUID == mobileRentAccessoryModel.ownerPlayerUID && this.rating == mobileRentAccessoryModel.rating && this.rentEndUnix == mobileRentAccessoryModel.rentEndUnix && this.rentPlayerID == mobileRentAccessoryModel.rentPlayerID && this.rentPlayerUID == mobileRentAccessoryModel.rentPlayerUID && this.status == mobileRentAccessoryModel.status && this.type == mobileRentAccessoryModel.type && Intrinsics.areEqual(this.posName, mobileRentAccessoryModel.posName) && this.bizPercent == mobileRentAccessoryModel.bizPercent && this.bizPercentColorBg == mobileRentAccessoryModel.bizPercentColorBg;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((((((((((Integer.hashCode(this.bizID) * 31) + Integer.hashCode(this.category)) * 31) + Integer.hashCode(this.cost)) * 31) + this.description.hashCode()) * 31) + Double.hashCode(this.enterX)) * 31) + Double.hashCode(this.enterY)) * 31) + Double.hashCode(this.enterZ)) * 31) + this.items.hashCode()) * 31) + Integer.hashCode(this.listID)) * 31) + Integer.hashCode(this.listUID)) * 31) + this.nickName.hashCode()) * 31) + Integer.hashCode(this.ownerPlayerUID)) * 31) + Integer.hashCode(this.rating)) * 31) + Long.hashCode(this.rentEndUnix)) * 31) + Integer.hashCode(this.rentPlayerID)) * 31) + Integer.hashCode(this.rentPlayerUID)) * 31) + Integer.hashCode(this.status)) * 31) + Integer.hashCode(this.type)) * 31) + this.posName.hashCode()) * 31) + Integer.hashCode(this.bizPercent)) * 31) + Integer.hashCode(this.bizPercentColorBg);
    }

    public String toString() {
        int i = this.bizID;
        int i2 = this.category;
        int i3 = this.cost;
        String str = this.description;
        double d = this.enterX;
        double d2 = this.enterY;
        double d3 = this.enterZ;
        List<MobileRentAccessoryModelItem> list = this.items;
        int i4 = this.listID;
        int i5 = this.listUID;
        String str2 = this.nickName;
        int i6 = this.ownerPlayerUID;
        int i7 = this.rating;
        long j = this.rentEndUnix;
        int i8 = this.rentPlayerID;
        int i9 = this.rentPlayerUID;
        int i10 = this.status;
        int i11 = this.type;
        String str3 = this.posName;
        int i12 = this.bizPercent;
        return "MobileRentAccessoryModel(bizID=" + i + ", category=" + i2 + ", cost=" + i3 + ", description=" + str + ", enterX=" + d + ", enterY=" + d2 + ", enterZ=" + d3 + ", items=" + list + ", listID=" + i4 + ", listUID=" + i5 + ", nickName=" + str2 + ", ownerPlayerUID=" + i6 + ", rating=" + i7 + ", rentEndUnix=" + j + ", rentPlayerID=" + i8 + ", rentPlayerUID=" + i9 + ", status=" + i10 + ", type=" + i11 + ", posName=" + str3 + ", bizPercent=" + i12 + ", bizPercentColorBg=" + this.bizPercentColorBg + ")";
    }

    public MobileRentAccessoryModel(int i, int i2, int i3, String description, double d, double d2, double d3, List<MobileRentAccessoryModelItem> items, int i4, int i5, String nickName, int i6, int i7, long j, int i8, int i9, int i10, int i11, String posName, int i12, int i13) {
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(nickName, "nickName");
        Intrinsics.checkNotNullParameter(posName, "posName");
        this.bizID = i;
        this.category = i2;
        this.cost = i3;
        this.description = description;
        this.enterX = d;
        this.enterY = d2;
        this.enterZ = d3;
        this.items = items;
        this.listID = i4;
        this.listUID = i5;
        this.nickName = nickName;
        this.ownerPlayerUID = i6;
        this.rating = i7;
        this.rentEndUnix = j;
        this.rentPlayerID = i8;
        this.rentPlayerUID = i9;
        this.status = i10;
        this.type = i11;
        this.posName = posName;
        this.bizPercent = i12;
        this.bizPercentColorBg = i13;
    }

    public final int getBizID() {
        return this.bizID;
    }

    public final int getCategory() {
        return this.category;
    }

    public final int getCost() {
        return this.cost;
    }

    public final String getDescription() {
        return this.description;
    }

    public final double getEnterX() {
        return this.enterX;
    }

    public final double getEnterY() {
        return this.enterY;
    }

    public final double getEnterZ() {
        return this.enterZ;
    }

    public final List<MobileRentAccessoryModelItem> getItems() {
        return this.items;
    }

    public final int getListID() {
        return this.listID;
    }

    public final int getListUID() {
        return this.listUID;
    }

    public final String getNickName() {
        return this.nickName;
    }

    public final int getOwnerPlayerUID() {
        return this.ownerPlayerUID;
    }

    public final int getRating() {
        return this.rating;
    }

    public final long getRentEndUnix() {
        return this.rentEndUnix;
    }

    public final int getRentPlayerID() {
        return this.rentPlayerID;
    }

    public final int getRentPlayerUID() {
        return this.rentPlayerUID;
    }

    public final int getStatus() {
        return this.status;
    }

    public final int getType() {
        return this.type;
    }

    public final String getPosName() {
        return this.posName;
    }

    public final int getBizPercent() {
        return this.bizPercent;
    }

    public final int getBizPercentColorBg() {
        return this.bizPercentColorBg;
    }

    public final boolean getIsMy(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return UtilsKt.getServerId(context).getAccountId() == this.ownerPlayerUID;
    }

    public final boolean getIsRent(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return UtilsKt.getServerId(context).getAccountId() == this.rentPlayerUID;
    }

    public final double calculateDistanceToEnter(MobileRentAccessoryMainAdapter.Companion.UserPosition userPositon) {
        Intrinsics.checkNotNullParameter(userPositon, "userPositon");
        return Math.sqrt(Math.pow(this.enterX - userPositon.getX(), 2.0d) + Math.pow(this.enterY - userPositon.getY(), 2.0d) + Math.pow(this.enterZ - userPositon.getZ(), 2.0d));
    }
}
