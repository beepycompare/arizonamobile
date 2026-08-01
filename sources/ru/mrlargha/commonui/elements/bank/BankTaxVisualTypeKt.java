package ru.mrlargha.commonui.elements.bank;

import kotlin.Metadata;
/* compiled from: BankTaxVisualType.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¨\u0006\u0004"}, d2 = {"resolveBankTaxAssetPath", "", "backendType", "", "CommonUI"}, k = 2, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class BankTaxVisualTypeKt {
    public static final String resolveBankTaxAssetPath(int i) {
        Integer assetId = BankTaxVisualType.Companion.fromBackendType(i).getAssetId();
        if (assetId == null) {
            return "";
        }
        return "systems/bank_menu/taxes/" + assetId.intValue() + ".webp";
    }
}
