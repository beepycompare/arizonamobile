package ru.mrlargha.feature.battlepassWinter2025;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import ru.mrlargha.commonui.utils.UtilsKt;
import ru.mrlargha.feature.battlepassWinter2025.data.CommonTaskInfo;
/* compiled from: CommonTasksAdapter.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "ru.mrlargha.feature.battlepassWinter2025.RodinaBattlePassCommonTaskViewHolder$loadRewardImage$1", f = "CommonTasksAdapter.kt", i = {0}, l = {161}, m = "invokeSuspend", n = {"imageId"}, nl = {164}, s = {"L$0"}, v = 2)
/* loaded from: classes6.dex */
final class RodinaBattlePassCommonTaskViewHolder$loadRewardImage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isArizona;
    final /* synthetic */ CommonTaskInfo $task;
    Object L$0;
    int label;
    final /* synthetic */ RodinaBattlePassCommonTaskViewHolder this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RodinaBattlePassCommonTaskViewHolder$loadRewardImage$1(boolean z, CommonTaskInfo commonTaskInfo, RodinaBattlePassCommonTaskViewHolder rodinaBattlePassCommonTaskViewHolder, Continuation<? super RodinaBattlePassCommonTaskViewHolder$loadRewardImage$1> continuation) {
        super(2, continuation);
        this.$isArizona = z;
        this.$task = commonTaskInfo;
        this.this$0 = rodinaBattlePassCommonTaskViewHolder;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new RodinaBattlePassCommonTaskViewHolder$loadRewardImage$1(this.$isArizona, this.$task, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((RodinaBattlePassCommonTaskViewHolder$loadRewardImage$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            String image = (this.$isArizona && Intrinsics.areEqual(this.$task.getImage(), "1.webp")) ? "30104.webp" : this.$task.getImage();
            this.L$0 = SpillingKt.nullOutSpilledVariable(image);
            this.label = 1;
            obj = BuildersKt.withContext(Dispatchers.getIO(), new RodinaBattlePassCommonTaskViewHolder$loadRewardImage$1$bitmap$1(image, null), this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            String str = (String) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        Bitmap bitmap = (Bitmap) obj;
        RodinaBattlePassCommonTaskViewHolder rodinaBattlePassCommonTaskViewHolder = this.this$0;
        if (bitmap != null) {
            ImageView itemRewardIc = rodinaBattlePassCommonTaskViewHolder.getBinding().itemRewardIc;
            Intrinsics.checkNotNullExpressionValue(itemRewardIc, "itemRewardIc");
            UtilsKt.setImage(itemRewardIc, bitmap);
        } else {
            ImageView itemRewardIc2 = rodinaBattlePassCommonTaskViewHolder.getBinding().itemRewardIc;
            Intrinsics.checkNotNullExpressionValue(itemRewardIc2, "itemRewardIc");
            Context context = this.this$0.getBinding().getRoot().getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            UtilsKt.setNotLoadedImage(itemRewardIc2, context);
        }
        return Unit.INSTANCE;
    }
}
