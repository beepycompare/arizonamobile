package ru.mrlargha.commonui.elements.donate.utils;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.content.ContextCompat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.elements.donate.presentation.models.DonateItemModel;
import ru.mrlargha.commonui.utils.ConverterKt;
/* compiled from: DonateUtils.kt */
@Metadata(d1 = {"\u0000X\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a\u001a\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004\u001a\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0004\u001a\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\n\u001a\u0018\u0010\r\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\n\u001a\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\n\u001a(\u0010\u0011\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0013\u001aH\u0010\u0014\u001a\u00020\u0015*\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001b2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\u000e\b\u0002\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 \"\u000e\u0010\"\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010#\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"sortForLines", "", "Lru/mrlargha/commonui/elements/donate/presentation/models/DonateItemModel;", "input", "", "getButtonsGradientDrawable", "Landroid/graphics/drawable/Drawable;", "context", "Landroid/content/Context;", "colorList", "", "getBorderDrawableWithColor", "borderColor", "getTransfusionDrawable", "centerColor", "getSelectCategoryDrawable", "color", "getDialogItemDrawable", "borderWith", "", "setTranslateAnimation", "Landroid/animation/ObjectAnimator;", "Landroid/view/View;", "from", "", TypedValues.TransitionType.S_TO, "startDelay", "", TypedValues.TransitionType.S_DURATION, "isRepeat", "", "onStart", "Lkotlin/Function0;", "", "TRANSPARENT_COLOR", "ANIMATION_PROPERTY_NAME", "CommonUI_release_web"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DonateUtilsKt {
    private static final String ANIMATION_PROPERTY_NAME = "translationX";
    public static final String TRANSPARENT_COLOR = "#00000000";

    public static final List<DonateItemModel> sortForLines(List<DonateItemModel> input) {
        Intrinsics.checkNotNullParameter(input, "input");
        List mutableList = CollectionsKt.toMutableList((Collection) input);
        ArrayList arrayList = new ArrayList();
        int i = 0;
        int i2 = 0;
        while (i < mutableList.size()) {
            DonateItemModel donateItemModel = (DonateItemModel) mutableList.get(i);
            int i3 = (donateItemModel.getType() == 1 ? 2 : 1) + i2;
            if (i3 <= 4) {
                arrayList.add(donateItemModel);
                i2 = i3 == 4 ? 0 : i3;
                i++;
            } else {
                int i4 = i + 1;
                int size = mutableList.size();
                while (true) {
                    if (i4 >= size) {
                        i4 = -1;
                        break;
                    } else if (((DonateItemModel) mutableList.get(i4)).getType() != 1) {
                        break;
                    } else {
                        i4++;
                    }
                }
                if (i4 != -1) {
                    mutableList.set(i, mutableList.get(i4));
                    mutableList.set(i4, (DonateItemModel) mutableList.get(i));
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
        if (gradientDrawable != null) {
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

    public static final Drawable getBorderDrawableWithColor(Context context, String borderColor) {
        Drawable.ConstantState constantState;
        Drawable newDrawable;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(borderColor, "borderColor");
        Drawable drawable = ContextCompat.getDrawable(context, R.drawable.donate_category_item_border);
        Drawable mutate = (drawable == null || (constantState = drawable.getConstantState()) == null || (newDrawable = constantState.newDrawable()) == null) ? null : newDrawable.mutate();
        GradientDrawable gradientDrawable = mutate instanceof GradientDrawable ? (GradientDrawable) mutate : null;
        if (gradientDrawable != null) {
            try {
                gradientDrawable.setStroke(context.getResources().getDimensionPixelSize(R.dimen._2sdp), Color.parseColor(borderColor));
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
                return null;
            }
        }
        return gradientDrawable;
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
        if (gradientDrawable != null) {
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
}
