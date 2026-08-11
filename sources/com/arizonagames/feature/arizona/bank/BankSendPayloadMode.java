package com.arizonagames.feature.arizona.bank;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: BankContract.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/arizonagames/feature/arizona/bank/BankSendPayloadMode;", "", "<init>", "(Ljava/lang/String;I)V", "NONE", "TARGET_AS_DATA", "TARGET_AS_ID", "EMPTY_JSON", "CHEST_REWARD", "bank"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BankSendPayloadMode {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ BankSendPayloadMode[] $VALUES;
    public static final BankSendPayloadMode NONE = new BankSendPayloadMode("NONE", 0);
    public static final BankSendPayloadMode TARGET_AS_DATA = new BankSendPayloadMode("TARGET_AS_DATA", 1);
    public static final BankSendPayloadMode TARGET_AS_ID = new BankSendPayloadMode("TARGET_AS_ID", 2);
    public static final BankSendPayloadMode EMPTY_JSON = new BankSendPayloadMode("EMPTY_JSON", 3);
    public static final BankSendPayloadMode CHEST_REWARD = new BankSendPayloadMode("CHEST_REWARD", 4);

    private static final /* synthetic */ BankSendPayloadMode[] $values() {
        return new BankSendPayloadMode[]{NONE, TARGET_AS_DATA, TARGET_AS_ID, EMPTY_JSON, CHEST_REWARD};
    }

    public static EnumEntries<BankSendPayloadMode> getEntries() {
        return $ENTRIES;
    }

    public static BankSendPayloadMode valueOf(String str) {
        return (BankSendPayloadMode) Enum.valueOf(BankSendPayloadMode.class, str);
    }

    public static BankSendPayloadMode[] values() {
        return (BankSendPayloadMode[]) $VALUES.clone();
    }

    private BankSendPayloadMode(String str, int i) {
    }

    static {
        BankSendPayloadMode[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
