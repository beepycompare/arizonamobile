package androidx.compose.foundation.text.input.internal;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: TransformedTextFieldState.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Landroidx/compose/foundation/text/input/internal/IndexTransformationType;", "", "(Ljava/lang/String;I)V", "Untransformed", "Insertion", "Replacement", "Deletion", "foundation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class IndexTransformationType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ IndexTransformationType[] $VALUES;
    public static final IndexTransformationType Untransformed = new IndexTransformationType("Untransformed", 0);
    public static final IndexTransformationType Insertion = new IndexTransformationType("Insertion", 1);
    public static final IndexTransformationType Replacement = new IndexTransformationType("Replacement", 2);
    public static final IndexTransformationType Deletion = new IndexTransformationType("Deletion", 3);

    private static final /* synthetic */ IndexTransformationType[] $values() {
        return new IndexTransformationType[]{Untransformed, Insertion, Replacement, Deletion};
    }

    public static EnumEntries<IndexTransformationType> getEntries() {
        return $ENTRIES;
    }

    public static IndexTransformationType valueOf(String str) {
        return (IndexTransformationType) Enum.valueOf(IndexTransformationType.class, str);
    }

    public static IndexTransformationType[] values() {
        return (IndexTransformationType[]) $VALUES.clone();
    }

    private IndexTransformationType(String str, int i) {
    }

    static {
        IndexTransformationType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
