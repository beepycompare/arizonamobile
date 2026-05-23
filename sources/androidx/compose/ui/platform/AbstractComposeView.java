package androidx.compose.ui.platform;

import android.content.Context;
import android.os.IBinder;
import android.os.Trace;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.Composition;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.Recomposer;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.R;
import androidx.compose.ui.node.Owner;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.lifecycle.ViewTreeViewModelStoreOwner;
import androidx.media3.extractor.text.ttml.TtmlNode;
import androidx.savedstate.SavedStateRegistryOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: ComposeView.android.kt */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\u0004\b'\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\fJ\u000e\u0010%\u001a\u00020 2\u0006\u0010&\u001a\u00020'J\r\u00107\u001a\u00020 H'¢\u0006\u0002\u00108J\u0006\u00109\u001a\u00020 J\u0010\u00109\u001a\u00020 2\u0006\u0010\u0018\u001a\u00020\u0017H\u0007J\b\u0010;\u001a\u00020 H\u0002J\f\u0010>\u001a\u00020\f*\u00020\fH\u0002J\b\u0010?\u001a\u00020\fH\u0002J\b\u0010@\u001a\u00020 H\u0002J\b\u0010A\u001a\u00020\u0017H\u0002J\u0018\u0010B\u001a\u00020\u00172\u0006\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020\u0017H\u0002J\u0006\u0010F\u001a\u00020 J\b\u0010I\u001a\u00020 H\u0014J\b\u0010J\u001a\u00020 H\u0002J\u0018\u0010K\u001a\u00020 2\u0006\u0010L\u001a\u00020\u00072\u0006\u0010M\u001a\u00020\u0007H\u0004J\u001d\u0010N\u001a\u00020 2\u0006\u0010L\u001a\u00020\u00072\u0006\u0010M\u001a\u00020\u0007H\u0010¢\u0006\u0002\bOJ0\u0010P\u001a\u00020 2\u0006\u0010Q\u001a\u00020)2\u0006\u0010R\u001a\u00020\u00072\u0006\u0010S\u001a\u00020\u00072\u0006\u0010T\u001a\u00020\u00072\u0006\u0010U\u001a\u00020\u0007H\u0004J5\u0010V\u001a\u00020 2\u0006\u0010Q\u001a\u00020)2\u0006\u0010R\u001a\u00020\u00072\u0006\u0010S\u001a\u00020\u00072\u0006\u0010T\u001a\u00020\u00072\u0006\u0010U\u001a\u00020\u0007H\u0010¢\u0006\u0002\bWJ\u0010\u0010X\u001a\u00020 2\u0006\u0010Y\u001a\u00020\u0007H\u0016J\b\u0010[\u001a\u00020)H\u0016J\u0010\u0010\\\u001a\u00020 2\u0006\u0010[\u001a\u00020)H\u0016J\u0012\u0010]\u001a\u00020 2\b\u0010^\u001a\u0004\u0018\u00010DH\u0016J\u001a\u0010]\u001a\u00020 2\b\u0010^\u001a\u0004\u0018\u00010D2\u0006\u0010_\u001a\u00020\u0007H\u0016J\"\u0010]\u001a\u00020 2\b\u0010^\u001a\u0004\u0018\u00010D2\u0006\u0010`\u001a\u00020\u00072\u0006\u0010a\u001a\u00020\u0007H\u0016J\u001c\u0010]\u001a\u00020 2\b\u0010^\u001a\u0004\u0018\u00010D2\b\u0010b\u001a\u0004\u0018\u00010cH\u0016J$\u0010]\u001a\u00020 2\b\u0010^\u001a\u0004\u0018\u00010D2\u0006\u0010_\u001a\u00020\u00072\b\u0010b\u001a\u0004\u0018\u00010cH\u0016J$\u0010d\u001a\u00020)2\b\u0010^\u001a\u0004\u0018\u00010D2\u0006\u0010_\u001a\u00020\u00072\b\u0010b\u001a\u0004\u0018\u00010cH\u0014J,\u0010d\u001a\u00020)2\b\u0010^\u001a\u0004\u0018\u00010D2\u0006\u0010_\u001a\u00020\u00072\b\u0010b\u001a\u0004\u0018\u00010c2\u0006\u0010e\u001a\u00020)H\u0014J\b\u0010f\u001a\u00020)H\u0016R\u0016\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u000e@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0014\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\f@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b\u0015\u0010\u0016R0\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010\r\u001a\u0004\u0018\u00010\u00178\u0000@@X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\"\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010#X\u0082\u000e¢\u0006\b\n\u0000\u0012\u0004\b$\u0010\u001aR\u0014\u0010(\u001a\u00020)8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b*\u0010+R,\u0010,\u001a\u00020)2\u0006\u0010\r\u001a\u00020)8\u0006@FX\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b-\u0010\u001a\u001a\u0004\b.\u0010+\"\u0004\b/\u00100R$\u00102\u001a\u0002012\u0006\u0010\r\u001a\u0002018F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u000e\u0010:\u001a\u00020)X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010<\u001a\u00020)*\u00020\f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b<\u0010=R\u0011\u0010G\u001a\u00020)8F¢\u0006\u0006\u001a\u0004\bH\u0010+R\u000e\u0010Z\u001a\u00020)X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006g"}, d2 = {"Landroidx/compose/ui/platform/AbstractComposeView;", "Landroid/view/ViewGroup;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "cachedViewTreeCompositionContext", "Ljava/lang/ref/WeakReference;", "Landroidx/compose/runtime/CompositionContext;", "value", "Landroid/os/IBinder;", "previousAttachedWindowToken", "setPreviousAttachedWindowToken", "(Landroid/os/IBinder;)V", "composition", "Landroidx/compose/runtime/Composition;", "parentContext", "setParentContext", "(Landroidx/compose/runtime/CompositionContext;)V", "Landroidx/compose/ui/platform/ComposeViewContext;", "composeViewContext", "getComposeViewContext$ui$annotations", "()V", "getComposeViewContext$ui", "()Landroidx/compose/ui/platform/ComposeViewContext;", "setComposeViewContext$ui", "(Landroidx/compose/ui/platform/ComposeViewContext;)V", "setParentCompositionContext", "", "parent", "disposeViewCompositionStrategy", "Lkotlin/Function0;", "getDisposeViewCompositionStrategy$annotations", "setViewCompositionStrategy", "strategy", "Landroidx/compose/ui/platform/ViewCompositionStrategy;", "shouldCreateCompositionOnAttachedToWindow", "", "getShouldCreateCompositionOnAttachedToWindow", "()Z", "showLayoutBounds", "getShowLayoutBounds$annotations", "getShowLayoutBounds", "setShowLayoutBounds", "(Z)V", "Landroidx/compose/ui/platform/AutoClearFocusBehavior;", "autoClearFocusBehavior", "getAutoClearFocusBehavior-4UtRPd4", "()I", "setAutoClearFocusBehavior-17tfJxM", "(I)V", "Content", "(Landroidx/compose/runtime/Composer;I)V", "createComposition", "creatingComposition", "checkAddView", "isAlive", "(Landroidx/compose/runtime/CompositionContext;)Z", "cacheIfAlive", "resolveParentCompositionContext", "ensureCompositionCreated", "resolveComposeViewContext", "updateAutoCreatedComposeViewContext", "contextView", "Landroid/view/View;", "existingContext", "disposeComposition", "hasComposition", "getHasComposition", "onAttachedToWindow", "attachedToWindow", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "internalOnMeasure", "internalOnMeasure$ui", "onLayout", "changed", TtmlNode.LEFT, "top", TtmlNode.RIGHT, "bottom", "internalOnLayout", "internalOnLayout$ui", "onRtlPropertiesChanged", "layoutDirection", "isTransitionGroupSet", "isTransitionGroup", "setTransitionGroup", "addView", "child", FirebaseAnalytics.Param.INDEX, "width", "height", "params", "Landroid/view/ViewGroup$LayoutParams;", "addViewInLayout", "preventRequestLayout", "shouldDelayChildPressedState", "ui"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class AbstractComposeView extends ViewGroup {
    public static final int $stable = 8;
    private WeakReference<CompositionContext> cachedViewTreeCompositionContext;
    private ComposeViewContext composeViewContext;
    private Composition composition;
    private boolean creatingComposition;
    private Function0<Unit> disposeViewCompositionStrategy;
    private boolean isTransitionGroupSet;
    private CompositionContext parentContext;
    private IBinder previousAttachedWindowToken;
    private boolean showLayoutBounds;

    public AbstractComposeView(Context context) {
        this(context, null, 0, 6, null);
    }

    public AbstractComposeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public static /* synthetic */ void getComposeViewContext$ui$annotations() {
    }

    private static /* synthetic */ void getDisposeViewCompositionStrategy$annotations() {
    }

    public static /* synthetic */ void getShowLayoutBounds$annotations() {
    }

    public abstract void Content(Composer composer, int i);

    protected boolean getShouldCreateCompositionOnAttachedToWindow() {
        return true;
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public AbstractComposeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setClipChildren(false);
        setClipToPadding(false);
        setImportantForAccessibility(1);
        this.disposeViewCompositionStrategy = ViewCompositionStrategy.Companion.getDefault().installFor(this);
    }

    public /* synthetic */ AbstractComposeView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    private final void setPreviousAttachedWindowToken(IBinder iBinder) {
        if (this.previousAttachedWindowToken != iBinder) {
            this.previousAttachedWindowToken = iBinder;
            this.cachedViewTreeCompositionContext = null;
        }
    }

    private final void setParentContext(CompositionContext compositionContext) {
        if (this.parentContext != compositionContext) {
            this.parentContext = compositionContext;
            if (compositionContext != null) {
                this.cachedViewTreeCompositionContext = null;
            }
            Composition composition = this.composition;
            if (composition != null) {
                composition.dispose();
                this.composition = null;
                if (isAttachedToWindow()) {
                    ensureCompositionCreated();
                }
            }
        }
    }

    public final ComposeViewContext getComposeViewContext$ui() {
        return this.composeViewContext;
    }

    public final void setComposeViewContext$ui(ComposeViewContext composeViewContext) {
        if (this.composeViewContext != composeViewContext) {
            if (composeViewContext == null) {
                disposeComposition();
            } else if (getChildCount() != 0) {
                View childAt = getChildAt(0);
                AndroidComposeView androidComposeView = childAt instanceof AndroidComposeView ? (AndroidComposeView) childAt : null;
                if (androidComposeView != null) {
                    if (androidComposeView.getCoroutineContext() != composeViewContext.getCompositionContext$ui().getEffectCoroutineContext()) {
                        disposeComposition();
                    }
                    androidComposeView.setComposeViewContext(composeViewContext);
                }
            }
            this.composeViewContext = composeViewContext;
        }
    }

    public final void setParentCompositionContext(CompositionContext compositionContext) {
        setParentContext(compositionContext);
    }

    public final void setViewCompositionStrategy(ViewCompositionStrategy viewCompositionStrategy) {
        Function0<Unit> function0 = this.disposeViewCompositionStrategy;
        if (function0 != null) {
            function0.invoke();
        }
        this.disposeViewCompositionStrategy = viewCompositionStrategy.installFor(this);
    }

    public final boolean getShowLayoutBounds() {
        return this.showLayoutBounds;
    }

    public final void setShowLayoutBounds(boolean z) {
        this.showLayoutBounds = z;
        View childAt = getChildAt(0);
        if (childAt != null) {
            ((Owner) childAt).setShowLayoutBounds(z);
        }
    }

    /* renamed from: getAutoClearFocusBehavior-4UtRPd4  reason: not valid java name */
    public final int m7239getAutoClearFocusBehavior4UtRPd4() {
        Object tag = getTag(R.id.auto_clear_focus_behavior_tag);
        AutoClearFocusBehavior autoClearFocusBehavior = tag instanceof AutoClearFocusBehavior ? (AutoClearFocusBehavior) tag : null;
        return autoClearFocusBehavior != null ? autoClearFocusBehavior.m7275unboximpl() : AutoClearFocusBehavior.Companion.m7277getDefault4UtRPd4();
    }

    /* renamed from: setAutoClearFocusBehavior-17tfJxM  reason: not valid java name */
    public final void m7240setAutoClearFocusBehavior17tfJxM(int i) {
        setTag(R.id.auto_clear_focus_behavior_tag, AutoClearFocusBehavior.m7269boximpl(i));
    }

    public final void createComposition() {
        ComposeViewContext composeViewContext;
        View view$ui;
        if (this.parentContext == null && !isAttachedToWindow() && ((composeViewContext = this.composeViewContext) == null || composeViewContext == null || (view$ui = composeViewContext.getView$ui()) == null || !view$ui.isAttachedToWindow())) {
            throw new IllegalStateException("createComposition requires a previous call to createComposition(ComposeViewContext), a parent reference, or the View to be attached to a window. Attach the View or call setParentCompositionReference.".toString());
        }
        ensureCompositionCreated();
    }

    public final void createComposition(ComposeViewContext composeViewContext) {
        if (!composeViewContext.getView$ui().isAttachedToWindow()) {
            throw new IllegalStateException("createComposition requires the ComposeViewContext's view to be attached to a window.".toString());
        }
        setComposeViewContext$ui(composeViewContext);
        ensureCompositionCreated();
    }

    private final void checkAddView() {
        if (!this.creatingComposition) {
            throw new UnsupportedOperationException("Cannot add views to " + getClass().getSimpleName() + "; only Compose content is supported");
        }
    }

    private final boolean isAlive(CompositionContext compositionContext) {
        return !(compositionContext instanceof Recomposer) || ((Recomposer) compositionContext).getCurrentState().getValue().compareTo(Recomposer.State.ShuttingDown) > 0;
    }

    private final CompositionContext cacheIfAlive(CompositionContext compositionContext) {
        CompositionContext compositionContext2 = isAlive(compositionContext) ? compositionContext : null;
        if (compositionContext2 != null) {
            this.cachedViewTreeCompositionContext = new WeakReference<>(compositionContext2);
        }
        return compositionContext;
    }

    private final CompositionContext resolveParentCompositionContext() {
        CompositionContext compositionContext;
        CompositionContext compositionContext2 = this.parentContext;
        if (compositionContext2 == null) {
            AbstractComposeView abstractComposeView = this;
            CompositionContext findViewTreeCompositionContext = WindowRecomposer_androidKt.findViewTreeCompositionContext(abstractComposeView);
            CompositionContext compositionContext3 = null;
            CompositionContext cacheIfAlive = findViewTreeCompositionContext != null ? cacheIfAlive(findViewTreeCompositionContext) : null;
            if (cacheIfAlive == null) {
                WeakReference<CompositionContext> weakReference = this.cachedViewTreeCompositionContext;
                if (weakReference != null && (compositionContext = weakReference.get()) != null && isAlive(compositionContext)) {
                    compositionContext3 = compositionContext;
                }
                return compositionContext3 == null ? cacheIfAlive(WindowRecomposer_androidKt.getWindowRecomposer(abstractComposeView)) : compositionContext3;
            }
            return cacheIfAlive;
        }
        return compositionContext2;
    }

    private final void ensureCompositionCreated() {
        if (this.composition == null) {
            try {
                this.creatingComposition = true;
                Trace.beginSection("Compose:initializeView");
                ComposeViewContext composeViewContext = this.composeViewContext;
                if (composeViewContext == null) {
                    composeViewContext = resolveComposeViewContext();
                }
                this.composition = Wrapper_androidKt.setContent(this, composeViewContext, ComposableLambdaKt.composableLambdaInstance(1003123809, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.platform.AbstractComposeView$ensureCompositionCreated$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                        invoke(composer, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer, int i) {
                        ComposerKt.sourceInformation(composer, "C340@15415L9:ComposeView.android.kt#itgzvw");
                        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
                            composer.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1003123809, i, -1, "androidx.compose.ui.platform.AbstractComposeView.ensureCompositionCreated.<anonymous>.<anonymous> (ComposeView.android.kt:340)");
                        }
                        AbstractComposeView.this.Content(composer, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }));
                Unit unit = Unit.INSTANCE;
                Trace.endSection();
            } finally {
                this.creatingComposition = false;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x007c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final ComposeViewContext resolveComposeViewContext() {
        ComposeViewContext composeViewContext;
        View findViewTreeComposeViewRoot;
        ComposeViewContext composeViewContext2;
        ViewModelStoreOwner viewModelStoreOwner;
        if (getChildCount() != 0) {
            View childAt = getChildAt(0);
            AndroidComposeView androidComposeView = childAt instanceof AndroidComposeView ? (AndroidComposeView) childAt : null;
            if (androidComposeView != null) {
                composeViewContext = androidComposeView.getComposeViewContext();
                findViewTreeComposeViewRoot = ComposeView_androidKt.findViewTreeComposeViewRoot(this);
                composeViewContext2 = ComposeView_androidKt.getComposeViewContext(findViewTreeComposeViewRoot);
                if (composeViewContext2 != null) {
                    CompositionContext resolveParentCompositionContext = resolveParentCompositionContext();
                    LifecycleOwner lifecycleOwner = ViewTreeLifecycleOwner.get(findViewTreeComposeViewRoot);
                    if (lifecycleOwner == null) {
                        lifecycleOwner = composeViewContext != null ? composeViewContext.getLifecycleOwner$ui() : null;
                        if (lifecycleOwner == null) {
                            throw new IllegalStateException("Composed into the View which doesn't propagate ViewTreeLifecycleOwner!");
                        }
                    }
                    LifecycleOwner lifecycleOwner2 = lifecycleOwner;
                    SavedStateRegistryOwner savedStateRegistryOwner = ViewTreeSavedStateRegistryOwner.get(findViewTreeComposeViewRoot);
                    if (savedStateRegistryOwner == null) {
                        savedStateRegistryOwner = composeViewContext != null ? composeViewContext.getSavedStateRegistryOwner$ui() : null;
                        if (savedStateRegistryOwner == null) {
                            throw new IllegalStateException("Composed into the View which doesn't propagate ViewTreeSavedStateRegistryOwner!");
                        }
                    }
                    SavedStateRegistryOwner savedStateRegistryOwner2 = savedStateRegistryOwner;
                    ViewModelStoreOwner viewModelStoreOwner2 = ViewTreeViewModelStoreOwner.get(findViewTreeComposeViewRoot);
                    if (viewModelStoreOwner2 == null) {
                        viewModelStoreOwner = composeViewContext != null ? composeViewContext.getViewModelStoreOwner$ui() : null;
                    } else {
                        viewModelStoreOwner = viewModelStoreOwner2;
                    }
                    ComposeViewContext composeViewContext3 = new ComposeViewContext(findViewTreeComposeViewRoot, resolveParentCompositionContext, lifecycleOwner2, savedStateRegistryOwner2, viewModelStoreOwner);
                    ComposeView_androidKt.setComposeViewContext(findViewTreeComposeViewRoot, composeViewContext3);
                    return composeViewContext3;
                }
                return updateAutoCreatedComposeViewContext(findViewTreeComposeViewRoot, composeViewContext2);
            }
        }
        composeViewContext = null;
        findViewTreeComposeViewRoot = ComposeView_androidKt.findViewTreeComposeViewRoot(this);
        composeViewContext2 = ComposeView_androidKt.getComposeViewContext(findViewTreeComposeViewRoot);
        if (composeViewContext2 != null) {
        }
    }

    private final ComposeViewContext updateAutoCreatedComposeViewContext(View view, ComposeViewContext composeViewContext) {
        CompositionContext resolveParentCompositionContext = resolveParentCompositionContext();
        LifecycleOwner lifecycleOwner = ViewTreeLifecycleOwner.get(view);
        ViewModelStoreOwner viewModelStoreOwner = ViewTreeViewModelStoreOwner.get(view);
        SavedStateRegistryOwner savedStateRegistryOwner = ViewTreeSavedStateRegistryOwner.get(view);
        if (resolveParentCompositionContext == composeViewContext.getCompositionContext$ui() && lifecycleOwner == composeViewContext.getLifecycleOwner$ui() && viewModelStoreOwner == composeViewContext.getViewModelStoreOwner$ui() && savedStateRegistryOwner == composeViewContext.getSavedStateRegistryOwner$ui()) {
            return composeViewContext;
        }
        if (resolveParentCompositionContext.getEffectCoroutineContext() != composeViewContext.getCompositionContext$ui().getEffectCoroutineContext()) {
            disposeComposition();
        }
        if (lifecycleOwner == null) {
            lifecycleOwner = composeViewContext.getLifecycleOwner$ui();
        }
        LifecycleOwner lifecycleOwner2 = lifecycleOwner;
        if (savedStateRegistryOwner == null) {
            savedStateRegistryOwner = composeViewContext.getSavedStateRegistryOwner$ui();
        }
        ComposeViewContext copy = composeViewContext.copy(view, resolveParentCompositionContext, lifecycleOwner2, savedStateRegistryOwner, viewModelStoreOwner);
        ComposeView_androidKt.setComposeViewContext(view, copy);
        return copy;
    }

    public final void disposeComposition() {
        View childAt = getChildAt(0);
        AndroidComposeView androidComposeView = childAt instanceof AndroidComposeView ? (AndroidComposeView) childAt : null;
        if (androidComposeView != null) {
            androidComposeView.removeConnectionToComposeViewContext();
        }
        Composition composition = this.composition;
        if (composition != null) {
            composition.dispose();
        }
        this.composition = null;
        requestLayout();
    }

    public final boolean getHasComposition() {
        return this.composition != null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (WindowRecomposer_androidKt.getContentChild(this).getParent() == null) {
            getHandler().postAtFrontOfQueue(new Runnable() { // from class: androidx.compose.ui.platform.AbstractComposeView$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    AbstractComposeView.this.attachedToWindow();
                }
            });
        } else {
            attachedToWindow();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void attachedToWindow() {
        View findViewTreeComposeViewRoot;
        if (isAttachedToWindow()) {
            setPreviousAttachedWindowToken(getWindowToken());
            if (this.composeViewContext == null) {
                AndroidComposeView androidComposeView = null;
                if (getChildCount() != 0) {
                    View childAt = getChildAt(0);
                    if (childAt instanceof AndroidComposeView) {
                        androidComposeView = (AndroidComposeView) childAt;
                    }
                }
                if (androidComposeView != null) {
                    ComposeViewContext composeViewContext = androidComposeView.getComposeViewContext();
                    findViewTreeComposeViewRoot = ComposeView_androidKt.findViewTreeComposeViewRoot(this);
                    androidComposeView.setComposeViewContext(updateAutoCreatedComposeViewContext(findViewTreeComposeViewRoot, composeViewContext));
                }
            }
            if (getShouldCreateCompositionOnAttachedToWindow()) {
                ensureCompositionCreated();
            }
        }
    }

    @Override // android.view.View
    protected final void onMeasure(int i, int i2) {
        ensureCompositionCreated();
        internalOnMeasure$ui(i, i2);
    }

    public void internalOnMeasure$ui(int i, int i2) {
        View childAt = getChildAt(0);
        if (childAt == null) {
            super.onMeasure(i, i2);
            return;
        }
        childAt.measure(View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(i) - getPaddingLeft()) - getPaddingRight()), View.MeasureSpec.getMode(i)), View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(i2) - getPaddingTop()) - getPaddingBottom()), View.MeasureSpec.getMode(i2)));
        setMeasuredDimension(childAt.getMeasuredWidth() + getPaddingLeft() + getPaddingRight(), childAt.getMeasuredHeight() + getPaddingTop() + getPaddingBottom());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        internalOnLayout$ui(z, i, i2, i3, i4);
    }

    public void internalOnLayout$ui(boolean z, int i, int i2, int i3, int i4) {
        View childAt = getChildAt(0);
        if (childAt != null) {
            childAt.layout(getPaddingLeft(), getPaddingTop(), (i3 - i) - getPaddingRight(), (i4 - i2) - getPaddingBottom());
        }
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i) {
        View childAt = getChildAt(0);
        if (childAt != null) {
            childAt.setLayoutDirection(i);
        }
    }

    @Override // android.view.ViewGroup
    public boolean isTransitionGroup() {
        return !this.isTransitionGroupSet || super.isTransitionGroup();
    }

    @Override // android.view.ViewGroup
    public void setTransitionGroup(boolean z) {
        super.setTransitionGroup(z);
        this.isTransitionGroupSet = true;
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        checkAddView();
        super.addView(view);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i) {
        checkAddView();
        super.addView(view, i);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, int i2) {
        checkAddView();
        super.addView(view, i, i2);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        checkAddView();
        super.addView(view, layoutParams);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        checkAddView();
        super.addView(view, i, layoutParams);
    }

    @Override // android.view.ViewGroup
    protected boolean addViewInLayout(View view, int i, ViewGroup.LayoutParams layoutParams) {
        checkAddView();
        return super.addViewInLayout(view, i, layoutParams);
    }

    @Override // android.view.ViewGroup
    protected boolean addViewInLayout(View view, int i, ViewGroup.LayoutParams layoutParams, boolean z) {
        checkAddView();
        return super.addViewInLayout(view, i, layoutParams, z);
    }
}
