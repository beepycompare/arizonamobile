package androidx.compose.foundation.gestures;

import androidx.compose.foundation.ComposeFoundationFlags;
import androidx.compose.foundation.gestures.TransformEvent;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.HistoricalChange;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventKt;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerEventType;
import androidx.compose.ui.input.pointer.PointerEvent_androidKt;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputScope;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelResult;
/* compiled from: Transformable.kt */
@Metadata(d1 = {"\u0000P\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a&\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u001a:\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00050\b2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u001a(\u0010\f\u001a\u00020\r*\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u0082@¢\u0006\u0002\u0010\u0014\u001a\u001e\u0010\u0015\u001a\u0004\u0018\u00010\t*\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0012\u001a\u00020\u0013H\u0002\u001a\u0016\u0010\u0019\u001a\u0004\u0018\u00010\t*\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002\u001a\u001b\u0010\u001a\u001a\u0004\u0018\u00010\u000b*\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002¢\u0006\u0002\u0010\u001b\u001a<\u0010\u001c\u001a\u00020\r*\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u00052\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00050\bH\u0082@¢\u0006\u0002\u0010\u001e\"\u000e\u0010\n\u001a\u00020\u000bX\u0080T¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"transformable", "Landroidx/compose/ui/Modifier;", RemoteConfigConstants.ResponseFieldKey.STATE, "Landroidx/compose/foundation/gestures/TransformableState;", "lockRotationOnZoomPan", "", "enabled", "canPan", "Lkotlin/Function1;", "Landroidx/compose/ui/geometry/Offset;", "SCROLL_FACTOR", "", "detectNonTouchGestures", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "channel", "Lkotlinx/coroutines/channels/Channel;", "Landroidx/compose/foundation/gestures/TransformEvent;", "scrollConfig", "Landroidx/compose/foundation/gestures/ScrollConfig;", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Lkotlinx/coroutines/channels/Channel;Landroidx/compose/foundation/gestures/ScrollConfig;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "consumePointerEventAsCtrlScrollOrNull", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "pointer", "Landroidx/compose/ui/input/pointer/PointerEvent;", "consumePointerEventAsPanOrNull", "consumePointerEventAsScaleOrNull", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Landroidx/compose/ui/input/pointer/PointerEvent;)Ljava/lang/Float;", "detectZoom", "panZoomLock", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;ZLkotlinx/coroutines/channels/Channel;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TransformableKt {
    public static final float SCROLL_FACTOR = 545.0f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean transformable$lambda$0(Offset offset) {
        return true;
    }

    public static /* synthetic */ Modifier transformable$default(Modifier modifier, TransformableState transformableState, boolean z, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            z2 = true;
        }
        return transformable(modifier, transformableState, z, z2);
    }

    public static final Modifier transformable(Modifier modifier, TransformableState transformableState, boolean z, boolean z2) {
        return transformable(modifier, transformableState, new Function1() { // from class: androidx.compose.foundation.gestures.TransformableKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(TransformableKt.transformable$lambda$0((Offset) obj));
            }
        }, z, z2);
    }

    public static /* synthetic */ Modifier transformable$default(Modifier modifier, TransformableState transformableState, Function1 function1, boolean z, boolean z2, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        if ((i & 8) != 0) {
            z2 = true;
        }
        return transformable(modifier, transformableState, function1, z, z2);
    }

    public static final Modifier transformable(Modifier modifier, TransformableState transformableState, Function1<? super Offset, Boolean> function1, boolean z, boolean z2) {
        return modifier.then(new TransformableElement(transformableState, function1, z, z2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Offset consumePointerEventAsCtrlScrollOrNull(AwaitPointerEventScope awaitPointerEventScope, PointerEvent pointerEvent, ScrollConfig scrollConfig) {
        long m5119getZeroF1C5BW0;
        if (PointerEvent_androidKt.m6649isCtrlPressed5xRPYO0(pointerEvent.m6617getKeyboardModifiersk7X9c1A()) && (PointerEventType.m6625equalsimpl0(pointerEvent.m6618getType7fucELk(), PointerEventType.Companion.m6640getScroll7fucELk()) || PointerEventType.m6625equalsimpl0(pointerEvent.m6618getType7fucELk(), PointerEventType.Companion.m6634getPanStart7fucELk()) || PointerEventType.m6625equalsimpl0(pointerEvent.m6618getType7fucELk(), PointerEventType.Companion.m6633getPanMove7fucELk()) || PointerEventType.m6625equalsimpl0(pointerEvent.m6618getType7fucELk(), PointerEventType.Companion.m6632getPanEnd7fucELk()))) {
            long mo455calculateMouseWheelScroll8xgXZGE = scrollConfig.mo455calculateMouseWheelScroll8xgXZGE(awaitPointerEventScope, pointerEvent, awaitPointerEventScope.mo6570getSizeYbymL2g());
            if (ComposeFoundationFlags.isTrackpadGestureHandlingEnabled) {
                PointerInputChange pointerInputChange = (PointerInputChange) CollectionsKt.firstOrNull((List<? extends Object>) pointerEvent.getChanges());
                if (pointerInputChange == null) {
                    m5119getZeroF1C5BW0 = Offset.Companion.m5119getZeroF1C5BW0();
                } else {
                    long m5095constructorimpl = Offset.m5095constructorimpl(pointerInputChange.m6684getPanOffsetF1C5BW0() ^ (-9223372034707292160L));
                    List<HistoricalChange> historical = pointerInputChange.getHistorical();
                    Offset m5092boximpl = Offset.m5092boximpl(Offset.Companion.m5119getZeroF1C5BW0());
                    int size = historical.size();
                    for (int i = 0; i < size; i++) {
                        m5092boximpl = Offset.m5092boximpl(Offset.m5107minusMKHz9U(m5092boximpl.m5113unboximpl(), historical.get(i).m6585getPanOffsetF1C5BW0()));
                    }
                    m5119getZeroF1C5BW0 = Offset.m5108plusMKHz9U(m5095constructorimpl, m5092boximpl.m5113unboximpl());
                }
            } else {
                m5119getZeroF1C5BW0 = Offset.Companion.m5119getZeroF1C5BW0();
            }
            long m5108plusMKHz9U = Offset.m5108plusMKHz9U(mo455calculateMouseWheelScroll8xgXZGE, m5119getZeroF1C5BW0);
            if (Offset.m5100equalsimpl0(m5108plusMKHz9U, Offset.Companion.m5119getZeroF1C5BW0())) {
                return null;
            }
            List<PointerInputChange> changes = pointerEvent.getChanges();
            int size2 = changes.size();
            for (int i2 = 0; i2 < size2; i2++) {
                changes.get(i2).consume();
            }
            return Offset.m5092boximpl(m5108plusMKHz9U);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Offset consumePointerEventAsPanOrNull(AwaitPointerEventScope awaitPointerEventScope, PointerEvent pointerEvent) {
        long m5119getZeroF1C5BW0;
        if (ComposeFoundationFlags.isTrackpadGestureHandlingEnabled && (PointerEventType.m6625equalsimpl0(pointerEvent.m6618getType7fucELk(), PointerEventType.Companion.m6634getPanStart7fucELk()) || PointerEventType.m6625equalsimpl0(pointerEvent.m6618getType7fucELk(), PointerEventType.Companion.m6633getPanMove7fucELk()) || PointerEventType.m6625equalsimpl0(pointerEvent.m6618getType7fucELk(), PointerEventType.Companion.m6632getPanEnd7fucELk()))) {
            PointerInputChange pointerInputChange = (PointerInputChange) CollectionsKt.firstOrNull((List<? extends Object>) pointerEvent.getChanges());
            if (pointerInputChange == null) {
                m5119getZeroF1C5BW0 = Offset.Companion.m5119getZeroF1C5BW0();
            } else {
                long m5095constructorimpl = Offset.m5095constructorimpl(pointerInputChange.m6684getPanOffsetF1C5BW0() ^ (-9223372034707292160L));
                List<HistoricalChange> historical = pointerInputChange.getHistorical();
                Offset m5092boximpl = Offset.m5092boximpl(Offset.Companion.m5119getZeroF1C5BW0());
                int size = historical.size();
                for (int i = 0; i < size; i++) {
                    m5092boximpl = Offset.m5092boximpl(Offset.m5107minusMKHz9U(m5092boximpl.m5113unboximpl(), historical.get(i).m6585getPanOffsetF1C5BW0()));
                }
                m5119getZeroF1C5BW0 = Offset.m5108plusMKHz9U(m5095constructorimpl, m5092boximpl.m5113unboximpl());
            }
            if (Offset.m5100equalsimpl0(m5119getZeroF1C5BW0, Offset.Companion.m5119getZeroF1C5BW0())) {
                return null;
            }
            List<PointerInputChange> changes = pointerEvent.getChanges();
            int size2 = changes.size();
            for (int i2 = 0; i2 < size2; i2++) {
                changes.get(i2).consume();
            }
            return Offset.m5092boximpl(m5119getZeroF1C5BW0);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Float consumePointerEventAsScaleOrNull(AwaitPointerEventScope awaitPointerEventScope, PointerEvent pointerEvent) {
        if (ComposeFoundationFlags.isTrackpadGestureHandlingEnabled && (PointerEventType.m6625equalsimpl0(pointerEvent.m6618getType7fucELk(), PointerEventType.Companion.m6639getScaleStart7fucELk()) || PointerEventType.m6625equalsimpl0(pointerEvent.m6618getType7fucELk(), PointerEventType.Companion.m6637getScaleChange7fucELk()) || PointerEventType.m6625equalsimpl0(pointerEvent.m6618getType7fucELk(), PointerEventType.Companion.m6638getScaleEnd7fucELk()))) {
            List<PointerInputChange> changes = pointerEvent.getChanges();
            int size = changes.size();
            float f = 1.0f;
            for (int i = 0; i < size; i++) {
                PointerInputChange pointerInputChange = changes.get(i);
                f *= pointerInputChange.getScaleFactor();
                List<HistoricalChange> historical = pointerInputChange.getHistorical();
                int size2 = historical.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    f *= historical.get(i2).getScaleFactor();
                }
            }
            if (f == 1.0f) {
                return null;
            }
            List<PointerInputChange> changes2 = pointerEvent.getChanges();
            int size3 = changes2.size();
            for (int i3 = 0; i3 < size3; i3++) {
                changes2.get(i3).consume();
            }
            return Float.valueOf(f);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x031e, code lost:
        if (r6 != 0) goto L111;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x0320, code lost:
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0153, code lost:
        if (androidx.compose.foundation.ComposeFoundationFlags.isTrackpadGestureHandlingEnabled == false) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0163, code lost:
        if (androidx.compose.ui.input.pointer.PointerEventType.m6625equalsimpl0(r0.m6618getType7fucELk(), androidx.compose.ui.input.pointer.PointerEventType.Companion.m6634getPanStart7fucELk()) == false) goto L95;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0173, code lost:
        if (androidx.compose.ui.input.pointer.PointerEventType.m6625equalsimpl0(r0.m6618getType7fucELk(), androidx.compose.ui.input.pointer.PointerEventType.Companion.m6633getPanMove7fucELk()) == false) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0183, code lost:
        if (androidx.compose.ui.input.pointer.PointerEventType.m6625equalsimpl0(r0.m6618getType7fucELk(), androidx.compose.ui.input.pointer.PointerEventType.Companion.m6632getPanEnd7fucELk()) == false) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0193, code lost:
        if (androidx.compose.ui.input.pointer.PointerEventType.m6625equalsimpl0(r0.m6618getType7fucELk(), androidx.compose.ui.input.pointer.PointerEventType.Companion.m6639getScaleStart7fucELk()) == false) goto L101;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x01a3, code lost:
        if (androidx.compose.ui.input.pointer.PointerEventType.m6625equalsimpl0(r0.m6618getType7fucELk(), androidx.compose.ui.input.pointer.PointerEventType.Companion.m6637getScaleChange7fucELk()) == false) goto L103;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x01b3, code lost:
        if (androidx.compose.ui.input.pointer.PointerEventType.m6625equalsimpl0(r0.m6618getType7fucELk(), androidx.compose.ui.input.pointer.PointerEventType.Companion.m6638getScaleEnd7fucELk()) == false) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x01b5, code lost:
        r2 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x01b7, code lost:
        r2 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x026c, code lost:
        if (r13.invoke(androidx.compose.ui.geometry.Offset.m5092boximpl(r14)).booleanValue() != false) goto L64;
     */
    /* JADX WARN: Removed duplicated region for block: B:100:0x0312  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0338  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0325 A[EDGE_INSN: B:116:0x0325->B:105:0x0325 ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0151 A[EDGE_INSN: B:121:0x0151->B:32:0x0151 ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0238  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0292  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x02a4  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x02af  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x02ef  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:97:0x02ef -> B:98:0x02ff). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object detectZoom(AwaitPointerEventScope awaitPointerEventScope, boolean z, Channel<TransformEvent> channel, Function1<? super Offset, Boolean> function1, Continuation<? super Unit> continuation) {
        TransformableKt$detectZoom$1 transformableKt$detectZoom$1;
        Object obj;
        Object coroutine_suspended;
        int i;
        Channel<TransformEvent> channel2;
        Function1<? super Offset, Boolean> function12;
        boolean z2;
        float f;
        long j;
        int i2;
        int i3;
        float f2;
        float f3;
        AwaitPointerEventScope awaitPointerEventScope2;
        Function1<? super Offset, Boolean> function13;
        Channel<TransformEvent> channel3;
        AwaitPointerEventScope awaitPointerEventScope3;
        float f4;
        boolean z3;
        int size;
        int i4;
        int i5;
        TransformableKt$detectZoom$1 transformableKt$detectZoom$12;
        long j2;
        float f5;
        float f6;
        int i6;
        TransformableKt$detectZoom$1 transformableKt$detectZoom$13;
        Object awaitPointerEvent;
        float f7;
        int i7;
        boolean z4;
        AwaitPointerEventScope awaitPointerEventScope4;
        PointerEvent pointerEvent;
        int i8;
        float f8;
        float f9;
        long j3;
        int i9;
        int size2;
        int i10;
        int size3;
        int i11;
        int size4;
        int i12;
        if (continuation instanceof TransformableKt$detectZoom$1) {
            transformableKt$detectZoom$1 = (TransformableKt$detectZoom$1) continuation;
            if ((transformableKt$detectZoom$1.label & Integer.MIN_VALUE) != 0) {
                transformableKt$detectZoom$1.label -= Integer.MIN_VALUE;
                TransformableKt$detectZoom$1 transformableKt$detectZoom$14 = transformableKt$detectZoom$1;
                obj = transformableKt$detectZoom$14.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = transformableKt$detectZoom$14.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    long m5119getZeroF1C5BW0 = Offset.Companion.m5119getZeroF1C5BW0();
                    float touchSlop = awaitPointerEventScope.getViewConfiguration().getTouchSlop();
                    transformableKt$detectZoom$14.L$0 = awaitPointerEventScope;
                    channel2 = channel;
                    transformableKt$detectZoom$14.L$1 = channel2;
                    function12 = function1;
                    transformableKt$detectZoom$14.L$2 = function12;
                    z2 = z;
                    transformableKt$detectZoom$14.Z$0 = z2;
                    transformableKt$detectZoom$14.F$0 = 0.0f;
                    transformableKt$detectZoom$14.F$1 = 1.0f;
                    transformableKt$detectZoom$14.J$0 = m5119getZeroF1C5BW0;
                    transformableKt$detectZoom$14.I$0 = 0;
                    transformableKt$detectZoom$14.F$2 = touchSlop;
                    transformableKt$detectZoom$14.I$1 = 0;
                    transformableKt$detectZoom$14.label = 1;
                    if (TapGestureDetectorKt.awaitFirstDown$default(awaitPointerEventScope, false, null, transformableKt$detectZoom$14, 2, null) != coroutine_suspended) {
                        f = touchSlop;
                        j = m5119getZeroF1C5BW0;
                        i2 = 0;
                        i3 = 0;
                        f2 = 1.0f;
                        f3 = 0.0f;
                        awaitPointerEventScope2 = awaitPointerEventScope;
                    }
                    return coroutine_suspended;
                } else if (i != 1) {
                    if (i != 2) {
                        if (i == 3) {
                            i5 = transformableKt$detectZoom$14.I$2;
                            i7 = transformableKt$detectZoom$14.I$1;
                            f7 = transformableKt$detectZoom$14.F$2;
                            i6 = transformableKt$detectZoom$14.I$0;
                            j2 = transformableKt$detectZoom$14.J$0;
                            float f10 = transformableKt$detectZoom$14.F$1;
                            float f11 = transformableKt$detectZoom$14.F$0;
                            boolean z5 = transformableKt$detectZoom$14.Z$0;
                            pointerEvent = (PointerEvent) transformableKt$detectZoom$14.L$3;
                            ResultKt.throwOnFailure(obj);
                            f2 = f10;
                            z4 = z5;
                            f3 = f11;
                            awaitPointerEventScope4 = (AwaitPointerEventScope) transformableKt$detectZoom$14.L$0;
                            function12 = (Function1) transformableKt$detectZoom$14.L$2;
                            channel3 = (Channel) transformableKt$detectZoom$14.L$1;
                            transformableKt$detectZoom$13 = transformableKt$detectZoom$14;
                            awaitPointerEvent = obj;
                            List<PointerInputChange> changes = ((PointerEvent) awaitPointerEvent).getChanges();
                            size3 = changes.size();
                            Object obj2 = coroutine_suspended;
                            i11 = 0;
                            while (true) {
                                if (i11 >= size3) {
                                    break;
                                }
                                if (changes.get(i11).isConsumed()) {
                                    break;
                                }
                                i11++;
                            }
                            boolean z6 = false;
                            if (i5 == 0 && !z6) {
                                List<PointerInputChange> changes2 = pointerEvent.getChanges();
                                size4 = changes2.size();
                                for (i12 = 0; i12 < size4; i12++) {
                                    if (changes2.get(i12).getPressed()) {
                                        i2 = i7;
                                        f = f7;
                                        i3 = i6;
                                        transformableKt$detectZoom$14 = transformableKt$detectZoom$13;
                                        channel2 = channel3;
                                        awaitPointerEventScope2 = awaitPointerEventScope4;
                                        coroutine_suspended = obj2;
                                        z2 = z4;
                                        j = j2;
                                    }
                                }
                            }
                            return Unit.INSTANCE;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    i2 = transformableKt$detectZoom$14.I$1;
                    f = transformableKt$detectZoom$14.F$2;
                    i3 = transformableKt$detectZoom$14.I$0;
                    j = transformableKt$detectZoom$14.J$0;
                    f2 = transformableKt$detectZoom$14.F$1;
                    float f12 = transformableKt$detectZoom$14.F$0;
                    boolean z7 = transformableKt$detectZoom$14.Z$0;
                    channel3 = (Channel) transformableKt$detectZoom$14.L$1;
                    AwaitPointerEventScope awaitPointerEventScope5 = (AwaitPointerEventScope) transformableKt$detectZoom$14.L$0;
                    ResultKt.throwOnFailure(obj);
                    f4 = f12;
                    z3 = z7;
                    function13 = (Function1) transformableKt$detectZoom$14.L$2;
                    awaitPointerEventScope3 = awaitPointerEventScope5;
                    PointerEvent pointerEvent2 = (PointerEvent) obj;
                    List<PointerInputChange> changes3 = pointerEvent2.getChanges();
                    size = changes3.size();
                    int i13 = i2;
                    i4 = 0;
                    while (true) {
                        if (i4 >= size) {
                            break;
                        } else if (changes3.get(i4).isConsumed()) {
                            break;
                        } else {
                            i4++;
                        }
                    }
                    if (i5 != 0) {
                        float calculateZoom = TransformGestureDetectorKt.calculateZoom(pointerEvent2);
                        float calculateRotation = TransformGestureDetectorKt.calculateRotation(pointerEvent2);
                        long calculatePan = TransformGestureDetectorKt.calculatePan(pointerEvent2);
                        if (i3 == 0) {
                            f2 *= calculateZoom;
                            f4 += calculateRotation;
                            j = Offset.m5108plusMKHz9U(j, calculatePan);
                            i8 = i3;
                            float calculateCentroidSize = TransformGestureDetectorKt.calculateCentroidSize(pointerEvent2, false);
                            float abs = Math.abs(1.0f - f2) * calculateCentroidSize;
                            float abs2 = Math.abs(((3.1415927f * f4) * calculateCentroidSize) / 180.0f);
                            float m5101getDistanceimpl = Offset.m5101getDistanceimpl(j);
                            if (abs > f || abs2 > f || (m5101getDistanceimpl > f && function13.invoke(Offset.m5092boximpl(calculatePan)).booleanValue())) {
                                int i14 = (!z3 || abs2 >= f) ? 0 : 1;
                                channel3.mo9057trySendJP2dKIU(TransformEvent.TransformStarted.INSTANCE);
                                i9 = i14;
                                f8 = f4;
                                f9 = f2;
                                j3 = j;
                                i6 = 1;
                                i13 = i9;
                                if (i6 == 0) {
                                    long calculateCentroid = TransformGestureDetectorKt.calculateCentroid(pointerEvent2, false);
                                    float f13 = i13 != 0 ? 0.0f : calculateRotation;
                                    if (f13 != 0.0f) {
                                        transformableKt$detectZoom$12 = transformableKt$detectZoom$14;
                                    } else if (calculateZoom == 1.0f) {
                                        transformableKt$detectZoom$12 = transformableKt$detectZoom$14;
                                        if (!Offset.m5100equalsimpl0(calculatePan, Offset.Companion.m5119getZeroF1C5BW0())) {
                                        }
                                        List<PointerInputChange> changes4 = pointerEvent2.getChanges();
                                        size2 = changes4.size();
                                        for (i10 = 0; i10 < size2; i10++) {
                                            PointerInputChange pointerInputChange = changes4.get(i10);
                                            if (PointerEventKt.positionChanged(pointerInputChange)) {
                                                pointerInputChange.consume();
                                            }
                                        }
                                    } else {
                                        transformableKt$detectZoom$12 = transformableKt$detectZoom$14;
                                    }
                                    channel3.mo9057trySendJP2dKIU(new TransformEvent.TransformDelta(calculateCentroid, calculateZoom, calculatePan, f13, null));
                                    List<PointerInputChange> changes42 = pointerEvent2.getChanges();
                                    size2 = changes42.size();
                                    while (i10 < size2) {
                                    }
                                } else {
                                    transformableKt$detectZoom$12 = transformableKt$detectZoom$14;
                                }
                                j2 = j3;
                                f5 = f9;
                                f6 = f8;
                            }
                        } else {
                            i8 = i3;
                        }
                        i9 = i13;
                        f8 = f4;
                        f9 = f2;
                        j3 = j;
                        i6 = i8;
                        i13 = i9;
                        if (i6 == 0) {
                        }
                        j2 = j3;
                        f5 = f9;
                        f6 = f8;
                    } else {
                        transformableKt$detectZoom$12 = transformableKt$detectZoom$14;
                        ChannelResult.m11444boximpl(channel3.mo9057trySendJP2dKIU(TransformEvent.TransformStopped.INSTANCE));
                        j2 = j;
                        f5 = f2;
                        f6 = f4;
                        i6 = i3;
                    }
                    int i15 = i13;
                    PointerEventPass pointerEventPass = PointerEventPass.Final;
                    transformableKt$detectZoom$13 = transformableKt$detectZoom$12;
                    transformableKt$detectZoom$13.L$0 = awaitPointerEventScope3;
                    transformableKt$detectZoom$13.L$1 = channel3;
                    transformableKt$detectZoom$13.L$2 = function13;
                    transformableKt$detectZoom$13.L$3 = pointerEvent2;
                    transformableKt$detectZoom$13.Z$0 = z3;
                    transformableKt$detectZoom$13.F$0 = f6;
                    transformableKt$detectZoom$13.F$1 = f5;
                    transformableKt$detectZoom$13.J$0 = j2;
                    transformableKt$detectZoom$13.I$0 = i6;
                    transformableKt$detectZoom$13.F$2 = f;
                    transformableKt$detectZoom$13.I$1 = i15;
                    transformableKt$detectZoom$13.I$2 = i5;
                    transformableKt$detectZoom$13.label = 3;
                    awaitPointerEvent = awaitPointerEventScope3.awaitPointerEvent(pointerEventPass, transformableKt$detectZoom$13);
                    if (awaitPointerEvent != coroutine_suspended) {
                        f7 = f;
                        i7 = i15;
                        float f14 = f6;
                        f2 = f5;
                        z4 = z3;
                        f3 = f14;
                        awaitPointerEventScope4 = awaitPointerEventScope3;
                        function12 = function13;
                        pointerEvent = pointerEvent2;
                        List<PointerInputChange> changes5 = ((PointerEvent) awaitPointerEvent).getChanges();
                        size3 = changes5.size();
                        Object obj22 = coroutine_suspended;
                        i11 = 0;
                        while (true) {
                            if (i11 >= size3) {
                            }
                            i11++;
                        }
                        boolean z62 = false;
                        if (i5 == 0) {
                            List<PointerInputChange> changes22 = pointerEvent.getChanges();
                            size4 = changes22.size();
                            while (i12 < size4) {
                            }
                        }
                        return Unit.INSTANCE;
                    }
                    return coroutine_suspended;
                } else {
                    i2 = transformableKt$detectZoom$14.I$1;
                    f = transformableKt$detectZoom$14.F$2;
                    i3 = transformableKt$detectZoom$14.I$0;
                    j = transformableKt$detectZoom$14.J$0;
                    f2 = transformableKt$detectZoom$14.F$1;
                    f3 = transformableKt$detectZoom$14.F$0;
                    boolean z8 = transformableKt$detectZoom$14.Z$0;
                    function12 = (Function1) transformableKt$detectZoom$14.L$2;
                    Channel<TransformEvent> channel4 = (Channel) transformableKt$detectZoom$14.L$1;
                    awaitPointerEventScope2 = (AwaitPointerEventScope) transformableKt$detectZoom$14.L$0;
                    ResultKt.throwOnFailure(obj);
                    z2 = z8;
                    channel2 = channel4;
                }
                transformableKt$detectZoom$14.L$0 = awaitPointerEventScope2;
                transformableKt$detectZoom$14.L$1 = channel2;
                transformableKt$detectZoom$14.L$2 = function12;
                transformableKt$detectZoom$14.L$3 = null;
                transformableKt$detectZoom$14.Z$0 = z2;
                transformableKt$detectZoom$14.F$0 = f3;
                transformableKt$detectZoom$14.F$1 = f2;
                transformableKt$detectZoom$14.J$0 = j;
                transformableKt$detectZoom$14.I$0 = i3;
                transformableKt$detectZoom$14.F$2 = f;
                transformableKt$detectZoom$14.I$1 = i2;
                transformableKt$detectZoom$14.label = 2;
                obj = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, null, transformableKt$detectZoom$14, 1, null);
                if (obj != coroutine_suspended) {
                    Channel<TransformEvent> channel5 = channel2;
                    f4 = f3;
                    z3 = z2;
                    channel3 = channel5;
                    AwaitPointerEventScope awaitPointerEventScope6 = awaitPointerEventScope2;
                    function13 = function12;
                    awaitPointerEventScope3 = awaitPointerEventScope6;
                    PointerEvent pointerEvent22 = (PointerEvent) obj;
                    List<PointerInputChange> changes32 = pointerEvent22.getChanges();
                    size = changes32.size();
                    int i132 = i2;
                    i4 = 0;
                    while (true) {
                        if (i4 >= size) {
                        }
                        i4++;
                    }
                    if (i5 != 0) {
                    }
                    int i152 = i132;
                    PointerEventPass pointerEventPass2 = PointerEventPass.Final;
                    transformableKt$detectZoom$13 = transformableKt$detectZoom$12;
                    transformableKt$detectZoom$13.L$0 = awaitPointerEventScope3;
                    transformableKt$detectZoom$13.L$1 = channel3;
                    transformableKt$detectZoom$13.L$2 = function13;
                    transformableKt$detectZoom$13.L$3 = pointerEvent22;
                    transformableKt$detectZoom$13.Z$0 = z3;
                    transformableKt$detectZoom$13.F$0 = f6;
                    transformableKt$detectZoom$13.F$1 = f5;
                    transformableKt$detectZoom$13.J$0 = j2;
                    transformableKt$detectZoom$13.I$0 = i6;
                    transformableKt$detectZoom$13.F$2 = f;
                    transformableKt$detectZoom$13.I$1 = i152;
                    transformableKt$detectZoom$13.I$2 = i5;
                    transformableKt$detectZoom$13.label = 3;
                    awaitPointerEvent = awaitPointerEventScope3.awaitPointerEvent(pointerEventPass2, transformableKt$detectZoom$13);
                    if (awaitPointerEvent != coroutine_suspended) {
                    }
                }
                return coroutine_suspended;
            }
        }
        transformableKt$detectZoom$1 = new TransformableKt$detectZoom$1(continuation);
        TransformableKt$detectZoom$1 transformableKt$detectZoom$142 = transformableKt$detectZoom$1;
        obj = transformableKt$detectZoom$142.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = transformableKt$detectZoom$142.label;
        if (i != 0) {
        }
        transformableKt$detectZoom$142.L$0 = awaitPointerEventScope2;
        transformableKt$detectZoom$142.L$1 = channel2;
        transformableKt$detectZoom$142.L$2 = function12;
        transformableKt$detectZoom$142.L$3 = null;
        transformableKt$detectZoom$142.Z$0 = z2;
        transformableKt$detectZoom$142.F$0 = f3;
        transformableKt$detectZoom$142.F$1 = f2;
        transformableKt$detectZoom$142.J$0 = j;
        transformableKt$detectZoom$142.I$0 = i3;
        transformableKt$detectZoom$142.F$2 = f;
        transformableKt$detectZoom$142.I$1 = i2;
        transformableKt$detectZoom$142.label = 2;
        obj = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, null, transformableKt$detectZoom$142, 1, null);
        if (obj != coroutine_suspended) {
        }
        return coroutine_suspended;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object detectNonTouchGestures(PointerInputScope pointerInputScope, Channel<TransformEvent> channel, ScrollConfig scrollConfig, Continuation<? super Unit> continuation) {
        Object awaitPointerEventScope = pointerInputScope.awaitPointerEventScope(new TransformableKt$detectNonTouchGestures$2(continuation.getContext(), scrollConfig, channel, null), continuation);
        return awaitPointerEventScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? awaitPointerEventScope : Unit.INSTANCE;
    }
}
