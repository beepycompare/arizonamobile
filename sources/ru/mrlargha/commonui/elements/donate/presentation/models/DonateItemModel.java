package ru.mrlargha.commonui.elements.donate.presentation.models;

import com.google.firebase.analytics.FirebaseAnalytics;
import io.appmetrica.analytics.impl.L2;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: DonateItemModel.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\b\u0086\b\u0018\u00002\u00020\u0001B\u009b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\r\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\u0006\u0010\u0010\u001a\u00020\u0005\u0012\u0006\u0010\u0011\u001a\u00020\u0005\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0003\u0012\u0006\u0010\u0014\u001a\u00020\u0005\u0012\u0006\u0010\u0015\u001a\u00020\u0003\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\r¢\u0006\u0004\b\u0018\u0010\u0019J\u0006\u0010.\u001a\u00020/J\u0006\u00100\u001a\u000201J\u0006\u0010*\u001a\u000202J\t\u00103\u001a\u00020\u0003HÆ\u0003J\t\u00104\u001a\u00020\u0005HÆ\u0003J\t\u00105\u001a\u00020\u0003HÆ\u0003J\t\u00106\u001a\u00020\u0003HÆ\u0003J\t\u00107\u001a\u00020\u0003HÆ\u0003J\t\u00108\u001a\u00020\u0003HÆ\u0003J\t\u00109\u001a\u00020\u000bHÆ\u0003J\u000f\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00050\rHÆ\u0003J\t\u0010;\u001a\u00020\u0005HÆ\u0003J\t\u0010<\u001a\u00020\u0005HÆ\u0003J\t\u0010=\u001a\u00020\u0005HÆ\u0003J\t\u0010>\u001a\u00020\u0005HÆ\u0003J\t\u0010?\u001a\u00020\u0003HÆ\u0003J\t\u0010@\u001a\u00020\u0003HÆ\u0003J\t\u0010A\u001a\u00020\u0005HÆ\u0003J\t\u0010B\u001a\u00020\u0003HÆ\u0003J\u000f\u0010C\u001a\b\u0012\u0004\u0012\u00020\u00170\rHÆ\u0003J¿\u0001\u0010D\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\r2\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u00052\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00052\b\b\u0002\u0010\u0015\u001a\u00020\u00032\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\rHÆ\u0001J\u0013\u0010E\u001a\u00020\u000b2\b\u0010F\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010G\u001a\u00020\u0003HÖ\u0001J\t\u0010H\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001bR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001bR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001bR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\"R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\r¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\u000e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001dR\u0011\u0010\u000f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001dR\u0011\u0010\u0010\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001dR\u0011\u0010\u0011\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001dR\u0011\u0010\u0012\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001bR\u0011\u0010\u0013\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001bR\u0011\u0010\u0014\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001dR\u0011\u0010\u0015\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001bR\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\r¢\u0006\b\n\u0000\u001a\u0004\b-\u0010$¨\u0006I"}, d2 = {"Lru/mrlargha/commonui/elements/donate/presentation/models/DonateItemModel;", "", "id", "", "name", "", FirebaseAnalytics.Param.PRICE, "priceCurrency", "type", "iconButton", "isEnableButton", "", "colorButton", "", "titleButton", "image", "effectColor", L2.g, FirebaseAnalytics.Param.DISCOUNT, "blockType", "blockTitle", "unixTime", "badges", "Lru/mrlargha/commonui/elements/donate/presentation/models/DonateBadgesModel;", "<init>", "(ILjava/lang/String;IIIIZLjava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;ILjava/util/List;)V", "getId", "()I", "getName", "()Ljava/lang/String;", "getPrice", "getPriceCurrency", "getType", "getIconButton", "()Z", "getColorButton", "()Ljava/util/List;", "getTitleButton", "getImage", "getEffectColor", "getBackground", "getDiscount", "getBlockType", "getBlockTitle", "getUnixTime", "getBadges", "getCurrencyType", "Lru/mrlargha/commonui/elements/donate/presentation/models/DonatePriceCurrencyType;", "getItemType", "Lru/mrlargha/commonui/elements/donate/presentation/models/DonateItemType;", "Lru/mrlargha/commonui/elements/donate/presentation/models/DonateBlockType;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "copy", "equals", "other", "hashCode", "toString", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DonateItemModel {
    private final String background;
    private final List<DonateBadgesModel> badges;
    private final String blockTitle;
    private final int blockType;
    private final List<String> colorButton;
    private final int discount;
    private final String effectColor;
    private final int iconButton;
    private final int id;
    private final String image;
    private final boolean isEnableButton;
    private final String name;
    private final int price;
    private final int priceCurrency;
    private final String titleButton;
    private final int type;
    private final int unixTime;

    public static /* synthetic */ DonateItemModel copy$default(DonateItemModel donateItemModel, int i, String str, int i2, int i3, int i4, int i5, boolean z, List list, String str2, String str3, String str4, String str5, int i6, int i7, String str6, int i8, List list2, int i9, Object obj) {
        List<DonateBadgesModel> list3;
        int i10;
        int i11;
        DonateItemModel donateItemModel2;
        String str7;
        String str8;
        int i12;
        int i13;
        int i14;
        int i15;
        boolean z2;
        List list4;
        String str9;
        String str10;
        String str11;
        String str12;
        int i16;
        int i17;
        int i18 = (i9 & 1) != 0 ? donateItemModel.id : i;
        String str13 = (i9 & 2) != 0 ? donateItemModel.name : str;
        int i19 = (i9 & 4) != 0 ? donateItemModel.price : i2;
        int i20 = (i9 & 8) != 0 ? donateItemModel.priceCurrency : i3;
        int i21 = (i9 & 16) != 0 ? donateItemModel.type : i4;
        int i22 = (i9 & 32) != 0 ? donateItemModel.iconButton : i5;
        boolean z3 = (i9 & 64) != 0 ? donateItemModel.isEnableButton : z;
        List list5 = (i9 & 128) != 0 ? donateItemModel.colorButton : list;
        String str14 = (i9 & 256) != 0 ? donateItemModel.titleButton : str2;
        String str15 = (i9 & 512) != 0 ? donateItemModel.image : str3;
        String str16 = (i9 & 1024) != 0 ? donateItemModel.effectColor : str4;
        String str17 = (i9 & 2048) != 0 ? donateItemModel.background : str5;
        int i23 = (i9 & 4096) != 0 ? donateItemModel.discount : i6;
        int i24 = (i9 & 8192) != 0 ? donateItemModel.blockType : i7;
        int i25 = i18;
        String str18 = (i9 & 16384) != 0 ? donateItemModel.blockTitle : str6;
        int i26 = (i9 & 32768) != 0 ? donateItemModel.unixTime : i8;
        if ((i9 & 65536) != 0) {
            i10 = i26;
            list3 = donateItemModel.badges;
            str7 = str18;
            str8 = str13;
            i12 = i19;
            i13 = i20;
            i14 = i21;
            i15 = i22;
            z2 = z3;
            list4 = list5;
            str9 = str14;
            str10 = str15;
            str11 = str16;
            str12 = str17;
            i16 = i23;
            i17 = i24;
            i11 = i25;
            donateItemModel2 = donateItemModel;
        } else {
            list3 = list2;
            i10 = i26;
            i11 = i25;
            donateItemModel2 = donateItemModel;
            str7 = str18;
            str8 = str13;
            i12 = i19;
            i13 = i20;
            i14 = i21;
            i15 = i22;
            z2 = z3;
            list4 = list5;
            str9 = str14;
            str10 = str15;
            str11 = str16;
            str12 = str17;
            i16 = i23;
            i17 = i24;
        }
        return donateItemModel2.copy(i11, str8, i12, i13, i14, i15, z2, list4, str9, str10, str11, str12, i16, i17, str7, i10, list3);
    }

    public final int component1() {
        return this.id;
    }

    public final String component10() {
        return this.image;
    }

    public final String component11() {
        return this.effectColor;
    }

    public final String component12() {
        return this.background;
    }

    public final int component13() {
        return this.discount;
    }

    public final int component14() {
        return this.blockType;
    }

    public final String component15() {
        return this.blockTitle;
    }

    public final int component16() {
        return this.unixTime;
    }

    public final List<DonateBadgesModel> component17() {
        return this.badges;
    }

    public final String component2() {
        return this.name;
    }

    public final int component3() {
        return this.price;
    }

    public final int component4() {
        return this.priceCurrency;
    }

    public final int component5() {
        return this.type;
    }

    public final int component6() {
        return this.iconButton;
    }

    public final boolean component7() {
        return this.isEnableButton;
    }

    public final List<String> component8() {
        return this.colorButton;
    }

    public final String component9() {
        return this.titleButton;
    }

    public final DonateItemModel copy(int i, String name, int i2, int i3, int i4, int i5, boolean z, List<String> colorButton, String titleButton, String image, String effectColor, String background, int i6, int i7, String blockTitle, int i8, List<DonateBadgesModel> badges) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(colorButton, "colorButton");
        Intrinsics.checkNotNullParameter(titleButton, "titleButton");
        Intrinsics.checkNotNullParameter(image, "image");
        Intrinsics.checkNotNullParameter(effectColor, "effectColor");
        Intrinsics.checkNotNullParameter(background, "background");
        Intrinsics.checkNotNullParameter(blockTitle, "blockTitle");
        Intrinsics.checkNotNullParameter(badges, "badges");
        return new DonateItemModel(i, name, i2, i3, i4, i5, z, colorButton, titleButton, image, effectColor, background, i6, i7, blockTitle, i8, badges);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DonateItemModel) {
            DonateItemModel donateItemModel = (DonateItemModel) obj;
            return this.id == donateItemModel.id && Intrinsics.areEqual(this.name, donateItemModel.name) && this.price == donateItemModel.price && this.priceCurrency == donateItemModel.priceCurrency && this.type == donateItemModel.type && this.iconButton == donateItemModel.iconButton && this.isEnableButton == donateItemModel.isEnableButton && Intrinsics.areEqual(this.colorButton, donateItemModel.colorButton) && Intrinsics.areEqual(this.titleButton, donateItemModel.titleButton) && Intrinsics.areEqual(this.image, donateItemModel.image) && Intrinsics.areEqual(this.effectColor, donateItemModel.effectColor) && Intrinsics.areEqual(this.background, donateItemModel.background) && this.discount == donateItemModel.discount && this.blockType == donateItemModel.blockType && Intrinsics.areEqual(this.blockTitle, donateItemModel.blockTitle) && this.unixTime == donateItemModel.unixTime && Intrinsics.areEqual(this.badges, donateItemModel.badges);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((Integer.hashCode(this.id) * 31) + this.name.hashCode()) * 31) + Integer.hashCode(this.price)) * 31) + Integer.hashCode(this.priceCurrency)) * 31) + Integer.hashCode(this.type)) * 31) + Integer.hashCode(this.iconButton)) * 31) + Boolean.hashCode(this.isEnableButton)) * 31) + this.colorButton.hashCode()) * 31) + this.titleButton.hashCode()) * 31) + this.image.hashCode()) * 31) + this.effectColor.hashCode()) * 31) + this.background.hashCode()) * 31) + Integer.hashCode(this.discount)) * 31) + Integer.hashCode(this.blockType)) * 31) + this.blockTitle.hashCode()) * 31) + Integer.hashCode(this.unixTime)) * 31) + this.badges.hashCode();
    }

    public String toString() {
        int i = this.id;
        String str = this.name;
        int i2 = this.price;
        int i3 = this.priceCurrency;
        int i4 = this.type;
        int i5 = this.iconButton;
        boolean z = this.isEnableButton;
        List<String> list = this.colorButton;
        String str2 = this.titleButton;
        String str3 = this.image;
        String str4 = this.effectColor;
        String str5 = this.background;
        int i6 = this.discount;
        int i7 = this.blockType;
        String str6 = this.blockTitle;
        int i8 = this.unixTime;
        return "DonateItemModel(id=" + i + ", name=" + str + ", price=" + i2 + ", priceCurrency=" + i3 + ", type=" + i4 + ", iconButton=" + i5 + ", isEnableButton=" + z + ", colorButton=" + list + ", titleButton=" + str2 + ", image=" + str3 + ", effectColor=" + str4 + ", background=" + str5 + ", discount=" + i6 + ", blockType=" + i7 + ", blockTitle=" + str6 + ", unixTime=" + i8 + ", badges=" + this.badges + ")";
    }

    public DonateItemModel(int i, String name, int i2, int i3, int i4, int i5, boolean z, List<String> colorButton, String titleButton, String image, String effectColor, String background, int i6, int i7, String blockTitle, int i8, List<DonateBadgesModel> badges) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(colorButton, "colorButton");
        Intrinsics.checkNotNullParameter(titleButton, "titleButton");
        Intrinsics.checkNotNullParameter(image, "image");
        Intrinsics.checkNotNullParameter(effectColor, "effectColor");
        Intrinsics.checkNotNullParameter(background, "background");
        Intrinsics.checkNotNullParameter(blockTitle, "blockTitle");
        Intrinsics.checkNotNullParameter(badges, "badges");
        this.id = i;
        this.name = name;
        this.price = i2;
        this.priceCurrency = i3;
        this.type = i4;
        this.iconButton = i5;
        this.isEnableButton = z;
        this.colorButton = colorButton;
        this.titleButton = titleButton;
        this.image = image;
        this.effectColor = effectColor;
        this.background = background;
        this.discount = i6;
        this.blockType = i7;
        this.blockTitle = blockTitle;
        this.unixTime = i8;
        this.badges = badges;
    }

    public final int getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
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

    public final String getImage() {
        return this.image;
    }

    public final String getEffectColor() {
        return this.effectColor;
    }

    public final String getBackground() {
        return this.background;
    }

    public final int getDiscount() {
        return this.discount;
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

    public final List<DonateBadgesModel> getBadges() {
        return this.badges;
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
    public final DonateBlockType m10490getBlockType() {
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
}
