package ru.mrlargha.commonui.elements.donate.presentation;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import ru.mrlargha.commonui.utils.UtilsKt;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DonateScreen.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "ru.mrlargha.commonui.elements.donate.presentation.DonateScreen$openPurchaseCategory$1$1", f = "DonateScreen.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
/* loaded from: classes6.dex */
public final class DonateScreen$openPurchaseCategory$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $categoryId;
    final /* synthetic */ long $currentSessionGeneration;
    final /* synthetic */ DonateStates $sessionStates;
    int label;
    final /* synthetic */ DonateScreen this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DonateScreen$openPurchaseCategory$1$1(DonateScreen donateScreen, DonateStates donateStates, long j, int i, Continuation<? super DonateScreen$openPurchaseCategory$1$1> continuation) {
        super(2, continuation);
        this.this$0 = donateScreen;
        this.$sessionStates = donateStates;
        this.$currentSessionGeneration = j;
        this.$categoryId = i;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DonateScreen$openPurchaseCategory$1$1(this.this$0, this.$sessionStates, this.$currentSessionGeneration, this.$categoryId, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DonateScreen$openPurchaseCategory$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        boolean isCurrentSession;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            isCurrentSession = this.this$0.isCurrentSession(this.$sessionStates, this.$currentSessionGeneration);
            if (isCurrentSession) {
                boolean isArizonaType = UtilsKt.isArizonaType();
                DonateStates donateStates = this.$sessionStates;
                if (isArizonaType) {
                    donateStates.setItemsArizona(this.$categoryId, false);
                } else {
                    donateStates.setItemsRodina(this.$categoryId, false, false);
                }
                return Unit.INSTANCE;
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
