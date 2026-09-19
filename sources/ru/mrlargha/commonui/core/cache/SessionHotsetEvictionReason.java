package ru.mrlargha.commonui.core.cache;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: SessionHotsetPolicy.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lru/mrlargha/commonui/core/cache/SessionHotsetEvictionReason;", "", "<init>", "(Ljava/lang/String;I)V", "TTL", "CAPACITY", "MEMORY_PRESSURE", "EXPLICIT", "HOST_DESTROY", "REPLACED", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class SessionHotsetEvictionReason {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ SessionHotsetEvictionReason[] $VALUES;
    public static final SessionHotsetEvictionReason TTL = new SessionHotsetEvictionReason("TTL", 0);
    public static final SessionHotsetEvictionReason CAPACITY = new SessionHotsetEvictionReason("CAPACITY", 1);
    public static final SessionHotsetEvictionReason MEMORY_PRESSURE = new SessionHotsetEvictionReason("MEMORY_PRESSURE", 2);
    public static final SessionHotsetEvictionReason EXPLICIT = new SessionHotsetEvictionReason("EXPLICIT", 3);
    public static final SessionHotsetEvictionReason HOST_DESTROY = new SessionHotsetEvictionReason("HOST_DESTROY", 4);
    public static final SessionHotsetEvictionReason REPLACED = new SessionHotsetEvictionReason("REPLACED", 5);

    private static final /* synthetic */ SessionHotsetEvictionReason[] $values() {
        return new SessionHotsetEvictionReason[]{TTL, CAPACITY, MEMORY_PRESSURE, EXPLICIT, HOST_DESTROY, REPLACED};
    }

    public static EnumEntries<SessionHotsetEvictionReason> getEntries() {
        return $ENTRIES;
    }

    public static SessionHotsetEvictionReason valueOf(String str) {
        return (SessionHotsetEvictionReason) Enum.valueOf(SessionHotsetEvictionReason.class, str);
    }

    public static SessionHotsetEvictionReason[] values() {
        return (SessionHotsetEvictionReason[]) $VALUES.clone();
    }

    private SessionHotsetEvictionReason(String str, int i) {
    }

    static {
        SessionHotsetEvictionReason[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
