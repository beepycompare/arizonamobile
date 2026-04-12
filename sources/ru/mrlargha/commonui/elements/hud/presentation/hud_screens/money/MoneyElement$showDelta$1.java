package ru.mrlargha.commonui.elements.hud.presentation.hud_screens.money;

import android.widget.LinearLayout;
import androidx.media3.common.C;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MoneyElement.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "ru.mrlargha.commonui.elements.hud.presentation.hud_screens.money.MoneyElement$showDelta$1", f = "MoneyElement.kt", i = {}, l = {146}, m = "invokeSuspend", n = {}, nl = {147}, s = {}, v = 2)
/* loaded from: classes6.dex */
public final class MoneyElement$showDelta$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ MoneyElement this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MoneyElement$showDelta$1(MoneyElement moneyElement, Continuation<? super MoneyElement$showDelta$1> continuation) {
        super(2, continuation);
        this.this$0 = moneyElement;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MoneyElement$showDelta$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MoneyElement$showDelta$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (DelayKt.delay(C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        MoneyElement moneyElement = this.this$0;
        LinearLayout deltaRow = moneyElement.getBinding().blockM.deltaRow;
        Intrinsics.checkNotNullExpressionValue(deltaRow, "deltaRow");
        moneyElement.hideDeltaAnimated(deltaRow);
        MoneyElement moneyElement2 = this.this$0;
        LinearLayout deltaRow2 = moneyElement2.getBinding().blockKK.deltaRow;
        Intrinsics.checkNotNullExpressionValue(deltaRow2, "deltaRow");
        moneyElement2.hideDeltaAnimated(deltaRow2);
        MoneyElement moneyElement3 = this.this$0;
        LinearLayout deltaRow3 = moneyElement3.getBinding().blockK.deltaRow;
        Intrinsics.checkNotNullExpressionValue(deltaRow3, "deltaRow");
        moneyElement3.hideDeltaAnimated(deltaRow3);
        return Unit.INSTANCE;
    }
}
