package androidx.compose.ui.text;

import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.LinkAnnotation;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.Locale;
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
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.compose.ui.unit.TextUnitType;
import androidx.exifinterface.media.ExifInterface;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Savers.kt */
@Metadata(d1 = {"\u0000\u0080\u0003\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aM\u0010\u0000\u001a\u00020\u0001\"\u0014\b\u0000\u0010\u0002*\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0003\"\u0004\b\u0001\u0010\u0004\"\b\b\u0002\u0010\u0005*\u00020\u00012\b\u0010\u0006\u001a\u0004\u0018\u0001H\u00042\u0006\u0010\u0007\u001a\u0002H\u00022\u0006\u0010\b\u001a\u00020\tH\u0000¢\u0006\u0002\u0010\n\u001aP\u0010\u000b\u001a\u0004\u0018\u0001H\f\"\u0014\b\u0000\u0010\u0002*\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0003\"\u0004\b\u0001\u0010\u0004\"\b\b\u0002\u0010\u0005*\u00020\u0001\"\u0006\b\u0003\u0010\f\u0018\u00012\b\u0010\u0006\u001a\u0004\u0018\u0001H\u00052\u0006\u0010\u0007\u001a\u0002H\u0002H\u0080\b¢\u0006\u0002\u0010\r\u001ay\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u000f\"\u0004\b\u0000\u0010\u0004\"\b\b\u0001\u0010\u0005*\u00020\u00012.\u0010\u0000\u001a*\u0012\u0004\u0012\u00020\t\u0012\u0013\u0012\u0011H\u0004¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0006\u0012\u0006\u0012\u0004\u0018\u0001H\u00050\u0010¢\u0006\u0002\b\u00132#\u0010\u000b\u001a\u001f\u0012\u0013\u0012\u0011H\u0005¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0006\u0012\u0006\u0012\u0004\u0018\u0001H\u00040\u0014H\u0002\u001a\u001f\u0010\u0000\u001a\u0004\u0018\u0001H\u0002\"\u0004\b\u0000\u0010\u00022\b\u0010\u0006\u001a\u0004\u0018\u0001H\u0002H\u0000¢\u0006\u0002\u0010\u0015\u001a\"\u0010\u000b\u001a\u0004\u0018\u0001H\f\"\u0006\b\u0000\u0010\f\u0018\u00012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u0080\b¢\u0006\u0002\u0010\u0015\" \u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00010\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"(\u0010\u001a\u001a\u001c\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u001c0\u001b\u0012\u0004\u0012\u00020\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"(\u0010\u001d\u001a\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u001c\u0012\u0004\u0012\u00020\u00010\u0003X\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u001e\u0010\u001f\"\u001a\u0010 \u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\" \u0010\"\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u00010\u0003X\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\b$\u0010\u001f\"\u001a\u0010%\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"\u001a\u0010'\u001a\u000e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\" \u0010)\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\u00010\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u0019\" \u0010,\u001a\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020\u00010\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u0019\" \u0010/\u001a\u000e\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\u00010\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u0019\"$\u00102\u001a\u000e\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u00020\u00010\u0003*\u0002048@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b5\u00106\"\u001a\u00107\u001a\u000e\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u00020\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"$\u00102\u001a\u000e\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u00020\u00010\u0003*\u0002098@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b5\u0010:\"\u001a\u0010;\u001a\u000e\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u00020\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"$\u00102\u001a\u000e\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020\u00010\u0003*\u00020=8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b5\u0010>\"\u001a\u0010?\u001a\u000e\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"$\u00102\u001a\u000e\u0012\u0004\u0012\u00020@\u0012\u0004\u0012\u00020\u00010\u0003*\u00020A8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b5\u0010B\"\u001a\u0010C\u001a\u000e\u0012\u0004\u0012\u00020@\u0012\u0004\u0012\u00020\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"$\u00102\u001a\u000e\u0012\u0004\u0012\u00020D\u0012\u0004\u0012\u00020\u00010\u0003*\u00020E8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b5\u0010F\"\u001a\u0010G\u001a\u000e\u0012\u0004\u0012\u00020D\u0012\u0004\u0012\u00020\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"$\u00102\u001a\u000e\u0012\u0004\u0012\u00020H\u0012\u0004\u0012\u00020\u00010\u0003*\u00020I8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b5\u0010J\"\u001a\u0010K\u001a\u000e\u0012\u0004\u0012\u00020H\u0012\u0004\u0012\u00020\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"$\u00102\u001a\u000e\u0012\u0004\u0012\u00020L\u0012\u0004\u0012\u00020\u00010\u0003*\u00020M8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b5\u0010N\"\u001a\u0010O\u001a\u000e\u0012\u0004\u0012\u00020L\u0012\u0004\u0012\u00020\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"$\u00102\u001a\u000e\u0012\u0004\u0012\u00020P\u0012\u0004\u0012\u00020\u00010\u0003*\u00020Q8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b5\u0010R\"\u001a\u0010S\u001a\u000e\u0012\u0004\u0012\u00020P\u0012\u0004\u0012\u00020\u00010\u000fX\u0082\u0004¢\u0006\u0002\n\u0000\"$\u00102\u001a\u000e\u0012\u0004\u0012\u00020T\u0012\u0004\u0012\u00020\u00010\u0003*\u00020U8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b5\u0010V\"\u001a\u0010W\u001a\u000e\u0012\u0004\u0012\u00020T\u0012\u0004\u0012\u00020\u00010\u000fX\u0082\u0004¢\u0006\u0002\n\u0000\"$\u00102\u001a\u000e\u0012\u0004\u0012\u00020X\u0012\u0004\u0012\u00020\u00010\u0003*\u00020Y8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b5\u0010Z\"\u001a\u0010[\u001a\u000e\u0012\u0004\u0012\u00020X\u0012\u0004\u0012\u00020\u00010\u000fX\u0082\u0004¢\u0006\u0002\n\u0000\"$\u00102\u001a\u000e\u0012\u0004\u0012\u00020\\\u0012\u0004\u0012\u00020\u00010\u0003*\u00020]8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b5\u0010^\"\u001a\u0010_\u001a\u000e\u0012\u0004\u0012\u00020\\\u0012\u0004\u0012\u00020\u00010\u000fX\u0082\u0004¢\u0006\u0002\n\u0000\"$\u00102\u001a\u000e\u0012\u0004\u0012\u00020`\u0012\u0004\u0012\u00020\u00010\u0003*\u00020a8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b5\u0010b\" \u0010c\u001a\u000e\u0012\u0004\u0012\u00020`\u0012\u0004\u0012\u00020\u00010\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bd\u0010\u0019\"$\u00102\u001a\u000e\u0012\u0004\u0012\u00020e\u0012\u0004\u0012\u00020\u00010\u0003*\u00020f8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b5\u0010g\" \u0010h\u001a\u000e\u0012\u0004\u0012\u00020e\u0012\u0004\u0012\u00020\u00010\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bi\u0010\u0019\"$\u00102\u001a\u000e\u0012\u0004\u0012\u00020j\u0012\u0004\u0012\u00020\u00010\u0003*\u00020k8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b5\u0010l\"\u001a\u0010m\u001a\u000e\u0012\u0004\u0012\u00020j\u0012\u0004\u0012\u00020\u00010\u000fX\u0082\u0004¢\u0006\u0002\n\u0000\"$\u00102\u001a\u000e\u0012\u0004\u0012\u00020n\u0012\u0004\u0012\u00020\u00010\u0003*\u00020o8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b5\u0010p\" \u0010q\u001a\u000e\u0012\u0004\u0012\u00020n\u0012\u0004\u0012\u00020\u00010\u000fX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\br\u0010s\"$\u00102\u001a\u000e\u0012\u0004\u0012\u00020t\u0012\u0004\u0012\u00020\u00010\u0003*\u00020u8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b5\u0010v\"\u001a\u0010w\u001a\u000e\u0012\u0004\u0012\u00020t\u0012\u0004\u0012\u00020\u00010\u000fX\u0082\u0004¢\u0006\u0002\n\u0000\"$\u00102\u001a\u000e\u0012\u0004\u0012\u00020x\u0012\u0004\u0012\u00020\u00010\u0003*\u00020y8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b5\u0010z\"\u001a\u0010{\u001a\u000e\u0012\u0004\u0012\u00020x\u0012\u0004\u0012\u00020\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"$\u00102\u001a\u000e\u0012\u0004\u0012\u00020|\u0012\u0004\u0012\u00020\u00010\u0003*\u00020}8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b5\u0010~\"\u001a\u0010\u007f\u001a\u000e\u0012\u0004\u0012\u00020|\u0012\u0004\u0012\u00020\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"'\u00102\u001a\u000f\u0012\u0005\u0012\u00030\u0080\u0001\u0012\u0004\u0012\u00020\u00010\u0003*\u00030\u0081\u00018@X\u0080\u0004¢\u0006\u0007\u001a\u0005\b5\u0010\u0082\u0001\"\u001c\u0010\u0083\u0001\u001a\u000f\u0012\u0005\u0012\u00030\u0080\u0001\u0012\u0004\u0012\u00020\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"'\u00102\u001a\u000f\u0012\u0005\u0012\u00030\u0084\u0001\u0012\u0004\u0012\u00020\u00010\u0003*\u00030\u0085\u00018BX\u0082\u0004¢\u0006\u0007\u001a\u0005\b5\u0010\u0086\u0001\"\u001c\u0010\u0087\u0001\u001a\u000f\u0012\u0005\u0012\u00030\u0084\u0001\u0012\u0004\u0012\u00020\u00010\u000fX\u0082\u0004¢\u0006\u0002\n\u0000\"'\u00102\u001a\u000f\u0012\u0005\u0012\u00030\u0088\u0001\u0012\u0004\u0012\u00020\u00010\u0003*\u00030\u0089\u00018BX\u0082\u0004¢\u0006\u0007\u001a\u0005\b5\u0010\u008a\u0001\"\u001c\u0010\u008b\u0001\u001a\u000f\u0012\u0005\u0012\u00030\u0088\u0001\u0012\u0004\u0012\u00020\u00010\u000fX\u0082\u0004¢\u0006\u0002\n\u0000\"'\u00102\u001a\u000f\u0012\u0005\u0012\u00030\u008c\u0001\u0012\u0004\u0012\u00020\u00010\u0003*\u00030\u008d\u00018BX\u0082\u0004¢\u0006\u0007\u001a\u0005\b5\u0010\u008e\u0001\"\u001c\u0010\u008f\u0001\u001a\u000f\u0012\u0005\u0012\u00030\u008c\u0001\u0012\u0004\u0012\u00020\u00010\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0090\u0001"}, d2 = {"save", "", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/compose/runtime/saveable/Saver;", "Original", "Saveable", "value", "saver", "scope", "Landroidx/compose/runtime/saveable/SaverScope;", "(Ljava/lang/Object;Landroidx/compose/runtime/saveable/Saver;Landroidx/compose/runtime/saveable/SaverScope;)Ljava/lang/Object;", "restore", "Result", "(Ljava/lang/Object;Landroidx/compose/runtime/saveable/Saver;)Ljava/lang/Object;", "NonNullValueClassSaver", "Landroidx/compose/ui/text/NonNullValueClassSaver;", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "Lkotlin/ExtensionFunctionType;", "Lkotlin/Function1;", "(Ljava/lang/Object;)Ljava/lang/Object;", "AnnotatedStringSaver", "Landroidx/compose/ui/text/AnnotatedString;", "getAnnotatedStringSaver", "()Landroidx/compose/runtime/saveable/Saver;", "AnnotationRangeListSaver", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "AnnotationRangeSaver", "getAnnotationRangeSaver$annotations", "()V", "VerbatimTtsAnnotationSaver", "Landroidx/compose/ui/text/VerbatimTtsAnnotation;", "UrlAnnotationSaver", "Landroidx/compose/ui/text/UrlAnnotation;", "getUrlAnnotationSaver$annotations", "LinkSaver", "Landroidx/compose/ui/text/LinkAnnotation$Url;", "ClickableSaver", "Landroidx/compose/ui/text/LinkAnnotation$Clickable;", "ParagraphStyleSaver", "Landroidx/compose/ui/text/ParagraphStyle;", "getParagraphStyleSaver", "SpanStyleSaver", "Landroidx/compose/ui/text/SpanStyle;", "getSpanStyleSaver", "TextLinkStylesSaver", "Landroidx/compose/ui/text/TextLinkStyles;", "getTextLinkStylesSaver", "Saver", "Landroidx/compose/ui/text/style/TextDecoration;", "Landroidx/compose/ui/text/style/TextDecoration$Companion;", "getSaver", "(Landroidx/compose/ui/text/style/TextDecoration$Companion;)Landroidx/compose/runtime/saveable/Saver;", "TextDecorationSaver", "Landroidx/compose/ui/text/style/TextGeometricTransform;", "Landroidx/compose/ui/text/style/TextGeometricTransform$Companion;", "(Landroidx/compose/ui/text/style/TextGeometricTransform$Companion;)Landroidx/compose/runtime/saveable/Saver;", "TextGeometricTransformSaver", "Landroidx/compose/ui/text/style/TextIndent;", "Landroidx/compose/ui/text/style/TextIndent$Companion;", "(Landroidx/compose/ui/text/style/TextIndent$Companion;)Landroidx/compose/runtime/saveable/Saver;", "TextIndentSaver", "Landroidx/compose/ui/text/font/FontWeight;", "Landroidx/compose/ui/text/font/FontWeight$Companion;", "(Landroidx/compose/ui/text/font/FontWeight$Companion;)Landroidx/compose/runtime/saveable/Saver;", "FontWeightSaver", "Landroidx/compose/ui/text/style/BaselineShift;", "Landroidx/compose/ui/text/style/BaselineShift$Companion;", "(Landroidx/compose/ui/text/style/BaselineShift$Companion;)Landroidx/compose/runtime/saveable/Saver;", "BaselineShiftSaver", "Landroidx/compose/ui/text/TextRange;", "Landroidx/compose/ui/text/TextRange$Companion;", "(Landroidx/compose/ui/text/TextRange$Companion;)Landroidx/compose/runtime/saveable/Saver;", "TextRangeSaver", "Landroidx/compose/ui/graphics/Shadow;", "Landroidx/compose/ui/graphics/Shadow$Companion;", "(Landroidx/compose/ui/graphics/Shadow$Companion;)Landroidx/compose/runtime/saveable/Saver;", "ShadowSaver", "Landroidx/compose/ui/graphics/Color;", "Landroidx/compose/ui/graphics/Color$Companion;", "(Landroidx/compose/ui/graphics/Color$Companion;)Landroidx/compose/runtime/saveable/Saver;", "ColorSaver", "Landroidx/compose/ui/text/style/TextAlign;", "Landroidx/compose/ui/text/style/TextAlign$Companion;", "(Landroidx/compose/ui/text/style/TextAlign$Companion;)Landroidx/compose/runtime/saveable/Saver;", "TextAlignSaver", "Landroidx/compose/ui/text/style/TextDirection;", "Landroidx/compose/ui/text/style/TextDirection$Companion;", "(Landroidx/compose/ui/text/style/TextDirection$Companion;)Landroidx/compose/runtime/saveable/Saver;", "TextDirectionSaver", "Landroidx/compose/ui/text/style/Hyphens;", "Landroidx/compose/ui/text/style/Hyphens$Companion;", "(Landroidx/compose/ui/text/style/Hyphens$Companion;)Landroidx/compose/runtime/saveable/Saver;", "HyphensSaver", "Landroidx/compose/ui/text/font/FontStyle;", "Landroidx/compose/ui/text/font/FontStyle$Companion;", "(Landroidx/compose/ui/text/font/FontStyle$Companion;)Landroidx/compose/runtime/saveable/Saver;", "FontStyleSaver", "getFontStyleSaver", "Landroidx/compose/ui/text/font/FontSynthesis;", "Landroidx/compose/ui/text/font/FontSynthesis$Companion;", "(Landroidx/compose/ui/text/font/FontSynthesis$Companion;)Landroidx/compose/runtime/saveable/Saver;", "FontSynthesisSaver", "getFontSynthesisSaver", "Landroidx/compose/ui/unit/TextUnit;", "Landroidx/compose/ui/unit/TextUnit$Companion;", "(Landroidx/compose/ui/unit/TextUnit$Companion;)Landroidx/compose/runtime/saveable/Saver;", "TextUnitSaver", "Landroidx/compose/ui/unit/TextUnitType;", "Landroidx/compose/ui/unit/TextUnitType$Companion;", "(Landroidx/compose/ui/unit/TextUnitType$Companion;)Landroidx/compose/runtime/saveable/Saver;", "TextUnitTypeSaver", "getTextUnitTypeSaver", "()Landroidx/compose/ui/text/NonNullValueClassSaver;", "Landroidx/compose/ui/geometry/Offset;", "Landroidx/compose/ui/geometry/Offset$Companion;", "(Landroidx/compose/ui/geometry/Offset$Companion;)Landroidx/compose/runtime/saveable/Saver;", "OffsetSaver", "Landroidx/compose/ui/text/intl/LocaleList;", "Landroidx/compose/ui/text/intl/LocaleList$Companion;", "(Landroidx/compose/ui/text/intl/LocaleList$Companion;)Landroidx/compose/runtime/saveable/Saver;", "LocaleListSaver", "Landroidx/compose/ui/text/intl/Locale;", "Landroidx/compose/ui/text/intl/Locale$Companion;", "(Landroidx/compose/ui/text/intl/Locale$Companion;)Landroidx/compose/runtime/saveable/Saver;", "LocaleSaver", "Landroidx/compose/ui/text/style/LineHeightStyle;", "Landroidx/compose/ui/text/style/LineHeightStyle$Companion;", "(Landroidx/compose/ui/text/style/LineHeightStyle$Companion;)Landroidx/compose/runtime/saveable/Saver;", "LineHeightStyleSaver", "Landroidx/compose/ui/text/style/LineHeightStyle$Alignment;", "Landroidx/compose/ui/text/style/LineHeightStyle$Alignment$Companion;", "(Landroidx/compose/ui/text/style/LineHeightStyle$Alignment$Companion;)Landroidx/compose/runtime/saveable/Saver;", "LineHeightStyleAlignmentSaver", "Landroidx/compose/ui/text/style/LineHeightStyle$Trim;", "Landroidx/compose/ui/text/style/LineHeightStyle$Trim$Companion;", "(Landroidx/compose/ui/text/style/LineHeightStyle$Trim$Companion;)Landroidx/compose/runtime/saveable/Saver;", "LineHeightStyleTrimSaver", "Landroidx/compose/ui/text/style/LineHeightStyle$Mode;", "Landroidx/compose/ui/text/style/LineHeightStyle$Mode$Companion;", "(Landroidx/compose/ui/text/style/LineHeightStyle$Mode$Companion;)Landroidx/compose/runtime/saveable/Saver;", "LineHeightStyleModeSaver", "ui-text"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SaversKt {
    private static final Saver<AnnotatedString, Object> AnnotatedStringSaver = SaverKt.Saver(new Function2() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            Object arrayListOf;
            arrayListOf = CollectionsKt.arrayListOf(SaversKt.save(r2.getText()), SaversKt.save(((AnnotatedString) obj2).getAnnotations$ui_text(), SaversKt.AnnotationRangeListSaver, (SaverScope) obj));
            return arrayListOf;
        }
    }, new Function1() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return SaversKt.AnnotatedStringSaver$lambda$1(obj);
        }
    });
    private static final Saver<List<AnnotatedString.Range<? extends Object>>, Object> AnnotationRangeListSaver = SaverKt.Saver(new Function2() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda14
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return SaversKt.AnnotationRangeListSaver$lambda$0((SaverScope) obj, (List) obj2);
        }
    }, new Function1() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda26
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return SaversKt.AnnotationRangeListSaver$lambda$1(obj);
        }
    });
    private static final Saver<AnnotatedString.Range<? extends Object>, Object> AnnotationRangeSaver = SaverKt.Saver(new Function2() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda38
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return SaversKt.AnnotationRangeSaver$lambda$0((SaverScope) obj, (AnnotatedString.Range) obj2);
        }
    }, new Function1() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda50
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return SaversKt.AnnotationRangeSaver$lambda$1(obj);
        }
    });
    private static final Saver<VerbatimTtsAnnotation, Object> VerbatimTtsAnnotationSaver = SaverKt.Saver(new Function2() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda53
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            Object save;
            SaverScope saverScope = (SaverScope) obj;
            save = SaversKt.save(((VerbatimTtsAnnotation) obj2).getVerbatim());
            return save;
        }
    }, new Function1() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda54
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return SaversKt.VerbatimTtsAnnotationSaver$lambda$1(obj);
        }
    });
    private static final Saver<UrlAnnotation, Object> UrlAnnotationSaver = SaverKt.Saver(new Function2() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda56
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            Object save;
            SaverScope saverScope = (SaverScope) obj;
            save = SaversKt.save(((UrlAnnotation) obj2).getUrl());
            return save;
        }
    }, new Function1() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda57
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return SaversKt.UrlAnnotationSaver$lambda$1(obj);
        }
    });
    private static final Saver<LinkAnnotation.Url, Object> LinkSaver = SaverKt.Saver(new Function2() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda11
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            Object arrayListOf;
            arrayListOf = CollectionsKt.arrayListOf(SaversKt.save(r2.getUrl()), SaversKt.save(((LinkAnnotation.Url) obj2).getStyles(), SaversKt.TextLinkStylesSaver, (SaverScope) obj));
            return arrayListOf;
        }
    }, new Function1() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda22
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return SaversKt.LinkSaver$lambda$1(obj);
        }
    });
    private static final Saver<LinkAnnotation.Clickable, Object> ClickableSaver = SaverKt.Saver(new Function2() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda33
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            Object arrayListOf;
            arrayListOf = CollectionsKt.arrayListOf(SaversKt.save(r2.getTag()), SaversKt.save(((LinkAnnotation.Clickable) obj2).getStyles(), SaversKt.TextLinkStylesSaver, (SaverScope) obj));
            return arrayListOf;
        }
    }, new Function1() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda44
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return SaversKt.ClickableSaver$lambda$1(obj);
        }
    });
    private static final Saver<ParagraphStyle, Object> ParagraphStyleSaver = SaverKt.Saver(new Function2() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda55
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            Object arrayListOf;
            arrayListOf = CollectionsKt.arrayListOf(SaversKt.save(TextAlign.m8031boximpl(r2.m7513getTextAligne0LSkKk()), SaversKt.getSaver(TextAlign.Companion), r1), SaversKt.save(TextDirection.m8048boximpl(r2.m7515getTextDirections_7Xco()), SaversKt.getSaver(TextDirection.Companion), r1), SaversKt.save(TextUnit.m8344boximpl(r2.m7511getLineHeightXSAIIZE()), SaversKt.getSaver(TextUnit.Companion), r1), SaversKt.save(r2.getTextIndent(), SaversKt.getSaver(TextIndent.Companion), r1), SaversKt.save(r2.getPlatformStyle(), Savers_androidKt.getSaver(PlatformParagraphStyle.Companion), r1), SaversKt.save(r2.getLineHeightStyle(), SaversKt.getSaver(LineHeightStyle.Companion), r1), SaversKt.save(LineBreak.m7936boximpl(r2.m7510getLineBreakrAG3T2k()), Savers_androidKt.getSaver(LineBreak.Companion), r1), SaversKt.save(Hyphens.m7923boximpl(r2.m7508getHyphensvmbZdU8()), SaversKt.getSaver(Hyphens.Companion), r1), SaversKt.save(((ParagraphStyle) obj2).getTextMotion(), Savers_androidKt.getSaver(TextMotion.Companion), (SaverScope) obj));
            return arrayListOf;
        }
    }, new Function1() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda58
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return SaversKt.ParagraphStyleSaver$lambda$1(obj);
        }
    });
    private static final Saver<SpanStyle, Object> SpanStyleSaver = SaverKt.Saver(new Function2() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda59
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            Object arrayListOf;
            arrayListOf = CollectionsKt.arrayListOf(SaversKt.save(Color.m5338boximpl(r2.m7549getColor0d7_KjU()), SaversKt.getSaver(Color.Companion), r1), SaversKt.save(TextUnit.m8344boximpl(r2.m7550getFontSizeXSAIIZE()), SaversKt.getSaver(TextUnit.Companion), r1), SaversKt.save(r2.getFontWeight(), SaversKt.getSaver(FontWeight.Companion), r1), SaversKt.save(r2.m7551getFontStyle4Lr2A7w(), SaversKt.getSaver(FontStyle.Companion), r1), SaversKt.save(r2.m7552getFontSynthesisZQGJjVo(), SaversKt.getSaver(FontSynthesis.Companion), r1), SaversKt.save(-1), SaversKt.save(r2.getFontFeatureSettings()), SaversKt.save(TextUnit.m8344boximpl(r2.m7553getLetterSpacingXSAIIZE()), SaversKt.getSaver(TextUnit.Companion), r1), SaversKt.save(r2.m7548getBaselineShift5SSeXJ0(), SaversKt.getSaver(BaselineShift.Companion), r1), SaversKt.save(r2.getTextGeometricTransform(), SaversKt.getSaver(TextGeometricTransform.Companion), r1), SaversKt.save(r2.getLocaleList(), SaversKt.getSaver(LocaleList.Companion), r1), SaversKt.save(Color.m5338boximpl(r2.m7547getBackground0d7_KjU()), SaversKt.getSaver(Color.Companion), r1), SaversKt.save(r2.getTextDecoration(), SaversKt.getSaver(TextDecoration.Companion), r1), SaversKt.save(((SpanStyle) obj2).getShadow(), SaversKt.getSaver(Shadow.Companion), (SaverScope) obj));
            return arrayListOf;
        }
    }, new Function1() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda60
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return SaversKt.SpanStyleSaver$lambda$1(obj);
        }
    });
    private static final Saver<TextLinkStyles, Object> TextLinkStylesSaver = SaverKt.Saver(new Function2() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda61
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return SaversKt.TextLinkStylesSaver$lambda$0((SaverScope) obj, (TextLinkStyles) obj2);
        }
    }, new Function1() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return SaversKt.TextLinkStylesSaver$lambda$1(obj);
        }
    });
    private static final Saver<TextDecoration, Object> TextDecorationSaver = SaverKt.Saver(new Function2() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda3
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            Object valueOf;
            SaverScope saverScope = (SaverScope) obj;
            valueOf = Integer.valueOf(((TextDecoration) obj2).getMask());
            return valueOf;
        }
    }, new Function1() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda4
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return SaversKt.TextDecorationSaver$lambda$1(obj);
        }
    });
    private static final Saver<TextGeometricTransform, Object> TextGeometricTransformSaver = SaverKt.Saver(new Function2() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda5
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            Object arrayListOf;
            SaverScope saverScope = (SaverScope) obj;
            arrayListOf = CollectionsKt.arrayListOf(Float.valueOf(r2.getScaleX()), Float.valueOf(((TextGeometricTransform) obj2).getSkewX()));
            return arrayListOf;
        }
    }, new Function1() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda6
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return SaversKt.TextGeometricTransformSaver$lambda$1(obj);
        }
    });
    private static final Saver<TextIndent, Object> TextIndentSaver = SaverKt.Saver(new Function2() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda7
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            Object arrayListOf;
            arrayListOf = CollectionsKt.arrayListOf(SaversKt.save(TextUnit.m8344boximpl(r2.m8068getFirstLineXSAIIZE()), SaversKt.getSaver(TextUnit.Companion), r1), SaversKt.save(TextUnit.m8344boximpl(((TextIndent) obj2).m8069getRestLineXSAIIZE()), SaversKt.getSaver(TextUnit.Companion), (SaverScope) obj));
            return arrayListOf;
        }
    }, new Function1() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda8
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return SaversKt.TextIndentSaver$lambda$1(obj);
        }
    });
    private static final Saver<FontWeight, Object> FontWeightSaver = SaverKt.Saver(new Function2() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda9
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            Object valueOf;
            SaverScope saverScope = (SaverScope) obj;
            valueOf = Integer.valueOf(((FontWeight) obj2).getWeight());
            return valueOf;
        }
    }, new Function1() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda10
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return SaversKt.FontWeightSaver$lambda$1(obj);
        }
    });
    private static final Saver<BaselineShift, Object> BaselineShiftSaver = SaverKt.Saver(new Function2() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda12
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            Object valueOf;
            SaverScope saverScope = (SaverScope) obj;
            valueOf = Float.valueOf(((BaselineShift) obj2).m7906unboximpl());
            return valueOf;
        }
    }, new Function1() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda13
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return SaversKt.BaselineShiftSaver$lambda$1(obj);
        }
    });
    private static final Saver<TextRange, Object> TextRangeSaver = SaverKt.Saver(new Function2() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda15
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            Object arrayListOf;
            SaverScope saverScope = (SaverScope) obj;
            arrayListOf = CollectionsKt.arrayListOf(SaversKt.save(Integer.valueOf(TextRange.m7608getStartimpl(r2.m7612unboximpl()))), SaversKt.save(Integer.valueOf(TextRange.m7603getEndimpl(((TextRange) obj2).m7612unboximpl()))));
            return arrayListOf;
        }
    }, new Function1() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda16
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return SaversKt.TextRangeSaver$lambda$1(obj);
        }
    });
    private static final Saver<Shadow, Object> ShadowSaver = SaverKt.Saver(new Function2() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda17
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            Object arrayListOf;
            arrayListOf = CollectionsKt.arrayListOf(SaversKt.save(Color.m5338boximpl(r2.m5692getColor0d7_KjU()), SaversKt.getSaver(Color.Companion), r1), SaversKt.save(Offset.m5092boximpl(r2.m5693getOffsetF1C5BW0()), SaversKt.getSaver(Offset.Companion), (SaverScope) obj), SaversKt.save(Float.valueOf(((Shadow) obj2).getBlurRadius())));
            return arrayListOf;
        }
    }, new Function1() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda18
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return SaversKt.ShadowSaver$lambda$1(obj);
        }
    });
    private static final NonNullValueClassSaver<Color, Object> ColorSaver = NonNullValueClassSaver(new Function2<SaverScope, Color, Object>() { // from class: androidx.compose.ui.text.SaversKt$ColorSaver$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(SaverScope saverScope, Color color) {
            return m7537invoke4WTKRHQ(saverScope, color.m5358unboximpl());
        }

        /* renamed from: invoke-4WTKRHQ  reason: not valid java name */
        public final Object m7537invoke4WTKRHQ(SaverScope saverScope, long j) {
            if (j == 16) {
                return false;
            }
            return Integer.valueOf(ColorKt.m5402toArgb8_81llA(j));
        }
    }, new Function1<Object, Color>() { // from class: androidx.compose.ui.text.SaversKt$ColorSaver$2
        @Override // kotlin.jvm.functions.Function1
        /* renamed from: invoke-ijrfgN4  reason: not valid java name */
        public final Color invoke(Object obj) {
            if (Intrinsics.areEqual(obj, (Object) false)) {
                return Color.m5338boximpl(Color.Companion.m5384getUnspecified0d7_KjU());
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            return Color.m5338boximpl(ColorKt.Color(((Integer) obj).intValue()));
        }
    });
    private static final NonNullValueClassSaver<TextAlign, Object> TextAlignSaver = NonNullValueClassSaver(new Function2() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda19
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            Object valueOf;
            SaverScope saverScope = (SaverScope) obj;
            valueOf = Integer.valueOf(((TextAlign) obj2).m8037unboximpl());
            return valueOf;
        }
    }, new Function1() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda20
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return SaversKt.TextAlignSaver$lambda$1(obj);
        }
    });
    private static final NonNullValueClassSaver<TextDirection, Object> TextDirectionSaver = NonNullValueClassSaver(new Function2() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda21
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            Object valueOf;
            SaverScope saverScope = (SaverScope) obj;
            valueOf = Integer.valueOf(((TextDirection) obj2).m8054unboximpl());
            return valueOf;
        }
    }, new Function1() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda23
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return SaversKt.TextDirectionSaver$lambda$1(obj);
        }
    });
    private static final NonNullValueClassSaver<Hyphens, Object> HyphensSaver = NonNullValueClassSaver(new Function2() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda24
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            Object valueOf;
            SaverScope saverScope = (SaverScope) obj;
            valueOf = Integer.valueOf(((Hyphens) obj2).m7929unboximpl());
            return valueOf;
        }
    }, new Function1() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda25
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return SaversKt.HyphensSaver$lambda$1(obj);
        }
    });
    private static final Saver<FontStyle, Object> FontStyleSaver = SaverKt.Saver(new Function2() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda27
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            Object save;
            SaverScope saverScope = (SaverScope) obj;
            save = SaversKt.save(Integer.valueOf(((FontStyle) obj2).m7723unboximpl()));
            return save;
        }
    }, new Function1() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda28
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return SaversKt.FontStyleSaver$lambda$1(obj);
        }
    });
    private static final Saver<FontSynthesis, Object> FontSynthesisSaver = SaverKt.Saver(new Function2() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda29
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            Object valueOf;
            SaverScope saverScope = (SaverScope) obj;
            valueOf = Integer.valueOf(((FontSynthesis) obj2).m7736unboximpl());
            return valueOf;
        }
    }, new Function1() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda30
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return SaversKt.FontSynthesisSaver$lambda$1(obj);
        }
    });
    private static final NonNullValueClassSaver<TextUnit, Object> TextUnitSaver = NonNullValueClassSaver(new Function2() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda31
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return SaversKt.TextUnitSaver$lambda$0((SaverScope) obj, (TextUnit) obj2);
        }
    }, new Function1() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda32
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return SaversKt.TextUnitSaver$lambda$1(obj);
        }
    });
    private static final NonNullValueClassSaver<TextUnitType, Object> TextUnitTypeSaver = NonNullValueClassSaver(new Function2() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda34
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return SaversKt.TextUnitTypeSaver$lambda$0((SaverScope) obj, (TextUnitType) obj2);
        }
    }, new Function1() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda35
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return SaversKt.TextUnitTypeSaver$lambda$1(obj);
        }
    });
    private static final NonNullValueClassSaver<Offset, Object> OffsetSaver = NonNullValueClassSaver(new Function2() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda36
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return SaversKt.OffsetSaver$lambda$0((SaverScope) obj, (Offset) obj2);
        }
    }, new Function1() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda37
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return SaversKt.OffsetSaver$lambda$1(obj);
        }
    });
    private static final Saver<LocaleList, Object> LocaleListSaver = SaverKt.Saver(new Function2() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda39
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return SaversKt.LocaleListSaver$lambda$0((SaverScope) obj, (LocaleList) obj2);
        }
    }, new Function1() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda40
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return SaversKt.LocaleListSaver$lambda$1(obj);
        }
    });
    private static final Saver<Locale, Object> LocaleSaver = SaverKt.Saver(new Function2() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda41
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            Object languageTag;
            SaverScope saverScope = (SaverScope) obj;
            languageTag = ((Locale) obj2).toLanguageTag();
            return languageTag;
        }
    }, new Function1() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda42
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return SaversKt.LocaleSaver$lambda$1(obj);
        }
    });
    private static final Saver<LineHeightStyle, Object> LineHeightStyleSaver = SaverKt.Saver(new Function2() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda43
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            Object arrayListOf;
            arrayListOf = CollectionsKt.arrayListOf(SaversKt.save(LineHeightStyle.Alignment.m7997boximpl(r2.m7994getAlignmentPIaL0Z0()), SaversKt.getSaver(LineHeightStyle.Alignment.Companion), r1), SaversKt.save(LineHeightStyle.Trim.m8018boximpl(r2.m7996getTrimEVpEnUU()), SaversKt.getSaver(LineHeightStyle.Trim.Companion), r1), SaversKt.save(LineHeightStyle.Mode.m8008boximpl(((LineHeightStyle) obj2).m7995getModelzQqcRY()), SaversKt.getSaver(LineHeightStyle.Mode.Companion), (SaverScope) obj));
            return arrayListOf;
        }
    }, new Function1() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda45
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return SaversKt.LineHeightStyleSaver$lambda$1(obj);
        }
    });
    private static final NonNullValueClassSaver<LineHeightStyle.Alignment, Object> LineHeightStyleAlignmentSaver = NonNullValueClassSaver(new Function2() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda46
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            Object valueOf;
            SaverScope saverScope = (SaverScope) obj;
            valueOf = Float.valueOf(((LineHeightStyle.Alignment) obj2).m8003unboximpl());
            return valueOf;
        }
    }, new Function1() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda47
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return SaversKt.LineHeightStyleAlignmentSaver$lambda$1(obj);
        }
    });
    private static final NonNullValueClassSaver<LineHeightStyle.Trim, Object> LineHeightStyleTrimSaver = NonNullValueClassSaver(new Function2() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda48
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            Object valueOf;
            SaverScope saverScope = (SaverScope) obj;
            valueOf = Integer.valueOf(((LineHeightStyle.Trim) obj2).m8026unboximpl());
            return valueOf;
        }
    }, new Function1() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda49
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return SaversKt.LineHeightStyleTrimSaver$lambda$1(obj);
        }
    });
    private static final NonNullValueClassSaver<LineHeightStyle.Mode, Object> LineHeightStyleModeSaver = NonNullValueClassSaver(new Function2() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda51
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            Object valueOf;
            SaverScope saverScope = (SaverScope) obj;
            valueOf = Integer.valueOf(((LineHeightStyle.Mode) obj2).m8014unboximpl());
            return valueOf;
        }
    }, new Function1() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda52
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return SaversKt.LineHeightStyleModeSaver$lambda$1(obj);
        }
    });

    /* compiled from: Savers.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AnnotationType.values().length];
            try {
                iArr[AnnotationType.Paragraph.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AnnotationType.Span.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AnnotationType.VerbatimTts.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[AnnotationType.Url.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[AnnotationType.Link.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[AnnotationType.Clickable.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[AnnotationType.String.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private static /* synthetic */ void getAnnotationRangeSaver$annotations() {
    }

    private static /* synthetic */ void getUrlAnnotationSaver$annotations() {
    }

    public static final <T> T save(T t) {
        return t;
    }

    public static final <T extends Saver<Original, Saveable>, Original, Saveable> Object save(Original original, T t, SaverScope saverScope) {
        Object save;
        if (original == null || (save = t.save(saverScope, original)) == null) {
            return false;
        }
        return save;
    }

    public static final /* synthetic */ <T extends Saver<Original, Saveable>, Original, Saveable, Result> Result restore(Saveable saveable, T t) {
        if ((!Intrinsics.areEqual((Object) saveable, (Object) false) || (t instanceof NonNullValueClassSaver)) && saveable != null) {
            Result result = (Result) t.restore(saveable);
            Intrinsics.reifiedOperationMarker(1, "Result");
            return result;
        }
        return null;
    }

    private static final <Original, Saveable> NonNullValueClassSaver<Original, Saveable> NonNullValueClassSaver(final Function2<? super SaverScope, ? super Original, ? extends Saveable> function2, final Function1<? super Saveable, ? extends Original> function1) {
        return new NonNullValueClassSaver<Original, Saveable>() { // from class: androidx.compose.ui.text.SaversKt$NonNullValueClassSaver$1
            @Override // androidx.compose.runtime.saveable.Saver
            public Saveable save(SaverScope saverScope, Original original) {
                return function2.invoke(saverScope, original);
            }

            @Override // androidx.compose.runtime.saveable.Saver
            public Original restore(Saveable saveable) {
                return function1.invoke(saveable);
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ <Result> Result restore(Object obj) {
        if (obj != 0) {
            Intrinsics.reifiedOperationMarker(1, "Result");
            return obj;
        }
        return null;
    }

    public static final Saver<AnnotatedString, Object> getAnnotatedStringSaver() {
        return AnnotatedStringSaver;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final AnnotatedString AnnotatedStringSaver$lambda$1(Object obj) {
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
        List list = (List) obj;
        Object obj2 = list.get(1);
        Saver<List<AnnotatedString.Range<? extends Object>>, Object> saver = AnnotationRangeListSaver;
        List<AnnotatedString.Range<? extends Object>> restore = ((!Intrinsics.areEqual(obj2, (Object) false) || (saver instanceof NonNullValueClassSaver)) && obj2 != null) ? saver.restore(obj2) : null;
        Object obj3 = list.get(0);
        String str = obj3 != null ? (String) obj3 : null;
        Intrinsics.checkNotNull(str);
        return new AnnotatedString(restore, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final List AnnotationRangeListSaver$lambda$1(Object obj) {
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
        List list = (List) obj;
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Object obj2 = list.get(i);
            ArrayList arrayList2 = arrayList;
            Saver<AnnotatedString.Range<? extends Object>, Object> saver = AnnotationRangeSaver;
            AnnotatedString.Range<? extends Object> range = null;
            if ((!Intrinsics.areEqual(obj2, (Object) false) || (saver instanceof NonNullValueClassSaver)) && obj2 != null) {
                range = saver.restore(obj2);
            }
            Intrinsics.checkNotNull(range);
            arrayList2.add(range);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Object AnnotationRangeSaver$lambda$0(SaverScope saverScope, AnnotatedString.Range range) {
        AnnotationType annotationType;
        Object save;
        Object item = range.getItem();
        if (item instanceof ParagraphStyle) {
            annotationType = AnnotationType.Paragraph;
        } else if (item instanceof SpanStyle) {
            annotationType = AnnotationType.Span;
        } else if (item instanceof VerbatimTtsAnnotation) {
            annotationType = AnnotationType.VerbatimTts;
        } else if (item instanceof UrlAnnotation) {
            annotationType = AnnotationType.Url;
        } else if (item instanceof LinkAnnotation.Url) {
            annotationType = AnnotationType.Link;
        } else if (item instanceof LinkAnnotation.Clickable) {
            annotationType = AnnotationType.Clickable;
        } else if (!(item instanceof StringAnnotation)) {
            throw new UnsupportedOperationException();
        } else {
            annotationType = AnnotationType.String;
        }
        switch (WhenMappings.$EnumSwitchMapping$0[annotationType.ordinal()]) {
            case 1:
                Object item2 = range.getItem();
                Intrinsics.checkNotNull(item2, "null cannot be cast to non-null type androidx.compose.ui.text.ParagraphStyle");
                save = save((ParagraphStyle) item2, ParagraphStyleSaver, saverScope);
                break;
            case 2:
                Object item3 = range.getItem();
                Intrinsics.checkNotNull(item3, "null cannot be cast to non-null type androidx.compose.ui.text.SpanStyle");
                save = save((SpanStyle) item3, SpanStyleSaver, saverScope);
                break;
            case 3:
                Object item4 = range.getItem();
                Intrinsics.checkNotNull(item4, "null cannot be cast to non-null type androidx.compose.ui.text.VerbatimTtsAnnotation");
                save = save((VerbatimTtsAnnotation) item4, VerbatimTtsAnnotationSaver, saverScope);
                break;
            case 4:
                Object item5 = range.getItem();
                Intrinsics.checkNotNull(item5, "null cannot be cast to non-null type androidx.compose.ui.text.UrlAnnotation");
                save = save((UrlAnnotation) item5, UrlAnnotationSaver, saverScope);
                break;
            case 5:
                Object item6 = range.getItem();
                Intrinsics.checkNotNull(item6, "null cannot be cast to non-null type androidx.compose.ui.text.LinkAnnotation.Url");
                save = save((LinkAnnotation.Url) item6, LinkSaver, saverScope);
                break;
            case 6:
                Object item7 = range.getItem();
                Intrinsics.checkNotNull(item7, "null cannot be cast to non-null type androidx.compose.ui.text.LinkAnnotation.Clickable");
                save = save((LinkAnnotation.Clickable) item7, ClickableSaver, saverScope);
                break;
            case 7:
                Object item8 = range.getItem();
                Intrinsics.checkNotNull(item8, "null cannot be cast to non-null type androidx.compose.ui.text.StringAnnotation");
                save = save(((StringAnnotation) item8).m7562unboximpl());
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        return CollectionsKt.arrayListOf(save(annotationType), save, save(Integer.valueOf(range.getStart())), save(Integer.valueOf(range.getEnd())), save(range.getTag()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final AnnotatedString.Range AnnotationRangeSaver$lambda$1(Object obj) {
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
        List list = (List) obj;
        Object obj2 = list.get(0);
        ParagraphStyle paragraphStyle = null;
        r2 = null;
        LinkAnnotation.Clickable restore = null;
        r2 = null;
        LinkAnnotation.Url restore2 = null;
        r2 = null;
        UrlAnnotation restore3 = null;
        r2 = null;
        VerbatimTtsAnnotation restore4 = null;
        r2 = null;
        SpanStyle restore5 = null;
        paragraphStyle = null;
        AnnotationType annotationType = obj2 != null ? (AnnotationType) obj2 : null;
        Intrinsics.checkNotNull(annotationType);
        Object obj3 = list.get(2);
        Integer num = obj3 != null ? (Integer) obj3 : null;
        Intrinsics.checkNotNull(num);
        int intValue = num.intValue();
        Object obj4 = list.get(3);
        Integer num2 = obj4 != null ? (Integer) obj4 : null;
        Intrinsics.checkNotNull(num2);
        int intValue2 = num2.intValue();
        Object obj5 = list.get(4);
        String str = obj5 != null ? (String) obj5 : null;
        Intrinsics.checkNotNull(str);
        switch (WhenMappings.$EnumSwitchMapping$0[annotationType.ordinal()]) {
            case 1:
                Object obj6 = list.get(1);
                Saver<ParagraphStyle, Object> saver = ParagraphStyleSaver;
                if ((!Intrinsics.areEqual(obj6, (Object) false) || (saver instanceof NonNullValueClassSaver)) && obj6 != null) {
                    paragraphStyle = saver.restore(obj6);
                }
                Intrinsics.checkNotNull(paragraphStyle);
                return new AnnotatedString.Range(paragraphStyle, intValue, intValue2, str);
            case 2:
                Object obj7 = list.get(1);
                Saver<SpanStyle, Object> saver2 = SpanStyleSaver;
                if ((!Intrinsics.areEqual(obj7, (Object) false) || (saver2 instanceof NonNullValueClassSaver)) && obj7 != null) {
                    restore5 = saver2.restore(obj7);
                }
                Intrinsics.checkNotNull(restore5);
                return new AnnotatedString.Range(restore5, intValue, intValue2, str);
            case 3:
                Object obj8 = list.get(1);
                Saver<VerbatimTtsAnnotation, Object> saver3 = VerbatimTtsAnnotationSaver;
                if ((!Intrinsics.areEqual(obj8, (Object) false) || (saver3 instanceof NonNullValueClassSaver)) && obj8 != null) {
                    restore4 = saver3.restore(obj8);
                }
                Intrinsics.checkNotNull(restore4);
                return new AnnotatedString.Range(restore4, intValue, intValue2, str);
            case 4:
                Object obj9 = list.get(1);
                Saver<UrlAnnotation, Object> saver4 = UrlAnnotationSaver;
                if ((!Intrinsics.areEqual(obj9, (Object) false) || (saver4 instanceof NonNullValueClassSaver)) && obj9 != null) {
                    restore3 = saver4.restore(obj9);
                }
                Intrinsics.checkNotNull(restore3);
                return new AnnotatedString.Range(restore3, intValue, intValue2, str);
            case 5:
                Object obj10 = list.get(1);
                Saver<LinkAnnotation.Url, Object> saver5 = LinkSaver;
                if ((!Intrinsics.areEqual(obj10, (Object) false) || (saver5 instanceof NonNullValueClassSaver)) && obj10 != null) {
                    restore2 = saver5.restore(obj10);
                }
                Intrinsics.checkNotNull(restore2);
                return new AnnotatedString.Range(restore2, intValue, intValue2, str);
            case 6:
                Object obj11 = list.get(1);
                Saver<LinkAnnotation.Clickable, Object> saver6 = ClickableSaver;
                if ((!Intrinsics.areEqual(obj11, (Object) false) || (saver6 instanceof NonNullValueClassSaver)) && obj11 != null) {
                    restore = saver6.restore(obj11);
                }
                Intrinsics.checkNotNull(restore);
                return new AnnotatedString.Range(restore, intValue, intValue2, str);
            case 7:
                Object obj12 = list.get(1);
                String str2 = obj12 != null ? (String) obj12 : null;
                Intrinsics.checkNotNull(str2);
                return new AnnotatedString.Range(StringAnnotation.m7556boximpl(StringAnnotation.m7557constructorimpl(str2)), intValue, intValue2, str);
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final VerbatimTtsAnnotation VerbatimTtsAnnotationSaver$lambda$1(Object obj) {
        String str = obj != null ? (String) obj : null;
        Intrinsics.checkNotNull(str);
        return new VerbatimTtsAnnotation(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final UrlAnnotation UrlAnnotationSaver$lambda$1(Object obj) {
        String str = obj != null ? (String) obj : null;
        Intrinsics.checkNotNull(str);
        return new UrlAnnotation(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final LinkAnnotation.Url LinkSaver$lambda$1(Object obj) {
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
        List list = (List) obj;
        Object obj2 = list.get(0);
        TextLinkStyles textLinkStyles = null;
        String str = obj2 != null ? (String) obj2 : null;
        Intrinsics.checkNotNull(str);
        Object obj3 = list.get(1);
        Saver<TextLinkStyles, Object> saver = TextLinkStylesSaver;
        if ((!Intrinsics.areEqual(obj3, (Object) false) || (saver instanceof NonNullValueClassSaver)) && obj3 != null) {
            textLinkStyles = saver.restore(obj3);
        }
        return new LinkAnnotation.Url(str, textLinkStyles, null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final LinkAnnotation.Clickable ClickableSaver$lambda$1(Object obj) {
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
        List list = (List) obj;
        Object obj2 = list.get(0);
        String str = obj2 != null ? (String) obj2 : null;
        Intrinsics.checkNotNull(str);
        Object obj3 = list.get(1);
        Saver<TextLinkStyles, Object> saver = TextLinkStylesSaver;
        return new LinkAnnotation.Clickable(str, ((!Intrinsics.areEqual(obj3, (Object) false) || (saver instanceof NonNullValueClassSaver)) && obj3 != null) ? saver.restore(obj3) : null, null);
    }

    public static final Saver<ParagraphStyle, Object> getParagraphStyleSaver() {
        return ParagraphStyleSaver;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final ParagraphStyle ParagraphStyleSaver$lambda$1(Object obj) {
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
        List list = (List) obj;
        Object obj2 = list.get(0);
        Saver<TextAlign, Object> saver = getSaver(TextAlign.Companion);
        TextMotion textMotion = null;
        TextAlign restore = ((!Intrinsics.areEqual(obj2, (Object) false) || (saver instanceof NonNullValueClassSaver)) && obj2 != null) ? saver.restore(obj2) : null;
        Intrinsics.checkNotNull(restore);
        int m8037unboximpl = restore.m8037unboximpl();
        Object obj3 = list.get(1);
        Saver<TextDirection, Object> saver2 = getSaver(TextDirection.Companion);
        TextDirection restore2 = ((!Intrinsics.areEqual(obj3, (Object) false) || (saver2 instanceof NonNullValueClassSaver)) && obj3 != null) ? saver2.restore(obj3) : null;
        Intrinsics.checkNotNull(restore2);
        int m8054unboximpl = restore2.m8054unboximpl();
        Object obj4 = list.get(2);
        Saver<TextUnit, Object> saver3 = getSaver(TextUnit.Companion);
        TextUnit restore3 = ((!Intrinsics.areEqual(obj4, (Object) false) || (saver3 instanceof NonNullValueClassSaver)) && obj4 != null) ? saver3.restore(obj4) : null;
        Intrinsics.checkNotNull(restore3);
        long m8363unboximpl = restore3.m8363unboximpl();
        Object obj5 = list.get(3);
        Saver<TextIndent, Object> saver4 = getSaver(TextIndent.Companion);
        TextIndent restore4 = ((!Intrinsics.areEqual(obj5, (Object) false) || (saver4 instanceof NonNullValueClassSaver)) && obj5 != null) ? saver4.restore(obj5) : null;
        Object obj6 = list.get(4);
        Saver<PlatformParagraphStyle, Object> saver5 = Savers_androidKt.getSaver(PlatformParagraphStyle.Companion);
        PlatformParagraphStyle restore5 = ((!Intrinsics.areEqual(obj6, (Object) false) || (saver5 instanceof NonNullValueClassSaver)) && obj6 != null) ? saver5.restore(obj6) : null;
        Object obj7 = list.get(5);
        Saver<LineHeightStyle, Object> saver6 = getSaver(LineHeightStyle.Companion);
        LineHeightStyle restore6 = ((!Intrinsics.areEqual(obj7, (Object) false) || (saver6 instanceof NonNullValueClassSaver)) && obj7 != null) ? saver6.restore(obj7) : null;
        Object obj8 = list.get(6);
        Saver<LineBreak, Object> saver7 = Savers_androidKt.getSaver(LineBreak.Companion);
        LineBreak restore7 = ((!Intrinsics.areEqual(obj8, (Object) false) || (saver7 instanceof NonNullValueClassSaver)) && obj8 != null) ? saver7.restore(obj8) : null;
        Intrinsics.checkNotNull(restore7);
        int m7948unboximpl = restore7.m7948unboximpl();
        Object obj9 = list.get(7);
        Saver<Hyphens, Object> saver8 = getSaver(Hyphens.Companion);
        Hyphens restore8 = ((!Intrinsics.areEqual(obj9, (Object) false) || (saver8 instanceof NonNullValueClassSaver)) && obj9 != null) ? saver8.restore(obj9) : null;
        Intrinsics.checkNotNull(restore8);
        int m7929unboximpl = restore8.m7929unboximpl();
        Object obj10 = list.get(8);
        Saver<TextMotion, Object> saver9 = Savers_androidKt.getSaver(TextMotion.Companion);
        if ((!Intrinsics.areEqual(obj10, (Object) false) || (saver9 instanceof NonNullValueClassSaver)) && obj10 != null) {
            textMotion = saver9.restore(obj10);
        }
        return new ParagraphStyle(m8037unboximpl, m8054unboximpl, m8363unboximpl, restore4, restore5, restore6, m7948unboximpl, m7929unboximpl, textMotion, (DefaultConstructorMarker) null);
    }

    public static final Saver<SpanStyle, Object> getSpanStyleSaver() {
        return SpanStyleSaver;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0126, code lost:
        if ((r15 instanceof androidx.compose.ui.text.NonNullValueClassSaver) == false) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x014c, code lost:
        if ((r15 instanceof androidx.compose.ui.text.NonNullValueClassSaver) == false) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0172, code lost:
        if ((r2 instanceof androidx.compose.ui.text.NonNullValueClassSaver) == false) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x019e, code lost:
        if ((r5 instanceof androidx.compose.ui.text.NonNullValueClassSaver) == false) goto L73;
     */
    /* JADX WARN: Removed duplicated region for block: B:100:0x01bf  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01a5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final SpanStyle SpanStyleSaver$lambda$1(Object obj) {
        SpanStyle spanStyle;
        SpanStyle spanStyle2;
        TextGeometricTransform textGeometricTransform;
        Object obj2;
        FontWeight fontWeight;
        LocaleList localeList;
        Object obj3;
        long j;
        Color color;
        Object obj4;
        long j2;
        TextDecoration textDecoration;
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
        List list = (List) obj;
        Object obj5 = list.get(0);
        Saver<Color, Object> saver = getSaver(Color.Companion);
        Color restore = ((!Intrinsics.areEqual(obj5, (Object) false) || (saver instanceof NonNullValueClassSaver)) && obj5 != null) ? saver.restore(obj5) : null;
        Intrinsics.checkNotNull(restore);
        long m5358unboximpl = restore.m5358unboximpl();
        Object obj6 = list.get(1);
        Saver<TextUnit, Object> saver2 = getSaver(TextUnit.Companion);
        TextUnit restore2 = ((!Intrinsics.areEqual(obj6, (Object) false) || (saver2 instanceof NonNullValueClassSaver)) && obj6 != null) ? saver2.restore(obj6) : null;
        Intrinsics.checkNotNull(restore2);
        long m8363unboximpl = restore2.m8363unboximpl();
        Object obj7 = list.get(2);
        Saver<FontWeight, Object> saver3 = getSaver(FontWeight.Companion);
        FontWeight restore3 = ((!Intrinsics.areEqual(obj7, (Object) false) || (saver3 instanceof NonNullValueClassSaver)) && obj7 != null) ? saver3.restore(obj7) : null;
        Object obj8 = list.get(3);
        Saver<FontStyle, Object> saver4 = getSaver(FontStyle.Companion);
        FontStyle restore4 = ((!Intrinsics.areEqual(obj8, (Object) false) || (saver4 instanceof NonNullValueClassSaver)) && obj8 != null) ? saver4.restore(obj8) : null;
        Object obj9 = list.get(4);
        Saver<FontSynthesis, Object> saver5 = getSaver(FontSynthesis.Companion);
        FontSynthesis restore5 = ((!Intrinsics.areEqual(obj9, (Object) false) || (saver5 instanceof NonNullValueClassSaver)) && obj9 != null) ? saver5.restore(obj9) : null;
        Object obj10 = list.get(6);
        String str = obj10 != null ? (String) obj10 : null;
        Object obj11 = list.get(7);
        Saver<TextUnit, Object> saver6 = getSaver(TextUnit.Companion);
        TextUnit restore6 = ((!Intrinsics.areEqual(obj11, (Object) false) || (saver6 instanceof NonNullValueClassSaver)) && obj11 != null) ? saver6.restore(obj11) : null;
        Intrinsics.checkNotNull(restore6);
        long m8363unboximpl2 = restore6.m8363unboximpl();
        Object obj12 = list.get(8);
        Saver<BaselineShift, Object> saver7 = getSaver(BaselineShift.Companion);
        BaselineShift restore7 = ((!Intrinsics.areEqual(obj12, (Object) false) || (saver7 instanceof NonNullValueClassSaver)) && obj12 != null) ? saver7.restore(obj12) : null;
        Object obj13 = list.get(9);
        Saver<TextGeometricTransform, Object> saver8 = getSaver(TextGeometricTransform.Companion);
        if (Intrinsics.areEqual(obj13, (Object) false)) {
            spanStyle2 = spanStyle;
        } else {
            spanStyle2 = spanStyle;
        }
        if (obj13 != null) {
            textGeometricTransform = saver8.restore(obj13);
            obj2 = list.get(10);
            Saver<LocaleList, Object> saver9 = getSaver(LocaleList.Companion);
            if (Intrinsics.areEqual(obj2, (Object) false)) {
                fontWeight = restore3;
            } else {
                fontWeight = restore3;
            }
            if (obj2 != null) {
                localeList = saver9.restore(obj2);
                obj3 = list.get(11);
                Saver<Color, Object> saver10 = getSaver(Color.Companion);
                if (Intrinsics.areEqual(obj3, (Object) false)) {
                    j = m5358unboximpl;
                } else {
                    j = m5358unboximpl;
                }
                if (obj3 != null) {
                    color = saver10.restore(obj3);
                    Intrinsics.checkNotNull(color);
                    long m5358unboximpl2 = color.m5358unboximpl();
                    obj4 = list.get(12);
                    Saver<TextDecoration, Object> saver11 = getSaver(TextDecoration.Companion);
                    if (Intrinsics.areEqual(obj4, (Object) false)) {
                        j2 = m5358unboximpl2;
                    } else {
                        j2 = m5358unboximpl2;
                    }
                    if (obj4 != null) {
                        textDecoration = saver11.restore(obj4);
                        Object obj14 = list.get(13);
                        Saver<Shadow, Object> saver12 = getSaver(Shadow.Companion);
                        return new SpanStyle(j, m8363unboximpl, fontWeight, restore4, restore5, (FontFamily) null, str, m8363unboximpl2, restore7, textGeometricTransform, localeList, j2, textDecoration, ((Intrinsics.areEqual(obj14, (Object) false) || (saver12 instanceof NonNullValueClassSaver)) && obj14 != null) ? saver12.restore(obj14) : null, (PlatformSpanStyle) null, (DrawStyle) null, 49184, (DefaultConstructorMarker) null);
                    }
                    textDecoration = null;
                    Object obj142 = list.get(13);
                    Saver<Shadow, Object> saver122 = getSaver(Shadow.Companion);
                    if (Intrinsics.areEqual(obj142, (Object) false)) {
                    }
                    return new SpanStyle(j, m8363unboximpl, fontWeight, restore4, restore5, (FontFamily) null, str, m8363unboximpl2, restore7, textGeometricTransform, localeList, j2, textDecoration, ((Intrinsics.areEqual(obj142, (Object) false) || (saver122 instanceof NonNullValueClassSaver)) && obj142 != null) ? saver122.restore(obj142) : null, (PlatformSpanStyle) null, (DrawStyle) null, 49184, (DefaultConstructorMarker) null);
                }
                color = null;
                Intrinsics.checkNotNull(color);
                long m5358unboximpl22 = color.m5358unboximpl();
                obj4 = list.get(12);
                Saver<TextDecoration, Object> saver112 = getSaver(TextDecoration.Companion);
                if (Intrinsics.areEqual(obj4, (Object) false)) {
                }
                if (obj4 != null) {
                }
                textDecoration = null;
                Object obj1422 = list.get(13);
                Saver<Shadow, Object> saver1222 = getSaver(Shadow.Companion);
                if (Intrinsics.areEqual(obj1422, (Object) false)) {
                }
                return new SpanStyle(j, m8363unboximpl, fontWeight, restore4, restore5, (FontFamily) null, str, m8363unboximpl2, restore7, textGeometricTransform, localeList, j2, textDecoration, ((Intrinsics.areEqual(obj1422, (Object) false) || (saver1222 instanceof NonNullValueClassSaver)) && obj1422 != null) ? saver1222.restore(obj1422) : null, (PlatformSpanStyle) null, (DrawStyle) null, 49184, (DefaultConstructorMarker) null);
            }
            localeList = null;
            obj3 = list.get(11);
            Saver<Color, Object> saver102 = getSaver(Color.Companion);
            if (Intrinsics.areEqual(obj3, (Object) false)) {
            }
            if (obj3 != null) {
            }
            color = null;
            Intrinsics.checkNotNull(color);
            long m5358unboximpl222 = color.m5358unboximpl();
            obj4 = list.get(12);
            Saver<TextDecoration, Object> saver1122 = getSaver(TextDecoration.Companion);
            if (Intrinsics.areEqual(obj4, (Object) false)) {
            }
            if (obj4 != null) {
            }
            textDecoration = null;
            Object obj14222 = list.get(13);
            Saver<Shadow, Object> saver12222 = getSaver(Shadow.Companion);
            if (Intrinsics.areEqual(obj14222, (Object) false)) {
            }
            return new SpanStyle(j, m8363unboximpl, fontWeight, restore4, restore5, (FontFamily) null, str, m8363unboximpl2, restore7, textGeometricTransform, localeList, j2, textDecoration, ((Intrinsics.areEqual(obj14222, (Object) false) || (saver12222 instanceof NonNullValueClassSaver)) && obj14222 != null) ? saver12222.restore(obj14222) : null, (PlatformSpanStyle) null, (DrawStyle) null, 49184, (DefaultConstructorMarker) null);
        }
        textGeometricTransform = null;
        obj2 = list.get(10);
        Saver<LocaleList, Object> saver92 = getSaver(LocaleList.Companion);
        if (Intrinsics.areEqual(obj2, (Object) false)) {
        }
        if (obj2 != null) {
        }
        localeList = null;
        obj3 = list.get(11);
        Saver<Color, Object> saver1022 = getSaver(Color.Companion);
        if (Intrinsics.areEqual(obj3, (Object) false)) {
        }
        if (obj3 != null) {
        }
        color = null;
        Intrinsics.checkNotNull(color);
        long m5358unboximpl2222 = color.m5358unboximpl();
        obj4 = list.get(12);
        Saver<TextDecoration, Object> saver11222 = getSaver(TextDecoration.Companion);
        if (Intrinsics.areEqual(obj4, (Object) false)) {
        }
        if (obj4 != null) {
        }
        textDecoration = null;
        Object obj142222 = list.get(13);
        Saver<Shadow, Object> saver122222 = getSaver(Shadow.Companion);
        if (Intrinsics.areEqual(obj142222, (Object) false)) {
        }
        return new SpanStyle(j, m8363unboximpl, fontWeight, restore4, restore5, (FontFamily) null, str, m8363unboximpl2, restore7, textGeometricTransform, localeList, j2, textDecoration, ((Intrinsics.areEqual(obj142222, (Object) false) || (saver122222 instanceof NonNullValueClassSaver)) && obj142222 != null) ? saver122222.restore(obj142222) : null, (PlatformSpanStyle) null, (DrawStyle) null, 49184, (DefaultConstructorMarker) null);
    }

    public static final Saver<TextLinkStyles, Object> getTextLinkStylesSaver() {
        return TextLinkStylesSaver;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Object TextLinkStylesSaver$lambda$0(SaverScope saverScope, TextLinkStyles textLinkStyles) {
        SpanStyle style = textLinkStyles.getStyle();
        Saver<SpanStyle, Object> saver = SpanStyleSaver;
        return CollectionsKt.arrayListOf(save(style, saver, saverScope), save(textLinkStyles.getFocusedStyle(), saver, saverScope), save(textLinkStyles.getHoveredStyle(), saver, saverScope), save(textLinkStyles.getPressedStyle(), saver, saverScope));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final TextLinkStyles TextLinkStylesSaver$lambda$1(Object obj) {
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
        List list = (List) obj;
        Object obj2 = list.get(0);
        Saver<SpanStyle, Object> saver = SpanStyleSaver;
        SpanStyle spanStyle = null;
        SpanStyle restore = ((!Intrinsics.areEqual(obj2, (Object) false) || (saver instanceof NonNullValueClassSaver)) && obj2 != null) ? saver.restore(obj2) : null;
        Object obj3 = list.get(1);
        SpanStyle restore2 = ((!Intrinsics.areEqual(obj3, (Object) false) || (saver instanceof NonNullValueClassSaver)) && obj3 != null) ? saver.restore(obj3) : null;
        Object obj4 = list.get(2);
        SpanStyle restore3 = ((!Intrinsics.areEqual(obj4, (Object) false) || (saver instanceof NonNullValueClassSaver)) && obj4 != null) ? saver.restore(obj4) : null;
        Object obj5 = list.get(3);
        if ((!Intrinsics.areEqual(obj5, (Object) false) || (saver instanceof NonNullValueClassSaver)) && obj5 != null) {
            spanStyle = saver.restore(obj5);
        }
        return new TextLinkStyles(restore, restore2, restore3, spanStyle);
    }

    public static final Saver<TextDecoration, Object> getSaver(TextDecoration.Companion companion) {
        return TextDecorationSaver;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final TextDecoration TextDecorationSaver$lambda$1(Object obj) {
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
        return new TextDecoration(((Integer) obj).intValue());
    }

    public static final Saver<TextGeometricTransform, Object> getSaver(TextGeometricTransform.Companion companion) {
        return TextGeometricTransformSaver;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final TextGeometricTransform TextGeometricTransformSaver$lambda$1(Object obj) {
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Float>");
        List list = (List) obj;
        return new TextGeometricTransform(((Number) list.get(0)).floatValue(), ((Number) list.get(1)).floatValue());
    }

    public static final Saver<TextIndent, Object> getSaver(TextIndent.Companion companion) {
        return TextIndentSaver;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final TextIndent TextIndentSaver$lambda$1(Object obj) {
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
        List list = (List) obj;
        Object obj2 = list.get(0);
        Saver<TextUnit, Object> saver = getSaver(TextUnit.Companion);
        TextUnit textUnit = null;
        TextUnit restore = ((!Intrinsics.areEqual(obj2, (Object) false) || (saver instanceof NonNullValueClassSaver)) && obj2 != null) ? saver.restore(obj2) : null;
        Intrinsics.checkNotNull(restore);
        long m8363unboximpl = restore.m8363unboximpl();
        Object obj3 = list.get(1);
        Saver<TextUnit, Object> saver2 = getSaver(TextUnit.Companion);
        if ((!Intrinsics.areEqual(obj3, (Object) false) || (saver2 instanceof NonNullValueClassSaver)) && obj3 != null) {
            textUnit = saver2.restore(obj3);
        }
        Intrinsics.checkNotNull(textUnit);
        return new TextIndent(m8363unboximpl, textUnit.m8363unboximpl(), null);
    }

    public static final Saver<FontWeight, Object> getSaver(FontWeight.Companion companion) {
        return FontWeightSaver;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final FontWeight FontWeightSaver$lambda$1(Object obj) {
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
        return new FontWeight(((Integer) obj).intValue());
    }

    public static final Saver<BaselineShift, Object> getSaver(BaselineShift.Companion companion) {
        return BaselineShiftSaver;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final BaselineShift BaselineShiftSaver$lambda$1(Object obj) {
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Float");
        return BaselineShift.m7900boximpl(BaselineShift.m7901constructorimpl(((Float) obj).floatValue()));
    }

    public static final Saver<TextRange, Object> getSaver(TextRange.Companion companion) {
        return TextRangeSaver;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final TextRange TextRangeSaver$lambda$1(Object obj) {
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
        List list = (List) obj;
        Object obj2 = list.get(0);
        Integer num = obj2 != null ? (Integer) obj2 : null;
        Intrinsics.checkNotNull(num);
        int intValue = num.intValue();
        Object obj3 = list.get(1);
        Integer num2 = obj3 != null ? (Integer) obj3 : null;
        Intrinsics.checkNotNull(num2);
        return TextRange.m7596boximpl(TextRangeKt.TextRange(intValue, num2.intValue()));
    }

    public static final Saver<Shadow, Object> getSaver(Shadow.Companion companion) {
        return ShadowSaver;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Shadow ShadowSaver$lambda$1(Object obj) {
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
        List list = (List) obj;
        Object obj2 = list.get(0);
        Saver<Color, Object> saver = getSaver(Color.Companion);
        Color restore = ((!Intrinsics.areEqual(obj2, (Object) false) || (saver instanceof NonNullValueClassSaver)) && obj2 != null) ? saver.restore(obj2) : null;
        Intrinsics.checkNotNull(restore);
        long m5358unboximpl = restore.m5358unboximpl();
        Object obj3 = list.get(1);
        Saver<Offset, Object> saver2 = getSaver(Offset.Companion);
        Offset restore2 = ((!Intrinsics.areEqual(obj3, (Object) false) || (saver2 instanceof NonNullValueClassSaver)) && obj3 != null) ? saver2.restore(obj3) : null;
        Intrinsics.checkNotNull(restore2);
        long m5113unboximpl = restore2.m5113unboximpl();
        Object obj4 = list.get(2);
        Float f = obj4 != null ? (Float) obj4 : null;
        Intrinsics.checkNotNull(f);
        return new Shadow(m5358unboximpl, m5113unboximpl, f.floatValue(), null);
    }

    public static final Saver<Color, Object> getSaver(Color.Companion companion) {
        return ColorSaver;
    }

    public static final Saver<TextAlign, Object> getSaver(TextAlign.Companion companion) {
        return TextAlignSaver;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final TextAlign TextAlignSaver$lambda$1(Object obj) {
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
        return TextAlign.m8031boximpl(TextAlign.m8032constructorimpl(((Integer) obj).intValue()));
    }

    public static final Saver<TextDirection, Object> getSaver(TextDirection.Companion companion) {
        return TextDirectionSaver;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final TextDirection TextDirectionSaver$lambda$1(Object obj) {
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
        return TextDirection.m8048boximpl(TextDirection.m8049constructorimpl(((Integer) obj).intValue()));
    }

    public static final Saver<Hyphens, Object> getSaver(Hyphens.Companion companion) {
        return HyphensSaver;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Hyphens HyphensSaver$lambda$1(Object obj) {
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
        return Hyphens.m7923boximpl(Hyphens.m7924constructorimpl(((Integer) obj).intValue()));
    }

    public static final Saver<FontStyle, Object> getSaver(FontStyle.Companion companion) {
        return FontStyleSaver;
    }

    public static final Saver<FontStyle, Object> getFontStyleSaver() {
        return FontStyleSaver;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final FontStyle FontStyleSaver$lambda$1(Object obj) {
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
        return FontStyle.m7717boximpl(FontStyle.m7718constructorimpl(((Integer) obj).intValue()));
    }

    public static final Saver<FontSynthesis, Object> getSaver(FontSynthesis.Companion companion) {
        return FontSynthesisSaver;
    }

    public static final Saver<FontSynthesis, Object> getFontSynthesisSaver() {
        return FontSynthesisSaver;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final FontSynthesis FontSynthesisSaver$lambda$1(Object obj) {
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
        return FontSynthesis.m7728boximpl(FontSynthesis.m7729constructorimpl(((Integer) obj).intValue()));
    }

    public static final Saver<TextUnit, Object> getSaver(TextUnit.Companion companion) {
        return TextUnitSaver;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Object TextUnitSaver$lambda$0(SaverScope saverScope, TextUnit textUnit) {
        if (textUnit == null ? false : TextUnit.m8351equalsimpl0(textUnit.m8363unboximpl(), TextUnit.Companion.m8365getUnspecifiedXSAIIZE())) {
            return (Serializable) false;
        }
        return CollectionsKt.arrayListOf(save(Float.valueOf(TextUnit.m8354getValueimpl(textUnit.m8363unboximpl()))), save(TextUnitType.m8379boximpl(TextUnit.m8353getTypeUIouoOA(textUnit.m8363unboximpl())), getSaver(TextUnitType.Companion), saverScope));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final TextUnit TextUnitSaver$lambda$1(Object obj) {
        if (Intrinsics.areEqual(obj, (Object) false)) {
            return TextUnit.m8344boximpl(TextUnit.Companion.m8365getUnspecifiedXSAIIZE());
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
        List list = (List) obj;
        Object obj2 = list.get(0);
        TextUnitType textUnitType = null;
        Float f = obj2 != null ? (Float) obj2 : null;
        Intrinsics.checkNotNull(f);
        float floatValue = f.floatValue();
        Object obj3 = list.get(1);
        Saver<TextUnitType, Object> saver = getSaver(TextUnitType.Companion);
        if ((!Intrinsics.areEqual(obj3, (Object) false) || (saver instanceof NonNullValueClassSaver)) && obj3 != null) {
            textUnitType = saver.restore(obj3);
        }
        Intrinsics.checkNotNull(textUnitType);
        return TextUnit.m8344boximpl(TextUnitKt.m8366TextUnitanM5pPY(floatValue, textUnitType.m8385unboximpl()));
    }

    public static final Saver<TextUnitType, Object> getSaver(TextUnitType.Companion companion) {
        return TextUnitTypeSaver;
    }

    public static final NonNullValueClassSaver<TextUnitType, Object> getTextUnitTypeSaver() {
        return TextUnitTypeSaver;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Object TextUnitTypeSaver$lambda$0(SaverScope saverScope, TextUnitType textUnitType) {
        long m8385unboximpl = textUnitType.m8385unboximpl();
        if (TextUnitType.m8382equalsimpl0(m8385unboximpl, TextUnitType.Companion.m8386getEmUIouoOA())) {
            return 0;
        }
        return TextUnitType.m8382equalsimpl0(m8385unboximpl, TextUnitType.Companion.m8387getSpUIouoOA()) ? 1 : false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final TextUnitType TextUnitTypeSaver$lambda$1(Object obj) {
        return Intrinsics.areEqual(obj, (Object) 0) ? TextUnitType.m8379boximpl(TextUnitType.Companion.m8386getEmUIouoOA()) : Intrinsics.areEqual(obj, (Object) 1) ? TextUnitType.m8379boximpl(TextUnitType.Companion.m8387getSpUIouoOA()) : TextUnitType.m8379boximpl(TextUnitType.Companion.m8388getUnspecifiedUIouoOA());
    }

    public static final Saver<Offset, Object> getSaver(Offset.Companion companion) {
        return OffsetSaver;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Object OffsetSaver$lambda$0(SaverScope saverScope, Offset offset) {
        return offset == null ? false : Offset.m5100equalsimpl0(offset.m5113unboximpl(), Offset.Companion.m5118getUnspecifiedF1C5BW0()) ? (Serializable) false : CollectionsKt.arrayListOf(save(Float.valueOf(Float.intBitsToFloat((int) (offset.m5113unboximpl() >> 32)))), save(Float.valueOf(Float.intBitsToFloat((int) (offset.m5113unboximpl() & 4294967295L)))));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Offset OffsetSaver$lambda$1(Object obj) {
        if (Intrinsics.areEqual(obj, (Object) false)) {
            return Offset.m5092boximpl(Offset.Companion.m5118getUnspecifiedF1C5BW0());
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
        List list = (List) obj;
        Object obj2 = list.get(0);
        Float f = obj2 != null ? (Float) obj2 : null;
        Intrinsics.checkNotNull(f);
        float floatValue = f.floatValue();
        Object obj3 = list.get(1);
        Float f2 = obj3 != null ? (Float) obj3 : null;
        Intrinsics.checkNotNull(f2);
        return Offset.m5092boximpl(Offset.m5095constructorimpl((Float.floatToRawIntBits(floatValue) << 32) | (Float.floatToRawIntBits(f2.floatValue()) & 4294967295L)));
    }

    public static final Saver<LocaleList, Object> getSaver(LocaleList.Companion companion) {
        return LocaleListSaver;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Object LocaleListSaver$lambda$0(SaverScope saverScope, LocaleList localeList) {
        List<Locale> localeList2 = localeList.getLocaleList();
        ArrayList arrayList = new ArrayList(localeList2.size());
        int size = localeList2.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(save(localeList2.get(i), getSaver(Locale.Companion), saverScope));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final LocaleList LocaleListSaver$lambda$1(Object obj) {
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
        List list = (List) obj;
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Object obj2 = list.get(i);
            ArrayList arrayList2 = arrayList;
            Saver<Locale, Object> saver = getSaver(Locale.Companion);
            Locale locale = null;
            if ((!Intrinsics.areEqual(obj2, (Object) false) || (saver instanceof NonNullValueClassSaver)) && obj2 != null) {
                locale = saver.restore(obj2);
            }
            Intrinsics.checkNotNull(locale);
            arrayList2.add(locale);
        }
        return new LocaleList(arrayList);
    }

    public static final Saver<Locale, Object> getSaver(Locale.Companion companion) {
        return LocaleSaver;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Locale LocaleSaver$lambda$1(Object obj) {
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
        return new Locale((String) obj);
    }

    public static final Saver<LineHeightStyle, Object> getSaver(LineHeightStyle.Companion companion) {
        return LineHeightStyleSaver;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final LineHeightStyle LineHeightStyleSaver$lambda$1(Object obj) {
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
        List list = (List) obj;
        Object obj2 = list.get(0);
        Saver<LineHeightStyle.Alignment, Object> saver = getSaver(LineHeightStyle.Alignment.Companion);
        LineHeightStyle.Alignment restore = ((!Intrinsics.areEqual(obj2, (Object) false) || (saver instanceof NonNullValueClassSaver)) && obj2 != null) ? saver.restore(obj2) : null;
        Intrinsics.checkNotNull(restore);
        float m8003unboximpl = restore.m8003unboximpl();
        Object obj3 = list.get(1);
        Saver<LineHeightStyle.Trim, Object> saver2 = getSaver(LineHeightStyle.Trim.Companion);
        LineHeightStyle.Trim restore2 = ((!Intrinsics.areEqual(obj3, (Object) false) || (saver2 instanceof NonNullValueClassSaver)) && obj3 != null) ? saver2.restore(obj3) : null;
        Intrinsics.checkNotNull(restore2);
        int m8026unboximpl = restore2.m8026unboximpl();
        Object obj4 = list.get(2);
        Saver<LineHeightStyle.Mode, Object> saver3 = getSaver(LineHeightStyle.Mode.Companion);
        LineHeightStyle.Mode restore3 = ((!Intrinsics.areEqual(obj4, (Object) false) || (saver3 instanceof NonNullValueClassSaver)) && obj4 != null) ? saver3.restore(obj4) : null;
        Intrinsics.checkNotNull(restore3);
        return new LineHeightStyle(m8003unboximpl, m8026unboximpl, restore3.m8014unboximpl(), null);
    }

    private static final Saver<LineHeightStyle.Alignment, Object> getSaver(LineHeightStyle.Alignment.Companion companion) {
        return LineHeightStyleAlignmentSaver;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final LineHeightStyle.Alignment LineHeightStyleAlignmentSaver$lambda$1(Object obj) {
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Float");
        return LineHeightStyle.Alignment.m7997boximpl(LineHeightStyle.Alignment.m7998constructorimpl(((Float) obj).floatValue()));
    }

    private static final Saver<LineHeightStyle.Trim, Object> getSaver(LineHeightStyle.Trim.Companion companion) {
        return LineHeightStyleTrimSaver;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final LineHeightStyle.Trim LineHeightStyleTrimSaver$lambda$1(Object obj) {
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
        return LineHeightStyle.Trim.m8018boximpl(LineHeightStyle.Trim.m8019constructorimpl(((Integer) obj).intValue()));
    }

    private static final Saver<LineHeightStyle.Mode, Object> getSaver(LineHeightStyle.Mode.Companion companion) {
        return LineHeightStyleModeSaver;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final LineHeightStyle.Mode LineHeightStyleModeSaver$lambda$1(Object obj) {
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
        return LineHeightStyle.Mode.m8008boximpl(LineHeightStyle.Mode.m8009constructorimpl(((Integer) obj).intValue()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Object AnnotationRangeListSaver$lambda$0(SaverScope saverScope, List list) {
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(save((AnnotatedString.Range) list.get(i), AnnotationRangeSaver, saverScope));
        }
        return arrayList;
    }
}
