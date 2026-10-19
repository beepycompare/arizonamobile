package com.arizona.launcher.updater.archive.orchestrator;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: EngineResourceGenerationStore.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/EngineResourceGenerationAction;", "", "<init>", "(Ljava/lang/String;I)V", "UP_TO_DATE", "RESUME", "MIGRATE", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class EngineResourceGenerationAction {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ EngineResourceGenerationAction[] $VALUES;
    public static final EngineResourceGenerationAction UP_TO_DATE = new EngineResourceGenerationAction("UP_TO_DATE", 0);
    public static final EngineResourceGenerationAction RESUME = new EngineResourceGenerationAction("RESUME", 1);
    public static final EngineResourceGenerationAction MIGRATE = new EngineResourceGenerationAction("MIGRATE", 2);

    private static final /* synthetic */ EngineResourceGenerationAction[] $values() {
        return new EngineResourceGenerationAction[]{UP_TO_DATE, RESUME, MIGRATE};
    }

    public static EnumEntries<EngineResourceGenerationAction> getEntries() {
        return $ENTRIES;
    }

    public static EngineResourceGenerationAction valueOf(String str) {
        return (EngineResourceGenerationAction) Enum.valueOf(EngineResourceGenerationAction.class, str);
    }

    public static EngineResourceGenerationAction[] values() {
        return (EngineResourceGenerationAction[]) $VALUES.clone();
    }

    private EngineResourceGenerationAction(String str, int i) {
    }

    static {
        EngineResourceGenerationAction[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
