package ru.mrlargha.commonui.elements.donate.presentation;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.elements.donate.presentation.models.DonateCategoryModelUi;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DonateScreen.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* synthetic */ class DonateScreen$categoryAdapter$1 extends FunctionReferenceImpl implements Function1<DonateCategoryModelUi, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public DonateScreen$categoryAdapter$1(Object obj) {
        super(1, obj, DonateScreen.class, "onCategoryClick", "onCategoryClick(Lru/mrlargha/commonui/elements/donate/presentation/models/DonateCategoryModelUi;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(DonateCategoryModelUi donateCategoryModelUi) {
        invoke2(donateCategoryModelUi);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(DonateCategoryModelUi p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        ((DonateScreen) this.receiver).onCategoryClick(p0);
    }
}
