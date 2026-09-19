package ru.mrlargha.commonui.core.cache;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: UIElementEvictionReason.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lru/mrlargha/commonui/core/cache/UIElementEvictionReason;", "", "<init>", "(Ljava/lang/String;I)V", "HIDE_TIMEOUT", "CAPACITY", "MEMORY_PRESSURE", "EXPLICIT", "HOST_DESTROY", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class UIElementEvictionReason {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ UIElementEvictionReason[] $VALUES;
    public static final UIElementEvictionReason HIDE_TIMEOUT = new UIElementEvictionReason("HIDE_TIMEOUT", 0);
    public static final UIElementEvictionReason CAPACITY = new UIElementEvictionReason("CAPACITY", 1);
    public static final UIElementEvictionReason MEMORY_PRESSURE = new UIElementEvictionReason("MEMORY_PRESSURE", 2);
    public static final UIElementEvictionReason EXPLICIT = new UIElementEvictionReason("EXPLICIT", 3);
    public static final UIElementEvictionReason HOST_DESTROY = new UIElementEvictionReason("HOST_DESTROY", 4);

    private static final /* synthetic */ UIElementEvictionReason[] $values() {
        return new UIElementEvictionReason[]{HIDE_TIMEOUT, CAPACITY, MEMORY_PRESSURE, EXPLICIT, HOST_DESTROY};
    }

    public static EnumEntries<UIElementEvictionReason> getEntries() {
        return $ENTRIES;
    }

    public static UIElementEvictionReason valueOf(String str) {
        return (UIElementEvictionReason) Enum.valueOf(UIElementEvictionReason.class, str);
    }

    public static UIElementEvictionReason[] values() {
        return (UIElementEvictionReason[]) $VALUES.clone();
    }

    private UIElementEvictionReason(String str, int i) {
    }

    static {
        UIElementEvictionReason[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
