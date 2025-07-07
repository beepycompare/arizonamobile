package androidx.compose.runtime;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
/* compiled from: Applier.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\r\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J3\u0010\u0006\u001a\u00020\u00072\u001f\u0010\b\u001a\u001b\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00070\t¢\u0006\u0002\b\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\f\u001a\u00020\u0007H&J\u0015\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u000fJ\u001d\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0014J\u001d\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0014J \u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u0012H&J\b\u0010\u001a\u001a\u00020\u0007H\u0016J\b\u0010\u001b\u001a\u00020\u0007H\u0016J\u0018\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u0012H&J\b\u0010\u001d\u001a\u00020\u0007H\u0016J\b\u0010\u001e\u001a\u00020\u0007H&R\u0012\u0010\u0003\u001a\u00028\u0000X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u001fÀ\u0006\u0003"}, d2 = {"Landroidx/compose/runtime/Applier;", "N", "", "current", "getCurrent", "()Ljava/lang/Object;", "apply", "", "block", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", "value", "clear", "down", "node", "(Ljava/lang/Object;)V", "insertBottomUp", FirebaseAnalytics.Param.INDEX, "", "instance", "(ILjava/lang/Object;)V", "insertTopDown", "move", "from", TypedValues.TransitionType.S_TO, "count", "onBeginChanges", "onEndChanges", "remove", "reuse", "up", "runtime_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public interface Applier<N> {
    void clear();

    void down(N n);

    N getCurrent();

    void insertBottomUp(int i, N n);

    void insertTopDown(int i, N n);

    void move(int i, int i2, int i3);

    default void onBeginChanges() {
    }

    default void onEndChanges() {
    }

    void remove(int i, int i2);

    void up();

    /* compiled from: Applier.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class DefaultImpls {
        @Deprecated
        public static <N> void onBeginChanges(Applier<N> applier) {
            Applier.super.onBeginChanges();
        }

        @Deprecated
        public static <N> void onEndChanges(Applier<N> applier) {
            Applier.super.onEndChanges();
        }

        @Deprecated
        public static <N> void apply(Applier<N> applier, Function2<? super N, Object, Unit> function2, Object obj) {
            Applier.super.apply(function2, obj);
        }

        @Deprecated
        public static <N> void reuse(Applier<N> applier) {
            Applier.super.reuse();
        }
    }

    default void apply(Function2<? super N, Object, Unit> function2, Object obj) {
        function2.invoke(getCurrent(), obj);
    }

    default void reuse() {
        N current = getCurrent();
        ComposeNodeLifecycleCallback composeNodeLifecycleCallback = current instanceof ComposeNodeLifecycleCallback ? (ComposeNodeLifecycleCallback) current : null;
        if (composeNodeLifecycleCallback != null) {
            composeNodeLifecycleCallback.onReuse();
        }
    }
}
