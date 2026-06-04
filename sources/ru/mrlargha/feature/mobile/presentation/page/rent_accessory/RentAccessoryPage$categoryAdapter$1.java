package ru.mrlargha.feature.mobile.presentation.page.rent_accessory;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.feature.mobile.presentation.page.rent_accessory.models.MobileRentAccessoryCategoryModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RentAccessoryPage.kt */
@Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final /* synthetic */ class RentAccessoryPage$categoryAdapter$1 extends FunctionReferenceImpl implements Function1<MobileRentAccessoryCategoryModel, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public RentAccessoryPage$categoryAdapter$1(Object obj) {
        super(1, obj, RentAccessoryPage.class, "selectCategory", "selectCategory(Lru/mrlargha/feature/mobile/presentation/page/rent_accessory/models/MobileRentAccessoryCategoryModel;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(MobileRentAccessoryCategoryModel mobileRentAccessoryCategoryModel) {
        invoke2(mobileRentAccessoryCategoryModel);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(MobileRentAccessoryCategoryModel p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        ((RentAccessoryPage) this.receiver).selectCategory(p0);
    }
}
