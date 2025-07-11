package androidx.window.layout;

import android.app.Activity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.util.Consumer;
import androidx.media3.exoplayer.offline.DefaultDownloaderFactory$$ExternalSyntheticLambda0;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.flow.FlowCollector;
/* compiled from: WindowInfoTrackerImpl.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Landroidx/window/layout/WindowLayoutInfo;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "androidx.window.layout.WindowInfoTrackerImpl$windowLayoutInfo$1", f = "WindowInfoTrackerImpl.kt", i = {0, 0, 1, 1}, l = {ConstraintLayout.LayoutParams.Table.LAYOUT_MARGIN_BASELINE, ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE}, m = "invokeSuspend", n = {"$this$flow", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "$this$flow", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER}, s = {"L$0", "L$1", "L$0", "L$1"})
/* loaded from: classes3.dex */
final class WindowInfoTrackerImpl$windowLayoutInfo$1 extends SuspendLambda implements Function2<FlowCollector<? super WindowLayoutInfo>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Activity $activity;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ WindowInfoTrackerImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WindowInfoTrackerImpl$windowLayoutInfo$1(WindowInfoTrackerImpl windowInfoTrackerImpl, Activity activity, Continuation<? super WindowInfoTrackerImpl$windowLayoutInfo$1> continuation) {
        super(2, continuation);
        this.this$0 = windowInfoTrackerImpl;
        this.$activity = activity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        WindowInfoTrackerImpl$windowLayoutInfo$1 windowInfoTrackerImpl$windowLayoutInfo$1 = new WindowInfoTrackerImpl$windowLayoutInfo$1(this.this$0, this.$activity, continuation);
        windowInfoTrackerImpl$windowLayoutInfo$1.L$0 = obj;
        return windowInfoTrackerImpl$windowLayoutInfo$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FlowCollector<? super WindowLayoutInfo> flowCollector, Continuation<? super Unit> continuation) {
        return ((WindowInfoTrackerImpl$windowLayoutInfo$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0093, code lost:
        if (r5.emit((androidx.window.layout.WindowLayoutInfo) r1.next(), r9) == r0) goto L12;
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x007e A[Catch: all -> 0x00a2, TRY_LEAVE, TryCatch #0 {all -> 0x00a2, blocks: (B:7:0x001a, B:16:0x0061, B:20:0x0076, B:22:0x007e, B:12:0x0033, B:15:0x005d), top: B:30:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0096  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0093 -> B:8:0x001d). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        WindowBackend windowBackend;
        FlowCollector flowCollector;
        Consumer<WindowLayoutInfo> consumer;
        WindowBackend windowBackend2;
        ChannelIterator it;
        FlowCollector flowCollector2;
        WindowBackend windowBackend3;
        Object hasNext;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                flowCollector = (FlowCollector) this.L$0;
                final Channel Channel$default = ChannelKt.Channel$default(10, BufferOverflow.DROP_OLDEST, null, 4, null);
                consumer = new Consumer() { // from class: androidx.window.layout.WindowInfoTrackerImpl$windowLayoutInfo$1$$ExternalSyntheticLambda0
                    @Override // androidx.core.util.Consumer
                    public final void accept(Object obj2) {
                        WindowInfoTrackerImpl$windowLayoutInfo$1.m7723invokeSuspend$lambda0(Channel.this, (WindowLayoutInfo) obj2);
                    }
                };
                windowBackend2 = this.this$0.windowBackend;
                windowBackend2.registerLayoutChangeCallback(this.$activity, new DefaultDownloaderFactory$$ExternalSyntheticLambda0(), consumer);
                it = Channel$default.iterator();
                this.L$0 = flowCollector;
                this.L$1 = consumer;
                this.L$2 = it;
                this.label = 1;
                hasNext = it.hasNext(this);
                if (hasNext != coroutine_suspended) {
                }
            } else if (i == 1) {
                it = (ChannelIterator) this.L$2;
                consumer = (Consumer) this.L$1;
                flowCollector2 = (FlowCollector) this.L$0;
                ResultKt.throwOnFailure(obj);
                if (((Boolean) obj).booleanValue()) {
                }
            } else if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                it = (ChannelIterator) this.L$2;
                consumer = (Consumer) this.L$1;
                flowCollector2 = (FlowCollector) this.L$0;
                ResultKt.throwOnFailure(obj);
                flowCollector = flowCollector2;
                this.L$0 = flowCollector;
                this.L$1 = consumer;
                this.L$2 = it;
                this.label = 1;
                hasNext = it.hasNext(this);
                if (hasNext != coroutine_suspended) {
                    return coroutine_suspended;
                }
                flowCollector2 = flowCollector;
                obj = hasNext;
                if (((Boolean) obj).booleanValue()) {
                    windowBackend3 = this.this$0.windowBackend;
                    windowBackend3.unregisterLayoutChangeCallback(consumer);
                    return Unit.INSTANCE;
                }
                this.L$0 = flowCollector2;
                this.L$1 = consumer;
                this.L$2 = it;
                this.label = 2;
            }
        } catch (Throwable th) {
            windowBackend = this.this$0.windowBackend;
            windowBackend.unregisterLayoutChangeCallback(consumer);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invokeSuspend$lambda-0  reason: not valid java name */
    public static final void m7723invokeSuspend$lambda0(Channel channel, WindowLayoutInfo info) {
        Intrinsics.checkNotNullExpressionValue(info, "info");
        channel.mo7544trySendJP2dKIU(info);
    }
}
