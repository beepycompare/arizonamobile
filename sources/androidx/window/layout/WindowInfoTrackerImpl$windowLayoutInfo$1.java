package androidx.window.layout;

import android.content.Context;
import androidx.constraintlayout.widget.ConstraintLayout;
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
@DebugMetadata(c = "androidx.window.layout.WindowInfoTrackerImpl$windowLayoutInfo$1", f = "WindowInfoTrackerImpl.kt", i = {}, l = {ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_TOP_OF}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
final class WindowInfoTrackerImpl$windowLayoutInfo$1 extends SuspendLambda implements Function2<ProducerScope<? super WindowLayoutInfo>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ WindowInfoTrackerImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WindowInfoTrackerImpl$windowLayoutInfo$1(WindowInfoTrackerImpl windowInfoTrackerImpl, Context context, Continuation<? super WindowInfoTrackerImpl$windowLayoutInfo$1> continuation) {
        super(2, continuation);
        this.this$0 = windowInfoTrackerImpl;
        this.$context = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        WindowInfoTrackerImpl$windowLayoutInfo$1 windowInfoTrackerImpl$windowLayoutInfo$1 = new WindowInfoTrackerImpl$windowLayoutInfo$1(this.this$0, this.$context, continuation);
        windowInfoTrackerImpl$windowLayoutInfo$1.L$0 = obj;
        return windowInfoTrackerImpl$windowLayoutInfo$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(ProducerScope<? super WindowLayoutInfo> producerScope, Continuation<? super Unit> continuation) {
        return ((WindowInfoTrackerImpl$windowLayoutInfo$1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        WindowBackend windowBackend;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            final ProducerScope producerScope = (ProducerScope) this.L$0;
            final Consumer<WindowLayoutInfo> consumer = new Consumer() { // from class: androidx.window.layout.WindowInfoTrackerImpl$windowLayoutInfo$1$$ExternalSyntheticLambda0
                @Override // androidx.core.util.Consumer
                public final void accept(Object obj2) {
                    ProducerScope.this.mo9143trySendJP2dKIU((WindowLayoutInfo) obj2);
                }
            };
            windowBackend = this.this$0.windowBackend;
            windowBackend.registerLayoutChangeCallback(this.$context, new DefaultDownloaderFactory$$ExternalSyntheticLambda0(), consumer);
            final WindowInfoTrackerImpl windowInfoTrackerImpl = this.this$0;
            this.label = 1;
            if (ProduceKt.awaitClose(producerScope, new Function0() { // from class: androidx.window.layout.WindowInfoTrackerImpl$windowLayoutInfo$1$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit invokeSuspend$lambda$1;
                    invokeSuspend$lambda$1 = WindowInfoTrackerImpl$windowLayoutInfo$1.invokeSuspend$lambda$1(WindowInfoTrackerImpl.this, consumer);
                    return invokeSuspend$lambda$1;
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$1(WindowInfoTrackerImpl windowInfoTrackerImpl, Consumer consumer) {
        WindowBackend windowBackend;
        windowBackend = windowInfoTrackerImpl.windowBackend;
        windowBackend.unregisterLayoutChangeCallback(consumer);
        return Unit.INSTANCE;
    }
}
