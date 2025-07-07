package androidx.compose.ui.text.platform;

import android.content.Context;
import android.graphics.Typeface;
import androidx.collection.MutableScatterSet;
import androidx.compose.ui.text.font.Font;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontListFontFamily;
import androidx.compose.ui.text.font.FontLoadingStrategy;
import androidx.compose.ui.text.font.FontMatcher;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis_androidKt;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.internal.InlineClassHelperKt;
import androidx.compose.ui.util.ListUtilsKt;
import androidx.media3.extractor.text.ttml.TtmlNode;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: AndroidFontListTypeface.android.kt */
@Deprecated(message = "This is not supported after downloadable fonts.")
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u001c\b\u0002\u0010\u0006\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b\u0018\u00010\u0007\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ*\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001eR\u0014\u0010\u0002\u001a\u00020\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u000b\u001a\u00020\f¢\u0006\n\n\u0002\b\u0013\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00170\u0015X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006 "}, d2 = {"Landroidx/compose/ui/text/platform/AndroidFontListTypeface;", "Landroidx/compose/ui/text/platform/AndroidTypeface;", TtmlNode.ATTR_TTS_FONT_FAMILY, "Landroidx/compose/ui/text/font/FontListFontFamily;", "context", "Landroid/content/Context;", "necessaryStyles", "", "Lkotlin/Pair;", "Landroidx/compose/ui/text/font/FontWeight;", "Landroidx/compose/ui/text/font/FontStyle;", "fontMatcher", "Landroidx/compose/ui/text/font/FontMatcher;", "(Landroidx/compose/ui/text/font/FontListFontFamily;Landroid/content/Context;Ljava/util/List;Landroidx/compose/ui/text/font/FontMatcher;)V", "Landroidx/compose/ui/text/font/FontFamily;", "getFontFamily", "()Landroidx/compose/ui/text/font/FontFamily;", "getFontMatcher", "()Landroidx/compose/ui/text/font/FontMatcher;", "fontMatcher$1", "loadedTypefaces", "", "Landroidx/compose/ui/text/font/Font;", "Landroid/graphics/Typeface;", "getNativeTypeface", TtmlNode.ATTR_TTS_FONT_WEIGHT, TtmlNode.ATTR_TTS_FONT_STYLE, "synthesis", "Landroidx/compose/ui/text/font/FontSynthesis;", "getNativeTypeface-PYhJU0U", "(Landroidx/compose/ui/text/font/FontWeight;II)Landroid/graphics/Typeface;", "Companion", "ui-text_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AndroidFontListTypeface implements AndroidTypeface {
    private final FontFamily fontFamily;
    private final FontMatcher fontMatcher$1;
    private final Map<Font, Typeface> loadedTypefaces;
    private static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final FontMatcher fontMatcher = new FontMatcher();

    /* JADX WARN: Removed duplicated region for block: B:25:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00dc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public AndroidFontListTypeface(FontListFontFamily fontListFontFamily, Context context, List<Pair<FontWeight, FontStyle>> list, FontMatcher fontMatcher2) {
        ArrayList arrayList;
        ArrayList arrayList2;
        int size;
        this.fontMatcher$1 = fontMatcher2;
        List<Font> fonts = fontListFontFamily.getFonts();
        ArrayList arrayList3 = new ArrayList(fonts.size());
        int size2 = fonts.size();
        for (int i = 0; i < size2; i++) {
            Font font = fonts.get(i);
            if (FontLoadingStrategy.m6246equalsimpl0(font.mo6204getLoadingStrategyPKNRLFQ(), FontLoadingStrategy.Companion.m6251getBlockingPKNRLFQ())) {
                arrayList3.add(font);
            }
        }
        ArrayList arrayList4 = arrayList3;
        if (list != null) {
            ArrayList arrayList5 = new ArrayList(list.size());
            int size3 = list.size();
            for (int i2 = 0; i2 < size3; i2++) {
                Pair<FontWeight, FontStyle> pair = list.get(i2);
                arrayList5.add((Font) CollectionsKt.firstOrNull((List<? extends Object>) this.fontMatcher$1.m6255matchFontRetOiIg(arrayList4, pair.component1(), pair.component2().m6262unboximpl())));
            }
            List fastFilterNotNull = ListUtilsKt.fastFilterNotNull(arrayList5);
            if (fastFilterNotNull != null) {
                MutableScatterSet mutableScatterSet = new MutableScatterSet(fastFilterNotNull.size());
                ArrayList arrayList6 = new ArrayList(fastFilterNotNull.size());
                int size4 = fastFilterNotNull.size();
                for (int i3 = 0; i3 < size4; i3++) {
                    Object obj = fastFilterNotNull.get(i3);
                    if (mutableScatterSet.add((Font) obj)) {
                        arrayList6.add(obj);
                    }
                }
                arrayList = arrayList6;
                arrayList4 = arrayList != null ? arrayList : arrayList4;
                arrayList2 = arrayList4;
                if (arrayList2.isEmpty()) {
                    InlineClassHelperKt.throwIllegalStateException("Could not match font");
                }
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                size = arrayList2.size();
                for (int i4 = 0; i4 < size; i4++) {
                    Font font2 = (Font) arrayList4.get(i4);
                    try {
                        linkedHashMap.put(font2, AndroidTypefaceCache.INSTANCE.getOrCreate(context, font2));
                    } catch (Exception unused) {
                        InlineClassHelperKt.throwIllegalStateException("Cannot create Typeface from " + font2);
                    }
                }
                this.loadedTypefaces = linkedHashMap;
                this.fontFamily = fontListFontFamily;
            }
        }
        arrayList = null;
        if (arrayList != null) {
        }
        arrayList2 = arrayList4;
        if (arrayList2.isEmpty()) {
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        size = arrayList2.size();
        while (i4 < size) {
        }
        this.loadedTypefaces = linkedHashMap2;
        this.fontFamily = fontListFontFamily;
    }

    public /* synthetic */ AndroidFontListTypeface(FontListFontFamily fontListFontFamily, Context context, List list, FontMatcher fontMatcher2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(fontListFontFamily, context, (i & 4) != 0 ? null : list, (i & 8) != 0 ? fontMatcher : fontMatcher2);
    }

    public final FontMatcher getFontMatcher() {
        return this.fontMatcher$1;
    }

    /* compiled from: AndroidFontListTypeface.android.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroidx/compose/ui/text/platform/AndroidFontListTypeface$Companion;", "", "()V", "fontMatcher", "Landroidx/compose/ui/text/font/FontMatcher;", "getFontMatcher", "()Landroidx/compose/ui/text/font/FontMatcher;", "ui-text_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes2.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final FontMatcher getFontMatcher() {
            return AndroidFontListTypeface.fontMatcher;
        }
    }

    @Override // androidx.compose.ui.text.font.Typeface
    public FontFamily getFontFamily() {
        return this.fontFamily;
    }

    @Override // androidx.compose.ui.text.platform.AndroidTypeface
    /* renamed from: getNativeTypeface-PYhJU0U */
    public Typeface mo6401getNativeTypefacePYhJU0U(FontWeight fontWeight, int i, int i2) {
        Font font = (Font) CollectionsKt.firstOrNull((List<? extends Object>) this.fontMatcher$1.m6255matchFontRetOiIg(new ArrayList(this.loadedTypefaces.keySet()), fontWeight, i));
        if (font != null) {
            Typeface typeface = this.loadedTypefaces.get(font);
            if (typeface != null) {
                Object m6280synthesizeTypefaceFxwP2eA = FontSynthesis_androidKt.m6280synthesizeTypefaceFxwP2eA(i2, typeface, font, fontWeight, i);
                Intrinsics.checkNotNull(m6280synthesizeTypefaceFxwP2eA, "null cannot be cast to non-null type android.graphics.Typeface");
                return (Typeface) m6280synthesizeTypefaceFxwP2eA;
            }
            InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("Could not load typeface");
            throw new KotlinNothingValueException();
        }
        InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("Could not load font");
        throw new KotlinNothingValueException();
    }
}
