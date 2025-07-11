package ru.mrlargha.arizonaui.family;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import ru.mrlargha.arizonaui.databinding.FamilyMainBinding;
import ru.mrlargha.arizonaui.databinding.FamilyMembersFrameBinding;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FamilyScreen.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "ru.mrlargha.arizonaui.family.FamilyScreen$onClickMembersFrame$1", f = "FamilyScreen.kt", i = {}, l = {854}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
public final class FamilyScreen$onClickMembersFrame$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ FamilyScreen this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FamilyScreen$onClickMembersFrame$1(FamilyScreen familyScreen, Continuation<? super FamilyScreen$onClickMembersFrame$1> continuation) {
        super(2, continuation);
        this.this$0 = familyScreen;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FamilyScreen$onClickMembersFrame$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((FamilyScreen$onClickMembersFrame$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        FamilyMainBinding familyMainBinding;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (DelayKt.delay(1000L, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        familyMainBinding = this.this$0.binding;
        FamilyMembersFrameBinding familyMembersFrameBinding = familyMainBinding.frameMember;
        familyMembersFrameBinding.buttonKick.setCardBackgroundColor(0);
        familyMembersFrameBinding.buttonWarn.setCardBackgroundColor(0);
        familyMembersFrameBinding.buttonRank.setCardBackgroundColor(0);
        familyMembersFrameBinding.buttonPrem.setCardBackgroundColor(0);
        familyMembersFrameBinding.buttonKickText.setTextColor(-1);
        familyMembersFrameBinding.buttonWarnText.setTextColor(-1);
        familyMembersFrameBinding.buttonRankText.setTextColor(-1);
        familyMembersFrameBinding.buttonPremText.setTextColor(-1);
        return Unit.INSTANCE;
    }
}
