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
import ru.mrlargha.commonui.databinding.WinterBattlepassLevelItemBinding;
import ru.mrlargha.commonui.elements.battlepassWinter2025.data.AwardItemData;
import ru.mrlargha.commonui.utils.UtilsKt;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LevelItemsAdapter.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "ru.mrlargha.commonui.elements.battlepassWinter2025.LevelItemViewHolder$bind$1$2", f = "LevelItemsAdapter.kt", i = {}, l = {123}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
public final class LevelItemViewHolder$bind$1$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AwardItemData $itemUsual;
    final /* synthetic */ WinterBattlepassLevelItemBinding $this_apply;
    int label;
    final /* synthetic */ LevelItemViewHolder this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LevelItemViewHolder$bind$1$2(WinterBattlepassLevelItemBinding winterBattlepassLevelItemBinding, LevelItemViewHolder levelItemViewHolder, AwardItemData awardItemData, Continuation<? super LevelItemViewHolder$bind$1$2> continuation) {
        super(2, continuation);
        this.$this_apply = winterBattlepassLevelItemBinding;
        this.this$0 = levelItemViewHolder;
        this.$itemUsual = awardItemData;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LevelItemViewHolder$bind$1$2(this.$this_apply, this.this$0, this.$itemUsual, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((LevelItemViewHolder$bind$1$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        WinterBattlepassLevelItemBinding winterBattlepassLevelItemBinding;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = BuildersKt.withContext(Dispatchers.getIO(), new LevelItemViewHolder$bind$1$2$bitmap$1(this.$itemUsual, null), this);
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
            ImageView itemLevelIcUsually = this.$this_apply.itemLevelIcUsually;
            Intrinsics.checkNotNullExpressionValue(itemLevelIcUsually, "itemLevelIcUsually");
            UtilsKt.setImage(itemLevelIcUsually, bitmap);
        } else {
            ImageView itemLevelIcUsually2 = this.$this_apply.itemLevelIcUsually;
            Intrinsics.checkNotNullExpressionValue(itemLevelIcUsually2, "itemLevelIcUsually");
            winterBattlepassLevelItemBinding = this.this$0.binding;
            Context context = winterBattlepassLevelItemBinding.getRoot().getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            UtilsKt.setNotLoadedImage(itemLevelIcUsually2, context);
        }
        return Unit.INSTANCE;
    }
}
