package ru.mrlargha.commonui.elements.bank;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: BankTaxVisualType.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\b\u0086\u0081\u0002\u0018\u0000 \u00132\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0013B\u0013\b\u0002\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0014"}, d2 = {"Lru/mrlargha/commonui/elements/bank/BankTaxVisualType;", "", "assetId", "", "<init>", "(Ljava/lang/String;ILjava/lang/Integer;)V", "getAssetId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "LEGAL_FINE", "COMMUNAL", "PRIVATE_ORGANIZATION", "SOCIAL_HOUSING", "VEHICLE_RESTORATION", "HOTEL_ROOM_LEASE", "HOME", "BUSINESS", "FAMILY_APARTMENT", "UNKNOWN", "Companion", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class BankTaxVisualType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ BankTaxVisualType[] $VALUES;
    public static final Companion Companion;
    private final Integer assetId;
    public static final BankTaxVisualType LEGAL_FINE = new BankTaxVisualType("LEGAL_FINE", 0, 1);
    public static final BankTaxVisualType COMMUNAL = new BankTaxVisualType("COMMUNAL", 1, 2);
    public static final BankTaxVisualType PRIVATE_ORGANIZATION = new BankTaxVisualType("PRIVATE_ORGANIZATION", 2, 4);
    public static final BankTaxVisualType SOCIAL_HOUSING = new BankTaxVisualType("SOCIAL_HOUSING", 3, 5);
    public static final BankTaxVisualType VEHICLE_RESTORATION = new BankTaxVisualType("VEHICLE_RESTORATION", 4, 6);
    public static final BankTaxVisualType HOTEL_ROOM_LEASE = new BankTaxVisualType("HOTEL_ROOM_LEASE", 5, 7);
    public static final BankTaxVisualType HOME = new BankTaxVisualType("HOME", 6, 8);
    public static final BankTaxVisualType BUSINESS = new BankTaxVisualType("BUSINESS", 7, 9);
    public static final BankTaxVisualType FAMILY_APARTMENT = new BankTaxVisualType("FAMILY_APARTMENT", 8, 10);
    public static final BankTaxVisualType UNKNOWN = new BankTaxVisualType("UNKNOWN", 9, null);

    private static final /* synthetic */ BankTaxVisualType[] $values() {
        return new BankTaxVisualType[]{LEGAL_FINE, COMMUNAL, PRIVATE_ORGANIZATION, SOCIAL_HOUSING, VEHICLE_RESTORATION, HOTEL_ROOM_LEASE, HOME, BUSINESS, FAMILY_APARTMENT, UNKNOWN};
    }

    public static EnumEntries<BankTaxVisualType> getEntries() {
        return $ENTRIES;
    }

    public static BankTaxVisualType valueOf(String str) {
        return (BankTaxVisualType) Enum.valueOf(BankTaxVisualType.class, str);
    }

    public static BankTaxVisualType[] values() {
        return (BankTaxVisualType[]) $VALUES.clone();
    }

    private BankTaxVisualType(String str, int i, Integer num) {
        this.assetId = num;
    }

    public final Integer getAssetId() {
        return this.assetId;
    }

    static {
        BankTaxVisualType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
        Companion = new Companion(null);
    }

    /* compiled from: BankTaxVisualType.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lru/mrlargha/commonui/elements/bank/BankTaxVisualType$Companion;", "", "<init>", "()V", "fromBackendType", "Lru/mrlargha/commonui/elements/bank/BankTaxVisualType;", "type", "", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final BankTaxVisualType fromBackendType(int i) {
            switch (i) {
                case 0:
                    return BankTaxVisualType.LEGAL_FINE;
                case 1:
                    return BankTaxVisualType.COMMUNAL;
                case 2:
                    return BankTaxVisualType.PRIVATE_ORGANIZATION;
                case 3:
                    return BankTaxVisualType.SOCIAL_HOUSING;
                case 4:
                    return BankTaxVisualType.VEHICLE_RESTORATION;
                case 5:
                    return BankTaxVisualType.HOTEL_ROOM_LEASE;
                case 6:
                    return BankTaxVisualType.HOME;
                case 7:
                    return BankTaxVisualType.BUSINESS;
                case 8:
                    return BankTaxVisualType.FAMILY_APARTMENT;
                default:
                    return BankTaxVisualType.UNKNOWN;
            }
        }
    }
}
