package ru.mrlargha.commonui.elements.battlepassWinter2025;

import android.graphics.Bitmap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import ru.mrlargha.commonui.utils.UtilsKt;
/* compiled from: Winter2025BattlePass.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Landroid/graphics/Bitmap;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "ru.mrlargha.commonui.elements.battlepassWinter2025.Winter2025BattlePassScreen$setupBuyPremiumPage$1$3$bitmap2$1", f = "Winter2025BattlePass.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
final class Winter2025BattlePassScreen$setupBuyPremiumPage$1$3$bitmap2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Bitmap>, Object> {
    int label;
    final /* synthetic */ Winter2025BattlePassScreen this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Winter2025BattlePassScreen$setupBuyPremiumPage$1$3$bitmap2$1(Winter2025BattlePassScreen winter2025BattlePassScreen, Continuation<? super Winter2025BattlePassScreen$setupBuyPremiumPage$1$3$bitmap2$1> continuation) {
        super(2, continuation);
        this.this$0 = winter2025BattlePassScreen;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new Winter2025BattlePassScreen$setupBuyPremiumPage$1$3$bitmap2$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Bitmap> continuation) {
        return ((Winter2025BattlePassScreen$setupBuyPremiumPage$1$3$bitmap2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        boolean z;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            z = this.this$0.isArizonaType;
            return UtilsKt.getIconFromArchive$default("battlepass", z ? 1003 : 6740, null, 4, null);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
