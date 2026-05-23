package androidx.compose.ui.node;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
/* compiled from: NodeKind.kt */
@Metadata(d1 = {"\u0000È\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R!\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0007\u0010\u0003\u001a\u0004\b\b\u0010\tR!\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00058Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0003\u001a\u0004\b\r\u0010\tR!\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00058Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u0003\u001a\u0004\b\u0011\u0010\tR!\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u00058Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u0003\u001a\u0004\b\u0015\u0010\tR!\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u00058Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0018\u0010\u0003\u001a\u0004\b\u0019\u0010\tR!\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00058Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u001c\u0010\u0003\u001a\u0004\b\u001d\u0010\tR!\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u00058Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b \u0010\u0003\u001a\u0004\b!\u0010\tR!\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\u00058Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b$\u0010\u0003\u001a\u0004\b%\u0010\tR!\u0010&\u001a\b\u0012\u0004\u0012\u00020'0\u00058Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b(\u0010\u0003\u001a\u0004\b)\u0010\tR!\u0010*\u001a\b\u0012\u0004\u0012\u00020+0\u00058Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b,\u0010\u0003\u001a\u0004\b-\u0010\tR!\u0010.\u001a\b\u0012\u0004\u0012\u00020/0\u00058Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b0\u0010\u0003\u001a\u0004\b1\u0010\tR!\u00102\u001a\b\u0012\u0004\u0012\u0002030\u00058Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b4\u0010\u0003\u001a\u0004\b5\u0010\tR!\u00106\u001a\b\u0012\u0004\u0012\u0002070\u00058Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b8\u0010\u0003\u001a\u0004\b9\u0010\tR!\u0010:\u001a\b\u0012\u0004\u0012\u00020;0\u00058Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b<\u0010\u0003\u001a\u0004\b=\u0010\tR!\u0010>\u001a\b\u0012\u0004\u0012\u00020?0\u00058Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b@\u0010\u0003\u001a\u0004\bA\u0010\tR!\u0010B\u001a\b\u0012\u0004\u0012\u00020C0\u00058Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\bD\u0010\u0003\u001a\u0004\bE\u0010\tR!\u0010F\u001a\b\u0012\u0004\u0012\u00020G0\u00058Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\bH\u0010\u0003\u001a\u0004\bI\u0010\tR!\u0010J\u001a\b\u0012\u0004\u0012\u00020K0\u00058Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\bL\u0010\u0003\u001a\u0004\bM\u0010\tR!\u0010N\u001a\b\u0012\u0004\u0012\u00020O0\u00058Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\bP\u0010\u0003\u001a\u0004\bQ\u0010\tR!\u0010R\u001a\b\u0012\u0004\u0012\u00020S0\u00058Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\bT\u0010\u0003\u001a\u0004\bU\u0010\tR!\u0010V\u001a\b\u0012\u0004\u0012\u00020W0\u00058Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\bX\u0010\u0003\u001a\u0004\bY\u0010\tR!\u0010Z\u001a\b\u0012\u0004\u0012\u00020[0\u00058Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\\\u0010\u0003\u001a\u0004\b]\u0010\tR!\u0010^\u001a\b\u0012\u0004\u0012\u00020_0\u00058Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b`\u0010\u0003\u001a\u0004\ba\u0010\t¨\u0006b"}, d2 = {"Landroidx/compose/ui/node/Nodes;", "", "<init>", "()V", "Any", "Landroidx/compose/ui/node/NodeKind;", "Landroidx/compose/ui/Modifier$Node;", "getAny-OLwlOKw$annotations", "getAny-OLwlOKw", "()I", "Layout", "Landroidx/compose/ui/node/LayoutModifierNode;", "getLayout-OLwlOKw$annotations", "getLayout-OLwlOKw", "Draw", "Landroidx/compose/ui/node/DrawModifierNode;", "getDraw-OLwlOKw$annotations", "getDraw-OLwlOKw", "Semantics", "Landroidx/compose/ui/node/SemanticsModifierNode;", "getSemantics-OLwlOKw$annotations", "getSemantics-OLwlOKw", "PointerInput", "Landroidx/compose/ui/node/PointerInputModifierNode;", "getPointerInput-OLwlOKw$annotations", "getPointerInput-OLwlOKw", "Locals", "Landroidx/compose/ui/modifier/ModifierLocalModifierNode;", "getLocals-OLwlOKw$annotations", "getLocals-OLwlOKw", "ParentData", "Landroidx/compose/ui/node/ParentDataModifierNode;", "getParentData-OLwlOKw$annotations", "getParentData-OLwlOKw", "OnRemeasured", "Landroidx/compose/ui/node/MeasuredSizeAwareModifierNode;", "getOnRemeasured-OLwlOKw$annotations", "getOnRemeasured-OLwlOKw", "GlobalPositionAware", "Landroidx/compose/ui/node/GlobalPositionAwareModifierNode;", "getGlobalPositionAware-OLwlOKw$annotations", "getGlobalPositionAware-OLwlOKw", "ApproachMeasure", "Landroidx/compose/ui/layout/ApproachLayoutModifierNode;", "getApproachMeasure-OLwlOKw$annotations", "getApproachMeasure-OLwlOKw", "FocusTarget", "Landroidx/compose/ui/focus/FocusTargetNode;", "getFocusTarget-OLwlOKw$annotations", "getFocusTarget-OLwlOKw", "FocusProperties", "Landroidx/compose/ui/focus/FocusPropertiesModifierNode;", "getFocusProperties-OLwlOKw$annotations", "getFocusProperties-OLwlOKw", "FocusEvent", "Landroidx/compose/ui/focus/FocusEventModifierNode;", "getFocusEvent-OLwlOKw$annotations", "getFocusEvent-OLwlOKw", "KeyInput", "Landroidx/compose/ui/input/key/KeyInputModifierNode;", "getKeyInput-OLwlOKw$annotations", "getKeyInput-OLwlOKw", "RotaryInput", "Landroidx/compose/ui/input/rotary/RotaryInputModifierNode;", "getRotaryInput-OLwlOKw$annotations", "getRotaryInput-OLwlOKw", "CompositionLocalConsumer", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "getCompositionLocalConsumer-OLwlOKw$annotations", "getCompositionLocalConsumer-OLwlOKw", "SoftKeyboardKeyInput", "Landroidx/compose/ui/input/key/SoftKeyboardInterceptionModifierNode;", "getSoftKeyboardKeyInput-OLwlOKw$annotations", "getSoftKeyboardKeyInput-OLwlOKw", "Traversable", "Landroidx/compose/ui/node/TraversableNode;", "getTraversable-OLwlOKw$annotations", "getTraversable-OLwlOKw", "BringIntoView", "Landroidx/compose/ui/relocation/BringIntoViewModifierNode;", "getBringIntoView-OLwlOKw$annotations", "getBringIntoView-OLwlOKw", "Unplaced", "Landroidx/compose/ui/node/UnplacedAwareModifierNode;", "getUnplaced-OLwlOKw$annotations", "getUnplaced-OLwlOKw", "IndirectPointerInput", "Landroidx/compose/ui/input/indirect/IndirectPointerInputModifierNode;", "getIndirectPointerInput-OLwlOKw$annotations", "getIndirectPointerInput-OLwlOKw", "OnPlaced", "Landroidx/compose/ui/node/LayoutAwareModifierNode;", "getOnPlaced-OLwlOKw$annotations", "getOnPlaced-OLwlOKw", "BeyondBoundsLayout", "Landroidx/compose/ui/layout/BeyondBoundsLayoutProviderModifierNode;", "getBeyondBoundsLayout-OLwlOKw$annotations", "getBeyondBoundsLayout-OLwlOKw", "ui"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class Nodes {
    public static final int $stable = 0;
    public static final Nodes INSTANCE = new Nodes();

    @JvmStatic
    /* renamed from: getAny-OLwlOKw$annotations  reason: not valid java name */
    public static /* synthetic */ void m7147getAnyOLwlOKw$annotations() {
    }

    @JvmStatic
    /* renamed from: getApproachMeasure-OLwlOKw$annotations  reason: not valid java name */
    public static /* synthetic */ void m7149getApproachMeasureOLwlOKw$annotations() {
    }

    @JvmStatic
    /* renamed from: getBeyondBoundsLayout-OLwlOKw$annotations  reason: not valid java name */
    public static /* synthetic */ void m7151getBeyondBoundsLayoutOLwlOKw$annotations() {
    }

    @JvmStatic
    /* renamed from: getBringIntoView-OLwlOKw$annotations  reason: not valid java name */
    public static /* synthetic */ void m7153getBringIntoViewOLwlOKw$annotations() {
    }

    @JvmStatic
    /* renamed from: getCompositionLocalConsumer-OLwlOKw$annotations  reason: not valid java name */
    public static /* synthetic */ void m7155getCompositionLocalConsumerOLwlOKw$annotations() {
    }

    @JvmStatic
    /* renamed from: getDraw-OLwlOKw$annotations  reason: not valid java name */
    public static /* synthetic */ void m7157getDrawOLwlOKw$annotations() {
    }

    @JvmStatic
    /* renamed from: getFocusEvent-OLwlOKw$annotations  reason: not valid java name */
    public static /* synthetic */ void m7159getFocusEventOLwlOKw$annotations() {
    }

    @JvmStatic
    /* renamed from: getFocusProperties-OLwlOKw$annotations  reason: not valid java name */
    public static /* synthetic */ void m7161getFocusPropertiesOLwlOKw$annotations() {
    }

    @JvmStatic
    /* renamed from: getFocusTarget-OLwlOKw$annotations  reason: not valid java name */
    public static /* synthetic */ void m7163getFocusTargetOLwlOKw$annotations() {
    }

    @JvmStatic
    /* renamed from: getGlobalPositionAware-OLwlOKw$annotations  reason: not valid java name */
    public static /* synthetic */ void m7165getGlobalPositionAwareOLwlOKw$annotations() {
    }

    @JvmStatic
    /* renamed from: getIndirectPointerInput-OLwlOKw$annotations  reason: not valid java name */
    public static /* synthetic */ void m7167getIndirectPointerInputOLwlOKw$annotations() {
    }

    @JvmStatic
    /* renamed from: getKeyInput-OLwlOKw$annotations  reason: not valid java name */
    public static /* synthetic */ void m7169getKeyInputOLwlOKw$annotations() {
    }

    @JvmStatic
    /* renamed from: getLayout-OLwlOKw$annotations  reason: not valid java name */
    public static /* synthetic */ void m7171getLayoutOLwlOKw$annotations() {
    }

    @JvmStatic
    /* renamed from: getLocals-OLwlOKw$annotations  reason: not valid java name */
    public static /* synthetic */ void m7173getLocalsOLwlOKw$annotations() {
    }

    @JvmStatic
    /* renamed from: getOnPlaced-OLwlOKw$annotations  reason: not valid java name */
    public static /* synthetic */ void m7175getOnPlacedOLwlOKw$annotations() {
    }

    @JvmStatic
    /* renamed from: getOnRemeasured-OLwlOKw$annotations  reason: not valid java name */
    public static /* synthetic */ void m7177getOnRemeasuredOLwlOKw$annotations() {
    }

    @JvmStatic
    /* renamed from: getParentData-OLwlOKw$annotations  reason: not valid java name */
    public static /* synthetic */ void m7179getParentDataOLwlOKw$annotations() {
    }

    @JvmStatic
    /* renamed from: getPointerInput-OLwlOKw$annotations  reason: not valid java name */
    public static /* synthetic */ void m7181getPointerInputOLwlOKw$annotations() {
    }

    @JvmStatic
    /* renamed from: getRotaryInput-OLwlOKw$annotations  reason: not valid java name */
    public static /* synthetic */ void m7183getRotaryInputOLwlOKw$annotations() {
    }

    @JvmStatic
    /* renamed from: getSemantics-OLwlOKw$annotations  reason: not valid java name */
    public static /* synthetic */ void m7185getSemanticsOLwlOKw$annotations() {
    }

    @JvmStatic
    /* renamed from: getSoftKeyboardKeyInput-OLwlOKw$annotations  reason: not valid java name */
    public static /* synthetic */ void m7187getSoftKeyboardKeyInputOLwlOKw$annotations() {
    }

    @JvmStatic
    /* renamed from: getTraversable-OLwlOKw$annotations  reason: not valid java name */
    public static /* synthetic */ void m7189getTraversableOLwlOKw$annotations() {
    }

    @JvmStatic
    /* renamed from: getUnplaced-OLwlOKw$annotations  reason: not valid java name */
    public static /* synthetic */ void m7191getUnplacedOLwlOKw$annotations() {
    }

    private Nodes() {
    }

    /* renamed from: getAny-OLwlOKw  reason: not valid java name */
    public static final int m7146getAnyOLwlOKw() {
        return NodeKind.m7135constructorimpl(1);
    }

    /* renamed from: getLayout-OLwlOKw  reason: not valid java name */
    public static final int m7170getLayoutOLwlOKw() {
        return NodeKind.m7135constructorimpl(2);
    }

    /* renamed from: getDraw-OLwlOKw  reason: not valid java name */
    public static final int m7156getDrawOLwlOKw() {
        return NodeKind.m7135constructorimpl(4);
    }

    /* renamed from: getSemantics-OLwlOKw  reason: not valid java name */
    public static final int m7184getSemanticsOLwlOKw() {
        return NodeKind.m7135constructorimpl(8);
    }

    /* renamed from: getPointerInput-OLwlOKw  reason: not valid java name */
    public static final int m7180getPointerInputOLwlOKw() {
        return NodeKind.m7135constructorimpl(16);
    }

    /* renamed from: getLocals-OLwlOKw  reason: not valid java name */
    public static final int m7172getLocalsOLwlOKw() {
        return NodeKind.m7135constructorimpl(32);
    }

    /* renamed from: getParentData-OLwlOKw  reason: not valid java name */
    public static final int m7178getParentDataOLwlOKw() {
        return NodeKind.m7135constructorimpl(64);
    }

    /* renamed from: getOnRemeasured-OLwlOKw  reason: not valid java name */
    public static final int m7176getOnRemeasuredOLwlOKw() {
        return NodeKind.m7135constructorimpl(128);
    }

    /* renamed from: getGlobalPositionAware-OLwlOKw  reason: not valid java name */
    public static final int m7164getGlobalPositionAwareOLwlOKw() {
        return NodeKind.m7135constructorimpl(256);
    }

    /* renamed from: getApproachMeasure-OLwlOKw  reason: not valid java name */
    public static final int m7148getApproachMeasureOLwlOKw() {
        return NodeKind.m7135constructorimpl(512);
    }

    /* renamed from: getFocusTarget-OLwlOKw  reason: not valid java name */
    public static final int m7162getFocusTargetOLwlOKw() {
        return NodeKind.m7135constructorimpl(1024);
    }

    /* renamed from: getFocusProperties-OLwlOKw  reason: not valid java name */
    public static final int m7160getFocusPropertiesOLwlOKw() {
        return NodeKind.m7135constructorimpl(2048);
    }

    /* renamed from: getFocusEvent-OLwlOKw  reason: not valid java name */
    public static final int m7158getFocusEventOLwlOKw() {
        return NodeKind.m7135constructorimpl(4096);
    }

    /* renamed from: getKeyInput-OLwlOKw  reason: not valid java name */
    public static final int m7168getKeyInputOLwlOKw() {
        return NodeKind.m7135constructorimpl(8192);
    }

    /* renamed from: getRotaryInput-OLwlOKw  reason: not valid java name */
    public static final int m7182getRotaryInputOLwlOKw() {
        return NodeKind.m7135constructorimpl(16384);
    }

    /* renamed from: getCompositionLocalConsumer-OLwlOKw  reason: not valid java name */
    public static final int m7154getCompositionLocalConsumerOLwlOKw() {
        return NodeKind.m7135constructorimpl(32768);
    }

    /* renamed from: getSoftKeyboardKeyInput-OLwlOKw  reason: not valid java name */
    public static final int m7186getSoftKeyboardKeyInputOLwlOKw() {
        return NodeKind.m7135constructorimpl(131072);
    }

    /* renamed from: getTraversable-OLwlOKw  reason: not valid java name */
    public static final int m7188getTraversableOLwlOKw() {
        return NodeKind.m7135constructorimpl(262144);
    }

    /* renamed from: getBringIntoView-OLwlOKw  reason: not valid java name */
    public static final int m7152getBringIntoViewOLwlOKw() {
        return NodeKind.m7135constructorimpl(524288);
    }

    /* renamed from: getUnplaced-OLwlOKw  reason: not valid java name */
    public static final int m7190getUnplacedOLwlOKw() {
        return NodeKind.m7135constructorimpl(1048576);
    }

    /* renamed from: getIndirectPointerInput-OLwlOKw  reason: not valid java name */
    public static final int m7166getIndirectPointerInputOLwlOKw() {
        return NodeKind.m7135constructorimpl(2097152);
    }

    /* renamed from: getOnPlaced-OLwlOKw  reason: not valid java name */
    public static final int m7174getOnPlacedOLwlOKw() {
        return NodeKind.m7135constructorimpl(4194304);
    }

    /* renamed from: getBeyondBoundsLayout-OLwlOKw  reason: not valid java name */
    public static final int m7150getBeyondBoundsLayoutOLwlOKw() {
        return NodeKind.m7135constructorimpl(8388608);
    }
}
