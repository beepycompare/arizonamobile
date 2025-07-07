package androidx.constraintlayout.compose;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: ConstraintLayout.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\bf\u0018\u0000 \u00032\u00020\u0001:\u0004\u0002\u0003\u0004\u0005ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0006À\u0006\u0001"}, d2 = {"Landroidx/constraintlayout/compose/Dimension;", "", "Coercible", "Companion", "MaxCoercible", "MinCoercible", "constraintlayout-compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface Dimension {
    public static final Companion Companion = Companion.$$INSTANCE;

    /* compiled from: ConstraintLayout.kt */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0002À\u0006\u0001"}, d2 = {"Landroidx/constraintlayout/compose/Dimension$Coercible;", "Landroidx/constraintlayout/compose/Dimension;", "constraintlayout-compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public interface Coercible extends Dimension {
    }

    /* compiled from: ConstraintLayout.kt */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0002À\u0006\u0001"}, d2 = {"Landroidx/constraintlayout/compose/Dimension$MaxCoercible;", "Landroidx/constraintlayout/compose/Dimension;", "constraintlayout-compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public interface MaxCoercible extends Dimension {
    }

    /* compiled from: ConstraintLayout.kt */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0002À\u0006\u0001"}, d2 = {"Landroidx/constraintlayout/compose/Dimension$MinCoercible;", "Landroidx/constraintlayout/compose/Dimension;", "constraintlayout-compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public interface MinCoercible extends Dimension {
    }

    /* compiled from: ConstraintLayout.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0010J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\u000e\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0018J\u0018\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0014ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\f\u0010\u0006R\u0011\u0010\r\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\n\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001c"}, d2 = {"Landroidx/constraintlayout/compose/Dimension$Companion;", "", "()V", "fillToConstraints", "Landroidx/constraintlayout/compose/Dimension$Coercible;", "getFillToConstraints", "()Landroidx/constraintlayout/compose/Dimension$Coercible;", "matchParent", "Landroidx/constraintlayout/compose/Dimension;", "getMatchParent", "()Landroidx/constraintlayout/compose/Dimension;", "preferredWrapContent", "getPreferredWrapContent", "wrapContent", "getWrapContent", "percent", "", "preferredValue", "Landroidx/constraintlayout/compose/Dimension$MinCoercible;", "dp", "Landroidx/compose/ui/unit/Dp;", "preferredValue-0680j_4", "(F)Landroidx/constraintlayout/compose/Dimension$MinCoercible;", "ratio", "", "value", "value-0680j_4", "(F)Landroidx/constraintlayout/compose/Dimension;", "constraintlayout-compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        /* renamed from: preferredValue-0680j_4  reason: not valid java name */
        public final MinCoercible m7041preferredValue0680j_4(float f) {
            DimensionDescription dimensionDescription = new DimensionDescription("spread");
            dimensionDescription.getMax$constraintlayout_compose_release().m7043update0680j_4(f);
            return dimensionDescription;
        }

        /* renamed from: value-0680j_4  reason: not valid java name */
        public final Dimension m7042value0680j_4(float f) {
            return new DimensionDescription(f, (DefaultConstructorMarker) null);
        }

        public final Dimension ratio(String str) {
            return new DimensionDescription(str);
        }

        public final Coercible getPreferredWrapContent() {
            return new DimensionDescription("preferWrap");
        }

        public final Dimension getWrapContent() {
            return new DimensionDescription("wrap");
        }

        public final Dimension getMatchParent() {
            return new DimensionDescription("parent");
        }

        public final Coercible getFillToConstraints() {
            return new DimensionDescription("spread");
        }

        public final Dimension percent(float f) {
            return new DimensionDescription(new StringBuilder().append(f * 100.0f).append('%').toString());
        }
    }
}
