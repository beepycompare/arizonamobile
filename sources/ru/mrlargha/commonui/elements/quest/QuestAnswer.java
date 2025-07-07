package ru.mrlargha.commonui.elements.quest;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: QuestData.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lru/mrlargha/commonui/elements/quest/QuestAnswer;", "Lru/mrlargha/commonui/elements/quest/RodinaSerializableData;", "emoji", "", "text", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getEmoji", "()Ljava/lang/String;", "getText", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class QuestAnswer implements RodinaSerializableData {
    private final String emoji;
    private final String text;

    public static /* synthetic */ QuestAnswer copy$default(QuestAnswer questAnswer, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = questAnswer.emoji;
        }
        if ((i & 2) != 0) {
            str2 = questAnswer.text;
        }
        return questAnswer.copy(str, str2);
    }

    public final String component1() {
        return this.emoji;
    }

    public final String component2() {
        return this.text;
    }

    public final QuestAnswer copy(String emoji, String text) {
        Intrinsics.checkNotNullParameter(emoji, "emoji");
        Intrinsics.checkNotNullParameter(text, "text");
        return new QuestAnswer(emoji, text);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof QuestAnswer) {
            QuestAnswer questAnswer = (QuestAnswer) obj;
            return Intrinsics.areEqual(this.emoji, questAnswer.emoji) && Intrinsics.areEqual(this.text, questAnswer.text);
        }
        return false;
    }

    public int hashCode() {
        return (this.emoji.hashCode() * 31) + this.text.hashCode();
    }

    public String toString() {
        String str = this.emoji;
        return "QuestAnswer(emoji=" + str + ", text=" + this.text + ")";
    }

    public QuestAnswer(String emoji, String text) {
        Intrinsics.checkNotNullParameter(emoji, "emoji");
        Intrinsics.checkNotNullParameter(text, "text");
        this.emoji = emoji;
        this.text = text;
    }

    public final String getEmoji() {
        return this.emoji;
    }

    public final String getText() {
        return this.text;
    }
}
