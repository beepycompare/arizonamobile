package ru.mrlargha.commonui.elements.donate.domain.models;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: DonateCategoryModel.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\"\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001Be\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0006HÆ\u0003J\u000f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00060\bHÆ\u0003J\t\u0010\"\u001a\u00020\u0006HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J}\u0010)\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b2\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u0003HÆ\u0001J\u0013\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010-\u001a\u00020\u0003HÖ\u0001J\t\u0010.\u001a\u00020\u0006HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\t\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0016\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0013R\u0016\u0010\u000b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0013R\u0016\u0010\f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0013R\u0016\u0010\r\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0013R\u0016\u0010\u000e\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0013R\u0016\u0010\u000f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0013¨\u0006/"}, d2 = {"Lru/mrlargha/commonui/elements/donate/domain/models/DonateCategoryModel;", "", "key", "", "position", "name", "", "borderColor", "", "hoverColor", "image", "backgroundImage", "isNew", "visible", "gridTemplateType", "isActionCategory", "<init>", "(IILjava/lang/String;Ljava/util/List;Ljava/lang/String;IIIIII)V", "getKey", "()I", "getPosition", "getName", "()Ljava/lang/String;", "getBorderColor", "()Ljava/util/List;", "getHoverColor", "getImage", "getBackgroundImage", "getVisible", "getGridTemplateType", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "equals", "", "other", "hashCode", "toString", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DonateCategoryModel {
    @SerializedName("backgroundId")
    private final int backgroundImage;
    @SerializedName("borderColorId")
    private final List<String> borderColor;
    @SerializedName("gridTemplate")
    private final int gridTemplateType;
    @SerializedName("hoverColorId")
    private final String hoverColor;
    @SerializedName("imageId")
    private final int image;
    @SerializedName("isActionCategory")
    private final int isActionCategory;
    @SerializedName("isNew")
    private final int isNew;
    @SerializedName("key")
    private final int key;
    @SerializedName("name")
    private final String name;
    @SerializedName("position")
    private final int position;
    @SerializedName("visible")
    private final int visible;

    public static /* synthetic */ DonateCategoryModel copy$default(DonateCategoryModel donateCategoryModel, int i, int i2, String str, List list, String str2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, Object obj) {
        if ((i9 & 1) != 0) {
            i = donateCategoryModel.key;
        }
        if ((i9 & 2) != 0) {
            i2 = donateCategoryModel.position;
        }
        if ((i9 & 4) != 0) {
            str = donateCategoryModel.name;
        }
        List<String> list2 = list;
        if ((i9 & 8) != 0) {
            list2 = donateCategoryModel.borderColor;
        }
        if ((i9 & 16) != 0) {
            str2 = donateCategoryModel.hoverColor;
        }
        if ((i9 & 32) != 0) {
            i3 = donateCategoryModel.image;
        }
        if ((i9 & 64) != 0) {
            i4 = donateCategoryModel.backgroundImage;
        }
        if ((i9 & 128) != 0) {
            i5 = donateCategoryModel.isNew;
        }
        if ((i9 & 256) != 0) {
            i6 = donateCategoryModel.visible;
        }
        if ((i9 & 512) != 0) {
            i7 = donateCategoryModel.gridTemplateType;
        }
        if ((i9 & 1024) != 0) {
            i8 = donateCategoryModel.isActionCategory;
        }
        int i10 = i7;
        int i11 = i8;
        int i12 = i5;
        int i13 = i6;
        int i14 = i3;
        int i15 = i4;
        String str3 = str2;
        String str4 = str;
        return donateCategoryModel.copy(i, i2, str4, list2, str3, i14, i15, i12, i13, i10, i11);
    }

    public final int component1() {
        return this.key;
    }

    public final int component10() {
        return this.gridTemplateType;
    }

    public final int component11() {
        return this.isActionCategory;
    }

    public final int component2() {
        return this.position;
    }

    public final String component3() {
        return this.name;
    }

    public final List<String> component4() {
        return this.borderColor;
    }

    public final String component5() {
        return this.hoverColor;
    }

    public final int component6() {
        return this.image;
    }

    public final int component7() {
        return this.backgroundImage;
    }

    public final int component8() {
        return this.isNew;
    }

    public final int component9() {
        return this.visible;
    }

    public final DonateCategoryModel copy(int i, int i2, String name, List<String> borderColor, String hoverColor, int i3, int i4, int i5, int i6, int i7, int i8) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(borderColor, "borderColor");
        Intrinsics.checkNotNullParameter(hoverColor, "hoverColor");
        return new DonateCategoryModel(i, i2, name, borderColor, hoverColor, i3, i4, i5, i6, i7, i8);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DonateCategoryModel) {
            DonateCategoryModel donateCategoryModel = (DonateCategoryModel) obj;
            return this.key == donateCategoryModel.key && this.position == donateCategoryModel.position && Intrinsics.areEqual(this.name, donateCategoryModel.name) && Intrinsics.areEqual(this.borderColor, donateCategoryModel.borderColor) && Intrinsics.areEqual(this.hoverColor, donateCategoryModel.hoverColor) && this.image == donateCategoryModel.image && this.backgroundImage == donateCategoryModel.backgroundImage && this.isNew == donateCategoryModel.isNew && this.visible == donateCategoryModel.visible && this.gridTemplateType == donateCategoryModel.gridTemplateType && this.isActionCategory == donateCategoryModel.isActionCategory;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((((((Integer.hashCode(this.key) * 31) + Integer.hashCode(this.position)) * 31) + this.name.hashCode()) * 31) + this.borderColor.hashCode()) * 31) + this.hoverColor.hashCode()) * 31) + Integer.hashCode(this.image)) * 31) + Integer.hashCode(this.backgroundImage)) * 31) + Integer.hashCode(this.isNew)) * 31) + Integer.hashCode(this.visible)) * 31) + Integer.hashCode(this.gridTemplateType)) * 31) + Integer.hashCode(this.isActionCategory);
    }

    public String toString() {
        int i = this.key;
        int i2 = this.position;
        String str = this.name;
        List<String> list = this.borderColor;
        String str2 = this.hoverColor;
        int i3 = this.image;
        int i4 = this.backgroundImage;
        int i5 = this.isNew;
        int i6 = this.visible;
        int i7 = this.gridTemplateType;
        return "DonateCategoryModel(key=" + i + ", position=" + i2 + ", name=" + str + ", borderColor=" + list + ", hoverColor=" + str2 + ", image=" + i3 + ", backgroundImage=" + i4 + ", isNew=" + i5 + ", visible=" + i6 + ", gridTemplateType=" + i7 + ", isActionCategory=" + this.isActionCategory + ")";
    }

    public DonateCategoryModel(int i, int i2, String name, List<String> borderColor, String hoverColor, int i3, int i4, int i5, int i6, int i7, int i8) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(borderColor, "borderColor");
        Intrinsics.checkNotNullParameter(hoverColor, "hoverColor");
        this.key = i;
        this.position = i2;
        this.name = name;
        this.borderColor = borderColor;
        this.hoverColor = hoverColor;
        this.image = i3;
        this.backgroundImage = i4;
        this.isNew = i5;
        this.visible = i6;
        this.gridTemplateType = i7;
        this.isActionCategory = i8;
    }

    public final int getKey() {
        return this.key;
    }

    public final int getPosition() {
        return this.position;
    }

    public final String getName() {
        return this.name;
    }

    public final List<String> getBorderColor() {
        return this.borderColor;
    }

    public final String getHoverColor() {
        return this.hoverColor;
    }

    public final int getImage() {
        return this.image;
    }

    public final int getBackgroundImage() {
        return this.backgroundImage;
    }

    public final int isNew() {
        return this.isNew;
    }

    public final int getVisible() {
        return this.visible;
    }

    public final int getGridTemplateType() {
        return this.gridTemplateType;
    }

    public final int isActionCategory() {
        return this.isActionCategory;
    }
}
