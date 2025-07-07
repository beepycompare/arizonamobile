package ru.mrlargha.commonui.elements.battlepassWinter2025;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
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
import ru.mrlargha.commonui.databinding.WinterBattlepassCommonTaskItemBinding;
import ru.mrlargha.commonui.elements.battlepassWinter2025.data.CommonTaskInfo;
import ru.mrlargha.commonui.utils.UtilsKt;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CommonTasksAdapter.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "ru.mrlargha.commonui.elements.battlepassWinter2025.CommonTasksAdapter$onBindViewHolder$1$1", f = "CommonTasksAdapter.kt", i = {}, l = {ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
public final class CommonTasksAdapter$onBindViewHolder$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ RodinaBattlePassCommonTaskViewHolder $holder;
    final /* synthetic */ CommonTaskInfo $task;
    final /* synthetic */ WinterBattlepassCommonTaskItemBinding $this_apply;
    int label;
    final /* synthetic */ CommonTasksAdapter this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommonTasksAdapter$onBindViewHolder$1$1(CommonTasksAdapter commonTasksAdapter, CommonTaskInfo commonTaskInfo, WinterBattlepassCommonTaskItemBinding winterBattlepassCommonTaskItemBinding, RodinaBattlePassCommonTaskViewHolder rodinaBattlePassCommonTaskViewHolder, Continuation<? super CommonTasksAdapter$onBindViewHolder$1$1> continuation) {
        super(2, continuation);
        this.this$0 = commonTasksAdapter;
        this.$task = commonTaskInfo;
        this.$this_apply = winterBattlepassCommonTaskItemBinding;
        this.$holder = rodinaBattlePassCommonTaskViewHolder;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CommonTasksAdapter$onBindViewHolder$1$1(this.this$0, this.$task, this.$this_apply, this.$holder, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CommonTasksAdapter$onBindViewHolder$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        boolean z;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            z = this.this$0.isArizona;
            int image = (z && this.$task.getImage() == 1) ? 30094 : this.$task.getImage();
            this.label = 1;
            obj = BuildersKt.withContext(Dispatchers.getIO(), new CommonTasksAdapter$onBindViewHolder$1$1$bitmap$1(image, null), this);
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
            ImageView itemRewardIc = this.$this_apply.itemRewardIc;
            Intrinsics.checkNotNullExpressionValue(itemRewardIc, "itemRewardIc");
            UtilsKt.setImage(itemRewardIc, bitmap);
        } else {
            ImageView itemRewardIc2 = this.$this_apply.itemRewardIc;
            Intrinsics.checkNotNullExpressionValue(itemRewardIc2, "itemRewardIc");
            Context context = this.$holder.getBinding().getRoot().getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            UtilsKt.setNotLoadedImage(itemRewardIc2, context);
        }
        return Unit.INSTANCE;
    }
}
