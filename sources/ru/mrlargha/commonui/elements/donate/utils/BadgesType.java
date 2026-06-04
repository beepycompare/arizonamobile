package ru.mrlargha.commonui.elements.donate.utils;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: DonateUtils.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lru/mrlargha/commonui/elements/donate/utils/BadgesType;", "", "type", "", "<init>", "(Ljava/lang/String;II)V", "getType", "()I", "DEFAULT", "TIME", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class BadgesType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ BadgesType[] $VALUES;
    public static final BadgesType DEFAULT = new BadgesType("DEFAULT", 0, 0);
    public static final BadgesType TIME = new BadgesType("TIME", 1, 1);
    private final int type;

    private static final /* synthetic */ BadgesType[] $values() {
        return new BadgesType[]{DEFAULT, TIME};
    }

    public static EnumEntries<BadgesType> getEntries() {
        return $ENTRIES;
    }

    public static BadgesType valueOf(String str) {
        return (BadgesType) Enum.valueOf(BadgesType.class, str);
    }

    public static BadgesType[] values() {
        return (BadgesType[]) $VALUES.clone();
    }

    private BadgesType(String str, int i, int i2) {
        this.type = i2;
    }

    public final int getType() {
        return this.type;
    }

    static {
        BadgesType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
