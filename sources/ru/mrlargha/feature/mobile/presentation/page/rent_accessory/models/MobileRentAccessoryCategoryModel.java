package ru.mrlargha.feature.mobile.presentation.page.rent_accessory.models;

import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: MobileRentAccessoryCategoryModel.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J;\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001d\u001a\u00020\u0007HÖ\u0081\u0004J\n\u0010\u001e\u001a\u00020\u0003HÖ\u0081\u0004R%\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0002¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR%\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR%\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR%\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004\u0092\u0002\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R%\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\f¨\u0006\u001f"}, d2 = {"Lru/mrlargha/feature/mobile/presentation/page/rent_accessory/models/MobileRentAccessoryCategoryModel;", "", "color", "", "colorBG", "icon", TtmlNode.ATTR_ID, "", "name", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V", "getColor", "()Ljava/lang/String;", "Lcom/google/gson/annotations/SerializedName;", "value", "getColorBG", "getIcon", "getId", "()I", "getName", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "mobile"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class MobileRentAccessoryCategoryModel {
    @SerializedName("color")
    private final String color;
    @SerializedName("colorBG")
    private final String colorBG;
    @SerializedName("icon")
    private final String icon;
    @SerializedName(TtmlNode.ATTR_ID)
    private final int id;
    @SerializedName("name")
    private final String name;

    public static /* synthetic */ MobileRentAccessoryCategoryModel copy$default(MobileRentAccessoryCategoryModel mobileRentAccessoryCategoryModel, String str, String str2, String str3, int i, String str4, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = mobileRentAccessoryCategoryModel.color;
        }
        if ((i2 & 2) != 0) {
            str2 = mobileRentAccessoryCategoryModel.colorBG;
        }
        if ((i2 & 4) != 0) {
            str3 = mobileRentAccessoryCategoryModel.icon;
        }
        if ((i2 & 8) != 0) {
            i = mobileRentAccessoryCategoryModel.id;
        }
        if ((i2 & 16) != 0) {
            str4 = mobileRentAccessoryCategoryModel.name;
        }
        String str5 = str4;
        String str6 = str3;
        return mobileRentAccessoryCategoryModel.copy(str, str2, str6, i, str5);
    }

    public final String component1() {
        return this.color;
    }

    public final String component2() {
        return this.colorBG;
    }

    public final String component3() {
        return this.icon;
    }

    public final int component4() {
        return this.id;
    }

    public final String component5() {
        return this.name;
    }

    public final MobileRentAccessoryCategoryModel copy(String color, String colorBG, String icon, int i, String name) {
        Intrinsics.checkNotNullParameter(color, "color");
        Intrinsics.checkNotNullParameter(colorBG, "colorBG");
        Intrinsics.checkNotNullParameter(icon, "icon");
        Intrinsics.checkNotNullParameter(name, "name");
        return new MobileRentAccessoryCategoryModel(color, colorBG, icon, i, name);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MobileRentAccessoryCategoryModel) {
            MobileRentAccessoryCategoryModel mobileRentAccessoryCategoryModel = (MobileRentAccessoryCategoryModel) obj;
            return Intrinsics.areEqual(this.color, mobileRentAccessoryCategoryModel.color) && Intrinsics.areEqual(this.colorBG, mobileRentAccessoryCategoryModel.colorBG) && Intrinsics.areEqual(this.icon, mobileRentAccessoryCategoryModel.icon) && this.id == mobileRentAccessoryCategoryModel.id && Intrinsics.areEqual(this.name, mobileRentAccessoryCategoryModel.name);
        }
        return false;
    }

    public int hashCode() {
        return (((((((this.color.hashCode() * 31) + this.colorBG.hashCode()) * 31) + this.icon.hashCode()) * 31) + Integer.hashCode(this.id)) * 31) + this.name.hashCode();
    }

    public String toString() {
        String str = this.color;
        String str2 = this.colorBG;
        String str3 = this.icon;
        int i = this.id;
        return "MobileRentAccessoryCategoryModel(color=" + str + ", colorBG=" + str2 + ", icon=" + str3 + ", id=" + i + ", name=" + this.name + ")";
    }

    public MobileRentAccessoryCategoryModel(String color, String colorBG, String icon, int i, String name) {
        Intrinsics.checkNotNullParameter(color, "color");
        Intrinsics.checkNotNullParameter(colorBG, "colorBG");
        Intrinsics.checkNotNullParameter(icon, "icon");
        Intrinsics.checkNotNullParameter(name, "name");
        this.color = color;
        this.colorBG = colorBG;
        this.icon = icon;
        this.id = i;
        this.name = name;
    }

    public final String getColor() {
        return this.color;
    }

    public final String getColorBG() {
        return this.colorBG;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final int getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }
}
