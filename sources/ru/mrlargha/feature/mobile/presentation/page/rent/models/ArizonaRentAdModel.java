package ru.mrlargha.feature.mobile.presentation.page.rent.models;

import android.content.Context;
import android.util.Log;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.utils.UtilsKt;
/* compiled from: ArizonaRentAdModel.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u001a\b\u0086\b\u0018\u00002\u00020\u0001B\u0097\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\u0014\u001a\u00020\b\u0012\u0006\u0010\u0015\u001a\u00020\u0003\u0012\u0006\u0010\u0016\u001a\u00020\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u000e\u0010+\u001a\u00020\u00122\u0006\u0010,\u001a\u00020-J\u0006\u0010.\u001a\u00020\u0012J\u0006\u0010/\u001a\u00020\u0012J\t\u00100\u001a\u00020\u0003HÆ\u0003J\t\u00101\u001a\u00020\u0003HÆ\u0003J\t\u00102\u001a\u00020\u0003HÆ\u0003J\t\u00103\u001a\u00020\u0003HÆ\u0003J\t\u00104\u001a\u00020\bHÆ\u0003J\t\u00105\u001a\u00020\u0003HÆ\u0003J\t\u00106\u001a\u00020\u0003HÆ\u0003J\t\u00107\u001a\u00020\u0003HÆ\u0003J\t\u00108\u001a\u00020\u0003HÂ\u0003J\t\u00109\u001a\u00020\u0003HÆ\u0003J\t\u0010:\u001a\u00020\u0003HÆ\u0003J\t\u0010;\u001a\u00020\u0003HÆ\u0003J\t\u0010<\u001a\u00020\u0003HÆ\u0003J\t\u0010=\u001a\u00020\u0012HÆ\u0003J\t\u0010>\u001a\u00020\u0012HÆ\u0003J\t\u0010?\u001a\u00020\bHÆ\u0003J\t\u0010@\u001a\u00020\u0003HÆ\u0003J\t\u0010A\u001a\u00020\u0003HÆ\u0003J½\u0001\u0010B\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0014\u001a\u00020\b2\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u0003HÆ\u0001J\u0014\u0010C\u001a\u00020\u00122\b\u0010D\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010E\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010F\u001a\u00020\bHÖ\u0081\u0004R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001aR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001aR\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001aR\u0016\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001aR\u0016\u0010\u000b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001aR\u0010\u0010\f\u001a\u00020\u00038\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001aR\u0016\u0010\u000e\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001aR\u0016\u0010\u000f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001aR\u0016\u0010\u0010\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001aR\u0016\u0010\u0011\u001a\u00020\u00128\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010'R\u0016\u0010\u0013\u001a\u00020\u00128\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010'R\u0016\u0010\u0014\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001fR\u0016\u0010\u0015\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001aR\u0016\u0010\u0016\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001a¨\u0006G"}, d2 = {"Lru/mrlargha/feature/mobile/presentation/page/rent/models/ArizonaRentAdModel;", "", "id", "", "number", "ratingId", "playerId", "ownerName", "", "houseNumber", "image", "typeHouse", "typeRent", "startRent", "endRent", "cost", "xPayDay", "isHaveGarage", "", "isHaveBasement", "desc", "listId", "houseOwnerId", "<init>", "(IIIILjava/lang/String;IIIIIIIIZZLjava/lang/String;II)V", "getId", "()I", "getNumber", "getRatingId", "getPlayerId", "getOwnerName", "()Ljava/lang/String;", "getHouseNumber", "getImage", "getTypeHouse", "getStartRent", "getEndRent", "getCost", "getXPayDay", "()Z", "getDesc", "getListId", "getHouseOwnerId", "getIsMy", "context", "Landroid/content/Context;", "isFully", "isHome", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "copy", "equals", "other", "hashCode", "toString", "mobile"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ArizonaRentAdModel {
    @SerializedName("cost")
    private final int cost;
    @SerializedName("description")
    private final String desc;
    @SerializedName("valueEnd")
    private final int endRent;
    @SerializedName("houseID")
    private final int houseNumber;
    @SerializedName("playerUID")
    private final int houseOwnerId;
    @SerializedName("id")
    private final int id;
    @SerializedName("houseInt")
    private final int image;
    @SerializedName("basement")
    private final boolean isHaveBasement;
    @SerializedName("garage")
    private final boolean isHaveGarage;
    @SerializedName("listid")
    private final int listId;
    @SerializedName("number")
    private final int number;
    @SerializedName("playerName")
    private final String ownerName;
    @SerializedName("playerID")
    private final int playerId;
    @SerializedName("raitingID")
    private final int ratingId;
    @SerializedName("valueStart")
    private final int startRent;
    @SerializedName("typeHouse")
    private final int typeHouse;
    @SerializedName("typeRent")
    private final int typeRent;
    @SerializedName("xPayDay")
    private final int xPayDay;

    private final int component9() {
        return this.typeRent;
    }

    public static /* synthetic */ ArizonaRentAdModel copy$default(ArizonaRentAdModel arizonaRentAdModel, int i, int i2, int i3, int i4, String str, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, boolean z, boolean z2, String str2, int i13, int i14, int i15, Object obj) {
        int i16;
        int i17;
        int i18 = (i15 & 1) != 0 ? arizonaRentAdModel.id : i;
        int i19 = (i15 & 2) != 0 ? arizonaRentAdModel.number : i2;
        int i20 = (i15 & 4) != 0 ? arizonaRentAdModel.ratingId : i3;
        int i21 = (i15 & 8) != 0 ? arizonaRentAdModel.playerId : i4;
        String str3 = (i15 & 16) != 0 ? arizonaRentAdModel.ownerName : str;
        int i22 = (i15 & 32) != 0 ? arizonaRentAdModel.houseNumber : i5;
        int i23 = (i15 & 64) != 0 ? arizonaRentAdModel.image : i6;
        int i24 = (i15 & 128) != 0 ? arizonaRentAdModel.typeHouse : i7;
        int i25 = (i15 & 256) != 0 ? arizonaRentAdModel.typeRent : i8;
        int i26 = (i15 & 512) != 0 ? arizonaRentAdModel.startRent : i9;
        int i27 = (i15 & 1024) != 0 ? arizonaRentAdModel.endRent : i10;
        int i28 = (i15 & 2048) != 0 ? arizonaRentAdModel.cost : i11;
        int i29 = (i15 & 4096) != 0 ? arizonaRentAdModel.xPayDay : i12;
        boolean z3 = (i15 & 8192) != 0 ? arizonaRentAdModel.isHaveGarage : z;
        int i30 = i18;
        boolean z4 = (i15 & 16384) != 0 ? arizonaRentAdModel.isHaveBasement : z2;
        String str4 = (i15 & 32768) != 0 ? arizonaRentAdModel.desc : str2;
        int i31 = (i15 & 65536) != 0 ? arizonaRentAdModel.listId : i13;
        if ((i15 & 131072) != 0) {
            i17 = i31;
            i16 = arizonaRentAdModel.houseOwnerId;
        } else {
            i16 = i14;
            i17 = i31;
        }
        return arizonaRentAdModel.copy(i30, i19, i20, i21, str3, i22, i23, i24, i25, i26, i27, i28, i29, z3, z4, str4, i17, i16);
    }

    public final int component1() {
        return this.id;
    }

    public final int component10() {
        return this.startRent;
    }

    public final int component11() {
        return this.endRent;
    }

    public final int component12() {
        return this.cost;
    }

    public final int component13() {
        return this.xPayDay;
    }

    public final boolean component14() {
        return this.isHaveGarage;
    }

    public final boolean component15() {
        return this.isHaveBasement;
    }

    public final String component16() {
        return this.desc;
    }

    public final int component17() {
        return this.listId;
    }

    public final int component18() {
        return this.houseOwnerId;
    }

    public final int component2() {
        return this.number;
    }

    public final int component3() {
        return this.ratingId;
    }

    public final int component4() {
        return this.playerId;
    }

    public final String component5() {
        return this.ownerName;
    }

    public final int component6() {
        return this.houseNumber;
    }

    public final int component7() {
        return this.image;
    }

    public final int component8() {
        return this.typeHouse;
    }

    public final ArizonaRentAdModel copy(int i, int i2, int i3, int i4, String ownerName, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, boolean z, boolean z2, String desc, int i13, int i14) {
        Intrinsics.checkNotNullParameter(ownerName, "ownerName");
        Intrinsics.checkNotNullParameter(desc, "desc");
        return new ArizonaRentAdModel(i, i2, i3, i4, ownerName, i5, i6, i7, i8, i9, i10, i11, i12, z, z2, desc, i13, i14);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ArizonaRentAdModel) {
            ArizonaRentAdModel arizonaRentAdModel = (ArizonaRentAdModel) obj;
            return this.id == arizonaRentAdModel.id && this.number == arizonaRentAdModel.number && this.ratingId == arizonaRentAdModel.ratingId && this.playerId == arizonaRentAdModel.playerId && Intrinsics.areEqual(this.ownerName, arizonaRentAdModel.ownerName) && this.houseNumber == arizonaRentAdModel.houseNumber && this.image == arizonaRentAdModel.image && this.typeHouse == arizonaRentAdModel.typeHouse && this.typeRent == arizonaRentAdModel.typeRent && this.startRent == arizonaRentAdModel.startRent && this.endRent == arizonaRentAdModel.endRent && this.cost == arizonaRentAdModel.cost && this.xPayDay == arizonaRentAdModel.xPayDay && this.isHaveGarage == arizonaRentAdModel.isHaveGarage && this.isHaveBasement == arizonaRentAdModel.isHaveBasement && Intrinsics.areEqual(this.desc, arizonaRentAdModel.desc) && this.listId == arizonaRentAdModel.listId && this.houseOwnerId == arizonaRentAdModel.houseOwnerId;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((((Integer.hashCode(this.id) * 31) + Integer.hashCode(this.number)) * 31) + Integer.hashCode(this.ratingId)) * 31) + Integer.hashCode(this.playerId)) * 31) + this.ownerName.hashCode()) * 31) + Integer.hashCode(this.houseNumber)) * 31) + Integer.hashCode(this.image)) * 31) + Integer.hashCode(this.typeHouse)) * 31) + Integer.hashCode(this.typeRent)) * 31) + Integer.hashCode(this.startRent)) * 31) + Integer.hashCode(this.endRent)) * 31) + Integer.hashCode(this.cost)) * 31) + Integer.hashCode(this.xPayDay)) * 31) + Boolean.hashCode(this.isHaveGarage)) * 31) + Boolean.hashCode(this.isHaveBasement)) * 31) + this.desc.hashCode()) * 31) + Integer.hashCode(this.listId)) * 31) + Integer.hashCode(this.houseOwnerId);
    }

    public String toString() {
        int i = this.id;
        int i2 = this.number;
        int i3 = this.ratingId;
        int i4 = this.playerId;
        String str = this.ownerName;
        int i5 = this.houseNumber;
        int i6 = this.image;
        int i7 = this.typeHouse;
        int i8 = this.typeRent;
        int i9 = this.startRent;
        int i10 = this.endRent;
        int i11 = this.cost;
        int i12 = this.xPayDay;
        boolean z = this.isHaveGarage;
        boolean z2 = this.isHaveBasement;
        String str2 = this.desc;
        int i13 = this.listId;
        return "ArizonaRentAdModel(id=" + i + ", number=" + i2 + ", ratingId=" + i3 + ", playerId=" + i4 + ", ownerName=" + str + ", houseNumber=" + i5 + ", image=" + i6 + ", typeHouse=" + i7 + ", typeRent=" + i8 + ", startRent=" + i9 + ", endRent=" + i10 + ", cost=" + i11 + ", xPayDay=" + i12 + ", isHaveGarage=" + z + ", isHaveBasement=" + z2 + ", desc=" + str2 + ", listId=" + i13 + ", houseOwnerId=" + this.houseOwnerId + ")";
    }

    public ArizonaRentAdModel(int i, int i2, int i3, int i4, String ownerName, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, boolean z, boolean z2, String desc, int i13, int i14) {
        Intrinsics.checkNotNullParameter(ownerName, "ownerName");
        Intrinsics.checkNotNullParameter(desc, "desc");
        this.id = i;
        this.number = i2;
        this.ratingId = i3;
        this.playerId = i4;
        this.ownerName = ownerName;
        this.houseNumber = i5;
        this.image = i6;
        this.typeHouse = i7;
        this.typeRent = i8;
        this.startRent = i9;
        this.endRent = i10;
        this.cost = i11;
        this.xPayDay = i12;
        this.isHaveGarage = z;
        this.isHaveBasement = z2;
        this.desc = desc;
        this.listId = i13;
        this.houseOwnerId = i14;
    }

    public final int getId() {
        return this.id;
    }

    public final int getNumber() {
        return this.number;
    }

    public final int getRatingId() {
        return this.ratingId;
    }

    public final int getPlayerId() {
        return this.playerId;
    }

    public final String getOwnerName() {
        return this.ownerName;
    }

    public final int getHouseNumber() {
        return this.houseNumber;
    }

    public final int getImage() {
        return this.image;
    }

    public final int getTypeHouse() {
        return this.typeHouse;
    }

    public final int getStartRent() {
        return this.startRent;
    }

    public final int getEndRent() {
        return this.endRent;
    }

    public final int getCost() {
        return this.cost;
    }

    public final int getXPayDay() {
        return this.xPayDay;
    }

    public final boolean isHaveGarage() {
        return this.isHaveGarage;
    }

    public final boolean isHaveBasement() {
        return this.isHaveBasement;
    }

    public final String getDesc() {
        return this.desc;
    }

    public final int getListId() {
        return this.listId;
    }

    public final int getHouseOwnerId() {
        return this.houseOwnerId;
    }

    public final boolean getIsMy(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Log.d("arizona_rent", "server: " + UtilsKt.getServerId(context));
        return UtilsKt.getServerId(context).getAccountId() == this.houseOwnerId;
    }

    public final boolean isFully() {
        return this.typeRent == 0;
    }

    public final boolean isHome() {
        return this.typeHouse == 0;
    }
}
