package ru.mrlargha.commonui.elements.quest;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Quest.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lru/mrlargha/commonui/elements/quest/QuestAwards;", "", "title", "", "icon", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getTitle", "()Ljava/lang/String;", "getIcon", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class QuestAwards {
    private final String icon;
    private final String title;

    public static /* synthetic */ QuestAwards copy$default(QuestAwards questAwards, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = questAwards.title;
        }
        if ((i & 2) != 0) {
            str2 = questAwards.icon;
        }
        return questAwards.copy(str, str2);
    }

    public final String component1() {
        return this.title;
    }

    public final String component2() {
        return this.icon;
    }

    public final QuestAwards copy(String title, String icon) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(icon, "icon");
        return new QuestAwards(title, icon);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof QuestAwards) {
            QuestAwards questAwards = (QuestAwards) obj;
            return Intrinsics.areEqual(this.title, questAwards.title) && Intrinsics.areEqual(this.icon, questAwards.icon);
        }
        return false;
    }

    public int hashCode() {
        return (this.title.hashCode() * 31) + this.icon.hashCode();
    }

    public String toString() {
        String str = this.title;
        return "QuestAwards(title=" + str + ", icon=" + this.icon + ")";
    }

    public QuestAwards(String title, String icon) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(icon, "icon");
        this.title = title;
        this.icon = icon;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getIcon() {
        return this.icon;
    }
}
