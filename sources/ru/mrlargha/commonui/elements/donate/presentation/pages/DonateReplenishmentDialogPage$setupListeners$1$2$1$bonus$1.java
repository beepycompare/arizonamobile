package ru.mrlargha.commonui.elements.donate.presentation.pages;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import ru.mrlargha.commonui.elements.donate.presentation.adapters.DonateBonusAdapter;
/* compiled from: DonateReplenishmentDialogPage.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "ru.mrlargha.commonui.elements.donate.presentation.pages.DonateReplenishmentDialogPage$setupListeners$1$2$1$bonus$1", f = "DonateReplenishmentDialogPage.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
final class DonateReplenishmentDialogPage$setupListeners$1$2$1$bonus$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Integer>, Object> {
    final /* synthetic */ long $number;
    int label;
    final /* synthetic */ DonateReplenishmentDialogPage this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DonateReplenishmentDialogPage$setupListeners$1$2$1$bonus$1(DonateReplenishmentDialogPage donateReplenishmentDialogPage, long j, Continuation<? super DonateReplenishmentDialogPage$setupListeners$1$2$1$bonus$1> continuation) {
        super(2, continuation);
        this.this$0 = donateReplenishmentDialogPage;
        this.$number = j;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DonateReplenishmentDialogPage$setupListeners$1$2$1$bonus$1(this.this$0, this.$number, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Integer> continuation) {
        return ((DonateReplenishmentDialogPage$setupListeners$1$2$1$bonus$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        DonateBonusAdapter donateBonusAdapter;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            donateBonusAdapter = this.this$0.adapter;
            return Boxing.boxInt(donateBonusAdapter.setInputMoney(this.$number));
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
