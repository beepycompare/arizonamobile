package ru.mrlargha.commonui.elements.battlepassWinter2025;

import android.app.Activity;
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
import ru.mrlargha.commonui.databinding.WinterBattlepassBuyPremiumLayoutBinding;
import ru.mrlargha.commonui.utils.UtilsKt;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Winter2025BattlePass.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "ru.mrlargha.commonui.elements.battlepassWinter2025.Winter2025BattlePassScreen$setupBuyPremiumPage$1$3", f = "Winter2025BattlePass.kt", i = {}, l = {375}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
public final class Winter2025BattlePassScreen$setupBuyPremiumPage$1$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ WinterBattlepassBuyPremiumLayoutBinding $this_apply;
    int label;
    final /* synthetic */ Winter2025BattlePassScreen this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Winter2025BattlePassScreen$setupBuyPremiumPage$1$3(WinterBattlepassBuyPremiumLayoutBinding winterBattlepassBuyPremiumLayoutBinding, Winter2025BattlePassScreen winter2025BattlePassScreen, Continuation<? super Winter2025BattlePassScreen$setupBuyPremiumPage$1$3> continuation) {
        super(2, continuation);
        this.$this_apply = winterBattlepassBuyPremiumLayoutBinding;
        this.this$0 = winter2025BattlePassScreen;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new Winter2025BattlePassScreen$setupBuyPremiumPage$1$3(this.$this_apply, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((Winter2025BattlePassScreen$setupBuyPremiumPage$1$3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Activity targetActivity;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = BuildersKt.withContext(Dispatchers.getIO(), new Winter2025BattlePassScreen$setupBuyPremiumPage$1$3$bitmap$1(this.this$0, null), this);
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
            ImageView premiumImage3 = this.$this_apply.premiumImage3;
            Intrinsics.checkNotNullExpressionValue(premiumImage3, "premiumImage3");
            UtilsKt.setImage(premiumImage3, bitmap);
        } else {
            ImageView premiumImage32 = this.$this_apply.premiumImage3;
            Intrinsics.checkNotNullExpressionValue(premiumImage32, "premiumImage3");
            targetActivity = this.this$0.getTargetActivity();
            UtilsKt.setNotLoadedImage(premiumImage32, targetActivity);
        }
        return Unit.INSTANCE;
    }
}
