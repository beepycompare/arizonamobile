package ru.mrlargha.commonui.domain.db.inventory;

import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: InventoryItemEntity.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lru/mrlargha/commonui/domain/db/inventory/InventoryEffectType;", "", TtmlNode.ATTR_ID, "", "<init>", "(Ljava/lang/String;II)V", "getId", "()I", "BACKGROUND", "BACKGROUND_TOP", "FOREGROUND", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class InventoryEffectType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ InventoryEffectType[] $VALUES;
    public static final InventoryEffectType BACKGROUND = new InventoryEffectType("BACKGROUND", 0, 0);
    public static final InventoryEffectType BACKGROUND_TOP = new InventoryEffectType("BACKGROUND_TOP", 1, 1);
    public static final InventoryEffectType FOREGROUND = new InventoryEffectType("FOREGROUND", 2, 2);
    private final int id;

    private static final /* synthetic */ InventoryEffectType[] $values() {
        return new InventoryEffectType[]{BACKGROUND, BACKGROUND_TOP, FOREGROUND};
    }

    public static EnumEntries<InventoryEffectType> getEntries() {
        return $ENTRIES;
    }

    public static InventoryEffectType valueOf(String str) {
        return (InventoryEffectType) Enum.valueOf(InventoryEffectType.class, str);
    }

    public static InventoryEffectType[] values() {
        return (InventoryEffectType[]) $VALUES.clone();
    }

    private InventoryEffectType(String str, int i, int i2) {
        this.id = i2;
    }

    public final int getId() {
        return this.id;
    }

    static {
        InventoryEffectType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
