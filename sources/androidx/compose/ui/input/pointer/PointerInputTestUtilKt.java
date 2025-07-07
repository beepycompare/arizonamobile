package androidx.compose.ui.input.pointer;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.unit.IntSize;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: PointerInputTestUtil.kt */
@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0011\n\u0002\b\n\u001a@\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tH\u0000\u001aD\u0010\u000b\u001a\u00020\f*\u001e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\f0\rj\u0002`\u00112\u0006\u0010\u0012\u001a\u00020\u000e2\b\b\u0002\u0010\u0013\u001a\u00020\u0010H\u0000ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u001aL\u0010\u0016\u001a\u00020\f*\u001e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\f0\rj\u0002`\u00112\u0006\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u000f2\b\b\u0002\u0010\u0013\u001a\u00020\u0010H\u0000ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u001aX\u0010\u001a\u001a\u00020\f*\u001e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\f0\rj\u0002`\u00112\u0006\u0010\u0012\u001a\u00020\u000e2\u0012\u0010\u001b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000f0\u001c\"\u00020\u000f2\b\b\u0002\u0010\u0013\u001a\u00020\u0010H\u0000ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001e\u001aR\u0010\u001a\u001a\u00020\f*\u001e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\f0\rj\u0002`\u00112\u0006\u0010\u0012\u001a\u00020\u000e2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000f0\t2\b\b\u0002\u0010\u0013\u001a\u00020\u0010H\u0000ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001f\u001a(\u0010 \u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010!\u001a\u00020\u00062\b\b\u0002\u0010\"\u001a\u00020\u0006H\u0000\u001a(\u0010#\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0000\u001a\u0014\u0010$\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003H\u0000*<\b\u0000\u0010%\"\u001a\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\f0\r2\u001a\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\f0\r\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006&"}, d2 = {"down", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "id", "", "durationMillis", "x", "", "y", "historicalData", "", "Landroidx/compose/ui/input/pointer/HistoricalChange;", "invokeOverAllPasses", "", "Lkotlin/Function3;", "Landroidx/compose/ui/input/pointer/PointerEvent;", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "Landroidx/compose/ui/unit/IntSize;", "Landroidx/compose/ui/input/pointer/PointerInputHandler;", "pointerEvent", "size", "invokeOverAllPasses-H0pRuoY", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/input/pointer/PointerEvent;J)V", "invokeOverPass", "pointerEventPass", "invokeOverPass-hUlJWOE", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/input/pointer/PointerEvent;Landroidx/compose/ui/input/pointer/PointerEventPass;J)V", "invokeOverPasses", "pointerEventPasses", "", "invokeOverPasses-hUlJWOE", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/input/pointer/PointerEvent;[Landroidx/compose/ui/input/pointer/PointerEventPass;J)V", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/input/pointer/PointerEvent;Ljava/util/List;J)V", "moveBy", "dx", "dy", "moveTo", "up", "PointerInputHandler", "ui_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PointerInputTestUtilKt {
    public static /* synthetic */ PointerInputChange down$default(long j, long j2, float f, float f2, List list, int i, Object obj) {
        if ((i & 2) != 0) {
            j2 = 0;
        }
        long j3 = j2;
        float f3 = (i & 4) != 0 ? 0.0f : f;
        float f4 = (i & 8) != 0 ? 0.0f : f2;
        if ((i & 16) != 0) {
            list = null;
        }
        return down(j, j3, f3, f4, list);
    }

    public static final PointerInputChange down(long j, long j2, float f, float f2, List<HistoricalChange> list) {
        PointerInputChange pointerInputChange = new PointerInputChange(PointerId.m5293constructorimpl(j), j2, Offset.m3829constructorimpl((Float.floatToRawIntBits(f) << 32) | (Float.floatToRawIntBits(f2) & 4294967295L)), true, 1.0f, j2, Offset.m3829constructorimpl((Float.floatToRawIntBits(f) << 32) | (Float.floatToRawIntBits(f2) & 4294967295L)), false, false, 0, 0L, 1536, (DefaultConstructorMarker) null);
        List<HistoricalChange> list2 = list;
        return (list2 == null || list2.isEmpty()) ? pointerInputChange : PointerInputChange.m5302copyOHpmEuE$default(pointerInputChange, 0L, 0L, 0L, false, 0L, 0L, false, 0, list, 0L, 767, null);
    }

    public static /* synthetic */ PointerInputChange moveTo$default(PointerInputChange pointerInputChange, long j, float f, float f2, int i, Object obj) {
        if ((i & 2) != 0) {
            f = 0.0f;
        }
        if ((i & 4) != 0) {
            f2 = 0.0f;
        }
        return moveTo(pointerInputChange, j, f, f2);
    }

    public static final PointerInputChange moveTo(PointerInputChange pointerInputChange, long j, float f, float f2) {
        long m5311getIdJ3iCeTQ = pointerInputChange.m5311getIdJ3iCeTQ();
        long uptimeMillis = pointerInputChange.getUptimeMillis();
        boolean pressed = pointerInputChange.getPressed();
        return new PointerInputChange(m5311getIdJ3iCeTQ, j, Offset.m3829constructorimpl((Float.floatToRawIntBits(f) << 32) | (Float.floatToRawIntBits(f2) & 4294967295L)), true, 1.0f, uptimeMillis, pointerInputChange.m5313getPositionF1C5BW0(), pressed, false, 0, 0L, 1536, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ PointerInputChange moveBy$default(PointerInputChange pointerInputChange, long j, float f, float f2, int i, Object obj) {
        if ((i & 2) != 0) {
            f = 0.0f;
        }
        if ((i & 4) != 0) {
            f2 = 0.0f;
        }
        return moveBy(pointerInputChange, j, f, f2);
    }

    public static final PointerInputChange moveBy(PointerInputChange pointerInputChange, long j, float f, float f2) {
        long m5311getIdJ3iCeTQ = pointerInputChange.m5311getIdJ3iCeTQ();
        long uptimeMillis = pointerInputChange.getUptimeMillis();
        boolean pressed = pointerInputChange.getPressed();
        return new PointerInputChange(m5311getIdJ3iCeTQ, pointerInputChange.getUptimeMillis() + j, Offset.m3829constructorimpl((Float.floatToRawIntBits(Float.intBitsToFloat((int) (pointerInputChange.m5313getPositionF1C5BW0() & 4294967295L)) + f2) & 4294967295L) | (Float.floatToRawIntBits(Float.intBitsToFloat((int) (pointerInputChange.m5313getPositionF1C5BW0() >> 32)) + f) << 32)), true, 1.0f, uptimeMillis, pointerInputChange.m5313getPositionF1C5BW0(), pressed, false, 0, 0L, 1536, (DefaultConstructorMarker) null);
    }

    public static final PointerInputChange up(PointerInputChange pointerInputChange, long j) {
        long m5311getIdJ3iCeTQ = pointerInputChange.m5311getIdJ3iCeTQ();
        long uptimeMillis = pointerInputChange.getUptimeMillis();
        boolean pressed = pointerInputChange.getPressed();
        return new PointerInputChange(m5311getIdJ3iCeTQ, j, pointerInputChange.m5313getPositionF1C5BW0(), false, 1.0f, uptimeMillis, pointerInputChange.m5313getPositionF1C5BW0(), pressed, false, 0, 0L, 1536, (DefaultConstructorMarker) null);
    }

    /* renamed from: invokeOverAllPasses-H0pRuoY  reason: not valid java name */
    public static final void m5363invokeOverAllPassesH0pRuoY(Function3<? super PointerEvent, ? super PointerEventPass, ? super IntSize, Unit> function3, PointerEvent pointerEvent, long j) {
        m5367invokeOverPasseshUlJWOE(function3, pointerEvent, CollectionsKt.listOf((Object[]) new PointerEventPass[]{PointerEventPass.Initial, PointerEventPass.Main, PointerEventPass.Final}), j);
    }

    /* renamed from: invokeOverPass-hUlJWOE  reason: not valid java name */
    public static final void m5365invokeOverPasshUlJWOE(Function3<? super PointerEvent, ? super PointerEventPass, ? super IntSize, Unit> function3, PointerEvent pointerEvent, PointerEventPass pointerEventPass, long j) {
        m5367invokeOverPasseshUlJWOE(function3, pointerEvent, CollectionsKt.listOf(pointerEventPass), j);
    }

    /* renamed from: invokeOverPasses-hUlJWOE  reason: not valid java name */
    public static final void m5368invokeOverPasseshUlJWOE(Function3<? super PointerEvent, ? super PointerEventPass, ? super IntSize, Unit> function3, PointerEvent pointerEvent, PointerEventPass[] pointerEventPassArr, long j) {
        m5367invokeOverPasseshUlJWOE(function3, pointerEvent, ArraysKt.toList(pointerEventPassArr), j);
    }

    /* renamed from: invokeOverPasses-hUlJWOE  reason: not valid java name */
    public static final void m5367invokeOverPasseshUlJWOE(Function3<? super PointerEvent, ? super PointerEventPass, ? super IntSize, Unit> function3, PointerEvent pointerEvent, List<? extends PointerEventPass> list, long j) {
        if (pointerEvent.getChanges().isEmpty()) {
            throw new IllegalArgumentException("invokeOverPasses called with no changes".toString());
        }
        List<? extends PointerEventPass> list2 = list;
        if (list2.isEmpty()) {
            throw new IllegalArgumentException("invokeOverPasses called with no passes".toString());
        }
        int size = list2.size();
        for (int i = 0; i < size; i++) {
            function3.invoke(pointerEvent, list.get(i), IntSize.m6847boximpl(j));
        }
    }

    /* renamed from: invokeOverAllPasses-H0pRuoY$default  reason: not valid java name */
    public static /* synthetic */ void m5364invokeOverAllPassesH0pRuoY$default(Function3 function3, PointerEvent pointerEvent, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            long j2 = Integer.MAX_VALUE;
            j = IntSize.m6850constructorimpl((j2 & 4294967295L) | (j2 << 32));
        }
        m5363invokeOverAllPassesH0pRuoY(function3, pointerEvent, j);
    }

    /* renamed from: invokeOverPass-hUlJWOE$default  reason: not valid java name */
    public static /* synthetic */ void m5366invokeOverPasshUlJWOE$default(Function3 function3, PointerEvent pointerEvent, PointerEventPass pointerEventPass, long j, int i, Object obj) {
        if ((i & 4) != 0) {
            long j2 = Integer.MAX_VALUE;
            j = IntSize.m6850constructorimpl((j2 & 4294967295L) | (j2 << 32));
        }
        m5365invokeOverPasshUlJWOE(function3, pointerEvent, pointerEventPass, j);
    }

    /* renamed from: invokeOverPasses-hUlJWOE$default  reason: not valid java name */
    public static /* synthetic */ void m5370invokeOverPasseshUlJWOE$default(Function3 function3, PointerEvent pointerEvent, PointerEventPass[] pointerEventPassArr, long j, int i, Object obj) {
        if ((i & 4) != 0) {
            long j2 = Integer.MAX_VALUE;
            j = IntSize.m6850constructorimpl((j2 & 4294967295L) | (j2 << 32));
        }
        m5368invokeOverPasseshUlJWOE(function3, pointerEvent, pointerEventPassArr, j);
    }

    /* renamed from: invokeOverPasses-hUlJWOE$default  reason: not valid java name */
    public static /* synthetic */ void m5369invokeOverPasseshUlJWOE$default(Function3 function3, PointerEvent pointerEvent, List list, long j, int i, Object obj) {
        if ((i & 4) != 0) {
            long j2 = Integer.MAX_VALUE;
            j = IntSize.m6850constructorimpl((j2 & 4294967295L) | (j2 << 32));
        }
        m5367invokeOverPasseshUlJWOE(function3, pointerEvent, list, j);
    }
}
