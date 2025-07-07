package androidx.compose.foundation.text.modifiers;

import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.foundation.text.modifiers.TextAnnotatedStringNode;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.ColorProducer;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.GlobalPositionAwareModifierNode;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.node.LayoutModifierNodeKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.Placeholder;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.style.TextOverflow;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: SelectableTextAnnotatedStringNode.kt */
@Metadata(d1 = {"\u0000²\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004BÑ\u0001\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\f\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0014\u0012\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u0018\u0018\u00010\u0017\u0012\u001e\b\u0002\u0010\u001a\u001a\u0018\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u0017\u0012\u0004\u0012\u00020\u000e\u0018\u00010\f\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!\u0012\u0016\b\u0002\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u000e\u0018\u00010\f¢\u0006\u0002\u0010$J\u0010\u0010*\u001a\u00020\u000e2\u0006\u0010+\u001a\u00020,H\u0016J°\u0001\u0010-\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0014\u0010\u0016\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u0018\u0018\u00010\u00172\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00102\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\f2\u001c\u0010\u001a\u001a\u0018\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u0017\u0012\u0004\u0012\u00020\u000e\u0018\u00010\f2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010.\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010!ø\u0001\u0000¢\u0006\u0004\b/\u00100J\f\u00101\u001a\u00020\u000e*\u000202H\u0016J\u001c\u00103\u001a\u00020\u0014*\u0002042\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u00020\u0014H\u0016J\u001c\u00108\u001a\u00020\u0014*\u0002042\u0006\u00105\u001a\u0002062\u0006\u00109\u001a\u00020\u0014H\u0016J&\u0010:\u001a\u00020;*\u00020<2\u0006\u00105\u001a\u00020=2\u0006\u0010>\u001a\u00020?H\u0016ø\u0001\u0000¢\u0006\u0004\b@\u0010AJ\u001c\u0010B\u001a\u00020\u0014*\u0002042\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u00020\u0014H\u0016J\u001c\u0010C\u001a\u00020\u0014*\u0002042\u0006\u00105\u001a\u0002062\u0006\u00109\u001a\u00020\u0014H\u0016R\u001c\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u000e\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010%\u001a\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'R\u000e\u0010(\u001a\u00020)X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006D"}, d2 = {"Landroidx/compose/foundation/text/modifiers/SelectableTextAnnotatedStringNode;", "Landroidx/compose/ui/node/DelegatingNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/node/DrawModifierNode;", "Landroidx/compose/ui/node/GlobalPositionAwareModifierNode;", "text", "Landroidx/compose/ui/text/AnnotatedString;", "style", "Landroidx/compose/ui/text/TextStyle;", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "onTextLayout", "Lkotlin/Function1;", "Landroidx/compose/ui/text/TextLayoutResult;", "", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "softWrap", "", "maxLines", "", "minLines", "placeholders", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/Placeholder;", "onPlaceholderLayout", "Landroidx/compose/ui/geometry/Rect;", "selectionController", "Landroidx/compose/foundation/text/modifiers/SelectionController;", "overrideColor", "Landroidx/compose/ui/graphics/ColorProducer;", "autoSize", "Landroidx/compose/foundation/text/TextAutoSize;", "onShowTranslation", "Landroidx/compose/foundation/text/modifiers/TextAnnotatedStringNode$TextSubstitutionValue;", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/font/FontFamily$Resolver;Lkotlin/jvm/functions/Function1;IZIILjava/util/List;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/text/modifiers/SelectionController;Landroidx/compose/ui/graphics/ColorProducer;Landroidx/compose/foundation/text/TextAutoSize;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "shouldAutoInvalidate", "getShouldAutoInvalidate", "()Z", "textAnnotatedStringNode", "Landroidx/compose/foundation/text/modifiers/TextAnnotatedStringNode;", "onGloballyPositioned", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "update", "color", "update-7NebLg4", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;Ljava/util/List;IIZLandroidx/compose/ui/text/font/FontFamily$Resolver;ILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/text/modifiers/SelectionController;Landroidx/compose/ui/graphics/ColorProducer;Landroidx/compose/foundation/text/TextAutoSize;)V", "draw", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "maxIntrinsicHeight", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurable", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "foundation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SelectableTextAnnotatedStringNode extends DelegatingNode implements LayoutModifierNode, DrawModifierNode, GlobalPositionAwareModifierNode {
    public static final int $stable = 8;
    private Function1<? super TextAnnotatedStringNode.TextSubstitutionValue, Unit> onShowTranslation;
    private SelectionController selectionController;
    private final TextAnnotatedStringNode textAnnotatedStringNode;

    public /* synthetic */ SelectableTextAnnotatedStringNode(AnnotatedString annotatedString, TextStyle textStyle, FontFamily.Resolver resolver, Function1 function1, int i, boolean z, int i2, int i3, List list, Function1 function12, SelectionController selectionController, ColorProducer colorProducer, TextAutoSize textAutoSize, Function1 function13, DefaultConstructorMarker defaultConstructorMarker) {
        this(annotatedString, textStyle, resolver, function1, i, z, i2, i3, list, function12, selectionController, colorProducer, textAutoSize, function13);
    }

    @Override // androidx.compose.ui.Modifier.Node
    public boolean getShouldAutoInvalidate() {
        return false;
    }

    public /* synthetic */ SelectableTextAnnotatedStringNode(AnnotatedString annotatedString, TextStyle textStyle, FontFamily.Resolver resolver, Function1 function1, int i, boolean z, int i2, int i3, List list, Function1 function12, SelectionController selectionController, ColorProducer colorProducer, TextAutoSize textAutoSize, Function1 function13, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(annotatedString, textStyle, resolver, (i4 & 8) != 0 ? null : function1, (i4 & 16) != 0 ? TextOverflow.Companion.m6619getClipgIe3tQ8() : i, (i4 & 32) != 0 ? true : z, (i4 & 64) != 0 ? Integer.MAX_VALUE : i2, (i4 & 128) != 0 ? 1 : i3, (i4 & 256) != 0 ? null : list, (i4 & 512) != 0 ? null : function12, (i4 & 1024) != 0 ? null : selectionController, (i4 & 2048) != 0 ? null : colorProducer, (i4 & 4096) != 0 ? null : textAutoSize, (i4 & 8192) != 0 ? null : function13, null);
    }

    private SelectableTextAnnotatedStringNode(AnnotatedString annotatedString, TextStyle textStyle, FontFamily.Resolver resolver, Function1<? super TextLayoutResult, Unit> function1, int i, boolean z, int i2, int i3, List<AnnotatedString.Range<Placeholder>> list, Function1<? super List<Rect>, Unit> function12, SelectionController selectionController, ColorProducer colorProducer, TextAutoSize textAutoSize, Function1<? super TextAnnotatedStringNode.TextSubstitutionValue, Unit> function13) {
        this.selectionController = selectionController;
        this.onShowTranslation = function13;
        this.textAnnotatedStringNode = (TextAnnotatedStringNode) delegate(new TextAnnotatedStringNode(annotatedString, textStyle, resolver, function1, i, z, i2, i3, list, function12, this.selectionController, colorProducer, textAutoSize, this.onShowTranslation, null));
        if (this.selectionController != null) {
            return;
        }
        InlineClassHelperKt.throwIllegalArgumentExceptionForNullCheck("Do not use SelectionCapableStaticTextModifier unless selectionController != null");
        throw new KotlinNothingValueException();
    }

    @Override // androidx.compose.ui.node.GlobalPositionAwareModifierNode
    public void onGloballyPositioned(LayoutCoordinates layoutCoordinates) {
        SelectionController selectionController = this.selectionController;
        if (selectionController != null) {
            selectionController.updateGlobalPosition(layoutCoordinates);
        }
    }

    @Override // androidx.compose.ui.node.DrawModifierNode
    public void draw(ContentDrawScope contentDrawScope) {
        this.textAnnotatedStringNode.drawNonExtension(contentDrawScope);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* renamed from: measure-3p2s80s */
    public MeasureResult mo70measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        return this.textAnnotatedStringNode.m1445measureNonExtension3p2s80s(measureScope, measurable, j);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return this.textAnnotatedStringNode.minIntrinsicWidthNonExtension(intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return this.textAnnotatedStringNode.minIntrinsicHeightNonExtension(intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return this.textAnnotatedStringNode.maxIntrinsicWidthNonExtension(intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return this.textAnnotatedStringNode.maxIntrinsicHeightNonExtension(intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    /* renamed from: update-7NebLg4  reason: not valid java name */
    public final void m1444update7NebLg4(AnnotatedString annotatedString, TextStyle textStyle, List<AnnotatedString.Range<Placeholder>> list, int i, int i2, boolean z, FontFamily.Resolver resolver, int i3, Function1<? super TextLayoutResult, Unit> function1, Function1<? super List<Rect>, Unit> function12, SelectionController selectionController, ColorProducer colorProducer, TextAutoSize textAutoSize) {
        TextAnnotatedStringNode textAnnotatedStringNode = this.textAnnotatedStringNode;
        textAnnotatedStringNode.doInvalidations(textAnnotatedStringNode.updateDraw(colorProducer, textStyle), this.textAnnotatedStringNode.updateText$foundation_release(annotatedString), this.textAnnotatedStringNode.m1446updateLayoutRelatedArgsy0kMQk(textStyle, list, i, i2, z, resolver, i3, textAutoSize), this.textAnnotatedStringNode.updateCallbacks(function1, function12, selectionController, this.onShowTranslation));
        this.selectionController = selectionController;
        LayoutModifierNodeKt.invalidateMeasurement(this);
    }
}
