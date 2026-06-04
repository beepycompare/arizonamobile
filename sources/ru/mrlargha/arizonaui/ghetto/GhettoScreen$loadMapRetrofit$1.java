package ru.mrlargha.arizonaui.ghetto;

import androidx.compose.runtime.GapComposerKt;
import java.util.List;
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
import ru.mrlargha.arizonaui.databinding.GhettoMainBinding;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GhettoScreen.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "ru.mrlargha.arizonaui.ghetto.GhettoScreen$loadMapRetrofit$1", f = "GhettoScreen.kt", i = {}, l = {GapComposerKt.nodeKey}, m = "invokeSuspend", n = {}, nl = {128}, s = {}, v = 2)
/* loaded from: classes6.dex */
public final class GhettoScreen$loadMapRetrofit$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ GhettoScreen this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GhettoScreen$loadMapRetrofit$1(GhettoScreen ghettoScreen, Continuation<? super GhettoScreen$loadMapRetrofit$1> continuation) {
        super(2, continuation);
        this.this$0 = ghettoScreen;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GhettoScreen$loadMapRetrofit$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((GhettoScreen$loadMapRetrofit$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        List list;
        GhettoMainBinding ghettoMainBinding;
        List list2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            list = this.this$0.mapInfo;
            if (list.isEmpty()) {
                this.label = 1;
                obj = BuildersKt.withContext(Dispatchers.getIO(), new GhettoScreen$loadMapRetrofit$1$listFamilies$1(this.this$0, null), this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            ghettoMainBinding = this.this$0.binding;
            GridOverlayView overlayView = ghettoMainBinding.map.overlayView;
            Intrinsics.checkNotNullExpressionValue(overlayView, "overlayView");
            list2 = this.this$0.mapInfo;
            GridOverlayView.setDataAndTryToDraw$default(overlayView, list2, null, 2, null);
            return Unit.INSTANCE;
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        this.this$0.mapInfo = (List) obj;
        ghettoMainBinding = this.this$0.binding;
        GridOverlayView overlayView2 = ghettoMainBinding.map.overlayView;
        Intrinsics.checkNotNullExpressionValue(overlayView2, "overlayView");
        list2 = this.this$0.mapInfo;
        GridOverlayView.setDataAndTryToDraw$default(overlayView2, list2, null, 2, null);
        return Unit.INSTANCE;
    }
}
