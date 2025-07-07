package com.arkivanov.decompose.router.panels;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: ChildPanelsMode.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/arkivanov/decompose/router/panels/ChildPanelsMode;", "", "<init>", "(Ljava/lang/String;I)V", "SINGLE", "DUAL", "TRIPLE", "decompose_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ChildPanelsMode {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ChildPanelsMode[] $VALUES;
    public static final ChildPanelsMode SINGLE = new ChildPanelsMode("SINGLE", 0);
    public static final ChildPanelsMode DUAL = new ChildPanelsMode("DUAL", 1);
    public static final ChildPanelsMode TRIPLE = new ChildPanelsMode("TRIPLE", 2);

    private static final /* synthetic */ ChildPanelsMode[] $values() {
        return new ChildPanelsMode[]{SINGLE, DUAL, TRIPLE};
    }

    public static EnumEntries<ChildPanelsMode> getEntries() {
        return $ENTRIES;
    }

    private ChildPanelsMode(String str, int i) {
    }

    static {
        ChildPanelsMode[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static ChildPanelsMode valueOf(String str) {
        return (ChildPanelsMode) Enum.valueOf(ChildPanelsMode.class, str);
    }

    public static ChildPanelsMode[] values() {
        return (ChildPanelsMode[]) $VALUES.clone();
    }
}
