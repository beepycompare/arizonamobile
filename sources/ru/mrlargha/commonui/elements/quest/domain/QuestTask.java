package ru.mrlargha.commonui.elements.quest.domain;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: QuestResponses.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001Ba\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0006\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0006HÆ\u0003J\t\u0010\"\u001a\u00020\u0006HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eHÆ\u0003Ju\u0010)\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00062\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eHÆ\u0001J\u0013\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010-\u001a\u00020\u0003HÖ\u0001J\t\u0010.\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0013R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0013R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0016R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e¨\u0006/"}, d2 = {"Lru/mrlargha/commonui/elements/quest/domain/QuestTask;", "", "id", "", "stageId", "title", "", "description", "rewardReceived", "hasLocation", "progress", "maxProgress", "buttonText", "rewards", "", "Lru/mrlargha/commonui/elements/quest/domain/QuestReward;", "<init>", "(IILjava/lang/String;Ljava/lang/String;IIIILjava/lang/String;Ljava/util/List;)V", "getId", "()I", "getStageId", "getTitle", "()Ljava/lang/String;", "getDescription", "getRewardReceived", "getHasLocation", "getProgress", "getMaxProgress", "getButtonText", "getRewards", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", "", "other", "hashCode", "toString", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class QuestTask {
    @SerializedName("button")
    private final String buttonText;
    private final String description;
    private final int hasLocation;
    private final int id;
    private final int maxProgress;
    private final int progress;
    private final int rewardReceived;
    private final List<QuestReward> rewards;
    @SerializedName("stage_id")
    private final int stageId;
    private final String title;

    public static /* synthetic */ QuestTask copy$default(QuestTask questTask, int i, int i2, String str, String str2, int i3, int i4, int i5, int i6, String str3, List list, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            i = questTask.id;
        }
        if ((i7 & 2) != 0) {
            i2 = questTask.stageId;
        }
        if ((i7 & 4) != 0) {
            str = questTask.title;
        }
        if ((i7 & 8) != 0) {
            str2 = questTask.description;
        }
        if ((i7 & 16) != 0) {
            i3 = questTask.rewardReceived;
        }
        if ((i7 & 32) != 0) {
            i4 = questTask.hasLocation;
        }
        if ((i7 & 64) != 0) {
            i5 = questTask.progress;
        }
        if ((i7 & 128) != 0) {
            i6 = questTask.maxProgress;
        }
        if ((i7 & 256) != 0) {
            str3 = questTask.buttonText;
        }
        List<QuestReward> list2 = list;
        if ((i7 & 512) != 0) {
            list2 = questTask.rewards;
        }
        String str4 = str3;
        List list3 = list2;
        int i8 = i5;
        int i9 = i6;
        int i10 = i3;
        int i11 = i4;
        return questTask.copy(i, i2, str, str2, i10, i11, i8, i9, str4, list3);
    }

    public final int component1() {
        return this.id;
    }

    public final List<QuestReward> component10() {
        return this.rewards;
    }

    public final int component2() {
        return this.stageId;
    }

    public final String component3() {
        return this.title;
    }

    public final String component4() {
        return this.description;
    }

    public final int component5() {
        return this.rewardReceived;
    }

    public final int component6() {
        return this.hasLocation;
    }

    public final int component7() {
        return this.progress;
    }

    public final int component8() {
        return this.maxProgress;
    }

    public final String component9() {
        return this.buttonText;
    }

    public final QuestTask copy(int i, int i2, String title, String description, int i3, int i4, int i5, int i6, String str, List<QuestReward> rewards) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(rewards, "rewards");
        return new QuestTask(i, i2, title, description, i3, i4, i5, i6, str, rewards);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof QuestTask) {
            QuestTask questTask = (QuestTask) obj;
            return this.id == questTask.id && this.stageId == questTask.stageId && Intrinsics.areEqual(this.title, questTask.title) && Intrinsics.areEqual(this.description, questTask.description) && this.rewardReceived == questTask.rewardReceived && this.hasLocation == questTask.hasLocation && this.progress == questTask.progress && this.maxProgress == questTask.maxProgress && Intrinsics.areEqual(this.buttonText, questTask.buttonText) && Intrinsics.areEqual(this.rewards, questTask.rewards);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((((((((((((((Integer.hashCode(this.id) * 31) + Integer.hashCode(this.stageId)) * 31) + this.title.hashCode()) * 31) + this.description.hashCode()) * 31) + Integer.hashCode(this.rewardReceived)) * 31) + Integer.hashCode(this.hasLocation)) * 31) + Integer.hashCode(this.progress)) * 31) + Integer.hashCode(this.maxProgress)) * 31;
        String str = this.buttonText;
        return ((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.rewards.hashCode();
    }

    public String toString() {
        int i = this.id;
        int i2 = this.stageId;
        String str = this.title;
        String str2 = this.description;
        int i3 = this.rewardReceived;
        int i4 = this.hasLocation;
        int i5 = this.progress;
        int i6 = this.maxProgress;
        String str3 = this.buttonText;
        return "QuestTask(id=" + i + ", stageId=" + i2 + ", title=" + str + ", description=" + str2 + ", rewardReceived=" + i3 + ", hasLocation=" + i4 + ", progress=" + i5 + ", maxProgress=" + i6 + ", buttonText=" + str3 + ", rewards=" + this.rewards + ")";
    }

    public QuestTask(int i, int i2, String title, String description, int i3, int i4, int i5, int i6, String str, List<QuestReward> rewards) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(rewards, "rewards");
        this.id = i;
        this.stageId = i2;
        this.title = title;
        this.description = description;
        this.rewardReceived = i3;
        this.hasLocation = i4;
        this.progress = i5;
        this.maxProgress = i6;
        this.buttonText = str;
        this.rewards = rewards;
    }

    public /* synthetic */ QuestTask(int i, int i2, String str, String str2, int i3, int i4, int i5, int i6, String str3, List list, int i7, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, str, str2, i3, i4, i5, i6, (i7 & 256) != 0 ? null : str3, list);
    }

    public final int getId() {
        return this.id;
    }

    public final int getStageId() {
        return this.stageId;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getDescription() {
        return this.description;
    }

    public final int getRewardReceived() {
        return this.rewardReceived;
    }

    public final int getHasLocation() {
        return this.hasLocation;
    }

    public final int getProgress() {
        return this.progress;
    }

    public final int getMaxProgress() {
        return this.maxProgress;
    }

    public final String getButtonText() {
        return this.buttonText;
    }

    public final List<QuestReward> getRewards() {
        return this.rewards;
    }
}
