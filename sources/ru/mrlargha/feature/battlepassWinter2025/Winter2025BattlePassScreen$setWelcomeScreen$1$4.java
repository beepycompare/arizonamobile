package ru.mrlargha.feature.battlepassWinter2025;

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
import kotlinx.coroutines.CoroutineScope;
import ru.mrlargha.feature.battlepassWinter2025.databinding.WinterBattlepassWelcomeLayoutBinding;
/* compiled from: Winter2025BattlePass.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "ru.mrlargha.feature.battlepassWinter2025.Winter2025BattlePassScreen$setWelcomeScreen$1$4", f = "Winter2025BattlePass.kt", i = {}, l = {1305, 1306, 1307}, m = "invokeSuspend", n = {}, nl = {1306, 1307, 1308}, s = {}, v = 2)
/* loaded from: classes6.dex */
final class Winter2025BattlePassScreen$setWelcomeScreen$1$4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ WinterBattlepassWelcomeLayoutBinding $this_apply;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Winter2025BattlePassScreen$setWelcomeScreen$1$4(WinterBattlepassWelcomeLayoutBinding winterBattlepassWelcomeLayoutBinding, Continuation<? super Winter2025BattlePassScreen$setWelcomeScreen$1$4> continuation) {
        super(2, continuation);
        this.$this_apply = winterBattlepassWelcomeLayoutBinding;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new Winter2025BattlePassScreen$setWelcomeScreen$1$4(this.$this_apply, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((Winter2025BattlePassScreen$setWelcomeScreen$1$4) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0040, code lost:
        if (ru.mrlargha.commonui.utils.UtilsKt.loadGifFromZipAsync(r8, "battlepass", "welcomePrice1.gif", r7) == r0) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0057, code lost:
        if (ru.mrlargha.commonui.utils.UtilsKt.loadGifFromZipAsync(r8, "battlepass", "welcomePrice2.gif", r7) == r0) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x006e, code lost:
        if (ru.mrlargha.commonui.utils.UtilsKt.loadGifFromZipAsync(r8, "battlepass", "welcomePrice3.gif", r7) == r0) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0070, code lost:
        return r0;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ImageView imagePrise = this.$this_apply.welcomePrice1.imagePrise;
            Intrinsics.checkNotNullExpressionValue(imagePrise, "imagePrise");
            this.label = 1;
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else if (i != 2) {
            if (i == 3) {
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
            ImageView imagePrise2 = this.$this_apply.welcomePrice3.imagePrise;
            Intrinsics.checkNotNullExpressionValue(imagePrise2, "imagePrise");
            this.label = 3;
        }
        ImageView imagePrise3 = this.$this_apply.welcomePrice2.imagePrise;
        Intrinsics.checkNotNullExpressionValue(imagePrise3, "imagePrise");
        this.label = 2;
    }
}
