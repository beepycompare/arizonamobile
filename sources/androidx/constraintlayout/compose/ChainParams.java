package androidx.constraintlayout.compose;

import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: ConstraintLayoutBaseScope.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u000e\b\u0000\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rR\u0019\u0010\n\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0006\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0011\u0010\u000fR\u0019\u0010\t\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0012\u0010\u000fR\u0019\u0010\u0005\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0013\u0010\u000fR\u0019\u0010\u0007\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0014\u0010\u000fR\u0019\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0015\u0010\u000fR\u0019\u0010\b\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0016\u0010\u000fR\u0019\u0010\u0004\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0017\u0010\u000fR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000f\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001a"}, d2 = {"Landroidx/constraintlayout/compose/ChainParams;", "Landroidx/constraintlayout/compose/HelperParams;", "startMargin", "Landroidx/compose/ui/unit/Dp;", "topMargin", "endMargin", "bottomMargin", "startGoneMargin", "topGoneMargin", "endGoneMargin", "bottomGoneMargin", "weight", "", "(FFFFFFFFFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getBottomGoneMargin-D9Ej5fM", "()F", "F", "getBottomMargin-D9Ej5fM", "getEndGoneMargin-D9Ej5fM", "getEndMargin-D9Ej5fM", "getStartGoneMargin-D9Ej5fM", "getStartMargin-D9Ej5fM", "getTopGoneMargin-D9Ej5fM", "getTopMargin-D9Ej5fM", "getWeight", "Companion", "constraintlayout-compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ChainParams implements HelperParams {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private static final ChainParams Default;
    private final float bottomGoneMargin;
    private final float bottomMargin;
    private final float endGoneMargin;
    private final float endMargin;
    private final float startGoneMargin;
    private final float startMargin;
    private final float topGoneMargin;
    private final float topMargin;
    private final float weight;

    public /* synthetic */ ChainParams(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, f2, f3, f4, f5, f6, f7, f8, f9);
    }

    private ChainParams(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        this.startMargin = f;
        this.topMargin = f2;
        this.endMargin = f3;
        this.bottomMargin = f4;
        this.startGoneMargin = f5;
        this.topGoneMargin = f6;
        this.endGoneMargin = f7;
        this.bottomGoneMargin = f8;
        this.weight = f9;
    }

    /* renamed from: getStartMargin-D9Ej5fM  reason: not valid java name */
    public final float m6956getStartMarginD9Ej5fM() {
        return this.startMargin;
    }

    /* renamed from: getTopMargin-D9Ej5fM  reason: not valid java name */
    public final float m6958getTopMarginD9Ej5fM() {
        return this.topMargin;
    }

    /* renamed from: getEndMargin-D9Ej5fM  reason: not valid java name */
    public final float m6954getEndMarginD9Ej5fM() {
        return this.endMargin;
    }

    /* renamed from: getBottomMargin-D9Ej5fM  reason: not valid java name */
    public final float m6952getBottomMarginD9Ej5fM() {
        return this.bottomMargin;
    }

    /* renamed from: getStartGoneMargin-D9Ej5fM  reason: not valid java name */
    public final float m6955getStartGoneMarginD9Ej5fM() {
        return this.startGoneMargin;
    }

    /* renamed from: getTopGoneMargin-D9Ej5fM  reason: not valid java name */
    public final float m6957getTopGoneMarginD9Ej5fM() {
        return this.topGoneMargin;
    }

    /* renamed from: getEndGoneMargin-D9Ej5fM  reason: not valid java name */
    public final float m6953getEndGoneMarginD9Ej5fM() {
        return this.endGoneMargin;
    }

    /* renamed from: getBottomGoneMargin-D9Ej5fM  reason: not valid java name */
    public final float m6951getBottomGoneMarginD9Ej5fM() {
        return this.bottomGoneMargin;
    }

    public final float getWeight() {
        return this.weight;
    }

    /* compiled from: ConstraintLayoutBaseScope.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroidx/constraintlayout/compose/ChainParams$Companion;", "", "()V", "Default", "Landroidx/constraintlayout/compose/ChainParams;", "getDefault$constraintlayout_compose_release", "()Landroidx/constraintlayout/compose/ChainParams;", "constraintlayout-compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ChainParams getDefault$constraintlayout_compose_release() {
            return ChainParams.Default;
        }
    }

    static {
        float f = 0;
        Default = new ChainParams(Dp.m6684constructorimpl(f), Dp.m6684constructorimpl(f), Dp.m6684constructorimpl(f), Dp.m6684constructorimpl(f), Dp.m6684constructorimpl(f), Dp.m6684constructorimpl(f), Dp.m6684constructorimpl(f), Dp.m6684constructorimpl(f), Float.NaN, null);
    }
}
