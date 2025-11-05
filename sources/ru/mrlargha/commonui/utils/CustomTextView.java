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
import androidx.media3.extractor.text.ttml.TtmlNode;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchGroup;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import ru.mrlargha.commonui.R;
/* compiled from: CustomTextView.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 !2\u00020\u0001:\u0001!B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\rH\u0002J\u0010\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\rH\u0002J$\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\t2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u001a0 H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R!\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012R!\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0014\u001a\u0004\b\u0017\u0010\u0012¨\u0006\""}, d2 = {"Lru/mrlargha/commonui/utils/CustomTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "builder", "Landroid/text/SpannableStringBuilder;", "typeArray", "Landroid/content/res/TypedArray;", "colorListString", "", "fonts", "", "Landroid/graphics/Typeface;", "getFonts", "()Ljava/util/List;", "fonts$delegate", "Lkotlin/Lazy;", "colors", "", "getColors", "colors$delegate", "applyColoredTags", "", "raw", "applyColorWithFontTags", "addSpansOverExistingText", TtmlNode.RUBY_BASE, "apply", "Lkotlin/Function1;", "Companion", "CommonUI_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class CustomTextView extends AppCompatTextView {
    public static final Companion Companion = new Companion(null);
    private static final String LEFT_ANGLE_BRACKET = "&lt;";
    private static final String RIGHT_ANGLE_BRACKET = "&gt;";
    private final SpannableStringBuilder builder;
    private final String colorListString;
    private final Lazy colors$delegate;
    private final Lazy fonts$delegate;
    private final TypedArray typeArray;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        this.builder = new SpannableStringBuilder();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attrs, R.styleable.CustomTextView);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "obtainStyledAttributes(...)");
        this.typeArray = obtainStyledAttributes;
        String string = obtainStyledAttributes.getString(R.styleable.CustomTextView_textColorList);
        this.colorListString = string == null ? "" : string;
        this.fonts$delegate = LazyKt.lazy(new Function0() { // from class: ru.mrlargha.commonui.utils.CustomTextView$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                List fonts_delegate$lambda$0;
                fonts_delegate$lambda$0 = CustomTextView.fonts_delegate$lambda$0(CustomTextView.this);
                return fonts_delegate$lambda$0;
            }
        });
        this.colors$delegate = LazyKt.lazy(new Function0() { // from class: ru.mrlargha.commonui.utils.CustomTextView$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                List colors_delegate$lambda$0;
                colors_delegate$lambda$0 = CustomTextView.colors_delegate$lambda$0(CustomTextView.this);
                return colors_delegate$lambda$0;
            }
        });
        post(new Runnable() { // from class: ru.mrlargha.commonui.utils.CustomTextView$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                CustomTextView._init_$lambda$0(CustomTextView.this);
            }
        });
    }

    private final List<Typeface> getFonts() {
        return (List) this.fonts$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List fonts_delegate$lambda$0(CustomTextView customTextView) {
        List createListBuilder = CollectionsKt.createListBuilder();
        if (customTextView.typeArray.hasValue(R.styleable.CustomTextView_font0)) {
            Typeface font = customTextView.typeArray.getFont(R.styleable.CustomTextView_font0);
            Intrinsics.checkNotNull(font);
            createListBuilder.add(font);
        }
        if (customTextView.typeArray.hasValue(R.styleable.CustomTextView_font1)) {
            Typeface font2 = customTextView.typeArray.getFont(R.styleable.CustomTextView_font1);
            Intrinsics.checkNotNull(font2);
            createListBuilder.add(font2);
        }
        if (customTextView.typeArray.hasValue(R.styleable.CustomTextView_font2)) {
            Typeface font3 = customTextView.typeArray.getFont(R.styleable.CustomTextView_font2);
            Intrinsics.checkNotNull(font3);
            createListBuilder.add(font3);
        }
        if (createListBuilder.isEmpty()) {
            createListBuilder.add(Typeface.DEFAULT);
        }
        return CollectionsKt.build(createListBuilder);
    }

    private final List<Integer> getColors() {
        return (List) this.colors$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List colors_delegate$lambda$0(CustomTextView customTextView) {
        try {
            List<String> split$default = StringsKt.split$default((CharSequence) customTextView.colorListString, new String[]{StringUtils.COMMA}, false, 0, 6, (Object) null);
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(split$default, 10));
            for (String str : split$default) {
                arrayList.add(Integer.valueOf(Color.parseColor(StringsKt.trim((CharSequence) str).toString())));
            }
            return arrayList;
        } catch (Exception e) {
            Log.e(customTextView.getClass().getSimpleName(), "Invalid color list: " + customTextView.colorListString, e);
            return CollectionsKt.listOf(-1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$0(CustomTextView customTextView) {
        String replace$default = StringsKt.replace$default(StringsKt.replace$default(customTextView.getText().toString(), LEFT_ANGLE_BRACKET, "<", false, 4, (Object) null), RIGHT_ANGLE_BRACKET, ">", false, 4, (Object) null);
        String str = replace$default;
        if (StringsKt.contains$default((CharSequence) str, (CharSequence) "<cf", false, 2, (Object) null)) {
            customTextView.applyColorWithFontTags(replace$default);
        } else if (StringsKt.contains$default((CharSequence) str, (CharSequence) "<c", false, 2, (Object) null)) {
            customTextView.applyColoredTags(replace$default);
        }
        customTextView.setText(customTextView.builder, TextView.BufferType.SPANNABLE);
        customTextView.typeArray.recycle();
    }

    private final void applyColoredTags(String str) {
        String value;
        Integer intOrNull;
        int i = 0;
        for (MatchResult matchResult : Regex.findAll$default(new Regex("<c(\\d+)>(.*?)</c\\d+>"), str, 0, 2, null)) {
            MatchGroup matchGroup = matchResult.getGroups().get(1);
            int intValue = (matchGroup == null || (value = matchGroup.getValue()) == null || (intOrNull = StringsKt.toIntOrNull(value)) == null) ? 0 : intOrNull.intValue();
            MatchGroup matchGroup2 = matchResult.getGroups().get(2);
            String str2 = (matchGroup2 == null || (str2 = matchGroup2.getValue()) == null) ? "" : "";
            String substring = str.substring(i, matchResult.getRange().getFirst());
            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            String str3 = substring;
            if (str3.length() > 0) {
                int length = this.builder.length();
                this.builder.append((CharSequence) str3);
                this.builder.setSpan(new ForegroundColorSpan(((Number) CollectionsKt.first((List<? extends Object>) getColors())).intValue()), length, this.builder.length(), 33);
            }
            int length2 = this.builder.length();
            this.builder.append((CharSequence) str2);
            int length3 = this.builder.length();
            Integer num = (Integer) CollectionsKt.getOrNull(getColors(), intValue % getColors().size());
            this.builder.setSpan(new ForegroundColorSpan(num != null ? num.intValue() : ((Number) CollectionsKt.first((List<? extends Object>) getColors())).intValue()), length2, length3, 33);
            i = matchResult.getRange().getLast() + 1;
        }
        if (i < str.length()) {
            int length4 = this.builder.length();
            SpannableStringBuilder spannableStringBuilder = this.builder;
            String substring2 = str.substring(i);
            Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
            spannableStringBuilder.append((CharSequence) substring2);
            this.builder.setSpan(new ForegroundColorSpan(((Number) CollectionsKt.first((List<? extends Object>) getColors())).intValue()), length4, this.builder.length(), 33);
        }
    }

    private final void applyColorWithFontTags(String str) {
        String value;
        Integer intOrNull;
        int i = 0;
        for (MatchResult matchResult : Regex.findAll$default(new Regex("<cf(\\d+)>(.*?)</cf\\d+>"), str, 0, 2, null)) {
            MatchGroup matchGroup = matchResult.getGroups().get(1);
            int intValue = (matchGroup == null || (value = matchGroup.getValue()) == null || (intOrNull = StringsKt.toIntOrNull(value)) == null) ? 0 : intOrNull.intValue();
            MatchGroup matchGroup2 = matchResult.getGroups().get(2);
            String str2 = (matchGroup2 == null || (str2 = matchGroup2.getValue()) == null) ? "" : "";
            String substring = str.substring(i, matchResult.getRange().getFirst());
            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            String str3 = substring;
            if (str3.length() > 0) {
                int length = this.builder.length();
                this.builder.append((CharSequence) str3);
                this.builder.setSpan(new FontColorSpan(((Number) CollectionsKt.first((List<? extends Object>) getColors())).intValue(), (Typeface) CollectionsKt.first((List<? extends Object>) getFonts())), length, this.builder.length(), 33);
            }
            int length2 = this.builder.length();
            this.builder.append((CharSequence) str2);
            int length3 = this.builder.length();
            Integer num = (Integer) CollectionsKt.getOrNull(getColors(), intValue % getColors().size());
            int intValue2 = num != null ? num.intValue() : ((Number) CollectionsKt.first((List<? extends Object>) getColors())).intValue();
            Typeface typeface = (Typeface) CollectionsKt.getOrNull(getFonts(), intValue % getColors().size());
            if (typeface == null) {
                typeface = (Typeface) CollectionsKt.first((List<? extends Object>) getFonts());
            }
            this.builder.setSpan(new FontColorSpan(intValue2, typeface), length2, length3, 33);
            i = matchResult.getRange().getLast() + 1;
        }
        if (i < str.length()) {
            int length4 = this.builder.length();
            SpannableStringBuilder spannableStringBuilder = this.builder;
            String substring2 = str.substring(i);
            Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
            spannableStringBuilder.append((CharSequence) substring2);
            this.builder.setSpan(new FontColorSpan(((Number) CollectionsKt.first((List<? extends Object>) getColors())).intValue(), (Typeface) CollectionsKt.first((List<? extends Object>) getFonts())), length4, this.builder.length(), 33);
        }
    }

    private final SpannableStringBuilder addSpansOverExistingText(SpannableStringBuilder spannableStringBuilder, Function1<? super SpannableStringBuilder, Unit> function1) {
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(spannableStringBuilder);
        function1.invoke(spannableStringBuilder2);
        return spannableStringBuilder2;
    }

    /* compiled from: CustomTextView.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lru/mrlargha/commonui/utils/CustomTextView$Companion;", "", "<init>", "()V", "LEFT_ANGLE_BRACKET", "", "RIGHT_ANGLE_BRACKET", "CommonUI_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
