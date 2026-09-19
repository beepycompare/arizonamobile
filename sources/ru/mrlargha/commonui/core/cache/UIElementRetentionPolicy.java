package ru.mrlargha.commonui.core.cache;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: UIElementRetentionPolicy.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lru/mrlargha/commonui/core/cache/UIElementRetentionPolicy;", "", "<init>", "(Ljava/lang/String;I)V", "PINNED", "SESSION_HOTSET", "DISPOSE_ON_HIDE", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class UIElementRetentionPolicy {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ UIElementRetentionPolicy[] $VALUES;
    public static final UIElementRetentionPolicy PINNED = new UIElementRetentionPolicy("PINNED", 0);
    public static final UIElementRetentionPolicy SESSION_HOTSET = new UIElementRetentionPolicy("SESSION_HOTSET", 1);
    public static final UIElementRetentionPolicy DISPOSE_ON_HIDE = new UIElementRetentionPolicy("DISPOSE_ON_HIDE", 2);

    private static final /* synthetic */ UIElementRetentionPolicy[] $values() {
        return new UIElementRetentionPolicy[]{PINNED, SESSION_HOTSET, DISPOSE_ON_HIDE};
    }

    public static EnumEntries<UIElementRetentionPolicy> getEntries() {
        return $ENTRIES;
    }

    public static UIElementRetentionPolicy valueOf(String str) {
        return (UIElementRetentionPolicy) Enum.valueOf(UIElementRetentionPolicy.class, str);
    }

    public static UIElementRetentionPolicy[] values() {
        return (UIElementRetentionPolicy[]) $VALUES.clone();
    }

    private UIElementRetentionPolicy(String str, int i) {
    }

    static {
        UIElementRetentionPolicy[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
