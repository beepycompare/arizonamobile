package ru.mrlargha.feature.battlepassWinter2025;

import android.app.Activity;
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
import ru.mrlargha.feature.battlepassWinter2025.databinding.WinterBattlepassBuyPremiumLayoutBinding;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BattlePassPurchaseController.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "ru.mrlargha.feature.battlepassWinter2025.BattlePassPurchaseController$setupBuyPremiumPage$1$3", f = "BattlePassPurchaseController.kt", i = {1, 2, 2}, l = {93, 100, 107}, m = "invokeSuspend", n = {"bitmap1", "bitmap1", "bitmap2"}, nl = {96, 103, 110}, s = {"L$0", "L$0", "L$1"}, v = 2)
/* loaded from: classes6.dex */
public final class BattlePassPurchaseController$setupBuyPremiumPage$1$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ WinterBattlepassBuyPremiumLayoutBinding $this_apply;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ BattlePassPurchaseController this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BattlePassPurchaseController$setupBuyPremiumPage$1$3(WinterBattlepassBuyPremiumLayoutBinding winterBattlepassBuyPremiumLayoutBinding, BattlePassPurchaseController battlePassPurchaseController, Continuation<? super BattlePassPurchaseController$setupBuyPremiumPage$1$3> continuation) {
        super(2, continuation);
        this.$this_apply = winterBattlepassBuyPremiumLayoutBinding;
        this.this$0 = battlePassPurchaseController;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BattlePassPurchaseController$setupBuyPremiumPage$1$3(this.$this_apply, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((BattlePassPurchaseController$setupBuyPremiumPage$1$3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x004e, code lost:
        if (r9 == r0) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0092, code lost:
        if (r9 == r0) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00da, code lost:
        if (r9 == r0) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00dc, code lost:
        return r0;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Bitmap bitmap;
        Activity activity;
        Activity activity2;
        Activity activity3;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = BuildersKt.withContext(Dispatchers.getIO(), new BattlePassPurchaseController$setupBuyPremiumPage$1$3$bitmap1$1(this.this$0, null), this);
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else if (i != 2) {
            if (i == 3) {
                Bitmap bitmap2 = (Bitmap) this.L$1;
                Bitmap bitmap3 = (Bitmap) this.L$0;
                ResultKt.throwOnFailure(obj);
                Bitmap bitmap4 = (Bitmap) obj;
                WinterBattlepassBuyPremiumLayoutBinding winterBattlepassBuyPremiumLayoutBinding = this.$this_apply;
                if (bitmap4 != null) {
                    ImageView premiumImage3 = winterBattlepassBuyPremiumLayoutBinding.premiumImage3;
                    Intrinsics.checkNotNullExpressionValue(premiumImage3, "premiumImage3");
                    UtilsKt.setImage(premiumImage3, bitmap4);
                } else {
                    ImageView premiumImage32 = winterBattlepassBuyPremiumLayoutBinding.premiumImage3;
                    Intrinsics.checkNotNullExpressionValue(premiumImage32, "premiumImage3");
                    activity3 = this.this$0.targetActivity;
                    UtilsKt.setNotLoadedImage(premiumImage32, activity3);
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            bitmap = (Bitmap) this.L$0;
            ResultKt.throwOnFailure(obj);
            Bitmap bitmap5 = (Bitmap) obj;
            WinterBattlepassBuyPremiumLayoutBinding winterBattlepassBuyPremiumLayoutBinding2 = this.$this_apply;
            if (bitmap5 != null) {
                ImageView premiumImage2 = winterBattlepassBuyPremiumLayoutBinding2.premiumImage2;
                Intrinsics.checkNotNullExpressionValue(premiumImage2, "premiumImage2");
                UtilsKt.setImage(premiumImage2, bitmap5);
            } else {
                ImageView premiumImage22 = winterBattlepassBuyPremiumLayoutBinding2.premiumImage2;
                Intrinsics.checkNotNullExpressionValue(premiumImage22, "premiumImage2");
                activity2 = this.this$0.targetActivity;
                UtilsKt.setNotLoadedImage(premiumImage22, activity2);
            }
            this.L$0 = SpillingKt.nullOutSpilledVariable(bitmap);
            this.L$1 = SpillingKt.nullOutSpilledVariable(bitmap5);
            this.label = 3;
            obj = BuildersKt.withContext(Dispatchers.getIO(), new BattlePassPurchaseController$setupBuyPremiumPage$1$3$bitmap3$1(this.this$0, null), this);
        }
        bitmap = (Bitmap) obj;
        WinterBattlepassBuyPremiumLayoutBinding winterBattlepassBuyPremiumLayoutBinding3 = this.$this_apply;
        if (bitmap != null) {
            ImageView premiumImage1 = winterBattlepassBuyPremiumLayoutBinding3.premiumImage1;
            Intrinsics.checkNotNullExpressionValue(premiumImage1, "premiumImage1");
            UtilsKt.setImage(premiumImage1, bitmap);
        } else {
            ImageView premiumImage12 = winterBattlepassBuyPremiumLayoutBinding3.premiumImage1;
            Intrinsics.checkNotNullExpressionValue(premiumImage12, "premiumImage1");
            activity = this.this$0.targetActivity;
            UtilsKt.setNotLoadedImage(premiumImage12, activity);
        }
        this.L$0 = SpillingKt.nullOutSpilledVariable(bitmap);
        this.label = 2;
        obj = BuildersKt.withContext(Dispatchers.getIO(), new BattlePassPurchaseController$setupBuyPremiumPage$1$3$bitmap2$1(this.this$0, null), this);
    }
}
