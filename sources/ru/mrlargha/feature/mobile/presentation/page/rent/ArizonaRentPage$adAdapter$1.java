package ru.mrlargha.feature.mobile.presentation.page.rent;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.feature.mobile.presentation.page.rent.models.ArizonaRentAdClickEvent;
import ru.mrlargha.feature.mobile.presentation.page.rent.models.ArizonaRentAdModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ArizonaRentPage.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes6.dex */
public final /* synthetic */ class ArizonaRentPage$adAdapter$1 extends FunctionReferenceImpl implements Function2<ArizonaRentAdClickEvent, ArizonaRentAdModel, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public ArizonaRentPage$adAdapter$1(Object obj) {
        super(2, obj, ArizonaRentPage.class, "onAdClick", "onAdClick(Lru/mrlargha/feature/mobile/presentation/page/rent/models/ArizonaRentAdClickEvent;Lru/mrlargha/feature/mobile/presentation/page/rent/models/ArizonaRentAdModel;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(ArizonaRentAdClickEvent arizonaRentAdClickEvent, ArizonaRentAdModel arizonaRentAdModel) {
        invoke2(arizonaRentAdClickEvent, arizonaRentAdModel);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(ArizonaRentAdClickEvent p0, ArizonaRentAdModel p1) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        ((ArizonaRentPage) this.receiver).onAdClick(p0, p1);
    }
}
