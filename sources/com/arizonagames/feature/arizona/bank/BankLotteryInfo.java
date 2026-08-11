package com.arizonagames.feature.arizona.bank;

import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: BankContract.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001d\b\u0086\b\u0018\u00002\u00020\u0001Bq\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0005HÆ\u0003J\t\u0010(\u001a\u00020\u0005HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\tHÆ\u0003J\t\u0010+\u001a\u00020\u000bHÆ\u0003J\t\u0010,\u001a\u00020\u000bHÆ\u0003J\t\u0010-\u001a\u00020\u000bHÆ\u0003J\t\u0010.\u001a\u00020\u0005HÆ\u0003J\u000f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010HÆ\u0003Js\u00100\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u00052\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010HÆ\u0001J\u0014\u00101\u001a\u00020\u00032\b\u00102\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u00103\u001a\u00020\u000bHÖ\u0081\u0004J\n\u00104\u001a\u00020\u0005HÖ\u0081\u0004R%\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\t0\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR%\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\t0\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0015R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b!\u0010 R\u0011\u0010\r\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010 R\u0011\u0010\u000e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001aR\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%¨\u00065"}, d2 = {"Lcom/arizonagames/feature/arizona/bank/BankLotteryInfo;", "", "visible", "", "title", "", "desc", "activeState", "endTime", "", "ticketsBalance", "", "ticketsLeftTime", "ticketsAvailableCount", "streamUrl", "tasks", "", "Lcom/arizonagames/feature/arizona/bank/BankLotteryTaskInfo;", "<init>", "(ZLjava/lang/String;Ljava/lang/String;ZJIIILjava/lang/String;Ljava/util/List;)V", "getVisible", "()Z", "Lcom/google/gson/annotations/JsonAdapter;", "value", "Lcom/arizonagames/feature/arizona/bank/BankBooleanJsonAdapter;", "getTitle", "()Ljava/lang/String;", "getDesc", "getActiveState", "getEndTime", "()J", "getTicketsBalance", "()I", "getTicketsLeftTime", "getTicketsAvailableCount", "getStreamUrl", "getTasks", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", "other", "hashCode", "toString", "bank"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BankLotteryInfo {
    @JsonAdapter(BankBooleanJsonAdapter.class)
    private final boolean activeState;
    private final String desc;
    private final long endTime;
    private final String streamUrl;
    private final List<BankLotteryTaskInfo> tasks;
    private final int ticketsAvailableCount;
    private final int ticketsBalance;
    private final int ticketsLeftTime;
    private final String title;
    @JsonAdapter(BankBooleanJsonAdapter.class)
    private final boolean visible;

    public BankLotteryInfo() {
        this(false, null, null, false, 0L, 0, 0, 0, null, null, 1023, null);
    }

    public static /* synthetic */ BankLotteryInfo copy$default(BankLotteryInfo bankLotteryInfo, boolean z, String str, String str2, boolean z2, long j, int i, int i2, int i3, String str3, List list, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            z = bankLotteryInfo.visible;
        }
        if ((i4 & 2) != 0) {
            str = bankLotteryInfo.title;
        }
        if ((i4 & 4) != 0) {
            str2 = bankLotteryInfo.desc;
        }
        if ((i4 & 8) != 0) {
            z2 = bankLotteryInfo.activeState;
        }
        if ((i4 & 16) != 0) {
            j = bankLotteryInfo.endTime;
        }
        if ((i4 & 32) != 0) {
            i = bankLotteryInfo.ticketsBalance;
        }
        if ((i4 & 64) != 0) {
            i2 = bankLotteryInfo.ticketsLeftTime;
        }
        if ((i4 & 128) != 0) {
            i3 = bankLotteryInfo.ticketsAvailableCount;
        }
        if ((i4 & 256) != 0) {
            str3 = bankLotteryInfo.streamUrl;
        }
        List<BankLotteryTaskInfo> list2 = list;
        if ((i4 & 512) != 0) {
            list2 = bankLotteryInfo.tasks;
        }
        List list3 = list2;
        int i5 = i3;
        int i6 = i;
        long j2 = j;
        String str4 = str2;
        boolean z3 = z2;
        return bankLotteryInfo.copy(z, str, str4, z3, j2, i6, i2, i5, str3, list3);
    }

    public final boolean component1() {
        return this.visible;
    }

    public final List<BankLotteryTaskInfo> component10() {
        return this.tasks;
    }

    public final String component2() {
        return this.title;
    }

    public final String component3() {
        return this.desc;
    }

    public final boolean component4() {
        return this.activeState;
    }

    public final long component5() {
        return this.endTime;
    }

    public final int component6() {
        return this.ticketsBalance;
    }

    public final int component7() {
        return this.ticketsLeftTime;
    }

    public final int component8() {
        return this.ticketsAvailableCount;
    }

    public final String component9() {
        return this.streamUrl;
    }

    public final BankLotteryInfo copy(boolean z, String title, String desc, boolean z2, long j, int i, int i2, int i3, String streamUrl, List<BankLotteryTaskInfo> tasks) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(desc, "desc");
        Intrinsics.checkNotNullParameter(streamUrl, "streamUrl");
        Intrinsics.checkNotNullParameter(tasks, "tasks");
        return new BankLotteryInfo(z, title, desc, z2, j, i, i2, i3, streamUrl, tasks);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BankLotteryInfo) {
            BankLotteryInfo bankLotteryInfo = (BankLotteryInfo) obj;
            return this.visible == bankLotteryInfo.visible && Intrinsics.areEqual(this.title, bankLotteryInfo.title) && Intrinsics.areEqual(this.desc, bankLotteryInfo.desc) && this.activeState == bankLotteryInfo.activeState && this.endTime == bankLotteryInfo.endTime && this.ticketsBalance == bankLotteryInfo.ticketsBalance && this.ticketsLeftTime == bankLotteryInfo.ticketsLeftTime && this.ticketsAvailableCount == bankLotteryInfo.ticketsAvailableCount && Intrinsics.areEqual(this.streamUrl, bankLotteryInfo.streamUrl) && Intrinsics.areEqual(this.tasks, bankLotteryInfo.tasks);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((((Boolean.hashCode(this.visible) * 31) + this.title.hashCode()) * 31) + this.desc.hashCode()) * 31) + Boolean.hashCode(this.activeState)) * 31) + Long.hashCode(this.endTime)) * 31) + Integer.hashCode(this.ticketsBalance)) * 31) + Integer.hashCode(this.ticketsLeftTime)) * 31) + Integer.hashCode(this.ticketsAvailableCount)) * 31) + this.streamUrl.hashCode()) * 31) + this.tasks.hashCode();
    }

    public String toString() {
        boolean z = this.visible;
        String str = this.title;
        String str2 = this.desc;
        boolean z2 = this.activeState;
        long j = this.endTime;
        int i = this.ticketsBalance;
        int i2 = this.ticketsLeftTime;
        int i3 = this.ticketsAvailableCount;
        String str3 = this.streamUrl;
        return "BankLotteryInfo(visible=" + z + ", title=" + str + ", desc=" + str2 + ", activeState=" + z2 + ", endTime=" + j + ", ticketsBalance=" + i + ", ticketsLeftTime=" + i2 + ", ticketsAvailableCount=" + i3 + ", streamUrl=" + str3 + ", tasks=" + this.tasks + ")";
    }

    public BankLotteryInfo(boolean z, String title, String desc, boolean z2, long j, int i, int i2, int i3, String streamUrl, List<BankLotteryTaskInfo> tasks) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(desc, "desc");
        Intrinsics.checkNotNullParameter(streamUrl, "streamUrl");
        Intrinsics.checkNotNullParameter(tasks, "tasks");
        this.visible = z;
        this.title = title;
        this.desc = desc;
        this.activeState = z2;
        this.endTime = j;
        this.ticketsBalance = i;
        this.ticketsLeftTime = i2;
        this.ticketsAvailableCount = i3;
        this.streamUrl = streamUrl;
        this.tasks = tasks;
    }

    public /* synthetic */ BankLotteryInfo(boolean z, String str, String str2, boolean z2, long j, int i, int i2, int i3, String str3, List list, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? false : z, (i4 & 2) != 0 ? "" : str, (i4 & 4) != 0 ? "" : str2, (i4 & 8) != 0 ? false : z2, (i4 & 16) != 0 ? 0L : j, (i4 & 32) != 0 ? 0 : i, (i4 & 64) != 0 ? 0 : i2, (i4 & 128) != 0 ? 0 : i3, (i4 & 256) != 0 ? "" : str3, (i4 & 512) != 0 ? CollectionsKt.emptyList() : list);
    }

    public final boolean getVisible() {
        return this.visible;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getDesc() {
        return this.desc;
    }

    public final boolean getActiveState() {
        return this.activeState;
    }

    public final long getEndTime() {
        return this.endTime;
    }

    public final int getTicketsBalance() {
        return this.ticketsBalance;
    }

    public final int getTicketsLeftTime() {
        return this.ticketsLeftTime;
    }

    public final int getTicketsAvailableCount() {
        return this.ticketsAvailableCount;
    }

    public final String getStreamUrl() {
        return this.streamUrl;
    }

    public final List<BankLotteryTaskInfo> getTasks() {
        return this.tasks;
    }
}
