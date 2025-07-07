package androidx.constraintlayout.compose;

import androidx.compose.foundation.layout.LayoutScopeMarker;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.compose.ConstraintLayoutBaseScope;
import androidx.constraintlayout.core.parser.CLArray;
import androidx.constraintlayout.core.parser.CLNumber;
import androidx.constraintlayout.core.parser.CLObject;
import androidx.constraintlayout.core.parser.CLString;
import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ObservableProperty;
import kotlin.reflect.KProperty;
/* compiled from: ConstrainScope.kt */
@LayoutScopeMarker
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b$\b\u0007\u0018\u00002\u00020\u0001:\u0006\u009c\u0001\u009d\u0001\u009e\u0001B\u0017\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u000e\u0010w\u001a\u00020x2\u0006\u0010y\u001a\u00020zJ\u000e\u0010w\u001a\u00020x2\u0006\u0010y\u001a\u00020{J\u0018\u0010|\u001a\u00020x2\u0006\u0010}\u001a\u0002032\b\b\u0003\u0010~\u001a\u00020\rJ\u000e\u0010\u007f\u001a\u00020x2\u0006\u0010}\u001a\u000203J\u0019\u0010\u0080\u0001\u001a\u00020x2\u0006\u0010}\u001a\u0002032\b\b\u0003\u0010~\u001a\u00020\rJ-\u0010\u0081\u0001\u001a\u00020x2\u0006\u0010}\u001a\u0002032\u0007\u0010\u0082\u0001\u001a\u00020\r2\u0007\u0010\u0083\u0001\u001a\u00020Vø\u0001\u0000¢\u0006\u0006\b\u0084\u0001\u0010\u0085\u0001J\u0007\u0010\u0086\u0001\u001a\u00020xJ\u0007\u0010\u0087\u0001\u001a\u00020xJ\u0007\u0010\u0088\u0001\u001a\u00020xJY\u0010\u0089\u0001\u001a\u00020x2\u0006\u0010T\u001a\u00020z2\u0006\u0010\u0017\u001a\u00020z2\t\b\u0002\u0010\u008a\u0001\u001a\u00020V2\t\b\u0002\u0010\u008b\u0001\u001a\u00020V2\t\b\u0002\u0010\u008c\u0001\u001a\u00020V2\t\b\u0002\u0010\u008d\u0001\u001a\u00020V2\b\b\u0003\u0010~\u001a\u00020\rø\u0001\u0000¢\u0006\u0006\b\u008e\u0001\u0010\u008f\u0001J\u009f\u0001\u0010\u0089\u0001\u001a\u00020x2\u0006\u0010R\u001a\u00020{2\u0006\u0010T\u001a\u00020z2\u0006\u0010\u001d\u001a\u00020{2\u0006\u0010\u0017\u001a\u00020z2\t\b\u0002\u0010\u0090\u0001\u001a\u00020V2\t\b\u0002\u0010\u008a\u0001\u001a\u00020V2\t\b\u0002\u0010\u0091\u0001\u001a\u00020V2\t\b\u0002\u0010\u008b\u0001\u001a\u00020V2\t\b\u0002\u0010\u0092\u0001\u001a\u00020V2\t\b\u0002\u0010\u008c\u0001\u001a\u00020V2\t\b\u0002\u0010\u0093\u0001\u001a\u00020V2\t\b\u0002\u0010\u008d\u0001\u001a\u00020V2\b\b\u0003\u0010(\u001a\u00020\r2\b\b\u0003\u0010d\u001a\u00020\rø\u0001\u0000¢\u0006\u0006\b\u0094\u0001\u0010\u0095\u0001JY\u0010\u0089\u0001\u001a\u00020x2\u0006\u0010R\u001a\u00020{2\u0006\u0010\u001d\u001a\u00020{2\t\b\u0002\u0010\u0090\u0001\u001a\u00020V2\t\b\u0002\u0010\u0091\u0001\u001a\u00020V2\t\b\u0002\u0010\u0092\u0001\u001a\u00020V2\t\b\u0002\u0010\u0093\u0001\u001a\u00020V2\b\b\u0003\u0010~\u001a\u00020\rø\u0001\u0000¢\u0006\u0006\b\u008e\u0001\u0010\u0096\u0001J\u0007\u0010\u0097\u0001\u001a\u00020xJ\u0007\u0010\u0098\u0001\u001a\u00020xJ\u0017\u0010\u0099\u0001\u001a\u00020 *\u00020Vø\u0001\u0000¢\u0006\u0006\b\u009a\u0001\u0010\u009b\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR&\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r8\u0006@FX\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u0003\u001a\u00020\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u001d\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\tR+\u0010!\u001a\u00020 2\u0006\u0010\u001f\u001a\u00020 8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R&\u0010(\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r8\u0006@FX\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0010\"\u0004\b*\u0010\u0012R+\u0010+\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\r8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b,\u0010\u0010\"\u0004\b-\u0010\u0012R\u0014\u0010\u0002\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0011\u00102\u001a\u000203¢\u0006\b\n\u0000\u001a\u0004\b4\u00105R+\u00106\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\r8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b9\u0010/\u001a\u0004\b7\u0010\u0010\"\u0004\b8\u0010\u0012R+\u0010:\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\r8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b=\u0010/\u001a\u0004\b;\u0010\u0010\"\u0004\b<\u0010\u0012R+\u0010>\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\r8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bA\u0010/\u001a\u0004\b?\u0010\u0010\"\u0004\b@\u0010\u0012R+\u0010B\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\r8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bE\u0010/\u001a\u0004\bC\u0010\u0010\"\u0004\bD\u0010\u0012R+\u0010F\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\r8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bI\u0010/\u001a\u0004\bG\u0010\u0010\"\u0004\bH\u0010\u0012R+\u0010J\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\r8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bM\u0010/\u001a\u0004\bK\u0010\u0010\"\u0004\bL\u0010\u0012R+\u0010N\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\r8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bQ\u0010/\u001a\u0004\bO\u0010\u0010\"\u0004\bP\u0010\u0012R\u0011\u0010R\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\bS\u0010\tR\u0011\u0010T\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\bU\u0010\u001aR1\u0010W\u001a\u00020V2\u0006\u0010\u001f\u001a\u00020V8F@FX\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\bZ\u0010[\u001a\u0004\bX\u0010\u0010\"\u0004\bY\u0010\u0012R1\u0010\\\u001a\u00020V2\u0006\u0010\u001f\u001a\u00020V8F@FX\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b_\u0010[\u001a\u0004\b]\u0010\u0010\"\u0004\b^\u0010\u0012R1\u0010`\u001a\u00020V2\u0006\u0010\u001f\u001a\u00020V8F@FX\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\bc\u0010[\u001a\u0004\ba\u0010\u0010\"\u0004\bb\u0010\u0012R&\u0010d\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r8\u0006@FX\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\be\u0010\u0010\"\u0004\bf\u0010\u0012R+\u0010g\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\r8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bj\u0010/\u001a\u0004\bh\u0010\u0010\"\u0004\bi\u0010\u0012R+\u0010l\u001a\u00020k2\u0006\u0010\u001f\u001a\u00020k8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bq\u0010r\u001a\u0004\bm\u0010n\"\u0004\bo\u0010pR+\u0010s\u001a\u00020 2\u0006\u0010\u001f\u001a\u00020 8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bv\u0010'\u001a\u0004\bt\u0010#\"\u0004\bu\u0010%\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u009f\u0001"}, d2 = {"Landroidx/constraintlayout/compose/ConstrainScope;", "", "id", "containerObject", "Landroidx/constraintlayout/core/parser/CLObject;", "(Ljava/lang/Object;Landroidx/constraintlayout/core/parser/CLObject;)V", "absoluteLeft", "Landroidx/constraintlayout/compose/VerticalAnchorable;", "getAbsoluteLeft", "()Landroidx/constraintlayout/compose/VerticalAnchorable;", "absoluteRight", "getAbsoluteRight", "value", "", "alpha", "getAlpha", "()F", "setAlpha", "(F)V", "baseline", "Landroidx/constraintlayout/compose/BaselineAnchorable;", "getBaseline", "()Landroidx/constraintlayout/compose/BaselineAnchorable;", "bottom", "Landroidx/constraintlayout/compose/HorizontalAnchorable;", "getBottom", "()Landroidx/constraintlayout/compose/HorizontalAnchorable;", "getContainerObject$constraintlayout_compose_release", "()Landroidx/constraintlayout/core/parser/CLObject;", TtmlNode.END, "getEnd", "<set-?>", "Landroidx/constraintlayout/compose/Dimension;", "height", "getHeight", "()Landroidx/constraintlayout/compose/Dimension;", "setHeight", "(Landroidx/constraintlayout/compose/Dimension;)V", "height$delegate", "Landroidx/constraintlayout/compose/ConstrainScope$DimensionProperty;", "horizontalBias", "getHorizontalBias", "setHorizontalBias", "horizontalChainWeight", "getHorizontalChainWeight", "setHorizontalChainWeight", "horizontalChainWeight$delegate", "Landroidx/constraintlayout/compose/ConstrainScope$FloatProperty;", "getId$constraintlayout_compose_release", "()Ljava/lang/Object;", "parent", "Landroidx/constraintlayout/compose/ConstrainedLayoutReference;", "getParent", "()Landroidx/constraintlayout/compose/ConstrainedLayoutReference;", "pivotX", "getPivotX", "setPivotX", "pivotX$delegate", "pivotY", "getPivotY", "setPivotY", "pivotY$delegate", "rotationX", "getRotationX", "setRotationX", "rotationX$delegate", "rotationY", "getRotationY", "setRotationY", "rotationY$delegate", "rotationZ", "getRotationZ", "setRotationZ", "rotationZ$delegate", "scaleX", "getScaleX", "setScaleX", "scaleX$delegate", "scaleY", "getScaleY", "setScaleY", "scaleY$delegate", TtmlNode.START, "getStart", "top", "getTop", "Landroidx/compose/ui/unit/Dp;", "translationX", "getTranslationX-D9Ej5fM", "setTranslationX-0680j_4", "translationX$delegate", "Landroidx/constraintlayout/compose/ConstrainScope$DpProperty;", "translationY", "getTranslationY-D9Ej5fM", "setTranslationY-0680j_4", "translationY$delegate", "translationZ", "getTranslationZ-D9Ej5fM", "setTranslationZ-0680j_4", "translationZ$delegate", "verticalBias", "getVerticalBias", "setVerticalBias", "verticalChainWeight", "getVerticalChainWeight", "setVerticalChainWeight", "verticalChainWeight$delegate", "Landroidx/constraintlayout/compose/Visibility;", "visibility", "getVisibility", "()Landroidx/constraintlayout/compose/Visibility;", "setVisibility", "(Landroidx/constraintlayout/compose/Visibility;)V", "visibility$delegate", "Landroidx/constraintlayout/compose/ConstrainScope$visibility$2;", "width", "getWidth", "setWidth", "width$delegate", "centerAround", "", "anchor", "Landroidx/constraintlayout/compose/ConstraintLayoutBaseScope$HorizontalAnchor;", "Landroidx/constraintlayout/compose/ConstraintLayoutBaseScope$VerticalAnchor;", "centerHorizontallyTo", "other", "bias", "centerTo", "centerVerticallyTo", "circular", "angle", "distance", "circular-wH6b6FI", "(Landroidx/constraintlayout/compose/ConstrainedLayoutReference;FF)V", "clearConstraints", "clearHorizontal", "clearVertical", "linkTo", "topMargin", "bottomMargin", "topGoneMargin", "bottomGoneMargin", "linkTo-8ZKsbrE", "(Landroidx/constraintlayout/compose/ConstraintLayoutBaseScope$HorizontalAnchor;Landroidx/constraintlayout/compose/ConstraintLayoutBaseScope$HorizontalAnchor;FFFFF)V", "startMargin", "endMargin", "startGoneMargin", "endGoneMargin", "linkTo-R7zmacU", "(Landroidx/constraintlayout/compose/ConstraintLayoutBaseScope$VerticalAnchor;Landroidx/constraintlayout/compose/ConstraintLayoutBaseScope$HorizontalAnchor;Landroidx/constraintlayout/compose/ConstraintLayoutBaseScope$VerticalAnchor;Landroidx/constraintlayout/compose/ConstraintLayoutBaseScope$HorizontalAnchor;FFFFFFFFFF)V", "(Landroidx/constraintlayout/compose/ConstraintLayoutBaseScope$VerticalAnchor;Landroidx/constraintlayout/compose/ConstraintLayoutBaseScope$VerticalAnchor;FFFFF)V", "resetDimensions", "resetTransforms", "asDimension", "asDimension-0680j_4", "(F)Landroidx/constraintlayout/compose/Dimension;", "DimensionProperty", "DpProperty", "FloatProperty", "constraintlayout-compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ConstrainScope {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(ConstrainScope.class, "width", "getWidth()Landroidx/constraintlayout/compose/Dimension;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(ConstrainScope.class, "height", "getHeight()Landroidx/constraintlayout/compose/Dimension;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(ConstrainScope.class, "visibility", "getVisibility()Landroidx/constraintlayout/compose/Visibility;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(ConstrainScope.class, "scaleX", "getScaleX()F", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(ConstrainScope.class, "scaleY", "getScaleY()F", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(ConstrainScope.class, "rotationX", "getRotationX()F", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(ConstrainScope.class, "rotationY", "getRotationY()F", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(ConstrainScope.class, "rotationZ", "getRotationZ()F", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(ConstrainScope.class, "translationX", "getTranslationX-D9Ej5fM()F", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(ConstrainScope.class, "translationY", "getTranslationY-D9Ej5fM()F", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(ConstrainScope.class, "translationZ", "getTranslationZ-D9Ej5fM()F", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(ConstrainScope.class, "pivotX", "getPivotX()F", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(ConstrainScope.class, "pivotY", "getPivotY()F", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(ConstrainScope.class, "horizontalChainWeight", "getHorizontalChainWeight()F", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(ConstrainScope.class, "verticalChainWeight", "getVerticalChainWeight()F", 0))};
    public static final int $stable = 0;
    private final VerticalAnchorable absoluteLeft;
    private final VerticalAnchorable absoluteRight;
    private float alpha;
    private final BaselineAnchorable baseline;
    private final HorizontalAnchorable bottom;
    private final CLObject containerObject;
    private final VerticalAnchorable end;
    private float horizontalBias;
    private final FloatProperty horizontalChainWeight$delegate;
    private final Object id;
    private final FloatProperty pivotX$delegate;
    private final FloatProperty pivotY$delegate;
    private final FloatProperty rotationX$delegate;
    private final FloatProperty rotationY$delegate;
    private final FloatProperty rotationZ$delegate;
    private final FloatProperty scaleX$delegate;
    private final FloatProperty scaleY$delegate;
    private final VerticalAnchorable start;
    private final HorizontalAnchorable top;
    private final DpProperty translationX$delegate;
    private final DpProperty translationY$delegate;
    private final DpProperty translationZ$delegate;
    private float verticalBias;
    private final FloatProperty verticalChainWeight$delegate;
    private final ConstrainScope$visibility$2 visibility$delegate;
    private final ConstrainedLayoutReference parent = new ConstrainedLayoutReference("parent");
    private final DimensionProperty width$delegate = new DimensionProperty(Dimension.Companion.getWrapContent());
    private final DimensionProperty height$delegate = new DimensionProperty(Dimension.Companion.getWrapContent());

    /* JADX WARN: Type inference failed for: r15v5, types: [androidx.constraintlayout.compose.ConstrainScope$visibility$2] */
    public ConstrainScope(Object obj, CLObject cLObject) {
        this.id = obj;
        this.containerObject = cLObject;
        this.start = new ConstraintVerticalAnchorable(-2, cLObject);
        this.absoluteLeft = new ConstraintVerticalAnchorable(0, cLObject);
        this.top = new ConstraintHorizontalAnchorable(0, cLObject);
        this.end = new ConstraintVerticalAnchorable(-1, cLObject);
        this.absoluteRight = new ConstraintVerticalAnchorable(1, cLObject);
        this.bottom = new ConstraintHorizontalAnchorable(1, cLObject);
        this.baseline = new ConstraintBaselineAnchorable(cLObject);
        final Visibility visible = Visibility.Companion.getVisible();
        this.visibility$delegate = new ObservableProperty<Visibility>(visible) { // from class: androidx.constraintlayout.compose.ConstrainScope$visibility$2
            @Override // kotlin.properties.ObservableProperty
            public /* bridge */ /* synthetic */ void afterChange(KProperty kProperty, Visibility visibility, Visibility visibility2) {
                afterChange2((KProperty<?>) kProperty, visibility, visibility2);
            }

            /* renamed from: afterChange  reason: avoid collision after fix types in other method */
            protected void afterChange2(KProperty<?> kProperty, Visibility visibility, Visibility visibility2) {
                ConstrainScope.this.getContainerObject$constraintlayout_compose_release().putString(kProperty.getName(), visibility2.getName$constraintlayout_compose_release());
            }
        };
        this.alpha = 1.0f;
        this.scaleX$delegate = new FloatProperty(this, 1.0f, null, 2, null);
        this.scaleY$delegate = new FloatProperty(this, 1.0f, null, 2, null);
        this.rotationX$delegate = new FloatProperty(this, 0.0f, null, 2, null);
        this.rotationY$delegate = new FloatProperty(this, 0.0f, null, 2, null);
        this.rotationZ$delegate = new FloatProperty(this, 0.0f, null, 2, null);
        float f = 0;
        this.translationX$delegate = new DpProperty(this, Dp.m6684constructorimpl(f), null, 2, null);
        this.translationY$delegate = new DpProperty(this, Dp.m6684constructorimpl(f), null, 2, null);
        this.translationZ$delegate = new DpProperty(this, Dp.m6684constructorimpl(f), null, 2, null);
        this.pivotX$delegate = new FloatProperty(this, 0.5f, null, 2, null);
        this.pivotY$delegate = new FloatProperty(this, 0.5f, null, 2, null);
        this.horizontalChainWeight$delegate = new FloatProperty(Float.NaN, "hWeight");
        this.verticalChainWeight$delegate = new FloatProperty(Float.NaN, "vWeight");
        this.horizontalBias = 0.5f;
        this.verticalBias = 0.5f;
    }

    public final CLObject getContainerObject$constraintlayout_compose_release() {
        return this.containerObject;
    }

    public final Object getId$constraintlayout_compose_release() {
        return this.id;
    }

    public final ConstrainedLayoutReference getParent() {
        return this.parent;
    }

    public final VerticalAnchorable getStart() {
        return this.start;
    }

    public final VerticalAnchorable getAbsoluteLeft() {
        return this.absoluteLeft;
    }

    public final HorizontalAnchorable getTop() {
        return this.top;
    }

    public final VerticalAnchorable getEnd() {
        return this.end;
    }

    public final VerticalAnchorable getAbsoluteRight() {
        return this.absoluteRight;
    }

    public final HorizontalAnchorable getBottom() {
        return this.bottom;
    }

    public final BaselineAnchorable getBaseline() {
        return this.baseline;
    }

    public final Dimension getWidth() {
        return this.width$delegate.getValue(this, $$delegatedProperties[0]);
    }

    public final void setWidth(Dimension dimension) {
        this.width$delegate.setValue(this, $$delegatedProperties[0], dimension);
    }

    public final Dimension getHeight() {
        return this.height$delegate.getValue(this, $$delegatedProperties[1]);
    }

    public final void setHeight(Dimension dimension) {
        this.height$delegate.setValue(this, $$delegatedProperties[1], dimension);
    }

    public final Visibility getVisibility() {
        return getValue(this, $$delegatedProperties[2]);
    }

    public final void setVisibility(Visibility visibility) {
        setValue(this, $$delegatedProperties[2], visibility);
    }

    public final float getAlpha() {
        return this.alpha;
    }

    public final void setAlpha(float f) {
        this.alpha = f;
        if (Float.isNaN(f)) {
            return;
        }
        this.containerObject.putNumber("alpha", f);
    }

    public final float getScaleX() {
        return this.scaleX$delegate.getValue(this, $$delegatedProperties[3]).floatValue();
    }

    public final void setScaleX(float f) {
        this.scaleX$delegate.setValue(this, $$delegatedProperties[3], Float.valueOf(f));
    }

    public final float getScaleY() {
        return this.scaleY$delegate.getValue(this, $$delegatedProperties[4]).floatValue();
    }

    public final void setScaleY(float f) {
        this.scaleY$delegate.setValue(this, $$delegatedProperties[4], Float.valueOf(f));
    }

    public final float getRotationX() {
        return this.rotationX$delegate.getValue(this, $$delegatedProperties[5]).floatValue();
    }

    public final void setRotationX(float f) {
        this.rotationX$delegate.setValue(this, $$delegatedProperties[5], Float.valueOf(f));
    }

    public final float getRotationY() {
        return this.rotationY$delegate.getValue(this, $$delegatedProperties[6]).floatValue();
    }

    public final void setRotationY(float f) {
        this.rotationY$delegate.setValue(this, $$delegatedProperties[6], Float.valueOf(f));
    }

    public final float getRotationZ() {
        return this.rotationZ$delegate.getValue(this, $$delegatedProperties[7]).floatValue();
    }

    public final void setRotationZ(float f) {
        this.rotationZ$delegate.setValue(this, $$delegatedProperties[7], Float.valueOf(f));
    }

    /* renamed from: getTranslationX-D9Ej5fM  reason: not valid java name */
    public final float m6964getTranslationXD9Ej5fM() {
        return this.translationX$delegate.getValue(this, $$delegatedProperties[8]).m6698unboximpl();
    }

    /* renamed from: setTranslationX-0680j_4  reason: not valid java name */
    public final void m6970setTranslationX0680j_4(float f) {
        this.translationX$delegate.setValue(this, $$delegatedProperties[8], Dp.m6682boximpl(f));
    }

    /* renamed from: getTranslationY-D9Ej5fM  reason: not valid java name */
    public final float m6965getTranslationYD9Ej5fM() {
        return this.translationY$delegate.getValue(this, $$delegatedProperties[9]).m6698unboximpl();
    }

    /* renamed from: setTranslationY-0680j_4  reason: not valid java name */
    public final void m6971setTranslationY0680j_4(float f) {
        this.translationY$delegate.setValue(this, $$delegatedProperties[9], Dp.m6682boximpl(f));
    }

    /* renamed from: getTranslationZ-D9Ej5fM  reason: not valid java name */
    public final float m6966getTranslationZD9Ej5fM() {
        return this.translationZ$delegate.getValue(this, $$delegatedProperties[10]).m6698unboximpl();
    }

    /* renamed from: setTranslationZ-0680j_4  reason: not valid java name */
    public final void m6972setTranslationZ0680j_4(float f) {
        this.translationZ$delegate.setValue(this, $$delegatedProperties[10], Dp.m6682boximpl(f));
    }

    public final float getPivotX() {
        return this.pivotX$delegate.getValue(this, $$delegatedProperties[11]).floatValue();
    }

    public final void setPivotX(float f) {
        this.pivotX$delegate.setValue(this, $$delegatedProperties[11], Float.valueOf(f));
    }

    public final float getPivotY() {
        return this.pivotY$delegate.getValue(this, $$delegatedProperties[12]).floatValue();
    }

    public final void setPivotY(float f) {
        this.pivotY$delegate.setValue(this, $$delegatedProperties[12], Float.valueOf(f));
    }

    public final float getHorizontalChainWeight() {
        return this.horizontalChainWeight$delegate.getValue(this, $$delegatedProperties[13]).floatValue();
    }

    public final void setHorizontalChainWeight(float f) {
        this.horizontalChainWeight$delegate.setValue(this, $$delegatedProperties[13], Float.valueOf(f));
    }

    public final float getVerticalChainWeight() {
        return this.verticalChainWeight$delegate.getValue(this, $$delegatedProperties[14]).floatValue();
    }

    public final void setVerticalChainWeight(float f) {
        this.verticalChainWeight$delegate.setValue(this, $$delegatedProperties[14], Float.valueOf(f));
    }

    public final float getHorizontalBias() {
        return this.horizontalBias;
    }

    public final void setHorizontalBias(float f) {
        this.horizontalBias = f;
        if (Float.isNaN(f)) {
            return;
        }
        this.containerObject.putNumber("hBias", f);
    }

    public final float getVerticalBias() {
        return this.verticalBias;
    }

    public final void setVerticalBias(float f) {
        this.verticalBias = f;
        if (Float.isNaN(f)) {
            return;
        }
        this.containerObject.putNumber("vBias", f);
    }

    /* renamed from: linkTo-8ZKsbrE  reason: not valid java name */
    public final void m6968linkTo8ZKsbrE(ConstraintLayoutBaseScope.VerticalAnchor verticalAnchor, ConstraintLayoutBaseScope.VerticalAnchor verticalAnchor2, float f, float f2, float f3, float f4, float f5) {
        this.start.mo6944linkToVpY3zN4(verticalAnchor, f, f3);
        this.end.mo6944linkToVpY3zN4(verticalAnchor2, f2, f4);
        this.containerObject.putNumber("hRtlBias", f5);
    }

    /* renamed from: linkTo-8ZKsbrE  reason: not valid java name */
    public final void m6967linkTo8ZKsbrE(ConstraintLayoutBaseScope.HorizontalAnchor horizontalAnchor, ConstraintLayoutBaseScope.HorizontalAnchor horizontalAnchor2, float f, float f2, float f3, float f4, float f5) {
        this.top.mo6943linkToVpY3zN4(horizontalAnchor, f, f3);
        this.bottom.mo6943linkToVpY3zN4(horizontalAnchor2, f2, f4);
        this.containerObject.putNumber("vBias", f5);
    }

    /* renamed from: linkTo-R7zmacU  reason: not valid java name */
    public final void m6969linkToR7zmacU(ConstraintLayoutBaseScope.VerticalAnchor verticalAnchor, ConstraintLayoutBaseScope.HorizontalAnchor horizontalAnchor, ConstraintLayoutBaseScope.VerticalAnchor verticalAnchor2, ConstraintLayoutBaseScope.HorizontalAnchor horizontalAnchor2, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10) {
        m6968linkTo8ZKsbrE(verticalAnchor, verticalAnchor2, f, f3, f5, f7, f9);
        m6967linkTo8ZKsbrE(horizontalAnchor, horizontalAnchor2, f2, f4, f6, f8, f10);
    }

    public final void centerTo(ConstrainedLayoutReference constrainedLayoutReference) {
        m6961linkToR7zmacU$default(this, constrainedLayoutReference.getStart(), constrainedLayoutReference.getTop(), constrainedLayoutReference.getEnd(), constrainedLayoutReference.getBottom(), 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 16368, null);
    }

    public static /* synthetic */ void centerHorizontallyTo$default(ConstrainScope constrainScope, ConstrainedLayoutReference constrainedLayoutReference, float f, int i, Object obj) {
        if ((i & 2) != 0) {
            f = 0.5f;
        }
        constrainScope.centerHorizontallyTo(constrainedLayoutReference, f);
    }

    public final void centerHorizontallyTo(ConstrainedLayoutReference constrainedLayoutReference, float f) {
        m6960linkTo8ZKsbrE$default(this, constrainedLayoutReference.getStart(), constrainedLayoutReference.getEnd(), 0.0f, 0.0f, 0.0f, 0.0f, f, 60, (Object) null);
    }

    public static /* synthetic */ void centerVerticallyTo$default(ConstrainScope constrainScope, ConstrainedLayoutReference constrainedLayoutReference, float f, int i, Object obj) {
        if ((i & 2) != 0) {
            f = 0.5f;
        }
        constrainScope.centerVerticallyTo(constrainedLayoutReference, f);
    }

    public final void centerVerticallyTo(ConstrainedLayoutReference constrainedLayoutReference, float f) {
        m6959linkTo8ZKsbrE$default(this, constrainedLayoutReference.getTop(), constrainedLayoutReference.getBottom(), 0.0f, 0.0f, 0.0f, 0.0f, f, 60, (Object) null);
    }

    public final void centerAround(ConstraintLayoutBaseScope.VerticalAnchor verticalAnchor) {
        m6960linkTo8ZKsbrE$default(this, verticalAnchor, verticalAnchor, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 124, (Object) null);
    }

    public final void centerAround(ConstraintLayoutBaseScope.HorizontalAnchor horizontalAnchor) {
        m6959linkTo8ZKsbrE$default(this, horizontalAnchor, horizontalAnchor, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 124, (Object) null);
    }

    /* renamed from: circular-wH6b6FI  reason: not valid java name */
    public final void m6963circularwH6b6FI(ConstrainedLayoutReference constrainedLayoutReference, float f, float f2) {
        CLArray cLArray = new CLArray(new char[0]);
        cLArray.add(CLString.from(constrainedLayoutReference.getId$constraintlayout_compose_release().toString()));
        cLArray.add(new CLNumber(f));
        cLArray.add(new CLNumber(f2));
        this.containerObject.put("circular", cLArray);
    }

    public final void clearHorizontal() {
        this.containerObject.remove(TtmlNode.LEFT);
        this.containerObject.remove(TtmlNode.RIGHT);
        this.containerObject.remove(TtmlNode.START);
        this.containerObject.remove(TtmlNode.END);
    }

    public final void clearVertical() {
        this.containerObject.remove("top");
        this.containerObject.remove("bottom");
        this.containerObject.remove("baseline");
    }

    public final void clearConstraints() {
        clearHorizontal();
        clearVertical();
        this.containerObject.remove("circular");
    }

    public final void resetDimensions() {
        setWidth(Dimension.Companion.getWrapContent());
        setHeight(Dimension.Companion.getWrapContent());
    }

    public final void resetTransforms() {
        this.containerObject.remove("alpha");
        this.containerObject.remove("scaleX");
        this.containerObject.remove("scaleY");
        this.containerObject.remove("rotationX");
        this.containerObject.remove("rotationY");
        this.containerObject.remove("rotationZ");
        this.containerObject.remove("translationX");
        this.containerObject.remove("translationY");
        this.containerObject.remove("translationZ");
        this.containerObject.remove("pivotX");
        this.containerObject.remove("pivotY");
    }

    /* renamed from: asDimension-0680j_4  reason: not valid java name */
    public final Dimension m6962asDimension0680j_4(float f) {
        return Dimension.Companion.m7042value0680j_4(f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ConstrainScope.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0002\u0010\u0004J$\u0010\u0005\u001a\u00020\u00062\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\b2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002H\u0014¨\u0006\u000b"}, d2 = {"Landroidx/constraintlayout/compose/ConstrainScope$DimensionProperty;", "Lkotlin/properties/ObservableProperty;", "Landroidx/constraintlayout/compose/Dimension;", "initialValue", "(Landroidx/constraintlayout/compose/ConstrainScope;Landroidx/constraintlayout/compose/Dimension;)V", "afterChange", "", "property", "Lkotlin/reflect/KProperty;", "oldValue", "newValue", "constraintlayout-compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public final class DimensionProperty extends ObservableProperty<Dimension> {
        public DimensionProperty(Dimension dimension) {
            super(dimension);
        }

        @Override // kotlin.properties.ObservableProperty
        public /* bridge */ /* synthetic */ void afterChange(KProperty kProperty, Dimension dimension, Dimension dimension2) {
            afterChange2((KProperty<?>) kProperty, dimension, dimension2);
        }

        /* renamed from: afterChange  reason: avoid collision after fix types in other method */
        protected void afterChange2(KProperty<?> kProperty, Dimension dimension, Dimension dimension2) {
            CLObject containerObject$constraintlayout_compose_release = ConstrainScope.this.getContainerObject$constraintlayout_compose_release();
            String name = kProperty.getName();
            Intrinsics.checkNotNull(dimension2, "null cannot be cast to non-null type androidx.constraintlayout.compose.DimensionDescription");
            containerObject$constraintlayout_compose_release.put(name, ((DimensionDescription) dimension2).asCLElement$constraintlayout_compose_release());
        }
    }

    /* compiled from: ConstrainScope.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J$\u0010\u0007\u001a\u00020\b2\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\n2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0002H\u0014R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Landroidx/constraintlayout/compose/ConstrainScope$FloatProperty;", "Lkotlin/properties/ObservableProperty;", "", "initialValue", "nameOverride", "", "(Landroidx/constraintlayout/compose/ConstrainScope;FLjava/lang/String;)V", "afterChange", "", "property", "Lkotlin/reflect/KProperty;", "oldValue", "newValue", "constraintlayout-compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes2.dex */
    private final class FloatProperty extends ObservableProperty<Float> {
        private final String nameOverride;

        public FloatProperty(float f, String str) {
            super(Float.valueOf(f));
            this.nameOverride = str;
        }

        public /* synthetic */ FloatProperty(ConstrainScope constrainScope, float f, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(f, (i & 2) != 0 ? null : str);
        }

        @Override // kotlin.properties.ObservableProperty
        public /* bridge */ /* synthetic */ void afterChange(KProperty kProperty, Float f, Float f2) {
            afterChange(kProperty, f.floatValue(), f2.floatValue());
        }

        protected void afterChange(KProperty<?> kProperty, float f, float f2) {
            if (Float.isNaN(f2)) {
                return;
            }
            CLObject containerObject$constraintlayout_compose_release = ConstrainScope.this.getContainerObject$constraintlayout_compose_release();
            String str = this.nameOverride;
            if (str == null) {
                str = kProperty.getName();
            }
            containerObject$constraintlayout_compose_release.putNumber(str, f2);
        }
    }

    /* compiled from: ConstrainScope.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J.\u0010\u0007\u001a\u00020\b2\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\n2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0002H\u0014ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u000f"}, d2 = {"Landroidx/constraintlayout/compose/ConstrainScope$DpProperty;", "Lkotlin/properties/ObservableProperty;", "Landroidx/compose/ui/unit/Dp;", "initialValue", "nameOverride", "", "(Landroidx/constraintlayout/compose/ConstrainScope;FLjava/lang/String;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "afterChange", "", "property", "Lkotlin/reflect/KProperty;", "oldValue", "newValue", "afterChange-VpY3zN4", "(Lkotlin/reflect/KProperty;FF)V", "constraintlayout-compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes2.dex */
    private final class DpProperty extends ObservableProperty<Dp> {
        private final String nameOverride;

        public /* synthetic */ DpProperty(ConstrainScope constrainScope, float f, String str, DefaultConstructorMarker defaultConstructorMarker) {
            this(f, str);
        }

        private DpProperty(float f, String str) {
            super(Dp.m6682boximpl(f));
            this.nameOverride = str;
        }

        public /* synthetic */ DpProperty(ConstrainScope constrainScope, float f, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(constrainScope, f, (i & 2) != 0 ? null : str, null);
        }

        @Override // kotlin.properties.ObservableProperty
        public /* bridge */ /* synthetic */ void afterChange(KProperty kProperty, Dp dp, Dp dp2) {
            m6973afterChangeVpY3zN4(kProperty, dp.m6698unboximpl(), dp2.m6698unboximpl());
        }

        /* renamed from: afterChange-VpY3zN4  reason: not valid java name */
        protected void m6973afterChangeVpY3zN4(KProperty<?> kProperty, float f, float f2) {
            if (Float.isNaN(f2)) {
                return;
            }
            CLObject containerObject$constraintlayout_compose_release = ConstrainScope.this.getContainerObject$constraintlayout_compose_release();
            String str = this.nameOverride;
            if (str == null) {
                str = kProperty.getName();
            }
            containerObject$constraintlayout_compose_release.putNumber(str, f2);
        }
    }

    /* renamed from: linkTo-8ZKsbrE$default  reason: not valid java name */
    public static /* synthetic */ void m6960linkTo8ZKsbrE$default(ConstrainScope constrainScope, ConstraintLayoutBaseScope.VerticalAnchor verticalAnchor, ConstraintLayoutBaseScope.VerticalAnchor verticalAnchor2, float f, float f2, float f3, float f4, float f5, int i, Object obj) {
        if ((i & 4) != 0) {
            f = Dp.m6684constructorimpl(0);
        }
        float f6 = f;
        if ((i & 8) != 0) {
            f2 = Dp.m6684constructorimpl(0);
        }
        float f7 = f2;
        if ((i & 16) != 0) {
            f3 = Dp.m6684constructorimpl(0);
        }
        constrainScope.m6968linkTo8ZKsbrE(verticalAnchor, verticalAnchor2, f6, f7, f3, (i & 32) != 0 ? Dp.m6684constructorimpl(0) : f4, (i & 64) != 0 ? 0.5f : f5);
    }

    /* renamed from: linkTo-8ZKsbrE$default  reason: not valid java name */
    public static /* synthetic */ void m6959linkTo8ZKsbrE$default(ConstrainScope constrainScope, ConstraintLayoutBaseScope.HorizontalAnchor horizontalAnchor, ConstraintLayoutBaseScope.HorizontalAnchor horizontalAnchor2, float f, float f2, float f3, float f4, float f5, int i, Object obj) {
        if ((i & 4) != 0) {
            f = Dp.m6684constructorimpl(0);
        }
        float f6 = f;
        if ((i & 8) != 0) {
            f2 = Dp.m6684constructorimpl(0);
        }
        float f7 = f2;
        if ((i & 16) != 0) {
            f3 = Dp.m6684constructorimpl(0);
        }
        constrainScope.m6967linkTo8ZKsbrE(horizontalAnchor, horizontalAnchor2, f6, f7, f3, (i & 32) != 0 ? Dp.m6684constructorimpl(0) : f4, (i & 64) != 0 ? 0.5f : f5);
    }

    /* renamed from: linkTo-R7zmacU$default  reason: not valid java name */
    public static /* synthetic */ void m6961linkToR7zmacU$default(ConstrainScope constrainScope, ConstraintLayoutBaseScope.VerticalAnchor verticalAnchor, ConstraintLayoutBaseScope.HorizontalAnchor horizontalAnchor, ConstraintLayoutBaseScope.VerticalAnchor verticalAnchor2, ConstraintLayoutBaseScope.HorizontalAnchor horizontalAnchor2, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, int i, Object obj) {
        constrainScope.m6969linkToR7zmacU(verticalAnchor, horizontalAnchor, verticalAnchor2, horizontalAnchor2, (i & 16) != 0 ? Dp.m6684constructorimpl(0) : f, (i & 32) != 0 ? Dp.m6684constructorimpl(0) : f2, (i & 64) != 0 ? Dp.m6684constructorimpl(0) : f3, (i & 128) != 0 ? Dp.m6684constructorimpl(0) : f4, (i & 256) != 0 ? Dp.m6684constructorimpl(0) : f5, (i & 512) != 0 ? Dp.m6684constructorimpl(0) : f6, (i & 1024) != 0 ? Dp.m6684constructorimpl(0) : f7, (i & 2048) != 0 ? Dp.m6684constructorimpl(0) : f8, (i & 4096) != 0 ? 0.5f : f9, (i & 8192) != 0 ? 0.5f : f10);
    }
}
