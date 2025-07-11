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
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import ru.mrlargha.commonui.databinding.WinterBattlepassLayoutBinding;
import ru.mrlargha.commonui.utils.UtilsKt;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Winter2025BattlePass.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "ru.mrlargha.commonui.elements.battlepassWinter2025.Winter2025BattlePassScreen$setWelcomeScreen$1$4", f = "Winter2025BattlePass.kt", i = {1, 2, 2}, l = {1174, 1181, 1188}, m = "invokeSuspend", n = {"bitmap1", "bitmap1", "bitmap2"}, s = {"L$0", "L$0", "L$1"})
/* loaded from: classes5.dex */
public final class Winter2025BattlePassScreen$setWelcomeScreen$1$4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ WinterBattlepassLayoutBinding $this_apply;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ Winter2025BattlePassScreen this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Winter2025BattlePassScreen$setWelcomeScreen$1$4(WinterBattlepassLayoutBinding winterBattlepassLayoutBinding, Winter2025BattlePassScreen winter2025BattlePassScreen, Continuation<? super Winter2025BattlePassScreen$setWelcomeScreen$1$4> continuation) {
        super(2, continuation);
        this.$this_apply = winterBattlepassLayoutBinding;
        this.this$0 = winter2025BattlePassScreen;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new Winter2025BattlePassScreen$setWelcomeScreen$1$4(this.$this_apply, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((Winter2025BattlePassScreen$setWelcomeScreen$1$4) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0050, code lost:
        if (r10 == r0) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0098, code lost:
        if (r10 == r0) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00e4, code lost:
        if (r10 == r0) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00e6, code lost:
        return r0;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Bitmap bitmap;
        Activity targetActivity;
        Activity targetActivity2;
        Activity targetActivity3;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = BuildersKt.withContext(Dispatchers.getIO(), new Winter2025BattlePassScreen$setWelcomeScreen$1$4$bitmap1$1(this.this$0, null), this);
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else if (i != 2) {
            if (i == 3) {
                Bitmap bitmap2 = (Bitmap) this.L$1;
                Bitmap bitmap3 = (Bitmap) this.L$0;
                ResultKt.throwOnFailure(obj);
                Bitmap bitmap4 = (Bitmap) obj;
                if (bitmap4 != null) {
                    ImageView imagePrise = this.$this_apply.welcomePrice3.imagePrise;
                    Intrinsics.checkNotNullExpressionValue(imagePrise, "imagePrise");
                    UtilsKt.setImage(imagePrise, bitmap4);
                } else {
                    ImageView imagePrise2 = this.$this_apply.welcomePrice3.imagePrise;
                    Intrinsics.checkNotNullExpressionValue(imagePrise2, "imagePrise");
                    targetActivity3 = this.this$0.getTargetActivity();
                    UtilsKt.setNotLoadedImage(imagePrise2, targetActivity3);
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            bitmap = (Bitmap) this.L$0;
            ResultKt.throwOnFailure(obj);
            Bitmap bitmap5 = (Bitmap) obj;
            if (bitmap5 != null) {
                ImageView imagePrise3 = this.$this_apply.welcomePrice2.imagePrise;
                Intrinsics.checkNotNullExpressionValue(imagePrise3, "imagePrise");
                UtilsKt.setImage(imagePrise3, bitmap5);
            } else {
                ImageView imagePrise4 = this.$this_apply.welcomePrice2.imagePrise;
                Intrinsics.checkNotNullExpressionValue(imagePrise4, "imagePrise");
                targetActivity2 = this.this$0.getTargetActivity();
                UtilsKt.setNotLoadedImage(imagePrise4, targetActivity2);
            }
            this.L$0 = SpillingKt.nullOutSpilledVariable(bitmap);
            this.L$1 = SpillingKt.nullOutSpilledVariable(bitmap5);
            this.label = 3;
            obj = BuildersKt.withContext(Dispatchers.getIO(), new Winter2025BattlePassScreen$setWelcomeScreen$1$4$bitmap3$1(this.this$0, null), this);
        }
        bitmap = (Bitmap) obj;
        if (bitmap != null) {
            ImageView imagePrise5 = this.$this_apply.welcomePrice1.imagePrise;
            Intrinsics.checkNotNullExpressionValue(imagePrise5, "imagePrise");
            UtilsKt.setImage(imagePrise5, bitmap);
        } else {
            ImageView imagePrise6 = this.$this_apply.welcomePrice1.imagePrise;
            Intrinsics.checkNotNullExpressionValue(imagePrise6, "imagePrise");
            targetActivity = this.this$0.getTargetActivity();
            UtilsKt.setNotLoadedImage(imagePrise6, targetActivity);
        }
        this.L$0 = SpillingKt.nullOutSpilledVariable(bitmap);
        this.label = 2;
        obj = BuildersKt.withContext(Dispatchers.getIO(), new Winter2025BattlePassScreen$setWelcomeScreen$1$4$bitmap2$1(this.this$0, null), this);
    }
}
