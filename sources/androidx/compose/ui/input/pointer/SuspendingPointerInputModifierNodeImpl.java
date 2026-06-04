package androidx.compose.ui.input.pointer;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpRect;
import androidx.compose.ui.unit.IntSize;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.widget.FacebookDialog;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
/* compiled from: SuspendingPointerInputFilter.kt */
@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001_B=\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0014\b\u0002\u0010\b\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0006\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rBZ\b\u0017\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0012\u0010\b\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0006\u0018\u00010\t\u0012'\u0010\u000e\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u000f¢\u0006\u0002\b\u0012¢\u0006\u0004\b\f\u0010\u0013J\b\u0010I\u001a\u00020\u0011H\u0016J\b\u0010J\u001a\u00020\u0011H\u0016J\b\u0010K\u001a\u00020\u0011H\u0016J\b\u0010L\u001a\u00020\u0011H\u0016J?\u0010M\u001a\u00020\u00112\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0012\u0010\b\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0006\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH\u0000¢\u0006\u0004\bN\u0010\rJ-\u0010O\u001a\u00020\u00112\u0006\u0010P\u001a\u00020Q2\u001a\u0010R\u001a\u0016\u0012\f\u0012\n\u0012\u0002\b\u000308R\u00020\u0000\u0012\u0004\u0012\u00020\u00110SH\u0082\bJ\u0018\u0010T\u001a\u00020\u00112\u0006\u0010U\u001a\u0002052\u0006\u0010P\u001a\u00020QH\u0002J'\u0010V\u001a\u00020\u00112\u0006\u0010U\u001a\u0002052\u0006\u0010P\u001a\u00020Q2\u0006\u0010W\u001a\u00020/H\u0016¢\u0006\u0004\bX\u0010YJ\b\u0010Z\u001a\u00020\u0011H\u0016J=\u0010[\u001a\u0002H\\\"\u0004\b\u0000\u0010\\2'\u0010R\u001a#\b\u0001\u0012\u0004\u0012\u00020]\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\\0\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u000f¢\u0006\u0002\b\u0012H\u0096@¢\u0006\u0002\u0010^R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0006\u0018\u00010\tX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0014R3\u0010\u0015\u001a%\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u000f¢\u0006\u0002\b\u0012X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000Rl\u0010\u0019\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u000f¢\u0006\u0002\b\u00122'\u0010\u0018\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u000f¢\u0006\u0002\b\u00128V@VX\u0097\u000e¢\u0006\u0012\u0012\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR$\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u000b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0014\u0010$\u001a\u00020%8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'R\u0014\u0010(\u001a\u00020%8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b)\u0010'R\u0014\u0010*\u001a\u00020+8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b,\u0010-R\u0014\u0010.\u001a\u00020/8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b0\u00101R\u0010\u00102\u001a\u0004\u0018\u000103X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u000205X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u00106\u001a\u0010\u0012\f\u0012\n\u0012\u0002\b\u000308R\u00020\u000007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00109\u001a\u00060\u0006j\u0002`:X\u0082\u0004¢\u0006\u0004\n\u0002\u0010;R\u001c\u0010<\u001a\u0010\u0012\f\u0012\n\u0012\u0002\b\u000308R\u00020\u000007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010=\u001a\u0004\u0018\u000105X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010>\u001a\u00020/X\u0082\u000e¢\u0006\u0004\n\u0002\u0010?R\u0014\u0010@\u001a\u00020A8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bB\u00101R\u001a\u0010C\u001a\u00020DX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010F\"\u0004\bG\u0010H¨\u0006`"}, d2 = {"Landroidx/compose/ui/input/pointer/SuspendingPointerInputModifierNodeImpl;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/input/pointer/SuspendingPointerInputModifierNode;", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "Landroidx/compose/ui/unit/Density;", "key1", "", "key2", UserMetadata.KEYDATA_FILENAME, "", "pointerInputEventHandler", "Landroidx/compose/ui/input/pointer/PointerInputEventHandler;", "<init>", "(Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;Landroidx/compose/ui/input/pointer/PointerInputEventHandler;)V", "pointerInputEvent", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "[Ljava/lang/Object;", "_deprecatedPointerInputHandler", "Lkotlin/jvm/functions/Function2;", "_pointerInputEventHandler", "value", "pointerInputHandler", "getPointerInputHandler$annotations", "()V", "getPointerInputHandler", "()Lkotlin/jvm/functions/Function2;", "setPointerInputHandler", "(Lkotlin/jvm/functions/Function2;)V", "getPointerInputEventHandler", "()Landroidx/compose/ui/input/pointer/PointerInputEventHandler;", "setPointerInputEventHandler", "(Landroidx/compose/ui/input/pointer/PointerInputEventHandler;)V", "density", "", "getDensity", "()F", "fontScale", "getFontScale", "viewConfiguration", "Landroidx/compose/ui/platform/ViewConfiguration;", "getViewConfiguration", "()Landroidx/compose/ui/platform/ViewConfiguration;", "size", "Landroidx/compose/ui/unit/IntSize;", "getSize-YbymL2g", "()J", "pointerInputJob", "Lkotlinx/coroutines/Job;", "currentEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "pointerHandlers", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/ui/input/pointer/SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine;", "pointerHandlersLock", "Landroidx/compose/ui/platform/SynchronizedObject;", "Ljava/lang/Object;", "dispatchingPointerHandlers", "lastPointerEvent", "boundsSize", "J", "extendedTouchPadding", "Landroidx/compose/ui/geometry/Size;", "getExtendedTouchPadding-NH-jbRc", "interceptOutOfBoundsChildEvents", "", "getInterceptOutOfBoundsChildEvents", "()Z", "setInterceptOutOfBoundsChildEvents", "(Z)V", "onDetach", "onDensityChange", "onViewConfigurationChange", "resetPointerInputHandler", "update", "update$ui", "forEachCurrentPointerHandler", "pass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "block", "Lkotlin/Function1;", "dispatchPointerEvent", "pointerEvent", "onPointerEvent", "bounds", "onPointerEvent-H0pRuoY", "(Landroidx/compose/ui/input/pointer/PointerEvent;Landroidx/compose/ui/input/pointer/PointerEventPass;J)V", "onCancelPointerInput", "awaitPointerEventScope", "R", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "PointerEventHandlerCoroutine", "ui"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SuspendingPointerInputModifierNodeImpl extends Modifier.Node implements SuspendingPointerInputModifierNode, PointerInputScope, Density {
    public static final int $stable = 0;
    private Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object> _deprecatedPointerInputHandler;
    private PointerInputEventHandler _pointerInputEventHandler;
    private long boundsSize;
    private PointerEvent currentEvent;
    private final MutableVector<PointerEventHandlerCoroutine<?>> dispatchingPointerHandlers;
    private boolean interceptOutOfBoundsChildEvents;
    private Object key1;
    private Object key2;
    private Object[] keys;
    private PointerEvent lastPointerEvent;
    private final MutableVector<PointerEventHandlerCoroutine<?>> pointerHandlers;
    private final Object pointerHandlersLock;
    private Job pointerInputJob;

    /* compiled from: SuspendingPointerInputFilter.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PointerEventPass.values().length];
            try {
                iArr[PointerEventPass.Initial.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PointerEventPass.Final.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PointerEventPass.Main.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Deprecated(message = "Super property deprecated")
    public static /* synthetic */ void getPointerInputHandler$annotations() {
    }

    public SuspendingPointerInputModifierNodeImpl(Object obj, Object obj2, Object[] objArr, PointerInputEventHandler pointerInputEventHandler) {
        PointerEvent pointerEvent;
        this.key1 = obj;
        this.key2 = obj2;
        this.keys = objArr;
        this._pointerInputEventHandler = pointerInputEventHandler;
        pointerEvent = SuspendingPointerInputFilterKt.EmptyPointerEvent;
        this.currentEvent = pointerEvent;
        MutableVector<PointerEventHandlerCoroutine<?>> mutableVector = new MutableVector<>(new PointerEventHandlerCoroutine[16], 0);
        this.pointerHandlers = mutableVector;
        this.pointerHandlersLock = mutableVector;
        this.dispatchingPointerHandlers = new MutableVector<>(new PointerEventHandlerCoroutine[16], 0);
        this.boundsSize = IntSize.Companion.m8336getZeroYbymL2g();
    }

    public /* synthetic */ SuspendingPointerInputModifierNodeImpl(Object obj, Object obj2, Object[] objArr, PointerInputEventHandler pointerInputEventHandler, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : obj, (i & 2) != 0 ? null : obj2, (i & 4) != 0 ? null : objArr, pointerInputEventHandler);
    }

    @Deprecated(message = "Exists to maintain compatibility with previous API shape")
    public SuspendingPointerInputModifierNodeImpl(Object obj, Object obj2, Object[] objArr, Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object> function2) {
        this(obj, obj2, objArr, new PointerInputEventHandler() { // from class: androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl.1
            @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
            public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
                return Unit.INSTANCE;
            }
        });
        this._deprecatedPointerInputHandler = function2;
    }

    @Override // androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNode
    public Function2<PointerInputScope, Continuation<? super Unit>, Object> getPointerInputHandler() {
        Function2 function2 = this._deprecatedPointerInputHandler;
        return function2 == null ? new SuspendingPointerInputModifierNodeImpl$pointerInputHandler$1(null) : function2;
    }

    @Override // androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNode
    public void setPointerInputHandler(Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object> function2) {
        resetPointerInputHandler();
        this._deprecatedPointerInputHandler = function2;
    }

    @Override // androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNode
    public void setPointerInputEventHandler(PointerInputEventHandler pointerInputEventHandler) {
        resetPointerInputHandler();
        this._deprecatedPointerInputHandler = null;
        this._pointerInputEventHandler = pointerInputEventHandler;
    }

    @Override // androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNode
    public PointerInputEventHandler getPointerInputEventHandler() {
        return this._pointerInputEventHandler;
    }

    @Override // androidx.compose.ui.unit.Density
    public float getDensity() {
        return DelegatableNodeKt.requireLayoutNode(this).getDensity().getDensity();
    }

    @Override // androidx.compose.ui.unit.FontScaling
    public float getFontScale() {
        return DelegatableNodeKt.requireLayoutNode(this).getDensity().getFontScale();
    }

    @Override // androidx.compose.ui.input.pointer.PointerInputScope
    public ViewConfiguration getViewConfiguration() {
        return DelegatableNodeKt.requireLayoutNode(this).getViewConfiguration();
    }

    @Override // androidx.compose.ui.input.pointer.PointerInputScope
    /* renamed from: getSize-YbymL2g */
    public long mo425getSizeYbymL2g() {
        return this.boundsSize;
    }

    @Override // androidx.compose.ui.input.pointer.PointerInputScope
    /* renamed from: getExtendedTouchPadding-NH-jbRc */
    public long mo424getExtendedTouchPaddingNHjbRc() {
        long j = mo435toSizeXkaWNTQ(getViewConfiguration().mo7050getMinimumTouchTargetSizeMYxV2XQ());
        long mo425getSizeYbymL2g = mo425getSizeYbymL2g();
        return Size.m5163constructorimpl((Float.floatToRawIntBits(Math.max(0.0f, Float.intBitsToFloat((int) (j >> 32)) - ((int) (mo425getSizeYbymL2g >> 32))) / 2.0f) << 32) | (Float.floatToRawIntBits(Math.max(0.0f, Float.intBitsToFloat((int) (j & 4294967295L)) - ((int) (mo425getSizeYbymL2g & 4294967295L))) / 2.0f) & 4294967295L));
    }

    @Override // androidx.compose.ui.input.pointer.PointerInputScope
    public boolean getInterceptOutOfBoundsChildEvents() {
        return this.interceptOutOfBoundsChildEvents;
    }

    @Override // androidx.compose.ui.input.pointer.PointerInputScope
    public void setInterceptOutOfBoundsChildEvents(boolean z) {
        this.interceptOutOfBoundsChildEvents = z;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        resetPointerInputHandler();
        super.onDetach();
    }

    @Override // androidx.compose.ui.node.DelegatableNode, androidx.compose.ui.node.PointerInputModifierNode
    public void onDensityChange() {
        resetPointerInputHandler();
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    public void onViewConfigurationChange() {
        resetPointerInputHandler();
    }

    @Override // androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNode
    public void resetPointerInputHandler() {
        Job job = this.pointerInputJob;
        if (job != null) {
            job.cancel((CancellationException) new PointerInputResetException());
            this.pointerInputJob = null;
        }
    }

    public final void update$ui(Object obj, Object obj2, Object[] objArr, PointerInputEventHandler pointerInputEventHandler) {
        boolean z = !Intrinsics.areEqual(this.key1, obj);
        this.key1 = obj;
        if (!Intrinsics.areEqual(this.key2, obj2)) {
            z = true;
        }
        this.key2 = obj2;
        Object[] objArr2 = this.keys;
        if (objArr2 != null && objArr == null) {
            z = true;
        }
        if (objArr2 == null && objArr != null) {
            z = true;
        }
        if (objArr2 != null && objArr != null && !Arrays.equals(objArr, objArr2)) {
            z = true;
        }
        this.keys = objArr;
        if (getPointerInputEventHandler().getClass() == pointerInputEventHandler.getClass() ? z : true) {
            resetPointerInputHandler();
        }
        this._pointerInputEventHandler = pointerInputEventHandler;
    }

    private final void forEachCurrentPointerHandler(PointerEventPass pointerEventPass, Function1<? super PointerEventHandlerCoroutine<?>, Unit> function1) {
        synchronized (this.pointerHandlersLock) {
            MutableVector<PointerEventHandlerCoroutine<?>> mutableVector = this.dispatchingPointerHandlers;
            mutableVector.addAll(mutableVector.getSize(), this.pointerHandlers);
        }
        try {
            int i = WhenMappings.$EnumSwitchMapping$0[pointerEventPass.ordinal()];
            if (i == 1 || i == 2) {
                MutableVector<PointerEventHandlerCoroutine<?>> mutableVector2 = this.dispatchingPointerHandlers;
                PointerEventHandlerCoroutine<?>[] pointerEventHandlerCoroutineArr = mutableVector2.content;
                int size = mutableVector2.getSize();
                for (int i2 = 0; i2 < size; i2++) {
                    function1.invoke(pointerEventHandlerCoroutineArr[i2]);
                }
            } else if (i != 3) {
                throw new NoWhenBranchMatchedException();
            } else {
                MutableVector<PointerEventHandlerCoroutine<?>> mutableVector3 = this.dispatchingPointerHandlers;
                int size2 = mutableVector3.getSize() - 1;
                PointerEventHandlerCoroutine<?>[] pointerEventHandlerCoroutineArr2 = mutableVector3.content;
                if (size2 < pointerEventHandlerCoroutineArr2.length) {
                    while (size2 >= 0) {
                        function1.invoke(pointerEventHandlerCoroutineArr2[size2]);
                        size2--;
                    }
                }
            }
        } finally {
            this.dispatchingPointerHandlers.clear();
        }
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    /* renamed from: onPointerEvent-H0pRuoY */
    public void mo257onPointerEventH0pRuoY(PointerEvent pointerEvent, PointerEventPass pointerEventPass, long j) {
        Job launch$default;
        this.boundsSize = j;
        if (pointerEventPass == PointerEventPass.Initial) {
            this.currentEvent = pointerEvent;
        }
        if (this.pointerInputJob == null) {
            launch$default = BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, CoroutineStart.UNDISPATCHED, new SuspendingPointerInputModifierNodeImpl$onPointerEvent$1(this, null), 1, null);
            this.pointerInputJob = launch$default;
        }
        dispatchPointerEvent(pointerEvent, pointerEventPass);
        List<PointerInputChange> changes = pointerEvent.getChanges();
        int size = changes.size();
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= size) {
                z = true;
                break;
            } else if (!PointerEventKt.changedToUpIgnoreConsumed(changes.get(i))) {
                break;
            } else {
                i++;
            }
        }
        if (z) {
            pointerEvent = null;
        }
        this.lastPointerEvent = pointerEvent;
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    public void onCancelPointerInput() {
        PointerEvent pointerEvent = this.lastPointerEvent;
        if (pointerEvent == null) {
            return;
        }
        List<PointerInputChange> changes = pointerEvent.getChanges();
        int size = changes.size();
        for (int i = 0; i < size; i++) {
            if (changes.get(i).getPressed()) {
                List<PointerInputChange> changes2 = pointerEvent.getChanges();
                ArrayList arrayList = new ArrayList(changes2.size());
                int size2 = changes2.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    PointerInputChange pointerInputChange = changes2.get(i2);
                    long m6682getIdJ3iCeTQ = pointerInputChange.m6682getIdJ3iCeTQ();
                    long m6685getPositionF1C5BW0 = pointerInputChange.m6685getPositionF1C5BW0();
                    arrayList.add(new PointerInputChange(m6682getIdJ3iCeTQ, pointerInputChange.getUptimeMillis(), m6685getPositionF1C5BW0, false, pointerInputChange.getPressure(), pointerInputChange.getUptimeMillis(), pointerInputChange.m6685getPositionF1C5BW0(), pointerInputChange.getPressed(), pointerInputChange.getPressed(), pointerInputChange.m6688getTypeT8wyACA(), 0L, 0.0f, 0L, 7168, (DefaultConstructorMarker) null));
                }
                PointerEvent pointerEvent2 = new PointerEvent(arrayList);
                this.currentEvent = pointerEvent2;
                dispatchPointerEvent(pointerEvent2, PointerEventPass.Initial);
                dispatchPointerEvent(pointerEvent2, PointerEventPass.Main);
                dispatchPointerEvent(pointerEvent2, PointerEventPass.Final);
                this.lastPointerEvent = null;
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SuspendingPointerInputFilter.kt */
    @Metadata(d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b\u0082\u0004\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u00022\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00010\u0004B\u0015\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\fJ\u0010\u0010\u001f\u001a\u00020\u001c2\b\u0010 \u001a\u0004\u0018\u00010!J\u001b\u0010&\u001a\u00020\u001c2\f\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00000(H\u0016¢\u0006\u0002\u0010)J\u0016\u0010*\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\fH\u0096@¢\u0006\u0002\u0010+JG\u0010,\u001a\u0004\u0018\u0001H-\"\u0004\b\u0001\u0010-2\u0006\u0010.\u001a\u00020/2'\u00100\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H-0\u0004\u0012\u0006\u0012\u0004\u0018\u00010201¢\u0006\u0002\b3H\u0096@¢\u0006\u0002\u00104JE\u00105\u001a\u0002H-\"\u0004\b\u0001\u0010-2\u0006\u0010.\u001a\u00020/2'\u00100\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H-0\u0004\u0012\u0006\u0012\u0004\u0018\u00010201¢\u0006\u0002\b3H\u0096@¢\u0006\u0002\u00104J\u0014\u00106\u001a\u000207*\u000208H\u0097\u0001¢\u0006\u0004\b9\u0010:J\u0014\u00106\u001a\u000207*\u00020;H\u0097\u0001¢\u0006\u0004\b<\u0010=J\u0014\u0010>\u001a\u000208*\u000207H\u0097\u0001¢\u0006\u0004\b?\u0010@J\u0014\u0010>\u001a\u000208*\u00020AH\u0097\u0001¢\u0006\u0004\b?\u0010BJ\u0014\u0010>\u001a\u000208*\u00020;H\u0097\u0001¢\u0006\u0004\bC\u0010DJ\u0014\u0010E\u001a\u00020F*\u00020\u0019H\u0097\u0001¢\u0006\u0004\bG\u0010HJ\u0014\u0010I\u001a\u00020A*\u000208H\u0097\u0001¢\u0006\u0004\bJ\u0010BJ\u0014\u0010I\u001a\u00020A*\u00020;H\u0097\u0001¢\u0006\u0004\bK\u0010DJ\r\u0010L\u001a\u00020M*\u00020NH\u0097\u0001J\u0014\u0010O\u001a\u00020\u0019*\u00020FH\u0097\u0001¢\u0006\u0004\bP\u0010HJ\u0014\u0010Q\u001a\u00020;*\u000207H\u0097\u0001¢\u0006\u0004\bR\u0010SJ\u0014\u0010Q\u001a\u00020;*\u00020AH\u0097\u0001¢\u0006\u0004\bR\u0010TJ\u0014\u0010Q\u001a\u00020;*\u000208H\u0097\u0001¢\u0006\u0004\bU\u0010TR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u00198VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0013R\u0014\u0010\"\u001a\u00020#X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0014\u0010V\u001a\u00020A8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\bW\u0010XR\u0014\u0010Y\u001a\u00020A8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\bZ\u0010X¨\u0006["}, d2 = {"Landroidx/compose/ui/input/pointer/SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine;", "R", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "Landroidx/compose/ui/unit/Density;", "Lkotlin/coroutines/Continuation;", "completion", "<init>", "(Landroidx/compose/ui/input/pointer/SuspendingPointerInputModifierNodeImpl;Lkotlin/coroutines/Continuation;)V", "pointerAwaiter", "Lkotlinx/coroutines/CancellableContinuation;", "Landroidx/compose/ui/input/pointer/PointerEvent;", "awaitPass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "currentEvent", "getCurrentEvent", "()Landroidx/compose/ui/input/pointer/PointerEvent;", "size", "Landroidx/compose/ui/unit/IntSize;", "getSize-YbymL2g", "()J", "viewConfiguration", "Landroidx/compose/ui/platform/ViewConfiguration;", "getViewConfiguration", "()Landroidx/compose/ui/platform/ViewConfiguration;", "extendedTouchPadding", "Landroidx/compose/ui/geometry/Size;", "getExtendedTouchPadding-NH-jbRc", "offerPointerEvent", "", NotificationCompat.CATEGORY_EVENT, "pass", FacebookDialog.COMPLETION_GESTURE_CANCEL, "cause", "", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "resumeWith", "result", "Lkotlin/Result;", "(Ljava/lang/Object;)V", "awaitPointerEvent", "(Landroidx/compose/ui/input/pointer/PointerEventPass;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "withTimeoutOrNull", ExifInterface.GPS_DIRECTION_TRUE, "timeMillis", "", "block", "Lkotlin/Function2;", "", "Lkotlin/ExtensionFunctionType;", "(JLkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "withTimeout", "roundToPx", "", "Landroidx/compose/ui/unit/Dp;", "roundToPx-0680j_4", "(F)I", "Landroidx/compose/ui/unit/TextUnit;", "roundToPx--R2X_6o", "(J)I", "toDp", "toDp-u2uoSUM", "(I)F", "", "(F)F", "toDp-GaN1DYA", "(J)F", "toDpSize", "Landroidx/compose/ui/unit/DpSize;", "toDpSize-k-rfVVM", "(J)J", "toPx", "toPx-0680j_4", "toPx--R2X_6o", "toRect", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/unit/DpRect;", "toSize", "toSize-XkaWNTQ", "toSp", "toSp-kPz2Gy4", "(I)J", "(F)J", "toSp-0xMU5do", "density", "getDensity", "()F", "fontScale", "getFontScale", "ui"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public final class PointerEventHandlerCoroutine<R> implements AwaitPointerEventScope, Density, Continuation<R> {
        private final /* synthetic */ SuspendingPointerInputModifierNodeImpl $$delegate_0;
        private final Continuation<R> completion;
        private CancellableContinuation<? super PointerEvent> pointerAwaiter;
        private PointerEventPass awaitPass = PointerEventPass.Main;
        private final CoroutineContext context = EmptyCoroutineContext.INSTANCE;

        @Override // androidx.compose.ui.unit.Density
        public float getDensity() {
            return this.$$delegate_0.getDensity();
        }

        @Override // androidx.compose.ui.unit.FontScaling
        public float getFontScale() {
            return this.$$delegate_0.getFontScale();
        }

        @Override // androidx.compose.ui.unit.Density
        /* renamed from: roundToPx--R2X_6o */
        public int mo427roundToPxR2X_6o(long j) {
            return this.$$delegate_0.mo427roundToPxR2X_6o(j);
        }

        @Override // androidx.compose.ui.unit.Density
        /* renamed from: roundToPx-0680j_4 */
        public int mo428roundToPx0680j_4(float f) {
            return this.$$delegate_0.mo428roundToPx0680j_4(f);
        }

        @Override // androidx.compose.ui.unit.FontScaling
        /* renamed from: toDp-GaN1DYA */
        public float mo429toDpGaN1DYA(long j) {
            return this.$$delegate_0.mo429toDpGaN1DYA(j);
        }

        @Override // androidx.compose.ui.unit.Density
        /* renamed from: toDp-u2uoSUM */
        public float mo430toDpu2uoSUM(float f) {
            return this.$$delegate_0.mo430toDpu2uoSUM(f);
        }

        @Override // androidx.compose.ui.unit.Density
        /* renamed from: toDp-u2uoSUM */
        public float mo431toDpu2uoSUM(int i) {
            return this.$$delegate_0.mo431toDpu2uoSUM(i);
        }

        @Override // androidx.compose.ui.unit.Density
        /* renamed from: toDpSize-k-rfVVM */
        public long mo432toDpSizekrfVVM(long j) {
            return this.$$delegate_0.mo432toDpSizekrfVVM(j);
        }

        @Override // androidx.compose.ui.unit.Density
        /* renamed from: toPx--R2X_6o */
        public float mo433toPxR2X_6o(long j) {
            return this.$$delegate_0.mo433toPxR2X_6o(j);
        }

        @Override // androidx.compose.ui.unit.Density
        /* renamed from: toPx-0680j_4 */
        public float mo434toPx0680j_4(float f) {
            return this.$$delegate_0.mo434toPx0680j_4(f);
        }

        @Override // androidx.compose.ui.unit.Density
        public Rect toRect(DpRect dpRect) {
            return this.$$delegate_0.toRect(dpRect);
        }

        @Override // androidx.compose.ui.unit.Density
        /* renamed from: toSize-XkaWNTQ */
        public long mo435toSizeXkaWNTQ(long j) {
            return this.$$delegate_0.mo435toSizeXkaWNTQ(j);
        }

        @Override // androidx.compose.ui.unit.FontScaling
        /* renamed from: toSp-0xMU5do */
        public long mo436toSp0xMU5do(float f) {
            return this.$$delegate_0.mo436toSp0xMU5do(f);
        }

        @Override // androidx.compose.ui.unit.Density
        /* renamed from: toSp-kPz2Gy4 */
        public long mo437toSpkPz2Gy4(float f) {
            return this.$$delegate_0.mo437toSpkPz2Gy4(f);
        }

        @Override // androidx.compose.ui.unit.Density
        /* renamed from: toSp-kPz2Gy4 */
        public long mo438toSpkPz2Gy4(int i) {
            return this.$$delegate_0.mo438toSpkPz2Gy4(i);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public PointerEventHandlerCoroutine(Continuation<? super R> continuation) {
            this.$$delegate_0 = SuspendingPointerInputModifierNodeImpl.this;
            this.completion = continuation;
        }

        @Override // androidx.compose.ui.input.pointer.AwaitPointerEventScope
        public PointerEvent getCurrentEvent() {
            return SuspendingPointerInputModifierNodeImpl.this.currentEvent;
        }

        @Override // androidx.compose.ui.input.pointer.AwaitPointerEventScope
        /* renamed from: getSize-YbymL2g */
        public long mo6570getSizeYbymL2g() {
            return SuspendingPointerInputModifierNodeImpl.this.boundsSize;
        }

        @Override // androidx.compose.ui.input.pointer.AwaitPointerEventScope
        public ViewConfiguration getViewConfiguration() {
            return SuspendingPointerInputModifierNodeImpl.this.getViewConfiguration();
        }

        @Override // androidx.compose.ui.input.pointer.AwaitPointerEventScope
        /* renamed from: getExtendedTouchPadding-NH-jbRc */
        public long mo6569getExtendedTouchPaddingNHjbRc() {
            return SuspendingPointerInputModifierNodeImpl.this.mo424getExtendedTouchPaddingNHjbRc();
        }

        public final void offerPointerEvent(PointerEvent pointerEvent, PointerEventPass pointerEventPass) {
            CancellableContinuation<? super PointerEvent> cancellableContinuation;
            if (pointerEventPass != this.awaitPass || (cancellableContinuation = this.pointerAwaiter) == null) {
                return;
            }
            this.pointerAwaiter = null;
            Result.Companion companion = Result.Companion;
            cancellableContinuation.resumeWith(Result.m9896constructorimpl(pointerEvent));
        }

        public final void cancel(Throwable th) {
            CancellableContinuation<? super PointerEvent> cancellableContinuation = this.pointerAwaiter;
            if (cancellableContinuation != null) {
                cancellableContinuation.cancel(th);
            }
            this.pointerAwaiter = null;
        }

        @Override // kotlin.coroutines.Continuation
        public CoroutineContext getContext() {
            return this.context;
        }

        @Override // kotlin.coroutines.Continuation
        public void resumeWith(Object obj) {
            Object obj2 = SuspendingPointerInputModifierNodeImpl.this.pointerHandlersLock;
            SuspendingPointerInputModifierNodeImpl suspendingPointerInputModifierNodeImpl = SuspendingPointerInputModifierNodeImpl.this;
            synchronized (obj2) {
                suspendingPointerInputModifierNodeImpl.pointerHandlers.remove(this);
                Unit unit = Unit.INSTANCE;
            }
            this.completion.resumeWith(obj);
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
        /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
        @Override // androidx.compose.ui.input.pointer.AwaitPointerEventScope
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public <T> Object withTimeoutOrNull(long j, Function2<? super AwaitPointerEventScope, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation) {
            SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeoutOrNull$1 suspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeoutOrNull$1;
            int i;
            try {
                if (continuation instanceof SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeoutOrNull$1) {
                    suspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeoutOrNull$1 = (SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeoutOrNull$1) continuation;
                    if ((suspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeoutOrNull$1.label & Integer.MIN_VALUE) != 0) {
                        suspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeoutOrNull$1.label -= Integer.MIN_VALUE;
                        Object obj = suspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeoutOrNull$1.result;
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        i = suspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeoutOrNull$1.label;
                        if (i == 0) {
                            if (i == 1) {
                                ResultKt.throwOnFailure(obj);
                                return obj;
                            }
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        suspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeoutOrNull$1.label = 1;
                        Object withTimeout = withTimeout(j, function2, suspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeoutOrNull$1);
                        return withTimeout == coroutine_suspended ? coroutine_suspended : withTimeout;
                    }
                }
                if (i == 0) {
                }
            } catch (PointerEventTimeoutCancellationException unused) {
                return null;
            }
            suspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeoutOrNull$1 = new SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeoutOrNull$1(this, continuation);
            Object obj2 = suspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeoutOrNull$1.result;
            Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            i = suspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeoutOrNull$1.label;
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x0039  */
        @Override // androidx.compose.ui.input.pointer.AwaitPointerEventScope
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public <T> Object withTimeout(long j, Function2<? super AwaitPointerEventScope, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation) {
            SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeout$1 suspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeout$1;
            int i;
            Job launch$default;
            Throwable th;
            Job job;
            CancellableContinuation<? super PointerEvent> cancellableContinuation;
            if (continuation instanceof SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeout$1) {
                suspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeout$1 = (SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeout$1) continuation;
                if ((suspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeout$1.label & Integer.MIN_VALUE) != 0) {
                    suspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeout$1.label -= Integer.MIN_VALUE;
                    Object obj = suspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeout$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = suspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeout$1.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        if (j <= 0 && (cancellableContinuation = this.pointerAwaiter) != null) {
                            Result.Companion companion = Result.Companion;
                            cancellableContinuation.resumeWith(Result.m9896constructorimpl(ResultKt.createFailure(new PointerEventTimeoutCancellationException(j))));
                        }
                        launch$default = BuildersKt__Builders_commonKt.launch$default(SuspendingPointerInputModifierNodeImpl.this.getCoroutineScope(), null, null, new SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeout$job$1(j, this, null), 3, null);
                        try {
                            suspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeout$1.L$0 = launch$default;
                            suspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeout$1.label = 1;
                            obj = function2.invoke(this, suspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeout$1);
                            if (obj == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            job = launch$default;
                        } catch (Throwable th2) {
                            th = th2;
                            job = launch$default;
                            job.cancel((CancellationException) CancelTimeoutCancellationException.INSTANCE);
                            throw th;
                        }
                    } else if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        job = (Job) suspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeout$1.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                        } catch (Throwable th3) {
                            th = th3;
                            job.cancel((CancellationException) CancelTimeoutCancellationException.INSTANCE);
                            throw th;
                        }
                    }
                    job.cancel((CancellationException) CancelTimeoutCancellationException.INSTANCE);
                    return obj;
                }
            }
            suspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeout$1 = new SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeout$1(this, continuation);
            Object obj2 = suspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeout$1.result;
            Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            i = suspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeout$1.label;
            if (i != 0) {
            }
            job.cancel((CancellationException) CancelTimeoutCancellationException.INSTANCE);
            return obj2;
        }

        @Override // androidx.compose.ui.input.pointer.AwaitPointerEventScope
        public Object awaitPointerEvent(PointerEventPass pointerEventPass, Continuation<? super PointerEvent> continuation) {
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
            cancellableContinuationImpl.initCancellability();
            this.awaitPass = pointerEventPass;
            this.pointerAwaiter = cancellableContinuationImpl;
            Object result = cancellableContinuationImpl.getResult();
            if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(continuation);
            }
            return result;
        }
    }

    private final void dispatchPointerEvent(PointerEvent pointerEvent, PointerEventPass pointerEventPass) {
        synchronized (this.pointerHandlersLock) {
            MutableVector<PointerEventHandlerCoroutine<?>> mutableVector = this.dispatchingPointerHandlers;
            mutableVector.addAll(mutableVector.getSize(), this.pointerHandlers);
        }
        try {
            int i = WhenMappings.$EnumSwitchMapping$0[pointerEventPass.ordinal()];
            if (i == 1 || i == 2) {
                MutableVector<PointerEventHandlerCoroutine<?>> mutableVector2 = this.dispatchingPointerHandlers;
                PointerEventHandlerCoroutine<?>[] pointerEventHandlerCoroutineArr = mutableVector2.content;
                int size = mutableVector2.getSize();
                for (int i2 = 0; i2 < size; i2++) {
                    pointerEventHandlerCoroutineArr[i2].offerPointerEvent(pointerEvent, pointerEventPass);
                }
            } else if (i != 3) {
                throw new NoWhenBranchMatchedException();
            } else {
                MutableVector<PointerEventHandlerCoroutine<?>> mutableVector3 = this.dispatchingPointerHandlers;
                int size2 = mutableVector3.getSize() - 1;
                PointerEventHandlerCoroutine<?>[] pointerEventHandlerCoroutineArr2 = mutableVector3.content;
                if (size2 < pointerEventHandlerCoroutineArr2.length) {
                    while (size2 >= 0) {
                        pointerEventHandlerCoroutineArr2[size2].offerPointerEvent(pointerEvent, pointerEventPass);
                        size2--;
                    }
                }
            }
        } finally {
            this.dispatchingPointerHandlers.clear();
        }
    }

    @Override // androidx.compose.ui.input.pointer.PointerInputScope
    public <R> Object awaitPointerEventScope(Function2<? super AwaitPointerEventScope, ? super Continuation<? super R>, ? extends Object> function2, Continuation<? super R> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        final PointerEventHandlerCoroutine pointerEventHandlerCoroutine = new PointerEventHandlerCoroutine(cancellableContinuationImpl2);
        synchronized (this.pointerHandlersLock) {
            this.pointerHandlers.add(pointerEventHandlerCoroutine);
            Continuation<Unit> createCoroutine = ContinuationKt.createCoroutine(function2, pointerEventHandlerCoroutine, pointerEventHandlerCoroutine);
            Result.Companion companion = Result.Companion;
            createCoroutine.resumeWith(Result.m9896constructorimpl(Unit.INSTANCE));
            Unit unit = Unit.INSTANCE;
        }
        cancellableContinuationImpl2.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl$awaitPointerEventScope$2$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                pointerEventHandlerCoroutine.cancel(th);
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }
}
