package ru.mrlargha.commonui.elements.donate.presentation.models;

import io.appmetrica.analytics.impl.L2;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: DonateCategoryModel.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u001b\b\u0086\b\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\u000bHÆ\u0003J\t\u0010 \u001a\u00020\u000bHÆ\u0003J[\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000bHÆ\u0001J\u0013\u0010\"\u001a\u00020\u000b2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020\u0003HÖ\u0001J\t\u0010%\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0017R\u0011\u0010\f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017¨\u0006&"}, d2 = {"Lru/mrlargha/commonui/elements/donate/presentation/models/DonateCategoryModel;", "", "id", "", "title", "", "borderColor", "hoverColor", "image", L2.g, "isNew", "", "visible", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZ)V", "getId", "()I", "getTitle", "()Ljava/lang/String;", "getBorderColor", "getHoverColor", "getImage", "getBackground", "()Z", "getVisible", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "toString", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DonateCategoryModel {
    private final String background;
    private final String borderColor;
    private final String hoverColor;
    private final int id;
    private final String image;
    private final boolean isNew;
    private final String title;
    private final boolean visible;

    public static /* synthetic */ DonateCategoryModel copy$default(DonateCategoryModel donateCategoryModel, int i, String str, String str2, String str3, String str4, String str5, boolean z, boolean z2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = donateCategoryModel.id;
        }
        if ((i2 & 2) != 0) {
            str = donateCategoryModel.title;
        }
        if ((i2 & 4) != 0) {
            str2 = donateCategoryModel.borderColor;
        }
        if ((i2 & 8) != 0) {
            str3 = donateCategoryModel.hoverColor;
        }
        if ((i2 & 16) != 0) {
            str4 = donateCategoryModel.image;
        }
        if ((i2 & 32) != 0) {
            str5 = donateCategoryModel.background;
        }
        if ((i2 & 64) != 0) {
            z = donateCategoryModel.isNew;
        }
        if ((i2 & 128) != 0) {
            z2 = donateCategoryModel.visible;
        }
        boolean z3 = z;
        boolean z4 = z2;
        String str6 = str4;
        String str7 = str5;
        return donateCategoryModel.copy(i, str, str2, str3, str6, str7, z3, z4);
    }

    public final int component1() {
        return this.id;
    }

    public final String component2() {
        return this.title;
    }

    public final String component3() {
        return this.borderColor;
    }

    public final String component4() {
        return this.hoverColor;
    }

    public final String component5() {
        return this.image;
    }

    public final String component6() {
        return this.background;
    }

    public final boolean component7() {
        return this.isNew;
    }

    public final boolean component8() {
        return this.visible;
    }

    public final DonateCategoryModel copy(int i, String title, String str, String hoverColor, String image, String background, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(hoverColor, "hoverColor");
        Intrinsics.checkNotNullParameter(image, "image");
        Intrinsics.checkNotNullParameter(background, "background");
        return new DonateCategoryModel(i, title, str, hoverColor, image, background, z, z2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DonateCategoryModel) {
            DonateCategoryModel donateCategoryModel = (DonateCategoryModel) obj;
            return this.id == donateCategoryModel.id && Intrinsics.areEqual(this.title, donateCategoryModel.title) && Intrinsics.areEqual(this.borderColor, donateCategoryModel.borderColor) && Intrinsics.areEqual(this.hoverColor, donateCategoryModel.hoverColor) && Intrinsics.areEqual(this.image, donateCategoryModel.image) && Intrinsics.areEqual(this.background, donateCategoryModel.background) && this.isNew == donateCategoryModel.isNew && this.visible == donateCategoryModel.visible;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((Integer.hashCode(this.id) * 31) + this.title.hashCode()) * 31;
        String str = this.borderColor;
        return ((((((((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.hoverColor.hashCode()) * 31) + this.image.hashCode()) * 31) + this.background.hashCode()) * 31) + Boolean.hashCode(this.isNew)) * 31) + Boolean.hashCode(this.visible);
    }

    public String toString() {
        int i = this.id;
        String str = this.title;
        String str2 = this.borderColor;
        String str3 = this.hoverColor;
        String str4 = this.image;
        String str5 = this.background;
        boolean z = this.isNew;
        return "DonateCategoryModel(id=" + i + ", title=" + str + ", borderColor=" + str2 + ", hoverColor=" + str3 + ", image=" + str4 + ", background=" + str5 + ", isNew=" + z + ", visible=" + this.visible + ")";
    }

    public DonateCategoryModel(int i, String title, String str, String hoverColor, String image, String background, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(hoverColor, "hoverColor");
        Intrinsics.checkNotNullParameter(image, "image");
        Intrinsics.checkNotNullParameter(background, "background");
        this.id = i;
        this.title = title;
        this.borderColor = str;
        this.hoverColor = hoverColor;
        this.image = image;
        this.background = background;
        this.isNew = z;
        this.visible = z2;
    }

    public final int getId() {
        return this.id;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getBorderColor() {
        return this.borderColor;
    }

    public final String getHoverColor() {
        return this.hoverColor;
    }

    public final String getImage() {
        return this.image;
    }

    public final String getBackground() {
        return this.background;
    }

    public final boolean isNew() {
        return this.isNew;
    }

    public final boolean getVisible() {
        return this.visible;
    }
}
