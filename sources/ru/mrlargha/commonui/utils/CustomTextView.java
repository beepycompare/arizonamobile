package ru.mrlargha.commonui.utils;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.res.ResourcesCompat;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchGroup;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.RegexOption;
import kotlin.text.StringsKt;
import ru.mrlargha.commonui.R;
/* compiled from: CustomTextView.kt */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 $2\u00020\u0001:\u0001$B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0011\u001a\u00020\u0012H\u0002J\u0018\u0010\u0013\u001a\u00020\u00122\u0010\b\u0001\u0010\b\u001a\u00020\u0014\"\u00020\n:\u0002\b\u0015J\u000e\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0018J\u0010\u0010\u0019\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\fH\u0002J\u0016\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u001b\u001a\u00020\fH\u0002J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\fH\u0002J\u0010\u0010\u001f\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\fH\u0002J\"\u0010 \u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\nH\u0002R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010Ê\u0001\u0010\b&\u0012\f\b'\u0012\b\b\fJ\u0004\b\b((¨\u0006%"}, d2 = {"Lru/mrlargha/commonui/utils/CustomTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "colors", "", "", "formattedSourceText", "", "fonts", "Landroid/graphics/Typeface;", "getFonts", "()Ljava/util/List;", "applyFormattedText", "", "setTextColorList", "", "Landroidx/annotation/ColorInt;", "setFormattedText", "text", "", "decodeFormattedText", "parseColors", "colorListString", "buildColoredTags", "Landroid/text/SpannableStringBuilder;", "raw", "buildColorWithFontTags", "getTypefaceFromAttr", "ta", "Landroid/content/res/TypedArray;", "attrId", "Companion", "CommonUI", "Landroid/annotation/SuppressLint;", "value", "NewApi"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class CustomTextView extends AppCompatTextView {
    public static final Companion Companion = new Companion(null);
    private static final String LEFT_ANGLE_BRACKET = "&lt;";
    private static final String RIGHT_ANGLE_BRACKET = "&gt;";
    private List<Integer> colors;
    private final List<Typeface> fonts;
    private String formattedSourceText;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        this.colors = CollectionsKt.listOf(-1);
        this.formattedSourceText = "";
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attrs, R.styleable.CustomTextView);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "obtainStyledAttributes(...)");
        String string = obtainStyledAttributes.getString(R.styleable.CustomTextView_textColorList);
        this.colors = parseColors(string != null ? string : "");
        List createListBuilder = CollectionsKt.createListBuilder();
        Typeface typefaceFromAttr = getTypefaceFromAttr(context, obtainStyledAttributes, R.styleable.CustomTextView_font0);
        if (typefaceFromAttr != null) {
            createListBuilder.add(typefaceFromAttr);
        }
        Typeface typefaceFromAttr2 = getTypefaceFromAttr(context, obtainStyledAttributes, R.styleable.CustomTextView_font1);
        if (typefaceFromAttr2 != null) {
            createListBuilder.add(typefaceFromAttr2);
        }
        Typeface typefaceFromAttr3 = getTypefaceFromAttr(context, obtainStyledAttributes, R.styleable.CustomTextView_font2);
        if (typefaceFromAttr3 != null) {
            createListBuilder.add(typefaceFromAttr3);
        }
        if (createListBuilder.isEmpty()) {
            Typeface DEFAULT = Typeface.DEFAULT;
            Intrinsics.checkNotNullExpressionValue(DEFAULT, "DEFAULT");
            createListBuilder.add(DEFAULT);
        }
        this.fonts = CollectionsKt.build(createListBuilder);
        obtainStyledAttributes.recycle();
        this.formattedSourceText = decodeFormattedText(getText().toString());
        applyFormattedText();
    }

    public final List<Typeface> getFonts() {
        return this.fonts;
    }

    private final void applyFormattedText() {
        SpannableStringBuilder buildColoredTags;
        boolean contains$default = StringsKt.contains$default((CharSequence) this.formattedSourceText, (CharSequence) "<cf", false, 2, (Object) null);
        String str = this.formattedSourceText;
        if (contains$default) {
            buildColoredTags = buildColorWithFontTags(str);
        } else if (!StringsKt.contains$default((CharSequence) str, (CharSequence) "<c", false, 2, (Object) null)) {
            return;
        } else {
            buildColoredTags = buildColoredTags(this.formattedSourceText);
        }
        SpannableStringBuilder spannableStringBuilder = buildColoredTags;
        if (spannableStringBuilder.length() != 0 || this.formattedSourceText.length() <= 0) {
            setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);
        }
    }

    public final void setTextColorList(int... colors) {
        Intrinsics.checkNotNullParameter(colors, "colors");
        List<Integer> list = ArraysKt.toList(colors);
        if (list.isEmpty()) {
            list = CollectionsKt.listOf(-1);
        }
        this.colors = list;
        applyFormattedText();
    }

    public final void setFormattedText(CharSequence text) {
        Intrinsics.checkNotNullParameter(text, "text");
        String decodeFormattedText = decodeFormattedText(text.toString());
        this.formattedSourceText = decodeFormattedText;
        if (StringsKt.contains$default((CharSequence) decodeFormattedText, (CharSequence) "<c", false, 2, (Object) null)) {
            applyFormattedText();
        } else {
            setText(this.formattedSourceText);
        }
    }

    private final String decodeFormattedText(String str) {
        return StringsKt.replace$default(StringsKt.replace$default(str, LEFT_ANGLE_BRACKET, "<", false, 4, (Object) null), RIGHT_ANGLE_BRACKET, ">", false, 4, (Object) null);
    }

    private final List<Integer> parseColors(String str) {
        if (StringsKt.isBlank(str)) {
            return CollectionsKt.listOf(-1);
        }
        try {
            List<String> split$default = StringsKt.split$default((CharSequence) str, new String[]{StringUtils.COMMA}, false, 0, 6, (Object) null);
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(split$default, 10));
            for (String str2 : split$default) {
                arrayList.add(Integer.valueOf(Color.parseColor(StringsKt.trim((CharSequence) str2).toString())));
            }
            return arrayList;
        } catch (Exception e) {
            Log.e(getClass().getSimpleName(), "Invalid color list: " + str, e);
            return CollectionsKt.listOf(-1);
        }
    }

    private final SpannableStringBuilder buildColoredTags(String str) {
        String value;
        Integer intOrNull;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        int i = 0;
        for (MatchResult matchResult : Regex.findAll$default(new Regex("<c(\\d+)>(.*?)</c\\d+>", RegexOption.DOT_MATCHES_ALL), str, 0, 2, null)) {
            MatchGroup matchGroup = matchResult.getGroups().get(1);
            int intValue = (matchGroup == null || (value = matchGroup.getValue()) == null || (intOrNull = StringsKt.toIntOrNull(value)) == null) ? 0 : intOrNull.intValue();
            MatchGroup matchGroup2 = matchResult.getGroups().get(2);
            String str2 = (matchGroup2 == null || (str2 = matchGroup2.getValue()) == null) ? "" : "";
            String substring = str.substring(i, matchResult.getRange().getFirst());
            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            String str3 = substring;
            if (str3.length() > 0) {
                int length = spannableStringBuilder.length();
                spannableStringBuilder.append((CharSequence) str3);
                spannableStringBuilder.setSpan(new ForegroundColorSpan(((Number) CollectionsKt.first((List<? extends Object>) this.colors)).intValue()), length, spannableStringBuilder.length(), 33);
            }
            int length2 = spannableStringBuilder.length();
            spannableStringBuilder.append((CharSequence) str2);
            int length3 = spannableStringBuilder.length();
            List<Integer> list = this.colors;
            Integer num = (Integer) CollectionsKt.getOrNull(list, intValue % list.size());
            spannableStringBuilder.setSpan(new ForegroundColorSpan(num != null ? num.intValue() : ((Number) CollectionsKt.first((List<? extends Object>) this.colors)).intValue()), length2, length3, 33);
            i = matchResult.getRange().getLast() + 1;
        }
        if (i < str.length()) {
            int length4 = spannableStringBuilder.length();
            String substring2 = str.substring(i);
            Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
            spannableStringBuilder.append((CharSequence) substring2);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(((Number) CollectionsKt.first((List<? extends Object>) this.colors)).intValue()), length4, spannableStringBuilder.length(), 33);
        }
        return spannableStringBuilder;
    }

    private final SpannableStringBuilder buildColorWithFontTags(String str) {
        String value;
        Integer intOrNull;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        int i = 0;
        for (MatchResult matchResult : Regex.findAll$default(new Regex("<cf(\\d+)>(.*?)</cf\\d+>", RegexOption.DOT_MATCHES_ALL), str, 0, 2, null)) {
            MatchGroup matchGroup = matchResult.getGroups().get(1);
            int intValue = (matchGroup == null || (value = matchGroup.getValue()) == null || (intOrNull = StringsKt.toIntOrNull(value)) == null) ? 0 : intOrNull.intValue();
            MatchGroup matchGroup2 = matchResult.getGroups().get(2);
            String str2 = (matchGroup2 == null || (str2 = matchGroup2.getValue()) == null) ? "" : "";
            String substring = str.substring(i, matchResult.getRange().getFirst());
            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            String str3 = substring;
            if (str3.length() > 0) {
                int length = spannableStringBuilder.length();
                spannableStringBuilder.append((CharSequence) str3);
                spannableStringBuilder.setSpan(new FontColorSpan(((Number) CollectionsKt.first((List<? extends Object>) this.colors)).intValue(), (Typeface) CollectionsKt.first((List<? extends Object>) this.fonts)), length, spannableStringBuilder.length(), 33);
            }
            int length2 = spannableStringBuilder.length();
            spannableStringBuilder.append((CharSequence) str2);
            int length3 = spannableStringBuilder.length();
            List<Integer> list = this.colors;
            Integer num = (Integer) CollectionsKt.getOrNull(list, intValue % list.size());
            int intValue2 = num != null ? num.intValue() : ((Number) CollectionsKt.first((List<? extends Object>) this.colors)).intValue();
            List<Typeface> list2 = this.fonts;
            Typeface typeface = (Typeface) CollectionsKt.getOrNull(list2, intValue % list2.size());
            if (typeface == null) {
                typeface = (Typeface) CollectionsKt.first((List<? extends Object>) this.fonts);
            }
            spannableStringBuilder.setSpan(new FontColorSpan(intValue2, typeface), length2, length3, 33);
            i = matchResult.getRange().getLast() + 1;
        }
        if (i < str.length()) {
            int length4 = spannableStringBuilder.length();
            String substring2 = str.substring(i);
            Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
            spannableStringBuilder.append((CharSequence) substring2);
            spannableStringBuilder.setSpan(new FontColorSpan(((Number) CollectionsKt.first((List<? extends Object>) this.colors)).intValue(), (Typeface) CollectionsKt.first((List<? extends Object>) this.fonts)), length4, spannableStringBuilder.length(), 33);
        }
        return spannableStringBuilder;
    }

    private final Typeface getTypefaceFromAttr(Context context, TypedArray typedArray, int i) {
        int resourceId = typedArray.getResourceId(i, 0);
        if (resourceId != 0) {
            return ResourcesCompat.getFont(context, resourceId);
        }
        return null;
    }

    /* compiled from: CustomTextView.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lru/mrlargha/commonui/utils/CustomTextView$Companion;", "", "<init>", "()V", "LEFT_ANGLE_BRACKET", "", "RIGHT_ANGLE_BRACKET", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
