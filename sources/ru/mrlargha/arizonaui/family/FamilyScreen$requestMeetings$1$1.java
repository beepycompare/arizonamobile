package ru.mrlargha.arizonaui.family;

import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import ru.mrlargha.arizonaui.databinding.FamilyMainBinding;
import ru.mrlargha.arizonaui.databinding.FamilyMeetingsBinding;
import ru.mrlargha.arizonaui.family.adapters.MeetingsAdapter;
import ru.mrlargha.arizonaui.family.adapters.WarsAdapter;
import ru.mrlargha.arizonaui.family.data.CapturesItem;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FamilyScreen.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "ru.mrlargha.arizonaui.family.FamilyScreen$requestMeetings$1$1", f = "FamilyScreen.kt", i = {}, l = {631}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
public final class FamilyScreen$requestMeetings$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ FamilyScreen this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FamilyScreen$requestMeetings$1$1(FamilyScreen familyScreen, Continuation<? super FamilyScreen$requestMeetings$1$1> continuation) {
        super(2, continuation);
        this.this$0 = familyScreen;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FamilyScreen$requestMeetings$1$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((FamilyScreen$requestMeetings$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        FamilyMainBinding familyMainBinding;
        MeetingsAdapter meetingsAdapter;
        WarsAdapter warsAdapter;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = BuildersKt.withContext(Dispatchers.getIO(), new FamilyScreen$requestMeetings$1$1$list$1(this.this$0, null), this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        List<CapturesItem> list = (List) obj;
        familyMainBinding = this.this$0.binding;
        FamilyMeetingsBinding familyMeetingsBinding = familyMainBinding.meetings;
        familyMeetingsBinding.loaderBar.setVisibility(8);
        if (list.isEmpty()) {
            familyMeetingsBinding.empty.setVisibility(0);
        } else {
            familyMeetingsBinding.empty.setVisibility(8);
        }
        meetingsAdapter = this.this$0.meetingsAdapter;
        meetingsAdapter.addAllItems(list);
        warsAdapter = this.this$0.warAdapter;
        warsAdapter.setMeetings(list);
        return Unit.INSTANCE;
    }
}
