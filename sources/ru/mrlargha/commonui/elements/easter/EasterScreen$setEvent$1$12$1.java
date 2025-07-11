package ru.mrlargha.commonui.elements.easter;

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
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.databinding.EasterBattlePassEventItemBinding;
import ru.mrlargha.commonui.utils.UtilsKt;
/* compiled from: EasterScreen.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "ru.mrlargha.commonui.elements.easter.EasterScreen$setEvent$1$12$1", f = "EasterScreen.kt", i = {}, l = {458}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
final class EasterScreen$setEvent$1$12$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $it;
    final /* synthetic */ EasterBattlePassEventItemBinding $this_apply;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EasterScreen$setEvent$1$12$1(EasterBattlePassEventItemBinding easterBattlePassEventItemBinding, String str, Continuation<? super EasterScreen$setEvent$1$12$1> continuation) {
        super(2, continuation);
        this.$this_apply = easterBattlePassEventItemBinding;
        this.$it = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new EasterScreen$setEvent$1$12$1(this.$this_apply, this.$it, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((EasterScreen$setEvent$1$12$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = BuildersKt.withContext(Dispatchers.getIO(), new EasterScreen$setEvent$1$12$1$bitmap$1(this.$it, null), this);
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
            ImageView ivEventBg = this.$this_apply.ivEventBg;
            Intrinsics.checkNotNullExpressionValue(ivEventBg, "ivEventBg");
            UtilsKt.setImage(ivEventBg, bitmap);
        }
        if (bitmap == null) {
            this.$this_apply.ivEventBg.setImageResource(R.drawable.easter_battle_pass_task_item_bg_test);
        }
        return Unit.INSTANCE;
    }
}
