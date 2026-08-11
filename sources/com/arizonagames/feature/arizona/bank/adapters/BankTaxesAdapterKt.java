package com.arizonagames.feature.arizona.bank.adapters;

import com.arizonagames.feature.arizona.bank.BankTaxInfo;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ru.mrlargha.commonui.elements.bank.BankTaxVisualTypeKt;
/* compiled from: BankTaxesAdapter.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\u0018\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004*\b\u0012\u0004\u0012\u00020\u00020\u0004H\u0000¨\u0006\u0005"}, d2 = {"resolveTaxImagePath", "", "Lcom/arizonagames/feature/arizona/bank/BankTaxInfo;", "sortedForDisplay", "", "bank"}, k = 2, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BankTaxesAdapterKt {
    public static final String resolveTaxImagePath(BankTaxInfo bankTaxInfo) {
        Intrinsics.checkNotNullParameter(bankTaxInfo, "<this>");
        String imgPath = bankTaxInfo.getImgPath();
        if (StringsKt.isBlank(imgPath)) {
            imgPath = BankTaxVisualTypeKt.resolveBankTaxAssetPath(bankTaxInfo.getId());
        }
        return imgPath;
    }

    public static final List<BankTaxInfo> sortedForDisplay(List<BankTaxInfo> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        final Comparator comparator = new Comparator() { // from class: com.arizonagames.feature.arizona.bank.adapters.BankTaxesAdapterKt$sortedForDisplay$$inlined$compareByDescending$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(Boolean.valueOf(((BankTaxInfo) t2).getTax() > 0), Boolean.valueOf(((BankTaxInfo) t).getTax() > 0));
            }
        };
        final Comparator comparator2 = new Comparator() { // from class: com.arizonagames.feature.arizona.bank.adapters.BankTaxesAdapterKt$sortedForDisplay$$inlined$thenByDescending$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                int compare = comparator.compare(t, t2);
                return compare != 0 ? compare : ComparisonsKt.compareValues(Boolean.valueOf(((BankTaxInfo) t2).getWarning()), Boolean.valueOf(((BankTaxInfo) t).getWarning()));
            }
        };
        return CollectionsKt.sortedWith(list, new Comparator() { // from class: com.arizonagames.feature.arizona.bank.adapters.BankTaxesAdapterKt$sortedForDisplay$$inlined$thenBy$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                int compare = comparator2.compare(t, t2);
                return compare != 0 ? compare : ComparisonsKt.compareValues(Integer.valueOf(((BankTaxInfo) t).getId()), Integer.valueOf(((BankTaxInfo) t2).getId()));
            }
        });
    }
}
