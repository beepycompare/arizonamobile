package androidx.compose.animation;

import androidx.compose.animation.SharedTransitionScope;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.RememberObserver;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.graphics.layer.GraphicsLayerKt;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import io.appmetrica.analytics.modulesapi.internal.client.adrevenue.AdRevenueConstants;
import kotlin.Metadata;
/* compiled from: SharedElementEntry.kt */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b0\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002BG\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010A\u001a\u0004\u0018\u00010B2\u0006\u0010C\u001a\u00020BJ\u0010\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020MH\u0016J\b\u0010h\u001a\u00020KH\u0016J\b\u0010i\u001a\u00020KH\u0016J\b\u0010j\u001a\u00020KH\u0016R+\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\n8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R+\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00118V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR+\u0010\r\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\n8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b#\u0010\u001a\u001a\u0004\b!\u0010\u0016\"\u0004\b\"\u0010\u0018R+\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00048F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b(\u0010\u001a\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R+\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00068F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b-\u0010\u001a\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R+\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\b8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b2\u0010\u001a\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R+\u0010\t\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\n8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b5\u0010\u001a\u001a\u0004\b3\u0010\u0016\"\u0004\b4\u0010\u0018R+\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\f8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b:\u0010\u001a\u001a\u0004\b6\u00107\"\u0004\b8\u00109R+\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u000f8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b?\u0010\u001a\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u0011\u0010@\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b@\u0010\u0016R\u001c\u0010D\u001a\u0004\u0018\u00010EX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\u001c\u0010N\u001a\u0004\u0018\u00010\u0000X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR\u0011\u0010S\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\bT\u0010\u0016R\u001c\u0010U\u001a\u0004\u0018\u00010VX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR/\u0010\\\u001a\u0004\u0018\u00010[2\b\u0010\u0014\u001a\u0004\u0018\u00010[8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\ba\u0010\u001a\u001a\u0004\b]\u0010^\"\u0004\b_\u0010`R\u0014\u0010b\u001a\u00020\n8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bc\u0010\u0016R\u0014\u0010d\u001a\u00020\n8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\be\u0010\u0016R\u0011\u0010f\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\bg\u0010\u0016¨\u0006k"}, d2 = {"Landroidx/compose/animation/SharedElementEntry;", "Landroidx/compose/animation/LayerRenderer;", "Landroidx/compose/runtime/RememberObserver;", "sharedElement", "Landroidx/compose/animation/SharedElement;", "boundsAnimation", "Landroidx/compose/animation/BoundsAnimation;", "placeholderSize", "Landroidx/compose/animation/SharedTransitionScope$PlaceholderSize;", "renderOnlyWhenVisible", "", "overlayClip", "Landroidx/compose/animation/SharedTransitionScope$OverlayClip;", "renderInOverlayDuringTransition", "userState", "Landroidx/compose/animation/SharedTransitionScope$SharedContentState;", "zIndex", "", "<init>", "(Landroidx/compose/animation/SharedElement;Landroidx/compose/animation/BoundsAnimation;Landroidx/compose/animation/SharedTransitionScope$PlaceholderSize;ZLandroidx/compose/animation/SharedTransitionScope$OverlayClip;ZLandroidx/compose/animation/SharedTransitionScope$SharedContentState;F)V", "<set-?>", "isAttached", "()Z", "setAttached", "(Z)V", "isAttached$delegate", "Landroidx/compose/runtime/MutableState;", "getZIndex", "()F", "setZIndex", "(F)V", "zIndex$delegate", "Landroidx/compose/runtime/MutableFloatState;", "getRenderInOverlayDuringTransition", "setRenderInOverlayDuringTransition", "renderInOverlayDuringTransition$delegate", "getSharedElement", "()Landroidx/compose/animation/SharedElement;", "setSharedElement", "(Landroidx/compose/animation/SharedElement;)V", "sharedElement$delegate", "getBoundsAnimation", "()Landroidx/compose/animation/BoundsAnimation;", "setBoundsAnimation", "(Landroidx/compose/animation/BoundsAnimation;)V", "boundsAnimation$delegate", "getPlaceholderSize", "()Landroidx/compose/animation/SharedTransitionScope$PlaceholderSize;", "setPlaceholderSize", "(Landroidx/compose/animation/SharedTransitionScope$PlaceholderSize;)V", "placeholderSize$delegate", "getRenderOnlyWhenVisible", "setRenderOnlyWhenVisible", "renderOnlyWhenVisible$delegate", "getOverlayClip", "()Landroidx/compose/animation/SharedTransitionScope$OverlayClip;", "setOverlayClip", "(Landroidx/compose/animation/SharedTransitionScope$OverlayClip;)V", "overlayClip$delegate", "getUserState", "()Landroidx/compose/animation/SharedTransitionScope$SharedContentState;", "setUserState", "(Landroidx/compose/animation/SharedTransitionScope$SharedContentState;)V", "userState$delegate", "isEnabled", "calculateTargetBounds", "Landroidx/compose/ui/geometry/Rect;", "previousTargetBoundsBeforeLosingTarget", "clipPathInOverlay", "Landroidx/compose/ui/graphics/Path;", "getClipPathInOverlay$animation", "()Landroidx/compose/ui/graphics/Path;", "setClipPathInOverlay$animation", "(Landroidx/compose/ui/graphics/Path;)V", "drawInOverlay", "", "drawScope", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "parentState", "getParentState", "()Landroidx/compose/animation/SharedElementEntry;", "setParentState", "(Landroidx/compose/animation/SharedElementEntry;)V", TypedValues.AttributesType.S_TARGET, "getTarget", "boundsProvider", "Landroidx/compose/animation/BoundsProvider;", "getBoundsProvider", "()Landroidx/compose/animation/BoundsProvider;", "setBoundsProvider", "(Landroidx/compose/animation/BoundsProvider;)V", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", AdRevenueConstants.LAYER_KEY, "getLayer", "()Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "setLayer", "(Landroidx/compose/ui/graphics/layer/GraphicsLayer;)V", "layer$delegate", "shouldRenderAtAll", "getShouldRenderAtAll", "shouldRenderInOverlay", "getShouldRenderInOverlay$animation", "shouldRenderInPlace", "getShouldRenderInPlace", "onRemembered", "onForgotten", "onAbandoned", "animation"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SharedElementEntry implements LayerRenderer, RememberObserver {
    public static final int $stable = 8;
    private final MutableState boundsAnimation$delegate;
    private BoundsProvider boundsProvider;
    private Path clipPathInOverlay;
    private final MutableState isAttached$delegate;
    private final MutableState layer$delegate;
    private final MutableState overlayClip$delegate;
    private SharedElementEntry parentState;
    private final MutableState placeholderSize$delegate;
    private final MutableState renderInOverlayDuringTransition$delegate;
    private final MutableState renderOnlyWhenVisible$delegate;
    private final MutableState sharedElement$delegate;
    private final MutableState userState$delegate;
    private final MutableFloatState zIndex$delegate;

    @Override // androidx.compose.runtime.RememberObserver
    public void onAbandoned() {
    }

    public SharedElementEntry(SharedElement sharedElement, BoundsAnimation boundsAnimation, SharedTransitionScope.PlaceholderSize placeholderSize, boolean z, SharedTransitionScope.OverlayClip overlayClip, boolean z2, SharedTransitionScope.SharedContentState sharedContentState, float f) {
        MutableState mutableStateOf$default;
        MutableState mutableStateOf$default2;
        MutableState mutableStateOf$default3;
        MutableState mutableStateOf$default4;
        MutableState mutableStateOf$default5;
        MutableState mutableStateOf$default6;
        MutableState mutableStateOf$default7;
        MutableState mutableStateOf$default8;
        MutableState mutableStateOf$default9;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
        this.isAttached$delegate = mutableStateOf$default;
        this.zIndex$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(f);
        mutableStateOf$default2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z2), null, 2, null);
        this.renderInOverlayDuringTransition$delegate = mutableStateOf$default2;
        mutableStateOf$default3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(sharedElement, null, 2, null);
        this.sharedElement$delegate = mutableStateOf$default3;
        mutableStateOf$default4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(boundsAnimation, null, 2, null);
        this.boundsAnimation$delegate = mutableStateOf$default4;
        mutableStateOf$default5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(placeholderSize, null, 2, null);
        this.placeholderSize$delegate = mutableStateOf$default5;
        mutableStateOf$default6 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z), null, 2, null);
        this.renderOnlyWhenVisible$delegate = mutableStateOf$default6;
        mutableStateOf$default7 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(overlayClip, null, 2, null);
        this.overlayClip$delegate = mutableStateOf$default7;
        mutableStateOf$default8 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(sharedContentState, null, 2, null);
        this.userState$delegate = mutableStateOf$default8;
        mutableStateOf$default9 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.layer$delegate = mutableStateOf$default9;
    }

    public final boolean isAttached() {
        return ((Boolean) this.isAttached$delegate.getValue()).booleanValue();
    }

    public final void setAttached(boolean z) {
        this.isAttached$delegate.setValue(Boolean.valueOf(z));
    }

    @Override // androidx.compose.animation.LayerRenderer
    public float getZIndex() {
        return this.zIndex$delegate.getFloatValue();
    }

    public void setZIndex(float f) {
        this.zIndex$delegate.setFloatValue(f);
    }

    public final boolean getRenderInOverlayDuringTransition() {
        return ((Boolean) this.renderInOverlayDuringTransition$delegate.getValue()).booleanValue();
    }

    public final void setRenderInOverlayDuringTransition(boolean z) {
        this.renderInOverlayDuringTransition$delegate.setValue(Boolean.valueOf(z));
    }

    public final SharedElement getSharedElement() {
        return (SharedElement) this.sharedElement$delegate.getValue();
    }

    public final void setSharedElement(SharedElement sharedElement) {
        this.sharedElement$delegate.setValue(sharedElement);
    }

    public final BoundsAnimation getBoundsAnimation() {
        return (BoundsAnimation) this.boundsAnimation$delegate.getValue();
    }

    public final void setBoundsAnimation(BoundsAnimation boundsAnimation) {
        this.boundsAnimation$delegate.setValue(boundsAnimation);
    }

    public final SharedTransitionScope.PlaceholderSize getPlaceholderSize() {
        return (SharedTransitionScope.PlaceholderSize) this.placeholderSize$delegate.getValue();
    }

    public final void setPlaceholderSize(SharedTransitionScope.PlaceholderSize placeholderSize) {
        this.placeholderSize$delegate.setValue(placeholderSize);
    }

    public final boolean getRenderOnlyWhenVisible() {
        return ((Boolean) this.renderOnlyWhenVisible$delegate.getValue()).booleanValue();
    }

    public final void setRenderOnlyWhenVisible(boolean z) {
        this.renderOnlyWhenVisible$delegate.setValue(Boolean.valueOf(z));
    }

    public final SharedTransitionScope.OverlayClip getOverlayClip() {
        return (SharedTransitionScope.OverlayClip) this.overlayClip$delegate.getValue();
    }

    public final void setOverlayClip(SharedTransitionScope.OverlayClip overlayClip) {
        this.overlayClip$delegate.setValue(overlayClip);
    }

    public final SharedTransitionScope.SharedContentState getUserState() {
        return (SharedTransitionScope.SharedContentState) this.userState$delegate.getValue();
    }

    public final void setUserState(SharedTransitionScope.SharedContentState sharedContentState) {
        this.userState$delegate.setValue(sharedContentState);
    }

    public final boolean isEnabled() {
        return isAttached() && getUserState().isEnabledByUser$animation();
    }

    public final Rect calculateTargetBounds(Rect rect) {
        return getUserState().getConfig$animation().m124alternativeTargetBoundsInTransitionScopeAfterRemovalcSwnlzA(getUserState(), rect, IntSizeKt.m7738toSizeozmzZPI(getSharedElement().getScope().getLookaheadRoot$animation().mo6224getSizeYbymL2g()));
    }

    public final Path getClipPathInOverlay$animation() {
        return this.clipPathInOverlay;
    }

    public final void setClipPathInOverlay$animation(Path path) {
        this.clipPathInOverlay = path;
    }

    @Override // androidx.compose.animation.LayerRenderer
    public void drawInOverlay(DrawScope drawScope) {
        Rect currentBounds;
        GraphicsLayer layer = getLayer();
        if (layer == null || (currentBounds = getSharedElement().getState$animation().getCurrentBounds()) == null || !getShouldRenderInOverlay$animation()) {
            return;
        }
        long m4562getTopLeftF1C5BW0 = currentBounds.m4562getTopLeftF1C5BW0();
        float intBitsToFloat = Float.intBitsToFloat((int) (m4562getTopLeftF1C5BW0 >> 32));
        float intBitsToFloat2 = Float.intBitsToFloat((int) (m4562getTopLeftF1C5BW0 & 4294967295L));
        Path path = this.clipPathInOverlay;
        if (path != null) {
            int m4761getIntersectrtfAjoo = ClipOp.Companion.m4761getIntersectrtfAjoo();
            DrawContext drawContext = drawScope.getDrawContext();
            long mo5267getSizeNHjbRc = drawContext.mo5267getSizeNHjbRc();
            drawContext.getCanvas().save();
            try {
                drawContext.getTransform().mo5269clipPathmtrdDE(path, m4761getIntersectrtfAjoo);
                drawScope.getDrawContext().getTransform().translate(intBitsToFloat, intBitsToFloat2);
                GraphicsLayerKt.drawLayer(drawScope, layer);
                return;
            } finally {
                drawContext.getCanvas().restore();
                drawContext.mo5268setSizeuvyYCjk(mo5267getSizeNHjbRc);
            }
        }
        drawScope.getDrawContext().getTransform().translate(intBitsToFloat, intBitsToFloat2);
        try {
            GraphicsLayerKt.drawLayer(drawScope, layer);
        } finally {
            drawScope.getDrawContext().getTransform().translate(-intBitsToFloat, -intBitsToFloat2);
        }
    }

    @Override // androidx.compose.animation.LayerRenderer
    public SharedElementEntry getParentState() {
        return this.parentState;
    }

    public void setParentState(SharedElementEntry sharedElementEntry) {
        this.parentState = sharedElementEntry;
    }

    public final boolean getTarget() {
        return getBoundsAnimation().getTarget();
    }

    public final BoundsProvider getBoundsProvider() {
        return this.boundsProvider;
    }

    public final void setBoundsProvider(BoundsProvider boundsProvider) {
        this.boundsProvider = boundsProvider;
    }

    public final GraphicsLayer getLayer() {
        return (GraphicsLayer) this.layer$delegate.getValue();
    }

    public final void setLayer(GraphicsLayer graphicsLayer) {
        this.layer$delegate.setValue(graphicsLayer);
    }

    private final boolean getShouldRenderAtAll() {
        if (getBoundsAnimation().getTarget()) {
            return true;
        }
        return (getSharedElement().getState$animation().getMatchIsOrHasBeenConfigured() && !getSharedElement().getState$animation().getActiveMatchFound()) || !getRenderOnlyWhenVisible();
    }

    public final boolean getShouldRenderInOverlay$animation() {
        return getShouldRenderAtAll() && getSharedElement().getBoundsTransformIsActive() && isEnabled() && getRenderInOverlayDuringTransition() && getSharedElement().getScope().isTransitionActive();
    }

    public final boolean getShouldRenderInPlace() {
        if (getSharedElement().getBoundsTransformIsActive()) {
            return !getShouldRenderInOverlay$animation() && getShouldRenderAtAll();
        }
        return true;
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void onRemembered() {
        getSharedElement().getScope().onEntryAdded$animation(this);
        getSharedElement().invalidateTargetBoundsProvider();
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void onForgotten() {
        getSharedElement().getScope().onEntryRemoved$animation(this);
        getSharedElement().invalidateTargetBoundsProvider();
    }
}
