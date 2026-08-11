package com.arizonagames.feature.arizona.bank;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: BankContract.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/arizonagames/feature/arizona/bank/BankMainSection;", "", "backendValue", "", "<init>", "(Ljava/lang/String;II)V", "getBackendValue", "()I", "ACCOUNTS", "TAXES", "Companion", "bank"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BankMainSection {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ BankMainSection[] $VALUES;
    public static final Companion Companion;
    private final int backendValue;
    public static final BankMainSection ACCOUNTS = new BankMainSection("ACCOUNTS", 0, 0);
    public static final BankMainSection TAXES = new BankMainSection("TAXES", 1, 1);

    private static final /* synthetic */ BankMainSection[] $values() {
        return new BankMainSection[]{ACCOUNTS, TAXES};
    }

    public static EnumEntries<BankMainSection> getEntries() {
        return $ENTRIES;
    }

    public static BankMainSection valueOf(String str) {
        return (BankMainSection) Enum.valueOf(BankMainSection.class, str);
    }

    public static BankMainSection[] values() {
        return (BankMainSection[]) $VALUES.clone();
    }

    private BankMainSection(String str, int i, int i2) {
        this.backendValue = i2;
    }

    public final int getBackendValue() {
        return this.backendValue;
    }

    static {
        BankMainSection[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
        Companion = new Companion(null);
    }

    /* compiled from: BankContract.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/arizonagames/feature/arizona/bank/BankMainSection$Companion;", "", "<init>", "()V", "fromBackend", "Lcom/arizonagames/feature/arizona/bank/BankMainSection;", "value", "", "bank"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final BankMainSection fromBackend(int i) {
            Object obj;
            Iterator<E> it = BankMainSection.getEntries().iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (((BankMainSection) obj).getBackendValue() == i) {
                    break;
                }
            }
            BankMainSection bankMainSection = (BankMainSection) obj;
            return bankMainSection == null ? BankMainSection.ACCOUNTS : bankMainSection;
        }
    }
}
