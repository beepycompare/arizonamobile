package ru.mrlargha.commonui.elements.quest;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: QuestData.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J7\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001d"}, d2 = {"Lru/mrlargha/commonui/elements/quest/QuestData;", "Lru/mrlargha/commonui/elements/quest/RodinaSerializableData;", "questName", "", "npcName", "npcText", "answers", "", "Lru/mrlargha/commonui/elements/quest/QuestAnswer;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getQuestName", "()Ljava/lang/String;", "getNpcName", "getNpcText", "getAnswers", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class QuestData implements RodinaSerializableData {
    private final List<QuestAnswer> answers;
    private final String npcName;
    private final String npcText;
    private final String questName;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ QuestData copy$default(QuestData questData, String str, String str2, String str3, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = questData.questName;
        }
        if ((i & 2) != 0) {
            str2 = questData.npcName;
        }
        if ((i & 4) != 0) {
            str3 = questData.npcText;
        }
        if ((i & 8) != 0) {
            list = questData.answers;
        }
        return questData.copy(str, str2, str3, list);
    }

    public final String component1() {
        return this.questName;
    }

    public final String component2() {
        return this.npcName;
    }

    public final String component3() {
        return this.npcText;
    }

    public final List<QuestAnswer> component4() {
        return this.answers;
    }

    public final QuestData copy(String questName, String npcName, String npcText, List<QuestAnswer> answers) {
        Intrinsics.checkNotNullParameter(questName, "questName");
        Intrinsics.checkNotNullParameter(npcName, "npcName");
        Intrinsics.checkNotNullParameter(npcText, "npcText");
        Intrinsics.checkNotNullParameter(answers, "answers");
        return new QuestData(questName, npcName, npcText, answers);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof QuestData) {
            QuestData questData = (QuestData) obj;
            return Intrinsics.areEqual(this.questName, questData.questName) && Intrinsics.areEqual(this.npcName, questData.npcName) && Intrinsics.areEqual(this.npcText, questData.npcText) && Intrinsics.areEqual(this.answers, questData.answers);
        }
        return false;
    }

    public int hashCode() {
        return (((((this.questName.hashCode() * 31) + this.npcName.hashCode()) * 31) + this.npcText.hashCode()) * 31) + this.answers.hashCode();
    }

    public String toString() {
        String str = this.questName;
        String str2 = this.npcName;
        String str3 = this.npcText;
        return "QuestData(questName=" + str + ", npcName=" + str2 + ", npcText=" + str3 + ", answers=" + this.answers + ")";
    }

    public QuestData(String questName, String npcName, String npcText, List<QuestAnswer> answers) {
        Intrinsics.checkNotNullParameter(questName, "questName");
        Intrinsics.checkNotNullParameter(npcName, "npcName");
        Intrinsics.checkNotNullParameter(npcText, "npcText");
        Intrinsics.checkNotNullParameter(answers, "answers");
        this.questName = questName;
        this.npcName = npcName;
        this.npcText = npcText;
        this.answers = answers;
    }

    public final String getQuestName() {
        return this.questName;
    }

    public final String getNpcName() {
        return this.npcName;
    }

    public final String getNpcText() {
        return this.npcText;
    }

    public final List<QuestAnswer> getAnswers() {
        return this.answers;
    }
}
