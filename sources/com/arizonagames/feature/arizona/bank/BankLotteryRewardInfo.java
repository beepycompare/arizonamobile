package com.arizonagames.feature.arizona.bank;

import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: BankContract.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BE\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003JG\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001e\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u001f\u001a\u00020\u0005HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\r¨\u0006 "}, d2 = {"Lcom/arizonagames/feature/arizona/bank/BankLotteryRewardInfo;", "", TtmlNode.ATTR_ID, "", "name", "", "winner", "imgPath", "bgColor", "enchant", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getId", "()I", "getName", "()Ljava/lang/String;", "getWinner", "getImgPath", "getBgColor", "getEnchant", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "bank"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BankLotteryRewardInfo {
    private final String bgColor;
    private final int enchant;
    private final int id;
    private final String imgPath;
    private final String name;
    private final String winner;

    public BankLotteryRewardInfo() {
        this(0, null, null, null, null, 0, 63, null);
    }

    public static /* synthetic */ BankLotteryRewardInfo copy$default(BankLotteryRewardInfo bankLotteryRewardInfo, int i, String str, String str2, String str3, String str4, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = bankLotteryRewardInfo.id;
        }
        if ((i3 & 2) != 0) {
            str = bankLotteryRewardInfo.name;
        }
        if ((i3 & 4) != 0) {
            str2 = bankLotteryRewardInfo.winner;
        }
        if ((i3 & 8) != 0) {
            str3 = bankLotteryRewardInfo.imgPath;
        }
        if ((i3 & 16) != 0) {
            str4 = bankLotteryRewardInfo.bgColor;
        }
        if ((i3 & 32) != 0) {
            i2 = bankLotteryRewardInfo.enchant;
        }
        String str5 = str4;
        int i4 = i2;
        return bankLotteryRewardInfo.copy(i, str, str2, str3, str5, i4);
    }

    public final int component1() {
        return this.id;
    }

    public final String component2() {
        return this.name;
    }

    public final String component3() {
        return this.winner;
    }

    public final String component4() {
        return this.imgPath;
    }

    public final String component5() {
        return this.bgColor;
    }

    public final int component6() {
        return this.enchant;
    }

    public final BankLotteryRewardInfo copy(int i, String name, String str, String imgPath, String bgColor, int i2) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(imgPath, "imgPath");
        Intrinsics.checkNotNullParameter(bgColor, "bgColor");
        return new BankLotteryRewardInfo(i, name, str, imgPath, bgColor, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BankLotteryRewardInfo) {
            BankLotteryRewardInfo bankLotteryRewardInfo = (BankLotteryRewardInfo) obj;
            return this.id == bankLotteryRewardInfo.id && Intrinsics.areEqual(this.name, bankLotteryRewardInfo.name) && Intrinsics.areEqual(this.winner, bankLotteryRewardInfo.winner) && Intrinsics.areEqual(this.imgPath, bankLotteryRewardInfo.imgPath) && Intrinsics.areEqual(this.bgColor, bankLotteryRewardInfo.bgColor) && this.enchant == bankLotteryRewardInfo.enchant;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((Integer.hashCode(this.id) * 31) + this.name.hashCode()) * 31;
        String str = this.winner;
        return ((((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.imgPath.hashCode()) * 31) + this.bgColor.hashCode()) * 31) + Integer.hashCode(this.enchant);
    }

    public String toString() {
        int i = this.id;
        String str = this.name;
        String str2 = this.winner;
        String str3 = this.imgPath;
        String str4 = this.bgColor;
        return "BankLotteryRewardInfo(id=" + i + ", name=" + str + ", winner=" + str2 + ", imgPath=" + str3 + ", bgColor=" + str4 + ", enchant=" + this.enchant + ")";
    }

    public BankLotteryRewardInfo(int i, String name, String str, String imgPath, String bgColor, int i2) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(imgPath, "imgPath");
        Intrinsics.checkNotNullParameter(bgColor, "bgColor");
        this.id = i;
        this.name = name;
        this.winner = str;
        this.imgPath = imgPath;
        this.bgColor = bgColor;
        this.enchant = i2;
    }

    public /* synthetic */ BankLotteryRewardInfo(int i, String str, String str2, String str3, String str4, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? "" : str, (i3 & 4) != 0 ? null : str2, (i3 & 8) != 0 ? "" : str3, (i3 & 16) != 0 ? "" : str4, (i3 & 32) != 0 ? 0 : i2);
    }

    public final int getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final String getWinner() {
        return this.winner;
    }

    public final String getImgPath() {
        return this.imgPath;
    }

    public final String getBgColor() {
        return this.bgColor;
    }

    public final int getEnchant() {
        return this.enchant;
    }
}
