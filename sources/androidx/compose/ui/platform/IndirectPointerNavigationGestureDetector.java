package androidx.compose.ui.platform;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import androidx.compose.ui.focus.FocusDirection;
import androidx.compose.ui.input.indirect.AndroidIndirectPointerEvent_androidKt;
import androidx.compose.ui.input.indirect.IndirectPointerEvent;
import androidx.compose.ui.input.indirect.IndirectPointerEventPrimaryDirectionalMotionAxis;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
/* compiled from: AndroidComposeView.android.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0012J\u0006\u0010\u0019\u001a\u00020\u0007R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Landroidx/compose/ui/platform/IndirectPointerNavigationGestureDetector;", "", "context", "Landroid/content/Context;", "onMoveFocus", "Lkotlin/Function1;", "Landroidx/compose/ui/focus/FocusDirection;", "", "<init>", "(Landroid/content/Context;Lkotlin/jvm/functions/Function1;)V", "primaryDirectionalMotionAxis", "Landroidx/compose/ui/input/indirect/IndirectPointerEventPrimaryDirectionalMotionAxis;", "getPrimaryDirectionalMotionAxis-nZO2Niw", "()I", "setPrimaryDirectionalMotionAxis-WQKaTuc", "(I)V", "I", "ignoreCurrentGestureStream", "", "gestureDetector", "Landroid/view/GestureDetector;", "onIndirectPointerEvent", "indirectPointerEvent", "Landroidx/compose/ui/input/indirect/IndirectPointerEvent;", "isConsumed", "cancelCurrentEventStream", "ui"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class IndirectPointerNavigationGestureDetector {
    public static final int $stable = 8;
    private final GestureDetector gestureDetector;
    private boolean ignoreCurrentGestureStream;
    private final Function1<FocusDirection, Unit> onMoveFocus;
    private int primaryDirectionalMotionAxis = IndirectPointerEventPrimaryDirectionalMotionAxis.Companion.m6257getNonenZO2Niw();

    /* JADX WARN: Multi-variable type inference failed */
    public IndirectPointerNavigationGestureDetector(Context context, Function1<? super FocusDirection, Unit> function1) {
        this.onMoveFocus = function1;
        this.gestureDetector = new GestureDetector(context, new GestureDetector.OnGestureListener() { // from class: androidx.compose.ui.platform.IndirectPointerNavigationGestureDetector$gestureDetector$1
            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                return true;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                return true;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onShowPress(MotionEvent motionEvent) {
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                return true;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                boolean z;
                Function1 function12;
                Function1 function13;
                z = IndirectPointerNavigationGestureDetector.this.ignoreCurrentGestureStream;
                if (z) {
                    return true;
                }
                if (IndirectPointerEventPrimaryDirectionalMotionAxis.m6253equalsimpl0(IndirectPointerNavigationGestureDetector.this.m7378getPrimaryDirectionalMotionAxisnZO2Niw(), IndirectPointerEventPrimaryDirectionalMotionAxis.Companion.m6258getXnZO2Niw())) {
                    if (Math.abs(f) > Math.abs(f2)) {
                        int m5062getNextdhqQ8s = f > 0.0f ? FocusDirection.Companion.m5062getNextdhqQ8s() : FocusDirection.Companion.m5063getPreviousdhqQ8s();
                        function13 = IndirectPointerNavigationGestureDetector.this.onMoveFocus;
                        function13.invoke(FocusDirection.m5051boximpl(m5062getNextdhqQ8s));
                    }
                } else if (IndirectPointerEventPrimaryDirectionalMotionAxis.m6253equalsimpl0(IndirectPointerNavigationGestureDetector.this.m7378getPrimaryDirectionalMotionAxisnZO2Niw(), IndirectPointerEventPrimaryDirectionalMotionAxis.Companion.m6259getYnZO2Niw()) && Math.abs(f2) > Math.abs(f)) {
                    int m5062getNextdhqQ8s2 = f2 > 0.0f ? FocusDirection.Companion.m5062getNextdhqQ8s() : FocusDirection.Companion.m5063getPreviousdhqQ8s();
                    function12 = IndirectPointerNavigationGestureDetector.this.onMoveFocus;
                    function12.invoke(FocusDirection.m5051boximpl(m5062getNextdhqQ8s2));
                }
                return true;
            }
        });
    }

    /* renamed from: getPrimaryDirectionalMotionAxis-nZO2Niw  reason: not valid java name */
    public final int m7378getPrimaryDirectionalMotionAxisnZO2Niw() {
        return this.primaryDirectionalMotionAxis;
    }

    /* renamed from: setPrimaryDirectionalMotionAxis-WQKaTuc  reason: not valid java name */
    public final void m7379setPrimaryDirectionalMotionAxisWQKaTuc(int i) {
        this.primaryDirectionalMotionAxis = i;
    }

    public final boolean onIndirectPointerEvent(IndirectPointerEvent indirectPointerEvent, boolean z) {
        MotionEvent nativeEvent = AndroidIndirectPointerEvent_androidKt.getNativeEvent(indirectPointerEvent);
        int action = nativeEvent.getAction();
        if (action == 0) {
            this.primaryDirectionalMotionAxis = indirectPointerEvent.mo6246getPrimaryDirectionalMotionAxisnZO2Niw();
            this.ignoreCurrentGestureStream = false;
        } else if ((action == 1 || action == 2) && z) {
            cancelCurrentEventStream();
        }
        return this.gestureDetector.onTouchEvent(nativeEvent);
    }

    public final void cancelCurrentEventStream() {
        this.primaryDirectionalMotionAxis = IndirectPointerEventPrimaryDirectionalMotionAxis.Companion.m6257getNonenZO2Niw();
        this.ignoreCurrentGestureStream = true;
    }
}
