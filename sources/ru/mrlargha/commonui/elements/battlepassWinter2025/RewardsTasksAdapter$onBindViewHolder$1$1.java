package ru.mrlargha.commonui.elements.battlepassWinter2025;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import ru.mrlargha.commonui.databinding.WinterBattlepassTaskRewardItemBinding;
import ru.mrlargha.commonui.elements.battlepassWinter2025.data.CommonTaskReward;
import ru.mrlargha.commonui.utils.UtilsKt;
/* compiled from: RewardsTasksAdapter.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "ru.mrlargha.commonui.elements.battlepassWinter2025.RewardsTasksAdapter$onBindViewHolder$1$1", f = "RewardsTasksAdapter.kt", i = {}, l = {37}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
final class RewardsTasksAdapter$onBindViewHolder$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ RodinaBattlePassTaskRewardItemViewHolder $holder;
    final /* synthetic */ CommonTaskReward $reward;
    final /* synthetic */ WinterBattlepassTaskRewardItemBinding $this_apply;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RewardsTasksAdapter$onBindViewHolder$1$1(WinterBattlepassTaskRewardItemBinding winterBattlepassTaskRewardItemBinding, RodinaBattlePassTaskRewardItemViewHolder rodinaBattlePassTaskRewardItemViewHolder, CommonTaskReward commonTaskReward, Continuation<? super RewardsTasksAdapter$onBindViewHolder$1$1> continuation) {
        super(2, continuation);
        this.$this_apply = winterBattlepassTaskRewardItemBinding;
        this.$holder = rodinaBattlePassTaskRewardItemViewHolder;
        this.$reward = commonTaskReward;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new RewardsTasksAdapter$onBindViewHolder$1$1(this.$this_apply, this.$holder, this.$reward, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((RewardsTasksAdapter$onBindViewHolder$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = BuildersKt.withContext(Dispatchers.getIO(), new RewardsTasksAdapter$onBindViewHolder$1$1$bitmap$1(this.$reward, null), this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        Bitmap bitmap = (Bitmap) obj;
        if (bitmap != null) {
            ImageView taskInfoRewardItemImage = this.$this_apply.taskInfoRewardItemImage;
            Intrinsics.checkNotNullExpressionValue(taskInfoRewardItemImage, "taskInfoRewardItemImage");
            UtilsKt.setImage(taskInfoRewardItemImage, bitmap);
        } else {
            ImageView taskInfoRewardItemImage2 = this.$this_apply.taskInfoRewardItemImage;
            Intrinsics.checkNotNullExpressionValue(taskInfoRewardItemImage2, "taskInfoRewardItemImage");
            Context context = this.$holder.getBinding().getRoot().getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            UtilsKt.setNotLoadedImage(taskInfoRewardItemImage2, context);
        }
        return Unit.INSTANCE;
    }
}
