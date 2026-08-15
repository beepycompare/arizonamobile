package com.arizonagames.feature.arizona.bank.pages;

import android.graphics.Color;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.arizonagames.feature.arizona.bank.BankCurrencyHistoryInfo;
import com.arizonagames.feature.arizona.bank.BankCurrencyInfo;
import com.arizonagames.feature.arizona.bank.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import ru.mrlargha.commonui.elements.donate.utils.DonateUtilsKt;
/* compiled from: BankCurrencyCatalog.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u001e\u001a\u00020\u0005J\u0015\u0010\u001f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001e\u001a\u00020\u0005¢\u0006\u0002\u0010 J(\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00180\u00162\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\u00162\f\u0010$\u001a\b\u0012\u0004\u0012\u00020%0\u0016J\u0010\u0010&\u001a\u00020\u00052\u0006\u0010'\u001a\u00020(H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00180\u001cX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/arizonagames/feature/arizona/bank/pages/BankCurrencyCatalog;", "", "<init>", "()V", "ARIZONA_ID", "", "BITCOIN_ID", "ASC_ID", "VC_ID", "SP_500_ID", "APPLE_ID", "TESLA_ID", "VOLKSWAGEN_ID", "AMAZON_ID", "ALPHABET_ID", "BMW_ID", "MERCEDES_BENZ_ID", "NVIDIA_ID", "TOYOTA_ID", "SPACEX_ID", "MICROSOFT_ID", "defaultVisibleIds", "", "specs", "Lcom/arizonagames/feature/arizona/bank/pages/BankCurrencySpec;", "getSpecs", "()Ljava/util/List;", "specsById", "", "byId", TtmlNode.ATTR_ID, "iconResId", "(I)Ljava/lang/Integer;", "visibleSpecs", "currencies", "Lcom/arizonagames/feature/arizona/bank/BankCurrencyInfo;", "histories", "Lcom/arizonagames/feature/arizona/bank/BankCurrencyHistoryInfo;", "color", "value", "", "bank"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BankCurrencyCatalog {
    public static final int ALPHABET_ID = 9;
    public static final int AMAZON_ID = 8;
    public static final int APPLE_ID = 5;
    public static final int ARIZONA_ID = 0;
    public static final int ASC_ID = 2;
    public static final int BITCOIN_ID = 1;
    public static final int BMW_ID = 10;
    public static final BankCurrencyCatalog INSTANCE;
    public static final int MERCEDES_BENZ_ID = 11;
    public static final int MICROSOFT_ID = 15;
    public static final int NVIDIA_ID = 12;
    public static final int SPACEX_ID = 14;
    public static final int SP_500_ID = 4;
    public static final int TESLA_ID = 6;
    public static final int TOYOTA_ID = 13;
    public static final int VC_ID = 3;
    public static final int VOLKSWAGEN_ID = 7;
    private static final List<Integer> defaultVisibleIds;
    private static final List<BankCurrencySpec> specs;
    private static final Map<Integer, BankCurrencySpec> specsById;

    private BankCurrencyCatalog() {
    }

    static {
        BankCurrencyCatalog bankCurrencyCatalog = new BankCurrencyCatalog();
        INSTANCE = bankCurrencyCatalog;
        defaultVisibleIds = CollectionsKt.listOf((Object[]) new Integer[]{2, 3});
        List<BankCurrencySpec> listOf = CollectionsKt.listOf((Object[]) new BankCurrencySpec[]{new BankCurrencySpec(0, R.string.bank_currency_name_arizona, ru.mrlargha.commonui.R.drawable.currency_ic_arizona, null, bankCurrencyCatalog.color("#CE3047"), bankCurrencyCatalog.color("#354B84"), 7, bankCurrencyCatalog.color("#421B33"), bankCurrencyCatalog.color("#D7B5D0"), 18, bankCurrencyCatalog.color("#F8EAF3"), bankCurrencyCatalog.color("#FFF4FA"), 100L, -3, DonateUtilsKt.ANIMATION_DURATION, CollectionsKt.listOf((Object[]) new Long[]{96L, 98L, 101L, 99L, 102L, 100L, 103L, 101L}), 8, null), new BankCurrencySpec(1, R.string.bank_currency_name_btc, ru.mrlargha.commonui.R.drawable.currency_ic_btc, null, bankCurrencyCatalog.color("#B66A09"), bankCurrencyCatalog.color("#FFC34E"), 330, bankCurrencyCatalog.color("#784506"), bankCurrencyCatalog.color("#FFB341"), 42, bankCurrencyCatalog.color("#FFF2D8"), bankCurrencyCatalog.color("#FFF6E5"), 46000L, 2, DonateUtilsKt.ANIMATION_DURATION, CollectionsKt.listOf((Object[]) new Long[]{39L, 41L, 40L, 43L, 44L, 42L, 45L, 46L}), 8, null), new BankCurrencySpec(2, R.string.bank_currency_name_asc, ru.mrlargha.commonui.R.drawable.cuurency_ic_asc, null, bankCurrencyCatalog.color("#C72406"), bankCurrencyCatalog.color("#FF5035"), 325, bankCurrencyCatalog.color("#63210F"), bankCurrencyCatalog.color("#F06652"), 46, bankCurrencyCatalog.color("#FFE1DA"), bankCurrencyCatalog.color("#FFF0EA"), 12000L, 5, DonateUtilsKt.ANIMATION_DURATION, CollectionsKt.listOf((Object[]) new Long[]{8L, 12L, 16L, 12L, 25L, 30L, 18L, 17L, 15L, 23L, 16L, 10L, 17L, 28L, 22L, 28L}), 8, null), new BankCurrencySpec(3, R.string.bank_currency_name_vc, ru.mrlargha.commonui.R.drawable.currency_ic_vc, -1, bankCurrencyCatalog.color("#A12BC6"), bankCurrencyCatalog.color("#D36CF0"), 330, bankCurrencyCatalog.color("#6D3776"), bankCurrencyCatalog.color("#D473EF"), 44, bankCurrencyCatalog.color("#F6D8FF"), bankCurrencyCatalog.color("#FBE8FF"), 42000L, 1, DonateUtilsKt.ANIMATION_DURATION, CollectionsKt.listOf((Object[]) new Long[]{14L, 16L, 15L, 19L, 20L, 18L, 19L, 16L, 18L, 20L, 21L, 23L, 22L, 23L, 21L})), new BankCurrencySpec(4, R.string.bank_currency_name_sp_500, ru.mrlargha.commonui.R.drawable.bank_currency_ic_sp_500, null, bankCurrencyCatalog.color("#C03C00"), bankCurrencyCatalog.color("#FBA984"), 0, bankCurrencyCatalog.color("#75270F"), bankCurrencyCatalog.color("#F2A385"), 44, bankCurrencyCatalog.color("#FFF1EA"), bankCurrencyCatalog.color("#FFF7F3"), 220L, 12, DonateUtilsKt.ANIMATION_DURATION, CollectionsKt.listOf((Object[]) new Long[]{22L, 14L, 18L, 8L, 20L, 15L, 27L, 18L, 16L, 24L, 20L}), 8, null), new BankCurrencySpec(5, R.string.bank_currency_name_apple, ru.mrlargha.commonui.R.drawable.bank_currency_ic_apple, null, bankCurrencyCatalog.color("#4B4B4B"), bankCurrencyCatalog.color("#BABABA"), 325, bankCurrencyCatalog.color("#303030"), bankCurrencyCatalog.color("#D0D0D0"), 38, bankCurrencyCatalog.color("#F2F2F2"), bankCurrencyCatalog.color("#FFFFFF"), 220L, 12, DonateUtilsKt.ANIMATION_DURATION, CollectionsKt.listOf((Object[]) new Long[]{23L, 20L, 17L, 14L, 12L, 7L, 18L, 15L, 21L, 17L, 13L}), 8, null), new BankCurrencySpec(6, R.string.bank_currency_name_tesla, ru.mrlargha.commonui.R.drawable.bank_currency_ic_tesla, null, bankCurrencyCatalog.color("#2B0504"), bankCurrencyCatalog.color("#B6413B"), 325, bankCurrencyCatalog.color("#1D0303"), bankCurrencyCatalog.color("#D95A55"), 42, bankCurrencyCatalog.color("#FFE4E4"), bankCurrencyCatalog.color("#FFF1F1"), 220L, 12, DonateUtilsKt.ANIMATION_DURATION, CollectionsKt.listOf((Object[]) new Long[]{25L, 24L, 18L, 12L, 14L, 9L, 8L, 22L, 16L, 12L, 18L, 15L}), 8, null), new BankCurrencySpec(7, R.string.bank_currency_name_volkswagen, ru.mrlargha.commonui.R.drawable.bank_currency_ic_volkswagen, null, bankCurrencyCatalog.color("#114890"), bankCurrencyCatalog.color("#87DEF9"), 325, bankCurrencyCatalog.color("#0B315F"), bankCurrencyCatalog.color("#8AD9F0"), 44, bankCurrencyCatalog.color("#E7F9FF"), bankCurrencyCatalog.color("#F1FCFF"), 220L, 12, DonateUtilsKt.ANIMATION_DURATION, CollectionsKt.listOf((Object[]) new Long[]{22L, 12L, 6L, 10L, 8L, 15L, 12L, 9L, 16L, 18L, 17L}), 8, null), new BankCurrencySpec(8, R.string.bank_currency_name_amazon, ru.mrlargha.commonui.R.drawable.bank_currency_ic_amazon, null, bankCurrencyCatalog.color("#632902"), bankCurrencyCatalog.color("#F09030"), 325, bankCurrencyCatalog.color("#4A1D00"), bankCurrencyCatalog.color("#F4A152"), 42, bankCurrencyCatalog.color("#FFF0DF"), bankCurrencyCatalog.color("#FFF7ED"), 220L, 12, DonateUtilsKt.ANIMATION_DURATION, CollectionsKt.listOf((Object[]) new Long[]{18L, 10L, 16L, 12L, 20L, 15L, 21L, 12L, 25L, 18L, 22L}), 8, null), new BankCurrencySpec(9, R.string.bank_currency_name_alphabet, ru.mrlargha.commonui.R.drawable.bank_currency_ic_alphabet, null, bankCurrencyCatalog.color("#C81078"), bankCurrencyCatalog.color("#FDA6D3"), 325, bankCurrencyCatalog.color("#82104F"), bankCurrencyCatalog.color("#FFA7D6"), 42, bankCurrencyCatalog.color("#FFE7F4"), bankCurrencyCatalog.color("#FFF3FA"), 220L, 12, DonateUtilsKt.ANIMATION_DURATION, CollectionsKt.listOf((Object[]) new Long[]{24L, 12L, 18L, 15L, 17L, 20L, 18L, 22L, 19L, 15L, 21L}), 8, null), new BankCurrencySpec(10, R.string.bank_currency_name_bmw, ru.mrlargha.commonui.R.drawable.bank_currency_ic_bmw, null, bankCurrencyCatalog.color("#26384E"), bankCurrencyCatalog.color("#939CB5"), 325, bankCurrencyCatalog.color("#192838"), bankCurrencyCatalog.color("#A7B0C6"), 42, bankCurrencyCatalog.color("#E8EDF7"), bankCurrencyCatalog.color("#F3F6FC"), 220L, 12, DonateUtilsKt.ANIMATION_DURATION, CollectionsKt.listOf((Object[]) new Long[]{22L, 16L, 18L, 10L, 8L, 12L, 16L, 13L, 18L, 20L, 15L}), 8, null), new BankCurrencySpec(11, R.string.bank_currency_name_mercedes_benz, ru.mrlargha.commonui.R.drawable.bank_currency_ic_mercedes_benz, null, bankCurrencyCatalog.color("#766856"), bankCurrencyCatalog.color("#DBD2BA"), 325, bankCurrencyCatalog.color("#514738"), bankCurrencyCatalog.color("#E6DDC7"), 42, bankCurrencyCatalog.color("#FFF9EC"), bankCurrencyCatalog.color("#FFFCF4"), 220L, 12, DonateUtilsKt.ANIMATION_DURATION, CollectionsKt.listOf((Object[]) new Long[]{24L, 18L, 20L, 13L, 16L, 12L, 10L, 14L, 18L, 15L, 17L}), 8, null), new BankCurrencySpec(12, R.string.bank_currency_name_nvidia, ru.mrlargha.commonui.R.drawable.bank_currency_ic_nvidia, null, bankCurrencyCatalog.color("#559010"), bankCurrencyCatalog.color("#B8F559"), 325, bankCurrencyCatalog.color("#345D08"), bankCurrencyCatalog.color("#C5FA78"), 42, bankCurrencyCatalog.color("#F0FFDC"), bankCurrencyCatalog.color("#F7FFE9"), 220L, 12, DonateUtilsKt.ANIMATION_DURATION, CollectionsKt.listOf((Object[]) new Long[]{17L, 12L, 20L, 18L, 14L, 22L, 24L, 17L, 26L, 22L, 27L}), 8, null), new BankCurrencySpec(13, R.string.bank_currency_name_toyota, ru.mrlargha.commonui.R.drawable.bank_currency_ic_toyota, null, bankCurrencyCatalog.color("#535D27"), bankCurrencyCatalog.color("#AAB571"), 325, bankCurrencyCatalog.color("#343C16"), bankCurrencyCatalog.color("#B7C283"), 42, bankCurrencyCatalog.color("#F4F8DF"), bankCurrencyCatalog.color("#FAFCEB"), 220L, 12, DonateUtilsKt.ANIMATION_DURATION, CollectionsKt.listOf((Object[]) new Long[]{22L, 16L, 18L, 12L, 15L, 13L, 14L, 10L, 12L, 15L, 14L}), 8, null), new BankCurrencySpec(14, R.string.bank_currency_name_spacex, ru.mrlargha.commonui.R.drawable.bank_currency_ic_spacex, null, bankCurrencyCatalog.color("#2B2542"), bankCurrencyCatalog.color("#8D9BC8"), 325, bankCurrencyCatalog.color("#1A1728"), bankCurrencyCatalog.color("#A2ADD0"), 42, bankCurrencyCatalog.color("#EEEAFB"), bankCurrencyCatalog.color("#F7F4FF"), 220L, 12, DonateUtilsKt.ANIMATION_DURATION, CollectionsKt.listOf((Object[]) new Long[]{24L, 15L, 18L, 12L, 20L, 16L, 22L, 19L, 14L, 12L, 16L}), 8, null), new BankCurrencySpec(15, R.string.bank_currency_name_microsoft, ru.mrlargha.commonui.R.drawable.bank_currency_ic_microsoft, null, bankCurrencyCatalog.color("#A05A0B"), bankCurrencyCatalog.color("#F4C72F"), 325, bankCurrencyCatalog.color("#744007"), bankCurrencyCatalog.color("#F7D057"), 42, bankCurrencyCatalog.color("#FFF6D7"), bankCurrencyCatalog.color("#FFFAEA"), 220L, 12, DonateUtilsKt.ANIMATION_DURATION, CollectionsKt.listOf((Object[]) new Long[]{18L, 12L, 17L, 14L, 22L, 19L, 21L, 16L, 24L, 20L, 23L}), 8, null)});
        specs = listOf;
        List<BankCurrencySpec> list = listOf;
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(list, 10)), 16));
        for (Object obj : list) {
            linkedHashMap.put(Integer.valueOf(((BankCurrencySpec) obj).getId()), obj);
        }
        specsById = linkedHashMap;
    }

    public final List<BankCurrencySpec> getSpecs() {
        return specs;
    }

    public final BankCurrencySpec byId(int i) {
        return specsById.get(Integer.valueOf(i));
    }

    public final Integer iconResId(int i) {
        BankCurrencySpec byId = byId(i);
        if (byId != null) {
            return Integer.valueOf(byId.getIconResId());
        }
        return null;
    }

    public final List<BankCurrencySpec> visibleSpecs(List<BankCurrencyInfo> currencies, List<BankCurrencyHistoryInfo> histories) {
        Intrinsics.checkNotNullParameter(currencies, "currencies");
        Intrinsics.checkNotNullParameter(histories, "histories");
        List<BankCurrencyInfo> list = currencies;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (BankCurrencyInfo bankCurrencyInfo : list) {
            arrayList.add(Integer.valueOf(bankCurrencyInfo.getId()));
        }
        ArrayList arrayList2 = arrayList;
        List<BankCurrencyHistoryInfo> list2 = histories;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (BankCurrencyHistoryInfo bankCurrencyHistoryInfo : list2) {
            arrayList3.add(Integer.valueOf(bankCurrencyHistoryInfo.getId()));
        }
        Set set = CollectionsKt.toSet(CollectionsKt.plus((Collection) arrayList2, (Iterable) arrayList3));
        if (set.isEmpty()) {
            set = CollectionsKt.toSet(defaultVisibleIds);
        }
        Set set2 = set;
        ArrayList arrayList4 = new ArrayList();
        for (Object obj : specs) {
            if (set2.contains(Integer.valueOf(((BankCurrencySpec) obj).getId()))) {
                arrayList4.add(obj);
            }
        }
        return arrayList4;
    }

    private final int color(String str) {
        return Color.parseColor(str);
    }
}
