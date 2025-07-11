package ru.mrlargha.commonui.elements.donate.presentation.models;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: DonateItemModelUi.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lru/mrlargha/commonui/elements/donate/presentation/models/DonateBlockType;", "", "type", "", "<init>", "(Ljava/lang/String;II)V", "getType", "()I", "CIRCLE", "LOCK", "NONE", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DonateBlockType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ DonateBlockType[] $VALUES;
    public static final DonateBlockType CIRCLE = new DonateBlockType("CIRCLE", 0, 0);
    public static final DonateBlockType LOCK = new DonateBlockType("LOCK", 1, 1);
    public static final DonateBlockType NONE = new DonateBlockType("NONE", 2, 2);
    private final int type;

    private static final /* synthetic */ DonateBlockType[] $values() {
        return new DonateBlockType[]{CIRCLE, LOCK, NONE};
    }

    public static EnumEntries<DonateBlockType> getEntries() {
        return $ENTRIES;
    }

    public static DonateBlockType valueOf(String str) {
        return (DonateBlockType) Enum.valueOf(DonateBlockType.class, str);
    }

    public static DonateBlockType[] values() {
        return (DonateBlockType[]) $VALUES.clone();
    }

    private DonateBlockType(String str, int i, int i2) {
        this.type = i2;
    }

    public final int getType() {
        return this.type;
    }

    static {
        DonateBlockType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
