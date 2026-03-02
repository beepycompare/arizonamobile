package androidx.graphics.shapes;

import androidx.graphics.shapes.Feature;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
/* compiled from: FeatureSerializer.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Landroidx/graphics/shapes/FeatureSerializer;", "", "<init>", "()V", "Companion", "graphics-shapes"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class FeatureSerializer {
    private static final String LOG_TAG = "FeatureSerializer";
    private static final char SEPARATOR = ',';
    public static final Companion Companion = new Companion(null);
    private static final char EDGE_CHAR = 'n';
    private static final char CONVEX_CORNER_CHAR = 'x';
    private static final char CONCAVE_CORNER_CHAR = 'o';
    private static final char[] FEATURE_TAG_ARRAY = {EDGE_CHAR, CONVEX_CORNER_CHAR, CONCAVE_CORNER_CHAR};

    @JvmStatic
    public static final List<Feature> parse(String str) {
        return Companion.parse(str);
    }

    @JvmStatic
    public static final String serialize(List<? extends Feature> list) {
        return Companion.serialize(list);
    }

    /* compiled from: FeatureSerializer.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\f\n\u0002\b\u0004\n\u0002\u0010\u0019\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0007J\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\n\u001a\u00020\u0005H\u0007J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\bH\u0002J\u0016\u0010\r\u001a\u00020\u00052\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0007H\u0002J \u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J&\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00072\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\f\u0010\u0016\u001a\u00020\u0005*\u00020\u0005H\u0002R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0018X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0018X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0018X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Landroidx/graphics/shapes/FeatureSerializer$Companion;", "", "<init>", "()V", "serialize", "", "features", "", "Landroidx/graphics/shapes/Feature;", "parse", "serializedFeatures", "serializeFeature", "feature", "serializeCubics", "cubics", "Landroidx/graphics/shapes/Cubic;", "parseFeature", "serialized", "startIndex", "", "endIndex", "parseCubics", "removeTrailingZeroes", "SEPARATOR", "", "CONVEX_CORNER_CHAR", "CONCAVE_CORNER_CHAR", "EDGE_CHAR", "FEATURE_TAG_ARRAY", "", "LOG_TAG", "graphics-shapes"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final String serialize(List<? extends Feature> features) {
            Intrinsics.checkNotNullParameter(features, "features");
            StringBuilder sb = new StringBuilder("V1");
            for (Feature feature : features) {
                sb.append(FeatureSerializer.Companion.serializeFeature(feature));
            }
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
            return sb2;
        }

        @JvmStatic
        public final List<Feature> parse(String serializedFeatures) {
            int length;
            Intrinsics.checkNotNullParameter(serializedFeatures, "serializedFeatures");
            String str = serializedFeatures;
            int i = 0;
            MatchResult find$default = Regex.find$default(new Regex("^\\s*V(\\d+)"), str, 0, 2, null);
            if (find$default != null && find$default.getGroupValues().size() >= 2) {
                Intrinsics.areEqual(find$default.getGroupValues().get(1), "1");
                i = find$default.getValue().length();
            }
            MatchResult find = new Regex("[a-zA-Z]").find(str, i);
            if (find == null) {
                throw new IllegalArgumentException(("Could not find any feature tags. Please mark all cubic bezier curve points belonging to a feature with one of {" + ArraysKt.joinToString$default(FeatureSerializer.FEATURE_TAG_ARRAY, (CharSequence) ", ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null) + "} for V1, e.g. 'n1,1,2,2,3,3,4,4' for an edge (n) with anchor 0 (1,1), control 0 (2,2), control 1 (3,3) and anchor 1 (4,4).").toString());
            }
            List createListBuilder = CollectionsKt.createListBuilder();
            while (find != null) {
                int first = find.getRange().getFirst();
                find = find.next();
                if (find != null) {
                    length = find.getRange().getFirst();
                } else {
                    length = serializedFeatures.length();
                }
                createListBuilder.add(FeatureSerializer.Companion.parseFeature(serializedFeatures, first, length));
            }
            return CollectionsKt.build(createListBuilder);
        }

        private final String serializeFeature(Feature feature) {
            if (feature instanceof Feature.Edge) {
                return "n" + serializeCubics(feature.getCubics());
            } else if (!(feature instanceof Feature.Corner)) {
                return "n" + serializeCubics(feature.getCubics());
            } else {
                return (((Feature.Corner) feature).getConvex() ? FeatureSerializer.CONVEX_CORNER_CHAR : FeatureSerializer.CONCAVE_CORNER_CHAR) + serializeCubics(feature.getCubics());
            }
        }

        private final String serializeCubics(List<? extends Cubic> list) {
            StringBuilder sb = new StringBuilder();
            for (Cubic cubic : list) {
                sb.append(ArraysKt.joinToString$default(cubic.getPoints$graphics_shapes(), (CharSequence) StringUtils.COMMA, (CharSequence) null, (CharSequence) null, 6, (CharSequence) "", new Function1() { // from class: androidx.graphics.shapes.FeatureSerializer$Companion$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        CharSequence removeTrailingZeroes;
                        removeTrailingZeroes = FeatureSerializer.Companion.removeTrailingZeroes(String.valueOf(((Float) obj).floatValue()));
                        return removeTrailingZeroes;
                    }
                }, 6, (Object) null));
            }
            String removeTrailingZeroes = FeatureSerializer.Companion.removeTrailingZeroes(String.valueOf(((Cubic) CollectionsKt.last((List<? extends Object>) list)).getAnchor1X()));
            sb.append(removeTrailingZeroes + ',' + FeatureSerializer.Companion.removeTrailingZeroes(String.valueOf(((Cubic) CollectionsKt.last((List<? extends Object>) list)).getAnchor1Y())));
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
            return sb2;
        }

        private final Feature parseFeature(String str, int i, int i2) {
            char charAt = str.charAt(i);
            if (charAt != 'n') {
                if (charAt != 'o') {
                    if (charAt == 'x') {
                        return new Feature.Corner(parseCubics(str, i + 1, i2), true);
                    }
                    return new Feature.Edge(parseCubics(str, i + 1, i2));
                }
                return new Feature.Corner(parseCubics(str, i + 1, i2), false);
            }
            return new Feature.Edge(parseCubics(str, i + 1, i2));
        }

        private final List<Cubic> parseCubics(String str, int i, int i2) {
            int i3;
            float[] fArr = new float[8];
            List createListBuilder = CollectionsKt.createListBuilder();
            int i4 = i;
            int i5 = i4;
            int i6 = 0;
            while (i4 < i2) {
                if (str.charAt(i4) != ',') {
                    i4++;
                } else {
                    int i7 = i6 + 1;
                    String substring = str.substring(i5, i4);
                    Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                    fArr[i6] = Float.parseFloat(substring);
                    i5 = i4 + 1;
                    if (i7 == 8) {
                        createListBuilder.add(new Cubic(fArr));
                        float f = fArr[6];
                        float f2 = fArr[7];
                        float[] fArr2 = new float[8];
                        fArr2[0] = f;
                        fArr2[1] = f2;
                        i6 -= 5;
                        fArr = fArr2;
                    } else {
                        i6 = i7;
                    }
                    i4 = i5;
                }
            }
            int i8 = i6 + 1;
            if (i8 != 8) {
                try {
                    String substring2 = str.substring(i5, i4);
                    Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
                    Float.parseFloat(substring2);
                    i3 = 8 - i8;
                } catch (NumberFormatException unused) {
                    i3 = 8 - i6;
                }
                StringBuilder sb = new StringBuilder("Received a feature with an insufficient amount of numbers for substring '");
                String substring3 = str.substring(i - 1, i2);
                Intrinsics.checkNotNullExpressionValue(substring3, "substring(...)");
                throw new IllegalArgumentException(sb.append(substring3).append("'. Wanted to create ").append(createListBuilder.size() + 1).append(" continuous cubic bezier curves for this feature, but the last one is missing ").append(i3).append(" more numbers separated by ','.").toString().toString());
            }
            String substring4 = str.substring(i5, i4);
            Intrinsics.checkNotNullExpressionValue(substring4, "substring(...)");
            fArr[7] = Float.parseFloat(substring4);
            createListBuilder.add(new Cubic(fArr));
            return CollectionsKt.build(createListBuilder);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String removeTrailingZeroes(String str) {
            String str2;
            String str3;
            String str4 = str;
            int length = str4.length() - 1;
            if (length >= 0) {
                while (true) {
                    int i = length - 1;
                    if (str4.charAt(length) != '0') {
                        str2 = str4.subSequence(0, length + 1);
                        break;
                    } else if (i < 0) {
                        break;
                    } else {
                        length = i;
                    }
                }
            }
            String obj = str2.toString();
            int length2 = obj.length() - 1;
            if (length2 >= 0) {
                while (true) {
                    int i2 = length2 - 1;
                    if (obj.charAt(length2) != '.') {
                        str3 = obj.subSequence(0, length2 + 1);
                        break;
                    } else if (i2 < 0) {
                        break;
                    } else {
                        length2 = i2;
                    }
                }
            }
            return str3.toString();
        }
    }

    private FeatureSerializer() {
    }
}
