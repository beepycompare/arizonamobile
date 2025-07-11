package ru.mrlargha.commonui.elements.donate.utils;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.content.ContextCompat;
import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.elements.donate.presentation.models.DonateItemModelUi;
import ru.mrlargha.commonui.elements.donate.presentation.models.DonateItemType;
import ru.mrlargha.commonui.utils.ConverterKt;
/* compiled from: DonateUtils.kt */
@Metadata(d1 = {"\u0000p\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\u001a\u001a\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004\u001a\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0004\u001a\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0004\u001a\u0018\u0010\f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\n\u001a\u0018\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\n\u001a\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\n\u001a(\u0010\u0014\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0017\u001aH\u0010\u0018\u001a\u00020\u0019*\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001c2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020\u001f2\b\b\u0002\u0010!\u001a\u00020\"2\u000e\b\u0002\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$\u001a\u000e\u0010&\u001a\u00020\n2\u0006\u0010'\u001a\u00020\n\u001a\u0012\u0010(\u001a\u00020%*\u00020)2\u0006\u0010*\u001a\u00020\u0017\u001a\u0012\u0010+\u001a\u00020%*\u00020)2\u0006\u0010,\u001a\u00020\u0017\u001a\u0012\u0010-\u001a\u00020%*\u00020)2\u0006\u0010*\u001a\u00020\u0017\u001a\u0012\u0010.\u001a\u00020%*\u00020)2\u0006\u0010*\u001a\u00020\u0017\u001a\u0012\u0010/\u001a\u00020%*\u00020)2\u0006\u0010*\u001a\u00020\u0017\u001a\u0016\u00100\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n01*\u00020\n\u001a\u0014\u00102\u001a\u00020\u00102\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0004\u001a\f\u00103\u001a\u0004\u0018\u00010\n*\u00020\u001f\u001a\f\u00104\u001a\u0004\u0018\u00010\n*\u00020\u001f\u001a\u000e\u00105\u001a\u00020\n2\u0006\u00106\u001a\u00020\u001f\"\u000e\u00107\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000\"\u0014\u00108\u001a\b\u0012\u0004\u0012\u00020\n0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u00109\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010:\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010;\u001a\u00020\u001fX\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010<\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000¨\u0006="}, d2 = {"sortForLines", "", "Lru/mrlargha/commonui/elements/donate/presentation/models/DonateItemModelUi;", "input", "", "getButtonsGradientDrawable", "Landroid/graphics/drawable/Drawable;", "context", "Landroid/content/Context;", "colorList", "", "getDialogButtonGradient", "getItemEffectDrawable", "color", "getGradientBorderDrawable", "colors", "", "getTransfusionDrawable", "centerColor", "getSelectCategoryDrawable", "getDialogItemDrawable", "borderColor", "borderWith", "", "setTranslateAnimation", "Landroid/animation/ObjectAnimator;", "Landroid/view/View;", "from", "", TypedValues.TransitionType.S_TO, "startDelay", "", TypedValues.TransitionType.S_DURATION, "isRepeat", "", "onStart", "Lkotlin/Function0;", "", "decodeEmoji", "emojiCode", "setImageSdn", "Landroid/widget/ImageView;", "imageId", "setGifSdn", "gifId", "setImageItemBgSdn", "setImageCategorySdn", "setBackgroundCategorySdn", "splitOnPart", "Lkotlin/Pair;", "convertColorList", "getTimeHM", "getTimeHMS", "formatWithSpaces", "number", "TRANSPARENT_COLOR", "colorsDefault", "ANIMATION_PROPERTY_NAME", "ITEM_FOLDER_NAME", "ANIMATION_DURATION", DonateUtilsKt.DONATE_TAG, "CommonUI_release_web"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DonateUtilsKt {
    public static final long ANIMATION_DURATION = 6000;
    private static final String ANIMATION_PROPERTY_NAME = "translationX";
    public static final String DONATE_TAG = "DONATE_TAG";
    private static final String ITEM_FOLDER_NAME = "items";
    public static final String TRANSPARENT_COLOR = "#00000000";
    private static final List<String> colorsDefault = CollectionsKt.listOf((Object[]) new String[]{TRANSPARENT_COLOR, TRANSPARENT_COLOR});

    public static final List<DonateItemModelUi> sortForLines(List<DonateItemModelUi> input) {
        Intrinsics.checkNotNullParameter(input, "input");
        List mutableList = CollectionsKt.toMutableList((Collection) input);
        ArrayList arrayList = new ArrayList();
        int i = 0;
        int i2 = 0;
        while (i < mutableList.size()) {
            DonateItemModelUi donateItemModelUi = (DonateItemModelUi) mutableList.get(i);
            int i3 = (donateItemModelUi.getType() == DonateItemType.BIG.getType() ? 2 : 1) + i2;
            if (i3 <= 4) {
                arrayList.add(donateItemModelUi);
                i2 = i3 == 4 ? 0 : i3;
                i++;
            } else {
                int i4 = i + 1;
                int size = mutableList.size();
                while (true) {
                    if (i4 >= size) {
                        i4 = -1;
                        break;
                    } else if (((DonateItemModelUi) mutableList.get(i4)).getType() != 1) {
                        break;
                    } else {
                        i4++;
                    }
                }
                if (i4 != -1) {
                    mutableList.set(i, mutableList.get(i4));
                    mutableList.set(i4, (DonateItemModelUi) mutableList.get(i));
                } else {
                    i2 = 0;
                }
            }
        }
        return arrayList;
    }

    public static final Drawable getButtonsGradientDrawable(Context context, List<String> colorList) {
        Drawable.ConstantState constantState;
        Drawable newDrawable;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(colorList, "colorList");
        Drawable drawable = ContextCompat.getDrawable(context, R.drawable.donate_buttons_bg);
        Drawable mutate = (drawable == null || (constantState = drawable.getConstantState()) == null || (newDrawable = constantState.newDrawable()) == null) ? null : newDrawable.mutate();
        GradientDrawable gradientDrawable = mutate instanceof GradientDrawable ? (GradientDrawable) mutate : null;
        if (colorList.size() > 1 && gradientDrawable != null) {
            try {
                Log.e("donate", "colorList: " + colorList);
                List<String> list = colorList;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                for (String str : list) {
                    arrayList.add(Integer.valueOf(Color.parseColor(str)));
                }
                gradientDrawable.setColors(CollectionsKt.toIntArray(arrayList));
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
                return null;
            }
        }
        return gradientDrawable;
    }

    public static final Drawable getDialogButtonGradient(Context context, List<String> colorList) {
        Drawable.ConstantState constantState;
        Drawable newDrawable;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(colorList, "colorList");
        Drawable drawable = ContextCompat.getDrawable(context, R.drawable.donate_dialog_gradient);
        Drawable mutate = (drawable == null || (constantState = drawable.getConstantState()) == null || (newDrawable = constantState.newDrawable()) == null) ? null : newDrawable.mutate();
        GradientDrawable gradientDrawable = mutate instanceof GradientDrawable ? (GradientDrawable) mutate : null;
        if (colorList.size() > 1 && gradientDrawable != null) {
            try {
                List<String> list = colorList;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                for (String str : list) {
                    arrayList.add(Integer.valueOf(Color.parseColor(str)));
                }
                gradientDrawable.setColors(CollectionsKt.toIntArray(arrayList));
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
                return null;
            }
        }
        return gradientDrawable;
    }

    public static final Drawable getItemEffectDrawable(Context context, String color) {
        Drawable.ConstantState constantState;
        Drawable newDrawable;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(color, "color");
        Drawable drawable = ContextCompat.getDrawable(context, R.drawable.donate_blur_bg);
        Drawable mutate = (drawable == null || (constantState = drawable.getConstantState()) == null || (newDrawable = constantState.newDrawable()) == null) ? null : newDrawable.mutate();
        GradientDrawable gradientDrawable = mutate instanceof GradientDrawable ? (GradientDrawable) mutate : null;
        if (color.length() > 0 && gradientDrawable != null) {
            try {
                gradientDrawable.setColors(new int[]{Color.parseColor("#" + color), 0});
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
                return null;
            }
        }
        return gradientDrawable;
    }

    public static /* synthetic */ Drawable getGradientBorderDrawable$default(Context context, int[] iArr, int i, Object obj) {
        if ((i & 2) != 0) {
            iArr = convertColorList(colorsDefault);
        }
        return getGradientBorderDrawable(context, iArr);
    }

    public static final Drawable getGradientBorderDrawable(Context context, int[] colors) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(colors, "colors");
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, colors);
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(context.getResources().getDimension(R.dimen._8sdp));
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setShape(0);
        gradientDrawable2.setCornerRadius(context.getResources().getDimension(R.dimen._8sdp));
        gradientDrawable2.setColor(0);
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{gradientDrawable, gradientDrawable2});
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen._2sdp);
        layerDrawable.setLayerInset(1, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        return layerDrawable;
    }

    public static final Drawable getTransfusionDrawable(Context context, String centerColor) {
        Drawable.ConstantState constantState;
        Drawable newDrawable;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(centerColor, "centerColor");
        Drawable drawable = ContextCompat.getDrawable(context, R.drawable.donate_animation_thumb);
        Drawable mutate = (drawable == null || (constantState = drawable.getConstantState()) == null || (newDrawable = constantState.newDrawable()) == null) ? null : newDrawable.mutate();
        GradientDrawable gradientDrawable = mutate instanceof GradientDrawable ? (GradientDrawable) mutate : null;
        if (gradientDrawable != null) {
            try {
                gradientDrawable.setColors(CollectionsKt.toIntArray(CollectionsKt.listOf((Object[]) new Integer[]{0, 0, 0, Integer.valueOf(Color.parseColor(centerColor)), 0, 0, 0})));
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
                return null;
            }
        }
        return gradientDrawable;
    }

    public static final Drawable getSelectCategoryDrawable(Context context, String color) {
        Drawable.ConstantState constantState;
        Drawable newDrawable;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(color, "color");
        Drawable drawable = ContextCompat.getDrawable(context, R.drawable.donate_category_select_item);
        Drawable mutate = (drawable == null || (constantState = drawable.getConstantState()) == null || (newDrawable = constantState.newDrawable()) == null) ? null : newDrawable.mutate();
        GradientDrawable gradientDrawable = mutate instanceof GradientDrawable ? (GradientDrawable) mutate : null;
        if (color.length() > 0 && gradientDrawable != null) {
            try {
                gradientDrawable.setColors(CollectionsKt.toIntArray(CollectionsKt.listOf((Object[]) new Integer[]{0, Integer.valueOf(Color.parseColor(color)), Integer.valueOf(Color.parseColor(color))})));
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
                return null;
            }
        }
        return gradientDrawable;
    }

    public static final Drawable getDialogItemDrawable(Context context, String color, String borderColor, int i) {
        Drawable.ConstantState constantState;
        Drawable newDrawable;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(color, "color");
        Intrinsics.checkNotNullParameter(borderColor, "borderColor");
        Drawable drawable = ContextCompat.getDrawable(context, R.drawable.donate_dialog_item_bg);
        Drawable mutate = (drawable == null || (constantState = drawable.getConstantState()) == null || (newDrawable = constantState.newDrawable()) == null) ? null : newDrawable.mutate();
        GradientDrawable gradientDrawable = mutate instanceof GradientDrawable ? (GradientDrawable) mutate : null;
        if (gradientDrawable != null) {
            gradientDrawable.setColor(Color.parseColor(color));
        }
        if (gradientDrawable != null) {
            gradientDrawable.setStroke(ConverterKt.dpToPx(i, context), Color.parseColor(borderColor));
        }
        return gradientDrawable;
    }

    public static /* synthetic */ ObjectAnimator setTranslateAnimation$default(View view, float f, float f2, long j, long j2, boolean z, Function0 function0, int i, Object obj) {
        if ((i & 4) != 0) {
            j = 0;
        }
        return setTranslateAnimation(view, f, f2, j, (i & 8) != 0 ? 1000L : j2, (i & 16) != 0 ? false : z, (i & 32) != 0 ? new Function0() { // from class: ru.mrlargha.commonui.elements.donate.utils.DonateUtilsKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit unit;
                unit = Unit.INSTANCE;
                return unit;
            }
        } : function0);
    }

    public static final ObjectAnimator setTranslateAnimation(View view, float f, float f2, long j, long j2, boolean z, final Function0<Unit> onStart) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(onStart, "onStart");
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationX", f, f2);
        ofFloat.setDuration(j2);
        if (z) {
            ofFloat.setRepeatCount(-1);
            ofFloat.setRepeatMode(1);
        }
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat.setStartDelay(j);
        ofFloat.addListener(new Animator.AnimatorListener() { // from class: ru.mrlargha.commonui.elements.donate.utils.DonateUtilsKt$setTranslateAnimation$animator$1$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                onStart.invoke();
            }
        });
        Intrinsics.checkNotNull(ofFloat);
        return ofFloat;
    }

    public static final String decodeEmoji(String emojiCode) {
        Intrinsics.checkNotNullParameter(emojiCode, "emojiCode");
        try {
            char[] chars = Character.toChars(Integer.parseInt(StringsKt.removeSuffix(StringsKt.removePrefix(emojiCode, (CharSequence) ":u"), (CharSequence) StringUtils.PROCESS_POSTFIX_DELIMITER), CharsKt.checkRadix(16)));
            Intrinsics.checkNotNullExpressionValue(chars, "toChars(...)");
            return new String(chars);
        } catch (Exception unused) {
            return "";
        }
    }

    public static final void setImageSdn(ImageView imageView, int i) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        Log.e("donate", "setItem: " + i);
        Picasso.get().load("https://cdn.azresources.cloud/projects/arizona-rp/assets/images/donate_shop/" + i + ".webp").into(imageView);
    }

    public static final void setGifSdn(ImageView imageView, int i) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        Glide.with(imageView.getContext()).asGif().load("https://cdn.azresources.cloud/projects/arizona-rp/assets/images/donate_shop/" + i + ".gif").into(imageView);
    }

    public static final void setImageItemBgSdn(ImageView imageView, int i) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        Picasso.get().load("https://cdn.azresources.cloud/projects/arizona-rp/assets/images/donate_background/" + i + ".webp").into(imageView);
    }

    public static final void setImageCategorySdn(ImageView imageView, int i) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        Picasso.get().load("https://cdn.azresources.cloud/projects/arizona-rp/assets/images/donate_category/mobile_icons/" + i + ".webp").into(imageView);
    }

    public static final void setBackgroundCategorySdn(ImageView imageView, int i) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        Picasso.get().load("https://cdn.azresources.cloud/projects/arizona-rp/assets/images/donate_category/mobile/" + i + ".webp").into(imageView);
    }

    public static final Pair<String, String> splitOnPart(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        List split$default = StringsKt.split$default((CharSequence) str, new String[]{" "}, false, 2, 2, (Object) null);
        String str2 = (String) CollectionsKt.getOrNull(split$default, 0);
        if (str2 == null) {
            str2 = "";
        }
        String str3 = (String) CollectionsKt.getOrNull(split$default, 1);
        return TuplesKt.to(str2, str3 != null ? str3 : "");
    }

    public static final int[] convertColorList(List<String> colorList) {
        Intrinsics.checkNotNullParameter(colorList, "colorList");
        ArrayList arrayList = new ArrayList();
        for (String str : colorList) {
            arrayList.add(Integer.valueOf(Color.parseColor(str)));
        }
        return CollectionsKt.toIntArray(arrayList);
    }

    public static final String getTimeHM(long j) {
        long currentTimeMillis = (j * 1000) - System.currentTimeMillis();
        if (currentTimeMillis > 0) {
            long days = TimeUnit.MILLISECONDS.toDays(currentTimeMillis);
            long hours = TimeUnit.MILLISECONDS.toHours(currentTimeMillis) % 24;
            long minutes = TimeUnit.MILLISECONDS.toMinutes(currentTimeMillis) % 60;
            StringBuilder sb = new StringBuilder();
            if (days > 0) {
                sb.append(days + " д. ");
            }
            if (hours > 0) {
                sb.append(hours + " ч. ");
            }
            if (minutes > 0) {
                sb.append(minutes + " м.");
            }
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
            return StringsKt.trim((CharSequence) sb2).toString();
        }
        return null;
    }

    public static final String getTimeHMS(long j) {
        long currentTimeMillis = (j * 1000) - System.currentTimeMillis();
        if (currentTimeMillis > 0) {
            long hours = TimeUnit.MILLISECONDS.toHours(currentTimeMillis);
            long j2 = 60;
            long minutes = TimeUnit.MILLISECONDS.toMinutes(currentTimeMillis) % j2;
            long seconds = TimeUnit.MILLISECONDS.toSeconds(currentTimeMillis) % j2;
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("%02d:%02d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(hours), Long.valueOf(minutes), Long.valueOf(seconds)}, 3));
            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
            return format;
        }
        return null;
    }

    public static final String formatWithSpaces(long j) {
        DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols(Locale.getDefault());
        decimalFormatSymbols.setGroupingSeparator(' ');
        String format = new DecimalFormat("#,###", decimalFormatSymbols).format(j);
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return format;
    }
}
