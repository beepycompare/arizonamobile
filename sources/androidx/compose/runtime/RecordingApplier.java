package androidx.compose.runtime;

import androidx.collection.MutableIntList;
import androidx.collection.MutableObjectList;
import androidx.compose.runtime.internal.RememberEventDispatcher;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
/* compiled from: PausableComposition.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u0000 +*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0001+B\u000f\u0012\u0006\u0010\u0003\u001a\u00028\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0005J\b\u0010\u0013\u001a\u00020\u0011H\u0016J\u0018\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J \u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\b\u0010\u001b\u001a\u00020\u0011H\u0016J\u001d\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001eJ\u001d\u0010\u001f\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001eJ3\u0010 \u001a\u00020\u00112\u001f\u0010!\u001a\u001b\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0004\u0012\u00020\u00110\"¢\u0006\u0002\b#2\b\u0010$\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010%\u001a\u00020\u0011H\u0016J\u001c\u0010&\u001a\u00020\u00112\f\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010(\u001a\u00020)J\u0006\u0010*\u001a\u00020\u0011R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u00028\u0000X\u0096\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u0005¨\u0006,"}, d2 = {"Landroidx/compose/runtime/RecordingApplier;", "N", "Landroidx/compose/runtime/Applier;", "root", "<init>", "(Ljava/lang/Object;)V", "operations", "Landroidx/collection/MutableIntList;", "instances", "Landroidx/collection/MutableObjectList;", "", "current", "getCurrent", "()Ljava/lang/Object;", "setCurrent", "Ljava/lang/Object;", "down", "", "node", "up", "remove", FirebaseAnalytics.Param.INDEX, "", "count", "move", "from", TypedValues.TransitionType.S_TO, "clear", "insertBottomUp", "instance", "(ILjava/lang/Object;)V", "insertTopDown", "apply", "block", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", "value", "reuse", "playTo", "applier", "rememberManager", "Landroidx/compose/runtime/internal/RememberEventDispatcher;", "markRecomposePending", "Companion", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class RecordingApplier<N> implements Applier<N> {
    public static final int APPLY = 7;
    public static final int CLEAR = 4;
    public static final int DOWN = 1;
    public static final int INSERT_BOTTOM_UP = 5;
    public static final int INSERT_TOP_DOWN = 6;
    public static final int MOVE = 3;
    public static final int RECOMPOSE_PENDING = 9;
    public static final int REMOVE = 2;
    public static final int REUSE = 8;
    public static final int UP = 0;
    private N current;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private final MutableIntList operations = new MutableIntList(0, 1, null);
    private final MutableObjectList<Object> instances = new MutableObjectList<>(0, 1, null);

    public RecordingApplier(N n) {
        this.current = n;
    }

    @Override // androidx.compose.runtime.Applier
    public N getCurrent() {
        return this.current;
    }

    public void setCurrent(N n) {
        this.current = n;
    }

    @Override // androidx.compose.runtime.Applier
    public void down(N n) {
        this.operations.add(1);
        this.instances.add(n);
    }

    @Override // androidx.compose.runtime.Applier
    public void up() {
        this.operations.add(0);
    }

    @Override // androidx.compose.runtime.Applier
    public void remove(int i, int i2) {
        this.operations.add(2);
        this.operations.add(i);
        this.operations.add(i2);
    }

    @Override // androidx.compose.runtime.Applier
    public void move(int i, int i2, int i3) {
        this.operations.add(3);
        this.operations.add(i);
        this.operations.add(i2);
        this.operations.add(i3);
    }

    @Override // androidx.compose.runtime.Applier
    public void clear() {
        this.operations.add(4);
    }

    @Override // androidx.compose.runtime.Applier
    public void insertBottomUp(int i, N n) {
        this.operations.add(5);
        this.operations.add(i);
        this.instances.add(n);
    }

    @Override // androidx.compose.runtime.Applier
    public void insertTopDown(int i, N n) {
        this.operations.add(6);
        this.operations.add(i);
        this.instances.add(n);
    }

    @Override // androidx.compose.runtime.Applier
    public void apply(Function2<? super N, Object, Unit> function2, Object obj) {
        this.operations.add(7);
        this.instances.add(function2);
        this.instances.add(obj);
    }

    @Override // androidx.compose.runtime.Applier
    public void reuse() {
        this.operations.add(8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void playTo(Applier<N> applier, RememberEventDispatcher rememberEventDispatcher) {
        Exception exc;
        int i;
        int i2;
        MutableIntList mutableIntList = this.operations;
        int i3 = mutableIntList._size;
        MutableObjectList<Object> mutableObjectList = this.instances;
        MutableObjectList mutableObjectList2 = new MutableObjectList(0, 1, null);
        applier.onBeginChanges();
        int i4 = 0;
        int i5 = 0;
        while (i4 < i3) {
            int i6 = i4 + 1;
            try {
                try {
                    switch (mutableIntList.get(i4)) {
                        case 0:
                            applier.up();
                            i4 = i6;
                            break;
                        case 1:
                            int i7 = i5 + 1;
                            applier.down(mutableObjectList.get(i5));
                            i5 = i7;
                            i4 = i6;
                            break;
                        case 2:
                            int i8 = i4 + 2;
                            i4 += 3;
                            applier.remove(mutableIntList.get(i6), mutableIntList.get(i8));
                            break;
                        case 3:
                            int i9 = i4 + 2;
                            try {
                                i = i4 + 3;
                            } catch (Exception e) {
                                exc = e;
                                i4 = i9;
                            }
                            try {
                                i4 += 4;
                                applier.move(mutableIntList.get(i6), mutableIntList.get(i9), mutableIntList.get(i));
                                break;
                            } catch (Exception e2) {
                                exc = e2;
                                i4 = i;
                                throw new ComposePausableCompositionException(mutableObjectList, mutableObjectList2, mutableIntList, i4 - 1, exc);
                            }
                        case 4:
                            applier.clear();
                            i4 = i6;
                            break;
                        case 5:
                            i4 += 2;
                            i2 = i5 + 1;
                            applier.insertBottomUp(mutableIntList.get(i6), mutableObjectList.get(i5));
                            i5 = i2;
                            break;
                        case 6:
                            i4 += 2;
                            try {
                                i2 = i5 + 1;
                                applier.insertTopDown(mutableIntList.get(i6), mutableObjectList.get(i5));
                                i5 = i2;
                                break;
                            } catch (Exception e3) {
                                exc = e3;
                                throw new ComposePausableCompositionException(mutableObjectList, mutableObjectList2, mutableIntList, i4 - 1, exc);
                            }
                        case 7:
                            int i10 = i5 + 1;
                            Object obj = mutableObjectList.get(i5);
                            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type @[ExtensionFunctionType] kotlin.Function2<kotlin.Any?, kotlin.Any?, kotlin.Unit>");
                            i5 += 2;
                            applier.apply((Function2) TypeIntrinsics.beforeCheckcastToFunctionOfArity(obj, 2), mutableObjectList.get(i10));
                            i4 = i6;
                            break;
                        case 8:
                            Object current = applier.getCurrent();
                            if (current instanceof ComposeNodeLifecycleCallback) {
                                rememberEventDispatcher.dispatchOnDeactivateIfNecessary((ComposeNodeLifecycleCallback) current);
                            }
                            mutableObjectList2.add(current);
                            applier.reuse();
                            i4 = i6;
                            break;
                        default:
                            i4 = i6;
                            break;
                    }
                } catch (Exception e4) {
                    exc = e4;
                    i4 = i6;
                }
            } catch (Throwable th) {
                applier.onEndChanges();
                throw th;
            }
        }
        if (!(i5 == mutableObjectList.getSize())) {
            ComposerKt.composeImmediateRuntimeError("Applier operation size mismatch");
        }
        mutableObjectList.clear();
        mutableIntList.clear();
        applier.onEndChanges();
    }

    public final void markRecomposePending() {
        this.operations.add(9);
    }

    /* compiled from: PausableComposition.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Landroidx/compose/runtime/RecordingApplier$Companion;", "", "<init>", "()V", "UP", "", "DOWN", "REMOVE", "MOVE", "CLEAR", "INSERT_BOTTOM_UP", "INSERT_TOP_DOWN", "APPLY", "REUSE", "RECOMPOSE_PENDING", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
