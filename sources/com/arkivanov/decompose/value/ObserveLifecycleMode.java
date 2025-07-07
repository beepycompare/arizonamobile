package com.arkivanov.decompose.value;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: ValueExt.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/arkivanov/decompose/value/ObserveLifecycleMode;", "", "<init>", "(Ljava/lang/String;I)V", "CREATE_DESTROY", "START_STOP", "RESUME_PAUSE", "decompose_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ObserveLifecycleMode {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ObserveLifecycleMode[] $VALUES;
    public static final ObserveLifecycleMode CREATE_DESTROY = new ObserveLifecycleMode("CREATE_DESTROY", 0);
    public static final ObserveLifecycleMode START_STOP = new ObserveLifecycleMode("START_STOP", 1);
    public static final ObserveLifecycleMode RESUME_PAUSE = new ObserveLifecycleMode("RESUME_PAUSE", 2);

    private static final /* synthetic */ ObserveLifecycleMode[] $values() {
        return new ObserveLifecycleMode[]{CREATE_DESTROY, START_STOP, RESUME_PAUSE};
    }

    public static EnumEntries<ObserveLifecycleMode> getEntries() {
        return $ENTRIES;
    }

    private ObserveLifecycleMode(String str, int i) {
    }

    static {
        ObserveLifecycleMode[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static ObserveLifecycleMode valueOf(String str) {
        return (ObserveLifecycleMode) Enum.valueOf(ObserveLifecycleMode.class, str);
    }

    public static ObserveLifecycleMode[] values() {
        return (ObserveLifecycleMode[]) $VALUES.clone();
    }
}
