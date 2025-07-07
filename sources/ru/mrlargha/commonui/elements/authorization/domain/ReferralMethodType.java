package ru.mrlargha.commonui.elements.authorization.domain;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: ReferralMethodType.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lru/mrlargha/commonui/elements/authorization/domain/ReferralMethodType;", "", "id", "", "<init>", "(Ljava/lang/String;II)V", "getId", "()I", "FRIENDS", "SEARCH", "FORUMS", "OTHER", "Companion", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ReferralMethodType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ReferralMethodType[] $VALUES;
    public static final Companion Companion;
    private static final Map<Integer, ReferralMethodType> map;
    private final int id;
    public static final ReferralMethodType FRIENDS = new ReferralMethodType("FRIENDS", 0, 0);
    public static final ReferralMethodType SEARCH = new ReferralMethodType("SEARCH", 1, 1);
    public static final ReferralMethodType FORUMS = new ReferralMethodType("FORUMS", 2, 2);
    public static final ReferralMethodType OTHER = new ReferralMethodType("OTHER", 3, 3);

    private static final /* synthetic */ ReferralMethodType[] $values() {
        return new ReferralMethodType[]{FRIENDS, SEARCH, FORUMS, OTHER};
    }

    public static EnumEntries<ReferralMethodType> getEntries() {
        return $ENTRIES;
    }

    private ReferralMethodType(String str, int i, int i2) {
        this.id = i2;
    }

    public final int getId() {
        return this.id;
    }

    static {
        ReferralMethodType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
        Companion = new Companion(null);
        ReferralMethodType[] values = values();
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(values.length), 16));
        for (ReferralMethodType referralMethodType : values) {
            linkedHashMap.put(Integer.valueOf(referralMethodType.id), referralMethodType);
        }
        map = linkedHashMap;
    }

    /* compiled from: ReferralMethodType.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\u0006H\u0086\u0002R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lru/mrlargha/commonui/elements/authorization/domain/ReferralMethodType$Companion;", "", "<init>", "()V", "map", "", "", "Lru/mrlargha/commonui/elements/authorization/domain/ReferralMethodType;", "get", "value", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ReferralMethodType get(int i) {
            return (ReferralMethodType) ReferralMethodType.map.get(Integer.valueOf(i));
        }
    }

    public static ReferralMethodType valueOf(String str) {
        return (ReferralMethodType) Enum.valueOf(ReferralMethodType.class, str);
    }

    public static ReferralMethodType[] values() {
        return (ReferralMethodType[]) $VALUES.clone();
    }
}
