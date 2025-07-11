package ru.mrlargha.arizonaui.new_container;

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
import ru.mrlargha.arizonaui.databinding.NewContainerAwardItemBinding;
import ru.mrlargha.arizonaui.new_container.NewContainerScreen;
import ru.mrlargha.arizonaui.utils.UtilsKt;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NewContainerAwardsAdapter.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "ru.mrlargha.arizonaui.new_container.NewContainerAwardsAdapter$onBindViewHolder$1$1", f = "NewContainerAwardsAdapter.kt", i = {}, l = {39}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
public final class NewContainerAwardsAdapter$onBindViewHolder$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ NewContainerScreen.Companion.AwardInfo $info;
    final /* synthetic */ NewContainerAwardItemBinding $this_apply;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NewContainerAwardsAdapter$onBindViewHolder$1$1(NewContainerScreen.Companion.AwardInfo awardInfo, NewContainerAwardItemBinding newContainerAwardItemBinding, Continuation<? super NewContainerAwardsAdapter$onBindViewHolder$1$1> continuation) {
        super(2, continuation);
        this.$info = awardInfo;
        this.$this_apply = newContainerAwardItemBinding;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new NewContainerAwardsAdapter$onBindViewHolder$1$1(this.$info, this.$this_apply, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((NewContainerAwardsAdapter$onBindViewHolder$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = BuildersKt.withContext(Dispatchers.getIO(), new NewContainerAwardsAdapter$onBindViewHolder$1$1$bitmap$1(this.$info, null), this);
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
            ImageView awardIc = this.$this_apply.awardIc;
            Intrinsics.checkNotNullExpressionValue(awardIc, "awardIc");
            UtilsKt.setImage(awardIc, bitmap);
        }
        return Unit.INSTANCE;
    }
}
