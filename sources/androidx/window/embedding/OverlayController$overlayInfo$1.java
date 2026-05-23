package androidx.window.embedding;

import androidx.core.util.Consumer;
import androidx.media3.exoplayer.offline.DefaultDownloaderFactory$$ExternalSyntheticLambda0;
import androidx.media3.extractor.ts.TsExtractor;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
/* compiled from: OverlayController.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/channels/ProducerScope;", "Landroidx/window/embedding/OverlayInfo;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.window.embedding.OverlayController$overlayInfo$1", f = "OverlayController.kt", i = {}, l = {TsExtractor.TS_STREAM_TYPE_DTS_HD}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
final class OverlayController$overlayInfo$1 extends SuspendLambda implements Function2<ProducerScope<? super OverlayInfo>, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $overlayTag;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ OverlayController this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OverlayController$overlayInfo$1(OverlayController overlayController, String str, Continuation<? super OverlayController$overlayInfo$1> continuation) {
        super(2, continuation);
        this.this$0 = overlayController;
        this.$overlayTag = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        OverlayController$overlayInfo$1 overlayController$overlayInfo$1 = new OverlayController$overlayInfo$1(this.this$0, this.$overlayTag, continuation);
        overlayController$overlayInfo$1.L$0 = obj;
        return overlayController$overlayInfo$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(ProducerScope<? super OverlayInfo> producerScope, Continuation<? super Unit> continuation) {
        return ((OverlayController$overlayInfo$1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        EmbeddingBackend embeddingBackend;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            final ProducerScope producerScope = (ProducerScope) this.L$0;
            final Consumer<OverlayInfo> consumer = new Consumer() { // from class: androidx.window.embedding.OverlayController$overlayInfo$1$$ExternalSyntheticLambda0
                @Override // androidx.core.util.Consumer
                public final void accept(Object obj2) {
                    ProducerScope.this.mo9005trySendJP2dKIU((OverlayInfo) obj2);
                }
            };
            embeddingBackend = this.this$0.backend;
            embeddingBackend.addOverlayInfoCallback(this.$overlayTag, new DefaultDownloaderFactory$$ExternalSyntheticLambda0(), consumer);
            final OverlayController overlayController = this.this$0;
            this.label = 1;
            if (ProduceKt.awaitClose(producerScope, new Function0() { // from class: androidx.window.embedding.OverlayController$overlayInfo$1$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return OverlayController$overlayInfo$1.invokeSuspend$lambda$1(OverlayController.this, consumer);
                }
            }, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit invokeSuspend$lambda$1(OverlayController overlayController, Consumer consumer) {
        EmbeddingBackend embeddingBackend;
        embeddingBackend = overlayController.backend;
        embeddingBackend.removeOverlayInfoCallback(consumer);
        return Unit.INSTANCE;
    }
}
