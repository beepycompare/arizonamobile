package ru.mrlargha.commonui.elements.quest;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Quest.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001Bg\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0006\u0012\u0016\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0006HÆ\u0003J\t\u0010#\u001a\u00020\u0006HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0006HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0006HÆ\u0003J\u0019\u0010)\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u0010HÆ\u0003J}\u0010*\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00062\u0018\b\u0002\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u0010HÆ\u0001J\u0013\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010.\u001a\u00020\u0003HÖ\u0001J\t\u0010/\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014R\u0011\u0010\n\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0014R\u0011\u0010\f\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0017R!\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u00060"}, d2 = {"Lru/mrlargha/commonui/elements/quest/QuestLine;", "", "id", "", "storyId", "title", "", "description", "progress", "maxProgress", "textProgress", "hasReward", "image", "awards", "Ljava/util/ArrayList;", "Lru/mrlargha/commonui/elements/quest/QuestAwards;", "Lkotlin/collections/ArrayList;", "<init>", "(IILjava/lang/String;Ljava/lang/String;IILjava/lang/String;ILjava/lang/String;Ljava/util/ArrayList;)V", "getId", "()I", "getStoryId", "getTitle", "()Ljava/lang/String;", "getDescription", "getProgress", "getMaxProgress", "getTextProgress", "getHasReward", "getImage", "getAwards", "()Ljava/util/ArrayList;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", "", "other", "hashCode", "toString", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class QuestLine {
    private final ArrayList<QuestAwards> awards;
    private final String description;
    private final int hasReward;
    private final int id;
    private final String image;
    private final int maxProgress;
    private final int progress;
    private final int storyId;
    private final String textProgress;
    private final String title;

    public static /* synthetic */ QuestLine copy$default(QuestLine questLine, int i, int i2, String str, String str2, int i3, int i4, String str3, int i5, String str4, ArrayList arrayList, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i = questLine.id;
        }
        if ((i6 & 2) != 0) {
            i2 = questLine.storyId;
        }
        if ((i6 & 4) != 0) {
            str = questLine.title;
        }
        if ((i6 & 8) != 0) {
            str2 = questLine.description;
        }
        if ((i6 & 16) != 0) {
            i3 = questLine.progress;
        }
        if ((i6 & 32) != 0) {
            i4 = questLine.maxProgress;
        }
        if ((i6 & 64) != 0) {
            str3 = questLine.textProgress;
        }
        if ((i6 & 128) != 0) {
            i5 = questLine.hasReward;
        }
        if ((i6 & 256) != 0) {
            str4 = questLine.image;
        }
        ArrayList<QuestAwards> arrayList2 = arrayList;
        if ((i6 & 512) != 0) {
            arrayList2 = questLine.awards;
        }
        String str5 = str4;
        ArrayList arrayList3 = arrayList2;
        String str6 = str3;
        int i7 = i5;
        int i8 = i3;
        int i9 = i4;
        return questLine.copy(i, i2, str, str2, i8, i9, str6, i7, str5, arrayList3);
    }

    public final int component1() {
        return this.id;
    }

    public final ArrayList<QuestAwards> component10() {
        return this.awards;
    }

    public final int component2() {
        return this.storyId;
    }

    public final String component3() {
        return this.title;
    }

    public final String component4() {
        return this.description;
    }

    public final int component5() {
        return this.progress;
    }

    public final int component6() {
        return this.maxProgress;
    }

    public final String component7() {
        return this.textProgress;
    }

    public final int component8() {
        return this.hasReward;
    }

    public final String component9() {
        return this.image;
    }

    public final QuestLine copy(int i, int i2, String title, String description, int i3, int i4, String textProgress, int i5, String image, ArrayList<QuestAwards> awards) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(textProgress, "textProgress");
        Intrinsics.checkNotNullParameter(image, "image");
        Intrinsics.checkNotNullParameter(awards, "awards");
        return new QuestLine(i, i2, title, description, i3, i4, textProgress, i5, image, awards);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof QuestLine) {
            QuestLine questLine = (QuestLine) obj;
            return this.id == questLine.id && this.storyId == questLine.storyId && Intrinsics.areEqual(this.title, questLine.title) && Intrinsics.areEqual(this.description, questLine.description) && this.progress == questLine.progress && this.maxProgress == questLine.maxProgress && Intrinsics.areEqual(this.textProgress, questLine.textProgress) && this.hasReward == questLine.hasReward && Intrinsics.areEqual(this.image, questLine.image) && Intrinsics.areEqual(this.awards, questLine.awards);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((((Integer.hashCode(this.id) * 31) + Integer.hashCode(this.storyId)) * 31) + this.title.hashCode()) * 31) + this.description.hashCode()) * 31) + Integer.hashCode(this.progress)) * 31) + Integer.hashCode(this.maxProgress)) * 31) + this.textProgress.hashCode()) * 31) + Integer.hashCode(this.hasReward)) * 31) + this.image.hashCode()) * 31) + this.awards.hashCode();
    }

    public String toString() {
        int i = this.id;
        int i2 = this.storyId;
        String str = this.title;
        String str2 = this.description;
        int i3 = this.progress;
        int i4 = this.maxProgress;
        String str3 = this.textProgress;
        int i5 = this.hasReward;
        String str4 = this.image;
        return "QuestLine(id=" + i + ", storyId=" + i2 + ", title=" + str + ", description=" + str2 + ", progress=" + i3 + ", maxProgress=" + i4 + ", textProgress=" + str3 + ", hasReward=" + i5 + ", image=" + str4 + ", awards=" + this.awards + ")";
    }

    public QuestLine(int i, int i2, String title, String description, int i3, int i4, String textProgress, int i5, String image, ArrayList<QuestAwards> awards) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(textProgress, "textProgress");
        Intrinsics.checkNotNullParameter(image, "image");
        Intrinsics.checkNotNullParameter(awards, "awards");
        this.id = i;
        this.storyId = i2;
        this.title = title;
        this.description = description;
        this.progress = i3;
        this.maxProgress = i4;
        this.textProgress = textProgress;
        this.hasReward = i5;
        this.image = image;
        this.awards = awards;
    }

    public final int getId() {
        return this.id;
    }

    public final int getStoryId() {
        return this.storyId;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getDescription() {
        return this.description;
    }

    public final int getProgress() {
        return this.progress;
    }

    public final int getMaxProgress() {
        return this.maxProgress;
    }

    public final String getTextProgress() {
        return this.textProgress;
    }

    public final int getHasReward() {
        return this.hasReward;
    }

    public final String getImage() {
        return this.image;
    }

    public final ArrayList<QuestAwards> getAwards() {
        return this.awards;
    }
}
