package com.skydoves.cloudy;

import androidx.compose.animation.core.Easing;
import androidx.compose.animation.core.EasingKt;
import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: CloudyProgressive.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bw\u0018\u00002\u00020\u0001:\u0004\u0002\u0003\u0004\u0005\u0082\u0001\u0004\u0006\u0007\b\t¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lcom/skydoves/cloudy/CloudyProgressive;", "", "None", "TopToBottom", "BottomToTop", "Edges", "Lcom/skydoves/cloudy/CloudyProgressive$BottomToTop;", "Lcom/skydoves/cloudy/CloudyProgressive$Edges;", "Lcom/skydoves/cloudy/CloudyProgressive$None;", "Lcom/skydoves/cloudy/CloudyProgressive$TopToBottom;", "cloudy_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface CloudyProgressive {

    /* compiled from: CloudyProgressive.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, d2 = {"Lcom/skydoves/cloudy/CloudyProgressive$None;", "Lcom/skydoves/cloudy/CloudyProgressive;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "cloudy_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class None implements CloudyProgressive {
        public static final int $stable = 0;
        public static final None INSTANCE = new None();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof None) {
                None none = (None) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -1496093280;
        }

        public String toString() {
            return "None";
        }

        private None() {
        }
    }

    /* compiled from: CloudyProgressive.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0014\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0083\u0004J\n\u0010\u0016\u001a\u00020\u0017HÖ\u0081\u0004J\n\u0010\u0018\u001a\u00020\u0019HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u001a"}, d2 = {"Lcom/skydoves/cloudy/CloudyProgressive$TopToBottom;", "Lcom/skydoves/cloudy/CloudyProgressive;", TtmlNode.START, "", TtmlNode.END, "easing", "Landroidx/compose/animation/core/Easing;", "<init>", "(FFLandroidx/compose/animation/core/Easing;)V", "getStart", "()F", "getEnd", "getEasing", "()Landroidx/compose/animation/core/Easing;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "cloudy_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class TopToBottom implements CloudyProgressive {
        public static final int $stable = 0;
        private final Easing easing;
        private final float end;
        private final float start;

        public TopToBottom() {
            this(0.0f, 0.0f, null, 7, null);
        }

        public static /* synthetic */ TopToBottom copy$default(TopToBottom topToBottom, float f, float f2, Easing easing, int i, Object obj) {
            if ((i & 1) != 0) {
                f = topToBottom.start;
            }
            if ((i & 2) != 0) {
                f2 = topToBottom.end;
            }
            if ((i & 4) != 0) {
                easing = topToBottom.easing;
            }
            return topToBottom.copy(f, f2, easing);
        }

        public final float component1() {
            return this.start;
        }

        public final float component2() {
            return this.end;
        }

        public final Easing component3() {
            return this.easing;
        }

        public final TopToBottom copy(float f, float f2, Easing easing) {
            Intrinsics.checkNotNullParameter(easing, "easing");
            return new TopToBottom(f, f2, easing);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof TopToBottom) {
                TopToBottom topToBottom = (TopToBottom) obj;
                return Float.compare(this.start, topToBottom.start) == 0 && Float.compare(this.end, topToBottom.end) == 0 && Intrinsics.areEqual(this.easing, topToBottom.easing);
            }
            return false;
        }

        public int hashCode() {
            return (((Float.hashCode(this.start) * 31) + Float.hashCode(this.end)) * 31) + this.easing.hashCode();
        }

        public String toString() {
            return "TopToBottom(start=" + this.start + ", end=" + this.end + ", easing=" + this.easing + ')';
        }

        public TopToBottom(float f, float f2, Easing easing) {
            Intrinsics.checkNotNullParameter(easing, "easing");
            this.start = f;
            this.end = f2;
            this.easing = easing;
            if (0.0f > f || f > 1.0f) {
                throw new IllegalArgumentException(("start must be in 0..1, but was " + f).toString());
            }
            if (0.0f > f2 || f2 > 1.0f) {
                throw new IllegalArgumentException(("end must be in 0..1, but was " + f2).toString());
            }
            if (f >= f2) {
                throw new IllegalArgumentException(("start (" + f + ") must be less than end (" + f2 + ')').toString());
            }
        }

        public final float getStart() {
            return this.start;
        }

        public final float getEnd() {
            return this.end;
        }

        public /* synthetic */ TopToBottom(float f, float f2, Easing easing, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? 0.0f : f, (i & 2) != 0 ? 0.5f : f2, (i & 4) != 0 ? EasingKt.getFastOutSlowInEasing() : easing);
        }

        public final Easing getEasing() {
            return this.easing;
        }
    }

    /* compiled from: CloudyProgressive.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0014\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0083\u0004J\n\u0010\u0016\u001a\u00020\u0017HÖ\u0081\u0004J\n\u0010\u0018\u001a\u00020\u0019HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u001a"}, d2 = {"Lcom/skydoves/cloudy/CloudyProgressive$BottomToTop;", "Lcom/skydoves/cloudy/CloudyProgressive;", TtmlNode.START, "", TtmlNode.END, "easing", "Landroidx/compose/animation/core/Easing;", "<init>", "(FFLandroidx/compose/animation/core/Easing;)V", "getStart", "()F", "getEnd", "getEasing", "()Landroidx/compose/animation/core/Easing;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "cloudy_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class BottomToTop implements CloudyProgressive {
        public static final int $stable = 0;
        private final Easing easing;
        private final float end;
        private final float start;

        public BottomToTop() {
            this(0.0f, 0.0f, null, 7, null);
        }

        public static /* synthetic */ BottomToTop copy$default(BottomToTop bottomToTop, float f, float f2, Easing easing, int i, Object obj) {
            if ((i & 1) != 0) {
                f = bottomToTop.start;
            }
            if ((i & 2) != 0) {
                f2 = bottomToTop.end;
            }
            if ((i & 4) != 0) {
                easing = bottomToTop.easing;
            }
            return bottomToTop.copy(f, f2, easing);
        }

        public final float component1() {
            return this.start;
        }

        public final float component2() {
            return this.end;
        }

        public final Easing component3() {
            return this.easing;
        }

        public final BottomToTop copy(float f, float f2, Easing easing) {
            Intrinsics.checkNotNullParameter(easing, "easing");
            return new BottomToTop(f, f2, easing);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof BottomToTop) {
                BottomToTop bottomToTop = (BottomToTop) obj;
                return Float.compare(this.start, bottomToTop.start) == 0 && Float.compare(this.end, bottomToTop.end) == 0 && Intrinsics.areEqual(this.easing, bottomToTop.easing);
            }
            return false;
        }

        public int hashCode() {
            return (((Float.hashCode(this.start) * 31) + Float.hashCode(this.end)) * 31) + this.easing.hashCode();
        }

        public String toString() {
            return "BottomToTop(start=" + this.start + ", end=" + this.end + ", easing=" + this.easing + ')';
        }

        public BottomToTop(float f, float f2, Easing easing) {
            Intrinsics.checkNotNullParameter(easing, "easing");
            this.start = f;
            this.end = f2;
            this.easing = easing;
            if (0.0f > f || f > 1.0f) {
                throw new IllegalArgumentException(("start must be in 0..1, but was " + f).toString());
            }
            if (0.0f > f2 || f2 > 1.0f) {
                throw new IllegalArgumentException(("end must be in 0..1, but was " + f2).toString());
            }
            if (f <= f2) {
                throw new IllegalArgumentException(("start (" + f + ") must be greater than end (" + f2 + ") for BottomToTop").toString());
            }
        }

        public final float getStart() {
            return this.start;
        }

        public final float getEnd() {
            return this.end;
        }

        public /* synthetic */ BottomToTop(float f, float f2, Easing easing, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? 1.0f : f, (i & 2) != 0 ? 0.5f : f2, (i & 4) != 0 ? EasingKt.getFastOutSlowInEasing() : easing);
        }

        public final Easing getEasing() {
            return this.easing;
        }
    }

    /* compiled from: CloudyProgressive.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0016HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/skydoves/cloudy/CloudyProgressive$Edges;", "Lcom/skydoves/cloudy/CloudyProgressive;", "fadeDistance", "", "easing", "Landroidx/compose/animation/core/Easing;", "<init>", "(FLandroidx/compose/animation/core/Easing;)V", "getFadeDistance", "()F", "getEasing", "()Landroidx/compose/animation/core/Easing;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "cloudy_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Edges implements CloudyProgressive {
        public static final int $stable = 0;
        private final Easing easing;
        private final float fadeDistance;

        public Edges() {
            this(0.0f, null, 3, null);
        }

        public static /* synthetic */ Edges copy$default(Edges edges, float f, Easing easing, int i, Object obj) {
            if ((i & 1) != 0) {
                f = edges.fadeDistance;
            }
            if ((i & 2) != 0) {
                easing = edges.easing;
            }
            return edges.copy(f, easing);
        }

        public final float component1() {
            return this.fadeDistance;
        }

        public final Easing component2() {
            return this.easing;
        }

        public final Edges copy(float f, Easing easing) {
            Intrinsics.checkNotNullParameter(easing, "easing");
            return new Edges(f, easing);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Edges) {
                Edges edges = (Edges) obj;
                return Float.compare(this.fadeDistance, edges.fadeDistance) == 0 && Intrinsics.areEqual(this.easing, edges.easing);
            }
            return false;
        }

        public int hashCode() {
            return (Float.hashCode(this.fadeDistance) * 31) + this.easing.hashCode();
        }

        public String toString() {
            return "Edges(fadeDistance=" + this.fadeDistance + ", easing=" + this.easing + ')';
        }

        public Edges(float f, Easing easing) {
            Intrinsics.checkNotNullParameter(easing, "easing");
            this.fadeDistance = f;
            this.easing = easing;
            if (0.0f > f || f > 0.5f) {
                throw new IllegalArgumentException(("fadeDistance must be in 0..0.5, but was " + f).toString());
            }
        }

        public final float getFadeDistance() {
            return this.fadeDistance;
        }

        public /* synthetic */ Edges(float f, Easing easing, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? 0.2f : f, (i & 2) != 0 ? EasingKt.getFastOutSlowInEasing() : easing);
        }

        public final Easing getEasing() {
            return this.easing;
        }
    }
}
