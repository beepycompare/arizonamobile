package ru.mrlargha.commonui.elements.battlepassWinter2025.data;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: CommonTaskInfo.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lru/mrlargha/commonui/elements/battlepassWinter2025/data/CategoryType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "DAILY", "LONG", "SHOP", "PREMIUM", "Companion", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CategoryType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ CategoryType[] $VALUES;
    public static final Companion Companion;
    private final int value;
    public static final CategoryType DAILY = new CategoryType("DAILY", 0, 1);
    public static final CategoryType LONG = new CategoryType("LONG", 1, 2);
    public static final CategoryType SHOP = new CategoryType("SHOP", 2, 3);
    public static final CategoryType PREMIUM = new CategoryType("PREMIUM", 3, 4);

    private static final /* synthetic */ CategoryType[] $values() {
        return new CategoryType[]{DAILY, LONG, SHOP, PREMIUM};
    }

    public static EnumEntries<CategoryType> getEntries() {
        return $ENTRIES;
    }

    public static CategoryType valueOf(String str) {
        return (CategoryType) Enum.valueOf(CategoryType.class, str);
    }

    public static CategoryType[] values() {
        return (CategoryType[]) $VALUES.clone();
    }

    private CategoryType(String str, int i, int i2) {
        this.value = i2;
    }

    public final int getValue() {
        return this.value;
    }

    static {
        CategoryType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
        Companion = new Companion(null);
    }

    /* compiled from: CommonTaskInfo.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lru/mrlargha/commonui/elements/battlepassWinter2025/data/CategoryType$Companion;", "", "<init>", "()V", "fromCategoryId", "Lru/mrlargha/commonui/elements/battlepassWinter2025/data/CategoryType;", "value", "", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final CategoryType fromCategoryId(int i) {
            for (CategoryType categoryType : CategoryType.getEntries()) {
                if (categoryType.getValue() == i) {
                    return categoryType;
                }
            }
            throw new NoSuchElementException("Collection contains no element matching the predicate.");
        }
    }
}
