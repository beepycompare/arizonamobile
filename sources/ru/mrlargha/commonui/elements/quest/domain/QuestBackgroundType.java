package ru.mrlargha.commonui.elements.quest.domain;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: QuestBackgroundType.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000eB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000f"}, d2 = {"Lru/mrlargha/commonui/elements/quest/domain/QuestBackgroundType;", "", "type", "", "<init>", "(Ljava/lang/String;II)V", "getType", "()I", "NIGHT_OF_JUDGMENT", "RODINA_BIRTHDAY", "HALLOWEEN", "HALLOWEEN_DARK", "NEW_YEAR", "BUSINESS", "Companion", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class QuestBackgroundType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ QuestBackgroundType[] $VALUES;
    public static final Companion Companion;
    private final int type;
    public static final QuestBackgroundType NIGHT_OF_JUDGMENT = new QuestBackgroundType("NIGHT_OF_JUDGMENT", 0, 0);
    public static final QuestBackgroundType RODINA_BIRTHDAY = new QuestBackgroundType("RODINA_BIRTHDAY", 1, 1);
    public static final QuestBackgroundType HALLOWEEN = new QuestBackgroundType("HALLOWEEN", 2, 2);
    public static final QuestBackgroundType HALLOWEEN_DARK = new QuestBackgroundType("HALLOWEEN_DARK", 3, 3);
    public static final QuestBackgroundType NEW_YEAR = new QuestBackgroundType("NEW_YEAR", 4, 4);
    public static final QuestBackgroundType BUSINESS = new QuestBackgroundType("BUSINESS", 5, 5);

    private static final /* synthetic */ QuestBackgroundType[] $values() {
        return new QuestBackgroundType[]{NIGHT_OF_JUDGMENT, RODINA_BIRTHDAY, HALLOWEEN, HALLOWEEN_DARK, NEW_YEAR, BUSINESS};
    }

    public static EnumEntries<QuestBackgroundType> getEntries() {
        return $ENTRIES;
    }

    private QuestBackgroundType(String str, int i, int i2) {
        this.type = i2;
    }

    public final int getType() {
        return this.type;
    }

    static {
        QuestBackgroundType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
        Companion = new Companion(null);
    }

    /* compiled from: QuestBackgroundType.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lru/mrlargha/commonui/elements/quest/domain/QuestBackgroundType$Companion;", "", "<init>", "()V", "fromQuestType", "Lru/mrlargha/commonui/elements/quest/domain/QuestBackgroundType;", "type", "", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final QuestBackgroundType fromQuestType(int i) {
            Object obj;
            Iterator<E> it = QuestBackgroundType.getEntries().iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (((QuestBackgroundType) obj).getType() == i) {
                    break;
                }
            }
            QuestBackgroundType questBackgroundType = (QuestBackgroundType) obj;
            return questBackgroundType == null ? QuestBackgroundType.NIGHT_OF_JUDGMENT : questBackgroundType;
        }
    }

    public static QuestBackgroundType valueOf(String str) {
        return (QuestBackgroundType) Enum.valueOf(QuestBackgroundType.class, str);
    }

    public static QuestBackgroundType[] values() {
        return (QuestBackgroundType[]) $VALUES.clone();
    }
}
