package androidx.constraintlayout.compose;

import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.unit.TextUnit;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.core.parser.CLObject;
import io.reactivex.annotations.SchedulerSupport;
import java.util.Arrays;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
/* compiled from: MotionSceneScope.kt */
@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001:\u0001LB\u0007\b\u0000¢\u0006\u0002\u0010\u0002J\u001a\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00062\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0005J\u001a\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00102\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0005J7\u0010\u001d\u001a\u00020\u001c2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u001c2\u0017\u0010#\u001a\u0013\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020 0$¢\u0006\u0002\b&J\u000e\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u0001J#\u0010*\u001a\u00060+R\u00020\u00002\u0012\u0010,\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010-\"\u00020\u0001¢\u0006\u0002\u0010.J1\u0010/\u001a\u00020 2\u0006\u00100\u001a\u00020\u001c2\u0006\u00101\u001a\u00020\u001c2\u0019\b\u0002\u00102\u001a\u0013\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u00020 0$¢\u0006\u0002\b&J\b\u00104\u001a\u00020\u0005H\u0002J\b\u00105\u001a\u00020\u0005H\u0002J\r\u00106\u001a\u00020 H\u0000¢\u0006\u0002\b7J;\u0010!\u001a\u00020 2\u0006\u00100\u001a\u00020\u001c2\u0006\u00101\u001a\u00020\u001c2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00052\u0017\u00102\u001a\u0013\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u00020 0$¢\u0006\u0002\b&J$\u00108\u001a\u00020 *\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u000209ø\u0001\u0000¢\u0006\u0004\b:\u0010;J$\u00108\u001a\u00020 *\u00020<2\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u000209ø\u0001\u0000¢\u0006\u0004\b:\u0010=J$\u0010>\u001a\u00020 *\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020?ø\u0001\u0000¢\u0006\u0004\b@\u0010AJ$\u0010>\u001a\u00020 *\u00020<2\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020?ø\u0001\u0000¢\u0006\u0004\b@\u0010BJ\u001a\u0010C\u001a\u00020 *\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0014J\u001a\u0010C\u001a\u00020 *\u00020<2\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0014J$\u0010D\u001a\u00020 *\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020Eø\u0001\u0000¢\u0006\u0004\bF\u0010;J$\u0010D\u001a\u00020 *\u00020<2\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020Eø\u0001\u0000¢\u0006\u0004\bF\u0010=J\u001a\u0010G\u001a\u00020 *\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\rJ\u001a\u0010G\u001a\u00020 *\u00020<2\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\rJ\u001c\u0010H\u001a\u00020 *\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0016\u0010I\u001a\u00020\u0005*\u000209H\u0002ø\u0001\u0000¢\u0006\u0004\bJ\u0010KR6\u0010\u0003\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006`\u0007X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R6\u0010\u000f\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00100\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0010`\u0007X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\t\"\u0004\b\u0012\u0010\u000bR(\u0010\u0015\u001a\u00020\u0014*\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u00148F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006M"}, d2 = {"Landroidx/constraintlayout/compose/MotionSceneScope;", "", "()V", "constraintSetsByName", "Ljava/util/HashMap;", "", "Landroidx/constraintlayout/compose/ConstraintSet;", "Lkotlin/collections/HashMap;", "getConstraintSetsByName$constraintlayout_compose_release", "()Ljava/util/HashMap;", "setConstraintSetsByName$constraintlayout_compose_release", "(Ljava/util/HashMap;)V", "generatedCount", "", "generatedIdCount", "transitionsByName", "Landroidx/constraintlayout/compose/Transition;", "getTransitionsByName$constraintlayout_compose_release", "setTransitionsByName$constraintlayout_compose_release", "value", "", "staggeredWeight", "Landroidx/constraintlayout/compose/ConstrainScope;", "getStaggeredWeight", "(Landroidx/constraintlayout/compose/ConstrainScope;)F", "setStaggeredWeight", "(Landroidx/constraintlayout/compose/ConstrainScope;F)V", "addConstraintSet", "Landroidx/constraintlayout/compose/ConstraintSetRef;", "constraintSet", "name", "addTransition", "", "transition", "extendConstraintSet", "constraintSetContent", "Lkotlin/Function1;", "Landroidx/constraintlayout/compose/ConstraintSetScope;", "Lkotlin/ExtensionFunctionType;", "createRefFor", "Landroidx/constraintlayout/compose/ConstrainedLayoutReference;", "id", "createRefsFor", "Landroidx/constraintlayout/compose/MotionSceneScope$ConstrainedLayoutReferences;", "ids", "", "([Ljava/lang/Object;)Landroidx/constraintlayout/compose/MotionSceneScope$ConstrainedLayoutReferences;", "defaultTransition", "from", TypedValues.TransitionType.S_TO, "transitionContent", "Landroidx/constraintlayout/compose/TransitionScope;", "nextId", "nextName", "reset", "reset$constraintlayout_compose_release", "customColor", "Landroidx/compose/ui/graphics/Color;", "customColor-mxwnekA", "(Landroidx/constraintlayout/compose/ConstrainScope;Ljava/lang/String;J)V", "Landroidx/constraintlayout/compose/KeyAttributeScope;", "(Landroidx/constraintlayout/compose/KeyAttributeScope;Ljava/lang/String;J)V", "customDistance", "Landroidx/compose/ui/unit/Dp;", "customDistance-wH6b6FI", "(Landroidx/constraintlayout/compose/ConstrainScope;Ljava/lang/String;F)V", "(Landroidx/constraintlayout/compose/KeyAttributeScope;Ljava/lang/String;F)V", "customFloat", "customFontSize", "Landroidx/compose/ui/unit/TextUnit;", "customFontSize-kncR6DU", "customInt", "setMotionProperty", "toJsonHexString", "toJsonHexString-8_81llA", "(J)Ljava/lang/String;", "ConstrainedLayoutReferences", "constraintlayout-compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class MotionSceneScope {
    public static final int $stable = 8;
    private int generatedCount;
    private int generatedIdCount;
    private HashMap<String, ConstraintSet> constraintSetsByName = new HashMap<>();
    private HashMap<String, Transition> transitionsByName = new HashMap<>();

    private final String nextName() {
        StringBuilder sb = new StringBuilder("androidx.constraintlayout");
        int i = this.generatedCount;
        this.generatedCount = i + 1;
        return sb.append(i).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String nextId() {
        StringBuilder sb = new StringBuilder("androidx.constraintlayoutid");
        int i = this.generatedIdCount;
        this.generatedIdCount = i + 1;
        return sb.append(i).toString();
    }

    public final HashMap<String, ConstraintSet> getConstraintSetsByName$constraintlayout_compose_release() {
        return this.constraintSetsByName;
    }

    public final void setConstraintSetsByName$constraintlayout_compose_release(HashMap<String, ConstraintSet> hashMap) {
        this.constraintSetsByName = hashMap;
    }

    public final HashMap<String, Transition> getTransitionsByName$constraintlayout_compose_release() {
        return this.transitionsByName;
    }

    public final void setTransitionsByName$constraintlayout_compose_release(HashMap<String, Transition> hashMap) {
        this.transitionsByName = hashMap;
    }

    public final void reset$constraintlayout_compose_release() {
        this.generatedCount = 0;
        this.constraintSetsByName.clear();
        this.transitionsByName.clear();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void defaultTransition$default(MotionSceneScope motionSceneScope, ConstraintSetRef constraintSetRef, ConstraintSetRef constraintSetRef2, Function1 function1, int i, Object obj) {
        if ((i & 4) != 0) {
            function1 = new Function1<TransitionScope, Unit>() { // from class: androidx.constraintlayout.compose.MotionSceneScope$defaultTransition$1
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(TransitionScope transitionScope) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(TransitionScope transitionScope) {
                    invoke2(transitionScope);
                    return Unit.INSTANCE;
                }
            };
        }
        motionSceneScope.defaultTransition(constraintSetRef, constraintSetRef2, function1);
    }

    public final void defaultTransition(ConstraintSetRef constraintSetRef, ConstraintSetRef constraintSetRef2, Function1<? super TransitionScope, Unit> function1) {
        transition(constraintSetRef, constraintSetRef2, "default", function1);
    }

    public static /* synthetic */ ConstraintSetRef constraintSet$default(MotionSceneScope motionSceneScope, String str, ConstraintSetRef constraintSetRef, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            constraintSetRef = null;
        }
        return motionSceneScope.constraintSet(str, constraintSetRef, function1);
    }

    public final ConstraintSetRef constraintSet(String str, ConstraintSetRef constraintSetRef, Function1<? super ConstraintSetScope, Unit> function1) {
        return addConstraintSet(new DslConstraintSet(function1, constraintSetRef != null ? this.constraintSetsByName.get(constraintSetRef.getName$constraintlayout_compose_release()) : null), str);
    }

    public static /* synthetic */ void transition$default(MotionSceneScope motionSceneScope, ConstraintSetRef constraintSetRef, ConstraintSetRef constraintSetRef2, String str, Function1 function1, int i, Object obj) {
        if ((i & 4) != 0) {
            str = null;
        }
        motionSceneScope.transition(constraintSetRef, constraintSetRef2, str, function1);
    }

    public final void transition(ConstraintSetRef constraintSetRef, ConstraintSetRef constraintSetRef2, String str, Function1<? super TransitionScope, Unit> function1) {
        if (str == null) {
            str = nextName();
        }
        TransitionScope transitionScope = new TransitionScope(constraintSetRef.getName$constraintlayout_compose_release(), constraintSetRef2.getName$constraintlayout_compose_release());
        function1.invoke(transitionScope);
        this.transitionsByName.put(str, new TransitionImpl(transitionScope.getObject$constraintlayout_compose_release()));
    }

    public static /* synthetic */ ConstraintSetRef addConstraintSet$default(MotionSceneScope motionSceneScope, ConstraintSet constraintSet, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        return motionSceneScope.addConstraintSet(constraintSet, str);
    }

    public final ConstraintSetRef addConstraintSet(ConstraintSet constraintSet, String str) {
        if (str == null) {
            str = nextName();
        }
        this.constraintSetsByName.put(str, constraintSet);
        return new ConstraintSetRef(str);
    }

    public static /* synthetic */ void addTransition$default(MotionSceneScope motionSceneScope, Transition transition, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        motionSceneScope.addTransition(transition, str);
    }

    public final void addTransition(Transition transition, String str) {
        if (str == null) {
            str = nextName();
        }
        this.transitionsByName.put(str, transition);
    }

    public final ConstrainedLayoutReference createRefFor(Object obj) {
        return new ConstrainedLayoutReference(obj);
    }

    public final ConstrainedLayoutReferences createRefsFor(Object... objArr) {
        return new ConstrainedLayoutReferences(Arrays.copyOf(objArr, objArr.length));
    }

    /* compiled from: MotionSceneScope.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0015\b\u0000\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0006\u001a\u00020\u0007H\u0086\u0002J\t\u0010\b\u001a\u00020\u0007H\u0086\u0002J\t\u0010\t\u001a\u00020\u0007H\u0086\u0002J\t\u0010\n\u001a\u00020\u0007H\u0086\u0002J\t\u0010\u000b\u001a\u00020\u0007H\u0086\u0002J\t\u0010\f\u001a\u00020\u0007H\u0086\u0002J\t\u0010\r\u001a\u00020\u0007H\u0086\u0002J\t\u0010\u000e\u001a\u00020\u0007H\u0086\u0002J\t\u0010\u000f\u001a\u00020\u0007H\u0086\u0002J\t\u0010\u0010\u001a\u00020\u0007H\u0086\u0002J\t\u0010\u0011\u001a\u00020\u0007H\u0086\u0002J\t\u0010\u0012\u001a\u00020\u0007H\u0086\u0002J\t\u0010\u0013\u001a\u00020\u0007H\u0086\u0002J\t\u0010\u0014\u001a\u00020\u0007H\u0086\u0002J\t\u0010\u0015\u001a\u00020\u0007H\u0086\u0002J\t\u0010\u0016\u001a\u00020\u0007H\u0086\u0002R\u0016\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005¨\u0006\u0017"}, d2 = {"Landroidx/constraintlayout/compose/MotionSceneScope$ConstrainedLayoutReferences;", "", "ids", "", "(Landroidx/constraintlayout/compose/MotionSceneScope;[Ljava/lang/Object;)V", "[Ljava/lang/Object;", "component1", "Landroidx/constraintlayout/compose/ConstrainedLayoutReference;", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "constraintlayout-compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public final class ConstrainedLayoutReferences {
        private final Object[] ids;

        public ConstrainedLayoutReferences(Object[] objArr) {
            this.ids = objArr;
        }

        public final ConstrainedLayoutReference component1() {
            Object[] objArr = this.ids;
            return new ConstrainedLayoutReference(ArraysKt.getLastIndex(objArr) >= 0 ? objArr[0] : MotionSceneScope.this.nextId());
        }

        public final ConstrainedLayoutReference component2() {
            MotionSceneScope motionSceneScope = MotionSceneScope.this;
            Object[] objArr = this.ids;
            return motionSceneScope.createRefFor(1 <= ArraysKt.getLastIndex(objArr) ? objArr[1] : motionSceneScope.nextId());
        }

        public final ConstrainedLayoutReference component3() {
            MotionSceneScope motionSceneScope = MotionSceneScope.this;
            Object[] objArr = this.ids;
            return motionSceneScope.createRefFor(2 <= ArraysKt.getLastIndex(objArr) ? objArr[2] : motionSceneScope.nextId());
        }

        public final ConstrainedLayoutReference component4() {
            MotionSceneScope motionSceneScope = MotionSceneScope.this;
            Object[] objArr = this.ids;
            return motionSceneScope.createRefFor(3 <= ArraysKt.getLastIndex(objArr) ? objArr[3] : motionSceneScope.nextId());
        }

        public final ConstrainedLayoutReference component5() {
            MotionSceneScope motionSceneScope = MotionSceneScope.this;
            Object[] objArr = this.ids;
            return motionSceneScope.createRefFor(4 <= ArraysKt.getLastIndex(objArr) ? objArr[4] : motionSceneScope.nextId());
        }

        public final ConstrainedLayoutReference component6() {
            MotionSceneScope motionSceneScope = MotionSceneScope.this;
            Object[] objArr = this.ids;
            return motionSceneScope.createRefFor(5 <= ArraysKt.getLastIndex(objArr) ? objArr[5] : motionSceneScope.nextId());
        }

        public final ConstrainedLayoutReference component7() {
            MotionSceneScope motionSceneScope = MotionSceneScope.this;
            Object[] objArr = this.ids;
            return motionSceneScope.createRefFor(6 <= ArraysKt.getLastIndex(objArr) ? objArr[6] : motionSceneScope.nextId());
        }

        public final ConstrainedLayoutReference component8() {
            MotionSceneScope motionSceneScope = MotionSceneScope.this;
            Object[] objArr = this.ids;
            return motionSceneScope.createRefFor(7 <= ArraysKt.getLastIndex(objArr) ? objArr[7] : motionSceneScope.nextId());
        }

        public final ConstrainedLayoutReference component9() {
            MotionSceneScope motionSceneScope = MotionSceneScope.this;
            Object[] objArr = this.ids;
            return motionSceneScope.createRefFor(8 <= ArraysKt.getLastIndex(objArr) ? objArr[8] : motionSceneScope.nextId());
        }

        public final ConstrainedLayoutReference component10() {
            MotionSceneScope motionSceneScope = MotionSceneScope.this;
            Object[] objArr = this.ids;
            return motionSceneScope.createRefFor(9 <= ArraysKt.getLastIndex(objArr) ? objArr[9] : motionSceneScope.nextId());
        }

        public final ConstrainedLayoutReference component11() {
            MotionSceneScope motionSceneScope = MotionSceneScope.this;
            Object[] objArr = this.ids;
            return motionSceneScope.createRefFor(10 <= ArraysKt.getLastIndex(objArr) ? objArr[10] : motionSceneScope.nextId());
        }

        public final ConstrainedLayoutReference component12() {
            MotionSceneScope motionSceneScope = MotionSceneScope.this;
            Object[] objArr = this.ids;
            return motionSceneScope.createRefFor(11 <= ArraysKt.getLastIndex(objArr) ? objArr[11] : motionSceneScope.nextId());
        }

        public final ConstrainedLayoutReference component13() {
            MotionSceneScope motionSceneScope = MotionSceneScope.this;
            Object[] objArr = this.ids;
            return motionSceneScope.createRefFor(12 <= ArraysKt.getLastIndex(objArr) ? objArr[12] : motionSceneScope.nextId());
        }

        public final ConstrainedLayoutReference component14() {
            MotionSceneScope motionSceneScope = MotionSceneScope.this;
            Object[] objArr = this.ids;
            return motionSceneScope.createRefFor(13 <= ArraysKt.getLastIndex(objArr) ? objArr[13] : motionSceneScope.nextId());
        }

        public final ConstrainedLayoutReference component15() {
            MotionSceneScope motionSceneScope = MotionSceneScope.this;
            Object[] objArr = this.ids;
            return motionSceneScope.createRefFor(14 <= ArraysKt.getLastIndex(objArr) ? objArr[14] : motionSceneScope.nextId());
        }

        public final ConstrainedLayoutReference component16() {
            MotionSceneScope motionSceneScope = MotionSceneScope.this;
            Object[] objArr = this.ids;
            return motionSceneScope.createRefFor(15 <= ArraysKt.getLastIndex(objArr) ? objArr[15] : motionSceneScope.nextId());
        }
    }

    public final void customFloat(ConstrainScope constrainScope, String str, float f) {
        if (!constrainScope.getContainerObject$constraintlayout_compose_release().has(SchedulerSupport.CUSTOM)) {
            constrainScope.getContainerObject$constraintlayout_compose_release().put(SchedulerSupport.CUSTOM, new CLObject(new char[0]));
        }
        CLObject objectOrNull = constrainScope.getContainerObject$constraintlayout_compose_release().getObjectOrNull(SchedulerSupport.CUSTOM);
        if (objectOrNull == null) {
            return;
        }
        objectOrNull.putNumber(str, f);
    }

    /* renamed from: customColor-mxwnekA  reason: not valid java name */
    public final void m7128customColormxwnekA(ConstrainScope constrainScope, String str, long j) {
        if (!constrainScope.getContainerObject$constraintlayout_compose_release().has(SchedulerSupport.CUSTOM)) {
            constrainScope.getContainerObject$constraintlayout_compose_release().put(SchedulerSupport.CUSTOM, new CLObject(new char[0]));
        }
        CLObject objectOrNull = constrainScope.getContainerObject$constraintlayout_compose_release().getObjectOrNull(SchedulerSupport.CUSTOM);
        if (objectOrNull == null) {
            return;
        }
        objectOrNull.putString(str, m7127toJsonHexString8_81llA(j));
    }

    public final void customInt(ConstrainScope constrainScope, String str, int i) {
        customFloat(constrainScope, str, i);
    }

    /* renamed from: customDistance-wH6b6FI  reason: not valid java name */
    public final void m7130customDistancewH6b6FI(ConstrainScope constrainScope, String str, float f) {
        customFloat(constrainScope, str, f);
    }

    /* renamed from: customFontSize-kncR6DU  reason: not valid java name */
    public final void m7132customFontSizekncR6DU(ConstrainScope constrainScope, String str, long j) {
        customFloat(constrainScope, str, TextUnit.m6878getValueimpl(j));
    }

    public final float getStaggeredWeight(ConstrainScope constrainScope) {
        if (constrainScope.getContainerObject$constraintlayout_compose_release().has("motion")) {
            return constrainScope.getContainerObject$constraintlayout_compose_release().getObject("motion").getFloatOrNaN("stagger");
        }
        return Float.NaN;
    }

    public final void setStaggeredWeight(ConstrainScope constrainScope, float f) {
        setMotionProperty(constrainScope, "stagger", f);
    }

    private final void setMotionProperty(ConstrainScope constrainScope, String str, float f) {
        if (!constrainScope.getContainerObject$constraintlayout_compose_release().has("motion")) {
            constrainScope.getContainerObject$constraintlayout_compose_release().put("motion", new CLObject(new char[0]));
        }
        CLObject objectOrNull = constrainScope.getContainerObject$constraintlayout_compose_release().getObjectOrNull("motion");
        if (objectOrNull == null) {
            return;
        }
        objectOrNull.putNumber(str, f);
    }

    public final void customFloat(KeyAttributeScope keyAttributeScope, String str, float f) {
        keyAttributeScope.getCustomPropertiesValue$constraintlayout_compose_release().put(str, Float.valueOf(f));
    }

    /* renamed from: customColor-mxwnekA  reason: not valid java name */
    public final void m7129customColormxwnekA(KeyAttributeScope keyAttributeScope, String str, long j) {
        keyAttributeScope.getCustomPropertiesValue$constraintlayout_compose_release().put(str, m7127toJsonHexString8_81llA(j));
    }

    public final void customInt(KeyAttributeScope keyAttributeScope, String str, int i) {
        keyAttributeScope.getCustomPropertiesValue$constraintlayout_compose_release().put(str, Integer.valueOf(i));
    }

    /* renamed from: customDistance-wH6b6FI  reason: not valid java name */
    public final void m7131customDistancewH6b6FI(KeyAttributeScope keyAttributeScope, String str, float f) {
        keyAttributeScope.getCustomPropertiesValue$constraintlayout_compose_release().put(str, Float.valueOf(f));
    }

    /* renamed from: customFontSize-kncR6DU  reason: not valid java name */
    public final void m7133customFontSizekncR6DU(KeyAttributeScope keyAttributeScope, String str, long j) {
        keyAttributeScope.getCustomPropertiesValue$constraintlayout_compose_release().put(str, Float.valueOf(TextUnit.m6878getValueimpl(j)));
    }

    /* renamed from: toJsonHexString-8_81llA  reason: not valid java name */
    private final String m7127toJsonHexString8_81llA(long j) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("#%08X", Arrays.copyOf(new Object[]{Integer.valueOf(ColorKt.m4132toArgb8_81llA(j))}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        return format;
    }
}
