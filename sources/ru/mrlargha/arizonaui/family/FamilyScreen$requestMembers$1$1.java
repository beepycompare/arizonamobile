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
import ru.mrlargha.arizonaui.databinding.FamilyMembersBinding;
import ru.mrlargha.arizonaui.family.adapters.MembersAdapter;
import ru.mrlargha.arizonaui.family.data.FamilyData;
import ru.mrlargha.arizonaui.family.data.MemberItem;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FamilyScreen.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "ru.mrlargha.arizonaui.family.FamilyScreen$requestMembers$1$1", f = "FamilyScreen.kt", i = {}, l = {478}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
public final class FamilyScreen$requestMembers$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FamilyData $it;
    final /* synthetic */ int $page;
    int label;
    final /* synthetic */ FamilyScreen this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FamilyScreen$requestMembers$1$1(FamilyScreen familyScreen, FamilyData familyData, int i, Continuation<? super FamilyScreen$requestMembers$1$1> continuation) {
        super(2, continuation);
        this.this$0 = familyScreen;
        this.$it = familyData;
        this.$page = i;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FamilyScreen$requestMembers$1$1(this.this$0, this.$it, this.$page, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((FamilyScreen$requestMembers$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        FamilyMainBinding familyMainBinding;
        MembersAdapter membersAdapter;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = BuildersKt.withContext(Dispatchers.getIO(), new FamilyScreen$requestMembers$1$1$list$1(this.this$0, this.$it, this.$page, null), this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        List<MemberItem> list = (List) obj;
        familyMainBinding = this.this$0.binding;
        FamilyMembersBinding familyMembersBinding = familyMainBinding.members;
        int i2 = this.$page;
        familyMembersBinding.loaderBar.setVisibility(8);
        if (list.isEmpty() && i2 == 1) {
            familyMembersBinding.empty.setVisibility(0);
            familyMembersBinding.empty.setText("Список пуст");
        } else {
            familyMembersBinding.empty.setVisibility(8);
        }
        if (!list.isEmpty()) {
            membersAdapter = this.this$0.membersAdapter;
            membersAdapter.addAllItems(list);
        }
        return Unit.INSTANCE;
    }
}
