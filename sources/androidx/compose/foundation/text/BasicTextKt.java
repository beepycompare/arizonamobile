package androidx.compose.foundation.text;

import androidx.compose.foundation.text.modifiers.SelectableTextAnnotatedStringElement;
import androidx.compose.foundation.text.modifiers.SelectionController;
import androidx.compose.foundation.text.modifiers.TextAnnotatedStringElement;
import androidx.compose.foundation.text.modifiers.TextAnnotatedStringNode;
import androidx.compose.foundation.text.modifiers.TextAnnotatedStringNodeKt;
import androidx.compose.foundation.text.modifiers.TextStringSimpleElement;
import androidx.compose.foundation.text.selection.SelectionRegistrar;
import androidx.compose.foundation.text.selection.SelectionRegistrarKt;
import androidx.compose.foundation.text.selection.TextSelectionColors;
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.ColorProducer;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.Placeholder;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntOffset;
import androidx.media3.common.C;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.profileinstaller.ProfileVerifier;
import com.google.android.material.internal.ViewUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: BasicText.kt */
@Metadata(d1 = {"\u0000®\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0084\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\u0014\b\u0002\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0013H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u0090\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\u0014\b\u0002\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u00132\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001b\u001a\u009c\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\u0014\b\u0002\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u00132\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0007ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001f\u001az\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0014\b\u0002\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0013H\u0007ø\u0001\u0000¢\u0006\u0004\b \u0010!\u001ad\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00142\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0007ø\u0001\u0000¢\u0006\u0004\b\"\u0010#\u001an\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00142\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0010H\u0007ø\u0001\u0000¢\u0006\u0004\b \u0010$\u001az\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00142\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010%\u001a\u0086\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00142\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0007ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010&\u001aº\u0001\u0010'\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00032\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\u0006\u0010(\u001a\u00020\u000e2\u0014\b\u0002\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u00132\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010,2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0014\u0010-\u001a\u0010\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0003ø\u0001\u0000¢\u0006\u0004\b/\u00100\u001a@\u00101\u001a\u001e\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u000204\u0012\f\u0012\n\u0012\u0004\u0012\u000206\u0018\u00010503\u0018\u0001022\f\u00107\u001a\b\u0012\u0004\u0012\u000208022\f\u00109\u001a\b\u0012\u0004\u0012\u00020\u000e05H\u0002\u001a\u001e\u0010:\u001a\u000e\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020<0;2\b\u0010=\u001a\u0004\u0018\u00010>H\u0002\u001aÌ\u0001\u0010?\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010)\u001a\u00020*2\u0014\u0010@\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020B0A\u0018\u0001022\u001c\u0010C\u001a\u0018\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010D02\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\b\u0010+\u001a\u0004\u0018\u00010,2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0014\u0010-\u001a\u0010\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0002ø\u0001\u0000¢\u0006\u0004\bE\u0010F\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006G²\u0006\n\u0010H\u001a\u00020\u0003X\u008a\u008e\u0002"}, d2 = {"BasicText", "", "text", "Landroidx/compose/ui/text/AnnotatedString;", "modifier", "Landroidx/compose/ui/Modifier;", "style", "Landroidx/compose/ui/text/TextStyle;", "onTextLayout", "Lkotlin/Function1;", "Landroidx/compose/ui/text/TextLayoutResult;", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "softWrap", "", "maxLines", "", "minLines", "inlineContent", "", "", "Landroidx/compose/foundation/text/InlineTextContent;", "BasicText-VhcvRP8", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function1;IZIILjava/util/Map;Landroidx/compose/runtime/Composer;II)V", "color", "Landroidx/compose/ui/graphics/ColorProducer;", "BasicText-RWo7tUw", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function1;IZIILjava/util/Map;Landroidx/compose/ui/graphics/ColorProducer;Landroidx/compose/runtime/Composer;II)V", "autoSize", "Landroidx/compose/foundation/text/TextAutoSize;", "BasicText-CL7eQgs", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function1;IZIILjava/util/Map;Landroidx/compose/ui/graphics/ColorProducer;Landroidx/compose/foundation/text/TextAutoSize;Landroidx/compose/runtime/Composer;III)V", "BasicText-4YKlhWE", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function1;IZILjava/util/Map;Landroidx/compose/runtime/Composer;II)V", "BasicText-BpD7jsM", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function1;IZILandroidx/compose/runtime/Composer;II)V", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function1;IZIILandroidx/compose/runtime/Composer;II)V", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function1;IZIILandroidx/compose/ui/graphics/ColorProducer;Landroidx/compose/runtime/Composer;II)V", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function1;IZIILandroidx/compose/ui/graphics/ColorProducer;Landroidx/compose/foundation/text/TextAutoSize;Landroidx/compose/runtime/Composer;II)V", "LayoutWithLinksAndInlineContent", "hasInlineContent", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "selectionController", "Landroidx/compose/foundation/text/modifiers/SelectionController;", "onShowTranslation", "Landroidx/compose/foundation/text/modifiers/TextAnnotatedStringNode$TextSubstitutionValue;", "LayoutWithLinksAndInlineContent-11Od_4g", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/AnnotatedString;Lkotlin/jvm/functions/Function1;ZLjava/util/Map;Landroidx/compose/ui/text/TextStyle;IZIILandroidx/compose/ui/text/font/FontFamily$Resolver;Landroidx/compose/foundation/text/modifiers/SelectionController;Landroidx/compose/ui/graphics/ColorProducer;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/text/TextAutoSize;Landroidx/compose/runtime/Composer;III)V", "measureWithTextRangeMeasureConstraints", "", "Lkotlin/Pair;", "Landroidx/compose/ui/layout/Placeable;", "Lkotlin/Function0;", "Landroidx/compose/ui/unit/IntOffset;", "measurables", "Landroidx/compose/ui/layout/Measurable;", "shouldMeasureLinks", "selectionIdSaver", "Landroidx/compose/runtime/saveable/Saver;", "", "selectionRegistrar", "Landroidx/compose/foundation/text/selection/SelectionRegistrar;", "textModifier", "placeholders", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/Placeholder;", "onPlaceholderLayout", "Landroidx/compose/ui/geometry/Rect;", "textModifier-CL7eQgs", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function1;IZIILandroidx/compose/ui/text/font/FontFamily$Resolver;Ljava/util/List;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/text/modifiers/SelectionController;Landroidx/compose/ui/graphics/ColorProducer;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/text/TextAutoSize;)Landroidx/compose/ui/Modifier;", "foundation_release", "displayedText"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class BasicTextKt {
    public static final /* synthetic */ List access$measureWithTextRangeMeasureConstraints(List list, Function0 function0) {
        return measureWithTextRangeMeasureConstraints(list, function0);
    }

    /* JADX WARN: Removed duplicated region for block: B:215:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:259:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:268:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:269:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:279:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:280:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:291:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:302:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:303:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:306:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:372:0x03d9  */
    /* JADX WARN: Removed duplicated region for block: B:375:0x03f2  */
    /* JADX WARN: Removed duplicated region for block: B:377:? A[RETURN, SYNTHETIC] */
    /* renamed from: BasicText-RWo7tUw */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m1048BasicTextRWo7tUw(String str, Modifier modifier, TextStyle textStyle, Function1<? super TextLayoutResult, Unit> function1, int i, boolean z, int i2, int i3, ColorProducer colorProducer, TextAutoSize textAutoSize, Composer composer, final int i4, final int i5) {
        int i6;
        Modifier.Companion companion;
        int i7;
        Object obj;
        int i8;
        Object obj2;
        int i9;
        int i10;
        int i11;
        boolean z2;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        final String str2;
        final int i18;
        final TextAutoSize textAutoSize2;
        Composer composer2;
        final boolean z3;
        final Modifier modifier2;
        final TextStyle textStyle2;
        final Function1<? super TextLayoutResult, Unit> function12;
        final int i19;
        final int i20;
        final ColorProducer colorProducer2;
        ScopeUpdateScope endRestartGroup;
        SelectionController selectionController;
        int i21;
        int i22;
        Modifier modifier3;
        Modifier m1053textModifierCL7eQgs;
        Composer startRestartGroup = composer.startRestartGroup(-1040751001);
        ComposerKt.sourceInformation(startRestartGroup, "C(BasicText)P(9,4,8,5,6:c#ui.text.style.TextOverflow,7,2,3,1)103@5400L7,148@7222L41:BasicText.kt#423gt5");
        if ((i5 & 1) != 0) {
            i6 = i4 | 6;
        } else if ((i4 & 6) == 0) {
            i6 = (startRestartGroup.changed(str) ? 4 : 2) | i4;
        } else {
            i6 = i4;
        }
        int i23 = i5 & 2;
        if (i23 != 0) {
            i6 |= 48;
        } else if ((i4 & 48) == 0) {
            companion = modifier;
            i6 |= startRestartGroup.changed(companion) ? 32 : 16;
            i7 = i5 & 4;
            if (i7 == 0) {
                i6 |= RendererCapabilities.DECODER_SUPPORT_MASK;
            } else if ((i4 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                obj = textStyle;
                i6 |= startRestartGroup.changed(obj) ? 256 : 128;
                i8 = i5 & 8;
                if (i8 != 0) {
                    i6 |= 3072;
                } else if ((i4 & 3072) == 0) {
                    obj2 = function1;
                    i6 |= startRestartGroup.changedInstance(obj2) ? 2048 : 1024;
                    i9 = i5 & 16;
                    if (i9 == 0) {
                        i6 |= 24576;
                    } else if ((i4 & 24576) == 0) {
                        i10 = i;
                        i6 |= startRestartGroup.changed(i10) ? 16384 : 8192;
                        i11 = i5 & 32;
                        if (i11 != 0) {
                            i6 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                            z2 = z;
                        } else {
                            z2 = z;
                            if ((i4 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                                i6 |= startRestartGroup.changed(z2) ? 131072 : 65536;
                            }
                        }
                        i12 = i5 & 64;
                        if (i12 != 0) {
                            i6 |= 1572864;
                        } else if ((i4 & 1572864) == 0) {
                            i6 |= startRestartGroup.changed(i2) ? 1048576 : 524288;
                        }
                        i13 = i5 & 128;
                        if (i13 != 0) {
                            i6 |= 12582912;
                        } else if ((i4 & 12582912) == 0) {
                            i14 = i13;
                            i6 |= startRestartGroup.changed(i3) ? 8388608 : 4194304;
                            i15 = i5 & 256;
                            if (i15 == 0) {
                                i6 |= 100663296;
                            } else if ((i4 & 100663296) == 0) {
                                i16 = i15;
                                i6 |= startRestartGroup.changedInstance(colorProducer) ? 67108864 : 33554432;
                                i17 = i5 & 512;
                                int i24 = 805306368;
                                if (i17 == 0) {
                                    if ((i4 & 805306368) == 0) {
                                        i24 = (i4 & 1073741824) == 0 ? startRestartGroup.changed(textAutoSize) : startRestartGroup.changedInstance(textAutoSize) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
                                    }
                                    if (!startRestartGroup.shouldExecute((i6 & 306783379) == 306783378, i6 & 1)) {
                                        if (i23 != 0) {
                                            companion = Modifier.Companion;
                                        }
                                        TextStyle textStyle3 = i7 != 0 ? TextStyle.Companion.getDefault() : obj;
                                        Function1<? super TextLayoutResult, Unit> function13 = i8 != 0 ? null : obj2;
                                        int m6619getClipgIe3tQ8 = i9 != 0 ? TextOverflow.Companion.m6619getClipgIe3tQ8() : i10;
                                        boolean z4 = i11 != 0 ? true : z2;
                                        int i25 = i12 != 0 ? Integer.MAX_VALUE : i2;
                                        int i26 = i14 != 0 ? 1 : i3;
                                        ColorProducer colorProducer3 = i16 != 0 ? null : colorProducer;
                                        TextAutoSize textAutoSize3 = i17 != 0 ? null : textAutoSize;
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-1040751001, i6, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:101)");
                                        }
                                        HeightInLinesModifierKt.validateMinMaxLines(i26, i25);
                                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                        Object consume = startRestartGroup.consume(SelectionRegistrarKt.getLocalSelectionRegistrar());
                                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                        final SelectionRegistrar selectionRegistrar = (SelectionRegistrar) consume;
                                        if (selectionRegistrar != null) {
                                            startRestartGroup.startReplaceGroup(-1588802442);
                                            ComposerKt.sourceInformation(startRestartGroup, "106@5548L7,108@5702L77,108@5619L160,111@5792L180");
                                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                            Object consume2 = startRestartGroup.consume(TextSelectionColorsKt.getLocalTextSelectionColors());
                                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                            long m1533getBackgroundColor0d7_KjU = ((TextSelectionColors) consume2).m1533getBackgroundColor0d7_KjU();
                                            Object[] objArr = {selectionRegistrar};
                                            Saver<Long, Long> selectionIdSaver = selectionIdSaver(selectionRegistrar);
                                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -328339615, "CC(remember):BasicText.kt#9igjgp");
                                            boolean changedInstance = startRestartGroup.changedInstance(selectionRegistrar);
                                            Object rememberedValue = startRestartGroup.rememberedValue();
                                            if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                                                rememberedValue = (Function0) new Function0<Long>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$selectionController$selectableId$1$1
                                                    /* JADX INFO: Access modifiers changed from: package-private */
                                                    {
                                                        super(0);
                                                    }

                                                    /* JADX WARN: Can't rename method to resolve collision */
                                                    @Override // kotlin.jvm.functions.Function0
                                                    public final Long invoke() {
                                                        return Long.valueOf(SelectionRegistrar.this.nextSelectableId());
                                                    }
                                                };
                                                startRestartGroup.updateRememberedValue(rememberedValue);
                                            }
                                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                            long longValue = ((Number) RememberSaveableKt.m3635rememberSaveable(objArr, selectionIdSaver, (String) null, (Function0<? extends Object>) rememberedValue, startRestartGroup, 0, 4)).longValue();
                                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -328336632, "CC(remember):BasicText.kt#9igjgp");
                                            boolean changed = startRestartGroup.changed(longValue) | startRestartGroup.changed(selectionRegistrar) | startRestartGroup.changed(m1533getBackgroundColor0d7_KjU);
                                            Object rememberedValue2 = startRestartGroup.rememberedValue();
                                            if (changed || rememberedValue2 == Composer.Companion.getEmpty()) {
                                                rememberedValue2 = new SelectionController(longValue, selectionRegistrar, m1533getBackgroundColor0d7_KjU, null, 8, null);
                                                startRestartGroup.updateRememberedValue(rememberedValue2);
                                            }
                                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                            startRestartGroup.endReplaceGroup();
                                            selectionController = (SelectionController) rememberedValue2;
                                        } else {
                                            startRestartGroup.startReplaceGroup(-1588311278);
                                            startRestartGroup.endReplaceGroup();
                                            selectionController = null;
                                        }
                                        if (selectionController != null || function13 != null || textAutoSize3 != null) {
                                            i21 = i25;
                                            i22 = i26;
                                            str2 = str;
                                            startRestartGroup.startReplaceGroup(-1588155131);
                                            ComposerKt.sourceInformation(startRestartGroup, "127@6494L7");
                                            AnnotatedString annotatedString = new AnnotatedString(str2, null, 2, null);
                                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                            Object consume3 = startRestartGroup.consume(CompositionLocalsKt.getLocalFontFamilyResolver());
                                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                            modifier3 = companion;
                                            m1053textModifierCL7eQgs = m1053textModifierCL7eQgs(modifier3, annotatedString, textStyle3, function13, m6619getClipgIe3tQ8, z4, i21, i22, (FontFamily.Resolver) consume3, null, null, selectionController, colorProducer3, null, textAutoSize3);
                                            startRestartGroup.endReplaceGroup();
                                        } else {
                                            startRestartGroup.startReplaceGroup(-1587511974);
                                            ComposerKt.sourceInformation(startRestartGroup, "140@6983L7");
                                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                            Object consume4 = startRestartGroup.consume(CompositionLocalsKt.getLocalFontFamilyResolver());
                                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                            int i27 = i25;
                                            int i28 = i26;
                                            str2 = str;
                                            i21 = i27;
                                            i22 = i28;
                                            m1053textModifierCL7eQgs = companion.then(new TextStringSimpleElement(str, textStyle3, (FontFamily.Resolver) consume4, m6619getClipgIe3tQ8, z4, i27, i28, colorProducer3, null));
                                            startRestartGroup.endReplaceGroup();
                                            modifier3 = companion;
                                        }
                                        EmptyMeasurePolicy emptyMeasurePolicy = EmptyMeasurePolicy.INSTANCE;
                                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 544976794, "CC(Layout)P(1)121@4798L23,124@4949L333:Layout.kt#80mrfh");
                                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                                        Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, m1053textModifierCL7eQgs);
                                        CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                                        Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
                                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1405779621, "CC(ReusableComposeNode):Composables.kt#9igjgp");
                                        if (!(startRestartGroup.getApplier() instanceof Applier)) {
                                            ComposablesKt.invalidApplier();
                                        }
                                        startRestartGroup.startReusableNode();
                                        if (startRestartGroup.getInserting()) {
                                            startRestartGroup.createNode(constructor);
                                        } else {
                                            startRestartGroup.useNode();
                                        }
                                        Composer m3520constructorimpl = Updater.m3520constructorimpl(startRestartGroup);
                                        Updater.m3527setimpl(m3520constructorimpl, emptyMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                                        Updater.m3527setimpl(m3520constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                        Updater.m3527setimpl(m3520constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                        if (m3520constructorimpl.getInserting() || !Intrinsics.areEqual(m3520constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                            m3520constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                            m3520constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                        }
                                        startRestartGroup.endNode();
                                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                        composer2 = startRestartGroup;
                                        modifier2 = modifier3;
                                        textStyle2 = textStyle3;
                                        function12 = function13;
                                        i19 = m6619getClipgIe3tQ8;
                                        z3 = z4;
                                        i20 = i21;
                                        i18 = i22;
                                        colorProducer2 = colorProducer3;
                                        textAutoSize2 = textAutoSize3;
                                    } else {
                                        str2 = str;
                                        startRestartGroup.skipToGroupEnd();
                                        i18 = i3;
                                        textAutoSize2 = textAutoSize;
                                        composer2 = startRestartGroup;
                                        z3 = z2;
                                        modifier2 = companion;
                                        textStyle2 = obj;
                                        function12 = obj2;
                                        i19 = i10;
                                        i20 = i2;
                                        colorProducer2 = colorProducer;
                                    }
                                    endRestartGroup = composer2.endRestartGroup();
                                    if (endRestartGroup == null) {
                                        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$1
                                            /* JADX INFO: Access modifiers changed from: package-private */
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(2);
                                            }

                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                                invoke(composer3, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(Composer composer3, int i29) {
                                                BasicTextKt.m1048BasicTextRWo7tUw(str2, modifier2, textStyle2, function12, i19, z3, i20, i18, colorProducer2, textAutoSize2, composer3, RecomposeScopeImplKt.updateChangedFlags(i4 | 1), i5);
                                            }
                                        });
                                        return;
                                    }
                                    return;
                                }
                                i6 |= i24;
                                if (!startRestartGroup.shouldExecute((i6 & 306783379) == 306783378, i6 & 1)) {
                                }
                                endRestartGroup = composer2.endRestartGroup();
                                if (endRestartGroup == null) {
                                }
                            }
                            i16 = i15;
                            i17 = i5 & 512;
                            int i242 = 805306368;
                            if (i17 == 0) {
                            }
                            i6 |= i242;
                            if (!startRestartGroup.shouldExecute((i6 & 306783379) == 306783378, i6 & 1)) {
                            }
                            endRestartGroup = composer2.endRestartGroup();
                            if (endRestartGroup == null) {
                            }
                        }
                        i14 = i13;
                        i15 = i5 & 256;
                        if (i15 == 0) {
                        }
                        i16 = i15;
                        i17 = i5 & 512;
                        int i2422 = 805306368;
                        if (i17 == 0) {
                        }
                        i6 |= i2422;
                        if (!startRestartGroup.shouldExecute((i6 & 306783379) == 306783378, i6 & 1)) {
                        }
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup == null) {
                        }
                    }
                    i10 = i;
                    i11 = i5 & 32;
                    if (i11 != 0) {
                    }
                    i12 = i5 & 64;
                    if (i12 != 0) {
                    }
                    i13 = i5 & 128;
                    if (i13 != 0) {
                    }
                    i14 = i13;
                    i15 = i5 & 256;
                    if (i15 == 0) {
                    }
                    i16 = i15;
                    i17 = i5 & 512;
                    int i24222 = 805306368;
                    if (i17 == 0) {
                    }
                    i6 |= i24222;
                    if (!startRestartGroup.shouldExecute((i6 & 306783379) == 306783378, i6 & 1)) {
                    }
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup == null) {
                    }
                }
                obj2 = function1;
                i9 = i5 & 16;
                if (i9 == 0) {
                }
                i10 = i;
                i11 = i5 & 32;
                if (i11 != 0) {
                }
                i12 = i5 & 64;
                if (i12 != 0) {
                }
                i13 = i5 & 128;
                if (i13 != 0) {
                }
                i14 = i13;
                i15 = i5 & 256;
                if (i15 == 0) {
                }
                i16 = i15;
                i17 = i5 & 512;
                int i242222 = 805306368;
                if (i17 == 0) {
                }
                i6 |= i242222;
                if (!startRestartGroup.shouldExecute((i6 & 306783379) == 306783378, i6 & 1)) {
                }
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            obj = textStyle;
            i8 = i5 & 8;
            if (i8 != 0) {
            }
            obj2 = function1;
            i9 = i5 & 16;
            if (i9 == 0) {
            }
            i10 = i;
            i11 = i5 & 32;
            if (i11 != 0) {
            }
            i12 = i5 & 64;
            if (i12 != 0) {
            }
            i13 = i5 & 128;
            if (i13 != 0) {
            }
            i14 = i13;
            i15 = i5 & 256;
            if (i15 == 0) {
            }
            i16 = i15;
            i17 = i5 & 512;
            int i2422222 = 805306368;
            if (i17 == 0) {
            }
            i6 |= i2422222;
            if (!startRestartGroup.shouldExecute((i6 & 306783379) == 306783378, i6 & 1)) {
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        companion = modifier;
        i7 = i5 & 4;
        if (i7 == 0) {
        }
        obj = textStyle;
        i8 = i5 & 8;
        if (i8 != 0) {
        }
        obj2 = function1;
        i9 = i5 & 16;
        if (i9 == 0) {
        }
        i10 = i;
        i11 = i5 & 32;
        if (i11 != 0) {
        }
        i12 = i5 & 64;
        if (i12 != 0) {
        }
        i13 = i5 & 128;
        if (i13 != 0) {
        }
        i14 = i13;
        i15 = i5 & 256;
        if (i15 == 0) {
        }
        i16 = i15;
        i17 = i5 & 512;
        int i24222222 = 805306368;
        if (i17 == 0) {
        }
        i6 |= i24222222;
        if (!startRestartGroup.shouldExecute((i6 & 306783379) == 306783378, i6 & 1)) {
        }
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:393:0x0251, code lost:
        if (r2 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L125;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:248:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:259:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:260:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:270:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:271:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:281:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:282:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:291:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:292:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:301:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:302:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:312:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:313:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:323:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:324:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:334:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:336:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:349:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:356:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:438:0x04ac  */
    /* JADX WARN: Removed duplicated region for block: B:441:0x04c8  */
    /* JADX WARN: Removed duplicated region for block: B:443:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r8v7 */
    /* renamed from: BasicText-CL7eQgs */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m1046BasicTextCL7eQgs(AnnotatedString annotatedString, Modifier modifier, TextStyle textStyle, Function1<? super TextLayoutResult, Unit> function1, int i, boolean z, int i2, int i3, Map<String, InlineTextContent> map, ColorProducer colorProducer, TextAutoSize textAutoSize, Composer composer, final int i4, final int i5, final int i6) {
        int i7;
        int i8;
        Object obj;
        int i9;
        Object obj2;
        int i10;
        int i11;
        int i12;
        int i13;
        final int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        int i23;
        final AnnotatedString annotatedString2;
        final Modifier modifier2;
        final int i24;
        final Map<String, InlineTextContent> map2;
        final ColorProducer colorProducer2;
        Composer composer2;
        final int i25;
        final TextStyle textStyle2;
        final Function1<? super TextLayoutResult, Unit> function12;
        final boolean z2;
        final TextAutoSize textAutoSize2;
        ScopeUpdateScope endRestartGroup;
        int i26;
        Modifier modifier3;
        TextStyle textStyle3;
        Function1<? super TextLayoutResult, Unit> function13;
        Composer composer3;
        int i27;
        SelectionController selectionController;
        boolean z3;
        int i28;
        Function1<? super TextLayoutResult, Unit> function14;
        Composer composer4;
        Composer startRestartGroup = composer.startRestartGroup(-1343466571);
        ComposerKt.sourceInformation(startRestartGroup, "C(BasicText)P(10,5,9,6,7:c#ui.text.style.TextOverflow,8,3,4,2,1)196@10069L7:BasicText.kt#423gt5");
        if ((i6 & 1) != 0) {
            i7 = i4 | 6;
        } else if ((i4 & 6) == 0) {
            i7 = (startRestartGroup.changed(annotatedString) ? 4 : 2) | i4;
        } else {
            i7 = i4;
        }
        int i29 = i6 & 2;
        if (i29 != 0) {
            i7 |= 48;
        } else if ((i4 & 48) == 0) {
            i7 |= startRestartGroup.changed(modifier) ? 32 : 16;
            i8 = i6 & 4;
            if (i8 == 0) {
                i7 |= RendererCapabilities.DECODER_SUPPORT_MASK;
            } else if ((i4 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                obj = textStyle;
                i7 |= startRestartGroup.changed(obj) ? 256 : 128;
                i9 = i6 & 8;
                if (i9 != 0) {
                    i7 |= 3072;
                } else if ((i4 & 3072) == 0) {
                    obj2 = function1;
                    i7 |= startRestartGroup.changedInstance(obj2) ? 2048 : 1024;
                    i10 = i6 & 16;
                    if (i10 == 0) {
                        i7 |= 24576;
                    } else if ((i4 & 24576) == 0) {
                        i11 = i;
                        i7 |= startRestartGroup.changed(i11) ? 16384 : 8192;
                        i12 = i6 & 32;
                        if (i12 != 0) {
                            i7 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        } else if ((i4 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                            i7 |= startRestartGroup.changed(z) ? 131072 : 65536;
                        }
                        i13 = i6 & 64;
                        if (i13 != 0) {
                            i7 |= 1572864;
                            i14 = i2;
                        } else {
                            i14 = i2;
                            if ((i4 & 1572864) == 0) {
                                i7 |= startRestartGroup.changed(i14) ? 1048576 : 524288;
                            }
                        }
                        i15 = i6 & 128;
                        if (i15 != 0) {
                            i7 |= 12582912;
                        } else if ((i4 & 12582912) == 0) {
                            i16 = i15;
                            i7 |= startRestartGroup.changed(i3) ? 8388608 : 4194304;
                            i17 = i6 & 256;
                            if (i17 == 0) {
                                i7 |= 100663296;
                            } else if ((i4 & 100663296) == 0) {
                                i18 = i17;
                                i7 |= startRestartGroup.changedInstance(map) ? 67108864 : 33554432;
                                i19 = i6 & 512;
                                if (i19 != 0) {
                                    i7 |= 805306368;
                                } else if ((i4 & 805306368) == 0) {
                                    i20 = i19;
                                    i7 |= startRestartGroup.changedInstance(colorProducer) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
                                    i21 = i6 & 1024;
                                    if (i21 == 0) {
                                        i23 = i5 | 6;
                                    } else if ((i5 & 6) != 0) {
                                        i22 = i5;
                                        if (startRestartGroup.shouldExecute((i7 & 306783379) == 306783378 || (i22 & 3) != 2, i7 & 1)) {
                                            Modifier.Companion companion = i29 != 0 ? Modifier.Companion : modifier;
                                            TextStyle textStyle4 = i8 != 0 ? TextStyle.Companion.getDefault() : obj;
                                            Function1<? super TextLayoutResult, Unit> function15 = i9 != 0 ? null : obj2;
                                            if (i10 != 0) {
                                                i11 = TextOverflow.Companion.m6619getClipgIe3tQ8();
                                            }
                                            boolean z4 = i12 != 0 ? true : z;
                                            if (i13 != 0) {
                                                i14 = Integer.MAX_VALUE;
                                            }
                                            int i30 = i14;
                                            int i31 = i11;
                                            int i32 = i16 != 0 ? 1 : i3;
                                            Map<String, InlineTextContent> emptyMap = i18 != 0 ? MapsKt.emptyMap() : map;
                                            ColorProducer colorProducer3 = i20 != 0 ? null : colorProducer;
                                            TextAutoSize textAutoSize3 = i21 != 0 ? null : textAutoSize;
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-1343466571, i7, i22, "androidx.compose.foundation.text.BasicText (BasicText.kt:194)");
                                            }
                                            HeightInLinesModifierKt.validateMinMaxLines(i32, i30);
                                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                            Object consume = startRestartGroup.consume(SelectionRegistrarKt.getLocalSelectionRegistrar());
                                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                            final SelectionRegistrar selectionRegistrar = (SelectionRegistrar) consume;
                                            if (selectionRegistrar == null) {
                                                i26 = i22;
                                                modifier3 = companion;
                                                textStyle3 = textStyle4;
                                                function13 = function15;
                                                composer3 = startRestartGroup;
                                                i27 = i7;
                                                composer3.startReplaceGroup(-1583679630);
                                                composer3.endReplaceGroup();
                                                selectionController = null;
                                            } else {
                                                i26 = i22;
                                                startRestartGroup.startReplaceGroup(-1584170794);
                                                ComposerKt.sourceInformation(startRestartGroup, "199@10217L7,201@10371L77,201@10288L160,204@10461L180");
                                                modifier3 = companion;
                                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                                Object consume2 = startRestartGroup.consume(TextSelectionColorsKt.getLocalTextSelectionColors());
                                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                                long m1533getBackgroundColor0d7_KjU = ((TextSelectionColors) consume2).m1533getBackgroundColor0d7_KjU();
                                                Object[] objArr = {selectionRegistrar};
                                                Saver<Long, Long> selectionIdSaver = selectionIdSaver(selectionRegistrar);
                                                textStyle3 = textStyle4;
                                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -328190207, "CC(remember):BasicText.kt#9igjgp");
                                                boolean changedInstance = startRestartGroup.changedInstance(selectionRegistrar);
                                                Object rememberedValue = startRestartGroup.rememberedValue();
                                                if (changedInstance) {
                                                    function13 = function15;
                                                } else {
                                                    function13 = function15;
                                                }
                                                rememberedValue = (Function0) new Function0<Long>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$selectionController$selectableId$2$1
                                                    /* JADX INFO: Access modifiers changed from: package-private */
                                                    {
                                                        super(0);
                                                    }

                                                    /* JADX WARN: Can't rename method to resolve collision */
                                                    @Override // kotlin.jvm.functions.Function0
                                                    public final Long invoke() {
                                                        return Long.valueOf(SelectionRegistrar.this.nextSelectableId());
                                                    }
                                                };
                                                startRestartGroup.updateRememberedValue(rememberedValue);
                                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                                composer3 = startRestartGroup;
                                                i27 = i7;
                                                long longValue = ((Number) RememberSaveableKt.m3635rememberSaveable(objArr, selectionIdSaver, (String) null, (Function0<? extends Object>) rememberedValue, startRestartGroup, 0, 4)).longValue();
                                                ComposerKt.sourceInformationMarkerStart(composer3, -328187224, "CC(remember):BasicText.kt#9igjgp");
                                                boolean changed = composer3.changed(longValue) | composer3.changed(selectionRegistrar) | composer3.changed(m1533getBackgroundColor0d7_KjU);
                                                Object rememberedValue2 = composer3.rememberedValue();
                                                if (changed || rememberedValue2 == Composer.Companion.getEmpty()) {
                                                    rememberedValue2 = new SelectionController(longValue, selectionRegistrar, m1533getBackgroundColor0d7_KjU, null, 8, null);
                                                    composer3.updateRememberedValue(rememberedValue2);
                                                }
                                                selectionController = (SelectionController) rememberedValue2;
                                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                                composer3.endReplaceGroup();
                                            }
                                            boolean hasInlineContent = AnnotatedStringResolveInlineContentKt.hasInlineContent(annotatedString);
                                            boolean hasLinks = TextAnnotatedStringNodeKt.hasLinks(annotatedString);
                                            if (!hasInlineContent && !hasLinks) {
                                                composer3.startReplaceGroup(-1583500636);
                                                ComposerKt.sourceInformation(composer3, "224@11307L7,214@10891L757");
                                                ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                                Object consume3 = composer3.consume(CompositionLocalsKt.getLocalFontFamilyResolver());
                                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                                FontFamily.Resolver resolver = (FontFamily.Resolver) consume3;
                                                z3 = z4;
                                                annotatedString2 = annotatedString;
                                                Composer composer5 = composer3;
                                                i28 = i31;
                                                Function1<? super TextLayoutResult, Unit> function16 = function13;
                                                Modifier m1053textModifierCL7eQgs = m1053textModifierCL7eQgs(modifier3, annotatedString2, textStyle3, function16, i28, z3, i30, i32, resolver, null, null, selectionController, colorProducer3, null, textAutoSize3);
                                                EmptyMeasurePolicy emptyMeasurePolicy = EmptyMeasurePolicy.INSTANCE;
                                                ComposerKt.sourceInformationMarkerStart(composer5, 544976794, "CC(Layout)P(1)121@4798L23,124@4949L333:Layout.kt#80mrfh");
                                                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer5, 0);
                                                Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer5, m1053textModifierCL7eQgs);
                                                CompositionLocalMap currentCompositionLocalMap = composer5.getCurrentCompositionLocalMap();
                                                Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
                                                ComposerKt.sourceInformationMarkerStart(composer5, 1405779621, "CC(ReusableComposeNode):Composables.kt#9igjgp");
                                                if (!(composer5.getApplier() instanceof Applier)) {
                                                    ComposablesKt.invalidApplier();
                                                }
                                                composer5.startReusableNode();
                                                if (composer5.getInserting()) {
                                                    composer5.createNode(constructor);
                                                } else {
                                                    composer5.useNode();
                                                }
                                                Composer m3520constructorimpl = Updater.m3520constructorimpl(composer5);
                                                Updater.m3527setimpl(m3520constructorimpl, emptyMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                                                Updater.m3527setimpl(m3520constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                                Updater.m3527setimpl(m3520constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                                if (m3520constructorimpl.getInserting() || !Intrinsics.areEqual(m3520constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                    m3520constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                    m3520constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                                }
                                                composer5.endNode();
                                                ComposerKt.sourceInformationMarkerEnd(composer5);
                                                ComposerKt.sourceInformationMarkerEnd(composer5);
                                                composer5.endReplaceGroup();
                                                function14 = function16;
                                                composer4 = composer5;
                                            } else {
                                                annotatedString2 = annotatedString;
                                                Composer composer6 = composer3;
                                                z3 = z4;
                                                i28 = i31;
                                                Function1<? super TextLayoutResult, Unit> function17 = function13;
                                                SelectionController selectionController2 = selectionController;
                                                composer6.startReplaceGroup(-1582650709);
                                                ComposerKt.sourceInformation(composer6, "237@11821L39,250@12319L7,253@12442L292,239@11870L907");
                                                ComposerKt.sourceInformationMarkerStart(composer6, -328143845, "CC(remember):BasicText.kt#9igjgp");
                                                boolean z5 = (i27 & 14) == 4;
                                                Object rememberedValue3 = composer6.rememberedValue();
                                                if (z5 || rememberedValue3 == Composer.Companion.getEmpty()) {
                                                    rememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(annotatedString2, null, 2, null);
                                                    composer6.updateRememberedValue(rememberedValue3);
                                                }
                                                final MutableState mutableState = (MutableState) rememberedValue3;
                                                ComposerKt.sourceInformationMarkerEnd(composer6);
                                                AnnotatedString BasicText_CL7eQgs$lambda$5 = BasicText_CL7eQgs$lambda$5(mutableState);
                                                ComposerKt.sourceInformationMarkerStart(composer6, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                                Object consume4 = composer6.consume(CompositionLocalsKt.getLocalFontFamilyResolver());
                                                ComposerKt.sourceInformationMarkerEnd(composer6);
                                                FontFamily.Resolver resolver2 = (FontFamily.Resolver) consume4;
                                                ComposerKt.sourceInformationMarkerStart(composer6, -328123720, "CC(remember):BasicText.kt#9igjgp");
                                                boolean changed2 = composer6.changed(mutableState);
                                                Object rememberedValue4 = composer6.rememberedValue();
                                                if (changed2 || rememberedValue4 == Composer.Companion.getEmpty()) {
                                                    rememberedValue4 = (Function1) new Function1<TextAnnotatedStringNode.TextSubstitutionValue, Unit>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$2$1
                                                        /* JADX INFO: Access modifiers changed from: package-private */
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public /* bridge */ /* synthetic */ Unit invoke(TextAnnotatedStringNode.TextSubstitutionValue textSubstitutionValue) {
                                                            invoke2(textSubstitutionValue);
                                                            return Unit.INSTANCE;
                                                        }

                                                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                                                        public final void invoke2(TextAnnotatedStringNode.TextSubstitutionValue textSubstitutionValue) {
                                                            AnnotatedString original;
                                                            MutableState<AnnotatedString> mutableState2 = mutableState;
                                                            if (textSubstitutionValue.isShowingSubstitution()) {
                                                                original = textSubstitutionValue.getSubstitution();
                                                            } else {
                                                                original = textSubstitutionValue.getOriginal();
                                                            }
                                                            mutableState2.setValue(original);
                                                        }
                                                    };
                                                    composer6.updateRememberedValue(rememberedValue4);
                                                }
                                                ComposerKt.sourceInformationMarkerEnd(composer6);
                                                int i33 = i27 << 6;
                                                function14 = function17;
                                                Modifier modifier4 = modifier3;
                                                TextStyle textStyle5 = textStyle3;
                                                int i34 = i32;
                                                m1051LayoutWithLinksAndInlineContent11Od_4g(modifier4, BasicText_CL7eQgs$lambda$5, function14, hasInlineContent, emptyMap, textStyle5, i28, z3, i30, i34, resolver2, selectionController2, colorProducer3, rememberedValue4, textAutoSize3, composer6, ((i27 >> 3) & 910) | ((i27 >> 12) & 57344) | ((i27 << 9) & 458752) | (3670016 & i33) | (29360128 & i33) | (234881024 & i33) | (i33 & 1879048192), ((i27 >> 21) & 896) | ((i26 << 12) & 57344), 0);
                                                composer4 = composer6;
                                                textStyle3 = textStyle5;
                                                modifier3 = modifier4;
                                                composer4.endReplaceGroup();
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                            composer2 = composer4;
                                            i24 = i32;
                                            colorProducer2 = colorProducer3;
                                            textAutoSize2 = textAutoSize3;
                                            map2 = emptyMap;
                                            modifier2 = modifier3;
                                            textStyle2 = textStyle3;
                                            i14 = i30;
                                            z2 = z3;
                                            i25 = i28;
                                            function12 = function14;
                                        } else {
                                            annotatedString2 = annotatedString;
                                            startRestartGroup.skipToGroupEnd();
                                            modifier2 = modifier;
                                            i24 = i3;
                                            map2 = map;
                                            colorProducer2 = colorProducer;
                                            composer2 = startRestartGroup;
                                            i25 = i11;
                                            textStyle2 = obj;
                                            function12 = obj2;
                                            z2 = z;
                                            textAutoSize2 = textAutoSize;
                                        }
                                        endRestartGroup = composer2.endRestartGroup();
                                        if (endRestartGroup != null) {
                                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$3
                                                /* JADX INFO: Access modifiers changed from: package-private */
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                /* JADX WARN: Multi-variable type inference failed */
                                                {
                                                    super(2);
                                                }

                                                @Override // kotlin.jvm.functions.Function2
                                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer7, Integer num) {
                                                    invoke(composer7, num.intValue());
                                                    return Unit.INSTANCE;
                                                }

                                                public final void invoke(Composer composer7, int i35) {
                                                    BasicTextKt.m1046BasicTextCL7eQgs(AnnotatedString.this, modifier2, textStyle2, function12, i25, z2, i14, i24, map2, colorProducer2, textAutoSize2, composer7, RecomposeScopeImplKt.updateChangedFlags(i4 | 1), RecomposeScopeImplKt.updateChangedFlags(i5), i6);
                                                }
                                            });
                                            return;
                                        }
                                        return;
                                    } else {
                                        i23 = i5 | ((i5 & 8) == 0 ? startRestartGroup.changed(textAutoSize) : startRestartGroup.changedInstance(textAutoSize) ? 4 : 2);
                                    }
                                    i22 = i23;
                                    if (startRestartGroup.shouldExecute((i7 & 306783379) == 306783378 || (i22 & 3) != 2, i7 & 1)) {
                                    }
                                    endRestartGroup = composer2.endRestartGroup();
                                    if (endRestartGroup != null) {
                                    }
                                }
                                i20 = i19;
                                i21 = i6 & 1024;
                                if (i21 == 0) {
                                }
                                i22 = i23;
                                if (startRestartGroup.shouldExecute((i7 & 306783379) == 306783378 || (i22 & 3) != 2, i7 & 1)) {
                                }
                                endRestartGroup = composer2.endRestartGroup();
                                if (endRestartGroup != null) {
                                }
                            }
                            i18 = i17;
                            i19 = i6 & 512;
                            if (i19 != 0) {
                            }
                            i20 = i19;
                            i21 = i6 & 1024;
                            if (i21 == 0) {
                            }
                            i22 = i23;
                            if (startRestartGroup.shouldExecute((i7 & 306783379) == 306783378 || (i22 & 3) != 2, i7 & 1)) {
                            }
                            endRestartGroup = composer2.endRestartGroup();
                            if (endRestartGroup != null) {
                            }
                        }
                        i16 = i15;
                        i17 = i6 & 256;
                        if (i17 == 0) {
                        }
                        i18 = i17;
                        i19 = i6 & 512;
                        if (i19 != 0) {
                        }
                        i20 = i19;
                        i21 = i6 & 1024;
                        if (i21 == 0) {
                        }
                        i22 = i23;
                        if (startRestartGroup.shouldExecute((i7 & 306783379) == 306783378 || (i22 & 3) != 2, i7 & 1)) {
                        }
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                        }
                    }
                    i11 = i;
                    i12 = i6 & 32;
                    if (i12 != 0) {
                    }
                    i13 = i6 & 64;
                    if (i13 != 0) {
                    }
                    i15 = i6 & 128;
                    if (i15 != 0) {
                    }
                    i16 = i15;
                    i17 = i6 & 256;
                    if (i17 == 0) {
                    }
                    i18 = i17;
                    i19 = i6 & 512;
                    if (i19 != 0) {
                    }
                    i20 = i19;
                    i21 = i6 & 1024;
                    if (i21 == 0) {
                    }
                    i22 = i23;
                    if (startRestartGroup.shouldExecute((i7 & 306783379) == 306783378 || (i22 & 3) != 2, i7 & 1)) {
                    }
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                obj2 = function1;
                i10 = i6 & 16;
                if (i10 == 0) {
                }
                i11 = i;
                i12 = i6 & 32;
                if (i12 != 0) {
                }
                i13 = i6 & 64;
                if (i13 != 0) {
                }
                i15 = i6 & 128;
                if (i15 != 0) {
                }
                i16 = i15;
                i17 = i6 & 256;
                if (i17 == 0) {
                }
                i18 = i17;
                i19 = i6 & 512;
                if (i19 != 0) {
                }
                i20 = i19;
                i21 = i6 & 1024;
                if (i21 == 0) {
                }
                i22 = i23;
                if (startRestartGroup.shouldExecute((i7 & 306783379) == 306783378 || (i22 & 3) != 2, i7 & 1)) {
                }
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            obj = textStyle;
            i9 = i6 & 8;
            if (i9 != 0) {
            }
            obj2 = function1;
            i10 = i6 & 16;
            if (i10 == 0) {
            }
            i11 = i;
            i12 = i6 & 32;
            if (i12 != 0) {
            }
            i13 = i6 & 64;
            if (i13 != 0) {
            }
            i15 = i6 & 128;
            if (i15 != 0) {
            }
            i16 = i15;
            i17 = i6 & 256;
            if (i17 == 0) {
            }
            i18 = i17;
            i19 = i6 & 512;
            if (i19 != 0) {
            }
            i20 = i19;
            i21 = i6 & 1024;
            if (i21 == 0) {
            }
            i22 = i23;
            if (startRestartGroup.shouldExecute((i7 & 306783379) == 306783378 || (i22 & 3) != 2, i7 & 1)) {
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        i8 = i6 & 4;
        if (i8 == 0) {
        }
        obj = textStyle;
        i9 = i6 & 8;
        if (i9 != 0) {
        }
        obj2 = function1;
        i10 = i6 & 16;
        if (i10 == 0) {
        }
        i11 = i;
        i12 = i6 & 32;
        if (i12 != 0) {
        }
        i13 = i6 & 64;
        if (i13 != 0) {
        }
        i15 = i6 & 128;
        if (i15 != 0) {
        }
        i16 = i15;
        i17 = i6 & 256;
        if (i17 == 0) {
        }
        i18 = i17;
        i19 = i6 & 512;
        if (i19 != 0) {
        }
        i20 = i19;
        i21 = i6 & 1024;
        if (i21 == 0) {
        }
        i22 = i23;
        if (startRestartGroup.shouldExecute((i7 & 306783379) == 306783378 || (i22 & 3) != 2, i7 & 1)) {
        }
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    private static final AnnotatedString BasicText_CL7eQgs$lambda$5(MutableState<AnnotatedString> mutableState) {
        return mutableState.getValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:171:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:284:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:287:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:289:? A[RETURN, SYNTHETIC] */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* renamed from: BasicText-VhcvRP8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void m1050BasicTextVhcvRP8(final String str, Modifier modifier, TextStyle textStyle, Function1 function1, int i, boolean z, int i2, int i3, ColorProducer colorProducer, Composer composer, final int i4, final int i5) {
        String str2;
        int i6;
        Object obj;
        int i7;
        Object obj2;
        int i8;
        Object obj3;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        Composer composer2;
        final int i16;
        final int i17;
        final ColorProducer colorProducer2;
        final Modifier modifier2;
        final TextStyle textStyle2;
        final Function1 function12;
        final boolean z2;
        final int i18;
        ScopeUpdateScope endRestartGroup;
        int i19;
        TextStyle textStyle3;
        int i20;
        int i21;
        int i22;
        int i23;
        int i24;
        int i25;
        Composer startRestartGroup = composer.startRestartGroup(-1186827822);
        ComposerKt.sourceInformation(startRestartGroup, "C(BasicText)P(8,3,7,4,5:c#ui.text.style.TextOverflow,6,1,2)302@14843L93:BasicText.kt#423gt5");
        if ((i5 & 1) != 0) {
            i6 = i4 | 6;
            str2 = str;
        } else {
            str2 = str;
            if ((i4 & 6) == 0) {
                i6 = (startRestartGroup.changed(str2) ? 4 : 2) | i4;
            } else {
                i6 = i4;
            }
        }
        int i26 = i5 & 2;
        if (i26 != 0) {
            i6 |= 48;
        } else if ((i4 & 48) == 0) {
            obj = modifier;
            i6 |= startRestartGroup.changed(obj) ? 32 : 16;
            i7 = i5 & 4;
            if (i7 == 0) {
                i6 |= RendererCapabilities.DECODER_SUPPORT_MASK;
            } else if ((i4 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                obj2 = textStyle;
                i6 |= startRestartGroup.changed(obj2) ? 256 : 128;
                i8 = i5 & 8;
                if (i8 != 0) {
                    i6 |= 3072;
                } else if ((i4 & 3072) == 0) {
                    obj3 = function1;
                    i6 |= startRestartGroup.changedInstance(obj3) ? 2048 : 1024;
                    i9 = i5 & 16;
                    if (i9 == 0) {
                        i6 |= 24576;
                    } else if ((i4 & 24576) == 0) {
                        i6 |= startRestartGroup.changed(i) ? 16384 : 8192;
                        i10 = i5 & 32;
                        if (i10 != 0) {
                            i6 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        } else if ((196608 & i4) == 0) {
                            i6 |= startRestartGroup.changed(z) ? 131072 : 65536;
                            i11 = i5 & 64;
                            if (i11 == 0) {
                                i6 |= 1572864;
                            } else if ((i4 & 1572864) == 0) {
                                i6 |= startRestartGroup.changed(i2) ? 1048576 : 524288;
                            }
                            i12 = i5 & 128;
                            if (i12 == 0) {
                                i6 |= 12582912;
                            } else if ((i4 & 12582912) == 0) {
                                i13 = i12;
                                i6 |= startRestartGroup.changed(i3) ? 8388608 : 4194304;
                                i14 = i5 & 256;
                                if (i14 != 0) {
                                    i6 |= 100663296;
                                } else if ((i4 & 100663296) == 0) {
                                    i15 = i14;
                                    i6 |= startRestartGroup.changedInstance(colorProducer) ? 67108864 : 33554432;
                                    if (!startRestartGroup.shouldExecute((i6 & 38347923) == 38347922, i6 & 1)) {
                                        Modifier.Companion companion = i26 != 0 ? Modifier.Companion : obj;
                                        if (i7 != 0) {
                                            textStyle3 = TextStyle.Companion.getDefault();
                                            i19 = i10;
                                        } else {
                                            i19 = i10;
                                            textStyle3 = obj2;
                                        }
                                        Function1 function13 = i8 != 0 ? null : obj3;
                                        if (i9 != 0) {
                                            i21 = TextOverflow.Companion.m6619getClipgIe3tQ8();
                                            i20 = i11;
                                        } else {
                                            i20 = i11;
                                            i21 = i;
                                        }
                                        boolean z3 = i19 != 0 ? true : z;
                                        if (i20 != 0) {
                                            int i27 = i13;
                                            i23 = Integer.MAX_VALUE;
                                            i22 = i27;
                                        } else {
                                            i22 = i13;
                                            i23 = i2;
                                        }
                                        if (i22 != 0) {
                                            i24 = i15;
                                            i25 = 1;
                                        } else {
                                            i24 = i15;
                                            i25 = i3;
                                        }
                                        ColorProducer colorProducer3 = i24 != 0 ? null : colorProducer;
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-1186827822, i6, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:301)");
                                        }
                                        composer2 = startRestartGroup;
                                        m1048BasicTextRWo7tUw(str2, companion, textStyle3, function13, i21, z3, i23, i25, colorProducer3, (TextAutoSize) null, composer2, i6 & 268435454, 512);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                        modifier2 = companion;
                                        textStyle2 = textStyle3;
                                        function12 = function13;
                                        i16 = i21;
                                        z2 = z3;
                                        i17 = i23;
                                        i18 = i25;
                                        colorProducer2 = colorProducer3;
                                    } else {
                                        composer2 = startRestartGroup;
                                        composer2.skipToGroupEnd();
                                        i16 = i;
                                        i17 = i2;
                                        colorProducer2 = colorProducer;
                                        modifier2 = obj;
                                        textStyle2 = obj2;
                                        function12 = obj3;
                                        z2 = z;
                                        i18 = i3;
                                    }
                                    endRestartGroup = composer2.endRestartGroup();
                                    if (endRestartGroup == null) {
                                        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$4
                                            /* JADX INFO: Access modifiers changed from: package-private */
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(2);
                                            }

                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                                invoke(composer3, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(Composer composer3, int i28) {
                                                BasicTextKt.m1050BasicTextVhcvRP8(str, modifier2, textStyle2, function12, i16, z2, i17, i18, colorProducer2, composer3, RecomposeScopeImplKt.updateChangedFlags(i4 | 1), i5);
                                            }
                                        });
                                        return;
                                    }
                                    return;
                                }
                                i15 = i14;
                                if (!startRestartGroup.shouldExecute((i6 & 38347923) == 38347922, i6 & 1)) {
                                }
                                endRestartGroup = composer2.endRestartGroup();
                                if (endRestartGroup == null) {
                                }
                            }
                            i13 = i12;
                            i14 = i5 & 256;
                            if (i14 != 0) {
                            }
                            i15 = i14;
                            if (!startRestartGroup.shouldExecute((i6 & 38347923) == 38347922, i6 & 1)) {
                            }
                            endRestartGroup = composer2.endRestartGroup();
                            if (endRestartGroup == null) {
                            }
                        }
                        i11 = i5 & 64;
                        if (i11 == 0) {
                        }
                        i12 = i5 & 128;
                        if (i12 == 0) {
                        }
                        i13 = i12;
                        i14 = i5 & 256;
                        if (i14 != 0) {
                        }
                        i15 = i14;
                        if (!startRestartGroup.shouldExecute((i6 & 38347923) == 38347922, i6 & 1)) {
                        }
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup == null) {
                        }
                    }
                    i10 = i5 & 32;
                    if (i10 != 0) {
                    }
                    i11 = i5 & 64;
                    if (i11 == 0) {
                    }
                    i12 = i5 & 128;
                    if (i12 == 0) {
                    }
                    i13 = i12;
                    i14 = i5 & 256;
                    if (i14 != 0) {
                    }
                    i15 = i14;
                    if (!startRestartGroup.shouldExecute((i6 & 38347923) == 38347922, i6 & 1)) {
                    }
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup == null) {
                    }
                }
                obj3 = function1;
                i9 = i5 & 16;
                if (i9 == 0) {
                }
                i10 = i5 & 32;
                if (i10 != 0) {
                }
                i11 = i5 & 64;
                if (i11 == 0) {
                }
                i12 = i5 & 128;
                if (i12 == 0) {
                }
                i13 = i12;
                i14 = i5 & 256;
                if (i14 != 0) {
                }
                i15 = i14;
                if (!startRestartGroup.shouldExecute((i6 & 38347923) == 38347922, i6 & 1)) {
                }
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            obj2 = textStyle;
            i8 = i5 & 8;
            if (i8 != 0) {
            }
            obj3 = function1;
            i9 = i5 & 16;
            if (i9 == 0) {
            }
            i10 = i5 & 32;
            if (i10 != 0) {
            }
            i11 = i5 & 64;
            if (i11 == 0) {
            }
            i12 = i5 & 128;
            if (i12 == 0) {
            }
            i13 = i12;
            i14 = i5 & 256;
            if (i14 != 0) {
            }
            i15 = i14;
            if (!startRestartGroup.shouldExecute((i6 & 38347923) == 38347922, i6 & 1)) {
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        obj = modifier;
        i7 = i5 & 4;
        if (i7 == 0) {
        }
        obj2 = textStyle;
        i8 = i5 & 8;
        if (i8 != 0) {
        }
        obj3 = function1;
        i9 = i5 & 16;
        if (i9 == 0) {
        }
        i10 = i5 & 32;
        if (i10 != 0) {
        }
        i11 = i5 & 64;
        if (i11 == 0) {
        }
        i12 = i5 & 128;
        if (i12 == 0) {
        }
        i13 = i12;
        i14 = i5 & 256;
        if (i14 != 0) {
        }
        i15 = i14;
        if (!startRestartGroup.shouldExecute((i6 & 38347923) == 38347922, i6 & 1)) {
        }
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:185:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:261:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:262:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:272:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:273:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:276:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:312:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:315:0x0215  */
    /* JADX WARN: Removed duplicated region for block: B:317:? A[RETURN, SYNTHETIC] */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* renamed from: BasicText-RWo7tUw */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void m1047BasicTextRWo7tUw(final AnnotatedString annotatedString, Modifier modifier, TextStyle textStyle, Function1 function1, int i, boolean z, int i2, int i3, Map map, ColorProducer colorProducer, Composer composer, final int i4, final int i5) {
        AnnotatedString annotatedString2;
        int i6;
        Object obj;
        int i7;
        Object obj2;
        int i8;
        Object obj3;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        Composer composer2;
        final int i19;
        final Map map2;
        final Modifier modifier2;
        final TextStyle textStyle2;
        final Function1 function12;
        final int i20;
        final boolean z2;
        final int i21;
        final ColorProducer colorProducer2;
        ScopeUpdateScope endRestartGroup;
        int i22;
        Modifier.Companion companion;
        int i23;
        boolean z3;
        int i24;
        int i25;
        int i26;
        int i27;
        Composer startRestartGroup = composer.startRestartGroup(-1064305212);
        ComposerKt.sourceInformation(startRestartGroup, "C(BasicText)P(9,4,8,5,6:c#ui.text.style.TextOverflow,7,2,3,1)344@17259L194:BasicText.kt#423gt5");
        if ((i5 & 1) != 0) {
            i6 = i4 | 6;
            annotatedString2 = annotatedString;
        } else {
            annotatedString2 = annotatedString;
            if ((i4 & 6) == 0) {
                i6 = (startRestartGroup.changed(annotatedString2) ? 4 : 2) | i4;
            } else {
                i6 = i4;
            }
        }
        int i28 = i5 & 2;
        if (i28 != 0) {
            i6 |= 48;
        } else if ((i4 & 48) == 0) {
            obj = modifier;
            i6 |= startRestartGroup.changed(obj) ? 32 : 16;
            i7 = i5 & 4;
            if (i7 == 0) {
                i6 |= RendererCapabilities.DECODER_SUPPORT_MASK;
            } else if ((i4 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                obj2 = textStyle;
                i6 |= startRestartGroup.changed(obj2) ? 256 : 128;
                i8 = i5 & 8;
                if (i8 != 0) {
                    i6 |= 3072;
                } else if ((i4 & 3072) == 0) {
                    obj3 = function1;
                    i6 |= startRestartGroup.changedInstance(obj3) ? 2048 : 1024;
                    i9 = i5 & 16;
                    if (i9 == 0) {
                        i6 |= 24576;
                    } else if ((i4 & 24576) == 0) {
                        i10 = i;
                        i6 |= startRestartGroup.changed(i10) ? 16384 : 8192;
                        i11 = i5 & 32;
                        if (i11 != 0) {
                            i6 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        } else if ((196608 & i4) == 0) {
                            i6 |= startRestartGroup.changed(z) ? 131072 : 65536;
                            i12 = i5 & 64;
                            if (i12 == 0) {
                                i6 |= 1572864;
                            } else if ((i4 & 1572864) == 0) {
                                i6 |= startRestartGroup.changed(i2) ? 1048576 : 524288;
                            }
                            i13 = i5 & 128;
                            if (i13 == 0) {
                                i6 |= 12582912;
                            } else if ((i4 & 12582912) == 0) {
                                i14 = i13;
                                i6 |= startRestartGroup.changed(i3) ? 8388608 : 4194304;
                                i15 = i5 & 256;
                                if (i15 != 0) {
                                    i6 |= 100663296;
                                } else if ((i4 & 100663296) == 0) {
                                    i16 = i15;
                                    i6 |= startRestartGroup.changedInstance(map) ? 67108864 : 33554432;
                                    i17 = i5 & 512;
                                    if (i17 == 0) {
                                        i6 |= 805306368;
                                    } else if ((i4 & 805306368) == 0) {
                                        i18 = i17;
                                        i6 |= startRestartGroup.changedInstance(colorProducer) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
                                        if (startRestartGroup.shouldExecute((i6 & 306783379) != 306783378, i6 & 1)) {
                                            if (i28 != 0) {
                                                companion = Modifier.Companion;
                                                i22 = i11;
                                            } else {
                                                i22 = i11;
                                                companion = obj;
                                            }
                                            TextStyle textStyle3 = i7 != 0 ? TextStyle.Companion.getDefault() : obj2;
                                            Function1 function13 = i8 != 0 ? null : obj3;
                                            int m6619getClipgIe3tQ8 = i9 != 0 ? TextOverflow.Companion.m6619getClipgIe3tQ8() : i10;
                                            if (i22 != 0) {
                                                i23 = i14;
                                                z3 = true;
                                            } else {
                                                i23 = i14;
                                                z3 = z;
                                            }
                                            if (i12 != 0) {
                                                int i29 = i16;
                                                i25 = Integer.MAX_VALUE;
                                                i24 = i29;
                                            } else {
                                                i24 = i16;
                                                i25 = i2;
                                            }
                                            if (i23 != 0) {
                                                i26 = i18;
                                                i27 = 1;
                                            } else {
                                                i26 = i18;
                                                i27 = i3;
                                            }
                                            Map emptyMap = i24 != 0 ? MapsKt.emptyMap() : map;
                                            ColorProducer colorProducer3 = i26 != 0 ? null : colorProducer;
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-1064305212, i6, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:343)");
                                            }
                                            composer2 = startRestartGroup;
                                            m1046BasicTextCL7eQgs(annotatedString2, companion, textStyle3, function13, m6619getClipgIe3tQ8, z3, i25, i27, emptyMap, colorProducer3, null, composer2, i6 & 2147483646, 0, 1024);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                            modifier2 = companion;
                                            textStyle2 = textStyle3;
                                            function12 = function13;
                                            i20 = m6619getClipgIe3tQ8;
                                            z2 = z3;
                                            i19 = i25;
                                            i21 = i27;
                                            map2 = emptyMap;
                                            colorProducer2 = colorProducer3;
                                        } else {
                                            composer2 = startRestartGroup;
                                            composer2.skipToGroupEnd();
                                            i19 = i2;
                                            map2 = map;
                                            modifier2 = obj;
                                            textStyle2 = obj2;
                                            function12 = obj3;
                                            i20 = i10;
                                            z2 = z;
                                            i21 = i3;
                                            colorProducer2 = colorProducer;
                                        }
                                        endRestartGroup = composer2.endRestartGroup();
                                        if (endRestartGroup != null) {
                                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$5
                                                /* JADX INFO: Access modifiers changed from: package-private */
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                /* JADX WARN: Multi-variable type inference failed */
                                                {
                                                    super(2);
                                                }

                                                @Override // kotlin.jvm.functions.Function2
                                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                                    invoke(composer3, num.intValue());
                                                    return Unit.INSTANCE;
                                                }

                                                public final void invoke(Composer composer3, int i30) {
                                                    BasicTextKt.m1047BasicTextRWo7tUw(AnnotatedString.this, modifier2, textStyle2, function12, i20, z2, i19, i21, map2, colorProducer2, composer3, RecomposeScopeImplKt.updateChangedFlags(i4 | 1), i5);
                                                }
                                            });
                                            return;
                                        }
                                        return;
                                    }
                                    i18 = i17;
                                    if (startRestartGroup.shouldExecute((i6 & 306783379) != 306783378, i6 & 1)) {
                                    }
                                    endRestartGroup = composer2.endRestartGroup();
                                    if (endRestartGroup != null) {
                                    }
                                }
                                i16 = i15;
                                i17 = i5 & 512;
                                if (i17 == 0) {
                                }
                                i18 = i17;
                                if (startRestartGroup.shouldExecute((i6 & 306783379) != 306783378, i6 & 1)) {
                                }
                                endRestartGroup = composer2.endRestartGroup();
                                if (endRestartGroup != null) {
                                }
                            }
                            i14 = i13;
                            i15 = i5 & 256;
                            if (i15 != 0) {
                            }
                            i16 = i15;
                            i17 = i5 & 512;
                            if (i17 == 0) {
                            }
                            i18 = i17;
                            if (startRestartGroup.shouldExecute((i6 & 306783379) != 306783378, i6 & 1)) {
                            }
                            endRestartGroup = composer2.endRestartGroup();
                            if (endRestartGroup != null) {
                            }
                        }
                        i12 = i5 & 64;
                        if (i12 == 0) {
                        }
                        i13 = i5 & 128;
                        if (i13 == 0) {
                        }
                        i14 = i13;
                        i15 = i5 & 256;
                        if (i15 != 0) {
                        }
                        i16 = i15;
                        i17 = i5 & 512;
                        if (i17 == 0) {
                        }
                        i18 = i17;
                        if (startRestartGroup.shouldExecute((i6 & 306783379) != 306783378, i6 & 1)) {
                        }
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                        }
                    }
                    i10 = i;
                    i11 = i5 & 32;
                    if (i11 != 0) {
                    }
                    i12 = i5 & 64;
                    if (i12 == 0) {
                    }
                    i13 = i5 & 128;
                    if (i13 == 0) {
                    }
                    i14 = i13;
                    i15 = i5 & 256;
                    if (i15 != 0) {
                    }
                    i16 = i15;
                    i17 = i5 & 512;
                    if (i17 == 0) {
                    }
                    i18 = i17;
                    if (startRestartGroup.shouldExecute((i6 & 306783379) != 306783378, i6 & 1)) {
                    }
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                obj3 = function1;
                i9 = i5 & 16;
                if (i9 == 0) {
                }
                i10 = i;
                i11 = i5 & 32;
                if (i11 != 0) {
                }
                i12 = i5 & 64;
                if (i12 == 0) {
                }
                i13 = i5 & 128;
                if (i13 == 0) {
                }
                i14 = i13;
                i15 = i5 & 256;
                if (i15 != 0) {
                }
                i16 = i15;
                i17 = i5 & 512;
                if (i17 == 0) {
                }
                i18 = i17;
                if (startRestartGroup.shouldExecute((i6 & 306783379) != 306783378, i6 & 1)) {
                }
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            obj2 = textStyle;
            i8 = i5 & 8;
            if (i8 != 0) {
            }
            obj3 = function1;
            i9 = i5 & 16;
            if (i9 == 0) {
            }
            i10 = i;
            i11 = i5 & 32;
            if (i11 != 0) {
            }
            i12 = i5 & 64;
            if (i12 == 0) {
            }
            i13 = i5 & 128;
            if (i13 == 0) {
            }
            i14 = i13;
            i15 = i5 & 256;
            if (i15 != 0) {
            }
            i16 = i15;
            i17 = i5 & 512;
            if (i17 == 0) {
            }
            i18 = i17;
            if (startRestartGroup.shouldExecute((i6 & 306783379) != 306783378, i6 & 1)) {
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        obj = modifier;
        i7 = i5 & 4;
        if (i7 == 0) {
        }
        obj2 = textStyle;
        i8 = i5 & 8;
        if (i8 != 0) {
        }
        obj3 = function1;
        i9 = i5 & 16;
        if (i9 == 0) {
        }
        i10 = i;
        i11 = i5 & 32;
        if (i11 != 0) {
        }
        i12 = i5 & 64;
        if (i12 == 0) {
        }
        i13 = i5 & 128;
        if (i13 == 0) {
        }
        i14 = i13;
        i15 = i5 & 256;
        if (i15 != 0) {
        }
        i16 = i15;
        i17 = i5 & 512;
        if (i17 == 0) {
        }
        i18 = i17;
        if (startRestartGroup.shouldExecute((i6 & 306783379) != 306783378, i6 & 1)) {
        }
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:140:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:227:? A[RETURN, SYNTHETIC] */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* renamed from: BasicText-BpD7jsM */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void m1045BasicTextBpD7jsM(final String str, Modifier modifier, TextStyle textStyle, Function1 function1, int i, boolean z, int i2, Composer composer, final int i3, final int i4) {
        String str2;
        int i5;
        Object obj;
        int i6;
        Object obj2;
        int i7;
        int i8;
        int i9;
        boolean z2;
        int i10;
        Composer composer2;
        final int i11;
        final int i12;
        final Modifier modifier2;
        final TextStyle textStyle2;
        final Function1 function12;
        ScopeUpdateScope endRestartGroup;
        int i13;
        TextStyle textStyle3;
        int i14;
        int i15;
        Composer startRestartGroup = composer.startRestartGroup(1022429478);
        ComposerKt.sourceInformation(startRestartGroup, "C(BasicText)P(6,1,5,2,3:c#ui.text.style.TextOverflow,4)369@17839L234:BasicText.kt#423gt5");
        if ((i4 & 1) != 0) {
            i5 = i3 | 6;
            str2 = str;
        } else {
            str2 = str;
            if ((i3 & 6) == 0) {
                i5 = (startRestartGroup.changed(str2) ? 4 : 2) | i3;
            } else {
                i5 = i3;
            }
        }
        int i16 = i4 & 2;
        if (i16 != 0) {
            i5 |= 48;
        } else if ((i3 & 48) == 0) {
            obj = modifier;
            i5 |= startRestartGroup.changed(obj) ? 32 : 16;
            i6 = i4 & 4;
            if (i6 == 0) {
                i5 |= RendererCapabilities.DECODER_SUPPORT_MASK;
            } else if ((i3 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                obj2 = textStyle;
                i5 |= startRestartGroup.changed(obj2) ? 256 : 128;
                i7 = i4 & 8;
                if (i7 != 0) {
                    i5 |= 3072;
                } else if ((i3 & 3072) == 0) {
                    i5 |= startRestartGroup.changedInstance(function1) ? 2048 : 1024;
                    i8 = i4 & 16;
                    if (i8 == 0) {
                        i5 |= 24576;
                    } else if ((i3 & 24576) == 0) {
                        i5 |= startRestartGroup.changed(i) ? 16384 : 8192;
                        i9 = i4 & 32;
                        if (i9 != 0) {
                            i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        } else if ((196608 & i3) == 0) {
                            z2 = z;
                            i5 |= startRestartGroup.changed(z2) ? 131072 : 65536;
                            i10 = i4 & 64;
                            if (i10 == 0) {
                                i5 |= 1572864;
                            } else if ((i3 & 1572864) == 0) {
                                i5 |= startRestartGroup.changed(i2) ? 1048576 : 524288;
                            }
                            if (!startRestartGroup.shouldExecute((i5 & 599187) == 599186, i5 & 1)) {
                                Modifier.Companion companion = i16 != 0 ? Modifier.Companion : obj;
                                if (i6 != 0) {
                                    textStyle3 = TextStyle.Companion.getDefault();
                                    i13 = i8;
                                } else {
                                    i13 = i8;
                                    textStyle3 = obj2;
                                }
                                Function1 function13 = i7 != 0 ? null : function1;
                                if (i13 != 0) {
                                    i15 = TextOverflow.Companion.m6619getClipgIe3tQ8();
                                    i14 = i9;
                                } else {
                                    i14 = i9;
                                    i15 = i;
                                }
                                if (i14 != 0) {
                                    z2 = true;
                                }
                                int i17 = i10 != 0 ? Integer.MAX_VALUE : i2;
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1022429478, i5, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:368)");
                                }
                                composer2 = startRestartGroup;
                                m1048BasicTextRWo7tUw(str2, companion, textStyle3, function13, i15, z2, i17, 1, (ColorProducer) null, (TextAutoSize) null, composer2, (i5 & 14) | 12582912 | (i5 & 112) | (i5 & 896) | (i5 & 7168) | (57344 & i5) | (458752 & i5) | (i5 & 3670016), (int) ViewUtils.EDGE_TO_EDGE_FLAGS);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                modifier2 = companion;
                                textStyle2 = textStyle3;
                                function12 = function13;
                                i11 = i15;
                                i12 = i17;
                            } else {
                                composer2 = startRestartGroup;
                                composer2.skipToGroupEnd();
                                i11 = i;
                                i12 = i2;
                                modifier2 = obj;
                                textStyle2 = obj2;
                                function12 = function1;
                            }
                            final boolean z3 = z2;
                            endRestartGroup = composer2.endRestartGroup();
                            if (endRestartGroup == null) {
                                endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$6
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                        invoke(composer3, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer3, int i18) {
                                        BasicTextKt.m1045BasicTextBpD7jsM(str, modifier2, textStyle2, function12, i11, z3, i12, composer3, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), i4);
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        z2 = z;
                        i10 = i4 & 64;
                        if (i10 == 0) {
                        }
                        if (!startRestartGroup.shouldExecute((i5 & 599187) == 599186, i5 & 1)) {
                        }
                        final boolean z32 = z2;
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup == null) {
                        }
                    }
                    i9 = i4 & 32;
                    if (i9 != 0) {
                    }
                    z2 = z;
                    i10 = i4 & 64;
                    if (i10 == 0) {
                    }
                    if (!startRestartGroup.shouldExecute((i5 & 599187) == 599186, i5 & 1)) {
                    }
                    final boolean z322 = z2;
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup == null) {
                    }
                }
                i8 = i4 & 16;
                if (i8 == 0) {
                }
                i9 = i4 & 32;
                if (i9 != 0) {
                }
                z2 = z;
                i10 = i4 & 64;
                if (i10 == 0) {
                }
                if (!startRestartGroup.shouldExecute((i5 & 599187) == 599186, i5 & 1)) {
                }
                final boolean z3222 = z2;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            obj2 = textStyle;
            i7 = i4 & 8;
            if (i7 != 0) {
            }
            i8 = i4 & 16;
            if (i8 == 0) {
            }
            i9 = i4 & 32;
            if (i9 != 0) {
            }
            z2 = z;
            i10 = i4 & 64;
            if (i10 == 0) {
            }
            if (!startRestartGroup.shouldExecute((i5 & 599187) == 599186, i5 & 1)) {
            }
            final boolean z32222 = z2;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        obj = modifier;
        i6 = i4 & 4;
        if (i6 == 0) {
        }
        obj2 = textStyle;
        i7 = i4 & 8;
        if (i7 != 0) {
        }
        i8 = i4 & 16;
        if (i8 == 0) {
        }
        i9 = i4 & 32;
        if (i9 != 0) {
        }
        z2 = z;
        i10 = i4 & 64;
        if (i10 == 0) {
        }
        if (!startRestartGroup.shouldExecute((i5 & 599187) == 599186, i5 & 1)) {
        }
        final boolean z322222 = z2;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:157:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:259:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:261:? A[RETURN, SYNTHETIC] */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* renamed from: BasicText-4YKlhWE */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void m1043BasicText4YKlhWE(final AnnotatedString annotatedString, Modifier modifier, TextStyle textStyle, Function1 function1, int i, boolean z, int i2, Map map, Composer composer, final int i3, final int i4) {
        AnnotatedString annotatedString2;
        int i5;
        Object obj;
        int i6;
        Object obj2;
        int i7;
        Object obj3;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        Composer composer2;
        final int i13;
        final int i14;
        final Modifier modifier2;
        final TextStyle textStyle2;
        final Function1 function12;
        final boolean z2;
        final Map map2;
        ScopeUpdateScope endRestartGroup;
        int i15;
        Modifier.Companion companion;
        int i16;
        Function1 function13;
        Composer startRestartGroup = composer.startRestartGroup(-648605928);
        ComposerKt.sourceInformation(startRestartGroup, "C(BasicText)P(7,2,6,3,4:c#ui.text.style.TextOverflow,5,1)393@18530L273:BasicText.kt#423gt5");
        if ((i4 & 1) != 0) {
            i5 = i3 | 6;
            annotatedString2 = annotatedString;
        } else {
            annotatedString2 = annotatedString;
            if ((i3 & 6) == 0) {
                i5 = (startRestartGroup.changed(annotatedString2) ? 4 : 2) | i3;
            } else {
                i5 = i3;
            }
        }
        int i17 = i4 & 2;
        if (i17 != 0) {
            i5 |= 48;
        } else if ((i3 & 48) == 0) {
            obj = modifier;
            i5 |= startRestartGroup.changed(obj) ? 32 : 16;
            i6 = i4 & 4;
            if (i6 == 0) {
                i5 |= RendererCapabilities.DECODER_SUPPORT_MASK;
            } else if ((i3 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                obj2 = textStyle;
                i5 |= startRestartGroup.changed(obj2) ? 256 : 128;
                i7 = i4 & 8;
                if (i7 != 0) {
                    i5 |= 3072;
                } else if ((i3 & 3072) == 0) {
                    obj3 = function1;
                    i5 |= startRestartGroup.changedInstance(obj3) ? 2048 : 1024;
                    i8 = i4 & 16;
                    if (i8 == 0) {
                        i5 |= 24576;
                    } else if ((i3 & 24576) == 0) {
                        i5 |= startRestartGroup.changed(i) ? 16384 : 8192;
                        i9 = i4 & 32;
                        if (i9 != 0) {
                            i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        } else if ((196608 & i3) == 0) {
                            i5 |= startRestartGroup.changed(z) ? 131072 : 65536;
                            i10 = i4 & 64;
                            if (i10 == 0) {
                                i5 |= 1572864;
                            } else if ((i3 & 1572864) == 0) {
                                i5 |= startRestartGroup.changed(i2) ? 1048576 : 524288;
                            }
                            i11 = i4 & 128;
                            if (i11 == 0) {
                                i5 |= 12582912;
                            } else if ((i3 & 12582912) == 0) {
                                i12 = i11;
                                i5 |= startRestartGroup.changedInstance(map) ? 8388608 : 4194304;
                                if (startRestartGroup.shouldExecute((i5 & 4793491) != 4793490, i5 & 1)) {
                                    if (i17 != 0) {
                                        companion = Modifier.Companion;
                                        i15 = i8;
                                    } else {
                                        i15 = i8;
                                        companion = obj;
                                    }
                                    TextStyle textStyle3 = i6 != 0 ? TextStyle.Companion.getDefault() : obj2;
                                    if (i7 != 0) {
                                        function13 = null;
                                        i16 = i9;
                                    } else {
                                        i16 = i9;
                                        function13 = obj3;
                                    }
                                    int m6619getClipgIe3tQ8 = i15 != 0 ? TextOverflow.Companion.m6619getClipgIe3tQ8() : i;
                                    boolean z3 = i16 != 0 ? true : z;
                                    int i18 = i10 != 0 ? Integer.MAX_VALUE : i2;
                                    Map emptyMap = i12 != 0 ? MapsKt.emptyMap() : map;
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-648605928, i5, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:392)");
                                    }
                                    composer2 = startRestartGroup;
                                    m1046BasicTextCL7eQgs(annotatedString2, companion, textStyle3, function13, m6619getClipgIe3tQ8, z3, i18, 1, emptyMap, null, null, composer2, (i5 & 14) | 12582912 | (i5 & 112) | (i5 & 896) | (i5 & 7168) | (57344 & i5) | (458752 & i5) | (3670016 & i5) | ((i5 << 3) & 234881024), 0, 1536);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    modifier2 = companion;
                                    textStyle2 = textStyle3;
                                    function12 = function13;
                                    i13 = m6619getClipgIe3tQ8;
                                    z2 = z3;
                                    i14 = i18;
                                    map2 = emptyMap;
                                } else {
                                    composer2 = startRestartGroup;
                                    composer2.skipToGroupEnd();
                                    i13 = i;
                                    i14 = i2;
                                    modifier2 = obj;
                                    textStyle2 = obj2;
                                    function12 = obj3;
                                    z2 = z;
                                    map2 = map;
                                }
                                endRestartGroup = composer2.endRestartGroup();
                                if (endRestartGroup != null) {
                                    endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$7
                                        /* JADX INFO: Access modifiers changed from: package-private */
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(2);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                            invoke(composer3, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Composer composer3, int i19) {
                                            BasicTextKt.m1043BasicText4YKlhWE(AnnotatedString.this, modifier2, textStyle2, function12, i13, z2, i14, map2, composer3, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), i4);
                                        }
                                    });
                                    return;
                                }
                                return;
                            }
                            i12 = i11;
                            if (startRestartGroup.shouldExecute((i5 & 4793491) != 4793490, i5 & 1)) {
                            }
                            endRestartGroup = composer2.endRestartGroup();
                            if (endRestartGroup != null) {
                            }
                        }
                        i10 = i4 & 64;
                        if (i10 == 0) {
                        }
                        i11 = i4 & 128;
                        if (i11 == 0) {
                        }
                        i12 = i11;
                        if (startRestartGroup.shouldExecute((i5 & 4793491) != 4793490, i5 & 1)) {
                        }
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                        }
                    }
                    i9 = i4 & 32;
                    if (i9 != 0) {
                    }
                    i10 = i4 & 64;
                    if (i10 == 0) {
                    }
                    i11 = i4 & 128;
                    if (i11 == 0) {
                    }
                    i12 = i11;
                    if (startRestartGroup.shouldExecute((i5 & 4793491) != 4793490, i5 & 1)) {
                    }
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                obj3 = function1;
                i8 = i4 & 16;
                if (i8 == 0) {
                }
                i9 = i4 & 32;
                if (i9 != 0) {
                }
                i10 = i4 & 64;
                if (i10 == 0) {
                }
                i11 = i4 & 128;
                if (i11 == 0) {
                }
                i12 = i11;
                if (startRestartGroup.shouldExecute((i5 & 4793491) != 4793490, i5 & 1)) {
                }
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            obj2 = textStyle;
            i7 = i4 & 8;
            if (i7 != 0) {
            }
            obj3 = function1;
            i8 = i4 & 16;
            if (i8 == 0) {
            }
            i9 = i4 & 32;
            if (i9 != 0) {
            }
            i10 = i4 & 64;
            if (i10 == 0) {
            }
            i11 = i4 & 128;
            if (i11 == 0) {
            }
            i12 = i11;
            if (startRestartGroup.shouldExecute((i5 & 4793491) != 4793490, i5 & 1)) {
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        obj = modifier;
        i6 = i4 & 4;
        if (i6 == 0) {
        }
        obj2 = textStyle;
        i7 = i4 & 8;
        if (i7 != 0) {
        }
        obj3 = function1;
        i8 = i4 & 16;
        if (i8 == 0) {
        }
        i9 = i4 & 32;
        if (i9 != 0) {
        }
        i10 = i4 & 64;
        if (i10 == 0) {
        }
        i11 = i4 & 128;
        if (i11 == 0) {
        }
        i12 = i11;
        if (startRestartGroup.shouldExecute((i5 & 4793491) != 4793490, i5 & 1)) {
        }
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:157:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:259:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:261:? A[RETURN, SYNTHETIC] */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compat")
    /* renamed from: BasicText-4YKlhWE */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void m1044BasicText4YKlhWE(final String str, Modifier modifier, TextStyle textStyle, Function1 function1, int i, boolean z, int i2, int i3, Composer composer, final int i4, final int i5) {
        String str2;
        int i6;
        Object obj;
        int i7;
        Object obj2;
        int i8;
        Object obj3;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        Composer composer2;
        final int i14;
        final int i15;
        final Modifier modifier2;
        final TextStyle textStyle2;
        final Function1 function12;
        final boolean z2;
        final int i16;
        ScopeUpdateScope endRestartGroup;
        int i17;
        Modifier.Companion companion;
        int i18;
        Function1 function13;
        Composer startRestartGroup = composer.startRestartGroup(1542716361);
        ComposerKt.sourceInformation(startRestartGroup, "C(BasicText)P(7,2,6,3,4:c#ui.text.style.TextOverflow,5)417@19201L86:BasicText.kt#423gt5");
        if ((i5 & 1) != 0) {
            i6 = i4 | 6;
            str2 = str;
        } else {
            str2 = str;
            if ((i4 & 6) == 0) {
                i6 = (startRestartGroup.changed(str2) ? 4 : 2) | i4;
            } else {
                i6 = i4;
            }
        }
        int i19 = i5 & 2;
        if (i19 != 0) {
            i6 |= 48;
        } else if ((i4 & 48) == 0) {
            obj = modifier;
            i6 |= startRestartGroup.changed(obj) ? 32 : 16;
            i7 = i5 & 4;
            if (i7 == 0) {
                i6 |= RendererCapabilities.DECODER_SUPPORT_MASK;
            } else if ((i4 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                obj2 = textStyle;
                i6 |= startRestartGroup.changed(obj2) ? 256 : 128;
                i8 = i5 & 8;
                if (i8 != 0) {
                    i6 |= 3072;
                } else if ((i4 & 3072) == 0) {
                    obj3 = function1;
                    i6 |= startRestartGroup.changedInstance(obj3) ? 2048 : 1024;
                    i9 = i5 & 16;
                    if (i9 == 0) {
                        i6 |= 24576;
                    } else if ((i4 & 24576) == 0) {
                        i6 |= startRestartGroup.changed(i) ? 16384 : 8192;
                        i10 = i5 & 32;
                        if (i10 != 0) {
                            i6 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        } else if ((196608 & i4) == 0) {
                            i6 |= startRestartGroup.changed(z) ? 131072 : 65536;
                            i11 = i5 & 64;
                            if (i11 == 0) {
                                i6 |= 1572864;
                            } else if ((i4 & 1572864) == 0) {
                                i6 |= startRestartGroup.changed(i2) ? 1048576 : 524288;
                            }
                            i12 = i5 & 128;
                            if (i12 == 0) {
                                i6 |= 12582912;
                            } else if ((i4 & 12582912) == 0) {
                                i13 = i12;
                                i6 |= startRestartGroup.changed(i3) ? 8388608 : 4194304;
                                if (startRestartGroup.shouldExecute((i6 & 4793491) != 4793490, i6 & 1)) {
                                    if (i19 != 0) {
                                        companion = Modifier.Companion;
                                        i17 = i9;
                                    } else {
                                        i17 = i9;
                                        companion = obj;
                                    }
                                    TextStyle textStyle3 = i7 != 0 ? TextStyle.Companion.getDefault() : obj2;
                                    if (i8 != 0) {
                                        function13 = null;
                                        i18 = i10;
                                    } else {
                                        i18 = i10;
                                        function13 = obj3;
                                    }
                                    int m6619getClipgIe3tQ8 = i17 != 0 ? TextOverflow.Companion.m6619getClipgIe3tQ8() : i;
                                    boolean z3 = i18 != 0 ? true : z;
                                    int i20 = i11 != 0 ? Integer.MAX_VALUE : i2;
                                    int i21 = i13 != 0 ? 1 : i3;
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1542716361, i6, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:417)");
                                    }
                                    composer2 = startRestartGroup;
                                    m1048BasicTextRWo7tUw(str2, companion, textStyle3, function13, m6619getClipgIe3tQ8, z3, i20, i21, (ColorProducer) null, (TextAutoSize) null, composer2, i6 & 33554430, (int) ViewUtils.EDGE_TO_EDGE_FLAGS);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    modifier2 = companion;
                                    textStyle2 = textStyle3;
                                    function12 = function13;
                                    i14 = m6619getClipgIe3tQ8;
                                    z2 = z3;
                                    i15 = i20;
                                    i16 = i21;
                                } else {
                                    composer2 = startRestartGroup;
                                    composer2.skipToGroupEnd();
                                    i14 = i;
                                    i15 = i2;
                                    modifier2 = obj;
                                    textStyle2 = obj2;
                                    function12 = obj3;
                                    z2 = z;
                                    i16 = i3;
                                }
                                endRestartGroup = composer2.endRestartGroup();
                                if (endRestartGroup != null) {
                                    endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$8
                                        /* JADX INFO: Access modifiers changed from: package-private */
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(2);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                            invoke(composer3, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Composer composer3, int i22) {
                                            BasicTextKt.m1044BasicText4YKlhWE(str, modifier2, textStyle2, function12, i14, z2, i15, i16, composer3, RecomposeScopeImplKt.updateChangedFlags(i4 | 1), i5);
                                        }
                                    });
                                    return;
                                }
                                return;
                            }
                            i13 = i12;
                            if (startRestartGroup.shouldExecute((i6 & 4793491) != 4793490, i6 & 1)) {
                            }
                            endRestartGroup = composer2.endRestartGroup();
                            if (endRestartGroup != null) {
                            }
                        }
                        i11 = i5 & 64;
                        if (i11 == 0) {
                        }
                        i12 = i5 & 128;
                        if (i12 == 0) {
                        }
                        i13 = i12;
                        if (startRestartGroup.shouldExecute((i6 & 4793491) != 4793490, i6 & 1)) {
                        }
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                        }
                    }
                    i10 = i5 & 32;
                    if (i10 != 0) {
                    }
                    i11 = i5 & 64;
                    if (i11 == 0) {
                    }
                    i12 = i5 & 128;
                    if (i12 == 0) {
                    }
                    i13 = i12;
                    if (startRestartGroup.shouldExecute((i6 & 4793491) != 4793490, i6 & 1)) {
                    }
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                obj3 = function1;
                i9 = i5 & 16;
                if (i9 == 0) {
                }
                i10 = i5 & 32;
                if (i10 != 0) {
                }
                i11 = i5 & 64;
                if (i11 == 0) {
                }
                i12 = i5 & 128;
                if (i12 == 0) {
                }
                i13 = i12;
                if (startRestartGroup.shouldExecute((i6 & 4793491) != 4793490, i6 & 1)) {
                }
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            obj2 = textStyle;
            i8 = i5 & 8;
            if (i8 != 0) {
            }
            obj3 = function1;
            i9 = i5 & 16;
            if (i9 == 0) {
            }
            i10 = i5 & 32;
            if (i10 != 0) {
            }
            i11 = i5 & 64;
            if (i11 == 0) {
            }
            i12 = i5 & 128;
            if (i12 == 0) {
            }
            i13 = i12;
            if (startRestartGroup.shouldExecute((i6 & 4793491) != 4793490, i6 & 1)) {
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        obj = modifier;
        i7 = i5 & 4;
        if (i7 == 0) {
        }
        obj2 = textStyle;
        i8 = i5 & 8;
        if (i8 != 0) {
        }
        obj3 = function1;
        i9 = i5 & 16;
        if (i9 == 0) {
        }
        i10 = i5 & 32;
        if (i10 != 0) {
        }
        i11 = i5 & 64;
        if (i11 == 0) {
        }
        i12 = i5 & 128;
        if (i12 == 0) {
        }
        i13 = i12;
        if (startRestartGroup.shouldExecute((i6 & 4793491) != 4793490, i6 & 1)) {
        }
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:170:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:282:0x01cf  */
    /* JADX WARN: Removed duplicated region for block: B:285:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:287:? A[RETURN, SYNTHETIC] */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compat")
    /* renamed from: BasicText-VhcvRP8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void m1049BasicTextVhcvRP8(final AnnotatedString annotatedString, Modifier modifier, TextStyle textStyle, Function1 function1, int i, boolean z, int i2, int i3, Map map, Composer composer, final int i4, final int i5) {
        AnnotatedString annotatedString2;
        int i6;
        Object obj;
        int i7;
        Object obj2;
        int i8;
        Object obj3;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        Composer composer2;
        final int i16;
        final int i17;
        final Map map2;
        final Modifier modifier2;
        final TextStyle textStyle2;
        final Function1 function12;
        final boolean z2;
        final int i18;
        ScopeUpdateScope endRestartGroup;
        int i19;
        TextStyle textStyle3;
        int i20;
        int i21;
        int i22;
        int i23;
        int i24;
        int i25;
        Composer startRestartGroup = composer.startRestartGroup(851408699);
        ComposerKt.sourceInformation(startRestartGroup, "C(BasicText)P(8,3,7,4,5:c#ui.text.style.TextOverflow,6,1,2)432@19757L280:BasicText.kt#423gt5");
        if ((i5 & 1) != 0) {
            i6 = i4 | 6;
            annotatedString2 = annotatedString;
        } else {
            annotatedString2 = annotatedString;
            if ((i4 & 6) == 0) {
                i6 = (startRestartGroup.changed(annotatedString2) ? 4 : 2) | i4;
            } else {
                i6 = i4;
            }
        }
        int i26 = i5 & 2;
        if (i26 != 0) {
            i6 |= 48;
        } else if ((i4 & 48) == 0) {
            obj = modifier;
            i6 |= startRestartGroup.changed(obj) ? 32 : 16;
            i7 = i5 & 4;
            if (i7 == 0) {
                i6 |= RendererCapabilities.DECODER_SUPPORT_MASK;
            } else if ((i4 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                obj2 = textStyle;
                i6 |= startRestartGroup.changed(obj2) ? 256 : 128;
                i8 = i5 & 8;
                if (i8 != 0) {
                    i6 |= 3072;
                } else if ((i4 & 3072) == 0) {
                    obj3 = function1;
                    i6 |= startRestartGroup.changedInstance(obj3) ? 2048 : 1024;
                    i9 = i5 & 16;
                    if (i9 == 0) {
                        i6 |= 24576;
                    } else if ((i4 & 24576) == 0) {
                        i6 |= startRestartGroup.changed(i) ? 16384 : 8192;
                        i10 = i5 & 32;
                        if (i10 != 0) {
                            i6 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        } else if ((196608 & i4) == 0) {
                            i6 |= startRestartGroup.changed(z) ? 131072 : 65536;
                            i11 = i5 & 64;
                            if (i11 == 0) {
                                i6 |= 1572864;
                            } else if ((i4 & 1572864) == 0) {
                                i6 |= startRestartGroup.changed(i2) ? 1048576 : 524288;
                            }
                            i12 = i5 & 128;
                            if (i12 == 0) {
                                i6 |= 12582912;
                            } else if ((i4 & 12582912) == 0) {
                                i13 = i12;
                                i6 |= startRestartGroup.changed(i3) ? 8388608 : 4194304;
                                i14 = i5 & 256;
                                if (i14 != 0) {
                                    i6 |= 100663296;
                                } else if ((i4 & 100663296) == 0) {
                                    i15 = i14;
                                    i6 |= startRestartGroup.changedInstance(map) ? 67108864 : 33554432;
                                    if (!startRestartGroup.shouldExecute((i6 & 38347923) == 38347922, i6 & 1)) {
                                        Modifier.Companion companion = i26 != 0 ? Modifier.Companion : obj;
                                        if (i7 != 0) {
                                            textStyle3 = TextStyle.Companion.getDefault();
                                            i19 = i10;
                                        } else {
                                            i19 = i10;
                                            textStyle3 = obj2;
                                        }
                                        Function1 function13 = i8 != 0 ? null : obj3;
                                        if (i9 != 0) {
                                            i21 = TextOverflow.Companion.m6619getClipgIe3tQ8();
                                            i20 = i11;
                                        } else {
                                            i20 = i11;
                                            i21 = i;
                                        }
                                        boolean z3 = i19 != 0 ? true : z;
                                        if (i20 != 0) {
                                            int i27 = i13;
                                            i23 = Integer.MAX_VALUE;
                                            i22 = i27;
                                        } else {
                                            i22 = i13;
                                            i23 = i2;
                                        }
                                        if (i22 != 0) {
                                            i24 = i15;
                                            i25 = 1;
                                        } else {
                                            i24 = i15;
                                            i25 = i3;
                                        }
                                        Map emptyMap = i24 != 0 ? MapsKt.emptyMap() : map;
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(851408699, i6, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:432)");
                                        }
                                        composer2 = startRestartGroup;
                                        m1046BasicTextCL7eQgs(annotatedString2, companion, textStyle3, function13, i21, z3, i23, i25, emptyMap, null, null, composer2, i6 & 268435454, 0, 1536);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                        modifier2 = companion;
                                        textStyle2 = textStyle3;
                                        function12 = function13;
                                        i16 = i21;
                                        z2 = z3;
                                        i17 = i23;
                                        i18 = i25;
                                        map2 = emptyMap;
                                    } else {
                                        composer2 = startRestartGroup;
                                        composer2.skipToGroupEnd();
                                        i16 = i;
                                        i17 = i2;
                                        map2 = map;
                                        modifier2 = obj;
                                        textStyle2 = obj2;
                                        function12 = obj3;
                                        z2 = z;
                                        i18 = i3;
                                    }
                                    endRestartGroup = composer2.endRestartGroup();
                                    if (endRestartGroup == null) {
                                        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$9
                                            /* JADX INFO: Access modifiers changed from: package-private */
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(2);
                                            }

                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                                invoke(composer3, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(Composer composer3, int i28) {
                                                BasicTextKt.m1049BasicTextVhcvRP8(AnnotatedString.this, modifier2, textStyle2, function12, i16, z2, i17, i18, map2, composer3, RecomposeScopeImplKt.updateChangedFlags(i4 | 1), i5);
                                            }
                                        });
                                        return;
                                    }
                                    return;
                                }
                                i15 = i14;
                                if (!startRestartGroup.shouldExecute((i6 & 38347923) == 38347922, i6 & 1)) {
                                }
                                endRestartGroup = composer2.endRestartGroup();
                                if (endRestartGroup == null) {
                                }
                            }
                            i13 = i12;
                            i14 = i5 & 256;
                            if (i14 != 0) {
                            }
                            i15 = i14;
                            if (!startRestartGroup.shouldExecute((i6 & 38347923) == 38347922, i6 & 1)) {
                            }
                            endRestartGroup = composer2.endRestartGroup();
                            if (endRestartGroup == null) {
                            }
                        }
                        i11 = i5 & 64;
                        if (i11 == 0) {
                        }
                        i12 = i5 & 128;
                        if (i12 == 0) {
                        }
                        i13 = i12;
                        i14 = i5 & 256;
                        if (i14 != 0) {
                        }
                        i15 = i14;
                        if (!startRestartGroup.shouldExecute((i6 & 38347923) == 38347922, i6 & 1)) {
                        }
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup == null) {
                        }
                    }
                    i10 = i5 & 32;
                    if (i10 != 0) {
                    }
                    i11 = i5 & 64;
                    if (i11 == 0) {
                    }
                    i12 = i5 & 128;
                    if (i12 == 0) {
                    }
                    i13 = i12;
                    i14 = i5 & 256;
                    if (i14 != 0) {
                    }
                    i15 = i14;
                    if (!startRestartGroup.shouldExecute((i6 & 38347923) == 38347922, i6 & 1)) {
                    }
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup == null) {
                    }
                }
                obj3 = function1;
                i9 = i5 & 16;
                if (i9 == 0) {
                }
                i10 = i5 & 32;
                if (i10 != 0) {
                }
                i11 = i5 & 64;
                if (i11 == 0) {
                }
                i12 = i5 & 128;
                if (i12 == 0) {
                }
                i13 = i12;
                i14 = i5 & 256;
                if (i14 != 0) {
                }
                i15 = i14;
                if (!startRestartGroup.shouldExecute((i6 & 38347923) == 38347922, i6 & 1)) {
                }
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            obj2 = textStyle;
            i8 = i5 & 8;
            if (i8 != 0) {
            }
            obj3 = function1;
            i9 = i5 & 16;
            if (i9 == 0) {
            }
            i10 = i5 & 32;
            if (i10 != 0) {
            }
            i11 = i5 & 64;
            if (i11 == 0) {
            }
            i12 = i5 & 128;
            if (i12 == 0) {
            }
            i13 = i12;
            i14 = i5 & 256;
            if (i14 != 0) {
            }
            i15 = i14;
            if (!startRestartGroup.shouldExecute((i6 & 38347923) == 38347922, i6 & 1)) {
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        obj = modifier;
        i7 = i5 & 4;
        if (i7 == 0) {
        }
        obj2 = textStyle;
        i8 = i5 & 8;
        if (i8 != 0) {
        }
        obj3 = function1;
        i9 = i5 & 16;
        if (i9 == 0) {
        }
        i10 = i5 & 32;
        if (i10 != 0) {
        }
        i11 = i5 & 64;
        if (i11 == 0) {
        }
        i12 = i5 & 128;
        if (i12 == 0) {
        }
        i13 = i12;
        i14 = i5 & 256;
        if (i14 != 0) {
        }
        i15 = i14;
        if (!startRestartGroup.shouldExecute((i6 & 38347923) == 38347922, i6 & 1)) {
        }
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    private static final Saver<Long, Long> selectionIdSaver(final SelectionRegistrar selectionRegistrar) {
        return SaverKt.Saver(new Function2<SaverScope, Long, Long>() { // from class: androidx.compose.foundation.text.BasicTextKt$selectionIdSaver$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Long invoke(SaverScope saverScope, Long l) {
                return invoke(saverScope, l.longValue());
            }

            public final Long invoke(SaverScope saverScope, long j) {
                if (SelectionRegistrarKt.hasSelection(SelectionRegistrar.this, j)) {
                    return Long.valueOf(j);
                }
                return null;
            }
        }, new Function1<Long, Long>() { // from class: androidx.compose.foundation.text.BasicTextKt$selectionIdSaver$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Long invoke(Long l) {
                return invoke(l.longValue());
            }

            public final Long invoke(long j) {
                return Long.valueOf(j);
            }
        });
    }

    public static final List<Pair<Placeable, Function0<IntOffset>>> measureWithTextRangeMeasureConstraints(List<? extends Measurable> list, Function0<Boolean> function0) {
        if (function0.invoke().booleanValue()) {
            TextRangeLayoutMeasureScope textRangeLayoutMeasureScope = new TextRangeLayoutMeasureScope();
            ArrayList arrayList = new ArrayList(list.size());
            int size = list.size();
            for (int i = 0; i < size; i++) {
                Measurable measurable = list.get(i);
                Object parentData = measurable.getParentData();
                Intrinsics.checkNotNull(parentData, "null cannot be cast to non-null type androidx.compose.foundation.text.TextRangeLayoutModifier");
                TextRangeLayoutMeasureResult measure = ((TextRangeLayoutModifier) parentData).getMeasurePolicy().measure(textRangeLayoutMeasureScope);
                arrayList.add(new Pair(measurable.mo5438measureBRTryo0(Constraints.Companion.m6646fitPrioritizingWidthZbe2FdA(measure.getWidth(), measure.getWidth(), measure.getHeight(), measure.getHeight())), measure.getPlace()));
            }
            return arrayList;
        }
        return null;
    }

    /* renamed from: textModifier-CL7eQgs */
    private static final Modifier m1053textModifierCL7eQgs(Modifier modifier, AnnotatedString annotatedString, TextStyle textStyle, Function1<? super TextLayoutResult, Unit> function1, int i, boolean z, int i2, int i3, FontFamily.Resolver resolver, List<AnnotatedString.Range<Placeholder>> list, Function1<? super List<Rect>, Unit> function12, SelectionController selectionController, ColorProducer colorProducer, Function1<? super TextAnnotatedStringNode.TextSubstitutionValue, Unit> function13, TextAutoSize textAutoSize) {
        if (selectionController == null) {
            return modifier.then(Modifier.Companion).then(new TextAnnotatedStringElement(annotatedString, textStyle, resolver, function1, i, z, i2, i3, list, function12, null, colorProducer, textAutoSize, function13, null));
        }
        return modifier.then(selectionController.getModifier()).then(new SelectableTextAnnotatedStringElement(annotatedString, textStyle, resolver, function1, i, z, i2, i3, list, function12, selectionController, colorProducer, textAutoSize, null));
    }

    /* JADX WARN: Code restructure failed: missing block: B:519:0x0364, code lost:
        if (r4 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L154;
     */
    /* JADX WARN: Removed duplicated region for block: B:347:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:348:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:357:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:358:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:367:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:368:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:378:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:379:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:389:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:390:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:400:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:401:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:411:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:412:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:422:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:423:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:432:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:433:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:443:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:444:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:456:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:463:0x01f8  */
    /* JADX WARN: Removed duplicated region for block: B:576:0x057a  */
    /* JADX WARN: Removed duplicated region for block: B:579:0x0585  */
    /* JADX WARN: Removed duplicated region for block: B:581:? A[RETURN, SYNTHETIC] */
    /* renamed from: LayoutWithLinksAndInlineContent-11Od_4g */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m1051LayoutWithLinksAndInlineContent11Od_4g(final Modifier modifier, AnnotatedString annotatedString, final Function1<? super TextLayoutResult, Unit> function1, final boolean z, Map<String, InlineTextContent> map, final TextStyle textStyle, final int i, final boolean z2, final int i2, final int i3, final FontFamily.Resolver resolver, final SelectionController selectionController, final ColorProducer colorProducer, final Function1<? super TextAnnotatedStringNode.TextSubstitutionValue, Unit> function12, final TextAutoSize textAutoSize, Composer composer, final int i4, final int i5, final int i6) {
        Object obj;
        int i7;
        Object obj2;
        Object obj3;
        int i8;
        boolean z3;
        int i9;
        int i10;
        int i11;
        Composer composer2;
        final Map<String, InlineTextContent> map2;
        ScopeUpdateScope endRestartGroup;
        final TextLinkScope textLinkScope;
        Function0 function0;
        Pair<List<AnnotatedString.Range<Placeholder>>, List<AnnotatedString.Range<Function3<String, Composer, Integer, Unit>>>> pair;
        Map<String, InlineTextContent> map3;
        final MutableState mutableState;
        List<AnnotatedString.Range<Function3<String, Composer, Integer, Unit>>> list;
        TextMeasurePolicy textMeasurePolicy;
        MutableState mutableState2;
        final AnnotatedString annotatedString2 = annotatedString;
        Composer startRestartGroup = composer.startRestartGroup(-2118572703);
        ComposerKt.sourceInformation(startRestartGroup, "C(LayoutWithLinksAndInlineContent)P(7,14,9,3,4,13,10:c#ui.text.style.TextOverflow,12,5,6,2,11,1,8)671@28101L117,662@27779L1426:BasicText.kt#423gt5");
        if ((i6 & 1) != 0) {
            i7 = i4 | 6;
            obj = modifier;
        } else if ((i4 & 6) == 0) {
            obj = modifier;
            i7 = (startRestartGroup.changed(obj) ? 4 : 2) | i4;
        } else {
            obj = modifier;
            i7 = i4;
        }
        if ((i6 & 2) != 0) {
            i7 |= 48;
        } else if ((i4 & 48) == 0) {
            i7 |= startRestartGroup.changed(annotatedString2) ? 32 : 16;
        }
        if ((i6 & 4) != 0) {
            i7 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        } else if ((i4 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i7 |= startRestartGroup.changedInstance(function1) ? 256 : 128;
        }
        if ((i6 & 8) != 0) {
            i7 |= 3072;
        } else if ((i4 & 3072) == 0) {
            i7 |= startRestartGroup.changed(z) ? 2048 : 1024;
        }
        int i12 = i6 & 16;
        if (i12 != 0) {
            i7 |= 24576;
        } else if ((i4 & 24576) == 0) {
            obj2 = map;
            i7 |= startRestartGroup.changedInstance(obj2) ? 16384 : 8192;
            if ((i6 & 32) == 0) {
                i7 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                obj3 = textStyle;
            } else {
                obj3 = textStyle;
                if ((i4 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    i7 |= startRestartGroup.changed(obj3) ? 131072 : 65536;
                }
            }
            if ((i6 & 64) == 0) {
                i7 |= 1572864;
                i8 = i;
            } else {
                i8 = i;
                if ((i4 & 1572864) == 0) {
                    i7 |= startRestartGroup.changed(i8) ? 1048576 : 524288;
                }
            }
            if ((i6 & 128) == 0) {
                i7 |= 12582912;
            } else if ((12582912 & i4) == 0) {
                z3 = z2;
                i7 |= startRestartGroup.changed(z3) ? 8388608 : 4194304;
                if ((i6 & 256) != 0) {
                    i7 |= 100663296;
                } else if ((100663296 & i4) == 0) {
                    i9 = i2;
                    i7 |= startRestartGroup.changed(i9) ? 67108864 : 33554432;
                    if ((i6 & 512) == 0) {
                        i7 |= 805306368;
                    } else if ((i4 & 805306368) == 0) {
                        i7 |= startRestartGroup.changed(i3) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
                        if ((i6 & 1024) != 0) {
                            i10 = i5 | 6;
                        } else if ((i5 & 6) == 0) {
                            i10 = i5 | (startRestartGroup.changedInstance(resolver) ? 4 : 2);
                        } else {
                            i10 = i5;
                        }
                        if ((i6 & 2048) != 0) {
                            i10 |= 48;
                        } else if ((i5 & 48) == 0) {
                            i10 |= startRestartGroup.changedInstance(selectionController) ? 32 : 16;
                        }
                        i11 = i10;
                        if ((i6 & 4096) != 0) {
                            i11 |= RendererCapabilities.DECODER_SUPPORT_MASK;
                        } else if ((i5 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                            i11 |= startRestartGroup.changedInstance(colorProducer) ? 256 : 128;
                            if ((i6 & 8192) == 0) {
                                i11 |= 3072;
                            } else if ((i5 & 3072) == 0) {
                                i11 |= startRestartGroup.changedInstance(function12) ? 2048 : 1024;
                                if ((i6 & 16384) != 0) {
                                    i11 |= 24576;
                                } else if ((i5 & 24576) == 0) {
                                    i11 |= (32768 & i5) == 0 ? startRestartGroup.changed(textAutoSize) : startRestartGroup.changedInstance(textAutoSize) ? 16384 : 8192;
                                }
                                if (startRestartGroup.shouldExecute((306783379 & i7) == 306783378 || (i11 & 9363) != 9362, i7 & 1)) {
                                    Map<String, InlineTextContent> emptyMap = i12 != 0 ? MapsKt.emptyMap() : obj2;
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-2118572703, i7, i11, "androidx.compose.foundation.text.LayoutWithLinksAndInlineContent (BasicText.kt:630)");
                                    }
                                    Function1 function13 = null;
                                    if (TextAnnotatedStringNodeKt.hasLinks(annotatedString2)) {
                                        startRestartGroup.startReplaceGroup(-613484007);
                                        ComposerKt.sourceInformation(startRestartGroup, "634@26844L38");
                                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -296884047, "CC(remember):BasicText.kt#9igjgp");
                                        boolean z4 = (i7 & 112) == 32;
                                        Object rememberedValue = startRestartGroup.rememberedValue();
                                        if (z4 || rememberedValue == Composer.Companion.getEmpty()) {
                                            rememberedValue = new TextLinkScope(annotatedString2);
                                            startRestartGroup.updateRememberedValue(rememberedValue);
                                        }
                                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                        startRestartGroup.endReplaceGroup();
                                        textLinkScope = (TextLinkScope) rememberedValue;
                                    } else {
                                        startRestartGroup.startReplaceGroup(-613418350);
                                        startRestartGroup.endReplaceGroup();
                                        textLinkScope = null;
                                    }
                                    if (TextAnnotatedStringNodeKt.hasLinks(annotatedString2)) {
                                        startRestartGroup.startReplaceGroup(-613220135);
                                        ComposerKt.sourceInformation(startRestartGroup, "641@27109L70");
                                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -296875535, "CC(remember):BasicText.kt#9igjgp");
                                        boolean changed = ((i7 & 112) == 32) | startRestartGroup.changed(textLinkScope);
                                        Object rememberedValue2 = startRestartGroup.rememberedValue();
                                        if (changed || rememberedValue2 == Composer.Companion.getEmpty()) {
                                            rememberedValue2 = (Function0) new Function0<AnnotatedString>() { // from class: androidx.compose.foundation.text.BasicTextKt$LayoutWithLinksAndInlineContent$styledText$1$1
                                                /* JADX INFO: Access modifiers changed from: package-private */
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(0);
                                                }

                                                /* JADX WARN: Can't rename method to resolve collision */
                                                @Override // kotlin.jvm.functions.Function0
                                                public final AnnotatedString invoke() {
                                                    AnnotatedString applyAnnotators$foundation_release;
                                                    TextLinkScope textLinkScope2 = TextLinkScope.this;
                                                    return (textLinkScope2 == null || (applyAnnotators$foundation_release = textLinkScope2.applyAnnotators$foundation_release()) == null) ? annotatedString2 : applyAnnotators$foundation_release;
                                                }
                                            };
                                            startRestartGroup.updateRememberedValue(rememberedValue2);
                                        }
                                        function0 = (Function0) rememberedValue2;
                                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                        startRestartGroup.endReplaceGroup();
                                    } else {
                                        startRestartGroup.startReplaceGroup(-613122857);
                                        ComposerKt.sourceInformation(startRestartGroup, "643@27209L8");
                                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -296872397, "CC(remember):BasicText.kt#9igjgp");
                                        boolean z5 = (i7 & 112) == 32;
                                        Object rememberedValue3 = startRestartGroup.rememberedValue();
                                        if (z5 || rememberedValue3 == Composer.Companion.getEmpty()) {
                                            rememberedValue3 = (Function0) new Function0<AnnotatedString>() { // from class: androidx.compose.foundation.text.BasicTextKt$LayoutWithLinksAndInlineContent$styledText$2$1
                                                /* JADX INFO: Access modifiers changed from: package-private */
                                                {
                                                    super(0);
                                                }

                                                /* JADX WARN: Can't rename method to resolve collision */
                                                @Override // kotlin.jvm.functions.Function0
                                                public final AnnotatedString invoke() {
                                                    return AnnotatedString.this;
                                                }
                                            };
                                            startRestartGroup.updateRememberedValue(rememberedValue3);
                                        }
                                        function0 = (Function0) rememberedValue3;
                                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                        startRestartGroup.endReplaceGroup();
                                    }
                                    if (z) {
                                        pair = AnnotatedStringResolveInlineContentKt.resolveInlineContent(annotatedString2, emptyMap);
                                    } else {
                                        pair = new Pair<>(null, null);
                                    }
                                    List<AnnotatedString.Range<Placeholder>> component1 = pair.component1();
                                    List<AnnotatedString.Range<Function3<String, Composer, Integer, Unit>>> component2 = pair.component2();
                                    if (z) {
                                        startRestartGroup.startReplaceGroup(-612806750);
                                        ComposerKt.sourceInformation(startRestartGroup, "654@27526L61");
                                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -296862200, "CC(remember):BasicText.kt#9igjgp");
                                        Object rememberedValue4 = startRestartGroup.rememberedValue();
                                        map3 = emptyMap;
                                        if (rememberedValue4 == Composer.Companion.getEmpty()) {
                                            function13 = null;
                                            mutableState2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                                            startRestartGroup.updateRememberedValue(mutableState2);
                                        } else {
                                            function13 = null;
                                            mutableState2 = rememberedValue4;
                                        }
                                        mutableState = mutableState2;
                                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                        startRestartGroup.endReplaceGroup();
                                    } else {
                                        map3 = emptyMap;
                                        startRestartGroup.startReplaceGroup(-612718990);
                                        startRestartGroup.endReplaceGroup();
                                        mutableState = null;
                                    }
                                    if (z) {
                                        startRestartGroup.startReplaceGroup(-612625741);
                                        ComposerKt.sourceInformation(startRestartGroup, "659@27709L44");
                                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -296856361, "CC(remember):BasicText.kt#9igjgp");
                                        boolean changed2 = startRestartGroup.changed(mutableState);
                                        Object rememberedValue5 = startRestartGroup.rememberedValue();
                                        if (changed2) {
                                            list = component2;
                                        } else {
                                            list = component2;
                                        }
                                        rememberedValue5 = (Function1) new Function1<List<? extends Rect>, Unit>() { // from class: androidx.compose.foundation.text.BasicTextKt$LayoutWithLinksAndInlineContent$onPlaceholderLayout$1$1
                                            /* JADX INFO: Access modifiers changed from: package-private */
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public /* bridge */ /* synthetic */ Unit invoke(List<? extends Rect> list2) {
                                                invoke2((List<Rect>) list2);
                                                return Unit.INSTANCE;
                                            }

                                            /* renamed from: invoke  reason: avoid collision after fix types in other method */
                                            public final void invoke2(List<Rect> list2) {
                                                MutableState<List<Rect>> mutableState3 = mutableState;
                                                if (mutableState3 == null) {
                                                    return;
                                                }
                                                mutableState3.setValue(list2);
                                            }
                                        };
                                        startRestartGroup.updateRememberedValue(rememberedValue5);
                                        function13 = (Function1) rememberedValue5;
                                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                        startRestartGroup.endReplaceGroup();
                                    } else {
                                        list = component2;
                                        startRestartGroup.startReplaceGroup(-612554318);
                                        startRestartGroup.endReplaceGroup();
                                    }
                                    AnnotatedString annotatedString3 = (AnnotatedString) function0.invoke();
                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -296843744, "CC(remember):BasicText.kt#9igjgp");
                                    Function1 function14 = function13;
                                    boolean changedInstance = startRestartGroup.changedInstance(textLinkScope) | ((i7 & 896) == 256);
                                    Object rememberedValue6 = startRestartGroup.rememberedValue();
                                    if (changedInstance || rememberedValue6 == Composer.Companion.getEmpty()) {
                                        rememberedValue6 = (Function1) new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.foundation.text.BasicTextKt$LayoutWithLinksAndInlineContent$2$1
                                            /* JADX INFO: Access modifiers changed from: package-private */
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public /* bridge */ /* synthetic */ Unit invoke(TextLayoutResult textLayoutResult) {
                                                invoke2(textLayoutResult);
                                                return Unit.INSTANCE;
                                            }

                                            /* renamed from: invoke  reason: avoid collision after fix types in other method */
                                            public final void invoke2(TextLayoutResult textLayoutResult) {
                                                TextLinkScope textLinkScope2 = TextLinkScope.this;
                                                if (textLinkScope2 != null) {
                                                    textLinkScope2.setTextLayoutResult(textLayoutResult);
                                                }
                                                Function1<TextLayoutResult, Unit> function15 = function1;
                                                if (function15 != null) {
                                                    function15.invoke(textLayoutResult);
                                                }
                                            }
                                        };
                                        startRestartGroup.updateRememberedValue(rememberedValue6);
                                    }
                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                    List<AnnotatedString.Range<Function3<String, Composer, Integer, Unit>>> list2 = list;
                                    composer2 = startRestartGroup;
                                    int i13 = i7;
                                    Modifier m1053textModifierCL7eQgs = m1053textModifierCL7eQgs(obj, annotatedString3, obj3, (Function1) rememberedValue6, i8, z3, i9, i3, resolver, component1, function14, selectionController, colorProducer, function12, textAutoSize);
                                    if (!z) {
                                        composer2.startReplaceGroup(-611542291);
                                        ComposerKt.sourceInformation(composer2, "690@28867L55");
                                        ComposerKt.sourceInformationMarkerStart(composer2, -296819294, "CC(remember):BasicText.kt#9igjgp");
                                        boolean changedInstance2 = composer2.changedInstance(textLinkScope);
                                        Object rememberedValue7 = composer2.rememberedValue();
                                        if (changedInstance2 || rememberedValue7 == Composer.Companion.getEmpty()) {
                                            rememberedValue7 = (Function0) new Function0<Boolean>() { // from class: androidx.compose.foundation.text.BasicTextKt$LayoutWithLinksAndInlineContent$3$1
                                                /* JADX INFO: Access modifiers changed from: package-private */
                                                {
                                                    super(0);
                                                }

                                                /* JADX WARN: Can't rename method to resolve collision */
                                                @Override // kotlin.jvm.functions.Function0
                                                public final Boolean invoke() {
                                                    TextLinkScope textLinkScope2 = TextLinkScope.this;
                                                    return Boolean.valueOf(textLinkScope2 != null ? textLinkScope2.getShouldMeasureLinks().invoke().booleanValue() : false);
                                                }
                                            };
                                            composer2.updateRememberedValue(rememberedValue7);
                                        }
                                        ComposerKt.sourceInformationMarkerEnd(composer2);
                                        LinksTextMeasurePolicy linksTextMeasurePolicy = new LinksTextMeasurePolicy((Function0) rememberedValue7);
                                        composer2.endReplaceGroup();
                                        textMeasurePolicy = linksTextMeasurePolicy;
                                    } else {
                                        composer2.startReplaceGroup(-611365560);
                                        ComposerKt.sourceInformation(composer2, "694@29038L55,695@29128L39");
                                        ComposerKt.sourceInformationMarkerStart(composer2, -296813822, "CC(remember):BasicText.kt#9igjgp");
                                        boolean changedInstance3 = composer2.changedInstance(textLinkScope);
                                        Object rememberedValue8 = composer2.rememberedValue();
                                        if (changedInstance3 || rememberedValue8 == Composer.Companion.getEmpty()) {
                                            rememberedValue8 = (Function0) new Function0<Boolean>() { // from class: androidx.compose.foundation.text.BasicTextKt$LayoutWithLinksAndInlineContent$4$1
                                                /* JADX INFO: Access modifiers changed from: package-private */
                                                {
                                                    super(0);
                                                }

                                                /* JADX WARN: Can't rename method to resolve collision */
                                                @Override // kotlin.jvm.functions.Function0
                                                public final Boolean invoke() {
                                                    TextLinkScope textLinkScope2 = TextLinkScope.this;
                                                    return Boolean.valueOf(textLinkScope2 != null ? textLinkScope2.getShouldMeasureLinks().invoke().booleanValue() : false);
                                                }
                                            };
                                            composer2.updateRememberedValue(rememberedValue8);
                                        }
                                        Function0 function02 = (Function0) rememberedValue8;
                                        ComposerKt.sourceInformationMarkerEnd(composer2);
                                        ComposerKt.sourceInformationMarkerStart(composer2, -296810958, "CC(remember):BasicText.kt#9igjgp");
                                        boolean changed3 = composer2.changed(mutableState);
                                        Object rememberedValue9 = composer2.rememberedValue();
                                        if (changed3 || rememberedValue9 == Composer.Companion.getEmpty()) {
                                            rememberedValue9 = (Function0) new Function0<List<? extends Rect>>() { // from class: androidx.compose.foundation.text.BasicTextKt$LayoutWithLinksAndInlineContent$5$1
                                                /* JADX INFO: Access modifiers changed from: package-private */
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(0);
                                                }

                                                @Override // kotlin.jvm.functions.Function0
                                                public final List<? extends Rect> invoke() {
                                                    MutableState<List<Rect>> mutableState3 = mutableState;
                                                    if (mutableState3 != null) {
                                                        return mutableState3.getValue();
                                                    }
                                                    return null;
                                                }
                                            };
                                            composer2.updateRememberedValue(rememberedValue9);
                                        }
                                        ComposerKt.sourceInformationMarkerEnd(composer2);
                                        TextMeasurePolicy textMeasurePolicy2 = new TextMeasurePolicy(function02, (Function0) rememberedValue9);
                                        composer2.endReplaceGroup();
                                        textMeasurePolicy = textMeasurePolicy2;
                                    }
                                    ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                                    CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                                    Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer2, m1053textModifierCL7eQgs);
                                    Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
                                    ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                                    if (!(composer2.getApplier() instanceof Applier)) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    composer2.startReusableNode();
                                    if (composer2.getInserting()) {
                                        composer2.createNode(constructor);
                                    } else {
                                        composer2.useNode();
                                    }
                                    Composer m3520constructorimpl = Updater.m3520constructorimpl(composer2);
                                    Updater.m3527setimpl(m3520constructorimpl, textMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                                    Updater.m3527setimpl(m3520constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                    if (m3520constructorimpl.getInserting() || !Intrinsics.areEqual(m3520constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                        m3520constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                        m3520constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                    }
                                    Updater.m3527setimpl(m3520constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                                    ComposerKt.sourceInformationMarkerStart(composer2, -509599868, "C:BasicText.kt#423gt5");
                                    if (textLinkScope == null) {
                                        composer2.startReplaceGroup(-509592027);
                                        composer2.endReplaceGroup();
                                    } else {
                                        composer2.startReplaceGroup(537750876);
                                        ComposerKt.sourceInformation(composer2, "664@27830L18");
                                        textLinkScope.LinksComposables(composer2, 0);
                                        composer2.endReplaceGroup();
                                        Unit unit = Unit.INSTANCE;
                                    }
                                    if (list2 == null) {
                                        composer2.startReplaceGroup(-509541249);
                                        composer2.endReplaceGroup();
                                        annotatedString2 = annotatedString;
                                    } else {
                                        composer2.startReplaceGroup(-509541248);
                                        ComposerKt.sourceInformation(composer2, "*665@27886L48");
                                        annotatedString2 = annotatedString;
                                        AnnotatedStringResolveInlineContentKt.InlineChildren(annotatedString2, list2, composer2, (i13 >> 3) & 14);
                                        Unit unit2 = Unit.INSTANCE;
                                        composer2.endReplaceGroup();
                                        Unit unit3 = Unit.INSTANCE;
                                    }
                                    ComposerKt.sourceInformationMarkerEnd(composer2);
                                    composer2.endNode();
                                    ComposerKt.sourceInformationMarkerEnd(composer2);
                                    ComposerKt.sourceInformationMarkerEnd(composer2);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    map2 = map3;
                                } else {
                                    composer2 = startRestartGroup;
                                    composer2.skipToGroupEnd();
                                    map2 = obj2;
                                }
                                endRestartGroup = composer2.endRestartGroup();
                                if (endRestartGroup != null) {
                                    endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicTextKt$LayoutWithLinksAndInlineContent$6
                                        /* JADX INFO: Access modifiers changed from: package-private */
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(2);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                            invoke(composer3, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Composer composer3, int i14) {
                                            BasicTextKt.m1051LayoutWithLinksAndInlineContent11Od_4g(Modifier.this, annotatedString2, function1, z, map2, textStyle, i, z2, i2, i3, resolver, selectionController, colorProducer, function12, textAutoSize, composer3, RecomposeScopeImplKt.updateChangedFlags(i4 | 1), RecomposeScopeImplKt.updateChangedFlags(i5), i6);
                                        }
                                    });
                                    return;
                                }
                                return;
                            }
                            if ((i6 & 16384) != 0) {
                            }
                            if (startRestartGroup.shouldExecute((306783379 & i7) == 306783378 || (i11 & 9363) != 9362, i7 & 1)) {
                            }
                            endRestartGroup = composer2.endRestartGroup();
                            if (endRestartGroup != null) {
                            }
                        }
                        if ((i6 & 8192) == 0) {
                        }
                        if ((i6 & 16384) != 0) {
                        }
                        if (startRestartGroup.shouldExecute((306783379 & i7) == 306783378 || (i11 & 9363) != 9362, i7 & 1)) {
                        }
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                        }
                    }
                    if ((i6 & 1024) != 0) {
                    }
                    if ((i6 & 2048) != 0) {
                    }
                    i11 = i10;
                    if ((i6 & 4096) != 0) {
                    }
                    if ((i6 & 8192) == 0) {
                    }
                    if ((i6 & 16384) != 0) {
                    }
                    if (startRestartGroup.shouldExecute((306783379 & i7) == 306783378 || (i11 & 9363) != 9362, i7 & 1)) {
                    }
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                i9 = i2;
                if ((i6 & 512) == 0) {
                }
                if ((i6 & 1024) != 0) {
                }
                if ((i6 & 2048) != 0) {
                }
                i11 = i10;
                if ((i6 & 4096) != 0) {
                }
                if ((i6 & 8192) == 0) {
                }
                if ((i6 & 16384) != 0) {
                }
                if (startRestartGroup.shouldExecute((306783379 & i7) == 306783378 || (i11 & 9363) != 9362, i7 & 1)) {
                }
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            z3 = z2;
            if ((i6 & 256) != 0) {
            }
            i9 = i2;
            if ((i6 & 512) == 0) {
            }
            if ((i6 & 1024) != 0) {
            }
            if ((i6 & 2048) != 0) {
            }
            i11 = i10;
            if ((i6 & 4096) != 0) {
            }
            if ((i6 & 8192) == 0) {
            }
            if ((i6 & 16384) != 0) {
            }
            if (startRestartGroup.shouldExecute((306783379 & i7) == 306783378 || (i11 & 9363) != 9362, i7 & 1)) {
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        obj2 = map;
        if ((i6 & 32) == 0) {
        }
        if ((i6 & 64) == 0) {
        }
        if ((i6 & 128) == 0) {
        }
        z3 = z2;
        if ((i6 & 256) != 0) {
        }
        i9 = i2;
        if ((i6 & 512) == 0) {
        }
        if ((i6 & 1024) != 0) {
        }
        if ((i6 & 2048) != 0) {
        }
        i11 = i10;
        if ((i6 & 4096) != 0) {
        }
        if ((i6 & 8192) == 0) {
        }
        if ((i6 & 16384) != 0) {
        }
        if (startRestartGroup.shouldExecute((306783379 & i7) == 306783378 || (i11 & 9363) != 9362, i7 & 1)) {
        }
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }
}
