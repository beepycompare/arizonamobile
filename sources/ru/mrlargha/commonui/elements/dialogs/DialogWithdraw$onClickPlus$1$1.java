package ru.mrlargha.commonui.elements.dialogs;

import android.widget.EditText;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DialogWithdraw.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "ru.mrlargha.commonui.elements.dialogs.DialogWithdraw$onClickPlus$1$1", f = "DialogWithdraw.kt", i = {0, 0}, l = {277}, m = "invokeSuspend", n = {"$this$launch", "count"}, nl = {278}, s = {"L$0", "I$0"}, v = 2)
/* loaded from: classes6.dex */
public final class DialogWithdraw$onClickPlus$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CustomCardView $btnMinus;
    final /* synthetic */ EditText $et;
    final /* synthetic */ boolean $isDouble;
    final /* synthetic */ Ref.BooleanRef $isHoldTriggered;
    int I$0;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ DialogWithdraw this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DialogWithdraw$onClickPlus$1$1(Ref.BooleanRef booleanRef, DialogWithdraw dialogWithdraw, EditText editText, boolean z, CustomCardView customCardView, Continuation<? super DialogWithdraw$onClickPlus$1$1> continuation) {
        super(2, continuation);
        this.$isHoldTriggered = booleanRef;
        this.this$0 = dialogWithdraw;
        this.$et = editText;
        this.$isDouble = z;
        this.$btnMinus = customCardView;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DialogWithdraw$onClickPlus$1$1 dialogWithdraw$onClickPlus$1$1 = new DialogWithdraw$onClickPlus$1$1(this.$isHoldTriggered, this.this$0, this.$et, this.$isDouble, this.$btnMinus, continuation);
        dialogWithdraw$onClickPlus$1$1.L$0 = obj;
        return dialogWithdraw$onClickPlus$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DialogWithdraw$onClickPlus$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x006e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0037 -> B:14:0x003a). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        int i;
        boolean checkIsZero;
        CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            i = 0;
            if (CoroutineScopeKt.isActive(coroutineScope)) {
            }
        } else if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            i = this.I$0;
            ResultKt.throwOnFailure(obj);
            i++;
            this.$isHoldTriggered.element = true;
            DialogWithdraw dialogWithdraw = this.this$0;
            if (i <= 33) {
                dialogWithdraw.plusOne(this.$et, 25, this.$isDouble);
            } else {
                dialogWithdraw.plusOne(this.$et, 10, this.$isDouble);
            }
            this.this$0.checkEtValidates();
            CustomCardView customCardView = this.$btnMinus;
            checkIsZero = this.this$0.checkIsZero(this.$et);
            CustomCardView.changeValidate$default(customCardView, checkIsZero, 0.0f, 2, null);
            if (CoroutineScopeKt.isActive(coroutineScope)) {
                this.L$0 = coroutineScope;
                this.I$0 = i;
                this.label = 1;
                if (DelayKt.delay(150L, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                i++;
                this.$isHoldTriggered.element = true;
                DialogWithdraw dialogWithdraw2 = this.this$0;
                if (i <= 33) {
                }
                this.this$0.checkEtValidates();
                CustomCardView customCardView2 = this.$btnMinus;
                checkIsZero = this.this$0.checkIsZero(this.$et);
                CustomCardView.changeValidate$default(customCardView2, checkIsZero, 0.0f, 2, null);
                if (CoroutineScopeKt.isActive(coroutineScope)) {
                    return Unit.INSTANCE;
                }
            }
        }
    }
}
