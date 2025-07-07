package androidx.compose.foundation.gestures;

import androidx.compose.foundation.gestures.TransformEvent;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.channels.Channel;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Transformable.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.TransformableKt$detectZoomByCtrlMouseScroll$2", f = "Transformable.kt", i = {0, 1}, l = {272, 284}, m = "invokeSuspend", n = {"$this$awaitPointerEventScope", "$this$awaitPointerEventScope"}, s = {"L$0", "L$0"})
/* loaded from: classes.dex */
public final class TransformableKt$detectZoomByCtrlMouseScroll$2 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Channel<TransformEvent> $channel;
    final /* synthetic */ CoroutineContext $currentContext;
    final /* synthetic */ ScrollConfig $scrollConfig;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TransformableKt$detectZoomByCtrlMouseScroll$2(CoroutineContext coroutineContext, ScrollConfig scrollConfig, Channel<TransformEvent> channel, Continuation<? super TransformableKt$detectZoomByCtrlMouseScroll$2> continuation) {
        super(2, continuation);
        this.$currentContext = coroutineContext;
        this.$scrollConfig = scrollConfig;
        this.$channel = channel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        TransformableKt$detectZoomByCtrlMouseScroll$2 transformableKt$detectZoomByCtrlMouseScroll$2 = new TransformableKt$detectZoomByCtrlMouseScroll$2(this.$currentContext, this.$scrollConfig, this.$channel, continuation);
        transformableKt$detectZoomByCtrlMouseScroll$2.L$0 = obj;
        return transformableKt$detectZoomByCtrlMouseScroll$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
        return ((TransformableKt$detectZoomByCtrlMouseScroll$2) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x008f, code lost:
        if (r13 == r0) goto L13;
     */
    /* JADX WARN: Removed duplicated region for block: B:19:0x003b A[Catch: all -> 0x0027, TRY_ENTER, TryCatch #0 {all -> 0x0027, blocks: (B:7:0x0012, B:26:0x0092, B:28:0x0096, B:23:0x0058, B:19:0x003b, B:22:0x004b, B:12:0x0023), top: B:35:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00ab  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x008f -> B:26:0x0092). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        AwaitPointerEventScope awaitPointerEventScope;
        long m3847unboximpl;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
                if (!JobKt.isActive(this.$currentContext)) {
                }
            } else if (i == 1) {
                awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                m3847unboximpl = ((Offset) obj).m3847unboximpl();
                this.$channel.mo7544trySendJP2dKIU(TransformEvent.TransformStarted.INSTANCE);
                this.$channel.mo7544trySendJP2dKIU(new TransformEvent.TransformDelta((float) Math.pow(2.0f, Float.intBitsToFloat((int) (m3847unboximpl & 4294967295L)) / 545.0f), Offset.Companion.m3853getZeroF1C5BW0(), 0.0f, null));
                this.L$0 = awaitPointerEventScope;
                this.label = 2;
                obj = TransformableKt.awaitCtrlMouseScrollOrNull(awaitPointerEventScope, this.$scrollConfig, this);
            } else if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                Offset offset = (Offset) obj;
                if (offset != null) {
                    m3847unboximpl = offset.m3847unboximpl();
                    this.$channel.mo7544trySendJP2dKIU(new TransformEvent.TransformDelta((float) Math.pow(2.0f, Float.intBitsToFloat((int) (m3847unboximpl & 4294967295L)) / 545.0f), Offset.Companion.m3853getZeroF1C5BW0(), 0.0f, null));
                    this.L$0 = awaitPointerEventScope;
                    this.label = 2;
                    obj = TransformableKt.awaitCtrlMouseScrollOrNull(awaitPointerEventScope, this.$scrollConfig, this);
                } else {
                    this.$channel.mo7544trySendJP2dKIU(TransformEvent.TransformStopped.INSTANCE);
                    if (!JobKt.isActive(this.$currentContext)) {
                        this.L$0 = awaitPointerEventScope;
                        this.label = 1;
                        obj = TransformableKt.awaitFirstCtrlMouseScroll(awaitPointerEventScope, this.$scrollConfig, this);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        m3847unboximpl = ((Offset) obj).m3847unboximpl();
                        this.$channel.mo7544trySendJP2dKIU(TransformEvent.TransformStarted.INSTANCE);
                        this.$channel.mo7544trySendJP2dKIU(new TransformEvent.TransformDelta((float) Math.pow(2.0f, Float.intBitsToFloat((int) (m3847unboximpl & 4294967295L)) / 545.0f), Offset.Companion.m3853getZeroF1C5BW0(), 0.0f, null));
                        this.L$0 = awaitPointerEventScope;
                        this.label = 2;
                        obj = TransformableKt.awaitCtrlMouseScrollOrNull(awaitPointerEventScope, this.$scrollConfig, this);
                    } else {
                        return Unit.INSTANCE;
                    }
                }
            }
        } catch (Throwable th) {
            this.$channel.mo7544trySendJP2dKIU(TransformEvent.TransformStopped.INSTANCE);
            throw th;
        }
    }
}
