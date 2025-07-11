package ru.mrlargha.commonui.elements.employmentNote.presentation.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import com.google.android.material.imageview.ShapeableImageView;
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
import ru.mrlargha.commonui.databinding.ItemTaskRewardBinding;
import ru.mrlargha.commonui.elements.employmentNote.domain.RewardType;
import ru.mrlargha.commonui.utils.UtilsKt;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TaskRewardAdapter.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "ru.mrlargha.commonui.elements.employmentNote.presentation.adapter.TaskRewardViewHolder$bind$1$1", f = "TaskRewardAdapter.kt", i = {}, l = {63}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
public final class TaskRewardViewHolder$bind$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ RewardType $item;
    final /* synthetic */ ItemTaskRewardBinding $this_with;
    int label;
    final /* synthetic */ TaskRewardViewHolder this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TaskRewardViewHolder$bind$1$1(ItemTaskRewardBinding itemTaskRewardBinding, TaskRewardViewHolder taskRewardViewHolder, RewardType rewardType, Continuation<? super TaskRewardViewHolder$bind$1$1> continuation) {
        super(2, continuation);
        this.$this_with = itemTaskRewardBinding;
        this.this$0 = taskRewardViewHolder;
        this.$item = rewardType;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TaskRewardViewHolder$bind$1$1(this.$this_with, this.this$0, this.$item, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((TaskRewardViewHolder$bind$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ItemTaskRewardBinding itemTaskRewardBinding;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = BuildersKt.withContext(Dispatchers.getIO(), new TaskRewardViewHolder$bind$1$1$bitmap$1(this.$item, null), this);
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
            ShapeableImageView ivReward = this.$this_with.ivReward;
            Intrinsics.checkNotNullExpressionValue(ivReward, "ivReward");
            UtilsKt.setImage(ivReward, bitmap);
        } else {
            ShapeableImageView ivReward2 = this.$this_with.ivReward;
            Intrinsics.checkNotNullExpressionValue(ivReward2, "ivReward");
            itemTaskRewardBinding = this.this$0.binding;
            Context context = itemTaskRewardBinding.getRoot().getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            UtilsKt.setNotLoadedImage(ivReward2, context);
        }
        return Unit.INSTANCE;
    }
}
