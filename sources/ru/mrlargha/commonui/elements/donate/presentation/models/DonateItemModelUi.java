package ru.mrlargha.commonui.elements.donate.presentation.models;

import com.google.firebase.analytics.FirebaseAnalytics;
import io.appmetrica.analytics.impl.L2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.elements.donate.domain.models.DonateItemModel;
/* compiled from: DonateItemModelUi.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001f\b\u0086\b\u0018\u00002\u00020\u0001Bá\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\r\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0006\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0006\u0012\u0006\u0010\u0013\u001a\u00020\u0003\u0012\u0006\u0010\u0014\u001a\u00020\u0003\u0012\u0006\u0010\u0015\u001a\u00020\u0003\u0012\u0006\u0010\u0016\u001a\u00020\u0003\u0012\u0006\u0010\u0017\u001a\u00020\u0006\u0012\u0006\u0010\u0018\u001a\u00020\u0003\u0012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u000f\u0012\u0006\u0010\u001b\u001a\u00020\r\u0012\u0006\u0010\u001c\u001a\u00020\r\u0012\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00060\u000f\u0012\u0006\u0010\u001e\u001a\u00020\u0003\u0012\u0006\u0010\u001f\u001a\u00020\r¢\u0006\u0004\b \u0010!J\u0006\u0010=\u001a\u00020>J\u0006\u0010?\u001a\u00020@J\u0006\u00105\u001a\u00020AJ\u0012\u0010B\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060CJ\u0006\u0010D\u001a\u00020EJ\t\u0010F\u001a\u00020\u0003HÆ\u0003J\t\u0010G\u001a\u00020\u0003HÆ\u0003J\t\u0010H\u001a\u00020\u0006HÆ\u0003J\t\u0010I\u001a\u00020\u0006HÆ\u0003J\t\u0010J\u001a\u00020\u0003HÆ\u0003J\t\u0010K\u001a\u00020\u0003HÆ\u0003J\t\u0010L\u001a\u00020\u0003HÆ\u0003J\t\u0010M\u001a\u00020\u0003HÆ\u0003J\t\u0010N\u001a\u00020\rHÆ\u0003J\u000f\u0010O\u001a\b\u0012\u0004\u0012\u00020\u00060\u000fHÆ\u0003J\t\u0010P\u001a\u00020\u0006HÆ\u0003J\t\u0010Q\u001a\u00020\u0003HÆ\u0003J\t\u0010R\u001a\u00020\u0006HÆ\u0003J\t\u0010S\u001a\u00020\u0003HÆ\u0003J\t\u0010T\u001a\u00020\u0003HÆ\u0003J\t\u0010U\u001a\u00020\u0003HÆ\u0003J\t\u0010V\u001a\u00020\u0003HÆ\u0003J\t\u0010W\u001a\u00020\u0006HÆ\u0003J\t\u0010X\u001a\u00020\u0003HÆ\u0003J\u000f\u0010Y\u001a\b\u0012\u0004\u0012\u00020\u001a0\u000fHÆ\u0003J\t\u0010Z\u001a\u00020\rHÆ\u0003J\t\u0010[\u001a\u00020\rHÆ\u0003J\u000f\u0010\\\u001a\b\u0012\u0004\u0012\u00020\u00060\u000fHÆ\u0003J\t\u0010]\u001a\u00020\u0003HÆ\u0003J\t\u0010^\u001a\u00020\rHÆ\u0003J\u0095\u0002\u0010_\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\r2\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00062\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00062\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00062\b\b\u0002\u0010\u0018\u001a\u00020\u00032\u000e\b\u0002\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\r2\b\b\u0002\u0010\u001c\u001a\u00020\r2\u000e\b\u0002\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00060\u000f2\b\b\u0002\u0010\u001e\u001a\u00020\u00032\b\b\u0002\u0010\u001f\u001a\u00020\rHÆ\u0001J\u0013\u0010`\u001a\u00020\r2\b\u0010a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010b\u001a\u00020\u0003HÖ\u0001J\t\u0010c\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010#R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b'\u0010&R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010#R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010#R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010#R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b+\u0010#R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010,R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u000f¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0011\u0010\u0010\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b/\u0010&R\u0011\u0010\u0011\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b0\u0010#R\u0011\u0010\u0012\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b1\u0010&R\u0011\u0010\u0013\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b2\u0010#R\u0011\u0010\u0014\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b3\u0010#R\u0011\u0010\u0015\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b4\u0010#R\u0011\u0010\u0016\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b5\u0010#R\u0011\u0010\u0017\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b6\u0010&R\u0011\u0010\u0018\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b7\u0010#R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u000f¢\u0006\b\n\u0000\u001a\u0004\b8\u0010.R\u0011\u0010\u001b\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b9\u0010,R\u0011\u0010\u001c\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b:\u0010,R\u0017\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00060\u000f¢\u0006\b\n\u0000\u001a\u0004\b;\u0010.R\u0011\u0010\u001e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b<\u0010#R\u0011\u0010\u001f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010,¨\u0006d"}, d2 = {"Lru/mrlargha/commonui/elements/donate/presentation/models/DonateItemModelUi;", "", "id", "", "categoryId", "name", "", "desc", FirebaseAnalytics.Param.PRICE, "priceCurrency", "type", "iconButton", "isEnableButton", "", "colorButton", "", "titleButton", "image", "effectColor", L2.g, FirebaseAnalytics.Param.DISCOUNT, "discountPrice", "blockType", "blockTitle", "unixTime", "badges", "Lru/mrlargha/commonui/elements/donate/presentation/models/DonateBadgesModelUi;", "visible", "animation", "textGradientColor", "totalEarnings", "isGif", "<init>", "(IILjava/lang/String;Ljava/lang/String;IIIIZLjava/util/List;Ljava/lang/String;ILjava/lang/String;IIIILjava/lang/String;ILjava/util/List;ZZLjava/util/List;IZ)V", "getId", "()I", "getCategoryId", "getName", "()Ljava/lang/String;", "getDesc", "getPrice", "getPriceCurrency", "getType", "getIconButton", "()Z", "getColorButton", "()Ljava/util/List;", "getTitleButton", "getImage", "getEffectColor", "getBackground", "getDiscount", "getDiscountPrice", "getBlockType", "getBlockTitle", "getUnixTime", "getBadges", "getVisible", "getAnimation", "getTextGradientColor", "getTotalEarnings", "getCurrencyType", "Lru/mrlargha/commonui/elements/donate/presentation/models/DonatePriceCurrencyType;", "getItemType", "Lru/mrlargha/commonui/elements/donate/presentation/models/DonateItemType;", "Lru/mrlargha/commonui/elements/donate/presentation/models/DonateBlockType;", "getButtonTitle", "Lkotlin/Pair;", "toDomain", "Lru/mrlargha/commonui/elements/donate/domain/models/DonateItemModel;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "copy", "equals", "other", "hashCode", "toString", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DonateItemModelUi {
    private final boolean animation;
    private final int background;
    private final List<DonateBadgesModelUi> badges;
    private final String blockTitle;
    private final int blockType;
    private final int categoryId;
    private final List<String> colorButton;
    private final String desc;
    private final int discount;
    private final int discountPrice;
    private final String effectColor;
    private final int iconButton;
    private final int id;
    private final int image;
    private final boolean isEnableButton;
    private final boolean isGif;
    private final String name;
    private final int price;
    private final int priceCurrency;
    private final List<String> textGradientColor;
    private final String titleButton;
    private final int totalEarnings;
    private final int type;
    private final int unixTime;
    private final boolean visible;

    /* compiled from: DonateItemModelUi.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DonatePriceCurrencyType.values().length];
            try {
                iArr[DonatePriceCurrencyType.RUB.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DonatePriceCurrencyType.AZ.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[DonatePriceCurrencyType.DOLLAR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DonateItemModelUi copy$default(DonateItemModelUi donateItemModelUi, int i, int i2, String str, String str2, int i3, int i4, int i5, int i6, boolean z, List list, String str3, int i7, String str4, int i8, int i9, int i10, int i11, String str5, int i12, List list2, boolean z2, boolean z3, List list3, int i13, boolean z4, int i14, Object obj) {
        boolean z5;
        int i15;
        int i16 = (i14 & 1) != 0 ? donateItemModelUi.id : i;
        int i17 = (i14 & 2) != 0 ? donateItemModelUi.categoryId : i2;
        String str6 = (i14 & 4) != 0 ? donateItemModelUi.name : str;
        String str7 = (i14 & 8) != 0 ? donateItemModelUi.desc : str2;
        int i18 = (i14 & 16) != 0 ? donateItemModelUi.price : i3;
        int i19 = (i14 & 32) != 0 ? donateItemModelUi.priceCurrency : i4;
        int i20 = (i14 & 64) != 0 ? donateItemModelUi.type : i5;
        int i21 = (i14 & 128) != 0 ? donateItemModelUi.iconButton : i6;
        boolean z6 = (i14 & 256) != 0 ? donateItemModelUi.isEnableButton : z;
        List<String> list4 = (i14 & 512) != 0 ? donateItemModelUi.colorButton : list;
        String str8 = (i14 & 1024) != 0 ? donateItemModelUi.titleButton : str3;
        int i22 = (i14 & 2048) != 0 ? donateItemModelUi.image : i7;
        String str9 = (i14 & 4096) != 0 ? donateItemModelUi.effectColor : str4;
        int i23 = (i14 & 8192) != 0 ? donateItemModelUi.background : i8;
        int i24 = i16;
        int i25 = (i14 & 16384) != 0 ? donateItemModelUi.discount : i9;
        int i26 = (i14 & 32768) != 0 ? donateItemModelUi.discountPrice : i10;
        int i27 = (i14 & 65536) != 0 ? donateItemModelUi.blockType : i11;
        String str10 = (i14 & 131072) != 0 ? donateItemModelUi.blockTitle : str5;
        int i28 = (i14 & 262144) != 0 ? donateItemModelUi.unixTime : i12;
        List<DonateBadgesModelUi> list5 = (i14 & 524288) != 0 ? donateItemModelUi.badges : list2;
        boolean z7 = (i14 & 1048576) != 0 ? donateItemModelUi.visible : z2;
        boolean z8 = (i14 & 2097152) != 0 ? donateItemModelUi.animation : z3;
        List<String> list6 = (i14 & 4194304) != 0 ? donateItemModelUi.textGradientColor : list3;
        int i29 = (i14 & 8388608) != 0 ? donateItemModelUi.totalEarnings : i13;
        if ((i14 & 16777216) != 0) {
            i15 = i29;
            z5 = donateItemModelUi.isGif;
        } else {
            z5 = z4;
            i15 = i29;
        }
        return donateItemModelUi.copy(i24, i17, str6, str7, i18, i19, i20, i21, z6, list4, str8, i22, str9, i23, i25, i26, i27, str10, i28, list5, z7, z8, list6, i15, z5);
    }

    public final int component1() {
        return this.id;
    }

    public final List<String> component10() {
        return this.colorButton;
    }

    public final String component11() {
        return this.titleButton;
    }

    public final int component12() {
        return this.image;
    }

    public final String component13() {
        return this.effectColor;
    }

    public final int component14() {
        return this.background;
    }

    public final int component15() {
        return this.discount;
    }

    public final int component16() {
        return this.discountPrice;
    }

    public final int component17() {
        return this.blockType;
    }

    public final String component18() {
        return this.blockTitle;
    }

    public final int component19() {
        return this.unixTime;
    }

    public final int component2() {
        return this.categoryId;
    }

    public final List<DonateBadgesModelUi> component20() {
        return this.badges;
    }

    public final boolean component21() {
        return this.visible;
    }

    public final boolean component22() {
        return this.animation;
    }

    public final List<String> component23() {
        return this.textGradientColor;
    }

    public final int component24() {
        return this.totalEarnings;
    }

    public final boolean component25() {
        return this.isGif;
    }

    public final String component3() {
        return this.name;
    }

    public final String component4() {
        return this.desc;
    }

    public final int component5() {
        return this.price;
    }

    public final int component6() {
        return this.priceCurrency;
    }

    public final int component7() {
        return this.type;
    }

    public final int component8() {
        return this.iconButton;
    }

    public final boolean component9() {
        return this.isEnableButton;
    }

    public final DonateItemModelUi copy(int i, int i2, String name, String desc, int i3, int i4, int i5, int i6, boolean z, List<String> colorButton, String titleButton, int i7, String effectColor, int i8, int i9, int i10, int i11, String blockTitle, int i12, List<DonateBadgesModelUi> badges, boolean z2, boolean z3, List<String> textGradientColor, int i13, boolean z4) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(desc, "desc");
        Intrinsics.checkNotNullParameter(colorButton, "colorButton");
        Intrinsics.checkNotNullParameter(titleButton, "titleButton");
        Intrinsics.checkNotNullParameter(effectColor, "effectColor");
        Intrinsics.checkNotNullParameter(blockTitle, "blockTitle");
        Intrinsics.checkNotNullParameter(badges, "badges");
        Intrinsics.checkNotNullParameter(textGradientColor, "textGradientColor");
        return new DonateItemModelUi(i, i2, name, desc, i3, i4, i5, i6, z, colorButton, titleButton, i7, effectColor, i8, i9, i10, i11, blockTitle, i12, badges, z2, z3, textGradientColor, i13, z4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DonateItemModelUi) {
            DonateItemModelUi donateItemModelUi = (DonateItemModelUi) obj;
            return this.id == donateItemModelUi.id && this.categoryId == donateItemModelUi.categoryId && Intrinsics.areEqual(this.name, donateItemModelUi.name) && Intrinsics.areEqual(this.desc, donateItemModelUi.desc) && this.price == donateItemModelUi.price && this.priceCurrency == donateItemModelUi.priceCurrency && this.type == donateItemModelUi.type && this.iconButton == donateItemModelUi.iconButton && this.isEnableButton == donateItemModelUi.isEnableButton && Intrinsics.areEqual(this.colorButton, donateItemModelUi.colorButton) && Intrinsics.areEqual(this.titleButton, donateItemModelUi.titleButton) && this.image == donateItemModelUi.image && Intrinsics.areEqual(this.effectColor, donateItemModelUi.effectColor) && this.background == donateItemModelUi.background && this.discount == donateItemModelUi.discount && this.discountPrice == donateItemModelUi.discountPrice && this.blockType == donateItemModelUi.blockType && Intrinsics.areEqual(this.blockTitle, donateItemModelUi.blockTitle) && this.unixTime == donateItemModelUi.unixTime && Intrinsics.areEqual(this.badges, donateItemModelUi.badges) && this.visible == donateItemModelUi.visible && this.animation == donateItemModelUi.animation && Intrinsics.areEqual(this.textGradientColor, donateItemModelUi.textGradientColor) && this.totalEarnings == donateItemModelUi.totalEarnings && this.isGif == donateItemModelUi.isGif;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((((((((((((((((((Integer.hashCode(this.id) * 31) + Integer.hashCode(this.categoryId)) * 31) + this.name.hashCode()) * 31) + this.desc.hashCode()) * 31) + Integer.hashCode(this.price)) * 31) + Integer.hashCode(this.priceCurrency)) * 31) + Integer.hashCode(this.type)) * 31) + Integer.hashCode(this.iconButton)) * 31) + Boolean.hashCode(this.isEnableButton)) * 31) + this.colorButton.hashCode()) * 31) + this.titleButton.hashCode()) * 31) + Integer.hashCode(this.image)) * 31) + this.effectColor.hashCode()) * 31) + Integer.hashCode(this.background)) * 31) + Integer.hashCode(this.discount)) * 31) + Integer.hashCode(this.discountPrice)) * 31) + Integer.hashCode(this.blockType)) * 31) + this.blockTitle.hashCode()) * 31) + Integer.hashCode(this.unixTime)) * 31) + this.badges.hashCode()) * 31) + Boolean.hashCode(this.visible)) * 31) + Boolean.hashCode(this.animation)) * 31) + this.textGradientColor.hashCode()) * 31) + Integer.hashCode(this.totalEarnings)) * 31) + Boolean.hashCode(this.isGif);
    }

    public String toString() {
        int i = this.id;
        int i2 = this.categoryId;
        String str = this.name;
        String str2 = this.desc;
        int i3 = this.price;
        int i4 = this.priceCurrency;
        int i5 = this.type;
        int i6 = this.iconButton;
        boolean z = this.isEnableButton;
        List<String> list = this.colorButton;
        String str3 = this.titleButton;
        int i7 = this.image;
        String str4 = this.effectColor;
        int i8 = this.background;
        int i9 = this.discount;
        int i10 = this.discountPrice;
        int i11 = this.blockType;
        String str5 = this.blockTitle;
        int i12 = this.unixTime;
        List<DonateBadgesModelUi> list2 = this.badges;
        boolean z2 = this.visible;
        boolean z3 = this.animation;
        List<String> list3 = this.textGradientColor;
        int i13 = this.totalEarnings;
        return "DonateItemModelUi(id=" + i + ", categoryId=" + i2 + ", name=" + str + ", desc=" + str2 + ", price=" + i3 + ", priceCurrency=" + i4 + ", type=" + i5 + ", iconButton=" + i6 + ", isEnableButton=" + z + ", colorButton=" + list + ", titleButton=" + str3 + ", image=" + i7 + ", effectColor=" + str4 + ", background=" + i8 + ", discount=" + i9 + ", discountPrice=" + i10 + ", blockType=" + i11 + ", blockTitle=" + str5 + ", unixTime=" + i12 + ", badges=" + list2 + ", visible=" + z2 + ", animation=" + z3 + ", textGradientColor=" + list3 + ", totalEarnings=" + i13 + ", isGif=" + this.isGif + ")";
    }

    public DonateItemModelUi(int i, int i2, String name, String desc, int i3, int i4, int i5, int i6, boolean z, List<String> colorButton, String titleButton, int i7, String effectColor, int i8, int i9, int i10, int i11, String blockTitle, int i12, List<DonateBadgesModelUi> badges, boolean z2, boolean z3, List<String> textGradientColor, int i13, boolean z4) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(desc, "desc");
        Intrinsics.checkNotNullParameter(colorButton, "colorButton");
        Intrinsics.checkNotNullParameter(titleButton, "titleButton");
        Intrinsics.checkNotNullParameter(effectColor, "effectColor");
        Intrinsics.checkNotNullParameter(blockTitle, "blockTitle");
        Intrinsics.checkNotNullParameter(badges, "badges");
        Intrinsics.checkNotNullParameter(textGradientColor, "textGradientColor");
        this.id = i;
        this.categoryId = i2;
        this.name = name;
        this.desc = desc;
        this.price = i3;
        this.priceCurrency = i4;
        this.type = i5;
        this.iconButton = i6;
        this.isEnableButton = z;
        this.colorButton = colorButton;
        this.titleButton = titleButton;
        this.image = i7;
        this.effectColor = effectColor;
        this.background = i8;
        this.discount = i9;
        this.discountPrice = i10;
        this.blockType = i11;
        this.blockTitle = blockTitle;
        this.unixTime = i12;
        this.badges = badges;
        this.visible = z2;
        this.animation = z3;
        this.textGradientColor = textGradientColor;
        this.totalEarnings = i13;
        this.isGif = z4;
    }

    public final int getId() {
        return this.id;
    }

    public final int getCategoryId() {
        return this.categoryId;
    }

    public final String getName() {
        return this.name;
    }

    public final String getDesc() {
        return this.desc;
    }

    public final int getPrice() {
        return this.price;
    }

    public final int getPriceCurrency() {
        return this.priceCurrency;
    }

    public final int getType() {
        return this.type;
    }

    public final int getIconButton() {
        return this.iconButton;
    }

    public final boolean isEnableButton() {
        return this.isEnableButton;
    }

    public final List<String> getColorButton() {
        return this.colorButton;
    }

    public final String getTitleButton() {
        return this.titleButton;
    }

    public final int getImage() {
        return this.image;
    }

    public final String getEffectColor() {
        return this.effectColor;
    }

    public final int getBackground() {
        return this.background;
    }

    public final int getDiscount() {
        return this.discount;
    }

    public final int getDiscountPrice() {
        return this.discountPrice;
    }

    public final int getBlockType() {
        return this.blockType;
    }

    public final String getBlockTitle() {
        return this.blockTitle;
    }

    public final int getUnixTime() {
        return this.unixTime;
    }

    public final List<DonateBadgesModelUi> getBadges() {
        return this.badges;
    }

    public final boolean getVisible() {
        return this.visible;
    }

    public final boolean getAnimation() {
        return this.animation;
    }

    public final List<String> getTextGradientColor() {
        return this.textGradientColor;
    }

    public final int getTotalEarnings() {
        return this.totalEarnings;
    }

    public final boolean isGif() {
        return this.isGif;
    }

    public final DonatePriceCurrencyType getCurrencyType() {
        Object obj;
        Iterator<E> it = DonatePriceCurrencyType.getEntries().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((DonatePriceCurrencyType) obj).getType() == this.priceCurrency) {
                break;
            }
        }
        DonatePriceCurrencyType donatePriceCurrencyType = (DonatePriceCurrencyType) obj;
        return donatePriceCurrencyType == null ? DonatePriceCurrencyType.AZ : donatePriceCurrencyType;
    }

    public final DonateItemType getItemType() {
        Object obj;
        Iterator<E> it = DonateItemType.getEntries().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((DonateItemType) obj).getType() == this.type) {
                break;
            }
        }
        DonateItemType donateItemType = (DonateItemType) obj;
        return donateItemType == null ? DonateItemType.DEFAULT : donateItemType;
    }

    /* renamed from: getBlockType  reason: collision with other method in class */
    public final DonateBlockType m10603getBlockType() {
        Object obj;
        Iterator<E> it = DonateBlockType.getEntries().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((DonateBlockType) obj).getType() == this.blockType) {
                break;
            }
        }
        DonateBlockType donateBlockType = (DonateBlockType) obj;
        return donateBlockType == null ? DonateBlockType.NONE : donateBlockType;
    }

    public final Pair<String, String> getButtonTitle() {
        String str;
        String str2;
        str = "";
        if (this.titleButton.length() == 0) {
            int i = WhenMappings.$EnumSwitchMapping$0[getCurrencyType().ordinal()];
            String str3 = " РУБ";
            if (i != 1) {
                if (i == 2) {
                    str3 = " AZ";
                } else if (i != 3) {
                    throw new NoWhenBranchMatchedException();
                }
            }
            str = this.discount > 0 ? String.valueOf(this.price) : "";
            int i2 = this.discountPrice;
            if (i2 <= 0) {
                i2 = this.price;
            }
            str2 = String.valueOf(i2) + str3;
        } else {
            str2 = this.titleButton;
        }
        return TuplesKt.to(str, str2);
    }

    public final DonateItemModel toDomain() {
        int i = this.id;
        String str = this.name;
        String str2 = this.desc;
        int i2 = this.categoryId;
        int i3 = this.price;
        int i4 = this.priceCurrency;
        int i5 = this.type;
        int i6 = this.iconButton;
        boolean z = this.isEnableButton;
        List<String> list = this.colorButton;
        String str3 = this.titleButton;
        int i7 = this.image;
        String str4 = this.effectColor;
        int i8 = this.background;
        int i9 = this.discount;
        int i10 = this.discountPrice;
        int i11 = this.blockType;
        String str5 = this.blockTitle;
        int i12 = this.unixTime;
        List<DonateBadgesModelUi> list2 = this.badges;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (DonateBadgesModelUi donateBadgesModelUi : list2) {
            arrayList.add(donateBadgesModelUi.toDomain());
        }
        return new DonateItemModel(i, 0, str, str2, i3, i4, i2, i5, i6, z ? 1 : 0, list, str3, i7, str4, i9, i8, i10, arrayList, i11, str5, i12, this.visible ? 1 : 0, this.animation ? 1 : 0, this.textGradientColor, this.totalEarnings, this.isGif ? 0 : -1, 2, null);
    }
}
