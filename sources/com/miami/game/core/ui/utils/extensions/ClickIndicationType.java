package com.miami.game.core.ui.utils.extensions;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: ClickIndicationType.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/miami/game/core/ui/utils/extensions/ClickIndicationType;", "", "<init>", "(Ljava/lang/String;I)V", "NO_INDICATION", "INFINITE_ROUND", "THEMED", "ui-utils_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ClickIndicationType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ClickIndicationType[] $VALUES;
    public static final ClickIndicationType NO_INDICATION = new ClickIndicationType("NO_INDICATION", 0);
    public static final ClickIndicationType INFINITE_ROUND = new ClickIndicationType("INFINITE_ROUND", 1);
    public static final ClickIndicationType THEMED = new ClickIndicationType("THEMED", 2);

    private static final /* synthetic */ ClickIndicationType[] $values() {
        return new ClickIndicationType[]{NO_INDICATION, INFINITE_ROUND, THEMED};
    }

    public static EnumEntries<ClickIndicationType> getEntries() {
        return $ENTRIES;
    }

    private ClickIndicationType(String str, int i) {
    }

    static {
        ClickIndicationType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static ClickIndicationType valueOf(String str) {
        return (ClickIndicationType) Enum.valueOf(ClickIndicationType.class, str);
    }

    public static ClickIndicationType[] values() {
        return (ClickIndicationType[]) $VALUES.clone();
    }
}
