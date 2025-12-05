package androidx.compose.ui.text;

import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
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
import androidx.compose.ui.text.style.TextForegroundStyle;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.TextUnit;
import androidx.core.view.ViewCompat;
import androidx.media3.extractor.text.ttml.TtmlNode;
import io.appmetrica.analytics.impl.A2;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: TextStyle.kt */
@Metadata(d1 = {"\u0000Â\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b]\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\b\u0007\u0018\u0000 ¤\u00012\u00020\u0001:\u0002¤\u0001B%\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tB\u0019\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\nB×\u0001\b\u0017\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f\u0012\b\b\u0002\u0010 \u001a\u00020\f\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010(\u0012\b\b\u0002\u0010)\u001a\u00020\u000e\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010+¢\u0006\u0004\b\b\u0010,Bï\u0001\b\u0017\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f\u0012\b\b\u0002\u0010 \u001a\u00020\f\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010(\u0012\b\b\u0002\u0010)\u001a\u00020\u000e\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010+\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010.¢\u0006\u0004\b\b\u0010/B\u0087\u0002\b\u0017\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f\u0012\b\b\u0002\u0010 \u001a\u00020\f\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010(\u0012\b\b\u0002\u0010)\u001a\u00020\u000e\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010+\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010.\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u000101\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u000103¢\u0006\u0004\b\b\u00104B\u009f\u0002\b\u0017\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f\u0012\b\b\u0002\u0010 \u001a\u00020\f\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$\u0012\n\b\u0002\u00105\u001a\u0004\u0018\u000106\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010(\u0012\b\b\u0002\u0010)\u001a\u00020\u000e\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010+\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010.\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u000101\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u000103\u0012\n\b\u0002\u00107\u001a\u0004\u0018\u000108¢\u0006\u0004\b\b\u00109B\u0097\u0002\b\u0016\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f\u0012\b\b\u0002\u0010 \u001a\u00020\f\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$\u0012\n\b\u0002\u00105\u001a\u0004\u0018\u000106\u0012\b\b\u0002\u0010%\u001a\u00020&\u0012\b\b\u0002\u0010'\u001a\u00020(\u0012\b\b\u0002\u0010)\u001a\u00020\u000e\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010+\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010.\u0012\b\b\u0002\u00100\u001a\u000201\u0012\b\b\u0002\u00102\u001a\u000203\u0012\n\b\u0002\u00107\u001a\u0004\u0018\u000108¢\u0006\u0004\b\b\u0010:B¡\u0002\b\u0016\u0012\b\u0010;\u001a\u0004\u0018\u00010<\u0012\b\b\u0002\u0010=\u001a\u00020>\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f\u0012\b\b\u0002\u0010 \u001a\u00020\f\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$\u0012\n\b\u0002\u00105\u001a\u0004\u0018\u000106\u0012\b\b\u0002\u0010%\u001a\u00020&\u0012\b\b\u0002\u0010'\u001a\u00020(\u0012\b\b\u0002\u0010)\u001a\u00020\u000e\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010+\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010.\u0012\b\b\u0002\u00100\u001a\u000201\u0012\b\b\u0002\u00102\u001a\u000203\u0012\n\b\u0002\u00107\u001a\u0004\u0018\u000108¢\u0006\u0004\b\b\u0010?B©\u0002\b\u0017\u0012\b\u0010;\u001a\u0004\u0018\u00010<\u0012\b\b\u0002\u0010=\u001a\u00020>\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f\u0012\b\b\u0002\u0010 \u001a\u00020\f\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$\u0012\n\b\u0002\u00105\u001a\u0004\u0018\u000106\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010(\u0012\b\b\u0002\u0010)\u001a\u00020\u000e\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010+\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010.\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u000101\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u000103\u0012\n\b\u0002\u00107\u001a\u0004\u0018\u000108¢\u0006\u0004\b\b\u0010@J\b\u0010G\u001a\u00020\u0003H\u0007J\b\u0010H\u001a\u00020\u0005H\u0007J\u0014\u0010I\u001a\u00020\u00002\n\b\u0002\u0010J\u001a\u0004\u0018\u00010\u0000H\u0007J\u009d\u0002\u0010I\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u000e2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020\f2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$2\n\b\u0002\u00105\u001a\u0004\u0018\u0001062\b\b\u0002\u0010%\u001a\u00020&2\b\b\u0002\u0010'\u001a\u00020(2\b\b\u0002\u0010)\u001a\u00020\u000e2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010+2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010.2\b\b\u0002\u00100\u001a\u0002012\b\b\u0002\u00102\u001a\u0002032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u00107\u001a\u0004\u0018\u000108H\u0007¢\u0006\u0004\bK\u0010LJ¥\u0002\u0010I\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u000e2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020\f2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$2\n\b\u0002\u00105\u001a\u0004\u0018\u0001062\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010(2\b\b\u0002\u0010)\u001a\u00020\u000e2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010+2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010.2\n\b\u0002\u00100\u001a\u0004\u0018\u0001012\n\b\u0002\u00102\u001a\u0004\u0018\u0001032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u00107\u001a\u0004\u0018\u000108H\u0007¢\u0006\u0004\bM\u0010NJ\u0010\u0010I\u001a\u00020\u00002\u0006\u0010J\u001a\u00020\u0003H\u0007J\u0010\u0010I\u001a\u00020\u00002\u0006\u0010J\u001a\u00020\u0005H\u0007J\u0011\u0010O\u001a\u00020\u00002\u0006\u0010J\u001a\u00020\u0000H\u0087\u0002J\u0011\u0010O\u001a\u00020\u00002\u0006\u0010J\u001a\u00020\u0005H\u0087\u0002J\u0011\u0010O\u001a\u00020\u00002\u0006\u0010J\u001a\u00020\u0003H\u0087\u0002JÝ\u0001\u0010P\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u000e2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020\f2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010(2\b\b\u0002\u0010)\u001a\u00020\u000e2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010+H\u0007¢\u0006\u0004\bQ\u0010RJõ\u0001\u0010P\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u000e2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020\f2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010(2\b\b\u0002\u0010)\u001a\u00020\u000e2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010+2\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010-\u001a\u0004\u0018\u00010.H\u0007¢\u0006\u0004\bS\u0010TJ\u008d\u0002\u0010P\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u000e2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020\f2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010(2\b\b\u0002\u0010)\u001a\u00020\u000e2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010+2\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010-\u001a\u0004\u0018\u00010.2\n\b\u0002\u00100\u001a\u0004\u0018\u0001012\n\b\u0002\u00102\u001a\u0004\u0018\u000103H\u0007¢\u0006\u0004\bU\u0010VJ¥\u0002\u0010P\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u000e2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020\f2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$2\n\b\u0002\u00105\u001a\u0004\u0018\u0001062\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010(2\b\b\u0002\u0010)\u001a\u00020\u000e2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010+2\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010-\u001a\u0004\u0018\u00010.2\n\b\u0002\u00100\u001a\u0004\u0018\u0001012\n\b\u0002\u00102\u001a\u0004\u0018\u0001032\n\b\u0002\u00107\u001a\u0004\u0018\u000108H\u0007¢\u0006\u0004\bW\u0010XJ\u009b\u0002\u0010P\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u000e2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020\f2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$2\n\b\u0002\u00105\u001a\u0004\u0018\u0001062\b\b\u0002\u0010%\u001a\u00020&2\b\b\u0002\u0010'\u001a\u00020(2\b\b\u0002\u0010)\u001a\u00020\u000e2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010+2\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010-\u001a\u0004\u0018\u00010.2\b\b\u0002\u00100\u001a\u0002012\b\b\u0002\u00102\u001a\u0002032\n\b\u0002\u00107\u001a\u0004\u0018\u000108¢\u0006\u0004\bY\u0010ZJ¯\u0002\u0010P\u001a\u00020\u00002\b\u0010;\u001a\u0004\u0018\u00010<2\b\b\u0002\u0010=\u001a\u00020>2\b\b\u0002\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u000e2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020\f2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$2\n\b\u0002\u00105\u001a\u0004\u0018\u0001062\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010(2\b\b\u0002\u0010)\u001a\u00020\u000e2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010+2\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010-\u001a\u0004\u0018\u00010.2\n\b\u0002\u00100\u001a\u0004\u0018\u0001012\n\b\u0002\u00102\u001a\u0004\u0018\u0001032\n\b\u0002\u00107\u001a\u0004\u0018\u000108H\u0007¢\u0006\u0004\b[\u0010\\J¥\u0002\u0010P\u001a\u00020\u00002\b\u0010;\u001a\u0004\u0018\u00010<2\b\b\u0002\u0010=\u001a\u00020>2\b\b\u0002\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u000e2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020\f2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$2\n\b\u0002\u00105\u001a\u0004\u0018\u0001062\b\b\u0002\u0010%\u001a\u00020&2\b\b\u0002\u0010'\u001a\u00020(2\b\b\u0002\u0010)\u001a\u00020\u000e2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010+2\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010-\u001a\u0004\u0018\u00010.2\b\b\u0002\u00100\u001a\u0002012\b\b\u0002\u00102\u001a\u0002032\n\b\u0002\u00107\u001a\u0004\u0018\u000108¢\u0006\u0004\b]\u0010^J\u0015\u0010\u009b\u0001\u001a\u00030\u009c\u00012\b\u0010J\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\u0010\u0010\u009d\u0001\u001a\u00030\u009c\u00012\u0006\u0010J\u001a\u00020\u0000J\u0010\u0010\u009e\u0001\u001a\u00030\u009c\u00012\u0006\u0010J\u001a\u00020\u0000J\n\u0010\u009f\u0001\u001a\u00030 \u0001H\u0016J\u0010\u0010¡\u0001\u001a\u00030 \u0001H\u0000¢\u0006\u0003\b¢\u0001J\t\u0010£\u0001\u001a\u00020\u0018H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bA\u0010BR\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bC\u0010DR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\bE\u0010FR\u0013\u0010;\u001a\u0004\u0018\u00010<8F¢\u0006\u0006\u001a\u0004\b_\u0010`R\u0011\u0010\u000b\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\ba\u0010bR\u0011\u0010=\u001a\u00020>8F¢\u0006\u0006\u001a\u0004\bc\u0010dR\u0011\u0010\r\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\be\u0010bR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u00108F¢\u0006\u0006\u001a\u0004\bf\u0010gR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u00128F¢\u0006\u0006\u001a\u0004\bh\u0010iR\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u00148F¢\u0006\u0006\u001a\u0004\bj\u0010kR\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u00168F¢\u0006\u0006\u001a\u0004\bl\u0010mR\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u00188F¢\u0006\u0006\u001a\u0004\bn\u0010oR\u0011\u0010\u0019\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\bp\u0010bR\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u001b8F¢\u0006\u0006\u001a\u0004\bq\u0010rR\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u001d8F¢\u0006\u0006\u001a\u0004\bs\u0010tR\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u001f8F¢\u0006\u0006\u001a\u0004\bu\u0010vR\u0011\u0010 \u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\bw\u0010bR\u0013\u0010!\u001a\u0004\u0018\u00010\"8F¢\u0006\u0006\u001a\u0004\bx\u0010yR\u0013\u0010#\u001a\u0004\u0018\u00010$8F¢\u0006\u0006\u001a\u0004\bz\u0010{R\u0013\u00105\u001a\u0004\u0018\u0001068F¢\u0006\u0006\u001a\u0004\b|\u0010}R\u0011\u0010%\u001a\u00020&8F¢\u0006\u0006\u001a\u0004\b~\u0010\u007fR!\u0010\u0080\u0001\u001a\u0004\u0018\u00010&8GX\u0087\u0004¢\u0006\u0010\u0012\u0006\b\u0081\u0001\u0010\u0082\u0001\u001a\u0006\b\u0083\u0001\u0010\u0084\u0001R\u0012\u0010'\u001a\u00020(8F¢\u0006\u0007\u001a\u0005\b\u0085\u0001\u0010\u007fR!\u0010\u0086\u0001\u001a\u0004\u0018\u00010(8GX\u0087\u0004¢\u0006\u0010\u0012\u0006\b\u0087\u0001\u0010\u0082\u0001\u001a\u0006\b\u0088\u0001\u0010\u0089\u0001R\u0012\u0010)\u001a\u00020\u000e8F¢\u0006\u0007\u001a\u0005\b\u008a\u0001\u0010bR\u0015\u0010*\u001a\u0004\u0018\u00010+8F¢\u0006\b\u001a\u0006\b\u008b\u0001\u0010\u008c\u0001R\u0015\u0010-\u001a\u0004\u0018\u00010.8F¢\u0006\b\u001a\u0006\b\u008d\u0001\u0010\u008e\u0001R\u0012\u00102\u001a\u0002038F¢\u0006\u0007\u001a\u0005\b\u008f\u0001\u0010\u007fR!\u0010\u0090\u0001\u001a\u0004\u0018\u0001038GX\u0087\u0004¢\u0006\u0010\u0012\u0006\b\u0091\u0001\u0010\u0082\u0001\u001a\u0006\b\u0092\u0001\u0010\u0093\u0001R\u0012\u00100\u001a\u0002018F¢\u0006\u0007\u001a\u0005\b\u0094\u0001\u0010\u007fR!\u0010\u0095\u0001\u001a\u0004\u0018\u0001018GX\u0087\u0004¢\u0006\u0010\u0012\u0006\b\u0096\u0001\u0010\u0082\u0001\u001a\u0006\b\u0097\u0001\u0010\u0098\u0001R\u0015\u00107\u001a\u0004\u0018\u0001088F¢\u0006\b\u001a\u0006\b\u0099\u0001\u0010\u009a\u0001¨\u0006¥\u0001"}, d2 = {"Landroidx/compose/ui/text/TextStyle;", "", "spanStyle", "Landroidx/compose/ui/text/SpanStyle;", "paragraphStyle", "Landroidx/compose/ui/text/ParagraphStyle;", "platformStyle", "Landroidx/compose/ui/text/PlatformTextStyle;", "<init>", "(Landroidx/compose/ui/text/SpanStyle;Landroidx/compose/ui/text/ParagraphStyle;Landroidx/compose/ui/text/PlatformTextStyle;)V", "(Landroidx/compose/ui/text/SpanStyle;Landroidx/compose/ui/text/ParagraphStyle;)V", "color", "Landroidx/compose/ui/graphics/Color;", TtmlNode.ATTR_TTS_FONT_SIZE, "Landroidx/compose/ui/unit/TextUnit;", TtmlNode.ATTR_TTS_FONT_WEIGHT, "Landroidx/compose/ui/text/font/FontWeight;", TtmlNode.ATTR_TTS_FONT_STYLE, "Landroidx/compose/ui/text/font/FontStyle;", "fontSynthesis", "Landroidx/compose/ui/text/font/FontSynthesis;", TtmlNode.ATTR_TTS_FONT_FAMILY, "Landroidx/compose/ui/text/font/FontFamily;", "fontFeatureSettings", "", "letterSpacing", "baselineShift", "Landroidx/compose/ui/text/style/BaselineShift;", "textGeometricTransform", "Landroidx/compose/ui/text/style/TextGeometricTransform;", "localeList", "Landroidx/compose/ui/text/intl/LocaleList;", A2.g, TtmlNode.ATTR_TTS_TEXT_DECORATION, "Landroidx/compose/ui/text/style/TextDecoration;", "shadow", "Landroidx/compose/ui/graphics/Shadow;", TtmlNode.ATTR_TTS_TEXT_ALIGN, "Landroidx/compose/ui/text/style/TextAlign;", "textDirection", "Landroidx/compose/ui/text/style/TextDirection;", "lineHeight", "textIndent", "Landroidx/compose/ui/text/style/TextIndent;", "(JJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "lineHeightStyle", "Landroidx/compose/ui/text/style/LineHeightStyle;", "(JJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformTextStyle;Landroidx/compose/ui/text/style/LineHeightStyle;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "lineBreak", "Landroidx/compose/ui/text/style/LineBreak;", "hyphens", "Landroidx/compose/ui/text/style/Hyphens;", "(JJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformTextStyle;Landroidx/compose/ui/text/style/LineHeightStyle;Landroidx/compose/ui/text/style/LineBreak;Landroidx/compose/ui/text/style/Hyphens;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "drawStyle", "Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "textMotion", "Landroidx/compose/ui/text/style/TextMotion;", "(JJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformTextStyle;Landroidx/compose/ui/text/style/LineHeightStyle;Landroidx/compose/ui/text/style/LineBreak;Landroidx/compose/ui/text/style/Hyphens;Landroidx/compose/ui/text/style/TextMotion;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "(JJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/graphics/drawscope/DrawStyle;IIJLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformTextStyle;Landroidx/compose/ui/text/style/LineHeightStyle;IILandroidx/compose/ui/text/style/TextMotion;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "brush", "Landroidx/compose/ui/graphics/Brush;", "alpha", "", "(Landroidx/compose/ui/graphics/Brush;FJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/graphics/drawscope/DrawStyle;IIJLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformTextStyle;Landroidx/compose/ui/text/style/LineHeightStyle;IILandroidx/compose/ui/text/style/TextMotion;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "(Landroidx/compose/ui/graphics/Brush;FJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformTextStyle;Landroidx/compose/ui/text/style/LineHeightStyle;Landroidx/compose/ui/text/style/LineBreak;Landroidx/compose/ui/text/style/Hyphens;Landroidx/compose/ui/text/style/TextMotion;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getSpanStyle$ui_text", "()Landroidx/compose/ui/text/SpanStyle;", "getParagraphStyle$ui_text", "()Landroidx/compose/ui/text/ParagraphStyle;", "getPlatformStyle", "()Landroidx/compose/ui/text/PlatformTextStyle;", "toSpanStyle", "toParagraphStyle", "merge", "other", "merge-dA7vx0o", "(JJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/graphics/drawscope/DrawStyle;IIJLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/style/LineHeightStyle;IILandroidx/compose/ui/text/PlatformTextStyle;Landroidx/compose/ui/text/style/TextMotion;)Landroidx/compose/ui/text/TextStyle;", "merge-Z1GrekI", "(JJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/style/LineHeightStyle;Landroidx/compose/ui/text/style/LineBreak;Landroidx/compose/ui/text/style/Hyphens;Landroidx/compose/ui/text/PlatformTextStyle;Landroidx/compose/ui/text/style/TextMotion;)Landroidx/compose/ui/text/TextStyle;", "plus", "copy", "copy-HL5avdY", "(JJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;)Landroidx/compose/ui/text/TextStyle;", "copy-NOaFTUo", "(JJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformTextStyle;Landroidx/compose/ui/text/style/LineHeightStyle;)Landroidx/compose/ui/text/TextStyle;", "copy-CXVQc50", "(JJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformTextStyle;Landroidx/compose/ui/text/style/LineHeightStyle;Landroidx/compose/ui/text/style/LineBreak;Landroidx/compose/ui/text/style/Hyphens;)Landroidx/compose/ui/text/TextStyle;", "copy-v2rsoow", "(JJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformTextStyle;Landroidx/compose/ui/text/style/LineHeightStyle;Landroidx/compose/ui/text/style/LineBreak;Landroidx/compose/ui/text/style/Hyphens;Landroidx/compose/ui/text/style/TextMotion;)Landroidx/compose/ui/text/TextStyle;", "copy-p1EtxEg", "(JJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/graphics/drawscope/DrawStyle;IIJLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformTextStyle;Landroidx/compose/ui/text/style/LineHeightStyle;IILandroidx/compose/ui/text/style/TextMotion;)Landroidx/compose/ui/text/TextStyle;", "copy-aIRg9q4", "(Landroidx/compose/ui/graphics/Brush;FJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformTextStyle;Landroidx/compose/ui/text/style/LineHeightStyle;Landroidx/compose/ui/text/style/LineBreak;Landroidx/compose/ui/text/style/Hyphens;Landroidx/compose/ui/text/style/TextMotion;)Landroidx/compose/ui/text/TextStyle;", "copy-Ns73l9s", "(Landroidx/compose/ui/graphics/Brush;FJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/graphics/drawscope/DrawStyle;IIJLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformTextStyle;Landroidx/compose/ui/text/style/LineHeightStyle;IILandroidx/compose/ui/text/style/TextMotion;)Landroidx/compose/ui/text/TextStyle;", "getBrush", "()Landroidx/compose/ui/graphics/Brush;", "getColor-0d7_KjU", "()J", "getAlpha", "()F", "getFontSize-XSAIIZE", "getFontWeight", "()Landroidx/compose/ui/text/font/FontWeight;", "getFontStyle-4Lr2A7w", "()Landroidx/compose/ui/text/font/FontStyle;", "getFontSynthesis-ZQGJjVo", "()Landroidx/compose/ui/text/font/FontSynthesis;", "getFontFamily", "()Landroidx/compose/ui/text/font/FontFamily;", "getFontFeatureSettings", "()Ljava/lang/String;", "getLetterSpacing-XSAIIZE", "getBaselineShift-5SSeXJ0", "()Landroidx/compose/ui/text/style/BaselineShift;", "getTextGeometricTransform", "()Landroidx/compose/ui/text/style/TextGeometricTransform;", "getLocaleList", "()Landroidx/compose/ui/text/intl/LocaleList;", "getBackground-0d7_KjU", "getTextDecoration", "()Landroidx/compose/ui/text/style/TextDecoration;", "getShadow", "()Landroidx/compose/ui/graphics/Shadow;", "getDrawStyle", "()Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "getTextAlign-e0LSkKk", "()I", "deprecated_boxing_textAlign", "getTextAlign-buA522U$annotations", "()V", "getTextAlign-buA522U", "()Landroidx/compose/ui/text/style/TextAlign;", "getTextDirection-s_7X-co", "deprecated_boxing_textDirection", "getTextDirection-mmuk1to$annotations", "getTextDirection-mmuk1to", "()Landroidx/compose/ui/text/style/TextDirection;", "getLineHeight-XSAIIZE", "getTextIndent", "()Landroidx/compose/ui/text/style/TextIndent;", "getLineHeightStyle", "()Landroidx/compose/ui/text/style/LineHeightStyle;", "getHyphens-vmbZdU8", "deprecated_boxing_hyphens", "getHyphens-EaSxIns$annotations", "getHyphens-EaSxIns", "()Landroidx/compose/ui/text/style/Hyphens;", "getLineBreak-rAG3T2k", "deprecated_boxing_lineBreak", "getLineBreak-LgCVezo$annotations", "getLineBreak-LgCVezo", "()Landroidx/compose/ui/text/style/LineBreak;", "getTextMotion", "()Landroidx/compose/ui/text/style/TextMotion;", "equals", "", "hasSameLayoutAffectingAttributes", "hasSameDrawAffectingAttributes", "hashCode", "", "hashCodeLayoutAffectingAttributes", "hashCodeLayoutAffectingAttributes$ui_text", "toString", "Companion", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class TextStyle {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private static final TextStyle Default = new TextStyle(0, 0, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, (int) ViewCompat.MEASURED_SIZE_MASK, (DefaultConstructorMarker) null);
    private final ParagraphStyle paragraphStyle;
    private final PlatformTextStyle platformStyle;
    private final SpanStyle spanStyle;

    public /* synthetic */ TextStyle(long j, long j2, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j3, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j4, TextDecoration textDecoration, Shadow shadow, DrawStyle drawStyle, int i, int i2, long j5, TextIndent textIndent, PlatformTextStyle platformTextStyle, LineHeightStyle lineHeightStyle, int i3, int i4, TextMotion textMotion, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j3, baselineShift, textGeometricTransform, localeList, j4, textDecoration, shadow, drawStyle, i, i2, j5, textIndent, platformTextStyle, lineHeightStyle, i3, i4, textMotion);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "TextStyle constructors that take nullable TextAlign, TextDirection, LineBreak, and Hyphens are deprecated. Please use a new constructor where these parameters are non-nullable. Null value has been replaced by a special Unspecified object for performance reason.")
    public /* synthetic */ TextStyle(long j, long j2, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j3, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j4, TextDecoration textDecoration, Shadow shadow, DrawStyle drawStyle, TextAlign textAlign, TextDirection textDirection, long j5, TextIndent textIndent, PlatformTextStyle platformTextStyle, LineHeightStyle lineHeightStyle, LineBreak lineBreak, Hyphens hyphens, TextMotion textMotion, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j3, baselineShift, textGeometricTransform, localeList, j4, textDecoration, shadow, drawStyle, textAlign, textDirection, j5, textIndent, platformTextStyle, lineHeightStyle, lineBreak, hyphens, textMotion);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "TextStyle constructors that do not take new stable parameters like TextMotion are deprecated. Please use the new stable constructor.")
    public /* synthetic */ TextStyle(long j, long j2, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j3, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j4, TextDecoration textDecoration, Shadow shadow, TextAlign textAlign, TextDirection textDirection, long j5, TextIndent textIndent, PlatformTextStyle platformTextStyle, LineHeightStyle lineHeightStyle, LineBreak lineBreak, Hyphens hyphens, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j3, baselineShift, textGeometricTransform, localeList, j4, textDecoration, shadow, textAlign, textDirection, j5, textIndent, platformTextStyle, lineHeightStyle, lineBreak, hyphens);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "TextStyle constructors that do not take new stable parameters like LineHeightStyle, LineBreak, Hyphens are deprecated. Please use the new stable constructor.")
    public /* synthetic */ TextStyle(long j, long j2, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j3, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j4, TextDecoration textDecoration, Shadow shadow, TextAlign textAlign, TextDirection textDirection, long j5, TextIndent textIndent, PlatformTextStyle platformTextStyle, LineHeightStyle lineHeightStyle, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j3, baselineShift, textGeometricTransform, localeList, j4, textDecoration, shadow, textAlign, textDirection, j5, textIndent, platformTextStyle, lineHeightStyle);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "TextStyle constructors that do not take new stable parameters like LineHeightStyle, LineBreak, Hyphens are deprecated. Please use the new stable constructor.")
    public /* synthetic */ TextStyle(long j, long j2, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j3, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j4, TextDecoration textDecoration, Shadow shadow, TextAlign textAlign, TextDirection textDirection, long j5, TextIndent textIndent, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j3, baselineShift, textGeometricTransform, localeList, j4, textDecoration, shadow, textAlign, textDirection, j5, textIndent);
    }

    public /* synthetic */ TextStyle(Brush brush, float f, long j, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j2, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j3, TextDecoration textDecoration, Shadow shadow, DrawStyle drawStyle, int i, int i2, long j4, TextIndent textIndent, PlatformTextStyle platformTextStyle, LineHeightStyle lineHeightStyle, int i3, int i4, TextMotion textMotion, DefaultConstructorMarker defaultConstructorMarker) {
        this(brush, f, j, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j2, baselineShift, textGeometricTransform, localeList, j3, textDecoration, shadow, drawStyle, i, i2, j4, textIndent, platformTextStyle, lineHeightStyle, i3, i4, textMotion);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "TextStyle constructors that take nullable TextAlign, TextDirection, LineBreak, and Hyphens are deprecated. Please use a new constructor where these parameters are non-nullable. Null value has been replaced by a special Unspecified object for performance reason.")
    public /* synthetic */ TextStyle(Brush brush, float f, long j, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j2, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j3, TextDecoration textDecoration, Shadow shadow, DrawStyle drawStyle, TextAlign textAlign, TextDirection textDirection, long j4, TextIndent textIndent, PlatformTextStyle platformTextStyle, LineHeightStyle lineHeightStyle, LineBreak lineBreak, Hyphens hyphens, TextMotion textMotion, DefaultConstructorMarker defaultConstructorMarker) {
        this(brush, f, j, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j2, baselineShift, textGeometricTransform, localeList, j3, textDecoration, shadow, drawStyle, textAlign, textDirection, j4, textIndent, platformTextStyle, lineHeightStyle, lineBreak, hyphens, textMotion);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Kept for backwards compatibility.")
    /* renamed from: getHyphens-EaSxIns$annotations  reason: not valid java name */
    public static /* synthetic */ void m7716getHyphensEaSxIns$annotations() {
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Kept for backwards compatibility.")
    /* renamed from: getLineBreak-LgCVezo$annotations  reason: not valid java name */
    public static /* synthetic */ void m7717getLineBreakLgCVezo$annotations() {
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Kept for backwards compatibility.")
    /* renamed from: getTextAlign-buA522U$annotations  reason: not valid java name */
    public static /* synthetic */ void m7718getTextAlignbuA522U$annotations() {
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Kept for backwards compatibility.")
    /* renamed from: getTextDirection-mmuk1to$annotations  reason: not valid java name */
    public static /* synthetic */ void m7719getTextDirectionmmuk1to$annotations() {
    }

    public TextStyle(SpanStyle spanStyle, ParagraphStyle paragraphStyle, PlatformTextStyle platformTextStyle) {
        this.spanStyle = spanStyle;
        this.paragraphStyle = paragraphStyle;
        this.platformStyle = platformTextStyle;
    }

    public /* synthetic */ TextStyle(SpanStyle spanStyle, ParagraphStyle paragraphStyle, PlatformTextStyle platformTextStyle, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(spanStyle, paragraphStyle, (i & 4) != 0 ? null : platformTextStyle);
    }

    public final SpanStyle getSpanStyle$ui_text() {
        return this.spanStyle;
    }

    public final ParagraphStyle getParagraphStyle$ui_text() {
        return this.paragraphStyle;
    }

    public final PlatformTextStyle getPlatformStyle() {
        return this.platformStyle;
    }

    public TextStyle(SpanStyle spanStyle, ParagraphStyle paragraphStyle) {
        this(spanStyle, paragraphStyle, TextStyleKt.access$createPlatformTextStyleInternal(spanStyle.getPlatformStyle(), paragraphStyle.getPlatformStyle()));
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ TextStyle(long j, long j2, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j3, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j4, TextDecoration textDecoration, Shadow shadow, TextAlign textAlign, TextDirection textDirection, long j5, TextIndent textIndent, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(r18, r3, r5, r31, r32, r33, r34, r35, r37, r38, r39, r40, r6, r1, (i & 16384) != 0 ? null : textAlign, (i & 32768) != 0 ? null : textDirection, (i & 65536) != 0 ? TextUnit.Companion.m8463getUnspecifiedXSAIIZE() : j5, (i & 131072) != 0 ? null : textIndent, null);
        long m5460getUnspecified0d7_KjU = (i & 1) != 0 ? Color.Companion.m5460getUnspecified0d7_KjU() : j;
        long m8463getUnspecifiedXSAIIZE = (i & 2) != 0 ? TextUnit.Companion.m8463getUnspecifiedXSAIIZE() : j2;
        FontWeight fontWeight2 = (i & 4) != 0 ? null : fontWeight;
        FontStyle fontStyle2 = (i & 8) != 0 ? null : fontStyle;
        FontSynthesis fontSynthesis2 = (i & 16) != 0 ? null : fontSynthesis;
        FontFamily fontFamily2 = (i & 32) != 0 ? null : fontFamily;
        String str2 = (i & 64) != 0 ? null : str;
        long m8463getUnspecifiedXSAIIZE2 = (i & 128) != 0 ? TextUnit.Companion.m8463getUnspecifiedXSAIIZE() : j3;
        BaselineShift baselineShift2 = (i & 256) != 0 ? null : baselineShift;
        TextGeometricTransform textGeometricTransform2 = (i & 512) != 0 ? null : textGeometricTransform;
        LocaleList localeList2 = (i & 1024) != 0 ? null : localeList;
        long m5460getUnspecified0d7_KjU2 = (i & 2048) != 0 ? Color.Companion.m5460getUnspecified0d7_KjU() : j4;
        TextDecoration textDecoration2 = (i & 4096) != 0 ? null : textDecoration;
        long j6 = m5460getUnspecified0d7_KjU;
        Shadow shadow2 = (i & 8192) != 0 ? null : shadow;
        FontStyle fontStyle3 = fontStyle2;
        FontSynthesis fontSynthesis3 = fontSynthesis2;
        FontFamily fontFamily3 = fontFamily2;
        String str3 = str2;
        long j7 = m8463getUnspecifiedXSAIIZE2;
        BaselineShift baselineShift3 = baselineShift2;
        TextGeometricTransform textGeometricTransform3 = textGeometricTransform2;
        LocaleList localeList3 = localeList2;
        long j8 = m5460getUnspecified0d7_KjU2;
    }

    private TextStyle(long j, long j2, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j3, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j4, TextDecoration textDecoration, Shadow shadow, TextAlign textAlign, TextDirection textDirection, long j5, TextIndent textIndent) {
        this(new SpanStyle(j, j2, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j3, baselineShift, textGeometricTransform, localeList, j4, textDecoration, shadow, (PlatformSpanStyle) null, (DrawStyle) null, (DefaultConstructorMarker) null), new ParagraphStyle(textAlign != null ? textAlign.m8135unboximpl() : TextAlign.Companion.m8142getUnspecifiede0LSkKk(), textDirection != null ? textDirection.m8152unboximpl() : TextDirection.Companion.m8158getUnspecifieds_7Xco(), j5, textIndent, (PlatformParagraphStyle) null, (LineHeightStyle) null, LineBreak.Companion.m8054getUnspecifiedrAG3T2k(), Hyphens.Companion.m8030getUnspecifiedvmbZdU8(), (TextMotion) null, (DefaultConstructorMarker) null), null);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ TextStyle(long j, long j2, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j3, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j4, TextDecoration textDecoration, Shadow shadow, TextAlign textAlign, TextDirection textDirection, long j5, TextIndent textIndent, PlatformTextStyle platformTextStyle, LineHeightStyle lineHeightStyle, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(r18, r3, r5, r33, r34, r35, r36, r37, r39, r40, r41, r42, r6, r1, (i & 16384) != 0 ? null : textAlign, (i & 32768) != 0 ? null : textDirection, (i & 65536) != 0 ? TextUnit.Companion.m8463getUnspecifiedXSAIIZE() : j5, (i & 131072) != 0 ? null : textIndent, (i & 262144) != 0 ? null : platformTextStyle, (i & 524288) != 0 ? null : lineHeightStyle, null);
        long m5460getUnspecified0d7_KjU = (i & 1) != 0 ? Color.Companion.m5460getUnspecified0d7_KjU() : j;
        long m8463getUnspecifiedXSAIIZE = (i & 2) != 0 ? TextUnit.Companion.m8463getUnspecifiedXSAIIZE() : j2;
        FontWeight fontWeight2 = (i & 4) != 0 ? null : fontWeight;
        FontStyle fontStyle2 = (i & 8) != 0 ? null : fontStyle;
        FontSynthesis fontSynthesis2 = (i & 16) != 0 ? null : fontSynthesis;
        FontFamily fontFamily2 = (i & 32) != 0 ? null : fontFamily;
        String str2 = (i & 64) != 0 ? null : str;
        long m8463getUnspecifiedXSAIIZE2 = (i & 128) != 0 ? TextUnit.Companion.m8463getUnspecifiedXSAIIZE() : j3;
        BaselineShift baselineShift2 = (i & 256) != 0 ? null : baselineShift;
        TextGeometricTransform textGeometricTransform2 = (i & 512) != 0 ? null : textGeometricTransform;
        LocaleList localeList2 = (i & 1024) != 0 ? null : localeList;
        long m5460getUnspecified0d7_KjU2 = (i & 2048) != 0 ? Color.Companion.m5460getUnspecified0d7_KjU() : j4;
        TextDecoration textDecoration2 = (i & 4096) != 0 ? null : textDecoration;
        long j6 = m5460getUnspecified0d7_KjU;
        Shadow shadow2 = (i & 8192) != 0 ? null : shadow;
        FontStyle fontStyle3 = fontStyle2;
        FontSynthesis fontSynthesis3 = fontSynthesis2;
        FontFamily fontFamily3 = fontFamily2;
        String str3 = str2;
        long j7 = m8463getUnspecifiedXSAIIZE2;
        BaselineShift baselineShift3 = baselineShift2;
        TextGeometricTransform textGeometricTransform3 = textGeometricTransform2;
        LocaleList localeList3 = localeList2;
        long j8 = m5460getUnspecified0d7_KjU2;
    }

    private TextStyle(long j, long j2, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j3, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j4, TextDecoration textDecoration, Shadow shadow, TextAlign textAlign, TextDirection textDirection, long j5, TextIndent textIndent, PlatformTextStyle platformTextStyle, LineHeightStyle lineHeightStyle) {
        this(new SpanStyle(j, j2, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j3, baselineShift, textGeometricTransform, localeList, j4, textDecoration, shadow, platformTextStyle != null ? platformTextStyle.getSpanStyle() : null, (DrawStyle) null, (DefaultConstructorMarker) null), new ParagraphStyle(textAlign != null ? textAlign.m8135unboximpl() : TextAlign.Companion.m8142getUnspecifiede0LSkKk(), textDirection != null ? textDirection.m8152unboximpl() : TextDirection.Companion.m8158getUnspecifieds_7Xco(), j5, textIndent, platformTextStyle != null ? platformTextStyle.getParagraphStyle() : null, lineHeightStyle, LineBreak.Companion.m8054getUnspecifiedrAG3T2k(), Hyphens.Companion.m8030getUnspecifiedvmbZdU8(), (TextMotion) null, (DefaultConstructorMarker) null), platformTextStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ TextStyle(long j, long j2, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j3, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j4, TextDecoration textDecoration, Shadow shadow, TextAlign textAlign, TextDirection textDirection, long j5, TextIndent textIndent, PlatformTextStyle platformTextStyle, LineHeightStyle lineHeightStyle, LineBreak lineBreak, Hyphens hyphens, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(r18, r3, r5, r35, r36, r37, r38, r39, r41, r42, r43, r44, r6, r1, (i & 16384) != 0 ? null : textAlign, (i & 32768) != 0 ? null : textDirection, (i & 65536) != 0 ? TextUnit.Companion.m8463getUnspecifiedXSAIIZE() : j5, (i & 131072) != 0 ? null : textIndent, (i & 262144) != 0 ? null : platformTextStyle, (i & 524288) != 0 ? null : lineHeightStyle, (i & 1048576) != 0 ? null : lineBreak, (i & 2097152) != 0 ? null : hyphens, null);
        long m5460getUnspecified0d7_KjU = (i & 1) != 0 ? Color.Companion.m5460getUnspecified0d7_KjU() : j;
        long m8463getUnspecifiedXSAIIZE = (i & 2) != 0 ? TextUnit.Companion.m8463getUnspecifiedXSAIIZE() : j2;
        FontWeight fontWeight2 = (i & 4) != 0 ? null : fontWeight;
        FontStyle fontStyle2 = (i & 8) != 0 ? null : fontStyle;
        FontSynthesis fontSynthesis2 = (i & 16) != 0 ? null : fontSynthesis;
        FontFamily fontFamily2 = (i & 32) != 0 ? null : fontFamily;
        String str2 = (i & 64) != 0 ? null : str;
        long m8463getUnspecifiedXSAIIZE2 = (i & 128) != 0 ? TextUnit.Companion.m8463getUnspecifiedXSAIIZE() : j3;
        BaselineShift baselineShift2 = (i & 256) != 0 ? null : baselineShift;
        TextGeometricTransform textGeometricTransform2 = (i & 512) != 0 ? null : textGeometricTransform;
        LocaleList localeList2 = (i & 1024) != 0 ? null : localeList;
        long m5460getUnspecified0d7_KjU2 = (i & 2048) != 0 ? Color.Companion.m5460getUnspecified0d7_KjU() : j4;
        TextDecoration textDecoration2 = (i & 4096) != 0 ? null : textDecoration;
        long j6 = m5460getUnspecified0d7_KjU;
        Shadow shadow2 = (i & 8192) != 0 ? null : shadow;
        FontStyle fontStyle3 = fontStyle2;
        FontSynthesis fontSynthesis3 = fontSynthesis2;
        FontFamily fontFamily3 = fontFamily2;
        String str3 = str2;
        long j7 = m8463getUnspecifiedXSAIIZE2;
        BaselineShift baselineShift3 = baselineShift2;
        TextGeometricTransform textGeometricTransform3 = textGeometricTransform2;
        LocaleList localeList3 = localeList2;
        long j8 = m5460getUnspecified0d7_KjU2;
    }

    private TextStyle(long j, long j2, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j3, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j4, TextDecoration textDecoration, Shadow shadow, TextAlign textAlign, TextDirection textDirection, long j5, TextIndent textIndent, PlatformTextStyle platformTextStyle, LineHeightStyle lineHeightStyle, LineBreak lineBreak, Hyphens hyphens) {
        this(new SpanStyle(j, j2, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j3, baselineShift, textGeometricTransform, localeList, j4, textDecoration, shadow, platformTextStyle != null ? platformTextStyle.getSpanStyle() : null, (DrawStyle) null, 32768, (DefaultConstructorMarker) null), new ParagraphStyle(textAlign != null ? textAlign.m8135unboximpl() : TextAlign.Companion.m8142getUnspecifiede0LSkKk(), textDirection != null ? textDirection.m8152unboximpl() : TextDirection.Companion.m8158getUnspecifieds_7Xco(), j5, textIndent, platformTextStyle != null ? platformTextStyle.getParagraphStyle() : null, lineHeightStyle, lineBreak != null ? lineBreak.m8046unboximpl() : LineBreak.Companion.m8054getUnspecifiedrAG3T2k(), hyphens != null ? hyphens.m8027unboximpl() : Hyphens.Companion.m8030getUnspecifiedvmbZdU8(), (TextMotion) null, 256, (DefaultConstructorMarker) null), platformTextStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ TextStyle(long j, long j2, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j3, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j4, TextDecoration textDecoration, Shadow shadow, DrawStyle drawStyle, TextAlign textAlign, TextDirection textDirection, long j5, TextIndent textIndent, PlatformTextStyle platformTextStyle, LineHeightStyle lineHeightStyle, LineBreak lineBreak, Hyphens hyphens, TextMotion textMotion, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(r18, r3, r5, r37, r38, r39, r40, r41, r43, r44, r45, r46, r6, r1, (i & 16384) != 0 ? null : drawStyle, (i & 32768) != 0 ? null : textAlign, (i & 65536) != 0 ? null : textDirection, (i & 131072) != 0 ? TextUnit.Companion.m8463getUnspecifiedXSAIIZE() : j5, (i & 262144) != 0 ? null : textIndent, (i & 524288) != 0 ? null : platformTextStyle, (i & 1048576) != 0 ? null : lineHeightStyle, (i & 2097152) != 0 ? null : lineBreak, (i & 4194304) != 0 ? null : hyphens, (i & 8388608) != 0 ? null : textMotion, (DefaultConstructorMarker) null);
        long m5460getUnspecified0d7_KjU = (i & 1) != 0 ? Color.Companion.m5460getUnspecified0d7_KjU() : j;
        long m8463getUnspecifiedXSAIIZE = (i & 2) != 0 ? TextUnit.Companion.m8463getUnspecifiedXSAIIZE() : j2;
        FontWeight fontWeight2 = (i & 4) != 0 ? null : fontWeight;
        FontStyle fontStyle2 = (i & 8) != 0 ? null : fontStyle;
        FontSynthesis fontSynthesis2 = (i & 16) != 0 ? null : fontSynthesis;
        FontFamily fontFamily2 = (i & 32) != 0 ? null : fontFamily;
        String str2 = (i & 64) != 0 ? null : str;
        long m8463getUnspecifiedXSAIIZE2 = (i & 128) != 0 ? TextUnit.Companion.m8463getUnspecifiedXSAIIZE() : j3;
        BaselineShift baselineShift2 = (i & 256) != 0 ? null : baselineShift;
        TextGeometricTransform textGeometricTransform2 = (i & 512) != 0 ? null : textGeometricTransform;
        LocaleList localeList2 = (i & 1024) != 0 ? null : localeList;
        long m5460getUnspecified0d7_KjU2 = (i & 2048) != 0 ? Color.Companion.m5460getUnspecified0d7_KjU() : j4;
        TextDecoration textDecoration2 = (i & 4096) != 0 ? null : textDecoration;
        long j6 = m5460getUnspecified0d7_KjU;
        Shadow shadow2 = (i & 8192) != 0 ? null : shadow;
        FontStyle fontStyle3 = fontStyle2;
        FontSynthesis fontSynthesis3 = fontSynthesis2;
        FontFamily fontFamily3 = fontFamily2;
        String str3 = str2;
        long j7 = m8463getUnspecifiedXSAIIZE2;
        BaselineShift baselineShift3 = baselineShift2;
        TextGeometricTransform textGeometricTransform3 = textGeometricTransform2;
        LocaleList localeList3 = localeList2;
        long j8 = m5460getUnspecified0d7_KjU2;
    }

    private TextStyle(long j, long j2, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j3, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j4, TextDecoration textDecoration, Shadow shadow, DrawStyle drawStyle, TextAlign textAlign, TextDirection textDirection, long j5, TextIndent textIndent, PlatformTextStyle platformTextStyle, LineHeightStyle lineHeightStyle, LineBreak lineBreak, Hyphens hyphens, TextMotion textMotion) {
        this(new SpanStyle(j, j2, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j3, baselineShift, textGeometricTransform, localeList, j4, textDecoration, shadow, platformTextStyle != null ? platformTextStyle.getSpanStyle() : null, drawStyle, (DefaultConstructorMarker) null), new ParagraphStyle(textAlign != null ? textAlign.m8135unboximpl() : TextAlign.Companion.m8142getUnspecifiede0LSkKk(), textDirection != null ? textDirection.m8152unboximpl() : TextDirection.Companion.m8158getUnspecifieds_7Xco(), j5, textIndent, platformTextStyle != null ? platformTextStyle.getParagraphStyle() : null, lineHeightStyle, lineBreak != null ? lineBreak.m8046unboximpl() : LineBreak.Companion.m8054getUnspecifiedrAG3T2k(), hyphens != null ? hyphens.m8027unboximpl() : Hyphens.Companion.m8030getUnspecifiedvmbZdU8(), textMotion, (DefaultConstructorMarker) null), platformTextStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ TextStyle(long j, long j2, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j3, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j4, TextDecoration textDecoration, Shadow shadow, DrawStyle drawStyle, int i, int i2, long j5, TextIndent textIndent, PlatformTextStyle platformTextStyle, LineHeightStyle lineHeightStyle, int i3, int i4, TextMotion textMotion, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(r18, r3, r5, r37, r38, r39, r40, r41, r43, r44, r45, r46, r6, r1, (i5 & 16384) != 0 ? null : drawStyle, (i5 & 32768) != 0 ? TextAlign.Companion.m8142getUnspecifiede0LSkKk() : i, (i5 & 65536) != 0 ? TextDirection.Companion.m8158getUnspecifieds_7Xco() : i2, (i5 & 131072) != 0 ? TextUnit.Companion.m8463getUnspecifiedXSAIIZE() : j5, (i5 & 262144) != 0 ? null : textIndent, (i5 & 524288) != 0 ? null : platformTextStyle, (i5 & 1048576) != 0 ? null : lineHeightStyle, (i5 & 2097152) != 0 ? LineBreak.Companion.m8054getUnspecifiedrAG3T2k() : i3, (i5 & 4194304) != 0 ? Hyphens.Companion.m8030getUnspecifiedvmbZdU8() : i4, (i5 & 8388608) != 0 ? null : textMotion, (DefaultConstructorMarker) null);
        long m5460getUnspecified0d7_KjU = (i5 & 1) != 0 ? Color.Companion.m5460getUnspecified0d7_KjU() : j;
        long m8463getUnspecifiedXSAIIZE = (i5 & 2) != 0 ? TextUnit.Companion.m8463getUnspecifiedXSAIIZE() : j2;
        FontWeight fontWeight2 = (i5 & 4) != 0 ? null : fontWeight;
        FontStyle fontStyle2 = (i5 & 8) != 0 ? null : fontStyle;
        FontSynthesis fontSynthesis2 = (i5 & 16) != 0 ? null : fontSynthesis;
        FontFamily fontFamily2 = (i5 & 32) != 0 ? null : fontFamily;
        String str2 = (i5 & 64) != 0 ? null : str;
        long m8463getUnspecifiedXSAIIZE2 = (i5 & 128) != 0 ? TextUnit.Companion.m8463getUnspecifiedXSAIIZE() : j3;
        BaselineShift baselineShift2 = (i5 & 256) != 0 ? null : baselineShift;
        TextGeometricTransform textGeometricTransform2 = (i5 & 512) != 0 ? null : textGeometricTransform;
        LocaleList localeList2 = (i5 & 1024) != 0 ? null : localeList;
        long m5460getUnspecified0d7_KjU2 = (i5 & 2048) != 0 ? Color.Companion.m5460getUnspecified0d7_KjU() : j4;
        TextDecoration textDecoration2 = (i5 & 4096) != 0 ? null : textDecoration;
        long j6 = m5460getUnspecified0d7_KjU;
        Shadow shadow2 = (i5 & 8192) != 0 ? null : shadow;
        FontStyle fontStyle3 = fontStyle2;
        FontSynthesis fontSynthesis3 = fontSynthesis2;
        FontFamily fontFamily3 = fontFamily2;
        String str3 = str2;
        long j7 = m8463getUnspecifiedXSAIIZE2;
        BaselineShift baselineShift3 = baselineShift2;
        TextGeometricTransform textGeometricTransform3 = textGeometricTransform2;
        LocaleList localeList3 = localeList2;
        long j8 = m5460getUnspecified0d7_KjU2;
    }

    private TextStyle(long j, long j2, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j3, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j4, TextDecoration textDecoration, Shadow shadow, DrawStyle drawStyle, int i, int i2, long j5, TextIndent textIndent, PlatformTextStyle platformTextStyle, LineHeightStyle lineHeightStyle, int i3, int i4, TextMotion textMotion) {
        this(new SpanStyle(j, j2, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j3, baselineShift, textGeometricTransform, localeList, j4, textDecoration, shadow, platformTextStyle != null ? platformTextStyle.getSpanStyle() : null, drawStyle, (DefaultConstructorMarker) null), new ParagraphStyle(i, i2, j5, textIndent, platformTextStyle != null ? platformTextStyle.getParagraphStyle() : null, lineHeightStyle, i3, i4, textMotion, (DefaultConstructorMarker) null), platformTextStyle);
    }

    public /* synthetic */ TextStyle(Brush brush, float f, long j, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j2, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j3, TextDecoration textDecoration, Shadow shadow, DrawStyle drawStyle, int i, int i2, long j4, TextIndent textIndent, PlatformTextStyle platformTextStyle, LineHeightStyle lineHeightStyle, int i3, int i4, TextMotion textMotion, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(brush, (i5 & 2) != 0 ? Float.NaN : f, (i5 & 4) != 0 ? TextUnit.Companion.m8463getUnspecifiedXSAIIZE() : j, (i5 & 8) != 0 ? null : fontWeight, (i5 & 16) != 0 ? null : fontStyle, (i5 & 32) != 0 ? null : fontSynthesis, (i5 & 64) != 0 ? null : fontFamily, (i5 & 128) != 0 ? null : str, (i5 & 256) != 0 ? TextUnit.Companion.m8463getUnspecifiedXSAIIZE() : j2, (i5 & 512) != 0 ? null : baselineShift, (i5 & 1024) != 0 ? null : textGeometricTransform, (i5 & 2048) != 0 ? null : localeList, (i5 & 4096) != 0 ? Color.Companion.m5460getUnspecified0d7_KjU() : j3, (i5 & 8192) != 0 ? null : textDecoration, (i5 & 16384) != 0 ? null : shadow, (32768 & i5) != 0 ? null : drawStyle, (65536 & i5) != 0 ? TextAlign.Companion.m8142getUnspecifiede0LSkKk() : i, (131072 & i5) != 0 ? TextDirection.Companion.m8158getUnspecifieds_7Xco() : i2, (262144 & i5) != 0 ? TextUnit.Companion.m8463getUnspecifiedXSAIIZE() : j4, (524288 & i5) != 0 ? null : textIndent, (1048576 & i5) != 0 ? null : platformTextStyle, (2097152 & i5) != 0 ? null : lineHeightStyle, (4194304 & i5) != 0 ? LineBreak.Companion.m8054getUnspecifiedrAG3T2k() : i3, (8388608 & i5) != 0 ? Hyphens.Companion.m8030getUnspecifiedvmbZdU8() : i4, (i5 & 16777216) != 0 ? null : textMotion, (DefaultConstructorMarker) null);
    }

    private TextStyle(Brush brush, float f, long j, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j2, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j3, TextDecoration textDecoration, Shadow shadow, DrawStyle drawStyle, int i, int i2, long j4, TextIndent textIndent, PlatformTextStyle platformTextStyle, LineHeightStyle lineHeightStyle, int i3, int i4, TextMotion textMotion) {
        this(new SpanStyle(brush, f, j, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j2, baselineShift, textGeometricTransform, localeList, j3, textDecoration, shadow, platformTextStyle != null ? platformTextStyle.getSpanStyle() : null, drawStyle, (DefaultConstructorMarker) null), new ParagraphStyle(i, i2, j4, textIndent, platformTextStyle != null ? platformTextStyle.getParagraphStyle() : null, lineHeightStyle, i3, i4, textMotion, (DefaultConstructorMarker) null), platformTextStyle);
    }

    public /* synthetic */ TextStyle(Brush brush, float f, long j, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j2, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j3, TextDecoration textDecoration, Shadow shadow, DrawStyle drawStyle, TextAlign textAlign, TextDirection textDirection, long j4, TextIndent textIndent, PlatformTextStyle platformTextStyle, LineHeightStyle lineHeightStyle, LineBreak lineBreak, Hyphens hyphens, TextMotion textMotion, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(brush, (i & 2) != 0 ? Float.NaN : f, (i & 4) != 0 ? TextUnit.Companion.m8463getUnspecifiedXSAIIZE() : j, (i & 8) != 0 ? null : fontWeight, (i & 16) != 0 ? null : fontStyle, (i & 32) != 0 ? null : fontSynthesis, (i & 64) != 0 ? null : fontFamily, (i & 128) != 0 ? null : str, (i & 256) != 0 ? TextUnit.Companion.m8463getUnspecifiedXSAIIZE() : j2, (i & 512) != 0 ? null : baselineShift, (i & 1024) != 0 ? null : textGeometricTransform, (i & 2048) != 0 ? null : localeList, (i & 4096) != 0 ? Color.Companion.m5460getUnspecified0d7_KjU() : j3, (i & 8192) != 0 ? null : textDecoration, (i & 16384) != 0 ? null : shadow, (32768 & i) != 0 ? null : drawStyle, (65536 & i) != 0 ? null : textAlign, (131072 & i) != 0 ? null : textDirection, (262144 & i) != 0 ? TextUnit.Companion.m8463getUnspecifiedXSAIIZE() : j4, (524288 & i) != 0 ? null : textIndent, (1048576 & i) != 0 ? null : platformTextStyle, (2097152 & i) != 0 ? null : lineHeightStyle, (4194304 & i) != 0 ? null : lineBreak, (8388608 & i) != 0 ? null : hyphens, (i & 16777216) != 0 ? null : textMotion, (DefaultConstructorMarker) null);
    }

    private TextStyle(Brush brush, float f, long j, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j2, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j3, TextDecoration textDecoration, Shadow shadow, DrawStyle drawStyle, TextAlign textAlign, TextDirection textDirection, long j4, TextIndent textIndent, PlatformTextStyle platformTextStyle, LineHeightStyle lineHeightStyle, LineBreak lineBreak, Hyphens hyphens, TextMotion textMotion) {
        this(new SpanStyle(brush, f, j, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j2, baselineShift, textGeometricTransform, localeList, j3, textDecoration, shadow, platformTextStyle != null ? platformTextStyle.getSpanStyle() : null, drawStyle, (DefaultConstructorMarker) null), new ParagraphStyle(textAlign != null ? textAlign.m8135unboximpl() : TextAlign.Companion.m8142getUnspecifiede0LSkKk(), textDirection != null ? textDirection.m8152unboximpl() : TextDirection.Companion.m8158getUnspecifieds_7Xco(), j4, textIndent, platformTextStyle != null ? platformTextStyle.getParagraphStyle() : null, lineHeightStyle, lineBreak != null ? lineBreak.m8046unboximpl() : LineBreak.Companion.m8054getUnspecifiedrAG3T2k(), hyphens != null ? hyphens.m8027unboximpl() : Hyphens.Companion.m8030getUnspecifiedvmbZdU8(), textMotion, (DefaultConstructorMarker) null), platformTextStyle);
    }

    public final SpanStyle toSpanStyle() {
        return this.spanStyle;
    }

    public final ParagraphStyle toParagraphStyle() {
        return this.paragraphStyle;
    }

    public static /* synthetic */ TextStyle merge$default(TextStyle textStyle, TextStyle textStyle2, int i, Object obj) {
        if ((i & 1) != 0) {
            textStyle2 = null;
        }
        return textStyle.merge(textStyle2);
    }

    public final TextStyle merge(TextStyle textStyle) {
        return (textStyle == null || Intrinsics.areEqual(textStyle, Default)) ? this : new TextStyle(toSpanStyle().merge(textStyle.toSpanStyle()), toParagraphStyle().merge(textStyle.toParagraphStyle()));
    }

    /* renamed from: merge-dA7vx0o$default  reason: not valid java name */
    public static /* synthetic */ TextStyle m7721mergedA7vx0o$default(TextStyle textStyle, long j, long j2, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j3, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j4, TextDecoration textDecoration, Shadow shadow, DrawStyle drawStyle, int i, int i2, long j5, TextIndent textIndent, LineHeightStyle lineHeightStyle, int i3, int i4, PlatformTextStyle platformTextStyle, TextMotion textMotion, int i5, Object obj) {
        long m5460getUnspecified0d7_KjU = (i5 & 1) != 0 ? Color.Companion.m5460getUnspecified0d7_KjU() : j;
        return textStyle.m7746mergedA7vx0o(m5460getUnspecified0d7_KjU, (i5 & 2) != 0 ? TextUnit.Companion.m8463getUnspecifiedXSAIIZE() : j2, (i5 & 4) != 0 ? null : fontWeight, (i5 & 8) != 0 ? null : fontStyle, (i5 & 16) != 0 ? null : fontSynthesis, (i5 & 32) != 0 ? null : fontFamily, (i5 & 64) != 0 ? null : str, (i5 & 128) != 0 ? TextUnit.Companion.m8463getUnspecifiedXSAIIZE() : j3, (i5 & 256) != 0 ? null : baselineShift, (i5 & 512) != 0 ? null : textGeometricTransform, (i5 & 1024) != 0 ? null : localeList, (i5 & 2048) != 0 ? Color.Companion.m5460getUnspecified0d7_KjU() : j4, (i5 & 4096) != 0 ? null : textDecoration, (i5 & 8192) != 0 ? null : shadow, (i5 & 16384) != 0 ? null : drawStyle, (i5 & 32768) != 0 ? TextAlign.Companion.m8142getUnspecifiede0LSkKk() : i, (i5 & 65536) != 0 ? TextDirection.Companion.m8158getUnspecifieds_7Xco() : i2, (i5 & 131072) != 0 ? TextUnit.Companion.m8463getUnspecifiedXSAIIZE() : j5, (i5 & 262144) != 0 ? null : textIndent, (i5 & 524288) != 0 ? null : lineHeightStyle, (i5 & 1048576) != 0 ? LineBreak.Companion.m8054getUnspecifiedrAG3T2k() : i3, (i5 & 2097152) != 0 ? Hyphens.Companion.m8030getUnspecifiedvmbZdU8() : i4, (i5 & 4194304) != 0 ? null : platformTextStyle, (i5 & 8388608) != 0 ? null : textMotion);
    }

    /* renamed from: merge-dA7vx0o  reason: not valid java name */
    public final TextStyle m7746mergedA7vx0o(long j, long j2, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j3, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j4, TextDecoration textDecoration, Shadow shadow, DrawStyle drawStyle, int i, int i2, long j5, TextIndent textIndent, LineHeightStyle lineHeightStyle, int i3, int i4, PlatformTextStyle platformTextStyle, TextMotion textMotion) {
        SpanStyle m7646fastMergedSHsh3o = SpanStyleKt.m7646fastMergedSHsh3o(this.spanStyle, j, null, Float.NaN, j2, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j3, baselineShift, textGeometricTransform, localeList, j4, textDecoration, shadow, platformTextStyle != null ? platformTextStyle.getSpanStyle() : null, drawStyle);
        ParagraphStyle m7583fastMergej5T8yCg = ParagraphStyleKt.m7583fastMergej5T8yCg(this.paragraphStyle, i, i2, j5, textIndent, platformTextStyle != null ? platformTextStyle.getParagraphStyle() : null, lineHeightStyle, i3, i4, textMotion);
        return (this.spanStyle == m7646fastMergedSHsh3o && this.paragraphStyle == m7583fastMergej5T8yCg) ? this : new TextStyle(m7646fastMergedSHsh3o, m7583fastMergej5T8yCg);
    }

    /* renamed from: merge-Z1GrekI$default  reason: not valid java name */
    public static /* synthetic */ TextStyle m7720mergeZ1GrekI$default(TextStyle textStyle, long j, long j2, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j3, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j4, TextDecoration textDecoration, Shadow shadow, DrawStyle drawStyle, TextAlign textAlign, TextDirection textDirection, long j5, TextIndent textIndent, LineHeightStyle lineHeightStyle, LineBreak lineBreak, Hyphens hyphens, PlatformTextStyle platformTextStyle, TextMotion textMotion, int i, Object obj) {
        long m5460getUnspecified0d7_KjU = (i & 1) != 0 ? Color.Companion.m5460getUnspecified0d7_KjU() : j;
        return textStyle.m7745mergeZ1GrekI(m5460getUnspecified0d7_KjU, (i & 2) != 0 ? TextUnit.Companion.m8463getUnspecifiedXSAIIZE() : j2, (i & 4) != 0 ? null : fontWeight, (i & 8) != 0 ? null : fontStyle, (i & 16) != 0 ? null : fontSynthesis, (i & 32) != 0 ? null : fontFamily, (i & 64) != 0 ? null : str, (i & 128) != 0 ? TextUnit.Companion.m8463getUnspecifiedXSAIIZE() : j3, (i & 256) != 0 ? null : baselineShift, (i & 512) != 0 ? null : textGeometricTransform, (i & 1024) != 0 ? null : localeList, (i & 2048) != 0 ? Color.Companion.m5460getUnspecified0d7_KjU() : j4, (i & 4096) != 0 ? null : textDecoration, (i & 8192) != 0 ? null : shadow, (i & 16384) != 0 ? null : drawStyle, (i & 32768) != 0 ? null : textAlign, (i & 65536) != 0 ? null : textDirection, (i & 131072) != 0 ? TextUnit.Companion.m8463getUnspecifiedXSAIIZE() : j5, (i & 262144) != 0 ? null : textIndent, (i & 524288) != 0 ? null : lineHeightStyle, (i & 1048576) != 0 ? null : lineBreak, (i & 2097152) != 0 ? null : hyphens, (i & 4194304) != 0 ? null : platformTextStyle, (i & 8388608) != 0 ? null : textMotion);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "merge that takes nullable TextAlign, TextDirection, LineBreak, and Hyphens are deprecated. Please use a new constructor where these parameters are non-nullable. Null value has been replaced by a special Unspecified object for performance reason.")
    /* renamed from: merge-Z1GrekI  reason: not valid java name */
    public final /* synthetic */ TextStyle m7745mergeZ1GrekI(long j, long j2, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j3, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j4, TextDecoration textDecoration, Shadow shadow, DrawStyle drawStyle, TextAlign textAlign, TextDirection textDirection, long j5, TextIndent textIndent, LineHeightStyle lineHeightStyle, LineBreak lineBreak, Hyphens hyphens, PlatformTextStyle platformTextStyle, TextMotion textMotion) {
        SpanStyle m7646fastMergedSHsh3o = SpanStyleKt.m7646fastMergedSHsh3o(this.spanStyle, j, null, Float.NaN, j2, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j3, baselineShift, textGeometricTransform, localeList, j4, textDecoration, shadow, platformTextStyle != null ? platformTextStyle.getSpanStyle() : null, drawStyle);
        ParagraphStyle m7583fastMergej5T8yCg = ParagraphStyleKt.m7583fastMergej5T8yCg(this.paragraphStyle, textAlign != null ? textAlign.m8135unboximpl() : TextAlign.Companion.m8142getUnspecifiede0LSkKk(), textDirection != null ? textDirection.m8152unboximpl() : TextDirection.Companion.m8158getUnspecifieds_7Xco(), j5, textIndent, platformTextStyle != null ? platformTextStyle.getParagraphStyle() : null, lineHeightStyle, lineBreak != null ? lineBreak.m8046unboximpl() : LineBreak.Companion.m8054getUnspecifiedrAG3T2k(), hyphens != null ? hyphens.m8027unboximpl() : Hyphens.Companion.m8030getUnspecifiedvmbZdU8(), textMotion);
        return (this.spanStyle == m7646fastMergedSHsh3o && this.paragraphStyle == m7583fastMergej5T8yCg) ? this : new TextStyle(m7646fastMergedSHsh3o, m7583fastMergej5T8yCg);
    }

    public final TextStyle merge(SpanStyle spanStyle) {
        return new TextStyle(toSpanStyle().merge(spanStyle), toParagraphStyle());
    }

    public final TextStyle merge(ParagraphStyle paragraphStyle) {
        return new TextStyle(toSpanStyle(), toParagraphStyle().merge(paragraphStyle));
    }

    public final TextStyle plus(TextStyle textStyle) {
        return merge(textStyle);
    }

    public final TextStyle plus(ParagraphStyle paragraphStyle) {
        return merge(paragraphStyle);
    }

    public final TextStyle plus(SpanStyle spanStyle) {
        return merge(spanStyle);
    }

    /* renamed from: copy-HL5avdY$default  reason: not valid java name */
    public static /* synthetic */ TextStyle m7710copyHL5avdY$default(TextStyle textStyle, long j, long j2, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j3, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j4, TextDecoration textDecoration, Shadow shadow, TextAlign textAlign, TextDirection textDirection, long j5, TextIndent textIndent, int i, Object obj) {
        long m7641getColor0d7_KjU = (i & 1) != 0 ? textStyle.spanStyle.m7641getColor0d7_KjU() : j;
        long m7642getFontSizeXSAIIZE = (i & 2) != 0 ? textStyle.spanStyle.m7642getFontSizeXSAIIZE() : j2;
        FontWeight fontWeight2 = (i & 4) != 0 ? textStyle.spanStyle.getFontWeight() : fontWeight;
        FontStyle m7643getFontStyle4Lr2A7w = (i & 8) != 0 ? textStyle.spanStyle.m7643getFontStyle4Lr2A7w() : fontStyle;
        FontSynthesis m7644getFontSynthesisZQGJjVo = (i & 16) != 0 ? textStyle.spanStyle.m7644getFontSynthesisZQGJjVo() : fontSynthesis;
        FontFamily fontFamily2 = (i & 32) != 0 ? textStyle.spanStyle.getFontFamily() : fontFamily;
        String fontFeatureSettings = (i & 64) != 0 ? textStyle.spanStyle.getFontFeatureSettings() : str;
        long m7645getLetterSpacingXSAIIZE = (i & 128) != 0 ? textStyle.spanStyle.m7645getLetterSpacingXSAIIZE() : j3;
        BaselineShift m7640getBaselineShift5SSeXJ0 = (i & 256) != 0 ? textStyle.spanStyle.m7640getBaselineShift5SSeXJ0() : baselineShift;
        TextGeometricTransform textGeometricTransform2 = (i & 512) != 0 ? textStyle.spanStyle.getTextGeometricTransform() : textGeometricTransform;
        LocaleList localeList2 = (i & 1024) != 0 ? textStyle.spanStyle.getLocaleList() : localeList;
        long j6 = m7641getColor0d7_KjU;
        long m7639getBackground0d7_KjU = (i & 2048) != 0 ? textStyle.spanStyle.m7639getBackground0d7_KjU() : j4;
        TextDecoration textDecoration2 = (i & 4096) != 0 ? textStyle.spanStyle.getTextDecoration() : textDecoration;
        return textStyle.m7723copyHL5avdY(j6, m7642getFontSizeXSAIIZE, fontWeight2, m7643getFontStyle4Lr2A7w, m7644getFontSynthesisZQGJjVo, fontFamily2, fontFeatureSettings, m7645getLetterSpacingXSAIIZE, m7640getBaselineShift5SSeXJ0, textGeometricTransform2, localeList2, m7639getBackground0d7_KjU, textDecoration2, (i & 8192) != 0 ? textStyle.spanStyle.getShadow() : shadow, (i & 16384) != 0 ? TextAlign.m8129boximpl(textStyle.paragraphStyle.m7580getTextAligne0LSkKk()) : textAlign, (i & 32768) != 0 ? TextDirection.m8146boximpl(textStyle.paragraphStyle.m7582getTextDirections_7Xco()) : textDirection, (i & 65536) != 0 ? textStyle.paragraphStyle.m7578getLineHeightXSAIIZE() : j5, (i & 131072) != 0 ? textStyle.paragraphStyle.getTextIndent() : textIndent);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "TextStyle copy constructors that do not take new stable parameters like LineHeightStyle, LineBreak, Hyphens are deprecated. Please use the new stable copy constructor.")
    /* renamed from: copy-HL5avdY  reason: not valid java name */
    public final /* synthetic */ TextStyle m7723copyHL5avdY(long j, long j2, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j3, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j4, TextDecoration textDecoration, Shadow shadow, TextAlign textAlign, TextDirection textDirection, long j5, TextIndent textIndent) {
        TextForegroundStyle m8163from8_81llA;
        if (Color.m5425equalsimpl0(j, this.spanStyle.m7641getColor0d7_KjU())) {
            m8163from8_81llA = this.spanStyle.getTextForegroundStyle$ui_text();
        } else {
            m8163from8_81llA = TextForegroundStyle.Companion.m8163from8_81llA(j);
        }
        return new TextStyle(new SpanStyle(m8163from8_81llA, j2, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j3, baselineShift, textGeometricTransform, localeList, j4, textDecoration, shadow, this.spanStyle.getPlatformStyle(), this.spanStyle.getDrawStyle(), (DefaultConstructorMarker) null), new ParagraphStyle(textAlign != null ? textAlign.m8135unboximpl() : TextAlign.Companion.m8142getUnspecifiede0LSkKk(), textDirection != null ? textDirection.m8152unboximpl() : TextDirection.Companion.m8158getUnspecifieds_7Xco(), j5, textIndent, this.paragraphStyle.getPlatformStyle(), getLineHeightStyle(), m7739getLineBreakrAG3T2k(), m7736getHyphensvmbZdU8(), getTextMotion(), (DefaultConstructorMarker) null), this.platformStyle);
    }

    /* renamed from: copy-NOaFTUo$default  reason: not valid java name */
    public static /* synthetic */ TextStyle m7711copyNOaFTUo$default(TextStyle textStyle, long j, long j2, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j3, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j4, TextDecoration textDecoration, Shadow shadow, TextAlign textAlign, TextDirection textDirection, long j5, TextIndent textIndent, PlatformTextStyle platformTextStyle, LineHeightStyle lineHeightStyle, int i, Object obj) {
        LineHeightStyle lineHeightStyle2;
        PlatformTextStyle platformTextStyle2;
        long m7641getColor0d7_KjU = (i & 1) != 0 ? textStyle.spanStyle.m7641getColor0d7_KjU() : j;
        long m7642getFontSizeXSAIIZE = (i & 2) != 0 ? textStyle.spanStyle.m7642getFontSizeXSAIIZE() : j2;
        FontWeight fontWeight2 = (i & 4) != 0 ? textStyle.spanStyle.getFontWeight() : fontWeight;
        FontStyle m7643getFontStyle4Lr2A7w = (i & 8) != 0 ? textStyle.spanStyle.m7643getFontStyle4Lr2A7w() : fontStyle;
        FontSynthesis m7644getFontSynthesisZQGJjVo = (i & 16) != 0 ? textStyle.spanStyle.m7644getFontSynthesisZQGJjVo() : fontSynthesis;
        FontFamily fontFamily2 = (i & 32) != 0 ? textStyle.spanStyle.getFontFamily() : fontFamily;
        String fontFeatureSettings = (i & 64) != 0 ? textStyle.spanStyle.getFontFeatureSettings() : str;
        long m7645getLetterSpacingXSAIIZE = (i & 128) != 0 ? textStyle.spanStyle.m7645getLetterSpacingXSAIIZE() : j3;
        BaselineShift m7640getBaselineShift5SSeXJ0 = (i & 256) != 0 ? textStyle.spanStyle.m7640getBaselineShift5SSeXJ0() : baselineShift;
        TextGeometricTransform textGeometricTransform2 = (i & 512) != 0 ? textStyle.spanStyle.getTextGeometricTransform() : textGeometricTransform;
        LocaleList localeList2 = (i & 1024) != 0 ? textStyle.spanStyle.getLocaleList() : localeList;
        long j6 = m7641getColor0d7_KjU;
        long m7639getBackground0d7_KjU = (i & 2048) != 0 ? textStyle.spanStyle.m7639getBackground0d7_KjU() : j4;
        TextDecoration textDecoration2 = (i & 4096) != 0 ? textStyle.spanStyle.getTextDecoration() : textDecoration;
        Shadow shadow2 = (i & 8192) != 0 ? textStyle.spanStyle.getShadow() : shadow;
        TextDecoration textDecoration3 = textDecoration2;
        TextAlign m8129boximpl = (i & 16384) != 0 ? TextAlign.m8129boximpl(textStyle.paragraphStyle.m7580getTextAligne0LSkKk()) : textAlign;
        TextDirection m8146boximpl = (i & 32768) != 0 ? TextDirection.m8146boximpl(textStyle.paragraphStyle.m7582getTextDirections_7Xco()) : textDirection;
        long m7578getLineHeightXSAIIZE = (i & 65536) != 0 ? textStyle.paragraphStyle.m7578getLineHeightXSAIIZE() : j5;
        TextIndent textIndent2 = (i & 131072) != 0 ? textStyle.paragraphStyle.getTextIndent() : textIndent;
        PlatformTextStyle platformTextStyle3 = (i & 262144) != 0 ? textStyle.platformStyle : platformTextStyle;
        if ((i & 524288) != 0) {
            platformTextStyle2 = platformTextStyle3;
            lineHeightStyle2 = textStyle.paragraphStyle.getLineHeightStyle();
        } else {
            lineHeightStyle2 = lineHeightStyle;
            platformTextStyle2 = platformTextStyle3;
        }
        return textStyle.m7724copyNOaFTUo(j6, m7642getFontSizeXSAIIZE, fontWeight2, m7643getFontStyle4Lr2A7w, m7644getFontSynthesisZQGJjVo, fontFamily2, fontFeatureSettings, m7645getLetterSpacingXSAIIZE, m7640getBaselineShift5SSeXJ0, textGeometricTransform2, localeList2, m7639getBackground0d7_KjU, textDecoration3, shadow2, m8129boximpl, m8146boximpl, m7578getLineHeightXSAIIZE, textIndent2, platformTextStyle2, lineHeightStyle2);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "TextStyle copy constructors that do not take new stable parameters like LineHeightStyle, LineBreak, Hyphens are deprecated. Please use the new stable copy constructor.")
    /* renamed from: copy-NOaFTUo  reason: not valid java name */
    public final /* synthetic */ TextStyle m7724copyNOaFTUo(long j, long j2, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j3, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j4, TextDecoration textDecoration, Shadow shadow, TextAlign textAlign, TextDirection textDirection, long j5, TextIndent textIndent, PlatformTextStyle platformTextStyle, LineHeightStyle lineHeightStyle) {
        TextForegroundStyle m8163from8_81llA;
        if (Color.m5425equalsimpl0(j, this.spanStyle.m7641getColor0d7_KjU())) {
            m8163from8_81llA = this.spanStyle.getTextForegroundStyle$ui_text();
        } else {
            m8163from8_81llA = TextForegroundStyle.Companion.m8163from8_81llA(j);
        }
        return new TextStyle(new SpanStyle(m8163from8_81llA, j2, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j3, baselineShift, textGeometricTransform, localeList, j4, textDecoration, shadow, platformTextStyle != null ? platformTextStyle.getSpanStyle() : null, this.spanStyle.getDrawStyle(), (DefaultConstructorMarker) null), new ParagraphStyle(textAlign != null ? textAlign.m8135unboximpl() : TextAlign.Companion.m8142getUnspecifiede0LSkKk(), textDirection != null ? textDirection.m8152unboximpl() : TextDirection.Companion.m8158getUnspecifieds_7Xco(), j5, textIndent, platformTextStyle != null ? platformTextStyle.getParagraphStyle() : null, lineHeightStyle, m7739getLineBreakrAG3T2k(), m7736getHyphensvmbZdU8(), getTextMotion(), (DefaultConstructorMarker) null), platformTextStyle);
    }

    /* renamed from: copy-CXVQc50$default  reason: not valid java name */
    public static /* synthetic */ TextStyle m7709copyCXVQc50$default(TextStyle textStyle, long j, long j2, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j3, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j4, TextDecoration textDecoration, Shadow shadow, TextAlign textAlign, TextDirection textDirection, long j5, TextIndent textIndent, PlatformTextStyle platformTextStyle, LineHeightStyle lineHeightStyle, LineBreak lineBreak, Hyphens hyphens, int i, Object obj) {
        Hyphens hyphens2;
        LineBreak lineBreak2;
        long m7641getColor0d7_KjU = (i & 1) != 0 ? textStyle.spanStyle.m7641getColor0d7_KjU() : j;
        long m7642getFontSizeXSAIIZE = (i & 2) != 0 ? textStyle.spanStyle.m7642getFontSizeXSAIIZE() : j2;
        FontWeight fontWeight2 = (i & 4) != 0 ? textStyle.spanStyle.getFontWeight() : fontWeight;
        FontStyle m7643getFontStyle4Lr2A7w = (i & 8) != 0 ? textStyle.spanStyle.m7643getFontStyle4Lr2A7w() : fontStyle;
        FontSynthesis m7644getFontSynthesisZQGJjVo = (i & 16) != 0 ? textStyle.spanStyle.m7644getFontSynthesisZQGJjVo() : fontSynthesis;
        FontFamily fontFamily2 = (i & 32) != 0 ? textStyle.spanStyle.getFontFamily() : fontFamily;
        String fontFeatureSettings = (i & 64) != 0 ? textStyle.spanStyle.getFontFeatureSettings() : str;
        long m7645getLetterSpacingXSAIIZE = (i & 128) != 0 ? textStyle.spanStyle.m7645getLetterSpacingXSAIIZE() : j3;
        BaselineShift m7640getBaselineShift5SSeXJ0 = (i & 256) != 0 ? textStyle.spanStyle.m7640getBaselineShift5SSeXJ0() : baselineShift;
        TextGeometricTransform textGeometricTransform2 = (i & 512) != 0 ? textStyle.spanStyle.getTextGeometricTransform() : textGeometricTransform;
        LocaleList localeList2 = (i & 1024) != 0 ? textStyle.spanStyle.getLocaleList() : localeList;
        long j6 = m7641getColor0d7_KjU;
        long m7639getBackground0d7_KjU = (i & 2048) != 0 ? textStyle.spanStyle.m7639getBackground0d7_KjU() : j4;
        TextDecoration textDecoration2 = (i & 4096) != 0 ? textStyle.spanStyle.getTextDecoration() : textDecoration;
        Shadow shadow2 = (i & 8192) != 0 ? textStyle.spanStyle.getShadow() : shadow;
        TextDecoration textDecoration3 = textDecoration2;
        TextAlign m8129boximpl = (i & 16384) != 0 ? TextAlign.m8129boximpl(textStyle.paragraphStyle.m7580getTextAligne0LSkKk()) : textAlign;
        TextDirection m8146boximpl = (i & 32768) != 0 ? TextDirection.m8146boximpl(textStyle.paragraphStyle.m7582getTextDirections_7Xco()) : textDirection;
        long m7578getLineHeightXSAIIZE = (i & 65536) != 0 ? textStyle.paragraphStyle.m7578getLineHeightXSAIIZE() : j5;
        TextIndent textIndent2 = (i & 131072) != 0 ? textStyle.paragraphStyle.getTextIndent() : textIndent;
        PlatformTextStyle platformTextStyle2 = (i & 262144) != 0 ? textStyle.platformStyle : platformTextStyle;
        LineHeightStyle lineHeightStyle2 = (i & 524288) != 0 ? textStyle.paragraphStyle.getLineHeightStyle() : lineHeightStyle;
        LineBreak m8034boximpl = (i & 1048576) != 0 ? LineBreak.m8034boximpl(textStyle.paragraphStyle.m7577getLineBreakrAG3T2k()) : lineBreak;
        if ((i & 2097152) != 0) {
            lineBreak2 = m8034boximpl;
            hyphens2 = Hyphens.m8021boximpl(textStyle.paragraphStyle.m7575getHyphensvmbZdU8());
        } else {
            hyphens2 = hyphens;
            lineBreak2 = m8034boximpl;
        }
        return textStyle.m7722copyCXVQc50(j6, m7642getFontSizeXSAIIZE, fontWeight2, m7643getFontStyle4Lr2A7w, m7644getFontSynthesisZQGJjVo, fontFamily2, fontFeatureSettings, m7645getLetterSpacingXSAIIZE, m7640getBaselineShift5SSeXJ0, textGeometricTransform2, localeList2, m7639getBackground0d7_KjU, textDecoration3, shadow2, m8129boximpl, m8146boximpl, m7578getLineHeightXSAIIZE, textIndent2, platformTextStyle2, lineHeightStyle2, lineBreak2, hyphens2);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "TextStyle copy constructors that do not take new stable parameters like LineBreak, Hyphens, and TextMotion are deprecated. Please use the new stable copy constructor.")
    /* renamed from: copy-CXVQc50  reason: not valid java name */
    public final /* synthetic */ TextStyle m7722copyCXVQc50(long j, long j2, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j3, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j4, TextDecoration textDecoration, Shadow shadow, TextAlign textAlign, TextDirection textDirection, long j5, TextIndent textIndent, PlatformTextStyle platformTextStyle, LineHeightStyle lineHeightStyle, LineBreak lineBreak, Hyphens hyphens) {
        TextForegroundStyle m8163from8_81llA;
        if (Color.m5425equalsimpl0(j, this.spanStyle.m7641getColor0d7_KjU())) {
            m8163from8_81llA = this.spanStyle.getTextForegroundStyle$ui_text();
        } else {
            m8163from8_81llA = TextForegroundStyle.Companion.m8163from8_81llA(j);
        }
        return new TextStyle(new SpanStyle(m8163from8_81llA, j2, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j3, baselineShift, textGeometricTransform, localeList, j4, textDecoration, shadow, platformTextStyle != null ? platformTextStyle.getSpanStyle() : null, getDrawStyle(), (DefaultConstructorMarker) null), new ParagraphStyle(textAlign != null ? textAlign.m8135unboximpl() : TextAlign.Companion.m8142getUnspecifiede0LSkKk(), textDirection != null ? textDirection.m8152unboximpl() : TextDirection.Companion.m8158getUnspecifieds_7Xco(), j5, textIndent, platformTextStyle != null ? platformTextStyle.getParagraphStyle() : null, lineHeightStyle, lineBreak != null ? lineBreak.m8046unboximpl() : LineBreak.Companion.m8054getUnspecifiedrAG3T2k(), hyphens != null ? hyphens.m8027unboximpl() : Hyphens.Companion.m8030getUnspecifiedvmbZdU8(), getTextMotion(), (DefaultConstructorMarker) null), platformTextStyle);
    }

    /* renamed from: copy-v2rsoow$default  reason: not valid java name */
    public static /* synthetic */ TextStyle m7715copyv2rsoow$default(TextStyle textStyle, long j, long j2, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j3, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j4, TextDecoration textDecoration, Shadow shadow, DrawStyle drawStyle, TextAlign textAlign, TextDirection textDirection, long j5, TextIndent textIndent, PlatformTextStyle platformTextStyle, LineHeightStyle lineHeightStyle, LineBreak lineBreak, Hyphens hyphens, TextMotion textMotion, int i, Object obj) {
        TextMotion textMotion2;
        Hyphens hyphens2;
        long m7641getColor0d7_KjU = (i & 1) != 0 ? textStyle.spanStyle.m7641getColor0d7_KjU() : j;
        long m7642getFontSizeXSAIIZE = (i & 2) != 0 ? textStyle.spanStyle.m7642getFontSizeXSAIIZE() : j2;
        FontWeight fontWeight2 = (i & 4) != 0 ? textStyle.spanStyle.getFontWeight() : fontWeight;
        FontStyle m7643getFontStyle4Lr2A7w = (i & 8) != 0 ? textStyle.spanStyle.m7643getFontStyle4Lr2A7w() : fontStyle;
        FontSynthesis m7644getFontSynthesisZQGJjVo = (i & 16) != 0 ? textStyle.spanStyle.m7644getFontSynthesisZQGJjVo() : fontSynthesis;
        FontFamily fontFamily2 = (i & 32) != 0 ? textStyle.spanStyle.getFontFamily() : fontFamily;
        String fontFeatureSettings = (i & 64) != 0 ? textStyle.spanStyle.getFontFeatureSettings() : str;
        long m7645getLetterSpacingXSAIIZE = (i & 128) != 0 ? textStyle.spanStyle.m7645getLetterSpacingXSAIIZE() : j3;
        BaselineShift m7640getBaselineShift5SSeXJ0 = (i & 256) != 0 ? textStyle.spanStyle.m7640getBaselineShift5SSeXJ0() : baselineShift;
        TextGeometricTransform textGeometricTransform2 = (i & 512) != 0 ? textStyle.spanStyle.getTextGeometricTransform() : textGeometricTransform;
        LocaleList localeList2 = (i & 1024) != 0 ? textStyle.spanStyle.getLocaleList() : localeList;
        long j6 = m7641getColor0d7_KjU;
        long m7639getBackground0d7_KjU = (i & 2048) != 0 ? textStyle.spanStyle.m7639getBackground0d7_KjU() : j4;
        TextDecoration textDecoration2 = (i & 4096) != 0 ? textStyle.spanStyle.getTextDecoration() : textDecoration;
        Shadow shadow2 = (i & 8192) != 0 ? textStyle.spanStyle.getShadow() : shadow;
        TextDecoration textDecoration3 = textDecoration2;
        DrawStyle drawStyle2 = (i & 16384) != 0 ? textStyle.spanStyle.getDrawStyle() : drawStyle;
        TextAlign m8129boximpl = (i & 32768) != 0 ? TextAlign.m8129boximpl(textStyle.paragraphStyle.m7580getTextAligne0LSkKk()) : textAlign;
        TextDirection m8146boximpl = (i & 65536) != 0 ? TextDirection.m8146boximpl(textStyle.paragraphStyle.m7582getTextDirections_7Xco()) : textDirection;
        long m7578getLineHeightXSAIIZE = (i & 131072) != 0 ? textStyle.paragraphStyle.m7578getLineHeightXSAIIZE() : j5;
        TextIndent textIndent2 = (i & 262144) != 0 ? textStyle.paragraphStyle.getTextIndent() : textIndent;
        PlatformTextStyle platformTextStyle2 = (i & 524288) != 0 ? textStyle.platformStyle : platformTextStyle;
        LineHeightStyle lineHeightStyle2 = (i & 1048576) != 0 ? textStyle.paragraphStyle.getLineHeightStyle() : lineHeightStyle;
        LineBreak m8034boximpl = (i & 2097152) != 0 ? LineBreak.m8034boximpl(textStyle.paragraphStyle.m7577getLineBreakrAG3T2k()) : lineBreak;
        Hyphens m8021boximpl = (i & 4194304) != 0 ? Hyphens.m8021boximpl(textStyle.paragraphStyle.m7575getHyphensvmbZdU8()) : hyphens;
        if ((i & 8388608) != 0) {
            hyphens2 = m8021boximpl;
            textMotion2 = textStyle.paragraphStyle.getTextMotion();
        } else {
            textMotion2 = textMotion;
            hyphens2 = m8021boximpl;
        }
        return textStyle.m7728copyv2rsoow(j6, m7642getFontSizeXSAIIZE, fontWeight2, m7643getFontStyle4Lr2A7w, m7644getFontSynthesisZQGJjVo, fontFamily2, fontFeatureSettings, m7645getLetterSpacingXSAIIZE, m7640getBaselineShift5SSeXJ0, textGeometricTransform2, localeList2, m7639getBackground0d7_KjU, textDecoration3, shadow2, drawStyle2, m8129boximpl, m8146boximpl, m7578getLineHeightXSAIIZE, textIndent2, platformTextStyle2, lineHeightStyle2, m8034boximpl, hyphens2, textMotion2);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "copy constructors that take nullable TextAlign, TextDirection, LineBreak, and Hyphens are deprecated. Please use a new constructor where these parameters are non-nullable. Null value has been replaced by a special Unspecified object for performance reason.")
    /* renamed from: copy-v2rsoow  reason: not valid java name */
    public final /* synthetic */ TextStyle m7728copyv2rsoow(long j, long j2, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j3, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j4, TextDecoration textDecoration, Shadow shadow, DrawStyle drawStyle, TextAlign textAlign, TextDirection textDirection, long j5, TextIndent textIndent, PlatformTextStyle platformTextStyle, LineHeightStyle lineHeightStyle, LineBreak lineBreak, Hyphens hyphens, TextMotion textMotion) {
        TextForegroundStyle m8163from8_81llA;
        if (Color.m5425equalsimpl0(j, this.spanStyle.m7641getColor0d7_KjU())) {
            m8163from8_81llA = this.spanStyle.getTextForegroundStyle$ui_text();
        } else {
            m8163from8_81llA = TextForegroundStyle.Companion.m8163from8_81llA(j);
        }
        return new TextStyle(new SpanStyle(m8163from8_81llA, j2, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j3, baselineShift, textGeometricTransform, localeList, j4, textDecoration, shadow, platformTextStyle != null ? platformTextStyle.getSpanStyle() : null, drawStyle, (DefaultConstructorMarker) null), new ParagraphStyle(textAlign != null ? textAlign.m8135unboximpl() : TextAlign.Companion.m8142getUnspecifiede0LSkKk(), textDirection != null ? textDirection.m8152unboximpl() : TextDirection.Companion.m8158getUnspecifieds_7Xco(), j5, textIndent, platformTextStyle != null ? platformTextStyle.getParagraphStyle() : null, lineHeightStyle, lineBreak != null ? lineBreak.m8046unboximpl() : LineBreak.Companion.m8054getUnspecifiedrAG3T2k(), hyphens != null ? hyphens.m8027unboximpl() : Hyphens.Companion.m8030getUnspecifiedvmbZdU8(), textMotion, (DefaultConstructorMarker) null), platformTextStyle);
    }

    /* renamed from: copy-p1EtxEg$default  reason: not valid java name */
    public static /* synthetic */ TextStyle m7714copyp1EtxEg$default(TextStyle textStyle, long j, long j2, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j3, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j4, TextDecoration textDecoration, Shadow shadow, DrawStyle drawStyle, int i, int i2, long j5, TextIndent textIndent, PlatformTextStyle platformTextStyle, LineHeightStyle lineHeightStyle, int i3, int i4, TextMotion textMotion, int i5, Object obj) {
        TextMotion textMotion2;
        int i6;
        long m7641getColor0d7_KjU = (i5 & 1) != 0 ? textStyle.spanStyle.m7641getColor0d7_KjU() : j;
        long m7642getFontSizeXSAIIZE = (i5 & 2) != 0 ? textStyle.spanStyle.m7642getFontSizeXSAIIZE() : j2;
        FontWeight fontWeight2 = (i5 & 4) != 0 ? textStyle.spanStyle.getFontWeight() : fontWeight;
        FontStyle m7643getFontStyle4Lr2A7w = (i5 & 8) != 0 ? textStyle.spanStyle.m7643getFontStyle4Lr2A7w() : fontStyle;
        FontSynthesis m7644getFontSynthesisZQGJjVo = (i5 & 16) != 0 ? textStyle.spanStyle.m7644getFontSynthesisZQGJjVo() : fontSynthesis;
        FontFamily fontFamily2 = (i5 & 32) != 0 ? textStyle.spanStyle.getFontFamily() : fontFamily;
        String fontFeatureSettings = (i5 & 64) != 0 ? textStyle.spanStyle.getFontFeatureSettings() : str;
        long m7645getLetterSpacingXSAIIZE = (i5 & 128) != 0 ? textStyle.spanStyle.m7645getLetterSpacingXSAIIZE() : j3;
        BaselineShift m7640getBaselineShift5SSeXJ0 = (i5 & 256) != 0 ? textStyle.spanStyle.m7640getBaselineShift5SSeXJ0() : baselineShift;
        TextGeometricTransform textGeometricTransform2 = (i5 & 512) != 0 ? textStyle.spanStyle.getTextGeometricTransform() : textGeometricTransform;
        LocaleList localeList2 = (i5 & 1024) != 0 ? textStyle.spanStyle.getLocaleList() : localeList;
        long j6 = m7641getColor0d7_KjU;
        long m7639getBackground0d7_KjU = (i5 & 2048) != 0 ? textStyle.spanStyle.m7639getBackground0d7_KjU() : j4;
        TextDecoration textDecoration2 = (i5 & 4096) != 0 ? textStyle.spanStyle.getTextDecoration() : textDecoration;
        Shadow shadow2 = (i5 & 8192) != 0 ? textStyle.spanStyle.getShadow() : shadow;
        TextDecoration textDecoration3 = textDecoration2;
        DrawStyle drawStyle2 = (i5 & 16384) != 0 ? textStyle.spanStyle.getDrawStyle() : drawStyle;
        int m7580getTextAligne0LSkKk = (i5 & 32768) != 0 ? textStyle.paragraphStyle.m7580getTextAligne0LSkKk() : i;
        int m7582getTextDirections_7Xco = (i5 & 65536) != 0 ? textStyle.paragraphStyle.m7582getTextDirections_7Xco() : i2;
        long m7578getLineHeightXSAIIZE = (i5 & 131072) != 0 ? textStyle.paragraphStyle.m7578getLineHeightXSAIIZE() : j5;
        TextIndent textIndent2 = (i5 & 262144) != 0 ? textStyle.paragraphStyle.getTextIndent() : textIndent;
        PlatformTextStyle platformTextStyle2 = (i5 & 524288) != 0 ? textStyle.platformStyle : platformTextStyle;
        LineHeightStyle lineHeightStyle2 = (i5 & 1048576) != 0 ? textStyle.paragraphStyle.getLineHeightStyle() : lineHeightStyle;
        int m7577getLineBreakrAG3T2k = (i5 & 2097152) != 0 ? textStyle.paragraphStyle.m7577getLineBreakrAG3T2k() : i3;
        int m7575getHyphensvmbZdU8 = (i5 & 4194304) != 0 ? textStyle.paragraphStyle.m7575getHyphensvmbZdU8() : i4;
        if ((i5 & 8388608) != 0) {
            i6 = m7575getHyphensvmbZdU8;
            textMotion2 = textStyle.paragraphStyle.getTextMotion();
        } else {
            textMotion2 = textMotion;
            i6 = m7575getHyphensvmbZdU8;
        }
        return textStyle.m7727copyp1EtxEg(j6, m7642getFontSizeXSAIIZE, fontWeight2, m7643getFontStyle4Lr2A7w, m7644getFontSynthesisZQGJjVo, fontFamily2, fontFeatureSettings, m7645getLetterSpacingXSAIIZE, m7640getBaselineShift5SSeXJ0, textGeometricTransform2, localeList2, m7639getBackground0d7_KjU, textDecoration3, shadow2, drawStyle2, m7580getTextAligne0LSkKk, m7582getTextDirections_7Xco, m7578getLineHeightXSAIIZE, textIndent2, platformTextStyle2, lineHeightStyle2, m7577getLineBreakrAG3T2k, i6, textMotion2);
    }

    /* renamed from: copy-p1EtxEg  reason: not valid java name */
    public final TextStyle m7727copyp1EtxEg(long j, long j2, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j3, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j4, TextDecoration textDecoration, Shadow shadow, DrawStyle drawStyle, int i, int i2, long j5, TextIndent textIndent, PlatformTextStyle platformTextStyle, LineHeightStyle lineHeightStyle, int i3, int i4, TextMotion textMotion) {
        TextForegroundStyle m8163from8_81llA;
        if (Color.m5425equalsimpl0(j, this.spanStyle.m7641getColor0d7_KjU())) {
            m8163from8_81llA = this.spanStyle.getTextForegroundStyle$ui_text();
        } else {
            m8163from8_81llA = TextForegroundStyle.Companion.m8163from8_81llA(j);
        }
        return new TextStyle(new SpanStyle(m8163from8_81llA, j2, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j3, baselineShift, textGeometricTransform, localeList, j4, textDecoration, shadow, platformTextStyle != null ? platformTextStyle.getSpanStyle() : null, drawStyle, (DefaultConstructorMarker) null), new ParagraphStyle(i, i2, j5, textIndent, platformTextStyle != null ? platformTextStyle.getParagraphStyle() : null, lineHeightStyle, i3, i4, textMotion, (DefaultConstructorMarker) null), platformTextStyle);
    }

    /* renamed from: copy-aIRg9q4$default  reason: not valid java name */
    public static /* synthetic */ TextStyle m7713copyaIRg9q4$default(TextStyle textStyle, Brush brush, float f, long j, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j2, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j3, TextDecoration textDecoration, Shadow shadow, DrawStyle drawStyle, TextAlign textAlign, TextDirection textDirection, long j4, TextIndent textIndent, PlatformTextStyle platformTextStyle, LineHeightStyle lineHeightStyle, LineBreak lineBreak, Hyphens hyphens, TextMotion textMotion, int i, Object obj) {
        TextMotion textMotion2;
        Hyphens hyphens2;
        TextDecoration textDecoration2;
        DrawStyle drawStyle2;
        TextAlign textAlign2;
        TextDirection textDirection2;
        TextIndent textIndent2;
        PlatformTextStyle platformTextStyle2;
        LineHeightStyle lineHeightStyle2;
        Shadow shadow2;
        long j5;
        FontWeight fontWeight2;
        FontStyle fontStyle2;
        FontSynthesis fontSynthesis2;
        String str2;
        long j6;
        BaselineShift baselineShift2;
        TextGeometricTransform textGeometricTransform2;
        LocaleList localeList2;
        long j7;
        long j8;
        Brush brush2;
        float f2;
        LineBreak lineBreak2;
        TextStyle textStyle2;
        FontFamily fontFamily2;
        float alpha = (i & 2) != 0 ? textStyle.spanStyle.getAlpha() : f;
        long m7642getFontSizeXSAIIZE = (i & 4) != 0 ? textStyle.spanStyle.m7642getFontSizeXSAIIZE() : j;
        FontWeight fontWeight3 = (i & 8) != 0 ? textStyle.spanStyle.getFontWeight() : fontWeight;
        FontStyle m7643getFontStyle4Lr2A7w = (i & 16) != 0 ? textStyle.spanStyle.m7643getFontStyle4Lr2A7w() : fontStyle;
        FontSynthesis m7644getFontSynthesisZQGJjVo = (i & 32) != 0 ? textStyle.spanStyle.m7644getFontSynthesisZQGJjVo() : fontSynthesis;
        FontFamily fontFamily3 = (i & 64) != 0 ? textStyle.spanStyle.getFontFamily() : fontFamily;
        String fontFeatureSettings = (i & 128) != 0 ? textStyle.spanStyle.getFontFeatureSettings() : str;
        long m7645getLetterSpacingXSAIIZE = (i & 256) != 0 ? textStyle.spanStyle.m7645getLetterSpacingXSAIIZE() : j2;
        BaselineShift m7640getBaselineShift5SSeXJ0 = (i & 512) != 0 ? textStyle.spanStyle.m7640getBaselineShift5SSeXJ0() : baselineShift;
        TextGeometricTransform textGeometricTransform3 = (i & 1024) != 0 ? textStyle.spanStyle.getTextGeometricTransform() : textGeometricTransform;
        LocaleList localeList3 = (i & 2048) != 0 ? textStyle.spanStyle.getLocaleList() : localeList;
        long m7639getBackground0d7_KjU = (i & 4096) != 0 ? textStyle.spanStyle.m7639getBackground0d7_KjU() : j3;
        float f3 = alpha;
        TextDecoration textDecoration3 = (i & 8192) != 0 ? textStyle.spanStyle.getTextDecoration() : textDecoration;
        Shadow shadow3 = (i & 16384) != 0 ? textStyle.spanStyle.getShadow() : shadow;
        DrawStyle drawStyle3 = (i & 32768) != 0 ? textStyle.spanStyle.getDrawStyle() : drawStyle;
        TextAlign m8129boximpl = (i & 65536) != 0 ? TextAlign.m8129boximpl(textStyle.paragraphStyle.m7580getTextAligne0LSkKk()) : textAlign;
        TextDirection m8146boximpl = (i & 131072) != 0 ? TextDirection.m8146boximpl(textStyle.paragraphStyle.m7582getTextDirections_7Xco()) : textDirection;
        long m7578getLineHeightXSAIIZE = (i & 262144) != 0 ? textStyle.paragraphStyle.m7578getLineHeightXSAIIZE() : j4;
        TextIndent textIndent3 = (i & 524288) != 0 ? textStyle.paragraphStyle.getTextIndent() : textIndent;
        PlatformTextStyle platformTextStyle3 = (i & 1048576) != 0 ? textStyle.platformStyle : platformTextStyle;
        LineHeightStyle lineHeightStyle3 = (i & 2097152) != 0 ? textStyle.paragraphStyle.getLineHeightStyle() : lineHeightStyle;
        LineBreak m8034boximpl = (i & 4194304) != 0 ? LineBreak.m8034boximpl(textStyle.paragraphStyle.m7577getLineBreakrAG3T2k()) : lineBreak;
        Hyphens m8021boximpl = (i & 8388608) != 0 ? Hyphens.m8021boximpl(textStyle.paragraphStyle.m7575getHyphensvmbZdU8()) : hyphens;
        if ((i & 16777216) != 0) {
            hyphens2 = m8021boximpl;
            textMotion2 = textStyle.paragraphStyle.getTextMotion();
            textDecoration2 = textDecoration3;
            drawStyle2 = drawStyle3;
            textAlign2 = m8129boximpl;
            textDirection2 = m8146boximpl;
            textIndent2 = textIndent3;
            platformTextStyle2 = platformTextStyle3;
            lineHeightStyle2 = lineHeightStyle3;
            lineBreak2 = m8034boximpl;
            shadow2 = shadow3;
            j5 = m7642getFontSizeXSAIIZE;
            fontWeight2 = fontWeight3;
            fontStyle2 = m7643getFontStyle4Lr2A7w;
            fontSynthesis2 = m7644getFontSynthesisZQGJjVo;
            fontFamily2 = fontFamily3;
            str2 = fontFeatureSettings;
            j6 = m7645getLetterSpacingXSAIIZE;
            baselineShift2 = m7640getBaselineShift5SSeXJ0;
            textGeometricTransform2 = textGeometricTransform3;
            localeList2 = localeList3;
            j7 = m7639getBackground0d7_KjU;
            j8 = m7578getLineHeightXSAIIZE;
            brush2 = brush;
            f2 = f3;
            textStyle2 = textStyle;
        } else {
            textMotion2 = textMotion;
            hyphens2 = m8021boximpl;
            textDecoration2 = textDecoration3;
            drawStyle2 = drawStyle3;
            textAlign2 = m8129boximpl;
            textDirection2 = m8146boximpl;
            textIndent2 = textIndent3;
            platformTextStyle2 = platformTextStyle3;
            lineHeightStyle2 = lineHeightStyle3;
            shadow2 = shadow3;
            j5 = m7642getFontSizeXSAIIZE;
            fontWeight2 = fontWeight3;
            fontStyle2 = m7643getFontStyle4Lr2A7w;
            fontSynthesis2 = m7644getFontSynthesisZQGJjVo;
            str2 = fontFeatureSettings;
            j6 = m7645getLetterSpacingXSAIIZE;
            baselineShift2 = m7640getBaselineShift5SSeXJ0;
            textGeometricTransform2 = textGeometricTransform3;
            localeList2 = localeList3;
            j7 = m7639getBackground0d7_KjU;
            j8 = m7578getLineHeightXSAIIZE;
            brush2 = brush;
            f2 = f3;
            lineBreak2 = m8034boximpl;
            textStyle2 = textStyle;
            fontFamily2 = fontFamily3;
        }
        return textStyle2.m7726copyaIRg9q4(brush2, f2, j5, fontWeight2, fontStyle2, fontSynthesis2, fontFamily2, str2, j6, baselineShift2, textGeometricTransform2, localeList2, j7, textDecoration2, shadow2, drawStyle2, textAlign2, textDirection2, j8, textIndent2, platformTextStyle2, lineHeightStyle2, lineBreak2, hyphens2, textMotion2);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "copy constructors that take nullable TextAlign, TextDirection, LineBreak, and Hyphens are deprecated. Please use a new constructor where these parameters are non-nullable. Null value has been replaced by a special Unspecified object for performance reason.")
    /* renamed from: copy-aIRg9q4  reason: not valid java name */
    public final /* synthetic */ TextStyle m7726copyaIRg9q4(Brush brush, float f, long j, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j2, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j3, TextDecoration textDecoration, Shadow shadow, DrawStyle drawStyle, TextAlign textAlign, TextDirection textDirection, long j4, TextIndent textIndent, PlatformTextStyle platformTextStyle, LineHeightStyle lineHeightStyle, LineBreak lineBreak, Hyphens hyphens, TextMotion textMotion) {
        return new TextStyle(new SpanStyle(brush, f, j, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j2, baselineShift, textGeometricTransform, localeList, j3, textDecoration, shadow, platformTextStyle != null ? platformTextStyle.getSpanStyle() : null, drawStyle, (DefaultConstructorMarker) null), new ParagraphStyle(textAlign != null ? textAlign.m8135unboximpl() : TextAlign.Companion.m8142getUnspecifiede0LSkKk(), textDirection != null ? textDirection.m8152unboximpl() : TextDirection.Companion.m8158getUnspecifieds_7Xco(), j4, textIndent, platformTextStyle != null ? platformTextStyle.getParagraphStyle() : null, lineHeightStyle, lineBreak != null ? lineBreak.m8046unboximpl() : LineBreak.Companion.m8054getUnspecifiedrAG3T2k(), hyphens != null ? hyphens.m8027unboximpl() : Hyphens.Companion.m8030getUnspecifiedvmbZdU8(), textMotion, (DefaultConstructorMarker) null), platformTextStyle);
    }

    /* renamed from: copy-Ns73l9s$default  reason: not valid java name */
    public static /* synthetic */ TextStyle m7712copyNs73l9s$default(TextStyle textStyle, Brush brush, float f, long j, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j2, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j3, TextDecoration textDecoration, Shadow shadow, DrawStyle drawStyle, int i, int i2, long j4, TextIndent textIndent, PlatformTextStyle platformTextStyle, LineHeightStyle lineHeightStyle, int i3, int i4, TextMotion textMotion, int i5, Object obj) {
        TextMotion textMotion2;
        int i6;
        TextDecoration textDecoration2;
        DrawStyle drawStyle2;
        int i7;
        int i8;
        TextIndent textIndent2;
        PlatformTextStyle platformTextStyle2;
        LineHeightStyle lineHeightStyle2;
        Shadow shadow2;
        long j5;
        FontWeight fontWeight2;
        FontStyle fontStyle2;
        FontSynthesis fontSynthesis2;
        String str2;
        long j6;
        BaselineShift baselineShift2;
        TextGeometricTransform textGeometricTransform2;
        LocaleList localeList2;
        long j7;
        long j8;
        Brush brush2;
        float f2;
        int i9;
        TextStyle textStyle2;
        FontFamily fontFamily2;
        float alpha = (i5 & 2) != 0 ? textStyle.spanStyle.getAlpha() : f;
        long m7642getFontSizeXSAIIZE = (i5 & 4) != 0 ? textStyle.spanStyle.m7642getFontSizeXSAIIZE() : j;
        FontWeight fontWeight3 = (i5 & 8) != 0 ? textStyle.spanStyle.getFontWeight() : fontWeight;
        FontStyle m7643getFontStyle4Lr2A7w = (i5 & 16) != 0 ? textStyle.spanStyle.m7643getFontStyle4Lr2A7w() : fontStyle;
        FontSynthesis m7644getFontSynthesisZQGJjVo = (i5 & 32) != 0 ? textStyle.spanStyle.m7644getFontSynthesisZQGJjVo() : fontSynthesis;
        FontFamily fontFamily3 = (i5 & 64) != 0 ? textStyle.spanStyle.getFontFamily() : fontFamily;
        String fontFeatureSettings = (i5 & 128) != 0 ? textStyle.spanStyle.getFontFeatureSettings() : str;
        long m7645getLetterSpacingXSAIIZE = (i5 & 256) != 0 ? textStyle.spanStyle.m7645getLetterSpacingXSAIIZE() : j2;
        BaselineShift m7640getBaselineShift5SSeXJ0 = (i5 & 512) != 0 ? textStyle.spanStyle.m7640getBaselineShift5SSeXJ0() : baselineShift;
        TextGeometricTransform textGeometricTransform3 = (i5 & 1024) != 0 ? textStyle.spanStyle.getTextGeometricTransform() : textGeometricTransform;
        LocaleList localeList3 = (i5 & 2048) != 0 ? textStyle.spanStyle.getLocaleList() : localeList;
        long m7639getBackground0d7_KjU = (i5 & 4096) != 0 ? textStyle.spanStyle.m7639getBackground0d7_KjU() : j3;
        float f3 = alpha;
        TextDecoration textDecoration3 = (i5 & 8192) != 0 ? textStyle.spanStyle.getTextDecoration() : textDecoration;
        Shadow shadow3 = (i5 & 16384) != 0 ? textStyle.spanStyle.getShadow() : shadow;
        DrawStyle drawStyle3 = (i5 & 32768) != 0 ? textStyle.spanStyle.getDrawStyle() : drawStyle;
        int m7580getTextAligne0LSkKk = (i5 & 65536) != 0 ? textStyle.paragraphStyle.m7580getTextAligne0LSkKk() : i;
        int m7582getTextDirections_7Xco = (i5 & 131072) != 0 ? textStyle.paragraphStyle.m7582getTextDirections_7Xco() : i2;
        long m7578getLineHeightXSAIIZE = (i5 & 262144) != 0 ? textStyle.paragraphStyle.m7578getLineHeightXSAIIZE() : j4;
        TextIndent textIndent3 = (i5 & 524288) != 0 ? textStyle.paragraphStyle.getTextIndent() : textIndent;
        PlatformTextStyle platformTextStyle3 = (i5 & 1048576) != 0 ? textStyle.platformStyle : platformTextStyle;
        LineHeightStyle lineHeightStyle3 = (i5 & 2097152) != 0 ? textStyle.paragraphStyle.getLineHeightStyle() : lineHeightStyle;
        int m7577getLineBreakrAG3T2k = (i5 & 4194304) != 0 ? textStyle.paragraphStyle.m7577getLineBreakrAG3T2k() : i3;
        int m7575getHyphensvmbZdU8 = (i5 & 8388608) != 0 ? textStyle.paragraphStyle.m7575getHyphensvmbZdU8() : i4;
        if ((i5 & 16777216) != 0) {
            i6 = m7575getHyphensvmbZdU8;
            textMotion2 = textStyle.paragraphStyle.getTextMotion();
            textDecoration2 = textDecoration3;
            drawStyle2 = drawStyle3;
            i7 = m7580getTextAligne0LSkKk;
            i8 = m7582getTextDirections_7Xco;
            textIndent2 = textIndent3;
            platformTextStyle2 = platformTextStyle3;
            lineHeightStyle2 = lineHeightStyle3;
            i9 = m7577getLineBreakrAG3T2k;
            shadow2 = shadow3;
            j5 = m7642getFontSizeXSAIIZE;
            fontWeight2 = fontWeight3;
            fontStyle2 = m7643getFontStyle4Lr2A7w;
            fontSynthesis2 = m7644getFontSynthesisZQGJjVo;
            fontFamily2 = fontFamily3;
            str2 = fontFeatureSettings;
            j6 = m7645getLetterSpacingXSAIIZE;
            baselineShift2 = m7640getBaselineShift5SSeXJ0;
            textGeometricTransform2 = textGeometricTransform3;
            localeList2 = localeList3;
            j7 = m7639getBackground0d7_KjU;
            j8 = m7578getLineHeightXSAIIZE;
            brush2 = brush;
            f2 = f3;
            textStyle2 = textStyle;
        } else {
            textMotion2 = textMotion;
            i6 = m7575getHyphensvmbZdU8;
            textDecoration2 = textDecoration3;
            drawStyle2 = drawStyle3;
            i7 = m7580getTextAligne0LSkKk;
            i8 = m7582getTextDirections_7Xco;
            textIndent2 = textIndent3;
            platformTextStyle2 = platformTextStyle3;
            lineHeightStyle2 = lineHeightStyle3;
            shadow2 = shadow3;
            j5 = m7642getFontSizeXSAIIZE;
            fontWeight2 = fontWeight3;
            fontStyle2 = m7643getFontStyle4Lr2A7w;
            fontSynthesis2 = m7644getFontSynthesisZQGJjVo;
            str2 = fontFeatureSettings;
            j6 = m7645getLetterSpacingXSAIIZE;
            baselineShift2 = m7640getBaselineShift5SSeXJ0;
            textGeometricTransform2 = textGeometricTransform3;
            localeList2 = localeList3;
            j7 = m7639getBackground0d7_KjU;
            j8 = m7578getLineHeightXSAIIZE;
            brush2 = brush;
            f2 = f3;
            i9 = m7577getLineBreakrAG3T2k;
            textStyle2 = textStyle;
            fontFamily2 = fontFamily3;
        }
        return textStyle2.m7725copyNs73l9s(brush2, f2, j5, fontWeight2, fontStyle2, fontSynthesis2, fontFamily2, str2, j6, baselineShift2, textGeometricTransform2, localeList2, j7, textDecoration2, shadow2, drawStyle2, i7, i8, j8, textIndent2, platformTextStyle2, lineHeightStyle2, i9, i6, textMotion2);
    }

    /* renamed from: copy-Ns73l9s  reason: not valid java name */
    public final TextStyle m7725copyNs73l9s(Brush brush, float f, long j, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j2, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j3, TextDecoration textDecoration, Shadow shadow, DrawStyle drawStyle, int i, int i2, long j4, TextIndent textIndent, PlatformTextStyle platformTextStyle, LineHeightStyle lineHeightStyle, int i3, int i4, TextMotion textMotion) {
        return new TextStyle(new SpanStyle(brush, f, j, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j2, baselineShift, textGeometricTransform, localeList, j3, textDecoration, shadow, platformTextStyle != null ? platformTextStyle.getSpanStyle() : null, drawStyle, (DefaultConstructorMarker) null), new ParagraphStyle(i, i2, j4, textIndent, platformTextStyle != null ? platformTextStyle.getParagraphStyle() : null, lineHeightStyle, i3, i4, textMotion, (DefaultConstructorMarker) null), platformTextStyle);
    }

    public final Brush getBrush() {
        return this.spanStyle.getBrush();
    }

    /* renamed from: getColor-0d7_KjU  reason: not valid java name */
    public final long m7731getColor0d7_KjU() {
        return this.spanStyle.m7641getColor0d7_KjU();
    }

    public final float getAlpha() {
        return this.spanStyle.getAlpha();
    }

    /* renamed from: getFontSize-XSAIIZE  reason: not valid java name */
    public final long m7732getFontSizeXSAIIZE() {
        return this.spanStyle.m7642getFontSizeXSAIIZE();
    }

    public final FontWeight getFontWeight() {
        return this.spanStyle.getFontWeight();
    }

    /* renamed from: getFontStyle-4Lr2A7w  reason: not valid java name */
    public final FontStyle m7733getFontStyle4Lr2A7w() {
        return this.spanStyle.m7643getFontStyle4Lr2A7w();
    }

    /* renamed from: getFontSynthesis-ZQGJjVo  reason: not valid java name */
    public final FontSynthesis m7734getFontSynthesisZQGJjVo() {
        return this.spanStyle.m7644getFontSynthesisZQGJjVo();
    }

    public final FontFamily getFontFamily() {
        return this.spanStyle.getFontFamily();
    }

    public final String getFontFeatureSettings() {
        return this.spanStyle.getFontFeatureSettings();
    }

    /* renamed from: getLetterSpacing-XSAIIZE  reason: not valid java name */
    public final long m7737getLetterSpacingXSAIIZE() {
        return this.spanStyle.m7645getLetterSpacingXSAIIZE();
    }

    /* renamed from: getBaselineShift-5SSeXJ0  reason: not valid java name */
    public final BaselineShift m7730getBaselineShift5SSeXJ0() {
        return this.spanStyle.m7640getBaselineShift5SSeXJ0();
    }

    public final TextGeometricTransform getTextGeometricTransform() {
        return this.spanStyle.getTextGeometricTransform();
    }

    public final LocaleList getLocaleList() {
        return this.spanStyle.getLocaleList();
    }

    /* renamed from: getBackground-0d7_KjU  reason: not valid java name */
    public final long m7729getBackground0d7_KjU() {
        return this.spanStyle.m7639getBackground0d7_KjU();
    }

    public final TextDecoration getTextDecoration() {
        return this.spanStyle.getTextDecoration();
    }

    public final Shadow getShadow() {
        return this.spanStyle.getShadow();
    }

    public final DrawStyle getDrawStyle() {
        return this.spanStyle.getDrawStyle();
    }

    /* renamed from: getTextAlign-e0LSkKk  reason: not valid java name */
    public final int m7742getTextAligne0LSkKk() {
        return this.paragraphStyle.m7580getTextAligne0LSkKk();
    }

    /* renamed from: getTextAlign-buA522U  reason: not valid java name */
    public final TextAlign m7741getTextAlignbuA522U() {
        return TextAlign.m8129boximpl(m7742getTextAligne0LSkKk());
    }

    /* renamed from: getTextDirection-s_7X-co  reason: not valid java name */
    public final int m7744getTextDirections_7Xco() {
        return this.paragraphStyle.m7582getTextDirections_7Xco();
    }

    /* renamed from: getTextDirection-mmuk1to  reason: not valid java name */
    public final TextDirection m7743getTextDirectionmmuk1to() {
        return TextDirection.m8146boximpl(m7744getTextDirections_7Xco());
    }

    /* renamed from: getLineHeight-XSAIIZE  reason: not valid java name */
    public final long m7740getLineHeightXSAIIZE() {
        return this.paragraphStyle.m7578getLineHeightXSAIIZE();
    }

    public final TextIndent getTextIndent() {
        return this.paragraphStyle.getTextIndent();
    }

    public final LineHeightStyle getLineHeightStyle() {
        return this.paragraphStyle.getLineHeightStyle();
    }

    /* renamed from: getHyphens-vmbZdU8  reason: not valid java name */
    public final int m7736getHyphensvmbZdU8() {
        return this.paragraphStyle.m7575getHyphensvmbZdU8();
    }

    /* renamed from: getHyphens-EaSxIns  reason: not valid java name */
    public final Hyphens m7735getHyphensEaSxIns() {
        return Hyphens.m8021boximpl(m7736getHyphensvmbZdU8());
    }

    /* renamed from: getLineBreak-rAG3T2k  reason: not valid java name */
    public final int m7739getLineBreakrAG3T2k() {
        return this.paragraphStyle.m7577getLineBreakrAG3T2k();
    }

    /* renamed from: getLineBreak-LgCVezo  reason: not valid java name */
    public final LineBreak m7738getLineBreakLgCVezo() {
        return LineBreak.m8034boximpl(m7739getLineBreakrAG3T2k());
    }

    public final TextMotion getTextMotion() {
        return this.paragraphStyle.getTextMotion();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof TextStyle) {
            TextStyle textStyle = (TextStyle) obj;
            return Intrinsics.areEqual(this.spanStyle, textStyle.spanStyle) && Intrinsics.areEqual(this.paragraphStyle, textStyle.paragraphStyle) && Intrinsics.areEqual(this.platformStyle, textStyle.platformStyle);
        }
        return false;
    }

    public final boolean hasSameLayoutAffectingAttributes(TextStyle textStyle) {
        if (this != textStyle) {
            return Intrinsics.areEqual(this.paragraphStyle, textStyle.paragraphStyle) && this.spanStyle.hasSameLayoutAffectingAttributes$ui_text(textStyle.spanStyle);
        }
        return true;
    }

    public final boolean hasSameDrawAffectingAttributes(TextStyle textStyle) {
        return this == textStyle || this.spanStyle.hasSameNonLayoutAttributes$ui_text(textStyle.spanStyle);
    }

    public int hashCode() {
        int hashCode = ((this.spanStyle.hashCode() * 31) + this.paragraphStyle.hashCode()) * 31;
        PlatformTextStyle platformTextStyle = this.platformStyle;
        return hashCode + (platformTextStyle != null ? platformTextStyle.hashCode() : 0);
    }

    public final int hashCodeLayoutAffectingAttributes$ui_text() {
        int hashCodeLayoutAffectingAttributes$ui_text = ((this.spanStyle.hashCodeLayoutAffectingAttributes$ui_text() * 31) + this.paragraphStyle.hashCode()) * 31;
        PlatformTextStyle platformTextStyle = this.platformStyle;
        return hashCodeLayoutAffectingAttributes$ui_text + (platformTextStyle != null ? platformTextStyle.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("TextStyle(color=");
        sb.append((Object) Color.m5432toStringimpl(m7731getColor0d7_KjU())).append(", brush=").append(getBrush()).append(", alpha=").append(getAlpha()).append(", fontSize=").append((Object) TextUnit.m8459toStringimpl(m7732getFontSizeXSAIIZE())).append(", fontWeight=").append(getFontWeight()).append(", fontStyle=").append(m7733getFontStyle4Lr2A7w()).append(", fontSynthesis=").append(m7734getFontSynthesisZQGJjVo()).append(", fontFamily=").append(getFontFamily()).append(", fontFeatureSettings=").append(getFontFeatureSettings()).append(", letterSpacing=").append((Object) TextUnit.m8459toStringimpl(m7737getLetterSpacingXSAIIZE())).append(", baselineShift=").append(m7730getBaselineShift5SSeXJ0()).append(", textGeometricTransform=");
        sb.append(getTextGeometricTransform()).append(", localeList=").append(getLocaleList()).append(", background=").append((Object) Color.m5432toStringimpl(m7729getBackground0d7_KjU())).append(", textDecoration=").append(getTextDecoration()).append(", shadow=").append(getShadow()).append(", drawStyle=").append(getDrawStyle()).append(", textAlign=").append((Object) TextAlign.m8134toStringimpl(m7742getTextAligne0LSkKk())).append(", textDirection=").append((Object) TextDirection.m8151toStringimpl(m7744getTextDirections_7Xco())).append(", lineHeight=").append((Object) TextUnit.m8459toStringimpl(m7740getLineHeightXSAIIZE())).append(", textIndent=").append(getTextIndent()).append(", platformStyle=").append(this.platformStyle).append(", lineHeightStyle=").append(getLineHeightStyle());
        sb.append(", lineBreak=").append((Object) LineBreak.m8045toStringimpl(m7739getLineBreakrAG3T2k())).append(", hyphens=").append((Object) Hyphens.m8026toStringimpl(m7736getHyphensvmbZdU8())).append(", textMotion=").append(getTextMotion()).append(')');
        return sb.toString();
    }

    /* compiled from: TextStyle.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Landroidx/compose/ui/text/TextStyle$Companion;", "", "<init>", "()V", "Default", "Landroidx/compose/ui/text/TextStyle;", "getDefault$annotations", "getDefault", "()Landroidx/compose/ui/text/TextStyle;", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void getDefault$annotations() {
        }

        private Companion() {
        }

        public final TextStyle getDefault() {
            return TextStyle.Default;
        }
    }
}
