package ru.mrlargha.arizonaui.documents.data;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: DocumentsBites.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lru/mrlargha/arizonaui/documents/data/DocumentsBites;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "Main", "Licenses", "Health", "Army", "Property", "Transport", "Vip", "ArizonaUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DocumentsBites {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ DocumentsBites[] $VALUES;
    private final int value;
    public static final DocumentsBites Main = new DocumentsBites("Main", 0, 1);
    public static final DocumentsBites Licenses = new DocumentsBites("Licenses", 1, 2);
    public static final DocumentsBites Health = new DocumentsBites("Health", 2, 4);
    public static final DocumentsBites Army = new DocumentsBites("Army", 3, 8);
    public static final DocumentsBites Property = new DocumentsBites("Property", 4, 16);
    public static final DocumentsBites Transport = new DocumentsBites("Transport", 5, 32);
    public static final DocumentsBites Vip = new DocumentsBites("Vip", 6, 64);

    private static final /* synthetic */ DocumentsBites[] $values() {
        return new DocumentsBites[]{Main, Licenses, Health, Army, Property, Transport, Vip};
    }

    public static EnumEntries<DocumentsBites> getEntries() {
        return $ENTRIES;
    }

    public static DocumentsBites valueOf(String str) {
        return (DocumentsBites) Enum.valueOf(DocumentsBites.class, str);
    }

    public static DocumentsBites[] values() {
        return (DocumentsBites[]) $VALUES.clone();
    }

    private DocumentsBites(String str, int i, int i2) {
        this.value = i2;
    }

    public final int getValue() {
        return this.value;
    }

    static {
        DocumentsBites[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
