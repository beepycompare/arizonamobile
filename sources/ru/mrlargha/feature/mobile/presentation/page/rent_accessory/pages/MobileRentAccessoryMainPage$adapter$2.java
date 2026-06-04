package ru.mrlargha.feature.mobile.presentation.page.rent_accessory.pages;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import ru.mrlargha.feature.mobile.presentation.page.rent_accessory.models.MobileRentAccessoryCategoryModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MobileRentAccessoryMainPage.kt */
@Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final /* synthetic */ class MobileRentAccessoryMainPage$adapter$2 extends FunctionReferenceImpl implements Function1<Integer, MobileRentAccessoryCategoryModel> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public MobileRentAccessoryMainPage$adapter$2(Object obj) {
        super(1, obj, MobileRentAccessoryMainPage.class, "getCategory", "getCategory(I)Lru/mrlargha/feature/mobile/presentation/page/rent_accessory/models/MobileRentAccessoryCategoryModel;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ MobileRentAccessoryCategoryModel invoke(Integer num) {
        return invoke(num.intValue());
    }

    public final MobileRentAccessoryCategoryModel invoke(int i) {
        MobileRentAccessoryCategoryModel category;
        category = ((MobileRentAccessoryMainPage) this.receiver).getCategory(i);
        return category;
    }
}
