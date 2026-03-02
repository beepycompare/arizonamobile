package androidx.paging;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: PagingDataPresenter.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Landroidx/paging/DiffingChangePayload;", "", "<init>", "(Ljava/lang/String;I)V", "ITEM_TO_PLACEHOLDER", "PLACEHOLDER_TO_ITEM", "PLACEHOLDER_POSITION_CHANGE", "paging-common"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DiffingChangePayload {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ DiffingChangePayload[] $VALUES;
    public static final DiffingChangePayload ITEM_TO_PLACEHOLDER = new DiffingChangePayload("ITEM_TO_PLACEHOLDER", 0);
    public static final DiffingChangePayload PLACEHOLDER_TO_ITEM = new DiffingChangePayload("PLACEHOLDER_TO_ITEM", 1);
    public static final DiffingChangePayload PLACEHOLDER_POSITION_CHANGE = new DiffingChangePayload("PLACEHOLDER_POSITION_CHANGE", 2);

    private static final /* synthetic */ DiffingChangePayload[] $values() {
        return new DiffingChangePayload[]{ITEM_TO_PLACEHOLDER, PLACEHOLDER_TO_ITEM, PLACEHOLDER_POSITION_CHANGE};
    }

    public static EnumEntries<DiffingChangePayload> getEntries() {
        return $ENTRIES;
    }

    public static DiffingChangePayload valueOf(String str) {
        return (DiffingChangePayload) Enum.valueOf(DiffingChangePayload.class, str);
    }

    public static DiffingChangePayload[] values() {
        return (DiffingChangePayload[]) $VALUES.clone();
    }

    private DiffingChangePayload(String str, int i) {
    }

    static {
        DiffingChangePayload[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
