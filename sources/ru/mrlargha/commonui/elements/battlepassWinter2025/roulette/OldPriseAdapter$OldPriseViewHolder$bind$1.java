package ru.mrlargha.commonui.elements.battlepassWinter2025.roulette;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import androidx.media3.extractor.ts.TsExtractor;
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
import ru.mrlargha.commonui.databinding.WinterBattlepassRouletteOldPriseItemBinding;
import ru.mrlargha.commonui.elements.battlepassWinter2025.roulette.OldPriseAdapter;
import ru.mrlargha.commonui.elements.battlepassWinter2025.roulette.data.OldPrise;
import ru.mrlargha.commonui.utils.UtilsKt;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OldPriseAdapter.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "ru.mrlargha.commonui.elements.battlepassWinter2025.roulette.OldPriseAdapter$OldPriseViewHolder$bind$1", f = "OldPriseAdapter.kt", i = {}, l = {TsExtractor.TS_SYNC_BYTE}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
public final class OldPriseAdapter$OldPriseViewHolder$bind$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ OldPrise $prise;
    int label;
    final /* synthetic */ OldPriseAdapter.OldPriseViewHolder this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OldPriseAdapter$OldPriseViewHolder$bind$1(OldPriseAdapter.OldPriseViewHolder oldPriseViewHolder, OldPrise oldPrise, Continuation<? super OldPriseAdapter$OldPriseViewHolder$bind$1> continuation) {
        super(2, continuation);
        this.this$0 = oldPriseViewHolder;
        this.$prise = oldPrise;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new OldPriseAdapter$OldPriseViewHolder$bind$1(this.this$0, this.$prise, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((OldPriseAdapter$OldPriseViewHolder$bind$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        WinterBattlepassRouletteOldPriseItemBinding winterBattlepassRouletteOldPriseItemBinding;
        WinterBattlepassRouletteOldPriseItemBinding winterBattlepassRouletteOldPriseItemBinding2;
        WinterBattlepassRouletteOldPriseItemBinding winterBattlepassRouletteOldPriseItemBinding3;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = BuildersKt.withContext(Dispatchers.getIO(), new OldPriseAdapter$OldPriseViewHolder$bind$1$bitmap$1(this.$prise, null), this);
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
            winterBattlepassRouletteOldPriseItemBinding3 = this.this$0.binding;
            ImageView imagePrise = winterBattlepassRouletteOldPriseItemBinding3.imagePrise;
            Intrinsics.checkNotNullExpressionValue(imagePrise, "imagePrise");
            UtilsKt.setImage(imagePrise, bitmap);
        } else {
            winterBattlepassRouletteOldPriseItemBinding = this.this$0.binding;
            ImageView imagePrise2 = winterBattlepassRouletteOldPriseItemBinding.imagePrise;
            Intrinsics.checkNotNullExpressionValue(imagePrise2, "imagePrise");
            winterBattlepassRouletteOldPriseItemBinding2 = this.this$0.binding;
            Context context = winterBattlepassRouletteOldPriseItemBinding2.getRoot().getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            UtilsKt.setNotLoadedImage(imagePrise2, context);
        }
        return Unit.INSTANCE;
    }
}
