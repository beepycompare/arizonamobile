package androidx.compose.ui.platform;

import android.view.View;
import android.view.ViewGroup;
import androidx.compose.runtime.AbstractApplier;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composition;
import androidx.compose.runtime.CompositionKt;
import androidx.compose.ui.R;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.UiApplier;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Collections;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
/* compiled from: Wrapper.android.kt */
@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0016\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0000\u001a,\u0010\u0004\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0011\u0010\t\u001a\r\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0002\b\fH\u0001¢\u0006\u0002\u0010\r\"\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"createApplier", "Landroidx/compose/runtime/AbstractApplier;", "Landroidx/compose/ui/node/LayoutNode;", TtmlNode.RUBY_CONTAINER, "setContent", "Landroidx/compose/runtime/Composition;", "Landroidx/compose/ui/platform/AbstractComposeView;", "composeViewContext", "Landroidx/compose/ui/platform/ComposeViewContext;", FirebaseAnalytics.Param.CONTENT, "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/ui/platform/AbstractComposeView;Landroidx/compose/ui/platform/ComposeViewContext;Lkotlin/jvm/functions/Function2;)Landroidx/compose/runtime/Composition;", "DefaultLayoutParams", "Landroid/view/ViewGroup$LayoutParams;", "ui"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class Wrapper_androidKt {
    private static final ViewGroup.LayoutParams DefaultLayoutParams = new ViewGroup.LayoutParams(-2, -2);

    public static final AbstractApplier<LayoutNode> createApplier(LayoutNode layoutNode) {
        return new UiApplier(layoutNode);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0074  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Composition setContent(AbstractComposeView abstractComposeView, ComposeViewContext composeViewContext, Function2<? super Composer, ? super Integer, Unit> function2) {
        AndroidComposeView androidComposeView;
        WrappedComposition wrappedComposition;
        GlobalSnapshotManager.INSTANCE.ensureStarted();
        if (abstractComposeView.getChildCount() > 0) {
            View childAt = abstractComposeView.getChildAt(0);
            androidComposeView = childAt instanceof AndroidComposeView ? (AndroidComposeView) childAt : null;
            if (androidComposeView != null) {
                androidComposeView.setComposeViewContext(composeViewContext);
                if (androidComposeView == null) {
                    androidComposeView = new AndroidComposeView(abstractComposeView.getContext(), composeViewContext);
                    abstractComposeView.addView(androidComposeView.getView(), DefaultLayoutParams);
                }
                androidComposeView.setComposeViewContext(composeViewContext);
                if (abstractComposeView.getComposeViewContext$ui() != null) {
                    composeViewContext.incrementViewCount$ui();
                    androidComposeView.setComposeViewContextIncrementedDuringInit$ui(true);
                }
                if (InspectableValueKt.isDebugInspectorInfoEnabled() && androidComposeView.getTag(R.id.inspection_slot_table_set) == null) {
                    androidComposeView.setTag(R.id.inspection_slot_table_set, Collections.newSetFromMap(new WeakHashMap()));
                }
                Object tag = androidComposeView.getTag(R.id.wrapped_composition_tag);
                wrappedComposition = tag instanceof WrappedComposition ? (WrappedComposition) tag : null;
                if (wrappedComposition == null) {
                    wrappedComposition = new WrappedComposition(androidComposeView, CompositionKt.Composition(new UiApplier(androidComposeView.getRoot()), composeViewContext.getCompositionContext$ui()));
                    androidComposeView.setTag(R.id.wrapped_composition_tag, wrappedComposition);
                }
                wrappedComposition.setContent(function2);
                androidComposeView.setFrameEndScheduler$ui(new Wrapper_androidKt$setContent$1(composeViewContext.getCompositionContext$ui()));
                return wrappedComposition;
            }
        } else {
            abstractComposeView.removeAllViews();
        }
        androidComposeView = null;
        if (androidComposeView == null) {
        }
        androidComposeView.setComposeViewContext(composeViewContext);
        if (abstractComposeView.getComposeViewContext$ui() != null) {
        }
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            androidComposeView.setTag(R.id.inspection_slot_table_set, Collections.newSetFromMap(new WeakHashMap()));
        }
        Object tag2 = androidComposeView.getTag(R.id.wrapped_composition_tag);
        if (tag2 instanceof WrappedComposition) {
        }
        if (wrappedComposition == null) {
        }
        wrappedComposition.setContent(function2);
        androidComposeView.setFrameEndScheduler$ui(new Wrapper_androidKt$setContent$1(composeViewContext.getCompositionContext$ui()));
        return wrappedComposition;
    }
}
