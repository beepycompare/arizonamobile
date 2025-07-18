package ru.mrlargha.commonui.elements.authorization.domain.recovery;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: RecoveryMethodType.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lru/mrlargha/commonui/elements/authorization/domain/recovery/RecoveryMethodType;", "", "id", "", "<init>", "(Ljava/lang/String;II)V", "getId", "()I", "MAIL", "VK", "TELEGRAM", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RecoveryMethodType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ RecoveryMethodType[] $VALUES;
    private final int id;
    public static final RecoveryMethodType MAIL = new RecoveryMethodType("MAIL", 0, 0);
    public static final RecoveryMethodType VK = new RecoveryMethodType("VK", 1, 1);
    public static final RecoveryMethodType TELEGRAM = new RecoveryMethodType("TELEGRAM", 2, 2);

    private static final /* synthetic */ RecoveryMethodType[] $values() {
        return new RecoveryMethodType[]{MAIL, VK, TELEGRAM};
    }

    public static EnumEntries<RecoveryMethodType> getEntries() {
        return $ENTRIES;
    }

    public static RecoveryMethodType valueOf(String str) {
        return (RecoveryMethodType) Enum.valueOf(RecoveryMethodType.class, str);
    }

    public static RecoveryMethodType[] values() {
        return (RecoveryMethodType[]) $VALUES.clone();
    }

    private RecoveryMethodType(String str, int i, int i2) {
        this.id = i2;
    }

    public final int getId() {
        return this.id;
    }

    static {
        RecoveryMethodType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
