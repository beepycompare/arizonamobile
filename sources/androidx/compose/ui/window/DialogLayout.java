package androidx.compose.ui.window;

import android.content.Context;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.platform.AbstractComposeView;
import androidx.core.app.NotificationCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsAnimationCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.math.MathKt;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AndroidDialog.android.kt */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018J\u001d\u0010 \u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"H\u0010¢\u0006\u0002\b$J\u0018\u0010%\u001a\u00020\"2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\"H\u0002J5\u0010'\u001a\u00020\u000e2\u0006\u0010(\u001a\u00020\u00182\u0006\u0010)\u001a\u00020\"2\u0006\u0010*\u001a\u00020\"2\u0006\u0010+\u001a\u00020\"2\u0006\u0010,\u001a\u00020\"H\u0010¢\u0006\u0002\b-J&\u0010\u0013\u001a\u00020\u000e2\u0006\u0010.\u001a\u00020/2\u0011\u0010\u0010\u001a\r\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0002\b\u000f¢\u0006\u0002\u00100J\u0018\u00101\u001a\u0002022\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u000202H\u0016J~\u00106\u001a\u0002H7\"\u0004\b\u0000\u001072\u0006\u00108\u001a\u0002H72`\u00109\u001a\\\u0012\u0013\u0012\u00110\"¢\u0006\f\b;\u0012\b\b<\u0012\u0004\b\b()\u0012\u0013\u0012\u00110\"¢\u0006\f\b;\u0012\b\b<\u0012\u0004\b\b(*\u0012\u0013\u0012\u00110\"¢\u0006\f\b;\u0012\b\b<\u0012\u0004\b\b(+\u0012\u0013\u0012\u00110\"¢\u0006\f\b;\u0012\b\b<\u0012\u0004\b\b(,\u0012\u0004\u0012\u0002H70:H\u0082\b¢\u0006\u0002\u0010=J\u000e\u0010>\u001a\u00020\u00182\u0006\u0010?\u001a\u00020@J\r\u0010A\u001a\u00020\u000eH\u0017¢\u0006\u0002\u0010BR\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bRA\u0010\u0010\u001a\r\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0002\b\u000f2\u0011\u0010\f\u001a\r\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0002\b\u000f8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u0018@RX\u0094\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e¨\u0006C"}, d2 = {"Landroidx/compose/ui/window/DialogLayout;", "Landroidx/compose/ui/platform/AbstractComposeView;", "Landroidx/compose/ui/window/DialogWindowProvider;", "Landroidx/core/view/OnApplyWindowInsetsListener;", "context", "Landroid/content/Context;", "window", "Landroid/view/Window;", "<init>", "(Landroid/content/Context;Landroid/view/Window;)V", "getWindow", "()Landroid/view/Window;", "<set-?>", "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", FirebaseAnalytics.Param.CONTENT, "getContent", "()Lkotlin/jvm/functions/Function2;", "setContent", "(Lkotlin/jvm/functions/Function2;)V", "content$delegate", "Landroidx/compose/runtime/MutableState;", "usePlatformDefaultWidth", "", "decorFitsSystemWindows", "hasCalledSetLayout", "value", "shouldCreateCompositionOnAttachedToWindow", "getShouldCreateCompositionOnAttachedToWindow", "()Z", "updateProperties", "internalOnMeasure", "widthMeasureSpec", "", "heightMeasureSpec", "internalOnMeasure$ui", "getMaxDialogHeightExcludingInsets", "height", "internalOnLayout", "changed", TtmlNode.LEFT, "top", TtmlNode.RIGHT, "bottom", "internalOnLayout$ui", "parent", "Landroidx/compose/runtime/CompositionContext;", "(Landroidx/compose/runtime/CompositionContext;Lkotlin/jvm/functions/Function2;)V", "onApplyWindowInsets", "Landroidx/core/view/WindowInsetsCompat;", "v", "Landroid/view/View;", "insets", "insetValue", ExifInterface.GPS_DIRECTION_TRUE, "unchangedValue", "block", "Lkotlin/Function4;", "Lkotlin/ParameterName;", "name", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function4;)Ljava/lang/Object;", "isInsideContent", NotificationCompat.CATEGORY_EVENT, "Landroid/view/MotionEvent;", "Content", "(Landroidx/compose/runtime/Composer;I)V", "ui"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DialogLayout extends AbstractComposeView implements DialogWindowProvider, OnApplyWindowInsetsListener {
    private final MutableState content$delegate;
    private boolean decorFitsSystemWindows;
    private boolean hasCalledSetLayout;
    private boolean shouldCreateCompositionOnAttachedToWindow;
    private boolean usePlatformDefaultWidth;
    private final Window window;

    public DialogLayout(Context context, Window window) {
        super(context, null, 0, 6, null);
        MutableState mutableStateOf$default;
        this.window = window;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(ComposableSingletons$AndroidDialog_androidKt.INSTANCE.getLambda$210148896$ui(), null, 2, null);
        this.content$delegate = mutableStateOf$default;
        DialogLayout dialogLayout = this;
        ViewCompat.setOnApplyWindowInsetsListener(dialogLayout, this);
        ViewCompat.setWindowInsetsAnimationCallback(dialogLayout, new WindowInsetsAnimationCompat.Callback() { // from class: androidx.compose.ui.window.DialogLayout.1
            {
                super(1);
            }

            @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
            public WindowInsetsAnimationCompat.BoundsCompat onStart(WindowInsetsAnimationCompat windowInsetsAnimationCompat, WindowInsetsAnimationCompat.BoundsCompat boundsCompat) {
                DialogLayout dialogLayout2 = DialogLayout.this;
                if (!dialogLayout2.decorFitsSystemWindows) {
                    View childAt = dialogLayout2.getChildAt(0);
                    int max = Math.max(0, childAt.getLeft());
                    int max2 = Math.max(0, childAt.getTop());
                    int max3 = Math.max(0, dialogLayout2.getWidth() - childAt.getRight());
                    int max4 = Math.max(0, dialogLayout2.getHeight() - childAt.getBottom());
                    if (max != 0 || max2 != 0 || max3 != 0 || max4 != 0) {
                        return boundsCompat.inset(Insets.of(max, max2, max3, max4));
                    }
                }
                return boundsCompat;
            }

            @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
            public WindowInsetsCompat onProgress(WindowInsetsCompat windowInsetsCompat, List<WindowInsetsAnimationCompat> list) {
                DialogLayout dialogLayout2 = DialogLayout.this;
                if (!dialogLayout2.decorFitsSystemWindows) {
                    View childAt = dialogLayout2.getChildAt(0);
                    int max = Math.max(0, childAt.getLeft());
                    int max2 = Math.max(0, childAt.getTop());
                    int max3 = Math.max(0, dialogLayout2.getWidth() - childAt.getRight());
                    int max4 = Math.max(0, dialogLayout2.getHeight() - childAt.getBottom());
                    if (max != 0 || max2 != 0 || max3 != 0 || max4 != 0) {
                        return windowInsetsCompat.inset(max, max2, max3, max4);
                    }
                }
                return windowInsetsCompat;
            }
        });
    }

    @Override // androidx.compose.ui.window.DialogWindowProvider
    public Window getWindow() {
        return this.window;
    }

    private final Function2<Composer, Integer, Unit> getContent() {
        return (Function2) this.content$delegate.getValue();
    }

    private final void setContent(Function2<? super Composer, ? super Integer, Unit> function2) {
        this.content$delegate.setValue(function2);
    }

    @Override // androidx.compose.ui.platform.AbstractComposeView
    protected boolean getShouldCreateCompositionOnAttachedToWindow() {
        return this.shouldCreateCompositionOnAttachedToWindow;
    }

    public final void updateProperties(boolean z, boolean z2) {
        boolean z3 = (this.hasCalledSetLayout && z == this.usePlatformDefaultWidth && z2 == this.decorFitsSystemWindows) ? false : true;
        this.usePlatformDefaultWidth = z;
        this.decorFitsSystemWindows = z2;
        if (z3) {
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            int i = z ? -2 : -1;
            if (i == attributes.width && this.hasCalledSetLayout) {
                return;
            }
            getWindow().setLayout(i, -2);
            this.hasCalledSetLayout = true;
        }
    }

    @Override // androidx.compose.ui.platform.AbstractComposeView
    public void internalOnMeasure$ui(int i, int i2) {
        int i3;
        int min;
        View childAt = getChildAt(0);
        if (childAt == null) {
            super.internalOnMeasure$ui(i, i2);
            return;
        }
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int mode = View.MeasureSpec.getMode(i2);
        if (mode == Integer.MIN_VALUE && !this.usePlatformDefaultWidth && getWindow().getAttributes().height == -2) {
            i3 = this.decorFitsSystemWindows ? getMaxDialogHeightExcludingInsets(getWindow(), size2) : size2 + 1;
        } else {
            i3 = size2;
        }
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int i4 = size - paddingLeft;
        if (i4 < 0) {
            i4 = 0;
        }
        int i5 = i3 - paddingTop;
        int i6 = i5 >= 0 ? i5 : 0;
        int mode2 = View.MeasureSpec.getMode(i);
        if (mode2 != 0) {
            i = View.MeasureSpec.makeMeasureSpec(i4, Integer.MIN_VALUE);
        }
        if (mode != 0) {
            i2 = View.MeasureSpec.makeMeasureSpec(i6, Integer.MIN_VALUE);
        }
        childAt.measure(i, i2);
        if (mode2 == Integer.MIN_VALUE) {
            size = Math.min(size, childAt.getMeasuredWidth() + paddingLeft);
        } else if (mode2 != 1073741824) {
            size = childAt.getMeasuredWidth() + paddingLeft;
        }
        if (mode == Integer.MIN_VALUE) {
            min = Math.min(size2, childAt.getMeasuredHeight() + paddingTop);
        } else {
            min = mode != 1073741824 ? childAt.getMeasuredHeight() + paddingTop : size2;
        }
        setMeasuredDimension(size, min);
        if (this.decorFitsSystemWindows || childAt.getMeasuredHeight() + paddingTop <= size2 || getWindow().getAttributes().height != -2) {
            return;
        }
        getWindow().addFlags(Integer.MIN_VALUE);
        if (this.usePlatformDefaultWidth) {
            return;
        }
        getWindow().setLayout(-1, -1);
    }

    private final int getMaxDialogHeightExcludingInsets(Window window, int i) {
        if (Build.VERSION.SDK_INT < 30) {
            return Api21Impl.INSTANCE.getMaxDialogHeightExcludingSystemBarInsets(window);
        }
        return Build.VERSION.SDK_INT < 32 ? Api30Impl.INSTANCE.getMaxDialogHeightExcludingSystemBarInsets(window) : i;
    }

    @Override // androidx.compose.ui.platform.AbstractComposeView
    public void internalOnLayout$ui(boolean z, int i, int i2, int i3, int i4) {
        View childAt = getChildAt(0);
        if (childAt == null) {
            return;
        }
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int i5 = i3 - i;
        int i6 = i4 - i2;
        int measuredWidth = childAt.getMeasuredWidth();
        int measuredHeight = childAt.getMeasuredHeight();
        int paddingLeft2 = getPaddingLeft() + (((i5 - measuredWidth) - paddingLeft) / 2);
        int paddingTop = getPaddingTop() + (((i6 - measuredHeight) - (getPaddingTop() + getPaddingBottom())) / 2);
        childAt.layout(paddingLeft2, paddingTop, measuredWidth + paddingLeft2, measuredHeight + paddingTop);
    }

    public final void setContent(CompositionContext compositionContext, Function2<? super Composer, ? super Integer, Unit> function2) {
        setParentCompositionContext(compositionContext);
        setContent(function2);
        this.shouldCreateCompositionOnAttachedToWindow = true;
        createComposition();
    }

    private final <T> T insetValue(T t, Function4<? super Integer, ? super Integer, ? super Integer, ? super Integer, ? extends T> function4) {
        if (!this.decorFitsSystemWindows) {
            View childAt = getChildAt(0);
            int max = Math.max(0, childAt.getLeft());
            int max2 = Math.max(0, childAt.getTop());
            int max3 = Math.max(0, getWidth() - childAt.getRight());
            int max4 = Math.max(0, getHeight() - childAt.getBottom());
            if (max != 0 || max2 != 0 || max3 != 0 || max4 != 0) {
                return function4.invoke(Integer.valueOf(max), Integer.valueOf(max2), Integer.valueOf(max3), Integer.valueOf(max4));
            }
        }
        return t;
    }

    public final boolean isInsideContent(MotionEvent motionEvent) {
        View childAt;
        int roundToInt;
        if (Math.abs(motionEvent.getX()) > Float.MAX_VALUE || Math.abs(motionEvent.getY()) > Float.MAX_VALUE || (childAt = getChildAt(0)) == null) {
            return false;
        }
        int left = getLeft() + childAt.getLeft();
        int width = childAt.getWidth() + left;
        int top = getTop() + childAt.getTop();
        int height = childAt.getHeight() + top;
        int roundToInt2 = MathKt.roundToInt(motionEvent.getX());
        return left <= roundToInt2 && roundToInt2 <= width && top <= (roundToInt = MathKt.roundToInt(motionEvent.getY())) && roundToInt <= height;
    }

    @Override // androidx.compose.ui.platform.AbstractComposeView
    public void Content(Composer composer, final int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(1735448596);
        ComposerKt.sourceInformation(startRestartGroup, "C(Content)507@22337L9:AndroidDialog.android.kt#2oxthz");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changedInstance(this) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (!startRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1735448596, i2, -1, "androidx.compose.ui.window.DialogLayout.Content (AndroidDialog.android.kt:506)");
            }
            getContent().invoke(startRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.window.DialogLayout$Content$4
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i3) {
                    DialogLayout.this.Content(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    @Override // androidx.core.view.OnApplyWindowInsetsListener
    public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        if (!this.decorFitsSystemWindows) {
            View childAt = getChildAt(0);
            int max = Math.max(0, childAt.getLeft());
            int max2 = Math.max(0, childAt.getTop());
            int max3 = Math.max(0, getWidth() - childAt.getRight());
            int max4 = Math.max(0, getHeight() - childAt.getBottom());
            if (max != 0 || max2 != 0 || max3 != 0 || max4 != 0) {
                return windowInsetsCompat.inset(max, max2, max3, max4);
            }
        }
        return windowInsetsCompat;
    }
}
