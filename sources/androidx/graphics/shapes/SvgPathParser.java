package androidx.graphics.shapes;

import androidx.collection.FloatFloatPair;
import androidx.graphics.shapes.SvgPathParser;
import androidx.media3.exoplayer.upstream.CmcdData;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
/* compiled from: SvgPathParser.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0014\u0018\u0000 &2\u00020\u0001:\u0002&'B\u0015\b\u0002\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0010H\u0002J\u0010\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0010H\u0002J\u0010\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0010H\u0002J\u0010\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0010H\u0002J\u0010\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0010H\u0002J?\u0010\u001b\u001a\u00020\t2\n\u0010\u001c\u001a\u00060\u0003j\u0002`\u00042\n\u0010\u001d\u001a\u00060\u0003j\u0002`\u00042\n\u0010\u001e\u001a\u00060\u0003j\u0002`\u00042\n\u0010\u001f\u001a\u00060\u0003j\u0002`\u0004H\u0002¢\u0006\u0004\b \u0010!J'\u0010\"\u001a\u00020\t2\n\u0010\n\u001a\u00060\u0003j\u0002`\u00042\n\u0010#\u001a\u00060\u0003j\u0002`\u0004H\u0002¢\u0006\u0004\b$\u0010%R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00060\u0003j\u0002`\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u0018\u0010\f\u001a\u00060\u0003j\u0002`\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0011\u001a\u00060\u0003j\u0002`\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u000e¨\u0006("}, d2 = {"Landroidx/graphics/shapes/SvgPathParser;", "", "startPosition", "Landroidx/collection/FloatFloatPair;", "Landroidx/graphics/shapes/Point;", "<init>", "(J)V", "cubics", "", "Landroidx/graphics/shapes/Cubic;", TtmlNode.START, "J", "position", "getPosition-1ufDz9w", "()J", "previousCommand", "Landroidx/graphics/shapes/SvgPathParser$Command;", "reflectedPreviousControlPoint", "getReflectedPreviousControlPoint-1ufDz9w", "parseCommand", "", "command", "parseAtomicCommand", "atomicCommand", "parseLine", "parseCurve", "parseArc", "curveToCubic", "a0", "c0", "c1", "a1", "curveToCubic-ArktYTI", "(JJJJ)Landroidx/graphics/shapes/Cubic;", "lineToCubic", TtmlNode.END, "lineToCubic-ybeJwSQ", "(JJ)Landroidx/graphics/shapes/Cubic;", "Companion", "Command", "graphics-shapes"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SvgPathParser {
    public static final Companion Companion = new Companion(null);
    private final List<Cubic> cubics;
    private Command previousCommand;
    private final long start;

    public /* synthetic */ SvgPathParser(long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(j);
    }

    @JvmStatic
    public static final List<Feature> parseFeatures(String str) {
        return Companion.parseFeatures(str);
    }

    private SvgPathParser(long j) {
        this.cubics = new ArrayList();
        this.start = j;
        this.previousCommand = new Command('I', false, new float[0], 0, 0L, 16, null);
    }

    /* compiled from: SvgPathParser.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u001b\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0000¢\u0006\u0002\b\u000b¨\u0006\f"}, d2 = {"Landroidx/graphics/shapes/SvgPathParser$Companion;", "", "<init>", "()V", "parseFeatures", "", "Landroidx/graphics/shapes/Feature;", "svgPath", "", "parseCubics", "Landroidx/graphics/shapes/Cubic;", "parseCubics$graphics_shapes", "graphics-shapes"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final List<Feature> parseFeatures(String svgPath) {
            Intrinsics.checkNotNullParameter(svgPath, "svgPath");
            List<Cubic> parseCubics$graphics_shapes = parseCubics$graphics_shapes(svgPath);
            Function2 function2 = new Function2() { // from class: androidx.graphics.shapes.SvgPathParser$Companion$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return Boolean.valueOf(SvgPathParser.Companion.parseFeatures$lambda$0((Cubic) obj, (Cubic) obj2));
                }
            };
            int size = parseCubics$graphics_shapes.size();
            int lastIndex = CollectionsKt.getLastIndex(parseCubics$graphics_shapes);
            int i = 0;
            while (true) {
                if (i >= lastIndex) {
                    break;
                }
                int i2 = i + 1;
                if (!((Boolean) function2.invoke(parseCubics$graphics_shapes.get(i), parseCubics$graphics_shapes.get(i2))).booleanValue()) {
                    size = i;
                    break;
                }
                i = i2;
            }
            return PolygonValidator.Companion.fix(RoundedPolygonKt.RoundedPolygon$default(FeatureDetectorKt.detectFeatures(CollectionsKt.take(parseCubics$graphics_shapes, size)), 0.0f, 0.0f, 6, null)).getFeatures();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static final boolean parseFeatures$lambda$0(Cubic first, Cubic second) {
            Intrinsics.checkNotNullParameter(first, "first");
            Intrinsics.checkNotNullParameter(second, "second");
            return Math.abs(second.getAnchor0X() - first.getAnchor1X()) < 1.0E-4f && Math.abs(second.getAnchor0Y() - first.getAnchor1Y()) < 1.0E-4f;
        }

        public final List<Cubic> parseCubics$graphics_shapes(String svgPath) {
            Intrinsics.checkNotNullParameter(svgPath, "svgPath");
            Regex regex = new Regex("(?=[mM])");
            ArrayList<String> arrayList = new ArrayList();
            for (Object obj : regex.split(svgPath, 0)) {
                if (!StringsKt.isBlank((String) obj)) {
                    arrayList.add(obj);
                }
            }
            long m12constructorimpl = FloatFloatPair.m12constructorimpl(0.0f, 0.0f);
            List createListBuilder = CollectionsKt.createListBuilder();
            for (String str : arrayList) {
                Regex regex2 = new Regex("(?=[a-zA-Z])");
                ArrayList arrayList2 = new ArrayList();
                for (Object obj2 : regex2.split(str, 0)) {
                    if (!StringsKt.isBlank((String) obj2)) {
                        arrayList2.add(obj2);
                    }
                }
                ArrayList arrayList3 = arrayList2;
                Command m8743parseHiPawso = Command.Factory.m8743parseHiPawso((String) CollectionsKt.first((List<? extends Object>) arrayList3), m12constructorimpl);
                long m8715plusybeJwSQ = PointKt.m8715plusybeJwSQ(m8743parseHiPawso.m8741getStart1ufDz9w(), FloatFloatPair.m12constructorimpl(m8743parseHiPawso.get(0), m8743parseHiPawso.get(1)));
                SvgPathParser svgPathParser = new SvgPathParser(m8715plusybeJwSQ, null);
                svgPathParser.parseCommand(m8743parseHiPawso.m8737asLineDnnuFBc(m8715plusybeJwSQ));
                for (String str2 : CollectionsKt.drop(arrayList3, 1)) {
                    svgPathParser.parseCommand(Command.Factory.m8743parseHiPawso(str2, svgPathParser.m8733getPosition1ufDz9w()));
                }
                createListBuilder.addAll(svgPathParser.cubics);
                m12constructorimpl = m8715plusybeJwSQ;
            }
            return CollectionsKt.build(createListBuilder);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getPosition-1ufDz9w  reason: not valid java name */
    public final long m8733getPosition1ufDz9w() {
        Cubic cubic = (Cubic) CollectionsKt.lastOrNull((List<? extends Object>) this.cubics);
        return cubic != null ? FloatFloatPair.m12constructorimpl(cubic.getAnchor1X(), cubic.getAnchor1Y()) : this.start;
    }

    /* renamed from: getReflectedPreviousControlPoint-1ufDz9w  reason: not valid java name */
    private final long m8734getReflectedPreviousControlPoint1ufDz9w() {
        return PointKt.m8715plusybeJwSQ(m8733getPosition1ufDz9w(), PointKt.m8714minusybeJwSQ(m8733getPosition1ufDz9w(), FloatFloatPair.m12constructorimpl(((Cubic) CollectionsKt.last((List<? extends Object>) this.cubics)).getControl1X(), ((Cubic) CollectionsKt.last((List<? extends Object>) this.cubics)).getControl1Y())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void parseCommand(Command command) {
        if (command.isCloseCommand()) {
            this.cubics.add(m8735lineToCubicybeJwSQ(m8733getPosition1ufDz9w(), this.start));
            return;
        }
        int lastIndex = ArraysKt.getLastIndex(command.getParameters());
        int paramsCount = command.getParamsCount();
        if (paramsCount <= 0) {
            throw new IllegalArgumentException("Step must be positive, was: " + paramsCount + '.');
        }
        int i = 0;
        int progressionLastElement = ProgressionUtilKt.getProgressionLastElement(0, lastIndex, paramsCount);
        if (progressionLastElement < 0) {
            return;
        }
        while (true) {
            parseAtomicCommand(command.m8738chunkHiPawso(i, m8733getPosition1ufDz9w()));
            if (i == progressionLastElement) {
                return;
            }
            i += paramsCount;
        }
    }

    private final void parseAtomicCommand(Command command) {
        if (command.isLineCommand()) {
            parseLine(command);
        } else if (command.isCurveCommand()) {
            parseCurve(command);
        } else if (command.isArcCommand()) {
            parseArc(command);
        }
        this.previousCommand = command;
    }

    private final void parseLine(Command command) {
        Function1 function1 = new Function1() { // from class: androidx.graphics.shapes.SvgPathParser$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                boolean add;
                add = r0.cubics.add(r0.m8735lineToCubicybeJwSQ(SvgPathParser.this.m8733getPosition1ufDz9w(), ((FloatFloatPair) obj).m20unboximpl()));
                return Boolean.valueOf(add);
            }
        };
        char letter = command.getLetter();
        if (letter == 'h') {
            function1.invoke(FloatFloatPair.m9boximpl(FloatFloatPair.m12constructorimpl(command.x(0), PointKt.m8712getYDnnuFBc(command.m8741getStart1ufDz9w()))));
        } else if (letter == 'l') {
            function1.invoke(FloatFloatPair.m9boximpl(command.m8742xyXgqJiTY(0, 1)));
        } else if (letter != 'v') {
        } else {
            function1.invoke(FloatFloatPair.m9boximpl(FloatFloatPair.m12constructorimpl(PointKt.m8711getXDnnuFBc(command.m8741getStart1ufDz9w()), command.y(0))));
        }
    }

    private final void parseCurve(Command command) {
        Function3 function3 = new Function3() { // from class: androidx.graphics.shapes.SvgPathParser$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                boolean add;
                add = r0.cubics.add(r0.m8732curveToCubicArktYTI(SvgPathParser.this.m8733getPosition1ufDz9w(), ((FloatFloatPair) obj).m20unboximpl(), ((FloatFloatPair) obj2).m20unboximpl(), ((FloatFloatPair) obj3).m20unboximpl()));
                return Boolean.valueOf(add);
            }
        };
        char letter = command.getLetter();
        if (letter == 'c') {
            function3.invoke(FloatFloatPair.m9boximpl(command.m8742xyXgqJiTY(0, 1)), FloatFloatPair.m9boximpl(command.m8742xyXgqJiTY(2, 3)), FloatFloatPair.m9boximpl(command.m8742xyXgqJiTY(4, 5)));
        } else if (letter == 'q') {
            function3.invoke(FloatFloatPair.m9boximpl(command.m8742xyXgqJiTY(0, 1)), FloatFloatPair.m9boximpl(command.m8742xyXgqJiTY(0, 1)), FloatFloatPair.m9boximpl(command.m8742xyXgqJiTY(2, 3)));
        } else if (letter == 's') {
            function3.invoke(FloatFloatPair.m9boximpl(this.previousCommand.isBezierCommand() ? m8734getReflectedPreviousControlPoint1ufDz9w() : m8733getPosition1ufDz9w()), FloatFloatPair.m9boximpl(command.m8742xyXgqJiTY(0, 1)), FloatFloatPair.m9boximpl(command.m8742xyXgqJiTY(2, 3)));
        } else if (letter != 't') {
        } else {
            long m8734getReflectedPreviousControlPoint1ufDz9w = this.previousCommand.isQuadraticCurveCommand() ? m8734getReflectedPreviousControlPoint1ufDz9w() : m8733getPosition1ufDz9w();
            function3.invoke(FloatFloatPair.m9boximpl(m8734getReflectedPreviousControlPoint1ufDz9w), FloatFloatPair.m9boximpl(m8734getReflectedPreviousControlPoint1ufDz9w), FloatFloatPair.m9boximpl(command.m8742xyXgqJiTY(0, 1)));
        }
    }

    private final void parseArc(Command command) {
        long m8742xyXgqJiTY = command.m8742xyXgqJiTY(5, 6);
        this.cubics.addAll(ArcConverter.Companion.arcToCubics(PointKt.m8711getXDnnuFBc(m8733getPosition1ufDz9w()), PointKt.m8712getYDnnuFBc(m8733getPosition1ufDz9w()), PointKt.m8711getXDnnuFBc(m8742xyXgqJiTY), PointKt.m8712getYDnnuFBc(m8742xyXgqJiTY), command.get(0), command.get(1), command.get(2), !(command.get(3) == 0.0f), !(command.get(4) == 0.0f)));
    }

    /* renamed from: curveToCubic-ArktYTI  reason: not valid java name */
    private final Cubic m8732curveToCubicArktYTI(long j, long j2, long j3, long j4) {
        return new Cubic(new float[]{PointKt.m8711getXDnnuFBc(j), PointKt.m8712getYDnnuFBc(j), PointKt.m8711getXDnnuFBc(j2), PointKt.m8712getYDnnuFBc(j2), PointKt.m8711getXDnnuFBc(j3), PointKt.m8712getYDnnuFBc(j3), PointKt.m8711getXDnnuFBc(j4), PointKt.m8712getYDnnuFBc(j4)});
    }

    /* renamed from: lineToCubic-ybeJwSQ  reason: not valid java name */
    private final Cubic m8735lineToCubicybeJwSQ(long j, long j2) {
        return Cubic.Companion.straightLine(PointKt.m8711getXDnnuFBc(j), PointKt.m8712getYDnnuFBc(j), PointKt.m8711getXDnnuFBc(j2), PointKt.m8712getYDnnuFBc(j2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SvgPathParser.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0007\n\u0002\b\u001d\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0082\b\u0018\u0000 ?2\u00020\u0001:\u0001?B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\f\b\u0002\u0010\n\u001a\u00060\u000bj\u0002`\f¢\u0006\u0004\b\r\u0010\u000eJ\u0011\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\tH\u0086\u0002J\u000e\u0010\"\u001a\u00020 2\u0006\u0010!\u001a\u00020\tJ\u000e\u0010#\u001a\u00020 2\u0006\u0010!\u001a\u00020\tJ!\u0010$\u001a\u00060\u000bj\u0002`\f2\u0006\u0010!\u001a\u00020\t2\u0006\u0010%\u001a\u00020\t¢\u0006\u0004\b&\u0010'J!\u0010(\u001a\u00020\u00002\u0006\u0010)\u001a\u00020\t2\n\u0010*\u001a\u00060\u000bj\u0002`\f¢\u0006\u0004\b+\u0010,J\u0019\u0010-\u001a\u00020\u00002\n\u0010.\u001a\u00060\u000bj\u0002`\f¢\u0006\u0004\b/\u00100J\u0013\u00101\u001a\u00020\u00052\b\u00102\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u00103\u001a\u00020\tH\u0016J\t\u00104\u001a\u00020\u0003HÆ\u0003J\t\u00105\u001a\u00020\u0005HÆ\u0003J\t\u00106\u001a\u00020\u0007HÆ\u0003J\t\u00107\u001a\u00020\tHÆ\u0003J\u0014\u00108\u001a\u00060\u000bj\u0002`\fHÆ\u0003¢\u0006\u0004\b9\u0010\u0017JF\u0010:\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\f\b\u0002\u0010\n\u001a\u00060\u000bj\u0002`\fHÆ\u0001¢\u0006\u0004\b;\u0010<J\t\u0010=\u001a\u00020>HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\n\u001a\u00060\u000bj\u0002`\f¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0019\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0011R\u0011\u0010\u001a\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0011R\u0011\u0010\u001b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0011R\u0011\u0010\u001c\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0011R\u0011\u0010\u001d\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0011R\u0011\u0010\u001e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0011¨\u0006@"}, d2 = {"Landroidx/graphics/shapes/SvgPathParser$Command;", "", "letter", "", "isRelative", "", "parameters", "", "paramsCount", "", TtmlNode.START, "Landroidx/collection/FloatFloatPair;", "Landroidx/graphics/shapes/Point;", "<init>", "(CZ[FIJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getLetter", "()C", "()Z", "getParameters", "()[F", "getParamsCount", "()I", "getStart-1ufDz9w", "()J", "J", "isLineCommand", "isBezierCommand", "isQuadraticCurveCommand", "isCurveCommand", "isArcCommand", "isCloseCommand", "get", "", CmcdData.OBJECT_TYPE_INIT_SEGMENT, "x", "y", "xy", "j", "xy-XgqJiTY", "(II)J", "chunk", FirebaseAnalytics.Param.INDEX, "currentPosition", "chunk-HiPawso", "(IJ)Landroidx/graphics/shapes/SvgPathParser$Command;", "asLine", "newStart", "asLine-DnnuFBc", "(J)Landroidx/graphics/shapes/SvgPathParser$Command;", "equals", "other", "hashCode", "component1", "component2", "component3", "component4", "component5", "component5-1ufDz9w", "copy", "copy-teZZwEo", "(CZ[FIJ)Landroidx/graphics/shapes/SvgPathParser$Command;", "toString", "", "Factory", "graphics-shapes"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Command {
        public static final Factory Factory = new Factory(null);
        private static final Map<Character, Integer> commandToParamsCount = MapsKt.mapOf(TuplesKt.to('m', 2), TuplesKt.to('l', 2), TuplesKt.to('h', 1), TuplesKt.to('v', 1), TuplesKt.to('c', 6), TuplesKt.to('s', 4), TuplesKt.to('q', 4), TuplesKt.to('t', 2), TuplesKt.to('a', 7));
        private final boolean isArcCommand;
        private final boolean isBezierCommand;
        private final boolean isCloseCommand;
        private final boolean isCurveCommand;
        private final boolean isLineCommand;
        private final boolean isQuadraticCurveCommand;
        private final boolean isRelative;
        private final char letter;
        private final float[] parameters;
        private final int paramsCount;
        private final long start;

        public /* synthetic */ Command(char c, boolean z, float[] fArr, int i, long j, DefaultConstructorMarker defaultConstructorMarker) {
            this(c, z, fArr, i, j);
        }

        /* renamed from: copy-teZZwEo$default  reason: not valid java name */
        public static /* synthetic */ Command m8736copyteZZwEo$default(Command command, char c, boolean z, float[] fArr, int i, long j, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                c = command.letter;
            }
            if ((i2 & 2) != 0) {
                z = command.isRelative;
            }
            if ((i2 & 4) != 0) {
                fArr = command.parameters;
            }
            if ((i2 & 8) != 0) {
                i = command.paramsCount;
            }
            if ((i2 & 16) != 0) {
                j = command.start;
            }
            long j2 = j;
            return command.m8740copyteZZwEo(c, z, fArr, i, j2);
        }

        public final char component1() {
            return this.letter;
        }

        public final boolean component2() {
            return this.isRelative;
        }

        public final float[] component3() {
            return this.parameters;
        }

        public final int component4() {
            return this.paramsCount;
        }

        /* renamed from: component5-1ufDz9w  reason: not valid java name */
        public final long m8739component51ufDz9w() {
            return this.start;
        }

        /* renamed from: copy-teZZwEo  reason: not valid java name */
        public final Command m8740copyteZZwEo(char c, boolean z, float[] parameters, int i, long j) {
            Intrinsics.checkNotNullParameter(parameters, "parameters");
            return new Command(c, z, parameters, i, j, null);
        }

        public String toString() {
            return "Command(letter=" + this.letter + ", isRelative=" + this.isRelative + ", parameters=" + Arrays.toString(this.parameters) + ", paramsCount=" + this.paramsCount + ", start=" + ((Object) FloatFloatPair.m19toStringimpl(this.start)) + ')';
        }

        private Command(char c, boolean z, float[] parameters, int i, long j) {
            Intrinsics.checkNotNullParameter(parameters, "parameters");
            this.letter = c;
            this.isRelative = z;
            this.parameters = parameters;
            this.paramsCount = i;
            this.start = j;
            this.isLineCommand = ArraysKt.contains(new char[]{'l', 'h', 'v'}, c);
            this.isBezierCommand = ArraysKt.contains(new char[]{'c', 's'}, c);
            this.isQuadraticCurveCommand = ArraysKt.contains(new char[]{'q', 't'}, c);
            this.isCurveCommand = ArraysKt.contains(new char[]{'c', 's', 'q', 't'}, c);
            this.isArcCommand = c == 'a';
            this.isCloseCommand = c == 'z';
        }

        public final char getLetter() {
            return this.letter;
        }

        public final boolean isRelative() {
            return this.isRelative;
        }

        public final float[] getParameters() {
            return this.parameters;
        }

        public final int getParamsCount() {
            return this.paramsCount;
        }

        public /* synthetic */ Command(char c, boolean z, float[] fArr, int i, long j, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(c, z, fArr, i, (i2 & 16) != 0 ? FloatFloatPair.m12constructorimpl(0.0f, 0.0f) : j, null);
        }

        /* renamed from: getStart-1ufDz9w  reason: not valid java name */
        public final long m8741getStart1ufDz9w() {
            return this.start;
        }

        /* compiled from: SvgPathParser.kt */
        @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\f\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\n\u0010\f\u001a\u00060\rj\u0002`\u000e¢\u0006\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Landroidx/graphics/shapes/SvgPathParser$Command$Factory;", "", "<init>", "()V", "commandToParamsCount", "", "", "", "parse", "Landroidx/graphics/shapes/SvgPathParser$Command;", "input", "", "currentPosition", "Landroidx/collection/FloatFloatPair;", "Landroidx/graphics/shapes/Point;", "parse-HiPawso", "(Ljava/lang/String;J)Landroidx/graphics/shapes/SvgPathParser$Command;", "graphics-shapes"}, k = 1, mv = {2, 0, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class Factory {
            public /* synthetic */ Factory(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Factory() {
            }

            /* renamed from: parse-HiPawso  reason: not valid java name */
            public final Command m8743parseHiPawso(String input, long j) {
                Intrinsics.checkNotNullParameter(input, "input");
                char first = StringsKt.first(input);
                boolean isLowerCase = Character.isLowerCase(first);
                String[] strArr = {" ", StringUtils.COMMA};
                ArrayList arrayList = new ArrayList();
                for (Object obj : StringsKt.split$default((CharSequence) StringsKt.drop(input, 1), strArr, false, 0, 6, (Object) null)) {
                    if (!StringsKt.isBlank((String) obj)) {
                        arrayList.add(obj);
                    }
                }
                ArrayList<String> arrayList2 = arrayList;
                ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
                for (String str : arrayList2) {
                    arrayList3.add(Float.valueOf(Float.parseFloat(StringsKt.trim((CharSequence) str).toString())));
                }
                float[] floatArray = CollectionsKt.toFloatArray(arrayList3);
                char lowerCase = Character.toLowerCase(first);
                Integer num = (Integer) Command.commandToParamsCount.get(Character.valueOf(Character.toLowerCase(first)));
                int intValue = num != null ? num.intValue() : 0;
                if (!isLowerCase) {
                    j = FloatFloatPair.m12constructorimpl(0.0f, 0.0f);
                }
                return new Command(lowerCase, isLowerCase, floatArray, intValue, j, null);
            }
        }

        public final boolean isLineCommand() {
            return this.isLineCommand;
        }

        public final boolean isBezierCommand() {
            return this.isBezierCommand;
        }

        public final boolean isQuadraticCurveCommand() {
            return this.isQuadraticCurveCommand;
        }

        public final boolean isCurveCommand() {
            return this.isCurveCommand;
        }

        public final boolean isArcCommand() {
            return this.isArcCommand;
        }

        public final boolean isCloseCommand() {
            return this.isCloseCommand;
        }

        public final float get(int i) {
            return this.parameters[i];
        }

        public final float x(int i) {
            float f = get(i);
            return this.isRelative ? PointKt.m8711getXDnnuFBc(this.start) + f : f;
        }

        public final float y(int i) {
            float f = get(i);
            return this.isRelative ? PointKt.m8712getYDnnuFBc(this.start) + f : f;
        }

        /* renamed from: xy-XgqJiTY  reason: not valid java name */
        public final long m8742xyXgqJiTY(int i, int i2) {
            long m12constructorimpl = FloatFloatPair.m12constructorimpl(get(i), get(i2));
            return this.isRelative ? PointKt.m8715plusybeJwSQ(this.start, m12constructorimpl) : m12constructorimpl;
        }

        /* renamed from: chunk-HiPawso  reason: not valid java name */
        public final Command m8738chunkHiPawso(int i, long j) {
            return new Command(this.letter, this.isRelative, ArraysKt.sliceArray(this.parameters, RangesKt.until(i, this.paramsCount + i)), this.paramsCount, j, null);
        }

        /* renamed from: asLine-DnnuFBc  reason: not valid java name */
        public final Command m8737asLineDnnuFBc(long j) {
            return new Command('l', this.isRelative, CollectionsKt.toFloatArray(ArraysKt.drop(this.parameters, this.paramsCount)), 2, j, null);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Command command = (Command) obj;
            return this.letter == command.letter && Arrays.equals(this.parameters, command.parameters) && this.paramsCount == command.paramsCount;
        }

        public int hashCode() {
            return (((Character.hashCode(this.letter) * 31) + Arrays.hashCode(this.parameters)) * 31) + this.paramsCount;
        }
    }
}
