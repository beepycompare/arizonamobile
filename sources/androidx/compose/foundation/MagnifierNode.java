package androidx.compose.foundation;

import android.view.View;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.InlineClassHelperKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatableNode_androidKt;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.GlobalPositionAwareModifierNode;
import androidx.compose.ui.node.ObserverModifierNode;
import androidx.compose.ui.node.ObserverModifierNodeKt;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpSize;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ChannelResult;
/* compiled from: Magnifier.android.kt */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005B\u0099\u0001\u0012\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\n\u0012\u001b\b\u0002\u0010\u000b\u001a\u0015\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007¢\u0006\u0002\b\n\u0012\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0007\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\r\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0019¢\u0006\u0002\u0010\u001aJ\b\u0010R\u001a\u00020\u000eH\u0016J\b\u0010S\u001a\u00020\u000eH\u0016J\u0010\u0010T\u001a\u00020\u000e2\u0006\u0010U\u001a\u00020/H\u0016J\b\u0010V\u001a\u00020\u000eH\u0016J\b\u0010W\u001a\u00020\u000eH\u0002J\u0092\u0001\u0010X\u001a\u00020\u000e2\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\n2\u0019\u0010\u000b\u001a\u0015\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007¢\u0006\u0002\b\n2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00122\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u00072\u0006\u0010\u0018\u001a\u00020\u0019ø\u0001\u0000¢\u0006\u0004\bY\u0010ZJ\b\u0010[\u001a\u00020\u000eH\u0002J\b\u0010\\\u001a\u00020\u000eH\u0002J\f\u0010]\u001a\u00020\u000e*\u00020^H\u0016J\f\u0010_\u001a\u00020\u000e*\u00020`H\u0016R\u001a\u0010\u001b\u001a\u00020\t8BX\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\"\u0010\u0014\u001a\u00020\u0015X\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010(\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u0010\u0010)\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010*\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0016\u001a\u00020\u0015X\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010(\u001a\u0004\b,\u0010%\"\u0004\b-\u0010'R/\u00100\u001a\u0004\u0018\u00010/2\b\u0010.\u001a\u0004\u0018\u00010/8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u0010\u00107\u001a\u0004\u0018\u000108X\u0082\u000e¢\u0006\u0002\n\u0000R-\u0010\u000b\u001a\u0015\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007¢\u0006\u0002\b\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R(\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010:\"\u0004\b>\u0010<R\u001a\u0010\u0018\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u0016\u0010C\u001a\u0004\u0018\u00010DX\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\n\u0000R\"\u0010\u0013\u001a\u00020\rX\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010H\u001a\u0004\bE\u0010\u001d\"\u0004\bF\u0010GR+\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010:\"\u0004\bJ\u0010<R\u0016\u0010K\u001a\u00020\tX\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010HR\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010!\"\u0004\bM\u0010#R\u0010\u0010N\u001a\u0004\u0018\u00010OX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010%\"\u0004\bQ\u0010'\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006a"}, d2 = {"Landroidx/compose/foundation/MagnifierNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/GlobalPositionAwareModifierNode;", "Landroidx/compose/ui/node/DrawModifierNode;", "Landroidx/compose/ui/node/SemanticsModifierNode;", "Landroidx/compose/ui/node/ObserverModifierNode;", "sourceCenter", "Lkotlin/Function1;", "Landroidx/compose/ui/unit/Density;", "Landroidx/compose/ui/geometry/Offset;", "Lkotlin/ExtensionFunctionType;", "magnifierCenter", "onSizeChanged", "Landroidx/compose/ui/unit/DpSize;", "", "zoom", "", "useTextDefault", "", "size", "cornerRadius", "Landroidx/compose/ui/unit/Dp;", "elevation", "clippingEnabled", "platformMagnifierFactory", "Landroidx/compose/foundation/PlatformMagnifierFactory;", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;FZJFFZLandroidx/compose/foundation/PlatformMagnifierFactory;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "anchorPositionInRoot", "getAnchorPositionInRoot-F1C5BW0", "()J", "anchorPositionInRootState", "Landroidx/compose/runtime/State;", "getClippingEnabled", "()Z", "setClippingEnabled", "(Z)V", "getCornerRadius-D9Ej5fM", "()F", "setCornerRadius-0680j_4", "(F)V", "F", "density", "drawSignalChannel", "Lkotlinx/coroutines/channels/Channel;", "getElevation-D9Ej5fM", "setElevation-0680j_4", "<set-?>", "Landroidx/compose/ui/layout/LayoutCoordinates;", "layoutCoordinates", "getLayoutCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "setLayoutCoordinates", "(Landroidx/compose/ui/layout/LayoutCoordinates;)V", "layoutCoordinates$delegate", "Landroidx/compose/runtime/MutableState;", "magnifier", "Landroidx/compose/foundation/PlatformMagnifier;", "getMagnifierCenter", "()Lkotlin/jvm/functions/Function1;", "setMagnifierCenter", "(Lkotlin/jvm/functions/Function1;)V", "getOnSizeChanged", "setOnSizeChanged", "getPlatformMagnifierFactory", "()Landroidx/compose/foundation/PlatformMagnifierFactory;", "setPlatformMagnifierFactory", "(Landroidx/compose/foundation/PlatformMagnifierFactory;)V", "previousSize", "Landroidx/compose/ui/unit/IntSize;", "getSize-MYxV2XQ", "setSize-EaSLcWc", "(J)V", "J", "getSourceCenter", "setSourceCenter", "sourceCenterInRoot", "getUseTextDefault", "setUseTextDefault", "view", "Landroid/view/View;", "getZoom", "setZoom", "onAttach", "onDetach", "onGloballyPositioned", "coordinates", "onObservedReadsChanged", "recreateMagnifier", "update", "update-5F03MCQ", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;FZJFFZLkotlin/jvm/functions/Function1;Landroidx/compose/foundation/PlatformMagnifierFactory;)V", "updateMagnifier", "updateSizeIfNecessary", "applySemantics", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "draw", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "foundation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class MagnifierNode extends Modifier.Node implements GlobalPositionAwareModifierNode, DrawModifierNode, SemanticsModifierNode, ObserverModifierNode {
    public static final int $stable = 8;
    private State<Offset> anchorPositionInRootState;
    private boolean clippingEnabled;
    private float cornerRadius;
    private Density density;
    private Channel<Unit> drawSignalChannel;
    private float elevation;
    private final MutableState layoutCoordinates$delegate;
    private PlatformMagnifier magnifier;
    private Function1<? super Density, Offset> magnifierCenter;
    private Function1<? super DpSize, Unit> onSizeChanged;
    private PlatformMagnifierFactory platformMagnifierFactory;
    private IntSize previousSize;
    private long size;
    private Function1<? super Density, Offset> sourceCenter;
    private long sourceCenterInRoot;
    private boolean useTextDefault;
    private View view;
    private float zoom;

    public /* synthetic */ MagnifierNode(Function1 function1, Function1 function12, Function1 function13, float f, boolean z, long j, float f2, float f3, boolean z2, PlatformMagnifierFactory platformMagnifierFactory, DefaultConstructorMarker defaultConstructorMarker) {
        this(function1, function12, function13, f, z, j, f2, f3, z2, platformMagnifierFactory);
    }

    public final Function1<Density, Offset> getSourceCenter() {
        return this.sourceCenter;
    }

    public final void setSourceCenter(Function1<? super Density, Offset> function1) {
        this.sourceCenter = function1;
    }

    public final Function1<Density, Offset> getMagnifierCenter() {
        return this.magnifierCenter;
    }

    public final void setMagnifierCenter(Function1<? super Density, Offset> function1) {
        this.magnifierCenter = function1;
    }

    public final Function1<DpSize, Unit> getOnSizeChanged() {
        return this.onSizeChanged;
    }

    public final void setOnSizeChanged(Function1<? super DpSize, Unit> function1) {
        this.onSizeChanged = function1;
    }

    public final float getZoom() {
        return this.zoom;
    }

    public final void setZoom(float f) {
        this.zoom = f;
    }

    public final boolean getUseTextDefault() {
        return this.useTextDefault;
    }

    public final void setUseTextDefault(boolean z) {
        this.useTextDefault = z;
    }

    public /* synthetic */ MagnifierNode(Function1 function1, Function1 function12, Function1 function13, float f, boolean z, long j, float f2, float f3, boolean z2, PlatformMagnifierFactory platformMagnifierFactory, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(function1, (i & 2) != 0 ? null : function12, (i & 4) != 0 ? null : function13, (i & 8) != 0 ? Float.NaN : f, (i & 16) != 0 ? false : z, (i & 32) != 0 ? DpSize.Companion.m6791getUnspecifiedMYxV2XQ() : j, (i & 64) != 0 ? Dp.Companion.m6704getUnspecifiedD9Ej5fM() : f2, (i & 128) != 0 ? Dp.Companion.m6704getUnspecifiedD9Ej5fM() : f3, (i & 256) != 0 ? true : z2, (i & 512) != 0 ? PlatformMagnifierFactory.Companion.getForCurrentPlatform() : platformMagnifierFactory, null);
    }

    /* renamed from: getSize-MYxV2XQ  reason: not valid java name */
    public final long m308getSizeMYxV2XQ() {
        return this.size;
    }

    /* renamed from: setSize-EaSLcWc  reason: not valid java name */
    public final void m311setSizeEaSLcWc(long j) {
        this.size = j;
    }

    /* renamed from: getCornerRadius-D9Ej5fM  reason: not valid java name */
    public final float m306getCornerRadiusD9Ej5fM() {
        return this.cornerRadius;
    }

    /* renamed from: setCornerRadius-0680j_4  reason: not valid java name */
    public final void m309setCornerRadius0680j_4(float f) {
        this.cornerRadius = f;
    }

    /* renamed from: getElevation-D9Ej5fM  reason: not valid java name */
    public final float m307getElevationD9Ej5fM() {
        return this.elevation;
    }

    /* renamed from: setElevation-0680j_4  reason: not valid java name */
    public final void m310setElevation0680j_4(float f) {
        this.elevation = f;
    }

    public final boolean getClippingEnabled() {
        return this.clippingEnabled;
    }

    public final void setClippingEnabled(boolean z) {
        this.clippingEnabled = z;
    }

    public final PlatformMagnifierFactory getPlatformMagnifierFactory() {
        return this.platformMagnifierFactory;
    }

    public final void setPlatformMagnifierFactory(PlatformMagnifierFactory platformMagnifierFactory) {
        this.platformMagnifierFactory = platformMagnifierFactory;
    }

    private MagnifierNode(Function1<? super Density, Offset> function1, Function1<? super Density, Offset> function12, Function1<? super DpSize, Unit> function13, float f, boolean z, long j, float f2, float f3, boolean z2, PlatformMagnifierFactory platformMagnifierFactory) {
        this.sourceCenter = function1;
        this.magnifierCenter = function12;
        this.onSizeChanged = function13;
        this.zoom = f;
        this.useTextDefault = z;
        this.size = j;
        this.cornerRadius = f2;
        this.elevation = f3;
        this.clippingEnabled = z2;
        this.platformMagnifierFactory = platformMagnifierFactory;
        this.layoutCoordinates$delegate = SnapshotStateKt.mutableStateOf(null, SnapshotStateKt.neverEqualPolicy());
        this.sourceCenterInRoot = Offset.Companion.m3852getUnspecifiedF1C5BW0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LayoutCoordinates getLayoutCoordinates() {
        return (LayoutCoordinates) this.layoutCoordinates$delegate.getValue();
    }

    private final void setLayoutCoordinates(LayoutCoordinates layoutCoordinates) {
        this.layoutCoordinates$delegate.setValue(layoutCoordinates);
    }

    /* renamed from: getAnchorPositionInRoot-F1C5BW0  reason: not valid java name */
    private final long m305getAnchorPositionInRootF1C5BW0() {
        if (this.anchorPositionInRootState == null) {
            this.anchorPositionInRootState = SnapshotStateKt.derivedStateOf(new Function0<Offset>() { // from class: androidx.compose.foundation.MagnifierNode$anchorPositionInRoot$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Offset invoke() {
                    return Offset.m3826boximpl(m313invokeF1C5BW0());
                }

                /* renamed from: invoke-F1C5BW0  reason: not valid java name */
                public final long m313invokeF1C5BW0() {
                    LayoutCoordinates layoutCoordinates;
                    layoutCoordinates = MagnifierNode.this.getLayoutCoordinates();
                    return layoutCoordinates != null ? LayoutCoordinatesKt.positionInRoot(layoutCoordinates) : Offset.Companion.m3852getUnspecifiedF1C5BW0();
                }
            });
        }
        State<Offset> state = this.anchorPositionInRootState;
        return state != null ? state.getValue().m3847unboximpl() : Offset.Companion.m3852getUnspecifiedF1C5BW0();
    }

    /* renamed from: update-5F03MCQ  reason: not valid java name */
    public final void m312update5F03MCQ(Function1<? super Density, Offset> function1, Function1<? super Density, Offset> function12, float f, boolean z, long j, float f2, float f3, boolean z2, Function1<? super DpSize, Unit> function13, PlatformMagnifierFactory platformMagnifierFactory) {
        float f4 = this.zoom;
        long j2 = this.size;
        float f5 = this.cornerRadius;
        boolean z3 = this.useTextDefault;
        float f6 = this.elevation;
        boolean z4 = this.clippingEnabled;
        PlatformMagnifierFactory platformMagnifierFactory2 = this.platformMagnifierFactory;
        View view = this.view;
        Density density = this.density;
        this.sourceCenter = function1;
        this.magnifierCenter = function12;
        this.zoom = f;
        this.useTextDefault = z;
        this.size = j;
        this.cornerRadius = f2;
        this.elevation = f3;
        this.clippingEnabled = z2;
        this.onSizeChanged = function13;
        this.platformMagnifierFactory = platformMagnifierFactory;
        MagnifierNode magnifierNode = this;
        View requireView = DelegatableNode_androidKt.requireView(magnifierNode);
        Density requireDensity = DelegatableNodeKt.requireDensity(magnifierNode);
        if (this.magnifier != null && ((!Magnifier_androidKt.equalsIncludingNaN(f, f4) && !platformMagnifierFactory.getCanUpdateZoom()) || !DpSize.m6779equalsimpl0(j, j2) || !Dp.m6689equalsimpl0(f2, f5) || !Dp.m6689equalsimpl0(f3, f6) || z != z3 || z2 != z4 || !Intrinsics.areEqual(platformMagnifierFactory, platformMagnifierFactory2) || !Intrinsics.areEqual(requireView, view) || !Intrinsics.areEqual(requireDensity, density))) {
            recreateMagnifier();
        }
        updateMagnifier();
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onAttach() {
        onObservedReadsChanged();
        this.drawSignalChannel = ChannelKt.Channel$default(0, null, null, 7, null);
        BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, CoroutineStart.UNDISPATCHED, new MagnifierNode$onAttach$1(this, null), 1, null);
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        PlatformMagnifier platformMagnifier = this.magnifier;
        if (platformMagnifier != null) {
            platformMagnifier.dismiss();
        }
        this.magnifier = null;
    }

    @Override // androidx.compose.ui.node.ObserverModifierNode
    public void onObservedReadsChanged() {
        ObserverModifierNodeKt.observeReads(this, new Function0<Unit>() { // from class: androidx.compose.foundation.MagnifierNode$onObservedReadsChanged$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                MagnifierNode.this.updateMagnifier();
            }
        });
    }

    private final void recreateMagnifier() {
        PlatformMagnifier platformMagnifier = this.magnifier;
        if (platformMagnifier != null) {
            platformMagnifier.dismiss();
        }
        View view = this.view;
        if (view == null) {
            view = DelegatableNode_androidKt.requireView(this);
        }
        View view2 = view;
        this.view = view2;
        Density density = this.density;
        if (density == null) {
            density = DelegatableNodeKt.requireDensity(this);
        }
        Density density2 = density;
        this.density = density2;
        this.magnifier = this.platformMagnifierFactory.mo339createnHHXs2Y(view2, this.useTextDefault, this.size, this.cornerRadius, this.elevation, this.clippingEnabled, density2, this.zoom);
        updateSizeIfNecessary();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x007a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void updateMagnifier() {
        long m3852getUnspecifiedF1C5BW0;
        PlatformMagnifier platformMagnifier;
        Density density = this.density;
        if (density == null) {
            density = DelegatableNodeKt.requireDensity(this);
            this.density = density;
        }
        long m3847unboximpl = this.sourceCenter.invoke(density).m3847unboximpl();
        if ((m3847unboximpl & 9223372034707292159L) != InlineClassHelperKt.UnspecifiedPackedFloats && (m305getAnchorPositionInRootF1C5BW0() & 9223372034707292159L) != InlineClassHelperKt.UnspecifiedPackedFloats) {
            this.sourceCenterInRoot = Offset.m3842plusMKHz9U(m305getAnchorPositionInRootF1C5BW0(), m3847unboximpl);
            Function1<? super Density, Offset> function1 = this.magnifierCenter;
            if (function1 != null) {
                Offset m3826boximpl = Offset.m3826boximpl(function1.invoke(density).m3847unboximpl());
                if ((m3826boximpl.m3847unboximpl() & 9223372034707292159L) == InlineClassHelperKt.UnspecifiedPackedFloats) {
                    m3826boximpl = null;
                }
                if (m3826boximpl != null) {
                    m3852getUnspecifiedF1C5BW0 = Offset.m3842plusMKHz9U(m305getAnchorPositionInRootF1C5BW0(), m3826boximpl.m3847unboximpl());
                    long j = m3852getUnspecifiedF1C5BW0;
                    if (this.magnifier == null) {
                        recreateMagnifier();
                    }
                    platformMagnifier = this.magnifier;
                    if (platformMagnifier != null) {
                        platformMagnifier.mo338updateWko1d7g(this.sourceCenterInRoot, j, this.zoom);
                    }
                    updateSizeIfNecessary();
                    return;
                }
            }
            m3852getUnspecifiedF1C5BW0 = Offset.Companion.m3852getUnspecifiedF1C5BW0();
            long j2 = m3852getUnspecifiedF1C5BW0;
            if (this.magnifier == null) {
            }
            platformMagnifier = this.magnifier;
            if (platformMagnifier != null) {
            }
            updateSizeIfNecessary();
            return;
        }
        this.sourceCenterInRoot = Offset.Companion.m3852getUnspecifiedF1C5BW0();
        PlatformMagnifier platformMagnifier2 = this.magnifier;
        if (platformMagnifier2 != null) {
            platformMagnifier2.dismiss();
        }
    }

    private final void updateSizeIfNecessary() {
        Density density;
        PlatformMagnifier platformMagnifier = this.magnifier;
        if (platformMagnifier == null || (density = this.density) == null || IntSize.m6852equalsimpl(platformMagnifier.mo337getSizeYbymL2g(), this.previousSize)) {
            return;
        }
        Function1<? super DpSize, Unit> function1 = this.onSizeChanged;
        if (function1 != null) {
            function1.invoke(DpSize.m6770boximpl(density.mo387toDpSizekrfVVM(IntSizeKt.m6867toSizeozmzZPI(platformMagnifier.mo337getSizeYbymL2g()))));
        }
        this.previousSize = IntSize.m6847boximpl(platformMagnifier.mo337getSizeYbymL2g());
    }

    @Override // androidx.compose.ui.node.DrawModifierNode
    public void draw(ContentDrawScope contentDrawScope) {
        contentDrawScope.drawContent();
        Channel<Unit> channel = this.drawSignalChannel;
        if (channel != null) {
            ChannelResult.m9966boximpl(channel.mo7544trySendJP2dKIU(Unit.INSTANCE));
        }
    }

    @Override // androidx.compose.ui.node.GlobalPositionAwareModifierNode
    public void onGloballyPositioned(LayoutCoordinates layoutCoordinates) {
        setLayoutCoordinates(layoutCoordinates);
    }

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public void applySemantics(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        semanticsPropertyReceiver.set(Magnifier_androidKt.getMagnifierPositionInRoot(), new Function0<Offset>() { // from class: androidx.compose.foundation.MagnifierNode$applySemantics$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Offset invoke() {
                return Offset.m3826boximpl(m314invokeF1C5BW0());
            }

            /* renamed from: invoke-F1C5BW0  reason: not valid java name */
            public final long m314invokeF1C5BW0() {
                long j;
                j = MagnifierNode.this.sourceCenterInRoot;
                return j;
            }
        });
    }
}
