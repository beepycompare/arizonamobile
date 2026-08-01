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
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import ru.mrlargha.commonui.utils.UtilsKt;
import ru.mrlargha.feature.battlepassWinter2025.LevelItemsAdapter;
import ru.mrlargha.feature.battlepassWinter2025.data.AwardItemData;
import ru.mrlargha.feature.battlepassWinter2025.databinding.WinterBattlepassLevelItemBinding;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LevelItemsAdapter.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "ru.mrlargha.feature.battlepassWinter2025.LevelItemsAdapter$LevelItemViewHolder$bindRewardImages$1$2", f = "LevelItemsAdapter.kt", i = {0}, l = {285}, m = "invokeSuspend", n = {"$this$launch"}, nl = {292}, s = {"L$0"}, v = 2)
/* loaded from: classes6.dex */
public final class LevelItemsAdapter$LevelItemViewHolder$bindRewardImages$1$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AwardItemData $itemUsual;
    final /* synthetic */ WinterBattlepassLevelItemBinding $this_apply;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ LevelItemsAdapter this$0;
    final /* synthetic */ LevelItemsAdapter.LevelItemViewHolder this$1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LevelItemsAdapter$LevelItemViewHolder$bindRewardImages$1$2(WinterBattlepassLevelItemBinding winterBattlepassLevelItemBinding, LevelItemsAdapter levelItemsAdapter, AwardItemData awardItemData, LevelItemsAdapter.LevelItemViewHolder levelItemViewHolder, Continuation<? super LevelItemsAdapter$LevelItemViewHolder$bindRewardImages$1$2> continuation) {
        super(2, continuation);
        this.$this_apply = winterBattlepassLevelItemBinding;
        this.this$0 = levelItemsAdapter;
        this.$itemUsual = awardItemData;
        this.this$1 = levelItemViewHolder;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        LevelItemsAdapter$LevelItemViewHolder$bindRewardImages$1$2 levelItemsAdapter$LevelItemViewHolder$bindRewardImages$1$2 = new LevelItemsAdapter$LevelItemViewHolder$bindRewardImages$1$2(this.$this_apply, this.this$0, this.$itemUsual, this.this$1, continuation);
        levelItemsAdapter$LevelItemViewHolder$bindRewardImages$1$2.L$0 = obj;
        return levelItemsAdapter$LevelItemViewHolder$bindRewardImages$1$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((LevelItemsAdapter$LevelItemViewHolder$bindRewardImages$1$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        WinterBattlepassLevelItemBinding winterBattlepassLevelItemBinding;
        CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.L$0 = coroutineScope;
            this.label = 1;
            obj = BuildersKt.withContext(Dispatchers.getIO(), new LevelItemsAdapter$LevelItemViewHolder$bindRewardImages$1$2$bitmap$1(this.this$0, this.$itemUsual, null), this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        Bitmap bitmap = (Bitmap) obj;
        ImageView itemLevelIcUsually = this.$this_apply.itemLevelIcUsually;
        Intrinsics.checkNotNullExpressionValue(itemLevelIcUsually, "itemLevelIcUsually");
        itemLevelIcUsually.setVisibility(0);
        if (bitmap == null) {
            LevelItemsAdapter levelItemsAdapter = this.this$0;
            WinterBattlepassLevelItemBinding winterBattlepassLevelItemBinding2 = this.$this_apply;
            LevelItemsAdapter.LevelItemViewHolder levelItemViewHolder = this.this$1;
            if (levelItemsAdapter.isArizonaType) {
                ImageView itemLevelIcUsually2 = winterBattlepassLevelItemBinding2.itemLevelIcUsually;
                Intrinsics.checkNotNullExpressionValue(itemLevelIcUsually2, "itemLevelIcUsually");
                winterBattlepassLevelItemBinding = levelItemViewHolder.binding;
                Context context = winterBattlepassLevelItemBinding.getRoot().getContext();
                Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                UtilsKt.setNotLoadedImage(itemLevelIcUsually2, context);
            } else {
                ImageView itemLevelIcUsually3 = winterBattlepassLevelItemBinding2.itemLevelIcUsually;
                Intrinsics.checkNotNullExpressionValue(itemLevelIcUsually3, "itemLevelIcUsually");
                itemLevelIcUsually3.setVisibility(4);
            }
        } else {
            ImageView itemLevelIcUsually4 = this.$this_apply.itemLevelIcUsually;
            Intrinsics.checkNotNullExpressionValue(itemLevelIcUsually4, "itemLevelIcUsually");
            UtilsKt.setImage(itemLevelIcUsually4, bitmap);
        }
        return Unit.INSTANCE;
    }
}
