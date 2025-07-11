package ru.mrlargha.arizonaui.family;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import ru.mrlargha.arizonaui.databinding.FamilyMainBinding;
import ru.mrlargha.arizonaui.family.data.FamilyData;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FamilyScreen.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "ru.mrlargha.arizonaui.family.FamilyScreen$loadMembersCount$1", f = "FamilyScreen.kt", i = {0, 0}, l = {660}, m = "invokeSuspend", n = {"it", "$i$a$-let-FamilyScreen$loadMembersCount$1$1"}, s = {"L$1", "I$0"})
/* loaded from: classes5.dex */
public final class FamilyScreen$loadMembersCount$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int I$0;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ FamilyScreen this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FamilyScreen$loadMembersCount$1(FamilyScreen familyScreen, Continuation<? super FamilyScreen$loadMembersCount$1> continuation) {
        super(2, continuation);
        this.this$0 = familyScreen;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FamilyScreen$loadMembersCount$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((FamilyScreen$loadMembersCount$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        FamilyData familyData;
        FamilyScreen familyScreen;
        FamilyMainBinding familyMainBinding;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            familyData = this.this$0.familyData;
            if (familyData != null) {
                FamilyScreen familyScreen2 = this.this$0;
                this.L$0 = familyScreen2;
                this.L$1 = SpillingKt.nullOutSpilledVariable(familyData);
                this.I$0 = 0;
                this.label = 1;
                obj = BuildersKt.withContext(Dispatchers.getIO(), new FamilyScreen$loadMembersCount$1$1$members$1(familyScreen2, familyData, null), this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                familyScreen = familyScreen2;
            }
            return Unit.INSTANCE;
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            FamilyData familyData2 = (FamilyData) this.L$1;
            familyScreen = (FamilyScreen) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        int intValue = ((Number) obj).intValue();
        familyMainBinding = familyScreen.binding;
        familyMainBinding.topbar.textDevil.setText(intValue + " человек");
        return Unit.INSTANCE;
    }
}
