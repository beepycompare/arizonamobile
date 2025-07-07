package androidx.compose.ui.node;

import androidx.collection.MutableLongList;
import androidx.collection.MutableObjectIntMap;
import androidx.collection.ObjectIntMapKt;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.MutableRect;
import androidx.compose.ui.geometry.MutableRectKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Matrix;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.ReusableGraphicsLayerScope;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.input.pointer.MatrixPositionCalculator;
import androidx.compose.ui.input.pointer.PointerType;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.LookaheadLayoutCoordinates;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.extractor.text.ttml.TtmlNode;
import io.appmetrica.analytics.modulesapi.internal.client.adrevenue.AdRevenueConstants;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
/* compiled from: NodeCoordinator.kt */
@Metadata(d1 = {"\u0000¨\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b-\b \u0018\u0000 ¼\u00022\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0004¼\u0002½\u0002B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J$\u0010\u0097\u0001\u001a\u00020\f2\u0007\u0010\u0098\u0001\u001a\u00020\u00002\u0007\u0010\u0099\u0001\u001a\u00020\u00102\u0007\u0010\u009a\u0001\u001a\u00020(H\u0002J2\u0010\u0097\u0001\u001a\u00030\u009b\u00012\u0007\u0010\u0098\u0001\u001a\u00020\u00002\b\u0010\u009c\u0001\u001a\u00030\u009b\u00012\u0007\u0010\u009d\u0001\u001a\u00020(H\u0002ø\u0001\u0000¢\u0006\u0006\b\u009e\u0001\u0010\u009f\u0001J\u001d\u0010 \u0001\u001a\u00020c2\u0006\u0010b\u001a\u00020cH\u0004ø\u0001\u0000¢\u0006\u0006\b¡\u0001\u0010¢\u0001J'\u0010£\u0001\u001a\u00020\u001c2\b\u0010¤\u0001\u001a\u00030\u009b\u00012\u0006\u0010b\u001a\u00020cH\u0004ø\u0001\u0000¢\u0006\u0006\b¥\u0001\u0010¦\u0001J\u001b\u0010§\u0001\u001a\u00020\f2\u0007\u0010¨\u0001\u001a\u00020\n2\t\u0010©\u0001\u001a\u0004\u0018\u00010\u000bJ\u001c\u0010ª\u0001\u001a\u00020\f2\u0007\u0010¨\u0001\u001a\u00020\n2\b\u0010«\u0001\u001a\u00030¬\u0001H\u0004J\u001d\u0010\u00ad\u0001\u001a\u00020\f2\u0007\u0010¨\u0001\u001a\u00020\n2\t\u0010©\u0001\u001a\u0004\u0018\u00010\u000bH\u0002J\t\u0010®\u0001\u001a\u00020\fH&J\u0018\u0010¯\u0001\u001a\u00020\u00002\u0007\u0010°\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0003\b±\u0001J*\u0010²\u0001\u001a\u00030\u009b\u00012\u0007\u0010s\u001a\u00030\u009b\u00012\t\b\u0002\u0010\u009d\u0001\u001a\u00020(H\u0016ø\u0001\u0000¢\u0006\u0006\b³\u0001\u0010´\u0001J\u001b\u0010µ\u0001\u001a\u00020\f2\u0007\u0010¶\u0001\u001a\u00020\u00102\u0007\u0010\u009a\u0001\u001a\u00020(H\u0002J#\u0010·\u0001\u001a\u00020(2\f\u0010¸\u0001\u001a\u0007\u0012\u0002\b\u00030¹\u0001H\u0002ø\u0001\u0000¢\u0006\u0006\bº\u0001\u0010»\u0001J$\u0010¼\u0001\u001a\u0005\u0018\u00010\u0088\u00012\f\u0010¸\u0001\u001a\u0007\u0012\u0002\b\u00030¹\u0001ø\u0001\u0000¢\u0006\u0006\b½\u0001\u0010¾\u0001J\u0015\u0010¿\u0001\u001a\u0005\u0018\u00010\u0088\u00012\u0007\u0010À\u0001\u001a\u00020(H\u0002JD\u0010Á\u0001\u001a\u00020\f2\b\u0010Â\u0001\u001a\u00030Ã\u00012\b\u0010¤\u0001\u001a\u00030\u009b\u00012\b\u0010Ä\u0001\u001a\u00030Å\u00012\b\u0010Æ\u0001\u001a\u00030Ç\u00012\u0007\u0010È\u0001\u001a\u00020(ø\u0001\u0000¢\u0006\u0006\bÉ\u0001\u0010Ê\u0001JF\u0010Ë\u0001\u001a\u00020\f2\b\u0010Â\u0001\u001a\u00030Ã\u00012\b\u0010¤\u0001\u001a\u00030\u009b\u00012\b\u0010Ä\u0001\u001a\u00030Å\u00012\b\u0010Æ\u0001\u001a\u00030Ç\u00012\u0007\u0010È\u0001\u001a\u00020(H\u0016ø\u0001\u0000¢\u0006\u0006\bÌ\u0001\u0010Ê\u0001J\t\u0010Í\u0001\u001a\u00020\fH\u0016J\u001f\u0010Î\u0001\u001a\u00020(2\b\u0010¤\u0001\u001a\u00030\u009b\u0001H\u0004ø\u0001\u0000¢\u0006\u0006\bÏ\u0001\u0010Ð\u0001J\u0007\u0010Ñ\u0001\u001a\u00020(J\u001c\u0010Ò\u0001\u001a\u00030Ó\u00012\u0007\u0010Ô\u0001\u001a\u00020\u00032\u0007\u0010\u009a\u0001\u001a\u00020(H\u0016J)\u0010Õ\u0001\u001a\u00030\u009b\u00012\u0007\u0010Ô\u0001\u001a\u00020\u00032\b\u0010Ö\u0001\u001a\u00030\u009b\u0001H\u0016ø\u0001\u0000¢\u0006\u0006\b×\u0001\u0010Ø\u0001J2\u0010Õ\u0001\u001a\u00030\u009b\u00012\u0007\u0010Ô\u0001\u001a\u00020\u00032\b\u0010Ö\u0001\u001a\u00030\u009b\u00012\u0007\u0010\u009d\u0001\u001a\u00020(H\u0016ø\u0001\u0000¢\u0006\u0006\bÙ\u0001\u0010Ú\u0001J \u0010Û\u0001\u001a\u00030\u009b\u00012\b\u0010Ü\u0001\u001a\u00030\u009b\u0001H\u0016ø\u0001\u0000¢\u0006\u0006\bÝ\u0001\u0010¢\u0001J \u0010Þ\u0001\u001a\u00030\u009b\u00012\b\u0010Ü\u0001\u001a\u00030\u009b\u0001H\u0016ø\u0001\u0000¢\u0006\u0006\bß\u0001\u0010¢\u0001J \u0010à\u0001\u001a\u00030\u009b\u00012\b\u0010Ü\u0001\u001a\u00030\u009b\u0001H\u0016ø\u0001\u0000¢\u0006\u0006\bá\u0001\u0010¢\u0001J \u0010â\u0001\u001a\u00030\u009b\u00012\b\u0010¤\u0001\u001a\u00030\u009b\u0001H\u0002ø\u0001\u0000¢\u0006\u0006\bã\u0001\u0010¢\u0001J\u0007\u0010ä\u0001\u001a\u00020\fJ\u000f\u0010å\u0001\u001a\u00020\fH\u0000¢\u0006\u0003\bæ\u0001J\u0007\u0010ç\u0001\u001a\u00020\fJ\t\u0010è\u0001\u001a\u00020\fH\u0016J\u0007\u0010é\u0001\u001a\u00020\fJ\u001d\u0010ê\u0001\u001a\u00020\f2\b\u0010ë\u0001\u001a\u00030ì\u00012\b\u0010í\u0001\u001a\u00030ì\u0001H\u0014J\u0007\u0010î\u0001\u001a\u00020\fJ\u0007\u0010ï\u0001\u001a\u00020\fJ\u0007\u0010ð\u0001\u001a\u00020\fJ\u0007\u0010ñ\u0001\u001a\u00020\fJ\u001d\u0010ò\u0001\u001a\u00020\f2\u0007\u0010¨\u0001\u001a\u00020\n2\t\u0010©\u0001\u001a\u0004\u0018\u00010\u000bH\u0016J2\u0010ó\u0001\u001a\u00030ô\u00012\u0007\u0010õ\u0001\u001a\u00020>2\u0010\b\u0004\u0010ö\u0001\u001a\t\u0012\u0005\u0012\u00030ô\u000105H\u0084\bø\u0001\u0000¢\u0006\u0006\b÷\u0001\u0010ø\u0001JA\u0010ù\u0001\u001a\u00020\f2\u0006\u0010s\u001a\u00020r2\u0007\u0010\u0093\u0001\u001a\u00020\u001c2\u0019\u0010H\u001a\u0015\u0012\u0004\u0012\u00020F\u0012\u0004\u0012\u00020\f\u0018\u00010E¢\u0006\u0002\bGH\u0014ø\u0001\u0000¢\u0006\u0006\bú\u0001\u0010û\u0001J.\u0010ù\u0001\u001a\u00020\f2\u0006\u0010s\u001a\u00020r2\u0007\u0010\u0093\u0001\u001a\u00020\u001c2\u0006\u0010B\u001a\u00020\u000bH\u0014ø\u0001\u0000¢\u0006\u0006\bú\u0001\u0010ü\u0001JK\u0010ý\u0001\u001a\u00020\f2\u0006\u0010s\u001a\u00020r2\u0007\u0010\u0093\u0001\u001a\u00020\u001c2\u0019\u0010H\u001a\u0015\u0012\u0004\u0012\u00020F\u0012\u0004\u0012\u00020\f\u0018\u00010E¢\u0006\u0002\bG2\b\u0010$\u001a\u0004\u0018\u00010\u000bH\u0002ø\u0001\u0000¢\u0006\u0006\bþ\u0001\u0010ÿ\u0001JI\u0010\u0080\u0002\u001a\u00020\f2\u0006\u0010s\u001a\u00020r2\u0007\u0010\u0093\u0001\u001a\u00020\u001c2\u0019\u0010H\u001a\u0015\u0012\u0004\u0012\u00020F\u0012\u0004\u0012\u00020\f\u0018\u00010E¢\u0006\u0002\bG2\b\u0010B\u001a\u0004\u0018\u00010\u000bø\u0001\u0000¢\u0006\u0006\b\u0081\u0002\u0010ÿ\u0001J,\u0010\u0082\u0002\u001a\u00020\f2\u0007\u0010¶\u0001\u001a\u00020\u00102\u0007\u0010\u009a\u0001\u001a\u00020(2\t\b\u0002\u0010\u0083\u0002\u001a\u00020(H\u0000¢\u0006\u0003\b\u0084\u0002J\u0007\u0010\u0085\u0002\u001a\u00020\fJ\u000f\u0010\u0086\u0002\u001a\u00020\fH\u0010¢\u0006\u0003\b\u0087\u0002J \u0010\u0088\u0002\u001a\u00030\u009b\u00012\b\u0010\u0089\u0002\u001a\u00030\u009b\u0001H\u0016ø\u0001\u0000¢\u0006\u0006\b\u008a\u0002\u0010¢\u0001J\u0007\u0010\u008b\u0002\u001a\u00020(J*\u0010\u008c\u0002\u001a\u00030\u009b\u00012\u0007\u0010s\u001a\u00030\u009b\u00012\t\b\u0002\u0010\u009d\u0001\u001a\u00020(H\u0016ø\u0001\u0000¢\u0006\u0006\b\u008d\u0002\u0010´\u0001J\b\u0010\u008e\u0002\u001a\u00030Ó\u0001J(\u0010\u008f\u0002\u001a\u00020\f2\u0007\u0010Ô\u0001\u001a\u00020\u00032\b\u0010\u0090\u0002\u001a\u00030\u0091\u0002H\u0016ø\u0001\u0000¢\u0006\u0006\b\u0092\u0002\u0010\u0093\u0002J(\u0010\u0094\u0002\u001a\u00020\f2\u0007\u0010\u0098\u0001\u001a\u00020\u00002\b\u0010\u0090\u0002\u001a\u00030\u0091\u0002H\u0002ø\u0001\u0000¢\u0006\u0006\b\u0095\u0002\u0010\u0096\u0002J(\u0010\u0097\u0002\u001a\u00020\f2\u0007\u0010\u0098\u0001\u001a\u00020\u00002\b\u0010\u0090\u0002\u001a\u00030\u0091\u0002H\u0002ø\u0001\u0000¢\u0006\u0006\b\u0098\u0002\u0010\u0096\u0002J\u001f\u0010\u0099\u0002\u001a\u00020\f2\b\u0010\u0090\u0002\u001a\u00030\u0091\u0002H\u0016ø\u0001\u0000¢\u0006\u0006\b\u009a\u0002\u0010\u009b\u0002J-\u0010\u009c\u0002\u001a\u00020\f2\u0019\u0010H\u001a\u0015\u0012\u0004\u0012\u00020F\u0012\u0004\u0012\u00020\f\u0018\u00010E¢\u0006\u0002\bG2\t\b\u0002\u0010\u009d\u0002\u001a\u00020(J\u0014\u0010\u009e\u0002\u001a\u00020(2\t\b\u0002\u0010\u009f\u0002\u001a\u00020(H\u0002JF\u0010 \u0002\u001a\u00020\f\"\u0007\b\u0000\u0010¡\u0002\u0018\u00012\u000f\u0010¸\u0001\u001a\n\u0012\u0005\u0012\u0003H¡\u00020¹\u00012\u0014\u0010ö\u0001\u001a\u000f\u0012\u0005\u0012\u0003H¡\u0002\u0012\u0004\u0012\u00020\f0EH\u0086\bø\u0001\u0000¢\u0006\u0006\b¢\u0002\u0010£\u0002J3\u0010 \u0002\u001a\u00020\f2\b\u0010¤\u0002\u001a\u00030ì\u00012\u0007\u0010À\u0001\u001a\u00020(2\u0014\u0010ö\u0001\u001a\u000f\u0012\u0005\u0012\u00030\u0088\u0001\u0012\u0004\u0012\u00020\f0EH\u0086\bJ \u0010¥\u0002\u001a\u00030\u009b\u00012\b\u0010¦\u0002\u001a\u00030\u009b\u0001H\u0016ø\u0001\u0000¢\u0006\u0006\b§\u0002\u0010¢\u0001J(\u0010¨\u0002\u001a\u00020\f2\u0007\u0010¨\u0001\u001a\u00020\n2\u0013\u0010ö\u0001\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\f0EH\u0084\bJ\u001f\u0010©\u0002\u001a\u00020(2\b\u0010¤\u0001\u001a\u00030\u009b\u0001H\u0004ø\u0001\u0000¢\u0006\u0006\bª\u0002\u0010Ð\u0001JM\u0010«\u0002\u001a\u00020\f*\u0005\u0018\u00010\u0088\u00012\b\u0010Â\u0001\u001a\u00030Ã\u00012\b\u0010¤\u0001\u001a\u00030\u009b\u00012\b\u0010Ä\u0001\u001a\u00030Å\u00012\b\u0010Æ\u0001\u001a\u00030Ç\u00012\u0007\u0010È\u0001\u001a\u00020(H\u0002ø\u0001\u0000¢\u0006\u0006\b¬\u0002\u0010\u00ad\u0002JV\u0010®\u0002\u001a\u00020\f*\u0005\u0018\u00010\u0088\u00012\b\u0010Â\u0001\u001a\u00030Ã\u00012\b\u0010¤\u0001\u001a\u00030\u009b\u00012\b\u0010Ä\u0001\u001a\u00030Å\u00012\b\u0010Æ\u0001\u001a\u00030Ç\u00012\u0007\u0010È\u0001\u001a\u00020(2\u0007\u0010¯\u0002\u001a\u00020\u001cH\u0002ø\u0001\u0000¢\u0006\u0006\b°\u0002\u0010±\u0002J0\u0010²\u0002\u001a\u00020(*\u0005\u0018\u00010\u0088\u00012\b\u0010¤\u0001\u001a\u00030\u009b\u00012\b\u0010Æ\u0001\u001a\u00030Ç\u0001H\u0002ø\u0001\u0000¢\u0006\u0006\b³\u0002\u0010´\u0002J_\u0010µ\u0002\u001a\u00020\f*\u0005\u0018\u00010\u0088\u00012\b\u0010Â\u0001\u001a\u00030Ã\u00012\b\u0010¤\u0001\u001a\u00030\u009b\u00012\b\u0010Ä\u0001\u001a\u00030Å\u00012\b\u0010Æ\u0001\u001a\u00030Ç\u00012\u0007\u0010È\u0001\u001a\u00020(2\u0007\u0010¯\u0002\u001a\u00020\u001c2\u0007\u0010¶\u0002\u001a\u00020(H\u0002ø\u0001\u0000¢\u0006\u0006\b·\u0002\u0010¸\u0002JV\u0010¹\u0002\u001a\u00020\f*\u0005\u0018\u00010\u0088\u00012\b\u0010Â\u0001\u001a\u00030Ã\u00012\b\u0010¤\u0001\u001a\u00030\u009b\u00012\b\u0010Ä\u0001\u001a\u00030Å\u00012\b\u0010Æ\u0001\u001a\u00030Ç\u00012\u0007\u0010È\u0001\u001a\u00020(2\u0007\u0010¯\u0002\u001a\u00020\u001cH\u0002ø\u0001\u0000¢\u0006\u0006\bº\u0002\u0010±\u0002J\r\u0010»\u0002\u001a\u00020\u0000*\u00020\u0003H\u0002R$\u0010\b\u001a\u0018\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u00018VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u001c8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR(\u0010\u001f\u001a\u0016\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0004\u0012\u00020\f0\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b \u0010!R\u0010\u0010\"\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010%\u001a\u00020\u001c8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b&\u0010\u001eR\u001a\u0010'\u001a\u00020(X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001a\u0010-\u001a\u00020(X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010*\"\u0004\b/\u0010,R\u0014\u00100\u001a\u00020(8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b1\u0010*R\u0014\u00102\u001a\u00020(8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b3\u0010*R\u0014\u00104\u001a\b\u0012\u0004\u0012\u00020\f05X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00106\u001a\u00020(8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b6\u0010*R\u000e\u00107\u001a\u00020(X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u00108\u001a\u00020(8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b8\u0010*R\u000e\u00109\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010;\u001a\u00020(2\u0006\u0010:\u001a\u00020(@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b<\u0010*R\u001a\u0010=\u001a\u00020>8@X\u0080\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b?\u0010@R\"\u0010B\u001a\u0004\u0018\u00010A2\b\u0010:\u001a\u0004\u0018\u00010A@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bC\u0010DRD\u0010H\u001a\u0015\u0012\u0004\u0012\u00020F\u0012\u0004\u0012\u00020\f\u0018\u00010E¢\u0006\u0002\bG2\u0019\u0010:\u001a\u0015\u0012\u0004\u0012\u00020F\u0012\u0004\u0012\u00020\f\u0018\u00010E¢\u0006\u0002\bG@BX\u0084\u000e¢\u0006\b\n\u0000\u001a\u0004\bI\u0010JR\u000e\u0010K\u001a\u00020LX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010M\u001a\u00020NX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010O\u001a\u0004\u0018\u00010PX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010Q\u001a\u00020N8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bR\u0010SR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bT\u0010UR&\u0010W\u001a\u0004\u0018\u00010V2\b\u0010:\u001a\u0004\u0018\u00010V@dX¦\u000e¢\u0006\f\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[R$\u0010]\u001a\u00020\u000e2\u0006\u0010\\\u001a\u00020\u000e8P@PX\u0090\u000e¢\u0006\f\u001a\u0004\b^\u0010_\"\u0004\b`\u0010aR\u0017\u0010b\u001a\u00020c8Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\bd\u0010@R\u0016\u0010e\u001a\n\u0012\u0004\u0012\u00020g\u0018\u00010fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010h\u001a\u0004\u0018\u00010\u00018VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bi\u0010\u0017R\u0013\u0010j\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\bk\u0010\u001aR\u0016\u0010l\u001a\u0004\u0018\u00010m8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bn\u0010oR\u0013\u0010p\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\bq\u0010\u001aR,\u0010s\u001a\u00020r2\u0006\u0010:\u001a\u00020r@TX\u0096\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010w\u001a\u0004\bt\u0010@\"\u0004\bu\u0010vR\u001a\u0010x\u001a\b\u0012\u0004\u0012\u00020g0y8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bz\u0010{R\u0014\u0010|\u001a\u00020\u00108DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b}\u0010~R\u000e\u0010\u007f\u001a\u00020(X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0080\u0001\u001a\u00030\u0081\u00018Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0007\u001a\u0005\b\u0082\u0001\u0010@R\u0018\u0010\u0083\u0001\u001a\u00030\u0084\u00018BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u0085\u0001\u0010\u0086\u0001R\u0016\u0010\u0087\u0001\u001a\u00030\u0088\u0001X¦\u0004¢\u0006\b\u001a\u0006\b\u0089\u0001\u0010\u008a\u0001R!\u0010\u008b\u0001\u001a\u0004\u0018\u00010\u0000X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u008c\u0001\u0010\u008d\u0001\"\u0006\b\u008e\u0001\u0010\u008f\u0001R!\u0010\u0090\u0001\u001a\u0004\u0018\u00010\u0000X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0091\u0001\u0010\u008d\u0001\"\u0006\b\u0092\u0001\u0010\u008f\u0001R(\u0010\u0093\u0001\u001a\u00020\u001c2\u0006\u0010:\u001a\u00020\u001c@DX\u0086\u000e¢\u0006\u0011\n\u0000\u001a\u0005\b\u0094\u0001\u0010\u001e\"\u0006\b\u0095\u0001\u0010\u0096\u0001\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006¾\u0002"}, d2 = {"Landroidx/compose/ui/node/NodeCoordinator;", "Landroidx/compose/ui/node/LookaheadCapablePlaceable;", "Landroidx/compose/ui/layout/Measurable;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "Landroidx/compose/ui/node/OwnerScope;", "layoutNode", "Landroidx/compose/ui/node/LayoutNode;", "(Landroidx/compose/ui/node/LayoutNode;)V", "_drawBlock", "Lkotlin/Function2;", "Landroidx/compose/ui/graphics/Canvas;", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "", "_measureResult", "Landroidx/compose/ui/layout/MeasureResult;", "_rectCache", "Landroidx/compose/ui/geometry/MutableRect;", "alignmentLinesOwner", "Landroidx/compose/ui/node/AlignmentLinesOwner;", "getAlignmentLinesOwner", "()Landroidx/compose/ui/node/AlignmentLinesOwner;", "child", "getChild", "()Landroidx/compose/ui/node/LookaheadCapablePlaceable;", "coordinates", "getCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "density", "", "getDensity", "()F", "drawBlock", "getDrawBlock", "()Lkotlin/jvm/functions/Function2;", "drawBlockCanvas", "drawBlockParentLayer", "explicitLayer", "fontScale", "getFontScale", "forceMeasureWithLookaheadConstraints", "", "getForceMeasureWithLookaheadConstraints$ui_release", "()Z", "setForceMeasureWithLookaheadConstraints$ui_release", "(Z)V", "forcePlaceWithLookaheadOffset", "getForcePlaceWithLookaheadOffset$ui_release", "setForcePlaceWithLookaheadOffset$ui_release", "hasMeasureResult", "getHasMeasureResult", "introducesMotionFrameOfReference", "getIntroducesMotionFrameOfReference", "invalidateParentLayer", "Lkotlin/Function0;", "isAttached", "isClipping", "isValidOwnerScope", "lastLayerAlpha", "<set-?>", "lastLayerDrawingWasSkipped", "getLastLayerDrawingWasSkipped$ui_release", "lastMeasurementConstraints", "Landroidx/compose/ui/unit/Constraints;", "getLastMeasurementConstraints-msEJaDk$ui_release", "()J", "Landroidx/compose/ui/node/OwnedLayer;", AdRevenueConstants.LAYER_KEY, "getLayer", "()Landroidx/compose/ui/node/OwnedLayer;", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "Lkotlin/ExtensionFunctionType;", "layerBlock", "getLayerBlock", "()Lkotlin/jvm/functions/Function1;", "layerDensity", "Landroidx/compose/ui/unit/Density;", "layerLayoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "layerPositionalProperties", "Landroidx/compose/ui/node/LayerPositionalProperties;", "layoutDirection", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutNode", "()Landroidx/compose/ui/node/LayoutNode;", "Landroidx/compose/ui/node/LookaheadDelegate;", "lookaheadDelegate", "getLookaheadDelegate", "()Landroidx/compose/ui/node/LookaheadDelegate;", "setLookaheadDelegate", "(Landroidx/compose/ui/node/LookaheadDelegate;)V", "value", "measureResult", "getMeasureResult$ui_release", "()Landroidx/compose/ui/layout/MeasureResult;", "setMeasureResult$ui_release", "(Landroidx/compose/ui/layout/MeasureResult;)V", "minimumTouchTargetSize", "Landroidx/compose/ui/geometry/Size;", "getMinimumTouchTargetSize-NH-jbRc", "oldAlignmentLines", "Landroidx/collection/MutableObjectIntMap;", "Landroidx/compose/ui/layout/AlignmentLine;", "parent", "getParent", "parentCoordinates", "getParentCoordinates", "parentData", "", "getParentData", "()Ljava/lang/Object;", "parentLayoutCoordinates", "getParentLayoutCoordinates", "Landroidx/compose/ui/unit/IntOffset;", "position", "getPosition-nOcc-ac", "setPosition--gyyYBs", "(J)V", "J", "providedAlignmentLines", "", "getProvidedAlignmentLines", "()Ljava/util/Set;", "rectCache", "getRectCache", "()Landroidx/compose/ui/geometry/MutableRect;", "released", "size", "Landroidx/compose/ui/unit/IntSize;", "getSize-YbymL2g", "snapshotObserver", "Landroidx/compose/ui/node/OwnerSnapshotObserver;", "getSnapshotObserver", "()Landroidx/compose/ui/node/OwnerSnapshotObserver;", "tail", "Landroidx/compose/ui/Modifier$Node;", "getTail", "()Landroidx/compose/ui/Modifier$Node;", "wrapped", "getWrapped$ui_release", "()Landroidx/compose/ui/node/NodeCoordinator;", "setWrapped$ui_release", "(Landroidx/compose/ui/node/NodeCoordinator;)V", "wrappedBy", "getWrappedBy$ui_release", "setWrappedBy$ui_release", "zIndex", "getZIndex", "setZIndex", "(F)V", "ancestorToLocal", "ancestor", "rect", "clipBounds", "Landroidx/compose/ui/geometry/Offset;", TypedValues.CycleType.S_WAVE_OFFSET, "includeMotionFrameOfReference", "ancestorToLocal-S_NoaFU", "(Landroidx/compose/ui/node/NodeCoordinator;JZ)J", "calculateMinimumTouchTargetPadding", "calculateMinimumTouchTargetPadding-E7KxVPU", "(J)J", "distanceInMinimumTouchTarget", "pointerPosition", "distanceInMinimumTouchTarget-tz77jQw", "(JJ)F", "draw", "canvas", "graphicsLayer", "drawBorder", "paint", "Landroidx/compose/ui/graphics/Paint;", "drawContainedDrawModifiers", "ensureLookaheadDelegateCreated", "findCommonAncestor", "other", "findCommonAncestor$ui_release", "fromParentPosition", "fromParentPosition-8S9VItk", "(JZ)J", "fromParentRect", "bounds", "hasNode", "type", "Landroidx/compose/ui/node/NodeKind;", "hasNode-H91voCI", "(I)Z", TtmlNode.TAG_HEAD, "head-H91voCI", "(I)Landroidx/compose/ui/Modifier$Node;", "headNode", "includeTail", "hitTest", "hitTestSource", "Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;", "hitTestResult", "Landroidx/compose/ui/node/HitTestResult;", "pointerType", "Landroidx/compose/ui/input/pointer/PointerType;", "isInLayer", "hitTest-qzLsGqo", "(Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;JLandroidx/compose/ui/node/HitTestResult;IZ)V", "hitTestChild", "hitTestChild-qzLsGqo", "invalidateLayer", "isPointerInBounds", "isPointerInBounds-k-4lQ0M", "(J)Z", "isTransparent", "localBoundingBoxOf", "Landroidx/compose/ui/geometry/Rect;", "sourceCoordinates", "localPositionOf", "relativeToSource", "localPositionOf-R5De75A", "(Landroidx/compose/ui/layout/LayoutCoordinates;J)J", "localPositionOf-S_NoaFU", "(Landroidx/compose/ui/layout/LayoutCoordinates;JZ)J", "localToRoot", "relativeToLocal", "localToRoot-MK-Hz9U", "localToScreen", "localToScreen-MK-Hz9U", "localToWindow", "localToWindow-MK-Hz9U", "offsetFromEdge", "offsetFromEdge-MK-Hz9U", "onAttach", "onCoordinatesUsed", "onCoordinatesUsed$ui_release", "onDetach", "onLayoutModifierNodeChanged", "onLayoutNodeAttach", "onMeasureResultChanged", "width", "", "height", "onMeasured", "onPlaced", "onRelease", "onUnplaced", "performDraw", "performingMeasure", "Landroidx/compose/ui/layout/Placeable;", "constraints", "block", "performingMeasure-K40F9xA", "(JLkotlin/jvm/functions/Function0;)Landroidx/compose/ui/layout/Placeable;", "placeAt", "placeAt-f8xVGno", "(JFLkotlin/jvm/functions/Function1;)V", "(JFLandroidx/compose/ui/graphics/layer/GraphicsLayer;)V", "placeSelf", "placeSelf-MLgxB_4", "(JFLkotlin/jvm/functions/Function1;Landroidx/compose/ui/graphics/layer/GraphicsLayer;)V", "placeSelfApparentToRealOffset", "placeSelfApparentToRealOffset-MLgxB_4", "rectInParent", "clipToMinimumTouchTargetSize", "rectInParent$ui_release", "releaseLayer", "replace", "replace$ui_release", "screenToLocal", "relativeToScreen", "screenToLocal-MK-Hz9U", "shouldSharePointerInputWithSiblings", "toParentPosition", "toParentPosition-8S9VItk", "touchBoundsInRoot", "transformFrom", "matrix", "Landroidx/compose/ui/graphics/Matrix;", "transformFrom-EL8BTi8", "(Landroidx/compose/ui/layout/LayoutCoordinates;[F)V", "transformFromAncestor", "transformFromAncestor-EL8BTi8", "(Landroidx/compose/ui/node/NodeCoordinator;[F)V", "transformToAncestor", "transformToAncestor-EL8BTi8", "transformToScreen", "transformToScreen-58bKbWc", "([F)V", "updateLayerBlock", "forceUpdateLayerParameters", "updateLayerParameters", "invokeOnLayoutChange", "visitNodes", ExifInterface.GPS_DIRECTION_TRUE, "visitNodes-aLcG6gQ", "(ILkotlin/jvm/functions/Function1;)V", "mask", "windowToLocal", "relativeToWindow", "windowToLocal-MK-Hz9U", "withPositionTranslation", "withinLayerBounds", "withinLayerBounds-k-4lQ0M", "hit", "hit-5ShdDok", "(Landroidx/compose/ui/Modifier$Node;Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;JLandroidx/compose/ui/node/HitTestResult;IZ)V", "hitNear", "distanceFromEdge", "hitNear-Fh5PU_I", "(Landroidx/compose/ui/Modifier$Node;Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;JLandroidx/compose/ui/node/HitTestResult;IZF)V", "isInExpandedTouchBounds", "isInExpandedTouchBounds-ThD-n1k", "(Landroidx/compose/ui/Modifier$Node;JI)Z", "outOfBoundsHit", "isHitInMinimumTouchTargetBetter", "outOfBoundsHit-8NAm7pk", "(Landroidx/compose/ui/Modifier$Node;Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;JLandroidx/compose/ui/node/HitTestResult;IZFZ)V", "speculativeHit", "speculativeHit-Fh5PU_I", "toCoordinator", "Companion", "HitTestSource", "ui_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class NodeCoordinator extends LookaheadCapablePlaceable implements Measurable, LayoutCoordinates, OwnerScope {
    public static final int $stable = 0;
    public static final String ExpectAttachedLayoutCoordinates = "LayoutCoordinate operations are only valid when isAttached is true";
    public static final String UnmeasuredError = "Asking for measurement result of unmeasured layout modifier";
    private Function2<? super Canvas, ? super GraphicsLayer, Unit> _drawBlock;
    private MeasureResult _measureResult;
    private MutableRect _rectCache;
    private Canvas drawBlockCanvas;
    private GraphicsLayer drawBlockParentLayer;
    private GraphicsLayer explicitLayer;
    private boolean forceMeasureWithLookaheadConstraints;
    private boolean forcePlaceWithLookaheadOffset;
    private boolean isClipping;
    private boolean lastLayerDrawingWasSkipped;
    private OwnedLayer layer;
    private Function1<? super GraphicsLayerScope, Unit> layerBlock;
    private LayerPositionalProperties layerPositionalProperties;
    private final LayoutNode layoutNode;
    private MutableObjectIntMap<AlignmentLine> oldAlignmentLines;
    private boolean released;
    private NodeCoordinator wrapped;
    private NodeCoordinator wrappedBy;
    private float zIndex;
    public static final Companion Companion = new Companion(null);
    private static final Function1<NodeCoordinator, Unit> onCommitAffectingLayerParams = new Function1<NodeCoordinator, Unit>() { // from class: androidx.compose.ui.node.NodeCoordinator$Companion$onCommitAffectingLayerParams$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(NodeCoordinator nodeCoordinator) {
            invoke2(nodeCoordinator);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(NodeCoordinator nodeCoordinator) {
            if (nodeCoordinator.isValidOwnerScope() && NodeCoordinator.updateLayerParameters$default(nodeCoordinator, false, 1, null)) {
                LayoutNode layoutNode = nodeCoordinator.getLayoutNode();
                LayoutNodeLayoutDelegate layoutDelegate$ui_release = layoutNode.getLayoutDelegate$ui_release();
                if (layoutDelegate$ui_release.getChildrenAccessingCoordinatesDuringPlacement() > 0) {
                    if (layoutDelegate$ui_release.getCoordinatesAccessedDuringModifierPlacement() || layoutDelegate$ui_release.getCoordinatesAccessedDuringPlacement()) {
                        LayoutNode.requestRelayout$ui_release$default(layoutNode, false, 1, null);
                    }
                    layoutDelegate$ui_release.getMeasurePassDelegate$ui_release().notifyChildrenUsingCoordinatesWhilePlacing();
                }
                Owner requireOwner = LayoutNodeKt.requireOwner(layoutNode);
                requireOwner.getRectManager().onLayoutLayerPositionalPropertiesChanged(layoutNode);
                requireOwner.requestOnPositionedCallback(layoutNode);
            }
        }
    };
    private static final Function1<NodeCoordinator, Unit> onCommitAffectingLayer = new Function1<NodeCoordinator, Unit>() { // from class: androidx.compose.ui.node.NodeCoordinator$Companion$onCommitAffectingLayer$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(NodeCoordinator nodeCoordinator) {
            invoke2(nodeCoordinator);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(NodeCoordinator nodeCoordinator) {
            OwnedLayer layer = nodeCoordinator.getLayer();
            if (layer != null) {
                layer.invalidate();
            }
        }
    };
    private static final ReusableGraphicsLayerScope graphicsLayerScope = new ReusableGraphicsLayerScope();
    private static final LayerPositionalProperties tmpLayerPositionalProperties = new LayerPositionalProperties();
    private static final float[] tmpMatrix = Matrix.m4309constructorimpl$default(null, 1, null);
    private static final HitTestSource PointerInputSource = new HitTestSource() { // from class: androidx.compose.ui.node.NodeCoordinator$Companion$PointerInputSource$1
        @Override // androidx.compose.ui.node.NodeCoordinator.HitTestSource
        public boolean shouldHitTestChildren(LayoutNode layoutNode) {
            return true;
        }

        @Override // androidx.compose.ui.node.NodeCoordinator.HitTestSource
        /* renamed from: childHitTest-qzLsGqo  reason: not valid java name */
        public void mo5695childHitTestqzLsGqo(LayoutNode layoutNode, long j, HitTestResult hitTestResult, int i, boolean z) {
            layoutNode.m5615hitTest6fMxITs$ui_release(j, hitTestResult, i, z);
        }

        @Override // androidx.compose.ui.node.NodeCoordinator.HitTestSource
        /* renamed from: entityType-OLwlOKw  reason: not valid java name */
        public int mo5696entityTypeOLwlOKw() {
            return NodeKind.m5700constructorimpl(16);
        }

        @Override // androidx.compose.ui.node.NodeCoordinator.HitTestSource
        public boolean interceptOutOfBoundsChildEvents(Modifier.Node node) {
            int m5700constructorimpl = NodeKind.m5700constructorimpl(16);
            MutableVector mutableVector = null;
            while (node != null) {
                if (node instanceof PointerInputModifierNode) {
                    if (((PointerInputModifierNode) node).interceptOutOfBoundsChildEvents()) {
                        return true;
                    }
                } else if ((node.getKindSet$ui_release() & m5700constructorimpl) != 0 && (node instanceof DelegatingNode)) {
                    int i = 0;
                    for (Modifier.Node delegate$ui_release = ((DelegatingNode) node).getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild$ui_release()) {
                        if ((delegate$ui_release.getKindSet$ui_release() & m5700constructorimpl) != 0) {
                            i++;
                            if (i == 1) {
                                node = delegate$ui_release;
                            } else {
                                if (mutableVector == null) {
                                    mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                }
                                if (node != null) {
                                    if (mutableVector != null) {
                                        mutableVector.add(node);
                                    }
                                    node = null;
                                }
                                if (mutableVector != null) {
                                    mutableVector.add(delegate$ui_release);
                                }
                            }
                        }
                    }
                    if (i == 1) {
                    }
                }
                node = DelegatableNodeKt.pop(mutableVector);
            }
            return false;
        }
    };
    private static final HitTestSource SemanticsSource = new HitTestSource() { // from class: androidx.compose.ui.node.NodeCoordinator$Companion$SemanticsSource$1
        @Override // androidx.compose.ui.node.NodeCoordinator.HitTestSource
        public boolean interceptOutOfBoundsChildEvents(Modifier.Node node) {
            return false;
        }

        @Override // androidx.compose.ui.node.NodeCoordinator.HitTestSource
        public boolean shouldHitTestChildren(LayoutNode layoutNode) {
            SemanticsConfiguration semanticsConfiguration = layoutNode.getSemanticsConfiguration();
            boolean z = false;
            if (semanticsConfiguration != null && semanticsConfiguration.isClearingSemantics()) {
                z = true;
            }
            return !z;
        }

        @Override // androidx.compose.ui.node.NodeCoordinator.HitTestSource
        /* renamed from: childHitTest-qzLsGqo */
        public void mo5695childHitTestqzLsGqo(LayoutNode layoutNode, long j, HitTestResult hitTestResult, int i, boolean z) {
            layoutNode.m5616hitTestSemantics6fMxITs$ui_release(j, hitTestResult, i, z);
        }

        @Override // androidx.compose.ui.node.NodeCoordinator.HitTestSource
        /* renamed from: entityType-OLwlOKw */
        public int mo5696entityTypeOLwlOKw() {
            return NodeKind.m5700constructorimpl(8);
        }
    };
    private Density layerDensity = getLayoutNode().getDensity();
    private LayoutDirection layerLayoutDirection = getLayoutNode().getLayoutDirection();
    private float lastLayerAlpha = 0.8f;
    private long position = IntOffset.Companion.m6823getZeronOccac();
    private final Function0<Unit> invalidateParentLayer = new Function0<Unit>() { // from class: androidx.compose.ui.node.NodeCoordinator$invalidateParentLayer$1
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
            NodeCoordinator wrappedBy$ui_release = NodeCoordinator.this.getWrappedBy$ui_release();
            if (wrappedBy$ui_release != null) {
                wrappedBy$ui_release.invalidateLayer();
            }
        }
    };

    /* compiled from: NodeCoordinator.kt */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J:\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH&ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u0011H&ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0016H&J\u0010\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0005H&ø\u0001\u0002\u0082\u0002\u0011\n\u0005\b¡\u001e0\u0001\n\u0002\b!\n\u0004\b!0\u0001¨\u0006\u0019À\u0006\u0001"}, d2 = {"Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;", "", "childHitTest", "", "layoutNode", "Landroidx/compose/ui/node/LayoutNode;", "pointerPosition", "Landroidx/compose/ui/geometry/Offset;", "hitTestResult", "Landroidx/compose/ui/node/HitTestResult;", "pointerType", "Landroidx/compose/ui/input/pointer/PointerType;", "isInLayer", "", "childHitTest-qzLsGqo", "(Landroidx/compose/ui/node/LayoutNode;JLandroidx/compose/ui/node/HitTestResult;IZ)V", "entityType", "Landroidx/compose/ui/node/NodeKind;", "entityType-OLwlOKw", "()I", "interceptOutOfBoundsChildEvents", "node", "Landroidx/compose/ui/Modifier$Node;", "shouldHitTestChildren", "parentLayoutNode", "ui_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes.dex */
    public interface HitTestSource {
        /* renamed from: childHitTest-qzLsGqo */
        void mo5695childHitTestqzLsGqo(LayoutNode layoutNode, long j, HitTestResult hitTestResult, int i, boolean z);

        /* renamed from: entityType-OLwlOKw */
        int mo5696entityTypeOLwlOKw();

        boolean interceptOutOfBoundsChildEvents(Modifier.Node node);

        boolean shouldHitTestChildren(LayoutNode layoutNode);
    }

    public abstract void ensureLookaheadDelegateCreated();

    public abstract LookaheadDelegate getLookaheadDelegate();

    public abstract Modifier.Node getTail();

    protected abstract void setLookaheadDelegate(LookaheadDelegate lookaheadDelegate);

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable, androidx.compose.ui.node.MeasureScopeWithLayoutNode
    public LayoutNode getLayoutNode() {
        return this.layoutNode;
    }

    public NodeCoordinator(LayoutNode layoutNode) {
        this.layoutNode = layoutNode;
    }

    public final boolean getForcePlaceWithLookaheadOffset$ui_release() {
        return this.forcePlaceWithLookaheadOffset;
    }

    public final void setForcePlaceWithLookaheadOffset$ui_release(boolean z) {
        this.forcePlaceWithLookaheadOffset = z;
    }

    public final boolean getForceMeasureWithLookaheadConstraints$ui_release() {
        return this.forceMeasureWithLookaheadConstraints;
    }

    public final void setForceMeasureWithLookaheadConstraints$ui_release(boolean z) {
        this.forceMeasureWithLookaheadConstraints = z;
    }

    public final NodeCoordinator getWrapped$ui_release() {
        return this.wrapped;
    }

    public final void setWrapped$ui_release(NodeCoordinator nodeCoordinator) {
        this.wrapped = nodeCoordinator;
    }

    public final NodeCoordinator getWrappedBy$ui_release() {
        return this.wrappedBy;
    }

    public final void setWrappedBy$ui_release(NodeCoordinator nodeCoordinator) {
        this.wrappedBy = nodeCoordinator;
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasureScope
    public LayoutDirection getLayoutDirection() {
        return getLayoutNode().getLayoutDirection();
    }

    @Override // androidx.compose.ui.unit.Density
    public float getDensity() {
        return getLayoutNode().getDensity().getDensity();
    }

    @Override // androidx.compose.ui.unit.FontScaling
    public float getFontScale() {
        return getLayoutNode().getDensity().getFontScale();
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public LookaheadCapablePlaceable getParent() {
        return this.wrappedBy;
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public LayoutCoordinates getCoordinates() {
        return this;
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public boolean getIntroducesMotionFrameOfReference() {
        return isPlacedUnderMotionFrameOfReference();
    }

    public final Modifier.Node headNode(boolean z) {
        Modifier.Node tail;
        if (getLayoutNode().getOuterCoordinator$ui_release() == this) {
            return getLayoutNode().getNodes$ui_release().getHead$ui_release();
        }
        if (z) {
            NodeCoordinator nodeCoordinator = this.wrappedBy;
            if (nodeCoordinator == null || (tail = nodeCoordinator.getTail()) == null) {
                return null;
            }
            return tail.getChild$ui_release();
        }
        NodeCoordinator nodeCoordinator2 = this.wrappedBy;
        if (nodeCoordinator2 != null) {
            return nodeCoordinator2.getTail();
        }
        return null;
    }

    public final void visitNodes(int i, boolean z, Function1<? super Modifier.Node, Unit> function1) {
        Modifier.Node tail = getTail();
        if (!z && (tail = tail.getParent$ui_release()) == null) {
            return;
        }
        for (Modifier.Node headNode = headNode(z); headNode != null && (headNode.getAggregateChildKindSet$ui_release() & i) != 0; headNode = headNode.getChild$ui_release()) {
            if ((headNode.getKindSet$ui_release() & i) != 0) {
                function1.invoke(headNode);
            }
            if (headNode == tail) {
                return;
            }
        }
    }

    /* renamed from: visitNodes-aLcG6gQ */
    public final /* synthetic */ <T> void m5693visitNodesaLcG6gQ(int i, Function1<? super T, Unit> function1) {
        boolean m5709getIncludeSelfInTraversalH91voCI = NodeKindKt.m5709getIncludeSelfInTraversalH91voCI(i);
        Modifier.Node tail = getTail();
        if (!m5709getIncludeSelfInTraversalH91voCI && (tail = tail.getParent$ui_release()) == null) {
            return;
        }
        for (Modifier.Node headNode = headNode(m5709getIncludeSelfInTraversalH91voCI); headNode != null && (headNode.getAggregateChildKindSet$ui_release() & i) != 0; headNode = headNode.getChild$ui_release()) {
            if ((headNode.getKindSet$ui_release() & i) != 0) {
                Modifier.Node node = headNode;
                MutableVector mutableVector = null;
                while (node != null) {
                    Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
                    if (node instanceof Object) {
                        function1.invoke(node);
                    } else if ((node.getKindSet$ui_release() & i) != 0 && (node instanceof DelegatingNode)) {
                        int i2 = 0;
                        for (Modifier.Node delegate$ui_release = ((DelegatingNode) node).getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild$ui_release()) {
                            if ((delegate$ui_release.getKindSet$ui_release() & i) != 0) {
                                i2++;
                                if (i2 == 1) {
                                    node = delegate$ui_release;
                                } else {
                                    if (mutableVector == null) {
                                        mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                    }
                                    if (node != null) {
                                        if (mutableVector != null) {
                                            mutableVector.add(node);
                                        }
                                        node = null;
                                    }
                                    if (mutableVector != null) {
                                        mutableVector.add(delegate$ui_release);
                                    }
                                }
                            }
                        }
                        if (i2 == 1) {
                        }
                    }
                    node = DelegatableNodeKt.pop(mutableVector);
                }
            }
            if (headNode == tail) {
                return;
            }
        }
    }

    /* renamed from: hasNode-H91voCI */
    private final boolean m5670hasNodeH91voCI(int i) {
        Modifier.Node headNode = headNode(NodeKindKt.m5709getIncludeSelfInTraversalH91voCI(i));
        return headNode != null && DelegatableNodeKt.m5558has64DMado(headNode, i);
    }

    /* renamed from: head-H91voCI */
    public final Modifier.Node m5686headH91voCI(int i) {
        boolean m5709getIncludeSelfInTraversalH91voCI = NodeKindKt.m5709getIncludeSelfInTraversalH91voCI(i);
        Modifier.Node tail = getTail();
        if (!m5709getIncludeSelfInTraversalH91voCI && (tail = tail.getParent$ui_release()) == null) {
            return null;
        }
        for (Modifier.Node headNode = headNode(m5709getIncludeSelfInTraversalH91voCI); headNode != null && (headNode.getAggregateChildKindSet$ui_release() & i) != 0; headNode = headNode.getChild$ui_release()) {
            if ((headNode.getKindSet$ui_release() & i) != 0) {
                return headNode;
            }
            if (headNode == tail) {
                return null;
            }
        }
        return null;
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* renamed from: getSize-YbymL2g */
    public final long mo5446getSizeYbymL2g() {
        return m5497getMeasuredSizeYbymL2g();
    }

    protected final Function1<GraphicsLayerScope, Unit> getLayerBlock() {
        return this.layerBlock;
    }

    public final boolean isTransparent() {
        if (this.layer == null || this.lastLayerAlpha > 0.0f) {
            NodeCoordinator nodeCoordinator = this.wrappedBy;
            if (nodeCoordinator != null) {
                return nodeCoordinator.isTransparent();
            }
            return false;
        }
        return true;
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public AlignmentLinesOwner getAlignmentLinesOwner() {
        return getLayoutNode().getLayoutDelegate$ui_release().getAlignmentLinesOwner$ui_release();
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public LookaheadCapablePlaceable getChild() {
        return this.wrapped;
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public void replace$ui_release() {
        GraphicsLayer graphicsLayer = this.explicitLayer;
        if (graphicsLayer != null) {
            mo5499placeAtf8xVGno(mo5633getPositionnOccac(), this.zIndex, graphicsLayer);
        } else {
            mo5439placeAtf8xVGno(mo5633getPositionnOccac(), this.zIndex, this.layerBlock);
        }
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public boolean getHasMeasureResult() {
        return this._measureResult != null;
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public boolean isAttached() {
        return getTail().isAttached();
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public MeasureResult getMeasureResult$ui_release() {
        MeasureResult measureResult = this._measureResult;
        if (measureResult != null) {
            return measureResult;
        }
        throw new IllegalStateException(UnmeasuredError.toString());
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x0032, code lost:
        if (r0.isNotEmpty() == false) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setMeasureResult$ui_release(MeasureResult measureResult) {
        boolean compareEquals;
        MeasureResult measureResult2 = this._measureResult;
        if (measureResult != measureResult2) {
            this._measureResult = measureResult;
            if (measureResult2 == null || measureResult.getWidth() != measureResult2.getWidth() || measureResult.getHeight() != measureResult2.getHeight()) {
                onMeasureResultChanged(measureResult.getWidth(), measureResult.getHeight());
            }
            MutableObjectIntMap<AlignmentLine> mutableObjectIntMap = this.oldAlignmentLines;
            if (mutableObjectIntMap != null) {
                Intrinsics.checkNotNull(mutableObjectIntMap);
            }
            if (measureResult.getAlignmentLines().isEmpty()) {
                return;
            }
            compareEquals = NodeCoordinatorKt.compareEquals(this.oldAlignmentLines, measureResult.getAlignmentLines());
            if (compareEquals) {
                return;
            }
            getAlignmentLinesOwner().getAlignmentLines().onAlignmentsChanged();
            MutableObjectIntMap<AlignmentLine> mutableObjectIntMap2 = this.oldAlignmentLines;
            if (mutableObjectIntMap2 == null) {
                mutableObjectIntMap2 = ObjectIntMapKt.mutableObjectIntMapOf();
                this.oldAlignmentLines = mutableObjectIntMap2;
            }
            mutableObjectIntMap2.clear();
            for (Map.Entry<AlignmentLine, Integer> entry : measureResult.getAlignmentLines().entrySet()) {
                mutableObjectIntMap2.set(entry.getKey(), entry.getValue().intValue());
            }
        }
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public Set<AlignmentLine> getProvidedAlignmentLines() {
        LinkedHashSet linkedHashSet = null;
        for (NodeCoordinator nodeCoordinator = this; nodeCoordinator != null; nodeCoordinator = nodeCoordinator.wrapped) {
            MeasureResult measureResult = nodeCoordinator._measureResult;
            Map<AlignmentLine, Integer> alignmentLines = measureResult != null ? measureResult.getAlignmentLines() : null;
            if (alignmentLines != null && (!alignmentLines.isEmpty())) {
                if (linkedHashSet == null) {
                    linkedHashSet = new LinkedHashSet();
                }
                linkedHashSet.addAll(alignmentLines.keySet());
            }
        }
        return linkedHashSet == null ? SetsKt.emptySet() : linkedHashSet;
    }

    protected void onMeasureResultChanged(int i, int i2) {
        NodeCoordinator nodeCoordinator;
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            ownedLayer.mo5756resizeozmzZPI(IntSize.m6850constructorimpl((i << 32) | (i2 & 4294967295L)));
        } else if (getLayoutNode().isPlaced() && (nodeCoordinator = this.wrappedBy) != null) {
            nodeCoordinator.invalidateLayer();
        }
        m5500setMeasuredSizeozmzZPI(IntSize.m6850constructorimpl((i2 & 4294967295L) | (i << 32)));
        if (this.layerBlock != null) {
            updateLayerParameters(false);
        }
        int m5700constructorimpl = NodeKind.m5700constructorimpl(4);
        boolean m5709getIncludeSelfInTraversalH91voCI = NodeKindKt.m5709getIncludeSelfInTraversalH91voCI(m5700constructorimpl);
        Modifier.Node tail = getTail();
        if (m5709getIncludeSelfInTraversalH91voCI || (tail = tail.getParent$ui_release()) != null) {
            for (Modifier.Node headNode = headNode(m5709getIncludeSelfInTraversalH91voCI); headNode != null && (headNode.getAggregateChildKindSet$ui_release() & m5700constructorimpl) != 0; headNode = headNode.getChild$ui_release()) {
                if ((headNode.getKindSet$ui_release() & m5700constructorimpl) != 0) {
                    Modifier.Node node = headNode;
                    MutableVector mutableVector = null;
                    while (node != null) {
                        if (node instanceof DrawModifierNode) {
                            ((DrawModifierNode) node).onMeasureResultChanged();
                        } else if ((node.getKindSet$ui_release() & m5700constructorimpl) != 0 && (node instanceof DelegatingNode)) {
                            int i3 = 0;
                            for (Modifier.Node delegate$ui_release = ((DelegatingNode) node).getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild$ui_release()) {
                                if ((delegate$ui_release.getKindSet$ui_release() & m5700constructorimpl) != 0) {
                                    i3++;
                                    if (i3 == 1) {
                                        node = delegate$ui_release;
                                    } else {
                                        if (mutableVector == null) {
                                            mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                        }
                                        if (node != null) {
                                            if (mutableVector != null) {
                                                mutableVector.add(node);
                                            }
                                            node = null;
                                        }
                                        if (mutableVector != null) {
                                            mutableVector.add(delegate$ui_release);
                                        }
                                    }
                                }
                            }
                            if (i3 == 1) {
                            }
                        }
                        node = DelegatableNodeKt.pop(mutableVector);
                    }
                }
                if (headNode == tail) {
                    break;
                }
            }
        }
        Owner owner$ui_release = getLayoutNode().getOwner$ui_release();
        if (owner$ui_release != null) {
            owner$ui_release.onLayoutChange(getLayoutNode());
        }
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    /* renamed from: getPosition-nOcc-ac */
    public long mo5633getPositionnOccac() {
        return this.position;
    }

    /* renamed from: setPosition--gyyYBs */
    protected void m5691setPositiongyyYBs(long j) {
        this.position = j;
    }

    public final float getZIndex() {
        return this.zIndex;
    }

    protected final void setZIndex(float f) {
        this.zIndex = f;
    }

    /* JADX WARN: Type inference failed for: r5v4, types: [T, java.lang.Object] */
    @Override // androidx.compose.ui.layout.Measured, androidx.compose.ui.layout.IntrinsicMeasurable
    public Object getParentData() {
        if (getLayoutNode().getNodes$ui_release().m5661hasH91voCI$ui_release(NodeKind.m5700constructorimpl(64))) {
            getTail();
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            for (Modifier.Node tail$ui_release = getLayoutNode().getNodes$ui_release().getTail$ui_release(); tail$ui_release != null; tail$ui_release = tail$ui_release.getParent$ui_release()) {
                if ((NodeKind.m5700constructorimpl(64) & tail$ui_release.getKindSet$ui_release()) != 0) {
                    int m5700constructorimpl = NodeKind.m5700constructorimpl(64);
                    MutableVector mutableVector = null;
                    Modifier.Node node = tail$ui_release;
                    while (node != null) {
                        if (node instanceof ParentDataModifierNode) {
                            objectRef.element = ((ParentDataModifierNode) node).modifyParentData(getLayoutNode().getDensity(), objectRef.element);
                        } else if ((node.getKindSet$ui_release() & m5700constructorimpl) != 0 && (node instanceof DelegatingNode)) {
                            int i = 0;
                            for (Modifier.Node delegate$ui_release = ((DelegatingNode) node).getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild$ui_release()) {
                                if ((delegate$ui_release.getKindSet$ui_release() & m5700constructorimpl) != 0) {
                                    i++;
                                    if (i == 1) {
                                        node = delegate$ui_release;
                                    } else {
                                        if (mutableVector == null) {
                                            mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                        }
                                        if (node != null) {
                                            if (mutableVector != null) {
                                                mutableVector.add(node);
                                            }
                                            node = null;
                                        }
                                        if (mutableVector != null) {
                                            mutableVector.add(delegate$ui_release);
                                        }
                                    }
                                }
                            }
                            if (i == 1) {
                            }
                        }
                        node = DelegatableNodeKt.pop(mutableVector);
                    }
                }
            }
            return objectRef.element;
        }
        return null;
    }

    public final void onCoordinatesUsed$ui_release() {
        getLayoutNode().getLayoutDelegate$ui_release().onCoordinatesUsed();
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public final LayoutCoordinates getParentLayoutCoordinates() {
        if (!isAttached()) {
            InlineClassHelperKt.throwIllegalStateException(ExpectAttachedLayoutCoordinates);
        }
        onCoordinatesUsed$ui_release();
        return getLayoutNode().getOuterCoordinator$ui_release().wrappedBy;
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public final LayoutCoordinates getParentCoordinates() {
        if (!isAttached()) {
            InlineClassHelperKt.throwIllegalStateException(ExpectAttachedLayoutCoordinates);
        }
        onCoordinatesUsed$ui_release();
        return this.wrappedBy;
    }

    protected final MutableRect getRectCache() {
        MutableRect mutableRect = this._rectCache;
        if (mutableRect == null) {
            MutableRect mutableRect2 = new MutableRect(0.0f, 0.0f, 0.0f, 0.0f);
            this._rectCache = mutableRect2;
            return mutableRect2;
        }
        return mutableRect;
    }

    public final OwnerSnapshotObserver getSnapshotObserver() {
        return LayoutNodeKt.requireOwner(getLayoutNode()).getSnapshotObserver();
    }

    /* renamed from: getLastMeasurementConstraints-msEJaDk$ui_release */
    public final long m5684getLastMeasurementConstraintsmsEJaDk$ui_release() {
        return m5498getMeasurementConstraintsmsEJaDk();
    }

    /* renamed from: performingMeasure-K40F9xA */
    protected final Placeable m5689performingMeasureK40F9xA(long j, Function0<? extends Placeable> function0) {
        m5501setMeasurementConstraintsBRTryo0(j);
        return function0.invoke();
    }

    @Override // androidx.compose.ui.layout.Placeable
    /* renamed from: placeAt-f8xVGno */
    public void mo5439placeAtf8xVGno(long j, float f, Function1<? super GraphicsLayerScope, Unit> function1) {
        if (this.forcePlaceWithLookaheadOffset) {
            LookaheadDelegate lookaheadDelegate = getLookaheadDelegate();
            Intrinsics.checkNotNull(lookaheadDelegate);
            m5676placeSelfMLgxB_4(lookaheadDelegate.mo5633getPositionnOccac(), f, function1, null);
            return;
        }
        m5676placeSelfMLgxB_4(j, f, function1, null);
    }

    @Override // androidx.compose.ui.layout.Placeable
    /* renamed from: placeAt-f8xVGno */
    public void mo5499placeAtf8xVGno(long j, float f, GraphicsLayer graphicsLayer) {
        if (this.forcePlaceWithLookaheadOffset) {
            LookaheadDelegate lookaheadDelegate = getLookaheadDelegate();
            Intrinsics.checkNotNull(lookaheadDelegate);
            m5676placeSelfMLgxB_4(lookaheadDelegate.mo5633getPositionnOccac(), f, null, graphicsLayer);
            return;
        }
        m5676placeSelfMLgxB_4(j, f, null, graphicsLayer);
    }

    /* renamed from: placeSelf-MLgxB_4 */
    private final void m5676placeSelfMLgxB_4(long j, float f, Function1<? super GraphicsLayerScope, Unit> function1, GraphicsLayer graphicsLayer) {
        if (graphicsLayer != null) {
            if (!(function1 == null)) {
                InlineClassHelperKt.throwIllegalArgumentException("both ways to create layers shouldn't be used together");
            }
            if (this.explicitLayer != graphicsLayer) {
                this.explicitLayer = null;
                updateLayerBlock$default(this, null, false, 2, null);
                this.explicitLayer = graphicsLayer;
            }
            if (this.layer == null) {
                OwnedLayer createLayer$default = Owner.createLayer$default(LayoutNodeKt.requireOwner(getLayoutNode()), getDrawBlock(), this.invalidateParentLayer, graphicsLayer, false, 8, null);
                createLayer$default.mo5756resizeozmzZPI(m5497getMeasuredSizeYbymL2g());
                createLayer$default.mo5755movegyyYBs(j);
                this.layer = createLayer$default;
                getLayoutNode().setInnerLayerCoordinatorIsDirty$ui_release(true);
                this.invalidateParentLayer.invoke();
            }
        } else {
            if (this.explicitLayer != null) {
                this.explicitLayer = null;
                updateLayerBlock$default(this, null, false, 2, null);
            }
            updateLayerBlock$default(this, function1, false, 2, null);
        }
        if (!IntOffset.m6811equalsimpl0(mo5633getPositionnOccac(), j)) {
            m5691setPositiongyyYBs(j);
            getLayoutNode().getLayoutDelegate$ui_release().getMeasurePassDelegate$ui_release().notifyChildrenUsingCoordinatesWhilePlacing();
            OwnedLayer ownedLayer = this.layer;
            if (ownedLayer != null) {
                ownedLayer.mo5755movegyyYBs(j);
            } else {
                NodeCoordinator nodeCoordinator = this.wrappedBy;
                if (nodeCoordinator != null) {
                    nodeCoordinator.invalidateLayer();
                }
            }
            invalidateAlignmentLinesFromPositionChange(this);
            Owner owner$ui_release = getLayoutNode().getOwner$ui_release();
            if (owner$ui_release != null) {
                owner$ui_release.onLayoutChange(getLayoutNode());
            }
        }
        this.zIndex = f;
        if (isPlacingForAlignment$ui_release()) {
            return;
        }
        captureRulers$ui_release(getMeasureResult$ui_release());
    }

    public final void releaseLayer() {
        if (this.layer != null) {
            if (this.explicitLayer != null) {
                this.explicitLayer = null;
            }
            updateLayerBlock$default(this, null, false, 2, null);
            LayoutNode.requestRelayout$ui_release$default(getLayoutNode(), false, 1, null);
        }
    }

    /* renamed from: placeSelfApparentToRealOffset-MLgxB_4 */
    public final void m5690placeSelfApparentToRealOffsetMLgxB_4(long j, float f, Function1<? super GraphicsLayerScope, Unit> function1, GraphicsLayer graphicsLayer) {
        m5676placeSelfMLgxB_4(IntOffset.m6816plusqkQi6aY(j, m5496getApparentToRealOffsetnOccac()), f, function1, graphicsLayer);
    }

    public final void draw(Canvas canvas, GraphicsLayer graphicsLayer) {
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            ownedLayer.drawLayer(canvas, graphicsLayer);
            return;
        }
        float m6812getXimpl = IntOffset.m6812getXimpl(mo5633getPositionnOccac());
        float m6813getYimpl = IntOffset.m6813getYimpl(mo5633getPositionnOccac());
        canvas.translate(m6812getXimpl, m6813getYimpl);
        drawContainedDrawModifiers(canvas, graphicsLayer);
        canvas.translate(-m6812getXimpl, -m6813getYimpl);
    }

    public void performDraw(Canvas canvas, GraphicsLayer graphicsLayer) {
        NodeCoordinator nodeCoordinator = this.wrapped;
        if (nodeCoordinator != null) {
            nodeCoordinator.draw(canvas, graphicsLayer);
        }
    }

    private final Function2<Canvas, GraphicsLayer, Unit> getDrawBlock() {
        Function2 function2 = this._drawBlock;
        if (function2 == null) {
            final Function0<Unit> function0 = new Function0<Unit>() { // from class: androidx.compose.ui.node.NodeCoordinator$drawBlock$drawBlockCallToDrawModifiers$1
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
                    Canvas canvas;
                    GraphicsLayer graphicsLayer;
                    NodeCoordinator nodeCoordinator = NodeCoordinator.this;
                    canvas = nodeCoordinator.drawBlockCanvas;
                    Intrinsics.checkNotNull(canvas);
                    graphicsLayer = NodeCoordinator.this.drawBlockParentLayer;
                    nodeCoordinator.drawContainedDrawModifiers(canvas, graphicsLayer);
                }
            };
            Function2<Canvas, GraphicsLayer, Unit> function22 = new Function2<Canvas, GraphicsLayer, Unit>() { // from class: androidx.compose.ui.node.NodeCoordinator$drawBlock$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Canvas canvas, GraphicsLayer graphicsLayer) {
                    invoke2(canvas, graphicsLayer);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(Canvas canvas, GraphicsLayer graphicsLayer) {
                    OwnerSnapshotObserver snapshotObserver;
                    Function1 function1;
                    if (NodeCoordinator.this.getLayoutNode().isPlaced()) {
                        NodeCoordinator.this.drawBlockCanvas = canvas;
                        NodeCoordinator.this.drawBlockParentLayer = graphicsLayer;
                        snapshotObserver = NodeCoordinator.this.getSnapshotObserver();
                        function1 = NodeCoordinator.onCommitAffectingLayer;
                        snapshotObserver.observeReads$ui_release(NodeCoordinator.this, function1, function0);
                        NodeCoordinator.this.lastLayerDrawingWasSkipped = false;
                        return;
                    }
                    NodeCoordinator.this.lastLayerDrawingWasSkipped = true;
                }
            };
            this._drawBlock = function22;
            return function22;
        }
        return function2;
    }

    public static /* synthetic */ void updateLayerBlock$default(NodeCoordinator nodeCoordinator, Function1 function1, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateLayerBlock");
        }
        if ((i & 2) != 0) {
            z = false;
        }
        nodeCoordinator.updateLayerBlock(function1, z);
    }

    public final void updateLayerBlock(Function1<? super GraphicsLayerScope, Unit> function1, boolean z) {
        Owner owner$ui_release;
        if (!(function1 == null || this.explicitLayer == null)) {
            InlineClassHelperKt.throwIllegalArgumentException("layerBlock can't be provided when explicitLayer is provided");
        }
        LayoutNode layoutNode = getLayoutNode();
        boolean z2 = (!z && this.layerBlock == function1 && Intrinsics.areEqual(this.layerDensity, layoutNode.getDensity()) && this.layerLayoutDirection == layoutNode.getLayoutDirection()) ? false : true;
        this.layerDensity = layoutNode.getDensity();
        this.layerLayoutDirection = layoutNode.getLayoutDirection();
        if (layoutNode.isAttached() && function1 != null) {
            this.layerBlock = function1;
            if (this.layer == null) {
                OwnedLayer createLayer$default = Owner.createLayer$default(LayoutNodeKt.requireOwner(layoutNode), getDrawBlock(), this.invalidateParentLayer, null, layoutNode.getForceUseOldLayers(), 4, null);
                createLayer$default.mo5756resizeozmzZPI(m5497getMeasuredSizeYbymL2g());
                createLayer$default.mo5755movegyyYBs(mo5633getPositionnOccac());
                this.layer = createLayer$default;
                updateLayerParameters$default(this, false, 1, null);
                layoutNode.setInnerLayerCoordinatorIsDirty$ui_release(true);
                this.invalidateParentLayer.invoke();
                return;
            } else if (z2 && updateLayerParameters$default(this, false, 1, null)) {
                LayoutNodeKt.requireOwner(layoutNode).getRectManager().onLayoutLayerPositionalPropertiesChanged(layoutNode);
                return;
            } else {
                return;
            }
        }
        this.layerBlock = null;
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            ownedLayer.destroy();
            layoutNode.setInnerLayerCoordinatorIsDirty$ui_release(true);
            this.invalidateParentLayer.invoke();
            if (isAttached() && layoutNode.isPlaced() && (owner$ui_release = layoutNode.getOwner$ui_release()) != null) {
                owner$ui_release.onLayoutChange(layoutNode);
            }
        }
        this.layer = null;
        this.lastLayerDrawingWasSkipped = false;
    }

    public static /* synthetic */ boolean updateLayerParameters$default(NodeCoordinator nodeCoordinator, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                z = true;
            }
            return nodeCoordinator.updateLayerParameters(z);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateLayerParameters");
    }

    private final boolean updateLayerParameters(boolean z) {
        Owner owner$ui_release;
        if (this.explicitLayer != null) {
            return false;
        }
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            final Function1<? super GraphicsLayerScope, Unit> function1 = this.layerBlock;
            if (function1 != null) {
                ReusableGraphicsLayerScope reusableGraphicsLayerScope = graphicsLayerScope;
                reusableGraphicsLayerScope.reset();
                reusableGraphicsLayerScope.setGraphicsDensity$ui_release(getLayoutNode().getDensity());
                reusableGraphicsLayerScope.setLayoutDirection$ui_release(getLayoutNode().getLayoutDirection());
                reusableGraphicsLayerScope.m4391setSizeuvyYCjk(IntSizeKt.m6867toSizeozmzZPI(mo5446getSizeYbymL2g()));
                getSnapshotObserver().observeReads$ui_release(this, onCommitAffectingLayerParams, new Function0<Unit>() { // from class: androidx.compose.ui.node.NodeCoordinator$updateLayerParameters$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
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
                        ReusableGraphicsLayerScope reusableGraphicsLayerScope2;
                        ReusableGraphicsLayerScope reusableGraphicsLayerScope3;
                        Function1<GraphicsLayerScope, Unit> function12 = function1;
                        reusableGraphicsLayerScope2 = NodeCoordinator.graphicsLayerScope;
                        function12.invoke(reusableGraphicsLayerScope2);
                        reusableGraphicsLayerScope3 = NodeCoordinator.graphicsLayerScope;
                        reusableGraphicsLayerScope3.updateOutline$ui_release();
                    }
                });
                LayerPositionalProperties layerPositionalProperties = this.layerPositionalProperties;
                if (layerPositionalProperties == null) {
                    layerPositionalProperties = new LayerPositionalProperties();
                    this.layerPositionalProperties = layerPositionalProperties;
                }
                LayerPositionalProperties layerPositionalProperties2 = tmpLayerPositionalProperties;
                layerPositionalProperties2.copyFrom(layerPositionalProperties);
                layerPositionalProperties.copyFrom(reusableGraphicsLayerScope);
                ownedLayer.updateLayerProperties(reusableGraphicsLayerScope);
                boolean z2 = this.isClipping;
                this.isClipping = reusableGraphicsLayerScope.getClip();
                this.lastLayerAlpha = reusableGraphicsLayerScope.getAlpha();
                boolean hasSameValuesAs = layerPositionalProperties2.hasSameValuesAs(layerPositionalProperties);
                boolean z3 = !hasSameValuesAs;
                if (z && ((!hasSameValuesAs || z2 != this.isClipping) && (owner$ui_release = getLayoutNode().getOwner$ui_release()) != null)) {
                    owner$ui_release.onLayoutChange(getLayoutNode());
                }
                return z3;
            }
            InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("updateLayerParameters requires a non-null layerBlock");
            throw new KotlinNothingValueException();
        }
        if (!(this.layerBlock == null)) {
            InlineClassHelperKt.throwIllegalStateException("null layer with a non-null layerBlock");
        }
        return false;
    }

    public final boolean getLastLayerDrawingWasSkipped$ui_release() {
        return this.lastLayerDrawingWasSkipped;
    }

    public final OwnedLayer getLayer() {
        return this.layer;
    }

    @Override // androidx.compose.ui.node.OwnerScope
    public boolean isValidOwnerScope() {
        return (this.layer == null || this.released || !getLayoutNode().isAttached()) ? false : true;
    }

    /* renamed from: getMinimumTouchTargetSize-NH-jbRc */
    public final long m5685getMinimumTouchTargetSizeNHjbRc() {
        return this.layerDensity.mo390toSizeXkaWNTQ(getLayoutNode().getViewConfiguration().mo5622getMinimumTouchTargetSizeMYxV2XQ());
    }

    public final void onAttach() {
        if (this.layer != null || this.layerBlock == null) {
            return;
        }
        OwnedLayer createLayer$default = Owner.createLayer$default(LayoutNodeKt.requireOwner(getLayoutNode()), getDrawBlock(), this.invalidateParentLayer, this.explicitLayer, false, 8, null);
        createLayer$default.mo5756resizeozmzZPI(m5497getMeasuredSizeYbymL2g());
        createLayer$default.mo5755movegyyYBs(mo5633getPositionnOccac());
        createLayer$default.invalidate();
        this.layer = createLayer$default;
    }

    public final void onDetach() {
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            ownedLayer.destroy();
        }
        this.layer = null;
    }

    /* renamed from: hitTest-qzLsGqo */
    public final void m5687hitTestqzLsGqo(HitTestSource hitTestSource, long j, HitTestResult hitTestResult, int i, boolean z) {
        boolean z2;
        Modifier.Node m5686headH91voCI = m5686headH91voCI(hitTestSource.mo5696entityTypeOLwlOKw());
        boolean z3 = false;
        if (!m5694withinLayerBoundsk4lQ0M(j)) {
            if (PointerType.m5384equalsimpl0(i, PointerType.Companion.m5391getTouchT8wyACA())) {
                float m5682distanceInMinimumTouchTargettz77jQw = m5682distanceInMinimumTouchTargettz77jQw(j, m5685getMinimumTouchTargetSizeNHjbRc());
                if ((Float.floatToRawIntBits(m5682distanceInMinimumTouchTargettz77jQw) & Integer.MAX_VALUE) >= 2139095040 || !hitTestResult.isHitInMinimumTouchTargetBetter(m5682distanceInMinimumTouchTargettz77jQw, false)) {
                    return;
                }
                m5672hitNearFh5PU_I(m5686headH91voCI, hitTestSource, j, hitTestResult, i, false, m5682distanceInMinimumTouchTargettz77jQw);
            }
        } else if (m5686headH91voCI == null) {
            mo5604hitTestChildqzLsGqo(hitTestSource, j, hitTestResult, i, z);
        } else if (m5688isPointerInBoundsk4lQ0M(j)) {
            m5671hit5ShdDok(m5686headH91voCI, hitTestSource, j, hitTestResult, i, z);
        } else {
            float m5682distanceInMinimumTouchTargettz77jQw2 = !PointerType.m5384equalsimpl0(i, PointerType.Companion.m5391getTouchT8wyACA()) ? Float.POSITIVE_INFINITY : m5682distanceInMinimumTouchTargettz77jQw(j, m5685getMinimumTouchTargetSizeNHjbRc());
            if ((Float.floatToRawIntBits(m5682distanceInMinimumTouchTargettz77jQw2) & Integer.MAX_VALUE) < 2139095040) {
                z2 = z;
                if (hitTestResult.isHitInMinimumTouchTargetBetter(m5682distanceInMinimumTouchTargettz77jQw2, z2)) {
                    z3 = true;
                }
            } else {
                z2 = z;
            }
            m5675outOfBoundsHit8NAm7pk(m5686headH91voCI, hitTestSource, j, hitTestResult, i, z2, m5682distanceInMinimumTouchTargettz77jQw2, z3);
        }
    }

    /* renamed from: hit-5ShdDok */
    private final void m5671hit5ShdDok(Modifier.Node node, HitTestSource hitTestSource, long j, HitTestResult hitTestResult, int i, boolean z) {
        long DistanceAndFlags;
        Modifier.Node m5698nextUntilhw7D004;
        if (node != null) {
            int i2 = hitTestResult.hitDepth;
            hitTestResult.removeNodesInRange(hitTestResult.hitDepth + 1, hitTestResult.size());
            hitTestResult.hitDepth++;
            hitTestResult.values.add(node);
            MutableLongList mutableLongList = hitTestResult.distanceFromEdgeAndFlags;
            DistanceAndFlags = HitTestResultKt.DistanceAndFlags(-1.0f, z, false);
            mutableLongList.add(DistanceAndFlags);
            m5698nextUntilhw7D004 = NodeCoordinatorKt.m5698nextUntilhw7D004(node, hitTestSource.mo5696entityTypeOLwlOKw(), NodeKind.m5700constructorimpl(2));
            m5671hit5ShdDok(m5698nextUntilhw7D004, hitTestSource, j, hitTestResult, i, z);
            hitTestResult.hitDepth = i2;
            return;
        }
        mo5604hitTestChildqzLsGqo(hitTestSource, j, hitTestResult, i, z);
    }

    /* renamed from: outOfBoundsHit-8NAm7pk */
    public final void m5675outOfBoundsHit8NAm7pk(final Modifier.Node node, final HitTestSource hitTestSource, final long j, final HitTestResult hitTestResult, final int i, final boolean z, final float f, final boolean z2) {
        if (node == null) {
            mo5604hitTestChildqzLsGqo(hitTestSource, j, hitTestResult, i, z);
        } else if (m5673isInExpandedTouchBoundsThDn1k(node, j, i)) {
            hitTestResult.hitExpandedTouchBounds(node, z, new Function0<Unit>() { // from class: androidx.compose.ui.node.NodeCoordinator$outOfBoundsHit$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    Modifier.Node m5698nextUntilhw7D004;
                    NodeCoordinator nodeCoordinator = NodeCoordinator.this;
                    m5698nextUntilhw7D004 = NodeCoordinatorKt.m5698nextUntilhw7D004(node, hitTestSource.mo5696entityTypeOLwlOKw(), NodeKind.m5700constructorimpl(2));
                    nodeCoordinator.m5675outOfBoundsHit8NAm7pk(m5698nextUntilhw7D004, hitTestSource, j, hitTestResult, i, z, f, z2);
                }
            });
        } else if (z2) {
            m5672hitNearFh5PU_I(node, hitTestSource, j, hitTestResult, i, z, f);
        } else {
            m5677speculativeHitFh5PU_I(node, hitTestSource, j, hitTestResult, i, z, f);
        }
    }

    /* renamed from: hitNear-Fh5PU_I */
    private final void m5672hitNearFh5PU_I(Modifier.Node node, HitTestSource hitTestSource, long j, HitTestResult hitTestResult, int i, boolean z, float f) {
        long DistanceAndFlags;
        Modifier.Node m5698nextUntilhw7D004;
        if (node != null) {
            int i2 = hitTestResult.hitDepth;
            hitTestResult.removeNodesInRange(hitTestResult.hitDepth + 1, hitTestResult.size());
            hitTestResult.hitDepth++;
            hitTestResult.values.add(node);
            MutableLongList mutableLongList = hitTestResult.distanceFromEdgeAndFlags;
            DistanceAndFlags = HitTestResultKt.DistanceAndFlags(f, z, false);
            mutableLongList.add(DistanceAndFlags);
            m5698nextUntilhw7D004 = NodeCoordinatorKt.m5698nextUntilhw7D004(node, hitTestSource.mo5696entityTypeOLwlOKw(), NodeKind.m5700constructorimpl(2));
            m5675outOfBoundsHit8NAm7pk(m5698nextUntilhw7D004, hitTestSource, j, hitTestResult, i, z, f, true);
            hitTestResult.hitDepth = i2;
            return;
        }
        mo5604hitTestChildqzLsGqo(hitTestSource, j, hitTestResult, i, z);
    }

    /* renamed from: speculativeHit-Fh5PU_I */
    private final void m5677speculativeHitFh5PU_I(final Modifier.Node node, final HitTestSource hitTestSource, final long j, final HitTestResult hitTestResult, final int i, final boolean z, final float f) {
        Modifier.Node m5698nextUntilhw7D004;
        if (node == null) {
            mo5604hitTestChildqzLsGqo(hitTestSource, j, hitTestResult, i, z);
        } else if (!hitTestSource.interceptOutOfBoundsChildEvents(node)) {
            m5698nextUntilhw7D004 = NodeCoordinatorKt.m5698nextUntilhw7D004(node, hitTestSource.mo5696entityTypeOLwlOKw(), NodeKind.m5700constructorimpl(2));
            m5675outOfBoundsHit8NAm7pk(m5698nextUntilhw7D004, hitTestSource, j, hitTestResult, i, z, f, false);
        } else {
            hitTestResult.speculativeHit(node, f, z, new Function0<Unit>() { // from class: androidx.compose.ui.node.NodeCoordinator$speculativeHit$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    Modifier.Node m5698nextUntilhw7D0042;
                    NodeCoordinator nodeCoordinator = NodeCoordinator.this;
                    m5698nextUntilhw7D0042 = NodeCoordinatorKt.m5698nextUntilhw7D004(node, hitTestSource.mo5696entityTypeOLwlOKw(), NodeKind.m5700constructorimpl(2));
                    nodeCoordinator.m5675outOfBoundsHit8NAm7pk(m5698nextUntilhw7D0042, hitTestSource, j, hitTestResult, i, z, f, false);
                }
            });
        }
    }

    /* renamed from: isInExpandedTouchBounds-ThD-n1k */
    private final boolean m5673isInExpandedTouchBoundsThDn1k(Modifier.Node node, long j, int i) {
        if (node == null) {
            return false;
        }
        if (PointerType.m5384equalsimpl0(i, PointerType.Companion.m5390getStylusT8wyACA()) || PointerType.m5384equalsimpl0(i, PointerType.Companion.m5388getEraserT8wyACA())) {
            int m5700constructorimpl = NodeKind.m5700constructorimpl(16);
            MutableVector mutableVector = null;
            while (node != null) {
                if (node instanceof PointerInputModifierNode) {
                    long mo1189getTouchBoundsExpansionRZrCHBk = ((PointerInputModifierNode) node).mo1189getTouchBoundsExpansionRZrCHBk();
                    int i2 = (int) (j >> 32);
                    if (Float.intBitsToFloat(i2) >= (-TouchBoundsExpansion.m5780computeLeftimpl$ui_release(mo1189getTouchBoundsExpansionRZrCHBk, getLayoutDirection())) && Float.intBitsToFloat(i2) < getMeasuredWidth() + TouchBoundsExpansion.m5781computeRightimpl$ui_release(mo1189getTouchBoundsExpansionRZrCHBk, getLayoutDirection())) {
                        int i3 = (int) (j & 4294967295L);
                        if (Float.intBitsToFloat(i3) >= (-TouchBoundsExpansion.m5788getTopimpl(mo1189getTouchBoundsExpansionRZrCHBk)) && Float.intBitsToFloat(i3) < getMeasuredHeight() + TouchBoundsExpansion.m5785getBottomimpl(mo1189getTouchBoundsExpansionRZrCHBk)) {
                            return true;
                        }
                    }
                    return false;
                }
                if ((node.getKindSet$ui_release() & m5700constructorimpl) != 0 && (node instanceof DelegatingNode)) {
                    int i4 = 0;
                    for (Modifier.Node delegate$ui_release = ((DelegatingNode) node).getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild$ui_release()) {
                        if ((delegate$ui_release.getKindSet$ui_release() & m5700constructorimpl) != 0) {
                            i4++;
                            if (i4 == 1) {
                                node = delegate$ui_release;
                            } else {
                                if (mutableVector == null) {
                                    mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                }
                                if (node != null) {
                                    if (mutableVector != null) {
                                        mutableVector.add(node);
                                    }
                                    node = null;
                                }
                                if (mutableVector != null) {
                                    mutableVector.add(delegate$ui_release);
                                }
                            }
                        }
                    }
                    if (i4 == 1) {
                    }
                }
                node = DelegatableNodeKt.pop(mutableVector);
            }
            return false;
        }
        return false;
    }

    /* renamed from: hitTestChild-qzLsGqo */
    public void mo5604hitTestChildqzLsGqo(HitTestSource hitTestSource, long j, HitTestResult hitTestResult, int i, boolean z) {
        NodeCoordinator nodeCoordinator = this.wrapped;
        if (nodeCoordinator != null) {
            nodeCoordinator.m5687hitTestqzLsGqo(hitTestSource, m5669fromParentPosition8S9VItk$default(nodeCoordinator, j, false, 2, null), hitTestResult, i, z);
        }
    }

    public final Rect touchBoundsInRoot() {
        if (!isAttached()) {
            return Rect.Companion.getZero();
        }
        LayoutCoordinates findRootCoordinates = LayoutCoordinatesKt.findRootCoordinates(this);
        MutableRect rectCache = getRectCache();
        long m5681calculateMinimumTouchTargetPaddingE7KxVPU = m5681calculateMinimumTouchTargetPaddingE7KxVPU(m5685getMinimumTouchTargetSizeNHjbRc());
        int i = (int) (m5681calculateMinimumTouchTargetPaddingE7KxVPU >> 32);
        rectCache.setLeft(-Float.intBitsToFloat(i));
        int i2 = (int) (m5681calculateMinimumTouchTargetPaddingE7KxVPU & 4294967295L);
        rectCache.setTop(-Float.intBitsToFloat(i2));
        rectCache.setRight(getMeasuredWidth() + Float.intBitsToFloat(i));
        rectCache.setBottom(getMeasuredHeight() + Float.intBitsToFloat(i2));
        NodeCoordinator nodeCoordinator = this;
        while (nodeCoordinator != findRootCoordinates) {
            nodeCoordinator.rectInParent$ui_release(rectCache, false, true);
            if (rectCache.isEmpty()) {
                return Rect.Companion.getZero();
            }
            nodeCoordinator = nodeCoordinator.wrappedBy;
            Intrinsics.checkNotNull(nodeCoordinator);
        }
        return MutableRectKt.toRect(rectCache);
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* renamed from: screenToLocal-MK-Hz9U */
    public long mo5452screenToLocalMKHz9U(long j) {
        if (!isAttached()) {
            InlineClassHelperKt.throwIllegalStateException(ExpectAttachedLayoutCoordinates);
        }
        return mo5447localPositionOfR5De75A(LayoutCoordinatesKt.findRootCoordinates(this), LayoutNodeKt.requireOwner(getLayoutNode()).mo5394screenToLocalMKHz9U(j));
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* renamed from: localToScreen-MK-Hz9U */
    public long mo5450localToScreenMKHz9U(long j) {
        if (!isAttached()) {
            InlineClassHelperKt.throwIllegalStateException(ExpectAttachedLayoutCoordinates);
        }
        return LayoutNodeKt.requireOwner(getLayoutNode()).mo5393localToScreenMKHz9U(mo5449localToRootMKHz9U(j));
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* renamed from: windowToLocal-MK-Hz9U */
    public long mo5455windowToLocalMKHz9U(long j) {
        if (!isAttached()) {
            InlineClassHelperKt.throwIllegalStateException(ExpectAttachedLayoutCoordinates);
        }
        LayoutCoordinates findRootCoordinates = LayoutCoordinatesKt.findRootCoordinates(this);
        return mo5447localPositionOfR5De75A(findRootCoordinates, Offset.m3841minusMKHz9U(LayoutNodeKt.requireOwner(getLayoutNode()).mo5758calculateLocalPositionMKHz9U(j), LayoutCoordinatesKt.positionInRoot(findRootCoordinates)));
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* renamed from: localToWindow-MK-Hz9U */
    public long mo5451localToWindowMKHz9U(long j) {
        return LayoutNodeKt.requireOwner(getLayoutNode()).mo5759calculatePositionInWindowMKHz9U(mo5449localToRootMKHz9U(j));
    }

    private final NodeCoordinator toCoordinator(LayoutCoordinates layoutCoordinates) {
        NodeCoordinator coordinator;
        LookaheadLayoutCoordinates lookaheadLayoutCoordinates = layoutCoordinates instanceof LookaheadLayoutCoordinates ? (LookaheadLayoutCoordinates) layoutCoordinates : null;
        if (lookaheadLayoutCoordinates == null || (coordinator = lookaheadLayoutCoordinates.getCoordinator()) == null) {
            Intrinsics.checkNotNull(layoutCoordinates, "null cannot be cast to non-null type androidx.compose.ui.node.NodeCoordinator");
            return (NodeCoordinator) layoutCoordinates;
        }
        return coordinator;
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* renamed from: localPositionOf-R5De75A */
    public long mo5447localPositionOfR5De75A(LayoutCoordinates layoutCoordinates, long j) {
        return mo5448localPositionOfS_NoaFU(layoutCoordinates, j, true);
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* renamed from: localPositionOf-S_NoaFU */
    public long mo5448localPositionOfS_NoaFU(LayoutCoordinates layoutCoordinates, long j, boolean z) {
        if (layoutCoordinates instanceof LookaheadLayoutCoordinates) {
            ((LookaheadLayoutCoordinates) layoutCoordinates).getCoordinator().onCoordinatesUsed$ui_release();
            return Offset.m3829constructorimpl(layoutCoordinates.mo5448localPositionOfS_NoaFU(this, Offset.m3829constructorimpl(j ^ (-9223372034707292160L)), z) ^ (-9223372034707292160L));
        }
        NodeCoordinator coordinator = toCoordinator(layoutCoordinates);
        coordinator.onCoordinatesUsed$ui_release();
        NodeCoordinator findCommonAncestor$ui_release = findCommonAncestor$ui_release(coordinator);
        while (coordinator != findCommonAncestor$ui_release) {
            j = coordinator.m5692toParentPosition8S9VItk(j, z);
            coordinator = coordinator.wrappedBy;
            Intrinsics.checkNotNull(coordinator);
        }
        return m5668ancestorToLocalS_NoaFU(findCommonAncestor$ui_release, j, z);
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* renamed from: transformFrom-EL8BTi8 */
    public void mo5453transformFromEL8BTi8(LayoutCoordinates layoutCoordinates, float[] fArr) {
        NodeCoordinator coordinator = toCoordinator(layoutCoordinates);
        coordinator.onCoordinatesUsed$ui_release();
        NodeCoordinator findCommonAncestor$ui_release = findCommonAncestor$ui_release(coordinator);
        Matrix.m4318resetimpl(fArr);
        coordinator.m5680transformToAncestorEL8BTi8(findCommonAncestor$ui_release, fArr);
        m5679transformFromAncestorEL8BTi8(findCommonAncestor$ui_release, fArr);
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* renamed from: transformToScreen-58bKbWc */
    public void mo5454transformToScreen58bKbWc(float[] fArr) {
        Owner requireOwner = LayoutNodeKt.requireOwner(getLayoutNode());
        NodeCoordinator coordinator = toCoordinator(LayoutCoordinatesKt.findRootCoordinates(this));
        m5680transformToAncestorEL8BTi8(coordinator, fArr);
        if (requireOwner instanceof MatrixPositionCalculator) {
            ((MatrixPositionCalculator) requireOwner).mo5242localToScreen58bKbWc(fArr);
            return;
        }
        long positionOnScreen = LayoutCoordinatesKt.positionOnScreen(coordinator);
        if ((9223372034707292159L & positionOnScreen) != androidx.compose.ui.geometry.InlineClassHelperKt.UnspecifiedPackedFloats) {
            Matrix.m4330translateimpl(fArr, Float.intBitsToFloat((int) (positionOnScreen >> 32)), Float.intBitsToFloat((int) (positionOnScreen & 4294967295L)), 0.0f);
        }
    }

    /* renamed from: transformToAncestor-EL8BTi8 */
    private final void m5680transformToAncestorEL8BTi8(NodeCoordinator nodeCoordinator, float[] fArr) {
        NodeCoordinator nodeCoordinator2 = this;
        while (!Intrinsics.areEqual(nodeCoordinator2, nodeCoordinator)) {
            OwnedLayer ownedLayer = nodeCoordinator2.layer;
            if (ownedLayer != null) {
                ownedLayer.mo5757transform58bKbWc(fArr);
            }
            long mo5633getPositionnOccac = nodeCoordinator2.mo5633getPositionnOccac();
            if (!IntOffset.m6811equalsimpl0(mo5633getPositionnOccac, IntOffset.Companion.m6823getZeronOccac())) {
                float[] fArr2 = tmpMatrix;
                Matrix.m4318resetimpl(fArr2);
                Matrix.m4331translateimpl$default(fArr2, IntOffset.m6812getXimpl(mo5633getPositionnOccac), IntOffset.m6813getYimpl(mo5633getPositionnOccac), 0.0f, 4, null);
                Matrix.m4328timesAssign58bKbWc(fArr, fArr2);
            }
            nodeCoordinator2 = nodeCoordinator2.wrappedBy;
            Intrinsics.checkNotNull(nodeCoordinator2);
        }
    }

    /* renamed from: transformFromAncestor-EL8BTi8 */
    private final void m5679transformFromAncestorEL8BTi8(NodeCoordinator nodeCoordinator, float[] fArr) {
        if (Intrinsics.areEqual(nodeCoordinator, this)) {
            return;
        }
        NodeCoordinator nodeCoordinator2 = this.wrappedBy;
        Intrinsics.checkNotNull(nodeCoordinator2);
        nodeCoordinator2.m5679transformFromAncestorEL8BTi8(nodeCoordinator, fArr);
        if (!IntOffset.m6811equalsimpl0(mo5633getPositionnOccac(), IntOffset.Companion.m6823getZeronOccac())) {
            float[] fArr2 = tmpMatrix;
            Matrix.m4318resetimpl(fArr2);
            Matrix.m4331translateimpl$default(fArr2, -IntOffset.m6812getXimpl(mo5633getPositionnOccac()), -IntOffset.m6813getYimpl(mo5633getPositionnOccac()), 0.0f, 4, null);
            Matrix.m4328timesAssign58bKbWc(fArr, fArr2);
        }
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            ownedLayer.mo5752inverseTransform58bKbWc(fArr);
        }
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public Rect localBoundingBoxOf(LayoutCoordinates layoutCoordinates, boolean z) {
        if (!isAttached()) {
            InlineClassHelperKt.throwIllegalStateException(ExpectAttachedLayoutCoordinates);
        }
        if (!layoutCoordinates.isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("LayoutCoordinates " + layoutCoordinates + " is not attached!");
        }
        NodeCoordinator coordinator = toCoordinator(layoutCoordinates);
        coordinator.onCoordinatesUsed$ui_release();
        NodeCoordinator findCommonAncestor$ui_release = findCommonAncestor$ui_release(coordinator);
        MutableRect rectCache = getRectCache();
        rectCache.setLeft(0.0f);
        rectCache.setTop(0.0f);
        rectCache.setRight((int) (layoutCoordinates.mo5446getSizeYbymL2g() >> 32));
        rectCache.setBottom((int) (layoutCoordinates.mo5446getSizeYbymL2g() & 4294967295L));
        NodeCoordinator nodeCoordinator = coordinator;
        while (nodeCoordinator != findCommonAncestor$ui_release) {
            boolean z2 = z;
            rectInParent$ui_release$default(nodeCoordinator, rectCache, z2, false, 4, null);
            if (rectCache.isEmpty()) {
                return Rect.Companion.getZero();
            }
            nodeCoordinator = nodeCoordinator.wrappedBy;
            Intrinsics.checkNotNull(nodeCoordinator);
            z = z2;
        }
        ancestorToLocal(findCommonAncestor$ui_release, rectCache, z);
        return MutableRectKt.toRect(rectCache);
    }

    /* renamed from: ancestorToLocal-S_NoaFU */
    private final long m5668ancestorToLocalS_NoaFU(NodeCoordinator nodeCoordinator, long j, boolean z) {
        if (nodeCoordinator == this) {
            return j;
        }
        NodeCoordinator nodeCoordinator2 = this.wrappedBy;
        if (nodeCoordinator2 == null || Intrinsics.areEqual(nodeCoordinator, nodeCoordinator2)) {
            return m5683fromParentPosition8S9VItk(j, z);
        }
        return m5683fromParentPosition8S9VItk(nodeCoordinator2.m5668ancestorToLocalS_NoaFU(nodeCoordinator, j, z), z);
    }

    private final void ancestorToLocal(NodeCoordinator nodeCoordinator, MutableRect mutableRect, boolean z) {
        if (nodeCoordinator == this) {
            return;
        }
        NodeCoordinator nodeCoordinator2 = this.wrappedBy;
        if (nodeCoordinator2 != null) {
            nodeCoordinator2.ancestorToLocal(nodeCoordinator, mutableRect, z);
        }
        fromParentRect(mutableRect, z);
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* renamed from: localToRoot-MK-Hz9U */
    public long mo5449localToRootMKHz9U(long j) {
        if (!isAttached()) {
            InlineClassHelperKt.throwIllegalStateException(ExpectAttachedLayoutCoordinates);
        }
        onCoordinatesUsed$ui_release();
        long j2 = j;
        for (NodeCoordinator nodeCoordinator = this; nodeCoordinator != null; nodeCoordinator = nodeCoordinator.wrappedBy) {
            j2 = m5678toParentPosition8S9VItk$default(nodeCoordinator, j2, false, 2, null);
        }
        return j2;
    }

    protected final void withPositionTranslation(Canvas canvas, Function1<? super Canvas, Unit> function1) {
        float m6812getXimpl = IntOffset.m6812getXimpl(mo5633getPositionnOccac());
        float m6813getYimpl = IntOffset.m6813getYimpl(mo5633getPositionnOccac());
        canvas.translate(m6812getXimpl, m6813getYimpl);
        function1.invoke(canvas);
        canvas.translate(-m6812getXimpl, -m6813getYimpl);
    }

    /* renamed from: toParentPosition-8S9VItk$default */
    public static /* synthetic */ long m5678toParentPosition8S9VItk$default(NodeCoordinator nodeCoordinator, long j, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                z = true;
            }
            return nodeCoordinator.m5692toParentPosition8S9VItk(j, z);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toParentPosition-8S9VItk");
    }

    /* renamed from: toParentPosition-8S9VItk */
    public long m5692toParentPosition8S9VItk(long j, boolean z) {
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            j = ownedLayer.mo5754mapOffset8S9VItk(j, false);
        }
        return (z || !isPlacedUnderMotionFrameOfReference()) ? IntOffsetKt.m6827plusNvtHpc(j, mo5633getPositionnOccac()) : j;
    }

    /* renamed from: fromParentPosition-8S9VItk$default */
    public static /* synthetic */ long m5669fromParentPosition8S9VItk$default(NodeCoordinator nodeCoordinator, long j, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                z = true;
            }
            return nodeCoordinator.m5683fromParentPosition8S9VItk(j, z);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fromParentPosition-8S9VItk");
    }

    /* renamed from: fromParentPosition-8S9VItk */
    public long m5683fromParentPosition8S9VItk(long j, boolean z) {
        if (z || !isPlacedUnderMotionFrameOfReference()) {
            j = IntOffsetKt.m6825minusNvtHpc(j, mo5633getPositionnOccac());
        }
        OwnedLayer ownedLayer = this.layer;
        return ownedLayer != null ? ownedLayer.mo5754mapOffset8S9VItk(j, true) : j;
    }

    public final void drawBorder(Canvas canvas, Paint paint) {
        canvas.drawRect(0.5f, 0.5f, ((int) (m5497getMeasuredSizeYbymL2g() >> 32)) - 0.5f, ((int) (m5497getMeasuredSizeYbymL2g() & 4294967295L)) - 0.5f, paint);
    }

    public final void onLayoutNodeAttach() {
        updateLayerBlock(this.layerBlock, true);
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            ownedLayer.invalidate();
        }
    }

    public final void onRelease() {
        this.released = true;
        this.invalidateParentLayer.invoke();
        releaseLayer();
    }

    public static /* synthetic */ void rectInParent$ui_release$default(NodeCoordinator nodeCoordinator, MutableRect mutableRect, boolean z, boolean z2, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: rectInParent");
        }
        if ((i & 4) != 0) {
            z2 = false;
        }
        nodeCoordinator.rectInParent$ui_release(mutableRect, z, z2);
    }

    public final void rectInParent$ui_release(MutableRect mutableRect, boolean z, boolean z2) {
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            if (this.isClipping) {
                if (z2) {
                    long m5685getMinimumTouchTargetSizeNHjbRc = m5685getMinimumTouchTargetSizeNHjbRc();
                    float intBitsToFloat = Float.intBitsToFloat((int) (m5685getMinimumTouchTargetSizeNHjbRc >> 32)) / 2.0f;
                    float intBitsToFloat2 = Float.intBitsToFloat((int) (m5685getMinimumTouchTargetSizeNHjbRc & 4294967295L)) / 2.0f;
                    mutableRect.intersect(-intBitsToFloat, -intBitsToFloat2, ((int) (mo5446getSizeYbymL2g() >> 32)) + intBitsToFloat, ((int) (4294967295L & mo5446getSizeYbymL2g())) + intBitsToFloat2);
                } else if (z) {
                    mutableRect.intersect(0.0f, 0.0f, (int) (mo5446getSizeYbymL2g() >> 32), (int) (4294967295L & mo5446getSizeYbymL2g()));
                }
                if (mutableRect.isEmpty()) {
                    return;
                }
            }
            ownedLayer.mapBounds(mutableRect, false);
        }
        float m6812getXimpl = IntOffset.m6812getXimpl(mo5633getPositionnOccac());
        mutableRect.setLeft(mutableRect.getLeft() + m6812getXimpl);
        mutableRect.setRight(mutableRect.getRight() + m6812getXimpl);
        float m6813getYimpl = IntOffset.m6813getYimpl(mo5633getPositionnOccac());
        mutableRect.setTop(mutableRect.getTop() + m6813getYimpl);
        mutableRect.setBottom(mutableRect.getBottom() + m6813getYimpl);
    }

    private final void fromParentRect(MutableRect mutableRect, boolean z) {
        float m6812getXimpl = IntOffset.m6812getXimpl(mo5633getPositionnOccac());
        mutableRect.setLeft(mutableRect.getLeft() - m6812getXimpl);
        mutableRect.setRight(mutableRect.getRight() - m6812getXimpl);
        float m6813getYimpl = IntOffset.m6813getYimpl(mo5633getPositionnOccac());
        mutableRect.setTop(mutableRect.getTop() - m6813getYimpl);
        mutableRect.setBottom(mutableRect.getBottom() - m6813getYimpl);
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            ownedLayer.mapBounds(mutableRect, true);
            if (this.isClipping && z) {
                mutableRect.intersect(0.0f, 0.0f, (int) (mo5446getSizeYbymL2g() >> 32), (int) (mo5446getSizeYbymL2g() & 4294967295L));
                mutableRect.isEmpty();
            }
        }
    }

    /* renamed from: withinLayerBounds-k-4lQ0M */
    public final boolean m5694withinLayerBoundsk4lQ0M(long j) {
        if ((((androidx.compose.ui.geometry.InlineClassHelperKt.DualFloatInfinityBase ^ (j & androidx.compose.ui.geometry.InlineClassHelperKt.DualFloatInfinityBase)) - androidx.compose.ui.geometry.InlineClassHelperKt.Uint64Low32) & (-9223372034707292160L)) == 0) {
            OwnedLayer ownedLayer = this.layer;
            return ownedLayer == null || !this.isClipping || ownedLayer.mo5753isInLayerk4lQ0M(j);
        }
        return false;
    }

    public void invalidateLayer() {
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            ownedLayer.invalidate();
            return;
        }
        NodeCoordinator nodeCoordinator = this.wrappedBy;
        if (nodeCoordinator != null) {
            nodeCoordinator.invalidateLayer();
        }
    }

    public void onLayoutModifierNodeChanged() {
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            ownedLayer.invalidate();
        }
    }

    public final NodeCoordinator findCommonAncestor$ui_release(NodeCoordinator nodeCoordinator) {
        LayoutNode layoutNode = nodeCoordinator.getLayoutNode();
        LayoutNode layoutNode2 = getLayoutNode();
        if (layoutNode == layoutNode2) {
            Modifier.Node tail = nodeCoordinator.getTail();
            Modifier.Node tail2 = getTail();
            int m5700constructorimpl = NodeKind.m5700constructorimpl(2);
            if (!tail2.getNode().isAttached()) {
                InlineClassHelperKt.throwIllegalStateException("visitLocalAncestors called on an unattached node");
            }
            for (Modifier.Node parent$ui_release = tail2.getNode().getParent$ui_release(); parent$ui_release != null; parent$ui_release = parent$ui_release.getParent$ui_release()) {
                if ((parent$ui_release.getKindSet$ui_release() & m5700constructorimpl) != 0 && parent$ui_release == tail) {
                    return nodeCoordinator;
                }
            }
            return this;
        }
        while (layoutNode.getDepth$ui_release() > layoutNode2.getDepth$ui_release()) {
            layoutNode = layoutNode.getParent$ui_release();
            Intrinsics.checkNotNull(layoutNode);
        }
        while (layoutNode2.getDepth$ui_release() > layoutNode.getDepth$ui_release()) {
            layoutNode2 = layoutNode2.getParent$ui_release();
            Intrinsics.checkNotNull(layoutNode2);
        }
        while (layoutNode != layoutNode2) {
            layoutNode = layoutNode.getParent$ui_release();
            layoutNode2 = layoutNode2.getParent$ui_release();
            if (layoutNode != null) {
                if (layoutNode2 == null) {
                }
            }
            throw new IllegalArgumentException("layouts are not part of the same hierarchy");
        }
        if (layoutNode2 != getLayoutNode()) {
            if (layoutNode != nodeCoordinator.getLayoutNode()) {
                return layoutNode.getInnerCoordinator$ui_release();
            }
            return nodeCoordinator;
        }
        return this;
    }

    /* renamed from: distanceInMinimumTouchTarget-tz77jQw */
    public final float m5682distanceInMinimumTouchTargettz77jQw(long j, long j2) {
        if (getMeasuredWidth() < Float.intBitsToFloat((int) (j2 >> 32)) || getMeasuredHeight() < Float.intBitsToFloat((int) (j2 & 4294967295L))) {
            long m5681calculateMinimumTouchTargetPaddingE7KxVPU = m5681calculateMinimumTouchTargetPaddingE7KxVPU(j2);
            float intBitsToFloat = Float.intBitsToFloat((int) (m5681calculateMinimumTouchTargetPaddingE7KxVPU >> 32));
            float intBitsToFloat2 = Float.intBitsToFloat((int) (m5681calculateMinimumTouchTargetPaddingE7KxVPU & 4294967295L));
            long m5674offsetFromEdgeMKHz9U = m5674offsetFromEdgeMKHz9U(j);
            if ((intBitsToFloat > 0.0f || intBitsToFloat2 > 0.0f) && Float.intBitsToFloat((int) (m5674offsetFromEdgeMKHz9U >> 32)) <= intBitsToFloat && Float.intBitsToFloat((int) (m5674offsetFromEdgeMKHz9U & 4294967295L)) <= intBitsToFloat2) {
                return Offset.m3836getDistanceSquaredimpl(m5674offsetFromEdgeMKHz9U);
            }
            return Float.POSITIVE_INFINITY;
        }
        return Float.POSITIVE_INFINITY;
    }

    /* compiled from: NodeCoordinator.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\u00020\u0016X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0017\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0018"}, d2 = {"Landroidx/compose/ui/node/NodeCoordinator$Companion;", "", "()V", "ExpectAttachedLayoutCoordinates", "", "PointerInputSource", "Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;", "getPointerInputSource", "()Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;", "SemanticsSource", "getSemanticsSource", "UnmeasuredError", "graphicsLayerScope", "Landroidx/compose/ui/graphics/ReusableGraphicsLayerScope;", "onCommitAffectingLayer", "Lkotlin/Function1;", "Landroidx/compose/ui/node/NodeCoordinator;", "", "onCommitAffectingLayerParams", "tmpLayerPositionalProperties", "Landroidx/compose/ui/node/LayerPositionalProperties;", "tmpMatrix", "Landroidx/compose/ui/graphics/Matrix;", "[F", "ui_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final HitTestSource getPointerInputSource() {
            return NodeCoordinator.PointerInputSource;
        }

        public final HitTestSource getSemanticsSource() {
            return NodeCoordinator.SemanticsSource;
        }
    }

    public final void onMeasured() {
        Modifier.Node parent$ui_release;
        if (m5670hasNodeH91voCI(NodeKind.m5700constructorimpl(128))) {
            Snapshot.Companion companion = Snapshot.Companion;
            Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
            Function1<Object, Unit> readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
            Snapshot makeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
            try {
                int m5700constructorimpl = NodeKind.m5700constructorimpl(128);
                boolean m5709getIncludeSelfInTraversalH91voCI = NodeKindKt.m5709getIncludeSelfInTraversalH91voCI(m5700constructorimpl);
                if (m5709getIncludeSelfInTraversalH91voCI) {
                    parent$ui_release = getTail();
                } else {
                    parent$ui_release = getTail().getParent$ui_release();
                    if (parent$ui_release == null) {
                        Unit unit = Unit.INSTANCE;
                    }
                }
                for (Modifier.Node headNode = headNode(m5709getIncludeSelfInTraversalH91voCI); headNode != null && (headNode.getAggregateChildKindSet$ui_release() & m5700constructorimpl) != 0; headNode = headNode.getChild$ui_release()) {
                    if ((headNode.getKindSet$ui_release() & m5700constructorimpl) != 0) {
                        MutableVector mutableVector = null;
                        Modifier.Node node = headNode;
                        while (node != null) {
                            if (node instanceof LayoutAwareModifierNode) {
                                ((LayoutAwareModifierNode) node).mo377onRemeasuredozmzZPI(m5497getMeasuredSizeYbymL2g());
                            } else if ((node.getKindSet$ui_release() & m5700constructorimpl) != 0 && (node instanceof DelegatingNode)) {
                                int i = 0;
                                for (Modifier.Node delegate$ui_release = ((DelegatingNode) node).getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild$ui_release()) {
                                    if ((delegate$ui_release.getKindSet$ui_release() & m5700constructorimpl) != 0) {
                                        i++;
                                        if (i == 1) {
                                            node = delegate$ui_release;
                                        } else {
                                            if (mutableVector == null) {
                                                mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                            }
                                            if (node != null) {
                                                if (mutableVector != null) {
                                                    mutableVector.add(node);
                                                }
                                                node = null;
                                            }
                                            if (mutableVector != null) {
                                                mutableVector.add(delegate$ui_release);
                                            }
                                        }
                                    }
                                }
                                if (i == 1) {
                                }
                            }
                            node = DelegatableNodeKt.pop(mutableVector);
                        }
                    }
                    if (headNode == parent$ui_release) {
                        break;
                    }
                }
                Unit unit2 = Unit.INSTANCE;
            } finally {
                companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
            }
        }
    }

    public final void onUnplaced() {
        if (m5670hasNodeH91voCI(NodeKind.m5700constructorimpl(1048576))) {
            int m5700constructorimpl = NodeKind.m5700constructorimpl(1048576);
            boolean m5709getIncludeSelfInTraversalH91voCI = NodeKindKt.m5709getIncludeSelfInTraversalH91voCI(m5700constructorimpl);
            Modifier.Node tail = getTail();
            if (!m5709getIncludeSelfInTraversalH91voCI && (tail = tail.getParent$ui_release()) == null) {
                return;
            }
            for (Modifier.Node headNode = headNode(m5709getIncludeSelfInTraversalH91voCI); headNode != null && (headNode.getAggregateChildKindSet$ui_release() & m5700constructorimpl) != 0; headNode = headNode.getChild$ui_release()) {
                if ((headNode.getKindSet$ui_release() & m5700constructorimpl) != 0) {
                    Modifier.Node node = headNode;
                    MutableVector mutableVector = null;
                    while (node != null) {
                        if (node instanceof OnUnplacedModifierNode) {
                            ((OnUnplacedModifierNode) node).onUnplaced();
                        } else if ((node.getKindSet$ui_release() & m5700constructorimpl) != 0 && (node instanceof DelegatingNode)) {
                            int i = 0;
                            for (Modifier.Node delegate$ui_release = ((DelegatingNode) node).getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild$ui_release()) {
                                if ((delegate$ui_release.getKindSet$ui_release() & m5700constructorimpl) != 0) {
                                    i++;
                                    if (i == 1) {
                                        node = delegate$ui_release;
                                    } else {
                                        if (mutableVector == null) {
                                            mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                        }
                                        if (node != null) {
                                            if (mutableVector != null) {
                                                mutableVector.add(node);
                                            }
                                            node = null;
                                        }
                                        if (mutableVector != null) {
                                            mutableVector.add(delegate$ui_release);
                                        }
                                    }
                                }
                            }
                            if (i == 1) {
                            }
                        }
                        node = DelegatableNodeKt.pop(mutableVector);
                    }
                }
                if (headNode == tail) {
                    return;
                }
            }
        }
    }

    public final void drawContainedDrawModifiers(Canvas canvas, GraphicsLayer graphicsLayer) {
        Modifier.Node m5686headH91voCI = m5686headH91voCI(NodeKind.m5700constructorimpl(4));
        if (m5686headH91voCI == null) {
            performDraw(canvas, graphicsLayer);
        } else {
            getLayoutNode().getMDrawScope$ui_release().m5628draweZhPAX0$ui_release(canvas, IntSizeKt.m6867toSizeozmzZPI(mo5446getSizeYbymL2g()), this, m5686headH91voCI, graphicsLayer);
        }
    }

    public final void onPlaced() {
        int m5700constructorimpl = NodeKind.m5700constructorimpl(128);
        boolean m5709getIncludeSelfInTraversalH91voCI = NodeKindKt.m5709getIncludeSelfInTraversalH91voCI(m5700constructorimpl);
        Modifier.Node tail = getTail();
        if (!m5709getIncludeSelfInTraversalH91voCI && (tail = tail.getParent$ui_release()) == null) {
            return;
        }
        for (Modifier.Node headNode = headNode(m5709getIncludeSelfInTraversalH91voCI); headNode != null && (headNode.getAggregateChildKindSet$ui_release() & m5700constructorimpl) != 0; headNode = headNode.getChild$ui_release()) {
            if ((headNode.getKindSet$ui_release() & m5700constructorimpl) != 0) {
                Modifier.Node node = headNode;
                MutableVector mutableVector = null;
                while (node != null) {
                    if (node instanceof LayoutAwareModifierNode) {
                        ((LayoutAwareModifierNode) node).onPlaced(this);
                    } else if ((node.getKindSet$ui_release() & m5700constructorimpl) != 0 && (node instanceof DelegatingNode)) {
                        int i = 0;
                        for (Modifier.Node delegate$ui_release = ((DelegatingNode) node).getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild$ui_release()) {
                            if ((delegate$ui_release.getKindSet$ui_release() & m5700constructorimpl) != 0) {
                                i++;
                                if (i == 1) {
                                    node = delegate$ui_release;
                                } else {
                                    if (mutableVector == null) {
                                        mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                    }
                                    if (node != null) {
                                        if (mutableVector != null) {
                                            mutableVector.add(node);
                                        }
                                        node = null;
                                    }
                                    if (mutableVector != null) {
                                        mutableVector.add(delegate$ui_release);
                                    }
                                }
                            }
                        }
                        if (i == 1) {
                        }
                    }
                    node = DelegatableNodeKt.pop(mutableVector);
                }
            }
            if (headNode == tail) {
                return;
            }
        }
    }

    /* renamed from: isPointerInBounds-k-4lQ0M */
    protected final boolean m5688isPointerInBoundsk4lQ0M(long j) {
        float intBitsToFloat = Float.intBitsToFloat((int) (j >> 32));
        float intBitsToFloat2 = Float.intBitsToFloat((int) (j & 4294967295L));
        return intBitsToFloat >= 0.0f && intBitsToFloat2 >= 0.0f && intBitsToFloat < ((float) getMeasuredWidth()) && intBitsToFloat2 < ((float) getMeasuredHeight());
    }

    public final boolean shouldSharePointerInputWithSiblings() {
        Modifier.Node headNode = headNode(NodeKindKt.m5709getIncludeSelfInTraversalH91voCI(NodeKind.m5700constructorimpl(16)));
        if (headNode != null && headNode.isAttached()) {
            Modifier.Node node = headNode;
            int m5700constructorimpl = NodeKind.m5700constructorimpl(16);
            if (!node.getNode().isAttached()) {
                InlineClassHelperKt.throwIllegalStateException("visitLocalDescendants called on an unattached node");
            }
            Modifier.Node node2 = node.getNode();
            if ((node2.getAggregateChildKindSet$ui_release() & m5700constructorimpl) != 0) {
                while (node2 != null) {
                    if ((node2.getKindSet$ui_release() & m5700constructorimpl) != 0) {
                        Modifier.Node node3 = node2;
                        MutableVector mutableVector = null;
                        while (node3 != null) {
                            if (node3 instanceof PointerInputModifierNode) {
                                if (((PointerInputModifierNode) node3).sharePointerInputWithSiblings()) {
                                    return true;
                                }
                            } else if ((node3.getKindSet$ui_release() & m5700constructorimpl) != 0 && (node3 instanceof DelegatingNode)) {
                                int i = 0;
                                for (Modifier.Node delegate$ui_release = ((DelegatingNode) node3).getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild$ui_release()) {
                                    if ((delegate$ui_release.getKindSet$ui_release() & m5700constructorimpl) != 0) {
                                        i++;
                                        if (i == 1) {
                                            node3 = delegate$ui_release;
                                        } else {
                                            if (mutableVector == null) {
                                                mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                            }
                                            if (node3 != null) {
                                                if (mutableVector != null) {
                                                    mutableVector.add(node3);
                                                }
                                                node3 = null;
                                            }
                                            if (mutableVector != null) {
                                                mutableVector.add(delegate$ui_release);
                                            }
                                        }
                                    }
                                }
                                if (i == 1) {
                                }
                            }
                            node3 = DelegatableNodeKt.pop(mutableVector);
                        }
                        continue;
                    }
                    node2 = node2.getChild$ui_release();
                }
            }
        }
        return false;
    }

    /* renamed from: offsetFromEdge-MK-Hz9U */
    private final long m5674offsetFromEdgeMKHz9U(long j) {
        float intBitsToFloat = Float.intBitsToFloat((int) (j >> 32));
        float max = Math.max(0.0f, intBitsToFloat < 0.0f ? -intBitsToFloat : intBitsToFloat - getMeasuredWidth());
        float intBitsToFloat2 = Float.intBitsToFloat((int) (j & 4294967295L));
        return Offset.m3829constructorimpl((Float.floatToRawIntBits(Math.max(0.0f, intBitsToFloat2 < 0.0f ? -intBitsToFloat2 : intBitsToFloat2 - getMeasuredHeight())) & 4294967295L) | (Float.floatToRawIntBits(max) << 32));
    }

    /* renamed from: calculateMinimumTouchTargetPadding-E7KxVPU */
    protected final long m5681calculateMinimumTouchTargetPaddingE7KxVPU(long j) {
        float max = Math.max(0.0f, (Float.intBitsToFloat((int) (j >> 32)) - getMeasuredWidth()) / 2.0f);
        return Size.m3897constructorimpl((Float.floatToRawIntBits(Math.max(0.0f, (Float.intBitsToFloat((int) (j & 4294967295L)) - getMeasuredHeight()) / 2.0f)) & 4294967295L) | (Float.floatToRawIntBits(max) << 32));
    }
}
