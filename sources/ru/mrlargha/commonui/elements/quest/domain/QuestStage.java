package ru.mrlargha.commonui.elements.quest.domain;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: QuestResponses.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J;\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u001d"}, d2 = {"Lru/mrlargha/commonui/elements/quest/domain/QuestStage;", "", "id", "", "title", "", "description", "progress", "maxProgress", "<init>", "(ILjava/lang/String;Ljava/lang/String;II)V", "getId", "()I", "getTitle", "()Ljava/lang/String;", "getDescription", "getProgress", "getMaxProgress", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class QuestStage {
    private final String description;
    private final int id;
    private final int maxProgress;
    private final int progress;
    private final String title;

    public static /* synthetic */ QuestStage copy$default(QuestStage questStage, int i, String str, String str2, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = questStage.id;
        }
        if ((i4 & 2) != 0) {
            str = questStage.title;
        }
        if ((i4 & 4) != 0) {
            str2 = questStage.description;
        }
        if ((i4 & 8) != 0) {
            i2 = questStage.progress;
        }
        if ((i4 & 16) != 0) {
            i3 = questStage.maxProgress;
        }
        int i5 = i3;
        String str3 = str2;
        return questStage.copy(i, str, str3, i2, i5);
    }

    public final int component1() {
        return this.id;
    }

    public final String component2() {
        return this.title;
    }

    public final String component3() {
        return this.description;
    }

    public final int component4() {
        return this.progress;
    }

    public final int component5() {
        return this.maxProgress;
    }

    public final QuestStage copy(int i, String title, String description, int i2, int i3) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(description, "description");
        return new QuestStage(i, title, description, i2, i3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof QuestStage) {
            QuestStage questStage = (QuestStage) obj;
            return this.id == questStage.id && Intrinsics.areEqual(this.title, questStage.title) && Intrinsics.areEqual(this.description, questStage.description) && this.progress == questStage.progress && this.maxProgress == questStage.maxProgress;
        }
        return false;
    }

    public int hashCode() {
        return (((((((Integer.hashCode(this.id) * 31) + this.title.hashCode()) * 31) + this.description.hashCode()) * 31) + Integer.hashCode(this.progress)) * 31) + Integer.hashCode(this.maxProgress);
    }

    public String toString() {
        int i = this.id;
        String str = this.title;
        String str2 = this.description;
        int i2 = this.progress;
        return "QuestStage(id=" + i + ", title=" + str + ", description=" + str2 + ", progress=" + i2 + ", maxProgress=" + this.maxProgress + ")";
    }

    public QuestStage(int i, String title, String description, int i2, int i3) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(description, "description");
        this.id = i;
        this.title = title;
        this.description = description;
        this.progress = i2;
        this.maxProgress = i3;
    }

    public final int getId() {
        return this.id;
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
}
