package coil3.compose;

import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.ui.geometry.InlineClassHelperKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.ScaleFactorKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlin.time.TimeMark;
import kotlin.time.TimeSource;
/* compiled from: CrossfadePainter.kt */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001BM\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0001\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\f\u00100\u001a\u000201*\u000202H\u0014J\u0010\u00103\u001a\u00020\u000b2\u0006\u00104\u001a\u00020(H\u0014J\u0012\u00105\u001a\u00020\u000b2\b\u0010)\u001a\u0004\u0018\u00010*H\u0014J\u000f\u00106\u001a\u00020.H\u0002¢\u0006\u0004\b7\u0010\u0014J\u001e\u00108\u001a\u000201*\u0002022\b\u00109\u001a\u0004\u0018\u00010\u00012\u0006\u00104\u001a\u00020(H\u0002J\u001f\u0010:\u001a\u00020.2\u0006\u0010;\u001a\u00020.2\u0006\u0010<\u001a\u00020.H\u0002¢\u0006\u0004\b=\u0010>R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0006\u001a\u00020\u0007¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R+\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u001c8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0002\u001a\u0004\u0018\u00010\u00012\b\u0010+\u001a\u0004\u0018\u00010\u0001@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u0010R\u0014\u0010-\u001a\u00020.8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b/\u0010\u0014¨\u0006?"}, d2 = {"Lcoil3/compose/CrossfadePainter;", "Landroidx/compose/ui/graphics/painter/Painter;", TtmlNode.START, TtmlNode.END, "contentScale", "Landroidx/compose/ui/layout/ContentScale;", TypedValues.TransitionType.S_DURATION, "Lkotlin/time/Duration;", "timeSource", "Lkotlin/time/TimeSource;", "fadeStart", "", "preferExactIntrinsicSize", "<init>", "(Landroidx/compose/ui/graphics/painter/Painter;Landroidx/compose/ui/graphics/painter/Painter;Landroidx/compose/ui/layout/ContentScale;JLkotlin/time/TimeSource;ZZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getEnd", "()Landroidx/compose/ui/graphics/painter/Painter;", "getContentScale", "()Landroidx/compose/ui/layout/ContentScale;", "getDuration-UwyO8pc", "()J", "J", "getTimeSource", "()Lkotlin/time/TimeSource;", "getFadeStart", "()Z", "getPreferExactIntrinsicSize", "<set-?>", "", "invalidateTick", "getInvalidateTick", "()I", "setInvalidateTick", "(I)V", "invalidateTick$delegate", "Landroidx/compose/runtime/MutableIntState;", "startTime", "Lkotlin/time/TimeMark;", "isDone", "maxAlpha", "", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "value", "getStart", "intrinsicSize", "Landroidx/compose/ui/geometry/Size;", "getIntrinsicSize-NH-jbRc", "onDraw", "", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "applyAlpha", "alpha", "applyColorFilter", "computeIntrinsicSize", "computeIntrinsicSize-NH-jbRc", "drawPainter", "painter", "computeDrawSize", "srcSize", "dstSize", "computeDrawSize-x8L_9b0", "(JJ)J", "coil-compose-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class CrossfadePainter extends Painter {
    public static final int $stable = 0;
    private ColorFilter colorFilter;
    private final ContentScale contentScale;
    private final long duration;
    private final Painter end;
    private final boolean fadeStart;
    private final MutableIntState invalidateTick$delegate;
    private boolean isDone;
    private float maxAlpha;
    private final boolean preferExactIntrinsicSize;
    private Painter start;
    private TimeMark startTime;
    private final TimeSource timeSource;

    public /* synthetic */ CrossfadePainter(Painter painter, Painter painter2, ContentScale contentScale, long j, TimeSource timeSource, boolean z, boolean z2, DefaultConstructorMarker defaultConstructorMarker) {
        this(painter, painter2, contentScale, j, timeSource, z, z2);
    }

    public final Painter getEnd() {
        return this.end;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ CrossfadePainter(Painter painter, Painter painter2, ContentScale contentScale, long j, TimeSource timeSource, boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(painter, painter2, r3, r4, (i & 16) != 0 ? TimeSource.Monotonic.INSTANCE : timeSource, (i & 32) != 0 ? true : z, (i & 64) != 0 ? false : z2, null);
        long j2;
        ContentScale fit = (i & 4) != 0 ? ContentScale.Companion.getFit() : contentScale;
        if ((i & 8) != 0) {
            Duration.Companion companion = Duration.Companion;
            j2 = DurationKt.toDuration(200, DurationUnit.MILLISECONDS);
        } else {
            j2 = j;
        }
    }

    public final ContentScale getContentScale() {
        return this.contentScale;
    }

    /* renamed from: getDuration-UwyO8pc  reason: not valid java name */
    public final long m7747getDurationUwyO8pc() {
        return this.duration;
    }

    public final TimeSource getTimeSource() {
        return this.timeSource;
    }

    public final boolean getFadeStart() {
        return this.fadeStart;
    }

    public final boolean getPreferExactIntrinsicSize() {
        return this.preferExactIntrinsicSize;
    }

    private CrossfadePainter(Painter painter, Painter painter2, ContentScale contentScale, long j, TimeSource timeSource, boolean z, boolean z2) {
        this.end = painter2;
        this.contentScale = contentScale;
        this.duration = j;
        this.timeSource = timeSource;
        this.fadeStart = z;
        this.preferExactIntrinsicSize = z2;
        this.invalidateTick$delegate = SnapshotIntStateKt.mutableIntStateOf(0);
        this.maxAlpha = 1.0f;
        this.start = painter;
    }

    private final int getInvalidateTick() {
        return this.invalidateTick$delegate.getIntValue();
    }

    private final void setInvalidateTick(int i) {
        this.invalidateTick$delegate.setIntValue(i);
    }

    public final Painter getStart() {
        return this.start;
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    /* renamed from: getIntrinsicSize-NH-jbRc */
    public long mo4761getIntrinsicSizeNHjbRc() {
        return m7746computeIntrinsicSizeNHjbRc();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.compose.ui.graphics.painter.Painter
    public void onDraw(DrawScope drawScope) {
        if (this.isDone) {
            drawPainter(drawScope, this.end, this.maxAlpha);
            return;
        }
        TimeMark timeMark = this.startTime;
        if (timeMark == null) {
            timeMark = this.timeSource.markNow();
            this.startTime = timeMark;
        }
        float m9834getInWholeMillisecondsimpl = ((float) Duration.m9834getInWholeMillisecondsimpl(timeMark.mo9813elapsedNowUwyO8pc())) / ((float) Duration.m9834getInWholeMillisecondsimpl(this.duration));
        float coerceIn = RangesKt.coerceIn(m9834getInWholeMillisecondsimpl, 0.0f, 1.0f);
        float f = this.maxAlpha;
        float f2 = coerceIn * f;
        if (this.fadeStart) {
            f -= f2;
        }
        this.isDone = m9834getInWholeMillisecondsimpl >= 1.0f;
        drawPainter(drawScope, this.start, f);
        drawPainter(drawScope, this.end, f2);
        if (this.isDone) {
            this.start = null;
        } else {
            setInvalidateTick(getInvalidateTick() + 1);
        }
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    protected boolean applyAlpha(float f) {
        this.maxAlpha = f;
        return true;
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    protected boolean applyColorFilter(ColorFilter colorFilter) {
        this.colorFilter = colorFilter;
        return true;
    }

    /* renamed from: computeIntrinsicSize-NH-jbRc  reason: not valid java name */
    private final long m7746computeIntrinsicSizeNHjbRc() {
        Painter painter = this.start;
        long mo4761getIntrinsicSizeNHjbRc = painter != null ? painter.mo4761getIntrinsicSizeNHjbRc() : Size.Companion.m3915getZeroNHjbRc();
        Painter painter2 = this.end;
        long mo4761getIntrinsicSizeNHjbRc2 = painter2 != null ? painter2.mo4761getIntrinsicSizeNHjbRc() : Size.Companion.m3915getZeroNHjbRc();
        boolean z = mo4761getIntrinsicSizeNHjbRc != InlineClassHelperKt.UnspecifiedPackedFloats;
        boolean z2 = mo4761getIntrinsicSizeNHjbRc2 != InlineClassHelperKt.UnspecifiedPackedFloats;
        if (!z || !z2) {
            if (this.preferExactIntrinsicSize) {
                if (z) {
                    return mo4761getIntrinsicSizeNHjbRc;
                }
                if (z2) {
                    return mo4761getIntrinsicSizeNHjbRc2;
                }
            }
            return Size.Companion.m3914getUnspecifiedNHjbRc();
        }
        return Size.m3897constructorimpl((Float.floatToRawIntBits(Math.max(Float.intBitsToFloat((int) (mo4761getIntrinsicSizeNHjbRc >> 32)), Float.intBitsToFloat((int) (mo4761getIntrinsicSizeNHjbRc2 >> 32)))) << 32) | (Float.floatToRawIntBits(Math.max(Float.intBitsToFloat((int) (mo4761getIntrinsicSizeNHjbRc & 4294967295L)), Float.intBitsToFloat((int) (mo4761getIntrinsicSizeNHjbRc2 & 4294967295L)))) & 4294967295L));
    }

    private final void drawPainter(DrawScope drawScope, Painter painter, float f) {
        if (painter == null || f <= 0.0f) {
            return;
        }
        long mo4640getSizeNHjbRc = drawScope.mo4640getSizeNHjbRc();
        long m7745computeDrawSizex8L_9b0 = m7745computeDrawSizex8L_9b0(painter.mo4761getIntrinsicSizeNHjbRc(), mo4640getSizeNHjbRc);
        if (mo4640getSizeNHjbRc == InlineClassHelperKt.UnspecifiedPackedFloats || Size.m3908isEmptyimpl(mo4640getSizeNHjbRc)) {
            painter.m4767drawx_KDEd0(drawScope, m7745computeDrawSizex8L_9b0, f, this.colorFilter);
            return;
        }
        float f2 = 2;
        float intBitsToFloat = (Float.intBitsToFloat((int) (mo4640getSizeNHjbRc >> 32)) - Float.intBitsToFloat((int) (m7745computeDrawSizex8L_9b0 >> 32))) / f2;
        float intBitsToFloat2 = (Float.intBitsToFloat((int) (mo4640getSizeNHjbRc & 4294967295L)) - Float.intBitsToFloat((int) (m7745computeDrawSizex8L_9b0 & 4294967295L))) / f2;
        drawScope.getDrawContext().getTransform().inset(intBitsToFloat, intBitsToFloat2, intBitsToFloat, intBitsToFloat2);
        try {
            painter.m4767drawx_KDEd0(drawScope, m7745computeDrawSizex8L_9b0, f, this.colorFilter);
        } finally {
            float f3 = -intBitsToFloat;
            float f4 = -intBitsToFloat2;
            drawScope.getDrawContext().getTransform().inset(f3, f4, f3, f4);
        }
    }

    /* renamed from: computeDrawSize-x8L_9b0  reason: not valid java name */
    private final long m7745computeDrawSizex8L_9b0(long j, long j2) {
        return (j == InlineClassHelperKt.UnspecifiedPackedFloats || Size.m3908isEmptyimpl(j) || j2 == InlineClassHelperKt.UnspecifiedPackedFloats || Size.m3908isEmptyimpl(j2)) ? j2 : ScaleFactorKt.m5542timesUQTWf7w(j, this.contentScale.mo5431computeScaleFactorH7hwNQA(j, j2));
    }
}
