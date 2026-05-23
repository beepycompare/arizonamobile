package androidx.compose.ui.text.android;

import android.graphics.Bitmap;
import android.graphics.BlendMode;
import android.graphics.Canvas;
import android.graphics.DrawFilter;
import android.graphics.Matrix;
import android.graphics.NinePatch;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Picture;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.RenderNode;
import android.graphics.fonts.Font;
import android.graphics.text.MeasuredText;
import androidx.compose.ui.text.internal.InlineClassHelperKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.exoplayer.upstream.CmcdData;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.arizona.launcher.UpdateActivity;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Deprecated;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
/* compiled from: TextAndroidCanvas.android.kt */
@Metadata(d1 = {"\u0000ä\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0015\n\u0002\b\u000b\n\u0002\u0010\u0014\n\u0002\b\b\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0019\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0017\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00012\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\r0\u0010H\u0086\bJ\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0012\u0010\u0015\u001a\u00020\r2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u0018\u001a\u00020\rH\u0017J\b\u0010\u0019\u001a\u00020\rH\u0017J\b\u0010\u001a\u001a\u00020\u0012H\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u001cH\u0016J\b\u0010\u001e\u001a\u00020\u001cH\u0016J\u0010\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u001cH\u0016J\b\u0010!\u001a\u00020\u001cH\u0016J\b\u0010\"\u001a\u00020\u001cH\u0016J\b\u0010#\u001a\u00020\u001cH\u0016J$\u0010$\u001a\u00020\u001c2\b\u0010\u0013\u001a\u0004\u0018\u00010%2\b\u0010&\u001a\u0004\u0018\u00010'2\u0006\u0010(\u001a\u00020\u001cH\u0017J\u001c\u0010$\u001a\u00020\u001c2\b\u0010\u0013\u001a\u0004\u0018\u00010%2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J:\u0010$\u001a\u00020\u001c2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020*2\u0006\u0010-\u001a\u00020*2\b\u0010&\u001a\u0004\u0018\u00010'2\u0006\u0010(\u001a\u00020\u001cH\u0017J2\u0010$\u001a\u00020\u001c2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020*2\u0006\u0010-\u001a\u00020*2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\"\u0010.\u001a\u00020\u001c2\b\u0010\u0013\u001a\u0004\u0018\u00010%2\u0006\u0010/\u001a\u00020\u001c2\u0006\u0010(\u001a\u00020\u001cH\u0017J\u001a\u0010.\u001a\u00020\u001c2\b\u0010\u0013\u001a\u0004\u0018\u00010%2\u0006\u0010/\u001a\u00020\u001cH\u0016J8\u0010.\u001a\u00020\u001c2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020*2\u0006\u0010-\u001a\u00020*2\u0006\u0010/\u001a\u00020\u001c2\u0006\u0010(\u001a\u00020\u001cH\u0017J0\u0010.\u001a\u00020\u001c2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020*2\u0006\u0010-\u001a\u00020*2\u0006\u0010/\u001a\u00020\u001cH\u0016J\b\u00100\u001a\u00020\rH\u0016J\b\u00101\u001a\u00020\u001cH\u0016J\u0010\u00102\u001a\u00020\r2\u0006\u00103\u001a\u00020\u001cH\u0016J\u0018\u00104\u001a\u00020\r2\u0006\u00105\u001a\u00020*2\u0006\u00106\u001a\u00020*H\u0016J\u0018\u00107\u001a\u00020\r2\u0006\u00108\u001a\u00020*2\u0006\u00109\u001a\u00020*H\u0016J\u0010\u0010:\u001a\u00020\r2\u0006\u0010;\u001a\u00020*H\u0016J\u0018\u0010<\u001a\u00020\r2\u0006\u00108\u001a\u00020*2\u0006\u00109\u001a\u00020*H\u0016J\u0012\u0010=\u001a\u00020\r2\b\u0010>\u001a\u0004\u0018\u00010?H\u0016J\u0012\u0010@\u001a\u00020\r2\b\u0010>\u001a\u0004\u0018\u00010?H\u0016J\u0010\u0010A\u001a\u00020\r2\u0006\u0010B\u001a\u00020?H\u0017J\u0018\u0010C\u001a\u00020\u00122\u0006\u0010D\u001a\u00020%2\u0006\u0010E\u001a\u00020FH\u0017J\u0018\u0010C\u001a\u00020\u00122\u0006\u0010D\u001a\u00020\u00142\u0006\u0010E\u001a\u00020FH\u0017J\u0010\u0010C\u001a\u00020\u00122\u0006\u0010D\u001a\u00020%H\u0016J\u0010\u0010C\u001a\u00020\u00122\u0006\u0010D\u001a\u00020\u0014H\u0016J0\u0010C\u001a\u00020\u00122\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020*2\u0006\u0010-\u001a\u00020*2\u0006\u0010E\u001a\u00020FH\u0017J(\u0010C\u001a\u00020\u00122\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020*2\u0006\u0010-\u001a\u00020*H\u0016J(\u0010C\u001a\u00020\u00122\u0006\u0010)\u001a\u00020\u001c2\u0006\u0010+\u001a\u00020\u001c2\u0006\u0010,\u001a\u00020\u001c2\u0006\u0010-\u001a\u00020\u001cH\u0016J\u0010\u0010G\u001a\u00020\u00122\u0006\u0010D\u001a\u00020%H\u0017J\u0010\u0010G\u001a\u00020\u00122\u0006\u0010D\u001a\u00020\u0014H\u0017J(\u0010G\u001a\u00020\u00122\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020*2\u0006\u0010-\u001a\u00020*H\u0017J(\u0010G\u001a\u00020\u00122\u0006\u0010)\u001a\u00020\u001c2\u0006\u0010+\u001a\u00020\u001c2\u0006\u0010,\u001a\u00020\u001c2\u0006\u0010-\u001a\u00020\u001cH\u0017J\u0018\u0010H\u001a\u00020\u00122\u0006\u0010I\u001a\u00020J2\u0006\u0010E\u001a\u00020FH\u0017J\u0010\u0010H\u001a\u00020\u00122\u0006\u0010I\u001a\u00020JH\u0016J\u0010\u0010K\u001a\u00020\u00122\u0006\u0010I\u001a\u00020JH\u0017J\n\u0010L\u001a\u0004\u0018\u00010MH\u0016J\u0012\u0010N\u001a\u00020\r2\b\u0010O\u001a\u0004\u0018\u00010MH\u0016J\u0018\u0010P\u001a\u00020\u00122\u0006\u0010D\u001a\u00020%2\u0006\u0010Q\u001a\u00020RH\u0017J\u0010\u0010P\u001a\u00020\u00122\u0006\u0010D\u001a\u00020%H\u0017J\u0018\u0010P\u001a\u00020\u00122\u0006\u0010I\u001a\u00020J2\u0006\u0010Q\u001a\u00020RH\u0017J\u0010\u0010P\u001a\u00020\u00122\u0006\u0010I\u001a\u00020JH\u0017J0\u0010P\u001a\u00020\u00122\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020*2\u0006\u0010-\u001a\u00020*2\u0006\u0010Q\u001a\u00020RH\u0017J(\u0010P\u001a\u00020\u00122\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020*2\u0006\u0010-\u001a\u00020*H\u0017J\u0010\u0010S\u001a\u00020\r2\u0006\u0010T\u001a\u00020UH\u0016J\u0018\u0010S\u001a\u00020\r2\u0006\u0010T\u001a\u00020U2\u0006\u0010V\u001a\u00020%H\u0016J\u0018\u0010S\u001a\u00020\r2\u0006\u0010T\u001a\u00020U2\u0006\u0010V\u001a\u00020\u0014H\u0016J0\u0010W\u001a\u00020\r2\u0006\u0010X\u001a\u00020%2\u0006\u0010Y\u001a\u00020*2\u0006\u0010Z\u001a\u00020*2\u0006\u0010[\u001a\u00020\u00122\u0006\u0010&\u001a\u00020'H\u0016JH\u0010W\u001a\u00020\r2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020*2\u0006\u0010-\u001a\u00020*2\u0006\u0010Y\u001a\u00020*2\u0006\u0010Z\u001a\u00020*2\u0006\u0010[\u001a\u00020\u00122\u0006\u0010&\u001a\u00020'H\u0016J(\u0010\\\u001a\u00020\r2\u0006\u0010]\u001a\u00020\u001c2\u0006\u0010^\u001a\u00020\u001c2\u0006\u0010_\u001a\u00020\u001c2\u0006\u0010`\u001a\u00020\u001cH\u0016J*\u0010a\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020*2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J,\u0010a\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010b\u001a\u0004\u0018\u00010\u00142\u0006\u0010V\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J,\u0010a\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010b\u001a\u0004\u0018\u00010\u00142\u0006\u0010V\u001a\u00020\u00142\b\u0010&\u001a\u0004\u0018\u00010'H\u0016JR\u0010a\u001a\u00020\r2\u0006\u0010c\u001a\u00020d2\u0006\u0010e\u001a\u00020\u001c2\u0006\u0010f\u001a\u00020\u001c2\u0006\u0010g\u001a\u00020*2\u0006\u0010h\u001a\u00020*2\u0006\u0010i\u001a\u00020\u001c2\u0006\u0010j\u001a\u00020\u001c2\u0006\u0010k\u001a\u00020\u00122\b\u0010&\u001a\u0004\u0018\u00010'H\u0017JR\u0010a\u001a\u00020\r2\u0006\u0010c\u001a\u00020d2\u0006\u0010e\u001a\u00020\u001c2\u0006\u0010f\u001a\u00020\u001c2\u0006\u0010g\u001a\u00020\u001c2\u0006\u0010h\u001a\u00020\u001c2\u0006\u0010i\u001a\u00020\u001c2\u0006\u0010j\u001a\u00020\u001c2\u0006\u0010k\u001a\u00020\u00122\b\u0010&\u001a\u0004\u0018\u00010'H\u0017J\"\u0010a\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010>\u001a\u00020?2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016JL\u0010l\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010m\u001a\u00020\u001c2\u0006\u0010n\u001a\u00020\u001c2\u0006\u0010o\u001a\u00020p2\u0006\u0010q\u001a\u00020\u001c2\b\u0010c\u001a\u0004\u0018\u00010d2\u0006\u0010r\u001a\u00020\u001c2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J(\u0010s\u001a\u00020\r2\u0006\u0010t\u001a\u00020*2\u0006\u0010u\u001a\u00020*2\u0006\u0010v\u001a\u00020*2\u0006\u0010&\u001a\u00020'H\u0016J\u0010\u0010w\u001a\u00020\r2\u0006\u0010x\u001a\u00020\u001cH\u0016J\u0010\u0010w\u001a\u00020\r2\u0006\u0010x\u001a\u00020yH\u0017J\u0018\u0010w\u001a\u00020\r2\u0006\u0010x\u001a\u00020\u001c2\u0006\u0010z\u001a\u00020{H\u0016J\u0018\u0010w\u001a\u00020\r2\u0006\u0010x\u001a\u00020\u001c2\u0006\u0010z\u001a\u00020|H\u0017J\u0018\u0010w\u001a\u00020\r2\u0006\u0010x\u001a\u00020y2\u0006\u0010z\u001a\u00020|H\u0017J2\u0010}\u001a\u00020\r2\u0006\u0010~\u001a\u00020*2\u0006\u0010\u007f\u001a\u00020*2\u0007\u0010\u0080\u0001\u001a\u00020*2\u0007\u0010\u0081\u0001\u001a\u00020*2\u0006\u0010&\u001a\u00020'H\u0016J+\u0010\u0082\u0001\u001a\u00020\r2\u0007\u0010\u0083\u0001\u001a\u00020p2\u0006\u0010e\u001a\u00020\u001c2\u0007\u0010\u0084\u0001\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020'H\u0016J\u001a\u0010\u0082\u0001\u001a\u00020\r2\u0007\u0010\u0083\u0001\u001a\u00020p2\u0006\u0010&\u001a\u00020'H\u0016J\u0019\u0010\u0085\u0001\u001a\u00020\r2\u0006\u0010X\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0016J1\u0010\u0085\u0001\u001a\u00020\r2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020*2\u0006\u0010-\u001a\u00020*2\u0006\u0010&\u001a\u00020'H\u0016J\u0011\u0010\u0086\u0001\u001a\u00020\r2\u0006\u0010&\u001a\u00020'H\u0016J%\u0010\u0087\u0001\u001a\u00020\r2\b\u0010\u0088\u0001\u001a\u00030\u0089\u00012\u0006\u0010V\u001a\u00020\u00142\b\u0010&\u001a\u0004\u0018\u00010'H\u0017J%\u0010\u0087\u0001\u001a\u00020\r2\b\u0010\u0088\u0001\u001a\u00030\u0089\u00012\u0006\u0010V\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'H\u0017J\u0019\u0010\u008a\u0001\u001a\u00020\r2\u0006\u0010I\u001a\u00020J2\u0006\u0010&\u001a\u00020'H\u0016J!\u0010\u008b\u0001\u001a\u00020\r2\u0006\u0010g\u001a\u00020*2\u0006\u0010h\u001a\u00020*2\u0006\u0010&\u001a\u00020'H\u0016J-\u0010\u008c\u0001\u001a\u00020\r2\t\u0010\u0083\u0001\u001a\u0004\u0018\u00010p2\u0006\u0010e\u001a\u00020\u001c2\u0007\u0010\u0084\u0001\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020'H\u0016J\u001a\u0010\u008c\u0001\u001a\u00020\r2\u0007\u0010\u0083\u0001\u001a\u00020p2\u0006\u0010&\u001a\u00020'H\u0016J6\u0010\u008d\u0001\u001a\u00020\r2\b\u0010\u008e\u0001\u001a\u00030\u008f\u00012\u0007\u0010\u0090\u0001\u001a\u00020\u001c2\u0007\u0010\u0084\u0001\u001a\u00020\u001c2\u0007\u0010\u0091\u0001\u001a\u00020p2\u0006\u0010&\u001a\u00020'H\u0017J$\u0010\u008d\u0001\u001a\u00020\r2\b\u0010\u008e\u0001\u001a\u00030\u0092\u00012\u0007\u0010\u0091\u0001\u001a\u00020p2\u0006\u0010&\u001a\u00020'H\u0017J\u0019\u0010\u0093\u0001\u001a\u00020\r2\u0006\u0010D\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0016J\u0019\u0010\u0093\u0001\u001a\u00020\r2\u0006\u0010^\u001a\u00020\u00142\u0006\u0010&\u001a\u00020'H\u0016J1\u0010\u0093\u0001\u001a\u00020\r2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020*2\u0006\u0010-\u001a\u00020*2\u0006\u0010&\u001a\u00020'H\u0016J!\u0010\u0094\u0001\u001a\u00020\r2\u0006\u0010^\u001a\u00020\u001c2\u0006\u0010_\u001a\u00020\u001c2\u0006\u0010`\u001a\u00020\u001cH\u0016J+\u0010\u0095\u0001\u001a\u00020\r2\u0006\u0010D\u001a\u00020%2\u0007\u0010\u0096\u0001\u001a\u00020*2\u0007\u0010\u0097\u0001\u001a\u00020*2\u0006\u0010&\u001a\u00020'H\u0016JC\u0010\u0095\u0001\u001a\u00020\r2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020*2\u0006\u0010-\u001a\u00020*2\u0007\u0010\u0096\u0001\u001a\u00020*2\u0007\u0010\u0097\u0001\u001a\u00020*2\u0006\u0010&\u001a\u00020'H\u0016JG\u0010\u0098\u0001\u001a\u00020\r2\u0007\u0010\u0099\u0001\u001a\u00020%2\u0007\u0010\u009a\u0001\u001a\u00020*2\u0007\u0010\u009b\u0001\u001a\u00020*2\u0007\u0010\u009c\u0001\u001a\u00020%2\u0007\u0010\u009d\u0001\u001a\u00020*2\u0007\u0010\u009e\u0001\u001a\u00020*2\u0006\u0010&\u001a\u00020'H\u0017J5\u0010\u0098\u0001\u001a\u00020\r2\u0007\u0010\u0099\u0001\u001a\u00020%2\u0007\u0010\u009f\u0001\u001a\u00020p2\u0007\u0010\u009c\u0001\u001a\u00020%2\u0007\u0010 \u0001\u001a\u00020p2\u0006\u0010&\u001a\u00020'H\u0017JH\u0010¡\u0001\u001a\u00020\r2\u0007\u0010¢\u0001\u001a\u00020d2\u0007\u0010£\u0001\u001a\u00020\u001c2\u0007\u0010¤\u0001\u001a\u00020p2\u0007\u0010¥\u0001\u001a\u00020\u001c2\u0007\u0010¦\u0001\u001a\u00020\u001c2\b\u0010§\u0001\u001a\u00030¨\u00012\u0006\u0010&\u001a\u00020'H\u0017J=\u0010©\u0001\u001a\u00020\r2\b\u0010\u008e\u0001\u001a\u00030\u008f\u00012\u0007\u0010\u0090\u0001\u001a\u00020\u001c2\u0007\u0010\u0084\u0001\u001a\u00020\u001c2\u0006\u0010g\u001a\u00020*2\u0006\u0010h\u001a\u00020*2\u0006\u0010&\u001a\u00020'H\u0016J+\u0010©\u0001\u001a\u00020\r2\b\u0010\u008e\u0001\u001a\u00030\u0092\u00012\u0006\u0010g\u001a\u00020*2\u0006\u0010h\u001a\u00020*2\u0006\u0010&\u001a\u00020'H\u0016J=\u0010©\u0001\u001a\u00020\r2\b\u0010\u008e\u0001\u001a\u00030\u0092\u00012\u0007\u0010ª\u0001\u001a\u00020\u001c2\u0007\u0010«\u0001\u001a\u00020\u001c2\u0006\u0010g\u001a\u00020*2\u0006\u0010h\u001a\u00020*2\u0006\u0010&\u001a\u00020'H\u0016J=\u0010©\u0001\u001a\u00020\r2\b\u0010\u008e\u0001\u001a\u00030¬\u00012\u0007\u0010ª\u0001\u001a\u00020\u001c2\u0007\u0010«\u0001\u001a\u00020\u001c2\u0006\u0010g\u001a\u00020*2\u0006\u0010h\u001a\u00020*2\u0006\u0010&\u001a\u00020'H\u0016JG\u0010\u00ad\u0001\u001a\u00020\r2\b\u0010\u008e\u0001\u001a\u00030\u008f\u00012\u0007\u0010\u0090\u0001\u001a\u00020\u001c2\u0007\u0010\u0084\u0001\u001a\u00020\u001c2\u0006\u0010I\u001a\u00020J2\u0007\u0010®\u0001\u001a\u00020*2\u0007\u0010¯\u0001\u001a\u00020*2\u0006\u0010&\u001a\u00020'H\u0016J5\u0010\u00ad\u0001\u001a\u00020\r2\b\u0010\u008e\u0001\u001a\u00030\u0092\u00012\u0006\u0010I\u001a\u00020J2\u0007\u0010®\u0001\u001a\u00020*2\u0007\u0010¯\u0001\u001a\u00020*2\u0006\u0010&\u001a\u00020'H\u0016JX\u0010°\u0001\u001a\u00020\r2\b\u0010\u008e\u0001\u001a\u00030\u008f\u00012\u0007\u0010\u0090\u0001\u001a\u00020\u001c2\u0007\u0010\u0084\u0001\u001a\u00020\u001c2\u0007\u0010±\u0001\u001a\u00020\u001c2\u0007\u0010²\u0001\u001a\u00020\u001c2\u0006\u0010g\u001a\u00020*2\u0006\u0010h\u001a\u00020*2\u0007\u0010³\u0001\u001a\u00020\u00122\u0006\u0010&\u001a\u00020'H\u0017JX\u0010°\u0001\u001a\u00020\r2\b\u0010\u008e\u0001\u001a\u00030¬\u00012\u0007\u0010ª\u0001\u001a\u00020\u001c2\u0007\u0010«\u0001\u001a\u00020\u001c2\u0007\u0010´\u0001\u001a\u00020\u001c2\u0007\u0010µ\u0001\u001a\u00020\u001c2\u0006\u0010g\u001a\u00020*2\u0006\u0010h\u001a\u00020*2\u0007\u0010³\u0001\u001a\u00020\u00122\u0006\u0010&\u001a\u00020'H\u0017JX\u0010°\u0001\u001a\u00020\r2\b\u0010\u008e\u0001\u001a\u00030¶\u00012\u0007\u0010ª\u0001\u001a\u00020\u001c2\u0007\u0010«\u0001\u001a\u00020\u001c2\u0007\u0010´\u0001\u001a\u00020\u001c2\u0007\u0010µ\u0001\u001a\u00020\u001c2\u0006\u0010g\u001a\u00020*2\u0006\u0010h\u001a\u00020*2\u0007\u0010³\u0001\u001a\u00020\u00122\u0006\u0010&\u001a\u00020'H\u0017Jw\u0010·\u0001\u001a\u00020\r2\u0007\u0010z\u001a\u00030¸\u00012\u0007\u0010¹\u0001\u001a\u00020\u001c2\u0006\u0010o\u001a\u00020p2\u0006\u0010q\u001a\u00020\u001c2\t\u0010º\u0001\u001a\u0004\u0018\u00010p2\u0007\u0010»\u0001\u001a\u00020\u001c2\b\u0010c\u001a\u0004\u0018\u00010d2\u0006\u0010r\u001a\u00020\u001c2\n\u0010¼\u0001\u001a\u0005\u0018\u00010½\u00012\u0007\u0010¾\u0001\u001a\u00020\u001c2\u0007\u0010¿\u0001\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020'H\u0016J\u0013\u0010À\u0001\u001a\u00020\r2\b\u0010Á\u0001\u001a\u00030Â\u0001H\u0017R&\u0010\u0004\u001a\u0004\u0018\u00010\u00018\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0005\u0010\u0003\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00018BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0007¨\u0006Ã\u0001"}, d2 = {"Landroidx/compose/ui/text/android/TextAndroidCanvas;", "Landroid/graphics/Canvas;", "<init>", "()V", "_nativeCanvas", "get_nativeCanvas$ui_text$annotations", "get_nativeCanvas$ui_text", "()Landroid/graphics/Canvas;", "set_nativeCanvas$ui_text", "(Landroid/graphics/Canvas;)V", "nativeCanvas", "getNativeCanvas", "withCanvas", "", "canvas", "block", "Lkotlin/Function1;", "getClipBounds", "", "bounds", "Landroid/graphics/Rect;", "setBitmap", "bitmap", "Landroid/graphics/Bitmap;", "enableZ", "disableZ", "isOpaque", "getWidth", "", "getHeight", "getDensity", "setDensity", "density", "getMaximumBitmapWidth", "getMaximumBitmapHeight", "save", "saveLayer", "Landroid/graphics/RectF;", "paint", "Landroid/graphics/Paint;", "saveFlags", TtmlNode.LEFT, "", "top", TtmlNode.RIGHT, "bottom", "saveLayerAlpha", "alpha", "restore", "getSaveCount", "restoreToCount", "saveCount", "translate", "dx", "dy", "scale", "sx", "sy", "rotate", "degrees", "skew", "concat", "matrix", "Landroid/graphics/Matrix;", "setMatrix", "getMatrix", "ctm", "clipRect", "rect", "op", "Landroid/graphics/Region$Op;", "clipOutRect", "clipPath", "path", "Landroid/graphics/Path;", "clipOutPath", "getDrawFilter", "Landroid/graphics/DrawFilter;", "setDrawFilter", "filter", "quickReject", "type", "Landroid/graphics/Canvas$EdgeType;", "drawPicture", "picture", "Landroid/graphics/Picture;", "dst", "drawArc", "oval", "startAngle", "sweepAngle", "useCenter", "drawARGB", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "r", "g", "b", "drawBitmap", "src", "colors", "", TypedValues.CycleType.S_WAVE_OFFSET, "stride", "x", "y", "width", "height", "hasAlpha", "drawBitmapMesh", "meshWidth", "meshHeight", "verts", "", "vertOffset", "colorOffset", "drawCircle", "cx", "cy", "radius", "drawColor", "color", "", UpdateActivity.UPDATE_MODE, "Landroid/graphics/PorterDuff$Mode;", "Landroid/graphics/BlendMode;", "drawLine", "startX", "startY", "stopX", "stopY", "drawLines", "pts", "count", "drawOval", "drawPaint", "drawPatch", "patch", "Landroid/graphics/NinePatch;", "drawPath", "drawPoint", "drawPoints", "drawPosText", "text", "", FirebaseAnalytics.Param.INDEX, "pos", "", "drawRect", "drawRGB", "drawRoundRect", "rx", "ry", "drawDoubleRoundRect", "outer", "outerRx", "outerRy", "inner", "innerRx", "innerRy", "outerRadii", "innerRadii", "drawGlyphs", "glyphIds", "glyphIdOffset", "positions", "positionOffset", "glyphCount", "font", "Landroid/graphics/fonts/Font;", "drawText", TtmlNode.START, TtmlNode.END, "", "drawTextOnPath", "hOffset", "vOffset", "drawTextRun", "contextIndex", "contextCount", "isRtl", "contextStart", "contextEnd", "Landroid/graphics/text/MeasuredText;", "drawVertices", "Landroid/graphics/Canvas$VertexMode;", "vertexCount", "texs", "texOffset", "indices", "", "indexOffset", "indexCount", "drawRenderNode", "renderNode", "Landroid/graphics/RenderNode;", "ui-text"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class TextAndroidCanvas extends Canvas {
    public static final int $stable = 8;
    private Canvas _nativeCanvas;

    public static /* synthetic */ void get_nativeCanvas$ui_text$annotations() {
    }

    public final Canvas get_nativeCanvas$ui_text() {
        return this._nativeCanvas;
    }

    public final void set_nativeCanvas$ui_text(Canvas canvas) {
        this._nativeCanvas = canvas;
    }

    private final Canvas getNativeCanvas() {
        Canvas canvas = this._nativeCanvas;
        if (canvas != null) {
            return canvas;
        }
        InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("Text drawing wrapper is missing a Canvas!");
        throw new KotlinNothingValueException();
    }

    public final void withCanvas(Canvas canvas, Function1<? super Canvas, Unit> function1) {
        set_nativeCanvas$ui_text(canvas);
        try {
            function1.invoke(this);
        } finally {
            set_nativeCanvas$ui_text(null);
        }
    }

    @Override // android.graphics.Canvas
    public boolean getClipBounds(Rect rect) {
        boolean clipBounds = getNativeCanvas().getClipBounds(rect);
        if (clipBounds) {
            rect.set(0, 0, rect.width(), Integer.MAX_VALUE);
        }
        return clipBounds;
    }

    @Override // android.graphics.Canvas
    public void setBitmap(Bitmap bitmap) {
        getNativeCanvas().setBitmap(bitmap);
    }

    @Override // android.graphics.Canvas
    public void enableZ() {
        CanvasCompatQ.INSTANCE.enableZ(getNativeCanvas());
    }

    @Override // android.graphics.Canvas
    public void disableZ() {
        CanvasCompatQ.INSTANCE.disableZ(getNativeCanvas());
    }

    @Override // android.graphics.Canvas
    public boolean isOpaque() {
        return getNativeCanvas().isOpaque();
    }

    @Override // android.graphics.Canvas
    public int getWidth() {
        return getNativeCanvas().getWidth();
    }

    @Override // android.graphics.Canvas
    public int getHeight() {
        return getNativeCanvas().getHeight();
    }

    @Override // android.graphics.Canvas
    public int getDensity() {
        return getNativeCanvas().getDensity();
    }

    @Override // android.graphics.Canvas
    public void setDensity(int i) {
        getNativeCanvas().setDensity(i);
    }

    @Override // android.graphics.Canvas
    public int getMaximumBitmapWidth() {
        return getNativeCanvas().getMaximumBitmapWidth();
    }

    @Override // android.graphics.Canvas
    public int getMaximumBitmapHeight() {
        return getNativeCanvas().getMaximumBitmapHeight();
    }

    @Override // android.graphics.Canvas
    public int save() {
        return getNativeCanvas().save();
    }

    @Override // android.graphics.Canvas
    @Deprecated(message = "Deprecated in Java")
    public int saveLayer(RectF rectF, Paint paint, int i) {
        return getNativeCanvas().saveLayer(rectF, paint, i);
    }

    @Override // android.graphics.Canvas
    public int saveLayer(RectF rectF, Paint paint) {
        return getNativeCanvas().saveLayer(rectF, paint);
    }

    @Override // android.graphics.Canvas
    @Deprecated(message = "Deprecated in Java")
    public int saveLayer(float f, float f2, float f3, float f4, Paint paint, int i) {
        return getNativeCanvas().saveLayer(f, f2, f3, f4, paint, i);
    }

    @Override // android.graphics.Canvas
    public int saveLayer(float f, float f2, float f3, float f4, Paint paint) {
        return getNativeCanvas().saveLayer(f, f2, f3, f4, paint);
    }

    @Override // android.graphics.Canvas
    @Deprecated(message = "Deprecated in Java")
    public int saveLayerAlpha(RectF rectF, int i, int i2) {
        return getNativeCanvas().saveLayerAlpha(rectF, i, i2);
    }

    @Override // android.graphics.Canvas
    public int saveLayerAlpha(RectF rectF, int i) {
        return getNativeCanvas().saveLayerAlpha(rectF, i);
    }

    @Override // android.graphics.Canvas
    @Deprecated(message = "Deprecated in Java")
    public int saveLayerAlpha(float f, float f2, float f3, float f4, int i, int i2) {
        return getNativeCanvas().saveLayerAlpha(f, f2, f3, f4, i, i2);
    }

    @Override // android.graphics.Canvas
    public int saveLayerAlpha(float f, float f2, float f3, float f4, int i) {
        return getNativeCanvas().saveLayerAlpha(f, f2, f3, f4, i);
    }

    @Override // android.graphics.Canvas
    public void restore() {
        getNativeCanvas().restore();
    }

    @Override // android.graphics.Canvas
    public int getSaveCount() {
        return getNativeCanvas().getSaveCount();
    }

    @Override // android.graphics.Canvas
    public void restoreToCount(int i) {
        getNativeCanvas().restoreToCount(i);
    }

    @Override // android.graphics.Canvas
    public void translate(float f, float f2) {
        getNativeCanvas().translate(f, f2);
    }

    @Override // android.graphics.Canvas
    public void scale(float f, float f2) {
        getNativeCanvas().scale(f, f2);
    }

    @Override // android.graphics.Canvas
    public void rotate(float f) {
        getNativeCanvas().rotate(f);
    }

    @Override // android.graphics.Canvas
    public void skew(float f, float f2) {
        getNativeCanvas().skew(f, f2);
    }

    @Override // android.graphics.Canvas
    public void concat(Matrix matrix) {
        getNativeCanvas().concat(matrix);
    }

    @Override // android.graphics.Canvas
    public void setMatrix(Matrix matrix) {
        getNativeCanvas().setMatrix(matrix);
    }

    @Override // android.graphics.Canvas
    @Deprecated(message = "Deprecated in Java")
    public void getMatrix(Matrix matrix) {
        getNativeCanvas().getMatrix(matrix);
    }

    @Override // android.graphics.Canvas
    @Deprecated(message = "Deprecated in Java")
    public boolean clipRect(RectF rectF, Region.Op op) {
        return getNativeCanvas().clipRect(rectF, op);
    }

    @Override // android.graphics.Canvas
    @Deprecated(message = "Deprecated in Java")
    public boolean clipRect(Rect rect, Region.Op op) {
        return getNativeCanvas().clipRect(rect, op);
    }

    @Override // android.graphics.Canvas
    public boolean clipRect(RectF rectF) {
        return getNativeCanvas().clipRect(rectF);
    }

    @Override // android.graphics.Canvas
    public boolean clipRect(Rect rect) {
        return getNativeCanvas().clipRect(rect);
    }

    @Override // android.graphics.Canvas
    @Deprecated(message = "Deprecated in Java")
    public boolean clipRect(float f, float f2, float f3, float f4, Region.Op op) {
        return getNativeCanvas().clipRect(f, f2, f3, f4, op);
    }

    @Override // android.graphics.Canvas
    public boolean clipRect(float f, float f2, float f3, float f4) {
        return getNativeCanvas().clipRect(f, f2, f3, f4);
    }

    @Override // android.graphics.Canvas
    public boolean clipRect(int i, int i2, int i3, int i4) {
        return getNativeCanvas().clipRect(i, i2, i3, i4);
    }

    @Override // android.graphics.Canvas
    public boolean clipOutRect(RectF rectF) {
        return CanvasCompatO.INSTANCE.clipOutRect(getNativeCanvas(), rectF);
    }

    @Override // android.graphics.Canvas
    public boolean clipOutRect(Rect rect) {
        return CanvasCompatO.INSTANCE.clipOutRect(getNativeCanvas(), rect);
    }

    @Override // android.graphics.Canvas
    public boolean clipOutRect(float f, float f2, float f3, float f4) {
        return CanvasCompatO.INSTANCE.clipOutRect(getNativeCanvas(), f, f2, f3, f4);
    }

    @Override // android.graphics.Canvas
    public boolean clipOutRect(int i, int i2, int i3, int i4) {
        return CanvasCompatO.INSTANCE.clipOutRect(getNativeCanvas(), i, i2, i3, i4);
    }

    @Override // android.graphics.Canvas
    @Deprecated(message = "Deprecated in Java")
    public boolean clipPath(Path path, Region.Op op) {
        return getNativeCanvas().clipPath(path, op);
    }

    @Override // android.graphics.Canvas
    public boolean clipPath(Path path) {
        return getNativeCanvas().clipPath(path);
    }

    @Override // android.graphics.Canvas
    public boolean clipOutPath(Path path) {
        return CanvasCompatO.INSTANCE.clipOutPath(getNativeCanvas(), path);
    }

    @Override // android.graphics.Canvas
    public DrawFilter getDrawFilter() {
        return getNativeCanvas().getDrawFilter();
    }

    @Override // android.graphics.Canvas
    public void setDrawFilter(DrawFilter drawFilter) {
        getNativeCanvas().setDrawFilter(drawFilter);
    }

    @Override // android.graphics.Canvas
    @Deprecated(message = "Deprecated in Java")
    public boolean quickReject(RectF rectF, Canvas.EdgeType edgeType) {
        return getNativeCanvas().quickReject(rectF, edgeType);
    }

    @Override // android.graphics.Canvas
    public boolean quickReject(RectF rectF) {
        return CanvasCompatR.INSTANCE.quickReject(getNativeCanvas(), rectF);
    }

    @Override // android.graphics.Canvas
    @Deprecated(message = "Deprecated in Java")
    public boolean quickReject(Path path, Canvas.EdgeType edgeType) {
        return getNativeCanvas().quickReject(path, edgeType);
    }

    @Override // android.graphics.Canvas
    public boolean quickReject(Path path) {
        return CanvasCompatR.INSTANCE.quickReject(getNativeCanvas(), path);
    }

    @Override // android.graphics.Canvas
    @Deprecated(message = "Deprecated in Java")
    public boolean quickReject(float f, float f2, float f3, float f4, Canvas.EdgeType edgeType) {
        return getNativeCanvas().quickReject(f, f2, f3, f4, edgeType);
    }

    @Override // android.graphics.Canvas
    public boolean quickReject(float f, float f2, float f3, float f4) {
        return CanvasCompatR.INSTANCE.quickReject(getNativeCanvas(), f, f2, f3, f4);
    }

    @Override // android.graphics.Canvas
    public void drawPicture(Picture picture) {
        getNativeCanvas().drawPicture(picture);
    }

    @Override // android.graphics.Canvas
    public void drawPicture(Picture picture, RectF rectF) {
        getNativeCanvas().drawPicture(picture, rectF);
    }

    @Override // android.graphics.Canvas
    public void drawPicture(Picture picture, Rect rect) {
        getNativeCanvas().drawPicture(picture, rect);
    }

    @Override // android.graphics.Canvas
    public void drawArc(RectF rectF, float f, float f2, boolean z, Paint paint) {
        getNativeCanvas().drawArc(rectF, f, f2, z, paint);
    }

    @Override // android.graphics.Canvas
    public void drawArc(float f, float f2, float f3, float f4, float f5, float f6, boolean z, Paint paint) {
        getNativeCanvas().drawArc(f, f2, f3, f4, f5, f6, z, paint);
    }

    @Override // android.graphics.Canvas
    public void drawARGB(int i, int i2, int i3, int i4) {
        getNativeCanvas().drawARGB(i, i2, i3, i4);
    }

    @Override // android.graphics.Canvas
    public void drawBitmap(Bitmap bitmap, float f, float f2, Paint paint) {
        getNativeCanvas().drawBitmap(bitmap, f, f2, paint);
    }

    @Override // android.graphics.Canvas
    public void drawBitmap(Bitmap bitmap, Rect rect, RectF rectF, Paint paint) {
        getNativeCanvas().drawBitmap(bitmap, rect, rectF, paint);
    }

    @Override // android.graphics.Canvas
    public void drawBitmap(Bitmap bitmap, Rect rect, Rect rect2, Paint paint) {
        getNativeCanvas().drawBitmap(bitmap, rect, rect2, paint);
    }

    @Override // android.graphics.Canvas
    @Deprecated(message = "Deprecated in Java")
    public void drawBitmap(int[] iArr, int i, int i2, float f, float f2, int i3, int i4, boolean z, Paint paint) {
        getNativeCanvas().drawBitmap(iArr, i, i2, f, f2, i3, i4, z, paint);
    }

    @Override // android.graphics.Canvas
    @Deprecated(message = "Deprecated in Java")
    public void drawBitmap(int[] iArr, int i, int i2, int i3, int i4, int i5, int i6, boolean z, Paint paint) {
        getNativeCanvas().drawBitmap(iArr, i, i2, i3, i4, i5, i6, z, paint);
    }

    @Override // android.graphics.Canvas
    public void drawBitmap(Bitmap bitmap, Matrix matrix, Paint paint) {
        getNativeCanvas().drawBitmap(bitmap, matrix, paint);
    }

    @Override // android.graphics.Canvas
    public void drawBitmapMesh(Bitmap bitmap, int i, int i2, float[] fArr, int i3, int[] iArr, int i4, Paint paint) {
        getNativeCanvas().drawBitmapMesh(bitmap, i, i2, fArr, i3, iArr, i4, paint);
    }

    @Override // android.graphics.Canvas
    public void drawCircle(float f, float f2, float f3, Paint paint) {
        getNativeCanvas().drawCircle(f, f2, f3, paint);
    }

    @Override // android.graphics.Canvas
    public void drawColor(int i) {
        getNativeCanvas().drawColor(i);
    }

    @Override // android.graphics.Canvas
    public void drawColor(long j) {
        CanvasCompatQ.INSTANCE.drawColor(getNativeCanvas(), j);
    }

    @Override // android.graphics.Canvas
    public void drawColor(int i, PorterDuff.Mode mode) {
        getNativeCanvas().drawColor(i, mode);
    }

    @Override // android.graphics.Canvas
    public void drawColor(int i, BlendMode blendMode) {
        CanvasCompatQ.INSTANCE.drawColor(getNativeCanvas(), i, blendMode);
    }

    @Override // android.graphics.Canvas
    public void drawColor(long j, BlendMode blendMode) {
        CanvasCompatQ.INSTANCE.drawColor(getNativeCanvas(), j, blendMode);
    }

    @Override // android.graphics.Canvas
    public void drawLine(float f, float f2, float f3, float f4, Paint paint) {
        getNativeCanvas().drawLine(f, f2, f3, f4, paint);
    }

    @Override // android.graphics.Canvas
    public void drawLines(float[] fArr, int i, int i2, Paint paint) {
        getNativeCanvas().drawLines(fArr, i, i2, paint);
    }

    @Override // android.graphics.Canvas
    public void drawLines(float[] fArr, Paint paint) {
        getNativeCanvas().drawLines(fArr, paint);
    }

    @Override // android.graphics.Canvas
    public void drawOval(RectF rectF, Paint paint) {
        getNativeCanvas().drawOval(rectF, paint);
    }

    @Override // android.graphics.Canvas
    public void drawOval(float f, float f2, float f3, float f4, Paint paint) {
        getNativeCanvas().drawOval(f, f2, f3, f4, paint);
    }

    @Override // android.graphics.Canvas
    public void drawPaint(Paint paint) {
        getNativeCanvas().drawPaint(paint);
    }

    @Override // android.graphics.Canvas
    public void drawPatch(NinePatch ninePatch, Rect rect, Paint paint) {
        CanvasCompatS.INSTANCE.drawPatch(getNativeCanvas(), ninePatch, rect, paint);
    }

    @Override // android.graphics.Canvas
    public void drawPatch(NinePatch ninePatch, RectF rectF, Paint paint) {
        CanvasCompatS.INSTANCE.drawPatch(getNativeCanvas(), ninePatch, rectF, paint);
    }

    @Override // android.graphics.Canvas
    public void drawPath(Path path, Paint paint) {
        getNativeCanvas().drawPath(path, paint);
    }

    @Override // android.graphics.Canvas
    public void drawPoint(float f, float f2, Paint paint) {
        getNativeCanvas().drawPoint(f, f2, paint);
    }

    @Override // android.graphics.Canvas
    public void drawPoints(float[] fArr, int i, int i2, Paint paint) {
        getNativeCanvas().drawPoints(fArr, i, i2, paint);
    }

    @Override // android.graphics.Canvas
    public void drawPoints(float[] fArr, Paint paint) {
        getNativeCanvas().drawPoints(fArr, paint);
    }

    @Override // android.graphics.Canvas
    @Deprecated(message = "Deprecated in Java")
    public void drawPosText(char[] cArr, int i, int i2, float[] fArr, Paint paint) {
        getNativeCanvas().drawPosText(cArr, i, i2, fArr, paint);
    }

    @Override // android.graphics.Canvas
    @Deprecated(message = "Deprecated in Java")
    public void drawPosText(String str, float[] fArr, Paint paint) {
        getNativeCanvas().drawPosText(str, fArr, paint);
    }

    @Override // android.graphics.Canvas
    public void drawRect(RectF rectF, Paint paint) {
        getNativeCanvas().drawRect(rectF, paint);
    }

    @Override // android.graphics.Canvas
    public void drawRect(Rect rect, Paint paint) {
        getNativeCanvas().drawRect(rect, paint);
    }

    @Override // android.graphics.Canvas
    public void drawRect(float f, float f2, float f3, float f4, Paint paint) {
        getNativeCanvas().drawRect(f, f2, f3, f4, paint);
    }

    @Override // android.graphics.Canvas
    public void drawRGB(int i, int i2, int i3) {
        getNativeCanvas().drawRGB(i, i2, i3);
    }

    @Override // android.graphics.Canvas
    public void drawRoundRect(RectF rectF, float f, float f2, Paint paint) {
        getNativeCanvas().drawRoundRect(rectF, f, f2, paint);
    }

    @Override // android.graphics.Canvas
    public void drawRoundRect(float f, float f2, float f3, float f4, float f5, float f6, Paint paint) {
        getNativeCanvas().drawRoundRect(f, f2, f3, f4, f5, f6, paint);
    }

    @Override // android.graphics.Canvas
    public void drawDoubleRoundRect(RectF rectF, float f, float f2, RectF rectF2, float f3, float f4, Paint paint) {
        CanvasCompatQ.INSTANCE.drawDoubleRoundRect(getNativeCanvas(), rectF, f, f2, rectF2, f3, f4, paint);
    }

    @Override // android.graphics.Canvas
    public void drawDoubleRoundRect(RectF rectF, float[] fArr, RectF rectF2, float[] fArr2, Paint paint) {
        CanvasCompatQ.INSTANCE.drawDoubleRoundRect(getNativeCanvas(), rectF, fArr, rectF2, fArr2, paint);
    }

    @Override // android.graphics.Canvas
    public void drawGlyphs(int[] iArr, int i, float[] fArr, int i2, int i3, Font font, Paint paint) {
        CanvasCompatS.INSTANCE.drawGlyphs(getNativeCanvas(), iArr, i, fArr, i2, i3, font, paint);
    }

    @Override // android.graphics.Canvas
    public void drawText(char[] cArr, int i, int i2, float f, float f2, Paint paint) {
        getNativeCanvas().drawText(cArr, i, i2, f, f2, paint);
    }

    @Override // android.graphics.Canvas
    public void drawText(String str, float f, float f2, Paint paint) {
        getNativeCanvas().drawText(str, f, f2, paint);
    }

    @Override // android.graphics.Canvas
    public void drawText(String str, int i, int i2, float f, float f2, Paint paint) {
        getNativeCanvas().drawText(str, i, i2, f, f2, paint);
    }

    @Override // android.graphics.Canvas
    public void drawText(CharSequence charSequence, int i, int i2, float f, float f2, Paint paint) {
        getNativeCanvas().drawText(charSequence, i, i2, f, f2, paint);
    }

    @Override // android.graphics.Canvas
    public void drawTextOnPath(char[] cArr, int i, int i2, Path path, float f, float f2, Paint paint) {
        getNativeCanvas().drawTextOnPath(cArr, i, i2, path, f, f2, paint);
    }

    @Override // android.graphics.Canvas
    public void drawTextOnPath(String str, Path path, float f, float f2, Paint paint) {
        getNativeCanvas().drawTextOnPath(str, path, f, f2, paint);
    }

    @Override // android.graphics.Canvas
    public void drawTextRun(char[] cArr, int i, int i2, int i3, int i4, float f, float f2, boolean z, Paint paint) {
        CanvasCompatM.INSTANCE.drawTextRun(getNativeCanvas(), cArr, i, i2, i3, i4, f, f2, z, paint);
    }

    @Override // android.graphics.Canvas
    public void drawTextRun(CharSequence charSequence, int i, int i2, int i3, int i4, float f, float f2, boolean z, Paint paint) {
        CanvasCompatM.INSTANCE.drawTextRun(getNativeCanvas(), charSequence, i, i2, i3, i4, f, f2, z, paint);
    }

    @Override // android.graphics.Canvas
    public void drawTextRun(MeasuredText measuredText, int i, int i2, int i3, int i4, float f, float f2, boolean z, Paint paint) {
        CanvasCompatQ.INSTANCE.drawTextRun(getNativeCanvas(), measuredText, i, i2, i3, i4, f, f2, z, paint);
    }

    @Override // android.graphics.Canvas
    public void drawVertices(Canvas.VertexMode vertexMode, int i, float[] fArr, int i2, float[] fArr2, int i3, int[] iArr, int i4, short[] sArr, int i5, int i6, Paint paint) {
        getNativeCanvas().drawVertices(vertexMode, i, fArr, i2, fArr2, i3, iArr, i4, sArr, i5, i6, paint);
    }

    @Override // android.graphics.Canvas
    public void drawRenderNode(RenderNode renderNode) {
        CanvasCompatQ.INSTANCE.drawRenderNode(getNativeCanvas(), renderNode);
    }
}
