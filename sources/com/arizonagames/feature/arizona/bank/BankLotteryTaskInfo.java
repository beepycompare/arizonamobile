package com.arizonagames.feature.arizona.bank;

import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: BankContract.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001BI\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\tHÆ\u0003J\u000f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00050\u000bHÆ\u0003JK\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000bHÆ\u0001J\u0014\u0010\"\u001a\u00020\t2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010$\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010%\u001a\u00020\u0005HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R%\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004\u0092\u0002\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\t0\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006&"}, d2 = {"Lcom/arizonagames/feature/arizona/bank/BankLotteryTaskInfo;", "", "id", "", "title", "", "desc", "imgPath", "completed", "", "bgColors", "", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/util/List;)V", "getId", "()I", "getTitle", "()Ljava/lang/String;", "getDesc", "getImgPath", "getCompleted", "()Z", "Lcom/google/gson/annotations/JsonAdapter;", "value", "Lcom/arizonagames/feature/arizona/bank/BankBooleanJsonAdapter;", "getBgColors", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "bank"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BankLotteryTaskInfo {
    private final List<String> bgColors;
    @JsonAdapter(BankBooleanJsonAdapter.class)
    private final boolean completed;
    private final String desc;
    private final int id;
    private final String imgPath;
    private final String title;

    public BankLotteryTaskInfo() {
        this(0, null, null, null, false, null, 63, null);
    }

    public static /* synthetic */ BankLotteryTaskInfo copy$default(BankLotteryTaskInfo bankLotteryTaskInfo, int i, String str, String str2, String str3, boolean z, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = bankLotteryTaskInfo.id;
        }
        if ((i2 & 2) != 0) {
            str = bankLotteryTaskInfo.title;
        }
        if ((i2 & 4) != 0) {
            str2 = bankLotteryTaskInfo.desc;
        }
        if ((i2 & 8) != 0) {
            str3 = bankLotteryTaskInfo.imgPath;
        }
        if ((i2 & 16) != 0) {
            z = bankLotteryTaskInfo.completed;
        }
        List<String> list2 = list;
        if ((i2 & 32) != 0) {
            list2 = bankLotteryTaskInfo.bgColors;
        }
        boolean z2 = z;
        List list3 = list2;
        return bankLotteryTaskInfo.copy(i, str, str2, str3, z2, list3);
    }

    public final int component1() {
        return this.id;
    }

    public final String component2() {
        return this.title;
    }

    public final String component3() {
        return this.desc;
    }

    public final String component4() {
        return this.imgPath;
    }

    public final boolean component5() {
        return this.completed;
    }

    public final List<String> component6() {
        return this.bgColors;
    }

    public final BankLotteryTaskInfo copy(int i, String title, String desc, String imgPath, boolean z, List<String> bgColors) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(desc, "desc");
        Intrinsics.checkNotNullParameter(imgPath, "imgPath");
        Intrinsics.checkNotNullParameter(bgColors, "bgColors");
        return new BankLotteryTaskInfo(i, title, desc, imgPath, z, bgColors);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BankLotteryTaskInfo) {
            BankLotteryTaskInfo bankLotteryTaskInfo = (BankLotteryTaskInfo) obj;
            return this.id == bankLotteryTaskInfo.id && Intrinsics.areEqual(this.title, bankLotteryTaskInfo.title) && Intrinsics.areEqual(this.desc, bankLotteryTaskInfo.desc) && Intrinsics.areEqual(this.imgPath, bankLotteryTaskInfo.imgPath) && this.completed == bankLotteryTaskInfo.completed && Intrinsics.areEqual(this.bgColors, bankLotteryTaskInfo.bgColors);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((Integer.hashCode(this.id) * 31) + this.title.hashCode()) * 31) + this.desc.hashCode()) * 31) + this.imgPath.hashCode()) * 31) + Boolean.hashCode(this.completed)) * 31) + this.bgColors.hashCode();
    }

    public String toString() {
        int i = this.id;
        String str = this.title;
        String str2 = this.desc;
        String str3 = this.imgPath;
        boolean z = this.completed;
        return "BankLotteryTaskInfo(id=" + i + ", title=" + str + ", desc=" + str2 + ", imgPath=" + str3 + ", completed=" + z + ", bgColors=" + this.bgColors + ")";
    }

    public BankLotteryTaskInfo(int i, String title, String desc, String imgPath, boolean z, List<String> bgColors) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(desc, "desc");
        Intrinsics.checkNotNullParameter(imgPath, "imgPath");
        Intrinsics.checkNotNullParameter(bgColors, "bgColors");
        this.id = i;
        this.title = title;
        this.desc = desc;
        this.imgPath = imgPath;
        this.completed = z;
        this.bgColors = bgColors;
    }

    public /* synthetic */ BankLotteryTaskInfo(int i, String str, String str2, String str3, boolean z, List list, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? "" : str, (i2 & 4) != 0 ? "" : str2, (i2 & 8) != 0 ? "" : str3, (i2 & 16) != 0 ? false : z, (i2 & 32) != 0 ? CollectionsKt.emptyList() : list);
    }

    public final int getId() {
        return this.id;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getDesc() {
        return this.desc;
    }

    public final String getImgPath() {
        return this.imgPath;
    }

    public final boolean getCompleted() {
        return this.completed;
    }

    public final List<String> getBgColors() {
        return this.bgColors;
    }
}
