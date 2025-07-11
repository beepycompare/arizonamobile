package ru.mrlargha.commonui.elements.donate.domain.models;

import androidx.compose.ui.spatial.RectListKt;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: DonateItemModel.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\bB\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u009f\u0002\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00060\u000f\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0003¢\u0006\u0004\b \u0010!J\t\u0010>\u001a\u00020\u0003HÆ\u0003J\t\u0010?\u001a\u00020\u0003HÆ\u0003J\t\u0010@\u001a\u00020\u0006HÆ\u0003J\t\u0010A\u001a\u00020\u0006HÆ\u0003J\t\u0010B\u001a\u00020\u0003HÆ\u0003J\t\u0010C\u001a\u00020\u0003HÆ\u0003J\t\u0010D\u001a\u00020\u0003HÆ\u0003J\t\u0010E\u001a\u00020\u0003HÆ\u0003J\t\u0010F\u001a\u00020\u0003HÆ\u0003J\t\u0010G\u001a\u00020\u0003HÆ\u0003J\u000f\u0010H\u001a\b\u0012\u0004\u0012\u00020\u00060\u000fHÆ\u0003J\t\u0010I\u001a\u00020\u0006HÆ\u0003J\t\u0010J\u001a\u00020\u0003HÆ\u0003J\t\u0010K\u001a\u00020\u0006HÆ\u0003J\t\u0010L\u001a\u00020\u0003HÆ\u0003J\t\u0010M\u001a\u00020\u0003HÆ\u0003J\t\u0010N\u001a\u00020\u0003HÆ\u0003J\u0011\u0010O\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u000fHÆ\u0003J\t\u0010P\u001a\u00020\u0003HÆ\u0003J\t\u0010Q\u001a\u00020\u0006HÆ\u0003J\t\u0010R\u001a\u00020\u0003HÆ\u0003J\t\u0010S\u001a\u00020\u0003HÆ\u0003J\t\u0010T\u001a\u00020\u0003HÆ\u0003J\u000f\u0010U\u001a\b\u0012\u0004\u0012\u00020\u00060\u000fHÆ\u0003J\t\u0010V\u001a\u00020\u0003HÆ\u0003J\t\u0010W\u001a\u00020\u0003HÆ\u0003J¡\u0002\u0010X\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00062\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00062\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00032\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u000f2\b\b\u0002\u0010\u0018\u001a\u00020\u00032\b\b\u0002\u0010\u0019\u001a\u00020\u00062\b\b\u0002\u0010\u001a\u001a\u00020\u00032\b\b\u0002\u0010\u001b\u001a\u00020\u00032\b\b\u0002\u0010\u001c\u001a\u00020\u00032\u000e\b\u0002\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00060\u000f2\b\b\u0002\u0010\u001e\u001a\u00020\u00032\b\b\u0002\u0010\u001f\u001a\u00020\u0003HÆ\u0001J\u0013\u0010Y\u001a\u00020Z2\b\u0010[\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\\\u001a\u00020\u0003HÖ\u0001J\t\u0010]\u001a\u00020\u0006HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010#R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0016\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010&R\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010#R\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010#R\u0016\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010#R\u0016\u0010\u000b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010#R\u0016\u0010\f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010#R\u0016\u0010\r\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010#R\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0016\u0010\u0010\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u0010&R\u0016\u0010\u0011\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u0010#R\u0016\u0010\u0012\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u0010&R\u0016\u0010\u0013\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u0010#R\u0016\u0010\u0014\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u0010#R\u0016\u0010\u0015\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u0010#R\u001e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b5\u0010.R\u0016\u0010\u0018\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u0010#R\u0016\u0010\u0019\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b7\u0010&R\u0016\u0010\u001a\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u0010#R\u0016\u0010\u001b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b9\u0010#R\u0016\u0010\u001c\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b:\u0010#R\u001c\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00060\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b;\u0010.R\u0016\u0010\u001e\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b<\u0010#R\u0016\u0010\u001f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b=\u0010#¨\u0006^"}, d2 = {"Lru/mrlargha/commonui/elements/donate/domain/models/DonateItemModel;", "", "key", "", "position", "name", "", "description", FirebaseAnalytics.Param.PRICE, "priceCurrency", "category", "typeTemplate", "iconButton", "isEnable", "colorListButton", "", "titleButton", "image", "imageEffect", FirebaseAnalytics.Param.DISCOUNT, "backgroundId", "discountPrice", "badges", "Lru/mrlargha/commonui/elements/donate/domain/models/DonateBadgesModel;", "blockedType", "blockedReason", "leftUnixTime", "visible", "animation", "textGradientColor", "totalEarnings", "gifId", "<init>", "(IILjava/lang/String;Ljava/lang/String;IIIIIILjava/util/List;Ljava/lang/String;ILjava/lang/String;IIILjava/util/List;ILjava/lang/String;IIILjava/util/List;II)V", "getKey", "()I", "getPosition", "getName", "()Ljava/lang/String;", "getDescription", "getPrice", "getPriceCurrency", "getCategory", "getTypeTemplate", "getIconButton", "getColorListButton", "()Ljava/util/List;", "getTitleButton", "getImage", "getImageEffect", "getDiscount", "getBackgroundId", "getDiscountPrice", "getBadges", "getBlockedType", "getBlockedReason", "getLeftUnixTime", "getVisible", "getAnimation", "getTextGradientColor", "getTotalEarnings", "getGifId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "copy", "equals", "", "other", "hashCode", "toString", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DonateItemModel {
    @SerializedName("animation")
    private final int animation;
    @SerializedName("backgroundId")
    private final int backgroundId;
    @SerializedName("badges")
    private final List<DonateBadgesModel> badges;
    @SerializedName("blockedReason")
    private final String blockedReason;
    @SerializedName("blockedType")
    private final int blockedType;
    @SerializedName("category")
    private final int category;
    @SerializedName("colorButton")
    private final List<String> colorListButton;
    @SerializedName("desc")
    private final String description;
    @SerializedName(FirebaseAnalytics.Param.DISCOUNT)
    private final int discount;
    @SerializedName("discountPrice")
    private final int discountPrice;
    @SerializedName("gifId")
    private final int gifId;
    @SerializedName("iconButton")
    private final int iconButton;
    @SerializedName("imageId")
    private final int image;
    @SerializedName("imageEffectId")
    private final String imageEffect;
    @SerializedName("iSdisabledButton")
    private final int isEnable;
    @SerializedName("key")
    private final int key;
    @SerializedName("endUnixTime")
    private final int leftUnixTime;
    @SerializedName("name")
    private final String name;
    @SerializedName("position")
    private final int position;
    @SerializedName(FirebaseAnalytics.Param.PRICE)
    private final int price;
    @SerializedName("priceCurrency")
    private final int priceCurrency;
    @SerializedName("textGradientColor")
    private final List<String> textGradientColor;
    @SerializedName("nameButton")
    private final String titleButton;
    @SerializedName("totalEarnings")
    private final int totalEarnings;
    @SerializedName("typeTemplate")
    private final int typeTemplate;
    @SerializedName("visible")
    private final int visible;

    public DonateItemModel() {
        this(0, 0, null, null, 0, 0, 0, 0, 0, 0, null, null, 0, null, 0, 0, 0, null, 0, null, 0, 0, 0, null, 0, 0, RectListKt.Lower26Bits, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DonateItemModel copy$default(DonateItemModel donateItemModel, int i, int i2, String str, String str2, int i3, int i4, int i5, int i6, int i7, int i8, List list, String str3, int i9, String str4, int i10, int i11, int i12, List list2, int i13, String str5, int i14, int i15, int i16, List list3, int i17, int i18, int i19, Object obj) {
        int i20;
        int i21;
        int i22 = (i19 & 1) != 0 ? donateItemModel.key : i;
        int i23 = (i19 & 2) != 0 ? donateItemModel.position : i2;
        String str6 = (i19 & 4) != 0 ? donateItemModel.name : str;
        String str7 = (i19 & 8) != 0 ? donateItemModel.description : str2;
        int i24 = (i19 & 16) != 0 ? donateItemModel.price : i3;
        int i25 = (i19 & 32) != 0 ? donateItemModel.priceCurrency : i4;
        int i26 = (i19 & 64) != 0 ? donateItemModel.category : i5;
        int i27 = (i19 & 128) != 0 ? donateItemModel.typeTemplate : i6;
        int i28 = (i19 & 256) != 0 ? donateItemModel.iconButton : i7;
        int i29 = (i19 & 512) != 0 ? donateItemModel.isEnable : i8;
        List<String> list4 = (i19 & 1024) != 0 ? donateItemModel.colorListButton : list;
        String str8 = (i19 & 2048) != 0 ? donateItemModel.titleButton : str3;
        int i30 = (i19 & 4096) != 0 ? donateItemModel.image : i9;
        String str9 = (i19 & 8192) != 0 ? donateItemModel.imageEffect : str4;
        int i31 = i22;
        int i32 = (i19 & 16384) != 0 ? donateItemModel.discount : i10;
        int i33 = (i19 & 32768) != 0 ? donateItemModel.backgroundId : i11;
        int i34 = (i19 & 65536) != 0 ? donateItemModel.discountPrice : i12;
        List<DonateBadgesModel> list5 = (i19 & 131072) != 0 ? donateItemModel.badges : list2;
        int i35 = (i19 & 262144) != 0 ? donateItemModel.blockedType : i13;
        String str10 = (i19 & 524288) != 0 ? donateItemModel.blockedReason : str5;
        int i36 = (i19 & 1048576) != 0 ? donateItemModel.leftUnixTime : i14;
        int i37 = (i19 & 2097152) != 0 ? donateItemModel.visible : i15;
        int i38 = (i19 & 4194304) != 0 ? donateItemModel.animation : i16;
        List<String> list6 = (i19 & 8388608) != 0 ? donateItemModel.textGradientColor : list3;
        int i39 = (i19 & 16777216) != 0 ? donateItemModel.totalEarnings : i17;
        if ((i19 & 33554432) != 0) {
            i21 = i39;
            i20 = donateItemModel.gifId;
        } else {
            i20 = i18;
            i21 = i39;
        }
        return donateItemModel.copy(i31, i23, str6, str7, i24, i25, i26, i27, i28, i29, list4, str8, i30, str9, i32, i33, i34, list5, i35, str10, i36, i37, i38, list6, i21, i20);
    }

    public final int component1() {
        return this.key;
    }

    public final int component10() {
        return this.isEnable;
    }

    public final List<String> component11() {
        return this.colorListButton;
    }

    public final String component12() {
        return this.titleButton;
    }

    public final int component13() {
        return this.image;
    }

    public final String component14() {
        return this.imageEffect;
    }

    public final int component15() {
        return this.discount;
    }

    public final int component16() {
        return this.backgroundId;
    }

    public final int component17() {
        return this.discountPrice;
    }

    public final List<DonateBadgesModel> component18() {
        return this.badges;
    }

    public final int component19() {
        return this.blockedType;
    }

    public final int component2() {
        return this.position;
    }

    public final String component20() {
        return this.blockedReason;
    }

    public final int component21() {
        return this.leftUnixTime;
    }

    public final int component22() {
        return this.visible;
    }

    public final int component23() {
        return this.animation;
    }

    public final List<String> component24() {
        return this.textGradientColor;
    }

    public final int component25() {
        return this.totalEarnings;
    }

    public final int component26() {
        return this.gifId;
    }

    public final String component3() {
        return this.name;
    }

    public final String component4() {
        return this.description;
    }

    public final int component5() {
        return this.price;
    }

    public final int component6() {
        return this.priceCurrency;
    }

    public final int component7() {
        return this.category;
    }

    public final int component8() {
        return this.typeTemplate;
    }

    public final int component9() {
        return this.iconButton;
    }

    public final DonateItemModel copy(int i, int i2, String name, String description, int i3, int i4, int i5, int i6, int i7, int i8, List<String> colorListButton, String titleButton, int i9, String imageEffect, int i10, int i11, int i12, List<DonateBadgesModel> list, int i13, String blockedReason, int i14, int i15, int i16, List<String> textGradientColor, int i17, int i18) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(colorListButton, "colorListButton");
        Intrinsics.checkNotNullParameter(titleButton, "titleButton");
        Intrinsics.checkNotNullParameter(imageEffect, "imageEffect");
        Intrinsics.checkNotNullParameter(blockedReason, "blockedReason");
        Intrinsics.checkNotNullParameter(textGradientColor, "textGradientColor");
        return new DonateItemModel(i, i2, name, description, i3, i4, i5, i6, i7, i8, colorListButton, titleButton, i9, imageEffect, i10, i11, i12, list, i13, blockedReason, i14, i15, i16, textGradientColor, i17, i18);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DonateItemModel) {
            DonateItemModel donateItemModel = (DonateItemModel) obj;
            return this.key == donateItemModel.key && this.position == donateItemModel.position && Intrinsics.areEqual(this.name, donateItemModel.name) && Intrinsics.areEqual(this.description, donateItemModel.description) && this.price == donateItemModel.price && this.priceCurrency == donateItemModel.priceCurrency && this.category == donateItemModel.category && this.typeTemplate == donateItemModel.typeTemplate && this.iconButton == donateItemModel.iconButton && this.isEnable == donateItemModel.isEnable && Intrinsics.areEqual(this.colorListButton, donateItemModel.colorListButton) && Intrinsics.areEqual(this.titleButton, donateItemModel.titleButton) && this.image == donateItemModel.image && Intrinsics.areEqual(this.imageEffect, donateItemModel.imageEffect) && this.discount == donateItemModel.discount && this.backgroundId == donateItemModel.backgroundId && this.discountPrice == donateItemModel.discountPrice && Intrinsics.areEqual(this.badges, donateItemModel.badges) && this.blockedType == donateItemModel.blockedType && Intrinsics.areEqual(this.blockedReason, donateItemModel.blockedReason) && this.leftUnixTime == donateItemModel.leftUnixTime && this.visible == donateItemModel.visible && this.animation == donateItemModel.animation && Intrinsics.areEqual(this.textGradientColor, donateItemModel.textGradientColor) && this.totalEarnings == donateItemModel.totalEarnings && this.gifId == donateItemModel.gifId;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((((((((((((((((((((((((((((((((Integer.hashCode(this.key) * 31) + Integer.hashCode(this.position)) * 31) + this.name.hashCode()) * 31) + this.description.hashCode()) * 31) + Integer.hashCode(this.price)) * 31) + Integer.hashCode(this.priceCurrency)) * 31) + Integer.hashCode(this.category)) * 31) + Integer.hashCode(this.typeTemplate)) * 31) + Integer.hashCode(this.iconButton)) * 31) + Integer.hashCode(this.isEnable)) * 31) + this.colorListButton.hashCode()) * 31) + this.titleButton.hashCode()) * 31) + Integer.hashCode(this.image)) * 31) + this.imageEffect.hashCode()) * 31) + Integer.hashCode(this.discount)) * 31) + Integer.hashCode(this.backgroundId)) * 31) + Integer.hashCode(this.discountPrice)) * 31;
        List<DonateBadgesModel> list = this.badges;
        return ((((((((((((((((hashCode + (list == null ? 0 : list.hashCode())) * 31) + Integer.hashCode(this.blockedType)) * 31) + this.blockedReason.hashCode()) * 31) + Integer.hashCode(this.leftUnixTime)) * 31) + Integer.hashCode(this.visible)) * 31) + Integer.hashCode(this.animation)) * 31) + this.textGradientColor.hashCode()) * 31) + Integer.hashCode(this.totalEarnings)) * 31) + Integer.hashCode(this.gifId);
    }

    public String toString() {
        int i = this.key;
        int i2 = this.position;
        String str = this.name;
        String str2 = this.description;
        int i3 = this.price;
        int i4 = this.priceCurrency;
        int i5 = this.category;
        int i6 = this.typeTemplate;
        int i7 = this.iconButton;
        int i8 = this.isEnable;
        List<String> list = this.colorListButton;
        String str3 = this.titleButton;
        int i9 = this.image;
        String str4 = this.imageEffect;
        int i10 = this.discount;
        int i11 = this.backgroundId;
        int i12 = this.discountPrice;
        List<DonateBadgesModel> list2 = this.badges;
        int i13 = this.blockedType;
        String str5 = this.blockedReason;
        int i14 = this.leftUnixTime;
        int i15 = this.visible;
        int i16 = this.animation;
        List<String> list3 = this.textGradientColor;
        int i17 = this.totalEarnings;
        return "DonateItemModel(key=" + i + ", position=" + i2 + ", name=" + str + ", description=" + str2 + ", price=" + i3 + ", priceCurrency=" + i4 + ", category=" + i5 + ", typeTemplate=" + i6 + ", iconButton=" + i7 + ", isEnable=" + i8 + ", colorListButton=" + list + ", titleButton=" + str3 + ", image=" + i9 + ", imageEffect=" + str4 + ", discount=" + i10 + ", backgroundId=" + i11 + ", discountPrice=" + i12 + ", badges=" + list2 + ", blockedType=" + i13 + ", blockedReason=" + str5 + ", leftUnixTime=" + i14 + ", visible=" + i15 + ", animation=" + i16 + ", textGradientColor=" + list3 + ", totalEarnings=" + i17 + ", gifId=" + this.gifId + ")";
    }

    public DonateItemModel(int i, int i2, String name, String description, int i3, int i4, int i5, int i6, int i7, int i8, List<String> colorListButton, String titleButton, int i9, String imageEffect, int i10, int i11, int i12, List<DonateBadgesModel> list, int i13, String blockedReason, int i14, int i15, int i16, List<String> textGradientColor, int i17, int i18) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(colorListButton, "colorListButton");
        Intrinsics.checkNotNullParameter(titleButton, "titleButton");
        Intrinsics.checkNotNullParameter(imageEffect, "imageEffect");
        Intrinsics.checkNotNullParameter(blockedReason, "blockedReason");
        Intrinsics.checkNotNullParameter(textGradientColor, "textGradientColor");
        this.key = i;
        this.position = i2;
        this.name = name;
        this.description = description;
        this.price = i3;
        this.priceCurrency = i4;
        this.category = i5;
        this.typeTemplate = i6;
        this.iconButton = i7;
        this.isEnable = i8;
        this.colorListButton = colorListButton;
        this.titleButton = titleButton;
        this.image = i9;
        this.imageEffect = imageEffect;
        this.discount = i10;
        this.backgroundId = i11;
        this.discountPrice = i12;
        this.badges = list;
        this.blockedType = i13;
        this.blockedReason = blockedReason;
        this.leftUnixTime = i14;
        this.visible = i15;
        this.animation = i16;
        this.textGradientColor = textGradientColor;
        this.totalEarnings = i17;
        this.gifId = i18;
    }

    public /* synthetic */ DonateItemModel(int i, int i2, String str, String str2, int i3, int i4, int i5, int i6, int i7, int i8, List list, String str3, int i9, String str4, int i10, int i11, int i12, List list2, int i13, String str5, int i14, int i15, int i16, List list3, int i17, int i18, int i19, DefaultConstructorMarker defaultConstructorMarker) {
        this((i19 & 1) != 0 ? 0 : i, (i19 & 2) != 0 ? -1 : i2, (i19 & 4) != 0 ? "" : str, (i19 & 8) != 0 ? "" : str2, (i19 & 16) != 0 ? -1 : i3, (i19 & 32) != 0 ? -1 : i4, (i19 & 64) != 0 ? 0 : i5, (i19 & 128) != 0 ? -1 : i6, (i19 & 256) != 0 ? -1 : i7, (i19 & 512) != 0 ? -1 : i8, (i19 & 1024) != 0 ? CollectionsKt.emptyList() : list, (i19 & 2048) != 0 ? "" : str3, (i19 & 4096) != 0 ? -1 : i9, (i19 & 8192) != 0 ? "" : str4, (i19 & 16384) != 0 ? 0 : i10, (i19 & 32768) != 0 ? -1 : i11, (i19 & 65536) != 0 ? 0 : i12, (i19 & 131072) != 0 ? CollectionsKt.emptyList() : list2, (i19 & 262144) != 0 ? -1 : i13, (i19 & 524288) == 0 ? str5 : "", (i19 & 1048576) != 0 ? -1 : i14, (i19 & 2097152) != 0 ? -1 : i15, (i19 & 4194304) != 0 ? -1 : i16, (i19 & 8388608) != 0 ? CollectionsKt.emptyList() : list3, (i19 & 16777216) != 0 ? -1 : i17, (i19 & 33554432) != 0 ? -1 : i18);
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

    public final String getDescription() {
        return this.description;
    }

    public final int getPrice() {
        return this.price;
    }

    public final int getPriceCurrency() {
        return this.priceCurrency;
    }

    public final int getCategory() {
        return this.category;
    }

    public final int getTypeTemplate() {
        return this.typeTemplate;
    }

    public final int getIconButton() {
        return this.iconButton;
    }

    public final int isEnable() {
        return this.isEnable;
    }

    public final List<String> getColorListButton() {
        return this.colorListButton;
    }

    public final String getTitleButton() {
        return this.titleButton;
    }

    public final int getImage() {
        return this.image;
    }

    public final String getImageEffect() {
        return this.imageEffect;
    }

    public final int getDiscount() {
        return this.discount;
    }

    public final int getBackgroundId() {
        return this.backgroundId;
    }

    public final int getDiscountPrice() {
        return this.discountPrice;
    }

    public final List<DonateBadgesModel> getBadges() {
        return this.badges;
    }

    public final int getBlockedType() {
        return this.blockedType;
    }

    public final String getBlockedReason() {
        return this.blockedReason;
    }

    public final int getLeftUnixTime() {
        return this.leftUnixTime;
    }

    public final int getVisible() {
        return this.visible;
    }

    public final int getAnimation() {
        return this.animation;
    }

    public final List<String> getTextGradientColor() {
        return this.textGradientColor;
    }

    public final int getTotalEarnings() {
        return this.totalEarnings;
    }

    public final int getGifId() {
        return this.gifId;
    }
}
