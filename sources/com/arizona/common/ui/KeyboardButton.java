package com.arizona.common.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.content.ContextCompat;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.arizona.common.R;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: KeyboardButton.kt */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001B!\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u001a\u0002\b\b¢\u0006\u0004\b\u0006\u0010\u0007B#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0006\u0010\u000bB+\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n¢\u0006\u0004\b\u0006\u0010\rJ\u001a\u0010$\u001a\u00020%2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0002J\u0006\u0010&\u001a\u00020%J\u0006\u0010'\u001a\u00020%J\b\u0010(\u001a\u00020%H\u0002J\u000e\u0010)\u001a\u00020%2\u0006\u0010*\u001a\u00020\u000fJ\u000e\u0010+\u001a\u00020%2\u0006\u0010,\u001a\u00020#J\u000e\u0010-\u001a\u00020%2\u0006\u0010.\u001a\u00020\nR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0011\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0083\u000e\u0092\u0002\u0002\b\u0013¢\u0006\u0004\n\u0002\u0010\u0012R\u0012\u0010\u0014\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0012R\u0012\u0010\u0015\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0012R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010/\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b0\u00101¨\u00062"}, d2 = {"Lcom/arizona/common/ui/KeyboardButton;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Lkotlin/jvm/JvmOverloads;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "TAG", "", "keyText", "keyImage", "Ljava/lang/Integer;", "Landroidx/annotation/DrawableRes;", "keyImageTint", "keyTextSize", "customBackground", "Landroid/graphics/drawable/Drawable;", "hasBackground", "", "hasSymbolBackground", "hasBinderKeysBackground", "isMainBinderKey", "containter", "keyTextView", "Lcom/arizona/common/ui/AutoResizeTextView;", "keyImageView", "Landroid/widget/ImageView;", "currBinderType", "Lcom/arizona/common/ui/BinderButtonType;", "init", "", "onActionDown", "onActionUp", "bindViews", "setText", TypedValues.Custom.S_STRING, "setBinderButtonType", ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "setColor", "color", "text", "getText", "()Ljava/lang/String;", "CommonLibs"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class KeyboardButton extends RelativeLayout {
    private final String TAG;
    private RelativeLayout containter;
    private BinderButtonType currBinderType;
    private Drawable customBackground;
    private boolean hasBackground;
    private boolean hasBinderKeysBackground;
    private boolean hasSymbolBackground;
    private boolean isMainBinderKey;
    private Integer keyImage;
    private Integer keyImageTint;
    private ImageView keyImageView;
    private String keyText;
    private Integer keyTextSize;
    private AutoResizeTextView keyTextView;

    /* compiled from: KeyboardButton.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[BinderButtonType.values().length];
            try {
                iArr[BinderButtonType.INITIAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[BinderButtonType.BINDED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[BinderButtonType.EDITABLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public KeyboardButton(Context context) {
        this(context, (AttributeSet) null, 2, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KeyboardButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullExpressionValue("KeyboardButton", "getSimpleName(...)");
        this.TAG = "KeyboardButton";
        this.keyText = "";
        init(context, attributeSet);
    }

    public /* synthetic */ KeyboardButton(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KeyboardButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullExpressionValue("KeyboardButton", "getSimpleName(...)");
        this.TAG = "KeyboardButton";
        this.keyText = "";
        init(context, attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KeyboardButton(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullExpressionValue("KeyboardButton", "getSimpleName(...)");
        this.TAG = "KeyboardButton";
        this.keyText = "";
        init(context, attributeSet);
    }

    private final void init(Context context, AttributeSet attributeSet) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.keyboard_button, this);
        this.containter = (RelativeLayout) inflate.getRootView();
        this.keyTextView = (AutoResizeTextView) inflate.findViewById(R.id.key_text);
        this.keyImageView = (ImageView) inflate.findViewById(R.id.key_image);
        RelativeLayout relativeLayout = this.containter;
        this.customBackground = relativeLayout != null ? relativeLayout.getBackground() : null;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.KeyboardButtonAttrs);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "obtainStyledAttributes(...)");
        if (obtainStyledAttributes.hasValue(R.styleable.KeyboardButtonAttrs_hasBackground)) {
            this.hasBackground = obtainStyledAttributes.getBoolean(R.styleable.KeyboardButtonAttrs_hasBackground, true);
        }
        if (obtainStyledAttributes.hasValue(R.styleable.KeyboardButtonAttrs_textKey)) {
            String string = obtainStyledAttributes.getString(R.styleable.KeyboardButtonAttrs_textKey);
            if (string == null) {
                string = "";
            }
            this.keyText = string;
        }
        if (obtainStyledAttributes.hasValue(R.styleable.KeyboardButtonAttrs_imageKey)) {
            this.keyImage = Integer.valueOf(obtainStyledAttributes.getResourceId(R.styleable.KeyboardButtonAttrs_imageKey, -1));
        }
        if (obtainStyledAttributes.hasValue(R.styleable.KeyboardButtonAttrs_imageTint)) {
            this.keyImageTint = Integer.valueOf(obtainStyledAttributes.getColor(R.styleable.KeyboardButtonAttrs_imageTint, -1));
        }
        if (obtainStyledAttributes.hasValue(R.styleable.KeyboardButtonAttrs_hasSymbolBackground)) {
            this.hasSymbolBackground = obtainStyledAttributes.getBoolean(R.styleable.KeyboardButtonAttrs_hasSymbolBackground, false);
        }
        if (obtainStyledAttributes.hasValue(R.styleable.KeyboardButtonAttrs_hasBinderKeysBackground)) {
            this.hasBinderKeysBackground = obtainStyledAttributes.getBoolean(R.styleable.KeyboardButtonAttrs_hasBinderKeysBackground, false);
        }
        if (obtainStyledAttributes.hasValue(R.styleable.KeyboardButtonAttrs_textSize)) {
            this.keyTextSize = Integer.valueOf(obtainStyledAttributes.getDimensionPixelSize(R.styleable.KeyboardButtonAttrs_textSize, 0));
        }
        if (obtainStyledAttributes.hasValue(R.styleable.KeyboardButtonAttrs_isMainBinderKey)) {
            this.isMainBinderKey = obtainStyledAttributes.getBoolean(R.styleable.KeyboardButtonAttrs_isMainBinderKey, false);
        }
        obtainStyledAttributes.recycle();
        bindViews();
    }

    public final void onActionDown() {
        RelativeLayout relativeLayout;
        if (this.hasBinderKeysBackground) {
            RelativeLayout relativeLayout2 = this.containter;
            if (relativeLayout2 != null) {
                relativeLayout2.setBackgroundResource(R.drawable.bg_binder_keyboard_btn_pressed);
            }
        } else if (this.hasSymbolBackground) {
            RelativeLayout relativeLayout3 = this.containter;
            if (relativeLayout3 != null) {
                relativeLayout3.setBackgroundResource(R.drawable.bg_symbol_keyboard_btn_pressed);
            }
        } else if (this.hasBackground) {
            RelativeLayout relativeLayout4 = this.containter;
            if (relativeLayout4 != null) {
                relativeLayout4.setBackgroundResource(R.drawable.bg_keyboard_btn_pressed);
            }
        } else if (this.isMainBinderKey && (relativeLayout = this.containter) != null) {
            relativeLayout.setBackgroundResource(R.drawable.bg_binders_key_pressed);
        }
        BinderButtonType binderButtonType = this.currBinderType;
        if (binderButtonType != null) {
            int i = WhenMappings.$EnumSwitchMapping$0[binderButtonType.ordinal()];
            if (i == 1) {
                RelativeLayout relativeLayout5 = this.containter;
                if (relativeLayout5 != null) {
                    relativeLayout5.setBackgroundResource(R.drawable.bg_keyboard_btn_pressed);
                }
            } else if (i == 2) {
                RelativeLayout relativeLayout6 = this.containter;
                if (relativeLayout6 != null) {
                    relativeLayout6.setBackgroundResource(R.drawable.bg_binder_binded_keyboard_btn_pressed);
                }
            } else if (i != 3) {
                throw new NoWhenBranchMatchedException();
            } else {
                RelativeLayout relativeLayout7 = this.containter;
                if (relativeLayout7 != null) {
                    relativeLayout7.setBackgroundResource(R.drawable.bg_binder_edit_keyboard_btn_pressed);
                }
            }
        }
    }

    public final void onActionUp() {
        RelativeLayout relativeLayout;
        if (this.hasBinderKeysBackground) {
            RelativeLayout relativeLayout2 = this.containter;
            if (relativeLayout2 != null) {
                relativeLayout2.setBackgroundResource(R.drawable.bg_binder_keyboard_btn);
            }
        } else if (this.hasSymbolBackground) {
            RelativeLayout relativeLayout3 = this.containter;
            if (relativeLayout3 != null) {
                relativeLayout3.setBackgroundResource(R.drawable.bg_symbol_keyboard_btn);
            }
        } else if (this.hasBackground) {
            RelativeLayout relativeLayout4 = this.containter;
            if (relativeLayout4 != null) {
                relativeLayout4.setBackgroundResource(R.drawable.bg_keyboard_btn);
            }
        } else if (this.isMainBinderKey && (relativeLayout = this.containter) != null) {
            relativeLayout.setBackgroundResource(R.drawable.bg_main_binder_key);
        }
        BinderButtonType binderButtonType = this.currBinderType;
        if (binderButtonType != null) {
            int i = WhenMappings.$EnumSwitchMapping$0[binderButtonType.ordinal()];
            if (i == 1) {
                RelativeLayout relativeLayout5 = this.containter;
                if (relativeLayout5 != null) {
                    relativeLayout5.setBackgroundResource(R.drawable.bg_keyboard_btn);
                }
            } else if (i == 2) {
                RelativeLayout relativeLayout6 = this.containter;
                if (relativeLayout6 != null) {
                    relativeLayout6.setBackgroundResource(R.drawable.bg_binder_binded_keyboard_btn);
                }
            } else if (i != 3) {
                throw new NoWhenBranchMatchedException();
            } else {
                RelativeLayout relativeLayout7 = this.containter;
                if (relativeLayout7 != null) {
                    relativeLayout7.setBackgroundResource(R.drawable.bg_binder_edit_keyboard_btn);
                }
            }
        }
    }

    private final void bindViews() {
        RelativeLayout relativeLayout;
        AutoResizeTextView autoResizeTextView;
        AutoResizeTextView autoResizeTextView2;
        ImageView imageView;
        if (this.hasBinderKeysBackground) {
            RelativeLayout relativeLayout2 = this.containter;
            if (relativeLayout2 != null) {
                relativeLayout2.setBackgroundResource(R.drawable.bg_binder_keyboard_btn);
            }
        } else if (this.hasSymbolBackground) {
            RelativeLayout relativeLayout3 = this.containter;
            if (relativeLayout3 != null) {
                relativeLayout3.setBackgroundResource(R.drawable.bg_symbol_keyboard_btn);
            }
        } else if (this.hasBackground) {
            RelativeLayout relativeLayout4 = this.containter;
            if (relativeLayout4 != null) {
                relativeLayout4.setBackgroundResource(R.drawable.bg_keyboard_btn);
            }
        } else if (this.isMainBinderKey && (relativeLayout = this.containter) != null) {
            relativeLayout.setBackgroundResource(R.drawable.bg_main_binder_key);
        }
        Integer num = this.keyImage;
        if (num != null && (num == null || num.intValue() != -1)) {
            AutoResizeTextView autoResizeTextView3 = this.keyTextView;
            if (autoResizeTextView3 != null) {
                autoResizeTextView3.setVisibility(8);
            }
            ImageView imageView2 = this.keyImageView;
            if (imageView2 != null) {
                imageView2.setVisibility(0);
            }
            ImageView imageView3 = this.keyImageView;
            if (imageView3 != null) {
                Context context = getContext();
                Integer num2 = this.keyImage;
                Intrinsics.checkNotNull(num2);
                imageView3.setImageDrawable(ContextCompat.getDrawable(context, num2.intValue()));
            }
            Integer num3 = this.keyImageTint;
            if (num3 == null || (imageView = this.keyImageView) == null) {
                return;
            }
            Intrinsics.checkNotNull(num3);
            imageView.setColorFilter(num3.intValue());
            return;
        }
        AutoResizeTextView autoResizeTextView4 = this.keyTextView;
        if (autoResizeTextView4 != null) {
            autoResizeTextView4.setVisibility(0);
        }
        ImageView imageView4 = this.keyImageView;
        if (imageView4 != null) {
            imageView4.setVisibility(8);
        }
        AutoResizeTextView autoResizeTextView5 = this.keyTextView;
        if (autoResizeTextView5 != null) {
            autoResizeTextView5.setText(this.keyText);
        }
        Integer num4 = this.keyTextSize;
        if (num4 != null) {
            Intrinsics.checkNotNull(num4);
            if (num4.intValue() > 0 && (autoResizeTextView2 = this.keyTextView) != null) {
                Integer num5 = this.keyTextSize;
                Intrinsics.checkNotNull(num5);
                autoResizeTextView2.setTextSize(0, num5.intValue());
            }
        }
        if (!this.isMainBinderKey || (autoResizeTextView = this.keyTextView) == null) {
            return;
        }
        autoResizeTextView.setTextColor(Color.parseColor("#877AFF"));
    }

    public final void setText(String string) {
        Intrinsics.checkNotNullParameter(string, "string");
        this.keyText = string;
        AutoResizeTextView autoResizeTextView = this.keyTextView;
        if (autoResizeTextView != null) {
            autoResizeTextView.setText(string);
        }
    }

    public final void setBinderButtonType(BinderButtonType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        this.currBinderType = type;
        int i = WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
        if (i == 1) {
            RelativeLayout relativeLayout = this.containter;
            if (relativeLayout != null) {
                relativeLayout.setBackgroundResource(R.drawable.bg_keyboard_btn);
            }
        } else if (i == 2) {
            RelativeLayout relativeLayout2 = this.containter;
            if (relativeLayout2 != null) {
                relativeLayout2.setBackgroundResource(R.drawable.bg_binder_binded_keyboard_btn);
            }
        } else if (i != 3) {
            throw new NoWhenBranchMatchedException();
        } else {
            RelativeLayout relativeLayout3 = this.containter;
            if (relativeLayout3 != null) {
                relativeLayout3.setBackgroundResource(R.drawable.bg_binder_edit_keyboard_btn);
            }
        }
    }

    public final void setColor(int i) {
        ImageView imageView = this.keyImageView;
        if (imageView != null) {
            imageView.setColorFilter(i);
        }
    }

    public final String getText() {
        return this.keyText;
    }
}
