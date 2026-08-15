package ru.mrlargha.feature.mobile.presentation.page.rent.models;

import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ArizonaRentRealEstateModel.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\fJ\n\u0010\u001d\u001a\u00020\u0005H\u0096\u0080\u0004J\u0006\u0010\u001b\u001a\u00020\u001eJ\u0006\u0010\u001c\u001a\u00020\u001eJ\u0006\u0010\u001f\u001a\u00020\u001eJ\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÂ\u0003J\t\u0010&\u001a\u00020\u0003HÂ\u0003JO\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u0003HÆ\u0001J\u0014\u0010(\u001a\u00020\u001e2\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010*\u001a\u00020\u0003HÖ\u0081\u0004R%\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR%\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u0092\u0002\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R%\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000eR%\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000eR%\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u000eR\u001f\u0010\t\u001a\u00020\u00038\u0002X\u0083\u0004\u0092\u0002\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u001b¢\u0006\u0002\n\u0000R\u001f\u0010\n\u001a\u00020\u00038\u0002X\u0083\u0004\u0092\u0002\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u001c¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lru/mrlargha/feature/mobile/presentation/page/rent/models/ArizonaRentRealEstateModel;", "", TtmlNode.ATTR_ID, "", "name", "", "roomCount", "availableRoomCount", "houseId", "publish", "apartment", "<init>", "(ILjava/lang/String;IIIII)V", "getId", "()I", "Lcom/google/gson/annotations/SerializedName;", "value", FirebaseAnalytics.Param.INDEX, "getName", "()Ljava/lang/String;", "title", "getRoomCount", "maxRoom", "getAvailableRoomCount", "currentRoom", "getHouseId", "houseID", "isPublish", "isApartment", "toString", "", "isNotAvailableRooms", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "mobile"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ArizonaRentRealEstateModel {
    @SerializedName("isApartment")
    private final int apartment;
    @SerializedName("currentRoom")
    private final int availableRoomCount;
    @SerializedName("houseID")
    private final int houseId;
    @SerializedName(FirebaseAnalytics.Param.INDEX)
    private final int id;
    @SerializedName("title")
    private final String name;
    @SerializedName("isPublish")
    private final int publish;
    @SerializedName("maxRoom")
    private final int roomCount;

    public ArizonaRentRealEstateModel() {
        this(0, null, 0, 0, 0, 0, 0, 127, null);
    }

    private final int component6() {
        return this.publish;
    }

    private final int component7() {
        return this.apartment;
    }

    public static /* synthetic */ ArizonaRentRealEstateModel copy$default(ArizonaRentRealEstateModel arizonaRentRealEstateModel, int i, String str, int i2, int i3, int i4, int i5, int i6, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            i = arizonaRentRealEstateModel.id;
        }
        if ((i7 & 2) != 0) {
            str = arizonaRentRealEstateModel.name;
        }
        if ((i7 & 4) != 0) {
            i2 = arizonaRentRealEstateModel.roomCount;
        }
        if ((i7 & 8) != 0) {
            i3 = arizonaRentRealEstateModel.availableRoomCount;
        }
        if ((i7 & 16) != 0) {
            i4 = arizonaRentRealEstateModel.houseId;
        }
        if ((i7 & 32) != 0) {
            i5 = arizonaRentRealEstateModel.publish;
        }
        if ((i7 & 64) != 0) {
            i6 = arizonaRentRealEstateModel.apartment;
        }
        int i8 = i5;
        int i9 = i6;
        int i10 = i4;
        int i11 = i2;
        return arizonaRentRealEstateModel.copy(i, str, i11, i3, i10, i8, i9);
    }

    public final int component1() {
        return this.id;
    }

    public final String component2() {
        return this.name;
    }

    public final int component3() {
        return this.roomCount;
    }

    public final int component4() {
        return this.availableRoomCount;
    }

    public final int component5() {
        return this.houseId;
    }

    public final ArizonaRentRealEstateModel copy(int i, String name, int i2, int i3, int i4, int i5, int i6) {
        Intrinsics.checkNotNullParameter(name, "name");
        return new ArizonaRentRealEstateModel(i, name, i2, i3, i4, i5, i6);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ArizonaRentRealEstateModel) {
            ArizonaRentRealEstateModel arizonaRentRealEstateModel = (ArizonaRentRealEstateModel) obj;
            return this.id == arizonaRentRealEstateModel.id && Intrinsics.areEqual(this.name, arizonaRentRealEstateModel.name) && this.roomCount == arizonaRentRealEstateModel.roomCount && this.availableRoomCount == arizonaRentRealEstateModel.availableRoomCount && this.houseId == arizonaRentRealEstateModel.houseId && this.publish == arizonaRentRealEstateModel.publish && this.apartment == arizonaRentRealEstateModel.apartment;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((Integer.hashCode(this.id) * 31) + this.name.hashCode()) * 31) + Integer.hashCode(this.roomCount)) * 31) + Integer.hashCode(this.availableRoomCount)) * 31) + Integer.hashCode(this.houseId)) * 31) + Integer.hashCode(this.publish)) * 31) + Integer.hashCode(this.apartment);
    }

    public ArizonaRentRealEstateModel(int i, String name, int i2, int i3, int i4, int i5, int i6) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.id = i;
        this.name = name;
        this.roomCount = i2;
        this.availableRoomCount = i3;
        this.houseId = i4;
        this.publish = i5;
        this.apartment = i6;
    }

    public final int getId() {
        return this.id;
    }

    public /* synthetic */ ArizonaRentRealEstateModel(int i, String str, int i2, int i3, int i4, int i5, int i6, int i7, DefaultConstructorMarker defaultConstructorMarker) {
        this((i7 & 1) != 0 ? -1 : i, (i7 & 2) != 0 ? "" : str, (i7 & 4) != 0 ? -1 : i2, (i7 & 8) != 0 ? -1 : i3, (i7 & 16) != 0 ? -1 : i4, (i7 & 32) != 0 ? 0 : i5, (i7 & 64) != 0 ? 0 : i6);
    }

    public final String getName() {
        return this.name;
    }

    public final int getRoomCount() {
        return this.roomCount;
    }

    public final int getAvailableRoomCount() {
        return this.availableRoomCount;
    }

    public final int getHouseId() {
        return this.houseId;
    }

    public String toString() {
        return this.name;
    }

    public final boolean isPublish() {
        return this.publish == 1;
    }

    public final boolean isApartment() {
        return this.apartment == 1;
    }

    public final boolean isNotAvailableRooms() {
        return isApartment() && this.availableRoomCount <= 0;
    }
}
