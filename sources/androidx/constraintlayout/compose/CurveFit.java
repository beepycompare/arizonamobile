package androidx.constraintlayout.compose;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: TransitionScope.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Landroidx/constraintlayout/compose/CurveFit;", "Landroidx/constraintlayout/compose/NamedPropertyOrValue;", "name", "", "(Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "Companion", "constraintlayout-compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class CurveFit implements NamedPropertyOrValue {
    public static final int $stable = 0;
    private final String name;
    public static final Companion Companion = new Companion(null);
    private static final CurveFit Spline = new CurveFit("spline");
    private static final CurveFit Linear = new CurveFit("linear");

    public CurveFit(String str) {
        this.name = str;
    }

    /* compiled from: TransitionScope.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Landroidx/constraintlayout/compose/CurveFit$Companion;", "", "()V", "Linear", "Landroidx/constraintlayout/compose/CurveFit;", "getLinear", "()Landroidx/constraintlayout/compose/CurveFit;", "Spline", "getSpline", "constraintlayout-compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final CurveFit getSpline() {
            return CurveFit.Spline;
        }

        public final CurveFit getLinear() {
            return CurveFit.Linear;
        }
    }

    @Override // androidx.constraintlayout.compose.NamedPropertyOrValue
    public String getName() {
        return this.name;
    }
}
