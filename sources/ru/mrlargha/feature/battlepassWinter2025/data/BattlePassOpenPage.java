package ru.mrlargha.feature.battlepassWinter2025.data;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: BattlePassData.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lru/mrlargha/feature/battlepassWinter2025/data/BattlePassOpenPage;", "", "payload", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getPayload", "()Ljava/lang/String;", "Levels", "Tasks", "Companion", "battle-pass"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class BattlePassOpenPage {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ BattlePassOpenPage[] $VALUES;
    public static final Companion Companion;
    public static final BattlePassOpenPage Levels = new BattlePassOpenPage("Levels", 0, "levels");
    public static final BattlePassOpenPage Tasks = new BattlePassOpenPage("Tasks", 1, "tasks");
    private final String payload;

    private static final /* synthetic */ BattlePassOpenPage[] $values() {
        return new BattlePassOpenPage[]{Levels, Tasks};
    }

    public static EnumEntries<BattlePassOpenPage> getEntries() {
        return $ENTRIES;
    }

    public static BattlePassOpenPage valueOf(String str) {
        return (BattlePassOpenPage) Enum.valueOf(BattlePassOpenPage.class, str);
    }

    public static BattlePassOpenPage[] values() {
        return (BattlePassOpenPage[]) $VALUES.clone();
    }

    private BattlePassOpenPage(String str, int i, String str2) {
        this.payload = str2;
    }

    public final String getPayload() {
        return this.payload;
    }

    static {
        BattlePassOpenPage[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
        Companion = new Companion(null);
    }

    /* compiled from: BattlePassData.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lru/mrlargha/feature/battlepassWinter2025/data/BattlePassOpenPage$Companion;", "", "<init>", "()V", "fromPayload", "Lru/mrlargha/feature/battlepassWinter2025/data/BattlePassOpenPage;", "payload", "", "battle-pass"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final BattlePassOpenPage fromPayload(String payload) {
            Object obj;
            Intrinsics.checkNotNullParameter(payload, "payload");
            Iterator<E> it = BattlePassOpenPage.getEntries().iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (Intrinsics.areEqual(((BattlePassOpenPage) obj).getPayload(), payload)) {
                    break;
                }
            }
            return (BattlePassOpenPage) obj;
        }
    }
}
