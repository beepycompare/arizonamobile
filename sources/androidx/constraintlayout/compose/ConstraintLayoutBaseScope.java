package androidx.constraintlayout.compose;

import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.core.parser.CLArray;
import androidx.constraintlayout.core.parser.CLElement;
import androidx.constraintlayout.core.parser.CLNumber;
import androidx.constraintlayout.core.parser.CLObject;
import androidx.constraintlayout.core.parser.CLString;
import androidx.constraintlayout.core.state.ConstraintSetParser;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.android.vending.expansion.downloader.DownloaderServiceMarshaller;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
/* compiled from: ConstraintLayoutBaseScope.kt */
@Metadata(d1 = {"\u0000Ä\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0014\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b&\b'\u0018\u00002\u00020\u0001:\u0006¥\u0001¦\u0001§\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u0011\b\u0000\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J\u000e\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u0016J'\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0017\u0010!\u001a\u0013\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u00170\u0015¢\u0006\u0002\b\"J'\u0010\u001d\u001a\u00020#2\u0006\u0010\u001f\u001a\u00020$2\u0017\u0010!\u001a\u0013\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u00170\u0015¢\u0006\u0002\b\"J'\u0010\u001d\u001a\u00020%2\u0006\u0010\u001f\u001a\u00020&2\u0017\u0010!\u001a\u0013\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u00170\u0015¢\u0006\u0002\b\"J8\u0010\u001d\u001a\u00020\u00172\u0012\u0010'\u001a\n\u0012\u0006\b\u0001\u0012\u00020 0(\"\u00020 2\u0017\u0010!\u001a\u0013\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u00170\u0015¢\u0006\u0002\b\"¢\u0006\u0002\u0010)J.\u0010*\u001a\u00020+2\u0012\u0010,\u001a\n\u0012\u0006\b\u0001\u0012\u00020-0(\"\u00020-2\b\b\u0002\u0010.\u001a\u00020/ø\u0001\u0000¢\u0006\u0004\b0\u00101J.\u00102\u001a\u00020+2\u0012\u0010,\u001a\n\u0012\u0006\b\u0001\u0012\u00020-0(\"\u00020-2\b\b\u0002\u0010.\u001a\u00020/ø\u0001\u0000¢\u0006\u0004\b3\u00101J.\u00104\u001a\u0002052\u0012\u0010,\u001a\n\u0012\u0006\b\u0001\u0012\u00020-0(\"\u00020-2\b\b\u0002\u0010.\u001a\u00020/ø\u0001\u0000¢\u0006\u0004\b6\u00107J:\u00108\u001a\u00020 2\u0012\u0010,\u001a\n\u0012\u0006\b\u0001\u0012\u00020-0(\"\u00020-2\b\b\u0002\u00109\u001a\u00020/2\b\b\u0002\u0010:\u001a\u00020;H\u0007ø\u0001\u0000¢\u0006\u0004\b<\u0010=J.\u0010>\u001a\u00020+2\u0012\u0010,\u001a\n\u0012\u0006\b\u0001\u0012\u00020-0(\"\u00020-2\b\b\u0002\u0010.\u001a\u00020/ø\u0001\u0000¢\u0006\u0004\b?\u00101J¾\u0001\u0010@\u001a\u00020 2\u0016\u0010,\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010-0(\"\u0004\u0018\u00010-2\b\b\u0002\u0010A\u001a\u00020B2\b\b\u0002\u0010C\u001a\u00020/2\b\b\u0002\u0010D\u001a\u00020/2\b\b\u0002\u0010E\u001a\u00020\u00072\b\b\u0002\u0010F\u001a\u00020/2\b\b\u0002\u0010G\u001a\u00020/2\b\b\u0002\u0010H\u001a\u00020/2\b\b\u0002\u0010I\u001a\u00020/2\b\b\u0002\u0010J\u001a\u00020K2\b\b\u0002\u0010L\u001a\u00020M2\b\b\u0002\u0010N\u001a\u00020O2\b\b\u0002\u0010P\u001a\u00020Q2\b\b\u0002\u0010R\u001a\u00020Q2\b\b\u0002\u0010S\u001a\u00020T2\b\b\u0002\u0010U\u001a\u00020Tø\u0001\u0000¢\u0006\u0004\bV\u0010WJª\u0001\u0010@\u001a\u00020 2\u0016\u0010,\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010-0(\"\u0004\u0018\u00010-2\b\b\u0002\u0010A\u001a\u00020B2\b\b\u0002\u0010C\u001a\u00020/2\b\b\u0002\u0010D\u001a\u00020/2\b\b\u0002\u0010E\u001a\u00020\u00072\b\b\u0002\u0010X\u001a\u00020/2\b\b\u0002\u0010Y\u001a\u00020/2\b\b\u0002\u0010J\u001a\u00020K2\b\b\u0002\u0010L\u001a\u00020M2\b\b\u0002\u0010N\u001a\u00020O2\b\b\u0002\u0010P\u001a\u00020Q2\b\b\u0002\u0010R\u001a\u00020Q2\b\b\u0002\u0010S\u001a\u00020T2\b\b\u0002\u0010U\u001a\u00020Tø\u0001\u0000¢\u0006\u0004\bZ\u0010[J \u0001\u0010@\u001a\u00020 2\u0016\u0010,\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010-0(\"\u0004\u0018\u00010-2\b\b\u0002\u0010A\u001a\u00020B2\b\b\u0002\u0010C\u001a\u00020/2\b\b\u0002\u0010D\u001a\u00020/2\b\b\u0002\u0010E\u001a\u00020\u00072\b\b\u0002\u0010\\\u001a\u00020/2\b\b\u0002\u0010J\u001a\u00020K2\b\b\u0002\u0010L\u001a\u00020M2\b\b\u0002\u0010N\u001a\u00020O2\b\b\u0002\u0010P\u001a\u00020Q2\b\b\u0002\u0010R\u001a\u00020Q2\b\b\u0002\u0010S\u001a\u00020T2\b\b\u0002\u0010U\u001a\u00020Tø\u0001\u0000¢\u0006\u0004\b]\u0010^J\u0094\u0001\u0010_\u001a\u00020 2\u0012\u0010,\u001a\n\u0012\u0006\b\u0001\u0012\u00020-0(\"\u00020-2\b\b\u0001\u0010`\u001a\u00020\u00072\b\b\u0001\u0010a\u001a\u00020\u00072\b\b\u0002\u0010b\u001a\u00020B2\b\b\u0002\u0010c\u001a\u00020/2\b\b\u0002\u0010d\u001a\u00020/2\b\b\u0002\u0010e\u001a\u00020;2\b\b\u0002\u0010f\u001a\u00020;2\u000e\b\u0002\u0010g\u001a\b\u0012\u0004\u0012\u00020h0(2\u000e\b\u0002\u0010i\u001a\b\u0012\u0004\u0012\u00020j0(2\b\b\u0002\u0010k\u001a\u00020lø\u0001\u0000¢\u0006\u0004\bm\u0010nJ\u0018\u0010o\u001a\u00020+2\u0006\u0010p\u001a\u00020/ø\u0001\u0000¢\u0006\u0004\bq\u0010rJ\u000e\u0010o\u001a\u00020+2\u0006\u0010s\u001a\u00020QJ\u0018\u0010t\u001a\u00020+2\u0006\u0010p\u001a\u00020/ø\u0001\u0000¢\u0006\u0004\bu\u0010rJ\u000e\u0010t\u001a\u00020+2\u0006\u0010s\u001a\u00020QJ\u0018\u0010v\u001a\u0002052\u0006\u0010p\u001a\u00020/ø\u0001\u0000¢\u0006\u0004\bw\u0010xJ\u000e\u0010v\u001a\u0002052\u0006\u0010s\u001a\u00020QJ\u0018\u0010y\u001a\u00020+2\u0006\u0010p\u001a\u00020/ø\u0001\u0000¢\u0006\u0004\bz\u0010rJ\u000e\u0010y\u001a\u00020+2\u0006\u0010s\u001a\u00020QJ\u0018\u0010{\u001a\u00020+2\u0006\u0010p\u001a\u00020/ø\u0001\u0000¢\u0006\u0004\b|\u0010rJ\u000e\u0010{\u001a\u00020+2\u0006\u0010s\u001a\u00020QJ\u0018\u0010}\u001a\u0002052\u0006\u0010p\u001a\u00020/ø\u0001\u0000¢\u0006\u0004\b~\u0010xJ\u000e\u0010}\u001a\u0002052\u0006\u0010s\u001a\u00020QJ\b\u0010\u007f\u001a\u00020\u0007H\u0002J-\u0010\u0080\u0001\u001a\u00020$2\u0012\u0010,\u001a\n\u0012\u0006\b\u0001\u0012\u00020-0(\"\u00020-2\n\b\u0002\u0010\u0081\u0001\u001a\u00030\u0082\u0001¢\u0006\u0003\u0010\u0083\u0001J<\u0010\u0084\u0001\u001a\u00020 2\u0012\u0010,\u001a\n\u0012\u0006\b\u0001\u0012\u00020-0(\"\u00020-2\b\b\u0002\u00109\u001a\u00020/2\b\b\u0002\u0010:\u001a\u00020;H\u0007ø\u0001\u0000¢\u0006\u0005\b\u0085\u0001\u0010=J0\u0010\u0086\u0001\u001a\u00020+2\u0012\u0010,\u001a\n\u0012\u0006\b\u0001\u0012\u00020-0(\"\u00020-2\b\b\u0002\u0010.\u001a\u00020/ø\u0001\u0000¢\u0006\u0005\b\u0087\u0001\u00101J0\u0010\u0088\u0001\u001a\u0002052\u0012\u0010,\u001a\n\u0012\u0006\b\u0001\u0012\u00020-0(\"\u00020-2\b\b\u0002\u0010.\u001a\u00020/ø\u0001\u0000¢\u0006\u0005\b\u0089\u0001\u00107J-\u0010\u008a\u0001\u001a\u00020&2\u0012\u0010,\u001a\n\u0012\u0006\b\u0001\u0012\u00020-0(\"\u00020-2\n\b\u0002\u0010\u0081\u0001\u001a\u00030\u0082\u0001¢\u0006\u0003\u0010\u008b\u0001J\u0015\u0010\u008c\u0001\u001a\u00020B2\t\u0010\u008d\u0001\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\t\u0010\u008e\u0001\u001a\u00020\u0007H\u0016J\t\u0010\u008f\u0001\u001a\u00020\u0017H\u0016J\u0012\u0010\u0090\u0001\u001a\u00020\u00172\u0007\u0010\u0091\u0001\u001a\u00020\u0007H\u0002J\u0013\u0010\u0092\u0001\u001a\u00020\u0004*\u00020-H\u0000¢\u0006\u0003\b\u0093\u0001Jz\u0010\u0094\u0001\u001a\u00020-*\u00020-2\t\b\u0002\u0010\u0095\u0001\u001a\u00020/2\t\b\u0002\u0010\u0096\u0001\u001a\u00020/2\t\b\u0002\u0010\u0097\u0001\u001a\u00020/2\t\b\u0002\u0010\u0098\u0001\u001a\u00020/2\t\b\u0002\u0010\u0099\u0001\u001a\u00020/2\t\b\u0002\u0010\u009a\u0001\u001a\u00020/2\t\b\u0002\u0010\u009b\u0001\u001a\u00020/2\t\b\u0002\u0010\u009c\u0001\u001a\u00020/2\t\b\u0002\u0010\u009d\u0001\u001a\u00020Qø\u0001\u0000¢\u0006\u0006\b\u009e\u0001\u0010\u009f\u0001JN\u0010 \u0001\u001a\u00020-*\u00020-2\t\b\u0002\u0010\u0095\u0001\u001a\u00020/2\t\b\u0002\u0010\u0097\u0001\u001a\u00020/2\t\b\u0002\u0010\u0099\u0001\u001a\u00020/2\t\b\u0002\u0010\u009b\u0001\u001a\u00020/2\t\b\u0002\u0010\u009d\u0001\u001a\u00020Qø\u0001\u0000¢\u0006\u0006\b¡\u0001\u0010¢\u0001JN\u0010£\u0001\u001a\u00020-*\u00020-2\t\b\u0002\u0010\u0096\u0001\u001a\u00020/2\t\b\u0002\u0010\u0098\u0001\u001a\u00020/2\t\b\u0002\u0010\u009a\u0001\u001a\u00020/2\t\b\u0002\u0010\u009c\u0001\u001a\u00020/2\t\b\u0002\u0010\u009d\u0001\u001a\u00020Qø\u0001\u0000¢\u0006\u0006\b¤\u0001\u0010¢\u0001R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u00020\u00048\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\t\u0010\u0002\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\r\u001a\u00020\u00078\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u000e\u0010\u0002\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R.\u0010\u0013\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00170\u00150\u00148\u0004X\u0085\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0018\u0010\u0002\u001a\u0004\b\u0019\u0010\u001a\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006¨\u0001"}, d2 = {"Landroidx/constraintlayout/compose/ConstraintLayoutBaseScope;", "", "()V", "extendFrom", "Landroidx/constraintlayout/core/parser/CLObject;", "(Landroidx/constraintlayout/core/parser/CLObject;)V", "HelpersStartId", "", "containerObject", "getContainerObject$annotations", "getContainerObject", "()Landroidx/constraintlayout/core/parser/CLObject;", "helperId", "helpersHashCode", "getHelpersHashCode$annotations", "getHelpersHashCode", "()I", "setHelpersHashCode", "(I)V", "tasks", "", "Lkotlin/Function1;", "Landroidx/constraintlayout/compose/State;", "", "getTasks$annotations", "getTasks", "()Ljava/util/List;", "applyTo", RemoteConfigConstants.ResponseFieldKey.STATE, "constrain", "Landroidx/constraintlayout/compose/ConstrainScope;", "ref", "Landroidx/constraintlayout/compose/ConstrainedLayoutReference;", "constrainBlock", "Lkotlin/ExtensionFunctionType;", "Landroidx/constraintlayout/compose/HorizontalChainScope;", "Landroidx/constraintlayout/compose/HorizontalChainReference;", "Landroidx/constraintlayout/compose/VerticalChainScope;", "Landroidx/constraintlayout/compose/VerticalChainReference;", "refs", "", "([Landroidx/constraintlayout/compose/ConstrainedLayoutReference;Lkotlin/jvm/functions/Function1;)V", "createAbsoluteLeftBarrier", "Landroidx/constraintlayout/compose/ConstraintLayoutBaseScope$VerticalAnchor;", "elements", "Landroidx/constraintlayout/compose/LayoutReference;", "margin", "Landroidx/compose/ui/unit/Dp;", "createAbsoluteLeftBarrier-3ABfNKs", "([Landroidx/constraintlayout/compose/LayoutReference;F)Landroidx/constraintlayout/compose/ConstraintLayoutBaseScope$VerticalAnchor;", "createAbsoluteRightBarrier", "createAbsoluteRightBarrier-3ABfNKs", "createBottomBarrier", "Landroidx/constraintlayout/compose/ConstraintLayoutBaseScope$HorizontalAnchor;", "createBottomBarrier-3ABfNKs", "([Landroidx/constraintlayout/compose/LayoutReference;F)Landroidx/constraintlayout/compose/ConstraintLayoutBaseScope$HorizontalAnchor;", "createColumn", "spacing", "weights", "", "createColumn-lG28NQ4", "([Landroidx/constraintlayout/compose/LayoutReference;F[F)Landroidx/constraintlayout/compose/ConstrainedLayoutReference;", "createEndBarrier", "createEndBarrier-3ABfNKs", "createFlow", "flowVertically", "", "verticalGap", "horizontalGap", "maxElement", "paddingLeft", "paddingTop", "paddingRight", "paddingBottom", "wrapMode", "Landroidx/constraintlayout/compose/Wrap;", "verticalAlign", "Landroidx/constraintlayout/compose/VerticalAlign;", "horizontalAlign", "Landroidx/constraintlayout/compose/HorizontalAlign;", "horizontalFlowBias", "", "verticalFlowBias", "verticalStyle", "Landroidx/constraintlayout/compose/FlowStyle;", "horizontalStyle", "createFlow-Fgo90cY", "([Landroidx/constraintlayout/compose/LayoutReference;ZFFIFFFFLandroidx/constraintlayout/compose/Wrap;Landroidx/constraintlayout/compose/VerticalAlign;Landroidx/constraintlayout/compose/HorizontalAlign;FFLandroidx/constraintlayout/compose/FlowStyle;Landroidx/constraintlayout/compose/FlowStyle;)Landroidx/constraintlayout/compose/ConstrainedLayoutReference;", "paddingHorizontal", "paddingVertical", "createFlow-6oEtc9w", "([Landroidx/constraintlayout/compose/LayoutReference;ZFFIFFLandroidx/constraintlayout/compose/Wrap;Landroidx/constraintlayout/compose/VerticalAlign;Landroidx/constraintlayout/compose/HorizontalAlign;FFLandroidx/constraintlayout/compose/FlowStyle;Landroidx/constraintlayout/compose/FlowStyle;)Landroidx/constraintlayout/compose/ConstrainedLayoutReference;", "padding", "createFlow-IkjhEj4", "([Landroidx/constraintlayout/compose/LayoutReference;ZFFIFLandroidx/constraintlayout/compose/Wrap;Landroidx/constraintlayout/compose/VerticalAlign;Landroidx/constraintlayout/compose/HorizontalAlign;FFLandroidx/constraintlayout/compose/FlowStyle;Landroidx/constraintlayout/compose/FlowStyle;)Landroidx/constraintlayout/compose/ConstrainedLayoutReference;", "createGrid", "rows", "columns", "isHorizontalArrangement", "verticalSpacing", "horizontalSpacing", "rowWeights", "columnWeights", "skips", "Landroidx/constraintlayout/compose/Skip;", "spans", "Landroidx/constraintlayout/compose/Span;", DownloaderServiceMarshaller.PARAMS_FLAGS, "Landroidx/constraintlayout/compose/GridFlag;", "createGrid-Hu23Yyw", "([Landroidx/constraintlayout/compose/LayoutReference;IIZFF[F[F[Landroidx/constraintlayout/compose/Skip;[Landroidx/constraintlayout/compose/Span;I)Landroidx/constraintlayout/compose/ConstrainedLayoutReference;", "createGuidelineFromAbsoluteLeft", TypedValues.CycleType.S_WAVE_OFFSET, "createGuidelineFromAbsoluteLeft-0680j_4", "(F)Landroidx/constraintlayout/compose/ConstraintLayoutBaseScope$VerticalAnchor;", "fraction", "createGuidelineFromAbsoluteRight", "createGuidelineFromAbsoluteRight-0680j_4", "createGuidelineFromBottom", "createGuidelineFromBottom-0680j_4", "(F)Landroidx/constraintlayout/compose/ConstraintLayoutBaseScope$HorizontalAnchor;", "createGuidelineFromEnd", "createGuidelineFromEnd-0680j_4", "createGuidelineFromStart", "createGuidelineFromStart-0680j_4", "createGuidelineFromTop", "createGuidelineFromTop-0680j_4", "createHelperId", "createHorizontalChain", "chainStyle", "Landroidx/constraintlayout/compose/ChainStyle;", "([Landroidx/constraintlayout/compose/LayoutReference;Landroidx/constraintlayout/compose/ChainStyle;)Landroidx/constraintlayout/compose/HorizontalChainReference;", "createRow", "createRow-lG28NQ4", "createStartBarrier", "createStartBarrier-3ABfNKs", "createTopBarrier", "createTopBarrier-3ABfNKs", "createVerticalChain", "([Landroidx/constraintlayout/compose/LayoutReference;Landroidx/constraintlayout/compose/ChainStyle;)Landroidx/constraintlayout/compose/VerticalChainReference;", "equals", "other", "hashCode", "reset", "updateHelpersHashCode", "value", "asCLContainer", "asCLContainer$constraintlayout_compose_release", "withChainParams", "startMargin", "topMargin", "endMargin", "bottomMargin", "startGoneMargin", "topGoneMargin", "endGoneMargin", "bottomGoneMargin", "weight", "withChainParams-ouYQatA", "(Landroidx/constraintlayout/compose/LayoutReference;FFFFFFFFF)Landroidx/constraintlayout/compose/LayoutReference;", "withHorizontalChainParams", "withHorizontalChainParams-YLPp7PM", "(Landroidx/constraintlayout/compose/LayoutReference;FFFFF)Landroidx/constraintlayout/compose/LayoutReference;", "withVerticalChainParams", "withVerticalChainParams-YLPp7PM", "BaselineAnchor", "HorizontalAnchor", "VerticalAnchor", "constraintlayout-compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class ConstraintLayoutBaseScope {
    public static final int $stable = 8;
    private final int HelpersStartId;
    private final CLObject containerObject;
    private int helperId;
    private int helpersHashCode;
    private final List<Function1<State, Unit>> tasks;

    public static /* synthetic */ void getContainerObject$annotations() {
    }

    public static /* synthetic */ void getHelpersHashCode$annotations() {
    }

    @Deprecated(message = "Tasks is unused, it breaks the immutability promise.")
    protected static /* synthetic */ void getTasks$annotations() {
    }

    public ConstraintLayoutBaseScope(CLObject cLObject) {
        CLObject cLObject2;
        this.tasks = new ArrayList();
        this.containerObject = (cLObject == null || (cLObject2 = cLObject.mo7166clone()) == null) ? new CLObject(new char[0]) : cLObject2;
        this.HelpersStartId = 1000;
        this.helperId = 1000;
    }

    public ConstraintLayoutBaseScope() {
        this(null);
    }

    protected final List<Function1<State, Unit>> getTasks() {
        return this.tasks;
    }

    public final CLObject getContainerObject() {
        return this.containerObject;
    }

    public final void applyTo(State state) {
        ConstraintSetParser.populateState(this.containerObject, state, new ConstraintSetParser.LayoutVariables());
    }

    public void reset() {
        this.containerObject.clear();
        this.helperId = this.HelpersStartId;
        this.helpersHashCode = 0;
    }

    public final int getHelpersHashCode() {
        return this.helpersHashCode;
    }

    public final void setHelpersHashCode(int i) {
        this.helpersHashCode = i;
    }

    private final void updateHelpersHashCode(int i) {
        this.helpersHashCode = ((this.helpersHashCode * 1009) + i) % 1000000007;
    }

    private final int createHelperId() {
        int i = this.helperId;
        this.helperId = i + 1;
        return i;
    }

    /* compiled from: ConstraintLayoutBaseScope.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000e\u0010\u000e\u001a\u00020\u0001HÀ\u0003¢\u0006\u0002\b\u000fJ\u000e\u0010\u0010\u001a\u00020\u0004HÀ\u0003¢\u0006\u0002\b\u0011J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0004HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u001a"}, d2 = {"Landroidx/constraintlayout/compose/ConstraintLayoutBaseScope$VerticalAnchor;", "", "id", FirebaseAnalytics.Param.INDEX, "", TypedValues.Custom.S_REFERENCE, "Landroidx/constraintlayout/compose/LayoutReference;", "(Ljava/lang/Object;ILandroidx/constraintlayout/compose/LayoutReference;)V", "getId$constraintlayout_compose_release", "()Ljava/lang/Object;", "getIndex$constraintlayout_compose_release", "()I", "getReference", "()Landroidx/constraintlayout/compose/LayoutReference;", "component1", "component1$constraintlayout_compose_release", "component2", "component2$constraintlayout_compose_release", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "constraintlayout-compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class VerticalAnchor {
        public static final int $stable = 0;
        private final Object id;
        private final int index;
        private final LayoutReference reference;

        public static /* synthetic */ VerticalAnchor copy$default(VerticalAnchor verticalAnchor, Object obj, int i, LayoutReference layoutReference, int i2, Object obj2) {
            if ((i2 & 1) != 0) {
                obj = verticalAnchor.id;
            }
            if ((i2 & 2) != 0) {
                i = verticalAnchor.index;
            }
            if ((i2 & 4) != 0) {
                layoutReference = verticalAnchor.reference;
            }
            return verticalAnchor.copy(obj, i, layoutReference);
        }

        public final Object component1$constraintlayout_compose_release() {
            return this.id;
        }

        public final int component2$constraintlayout_compose_release() {
            return this.index;
        }

        public final LayoutReference component3() {
            return this.reference;
        }

        public final VerticalAnchor copy(Object obj, int i, LayoutReference layoutReference) {
            return new VerticalAnchor(obj, i, layoutReference);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof VerticalAnchor) {
                VerticalAnchor verticalAnchor = (VerticalAnchor) obj;
                return Intrinsics.areEqual(this.id, verticalAnchor.id) && this.index == verticalAnchor.index && Intrinsics.areEqual(this.reference, verticalAnchor.reference);
            }
            return false;
        }

        public int hashCode() {
            return (((this.id.hashCode() * 31) + Integer.hashCode(this.index)) * 31) + this.reference.hashCode();
        }

        public String toString() {
            return "VerticalAnchor(id=" + this.id + ", index=" + this.index + ", reference=" + this.reference + ')';
        }

        public VerticalAnchor(Object obj, int i, LayoutReference layoutReference) {
            this.id = obj;
            this.index = i;
            this.reference = layoutReference;
        }

        public final Object getId$constraintlayout_compose_release() {
            return this.id;
        }

        public final int getIndex$constraintlayout_compose_release() {
            return this.index;
        }

        public final LayoutReference getReference() {
            return this.reference;
        }
    }

    /* compiled from: ConstraintLayoutBaseScope.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000e\u0010\u000e\u001a\u00020\u0001HÀ\u0003¢\u0006\u0002\b\u000fJ\u000e\u0010\u0010\u001a\u00020\u0004HÀ\u0003¢\u0006\u0002\b\u0011J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0004HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u001a"}, d2 = {"Landroidx/constraintlayout/compose/ConstraintLayoutBaseScope$HorizontalAnchor;", "", "id", FirebaseAnalytics.Param.INDEX, "", TypedValues.Custom.S_REFERENCE, "Landroidx/constraintlayout/compose/LayoutReference;", "(Ljava/lang/Object;ILandroidx/constraintlayout/compose/LayoutReference;)V", "getId$constraintlayout_compose_release", "()Ljava/lang/Object;", "getIndex$constraintlayout_compose_release", "()I", "getReference", "()Landroidx/constraintlayout/compose/LayoutReference;", "component1", "component1$constraintlayout_compose_release", "component2", "component2$constraintlayout_compose_release", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "constraintlayout-compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class HorizontalAnchor {
        public static final int $stable = 0;
        private final Object id;
        private final int index;
        private final LayoutReference reference;

        public static /* synthetic */ HorizontalAnchor copy$default(HorizontalAnchor horizontalAnchor, Object obj, int i, LayoutReference layoutReference, int i2, Object obj2) {
            if ((i2 & 1) != 0) {
                obj = horizontalAnchor.id;
            }
            if ((i2 & 2) != 0) {
                i = horizontalAnchor.index;
            }
            if ((i2 & 4) != 0) {
                layoutReference = horizontalAnchor.reference;
            }
            return horizontalAnchor.copy(obj, i, layoutReference);
        }

        public final Object component1$constraintlayout_compose_release() {
            return this.id;
        }

        public final int component2$constraintlayout_compose_release() {
            return this.index;
        }

        public final LayoutReference component3() {
            return this.reference;
        }

        public final HorizontalAnchor copy(Object obj, int i, LayoutReference layoutReference) {
            return new HorizontalAnchor(obj, i, layoutReference);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof HorizontalAnchor) {
                HorizontalAnchor horizontalAnchor = (HorizontalAnchor) obj;
                return Intrinsics.areEqual(this.id, horizontalAnchor.id) && this.index == horizontalAnchor.index && Intrinsics.areEqual(this.reference, horizontalAnchor.reference);
            }
            return false;
        }

        public int hashCode() {
            return (((this.id.hashCode() * 31) + Integer.hashCode(this.index)) * 31) + this.reference.hashCode();
        }

        public String toString() {
            return "HorizontalAnchor(id=" + this.id + ", index=" + this.index + ", reference=" + this.reference + ')';
        }

        public HorizontalAnchor(Object obj, int i, LayoutReference layoutReference) {
            this.id = obj;
            this.index = i;
            this.reference = layoutReference;
        }

        public final Object getId$constraintlayout_compose_release() {
            return this.id;
        }

        public final int getIndex$constraintlayout_compose_release() {
            return this.index;
        }

        public final LayoutReference getReference() {
            return this.reference;
        }
    }

    /* compiled from: ConstraintLayoutBaseScope.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u000e\u0010\n\u001a\u00020\u0001HÀ\u0003¢\u0006\u0002\b\u000bJ\t\u0010\f\u001a\u00020\u0004HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0015"}, d2 = {"Landroidx/constraintlayout/compose/ConstraintLayoutBaseScope$BaselineAnchor;", "", "id", TypedValues.Custom.S_REFERENCE, "Landroidx/constraintlayout/compose/LayoutReference;", "(Ljava/lang/Object;Landroidx/constraintlayout/compose/LayoutReference;)V", "getId$constraintlayout_compose_release", "()Ljava/lang/Object;", "getReference", "()Landroidx/constraintlayout/compose/LayoutReference;", "component1", "component1$constraintlayout_compose_release", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "constraintlayout-compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class BaselineAnchor {
        public static final int $stable = 0;
        private final Object id;
        private final LayoutReference reference;

        public static /* synthetic */ BaselineAnchor copy$default(BaselineAnchor baselineAnchor, Object obj, LayoutReference layoutReference, int i, Object obj2) {
            if ((i & 1) != 0) {
                obj = baselineAnchor.id;
            }
            if ((i & 2) != 0) {
                layoutReference = baselineAnchor.reference;
            }
            return baselineAnchor.copy(obj, layoutReference);
        }

        public final Object component1$constraintlayout_compose_release() {
            return this.id;
        }

        public final LayoutReference component2() {
            return this.reference;
        }

        public final BaselineAnchor copy(Object obj, LayoutReference layoutReference) {
            return new BaselineAnchor(obj, layoutReference);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof BaselineAnchor) {
                BaselineAnchor baselineAnchor = (BaselineAnchor) obj;
                return Intrinsics.areEqual(this.id, baselineAnchor.id) && Intrinsics.areEqual(this.reference, baselineAnchor.reference);
            }
            return false;
        }

        public int hashCode() {
            return (this.id.hashCode() * 31) + this.reference.hashCode();
        }

        public String toString() {
            return "BaselineAnchor(id=" + this.id + ", reference=" + this.reference + ')';
        }

        public BaselineAnchor(Object obj, LayoutReference layoutReference) {
            this.id = obj;
            this.reference = layoutReference;
        }

        public final Object getId$constraintlayout_compose_release() {
            return this.id;
        }

        public final LayoutReference getReference() {
            return this.reference;
        }
    }

    public final HorizontalChainScope constrain(HorizontalChainReference horizontalChainReference, Function1<? super HorizontalChainScope, Unit> function1) {
        HorizontalChainScope horizontalChainScope = new HorizontalChainScope(horizontalChainReference.getId$constraintlayout_compose_release(), asCLContainer$constraintlayout_compose_release(horizontalChainReference));
        function1.invoke(horizontalChainScope);
        return horizontalChainScope;
    }

    public final VerticalChainScope constrain(VerticalChainReference verticalChainReference, Function1<? super VerticalChainScope, Unit> function1) {
        VerticalChainScope verticalChainScope = new VerticalChainScope(verticalChainReference.getId$constraintlayout_compose_release(), asCLContainer$constraintlayout_compose_release(verticalChainReference));
        function1.invoke(verticalChainScope);
        return verticalChainScope;
    }

    public final ConstrainScope constrain(ConstrainedLayoutReference constrainedLayoutReference, Function1<? super ConstrainScope, Unit> function1) {
        ConstrainScope constrainScope = new ConstrainScope(constrainedLayoutReference.getId$constraintlayout_compose_release(), asCLContainer$constraintlayout_compose_release(constrainedLayoutReference));
        function1.invoke(constrainScope);
        return constrainScope;
    }

    /* renamed from: createGuidelineFromStart-0680j_4  reason: not valid java name */
    public final VerticalAnchor m7002createGuidelineFromStart0680j_4(float f) {
        LayoutReferenceImpl layoutReferenceImpl = new LayoutReferenceImpl(Integer.valueOf(createHelperId()));
        LayoutReferenceImpl layoutReferenceImpl2 = layoutReferenceImpl;
        CLObject asCLContainer$constraintlayout_compose_release = asCLContainer$constraintlayout_compose_release(layoutReferenceImpl2);
        asCLContainer$constraintlayout_compose_release.putString("type", "vGuideline");
        asCLContainer$constraintlayout_compose_release.putNumber(TtmlNode.START, f);
        updateHelpersHashCode(1);
        updateHelpersHashCode(Dp.m6690hashCodeimpl(f));
        return new VerticalAnchor(layoutReferenceImpl.getId$constraintlayout_compose_release(), 0, layoutReferenceImpl2);
    }

    /* renamed from: createGuidelineFromAbsoluteLeft-0680j_4  reason: not valid java name */
    public final VerticalAnchor m6998createGuidelineFromAbsoluteLeft0680j_4(float f) {
        LayoutReferenceImpl layoutReferenceImpl = new LayoutReferenceImpl(Integer.valueOf(createHelperId()));
        LayoutReferenceImpl layoutReferenceImpl2 = layoutReferenceImpl;
        CLObject asCLContainer$constraintlayout_compose_release = asCLContainer$constraintlayout_compose_release(layoutReferenceImpl2);
        asCLContainer$constraintlayout_compose_release.putString("type", "vGuideline");
        asCLContainer$constraintlayout_compose_release.putNumber(TtmlNode.LEFT, f);
        updateHelpersHashCode(2);
        updateHelpersHashCode(Dp.m6690hashCodeimpl(f));
        return new VerticalAnchor(layoutReferenceImpl.getId$constraintlayout_compose_release(), 0, layoutReferenceImpl2);
    }

    public final VerticalAnchor createGuidelineFromStart(float f) {
        LayoutReferenceImpl layoutReferenceImpl = new LayoutReferenceImpl(Integer.valueOf(createHelperId()));
        CLArray cLArray = new CLArray(new char[0]);
        cLArray.add(CLString.from(TtmlNode.START));
        cLArray.add(new CLNumber(f));
        LayoutReferenceImpl layoutReferenceImpl2 = layoutReferenceImpl;
        CLObject asCLContainer$constraintlayout_compose_release = asCLContainer$constraintlayout_compose_release(layoutReferenceImpl2);
        asCLContainer$constraintlayout_compose_release.putString("type", "vGuideline");
        asCLContainer$constraintlayout_compose_release.put("percent", cLArray);
        updateHelpersHashCode(3);
        updateHelpersHashCode(Float.hashCode(f));
        return new VerticalAnchor(layoutReferenceImpl.getId$constraintlayout_compose_release(), 0, layoutReferenceImpl2);
    }

    public final VerticalAnchor createGuidelineFromAbsoluteLeft(float f) {
        LayoutReferenceImpl layoutReferenceImpl = new LayoutReferenceImpl(Integer.valueOf(createHelperId()));
        LayoutReferenceImpl layoutReferenceImpl2 = layoutReferenceImpl;
        CLObject asCLContainer$constraintlayout_compose_release = asCLContainer$constraintlayout_compose_release(layoutReferenceImpl2);
        asCLContainer$constraintlayout_compose_release.putString("type", "vGuideline");
        asCLContainer$constraintlayout_compose_release.putNumber("percent", f);
        updateHelpersHashCode(4);
        updateHelpersHashCode(Float.hashCode(f));
        return new VerticalAnchor(layoutReferenceImpl.getId$constraintlayout_compose_release(), 0, layoutReferenceImpl2);
    }

    /* renamed from: createGuidelineFromEnd-0680j_4  reason: not valid java name */
    public final VerticalAnchor m7001createGuidelineFromEnd0680j_4(float f) {
        LayoutReferenceImpl layoutReferenceImpl = new LayoutReferenceImpl(Integer.valueOf(createHelperId()));
        LayoutReferenceImpl layoutReferenceImpl2 = layoutReferenceImpl;
        CLObject asCLContainer$constraintlayout_compose_release = asCLContainer$constraintlayout_compose_release(layoutReferenceImpl2);
        asCLContainer$constraintlayout_compose_release.putString("type", "vGuideline");
        asCLContainer$constraintlayout_compose_release.putNumber(TtmlNode.END, f);
        updateHelpersHashCode(5);
        updateHelpersHashCode(Dp.m6690hashCodeimpl(f));
        return new VerticalAnchor(layoutReferenceImpl.getId$constraintlayout_compose_release(), 0, layoutReferenceImpl2);
    }

    /* renamed from: createGuidelineFromAbsoluteRight-0680j_4  reason: not valid java name */
    public final VerticalAnchor m6999createGuidelineFromAbsoluteRight0680j_4(float f) {
        LayoutReferenceImpl layoutReferenceImpl = new LayoutReferenceImpl(Integer.valueOf(createHelperId()));
        LayoutReferenceImpl layoutReferenceImpl2 = layoutReferenceImpl;
        CLObject asCLContainer$constraintlayout_compose_release = asCLContainer$constraintlayout_compose_release(layoutReferenceImpl2);
        asCLContainer$constraintlayout_compose_release.putString("type", "vGuideline");
        asCLContainer$constraintlayout_compose_release.putNumber(TtmlNode.RIGHT, f);
        updateHelpersHashCode(6);
        updateHelpersHashCode(Dp.m6690hashCodeimpl(f));
        return new VerticalAnchor(layoutReferenceImpl.getId$constraintlayout_compose_release(), 0, layoutReferenceImpl2);
    }

    public final VerticalAnchor createGuidelineFromEnd(float f) {
        LayoutReferenceImpl layoutReferenceImpl = new LayoutReferenceImpl(Integer.valueOf(createHelperId()));
        CLArray cLArray = new CLArray(new char[0]);
        cLArray.add(CLString.from(TtmlNode.END));
        cLArray.add(new CLNumber(f));
        LayoutReferenceImpl layoutReferenceImpl2 = layoutReferenceImpl;
        CLObject asCLContainer$constraintlayout_compose_release = asCLContainer$constraintlayout_compose_release(layoutReferenceImpl2);
        asCLContainer$constraintlayout_compose_release.putString("type", "vGuideline");
        asCLContainer$constraintlayout_compose_release.put("percent", cLArray);
        updateHelpersHashCode(3);
        updateHelpersHashCode(Float.hashCode(f));
        return new VerticalAnchor(layoutReferenceImpl.getId$constraintlayout_compose_release(), 0, layoutReferenceImpl2);
    }

    public final VerticalAnchor createGuidelineFromAbsoluteRight(float f) {
        return createGuidelineFromAbsoluteLeft(1.0f - f);
    }

    /* renamed from: createGuidelineFromTop-0680j_4  reason: not valid java name */
    public final HorizontalAnchor m7003createGuidelineFromTop0680j_4(float f) {
        LayoutReferenceImpl layoutReferenceImpl = new LayoutReferenceImpl(Integer.valueOf(createHelperId()));
        LayoutReferenceImpl layoutReferenceImpl2 = layoutReferenceImpl;
        CLObject asCLContainer$constraintlayout_compose_release = asCLContainer$constraintlayout_compose_release(layoutReferenceImpl2);
        asCLContainer$constraintlayout_compose_release.putString("type", "hGuideline");
        asCLContainer$constraintlayout_compose_release.putNumber(TtmlNode.START, f);
        updateHelpersHashCode(7);
        updateHelpersHashCode(Dp.m6690hashCodeimpl(f));
        return new HorizontalAnchor(layoutReferenceImpl.getId$constraintlayout_compose_release(), 0, layoutReferenceImpl2);
    }

    public final HorizontalAnchor createGuidelineFromTop(float f) {
        LayoutReferenceImpl layoutReferenceImpl = new LayoutReferenceImpl(Integer.valueOf(createHelperId()));
        LayoutReferenceImpl layoutReferenceImpl2 = layoutReferenceImpl;
        CLObject asCLContainer$constraintlayout_compose_release = asCLContainer$constraintlayout_compose_release(layoutReferenceImpl2);
        asCLContainer$constraintlayout_compose_release.putString("type", "hGuideline");
        asCLContainer$constraintlayout_compose_release.putNumber("percent", f);
        updateHelpersHashCode(8);
        updateHelpersHashCode(Float.hashCode(f));
        return new HorizontalAnchor(layoutReferenceImpl.getId$constraintlayout_compose_release(), 0, layoutReferenceImpl2);
    }

    /* renamed from: createGuidelineFromBottom-0680j_4  reason: not valid java name */
    public final HorizontalAnchor m7000createGuidelineFromBottom0680j_4(float f) {
        LayoutReferenceImpl layoutReferenceImpl = new LayoutReferenceImpl(Integer.valueOf(createHelperId()));
        LayoutReferenceImpl layoutReferenceImpl2 = layoutReferenceImpl;
        CLObject asCLContainer$constraintlayout_compose_release = asCLContainer$constraintlayout_compose_release(layoutReferenceImpl2);
        asCLContainer$constraintlayout_compose_release.putString("type", "hGuideline");
        asCLContainer$constraintlayout_compose_release.putNumber(TtmlNode.END, f);
        updateHelpersHashCode(9);
        updateHelpersHashCode(Dp.m6690hashCodeimpl(f));
        return new HorizontalAnchor(layoutReferenceImpl.getId$constraintlayout_compose_release(), 0, layoutReferenceImpl2);
    }

    public final HorizontalAnchor createGuidelineFromBottom(float f) {
        return createGuidelineFromTop(1.0f - f);
    }

    /* renamed from: createStartBarrier-3ABfNKs  reason: not valid java name */
    public final VerticalAnchor m7005createStartBarrier3ABfNKs(LayoutReference[] layoutReferenceArr, float f) {
        LayoutReferenceImpl layoutReferenceImpl = new LayoutReferenceImpl(Integer.valueOf(createHelperId()));
        CLArray cLArray = new CLArray(new char[0]);
        for (LayoutReference layoutReference : layoutReferenceArr) {
            cLArray.add(CLString.from(layoutReference.getId$constraintlayout_compose_release().toString()));
        }
        LayoutReferenceImpl layoutReferenceImpl2 = layoutReferenceImpl;
        CLObject asCLContainer$constraintlayout_compose_release = asCLContainer$constraintlayout_compose_release(layoutReferenceImpl2);
        asCLContainer$constraintlayout_compose_release.putString("type", "barrier");
        asCLContainer$constraintlayout_compose_release.putString("direction", TtmlNode.START);
        asCLContainer$constraintlayout_compose_release.putNumber("margin", f);
        asCLContainer$constraintlayout_compose_release.put("contains", cLArray);
        updateHelpersHashCode(10);
        for (LayoutReference layoutReference2 : layoutReferenceArr) {
            updateHelpersHashCode(layoutReference2.hashCode());
        }
        updateHelpersHashCode(Dp.m6690hashCodeimpl(f));
        return new VerticalAnchor(layoutReferenceImpl.getId$constraintlayout_compose_release(), 0, layoutReferenceImpl2);
    }

    /* renamed from: createAbsoluteLeftBarrier-3ABfNKs  reason: not valid java name */
    public final VerticalAnchor m6989createAbsoluteLeftBarrier3ABfNKs(LayoutReference[] layoutReferenceArr, float f) {
        LayoutReferenceImpl layoutReferenceImpl = new LayoutReferenceImpl(Integer.valueOf(createHelperId()));
        CLArray cLArray = new CLArray(new char[0]);
        for (LayoutReference layoutReference : layoutReferenceArr) {
            cLArray.add(CLString.from(layoutReference.getId$constraintlayout_compose_release().toString()));
        }
        LayoutReferenceImpl layoutReferenceImpl2 = layoutReferenceImpl;
        CLObject asCLContainer$constraintlayout_compose_release = asCLContainer$constraintlayout_compose_release(layoutReferenceImpl2);
        asCLContainer$constraintlayout_compose_release.putString("type", "barrier");
        asCLContainer$constraintlayout_compose_release.putString("direction", TtmlNode.LEFT);
        asCLContainer$constraintlayout_compose_release.putNumber("margin", f);
        asCLContainer$constraintlayout_compose_release.put("contains", cLArray);
        updateHelpersHashCode(11);
        for (LayoutReference layoutReference2 : layoutReferenceArr) {
            updateHelpersHashCode(layoutReference2.hashCode());
        }
        updateHelpersHashCode(Dp.m6690hashCodeimpl(f));
        return new VerticalAnchor(layoutReferenceImpl.getId$constraintlayout_compose_release(), 0, layoutReferenceImpl2);
    }

    /* renamed from: createTopBarrier-3ABfNKs  reason: not valid java name */
    public final HorizontalAnchor m7006createTopBarrier3ABfNKs(LayoutReference[] layoutReferenceArr, float f) {
        LayoutReferenceImpl layoutReferenceImpl = new LayoutReferenceImpl(Integer.valueOf(createHelperId()));
        CLArray cLArray = new CLArray(new char[0]);
        for (LayoutReference layoutReference : layoutReferenceArr) {
            cLArray.add(CLString.from(layoutReference.getId$constraintlayout_compose_release().toString()));
        }
        LayoutReferenceImpl layoutReferenceImpl2 = layoutReferenceImpl;
        CLObject asCLContainer$constraintlayout_compose_release = asCLContainer$constraintlayout_compose_release(layoutReferenceImpl2);
        asCLContainer$constraintlayout_compose_release.putString("type", "barrier");
        asCLContainer$constraintlayout_compose_release.putString("direction", "top");
        asCLContainer$constraintlayout_compose_release.putNumber("margin", f);
        asCLContainer$constraintlayout_compose_release.put("contains", cLArray);
        updateHelpersHashCode(12);
        for (LayoutReference layoutReference2 : layoutReferenceArr) {
            updateHelpersHashCode(layoutReference2.hashCode());
        }
        updateHelpersHashCode(Dp.m6690hashCodeimpl(f));
        return new HorizontalAnchor(layoutReferenceImpl.getId$constraintlayout_compose_release(), 0, layoutReferenceImpl2);
    }

    /* renamed from: createEndBarrier-3ABfNKs  reason: not valid java name */
    public final VerticalAnchor m6993createEndBarrier3ABfNKs(LayoutReference[] layoutReferenceArr, float f) {
        LayoutReferenceImpl layoutReferenceImpl = new LayoutReferenceImpl(Integer.valueOf(createHelperId()));
        CLArray cLArray = new CLArray(new char[0]);
        for (LayoutReference layoutReference : layoutReferenceArr) {
            cLArray.add(CLString.from(layoutReference.getId$constraintlayout_compose_release().toString()));
        }
        LayoutReferenceImpl layoutReferenceImpl2 = layoutReferenceImpl;
        CLObject asCLContainer$constraintlayout_compose_release = asCLContainer$constraintlayout_compose_release(layoutReferenceImpl2);
        asCLContainer$constraintlayout_compose_release.putString("type", "barrier");
        asCLContainer$constraintlayout_compose_release.putString("direction", TtmlNode.END);
        asCLContainer$constraintlayout_compose_release.putNumber("margin", f);
        asCLContainer$constraintlayout_compose_release.put("contains", cLArray);
        updateHelpersHashCode(13);
        for (LayoutReference layoutReference2 : layoutReferenceArr) {
            updateHelpersHashCode(layoutReference2.hashCode());
        }
        updateHelpersHashCode(Dp.m6690hashCodeimpl(f));
        return new VerticalAnchor(layoutReferenceImpl.getId$constraintlayout_compose_release(), 0, layoutReferenceImpl2);
    }

    /* renamed from: createAbsoluteRightBarrier-3ABfNKs  reason: not valid java name */
    public final VerticalAnchor m6990createAbsoluteRightBarrier3ABfNKs(LayoutReference[] layoutReferenceArr, float f) {
        LayoutReferenceImpl layoutReferenceImpl = new LayoutReferenceImpl(Integer.valueOf(createHelperId()));
        CLArray cLArray = new CLArray(new char[0]);
        for (LayoutReference layoutReference : layoutReferenceArr) {
            cLArray.add(CLString.from(layoutReference.getId$constraintlayout_compose_release().toString()));
        }
        LayoutReferenceImpl layoutReferenceImpl2 = layoutReferenceImpl;
        CLObject asCLContainer$constraintlayout_compose_release = asCLContainer$constraintlayout_compose_release(layoutReferenceImpl2);
        asCLContainer$constraintlayout_compose_release.putString("type", "barrier");
        asCLContainer$constraintlayout_compose_release.putString("direction", TtmlNode.RIGHT);
        asCLContainer$constraintlayout_compose_release.putNumber("margin", f);
        asCLContainer$constraintlayout_compose_release.put("contains", cLArray);
        updateHelpersHashCode(14);
        for (LayoutReference layoutReference2 : layoutReferenceArr) {
            updateHelpersHashCode(layoutReference2.hashCode());
        }
        updateHelpersHashCode(Dp.m6690hashCodeimpl(f));
        return new VerticalAnchor(layoutReferenceImpl.getId$constraintlayout_compose_release(), 0, layoutReferenceImpl2);
    }

    /* renamed from: createBottomBarrier-3ABfNKs  reason: not valid java name */
    public final HorizontalAnchor m6991createBottomBarrier3ABfNKs(LayoutReference[] layoutReferenceArr, float f) {
        LayoutReferenceImpl layoutReferenceImpl = new LayoutReferenceImpl(Integer.valueOf(createHelperId()));
        CLArray cLArray = new CLArray(new char[0]);
        for (LayoutReference layoutReference : layoutReferenceArr) {
            cLArray.add(CLString.from(layoutReference.getId$constraintlayout_compose_release().toString()));
        }
        LayoutReferenceImpl layoutReferenceImpl2 = layoutReferenceImpl;
        CLObject asCLContainer$constraintlayout_compose_release = asCLContainer$constraintlayout_compose_release(layoutReferenceImpl2);
        asCLContainer$constraintlayout_compose_release.putString("type", "barrier");
        asCLContainer$constraintlayout_compose_release.putString("direction", "bottom");
        asCLContainer$constraintlayout_compose_release.putNumber("margin", f);
        asCLContainer$constraintlayout_compose_release.put("contains", cLArray);
        updateHelpersHashCode(15);
        for (LayoutReference layoutReference2 : layoutReferenceArr) {
            updateHelpersHashCode(layoutReference2.hashCode());
        }
        updateHelpersHashCode(Dp.m6690hashCodeimpl(f));
        return new HorizontalAnchor(layoutReferenceImpl.getId$constraintlayout_compose_release(), 0, layoutReferenceImpl2);
    }

    /* renamed from: createFlow-IkjhEj4  reason: not valid java name */
    public final ConstrainedLayoutReference m6996createFlowIkjhEj4(LayoutReference[] layoutReferenceArr, boolean z, float f, float f2, int i, float f3, Wrap wrap, VerticalAlign verticalAlign, HorizontalAlign horizontalAlign, float f4, float f5, FlowStyle flowStyle, FlowStyle flowStyle2) {
        return m6995createFlowFgo90cY((LayoutReference[]) Arrays.copyOf(layoutReferenceArr, layoutReferenceArr.length), z, f, f2, i, f3, f3, f3, f3, wrap, verticalAlign, horizontalAlign, f4, f5, flowStyle, flowStyle2);
    }

    /* renamed from: createFlow-6oEtc9w  reason: not valid java name */
    public final ConstrainedLayoutReference m6994createFlow6oEtc9w(LayoutReference[] layoutReferenceArr, boolean z, float f, float f2, int i, float f3, float f4, Wrap wrap, VerticalAlign verticalAlign, HorizontalAlign horizontalAlign, float f5, float f6, FlowStyle flowStyle, FlowStyle flowStyle2) {
        return m6995createFlowFgo90cY((LayoutReference[]) Arrays.copyOf(layoutReferenceArr, layoutReferenceArr.length), z, f, f2, i, f3, f4, f3, f4, wrap, verticalAlign, horizontalAlign, f5, f6, flowStyle, flowStyle2);
    }

    /* renamed from: createFlow-Fgo90cY  reason: not valid java name */
    public final ConstrainedLayoutReference m6995createFlowFgo90cY(LayoutReference[] layoutReferenceArr, boolean z, float f, float f2, int i, float f3, float f4, float f5, float f6, Wrap wrap, VerticalAlign verticalAlign, HorizontalAlign horizontalAlign, float f7, float f8, FlowStyle flowStyle, FlowStyle flowStyle2) {
        ConstrainedLayoutReference constrainedLayoutReference = new ConstrainedLayoutReference(Integer.valueOf(createHelperId()));
        CLArray cLArray = new CLArray(new char[0]);
        for (LayoutReference layoutReference : layoutReferenceArr) {
            if (layoutReference != null) {
                cLArray.add(CLString.from(layoutReference.getId$constraintlayout_compose_release().toString()));
            }
        }
        CLArray cLArray2 = new CLArray(new char[0]);
        cLArray2.add(new CLNumber(f3));
        cLArray2.add(new CLNumber(f4));
        cLArray2.add(new CLNumber(f5));
        cLArray2.add(new CLNumber(f6));
        CLObject asCLContainer$constraintlayout_compose_release = asCLContainer$constraintlayout_compose_release(constrainedLayoutReference);
        asCLContainer$constraintlayout_compose_release.put("contains", cLArray);
        asCLContainer$constraintlayout_compose_release.putString("type", z ? "vFlow" : "hFlow");
        asCLContainer$constraintlayout_compose_release.putNumber("vGap", f);
        asCLContainer$constraintlayout_compose_release.putNumber("hGap", f2);
        asCLContainer$constraintlayout_compose_release.putNumber("maxElement", i);
        asCLContainer$constraintlayout_compose_release.put("padding", cLArray2);
        asCLContainer$constraintlayout_compose_release.putString("wrap", wrap.getName$constraintlayout_compose_release());
        asCLContainer$constraintlayout_compose_release.putString("vAlign", verticalAlign.getName$constraintlayout_compose_release());
        asCLContainer$constraintlayout_compose_release.putString("hAlign", horizontalAlign.getName$constraintlayout_compose_release());
        asCLContainer$constraintlayout_compose_release.putNumber("hFlowBias", f7);
        asCLContainer$constraintlayout_compose_release.putNumber("vFlowBias", f8);
        asCLContainer$constraintlayout_compose_release.putString("vStyle", flowStyle.getName$constraintlayout_compose_release());
        asCLContainer$constraintlayout_compose_release.putString("hStyle", flowStyle2.getName$constraintlayout_compose_release());
        updateHelpersHashCode(16);
        int length = layoutReferenceArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            LayoutReference layoutReference2 = layoutReferenceArr[i2];
            updateHelpersHashCode(layoutReference2 != null ? layoutReference2.hashCode() : 0);
        }
        return constrainedLayoutReference;
    }

    /* renamed from: createRow-lG28NQ4  reason: not valid java name */
    public final ConstrainedLayoutReference m7004createRowlG28NQ4(LayoutReference[] layoutReferenceArr, float f, float[] fArr) {
        if (!(fArr.length == 0) && layoutReferenceArr.length != fArr.length) {
            throw new IllegalArgumentException("Number of weights (" + fArr.length + ") should match number of elements (" + layoutReferenceArr.length + ").");
        }
        return m6982createGridHu23Yyw$default(this, (LayoutReference[]) Arrays.copyOf(layoutReferenceArr, layoutReferenceArr.length), 1, 0, false, 0.0f, f, null, fArr, null, null, 0, 1880, null);
    }

    /* renamed from: createColumn-lG28NQ4  reason: not valid java name */
    public final ConstrainedLayoutReference m6992createColumnlG28NQ4(LayoutReference[] layoutReferenceArr, float f, float[] fArr) {
        if (!(fArr.length == 0) && layoutReferenceArr.length != fArr.length) {
            throw new IllegalArgumentException("Number of weights (" + fArr.length + ") should match number of elements (" + layoutReferenceArr.length + ").");
        }
        return m6982createGridHu23Yyw$default(this, (LayoutReference[]) Arrays.copyOf(layoutReferenceArr, layoutReferenceArr.length), 0, 1, false, f, 0.0f, fArr, null, null, null, 0, 1960, null);
    }

    /* renamed from: createGrid-Hu23Yyw  reason: not valid java name */
    public final ConstrainedLayoutReference m6997createGridHu23Yyw(LayoutReference[] layoutReferenceArr, int i, int i2, boolean z, float f, float f2, float[] fArr, float[] fArr2, Skip[] skipArr, Span[] spanArr, int i3) {
        CLArray cLArray;
        String str;
        String str2;
        String str3;
        if (!(fArr.length == 0) && i > 0 && i != fArr.length) {
            throw new IllegalArgumentException("Number of weights (" + fArr.length + ") should match number of rows (" + i + ").");
        }
        if (!(fArr2.length == 0) && i2 > 0 && i2 != fArr2.length) {
            throw new IllegalArgumentException("Number of weights (" + fArr2.length + ") should match number of columns (" + i2 + ").");
        }
        ConstrainedLayoutReference constrainedLayoutReference = new ConstrainedLayoutReference(Integer.valueOf(createHelperId()));
        CLArray cLArray2 = new CLArray(new char[0]);
        for (LayoutReference layoutReference : layoutReferenceArr) {
            cLArray2.add(CLString.from(layoutReference.getId$constraintlayout_compose_release().toString()));
        }
        if (fArr.length > 1) {
            cLArray = cLArray2;
            str = ArraysKt.joinToString$default(fArr, (CharSequence) StringUtils.COMMA, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
        } else {
            cLArray = cLArray2;
            str = "";
        }
        if (fArr2.length > 1) {
            str2 = str;
            str3 = ArraysKt.joinToString$default(fArr2, (CharSequence) StringUtils.COMMA, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
        } else {
            str2 = str;
            str3 = "";
        }
        String joinToString$default = !(skipArr.length == 0) ? ArraysKt.joinToString$default(skipArr, StringUtils.COMMA, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1<Skip, CharSequence>() { // from class: androidx.constraintlayout.compose.ConstraintLayoutBaseScope$createGrid$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ CharSequence invoke(Skip skip) {
                return m7010invokefXgvMDs(skip.m7142unboximpl());
            }

            /* renamed from: invoke-fXgvMDs  reason: not valid java name */
            public final CharSequence m7010invokefXgvMDs(String str4) {
                return str4;
            }
        }, 30, (Object) null) : "";
        String joinToString$default2 = spanArr.length == 0 ? "" : ArraysKt.joinToString$default(spanArr, StringUtils.COMMA, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1<Span, CharSequence>() { // from class: androidx.constraintlayout.compose.ConstraintLayoutBaseScope$createGrid$3
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ CharSequence invoke(Span span) {
                return m7011invoke56oDYsA(span.m7151unboximpl());
            }

            /* renamed from: invoke-56oDYsA  reason: not valid java name */
            public final CharSequence m7011invoke56oDYsA(String str4) {
                return str4;
            }
        }, 30, (Object) null);
        CLObject asCLContainer$constraintlayout_compose_release = asCLContainer$constraintlayout_compose_release(constrainedLayoutReference);
        asCLContainer$constraintlayout_compose_release.put("contains", cLArray);
        asCLContainer$constraintlayout_compose_release.putString("type", "grid");
        asCLContainer$constraintlayout_compose_release.putNumber("orientation", z ? 0.0f : 1.0f);
        asCLContainer$constraintlayout_compose_release.putNumber("rows", i);
        asCLContainer$constraintlayout_compose_release.putNumber("columns", i2);
        asCLContainer$constraintlayout_compose_release.putNumber("vGap", f);
        asCLContainer$constraintlayout_compose_release.putNumber("hGap", f2);
        asCLContainer$constraintlayout_compose_release.putString("rowWeights", str2);
        asCLContainer$constraintlayout_compose_release.putString("columnWeights", str3);
        asCLContainer$constraintlayout_compose_release.putString("skips", joinToString$default);
        asCLContainer$constraintlayout_compose_release.putString("spans", joinToString$default2);
        asCLContainer$constraintlayout_compose_release.putNumber(DownloaderServiceMarshaller.PARAMS_FLAGS, i3);
        return constrainedLayoutReference;
    }

    public static /* synthetic */ HorizontalChainReference createHorizontalChain$default(ConstraintLayoutBaseScope constraintLayoutBaseScope, LayoutReference[] layoutReferenceArr, ChainStyle chainStyle, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                chainStyle = ChainStyle.Companion.getSpread();
            }
            return constraintLayoutBaseScope.createHorizontalChain(layoutReferenceArr, chainStyle);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createHorizontalChain");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r7v7, types: [androidx.constraintlayout.core.parser.CLArray] */
    public final HorizontalChainReference createHorizontalChain(LayoutReference[] layoutReferenceArr, ChainStyle chainStyle) {
        ?? from;
        HorizontalChainReference horizontalChainReference = new HorizontalChainReference(Integer.valueOf(createHelperId()));
        CLArray cLArray = new CLArray(new char[0]);
        for (LayoutReference layoutReference : layoutReferenceArr) {
            Object obj = layoutReference.helperParamsMap.get(Reflection.getOrCreateKotlinClass(ChainParams.class).getSimpleName());
            if (!(obj instanceof ChainParams)) {
                obj = null;
            }
            ChainParams chainParams = (ChainParams) obj;
            if (chainParams != null) {
                from = new CLArray(new char[0]);
                from.add(CLString.from(layoutReference.getId$constraintlayout_compose_release().toString()));
                from.add(new CLNumber(chainParams.getWeight()));
                from.add(new CLNumber(chainParams.m6956getStartMarginD9Ej5fM()));
                from.add(new CLNumber(chainParams.m6954getEndMarginD9Ej5fM()));
                from.add(new CLNumber(chainParams.m6955getStartGoneMarginD9Ej5fM()));
                from.add(new CLNumber(chainParams.m6953getEndGoneMarginD9Ej5fM()));
            } else {
                from = CLString.from(layoutReference.getId$constraintlayout_compose_release().toString());
            }
            cLArray.add((CLElement) from);
        }
        CLArray cLArray2 = new CLArray(new char[0]);
        cLArray2.add(CLString.from(chainStyle.getName$constraintlayout_compose_release()));
        Float bias$constraintlayout_compose_release = chainStyle.getBias$constraintlayout_compose_release();
        cLArray2.add(new CLNumber(bias$constraintlayout_compose_release != null ? bias$constraintlayout_compose_release.floatValue() : 0.5f));
        CLObject asCLContainer$constraintlayout_compose_release = asCLContainer$constraintlayout_compose_release(horizontalChainReference);
        asCLContainer$constraintlayout_compose_release.putString("type", "hChain");
        asCLContainer$constraintlayout_compose_release.put("contains", cLArray);
        asCLContainer$constraintlayout_compose_release.put("style", cLArray2);
        updateHelpersHashCode(16);
        for (LayoutReference layoutReference2 : layoutReferenceArr) {
            updateHelpersHashCode(layoutReference2.hashCode());
        }
        updateHelpersHashCode(chainStyle.hashCode());
        return horizontalChainReference;
    }

    public static /* synthetic */ VerticalChainReference createVerticalChain$default(ConstraintLayoutBaseScope constraintLayoutBaseScope, LayoutReference[] layoutReferenceArr, ChainStyle chainStyle, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                chainStyle = ChainStyle.Companion.getSpread();
            }
            return constraintLayoutBaseScope.createVerticalChain(layoutReferenceArr, chainStyle);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createVerticalChain");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r7v7, types: [androidx.constraintlayout.core.parser.CLArray] */
    public final VerticalChainReference createVerticalChain(LayoutReference[] layoutReferenceArr, ChainStyle chainStyle) {
        ?? from;
        VerticalChainReference verticalChainReference = new VerticalChainReference(Integer.valueOf(createHelperId()));
        CLArray cLArray = new CLArray(new char[0]);
        for (LayoutReference layoutReference : layoutReferenceArr) {
            Object obj = layoutReference.helperParamsMap.get(Reflection.getOrCreateKotlinClass(ChainParams.class).getSimpleName());
            if (!(obj instanceof ChainParams)) {
                obj = null;
            }
            ChainParams chainParams = (ChainParams) obj;
            if (chainParams != null) {
                from = new CLArray(new char[0]);
                from.add(CLString.from(layoutReference.getId$constraintlayout_compose_release().toString()));
                from.add(new CLNumber(chainParams.getWeight()));
                from.add(new CLNumber(chainParams.m6958getTopMarginD9Ej5fM()));
                from.add(new CLNumber(chainParams.m6952getBottomMarginD9Ej5fM()));
                from.add(new CLNumber(chainParams.m6957getTopGoneMarginD9Ej5fM()));
                from.add(new CLNumber(chainParams.m6951getBottomGoneMarginD9Ej5fM()));
            } else {
                from = CLString.from(layoutReference.getId$constraintlayout_compose_release().toString());
            }
            cLArray.add((CLElement) from);
        }
        CLArray cLArray2 = new CLArray(new char[0]);
        cLArray2.add(CLString.from(chainStyle.getName$constraintlayout_compose_release()));
        Float bias$constraintlayout_compose_release = chainStyle.getBias$constraintlayout_compose_release();
        cLArray2.add(new CLNumber(bias$constraintlayout_compose_release != null ? bias$constraintlayout_compose_release.floatValue() : 0.5f));
        CLObject asCLContainer$constraintlayout_compose_release = asCLContainer$constraintlayout_compose_release(verticalChainReference);
        asCLContainer$constraintlayout_compose_release.putString("type", "vChain");
        asCLContainer$constraintlayout_compose_release.put("contains", cLArray);
        asCLContainer$constraintlayout_compose_release.put("style", cLArray2);
        updateHelpersHashCode(17);
        for (LayoutReference layoutReference2 : layoutReferenceArr) {
            updateHelpersHashCode(layoutReference2.hashCode());
        }
        updateHelpersHashCode(chainStyle.hashCode());
        return verticalChainReference;
    }

    /* renamed from: withChainParams-ouYQatA  reason: not valid java name */
    public final LayoutReference m7007withChainParamsouYQatA(LayoutReference layoutReference, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        layoutReference.setHelperParams$constraintlayout_compose_release(new ChainParams(f, f2, f3, f4, f5, f6, f7, f8, f9, null));
        return layoutReference;
    }

    public final CLObject asCLContainer$constraintlayout_compose_release(LayoutReference layoutReference) {
        String obj = layoutReference.getId$constraintlayout_compose_release().toString();
        if (this.containerObject.getObjectOrNull(obj) == null) {
            this.containerObject.put(obj, new CLObject(new char[0]));
        }
        return this.containerObject.getObject(obj);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ConstraintLayoutBaseScope) {
            return Intrinsics.areEqual(this.containerObject, ((ConstraintLayoutBaseScope) obj).containerObject);
        }
        return false;
    }

    public int hashCode() {
        return this.containerObject.hashCode();
    }

    public final void constrain(ConstrainedLayoutReference[] constrainedLayoutReferenceArr, Function1<? super ConstrainScope, Unit> function1) {
        for (ConstrainedLayoutReference constrainedLayoutReference : constrainedLayoutReferenceArr) {
            constrain(constrainedLayoutReference, function1);
        }
    }

    /* renamed from: createStartBarrier-3ABfNKs$default  reason: not valid java name */
    public static /* synthetic */ VerticalAnchor m6984createStartBarrier3ABfNKs$default(ConstraintLayoutBaseScope constraintLayoutBaseScope, LayoutReference[] layoutReferenceArr, float f, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                f = Dp.m6684constructorimpl(0);
            }
            return constraintLayoutBaseScope.m7005createStartBarrier3ABfNKs(layoutReferenceArr, f);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createStartBarrier-3ABfNKs");
    }

    /* renamed from: createAbsoluteLeftBarrier-3ABfNKs$default  reason: not valid java name */
    public static /* synthetic */ VerticalAnchor m6974createAbsoluteLeftBarrier3ABfNKs$default(ConstraintLayoutBaseScope constraintLayoutBaseScope, LayoutReference[] layoutReferenceArr, float f, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                f = Dp.m6684constructorimpl(0);
            }
            return constraintLayoutBaseScope.m6989createAbsoluteLeftBarrier3ABfNKs(layoutReferenceArr, f);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createAbsoluteLeftBarrier-3ABfNKs");
    }

    /* renamed from: createTopBarrier-3ABfNKs$default  reason: not valid java name */
    public static /* synthetic */ HorizontalAnchor m6985createTopBarrier3ABfNKs$default(ConstraintLayoutBaseScope constraintLayoutBaseScope, LayoutReference[] layoutReferenceArr, float f, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                f = Dp.m6684constructorimpl(0);
            }
            return constraintLayoutBaseScope.m7006createTopBarrier3ABfNKs(layoutReferenceArr, f);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createTopBarrier-3ABfNKs");
    }

    /* renamed from: createEndBarrier-3ABfNKs$default  reason: not valid java name */
    public static /* synthetic */ VerticalAnchor m6978createEndBarrier3ABfNKs$default(ConstraintLayoutBaseScope constraintLayoutBaseScope, LayoutReference[] layoutReferenceArr, float f, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                f = Dp.m6684constructorimpl(0);
            }
            return constraintLayoutBaseScope.m6993createEndBarrier3ABfNKs(layoutReferenceArr, f);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createEndBarrier-3ABfNKs");
    }

    /* renamed from: createAbsoluteRightBarrier-3ABfNKs$default  reason: not valid java name */
    public static /* synthetic */ VerticalAnchor m6975createAbsoluteRightBarrier3ABfNKs$default(ConstraintLayoutBaseScope constraintLayoutBaseScope, LayoutReference[] layoutReferenceArr, float f, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                f = Dp.m6684constructorimpl(0);
            }
            return constraintLayoutBaseScope.m6990createAbsoluteRightBarrier3ABfNKs(layoutReferenceArr, f);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createAbsoluteRightBarrier-3ABfNKs");
    }

    /* renamed from: createBottomBarrier-3ABfNKs$default  reason: not valid java name */
    public static /* synthetic */ HorizontalAnchor m6976createBottomBarrier3ABfNKs$default(ConstraintLayoutBaseScope constraintLayoutBaseScope, LayoutReference[] layoutReferenceArr, float f, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                f = Dp.m6684constructorimpl(0);
            }
            return constraintLayoutBaseScope.m6991createBottomBarrier3ABfNKs(layoutReferenceArr, f);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createBottomBarrier-3ABfNKs");
    }

    /* renamed from: createFlow-IkjhEj4$default  reason: not valid java name */
    public static /* synthetic */ ConstrainedLayoutReference m6981createFlowIkjhEj4$default(ConstraintLayoutBaseScope constraintLayoutBaseScope, LayoutReference[] layoutReferenceArr, boolean z, float f, float f2, int i, float f3, Wrap wrap, VerticalAlign verticalAlign, HorizontalAlign horizontalAlign, float f4, float f5, FlowStyle flowStyle, FlowStyle flowStyle2, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                z = false;
            }
            if ((i2 & 4) != 0) {
                f = Dp.m6684constructorimpl(0);
            }
            return constraintLayoutBaseScope.m6996createFlowIkjhEj4(layoutReferenceArr, z, f, (i2 & 8) != 0 ? Dp.m6684constructorimpl(0) : f2, (i2 & 16) != 0 ? 0 : i, (i2 & 32) != 0 ? Dp.m6684constructorimpl(0) : f3, (i2 & 64) != 0 ? Wrap.Companion.getNone() : wrap, (i2 & 128) != 0 ? VerticalAlign.Companion.getCenter() : verticalAlign, (i2 & 256) != 0 ? HorizontalAlign.Companion.getCenter() : horizontalAlign, (i2 & 512) != 0 ? 0.0f : f4, (i2 & 1024) == 0 ? f5 : 0.0f, (i2 & 2048) != 0 ? FlowStyle.Companion.getPacked() : flowStyle, (i2 & 4096) != 0 ? FlowStyle.Companion.getPacked() : flowStyle2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createFlow-IkjhEj4");
    }

    /* renamed from: createFlow-6oEtc9w$default  reason: not valid java name */
    public static /* synthetic */ ConstrainedLayoutReference m6979createFlow6oEtc9w$default(ConstraintLayoutBaseScope constraintLayoutBaseScope, LayoutReference[] layoutReferenceArr, boolean z, float f, float f2, int i, float f3, float f4, Wrap wrap, VerticalAlign verticalAlign, HorizontalAlign horizontalAlign, float f5, float f6, FlowStyle flowStyle, FlowStyle flowStyle2, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                z = false;
            }
            return constraintLayoutBaseScope.m6994createFlow6oEtc9w(layoutReferenceArr, z, (i2 & 4) != 0 ? Dp.m6684constructorimpl(0) : f, (i2 & 8) != 0 ? Dp.m6684constructorimpl(0) : f2, (i2 & 16) != 0 ? 0 : i, (i2 & 32) != 0 ? Dp.m6684constructorimpl(0) : f3, (i2 & 64) != 0 ? Dp.m6684constructorimpl(0) : f4, (i2 & 128) != 0 ? Wrap.Companion.getNone() : wrap, (i2 & 256) != 0 ? VerticalAlign.Companion.getCenter() : verticalAlign, (i2 & 512) != 0 ? HorizontalAlign.Companion.getCenter() : horizontalAlign, (i2 & 1024) != 0 ? 0.0f : f5, (i2 & 2048) == 0 ? f6 : 0.0f, (i2 & 4096) != 0 ? FlowStyle.Companion.getPacked() : flowStyle, (i2 & 8192) != 0 ? FlowStyle.Companion.getPacked() : flowStyle2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createFlow-6oEtc9w");
    }

    /* renamed from: createFlow-Fgo90cY$default  reason: not valid java name */
    public static /* synthetic */ ConstrainedLayoutReference m6980createFlowFgo90cY$default(ConstraintLayoutBaseScope constraintLayoutBaseScope, LayoutReference[] layoutReferenceArr, boolean z, float f, float f2, int i, float f3, float f4, float f5, float f6, Wrap wrap, VerticalAlign verticalAlign, HorizontalAlign horizontalAlign, float f7, float f8, FlowStyle flowStyle, FlowStyle flowStyle2, int i2, Object obj) {
        if (obj == null) {
            return constraintLayoutBaseScope.m6995createFlowFgo90cY(layoutReferenceArr, (i2 & 2) != 0 ? false : z, (i2 & 4) != 0 ? Dp.m6684constructorimpl(0) : f, (i2 & 8) != 0 ? Dp.m6684constructorimpl(0) : f2, (i2 & 16) != 0 ? 0 : i, (i2 & 32) != 0 ? Dp.m6684constructorimpl(0) : f3, (i2 & 64) != 0 ? Dp.m6684constructorimpl(0) : f4, (i2 & 128) != 0 ? Dp.m6684constructorimpl(0) : f5, (i2 & 256) != 0 ? Dp.m6684constructorimpl(0) : f6, (i2 & 512) != 0 ? Wrap.Companion.getNone() : wrap, (i2 & 1024) != 0 ? VerticalAlign.Companion.getCenter() : verticalAlign, (i2 & 2048) != 0 ? HorizontalAlign.Companion.getCenter() : horizontalAlign, (i2 & 4096) != 0 ? 0.0f : f7, (i2 & 8192) == 0 ? f8 : 0.0f, (i2 & 16384) != 0 ? FlowStyle.Companion.getPacked() : flowStyle, (i2 & 32768) != 0 ? FlowStyle.Companion.getPacked() : flowStyle2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createFlow-Fgo90cY");
    }

    /* renamed from: createRow-lG28NQ4$default  reason: not valid java name */
    public static /* synthetic */ ConstrainedLayoutReference m6983createRowlG28NQ4$default(ConstraintLayoutBaseScope constraintLayoutBaseScope, LayoutReference[] layoutReferenceArr, float f, float[] fArr, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                f = Dp.m6684constructorimpl(0);
            }
            if ((i & 4) != 0) {
                fArr = new float[0];
            }
            return constraintLayoutBaseScope.m7004createRowlG28NQ4(layoutReferenceArr, f, fArr);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createRow-lG28NQ4");
    }

    /* renamed from: createColumn-lG28NQ4$default  reason: not valid java name */
    public static /* synthetic */ ConstrainedLayoutReference m6977createColumnlG28NQ4$default(ConstraintLayoutBaseScope constraintLayoutBaseScope, LayoutReference[] layoutReferenceArr, float f, float[] fArr, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                f = Dp.m6684constructorimpl(0);
            }
            if ((i & 4) != 0) {
                fArr = new float[0];
            }
            return constraintLayoutBaseScope.m6992createColumnlG28NQ4(layoutReferenceArr, f, fArr);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createColumn-lG28NQ4");
    }

    /* renamed from: createGrid-Hu23Yyw$default  reason: not valid java name */
    public static /* synthetic */ ConstrainedLayoutReference m6982createGridHu23Yyw$default(ConstraintLayoutBaseScope constraintLayoutBaseScope, LayoutReference[] layoutReferenceArr, int i, int i2, boolean z, float f, float f2, float[] fArr, float[] fArr2, Skip[] skipArr, Span[] spanArr, int i3, int i4, Object obj) {
        if (obj == null) {
            return constraintLayoutBaseScope.m6997createGridHu23Yyw(layoutReferenceArr, i, i2, (i4 & 8) != 0 ? true : z, (i4 & 16) != 0 ? Dp.m6684constructorimpl(0) : f, (i4 & 32) != 0 ? Dp.m6684constructorimpl(0) : f2, (i4 & 64) != 0 ? new float[0] : fArr, (i4 & 128) != 0 ? new float[0] : fArr2, (i4 & 256) != 0 ? new Skip[0] : skipArr, (i4 & 512) != 0 ? new Span[0] : spanArr, (i4 & 1024) != 0 ? GridFlag.Companion.m7056getNonedTRCCdc() : i3);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createGrid-Hu23Yyw");
    }

    /* renamed from: withChainParams-ouYQatA$default  reason: not valid java name */
    public static /* synthetic */ LayoutReference m6986withChainParamsouYQatA$default(ConstraintLayoutBaseScope constraintLayoutBaseScope, LayoutReference layoutReference, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, int i, Object obj) {
        if (obj == null) {
            return constraintLayoutBaseScope.m7007withChainParamsouYQatA(layoutReference, (i & 1) != 0 ? Dp.m6684constructorimpl(0) : f, (i & 2) != 0 ? Dp.m6684constructorimpl(0) : f2, (i & 4) != 0 ? Dp.m6684constructorimpl(0) : f3, (i & 8) != 0 ? Dp.m6684constructorimpl(0) : f4, (i & 16) != 0 ? Dp.m6684constructorimpl(0) : f5, (i & 32) != 0 ? Dp.m6684constructorimpl(0) : f6, (i & 64) != 0 ? Dp.m6684constructorimpl(0) : f7, (i & 128) != 0 ? Dp.m6684constructorimpl(0) : f8, (i & 256) != 0 ? Float.NaN : f9);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: withChainParams-ouYQatA");
    }

    /* renamed from: withHorizontalChainParams-YLPp7PM  reason: not valid java name */
    public final LayoutReference m7008withHorizontalChainParamsYLPp7PM(LayoutReference layoutReference, float f, float f2, float f3, float f4, float f5) {
        float f6 = 0;
        return m7007withChainParamsouYQatA(layoutReference, f, Dp.m6684constructorimpl(f6), f2, Dp.m6684constructorimpl(f6), f3, Dp.m6684constructorimpl(f6), f4, Dp.m6684constructorimpl(f6), f5);
    }

    /* renamed from: withHorizontalChainParams-YLPp7PM$default  reason: not valid java name */
    public static /* synthetic */ LayoutReference m6987withHorizontalChainParamsYLPp7PM$default(ConstraintLayoutBaseScope constraintLayoutBaseScope, LayoutReference layoutReference, float f, float f2, float f3, float f4, float f5, int i, Object obj) {
        if (obj == null) {
            return constraintLayoutBaseScope.m7008withHorizontalChainParamsYLPp7PM(layoutReference, (i & 1) != 0 ? Dp.m6684constructorimpl(0) : f, (i & 2) != 0 ? Dp.m6684constructorimpl(0) : f2, (i & 4) != 0 ? Dp.m6684constructorimpl(0) : f3, (i & 8) != 0 ? Dp.m6684constructorimpl(0) : f4, (i & 16) != 0 ? Float.NaN : f5);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: withHorizontalChainParams-YLPp7PM");
    }

    /* renamed from: withVerticalChainParams-YLPp7PM  reason: not valid java name */
    public final LayoutReference m7009withVerticalChainParamsYLPp7PM(LayoutReference layoutReference, float f, float f2, float f3, float f4, float f5) {
        float f6 = 0;
        return m7007withChainParamsouYQatA(layoutReference, Dp.m6684constructorimpl(f6), f, Dp.m6684constructorimpl(f6), f2, Dp.m6684constructorimpl(f6), f3, Dp.m6684constructorimpl(f6), f4, f5);
    }

    /* renamed from: withVerticalChainParams-YLPp7PM$default  reason: not valid java name */
    public static /* synthetic */ LayoutReference m6988withVerticalChainParamsYLPp7PM$default(ConstraintLayoutBaseScope constraintLayoutBaseScope, LayoutReference layoutReference, float f, float f2, float f3, float f4, float f5, int i, Object obj) {
        if (obj == null) {
            return constraintLayoutBaseScope.m7009withVerticalChainParamsYLPp7PM(layoutReference, (i & 1) != 0 ? Dp.m6684constructorimpl(0) : f, (i & 2) != 0 ? Dp.m6684constructorimpl(0) : f2, (i & 4) != 0 ? Dp.m6684constructorimpl(0) : f3, (i & 8) != 0 ? Dp.m6684constructorimpl(0) : f4, (i & 16) != 0 ? Float.NaN : f5);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: withVerticalChainParams-YLPp7PM");
    }
}
