package androidx.window.layout;

import android.app.Activity;
import androidx.compose.ui.spatial.RectListKt;
import androidx.core.util.Consumer;
import androidx.media3.exoplayer.offline.DefaultDownloaderFactory$$ExternalSyntheticLambda0;
import androidx.window.layout.adapter.WindowBackend;
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
/* compiled from: WindowInfoTrackerImpl.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/channels/ProducerScope;", "Landroidx/window/layout/WindowLayoutInfo;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.window.layout.WindowInfoTrackerImpl$windowLayoutInfo$2", f = "WindowInfoTrackerImpl.kt", i = {}, l = {RectListKt.BitOffsetForGesturable}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
final class WindowInfoTrackerImpl$windowLayoutInfo$2 extends SuspendLambda implements Function2<ProducerScope<? super WindowLayoutInfo>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Activity $activity;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ WindowInfoTrackerImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WindowInfoTrackerImpl$windowLayoutInfo$2(WindowInfoTrackerImpl windowInfoTrackerImpl, Activity activity, Continuation<? super WindowInfoTrackerImpl$windowLayoutInfo$2> continuation) {
        super(2, continuation);
        this.this$0 = windowInfoTrackerImpl;
        this.$activity = activity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        WindowInfoTrackerImpl$windowLayoutInfo$2 windowInfoTrackerImpl$windowLayoutInfo$2 = new WindowInfoTrackerImpl$windowLayoutInfo$2(this.this$0, this.$activity, continuation);
        windowInfoTrackerImpl$windowLayoutInfo$2.L$0 = obj;
        return windowInfoTrackerImpl$windowLayoutInfo$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(ProducerScope<? super WindowLayoutInfo> producerScope, Continuation<? super Unit> continuation) {
        return ((WindowInfoTrackerImpl$windowLayoutInfo$2) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        WindowBackend windowBackend;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            final ProducerScope producerScope = (ProducerScope) this.L$0;
            final Consumer<WindowLayoutInfo> consumer = new Consumer() { // from class: androidx.window.layout.WindowInfoTrackerImpl$windowLayoutInfo$2$$ExternalSyntheticLambda0
                @Override // androidx.core.util.Consumer
                public final void accept(Object obj2) {
                    ProducerScope.this.mo9005trySendJP2dKIU((WindowLayoutInfo) obj2);
                }
            };
            windowBackend = this.this$0.windowBackend;
            windowBackend.registerLayoutChangeCallback(this.$activity, new DefaultDownloaderFactory$$ExternalSyntheticLambda0(), consumer);
            final WindowInfoTrackerImpl windowInfoTrackerImpl = this.this$0;
            this.label = 1;
            if (ProduceKt.awaitClose(producerScope, new Function0() { // from class: androidx.window.layout.WindowInfoTrackerImpl$windowLayoutInfo$2$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return WindowInfoTrackerImpl$windowLayoutInfo$2.invokeSuspend$lambda$1(WindowInfoTrackerImpl.this, consumer);
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
    public static final Unit invokeSuspend$lambda$1(WindowInfoTrackerImpl windowInfoTrackerImpl, Consumer consumer) {
        WindowBackend windowBackend;
        windowBackend = windowInfoTrackerImpl.windowBackend;
        windowBackend.unregisterLayoutChangeCallback(consumer);
        return Unit.INSTANCE;
    }
}
