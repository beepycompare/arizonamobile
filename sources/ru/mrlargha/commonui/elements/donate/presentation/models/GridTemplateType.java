package ru.mrlargha.commonui.elements.donate.presentation.models;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: DonateCategoryModelUi.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lru/mrlargha/commonui/elements/donate/presentation/models/GridTemplateType;", "", "type", "", "<init>", "(Ljava/lang/String;II)V", "getType", "()I", "MAIN", "GRID", "ROW", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GridTemplateType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ GridTemplateType[] $VALUES;
    private final int type;
    public static final GridTemplateType MAIN = new GridTemplateType("MAIN", 0, -1);
    public static final GridTemplateType GRID = new GridTemplateType("GRID", 1, 0);
    public static final GridTemplateType ROW = new GridTemplateType("ROW", 2, 1);

    private static final /* synthetic */ GridTemplateType[] $values() {
        return new GridTemplateType[]{MAIN, GRID, ROW};
    }

    public static EnumEntries<GridTemplateType> getEntries() {
        return $ENTRIES;
    }

    public static GridTemplateType valueOf(String str) {
        return (GridTemplateType) Enum.valueOf(GridTemplateType.class, str);
    }

    public static GridTemplateType[] values() {
        return (GridTemplateType[]) $VALUES.clone();
    }

    private GridTemplateType(String str, int i, int i2) {
        this.type = i2;
    }

    public final int getType() {
        return this.type;
    }

    static {
        GridTemplateType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
