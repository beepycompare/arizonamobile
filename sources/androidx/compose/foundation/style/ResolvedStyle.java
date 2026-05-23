package androidx.compose.foundation.style;

import androidx.collection.MutableIntList;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.TransformOrigin;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.platform.InspectableValue;
import androidx.compose.ui.platform.ValueElement;
import androidx.compose.ui.text.ParagraphStyle;
import androidx.compose.ui.text.PlatformTextStyle;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.Hyphens;
import androidx.compose.ui.text.style.LineBreak;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextDirection;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpSize;
import androidx.compose.ui.unit.TextUnit;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.android.material.internal.ViewUtils;
import com.google.android.vending.expansion.downloader.DownloaderServiceMarshaller;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import io.appmetrica.analytics.impl.M2;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
/* compiled from: ResolvedStyle.kt */
@Metadata(d1 = {"\u0000Ä\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\bB\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b,\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0000¢\u0006\u0004\b\u0003\u0010\u0004J#\u0010Ä\u0001\u001a\u00020\u00062\u0007\u0010Å\u0001\u001a\u00020\u00002\t\b\u0002\u0010Æ\u0001\u001a\u00020\u0006H\u0000¢\u0006\u0003\bÇ\u0001J\u000f\u0010È\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0003\bÉ\u0001J\u000f\u0010Ê\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0003\bË\u0001J\u0019\u0010Ì\u0001\u001a\u00030Í\u00012\u0007\u0010Î\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0003\bÏ\u0001J\u0019\u0010Ð\u0001\u001a\u00030Í\u00012\u0007\u0010Î\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0003\bÑ\u0001J\u0010\u0010Ò\u0001\u001a\u00030Í\u0001H\u0000¢\u0006\u0003\bÓ\u0001J4\u0010Ô\u0001\u001a\u00030Í\u00012\b\u0010Õ\u0001\u001a\u00030Ö\u00012\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010×\u0001\u001a\u00030Ø\u00012\u0006\u0010\u000e\u001a\u00020\u000fH\u0000¢\u0006\u0003\bÙ\u0001J:\u0010Ú\u0001\u001a\u00030Í\u00012\b\u0010Õ\u0001\u001a\u00030Ö\u00012\b\u0010×\u0001\u001a\u00030Ø\u00012\u0006\u0010\u000e\u001a\u00020\u000f2\f\b\u0002\u0010Û\u0001\u001a\u0005\u0018\u00010Ü\u0001H\u0000¢\u0006\u0003\bÝ\u0001J\u0019\u0010Þ\u0001\u001a\u00030Í\u00012\u0007\u0010ß\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0003\bà\u0001J\u001a\u0010á\u0001\u001a\u00030â\u00012\b\u0010ã\u0001\u001a\u00030â\u0001H\u0000¢\u0006\u0003\bä\u0001J\u0011\u0010å\u0001\u001a\n\u0012\u0005\u0012\u00030ç\u00010æ\u0001H\u0002J\u001b\u0010\u0012\u001a\u00030Í\u00012\b\u0010ñ\u0001\u001a\u00030ò\u0001H\u0016¢\u0006\u0005\bó\u0001\u0010\u0016J\u001b\u0010\u0017\u001a\u00030Í\u00012\b\u0010ñ\u0001\u001a\u00030ò\u0001H\u0016¢\u0006\u0005\bô\u0001\u0010\u0016J\u001b\u0010\u001a\u001a\u00030Í\u00012\b\u0010ñ\u0001\u001a\u00030ò\u0001H\u0016¢\u0006\u0005\bõ\u0001\u0010\u0016J\u001b\u0010\u001d\u001a\u00030Í\u00012\b\u0010ñ\u0001\u001a\u00030ò\u0001H\u0016¢\u0006\u0005\bö\u0001\u0010\u0016J\u001c\u0010÷\u0001\u001a\u00030Í\u00012\b\u0010ñ\u0001\u001a\u00030ò\u0001H\u0016¢\u0006\u0005\bø\u0001\u0010\u0016J\u001c\u0010ù\u0001\u001a\u00030Í\u00012\b\u0010ñ\u0001\u001a\u00030ò\u0001H\u0016¢\u0006\u0005\bú\u0001\u0010\u0016J\u001c\u0010û\u0001\u001a\u00030Í\u00012\b\u0010ñ\u0001\u001a\u00030ò\u0001H\u0016¢\u0006\u0005\bü\u0001\u0010\u0016J9\u0010û\u0001\u001a\u00030Í\u00012\b\u0010ý\u0001\u001a\u00030ò\u00012\u0007\u0010>\u001a\u00030ò\u00012\b\u0010þ\u0001\u001a\u00030ò\u00012\u0007\u0010D\u001a\u00030ò\u0001H\u0016¢\u0006\u0006\bÿ\u0001\u0010\u0080\u0002J'\u0010û\u0001\u001a\u00030Í\u00012\b\u0010\u0081\u0002\u001a\u00030ò\u00012\b\u0010\u0082\u0002\u001a\u00030ò\u0001H\u0016¢\u0006\u0006\b\u0083\u0002\u0010\u0084\u0002J\u001b\u0010 \u001a\u00030Í\u00012\b\u0010ñ\u0001\u001a\u00030ò\u0001H\u0016¢\u0006\u0005\b\u0085\u0002\u0010\u0016J\u001b\u0010#\u001a\u00030Í\u00012\b\u0010ñ\u0001\u001a\u00030ò\u0001H\u0016¢\u0006\u0005\b\u0086\u0002\u0010\u0016J\u001b\u0010&\u001a\u00030Í\u00012\b\u0010ñ\u0001\u001a\u00030ò\u0001H\u0016¢\u0006\u0005\b\u0087\u0002\u0010\u0016J\u001b\u0010)\u001a\u00030Í\u00012\b\u0010ñ\u0001\u001a\u00030ò\u0001H\u0016¢\u0006\u0005\b\u0088\u0002\u0010\u0016J\u001c\u0010\u0089\u0002\u001a\u00030Í\u00012\b\u0010ñ\u0001\u001a\u00030ò\u0001H\u0016¢\u0006\u0005\b\u008a\u0002\u0010\u0016J\u001c\u0010\u008b\u0002\u001a\u00030Í\u00012\b\u0010ñ\u0001\u001a\u00030ò\u0001H\u0016¢\u0006\u0005\b\u008c\u0002\u0010\u0016J\u001c\u0010\u008d\u0002\u001a\u00030Í\u00012\b\u0010ñ\u0001\u001a\u00030ò\u0001H\u0016¢\u0006\u0005\b\u008e\u0002\u0010\u0016J9\u0010\u008d\u0002\u001a\u00030Í\u00012\b\u0010ý\u0001\u001a\u00030ò\u00012\u0007\u0010>\u001a\u00030ò\u00012\b\u0010þ\u0001\u001a\u00030ò\u00012\u0007\u0010D\u001a\u00030ò\u0001H\u0016¢\u0006\u0006\b\u008f\u0002\u0010\u0080\u0002J'\u0010\u008d\u0002\u001a\u00030Í\u00012\b\u0010\u0081\u0002\u001a\u00030ò\u00012\b\u0010\u0082\u0002\u001a\u00030ò\u0001H\u0016¢\u0006\u0006\b\u0090\u0002\u0010\u0084\u0002J\u001b\u0010,\u001a\u00030Í\u00012\b\u0010ñ\u0001\u001a\u00030ò\u0001H\u0016¢\u0006\u0005\b\u0091\u0002\u0010\u0016J\u001a\u0010S\u001a\u00030Í\u00012\u0007\u0010ñ\u0001\u001a\u00020TH\u0016¢\u0006\u0005\b\u0092\u0002\u0010XJ\u0012\u0010Z\u001a\u00030Í\u00012\u0007\u0010ñ\u0001\u001a\u00020[H\u0016J%\u0010\u0093\u0002\u001a\u00030Í\u00012\u0007\u0010/\u001a\u00030ò\u00012\u0007\u0010\u0094\u0002\u001a\u00020TH\u0016¢\u0006\u0006\b\u0095\u0002\u0010\u0096\u0002J%\u0010\u0093\u0002\u001a\u00030Í\u00012\u0007\u0010/\u001a\u00030ò\u00012\u0007\u0010\u0097\u0002\u001a\u00020[H\u0016¢\u0006\u0006\b\u0098\u0002\u0010\u0099\u0002J\u001b\u0010/\u001a\u00030Í\u00012\b\u0010ñ\u0001\u001a\u00030ò\u0001H\u0016¢\u0006\u0005\b\u009a\u0002\u0010\u0016J\u001b\u00102\u001a\u00030Í\u00012\b\u0010ñ\u0001\u001a\u00030ò\u0001H\u0016¢\u0006\u0005\b\u009b\u0002\u0010\u0016J%\u0010\u009c\u0002\u001a\u00030Í\u00012\u0007\u0010/\u001a\u00030ò\u00012\u0007\u00102\u001a\u00030ò\u0001H\u0016¢\u0006\u0006\b\u009d\u0002\u0010\u0084\u0002J\u001c\u0010\u009c\u0002\u001a\u00030Í\u00012\b\u0010ñ\u0001\u001a\u00030ò\u0001H\u0016¢\u0006\u0005\b\u009e\u0002\u0010\u0016J\u001c\u0010\u009c\u0002\u001a\u00030Í\u00012\b\u0010ñ\u0001\u001a\u00030\u009f\u0002H\u0016¢\u0006\u0005\b \u0002\u0010XJ\u0012\u0010/\u001a\u00030Í\u00012\u0007\u0010¡\u0002\u001a\u00020\fH\u0016J\u0012\u00102\u001a\u00030Í\u00012\u0007\u0010¡\u0002\u001a\u00020\fH\u0016J\u001b\u0010;\u001a\u00030Í\u00012\b\u0010ñ\u0001\u001a\u00030ò\u0001H\u0016¢\u0006\u0005\b¢\u0002\u0010\u0016J\u001b\u0010>\u001a\u00030Í\u00012\b\u0010ñ\u0001\u001a\u00030ò\u0001H\u0016¢\u0006\u0005\b£\u0002\u0010\u0016J\u001b\u0010A\u001a\u00030Í\u00012\b\u0010ñ\u0001\u001a\u00030ò\u0001H\u0016¢\u0006\u0005\b¤\u0002\u0010\u0016J\u001b\u0010D\u001a\u00030Í\u00012\b\u0010ñ\u0001\u001a\u00030ò\u0001H\u0016¢\u0006\u0005\b¥\u0002\u0010\u0016J\u001b\u0010M\u001a\u00030Í\u00012\b\u0010ñ\u0001\u001a\u00030ò\u0001H\u0016¢\u0006\u0005\b¦\u0002\u0010\u0016J\u001b\u0010G\u001a\u00030Í\u00012\b\u0010ñ\u0001\u001a\u00030ò\u0001H\u0016¢\u0006\u0005\b§\u0002\u0010\u0016J\u001c\u0010¨\u0002\u001a\u00030Í\u00012\b\u0010\u009c\u0002\u001a\u00030\u009f\u0002H\u0016¢\u0006\u0005\b©\u0002\u0010XJ%\u0010¨\u0002\u001a\u00030Í\u00012\u0007\u0010/\u001a\u00030ò\u00012\u0007\u00102\u001a\u00030ò\u0001H\u0016¢\u0006\u0006\bª\u0002\u0010\u0084\u0002J\u001b\u0010P\u001a\u00030Í\u00012\b\u0010ñ\u0001\u001a\u00030ò\u0001H\u0016¢\u0006\u0005\b«\u0002\u0010\u0016J\u001b\u0010J\u001a\u00030Í\u00012\b\u0010ñ\u0001\u001a\u00030ò\u0001H\u0016¢\u0006\u0005\b¬\u0002\u0010\u0016J\u001c\u0010\u00ad\u0002\u001a\u00030Í\u00012\b\u0010\u009c\u0002\u001a\u00030\u009f\u0002H\u0016¢\u0006\u0005\b®\u0002\u0010XJ%\u0010\u00ad\u0002\u001a\u00030Í\u00012\u0007\u0010/\u001a\u00030ò\u00012\u0007\u00102\u001a\u00030ò\u0001H\u0016¢\u0006\u0006\b¯\u0002\u0010\u0084\u0002J\u0012\u0010w\u001a\u00030Í\u00012\u0007\u0010ñ\u0001\u001a\u00020\fH\u0016J\u0012\u0010z\u001a\u00030Í\u00012\u0007\u0010ñ\u0001\u001a\u00020\fH\u0016J\u0012\u0010}\u001a\u00030Í\u00012\u0007\u0010ñ\u0001\u001a\u00020\fH\u0016J\u0013\u0010°\u0002\u001a\u00030Í\u00012\u0007\u0010ñ\u0001\u001a\u00020\fH\u0016J\u0013\u0010\u0080\u0001\u001a\u00030Í\u00012\u0007\u0010ñ\u0001\u001a\u00020\fH\u0016J\u0013\u0010\u0083\u0001\u001a\u00030Í\u00012\u0007\u0010ñ\u0001\u001a\u00020\fH\u0016J\u001c\u0010±\u0002\u001a\u00030Í\u00012\u0007\u0010²\u0002\u001a\u00020\f2\u0007\u0010³\u0002\u001a\u00020\fH\u0016J\u001c\u0010±\u0002\u001a\u00030Í\u00012\b\u0010´\u0002\u001a\u00030µ\u0002H\u0016¢\u0006\u0005\b¶\u0002\u0010XJ\u0013\u0010\u0086\u0001\u001a\u00030Í\u00012\u0007\u0010ñ\u0001\u001a\u00020\fH\u0016J\u0013\u0010\u0089\u0001\u001a\u00030Í\u00012\u0007\u0010ñ\u0001\u001a\u00020\fH\u0016J\u0013\u0010\u008c\u0001\u001a\u00030Í\u00012\u0007\u0010ñ\u0001\u001a\u00020\fH\u0016J\u001c\u0010\u008f\u0001\u001a\u00030Í\u00012\b\u0010ñ\u0001\u001a\u00030\u0090\u0001H\u0016¢\u0006\u0005\b·\u0002\u0010XJ\u0012\u0010l\u001a\u00030Í\u00012\u0007\u0010ñ\u0001\u001a\u00020\u000fH\u0016J\u0013\u0010\u0096\u0001\u001a\u00030Í\u00012\u0007\u0010ñ\u0001\u001a\u00020\fH\u0016J\u001b\u0010¸\u0002\u001a\u00030Í\u00012\u0007\u0010\u0094\u0002\u001a\u00020TH\u0016¢\u0006\u0005\b¹\u0002\u0010XJ\u0013\u0010¸\u0002\u001a\u00030Í\u00012\u0007\u0010ñ\u0001\u001a\u00020[H\u0016J\u001b\u0010º\u0002\u001a\u00030Í\u00012\u0007\u0010ñ\u0001\u001a\u00020TH\u0016¢\u0006\u0005\b»\u0002\u0010XJ\u0013\u0010º\u0002\u001a\u00030Í\u00012\u0007\u0010ñ\u0001\u001a\u00020[H\u0016J\u0012\u0010q\u001a\u00030Í\u00012\u0007\u0010ñ\u0001\u001a\u00020rH\u0016J\u0014\u0010¼\u0002\u001a\u00030Í\u00012\b\u0010ñ\u0001\u001a\u00030Ö\u0001H\u0016J$\u0010¼\u0002\u001a\u00030Í\u00012\u000e\u0010½\u0002\u001a\t\u0012\u0004\u0012\u00020\f0¾\u00022\b\u0010ñ\u0001\u001a\u00030Ö\u0001H\u0016J4\u0010¼\u0002\u001a\u00030Í\u00012\u000e\u0010¿\u0002\u001a\t\u0012\u0004\u0012\u00020\f0¾\u00022\u000e\u0010À\u0002\u001a\t\u0012\u0004\u0012\u00020\f0¾\u00022\b\u0010ñ\u0001\u001a\u00030Ö\u0001H\u0016J\u0014\u0010Æ\u0002\u001a\u00030Í\u00012\b\u0010ñ\u0001\u001a\u00030Ï\u0002H\u0016J(\u0010Æ\u0002\u001a\u00030Í\u00012\u0016\u0010ñ\u0001\u001a\f\u0012\u0007\b\u0001\u0012\u00030Ï\u00020Ð\u0002\"\u00030Ï\u0002H\u0016¢\u0006\u0003\u0010Ñ\u0002J\u0014\u0010Ì\u0002\u001a\u00030Í\u00012\b\u0010ñ\u0001\u001a\u00030Ï\u0002H\u0016J(\u0010Ì\u0002\u001a\u00030Í\u00012\u0016\u0010ñ\u0001\u001a\f\u0012\u0007\b\u0001\u0012\u00030Ï\u00020Ð\u0002\"\u00030Ï\u0002H\u0016¢\u0006\u0003\u0010Ñ\u0002J\u0014\u0010Ò\u0002\u001a\u00030Í\u00012\b\u0010ñ\u0001\u001a\u00030â\u0001H\u0016J\u001b\u0010\u0099\u0001\u001a\u00030Í\u00012\u0007\u0010ñ\u0001\u001a\u00020TH\u0016¢\u0006\u0005\bì\u0002\u0010XJ\u0013\u0010\u009c\u0001\u001a\u00030Í\u00012\u0007\u0010ñ\u0001\u001a\u00020[H\u0016J\u0014\u0010è\u0002\u001a\u00030Í\u00012\b\u0010ñ\u0001\u001a\u00030é\u0002H\u0016J\u0014\u0010\u009f\u0001\u001a\u00030Í\u00012\b\u0010ñ\u0001\u001a\u00030 \u0001H\u0016J\u0014\u0010¥\u0001\u001a\u00030Í\u00012\b\u0010ñ\u0001\u001a\u00030¦\u0001H\u0016J\u001c\u0010«\u0001\u001a\u00030Í\u00012\b\u0010ñ\u0001\u001a\u00030¬\u0001H\u0016¢\u0006\u0005\bí\u0002\u0010XJ\u001c\u0010¯\u0001\u001a\u00030Í\u00012\b\u0010ñ\u0001\u001a\u00030¬\u0001H\u0016¢\u0006\u0005\bî\u0002\u0010XJ\u001c\u0010²\u0001\u001a\u00030Í\u00012\b\u0010ñ\u0001\u001a\u00030¬\u0001H\u0016¢\u0006\u0005\bï\u0002\u0010XJ\u001c\u0010µ\u0001\u001a\u00030Í\u00012\b\u0010ñ\u0001\u001a\u00030¶\u0001H\u0016¢\u0006\u0005\bð\u0002\u0010\u0016J\u001d\u0010º\u0001\u001a\u00030Í\u00012\b\u0010ñ\u0001\u001a\u00030»\u0001H\u0016¢\u0006\u0006\bñ\u0002\u0010¿\u0001J\u001d\u0010Ó\u0002\u001a\u00030Í\u00012\b\u0010ñ\u0001\u001a\u00030Ô\u0002H\u0016¢\u0006\u0006\bò\u0002\u0010¿\u0001J\u001d\u0010Ö\u0002\u001a\u00030Í\u00012\b\u0010ñ\u0001\u001a\u00030×\u0002H\u0016¢\u0006\u0006\bó\u0002\u0010¿\u0001J\u001d\u0010Ù\u0002\u001a\u00030Í\u00012\b\u0010ñ\u0001\u001a\u00030Ú\u0002H\u0016¢\u0006\u0006\bô\u0002\u0010¿\u0001J\u001d\u0010Ü\u0002\u001a\u00030Í\u00012\b\u0010ñ\u0001\u001a\u00030Ý\u0002H\u0016¢\u0006\u0006\bõ\u0002\u0010¿\u0001J\u0014\u0010ß\u0002\u001a\u00030Í\u00012\b\u0010ñ\u0001\u001a\u00030à\u0002H\u0016J\u001d\u0010å\u0002\u001a\u00030Í\u00012\b\u0010ñ\u0001\u001a\u00030æ\u0002H\u0016¢\u0006\u0006\bö\u0002\u0010¿\u0001Ju\u0010Û\u0001\u001a\u00030Í\u0001\"\u0005\b\u0000\u0010Â\u00022\u000f\u0010÷\u0002\u001a\n\u0012\u0005\u0012\u0003HÂ\u00020ø\u00022\b\u0010ñ\u0001\u001a\u00030Ö\u00012G\u0010ù\u0002\u001aB\u0012\u001e\u0012\u001c\u0012\u0005\u0012\u0003HÂ\u00020ø\u0002¢\u0006\u000f\bû\u0002\u0012\n\bü\u0002\u0012\u0005\b\b(÷\u0002\u0012\u0017\u0012\u00150Ü\u0001¢\u0006\u000f\bû\u0002\u0012\n\bü\u0002\u0012\u0005\b\b(Û\u0001\u0012\u0004\u0012\u00020\u000f0ú\u0002H\u0016J*\u0010ý\u0002\u001a\u00030Í\u00012\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010×\u0001\u001a\u00030Ø\u00012\u0006\u0010\u000e\u001a\u00020\u000fH\u0000¢\u0006\u0003\bþ\u0002J\u0010\u0010ÿ\u0002\u001a\u00030Í\u0001H\u0000¢\u0006\u0003\b\u0080\u0003J\u0012\u0010\u0081\u0003\u001a\u00020\t2\u0007\u0010\u0082\u0003\u001a\u00020\u0006H\u0002J%\u0010\u0083\u0003\u001a\u00030Í\u00012\u0007\u0010÷\u0002\u001a\u00020\u00062\u000f\u0010\u0084\u0003\u001a\n\u0012\u0005\u0012\u00030Í\u00010\u0085\u0003H\u0082\bJ&\u0010\u0083\u0003\u001a\u00030Í\u00012\u0007\u0010÷\u0002\u001a\u00020\u00062\u0007\u0010ù\u0002\u001a\u00020\u000f2\b\u0010Õ\u0001\u001a\u00030Ö\u0001H\u0002J\u000b\u0010\u0086\u0003\u001a\u00030Í\u0001H\u0082\bR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\u00068\u0000@\u0000X\u0081\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u00020\fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R\u001a\u0010\u001a\u001a\u00020\fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0014\"\u0004\b\u001c\u0010\u0016R\u001a\u0010\u001d\u001a\u00020\fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0014\"\u0004\b\u001f\u0010\u0016R\u001a\u0010 \u001a\u00020\fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0014\"\u0004\b\"\u0010\u0016R\u001a\u0010#\u001a\u00020\fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0014\"\u0004\b%\u0010\u0016R\u001a\u0010&\u001a\u00020\fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0014\"\u0004\b(\u0010\u0016R\u001a\u0010)\u001a\u00020\fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0014\"\u0004\b+\u0010\u0016R\u001a\u0010,\u001a\u00020\fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0014\"\u0004\b.\u0010\u0016R\u001a\u0010/\u001a\u00020\fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u0014\"\u0004\b1\u0010\u0016R\u001a\u00102\u001a\u00020\fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u0014\"\u0004\b4\u0010\u0016R\u001a\u00105\u001a\u00020\fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u0014\"\u0004\b7\u0010\u0016R\u001a\u00108\u001a\u00020\fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\u0014\"\u0004\b:\u0010\u0016R\u001a\u0010;\u001a\u00020\fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\u0014\"\u0004\b=\u0010\u0016R\u001a\u0010>\u001a\u00020\fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010\u0014\"\u0004\b@\u0010\u0016R\u001a\u0010A\u001a\u00020\fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010\u0014\"\u0004\bC\u0010\u0016R\u001a\u0010D\u001a\u00020\fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010\u0014\"\u0004\bF\u0010\u0016R\u001a\u0010G\u001a\u00020\fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010\u0014\"\u0004\bI\u0010\u0016R\u001a\u0010J\u001a\u00020\fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010\u0014\"\u0004\bL\u0010\u0016R\u001a\u0010M\u001a\u00020\fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010\u0014\"\u0004\bO\u0010\u0016R\u001a\u0010P\u001a\u00020\fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010\u0014\"\u0004\bR\u0010\u0016R\u001c\u0010S\u001a\u00020TX\u0080\u000e¢\u0006\u0010\n\u0002\u0010Y\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR\u001c\u0010Z\u001a\u0004\u0018\u00010[X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\\\u0010]\"\u0004\b^\u0010_R\u001c\u0010`\u001a\u00020TX\u0080\u000e¢\u0006\u0010\n\u0002\u0010Y\u001a\u0004\ba\u0010V\"\u0004\bb\u0010XR\u001c\u0010c\u001a\u0004\u0018\u00010[X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bd\u0010]\"\u0004\be\u0010_R\u001c\u0010f\u001a\u00020TX\u0080\u000e¢\u0006\u0010\n\u0002\u0010Y\u001a\u0004\bg\u0010V\"\u0004\bh\u0010XR\u001c\u0010i\u001a\u0004\u0018\u00010[X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bj\u0010]\"\u0004\bk\u0010_R\u001a\u0010l\u001a\u00020\u000fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bm\u0010n\"\u0004\bo\u0010pR\u001a\u0010q\u001a\u00020rX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bs\u0010t\"\u0004\bu\u0010vR\u001a\u0010w\u001a\u00020\fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bx\u0010\u0014\"\u0004\by\u0010\u0016R\u001a\u0010z\u001a\u00020\fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b{\u0010\u0014\"\u0004\b|\u0010\u0016R\u001a\u0010}\u001a\u00020\fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b~\u0010\u0014\"\u0004\b\u007f\u0010\u0016R\u001d\u0010\u0080\u0001\u001a\u00020\fX\u0080\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0081\u0001\u0010\u0014\"\u0005\b\u0082\u0001\u0010\u0016R\u001d\u0010\u0083\u0001\u001a\u00020\fX\u0080\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0084\u0001\u0010\u0014\"\u0005\b\u0085\u0001\u0010\u0016R\u001d\u0010\u0086\u0001\u001a\u00020\fX\u0080\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0087\u0001\u0010\u0014\"\u0005\b\u0088\u0001\u0010\u0016R\u001d\u0010\u0089\u0001\u001a\u00020\fX\u0080\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008a\u0001\u0010\u0014\"\u0005\b\u008b\u0001\u0010\u0016R\u001d\u0010\u008c\u0001\u001a\u00020\fX\u0080\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008d\u0001\u0010\u0014\"\u0005\b\u008e\u0001\u0010\u0016R \u0010\u008f\u0001\u001a\u00030\u0090\u0001X\u0080\u000e¢\u0006\u0012\n\u0002\u0010Y\u001a\u0005\b\u0091\u0001\u0010V\"\u0005\b\u0092\u0001\u0010XR\u001d\u0010\u0093\u0001\u001a\u00020\fX\u0080\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0094\u0001\u0010\u0014\"\u0005\b\u0095\u0001\u0010\u0016R\u001d\u0010\u0096\u0001\u001a\u00020\fX\u0080\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0097\u0001\u0010\u0014\"\u0005\b\u0098\u0001\u0010\u0016R\u001f\u0010\u0099\u0001\u001a\u00020TX\u0080\u000e¢\u0006\u0012\n\u0002\u0010Y\u001a\u0005\b\u009a\u0001\u0010V\"\u0005\b\u009b\u0001\u0010XR\u001f\u0010\u009c\u0001\u001a\u0004\u0018\u00010[X\u0080\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u009d\u0001\u0010]\"\u0005\b\u009e\u0001\u0010_R\"\u0010\u009f\u0001\u001a\u0005\u0018\u00010 \u0001X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¡\u0001\u0010¢\u0001\"\u0006\b£\u0001\u0010¤\u0001R\"\u0010¥\u0001\u001a\u0005\u0018\u00010¦\u0001X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b§\u0001\u0010¨\u0001\"\u0006\b©\u0001\u0010ª\u0001R \u0010«\u0001\u001a\u00030¬\u0001X\u0080\u000e¢\u0006\u0012\n\u0002\u0010Y\u001a\u0005\b\u00ad\u0001\u0010V\"\u0005\b®\u0001\u0010XR \u0010¯\u0001\u001a\u00030¬\u0001X\u0080\u000e¢\u0006\u0012\n\u0002\u0010Y\u001a\u0005\b°\u0001\u0010V\"\u0005\b±\u0001\u0010XR \u0010²\u0001\u001a\u00030¬\u0001X\u0080\u000e¢\u0006\u0012\n\u0002\u0010Y\u001a\u0005\b³\u0001\u0010V\"\u0005\b´\u0001\u0010XR!\u0010µ\u0001\u001a\u00030¶\u0001X\u0080\u000e¢\u0006\u0013\n\u0003\u0010¹\u0001\u001a\u0005\b·\u0001\u0010\u0014\"\u0005\b¸\u0001\u0010\u0016R#\u0010º\u0001\u001a\u00030»\u0001X\u0080\u000e¢\u0006\u0015\n\u0003\u0010À\u0001\u001a\u0006\b¼\u0001\u0010½\u0001\"\u0006\b¾\u0001\u0010¿\u0001R\u001f\u0010Á\u0001\u001a\u00020\u0006X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÂ\u0001\u0010½\u0001\"\u0006\bÃ\u0001\u0010¿\u0001R\u001f\u0010è\u0001\u001a\n\u0012\u0005\u0012\u00030ç\u00010é\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\bê\u0001\u0010ë\u0001R\u0016\u0010×\u0001\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\bì\u0001\u0010\u0014R\u0016\u0010í\u0001\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\bî\u0001\u0010\u0014R\u0018\u0010Û\u0001\u001a\u00030Ü\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\bï\u0001\u0010ð\u0001R+\u0010Á\u0002\u001a\u0003HÂ\u0002\"\u0005\b\u0000\u0010Â\u0002*\n\u0012\u0005\u0012\u0003HÂ\u00020Ã\u00028VX\u0096\u0004¢\u0006\b\u001a\u0006\bÄ\u0002\u0010Å\u0002R\"\u0010Æ\u0002\u001a\u0005\u0018\u00010Ç\u0002X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÈ\u0002\u0010É\u0002\"\u0006\bÊ\u0002\u0010Ë\u0002R\"\u0010Ì\u0002\u001a\u0005\u0018\u00010Ç\u0002X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÍ\u0002\u0010É\u0002\"\u0006\bÎ\u0002\u0010Ë\u0002R\u0018\u0010Ó\u0002\u001a\u00030Ô\u00028@X\u0080\u0004¢\u0006\b\u001a\u0006\bÕ\u0002\u0010½\u0001R\u0018\u0010Ö\u0002\u001a\u00030×\u00028@X\u0080\u0004¢\u0006\b\u001a\u0006\bØ\u0002\u0010½\u0001R\u0018\u0010Ù\u0002\u001a\u00030Ú\u00028@X\u0080\u0004¢\u0006\b\u001a\u0006\bÛ\u0002\u0010½\u0001R\u0018\u0010Ü\u0002\u001a\u00030Ý\u00028@X\u0080\u0004¢\u0006\b\u001a\u0006\bÞ\u0002\u0010½\u0001R\u0018\u0010ß\u0002\u001a\u00030à\u00028@X\u0080\u0004¢\u0006\b\u001a\u0006\bá\u0002\u0010â\u0002R\u0016\u0010ã\u0002\u001a\u00020\u000f8@X\u0080\u0004¢\u0006\u0007\u001a\u0005\bä\u0002\u0010nR\u0018\u0010å\u0002\u001a\u00030æ\u00028@X\u0080\u0004¢\u0006\b\u001a\u0006\bç\u0002\u0010½\u0001R\u0018\u0010è\u0002\u001a\u00030é\u00028@X\u0080\u0004¢\u0006\b\u001a\u0006\bê\u0002\u0010ë\u0002R\u0018\u0010\u0087\u0003\u001a\u00020\u00068Â\u0002X\u0082\u0004¢\u0006\b\u001a\u0006\b\u0088\u0003\u0010½\u0001¨\u0006\u0089\u0003"}, d2 = {"Landroidx/compose/foundation/style/ResolvedStyle;", "Landroidx/compose/foundation/style/StyleScope;", "Landroidx/compose/ui/platform/InspectableValue;", "<init>", "()V", "compositeHash", "", "currentIndex", "indexStack", "Landroidx/collection/MutableIntList;", DownloaderServiceMarshaller.PARAMS_FLAGS, "_density", "", "_fontScale", "animating", "", "node", "Landroidx/compose/foundation/style/StyleOuterNode;", "contentPaddingStart", "getContentPaddingStart$foundation", "()F", "setContentPaddingStart$foundation", "(F)V", "contentPaddingEnd", "getContentPaddingEnd$foundation", "setContentPaddingEnd$foundation", "contentPaddingTop", "getContentPaddingTop$foundation", "setContentPaddingTop$foundation", "contentPaddingBottom", "getContentPaddingBottom$foundation", "setContentPaddingBottom$foundation", "externalPaddingStart", "getExternalPaddingStart$foundation", "setExternalPaddingStart$foundation", "externalPaddingEnd", "getExternalPaddingEnd$foundation", "setExternalPaddingEnd$foundation", "externalPaddingTop", "getExternalPaddingTop$foundation", "setExternalPaddingTop$foundation", "externalPaddingBottom", "getExternalPaddingBottom$foundation", "setExternalPaddingBottom$foundation", "borderWidth", "getBorderWidth$foundation", "setBorderWidth$foundation", "width", "getWidth$foundation", "setWidth$foundation", "height", "getHeight$foundation", "setHeight$foundation", "widthFraction", "getWidthFraction$foundation", "setWidthFraction$foundation", "heightFraction", "getHeightFraction$foundation", "setHeightFraction$foundation", TtmlNode.LEFT, "getLeft$foundation", "setLeft$foundation", "top", "getTop$foundation", "setTop$foundation", TtmlNode.RIGHT, "getRight$foundation", "setRight$foundation", "bottom", "getBottom$foundation", "setBottom$foundation", "minHeight", "getMinHeight$foundation", "setMinHeight$foundation", "maxHeight", "getMaxHeight$foundation", "setMaxHeight$foundation", "minWidth", "getMinWidth$foundation", "setMinWidth$foundation", "maxWidth", "getMaxWidth$foundation", "setMaxWidth$foundation", "borderColor", "Landroidx/compose/ui/graphics/Color;", "getBorderColor-0d7_KjU$foundation", "()J", "setBorderColor-8_81llA$foundation", "(J)V", "J", "borderBrush", "Landroidx/compose/ui/graphics/Brush;", "getBorderBrush$foundation", "()Landroidx/compose/ui/graphics/Brush;", "setBorderBrush$foundation", "(Landroidx/compose/ui/graphics/Brush;)V", TtmlNode.ATTR_TTS_BACKGROUND_COLOR, "getBackgroundColor-0d7_KjU$foundation", "setBackgroundColor-8_81llA$foundation", "backgroundBrush", "getBackgroundBrush$foundation", "setBackgroundBrush$foundation", "foregroundColor", "getForegroundColor-0d7_KjU$foundation", "setForegroundColor-8_81llA$foundation", "foregroundBrush", "getForegroundBrush$foundation", "setForegroundBrush$foundation", "clip", "getClip$foundation", "()Z", "setClip$foundation", "(Z)V", "shape", "Landroidx/compose/ui/graphics/Shape;", "getShape$foundation", "()Landroidx/compose/ui/graphics/Shape;", "setShape$foundation", "(Landroidx/compose/ui/graphics/Shape;)V", "alpha", "getAlpha$foundation", "setAlpha$foundation", "scaleX", "getScaleX$foundation", "setScaleX$foundation", "scaleY", "getScaleY$foundation", "setScaleY$foundation", "translationX", "getTranslationX$foundation", "setTranslationX$foundation", "translationY", "getTranslationY$foundation", "setTranslationY$foundation", "rotationX", "getRotationX$foundation", "setRotationX$foundation", "rotationY", "getRotationY$foundation", "setRotationY$foundation", "rotationZ", "getRotationZ$foundation", "setRotationZ$foundation", "transformOrigin", "Landroidx/compose/ui/graphics/TransformOrigin;", "getTransformOrigin-SzJe1aQ$foundation", "setTransformOrigin-__ExYCQ$foundation", "cameraDistance", "getCameraDistance$foundation", "setCameraDistance$foundation", "zIndex", "getZIndex$foundation", "setZIndex$foundation", "contentColor", "getContentColor-0d7_KjU$foundation", "setContentColor-8_81llA$foundation", "contentBrush", "getContentBrush$foundation", "setContentBrush$foundation", TtmlNode.ATTR_TTS_FONT_FAMILY, "Landroidx/compose/ui/text/font/FontFamily;", "getFontFamily$foundation", "()Landroidx/compose/ui/text/font/FontFamily;", "setFontFamily$foundation", "(Landroidx/compose/ui/text/font/FontFamily;)V", "textIndent", "Landroidx/compose/ui/text/style/TextIndent;", "getTextIndent$foundation", "()Landroidx/compose/ui/text/style/TextIndent;", "setTextIndent$foundation", "(Landroidx/compose/ui/text/style/TextIndent;)V", TtmlNode.ATTR_TTS_FONT_SIZE, "Landroidx/compose/ui/unit/TextUnit;", "getFontSize-XSAIIZE$foundation", "setFontSize--R2X_6o$foundation", "lineHeight", "getLineHeight-XSAIIZE$foundation", "setLineHeight--R2X_6o$foundation", "letterSpacing", "getLetterSpacing-XSAIIZE$foundation", "setLetterSpacing--R2X_6o$foundation", "baselineShift", "Landroidx/compose/ui/text/style/BaselineShift;", "getBaselineShift-y9eOQZs$foundation", "setBaselineShift-4Dl_Bck$foundation", "F", "lineBreak", "Landroidx/compose/ui/text/style/LineBreak;", "getLineBreak-rAG3T2k$foundation", "()I", "setLineBreak-CZqVlQI$foundation", "(I)V", "I", "textEnums", "getTextEnums$foundation", "setTextEnums$foundation", "diff", "other", "filterFlags", "diff$foundation", "copy", "copy$foundation", "copyInheritedStyles", "copyInheritedStyles$foundation", "copyInheritedStylesInto", "", TypedValues.AttributesType.S_TARGET, "copyInheritedStylesInto$foundation", "copyInto", "copyInto$foundation", "clear", "clear$foundation", "resolve", "style", "Landroidx/compose/foundation/style/Style;", "density", "Landroidx/compose/ui/unit/Density;", "resolve$foundation", "resolveForTesting", RemoteConfigConstants.ResponseFieldKey.STATE, "Landroidx/compose/foundation/style/StyleState;", "resolveForTesting$foundation", "applyInheritableStyles", "source", "applyInheritableStyles$foundation", "toTextStyle", "Landroidx/compose/ui/text/TextStyle;", "fallback", "toTextStyle$foundation", "valueElements", "", "Landroidx/compose/ui/platform/ValueElement;", "inspectableElements", "Lkotlin/sequences/Sequence;", "getInspectableElements", "()Lkotlin/sequences/Sequence;", "getDensity", "fontScale", "getFontScale", "getState", "()Landroidx/compose/foundation/style/StyleState;", "value", "Landroidx/compose/ui/unit/Dp;", "contentPaddingStart-0680j_4", "contentPaddingEnd-0680j_4", "contentPaddingTop-0680j_4", "contentPaddingBottom-0680j_4", "contentPaddingHorizontal", "contentPaddingHorizontal-0680j_4", "contentPaddingVertical", "contentPaddingVertical-0680j_4", "contentPadding", "contentPadding-0680j_4", TtmlNode.START, TtmlNode.END, "contentPadding-a9UjIt4", "(FFFF)V", "horizontal", "vertical", "contentPadding-YgX7TsA", "(FF)V", "externalPaddingStart-0680j_4", "externalPaddingEnd-0680j_4", "externalPaddingTop-0680j_4", "externalPaddingBottom-0680j_4", "externalPaddingHorizontal", "externalPaddingHorizontal-0680j_4", "externalPaddingVertical", "externalPaddingVertical-0680j_4", "externalPadding", "externalPadding-0680j_4", "externalPadding-a9UjIt4", "externalPadding-YgX7TsA", "borderWidth-0680j_4", "borderColor-8_81llA", "border", "color", "border-cXLIe8U", "(FJ)V", "brush", "border-D5KLDUw", "(FLandroidx/compose/ui/graphics/Brush;)V", "width-0680j_4", "height-0680j_4", "size", "size-YgX7TsA", "size-0680j_4", "Landroidx/compose/ui/unit/DpSize;", "size-EaSLcWc", "fraction", "left-0680j_4", "top-0680j_4", "right-0680j_4", "bottom-0680j_4", "minWidth-0680j_4", "minHeight-0680j_4", "minSize", "minSize-EaSLcWc", "minSize-YgX7TsA", "maxWidth-0680j_4", "maxHeight-0680j_4", "maxSize", "maxSize-EaSLcWc", "maxSize-YgX7TsA", "scale", "translation", "x", "y", TypedValues.CycleType.S_WAVE_OFFSET, "Landroidx/compose/ui/geometry/Offset;", "translation-k-4lQ0M", "transformOrigin-__ExYCQ", M2.g, "background-8_81llA", "foreground", "foreground-8_81llA", "animate", "spec", "Landroidx/compose/animation/core/AnimationSpec;", "toSpec", "fromSpec", "currentValue", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/compose/runtime/CompositionLocal;", "getCurrentValue", "(Landroidx/compose/runtime/CompositionLocal;)Ljava/lang/Object;", "dropShadow", "", "getDropShadow$foundation", "()Ljava/lang/Object;", "setDropShadow$foundation", "(Ljava/lang/Object;)V", "innerShadow", "getInnerShadow$foundation", "setInnerShadow$foundation", "Landroidx/compose/ui/graphics/shadow/Shadow;", "", "([Landroidx/compose/ui/graphics/shadow/Shadow;)V", "textStyle", TtmlNode.ATTR_TTS_FONT_STYLE, "Landroidx/compose/ui/text/font/FontStyle;", "getFontStyle-_-LCdwA$foundation", TtmlNode.ATTR_TTS_TEXT_ALIGN, "Landroidx/compose/ui/text/style/TextAlign;", "getTextAlign-e0LSkKk$foundation", "textDirection", "Landroidx/compose/ui/text/style/TextDirection;", "getTextDirection-s_7X-co$foundation", "hyphens", "Landroidx/compose/ui/text/style/Hyphens;", "getHyphens-vmbZdU8$foundation", TtmlNode.ATTR_TTS_FONT_WEIGHT, "Landroidx/compose/ui/text/font/FontWeight;", "getFontWeight$foundation", "()Landroidx/compose/ui/text/font/FontWeight;", "isFontWeightSpecified", "isFontWeightSpecified$foundation", "fontSynthesis", "Landroidx/compose/ui/text/font/FontSynthesis;", "getFontSynthesis-GVVA2EU$foundation", TtmlNode.ATTR_TTS_TEXT_DECORATION, "Landroidx/compose/ui/text/style/TextDecoration;", "getTextDecoration$foundation", "()Landroidx/compose/ui/text/style/TextDecoration;", "contentColor-8_81llA", "fontSize--R2X_6o", "lineHeight--R2X_6o", "letterSpacing--R2X_6o", "baselineShift-4Dl_Bck", "lineBreak-CZqVlQI", "fontStyle-nzbMABs", "textAlign-aXe7zB0", "textDirection-Hejc4pk", "hyphens--3fSNIE", "fontSynthesis-6p3vJLY", "key", "Landroidx/compose/foundation/style/StyleStateKey;", AppMeasurementSdk.ConditionalUserProperty.ACTIVE, "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "startResolve", "startResolve$foundation", "doneResolve", "doneResolve$foundation", "pushIndex", FirebaseAnalytics.Param.INDEX, "group", "block", "Lkotlin/Function0;", "skippedGroup", "currentCompositeHash", "getCurrentCompositeHash", "foundation"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ResolvedStyle implements StyleScope, InspectableValue {
    public static final int $stable = 0;
    private boolean animating;
    private Brush backgroundBrush;
    private Brush borderBrush;
    private float borderWidth;
    private boolean clip;
    private int compositeHash;
    private Brush contentBrush;
    private float contentPaddingBottom;
    private float contentPaddingEnd;
    private float contentPaddingStart;
    private float contentPaddingTop;
    private int currentIndex;
    private Object dropShadow;
    private float externalPaddingBottom;
    private float externalPaddingEnd;
    private float externalPaddingStart;
    private float externalPaddingTop;
    public int flags;
    private FontFamily fontFamily;
    private Brush foregroundBrush;
    private MutableIntList indexStack;
    private Object innerShadow;
    private StyleOuterNode node;
    private float rotationX;
    private float rotationY;
    private float rotationZ;
    private int textEnums;
    private TextIndent textIndent;
    private float translationX;
    private float translationY;
    private float zIndex;
    private float _density = 1.0f;
    private float _fontScale = 1.0f;
    private float width = Float.NaN;
    private float height = Float.NaN;
    private float widthFraction = Float.NaN;
    private float heightFraction = Float.NaN;
    private float left = Float.NaN;
    private float top = Float.NaN;
    private float right = Float.NaN;
    private float bottom = Float.NaN;
    private float minHeight = Float.NaN;
    private float maxHeight = Float.NaN;
    private float minWidth = Float.NaN;
    private float maxWidth = Float.NaN;
    private long borderColor = Color.Companion.m5374getBlack0d7_KjU();
    private long backgroundColor = Color.Companion.m5383getTransparent0d7_KjU();
    private long foregroundColor = Color.Companion.m5384getUnspecified0d7_KjU();
    private Shape shape = RectangleShapeKt.getRectangleShape();
    private float alpha = 1.0f;
    private float scaleX = 1.0f;
    private float scaleY = 1.0f;
    private long transformOrigin = TransformOrigin.Companion.m5761getCenterSzJe1aQ();
    private float cameraDistance = 1.0f;
    private long contentColor = Color.Companion.m5384getUnspecified0d7_KjU();
    private long fontSize = TextUnit.Companion.m8365getUnspecifiedXSAIIZE();
    private long lineHeight = TextUnit.Companion.m8365getUnspecifiedXSAIIZE();
    private long letterSpacing = TextUnit.Companion.m8365getUnspecifiedXSAIIZE();
    private float baselineShift = BaselineShift.Companion.m7914getUnspecifiedy9eOQZs();
    private int lineBreak = LineBreak.Companion.m7956getUnspecifiedrAG3T2k();

    public final float getContentPaddingStart$foundation() {
        return this.contentPaddingStart;
    }

    public final void setContentPaddingStart$foundation(float f) {
        this.contentPaddingStart = f;
    }

    public final float getContentPaddingEnd$foundation() {
        return this.contentPaddingEnd;
    }

    public final void setContentPaddingEnd$foundation(float f) {
        this.contentPaddingEnd = f;
    }

    public final float getContentPaddingTop$foundation() {
        return this.contentPaddingTop;
    }

    public final void setContentPaddingTop$foundation(float f) {
        this.contentPaddingTop = f;
    }

    public final float getContentPaddingBottom$foundation() {
        return this.contentPaddingBottom;
    }

    public final void setContentPaddingBottom$foundation(float f) {
        this.contentPaddingBottom = f;
    }

    public final float getExternalPaddingStart$foundation() {
        return this.externalPaddingStart;
    }

    public final void setExternalPaddingStart$foundation(float f) {
        this.externalPaddingStart = f;
    }

    public final float getExternalPaddingEnd$foundation() {
        return this.externalPaddingEnd;
    }

    public final void setExternalPaddingEnd$foundation(float f) {
        this.externalPaddingEnd = f;
    }

    public final float getExternalPaddingTop$foundation() {
        return this.externalPaddingTop;
    }

    public final void setExternalPaddingTop$foundation(float f) {
        this.externalPaddingTop = f;
    }

    public final float getExternalPaddingBottom$foundation() {
        return this.externalPaddingBottom;
    }

    public final void setExternalPaddingBottom$foundation(float f) {
        this.externalPaddingBottom = f;
    }

    public final float getBorderWidth$foundation() {
        return this.borderWidth;
    }

    public final void setBorderWidth$foundation(float f) {
        this.borderWidth = f;
    }

    public final float getWidth$foundation() {
        return this.width;
    }

    public final void setWidth$foundation(float f) {
        this.width = f;
    }

    public final float getHeight$foundation() {
        return this.height;
    }

    public final void setHeight$foundation(float f) {
        this.height = f;
    }

    public final float getWidthFraction$foundation() {
        return this.widthFraction;
    }

    public final void setWidthFraction$foundation(float f) {
        this.widthFraction = f;
    }

    public final float getHeightFraction$foundation() {
        return this.heightFraction;
    }

    public final void setHeightFraction$foundation(float f) {
        this.heightFraction = f;
    }

    public final float getLeft$foundation() {
        return this.left;
    }

    public final void setLeft$foundation(float f) {
        this.left = f;
    }

    public final float getTop$foundation() {
        return this.top;
    }

    public final void setTop$foundation(float f) {
        this.top = f;
    }

    public final float getRight$foundation() {
        return this.right;
    }

    public final void setRight$foundation(float f) {
        this.right = f;
    }

    public final float getBottom$foundation() {
        return this.bottom;
    }

    public final void setBottom$foundation(float f) {
        this.bottom = f;
    }

    public final float getMinHeight$foundation() {
        return this.minHeight;
    }

    public final void setMinHeight$foundation(float f) {
        this.minHeight = f;
    }

    public final float getMaxHeight$foundation() {
        return this.maxHeight;
    }

    public final void setMaxHeight$foundation(float f) {
        this.maxHeight = f;
    }

    public final float getMinWidth$foundation() {
        return this.minWidth;
    }

    public final void setMinWidth$foundation(float f) {
        this.minWidth = f;
    }

    public final float getMaxWidth$foundation() {
        return this.maxWidth;
    }

    public final void setMaxWidth$foundation(float f) {
        this.maxWidth = f;
    }

    /* renamed from: getBorderColor-0d7_KjU$foundation  reason: not valid java name */
    public final long m1415getBorderColor0d7_KjU$foundation() {
        return this.borderColor;
    }

    /* renamed from: setBorderColor-8_81llA$foundation  reason: not valid java name */
    public final void m1445setBorderColor8_81llA$foundation(long j) {
        this.borderColor = j;
    }

    public final Brush getBorderBrush$foundation() {
        return this.borderBrush;
    }

    public final void setBorderBrush$foundation(Brush brush) {
        this.borderBrush = brush;
    }

    /* renamed from: getBackgroundColor-0d7_KjU$foundation  reason: not valid java name */
    public final long m1413getBackgroundColor0d7_KjU$foundation() {
        return this.backgroundColor;
    }

    /* renamed from: setBackgroundColor-8_81llA$foundation  reason: not valid java name */
    public final void m1443setBackgroundColor8_81llA$foundation(long j) {
        this.backgroundColor = j;
    }

    public final Brush getBackgroundBrush$foundation() {
        return this.backgroundBrush;
    }

    public final void setBackgroundBrush$foundation(Brush brush) {
        this.backgroundBrush = brush;
    }

    /* renamed from: getForegroundColor-0d7_KjU$foundation  reason: not valid java name */
    public final long m1420getForegroundColor0d7_KjU$foundation() {
        return this.foregroundColor;
    }

    /* renamed from: setForegroundColor-8_81llA$foundation  reason: not valid java name */
    public final void m1448setForegroundColor8_81llA$foundation(long j) {
        this.foregroundColor = j;
    }

    public final Brush getForegroundBrush$foundation() {
        return this.foregroundBrush;
    }

    public final void setForegroundBrush$foundation(Brush brush) {
        this.foregroundBrush = brush;
    }

    public final boolean getClip$foundation() {
        return this.clip;
    }

    public final void setClip$foundation(boolean z) {
        this.clip = z;
    }

    public final Shape getShape$foundation() {
        return this.shape;
    }

    public final void setShape$foundation(Shape shape) {
        this.shape = shape;
    }

    public final float getAlpha$foundation() {
        return this.alpha;
    }

    public final void setAlpha$foundation(float f) {
        this.alpha = f;
    }

    public final float getScaleX$foundation() {
        return this.scaleX;
    }

    public final void setScaleX$foundation(float f) {
        this.scaleX = f;
    }

    public final float getScaleY$foundation() {
        return this.scaleY;
    }

    public final void setScaleY$foundation(float f) {
        this.scaleY = f;
    }

    public final float getTranslationX$foundation() {
        return this.translationX;
    }

    public final void setTranslationX$foundation(float f) {
        this.translationX = f;
    }

    public final float getTranslationY$foundation() {
        return this.translationY;
    }

    public final void setTranslationY$foundation(float f) {
        this.translationY = f;
    }

    public final float getRotationX$foundation() {
        return this.rotationX;
    }

    public final void setRotationX$foundation(float f) {
        this.rotationX = f;
    }

    public final float getRotationY$foundation() {
        return this.rotationY;
    }

    public final void setRotationY$foundation(float f) {
        this.rotationY = f;
    }

    public final float getRotationZ$foundation() {
        return this.rotationZ;
    }

    public final void setRotationZ$foundation(float f) {
        this.rotationZ = f;
    }

    /* renamed from: getTransformOrigin-SzJe1aQ$foundation  reason: not valid java name */
    public final long m1427getTransformOriginSzJe1aQ$foundation() {
        return this.transformOrigin;
    }

    /* renamed from: setTransformOrigin-__ExYCQ$foundation  reason: not valid java name */
    public final void m1452setTransformOrigin__ExYCQ$foundation(long j) {
        this.transformOrigin = j;
    }

    public final float getCameraDistance$foundation() {
        return this.cameraDistance;
    }

    public final void setCameraDistance$foundation(float f) {
        this.cameraDistance = f;
    }

    public final float getZIndex$foundation() {
        return this.zIndex;
    }

    public final void setZIndex$foundation(float f) {
        this.zIndex = f;
    }

    /* renamed from: getContentColor-0d7_KjU$foundation  reason: not valid java name */
    public final long m1416getContentColor0d7_KjU$foundation() {
        return this.contentColor;
    }

    /* renamed from: setContentColor-8_81llA$foundation  reason: not valid java name */
    public final void m1446setContentColor8_81llA$foundation(long j) {
        this.contentColor = j;
    }

    public final Brush getContentBrush$foundation() {
        return this.contentBrush;
    }

    public final void setContentBrush$foundation(Brush brush) {
        this.contentBrush = brush;
    }

    public final FontFamily getFontFamily$foundation() {
        return this.fontFamily;
    }

    public final void setFontFamily$foundation(FontFamily fontFamily) {
        this.fontFamily = fontFamily;
    }

    public final TextIndent getTextIndent$foundation() {
        return this.textIndent;
    }

    public final void setTextIndent$foundation(TextIndent textIndent) {
        this.textIndent = textIndent;
    }

    /* renamed from: getFontSize-XSAIIZE$foundation  reason: not valid java name */
    public final long m1417getFontSizeXSAIIZE$foundation() {
        return this.fontSize;
    }

    /* renamed from: setFontSize--R2X_6o$foundation  reason: not valid java name */
    public final void m1447setFontSizeR2X_6o$foundation(long j) {
        this.fontSize = j;
    }

    /* renamed from: getLineHeight-XSAIIZE$foundation  reason: not valid java name */
    public final long m1424getLineHeightXSAIIZE$foundation() {
        return this.lineHeight;
    }

    /* renamed from: setLineHeight--R2X_6o$foundation  reason: not valid java name */
    public final void m1451setLineHeightR2X_6o$foundation(long j) {
        this.lineHeight = j;
    }

    /* renamed from: getLetterSpacing-XSAIIZE$foundation  reason: not valid java name */
    public final long m1422getLetterSpacingXSAIIZE$foundation() {
        return this.letterSpacing;
    }

    /* renamed from: setLetterSpacing--R2X_6o$foundation  reason: not valid java name */
    public final void m1449setLetterSpacingR2X_6o$foundation(long j) {
        this.letterSpacing = j;
    }

    /* renamed from: getBaselineShift-y9eOQZs$foundation  reason: not valid java name */
    public final float m1414getBaselineShifty9eOQZs$foundation() {
        return this.baselineShift;
    }

    /* renamed from: setBaselineShift-4Dl_Bck$foundation  reason: not valid java name */
    public final void m1444setBaselineShift4Dl_Bck$foundation(float f) {
        this.baselineShift = f;
    }

    /* renamed from: getLineBreak-rAG3T2k$foundation  reason: not valid java name */
    public final int m1423getLineBreakrAG3T2k$foundation() {
        return this.lineBreak;
    }

    /* renamed from: setLineBreak-CZqVlQI$foundation  reason: not valid java name */
    public final void m1450setLineBreakCZqVlQI$foundation(int i) {
        this.lineBreak = i;
    }

    public final int getTextEnums$foundation() {
        return this.textEnums;
    }

    public final void setTextEnums$foundation(int i) {
        this.textEnums = i;
    }

    public static /* synthetic */ int diff$foundation$default(ResolvedStyle resolvedStyle, ResolvedStyle resolvedStyle2, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = -1;
        }
        return resolvedStyle.diff$foundation(resolvedStyle2, i);
    }

    public final int diff$foundation(ResolvedStyle resolvedStyle, int i) {
        int i2 = this.flags;
        int i3 = resolvedStyle.flags;
        int i4 = i2 ^ i3;
        int i5 = i & i2 & i3;
        if ((i5 & 1) != 0 && (this.contentPaddingStart != resolvedStyle.contentPaddingStart || this.contentPaddingEnd != resolvedStyle.contentPaddingEnd || this.contentPaddingTop != resolvedStyle.contentPaddingTop || this.contentPaddingBottom != resolvedStyle.contentPaddingBottom || this.borderWidth != resolvedStyle.borderWidth)) {
            i4 |= 1;
        }
        if ((i5 & 8) != 0 && (this.width != resolvedStyle.width || this.height != resolvedStyle.height || this.widthFraction != resolvedStyle.widthFraction || this.heightFraction != resolvedStyle.heightFraction || this.externalPaddingStart != resolvedStyle.externalPaddingStart || this.externalPaddingEnd != resolvedStyle.externalPaddingEnd || this.externalPaddingTop != resolvedStyle.externalPaddingTop || this.externalPaddingBottom != resolvedStyle.externalPaddingBottom || Float.floatToRawIntBits(this.left) != Float.floatToRawIntBits(resolvedStyle.left) || Float.floatToRawIntBits(this.top) != Float.floatToRawIntBits(resolvedStyle.top) || Float.floatToRawIntBits(this.right) != Float.floatToRawIntBits(resolvedStyle.right) || Float.floatToRawIntBits(this.bottom) != Float.floatToRawIntBits(resolvedStyle.bottom) || Float.floatToRawIntBits(this.minWidth) != Float.floatToRawIntBits(resolvedStyle.minWidth) || Float.floatToRawIntBits(this.maxWidth) != Float.floatToRawIntBits(resolvedStyle.maxWidth) || Float.floatToRawIntBits(this.minHeight) != Float.floatToRawIntBits(resolvedStyle.minHeight) || Float.floatToRawIntBits(this.maxHeight) != Float.floatToRawIntBits(resolvedStyle.maxHeight))) {
            i4 |= 8;
        }
        if ((i5 & 2) != 0 && (this.borderWidth != resolvedStyle.borderWidth || !Color.m5349equalsimpl0(this.borderColor, resolvedStyle.borderColor) || !Intrinsics.areEqual(this.borderBrush, resolvedStyle.borderBrush) || !Color.m5349equalsimpl0(this.backgroundColor, resolvedStyle.backgroundColor) || !Intrinsics.areEqual(this.backgroundBrush, resolvedStyle.backgroundBrush) || !Intrinsics.areEqual(this.foregroundBrush, resolvedStyle.foregroundBrush) || !Intrinsics.areEqual(this.innerShadow, resolvedStyle.innerShadow) || !Intrinsics.areEqual(this.dropShadow, resolvedStyle.dropShadow) || !Intrinsics.areEqual(this.shape, resolvedStyle.shape))) {
            i4 |= 2;
        }
        if ((i5 & 4) != 0 && (this.alpha != resolvedStyle.alpha || this.scaleX != resolvedStyle.scaleX || this.scaleY != resolvedStyle.scaleY || this.translationX != resolvedStyle.translationX || this.translationY != resolvedStyle.translationY || this.rotationX != resolvedStyle.rotationX || this.rotationY != resolvedStyle.rotationY || this.rotationZ != resolvedStyle.rotationZ || !TransformOrigin.m5755equalsimpl0(this.transformOrigin, resolvedStyle.transformOrigin) || this.clip != resolvedStyle.clip)) {
            i4 |= 4;
        }
        if (!Intrinsics.areEqual(this.shape, resolvedStyle.shape)) {
            i4 |= 6;
        }
        if ((i5 & 64) != 0 && (!Color.m5349equalsimpl0(this.contentColor, resolvedStyle.contentColor) || !Intrinsics.areEqual(this.contentBrush, resolvedStyle.contentBrush))) {
            i4 |= 64;
        }
        return ((i5 & 32) == 0 || (Intrinsics.areEqual(this.fontFamily, resolvedStyle.fontFamily) && Intrinsics.areEqual(this.textIndent, resolvedStyle.textIndent) && TextUnit.m8351equalsimpl0(this.fontSize, resolvedStyle.fontSize) && TextUnit.m8351equalsimpl0(this.lineHeight, resolvedStyle.lineHeight) && TextUnit.m8351equalsimpl0(this.letterSpacing, resolvedStyle.letterSpacing) && BaselineShift.m7903equalsimpl0(this.baselineShift, resolvedStyle.baselineShift) && LineBreak.m7942equalsimpl0(this.lineBreak, resolvedStyle.lineBreak) && this.textEnums == resolvedStyle.textEnums)) ? i4 : i4 | 96;
    }

    public final ResolvedStyle copy$foundation() {
        ResolvedStyle resolvedStyle = new ResolvedStyle();
        copyInto$foundation(resolvedStyle);
        return resolvedStyle;
    }

    public final ResolvedStyle copyInheritedStyles$foundation() {
        ResolvedStyle resolvedStyle = new ResolvedStyle();
        copyInheritedStylesInto$foundation(resolvedStyle);
        return resolvedStyle;
    }

    public final void copyInheritedStylesInto$foundation(ResolvedStyle resolvedStyle) {
        resolvedStyle.contentColor = this.contentColor;
        resolvedStyle.contentBrush = this.contentBrush;
        resolvedStyle.fontFamily = this.fontFamily;
        resolvedStyle.textIndent = this.textIndent;
        resolvedStyle.fontSize = this.fontSize;
        resolvedStyle.lineHeight = this.lineHeight;
        resolvedStyle.letterSpacing = this.letterSpacing;
        resolvedStyle.baselineShift = this.baselineShift;
        resolvedStyle.lineBreak = this.lineBreak;
        resolvedStyle.textEnums = this.textEnums;
    }

    public final void copyInto$foundation(ResolvedStyle resolvedStyle) {
        resolvedStyle.flags = this.flags;
        resolvedStyle.left = this.left;
        resolvedStyle.top = this.top;
        resolvedStyle.right = this.right;
        resolvedStyle.bottom = this.bottom;
        resolvedStyle.minHeight = this.minHeight;
        resolvedStyle.maxHeight = this.maxHeight;
        resolvedStyle.minWidth = this.minWidth;
        resolvedStyle.maxWidth = this.maxWidth;
        resolvedStyle.contentPaddingStart = this.contentPaddingStart;
        resolvedStyle.contentPaddingEnd = this.contentPaddingEnd;
        resolvedStyle.contentPaddingTop = this.contentPaddingTop;
        resolvedStyle.contentPaddingBottom = this.contentPaddingBottom;
        resolvedStyle.externalPaddingStart = this.externalPaddingStart;
        resolvedStyle.externalPaddingEnd = this.externalPaddingEnd;
        resolvedStyle.externalPaddingTop = this.externalPaddingTop;
        resolvedStyle.externalPaddingBottom = this.externalPaddingBottom;
        resolvedStyle.borderWidth = this.borderWidth;
        resolvedStyle.shape = this.shape;
        resolvedStyle.alpha = this.alpha;
        resolvedStyle.scaleX = this.scaleX;
        resolvedStyle.scaleY = this.scaleY;
        resolvedStyle.translationX = this.translationX;
        resolvedStyle.translationY = this.translationY;
        resolvedStyle.rotationX = this.rotationX;
        resolvedStyle.rotationY = this.rotationY;
        resolvedStyle.rotationZ = this.rotationZ;
        resolvedStyle.transformOrigin = this.transformOrigin;
        resolvedStyle.zIndex = this.zIndex;
        resolvedStyle.cameraDistance = this.cameraDistance;
        resolvedStyle.borderColor = this.borderColor;
        resolvedStyle.borderBrush = this.borderBrush;
        resolvedStyle.backgroundColor = this.backgroundColor;
        resolvedStyle.backgroundBrush = this.backgroundBrush;
        resolvedStyle.foregroundBrush = this.foregroundBrush;
        resolvedStyle.dropShadow = this.dropShadow;
        resolvedStyle.innerShadow = this.innerShadow;
        resolvedStyle.clip = this.clip;
        resolvedStyle.width = this.width;
        resolvedStyle.height = this.height;
        resolvedStyle.widthFraction = this.widthFraction;
        resolvedStyle.heightFraction = this.heightFraction;
        copyInheritedStylesInto$foundation(resolvedStyle);
    }

    public final void clear$foundation() {
        ResolvedStyleKt.access$getEmptyResolvedStyle$p().copyInto$foundation(this);
    }

    public final void resolve$foundation(Style style, StyleOuterNode styleOuterNode, Density density, boolean z) {
        startResolve$foundation(styleOuterNode, density, z);
        style.applyStyle(this);
        doneResolve$foundation();
    }

    public static /* synthetic */ void resolveForTesting$foundation$default(ResolvedStyle resolvedStyle, Style style, Density density, boolean z, StyleState styleState, int i, Object obj) {
        if ((i & 8) != 0) {
            styleState = null;
        }
        resolvedStyle.resolveForTesting$foundation(style, density, z, styleState);
    }

    public final void resolveForTesting$foundation(Style style, Density density, boolean z, StyleState styleState) {
        this.currentIndex = 0;
        this.compositeHash = 0;
        this.node = new StyleOuterNode(styleState, style);
        this._density = density.getDensity();
        this.animating = z;
        style.applyStyle(this);
        doneResolve$foundation();
    }

    public final void applyInheritableStyles$foundation(ResolvedStyle resolvedStyle) {
        int i = resolvedStyle.flags & 96;
        if (i == 0) {
            return;
        }
        this.flags = i | this.flags;
        long j = resolvedStyle.contentColor;
        long j2 = this.contentColor;
        if (j == 16) {
            j = j2;
        }
        this.contentColor = j;
        Brush brush = resolvedStyle.contentBrush;
        if (brush == null) {
            brush = this.contentBrush;
        }
        this.contentBrush = brush;
        FontFamily fontFamily = resolvedStyle.fontFamily;
        if (fontFamily == null) {
            fontFamily = this.fontFamily;
        }
        this.fontFamily = fontFamily;
        TextIndent textIndent = resolvedStyle.textIndent;
        if (textIndent == null) {
            textIndent = this.textIndent;
        }
        this.textIndent = textIndent;
        long j3 = resolvedStyle.fontSize;
        long j4 = this.fontSize;
        if (TextUnit.m8352getRawTypeimpl(j3) == 0) {
            j3 = j4;
        }
        this.fontSize = j3;
        long j5 = resolvedStyle.lineHeight;
        long j6 = this.lineHeight;
        if (TextUnit.m8352getRawTypeimpl(j5) == 0) {
            j5 = j6;
        }
        this.lineHeight = j5;
        long j7 = resolvedStyle.letterSpacing;
        long j8 = this.letterSpacing;
        if (TextUnit.m8352getRawTypeimpl(j7) == 0) {
            j7 = j8;
        }
        this.letterSpacing = j7;
        float f = resolvedStyle.baselineShift;
        float f2 = this.baselineShift;
        if (!BaselineShift.m7903equalsimpl0(f, BaselineShift.Companion.m7914getUnspecifiedy9eOQZs())) {
            f = f2;
        }
        this.baselineShift = f;
        int i2 = resolvedStyle.lineBreak;
        int i3 = this.lineBreak;
        if (LineBreak.m7942equalsimpl0(i2, LineBreak.Companion.m7956getUnspecifiedrAG3T2k())) {
            i2 = i3;
        }
        this.lineBreak = i2;
        int i4 = this.textEnums;
        int i5 = resolvedStyle.textEnums;
        int i6 = i5 & 3;
        int i7 = i4 & (-4);
        if (i6 != 0) {
            i4 = i6;
        }
        int i8 = i4 | i7;
        int i9 = i5 & 28;
        int i10 = i8 & (-29);
        if (i9 != 0) {
            i8 = i9;
        }
        int i11 = i8 | i10;
        int i12 = i5 & 112;
        int i13 = i11 & (-113);
        if (i12 != 0) {
            i11 = i12;
        }
        int i14 = i11 | i13;
        int i15 = i5 & ViewUtils.EDGE_TO_EDGE_FLAGS;
        int i16 = i14 & (-769);
        if (i15 != 0) {
            i14 = i15;
        }
        int i17 = i14 | i16;
        int i18 = i5 & 15360;
        int i19 = i17 & (-15361);
        if (i18 != 0) {
            i17 = i18;
        }
        int i20 = i17 | i19;
        int i21 = i5 & 134086656;
        int i22 = (-134086657) & i20;
        if (i21 != 0) {
            i20 = i21;
        }
        this.textEnums = i22 | i20;
    }

    public final TextStyle toTextStyle$foundation(TextStyle textStyle) {
        ResolvedStyle access$getEmptyResolvedStyle$p = ResolvedStyleKt.access$getEmptyResolvedStyle$p();
        long j = this.contentColor;
        if (j == 16) {
            j = textStyle.m7638getColor0d7_KjU();
        }
        long j2 = j;
        long j3 = this.fontSize;
        long m7639getFontSizeXSAIIZE = textStyle.m7639getFontSizeXSAIIZE();
        if (!(TextUnit.m8352getRawTypeimpl(j3) == 0)) {
            m7639getFontSizeXSAIIZE = j3;
        }
        FontWeight fontWeight$foundation = isFontWeightSpecified$foundation() ? getFontWeight$foundation() : textStyle.getFontWeight();
        FontStyle m7717boximpl = !FontStyle.m7720equalsimpl0(m1418getFontStyle_LCdwA$foundation(), access$getEmptyResolvedStyle$p.m1418getFontStyle_LCdwA$foundation()) ? FontStyle.m7717boximpl(m1418getFontStyle_LCdwA$foundation()) : textStyle.m7640getFontStyle4Lr2A7w();
        FontSynthesis m7728boximpl = !FontSynthesis.m7731equalsimpl0(m1419getFontSynthesisGVVA2EU$foundation(), access$getEmptyResolvedStyle$p.m1419getFontSynthesisGVVA2EU$foundation()) ? FontSynthesis.m7728boximpl(m1419getFontSynthesisGVVA2EU$foundation()) : textStyle.m7641getFontSynthesisZQGJjVo();
        FontFamily fontFamily = this.fontFamily;
        if (fontFamily == null) {
            fontFamily = textStyle.getFontFamily();
        }
        String fontFeatureSettings = textStyle.getFontFeatureSettings();
        long j4 = this.letterSpacing;
        long m7644getLetterSpacingXSAIIZE = textStyle.m7644getLetterSpacingXSAIIZE();
        if (TextUnit.m8352getRawTypeimpl(j4) == 0) {
            j4 = m7644getLetterSpacingXSAIIZE;
        }
        BaselineShift m7900boximpl = !Float.isNaN(this.baselineShift) ? BaselineShift.m7900boximpl(this.baselineShift) : textStyle.m7637getBaselineShift5SSeXJ0();
        TextGeometricTransform textGeometricTransform = textStyle.getTextGeometricTransform();
        LocaleList localeList = textStyle.getLocaleList();
        long m7636getBackground0d7_KjU = textStyle.m7636getBackground0d7_KjU();
        TextDecoration textDecoration$foundation = !Intrinsics.areEqual(getTextDecoration$foundation(), access$getEmptyResolvedStyle$p.getTextDecoration$foundation()) ? getTextDecoration$foundation() : textStyle.getTextDecoration();
        Shadow shadow = textStyle.getShadow();
        DrawStyle drawStyle = textStyle.getDrawStyle();
        int m1425getTextAligne0LSkKk$foundation = !TextAlign.m8034equalsimpl0(m1425getTextAligne0LSkKk$foundation(), access$getEmptyResolvedStyle$p.m1425getTextAligne0LSkKk$foundation()) ? m1425getTextAligne0LSkKk$foundation() : textStyle.m7649getTextAligne0LSkKk();
        int m1426getTextDirections_7Xco$foundation = !TextDirection.m8051equalsimpl0(m1426getTextDirections_7Xco$foundation(), access$getEmptyResolvedStyle$p.m1426getTextDirections_7Xco$foundation()) ? m1426getTextDirections_7Xco$foundation() : textStyle.m7651getTextDirections_7Xco();
        FontWeight fontWeight = fontWeight$foundation;
        long j5 = this.lineHeight;
        long m7647getLineHeightXSAIIZE = !((TextUnit.m8352getRawTypeimpl(j5) > 0L ? 1 : (TextUnit.m8352getRawTypeimpl(j5) == 0L ? 0 : -1)) == 0) ? j5 : textStyle.m7647getLineHeightXSAIIZE();
        TextIndent textIndent = this.textIndent;
        if (textIndent == null) {
            textIndent = textStyle.getTextIndent();
        }
        PlatformTextStyle platformStyle = textStyle.getPlatformStyle();
        LineHeightStyle lineHeightStyle = textStyle.getLineHeightStyle();
        int i = this.lineBreak;
        int m7646getLineBreakrAG3T2k = textStyle.m7646getLineBreakrAG3T2k();
        TextIndent textIndent2 = textIndent;
        if (LineBreak.m7942equalsimpl0(i, LineBreak.Companion.m7956getUnspecifiedrAG3T2k())) {
            i = m7646getLineBreakrAG3T2k;
        }
        BaselineShift baselineShift = m7900boximpl;
        TextDecoration textDecoration = textDecoration$foundation;
        FontStyle fontStyle = m7717boximpl;
        TextStyle textStyle2 = new TextStyle(j2, m7639getFontSizeXSAIIZE, fontWeight, fontStyle, m7728boximpl, fontFamily, fontFeatureSettings, j4, baselineShift, textGeometricTransform, localeList, m7636getBackground0d7_KjU, textDecoration, shadow, drawStyle, m1425getTextAligne0LSkKk$foundation, m1426getTextDirections_7Xco$foundation, m7647getLineHeightXSAIIZE, textIndent2, platformStyle, lineHeightStyle, i, !Hyphens.m7926equalsimpl0(m1421getHyphensvmbZdU8$foundation(), access$getEmptyResolvedStyle$p.m1421getHyphensvmbZdU8$foundation()) ? m1421getHyphensvmbZdU8$foundation() : textStyle.m7643getHyphensvmbZdU8(), textStyle.getTextMotion(), (DefaultConstructorMarker) null);
        Brush brush = this.contentBrush;
        return brush != null ? TextStyle.m7619copyNs73l9s$default(textStyle2, brush, 0.0f, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 33554430, null) : textStyle2;
    }

    private final List<ValueElement> valueElements() {
        ArrayList arrayList = new ArrayList();
        ResolvedStyle access$getEmptyResolvedStyle$p = ResolvedStyleKt.access$getEmptyResolvedStyle$p();
        float f = access$getEmptyResolvedStyle$p.contentPaddingStart;
        float f2 = this.contentPaddingStart;
        if (f != f2) {
            valueElements$lambda$0$add(arrayList, "contentPaddingStart", Float.valueOf(f2));
        }
        float f3 = access$getEmptyResolvedStyle$p.contentPaddingEnd;
        float f4 = this.contentPaddingEnd;
        if (f3 != f4) {
            valueElements$lambda$0$add(arrayList, "contentPaddingEnd", Float.valueOf(f4));
        }
        float f5 = access$getEmptyResolvedStyle$p.contentPaddingTop;
        float f6 = this.contentPaddingTop;
        if (f5 != f6) {
            valueElements$lambda$0$add(arrayList, "contentPaddingTop", Float.valueOf(f6));
        }
        float f7 = access$getEmptyResolvedStyle$p.contentPaddingBottom;
        float f8 = this.contentPaddingBottom;
        if (f7 != f8) {
            valueElements$lambda$0$add(arrayList, "contentPaddingBottom", Float.valueOf(f8));
        }
        float f9 = access$getEmptyResolvedStyle$p.externalPaddingStart;
        float f10 = this.externalPaddingStart;
        if (f9 != f10) {
            valueElements$lambda$0$add(arrayList, "externalPaddingStart", Float.valueOf(f10));
        }
        float f11 = access$getEmptyResolvedStyle$p.externalPaddingEnd;
        float f12 = this.externalPaddingEnd;
        if (f11 != f12) {
            valueElements$lambda$0$add(arrayList, "externalPaddingEnd", Float.valueOf(f12));
        }
        float f13 = access$getEmptyResolvedStyle$p.externalPaddingTop;
        float f14 = this.externalPaddingTop;
        if (f13 != f14) {
            valueElements$lambda$0$add(arrayList, "externalPaddingTop", Float.valueOf(f14));
        }
        float f15 = access$getEmptyResolvedStyle$p.externalPaddingBottom;
        float f16 = this.externalPaddingBottom;
        if (f15 != f16) {
            valueElements$lambda$0$add(arrayList, "externalPaddingBottom", Float.valueOf(f16));
        }
        float f17 = access$getEmptyResolvedStyle$p.borderWidth;
        float f18 = this.borderWidth;
        if (f17 != f18) {
            valueElements$lambda$0$add(arrayList, "borderWidth", Float.valueOf(f18));
        }
        float f19 = access$getEmptyResolvedStyle$p.width;
        float f20 = this.width;
        if (f19 != f20) {
            valueElements$lambda$0$add(arrayList, "width", Float.valueOf(f20));
        }
        float f21 = access$getEmptyResolvedStyle$p.height;
        float f22 = this.height;
        if (f21 != f22) {
            valueElements$lambda$0$add(arrayList, "height", Float.valueOf(f22));
        }
        if (Float.floatToRawIntBits(access$getEmptyResolvedStyle$p.widthFraction) != Float.floatToRawIntBits(this.widthFraction)) {
            valueElements$lambda$0$add(arrayList, "widthFraction", Float.valueOf(this.widthFraction));
        }
        if (Float.floatToRawIntBits(access$getEmptyResolvedStyle$p.heightFraction) != Float.floatToRawIntBits(this.heightFraction)) {
            valueElements$lambda$0$add(arrayList, "heightFraction", Float.valueOf(this.heightFraction));
        }
        float f23 = access$getEmptyResolvedStyle$p.alpha;
        float f24 = this.alpha;
        if (f23 != f24) {
            valueElements$lambda$0$add(arrayList, "alpha", Float.valueOf(f24));
        }
        float f25 = access$getEmptyResolvedStyle$p.scaleX;
        float f26 = this.scaleX;
        if (f25 != f26) {
            valueElements$lambda$0$add(arrayList, "scaleX", Float.valueOf(f26));
        }
        float f27 = access$getEmptyResolvedStyle$p.scaleY;
        float f28 = this.scaleY;
        if (f27 != f28) {
            valueElements$lambda$0$add(arrayList, "scaleY", Float.valueOf(f28));
        }
        float f29 = access$getEmptyResolvedStyle$p.translationX;
        float f30 = this.translationX;
        if (f29 != f30) {
            valueElements$lambda$0$add(arrayList, "translationX", Float.valueOf(f30));
        }
        float f31 = access$getEmptyResolvedStyle$p.translationY;
        float f32 = this.translationY;
        if (f31 != f32) {
            valueElements$lambda$0$add(arrayList, "translationY", Float.valueOf(f32));
        }
        float f33 = access$getEmptyResolvedStyle$p.rotationX;
        float f34 = this.rotationX;
        if (f33 != f34) {
            valueElements$lambda$0$add(arrayList, "rotationX", Float.valueOf(f34));
        }
        float f35 = access$getEmptyResolvedStyle$p.rotationY;
        float f36 = this.rotationY;
        if (f35 != f36) {
            valueElements$lambda$0$add(arrayList, "rotationY", Float.valueOf(f36));
        }
        float f37 = access$getEmptyResolvedStyle$p.rotationZ;
        float f38 = this.rotationZ;
        if (f37 != f38) {
            valueElements$lambda$0$add(arrayList, "rotationZ", Float.valueOf(f38));
        }
        if (!TransformOrigin.m5755equalsimpl0(access$getEmptyResolvedStyle$p.transformOrigin, this.transformOrigin)) {
            valueElements$lambda$0$add(arrayList, "transformOrigin", TransformOrigin.m5748boximpl(this.transformOrigin));
        }
        float f39 = access$getEmptyResolvedStyle$p.zIndex;
        float f40 = this.zIndex;
        if (f39 != f40) {
            valueElements$lambda$0$add(arrayList, "zIndex", Float.valueOf(f40));
        }
        float f41 = access$getEmptyResolvedStyle$p.cameraDistance;
        float f42 = this.cameraDistance;
        if (f41 != f42) {
            valueElements$lambda$0$add(arrayList, "cameraDistance", Float.valueOf(f42));
        }
        if (!Color.m5349equalsimpl0(access$getEmptyResolvedStyle$p.borderColor, this.borderColor)) {
            valueElements$lambda$0$add(arrayList, "borderColor", Color.m5338boximpl(this.borderColor));
        }
        if (!Intrinsics.areEqual(access$getEmptyResolvedStyle$p.borderBrush, this.borderBrush)) {
            valueElements$lambda$0$add(arrayList, "borderBrush", this.borderBrush);
        }
        if (!Color.m5349equalsimpl0(access$getEmptyResolvedStyle$p.backgroundColor, this.backgroundColor)) {
            valueElements$lambda$0$add(arrayList, TtmlNode.ATTR_TTS_BACKGROUND_COLOR, Color.m5338boximpl(this.backgroundColor));
        }
        if (!Intrinsics.areEqual(access$getEmptyResolvedStyle$p.backgroundBrush, this.backgroundBrush)) {
            valueElements$lambda$0$add(arrayList, "backgroundBrush", this.backgroundBrush);
        }
        if (!Intrinsics.areEqual(access$getEmptyResolvedStyle$p.foregroundBrush, this.foregroundBrush)) {
            valueElements$lambda$0$add(arrayList, "foregroundBrush", this.foregroundBrush);
        }
        boolean z = access$getEmptyResolvedStyle$p.clip;
        boolean z2 = this.clip;
        if (z != z2) {
            valueElements$lambda$0$add(arrayList, "clip", Boolean.valueOf(z2));
        }
        if (!Intrinsics.areEqual(access$getEmptyResolvedStyle$p.shape, this.shape)) {
            valueElements$lambda$0$add(arrayList, "shape", this.shape);
        }
        if (access$getEmptyResolvedStyle$p.contentColor != 16) {
            valueElements$lambda$0$add(arrayList, "contentColor", Color.m5338boximpl(this.contentColor));
        }
        if (!Intrinsics.areEqual(access$getEmptyResolvedStyle$p.contentBrush, this.backgroundBrush)) {
            valueElements$lambda$0$add(arrayList, "contentBrush", this.contentBrush);
        }
        if (!Intrinsics.areEqual(access$getEmptyResolvedStyle$p.fontFamily, this.fontFamily)) {
            valueElements$lambda$0$add(arrayList, TtmlNode.ATTR_TTS_FONT_FAMILY, this.fontFamily);
        }
        if (!Intrinsics.areEqual(access$getEmptyResolvedStyle$p.textIndent, this.textIndent)) {
            valueElements$lambda$0$add(arrayList, "textIndent", this.textIndent);
        }
        if (!TextUnit.m8351equalsimpl0(access$getEmptyResolvedStyle$p.fontSize, this.fontSize)) {
            valueElements$lambda$0$add(arrayList, TtmlNode.ATTR_TTS_FONT_SIZE, TextUnit.m8344boximpl(this.fontSize));
        }
        if (!TextUnit.m8351equalsimpl0(access$getEmptyResolvedStyle$p.lineHeight, this.lineHeight)) {
            valueElements$lambda$0$add(arrayList, "lineHeight", TextUnit.m8344boximpl(this.lineHeight));
        }
        if (!TextUnit.m8351equalsimpl0(access$getEmptyResolvedStyle$p.letterSpacing, this.letterSpacing)) {
            valueElements$lambda$0$add(arrayList, "letterSpacing", TextUnit.m8344boximpl(this.letterSpacing));
        }
        if (!BaselineShift.m7903equalsimpl0(access$getEmptyResolvedStyle$p.baselineShift, this.baselineShift)) {
            valueElements$lambda$0$add(arrayList, "baselineShift", BaselineShift.m7900boximpl(this.baselineShift));
        }
        if (!LineBreak.m7942equalsimpl0(access$getEmptyResolvedStyle$p.lineBreak, this.lineBreak)) {
            valueElements$lambda$0$add(arrayList, "lineBreak", LineBreak.m7936boximpl(this.lineBreak));
        }
        if (!TextAlign.m8034equalsimpl0(access$getEmptyResolvedStyle$p.m1425getTextAligne0LSkKk$foundation(), m1425getTextAligne0LSkKk$foundation())) {
            valueElements$lambda$0$add(arrayList, TtmlNode.ATTR_TTS_TEXT_ALIGN, TextAlign.m8031boximpl(m1425getTextAligne0LSkKk$foundation()));
        }
        if (!TextDirection.m8051equalsimpl0(access$getEmptyResolvedStyle$p.m1426getTextDirections_7Xco$foundation(), m1426getTextDirections_7Xco$foundation())) {
            valueElements$lambda$0$add(arrayList, "textDirection", TextDirection.m8048boximpl(m1426getTextDirections_7Xco$foundation()));
        }
        if (!Hyphens.m7926equalsimpl0(access$getEmptyResolvedStyle$p.m1421getHyphensvmbZdU8$foundation(), m1421getHyphensvmbZdU8$foundation())) {
            valueElements$lambda$0$add(arrayList, "hyphens", Hyphens.m7923boximpl(m1421getHyphensvmbZdU8$foundation()));
        }
        if (!FontStyle.m7720equalsimpl0(access$getEmptyResolvedStyle$p.m1418getFontStyle_LCdwA$foundation(), m1418getFontStyle_LCdwA$foundation())) {
            valueElements$lambda$0$add(arrayList, TtmlNode.ATTR_TTS_FONT_STYLE, FontStyle.m7717boximpl(m1418getFontStyle_LCdwA$foundation()));
        }
        if (!Intrinsics.areEqual(access$getEmptyResolvedStyle$p.getFontWeight$foundation(), getFontWeight$foundation())) {
            valueElements$lambda$0$add(arrayList, TtmlNode.ATTR_TTS_FONT_WEIGHT, getFontWeight$foundation());
        }
        if (!FontSynthesis.m7731equalsimpl0(access$getEmptyResolvedStyle$p.m1419getFontSynthesisGVVA2EU$foundation(), m1419getFontSynthesisGVVA2EU$foundation())) {
            valueElements$lambda$0$add(arrayList, "fontSynthesis", FontSynthesis.m7728boximpl(m1419getFontSynthesisGVVA2EU$foundation()));
        }
        if (!Intrinsics.areEqual(access$getEmptyResolvedStyle$p.getTextDecoration$foundation(), getTextDecoration$foundation())) {
            valueElements$lambda$0$add(arrayList, TtmlNode.ATTR_TTS_TEXT_DECORATION, getTextDecoration$foundation());
        }
        return arrayList;
    }

    private static final boolean valueElements$lambda$0$add(List<ValueElement> list, String str, Object obj) {
        return list.add(new ValueElement(str, obj));
    }

    @Override // androidx.compose.ui.platform.InspectableValue
    public Sequence<ValueElement> getInspectableElements() {
        return CollectionsKt.asSequence(valueElements());
    }

    @Override // androidx.compose.ui.unit.Density
    public float getDensity() {
        return this._density;
    }

    @Override // androidx.compose.ui.unit.FontScaling
    public float getFontScale() {
        return this._fontScale;
    }

    @Override // androidx.compose.foundation.style.StyleScope
    public StyleState getState() {
        StyleOuterNode styleOuterNode = this.node;
        Intrinsics.checkNotNull(styleOuterNode);
        return styleOuterNode.getState$foundation();
    }

    @Override // androidx.compose.foundation.style.StyleScope
    /* renamed from: contentPaddingStart-0680j_4  reason: not valid java name */
    public void mo1397contentPaddingStart0680j_4(float f) {
        this.flags |= 1;
        this.contentPaddingStart = mo428roundToPx0680j_4(f);
    }

    @Override // androidx.compose.foundation.style.StyleScope
    /* renamed from: contentPaddingEnd-0680j_4  reason: not valid java name */
    public void mo1395contentPaddingEnd0680j_4(float f) {
        this.flags |= 1;
        this.contentPaddingEnd = mo428roundToPx0680j_4(f);
    }

    @Override // androidx.compose.foundation.style.StyleScope
    /* renamed from: contentPaddingTop-0680j_4  reason: not valid java name */
    public void mo1398contentPaddingTop0680j_4(float f) {
        this.flags |= 1;
        this.contentPaddingTop = mo428roundToPx0680j_4(f);
    }

    @Override // androidx.compose.foundation.style.StyleScope
    /* renamed from: contentPaddingBottom-0680j_4  reason: not valid java name */
    public void mo1394contentPaddingBottom0680j_4(float f) {
        this.flags |= 1;
        this.contentPaddingBottom = mo428roundToPx0680j_4(f);
    }

    @Override // androidx.compose.foundation.style.StyleScope
    /* renamed from: contentPaddingHorizontal-0680j_4  reason: not valid java name */
    public void mo1396contentPaddingHorizontal0680j_4(float f) {
        this.flags |= 1;
        float f2 = mo428roundToPx0680j_4(f);
        this.contentPaddingStart = f2;
        this.contentPaddingEnd = f2;
    }

    @Override // androidx.compose.foundation.style.StyleScope
    /* renamed from: contentPaddingVertical-0680j_4  reason: not valid java name */
    public void mo1399contentPaddingVertical0680j_4(float f) {
        this.flags |= 1;
        float f2 = mo428roundToPx0680j_4(f);
        this.contentPaddingTop = f2;
        this.contentPaddingBottom = f2;
    }

    @Override // androidx.compose.foundation.style.StyleScope
    /* renamed from: contentPadding-0680j_4  reason: not valid java name */
    public void mo1391contentPadding0680j_4(float f) {
        this.flags |= 1;
        float f2 = mo428roundToPx0680j_4(f);
        this.contentPaddingStart = f2;
        this.contentPaddingEnd = f2;
        this.contentPaddingTop = f2;
        this.contentPaddingBottom = f2;
    }

    @Override // androidx.compose.foundation.style.StyleScope
    /* renamed from: contentPadding-a9UjIt4  reason: not valid java name */
    public void mo1393contentPaddinga9UjIt4(float f, float f2, float f3, float f4) {
        this.flags |= 1;
        this.contentPaddingTop = mo428roundToPx0680j_4(f2);
        this.contentPaddingEnd = mo428roundToPx0680j_4(f3);
        this.contentPaddingBottom = mo428roundToPx0680j_4(f4);
        this.contentPaddingStart = mo428roundToPx0680j_4(f);
    }

    @Override // androidx.compose.foundation.style.StyleScope
    /* renamed from: contentPadding-YgX7TsA  reason: not valid java name */
    public void mo1392contentPaddingYgX7TsA(float f, float f2) {
        this.flags |= 1;
        float f3 = mo428roundToPx0680j_4(f2);
        this.contentPaddingTop = f3;
        this.contentPaddingBottom = f3;
        float f4 = mo428roundToPx0680j_4(f);
        this.contentPaddingEnd = f4;
        this.contentPaddingStart = f4;
    }

    @Override // androidx.compose.foundation.style.StyleScope
    /* renamed from: externalPaddingStart-0680j_4  reason: not valid java name */
    public void mo1406externalPaddingStart0680j_4(float f) {
        this.flags |= 8;
        this.externalPaddingStart = mo428roundToPx0680j_4(f);
    }

    @Override // androidx.compose.foundation.style.StyleScope
    /* renamed from: externalPaddingEnd-0680j_4  reason: not valid java name */
    public void mo1404externalPaddingEnd0680j_4(float f) {
        this.flags |= 8;
        this.externalPaddingEnd = mo428roundToPx0680j_4(f);
    }

    @Override // androidx.compose.foundation.style.StyleScope
    /* renamed from: externalPaddingTop-0680j_4  reason: not valid java name */
    public void mo1407externalPaddingTop0680j_4(float f) {
        this.flags |= 8;
        this.externalPaddingTop = mo428roundToPx0680j_4(f);
    }

    @Override // androidx.compose.foundation.style.StyleScope
    /* renamed from: externalPaddingBottom-0680j_4  reason: not valid java name */
    public void mo1403externalPaddingBottom0680j_4(float f) {
        this.flags |= 8;
        this.externalPaddingBottom = mo428roundToPx0680j_4(f);
    }

    @Override // androidx.compose.foundation.style.StyleScope
    /* renamed from: externalPaddingHorizontal-0680j_4  reason: not valid java name */
    public void mo1405externalPaddingHorizontal0680j_4(float f) {
        this.flags |= 8;
        float f2 = mo428roundToPx0680j_4(f);
        this.externalPaddingStart = f2;
        this.externalPaddingEnd = f2;
    }

    @Override // androidx.compose.foundation.style.StyleScope
    /* renamed from: externalPaddingVertical-0680j_4  reason: not valid java name */
    public void mo1408externalPaddingVertical0680j_4(float f) {
        this.flags |= 8;
        float f2 = mo428roundToPx0680j_4(f);
        this.externalPaddingTop = f2;
        this.externalPaddingBottom = f2;
    }

    @Override // androidx.compose.foundation.style.StyleScope
    /* renamed from: externalPadding-0680j_4  reason: not valid java name */
    public void mo1400externalPadding0680j_4(float f) {
        this.flags |= 8;
        float f2 = mo428roundToPx0680j_4(f);
        this.externalPaddingStart = f2;
        this.externalPaddingEnd = f2;
        this.externalPaddingTop = f2;
        this.externalPaddingBottom = f2;
    }

    @Override // androidx.compose.foundation.style.StyleScope
    /* renamed from: externalPadding-a9UjIt4  reason: not valid java name */
    public void mo1402externalPaddinga9UjIt4(float f, float f2, float f3, float f4) {
        this.flags |= 8;
        this.externalPaddingTop = mo428roundToPx0680j_4(f2);
        this.externalPaddingEnd = mo428roundToPx0680j_4(f3);
        this.externalPaddingBottom = mo428roundToPx0680j_4(f4);
        this.externalPaddingStart = mo428roundToPx0680j_4(f);
    }

    @Override // androidx.compose.foundation.style.StyleScope
    /* renamed from: externalPadding-YgX7TsA  reason: not valid java name */
    public void mo1401externalPaddingYgX7TsA(float f, float f2) {
        this.flags |= 8;
        float f3 = mo428roundToPx0680j_4(f2);
        this.externalPaddingTop = f3;
        this.externalPaddingBottom = f3;
        float f4 = mo428roundToPx0680j_4(f);
        this.externalPaddingEnd = f4;
        this.externalPaddingStart = f4;
    }

    @Override // androidx.compose.foundation.style.StyleScope
    /* renamed from: borderWidth-0680j_4  reason: not valid java name */
    public void mo1388borderWidth0680j_4(float f) {
        float ceil;
        this.flags |= 3;
        if (Dp.m8165equalsimpl0(f, Dp.Companion.m8180getUnspecifiedD9Ej5fM())) {
            ceil = 0.0f;
        } else {
            ceil = Dp.m8165equalsimpl0(f, Dp.Companion.m8178getHairlineD9Ej5fM()) ? 1.0f : (float) Math.ceil(f * this._density);
        }
        this.borderWidth = ceil;
    }

    @Override // androidx.compose.foundation.style.StyleScope
    /* renamed from: borderColor-8_81llA  reason: not valid java name */
    public void mo1387borderColor8_81llA(long j) {
        this.flags |= 2;
        this.borderColor = j;
        this.borderBrush = null;
    }

    @Override // androidx.compose.foundation.style.StyleScope
    public void borderBrush(Brush brush) {
        this.flags |= 2;
        this.borderBrush = brush;
        this.borderColor = Color.Companion.m5384getUnspecified0d7_KjU();
    }

    @Override // androidx.compose.foundation.style.StyleScope
    /* renamed from: border-cXLIe8U  reason: not valid java name */
    public void mo1386bordercXLIe8U(float f, long j) {
        mo1388borderWidth0680j_4(f);
        mo1387borderColor8_81llA(j);
    }

    @Override // androidx.compose.foundation.style.StyleScope
    /* renamed from: border-D5KLDUw  reason: not valid java name */
    public void mo1385borderD5KLDUw(float f, Brush brush) {
        mo1388borderWidth0680j_4(f);
        borderBrush(brush);
    }

    @Override // androidx.compose.foundation.style.StyleScope
    /* renamed from: width-0680j_4  reason: not valid java name */
    public void mo1461width0680j_4(float f) {
        this.flags |= 8;
        this.width = f * this._density;
        this.widthFraction = Float.NaN;
    }

    @Override // androidx.compose.foundation.style.StyleScope
    /* renamed from: height-0680j_4  reason: not valid java name */
    public void mo1428height0680j_4(float f) {
        this.flags |= 8;
        this.height = f * this._density;
        this.heightFraction = Float.NaN;
    }

    @Override // androidx.compose.foundation.style.StyleScope
    /* renamed from: size-YgX7TsA  reason: not valid java name */
    public void mo1455sizeYgX7TsA(float f, float f2) {
        this.flags |= 8;
        float f3 = this._density;
        this.width = f * f3;
        this.widthFraction = Float.NaN;
        this.height = f2 * f3;
        this.heightFraction = Float.NaN;
    }

    @Override // androidx.compose.foundation.style.StyleScope
    /* renamed from: size-0680j_4  reason: not valid java name */
    public void mo1453size0680j_4(float f) {
        this.flags |= 8;
        float f2 = f * this._density;
        this.width = f2;
        this.widthFraction = Float.NaN;
        this.height = f2;
        this.heightFraction = Float.NaN;
    }

    @Override // androidx.compose.foundation.style.StyleScope
    /* renamed from: size-EaSLcWc  reason: not valid java name */
    public void mo1454sizeEaSLcWc(long j) {
        this.flags |= 8;
        this.width = DpSize.m8258getWidthD9Ej5fM(j) * this._density;
        this.widthFraction = Float.NaN;
        this.height = DpSize.m8256getHeightD9Ej5fM(j) * this._density;
        this.heightFraction = Float.NaN;
    }

    @Override // androidx.compose.foundation.style.StyleScope
    public void width(float f) {
        this.flags |= 8;
        this.widthFraction = f;
        this.width = Float.NaN;
    }

    @Override // androidx.compose.foundation.style.StyleScope
    public void height(float f) {
        this.flags |= 8;
        this.heightFraction = f;
        this.height = Float.NaN;
    }

    @Override // androidx.compose.foundation.style.StyleScope
    /* renamed from: left-0680j_4  reason: not valid java name */
    public void mo1430left0680j_4(float f) {
        this.flags |= 8;
        this.left = f * this._density;
    }

    @Override // androidx.compose.foundation.style.StyleScope
    /* renamed from: top-0680j_4  reason: not valid java name */
    public void mo1458top0680j_4(float f) {
        this.flags |= 8;
        this.top = f * this._density;
    }

    @Override // androidx.compose.foundation.style.StyleScope
    /* renamed from: right-0680j_4  reason: not valid java name */
    public void mo1442right0680j_4(float f) {
        this.flags |= 8;
        this.right = f * this._density;
    }

    @Override // androidx.compose.foundation.style.StyleScope
    /* renamed from: bottom-0680j_4  reason: not valid java name */
    public void mo1389bottom0680j_4(float f) {
        this.flags |= 8;
        this.bottom = f * this._density;
    }

    @Override // androidx.compose.foundation.style.StyleScope
    /* renamed from: minWidth-0680j_4  reason: not valid java name */
    public void mo1441minWidth0680j_4(float f) {
        this.flags |= 8;
        this.minWidth = f * this._density;
    }

    @Override // androidx.compose.foundation.style.StyleScope
    /* renamed from: minHeight-0680j_4  reason: not valid java name */
    public void mo1438minHeight0680j_4(float f) {
        this.flags |= 8;
        this.minHeight = f * this._density;
    }

    @Override // androidx.compose.foundation.style.StyleScope
    /* renamed from: minSize-EaSLcWc  reason: not valid java name */
    public void mo1439minSizeEaSLcWc(long j) {
        mo1441minWidth0680j_4(DpSize.m8258getWidthD9Ej5fM(j));
        mo1438minHeight0680j_4(DpSize.m8256getHeightD9Ej5fM(j));
    }

    @Override // androidx.compose.foundation.style.StyleScope
    /* renamed from: minSize-YgX7TsA  reason: not valid java name */
    public void mo1440minSizeYgX7TsA(float f, float f2) {
        mo1441minWidth0680j_4(f);
        mo1438minHeight0680j_4(f2);
    }

    @Override // androidx.compose.foundation.style.StyleScope
    /* renamed from: maxWidth-0680j_4  reason: not valid java name */
    public void mo1437maxWidth0680j_4(float f) {
        this.flags |= 8;
        this.maxWidth = f * this._density;
    }

    @Override // androidx.compose.foundation.style.StyleScope
    /* renamed from: maxHeight-0680j_4  reason: not valid java name */
    public void mo1434maxHeight0680j_4(float f) {
        this.flags |= 8;
        this.maxHeight = f * this._density;
    }

    @Override // androidx.compose.foundation.style.StyleScope
    /* renamed from: maxSize-EaSLcWc  reason: not valid java name */
    public void mo1435maxSizeEaSLcWc(long j) {
        mo1437maxWidth0680j_4(DpSize.m8258getWidthD9Ej5fM(j));
        mo1434maxHeight0680j_4(DpSize.m8256getHeightD9Ej5fM(j));
    }

    @Override // androidx.compose.foundation.style.StyleScope
    /* renamed from: maxSize-YgX7TsA  reason: not valid java name */
    public void mo1436maxSizeYgX7TsA(float f, float f2) {
        mo1437maxWidth0680j_4(f);
        mo1434maxHeight0680j_4(f2);
    }

    @Override // androidx.compose.foundation.style.StyleScope
    public void alpha(float f) {
        this.flags |= 4;
        this.alpha = f;
    }

    @Override // androidx.compose.foundation.style.StyleScope
    public void scaleX(float f) {
        this.flags |= 4;
        this.scaleX = f;
    }

    @Override // androidx.compose.foundation.style.StyleScope
    public void scaleY(float f) {
        this.flags |= 4;
        this.scaleY = f;
    }

    @Override // androidx.compose.foundation.style.StyleScope
    public void scale(float f) {
        this.flags |= 4;
        this.scaleX = f;
        this.scaleY = f;
    }

    @Override // androidx.compose.foundation.style.StyleScope
    public void translationX(float f) {
        this.flags |= 4;
        this.translationX = f;
    }

    @Override // androidx.compose.foundation.style.StyleScope
    public void translationY(float f) {
        this.flags |= 4;
        this.translationY = f;
    }

    @Override // androidx.compose.foundation.style.StyleScope
    public void translation(float f, float f2) {
        this.flags |= 4;
        this.translationX = f;
        this.translationY = f2;
    }

    @Override // androidx.compose.foundation.style.StyleScope
    /* renamed from: translation-k-4lQ0M  reason: not valid java name */
    public void mo1460translationk4lQ0M(long j) {
        this.flags |= 4;
        this.translationX = Float.intBitsToFloat((int) (j >> 32));
        this.translationY = Float.intBitsToFloat((int) (j & 4294967295L));
    }

    @Override // androidx.compose.foundation.style.StyleScope
    public void rotationX(float f) {
        this.flags |= 4;
        this.rotationX = f;
    }

    @Override // androidx.compose.foundation.style.StyleScope
    public void rotationY(float f) {
        this.flags |= 4;
        this.rotationY = f;
    }

    @Override // androidx.compose.foundation.style.StyleScope
    public void rotationZ(float f) {
        this.flags |= 4;
        this.rotationZ = f;
    }

    @Override // androidx.compose.foundation.style.StyleScope
    /* renamed from: transformOrigin-__ExYCQ  reason: not valid java name */
    public void mo1459transformOrigin__ExYCQ(long j) {
        this.flags |= 4;
        this.transformOrigin = j;
    }

    @Override // androidx.compose.foundation.style.StyleScope
    public void clip(boolean z) {
        this.flags |= 4;
        this.clip = z;
    }

    @Override // androidx.compose.foundation.style.StyleScope
    public void zIndex(float f) {
        this.zIndex = f;
    }

    @Override // androidx.compose.foundation.style.StyleScope
    /* renamed from: background-8_81llA  reason: not valid java name */
    public void mo1383background8_81llA(long j) {
        this.flags |= 2;
        this.backgroundColor = j;
        this.backgroundBrush = null;
    }

    @Override // androidx.compose.foundation.style.StyleScope
    public void background(Brush brush) {
        this.flags |= 2;
        this.backgroundBrush = brush;
        this.backgroundColor = Color.Companion.m5384getUnspecified0d7_KjU();
    }

    @Override // androidx.compose.foundation.style.StyleScope
    /* renamed from: foreground-8_81llA  reason: not valid java name */
    public void mo1412foreground8_81llA(long j) {
        this.flags |= 2;
        this.foregroundColor = j;
        this.foregroundBrush = null;
    }

    @Override // androidx.compose.foundation.style.StyleScope
    public void foreground(Brush brush) {
        this.flags |= 2;
        this.foregroundBrush = brush;
        this.foregroundColor = Color.Companion.m5384getUnspecified0d7_KjU();
    }

    @Override // androidx.compose.foundation.style.StyleScope
    public void shape(Shape shape) {
        this.flags |= 6;
        this.shape = shape;
    }

    @Override // androidx.compose.foundation.style.StyleScope
    public void animate(Style style) {
        animate(ResolvedStyleKt.access$getDefaultSpringSpec$p(), ResolvedStyleKt.access$getDefaultSpringSpec$p(), style);
    }

    @Override // androidx.compose.foundation.style.StyleScope
    public void animate(AnimationSpec<Float> animationSpec, Style style) {
        animate(animationSpec, animationSpec, style);
    }

    @Override // androidx.compose.foundation.style.StyleScope
    public void animate(AnimationSpec<Float> animationSpec, AnimationSpec<Float> animationSpec2, Style style) {
        this.flags |= 16;
        int i = this.currentIndex;
        int i2 = 1318433304 ^ i;
        this.compositeHash = ResolvedStyleKt.access$updateHashEnter(this.compositeHash, i2);
        MutableIntList pushIndex = pushIndex(i);
        this.currentIndex = 0;
        if (this.animating) {
            StyleScopeKt.apply(this, style);
        } else {
            StyleOuterNode styleOuterNode = this.node;
            Intrinsics.checkNotNull(styleOuterNode);
            StyleAnimations animations$foundation = styleOuterNode.getAnimations$foundation();
            if (animations$foundation == null) {
                animations$foundation = new StyleAnimations(styleOuterNode);
                styleOuterNode.setAnimations$foundation(animations$foundation);
            }
            animations$foundation.record(this.compositeHash ^ this.currentIndex, style, animationSpec, animationSpec2);
        }
        this.currentIndex = pushIndex.removeAt(pushIndex._size - 1) + 1;
        this.compositeHash = ResolvedStyleKt.access$updateHashExit(this.compositeHash, i2);
    }

    @Override // androidx.compose.runtime.CompositionLocalAccessorScope
    public <T> T getCurrentValue(CompositionLocal<T> compositionLocal) {
        StyleOuterNode styleOuterNode = this.node;
        Intrinsics.checkNotNull(styleOuterNode);
        return (T) CompositionLocalConsumerModifierNodeKt.currentValueOf(styleOuterNode, compositionLocal);
    }

    public final Object getDropShadow$foundation() {
        return this.dropShadow;
    }

    public final void setDropShadow$foundation(Object obj) {
        this.dropShadow = obj;
    }

    public final Object getInnerShadow$foundation() {
        return this.innerShadow;
    }

    public final void setInnerShadow$foundation(Object obj) {
        this.innerShadow = obj;
    }

    @Override // androidx.compose.foundation.style.StyleScope
    public void dropShadow(androidx.compose.ui.graphics.shadow.Shadow shadow) {
        this.dropShadow = shadow;
        this.flags |= 2;
    }

    @Override // androidx.compose.foundation.style.StyleScope
    public void dropShadow(androidx.compose.ui.graphics.shadow.Shadow... shadowArr) {
        this.dropShadow = shadowArr;
        this.flags |= 2;
    }

    @Override // androidx.compose.foundation.style.StyleScope
    public void innerShadow(androidx.compose.ui.graphics.shadow.Shadow shadow) {
        this.innerShadow = shadow;
        this.flags |= 2;
    }

    @Override // androidx.compose.foundation.style.StyleScope
    public void innerShadow(androidx.compose.ui.graphics.shadow.Shadow... shadowArr) {
        this.innerShadow = shadowArr;
        this.flags |= 2;
    }

    @Override // androidx.compose.foundation.style.StyleScope
    public void textStyle(TextStyle textStyle) {
        SpanStyle spanStyle = textStyle.toSpanStyle();
        if (spanStyle.m7549getColor0d7_KjU() != 16) {
            mo1390contentColor8_81llA(spanStyle.m7549getColor0d7_KjU());
        }
        if (!(TextUnit.m8352getRawTypeimpl(spanStyle.m7550getFontSizeXSAIIZE()) == 0)) {
            mo1409fontSizeR2X_6o(spanStyle.m7550getFontSizeXSAIIZE());
        }
        if (!(TextUnit.m8352getRawTypeimpl(spanStyle.m7553getLetterSpacingXSAIIZE()) == 0)) {
            mo1431letterSpacingR2X_6o(spanStyle.m7553getLetterSpacingXSAIIZE());
        }
        Brush brush = spanStyle.getBrush();
        if (brush != null) {
            contentBrush(brush);
        }
        FontStyle m7551getFontStyle4Lr2A7w = spanStyle.m7551getFontStyle4Lr2A7w();
        if (m7551getFontStyle4Lr2A7w != null) {
            mo1410fontStylenzbMABs(m7551getFontStyle4Lr2A7w.m7723unboximpl());
        }
        BaselineShift m7548getBaselineShift5SSeXJ0 = spanStyle.m7548getBaselineShift5SSeXJ0();
        if (m7548getBaselineShift5SSeXJ0 != null) {
            float m7906unboximpl = m7548getBaselineShift5SSeXJ0.m7906unboximpl();
            if (!Float.isNaN(m7906unboximpl)) {
                mo1384baselineShift4Dl_Bck(m7906unboximpl);
            }
        }
        FontWeight fontWeight = spanStyle.getFontWeight();
        if (fontWeight != null) {
            fontWeight(fontWeight);
        }
        TextDecoration textDecoration = spanStyle.getTextDecoration();
        if (textDecoration != null) {
            textDecoration(textDecoration);
        }
        FontSynthesis m7552getFontSynthesisZQGJjVo = spanStyle.m7552getFontSynthesisZQGJjVo();
        if (m7552getFontSynthesisZQGJjVo != null) {
            mo1411fontSynthesis6p3vJLY(m7552getFontSynthesisZQGJjVo.m7736unboximpl());
        }
        ParagraphStyle paragraphStyle = textStyle.toParagraphStyle();
        TextIndent textIndent = paragraphStyle.getTextIndent();
        if (textIndent != null) {
            textIndent(textIndent);
        }
        if (!(TextUnit.m8352getRawTypeimpl(paragraphStyle.m7511getLineHeightXSAIIZE()) == 0)) {
            mo1433lineHeightR2X_6o(paragraphStyle.m7511getLineHeightXSAIIZE());
        }
        if (!LineBreak.m7942equalsimpl0(paragraphStyle.m7510getLineBreakrAG3T2k(), LineBreak.Companion.m7956getUnspecifiedrAG3T2k())) {
            mo1432lineBreakCZqVlQI(paragraphStyle.m7510getLineBreakrAG3T2k());
        }
        if (paragraphStyle.m7508getHyphensvmbZdU8() != 0) {
            mo1429hyphens3fSNIE(paragraphStyle.m7508getHyphensvmbZdU8());
        }
        if (paragraphStyle.m7515getTextDirections_7Xco() != 0) {
            mo1457textDirectionHejc4pk(paragraphStyle.m7515getTextDirections_7Xco());
        }
        if (paragraphStyle.m7513getTextAligne0LSkKk() != 0) {
            mo1456textAlignaXe7zB0(paragraphStyle.m7513getTextAligne0LSkKk());
        }
    }

    /* renamed from: getFontStyle-_-LCdwA$foundation  reason: not valid java name */
    public final int m1418getFontStyle_LCdwA$foundation() {
        if ((this.textEnums & 1) == 1) {
            return FontStyle.Companion.m7726getItalic_LCdwA();
        }
        return FontStyle.Companion.m7727getNormal_LCdwA();
    }

    /* renamed from: getTextAlign-e0LSkKk$foundation  reason: not valid java name */
    public final int m1425getTextAligne0LSkKk$foundation() {
        return TextAlign.Companion.m8045valueOfIgVj0fw((this.textEnums & 28) >> 2);
    }

    /* renamed from: getTextDirection-s_7X-co$foundation  reason: not valid java name */
    public final int m1426getTextDirections_7Xco$foundation() {
        return TextDirection.Companion.m8061valueOfE8nx0Ws((this.textEnums & 112) >> 4);
    }

    /* renamed from: getHyphens-vmbZdU8$foundation  reason: not valid java name */
    public final int m1421getHyphensvmbZdU8$foundation() {
        return Hyphens.Companion.m7933valueOfkPa1_AA((this.textEnums & ViewUtils.EDGE_TO_EDGE_FLAGS) >> 8);
    }

    public final FontWeight getFontWeight$foundation() {
        return new FontWeight((this.textEnums & 134086656) >> 17);
    }

    public final boolean isFontWeightSpecified$foundation() {
        return ((this.textEnums & 134086656) >> 17) != 0;
    }

    /* renamed from: getFontSynthesis-GVVA2EU$foundation  reason: not valid java name */
    public final int m1419getFontSynthesisGVVA2EU$foundation() {
        return FontSynthesis.Companion.m7741valueOf9CiegCU(((this.textEnums & 15360) >> 10) & 7);
    }

    public final TextDecoration getTextDecoration$foundation() {
        return TextDecoration.Companion.valueOf(((this.textEnums & 114688) >> 14) & 3);
    }

    @Override // androidx.compose.foundation.style.StyleScope
    /* renamed from: contentColor-8_81llA  reason: not valid java name */
    public void mo1390contentColor8_81llA(long j) {
        this.flags |= 64;
        this.contentColor = j;
        this.contentBrush = null;
    }

    @Override // androidx.compose.foundation.style.StyleScope
    public void contentBrush(Brush brush) {
        this.flags |= 64;
        this.contentBrush = brush;
        this.contentColor = Color.Companion.m5384getUnspecified0d7_KjU();
    }

    @Override // androidx.compose.foundation.style.StyleScope
    public void textDecoration(TextDecoration textDecoration) {
        this.flags |= 64;
        this.textEnums = ((textDecoration.getMask() | 4) << 14) | this.textEnums;
    }

    @Override // androidx.compose.foundation.style.StyleScope
    public void fontFamily(FontFamily fontFamily) {
        this.flags |= 32;
        this.fontFamily = fontFamily;
    }

    @Override // androidx.compose.foundation.style.StyleScope
    public void textIndent(TextIndent textIndent) {
        this.flags |= 32;
        this.textIndent = textIndent;
    }

    @Override // androidx.compose.foundation.style.StyleScope
    /* renamed from: fontSize--R2X_6o  reason: not valid java name */
    public void mo1409fontSizeR2X_6o(long j) {
        this.flags |= 32;
        this.fontSize = j;
    }

    @Override // androidx.compose.foundation.style.StyleScope
    /* renamed from: lineHeight--R2X_6o  reason: not valid java name */
    public void mo1433lineHeightR2X_6o(long j) {
        this.flags |= 32;
        this.lineHeight = j;
    }

    @Override // androidx.compose.foundation.style.StyleScope
    /* renamed from: letterSpacing--R2X_6o  reason: not valid java name */
    public void mo1431letterSpacingR2X_6o(long j) {
        this.flags |= 32;
        this.letterSpacing = j;
    }

    @Override // androidx.compose.foundation.style.StyleScope
    /* renamed from: baselineShift-4Dl_Bck  reason: not valid java name */
    public void mo1384baselineShift4Dl_Bck(float f) {
        this.flags |= 32;
        this.baselineShift = f;
    }

    @Override // androidx.compose.foundation.style.StyleScope
    /* renamed from: lineBreak-CZqVlQI  reason: not valid java name */
    public void mo1432lineBreakCZqVlQI(int i) {
        this.flags |= 32;
        this.lineBreak = i;
    }

    @Override // androidx.compose.foundation.style.StyleScope
    /* renamed from: fontStyle-nzbMABs  reason: not valid java name */
    public void mo1410fontStylenzbMABs(int i) {
        this.flags |= 32;
        this.textEnums = ((i | 2) & 3) | (this.textEnums & (-4));
    }

    @Override // androidx.compose.foundation.style.StyleScope
    /* renamed from: textAlign-aXe7zB0  reason: not valid java name */
    public void mo1456textAlignaXe7zB0(int i) {
        this.flags |= 32;
        this.textEnums = ((i << 2) & 28) | (this.textEnums & (-29));
    }

    @Override // androidx.compose.foundation.style.StyleScope
    /* renamed from: textDirection-Hejc4pk  reason: not valid java name */
    public void mo1457textDirectionHejc4pk(int i) {
        this.flags |= 32;
        this.textEnums = ((i << 4) & 112) | (this.textEnums & (-113));
    }

    @Override // androidx.compose.foundation.style.StyleScope
    /* renamed from: hyphens--3fSNIE  reason: not valid java name */
    public void mo1429hyphens3fSNIE(int i) {
        this.flags |= 32;
        this.textEnums = ((i << 8) & ViewUtils.EDGE_TO_EDGE_FLAGS) | (this.textEnums & (-769));
    }

    @Override // androidx.compose.foundation.style.StyleScope
    public void fontWeight(FontWeight fontWeight) {
        this.flags |= 32;
        this.textEnums = ((fontWeight.getWeight() << 17) & 134086656) | (this.textEnums & (-134086657));
    }

    @Override // androidx.compose.foundation.style.StyleScope
    /* renamed from: fontSynthesis-6p3vJLY  reason: not valid java name */
    public void mo1411fontSynthesis6p3vJLY(int i) {
        this.flags |= 32;
        this.textEnums = (((i & 7) | 8) << 10) | this.textEnums;
    }

    @Override // androidx.compose.foundation.style.StyleScope
    public <T> void state(StyleStateKey<T> styleStateKey, Style style, Function2<? super StyleStateKey<T>, ? super StyleState, Boolean> function2) {
        group(styleStateKey.hashCode(), function2.invoke(styleStateKey, getState()).booleanValue(), style);
    }

    public final void startResolve$foundation(StyleOuterNode styleOuterNode, Density density, boolean z) {
        this.currentIndex = 0;
        this.compositeHash = 0;
        this.node = styleOuterNode;
        this._density = density.getDensity();
        this.animating = z;
    }

    public final void doneResolve$foundation() {
        this.node = null;
        this.animating = false;
    }

    private final MutableIntList pushIndex(int i) {
        MutableIntList mutableIntList = this.indexStack;
        if (mutableIntList == null) {
            mutableIntList = new MutableIntList(0, 1, null);
            this.indexStack = mutableIntList;
        }
        mutableIntList.add(i);
        return mutableIntList;
    }

    private final void group(int i, Function0<Unit> function0) {
        int i2 = this.currentIndex;
        int i3 = i ^ i2;
        this.compositeHash = ResolvedStyleKt.access$updateHashEnter(this.compositeHash, i3);
        MutableIntList pushIndex = pushIndex(i2);
        this.currentIndex = 0;
        function0.invoke();
        this.currentIndex = pushIndex.removeAt(pushIndex._size - 1) + 1;
        this.compositeHash = ResolvedStyleKt.access$updateHashExit(this.compositeHash, i3);
    }

    private final void skippedGroup() {
        this.currentIndex++;
    }

    private final int getCurrentCompositeHash() {
        return this.currentIndex ^ this.compositeHash;
    }

    private final void group(int i, boolean z, Style style) {
        int i2 = this.currentIndex;
        if (z) {
            int i3 = i ^ i2;
            this.compositeHash = ResolvedStyleKt.access$updateHashEnter(this.compositeHash, i3);
            MutableIntList pushIndex = pushIndex(i2);
            this.currentIndex = 0;
            style.applyStyle(this);
            this.currentIndex = pushIndex.removeAt(pushIndex._size - 1) + 1;
            this.compositeHash = ResolvedStyleKt.access$updateHashExit(this.compositeHash, i3);
            return;
        }
        this.currentIndex = i2 + 1;
    }
}
