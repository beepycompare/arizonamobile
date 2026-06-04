package ru.mrlargha.commonui.elements.donate.domain.usecases;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DonateGetItemUseCase.kt */
@Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "ru.mrlargha.commonui.elements.donate.domain.usecases.DonateGetItemUseCase", f = "DonateGetItemUseCase.kt", i = {0, 0, 1, 1}, l = {108, ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_TOP_OF}, m = "updateItem", n = {"item", "$this$withLock_u24default$iv", "item", "$this$withLock_u24default$iv"}, nl = {109, ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF}, s = {"L$0", "L$1", "L$0", "L$1"}, v = 2)
/* loaded from: classes6.dex */
public final class DonateGetItemUseCase$updateItem$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DonateGetItemUseCase this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DonateGetItemUseCase$updateItem$1(DonateGetItemUseCase donateGetItemUseCase, Continuation<? super DonateGetItemUseCase$updateItem$1> continuation) {
        super(continuation);
        this.this$0 = donateGetItemUseCase;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.updateItem(null, this);
    }
}
