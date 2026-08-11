package com.arizonagames.feature.arizona.bank;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: BankContract.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0016\b\u0086\u0081\u0002\u0018\u0000 \u001c2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u001cB9\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0015\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001b¨\u0006\u001d"}, d2 = {"Lcom/arizonagames/feature/arizona/bank/BankPage;", "", "backendValue", "", "title", "", "hasTopTab", "", "titleResId", "topTabClickId", "<init>", "(Ljava/lang/String;IILjava/lang/String;ZILjava/lang/Integer;)V", "getBackendValue", "()I", "getTitle", "()Ljava/lang/String;", "getHasTopTab", "()Z", "getTitleResId", "getTopTabClickId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "MAIN", "DEPOSIT", "CURRENCY", "OTHER", "LOTTERY", "CARD_ISSUE", "Companion", "bank"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BankPage {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ BankPage[] $VALUES;
    public static final Companion Companion;
    private static final int SERVER_OPEN_PAGE_ID_OFFSET = 1;
    private final int backendValue;
    private final boolean hasTopTab;
    private final String title;
    private final int titleResId;
    private final Integer topTabClickId;
    public static final BankPage MAIN = new BankPage("MAIN", 0, 0, "Главное", false, 0, 1, 12, null);
    public static final BankPage DEPOSIT = new BankPage("DEPOSIT", 1, 1, "Депозит", false, 0, 2, 12, null);
    public static final BankPage CURRENCY = new BankPage("CURRENCY", 2, 2, "Валюты", false, 0, 3, 12, null);
    public static final BankPage OTHER = new BankPage("OTHER", 3, 3, "Другое", false, 0, 4, 12, null);
    public static final BankPage LOTTERY = new BankPage("LOTTERY", 4, 4, "Розыгрыши", false, R.string.bank_lottery_tab_title, 5, 4, null);
    public static final BankPage CARD_ISSUE = new BankPage("CARD_ISSUE", 5, 5, "Оформление", false, 0, null, 24, null);

    private static final /* synthetic */ BankPage[] $values() {
        return new BankPage[]{MAIN, DEPOSIT, CURRENCY, OTHER, LOTTERY, CARD_ISSUE};
    }

    public static EnumEntries<BankPage> getEntries() {
        return $ENTRIES;
    }

    public static BankPage valueOf(String str) {
        return (BankPage) Enum.valueOf(BankPage.class, str);
    }

    public static BankPage[] values() {
        return (BankPage[]) $VALUES.clone();
    }

    private BankPage(String str, int i, int i2, String str2, boolean z, int i3, Integer num) {
        this.backendValue = i2;
        this.title = str2;
        this.hasTopTab = z;
        this.titleResId = i3;
        this.topTabClickId = num;
    }

    /* synthetic */ BankPage(String str, int i, int i2, String str2, boolean z, int i3, Integer num, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i, i2, str2, (i4 & 4) != 0 ? true : z, (i4 & 8) != 0 ? 0 : i3, (i4 & 16) != 0 ? null : num);
    }

    public final int getBackendValue() {
        return this.backendValue;
    }

    public final String getTitle() {
        return this.title;
    }

    public final boolean getHasTopTab() {
        return this.hasTopTab;
    }

    public final int getTitleResId() {
        return this.titleResId;
    }

    public final Integer getTopTabClickId() {
        return this.topTabClickId;
    }

    static {
        BankPage[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
        Companion = new Companion(null);
    }

    /* compiled from: BankContract.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007R\u000e\u0010\t\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/arizonagames/feature/arizona/bank/BankPage$Companion;", "", "<init>", "()V", "fromBackend", "Lcom/arizonagames/feature/arizona/bank/BankPage;", "value", "", "fromServerOpenId", "SERVER_OPEN_PAGE_ID_OFFSET", "bank"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final BankPage fromBackend(int i) {
            Object obj;
            Iterator<E> it = BankPage.getEntries().iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (((BankPage) obj).getBackendValue() == i) {
                    break;
                }
            }
            BankPage bankPage = (BankPage) obj;
            return bankPage == null ? BankPage.MAIN : bankPage;
        }

        public final BankPage fromServerOpenId(int i) {
            return fromBackend(i - 1);
        }
    }
}
