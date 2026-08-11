package com.arizonagames.feature.arizona.bank.pages;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.arizonagames.feature.arizona.bank.BankCurrencyHistoryInfo;
import com.arizonagames.feature.arizona.bank.BankCurrencyInfo;
import com.arizonagames.feature.arizona.bank.BankSendSubId;
import com.arizonagames.feature.arizona.bank.R;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BankCurrencyPageController.kt */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B!\u0012\u0018\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0005H\u0016J\u0018\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u0005H\u0016J\b\u0010\u001e\u001a\u00020\u0005H\u0016J0\u0010\u001f\u001a\u00020\u00072\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u000f0\u000b2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00110\u000b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u000bJ\u0006\u0010\"\u001a\u00020\u0007R \u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00110\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00160\u0015X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/arizonagames/feature/arizona/bank/pages/BankCurrencyAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/arizonagames/feature/arizona/bank/pages/BankCurrencyViewHolder;", "onAction", "Lkotlin/Function2;", "", "Lcom/arizonagames/feature/arizona/bank/BankSendSubId;", "", "<init>", "(Lkotlin/jvm/functions/Function2;)V", "items", "", "Lcom/arizonagames/feature/arizona/bank/pages/BankCurrencySpec;", "currenciesById", "", "Lcom/arizonagames/feature/arizona/bank/BankCurrencyInfo;", "historyById", "Lcom/arizonagames/feature/arizona/bank/BankCurrencyHistoryInfo;", "ownBalances", "", "selectedRangesById", "", "Lcom/arizonagames/feature/arizona/bank/pages/CurrencyHistoryRange;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "getItemCount", "submitList", "currencies", "currencyHistory", "resetState", "bank"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BankCurrencyAdapter extends RecyclerView.Adapter<BankCurrencyViewHolder> {
    private Map<Integer, BankCurrencyInfo> currenciesById;
    private Map<Integer, BankCurrencyHistoryInfo> historyById;
    private List<BankCurrencySpec> items;
    private final Function2<Integer, BankSendSubId, Unit> onAction;
    private List<Long> ownBalances;
    private final Map<Integer, CurrencyHistoryRange> selectedRangesById;

    /* JADX WARN: Multi-variable type inference failed */
    public BankCurrencyAdapter(Function2<? super Integer, ? super BankSendSubId, Unit> onAction) {
        Intrinsics.checkNotNullParameter(onAction, "onAction");
        this.onAction = onAction;
        this.items = BankCurrencyCatalog.INSTANCE.visibleSpecs(CollectionsKt.emptyList(), CollectionsKt.emptyList());
        this.currenciesById = MapsKt.emptyMap();
        this.historyById = MapsKt.emptyMap();
        this.ownBalances = CollectionsKt.emptyList();
        this.selectedRangesById = new LinkedHashMap();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public BankCurrencyViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.bank_currency_item, parent, false);
        Intrinsics.checkNotNull(inflate);
        return new BankCurrencyViewHolder(inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(BankCurrencyViewHolder holder, final int i) {
        long currencyValue;
        Intrinsics.checkNotNullParameter(holder, "holder");
        final BankCurrencySpec bankCurrencySpec = this.items.get(i);
        BankCurrencyInfo bankCurrencyInfo = this.currenciesById.get(Integer.valueOf(bankCurrencySpec.getId()));
        BankCurrencyHistoryInfo bankCurrencyHistoryInfo = this.historyById.get(Integer.valueOf(bankCurrencySpec.getId()));
        currencyValue = BankCurrencyPageControllerKt.currencyValue(this.ownBalances, bankCurrencySpec.getId());
        CurrencyHistoryRange currencyHistoryRange = this.selectedRangesById.get(Integer.valueOf(bankCurrencySpec.getId()));
        if (currencyHistoryRange == null) {
            currencyHistoryRange = CurrencyHistoryRange.DAY;
        }
        holder.bind(bankCurrencySpec, bankCurrencyInfo, bankCurrencyHistoryInfo, currencyValue, currencyHistoryRange, new Function1() { // from class: com.arizonagames.feature.arizona.bank.pages.BankCurrencyAdapter$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BankCurrencyAdapter.onBindViewHolder$lambda$0(BankCurrencyAdapter.this, bankCurrencySpec, i, (CurrencyHistoryRange) obj);
            }
        }, new Function1() { // from class: com.arizonagames.feature.arizona.bank.pages.BankCurrencyAdapter$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BankCurrencyAdapter.onBindViewHolder$lambda$1(BankCurrencyAdapter.this, ((Integer) obj).intValue());
            }
        }, new Function1() { // from class: com.arizonagames.feature.arizona.bank.pages.BankCurrencyAdapter$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BankCurrencyAdapter.onBindViewHolder$lambda$2(BankCurrencyAdapter.this, ((Integer) obj).intValue());
            }
        }, new Function1() { // from class: com.arizonagames.feature.arizona.bank.pages.BankCurrencyAdapter$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BankCurrencyAdapter.onBindViewHolder$lambda$3(BankCurrencyAdapter.this, ((Integer) obj).intValue());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit onBindViewHolder$lambda$0(BankCurrencyAdapter bankCurrencyAdapter, BankCurrencySpec bankCurrencySpec, int i, CurrencyHistoryRange range) {
        Intrinsics.checkNotNullParameter(range, "range");
        bankCurrencyAdapter.selectedRangesById.put(Integer.valueOf(bankCurrencySpec.getId()), range);
        bankCurrencyAdapter.notifyItemChanged(i);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit onBindViewHolder$lambda$1(BankCurrencyAdapter bankCurrencyAdapter, int i) {
        bankCurrencyAdapter.onAction.invoke(Integer.valueOf(i), BankSendSubId.CURRENCY_BUY);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit onBindViewHolder$lambda$2(BankCurrencyAdapter bankCurrencyAdapter, int i) {
        bankCurrencyAdapter.onAction.invoke(Integer.valueOf(i), BankSendSubId.CURRENCY_SELL);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit onBindViewHolder$lambda$3(BankCurrencyAdapter bankCurrencyAdapter, int i) {
        bankCurrencyAdapter.onAction.invoke(Integer.valueOf(i), BankSendSubId.CURRENCY_INFO);
        return Unit.INSTANCE;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.items.size();
    }

    public final void submitList(List<BankCurrencyInfo> currencies, List<BankCurrencyHistoryInfo> currencyHistory, List<Long> ownBalances) {
        Intrinsics.checkNotNullParameter(currencies, "currencies");
        Intrinsics.checkNotNullParameter(currencyHistory, "currencyHistory");
        Intrinsics.checkNotNullParameter(ownBalances, "ownBalances");
        List<BankCurrencyInfo> list = currencies;
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(list, 10)), 16));
        for (Object obj : list) {
            linkedHashMap.put(Integer.valueOf(((BankCurrencyInfo) obj).getId()), obj);
        }
        this.currenciesById = linkedHashMap;
        List<BankCurrencyHistoryInfo> list2 = currencyHistory;
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(list2, 10)), 16));
        for (Object obj2 : list2) {
            linkedHashMap2.put(Integer.valueOf(((BankCurrencyHistoryInfo) obj2).getId()), obj2);
        }
        this.historyById = linkedHashMap2;
        this.ownBalances = ownBalances;
        this.items = BankCurrencyCatalog.INSTANCE.visibleSpecs(currencies, currencyHistory);
        Set<Integer> keySet = this.selectedRangesById.keySet();
        List<BankCurrencySpec> list3 = this.items;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list3, 10));
        for (BankCurrencySpec bankCurrencySpec : list3) {
            arrayList.add(Integer.valueOf(bankCurrencySpec.getId()));
        }
        keySet.retainAll(CollectionsKt.toSet(arrayList));
        notifyDataSetChanged();
    }

    public final void resetState() {
        this.selectedRangesById.clear();
        submitList(CollectionsKt.emptyList(), CollectionsKt.emptyList(), CollectionsKt.emptyList());
    }
}
