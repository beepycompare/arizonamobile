package androidx.compose.ui.node;

import androidx.collection.MutableLongList;
import androidx.collection.MutableObjectIntMap;
import androidx.collection.MutableScatterSet;
import androidx.collection.ObjectIntMapKt;
import androidx.collection.ScatterSetKt;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.ComposeUiFlags;
import androidx.compose.ui.FrameRateCategory;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.MutableRect;
import androidx.compose.ui.geometry.MutableRectKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Matrix;
import androidx.compose.ui.graphics.MatrixKt;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.ReusableGraphicsLayerScope;
import androidx.compose.ui.graphics.Shape;
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
import androidx.compose.ui.semantics.SemanticsNodeKt;
import androidx.compose.ui.semantics.SemanticsOwnerKt;
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
import kotlin.ranges.RangesKt;
/* compiled from: NodeCoordinator.kt */
@Metadata(d1 = {"\u0000À\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b \b!\u0018\u0000 Ë\u00022\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0004Ê\u0002Ë\u0002B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u00103\u001a\u0004\u0018\u00010\u00152\u0006\u00104\u001a\u00020\fH\u0002J-\u00105\u001a\u0002062\u0006\u00107\u001a\u0002082\u0006\u00104\u001a\u00020\f2\u0012\u00109\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u0002060:H\u0086\bJ:\u00105\u001a\u000206\"\u0006\b\u0000\u0010;\u0018\u00012\f\u0010<\u001a\b\u0012\u0004\u0012\u0002H;0=2\u0012\u00109\u001a\u000e\u0012\u0004\u0012\u0002H;\u0012\u0004\u0012\u0002060:H\u0086\b¢\u0006\u0004\b>\u0010?J\u001b\u0010@\u001a\u00020\f2\n\u0010<\u001a\u0006\u0012\u0002\b\u00030=H\u0002¢\u0006\u0004\bA\u0010BJ\u001b\u0010C\u001a\u0004\u0018\u00010\u00152\n\u0010<\u001a\u0006\u0012\u0002\b\u00030=¢\u0006\u0004\bD\u0010EJ\u0006\u0010U\u001a\u00020\fJ\r\u0010\\\u001a\u000206H\u0010¢\u0006\u0002\b]J\b\u0010q\u001a\u000206H&J\u0018\u0010v\u001a\u0002062\u0006\u0010w\u001a\u0002082\u0006\u0010x\u001a\u000208H\u0014J\u000f\u0010\u0087\u0001\u001a\u000206H\u0000¢\u0006\u0003\b\u0088\u0001J0\u0010§\u0001\u001a\u00030¨\u00012\b\u0010©\u0001\u001a\u00030\u0099\u00012\u0010\b\u0004\u00109\u001a\n\u0012\u0005\u0012\u00030¨\u00010ª\u0001H\u0084\b¢\u0006\u0006\b«\u0001\u0010¬\u0001J\u0007\u0010\u00ad\u0001\u001a\u000206J\u0007\u0010®\u0001\u001a\u000206J=\u0010¯\u0001\u001a\u0002062\u0006\u0010z\u001a\u00020y2\u0006\u0010\u007f\u001a\u00020%2\u0019\u0010N\u001a\u0015\u0012\u0004\u0012\u00020L\u0012\u0004\u0012\u000206\u0018\u00010:¢\u0006\u0002\bMH\u0014¢\u0006\u0006\b°\u0001\u0010±\u0001J,\u0010¯\u0001\u001a\u0002062\u0006\u0010z\u001a\u00020y2\u0006\u0010\u007f\u001a\u00020%2\b\u0010²\u0001\u001a\u00030³\u0001H\u0014¢\u0006\u0006\b°\u0001\u0010´\u0001JI\u0010µ\u0001\u001a\u0002062\u0006\u0010z\u001a\u00020y2\u0006\u0010\u007f\u001a\u00020%2\u0019\u0010N\u001a\u0015\u0012\u0004\u0012\u00020L\u0012\u0004\u0012\u000206\u0018\u00010:¢\u0006\u0002\bM2\n\u0010¶\u0001\u001a\u0005\u0018\u00010³\u0001H\u0002¢\u0006\u0006\b·\u0001\u0010¸\u0001J\u0007\u0010¹\u0001\u001a\u000206JG\u0010º\u0001\u001a\u0002062\u0006\u0010z\u001a\u00020y2\u0006\u0010\u007f\u001a\u00020%2\u0019\u0010N\u001a\u0015\u0012\u0004\u0012\u00020L\u0012\u0004\u0012\u000206\u0018\u00010:¢\u0006\u0002\bM2\n\u0010²\u0001\u001a\u0005\u0018\u00010³\u0001¢\u0006\u0006\b»\u0001\u0010¸\u0001J\u001d\u0010¼\u0001\u001a\u0002062\b\u0010½\u0001\u001a\u00030¾\u00012\n\u0010¿\u0001\u001a\u0005\u0018\u00010³\u0001J\u001f\u0010À\u0001\u001a\u0002062\b\u0010½\u0001\u001a\u00030¾\u00012\n\u0010¿\u0001\u001a\u0005\u0018\u00010³\u0001H\u0002J\u001f\u0010Á\u0001\u001a\u0002062\b\u0010½\u0001\u001a\u00030¾\u00012\n\u0010¿\u0001\u001a\u0005\u0018\u00010³\u0001H\u0016J\u0007\u0010Â\u0001\u001a\u000206J-\u0010Ê\u0001\u001a\u0002062\u0019\u0010N\u001a\u0015\u0012\u0004\u0012\u00020L\u0012\u0004\u0012\u000206\u0018\u00010:¢\u0006\u0002\bM2\t\b\u0002\u0010Ë\u0001\u001a\u00020\fJ\u0014\u0010Ì\u0001\u001a\u0002062\t\b\u0002\u0010Í\u0001\u001a\u00020\fH\u0002JA\u0010Ø\u0001\u001a\u0002062\b\u0010Ù\u0001\u001a\u00030Ú\u00012\b\u0010Û\u0001\u001a\u00030Ü\u00012\b\u0010Ý\u0001\u001a\u00030Þ\u00012\b\u0010ß\u0001\u001a\u00030à\u00012\u0007\u0010á\u0001\u001a\u00020\f¢\u0006\u0006\bâ\u0001\u0010ã\u0001JI\u0010ä\u0001\u001a\u000206*\u0004\u0018\u00010\u00152\b\u0010Ù\u0001\u001a\u00030Ú\u00012\b\u0010Û\u0001\u001a\u00030Ü\u00012\b\u0010Ý\u0001\u001a\u00030Þ\u00012\b\u0010ß\u0001\u001a\u00030à\u00012\u0007\u0010á\u0001\u001a\u00020\fH\u0002¢\u0006\u0006\bå\u0001\u0010æ\u0001J[\u0010ç\u0001\u001a\u000206*\u0004\u0018\u00010\u00152\b\u0010Ù\u0001\u001a\u00030Ú\u00012\b\u0010Û\u0001\u001a\u00030Ü\u00012\b\u0010Ý\u0001\u001a\u00030Þ\u00012\b\u0010ß\u0001\u001a\u00030à\u00012\u0007\u0010á\u0001\u001a\u00020\f2\u0007\u0010è\u0001\u001a\u00020%2\u0007\u0010é\u0001\u001a\u00020\fH\u0002¢\u0006\u0006\bê\u0001\u0010ë\u0001JR\u0010ì\u0001\u001a\u000206*\u0004\u0018\u00010\u00152\b\u0010Ù\u0001\u001a\u00030Ú\u00012\b\u0010Û\u0001\u001a\u00030Ü\u00012\b\u0010Ý\u0001\u001a\u00030Þ\u00012\b\u0010ß\u0001\u001a\u00030à\u00012\u0007\u0010á\u0001\u001a\u00020\f2\u0007\u0010è\u0001\u001a\u00020%H\u0002¢\u0006\u0006\bí\u0001\u0010î\u0001JR\u0010ï\u0001\u001a\u000206*\u0004\u0018\u00010\u00152\b\u0010Ù\u0001\u001a\u00030Ú\u00012\b\u0010Û\u0001\u001a\u00030Ü\u00012\b\u0010Ý\u0001\u001a\u00030Þ\u00012\b\u0010ß\u0001\u001a\u00030à\u00012\u0007\u0010á\u0001\u001a\u00020\f2\u0007\u0010è\u0001\u001a\u00020%H\u0002¢\u0006\u0006\bð\u0001\u0010î\u0001J,\u0010ñ\u0001\u001a\u00020\f*\u0004\u0018\u00010\u00152\b\u0010Û\u0001\u001a\u00030Ü\u00012\b\u0010ß\u0001\u001a\u00030à\u0001H\u0002¢\u0006\u0006\bò\u0001\u0010ó\u0001JC\u0010ô\u0001\u001a\u0002062\b\u0010Ù\u0001\u001a\u00030Ú\u00012\b\u0010Û\u0001\u001a\u00030Ü\u00012\b\u0010Ý\u0001\u001a\u00030Þ\u00012\b\u0010ß\u0001\u001a\u00030à\u00012\u0007\u0010á\u0001\u001a\u00020\fH\u0016¢\u0006\u0006\bõ\u0001\u0010ã\u0001J\b\u0010ö\u0001\u001a\u00030÷\u0001J\u001d\u0010ø\u0001\u001a\u00030Ü\u00012\b\u0010ù\u0001\u001a\u00030Ü\u0001H\u0016¢\u0006\u0006\bú\u0001\u0010û\u0001J\u001d\u0010ü\u0001\u001a\u00030Ü\u00012\b\u0010ý\u0001\u001a\u00030Ü\u0001H\u0016¢\u0006\u0006\bþ\u0001\u0010û\u0001J\u001d\u0010ÿ\u0001\u001a\u00030Ü\u00012\b\u0010\u0080\u0002\u001a\u00030Ü\u0001H\u0016¢\u0006\u0006\b\u0081\u0002\u0010û\u0001J\u001d\u0010\u0082\u0002\u001a\u00030Ü\u00012\b\u0010ý\u0001\u001a\u00030Ü\u0001H\u0016¢\u0006\u0006\b\u0083\u0002\u0010û\u0001J\r\u0010\u0084\u0002\u001a\u00020\u0000*\u00020\u0003H\u0002J&\u0010\u0085\u0002\u001a\u00030Ü\u00012\u0007\u0010\u0086\u0002\u001a\u00020\u00032\b\u0010\u0087\u0002\u001a\u00030Ü\u0001H\u0016¢\u0006\u0006\b\u0088\u0002\u0010\u0089\u0002J/\u0010\u0085\u0002\u001a\u00030Ü\u00012\u0007\u0010\u0086\u0002\u001a\u00020\u00032\b\u0010\u0087\u0002\u001a\u00030Ü\u00012\u0007\u0010\u008a\u0002\u001a\u00020\fH\u0016¢\u0006\u0006\b\u008b\u0002\u0010\u008c\u0002J%\u0010\u008d\u0002\u001a\u0002062\u0007\u0010\u0086\u0002\u001a\u00020\u00032\b\u0010\u008e\u0002\u001a\u00030\u008f\u0002H\u0016¢\u0006\u0006\b\u0090\u0002\u0010\u0091\u0002J\u001c\u0010\u0092\u0002\u001a\u0002062\b\u0010\u008e\u0002\u001a\u00030\u008f\u0002H\u0016¢\u0006\u0006\b\u0093\u0002\u0010\u0094\u0002J%\u0010\u0095\u0002\u001a\u0002062\u0007\u0010\u0096\u0002\u001a\u00020\u00002\b\u0010\u008e\u0002\u001a\u00030\u008f\u0002H\u0002¢\u0006\u0006\b\u0097\u0002\u0010\u0098\u0002J%\u0010\u0099\u0002\u001a\u0002062\u0007\u0010\u0096\u0002\u001a\u00020\u00002\b\u0010\u008e\u0002\u001a\u00030\u008f\u0002H\u0002¢\u0006\u0006\b\u009a\u0002\u0010\u0098\u0002J\u001c\u0010\u009b\u0002\u001a\u00030÷\u00012\u0007\u0010\u0086\u0002\u001a\u00020\u00032\u0007\u0010\u009c\u0002\u001a\u00020\fH\u0016J/\u0010\u009d\u0002\u001a\u00030Ü\u00012\u0007\u0010\u0096\u0002\u001a\u00020\u00002\b\u0010\u009e\u0002\u001a\u00030Ü\u00012\u0007\u0010\u008a\u0002\u001a\u00020\fH\u0002¢\u0006\u0006\b\u009f\u0002\u0010 \u0002J%\u0010\u009d\u0002\u001a\u0002062\u0007\u0010\u0096\u0002\u001a\u00020\u00002\b\u0010¡\u0002\u001a\u00030\u008e\u00012\u0007\u0010\u009c\u0002\u001a\u00020\fH\u0002J\u001d\u0010¢\u0002\u001a\u00030Ü\u00012\b\u0010ý\u0001\u001a\u00030Ü\u0001H\u0016¢\u0006\u0006\b£\u0002\u0010û\u0001J)\u0010¤\u0002\u001a\u0002062\b\u0010½\u0001\u001a\u00030¾\u00012\u0013\u00109\u001a\u000f\u0012\u0005\u0012\u00030¾\u0001\u0012\u0004\u0012\u0002060:H\u0084\bJ'\u0010¥\u0002\u001a\u00030Ü\u00012\u0007\u0010z\u001a\u00030Ü\u00012\t\b\u0002\u0010\u008a\u0002\u001a\u00020\fH\u0016¢\u0006\u0006\b¦\u0002\u0010§\u0002J'\u0010¨\u0002\u001a\u00030Ü\u00012\u0007\u0010z\u001a\u00030Ü\u00012\t\b\u0002\u0010\u008a\u0002\u001a\u00020\fH\u0016¢\u0006\u0006\b©\u0002\u0010§\u0002J\u001d\u0010ª\u0002\u001a\u0002062\b\u0010½\u0001\u001a\u00030¾\u00012\b\u0010«\u0002\u001a\u00030¬\u0002H\u0004J\u0007\u0010\u00ad\u0002\u001a\u000206J\u0007\u0010®\u0002\u001a\u000206J-\u0010¯\u0002\u001a\u0002062\b\u0010°\u0002\u001a\u00030\u008e\u00012\u0007\u0010\u009c\u0002\u001a\u00020\f2\t\b\u0002\u0010±\u0002\u001a\u00020\fH\u0000¢\u0006\u0003\b²\u0002J\u001c\u0010³\u0002\u001a\u0002062\b\u0010°\u0002\u001a\u00030\u008e\u00012\u0007\u0010\u009c\u0002\u001a\u00020\fH\u0002J\u001c\u0010´\u0002\u001a\u00020\f2\b\u0010Û\u0001\u001a\u00030Ü\u0001H\u0004¢\u0006\u0006\bµ\u0002\u0010¶\u0002J\u001c\u0010·\u0002\u001a\u00020\f2\b\u0010Û\u0001\u001a\u00030Ü\u0001H\u0004¢\u0006\u0006\b¸\u0002\u0010¶\u0002J\t\u0010¹\u0002\u001a\u000206H\u0016J\t\u0010º\u0002\u001a\u000206H\u0016J\u0018\u0010»\u0002\u001a\u00020\u00002\u0007\u0010¼\u0002\u001a\u00020\u0000H\u0000¢\u0006\u0003\b½\u0002J\u0007\u0010¾\u0002\u001a\u00020\fJ\u001d\u0010¿\u0002\u001a\u00030Ü\u00012\b\u0010Û\u0001\u001a\u00030Ü\u0001H\u0002¢\u0006\u0006\bÀ\u0002\u0010û\u0001J\u001d\u0010Á\u0002\u001a\u00030Ö\u00012\b\u0010Õ\u0001\u001a\u00030Ö\u0001H\u0004¢\u0006\u0006\bÂ\u0002\u0010û\u0001J'\u0010Ã\u0002\u001a\u00030Ü\u00012\b\u0010Ä\u0002\u001a\u00030\u008e\u00012\b\u0010Õ\u0001\u001a\u00030Ö\u0001H\u0004¢\u0006\u0006\bÅ\u0002\u0010Æ\u0002J&\u0010Ç\u0002\u001a\u00020%2\b\u0010Û\u0001\u001a\u00030Ü\u00012\b\u0010Õ\u0001\u001a\u00030Ö\u0001H\u0004¢\u0006\u0006\bÈ\u0002\u0010É\u0002R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\u0012\u0010\u0014\u001a\u00020\u0015X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0000X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u0000X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001a\"\u0004\b\u001f\u0010\u001cR\u0014\u0010 \u001a\u00020!8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u0014\u0010$\u001a\u00020%8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'R\u0014\u0010(\u001a\u00020%8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b)\u0010'R\u0016\u0010*\u001a\u0004\u0018\u00010\u00018VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b+\u0010,R\u0014\u0010-\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b.\u0010/R\u0014\u00100\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b1\u0010\u000eR\u000e\u00102\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010F\u001a\u00020G8F¢\u0006\u0006\u001a\u0004\bH\u0010IR\u000e\u0010J\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000RD\u0010N\u001a\u0015\u0012\u0004\u0012\u00020L\u0012\u0004\u0012\u000206\u0018\u00010:¢\u0006\u0002\bM2\u0019\u0010K\u001a\u0015\u0012\u0004\u0012\u00020L\u0012\u0004\u0012\u000206\u0018\u00010:¢\u0006\u0002\bM@BX\u0084\u000e¢\u0006\b\n\u0000\u001a\u0004\bO\u0010PR\u000e\u0010Q\u001a\u00020RX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010S\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010T\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010V\u001a\u00020W8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bX\u0010YR\u0016\u0010Z\u001a\u0004\u0018\u00010\u00018VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b[\u0010,R\u0014\u0010^\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b_\u0010\u000eR\u0014\u0010`\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b`\u0010\u000eR\u0010\u0010a\u001a\u0004\u0018\u00010bX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010c\u001a\u00020b2\u0006\u0010K\u001a\u00020b8P@PX\u0090\u000e¢\u0006\f\u001a\u0004\bd\u0010e\"\u0004\bf\u0010gR&\u0010i\u001a\u0004\u0018\u00010h2\b\u0010K\u001a\u0004\u0018\u00010h@dX¦\u000e¢\u0006\f\u001a\u0004\bj\u0010k\"\u0004\bl\u0010mR\u0016\u0010n\u001a\n\u0012\u0004\u0012\u00020p\u0018\u00010oX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010r\u001a\b\u0012\u0004\u0012\u00020p0s8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bt\u0010uR&\u0010z\u001a\u00020y2\u0006\u0010K\u001a\u00020y@TX\u0096\u000e¢\u0006\u0010\n\u0002\u0010~\u001a\u0004\b{\u0010I\"\u0004\b|\u0010}R'\u0010\u007f\u001a\u00020%2\u0006\u0010K\u001a\u00020%@DX\u0086\u000e¢\u0006\u0011\n\u0000\u001a\u0005\b\u0080\u0001\u0010'\"\u0006\b\u0081\u0001\u0010\u0082\u0001R\u001a\u0010\u0083\u0001\u001a\u0005\u0018\u00010\u0084\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u0085\u0001\u0010\u0086\u0001R\u0015\u0010\u0089\u0001\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0007\u001a\u0005\b\u008a\u0001\u0010/R\u0015\u0010\u008b\u0001\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0007\u001a\u0005\b\u008c\u0001\u0010/R\u0012\u0010\u008d\u0001\u001a\u0005\u0018\u00010\u008e\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u008f\u0001\u001a\u00030\u008e\u00018DX\u0084\u0004¢\u0006\b\u001a\u0006\b\u0090\u0001\u0010\u0091\u0001R\u0018\u0010\u0092\u0001\u001a\u00030\u0093\u00018BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u0094\u0001\u0010\u0095\u0001R\u0012\u0010\u0096\u0001\u001a\u0005\u0018\u00010\u0097\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0098\u0001\u001a\u00030\u0099\u00018@X\u0080\u0004¢\u0006\u0007\u001a\u0005\b\u009a\u0001\u0010IR \u0010\u009b\u0001\u001a\u00030\u009c\u0001X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u009d\u0001\u0010\u009e\u0001\"\u0006\b\u009f\u0001\u0010 \u0001R\u001d\u0010¡\u0001\u001a\u00020\fX\u0080\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¢\u0001\u0010\u000e\"\u0005\b£\u0001\u0010\u0010R\u001d\u0010¤\u0001\u001a\u00020\fX\u0080\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¥\u0001\u0010\u000e\"\u0005\b¦\u0001\u0010\u0010R\u0012\u0010Ã\u0001\u001a\u0005\u0018\u00010³\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010Ä\u0001\u001a\u0005\u0018\u00010¾\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010Å\u0001\u001a\u001b\u0012\u0005\u0012\u00030¾\u0001\u0012\u0007\u0012\u0005\u0018\u00010³\u0001\u0012\u0004\u0012\u000206\u0018\u00010Æ\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R.\u0010Ç\u0001\u001a\u0019\u0012\u0005\u0012\u00030¾\u0001\u0012\u0007\u0012\u0005\u0018\u00010³\u0001\u0012\u0004\u0012\u0002060Æ\u00018BX\u0082\u0004¢\u0006\b\u001a\u0006\bÈ\u0001\u0010É\u0001R\u0016\u0010Î\u0001\u001a\t\u0012\u0004\u0012\u0002060ª\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010Ï\u0001\u001a\u00020\f2\u0006\u0010K\u001a\u00020\f@BX\u0080\u000e¢\u0006\t\n\u0000\u001a\u0005\bÐ\u0001\u0010\u000eR'\u0010²\u0001\u001a\u0005\u0018\u00010Ñ\u00012\t\u0010K\u001a\u0005\u0018\u00010Ñ\u0001@BX\u0086\u000e¢\u0006\n\n\u0000\u001a\u0006\bÒ\u0001\u0010Ó\u0001R\u0012\u0010¶\u0001\u001a\u0005\u0018\u00010³\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010Ô\u0001\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\bÔ\u0001\u0010\u000eR\u0014\u0010Õ\u0001\u001a\u00030Ö\u00018F¢\u0006\u0007\u001a\u0005\b×\u0001\u0010I¨\u0006Ì\u0002"}, d2 = {"Landroidx/compose/ui/node/NodeCoordinator;", "Landroidx/compose/ui/node/LookaheadCapablePlaceable;", "Landroidx/compose/ui/layout/Measurable;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "Landroidx/compose/ui/node/OwnerScope;", "layoutNode", "Landroidx/compose/ui/node/LayoutNode;", "<init>", "(Landroidx/compose/ui/node/LayoutNode;)V", "getLayoutNode", "()Landroidx/compose/ui/node/LayoutNode;", "forcePlaceWithLookaheadOffset", "", "getForcePlaceWithLookaheadOffset$ui", "()Z", "setForcePlaceWithLookaheadOffset$ui", "(Z)V", "forceMeasureWithLookaheadConstraints", "getForceMeasureWithLookaheadConstraints$ui", "setForceMeasureWithLookaheadConstraints$ui", "tail", "Landroidx/compose/ui/Modifier$Node;", "getTail", "()Landroidx/compose/ui/Modifier$Node;", "wrapped", "getWrapped$ui", "()Landroidx/compose/ui/node/NodeCoordinator;", "setWrapped$ui", "(Landroidx/compose/ui/node/NodeCoordinator;)V", "wrappedBy", "getWrappedBy$ui", "setWrappedBy$ui", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "density", "", "getDensity", "()F", "fontScale", "getFontScale", "parent", "getParent", "()Landroidx/compose/ui/node/LookaheadCapablePlaceable;", "coordinates", "getCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "introducesMotionFrameOfReference", "getIntroducesMotionFrameOfReference", "released", "headNode", "includeTail", "visitNodes", "", "mask", "", "block", "Lkotlin/Function1;", ExifInterface.GPS_DIRECTION_TRUE, "type", "Landroidx/compose/ui/node/NodeKind;", "visitNodes-aLcG6gQ", "(ILkotlin/jvm/functions/Function1;)V", "hasNode", "hasNode-H91voCI", "(I)Z", TtmlNode.TAG_HEAD, "head-H91voCI", "(I)Landroidx/compose/ui/Modifier$Node;", "size", "Landroidx/compose/ui/unit/IntSize;", "getSize-YbymL2g", "()J", "isClipping", "value", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "Lkotlin/ExtensionFunctionType;", "layerBlock", "getLayerBlock", "()Lkotlin/jvm/functions/Function1;", "layerDensity", "Landroidx/compose/ui/unit/Density;", "layerLayoutDirection", "lastLayerAlpha", "isTransparent", "alignmentLinesOwner", "Landroidx/compose/ui/node/AlignmentLinesOwner;", "getAlignmentLinesOwner", "()Landroidx/compose/ui/node/AlignmentLinesOwner;", "child", "getChild", "replace", "replace$ui", "hasMeasureResult", "getHasMeasureResult", "isAttached", "_measureResult", "Landroidx/compose/ui/layout/MeasureResult;", "measureResult", "getMeasureResult$ui", "()Landroidx/compose/ui/layout/MeasureResult;", "setMeasureResult$ui", "(Landroidx/compose/ui/layout/MeasureResult;)V", "Landroidx/compose/ui/node/LookaheadDelegate;", "lookaheadDelegate", "getLookaheadDelegate", "()Landroidx/compose/ui/node/LookaheadDelegate;", "setLookaheadDelegate", "(Landroidx/compose/ui/node/LookaheadDelegate;)V", "oldAlignmentLines", "Landroidx/collection/MutableObjectIntMap;", "Landroidx/compose/ui/layout/AlignmentLine;", "ensureLookaheadDelegateCreated", "providedAlignmentLines", "", "getProvidedAlignmentLines", "()Ljava/util/Set;", "onMeasureResultChanged", "width", "height", "Landroidx/compose/ui/unit/IntOffset;", "position", "getPosition-nOcc-ac", "setPosition--gyyYBs", "(J)V", "J", "zIndex", "getZIndex", "setZIndex", "(F)V", "parentData", "", "getParentData", "()Ljava/lang/Object;", "onCoordinatesUsed", "onCoordinatesUsed$ui", "parentLayoutCoordinates", "getParentLayoutCoordinates", "parentCoordinates", "getParentCoordinates", "_rectCache", "Landroidx/compose/ui/geometry/MutableRect;", "rectCache", "getRectCache", "()Landroidx/compose/ui/geometry/MutableRect;", "snapshotObserver", "Landroidx/compose/ui/node/OwnerSnapshotObserver;", "getSnapshotObserver", "()Landroidx/compose/ui/node/OwnerSnapshotObserver;", "layerPositionalProperties", "Landroidx/compose/ui/node/LayerPositionalProperties;", "lastMeasurementConstraints", "Landroidx/compose/ui/unit/Constraints;", "getLastMeasurementConstraints-msEJaDk$ui", "lastShape", "Landroidx/compose/ui/graphics/Shape;", "getLastShape$ui", "()Landroidx/compose/ui/graphics/Shape;", "setLastShape$ui", "(Landroidx/compose/ui/graphics/Shape;)V", "lastClip", "getLastClip$ui", "setLastClip$ui", "wasLayerBlockInvoked", "getWasLayerBlockInvoked$ui", "setWasLayerBlockInvoked$ui", "performingMeasure", "Landroidx/compose/ui/layout/Placeable;", "constraints", "Lkotlin/Function0;", "performingMeasure-K40F9xA", "(JLkotlin/jvm/functions/Function0;)Landroidx/compose/ui/layout/Placeable;", "onMeasured", "onUnplaced", "placeAt", "placeAt-f8xVGno", "(JFLkotlin/jvm/functions/Function1;)V", AdRevenueConstants.LAYER_KEY, "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "(JFLandroidx/compose/ui/graphics/layer/GraphicsLayer;)V", "placeSelf", "explicitLayer", "placeSelf-MLgxB_4", "(JFLkotlin/jvm/functions/Function1;Landroidx/compose/ui/graphics/layer/GraphicsLayer;)V", "releaseLayer", "placeSelfApparentToRealOffset", "placeSelfApparentToRealOffset-MLgxB_4", "draw", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "graphicsLayer", "drawContainedDrawModifiers", "performDraw", "onPlaced", "drawBlockParentLayer", "drawBlockCanvas", "_drawBlock", "Lkotlin/Function2;", "drawBlock", "getDrawBlock", "()Lkotlin/jvm/functions/Function2;", "updateLayerBlock", "forceUpdateLayerParameters", "updateLayerParameters", "invokeOnLayoutChange", "invalidateParentLayer", "lastLayerDrawingWasSkipped", "getLastLayerDrawingWasSkipped$ui", "Landroidx/compose/ui/node/OwnedLayer;", "getLayer", "()Landroidx/compose/ui/node/OwnedLayer;", "isValidOwnerScope", "minimumTouchTargetSize", "Landroidx/compose/ui/geometry/Size;", "getMinimumTouchTargetSize-NH-jbRc", "hitTest", "hitTestSource", "Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;", "pointerPosition", "Landroidx/compose/ui/geometry/Offset;", "hitTestResult", "Landroidx/compose/ui/node/HitTestResult;", "pointerType", "Landroidx/compose/ui/input/pointer/PointerType;", "isInLayer", "hitTest-qzLsGqo", "(Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;JLandroidx/compose/ui/node/HitTestResult;IZ)V", "hit", "hit-5ShdDok", "(Landroidx/compose/ui/Modifier$Node;Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;JLandroidx/compose/ui/node/HitTestResult;IZ)V", "outOfBoundsHit", "distanceFromEdge", "isHitInMinimumTouchTargetBetter", "outOfBoundsHit-8NAm7pk", "(Landroidx/compose/ui/Modifier$Node;Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;JLandroidx/compose/ui/node/HitTestResult;IZFZ)V", "hitNear", "hitNear-Fh5PU_I", "(Landroidx/compose/ui/Modifier$Node;Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;JLandroidx/compose/ui/node/HitTestResult;IZF)V", "speculativeHit", "speculativeHit-Fh5PU_I", "isInExpandedTouchBounds", "isInExpandedTouchBounds-ThD-n1k", "(Landroidx/compose/ui/Modifier$Node;JI)Z", "hitTestChild", "hitTestChild-qzLsGqo", "touchBoundsInRoot", "Landroidx/compose/ui/geometry/Rect;", "screenToLocal", "relativeToScreen", "screenToLocal-MK-Hz9U", "(J)J", "localToScreen", "relativeToLocal", "localToScreen-MK-Hz9U", "windowToLocal", "relativeToWindow", "windowToLocal-MK-Hz9U", "localToWindow", "localToWindow-MK-Hz9U", "toCoordinator", "localPositionOf", "sourceCoordinates", "relativeToSource", "localPositionOf-R5De75A", "(Landroidx/compose/ui/layout/LayoutCoordinates;J)J", "includeMotionFrameOfReference", "localPositionOf-S_NoaFU", "(Landroidx/compose/ui/layout/LayoutCoordinates;JZ)J", "transformFrom", "matrix", "Landroidx/compose/ui/graphics/Matrix;", "transformFrom-EL8BTi8", "(Landroidx/compose/ui/layout/LayoutCoordinates;[F)V", "transformToScreen", "transformToScreen-58bKbWc", "([F)V", "transformToAncestor", "ancestor", "transformToAncestor-EL8BTi8", "(Landroidx/compose/ui/node/NodeCoordinator;[F)V", "transformFromAncestor", "transformFromAncestor-EL8BTi8", "localBoundingBoxOf", "clipBounds", "ancestorToLocal", TypedValues.CycleType.S_WAVE_OFFSET, "ancestorToLocal-S_NoaFU", "(Landroidx/compose/ui/node/NodeCoordinator;JZ)J", "rect", "localToRoot", "localToRoot-MK-Hz9U", "withPositionTranslation", "toParentPosition", "toParentPosition-8S9VItk", "(JZ)J", "fromParentPosition", "fromParentPosition-8S9VItk", "drawBorder", "paint", "Landroidx/compose/ui/graphics/Paint;", "onLayoutNodeDetach", "onRelease", "rectInParent", "bounds", "clipToMinimumTouchTargetSize", "rectInParent$ui", "fromParentRect", "withinLayerBounds", "withinLayerBounds-k-4lQ0M", "(J)Z", "isPointerInBounds", "isPointerInBounds-k-4lQ0M", "invalidateLayer", "onLayoutModifierNodeChanged", "findCommonAncestor", "other", "findCommonAncestor$ui", "shouldSharePointerInputWithSiblings", "offsetFromEdge", "offsetFromEdge-MK-Hz9U", "calculateMinimumTouchTargetPadding", "calculateMinimumTouchTargetPadding-E7KxVPU", "calculateMinimumTouchTargetOffset", "childRect", "calculateMinimumTouchTargetOffset-C6jSQ5I", "(Landroidx/compose/ui/geometry/MutableRect;J)J", "distanceInMinimumTouchTarget", "distanceInMinimumTouchTarget-tz77jQw", "(JJ)F", "HitTestSource", "Companion", "ui"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
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
    private boolean lastClip;
    private boolean lastLayerDrawingWasSkipped;
    private OwnedLayer layer;
    private Function1<? super GraphicsLayerScope, Unit> layerBlock;
    private LayerPositionalProperties layerPositionalProperties;
    private final LayoutNode layoutNode;
    private MutableObjectIntMap<AlignmentLine> oldAlignmentLines;
    private boolean released;
    private boolean wasLayerBlockInvoked;
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
            LayoutNode layoutNode = nodeCoordinator.getLayoutNode();
            try {
                if (nodeCoordinator.isValidOwnerScope()) {
                    NodeCoordinator.updateLayerParameters$default(nodeCoordinator, false, 1, null);
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                layoutNode.rethrowWithComposeStackTrace(th);
                throw new KotlinNothingValueException();
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
    private static final float[] tmpMatrix = Matrix.m5592constructorimpl$default(null, 1, null);
    private static final HitTestSource PointerInputSource = new HitTestSource() { // from class: androidx.compose.ui.node.NodeCoordinator$Companion$PointerInputSource$1
        @Override // androidx.compose.ui.node.NodeCoordinator.HitTestSource
        public boolean shouldHitTestChildren(LayoutNode layoutNode) {
            return true;
        }

        @Override // androidx.compose.ui.node.NodeCoordinator.HitTestSource
        /* renamed from: childHitTest-qzLsGqo  reason: not valid java name */
        public void mo7130childHitTestqzLsGqo(LayoutNode layoutNode, long j, HitTestResult hitTestResult, int i, boolean z) {
            layoutNode.m7045hitTest6fMxITs$ui(j, hitTestResult, i, z);
        }

        @Override // androidx.compose.ui.node.NodeCoordinator.HitTestSource
        public boolean shareWithSiblings(HitTestResult hitTestResult, LayoutNode layoutNode) {
            if (layoutNode.getOuterCoordinator$ui().shouldSharePointerInputWithSiblings()) {
                hitTestResult.acceptHits();
                return true;
            }
            return false;
        }

        @Override // androidx.compose.ui.node.NodeCoordinator.HitTestSource
        /* renamed from: entityType-OLwlOKw  reason: not valid java name */
        public int mo7131entityTypeOLwlOKw() {
            return NodeKind.m7135constructorimpl(16);
        }

        @Override // androidx.compose.ui.node.NodeCoordinator.HitTestSource
        public boolean interceptOutOfBoundsChildEvents(Modifier.Node node) {
            int m7135constructorimpl = NodeKind.m7135constructorimpl(16);
            MutableVector mutableVector = null;
            while (node != null) {
                if (node instanceof PointerInputModifierNode) {
                    if (((PointerInputModifierNode) node).interceptOutOfBoundsChildEvents()) {
                        return true;
                    }
                } else if ((node.getKindSet$ui() & m7135constructorimpl) != 0 && (node instanceof DelegatingNode)) {
                    int i = 0;
                    for (Modifier.Node delegate$ui = ((DelegatingNode) node).getDelegate$ui(); delegate$ui != null; delegate$ui = delegate$ui.getChild$ui()) {
                        if ((delegate$ui.getKindSet$ui() & m7135constructorimpl) != 0) {
                            i++;
                            if (i == 1) {
                                node = delegate$ui;
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
                                    mutableVector.add(delegate$ui);
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
        public boolean shareWithSiblings(HitTestResult hitTestResult, LayoutNode layoutNode) {
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
        public void mo7130childHitTestqzLsGqo(LayoutNode layoutNode, long j, HitTestResult hitTestResult, int i, boolean z) {
            layoutNode.m7046hitTestSemantics6fMxITs$ui(j, hitTestResult, i, z);
        }

        @Override // androidx.compose.ui.node.NodeCoordinator.HitTestSource
        public boolean shouldHitTest(Modifier.Node node) {
            if (ComposeUiFlags.isSkipNonImportantSemanticsNodesHitTestEnabled) {
                return SemanticsOwnerKt.isImportantForAccessibility(SemanticsNodeKt.SemanticsNode(DelegatableNodeKt.requireLayoutNode(node), false));
            }
            return true;
        }

        @Override // androidx.compose.ui.node.NodeCoordinator.HitTestSource
        /* renamed from: entityType-OLwlOKw */
        public int mo7131entityTypeOLwlOKw() {
            return NodeKind.m7135constructorimpl(8);
        }
    };
    private Density layerDensity = getLayoutNode().getDensity();
    private LayoutDirection layerLayoutDirection = getLayoutNode().getLayoutDirection();
    private float lastLayerAlpha = 0.8f;
    private long position = IntOffset.Companion.m8299getZeronOccac();
    private Shape lastShape = RectangleShapeKt.getRectangleShape();
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
            NodeCoordinator wrappedBy$ui = NodeCoordinator.this.getWrappedBy$ui();
            if (wrappedBy$ui != null) {
                wrappedBy$ui.invalidateLayer();
            }
        }
    };

    /* compiled from: NodeCoordinator.kt */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b`\u0018\u00002\u00020\u0001J\u0013\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH&J7\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0007H&¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\fH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u001cÀ\u0006\u0001"}, d2 = {"Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;", "", "entityType", "Landroidx/compose/ui/node/NodeKind;", "entityType-OLwlOKw", "()I", "interceptOutOfBoundsChildEvents", "", "node", "Landroidx/compose/ui/Modifier$Node;", "shouldHitTestChildren", "parentLayoutNode", "Landroidx/compose/ui/node/LayoutNode;", "childHitTest", "", "layoutNode", "pointerPosition", "Landroidx/compose/ui/geometry/Offset;", "hitTestResult", "Landroidx/compose/ui/node/HitTestResult;", "pointerType", "Landroidx/compose/ui/input/pointer/PointerType;", "isInLayer", "childHitTest-qzLsGqo", "(Landroidx/compose/ui/node/LayoutNode;JLandroidx/compose/ui/node/HitTestResult;IZ)V", "shouldHitTest", "shareWithSiblings", "child", "ui"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public interface HitTestSource {
        /* renamed from: childHitTest-qzLsGqo */
        void mo7130childHitTestqzLsGqo(LayoutNode layoutNode, long j, HitTestResult hitTestResult, int i, boolean z);

        /* renamed from: entityType-OLwlOKw */
        int mo7131entityTypeOLwlOKw();

        boolean interceptOutOfBoundsChildEvents(Modifier.Node node);

        boolean shareWithSiblings(HitTestResult hitTestResult, LayoutNode layoutNode);

        default boolean shouldHitTest(Modifier.Node node) {
            return true;
        }

        boolean shouldHitTestChildren(LayoutNode layoutNode);
    }

    public abstract void ensureLookaheadDelegateCreated();

    public abstract LookaheadDelegate getLookaheadDelegate();

    public abstract Modifier.Node getTail();

    protected abstract void setLookaheadDelegate(LookaheadDelegate lookaheadDelegate);

    public NodeCoordinator(LayoutNode layoutNode) {
        this.layoutNode = layoutNode;
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable, androidx.compose.ui.node.MeasureScopeWithLayoutNode
    public LayoutNode getLayoutNode() {
        return this.layoutNode;
    }

    public final boolean getForcePlaceWithLookaheadOffset$ui() {
        return this.forcePlaceWithLookaheadOffset;
    }

    public final void setForcePlaceWithLookaheadOffset$ui(boolean z) {
        this.forcePlaceWithLookaheadOffset = z;
    }

    public final boolean getForceMeasureWithLookaheadConstraints$ui() {
        return this.forceMeasureWithLookaheadConstraints;
    }

    public final void setForceMeasureWithLookaheadConstraints$ui(boolean z) {
        this.forceMeasureWithLookaheadConstraints = z;
    }

    public final NodeCoordinator getWrapped$ui() {
        return this.wrapped;
    }

    public final void setWrapped$ui(NodeCoordinator nodeCoordinator) {
        this.wrapped = nodeCoordinator;
    }

    public final NodeCoordinator getWrappedBy$ui() {
        return this.wrappedBy;
    }

    public final void setWrappedBy$ui(NodeCoordinator nodeCoordinator) {
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
        if (getLayoutNode().getOuterCoordinator$ui() == this) {
            return getLayoutNode().getNodes$ui().getHead$ui();
        }
        NodeCoordinator nodeCoordinator = this.wrappedBy;
        if (!z) {
            if (nodeCoordinator != null) {
                return nodeCoordinator.getTail();
            }
            return null;
        } else if (nodeCoordinator == null || (tail = nodeCoordinator.getTail()) == null) {
            return null;
        } else {
            return tail.getChild$ui();
        }
    }

    public final void visitNodes(int i, boolean z, Function1<? super Modifier.Node, Unit> function1) {
        Modifier.Node tail = getTail();
        if (!z && (tail = tail.getParent$ui()) == null) {
            return;
        }
        for (Modifier.Node headNode = headNode(z); headNode != null && (headNode.getAggregateChildKindSet$ui() & i) != 0; headNode = headNode.getChild$ui()) {
            if ((headNode.getKindSet$ui() & i) != 0) {
                function1.invoke(headNode);
            }
            if (headNode == tail) {
                return;
            }
        }
    }

    /* renamed from: visitNodes-aLcG6gQ */
    public final /* synthetic */ <T> void m7128visitNodesaLcG6gQ(int i, Function1<? super T, Unit> function1) {
        boolean m7144getIncludeSelfInTraversalH91voCI = NodeKindKt.m7144getIncludeSelfInTraversalH91voCI(i);
        Modifier.Node tail = getTail();
        if (!m7144getIncludeSelfInTraversalH91voCI && (tail = tail.getParent$ui()) == null) {
            return;
        }
        for (Modifier.Node headNode = headNode(m7144getIncludeSelfInTraversalH91voCI); headNode != null && (headNode.getAggregateChildKindSet$ui() & i) != 0; headNode = headNode.getChild$ui()) {
            if ((headNode.getKindSet$ui() & i) != 0) {
                Modifier.Node node = headNode;
                MutableVector mutableVector = null;
                while (node != null) {
                    Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
                    if (node instanceof Object) {
                        function1.invoke(node);
                    } else if ((node.getKindSet$ui() & i) != 0 && (node instanceof DelegatingNode)) {
                        int i2 = 0;
                        for (Modifier.Node delegate$ui = ((DelegatingNode) node).getDelegate$ui(); delegate$ui != null; delegate$ui = delegate$ui.getChild$ui()) {
                            if ((delegate$ui.getKindSet$ui() & i) != 0) {
                                i2++;
                                if (i2 == 1) {
                                    node = delegate$ui;
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
                                        mutableVector.add(delegate$ui);
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
    private final boolean m7104hasNodeH91voCI(int i) {
        Modifier.Node headNode = headNode(NodeKindKt.m7144getIncludeSelfInTraversalH91voCI(i));
        return headNode != null && DelegatableNodeKt.m6988has64DMado(headNode, i);
    }

    /* renamed from: head-H91voCI */
    public final Modifier.Node m7121headH91voCI(int i) {
        boolean m7144getIncludeSelfInTraversalH91voCI = NodeKindKt.m7144getIncludeSelfInTraversalH91voCI(i);
        Modifier.Node tail = getTail();
        if (!m7144getIncludeSelfInTraversalH91voCI && (tail = tail.getParent$ui()) == null) {
            return null;
        }
        for (Modifier.Node headNode = headNode(m7144getIncludeSelfInTraversalH91voCI); headNode != null && (headNode.getAggregateChildKindSet$ui() & i) != 0; headNode = headNode.getChild$ui()) {
            if ((headNode.getKindSet$ui() & i) != 0) {
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
    public final long mo6826getSizeYbymL2g() {
        return m6879getMeasuredSizeYbymL2g();
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
        return getLayoutNode().getLayoutDelegate$ui().getAlignmentLinesOwner$ui();
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public LookaheadCapablePlaceable getChild() {
        return this.wrapped;
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public void replace$ui() {
        GraphicsLayer graphicsLayer = this.explicitLayer;
        if (graphicsLayer != null) {
            mo6881placeAtf8xVGno(mo7063getPositionnOccac(), this.zIndex, graphicsLayer);
        } else {
            mo6819placeAtf8xVGno(mo7063getPositionnOccac(), this.zIndex, this.layerBlock);
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
    public MeasureResult getMeasureResult$ui() {
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
    public void setMeasureResult$ui(MeasureResult measureResult) {
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
        Set asSet;
        MutableScatterSet mutableScatterSet = null;
        while (this != null) {
            MeasureResult measureResult = this._measureResult;
            Map<AlignmentLine, Integer> alignmentLines = measureResult != null ? measureResult.getAlignmentLines() : null;
            if (alignmentLines != null && (!alignmentLines.isEmpty())) {
                if (mutableScatterSet == null) {
                    mutableScatterSet = ScatterSetKt.mutableScatterSetOf();
                }
                mutableScatterSet.addAll(alignmentLines.keySet());
            }
            this = this.wrapped;
        }
        return (mutableScatterSet == null || (asSet = mutableScatterSet.asSet()) == null) ? SetsKt.emptySet() : asSet;
    }

    protected void onMeasureResultChanged(int i, int i2) {
        NodeCoordinator nodeCoordinator;
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            ownedLayer.mo7197resizeozmzZPI(IntSize.m8326constructorimpl((i << 32) | (i2 & 4294967295L)));
        } else if (getLayoutNode().isPlaced() && (nodeCoordinator = this.wrappedBy) != null) {
            nodeCoordinator.invalidateLayer();
        }
        m6882setMeasuredSizeozmzZPI(IntSize.m8326constructorimpl((i2 & 4294967295L) | (i << 32)));
        if (this.layerBlock != null) {
            updateLayerParameters(false);
        }
        int m7135constructorimpl = NodeKind.m7135constructorimpl(4);
        boolean m7144getIncludeSelfInTraversalH91voCI = NodeKindKt.m7144getIncludeSelfInTraversalH91voCI(m7135constructorimpl);
        Modifier.Node tail = getTail();
        if (m7144getIncludeSelfInTraversalH91voCI || (tail = tail.getParent$ui()) != null) {
            for (Modifier.Node headNode = headNode(m7144getIncludeSelfInTraversalH91voCI); headNode != null && (headNode.getAggregateChildKindSet$ui() & m7135constructorimpl) != 0; headNode = headNode.getChild$ui()) {
                if ((headNode.getKindSet$ui() & m7135constructorimpl) != 0) {
                    Modifier.Node node = headNode;
                    MutableVector mutableVector = null;
                    while (node != null) {
                        if (node instanceof DrawModifierNode) {
                            ((DrawModifierNode) node).onMeasureResultChanged();
                        } else if ((node.getKindSet$ui() & m7135constructorimpl) != 0 && (node instanceof DelegatingNode)) {
                            int i3 = 0;
                            for (Modifier.Node delegate$ui = ((DelegatingNode) node).getDelegate$ui(); delegate$ui != null; delegate$ui = delegate$ui.getChild$ui()) {
                                if ((delegate$ui.getKindSet$ui() & m7135constructorimpl) != 0) {
                                    i3++;
                                    if (i3 == 1) {
                                        node = delegate$ui;
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
                                            mutableVector.add(delegate$ui);
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
        Owner owner$ui = getLayoutNode().getOwner$ui();
        if (owner$ui != null) {
            owner$ui.onLayoutChange(getLayoutNode());
        }
        getLayoutNode().onCoordinatorRectChanged$ui(this);
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    /* renamed from: getPosition-nOcc-ac */
    public long mo7063getPositionnOccac() {
        return this.position;
    }

    /* renamed from: setPosition--gyyYBs */
    protected void m7126setPositiongyyYBs(long j) {
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
        if (getLayoutNode().getNodes$ui().m7095hasH91voCI$ui(NodeKind.m7135constructorimpl(64))) {
            getTail();
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            for (Modifier.Node tail$ui = getLayoutNode().getNodes$ui().getTail$ui(); tail$ui != null; tail$ui = tail$ui.getParent$ui()) {
                if ((NodeKind.m7135constructorimpl(64) & tail$ui.getKindSet$ui()) != 0) {
                    int m7135constructorimpl = NodeKind.m7135constructorimpl(64);
                    MutableVector mutableVector = null;
                    Modifier.Node node = tail$ui;
                    while (node != null) {
                        if (node instanceof ParentDataModifierNode) {
                            objectRef.element = ((ParentDataModifierNode) node).modifyParentData(getLayoutNode().getDensity(), objectRef.element);
                        } else if ((node.getKindSet$ui() & m7135constructorimpl) != 0 && (node instanceof DelegatingNode)) {
                            int i = 0;
                            for (Modifier.Node delegate$ui = ((DelegatingNode) node).getDelegate$ui(); delegate$ui != null; delegate$ui = delegate$ui.getChild$ui()) {
                                if ((delegate$ui.getKindSet$ui() & m7135constructorimpl) != 0) {
                                    i++;
                                    if (i == 1) {
                                        node = delegate$ui;
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
                                            mutableVector.add(delegate$ui);
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

    public final void onCoordinatesUsed$ui() {
        getLayoutNode().getLayoutDelegate$ui().onCoordinatesUsed();
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public final LayoutCoordinates getParentLayoutCoordinates() {
        if (!isAttached()) {
            StringBuilder sb = new StringBuilder(ExpectAttachedLayoutCoordinates);
            for (LayoutNode layoutNode = getLayoutNode(); layoutNode != null; layoutNode = layoutNode.getParent$ui()) {
                sb.append("\n|");
                sb.append(layoutNode);
                sb.append(" isAttached=");
                sb.append(layoutNode.isAttached());
                sb.append(" modifier=");
                sb.append(layoutNode.getModifier());
                sb.append(" tail=");
                sb.append(getTail());
            }
            InlineClassHelperKt.throwIllegalStateException(sb.toString());
        }
        onCoordinatesUsed$ui();
        return getLayoutNode().getOuterCoordinator$ui().wrappedBy;
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public final LayoutCoordinates getParentCoordinates() {
        if (!isAttached()) {
            InlineClassHelperKt.throwIllegalStateException(ExpectAttachedLayoutCoordinates);
        }
        onCoordinatesUsed$ui();
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

    /* renamed from: getLastMeasurementConstraints-msEJaDk$ui */
    public final long m7119getLastMeasurementConstraintsmsEJaDk$ui() {
        return m6880getMeasurementConstraintsmsEJaDk();
    }

    public final Shape getLastShape$ui() {
        return this.lastShape;
    }

    public final void setLastShape$ui(Shape shape) {
        this.lastShape = shape;
    }

    public final boolean getLastClip$ui() {
        return this.lastClip;
    }

    public final void setLastClip$ui(boolean z) {
        this.lastClip = z;
    }

    public final boolean getWasLayerBlockInvoked$ui() {
        return this.wasLayerBlockInvoked;
    }

    public final void setWasLayerBlockInvoked$ui(boolean z) {
        this.wasLayerBlockInvoked = z;
    }

    /* renamed from: performingMeasure-K40F9xA */
    protected final Placeable m7124performingMeasureK40F9xA(long j, Function0<? extends Placeable> function0) {
        m6883setMeasurementConstraintsBRTryo0(j);
        return function0.invoke();
    }

    @Override // androidx.compose.ui.layout.Placeable
    /* renamed from: placeAt-f8xVGno */
    public void mo6819placeAtf8xVGno(long j, float f, Function1<? super GraphicsLayerScope, Unit> function1) {
        if (this.forcePlaceWithLookaheadOffset) {
            LookaheadDelegate lookaheadDelegate = getLookaheadDelegate();
            Intrinsics.checkNotNull(lookaheadDelegate);
            m7110placeSelfMLgxB_4(lookaheadDelegate.mo7063getPositionnOccac(), f, function1, null);
            return;
        }
        m7110placeSelfMLgxB_4(j, f, function1, null);
    }

    @Override // androidx.compose.ui.layout.Placeable
    /* renamed from: placeAt-f8xVGno */
    public void mo6881placeAtf8xVGno(long j, float f, GraphicsLayer graphicsLayer) {
        if (this.forcePlaceWithLookaheadOffset) {
            LookaheadDelegate lookaheadDelegate = getLookaheadDelegate();
            Intrinsics.checkNotNull(lookaheadDelegate);
            m7110placeSelfMLgxB_4(lookaheadDelegate.mo7063getPositionnOccac(), f, null, graphicsLayer);
            return;
        }
        m7110placeSelfMLgxB_4(j, f, null, graphicsLayer);
    }

    /* renamed from: placeSelf-MLgxB_4 */
    private final void m7110placeSelfMLgxB_4(long j, float f, Function1<? super GraphicsLayerScope, Unit> function1, GraphicsLayer graphicsLayer) {
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
                OwnedLayer createLayer = LayoutNodeKt.requireOwner(getLayoutNode()).createLayer(getDrawBlock(), this.invalidateParentLayer, graphicsLayer);
                createLayer.mo7197resizeozmzZPI(m6879getMeasuredSizeYbymL2g());
                createLayer.mo7196movegyyYBs(j);
                this.layer = createLayer;
                getLayoutNode().setInnerLayerCoordinatorIsDirty$ui(true);
                this.invalidateParentLayer.invoke();
            }
        } else {
            if (this.explicitLayer != null) {
                this.explicitLayer = null;
                updateLayerBlock$default(this, null, false, 2, null);
            }
            updateLayerBlock$default(this, function1, false, 2, null);
        }
        if (!IntOffset.m8287equalsimpl0(mo7063getPositionnOccac(), j)) {
            LayoutNodeKt.requireOwner(getLayoutNode()).voteFrameRate(FrameRateCategory.Companion.m4780getHighNSsRyOo());
            m7126setPositiongyyYBs(j);
            OwnedLayer ownedLayer = this.layer;
            if (ownedLayer != null) {
                ownedLayer.mo7196movegyyYBs(j);
            } else {
                NodeCoordinator nodeCoordinator = this.wrappedBy;
                if (nodeCoordinator != null) {
                    nodeCoordinator.invalidateLayer();
                }
            }
            getLayoutNode().onCoordinatorRectChanged$ui(this);
            invalidateAlignmentLinesFromPositionChange(this);
            Owner owner$ui = getLayoutNode().getOwner$ui();
            if (owner$ui != null) {
                owner$ui.onLayoutChange(getLayoutNode());
            }
        }
        this.zIndex = f;
        if (this == getLayoutNode().getOuterCoordinator$ui()) {
            LayoutNodeKt.requireOwner(getLayoutNode()).getRectManager().recalculateRectIfDirty(getLayoutNode());
        }
        if (isPlacingForAlignment$ui()) {
            return;
        }
        captureRulersIfNeeded$ui(getMeasureResult$ui());
    }

    public final void releaseLayer() {
        if (this.layer != null) {
            if (this.explicitLayer != null) {
                this.explicitLayer = null;
            }
            updateLayerBlock$default(this, null, false, 2, null);
            LayoutNode.requestRelayout$ui$default(getLayoutNode(), false, 1, null);
        }
    }

    /* renamed from: placeSelfApparentToRealOffset-MLgxB_4 */
    public final void m7125placeSelfApparentToRealOffsetMLgxB_4(long j, float f, Function1<? super GraphicsLayerScope, Unit> function1, GraphicsLayer graphicsLayer) {
        m7110placeSelfMLgxB_4(IntOffset.m8292plusqkQi6aY(j, m6878getApparentToRealOffsetnOccac()), f, function1, graphicsLayer);
    }

    public final void draw(Canvas canvas, GraphicsLayer graphicsLayer) {
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            ownedLayer.drawLayer(canvas, graphicsLayer);
            return;
        }
        float m8288getXimpl = IntOffset.m8288getXimpl(mo7063getPositionnOccac());
        float m8289getYimpl = IntOffset.m8289getYimpl(mo7063getPositionnOccac());
        canvas.translate(m8288getXimpl, m8289getYimpl);
        drawContainedDrawModifiers(canvas, graphicsLayer);
        canvas.translate(-m8288getXimpl, -m8289getYimpl);
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
                    boolean isPlaced = NodeCoordinator.this.getLayoutNode().isPlaced();
                    NodeCoordinator nodeCoordinator = NodeCoordinator.this;
                    if (isPlaced) {
                        nodeCoordinator.drawBlockCanvas = canvas;
                        NodeCoordinator.this.drawBlockParentLayer = graphicsLayer;
                        snapshotObserver = NodeCoordinator.this.getSnapshotObserver();
                        function1 = NodeCoordinator.onCommitAffectingLayer;
                        Function0<Unit> function02 = function0;
                        snapshotObserver.observer.observeReads(NodeCoordinator.this, function1, function02);
                        NodeCoordinator.this.lastLayerDrawingWasSkipped = false;
                        return;
                    }
                    nodeCoordinator.lastLayerDrawingWasSkipped = true;
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
        Owner owner$ui;
        if (!(function1 == null || this.explicitLayer == null)) {
            InlineClassHelperKt.throwIllegalArgumentException("layerBlock can't be provided when explicitLayer is provided");
        }
        LayoutNode layoutNode = getLayoutNode();
        boolean z2 = (!z && this.layerBlock == function1 && Intrinsics.areEqual(this.layerDensity, layoutNode.getDensity()) && this.layerLayoutDirection == layoutNode.getLayoutDirection()) ? false : true;
        this.layerDensity = layoutNode.getDensity();
        this.layerLayoutDirection = layoutNode.getLayoutDirection();
        if (layoutNode.isAttached() && function1 != null) {
            this.layerBlock = function1;
            if (this.layer != null) {
                if (z2) {
                    updateLayerParameters$default(this, false, 1, null);
                    return;
                }
                return;
            }
            OwnedLayer createLayer$default = Owner.createLayer$default(LayoutNodeKt.requireOwner(layoutNode), getDrawBlock(), this.invalidateParentLayer, null, 4, null);
            createLayer$default.mo7197resizeozmzZPI(m6879getMeasuredSizeYbymL2g());
            createLayer$default.mo7196movegyyYBs(mo7063getPositionnOccac());
            this.layer = createLayer$default;
            updateLayerParameters$default(this, false, 1, null);
            layoutNode.setInnerLayerCoordinatorIsDirty$ui(true);
            this.invalidateParentLayer.invoke();
            return;
        }
        this.layerBlock = null;
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            if (!MatrixKt.m5617isIdentity58bKbWc(ownedLayer.mo7192getUnderlyingMatrixsQKQjiQ())) {
                layoutNode.onCoordinatorRectChanged$ui(this);
            }
            ownedLayer.destroy();
            this.layer = null;
            layoutNode.setInnerLayerCoordinatorIsDirty$ui(true);
            this.invalidateParentLayer.invoke();
            if (isAttached() && layoutNode.isPlaced() && (owner$ui = layoutNode.getOwner$ui()) != null) {
                owner$ui.onLayoutChange(layoutNode);
            }
        }
        this.lastLayerDrawingWasSkipped = false;
    }

    public static /* synthetic */ void updateLayerParameters$default(NodeCoordinator nodeCoordinator, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateLayerParameters");
        }
        if ((i & 1) != 0) {
            z = true;
        }
        nodeCoordinator.updateLayerParameters(z);
    }

    private final void updateLayerParameters(boolean z) {
        Owner owner$ui;
        if (this.explicitLayer != null) {
            return;
        }
        OwnedLayer ownedLayer = this.layer;
        final Function1<? super GraphicsLayerScope, Unit> function1 = this.layerBlock;
        if (ownedLayer == null) {
            if (function1 == null) {
                return;
            }
            InlineClassHelperKt.throwIllegalStateException("null layer with a non-null layerBlock");
        } else if (function1 != null) {
            ReusableGraphicsLayerScope reusableGraphicsLayerScope = graphicsLayerScope;
            reusableGraphicsLayerScope.reset();
            reusableGraphicsLayerScope.setGraphicsDensity$ui(getLayoutNode().getDensity());
            reusableGraphicsLayerScope.setLayoutDirection$ui(getLayoutNode().getLayoutDirection());
            reusableGraphicsLayerScope.m5676setSizeuvyYCjk(IntSizeKt.m8343toSizeozmzZPI(mo6826getSizeYbymL2g()));
            getSnapshotObserver().observer.observeReads(this, onCommitAffectingLayerParams, new Function0<Unit>() { // from class: androidx.compose.ui.node.NodeCoordinator$updateLayerParameters$1
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
                    ReusableGraphicsLayerScope reusableGraphicsLayerScope4;
                    ReusableGraphicsLayerScope reusableGraphicsLayerScope5;
                    ReusableGraphicsLayerScope reusableGraphicsLayerScope6;
                    ReusableGraphicsLayerScope reusableGraphicsLayerScope7;
                    Function1<GraphicsLayerScope, Unit> function12 = function1;
                    reusableGraphicsLayerScope2 = NodeCoordinator.graphicsLayerScope;
                    function12.invoke(reusableGraphicsLayerScope2);
                    Shape lastShape$ui = this.getLastShape$ui();
                    reusableGraphicsLayerScope3 = NodeCoordinator.graphicsLayerScope;
                    boolean areEqual = Intrinsics.areEqual(lastShape$ui, reusableGraphicsLayerScope3.getShape());
                    boolean lastClip$ui = this.getLastClip$ui();
                    reusableGraphicsLayerScope4 = NodeCoordinator.graphicsLayerScope;
                    boolean z2 = lastClip$ui != reusableGraphicsLayerScope4.getClip();
                    if (!areEqual || z2) {
                        NodeCoordinator nodeCoordinator = this;
                        reusableGraphicsLayerScope5 = NodeCoordinator.graphicsLayerScope;
                        nodeCoordinator.setLastShape$ui(reusableGraphicsLayerScope5.getShape());
                        NodeCoordinator nodeCoordinator2 = this;
                        reusableGraphicsLayerScope6 = NodeCoordinator.graphicsLayerScope;
                        nodeCoordinator2.setLastClip$ui(reusableGraphicsLayerScope6.getClip());
                        if (this.getWasLayerBlockInvoked$ui() && (z2 || (this.getLastClip$ui() && !areEqual))) {
                            this.getLayoutNode().invalidateSemantics$ui();
                        }
                    }
                    this.setWasLayerBlockInvoked$ui(true);
                    reusableGraphicsLayerScope7 = NodeCoordinator.graphicsLayerScope;
                    reusableGraphicsLayerScope7.updateOutline$ui();
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
            if (z && ((!hasSameValuesAs || z2 != this.isClipping) && (owner$ui = getLayoutNode().getOwner$ui()) != null)) {
                owner$ui.onLayoutChange(getLayoutNode());
            }
            if (hasSameValuesAs) {
                return;
            }
            LayoutNode layoutNode = getLayoutNode();
            layoutNode.onCoordinatorRectChanged$ui(this);
            if (layoutNode.getGloballyPositionedObservers() > 0) {
                LayoutNodeKt.requireOwner(layoutNode).requestOnPositionedCallback(layoutNode);
            }
        } else {
            InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("updateLayerParameters requires a non-null layerBlock");
            throw new KotlinNothingValueException();
        }
    }

    public final boolean getLastLayerDrawingWasSkipped$ui() {
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
    public final long m7120getMinimumTouchTargetSizeNHjbRc() {
        return this.layerDensity.mo435toSizeXkaWNTQ(getLayoutNode().getViewConfiguration().mo7050getMinimumTouchTargetSizeMYxV2XQ());
    }

    /* renamed from: hitTest-qzLsGqo */
    public final void m7122hitTestqzLsGqo(HitTestSource hitTestSource, long j, HitTestResult hitTestResult, int i, boolean z) {
        boolean z2;
        Modifier.Node m7121headH91voCI = m7121headH91voCI(hitTestSource.mo7131entityTypeOLwlOKw());
        boolean z3 = false;
        if (!m7129withinLayerBoundsk4lQ0M(j)) {
            if (PointerType.m6758equalsimpl0(i, PointerType.Companion.m6765getTouchT8wyACA())) {
                float m7117distanceInMinimumTouchTargettz77jQw = m7117distanceInMinimumTouchTargettz77jQw(j, m7120getMinimumTouchTargetSizeNHjbRc());
                if ((Float.floatToRawIntBits(m7117distanceInMinimumTouchTargettz77jQw) & Integer.MAX_VALUE) >= 2139095040 || !hitTestResult.isHitInMinimumTouchTargetBetter(m7117distanceInMinimumTouchTargettz77jQw, false)) {
                    return;
                }
                m7106hitNearFh5PU_I(m7121headH91voCI, hitTestSource, j, hitTestResult, i, false, m7117distanceInMinimumTouchTargettz77jQw);
            }
        } else if (m7121headH91voCI == null) {
            mo7036hitTestChildqzLsGqo(hitTestSource, j, hitTestResult, i, z);
        } else if (m7123isPointerInBoundsk4lQ0M(j)) {
            m7105hit5ShdDok(m7121headH91voCI, hitTestSource, j, hitTestResult, i, z);
        } else {
            float m7117distanceInMinimumTouchTargettz77jQw2 = !PointerType.m6758equalsimpl0(i, PointerType.Companion.m6765getTouchT8wyACA()) ? Float.POSITIVE_INFINITY : m7117distanceInMinimumTouchTargettz77jQw(j, m7120getMinimumTouchTargetSizeNHjbRc());
            if ((Float.floatToRawIntBits(m7117distanceInMinimumTouchTargettz77jQw2) & Integer.MAX_VALUE) < 2139095040) {
                z2 = z;
                if (hitTestResult.isHitInMinimumTouchTargetBetter(m7117distanceInMinimumTouchTargettz77jQw2, z2)) {
                    z3 = true;
                }
            } else {
                z2 = z;
            }
            m7109outOfBoundsHit8NAm7pk(m7121headH91voCI, hitTestSource, j, hitTestResult, i, z2, m7117distanceInMinimumTouchTargettz77jQw2, z3);
        }
    }

    /* renamed from: hit-5ShdDok */
    private final void m7105hit5ShdDok(Modifier.Node node, HitTestSource hitTestSource, long j, HitTestResult hitTestResult, int i, boolean z) {
        long DistanceAndFlags;
        Modifier.Node m7133nextUntilhw7D004;
        Modifier.Node m7133nextUntilhw7D0042;
        if (node == null) {
            mo7036hitTestChildqzLsGqo(hitTestSource, j, hitTestResult, i, z);
        } else if (!hitTestSource.shouldHitTest(node)) {
            m7133nextUntilhw7D0042 = NodeCoordinatorKt.m7133nextUntilhw7D004(node, hitTestSource.mo7131entityTypeOLwlOKw(), NodeKind.m7135constructorimpl(2));
            m7105hit5ShdDok(m7133nextUntilhw7D0042, hitTestSource, j, hitTestResult, i, z);
        } else {
            int i2 = hitTestResult.hitDepth;
            hitTestResult.removeNodesInRange(hitTestResult.hitDepth + 1, hitTestResult.size());
            hitTestResult.hitDepth++;
            hitTestResult.values.add(node);
            MutableLongList mutableLongList = hitTestResult.distanceFromEdgeAndFlags;
            DistanceAndFlags = HitTestResultKt.DistanceAndFlags(-1.0f, z, false);
            mutableLongList.add(DistanceAndFlags);
            m7133nextUntilhw7D004 = NodeCoordinatorKt.m7133nextUntilhw7D004(node, hitTestSource.mo7131entityTypeOLwlOKw(), NodeKind.m7135constructorimpl(2));
            m7105hit5ShdDok(m7133nextUntilhw7D004, hitTestSource, j, hitTestResult, i, z);
            hitTestResult.hitDepth = i2;
        }
    }

    /* renamed from: outOfBoundsHit-8NAm7pk */
    public final void m7109outOfBoundsHit8NAm7pk(final Modifier.Node node, final HitTestSource hitTestSource, final long j, final HitTestResult hitTestResult, final int i, final boolean z, final float f, final boolean z2) {
        Modifier.Node m7133nextUntilhw7D004;
        if (node == null) {
            mo7036hitTestChildqzLsGqo(hitTestSource, j, hitTestResult, i, z);
        } else if (!hitTestSource.shouldHitTest(node)) {
            m7133nextUntilhw7D004 = NodeCoordinatorKt.m7133nextUntilhw7D004(node, hitTestSource.mo7131entityTypeOLwlOKw(), NodeKind.m7135constructorimpl(2));
            m7109outOfBoundsHit8NAm7pk(m7133nextUntilhw7D004, hitTestSource, j, hitTestResult, i, z, f, z2);
        } else if (m7107isInExpandedTouchBoundsThDn1k(node, j, i)) {
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
                    Modifier.Node m7133nextUntilhw7D0042;
                    NodeCoordinator nodeCoordinator = NodeCoordinator.this;
                    m7133nextUntilhw7D0042 = NodeCoordinatorKt.m7133nextUntilhw7D004(node, hitTestSource.mo7131entityTypeOLwlOKw(), NodeKind.m7135constructorimpl(2));
                    nodeCoordinator.m7109outOfBoundsHit8NAm7pk(m7133nextUntilhw7D0042, hitTestSource, j, hitTestResult, i, z, f, z2);
                }
            });
        } else if (z2) {
            m7106hitNearFh5PU_I(node, hitTestSource, j, hitTestResult, i, z, f);
        } else {
            m7111speculativeHitFh5PU_I(node, hitTestSource, j, hitTestResult, i, z, f);
        }
    }

    /* renamed from: hitNear-Fh5PU_I */
    private final void m7106hitNearFh5PU_I(Modifier.Node node, HitTestSource hitTestSource, long j, HitTestResult hitTestResult, int i, boolean z, float f) {
        long DistanceAndFlags;
        Modifier.Node m7133nextUntilhw7D004;
        Modifier.Node m7133nextUntilhw7D0042;
        if (node == null) {
            mo7036hitTestChildqzLsGqo(hitTestSource, j, hitTestResult, i, z);
        } else if (!hitTestSource.shouldHitTest(node)) {
            m7133nextUntilhw7D0042 = NodeCoordinatorKt.m7133nextUntilhw7D004(node, hitTestSource.mo7131entityTypeOLwlOKw(), NodeKind.m7135constructorimpl(2));
            m7106hitNearFh5PU_I(m7133nextUntilhw7D0042, hitTestSource, j, hitTestResult, i, z, f);
        } else {
            int i2 = hitTestResult.hitDepth;
            hitTestResult.removeNodesInRange(hitTestResult.hitDepth + 1, hitTestResult.size());
            hitTestResult.hitDepth++;
            hitTestResult.values.add(node);
            MutableLongList mutableLongList = hitTestResult.distanceFromEdgeAndFlags;
            DistanceAndFlags = HitTestResultKt.DistanceAndFlags(f, z, false);
            mutableLongList.add(DistanceAndFlags);
            m7133nextUntilhw7D004 = NodeCoordinatorKt.m7133nextUntilhw7D004(node, hitTestSource.mo7131entityTypeOLwlOKw(), NodeKind.m7135constructorimpl(2));
            m7109outOfBoundsHit8NAm7pk(m7133nextUntilhw7D004, hitTestSource, j, hitTestResult, i, z, f, true);
            hitTestResult.hitDepth = i2;
        }
    }

    /* renamed from: speculativeHit-Fh5PU_I */
    private final void m7111speculativeHitFh5PU_I(final Modifier.Node node, final HitTestSource hitTestSource, final long j, final HitTestResult hitTestResult, final int i, final boolean z, final float f) {
        Modifier.Node m7133nextUntilhw7D004;
        Modifier.Node m7133nextUntilhw7D0042;
        if (node == null) {
            mo7036hitTestChildqzLsGqo(hitTestSource, j, hitTestResult, i, z);
        } else if (!hitTestSource.shouldHitTest(node)) {
            m7133nextUntilhw7D0042 = NodeCoordinatorKt.m7133nextUntilhw7D004(node, hitTestSource.mo7131entityTypeOLwlOKw(), NodeKind.m7135constructorimpl(2));
            m7111speculativeHitFh5PU_I(m7133nextUntilhw7D0042, hitTestSource, j, hitTestResult, i, z, f);
        } else if (!hitTestSource.interceptOutOfBoundsChildEvents(node)) {
            m7133nextUntilhw7D004 = NodeCoordinatorKt.m7133nextUntilhw7D004(node, hitTestSource.mo7131entityTypeOLwlOKw(), NodeKind.m7135constructorimpl(2));
            m7109outOfBoundsHit8NAm7pk(m7133nextUntilhw7D004, hitTestSource, j, hitTestResult, i, z, f, false);
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
                    Modifier.Node m7133nextUntilhw7D0043;
                    NodeCoordinator nodeCoordinator = NodeCoordinator.this;
                    m7133nextUntilhw7D0043 = NodeCoordinatorKt.m7133nextUntilhw7D004(node, hitTestSource.mo7131entityTypeOLwlOKw(), NodeKind.m7135constructorimpl(2));
                    nodeCoordinator.m7109outOfBoundsHit8NAm7pk(m7133nextUntilhw7D0043, hitTestSource, j, hitTestResult, i, z, f, false);
                }
            });
        }
    }

    /* renamed from: isInExpandedTouchBounds-ThD-n1k */
    private final boolean m7107isInExpandedTouchBoundsThDn1k(Modifier.Node node, long j, int i) {
        if (node == null) {
            return false;
        }
        if (PointerType.m6758equalsimpl0(i, PointerType.Companion.m6764getStylusT8wyACA()) || PointerType.m6758equalsimpl0(i, PointerType.Companion.m6762getEraserT8wyACA())) {
            int m7135constructorimpl = NodeKind.m7135constructorimpl(16);
            MutableVector mutableVector = null;
            while (node != null) {
                if (node instanceof PointerInputModifierNode) {
                    long mo1710getTouchBoundsExpansionRZrCHBk = ((PointerInputModifierNode) node).mo1710getTouchBoundsExpansionRZrCHBk();
                    int i2 = (int) (j >> 32);
                    if (Float.intBitsToFloat(i2) >= (-TouchBoundsExpansion.m7221computeLeftimpl$ui(mo1710getTouchBoundsExpansionRZrCHBk, getLayoutDirection())) && Float.intBitsToFloat(i2) < getMeasuredWidth() + TouchBoundsExpansion.m7222computeRightimpl$ui(mo1710getTouchBoundsExpansionRZrCHBk, getLayoutDirection())) {
                        int i3 = (int) (j & 4294967295L);
                        if (Float.intBitsToFloat(i3) >= (-TouchBoundsExpansion.m7229getTopimpl(mo1710getTouchBoundsExpansionRZrCHBk)) && Float.intBitsToFloat(i3) < getMeasuredHeight() + TouchBoundsExpansion.m7226getBottomimpl(mo1710getTouchBoundsExpansionRZrCHBk)) {
                            return true;
                        }
                    }
                    return false;
                }
                if ((node.getKindSet$ui() & m7135constructorimpl) != 0 && (node instanceof DelegatingNode)) {
                    int i4 = 0;
                    for (Modifier.Node delegate$ui = ((DelegatingNode) node).getDelegate$ui(); delegate$ui != null; delegate$ui = delegate$ui.getChild$ui()) {
                        if ((delegate$ui.getKindSet$ui() & m7135constructorimpl) != 0) {
                            i4++;
                            if (i4 == 1) {
                                node = delegate$ui;
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
                                    mutableVector.add(delegate$ui);
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
    public void mo7036hitTestChildqzLsGqo(HitTestSource hitTestSource, long j, HitTestResult hitTestResult, int i, boolean z) {
        NodeCoordinator nodeCoordinator = this.wrapped;
        if (nodeCoordinator != null) {
            nodeCoordinator.m7122hitTestqzLsGqo(hitTestSource, m7103fromParentPosition8S9VItk$default(nodeCoordinator, j, false, 2, null), hitTestResult, i, z);
        }
    }

    public final Rect touchBoundsInRoot() {
        if (!isAttached()) {
            return Rect.Companion.getZero();
        }
        LayoutCoordinates findRootCoordinates = LayoutCoordinatesKt.findRootCoordinates(this);
        MutableRect rectCache = getRectCache();
        long m7116calculateMinimumTouchTargetPaddingE7KxVPU = m7116calculateMinimumTouchTargetPaddingE7KxVPU(m7120getMinimumTouchTargetSizeNHjbRc());
        int i = (int) (m7116calculateMinimumTouchTargetPaddingE7KxVPU >> 32);
        rectCache.setLeft(-Float.intBitsToFloat(i));
        int i2 = (int) (m7116calculateMinimumTouchTargetPaddingE7KxVPU & 4294967295L);
        rectCache.setTop(-Float.intBitsToFloat(i2));
        rectCache.setRight(getMeasuredWidth() + Float.intBitsToFloat(i));
        rectCache.setBottom(getMeasuredHeight() + Float.intBitsToFloat(i2));
        while (this != findRootCoordinates) {
            this.rectInParent$ui(rectCache, false, true);
            if (rectCache.isEmpty()) {
                return Rect.Companion.getZero();
            }
            this = this.wrappedBy;
            Intrinsics.checkNotNull(this);
        }
        return MutableRectKt.toRect(rectCache);
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* renamed from: screenToLocal-MK-Hz9U */
    public long mo6832screenToLocalMKHz9U(long j) {
        if (!isAttached()) {
            InlineClassHelperKt.throwIllegalStateException(ExpectAttachedLayoutCoordinates);
        }
        return mo6827localPositionOfR5De75A(LayoutCoordinatesKt.findRootCoordinates(this), LayoutNodeKt.requireOwner(getLayoutNode()).mo6768screenToLocalMKHz9U(j));
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* renamed from: localToScreen-MK-Hz9U */
    public long mo6830localToScreenMKHz9U(long j) {
        if (!isAttached()) {
            InlineClassHelperKt.throwIllegalStateException(ExpectAttachedLayoutCoordinates);
        }
        return LayoutNodeKt.requireOwner(getLayoutNode()).mo6767localToScreenMKHz9U(mo6829localToRootMKHz9U(j));
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* renamed from: windowToLocal-MK-Hz9U */
    public long mo6835windowToLocalMKHz9U(long j) {
        if (!isAttached()) {
            InlineClassHelperKt.throwIllegalStateException(ExpectAttachedLayoutCoordinates);
        }
        LayoutCoordinates findRootCoordinates = LayoutCoordinatesKt.findRootCoordinates(this);
        return mo6827localPositionOfR5De75A(findRootCoordinates, Offset.m5107minusMKHz9U(LayoutNodeKt.requireOwner(getLayoutNode()).mo7199calculateLocalPositionMKHz9U(j), LayoutCoordinatesKt.positionInRoot(findRootCoordinates)));
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* renamed from: localToWindow-MK-Hz9U */
    public long mo6831localToWindowMKHz9U(long j) {
        return LayoutNodeKt.requireOwner(getLayoutNode()).mo7200calculatePositionInWindowMKHz9U(mo6829localToRootMKHz9U(j));
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
    public long mo6827localPositionOfR5De75A(LayoutCoordinates layoutCoordinates, long j) {
        return mo6828localPositionOfS_NoaFU(layoutCoordinates, j, true);
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* renamed from: localPositionOf-S_NoaFU */
    public long mo6828localPositionOfS_NoaFU(LayoutCoordinates layoutCoordinates, long j, boolean z) {
        if (layoutCoordinates instanceof LookaheadLayoutCoordinates) {
            LookaheadLayoutCoordinates lookaheadLayoutCoordinates = (LookaheadLayoutCoordinates) layoutCoordinates;
            lookaheadLayoutCoordinates.getCoordinator().onCoordinatesUsed$ui();
            return Offset.m5095constructorimpl(lookaheadLayoutCoordinates.mo6828localPositionOfS_NoaFU(this, Offset.m5095constructorimpl(j ^ (-9223372034707292160L)), z) ^ (-9223372034707292160L));
        }
        NodeCoordinator coordinator = toCoordinator(layoutCoordinates);
        coordinator.onCoordinatesUsed$ui();
        NodeCoordinator findCommonAncestor$ui = findCommonAncestor$ui(coordinator);
        while (coordinator != findCommonAncestor$ui) {
            j = coordinator.m7127toParentPosition8S9VItk(j, z);
            coordinator = coordinator.wrappedBy;
            Intrinsics.checkNotNull(coordinator);
        }
        return m7102ancestorToLocalS_NoaFU(findCommonAncestor$ui, j, z);
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* renamed from: transformFrom-EL8BTi8 */
    public void mo6833transformFromEL8BTi8(LayoutCoordinates layoutCoordinates, float[] fArr) {
        NodeCoordinator coordinator = toCoordinator(layoutCoordinates);
        coordinator.onCoordinatesUsed$ui();
        NodeCoordinator findCommonAncestor$ui = findCommonAncestor$ui(coordinator);
        Matrix.m5601resetimpl(fArr);
        coordinator.m7114transformToAncestorEL8BTi8(findCommonAncestor$ui, fArr);
        m7113transformFromAncestorEL8BTi8(findCommonAncestor$ui, fArr);
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* renamed from: transformToScreen-58bKbWc */
    public void mo6834transformToScreen58bKbWc(float[] fArr) {
        Owner requireOwner = LayoutNodeKt.requireOwner(getLayoutNode());
        NodeCoordinator coordinator = toCoordinator(LayoutCoordinatesKt.findRootCoordinates(this));
        m7114transformToAncestorEL8BTi8(coordinator, fArr);
        if (requireOwner instanceof MatrixPositionCalculator) {
            ((MatrixPositionCalculator) requireOwner).mo6591localToScreen58bKbWc(fArr);
            return;
        }
        long positionOnScreen = LayoutCoordinatesKt.positionOnScreen(coordinator);
        if ((9223372034707292159L & positionOnScreen) != androidx.compose.ui.geometry.InlineClassHelperKt.UnspecifiedPackedFloats) {
            Matrix.m5613translateimpl(fArr, Float.intBitsToFloat((int) (positionOnScreen >> 32)), Float.intBitsToFloat((int) (positionOnScreen & 4294967295L)), 0.0f);
        }
    }

    /* renamed from: transformToAncestor-EL8BTi8 */
    private final void m7114transformToAncestorEL8BTi8(NodeCoordinator nodeCoordinator, float[] fArr) {
        while (!Intrinsics.areEqual(this, nodeCoordinator)) {
            OwnedLayer ownedLayer = this.layer;
            if (ownedLayer != null) {
                ownedLayer.mo7198transform58bKbWc(fArr);
            }
            long mo7063getPositionnOccac = this.mo7063getPositionnOccac();
            if (!IntOffset.m8287equalsimpl0(mo7063getPositionnOccac, IntOffset.Companion.m8299getZeronOccac())) {
                float[] fArr2 = tmpMatrix;
                Matrix.m5601resetimpl(fArr2);
                Matrix.m5614translateimpl$default(fArr2, IntOffset.m8288getXimpl(mo7063getPositionnOccac), IntOffset.m8289getYimpl(mo7063getPositionnOccac), 0.0f, 4, null);
                Matrix.m5611timesAssign58bKbWc(fArr, fArr2);
            }
            this = this.wrappedBy;
            Intrinsics.checkNotNull(this);
        }
    }

    /* renamed from: transformFromAncestor-EL8BTi8 */
    private final void m7113transformFromAncestorEL8BTi8(NodeCoordinator nodeCoordinator, float[] fArr) {
        if (Intrinsics.areEqual(nodeCoordinator, this)) {
            return;
        }
        NodeCoordinator nodeCoordinator2 = this.wrappedBy;
        Intrinsics.checkNotNull(nodeCoordinator2);
        nodeCoordinator2.m7113transformFromAncestorEL8BTi8(nodeCoordinator, fArr);
        if (!IntOffset.m8287equalsimpl0(mo7063getPositionnOccac(), IntOffset.Companion.m8299getZeronOccac())) {
            float[] fArr2 = tmpMatrix;
            Matrix.m5601resetimpl(fArr2);
            Matrix.m5614translateimpl$default(fArr2, -IntOffset.m8288getXimpl(mo7063getPositionnOccac()), -IntOffset.m8289getYimpl(mo7063getPositionnOccac()), 0.0f, 4, null);
            Matrix.m5611timesAssign58bKbWc(fArr, fArr2);
        }
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            ownedLayer.mo7193inverseTransform58bKbWc(fArr);
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
        coordinator.onCoordinatesUsed$ui();
        NodeCoordinator findCommonAncestor$ui = findCommonAncestor$ui(coordinator);
        MutableRect rectCache = getRectCache();
        rectCache.setLeft(0.0f);
        rectCache.setTop(0.0f);
        rectCache.setRight((int) (layoutCoordinates.mo6826getSizeYbymL2g() >> 32));
        rectCache.setBottom((int) (layoutCoordinates.mo6826getSizeYbymL2g() & 4294967295L));
        NodeCoordinator nodeCoordinator = coordinator;
        while (nodeCoordinator != findCommonAncestor$ui) {
            boolean z2 = z;
            rectInParent$ui$default(nodeCoordinator, rectCache, z2, false, 4, null);
            if (rectCache.isEmpty()) {
                return Rect.Companion.getZero();
            }
            nodeCoordinator = nodeCoordinator.wrappedBy;
            Intrinsics.checkNotNull(nodeCoordinator);
            z = z2;
        }
        ancestorToLocal(findCommonAncestor$ui, rectCache, z);
        return MutableRectKt.toRect(rectCache);
    }

    /* renamed from: ancestorToLocal-S_NoaFU */
    private final long m7102ancestorToLocalS_NoaFU(NodeCoordinator nodeCoordinator, long j, boolean z) {
        if (nodeCoordinator == this) {
            return j;
        }
        NodeCoordinator nodeCoordinator2 = this.wrappedBy;
        if (nodeCoordinator2 == null || Intrinsics.areEqual(nodeCoordinator, nodeCoordinator2)) {
            return m7118fromParentPosition8S9VItk(j, z);
        }
        return m7118fromParentPosition8S9VItk(nodeCoordinator2.m7102ancestorToLocalS_NoaFU(nodeCoordinator, j, z), z);
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
    public long mo6829localToRootMKHz9U(long j) {
        if (!isAttached()) {
            InlineClassHelperKt.throwIllegalStateException(ExpectAttachedLayoutCoordinates);
        }
        onCoordinatesUsed$ui();
        long j2 = j;
        for (NodeCoordinator nodeCoordinator = this; nodeCoordinator != null; nodeCoordinator = nodeCoordinator.wrappedBy) {
            LayoutNode layoutNode = nodeCoordinator.getLayoutNode();
            if (nodeCoordinator == layoutNode.getOuterCoordinator$ui() && !layoutNode.getHasPositionalLayerTransformationsInOffsetFromRoot$ui()) {
                long m7401getOffsetFromRectListForBjo55l4 = LayoutNodeKt.requireOwner(layoutNode).getRectManager().m7401getOffsetFromRectListForBjo55l4(layoutNode);
                if (!IntOffset.m8287equalsimpl0(m7401getOffsetFromRectListForBjo55l4, IntOffset.Companion.m8298getMaxnOccac())) {
                    return IntOffsetKt.m8303plusNvtHpc(j2, m7401getOffsetFromRectListForBjo55l4);
                }
            }
            j2 = m7112toParentPosition8S9VItk$default(nodeCoordinator, j2, false, 2, null);
        }
        return j2;
    }

    protected final void withPositionTranslation(Canvas canvas, Function1<? super Canvas, Unit> function1) {
        float m8288getXimpl = IntOffset.m8288getXimpl(mo7063getPositionnOccac());
        float m8289getYimpl = IntOffset.m8289getYimpl(mo7063getPositionnOccac());
        canvas.translate(m8288getXimpl, m8289getYimpl);
        function1.invoke(canvas);
        canvas.translate(-m8288getXimpl, -m8289getYimpl);
    }

    /* renamed from: toParentPosition-8S9VItk$default */
    public static /* synthetic */ long m7112toParentPosition8S9VItk$default(NodeCoordinator nodeCoordinator, long j, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                z = true;
            }
            return nodeCoordinator.m7127toParentPosition8S9VItk(j, z);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toParentPosition-8S9VItk");
    }

    /* renamed from: toParentPosition-8S9VItk */
    public long m7127toParentPosition8S9VItk(long j, boolean z) {
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            j = ownedLayer.mo7195mapOffset8S9VItk(j, false);
        }
        return (z || !isPlacedUnderMotionFrameOfReference()) ? IntOffsetKt.m8303plusNvtHpc(j, mo7063getPositionnOccac()) : j;
    }

    /* renamed from: fromParentPosition-8S9VItk$default */
    public static /* synthetic */ long m7103fromParentPosition8S9VItk$default(NodeCoordinator nodeCoordinator, long j, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                z = true;
            }
            return nodeCoordinator.m7118fromParentPosition8S9VItk(j, z);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fromParentPosition-8S9VItk");
    }

    /* renamed from: fromParentPosition-8S9VItk */
    public long m7118fromParentPosition8S9VItk(long j, boolean z) {
        if (z || !isPlacedUnderMotionFrameOfReference()) {
            j = IntOffsetKt.m8301minusNvtHpc(j, mo7063getPositionnOccac());
        }
        OwnedLayer ownedLayer = this.layer;
        return ownedLayer != null ? ownedLayer.mo7195mapOffset8S9VItk(j, true) : j;
    }

    public final void drawBorder(Canvas canvas, Paint paint) {
        canvas.drawRect(0.5f, 0.5f, ((int) (m6879getMeasuredSizeYbymL2g() >> 32)) - 0.5f, ((int) (m6879getMeasuredSizeYbymL2g() & 4294967295L)) - 0.5f, paint);
    }

    public final void onLayoutNodeDetach() {
        releaseLayer();
        if (getLayoutNode().isPlaced()) {
            onUnplaced();
        }
    }

    public final void onRelease() {
        this.released = true;
        this.invalidateParentLayer.invoke();
        releaseLayer();
        if (IntOffset.m8287equalsimpl0(mo7063getPositionnOccac(), IntOffset.Companion.m8299getZeronOccac())) {
            return;
        }
        getLayoutNode().onCoordinatorRectChanged$ui(this);
    }

    public static /* synthetic */ void rectInParent$ui$default(NodeCoordinator nodeCoordinator, MutableRect mutableRect, boolean z, boolean z2, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: rectInParent");
        }
        if ((i & 4) != 0) {
            z2 = false;
        }
        nodeCoordinator.rectInParent$ui(mutableRect, z, z2);
    }

    public final void rectInParent$ui(MutableRect mutableRect, boolean z, boolean z2) {
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            if (this.isClipping) {
                if (z2) {
                    long m7120getMinimumTouchTargetSizeNHjbRc = m7120getMinimumTouchTargetSizeNHjbRc();
                    long m7115calculateMinimumTouchTargetOffsetC6jSQ5I = m7115calculateMinimumTouchTargetOffsetC6jSQ5I(mutableRect, m7120getMinimumTouchTargetSizeNHjbRc);
                    float intBitsToFloat = Float.intBitsToFloat((int) (m7115calculateMinimumTouchTargetOffsetC6jSQ5I >> 32));
                    float intBitsToFloat2 = Float.intBitsToFloat((int) (m7115calculateMinimumTouchTargetOffsetC6jSQ5I & 4294967295L));
                    long mo6826getSizeYbymL2g = mo6826getSizeYbymL2g();
                    float f = (int) (mo6826getSizeYbymL2g >> 32);
                    int i = (int) (m7120getMinimumTouchTargetSizeNHjbRc >> 32);
                    float f2 = (int) (mo6826getSizeYbymL2g & 4294967295L);
                    int i2 = (int) (m7120getMinimumTouchTargetSizeNHjbRc & 4294967295L);
                    mutableRect.intersect(intBitsToFloat, intBitsToFloat2, Math.min(Float.intBitsToFloat(i) + f, Math.max(f, Float.intBitsToFloat(i) + intBitsToFloat)), Math.min(Float.intBitsToFloat(i2) + f2, Math.max(f2, Float.intBitsToFloat(i2) + intBitsToFloat2)));
                } else if (z) {
                    mutableRect.intersect(0.0f, 0.0f, (int) (mo6826getSizeYbymL2g() >> 32), (int) (4294967295L & mo6826getSizeYbymL2g()));
                }
                if (mutableRect.isEmpty()) {
                    return;
                }
            }
            ownedLayer.mapBounds(mutableRect, false);
        }
        float m8288getXimpl = IntOffset.m8288getXimpl(mo7063getPositionnOccac());
        mutableRect.setLeft(mutableRect.getLeft() + m8288getXimpl);
        mutableRect.setRight(mutableRect.getRight() + m8288getXimpl);
        float m8289getYimpl = IntOffset.m8289getYimpl(mo7063getPositionnOccac());
        mutableRect.setTop(mutableRect.getTop() + m8289getYimpl);
        mutableRect.setBottom(mutableRect.getBottom() + m8289getYimpl);
    }

    private final void fromParentRect(MutableRect mutableRect, boolean z) {
        float m8288getXimpl = IntOffset.m8288getXimpl(mo7063getPositionnOccac());
        mutableRect.setLeft(mutableRect.getLeft() - m8288getXimpl);
        mutableRect.setRight(mutableRect.getRight() - m8288getXimpl);
        float m8289getYimpl = IntOffset.m8289getYimpl(mo7063getPositionnOccac());
        mutableRect.setTop(mutableRect.getTop() - m8289getYimpl);
        mutableRect.setBottom(mutableRect.getBottom() - m8289getYimpl);
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            ownedLayer.mapBounds(mutableRect, true);
            if (this.isClipping && z) {
                mutableRect.intersect(0.0f, 0.0f, (int) (mo6826getSizeYbymL2g() >> 32), (int) (mo6826getSizeYbymL2g() & 4294967295L));
                mutableRect.isEmpty();
            }
        }
    }

    /* renamed from: withinLayerBounds-k-4lQ0M */
    public final boolean m7129withinLayerBoundsk4lQ0M(long j) {
        if ((((androidx.compose.ui.geometry.InlineClassHelperKt.DualFloatInfinityBase ^ (j & androidx.compose.ui.geometry.InlineClassHelperKt.DualFloatInfinityBase)) - androidx.compose.ui.geometry.InlineClassHelperKt.Uint64Low32) & (-9223372034707292160L)) == 0) {
            OwnedLayer ownedLayer = this.layer;
            return ownedLayer == null || !this.isClipping || ownedLayer.mo7194isInLayerk4lQ0M(j);
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

    public final NodeCoordinator findCommonAncestor$ui(NodeCoordinator nodeCoordinator) {
        LayoutNode layoutNode = nodeCoordinator.getLayoutNode();
        LayoutNode layoutNode2 = getLayoutNode();
        if (layoutNode == layoutNode2) {
            Modifier.Node tail = nodeCoordinator.getTail();
            Modifier.Node tail2 = getTail();
            int m7135constructorimpl = NodeKind.m7135constructorimpl(2);
            if (!tail2.getNode().isAttached()) {
                InlineClassHelperKt.throwIllegalStateException("visitLocalAncestors called on an unattached node");
            }
            for (Modifier.Node parent$ui = tail2.getNode().getParent$ui(); parent$ui != null; parent$ui = parent$ui.getParent$ui()) {
                if ((parent$ui.getKindSet$ui() & m7135constructorimpl) != 0 && parent$ui == tail) {
                    return nodeCoordinator;
                }
            }
            return this;
        }
        while (layoutNode.getDepth$ui() > layoutNode2.getDepth$ui()) {
            layoutNode = layoutNode.getParent$ui();
            Intrinsics.checkNotNull(layoutNode);
        }
        while (layoutNode2.getDepth$ui() > layoutNode.getDepth$ui()) {
            layoutNode2 = layoutNode2.getParent$ui();
            Intrinsics.checkNotNull(layoutNode2);
        }
        while (layoutNode != layoutNode2) {
            layoutNode = layoutNode.getParent$ui();
            layoutNode2 = layoutNode2.getParent$ui();
            if (layoutNode != null) {
                if (layoutNode2 == null) {
                }
            }
            throw new IllegalArgumentException("layouts are not part of the same hierarchy");
        }
        if (layoutNode2 != getLayoutNode()) {
            if (layoutNode != nodeCoordinator.getLayoutNode()) {
                return layoutNode.getInnerCoordinator$ui();
            }
            return nodeCoordinator;
        }
        return this;
    }

    /* renamed from: calculateMinimumTouchTargetOffset-C6jSQ5I */
    protected final long m7115calculateMinimumTouchTargetOffsetC6jSQ5I(MutableRect mutableRect, long j) {
        float left = mutableRect.getLeft();
        float top = mutableRect.getTop();
        if (mutableRect.getRight() < 0.0f || left > ((int) (mo6826getSizeYbymL2g() >> 32)) || mutableRect.getBottom() < 0.0f || top > ((int) (mo6826getSizeYbymL2g() & 4294967295L))) {
            return Offset.Companion.m5119getZeroF1C5BW0();
        }
        float intBitsToFloat = Float.intBitsToFloat((int) (j >> 32));
        float intBitsToFloat2 = Float.intBitsToFloat((int) (j & 4294967295L));
        float right = (intBitsToFloat - (mutableRect.getRight() - mutableRect.getLeft())) / 2.0f;
        float coerceAtLeast = right > 0.0f ? left - right : RangesKt.coerceAtLeast(left, (-intBitsToFloat) / 2.0f);
        float bottom = (intBitsToFloat2 - (mutableRect.getBottom() - mutableRect.getTop())) / 2.0f;
        return Offset.m5095constructorimpl((Float.floatToRawIntBits(coerceAtLeast) << 32) | (Float.floatToRawIntBits(bottom > 0.0f ? top - bottom : RangesKt.coerceAtLeast(top, (-intBitsToFloat2) / 2.0f)) & 4294967295L));
    }

    /* renamed from: distanceInMinimumTouchTarget-tz77jQw */
    public final float m7117distanceInMinimumTouchTargettz77jQw(long j, long j2) {
        if (getMeasuredWidth() < Float.intBitsToFloat((int) (j2 >> 32)) || getMeasuredHeight() < Float.intBitsToFloat((int) (j2 & 4294967295L))) {
            long m7116calculateMinimumTouchTargetPaddingE7KxVPU = m7116calculateMinimumTouchTargetPaddingE7KxVPU(j2);
            float intBitsToFloat = Float.intBitsToFloat((int) (m7116calculateMinimumTouchTargetPaddingE7KxVPU >> 32));
            float intBitsToFloat2 = Float.intBitsToFloat((int) (m7116calculateMinimumTouchTargetPaddingE7KxVPU & 4294967295L));
            long m7108offsetFromEdgeMKHz9U = m7108offsetFromEdgeMKHz9U(j);
            if ((intBitsToFloat > 0.0f || intBitsToFloat2 > 0.0f) && Float.intBitsToFloat((int) (m7108offsetFromEdgeMKHz9U >> 32)) <= intBitsToFloat && Float.intBitsToFloat((int) (m7108offsetFromEdgeMKHz9U & 4294967295L)) <= intBitsToFloat2) {
                return Offset.m5102getDistanceSquaredimpl(m7108offsetFromEdgeMKHz9U);
            }
            return Float.POSITIVE_INFINITY;
        }
        return Float.POSITIVE_INFINITY;
    }

    /* compiled from: NodeCoordinator.kt */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016¨\u0006\u0019"}, d2 = {"Landroidx/compose/ui/node/NodeCoordinator$Companion;", "", "<init>", "()V", "ExpectAttachedLayoutCoordinates", "", "UnmeasuredError", "onCommitAffectingLayerParams", "Lkotlin/Function1;", "Landroidx/compose/ui/node/NodeCoordinator;", "", "onCommitAffectingLayer", "graphicsLayerScope", "Landroidx/compose/ui/graphics/ReusableGraphicsLayerScope;", "tmpLayerPositionalProperties", "Landroidx/compose/ui/node/LayerPositionalProperties;", "tmpMatrix", "Landroidx/compose/ui/graphics/Matrix;", "[F", "PointerInputSource", "Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;", "getPointerInputSource", "()Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;", "SemanticsSource", "getSemanticsSource", "ui"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
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
        Modifier.Node parent$ui;
        if (m7104hasNodeH91voCI(NodeKind.m7135constructorimpl(128))) {
            Snapshot.Companion companion = Snapshot.Companion;
            Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
            Function1<Object, Unit> readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
            Snapshot makeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
            try {
                int m7135constructorimpl = NodeKind.m7135constructorimpl(128);
                boolean m7144getIncludeSelfInTraversalH91voCI = NodeKindKt.m7144getIncludeSelfInTraversalH91voCI(m7135constructorimpl);
                if (m7144getIncludeSelfInTraversalH91voCI) {
                    parent$ui = getTail();
                } else {
                    parent$ui = getTail().getParent$ui();
                    if (parent$ui == null) {
                        Unit unit = Unit.INSTANCE;
                    }
                }
                for (Modifier.Node headNode = headNode(m7144getIncludeSelfInTraversalH91voCI); headNode != null && (headNode.getAggregateChildKindSet$ui() & m7135constructorimpl) != 0; headNode = headNode.getChild$ui()) {
                    if ((headNode.getKindSet$ui() & m7135constructorimpl) != 0) {
                        MutableVector mutableVector = null;
                        Modifier.Node node = headNode;
                        while (node != null) {
                            if (node instanceof MeasuredSizeAwareModifierNode) {
                                ((MeasuredSizeAwareModifierNode) node).mo423onRemeasuredozmzZPI(m6879getMeasuredSizeYbymL2g());
                            } else if ((node.getKindSet$ui() & m7135constructorimpl) != 0 && (node instanceof DelegatingNode)) {
                                int i = 0;
                                for (Modifier.Node delegate$ui = ((DelegatingNode) node).getDelegate$ui(); delegate$ui != null; delegate$ui = delegate$ui.getChild$ui()) {
                                    if ((delegate$ui.getKindSet$ui() & m7135constructorimpl) != 0) {
                                        i++;
                                        if (i == 1) {
                                            node = delegate$ui;
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
                                                mutableVector.add(delegate$ui);
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
                    if (headNode == parent$ui) {
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
        if (m7104hasNodeH91voCI(NodeKind.m7135constructorimpl(1048576))) {
            int m7135constructorimpl = NodeKind.m7135constructorimpl(1048576);
            boolean m7144getIncludeSelfInTraversalH91voCI = NodeKindKt.m7144getIncludeSelfInTraversalH91voCI(m7135constructorimpl);
            Modifier.Node tail = getTail();
            if (!m7144getIncludeSelfInTraversalH91voCI && (tail = tail.getParent$ui()) == null) {
                return;
            }
            for (Modifier.Node headNode = headNode(m7144getIncludeSelfInTraversalH91voCI); headNode != null && (headNode.getAggregateChildKindSet$ui() & m7135constructorimpl) != 0; headNode = headNode.getChild$ui()) {
                if ((headNode.getKindSet$ui() & m7135constructorimpl) != 0) {
                    Modifier.Node node = headNode;
                    MutableVector mutableVector = null;
                    while (node != null) {
                        if (node instanceof UnplacedAwareModifierNode) {
                            ((UnplacedAwareModifierNode) node).onUnplaced();
                        } else if ((node.getKindSet$ui() & m7135constructorimpl) != 0 && (node instanceof DelegatingNode)) {
                            int i = 0;
                            for (Modifier.Node delegate$ui = ((DelegatingNode) node).getDelegate$ui(); delegate$ui != null; delegate$ui = delegate$ui.getChild$ui()) {
                                if ((delegate$ui.getKindSet$ui() & m7135constructorimpl) != 0) {
                                    i++;
                                    if (i == 1) {
                                        node = delegate$ui;
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
                                            mutableVector.add(delegate$ui);
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
        Modifier.Node m7121headH91voCI = m7121headH91voCI(NodeKind.m7135constructorimpl(4));
        if (m7121headH91voCI == null) {
            performDraw(canvas, graphicsLayer);
        } else {
            getLayoutNode().getMDrawScope$ui().m7056draweZhPAX0$ui(canvas, IntSizeKt.m8343toSizeozmzZPI(mo6826getSizeYbymL2g()), this, m7121headH91voCI, graphicsLayer);
        }
    }

    public final void onPlaced() {
        int m7135constructorimpl = NodeKind.m7135constructorimpl(4194304);
        boolean m7144getIncludeSelfInTraversalH91voCI = NodeKindKt.m7144getIncludeSelfInTraversalH91voCI(m7135constructorimpl);
        Modifier.Node tail = getTail();
        if (!m7144getIncludeSelfInTraversalH91voCI && (tail = tail.getParent$ui()) == null) {
            return;
        }
        for (Modifier.Node headNode = headNode(m7144getIncludeSelfInTraversalH91voCI); headNode != null && (headNode.getAggregateChildKindSet$ui() & m7135constructorimpl) != 0; headNode = headNode.getChild$ui()) {
            if ((headNode.getKindSet$ui() & m7135constructorimpl) != 0) {
                Modifier.Node node = headNode;
                MutableVector mutableVector = null;
                while (node != null) {
                    if (node instanceof LayoutAwareModifierNode) {
                        ((LayoutAwareModifierNode) node).onPlaced(this);
                    } else if ((node.getKindSet$ui() & m7135constructorimpl) != 0 && (node instanceof DelegatingNode)) {
                        int i = 0;
                        for (Modifier.Node delegate$ui = ((DelegatingNode) node).getDelegate$ui(); delegate$ui != null; delegate$ui = delegate$ui.getChild$ui()) {
                            if ((delegate$ui.getKindSet$ui() & m7135constructorimpl) != 0) {
                                i++;
                                if (i == 1) {
                                    node = delegate$ui;
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
                                        mutableVector.add(delegate$ui);
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
    protected final boolean m7123isPointerInBoundsk4lQ0M(long j) {
        float intBitsToFloat = Float.intBitsToFloat((int) (j >> 32));
        float intBitsToFloat2 = Float.intBitsToFloat((int) (j & 4294967295L));
        return intBitsToFloat >= 0.0f && intBitsToFloat2 >= 0.0f && intBitsToFloat < ((float) getMeasuredWidth()) && intBitsToFloat2 < ((float) getMeasuredHeight());
    }

    public final boolean shouldSharePointerInputWithSiblings() {
        Modifier.Node headNode = headNode(NodeKindKt.m7144getIncludeSelfInTraversalH91voCI(NodeKind.m7135constructorimpl(16)));
        if (headNode != null && headNode.isAttached()) {
            Modifier.Node node = headNode;
            int m7135constructorimpl = NodeKind.m7135constructorimpl(16);
            if (!node.getNode().isAttached()) {
                InlineClassHelperKt.throwIllegalStateException("visitLocalDescendants called on an unattached node");
            }
            Modifier.Node node2 = node.getNode();
            if ((node2.getAggregateChildKindSet$ui() & m7135constructorimpl) != 0) {
                while (node2 != null) {
                    if ((node2.getKindSet$ui() & m7135constructorimpl) != 0) {
                        Modifier.Node node3 = node2;
                        MutableVector mutableVector = null;
                        while (node3 != null) {
                            if (node3 instanceof PointerInputModifierNode) {
                                if (((PointerInputModifierNode) node3).sharePointerInputWithSiblings()) {
                                    return true;
                                }
                            } else if ((node3.getKindSet$ui() & m7135constructorimpl) != 0 && (node3 instanceof DelegatingNode)) {
                                int i = 0;
                                for (Modifier.Node delegate$ui = ((DelegatingNode) node3).getDelegate$ui(); delegate$ui != null; delegate$ui = delegate$ui.getChild$ui()) {
                                    if ((delegate$ui.getKindSet$ui() & m7135constructorimpl) != 0) {
                                        i++;
                                        if (i == 1) {
                                            node3 = delegate$ui;
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
                                                mutableVector.add(delegate$ui);
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
                    node2 = node2.getChild$ui();
                }
            }
        }
        return false;
    }

    /* renamed from: offsetFromEdge-MK-Hz9U */
    private final long m7108offsetFromEdgeMKHz9U(long j) {
        float intBitsToFloat = Float.intBitsToFloat((int) (j >> 32));
        float max = Math.max(0.0f, intBitsToFloat < 0.0f ? -intBitsToFloat : intBitsToFloat - getMeasuredWidth());
        float intBitsToFloat2 = Float.intBitsToFloat((int) (j & 4294967295L));
        return Offset.m5095constructorimpl((Float.floatToRawIntBits(max) << 32) | (Float.floatToRawIntBits(Math.max(0.0f, intBitsToFloat2 < 0.0f ? -intBitsToFloat2 : intBitsToFloat2 - getMeasuredHeight())) & 4294967295L));
    }

    /* renamed from: calculateMinimumTouchTargetPadding-E7KxVPU */
    protected final long m7116calculateMinimumTouchTargetPaddingE7KxVPU(long j) {
        return Size.m5163constructorimpl((Float.floatToRawIntBits(Math.max(0.0f, (Float.intBitsToFloat((int) (j >> 32)) - getMeasuredWidth()) / 2.0f)) << 32) | (Float.floatToRawIntBits(Math.max(0.0f, (Float.intBitsToFloat((int) (j & 4294967295L)) - getMeasuredHeight()) / 2.0f)) & 4294967295L));
    }
}
