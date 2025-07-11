package ru.mrlargha.commonui.elements.tuningAuto.domain;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ResponseData.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b-\b\u0086\b\u0018\u00002\u00020\u0001B\u0087\u0001\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0010\u001a\u00020\u000e\u0012\u0006\u0010\u0011\u001a\u00020\u0006\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u0012\u0006\u0010\u0014\u001a\u00020\u0015¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0019J\u0010\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0019J\t\u0010/\u001a\u00020\u0006HÆ\u0003J\u0010\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0019J\t\u00101\u001a\u00020\u0006HÆ\u0003J\t\u00102\u001a\u00020\u0006HÆ\u0003J\t\u00103\u001a\u00020\u0006HÆ\u0003J\t\u00104\u001a\u00020\fHÆ\u0003J\t\u00105\u001a\u00020\u000eHÆ\u0003J\t\u00106\u001a\u00020\u000eHÆ\u0003J\t\u00107\u001a\u00020\u000eHÆ\u0003J\t\u00108\u001a\u00020\u0006HÆ\u0003J\u0010\u00109\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0019J\t\u0010:\u001a\u00020\u000eHÆ\u0003J\t\u0010;\u001a\u00020\u0015HÆ\u0003J¬\u0001\u0010<\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u00062\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u000e2\b\b\u0002\u0010\u0014\u001a\u00020\u0015HÆ\u0001¢\u0006\u0002\u0010=J\u0013\u0010>\u001a\u00020\u000e2\b\u0010?\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010@\u001a\u00020\u0003HÖ\u0001J\t\u0010A\u001a\u00020\u0006HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u001b\u0010\u0019R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u001e\u0010\u0019R\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001dR\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001dR\u0011\u0010\n\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001dR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010\u000f\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b&\u0010%R\u0011\u0010\u0010\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b'\u0010%R\u0011\u0010\u0011\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001dR\u0015\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b)\u0010\u0019R\u0011\u0010\u0013\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b*\u0010%R\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,¨\u0006B"}, d2 = {"Lru/mrlargha/commonui/elements/tuningAuto/domain/CategoryComponents;", "", "id", "", "categoryId", "header", "", "color", "name", "text", "icon", FirebaseAnalytics.Param.PRICE, "", "installed", "", "available", "inCart", "statusText", "statusColor", "hidePriceButton", "scale", "", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JZZZLjava/lang/String;Ljava/lang/Integer;ZF)V", "getId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCategoryId", "getHeader", "()Ljava/lang/String;", "getColor", "getName", "getText", "getIcon", "getPrice", "()J", "getInstalled", "()Z", "getAvailable", "getInCart", "getStatusText", "getStatusColor", "getHidePriceButton", "getScale", "()F", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JZZZLjava/lang/String;Ljava/lang/Integer;ZF)Lru/mrlargha/commonui/elements/tuningAuto/domain/CategoryComponents;", "equals", "other", "hashCode", "toString", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CategoryComponents {
    private final boolean available;
    private final Integer categoryId;
    private final Integer color;
    private final String header;
    private final boolean hidePriceButton;
    private final String icon;
    private final Integer id;
    private final boolean inCart;
    private final boolean installed;
    private final String name;
    private final long price;
    private final float scale;
    private final Integer statusColor;
    private final String statusText;
    private final String text;

    public static /* synthetic */ CategoryComponents copy$default(CategoryComponents categoryComponents, Integer num, Integer num2, String str, Integer num3, String str2, String str3, String str4, long j, boolean z, boolean z2, boolean z3, String str5, Integer num4, boolean z4, float f, int i, Object obj) {
        Integer num5 = (i & 1) != 0 ? categoryComponents.id : num;
        return categoryComponents.copy(num5, (i & 2) != 0 ? categoryComponents.categoryId : num2, (i & 4) != 0 ? categoryComponents.header : str, (i & 8) != 0 ? categoryComponents.color : num3, (i & 16) != 0 ? categoryComponents.name : str2, (i & 32) != 0 ? categoryComponents.text : str3, (i & 64) != 0 ? categoryComponents.icon : str4, (i & 128) != 0 ? categoryComponents.price : j, (i & 256) != 0 ? categoryComponents.installed : z, (i & 512) != 0 ? categoryComponents.available : z2, (i & 1024) != 0 ? categoryComponents.inCart : z3, (i & 2048) != 0 ? categoryComponents.statusText : str5, (i & 4096) != 0 ? categoryComponents.statusColor : num4, (i & 8192) != 0 ? categoryComponents.hidePriceButton : z4, (i & 16384) != 0 ? categoryComponents.scale : f);
    }

    public final Integer component1() {
        return this.id;
    }

    public final boolean component10() {
        return this.available;
    }

    public final boolean component11() {
        return this.inCart;
    }

    public final String component12() {
        return this.statusText;
    }

    public final Integer component13() {
        return this.statusColor;
    }

    public final boolean component14() {
        return this.hidePriceButton;
    }

    public final float component15() {
        return this.scale;
    }

    public final Integer component2() {
        return this.categoryId;
    }

    public final String component3() {
        return this.header;
    }

    public final Integer component4() {
        return this.color;
    }

    public final String component5() {
        return this.name;
    }

    public final String component6() {
        return this.text;
    }

    public final String component7() {
        return this.icon;
    }

    public final long component8() {
        return this.price;
    }

    public final boolean component9() {
        return this.installed;
    }

    public final CategoryComponents copy(Integer num, Integer num2, String header, Integer num3, String name, String text, String icon, long j, boolean z, boolean z2, boolean z3, String statusText, Integer num4, boolean z4, float f) {
        Intrinsics.checkNotNullParameter(header, "header");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(icon, "icon");
        Intrinsics.checkNotNullParameter(statusText, "statusText");
        return new CategoryComponents(num, num2, header, num3, name, text, icon, j, z, z2, z3, statusText, num4, z4, f);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CategoryComponents) {
            CategoryComponents categoryComponents = (CategoryComponents) obj;
            return Intrinsics.areEqual(this.id, categoryComponents.id) && Intrinsics.areEqual(this.categoryId, categoryComponents.categoryId) && Intrinsics.areEqual(this.header, categoryComponents.header) && Intrinsics.areEqual(this.color, categoryComponents.color) && Intrinsics.areEqual(this.name, categoryComponents.name) && Intrinsics.areEqual(this.text, categoryComponents.text) && Intrinsics.areEqual(this.icon, categoryComponents.icon) && this.price == categoryComponents.price && this.installed == categoryComponents.installed && this.available == categoryComponents.available && this.inCart == categoryComponents.inCart && Intrinsics.areEqual(this.statusText, categoryComponents.statusText) && Intrinsics.areEqual(this.statusColor, categoryComponents.statusColor) && this.hidePriceButton == categoryComponents.hidePriceButton && Float.compare(this.scale, categoryComponents.scale) == 0;
        }
        return false;
    }

    public int hashCode() {
        Integer num = this.id;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.categoryId;
        int hashCode2 = (((hashCode + (num2 == null ? 0 : num2.hashCode())) * 31) + this.header.hashCode()) * 31;
        Integer num3 = this.color;
        int hashCode3 = (((((((((((((((((hashCode2 + (num3 == null ? 0 : num3.hashCode())) * 31) + this.name.hashCode()) * 31) + this.text.hashCode()) * 31) + this.icon.hashCode()) * 31) + Long.hashCode(this.price)) * 31) + Boolean.hashCode(this.installed)) * 31) + Boolean.hashCode(this.available)) * 31) + Boolean.hashCode(this.inCart)) * 31) + this.statusText.hashCode()) * 31;
        Integer num4 = this.statusColor;
        return ((((hashCode3 + (num4 != null ? num4.hashCode() : 0)) * 31) + Boolean.hashCode(this.hidePriceButton)) * 31) + Float.hashCode(this.scale);
    }

    public String toString() {
        Integer num = this.id;
        Integer num2 = this.categoryId;
        String str = this.header;
        Integer num3 = this.color;
        String str2 = this.name;
        String str3 = this.text;
        String str4 = this.icon;
        long j = this.price;
        boolean z = this.installed;
        boolean z2 = this.available;
        boolean z3 = this.inCart;
        String str5 = this.statusText;
        Integer num4 = this.statusColor;
        boolean z4 = this.hidePriceButton;
        return "CategoryComponents(id=" + num + ", categoryId=" + num2 + ", header=" + str + ", color=" + num3 + ", name=" + str2 + ", text=" + str3 + ", icon=" + str4 + ", price=" + j + ", installed=" + z + ", available=" + z2 + ", inCart=" + z3 + ", statusText=" + str5 + ", statusColor=" + num4 + ", hidePriceButton=" + z4 + ", scale=" + this.scale + ")";
    }

    public CategoryComponents(Integer num, Integer num2, String header, Integer num3, String name, String text, String icon, long j, boolean z, boolean z2, boolean z3, String statusText, Integer num4, boolean z4, float f) {
        Intrinsics.checkNotNullParameter(header, "header");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(icon, "icon");
        Intrinsics.checkNotNullParameter(statusText, "statusText");
        this.id = num;
        this.categoryId = num2;
        this.header = header;
        this.color = num3;
        this.name = name;
        this.text = text;
        this.icon = icon;
        this.price = j;
        this.installed = z;
        this.available = z2;
        this.inCart = z3;
        this.statusText = statusText;
        this.statusColor = num4;
        this.hidePriceButton = z4;
        this.scale = f;
    }

    public final Integer getId() {
        return this.id;
    }

    public final Integer getCategoryId() {
        return this.categoryId;
    }

    public final String getHeader() {
        return this.header;
    }

    public final Integer getColor() {
        return this.color;
    }

    public final String getName() {
        return this.name;
    }

    public final String getText() {
        return this.text;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final long getPrice() {
        return this.price;
    }

    public final boolean getInstalled() {
        return this.installed;
    }

    public final boolean getAvailable() {
        return this.available;
    }

    public final boolean getInCart() {
        return this.inCart;
    }

    public final String getStatusText() {
        return this.statusText;
    }

    public final Integer getStatusColor() {
        return this.statusColor;
    }

    public final boolean getHidePriceButton() {
        return this.hidePriceButton;
    }

    public final float getScale() {
        return this.scale;
    }
}
