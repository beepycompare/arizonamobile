package ru.mrlargha.commonui.core;

import android.app.Activity;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.inputmethod.InputMethodManager;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import com.arizona.common.utils.ViewIdGenerator;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import ru.mrlargha.commonui.R;
/* compiled from: SAMPUIElement.kt */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\b&\u0018\u0000 :2\u00020\u0001:\u0002:;B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u001bH\u0016J\u001e\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u0005J\"\u0010\"\u001a\u00020\u00192\u0006\u0010#\u001a\u00020\r2\b\b\u0002\u0010$\u001a\u00020\u00052\b\b\u0002\u0010%\u001a\u00020\u0005J\"\u0010&\u001a\u00020\u00192\u0006\u0010'\u001a\u00020\u00052\b\b\u0002\u0010(\u001a\u00020\u00052\b\b\u0002\u0010)\u001a\u00020*J\u0018\u0010+\u001a\u00020\u00192\u0006\u0010,\u001a\u00020*2\u0006\u0010(\u001a\u00020\u0005H\u0016J\b\u0010-\u001a\u00020\u0019H\u0016J\u0010\u0010.\u001a\u00020\u00192\u0006\u0010/\u001a\u00020*H\u0016J\u0006\u00100\u001a\u00020\u0019J\u0006\u00101\u001a\u00020\u0005J&\u00102\u001a\u00020\u0019*\u00020\r2\u0006\u0010'\u001a\u00020\u00052\b\b\u0002\u0010(\u001a\u00020\u00052\b\b\u0002\u0010)\u001a\u00020*J\n\u00103\u001a\u00020\u0019*\u00020\rJ\n\u00104\u001a\u00020\u0019*\u00020\rJ*\u00102\u001a\u00020\u0019*\u00020\r2\u0006\u0010'\u001a\u00020\u00052\b\b\u0002\u0010(\u001a\u00020\u00052\f\u0010)\u001a\b\u0012\u0004\u0012\u00020*05J\b\u00106\u001a\u00020\u0019H\u0016J\u0018\u00107\u001a\u00020\u00192\u0006\u0010,\u001a\u00020\u00052\u0006\u00108\u001a\u00020\u0005H\u0016J\u0018\u00107\u001a\u00020\u00192\u0006\u0010,\u001a\u00020\u00052\u0006\u00108\u001a\u000209H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00020\u000fX\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u0013X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006<"}, d2 = {"Lru/mrlargha/commonui/core/SAMPUIElement;", "", "targetActivity", "Landroid/app/Activity;", "backendID", "", "<init>", "(Landroid/app/Activity;I)V", "getTargetActivity", "()Landroid/app/Activity;", "getBackendID", "()I", "innerView", "Landroid/view/View;", "notifier", "Lru/mrlargha/commonui/core/IBackendNotifier;", "getNotifier", "()Lru/mrlargha/commonui/core/IBackendNotifier;", "sharedPreferences", "Landroid/content/SharedPreferences;", "getSharedPreferences", "()Landroid/content/SharedPreferences;", "baseLayout", "Landroidx/constraintlayout/widget/ConstraintLayout;", "setVisibility", "", "visible", "", "isOnScreen", "setPosition", "type", "Lru/mrlargha/commonui/core/SAMPUIElement$PositionType;", "x", "y", "addViewToConstraintLayout", "view", "width", "height", "notifyClick", "id", "subId", "message", "", "onBackendMessage", "data", "onLayoutClick", "consumeUserInput", "text", "removeFromLayout", "getViewId", "bindBackendClick", "gone", "show", "Lkotlin/Function0;", "removeAllChildren", "onUpdateData", "value", "", "Companion", "PositionType", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class SAMPUIElement {
    public static final Companion Companion = new Companion(null);
    private static final String SP_NAME = "UI_ELEMENTS_SP";
    private static final String TAG = "SAMPUIElementBase";
    private final int backendID;
    private final ConstraintLayout baseLayout;
    private View innerView;
    private final IBackendNotifier notifier;
    private final SharedPreferences sharedPreferences;
    private final Activity targetActivity;

    /* compiled from: SAMPUIElement.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PositionType.values().length];
            try {
                iArr[PositionType.LEFT_TOP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PositionType.CENTER_TOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PositionType.RIGHT_TOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[PositionType.LEFT_CENTER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[PositionType.CENTER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[PositionType.RIGHT_CENTER.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[PositionType.LEFT_BOTTOM.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[PositionType.CENTER_BOTTOM.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[PositionType.RIGHT_BOTTOM.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public void consumeUserInput(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
    }

    public void onBackendMessage(String data, int i) {
        Intrinsics.checkNotNullParameter(data, "data");
    }

    public void onLayoutClick() {
    }

    public void onUpdateData(int i, int i2) {
    }

    public void onUpdateData(int i, long j) {
    }

    public void removeAllChildren() {
    }

    /* compiled from: SAMPUIElement.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lru/mrlargha/commonui/core/SAMPUIElement$Companion;", "", "<init>", "()V", "SP_NAME", "", "TAG", "hideKeyboard", "", "activity", "Landroid/app/Activity;", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void hideKeyboard(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Object systemService = activity.getSystemService("input_method");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            InputMethodManager inputMethodManager = (InputMethodManager) systemService;
            View currentFocus = activity.getCurrentFocus();
            if (currentFocus == null) {
                currentFocus = new View(activity);
            }
            inputMethodManager.hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
        }
    }

    public SAMPUIElement(Activity targetActivity, int i) {
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        this.targetActivity = targetActivity;
        this.backendID = i;
        Intrinsics.checkNotNull(targetActivity, "null cannot be cast to non-null type ru.mrlargha.commonui.core.IBackendNotifier");
        this.notifier = (IBackendNotifier) targetActivity;
        SharedPreferences sharedPreferences = targetActivity.getSharedPreferences(SP_NAME, 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "getSharedPreferences(...)");
        this.sharedPreferences = sharedPreferences;
        View inflate = targetActivity.getLayoutInflater().inflate(R.layout.constrain_layout_template, (ViewGroup) null);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
        ConstraintLayout constraintLayout = (ConstraintLayout) inflate;
        this.baseLayout = constraintLayout;
        constraintLayout.setId(ViewIdGenerator.INSTANCE.generateViewId());
        targetActivity.addContentView(constraintLayout, new ConstraintLayout.LayoutParams(-1, -1));
    }

    public final int getBackendID() {
        return this.backendID;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Activity getTargetActivity() {
        return this.targetActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public IBackendNotifier getNotifier() {
        return this.notifier;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final SharedPreferences getSharedPreferences() {
        return this.sharedPreferences;
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: SAMPUIElement.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\b\u0086\u0081\u0002\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0011B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0012"}, d2 = {"Lru/mrlargha/commonui/core/SAMPUIElement$PositionType;", "", "backendCode", "", "<init>", "(Ljava/lang/String;II)V", "getBackendCode", "()I", "LEFT_TOP", "RIGHT_TOP", "CENTER_TOP", "LEFT_CENTER", "CENTER", "RIGHT_CENTER", "LEFT_BOTTOM", "CENTER_BOTTOM", "RIGHT_BOTTOM", "Companion", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class PositionType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ PositionType[] $VALUES;
        public static final Companion Companion;
        private final int backendCode;
        public static final PositionType LEFT_TOP = new PositionType("LEFT_TOP", 0, 1);
        public static final PositionType RIGHT_TOP = new PositionType("RIGHT_TOP", 1, 2);
        public static final PositionType CENTER_TOP = new PositionType("CENTER_TOP", 2, 3);
        public static final PositionType LEFT_CENTER = new PositionType("LEFT_CENTER", 3, 4);
        public static final PositionType CENTER = new PositionType("CENTER", 4, 5);
        public static final PositionType RIGHT_CENTER = new PositionType("RIGHT_CENTER", 5, 6);
        public static final PositionType LEFT_BOTTOM = new PositionType("LEFT_BOTTOM", 6, 7);
        public static final PositionType CENTER_BOTTOM = new PositionType("CENTER_BOTTOM", 7, 8);
        public static final PositionType RIGHT_BOTTOM = new PositionType("RIGHT_BOTTOM", 8, 9);

        private static final /* synthetic */ PositionType[] $values() {
            return new PositionType[]{LEFT_TOP, RIGHT_TOP, CENTER_TOP, LEFT_CENTER, CENTER, RIGHT_CENTER, LEFT_BOTTOM, CENTER_BOTTOM, RIGHT_BOTTOM};
        }

        public static EnumEntries<PositionType> getEntries() {
            return $ENTRIES;
        }

        @JvmStatic
        public static final PositionType valueOf(int i) {
            return Companion.valueOf(i);
        }

        public static PositionType valueOf(String str) {
            return (PositionType) Enum.valueOf(PositionType.class, str);
        }

        public static PositionType[] values() {
            return (PositionType[]) $VALUES.clone();
        }

        private PositionType(String str, int i, int i2) {
            this.backendCode = i2;
        }

        public final int getBackendCode() {
            return this.backendCode;
        }

        static {
            PositionType[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
            Companion = new Companion(null);
        }

        /* compiled from: SAMPUIElement.kt */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\b"}, d2 = {"Lru/mrlargha/commonui/core/SAMPUIElement$PositionType$Companion;", "", "<init>", "()V", "valueOf", "Lru/mrlargha/commonui/core/SAMPUIElement$PositionType;", "value", "", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final PositionType valueOf(int i) {
                PositionType[] values;
                for (PositionType positionType : PositionType.values()) {
                    if (positionType.getBackendCode() == i) {
                        return positionType;
                    }
                }
                return null;
            }
        }
    }

    public void setVisibility(boolean z) {
        this.baseLayout.setVisibility(z ? 0 : 8);
        View view = this.innerView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("innerView");
            view = null;
        }
        view.setVisibility(z ? 0 : 8);
        if (this.backendID != UIElementID.RODINA_METAL_DETECTOR.getId()) {
            Activity activity = this.targetActivity;
            Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type ru.mrlargha.commonui.core.IBackendNotifier");
            ((IBackendNotifier) activity).viewShownStatusChangedWrapper(this.backendID, z);
        }
    }

    public boolean isOnScreen() {
        return this.baseLayout.getVisibility() == 0;
    }

    public final void setPosition(PositionType type, int i, int i2) {
        Intrinsics.checkNotNullParameter(type, "type");
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(this.baseLayout);
        View view = this.innerView;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("innerView");
            view = null;
        }
        constraintSet.clear(view.getId(), 3);
        View view3 = this.innerView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("innerView");
            view3 = null;
        }
        constraintSet.clear(view3.getId(), 4);
        View view4 = this.innerView;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("innerView");
            view4 = null;
        }
        constraintSet.clear(view4.getId(), 1);
        View view5 = this.innerView;
        if (view5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("innerView");
            view5 = null;
        }
        constraintSet.clear(view5.getId(), 2);
        switch (WhenMappings.$EnumSwitchMapping$0[type.ordinal()]) {
            case 1:
                View view6 = this.innerView;
                if (view6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("innerView");
                    view6 = null;
                }
                constraintSet.connect(view6.getId(), 3, this.baseLayout.getId(), 3, i);
                View view7 = this.innerView;
                if (view7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("innerView");
                } else {
                    view2 = view7;
                }
                constraintSet.connect(view2.getId(), 1, this.baseLayout.getId(), 1, i2);
                break;
            case 2:
                View view8 = this.innerView;
                if (view8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("innerView");
                    view8 = null;
                }
                constraintSet.connect(view8.getId(), 1, this.baseLayout.getId(), 1, 0);
                View view9 = this.innerView;
                if (view9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("innerView");
                    view9 = null;
                }
                constraintSet.connect(view9.getId(), 2, this.baseLayout.getId(), 2, 0);
                View view10 = this.innerView;
                if (view10 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("innerView");
                } else {
                    view2 = view10;
                }
                constraintSet.connect(view2.getId(), 3, this.baseLayout.getId(), 3, i2);
                break;
            case 3:
                View view11 = this.innerView;
                if (view11 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("innerView");
                    view11 = null;
                }
                constraintSet.connect(view11.getId(), 3, this.baseLayout.getId(), 3, i);
                View view12 = this.innerView;
                if (view12 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("innerView");
                } else {
                    view2 = view12;
                }
                constraintSet.connect(view2.getId(), 2, this.baseLayout.getId(), 2, i2);
                break;
            case 4:
                View view13 = this.innerView;
                if (view13 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("innerView");
                    view13 = null;
                }
                constraintSet.connect(view13.getId(), 1, this.baseLayout.getId(), 1, i);
                View view14 = this.innerView;
                if (view14 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("innerView");
                    view14 = null;
                }
                constraintSet.connect(view14.getId(), 3, this.baseLayout.getId(), 3, 0);
                View view15 = this.innerView;
                if (view15 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("innerView");
                } else {
                    view2 = view15;
                }
                constraintSet.connect(view2.getId(), 4, this.baseLayout.getId(), 4, 0);
                break;
            case 5:
                View view16 = this.innerView;
                if (view16 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("innerView");
                    view16 = null;
                }
                constraintSet.connect(view16.getId(), 1, this.baseLayout.getId(), 1, 0);
                View view17 = this.innerView;
                if (view17 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("innerView");
                    view17 = null;
                }
                constraintSet.connect(view17.getId(), 2, this.baseLayout.getId(), 2, 0);
                View view18 = this.innerView;
                if (view18 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("innerView");
                    view18 = null;
                }
                constraintSet.connect(view18.getId(), 3, this.baseLayout.getId(), 3, 0);
                View view19 = this.innerView;
                if (view19 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("innerView");
                } else {
                    view2 = view19;
                }
                constraintSet.connect(view2.getId(), 4, this.baseLayout.getId(), 4, 0);
                break;
            case 6:
                View view20 = this.innerView;
                if (view20 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("innerView");
                    view20 = null;
                }
                constraintSet.connect(view20.getId(), 2, this.baseLayout.getId(), 2, i);
                View view21 = this.innerView;
                if (view21 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("innerView");
                    view21 = null;
                }
                constraintSet.connect(view21.getId(), 3, this.baseLayout.getId(), 3, 0);
                View view22 = this.innerView;
                if (view22 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("innerView");
                } else {
                    view2 = view22;
                }
                constraintSet.connect(view2.getId(), 4, this.baseLayout.getId(), 4, 0);
                break;
            case 7:
                View view23 = this.innerView;
                if (view23 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("innerView");
                    view23 = null;
                }
                constraintSet.connect(view23.getId(), 1, this.baseLayout.getId(), 1, i);
                View view24 = this.innerView;
                if (view24 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("innerView");
                } else {
                    view2 = view24;
                }
                constraintSet.connect(view2.getId(), 4, this.baseLayout.getId(), 4, i2);
                break;
            case 8:
                View view25 = this.innerView;
                if (view25 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("innerView");
                    view25 = null;
                }
                constraintSet.connect(view25.getId(), 1, this.baseLayout.getId(), 1, 0);
                View view26 = this.innerView;
                if (view26 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("innerView");
                    view26 = null;
                }
                constraintSet.connect(view26.getId(), 2, this.baseLayout.getId(), 2, 0);
                View view27 = this.innerView;
                if (view27 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("innerView");
                } else {
                    view2 = view27;
                }
                constraintSet.connect(view2.getId(), 4, this.baseLayout.getId(), 4, i2);
                break;
            case 9:
                View view28 = this.innerView;
                if (view28 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("innerView");
                    view28 = null;
                }
                constraintSet.connect(view28.getId(), 2, this.baseLayout.getId(), 2, i);
                View view29 = this.innerView;
                if (view29 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("innerView");
                } else {
                    view2 = view29;
                }
                constraintSet.connect(view2.getId(), 4, this.baseLayout.getId(), 4, i2);
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        constraintSet.applyTo(this.baseLayout);
    }

    public static /* synthetic */ void addViewToConstraintLayout$default(SAMPUIElement sAMPUIElement, View view, int i, int i2, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addViewToConstraintLayout");
        }
        if ((i3 & 2) != 0) {
            i = -2;
        }
        if ((i3 & 4) != 0) {
            i2 = -2;
        }
        sAMPUIElement.addViewToConstraintLayout(view, i, i2);
    }

    public final void addViewToConstraintLayout(View view, int i, int i2) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.innerView = view;
        ConstraintLayout constraintLayout = this.baseLayout;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("innerView");
            view = null;
        }
        constraintLayout.addView(view, i, i2);
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(this.baseLayout);
        View view3 = this.innerView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("innerView");
            view3 = null;
        }
        constraintSet.connect(view3.getId(), 3, this.baseLayout.getId(), 3);
        View view4 = this.innerView;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("innerView");
            view4 = null;
        }
        constraintSet.connect(view4.getId(), 4, this.baseLayout.getId(), 4);
        View view5 = this.innerView;
        if (view5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("innerView");
            view5 = null;
        }
        constraintSet.connect(view5.getId(), 1, this.baseLayout.getId(), 1);
        View view6 = this.innerView;
        if (view6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("innerView");
        } else {
            view2 = view6;
        }
        constraintSet.connect(view2.getId(), 2, this.baseLayout.getId(), 2);
        constraintSet.applyTo(this.baseLayout);
        this.baseLayout.setOnTouchListener(new View.OnTouchListener() { // from class: ru.mrlargha.commonui.core.SAMPUIElement$$ExternalSyntheticLambda0
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view7, MotionEvent motionEvent) {
                boolean addViewToConstraintLayout$lambda$13;
                addViewToConstraintLayout$lambda$13 = SAMPUIElement.addViewToConstraintLayout$lambda$13(SAMPUIElement.this, view7, motionEvent);
                return addViewToConstraintLayout$lambda$13;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean addViewToConstraintLayout$lambda$13(SAMPUIElement sAMPUIElement, View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            view.performClick();
        }
        sAMPUIElement.onLayoutClick();
        return false;
    }

    public static /* synthetic */ void notifyClick$default(SAMPUIElement sAMPUIElement, int i, int i2, String str, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: notifyClick");
        }
        if ((i3 & 2) != 0) {
            i2 = -1;
        }
        if ((i3 & 4) != 0) {
            str = "";
        }
        sAMPUIElement.notifyClick(i, i2, str);
    }

    public final void notifyClick(int i, int i2, String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        Log.d(TAG, "Click on backendId: " + this.backendID + ", id (index key): " + i + ", subId: " + i2 + ", message: " + message);
        IBackendNotifier notifier = getNotifier();
        int i3 = this.backendID;
        byte[] bytes = message.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        notifier.clickedWrapper(i3, i, i2, bytes);
    }

    public final void removeFromLayout() {
        Activity activity = this.targetActivity;
        Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type ru.mrlargha.commonui.core.IBackendNotifier");
        ((IBackendNotifier) activity).viewShownStatusChangedWrapper(this.backendID, false);
        ConstraintLayout constraintLayout = this.baseLayout;
        View view = this.innerView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("innerView");
            view = null;
        }
        constraintLayout.removeView(view);
        if (this.baseLayout.getParent() != null) {
            ViewParent parent = this.baseLayout.getParent();
            ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
            if (viewGroup != null) {
                viewGroup.removeView(this.baseLayout);
            }
        }
    }

    public final int getViewId() {
        return this.baseLayout.getId();
    }

    public static /* synthetic */ void bindBackendClick$default(SAMPUIElement sAMPUIElement, View view, int i, int i2, String str, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: bindBackendClick");
        }
        if ((i3 & 2) != 0) {
            i2 = -1;
        }
        if ((i3 & 4) != 0) {
            str = "";
        }
        sAMPUIElement.bindBackendClick(view, i, i2, str);
    }

    public final void bindBackendClick(View view, final int i, final int i2, final String message) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(message, "message");
        view.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.core.SAMPUIElement$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                SAMPUIElement.bindBackendClick$lambda$14(SAMPUIElement.this, i, i2, message, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindBackendClick$lambda$14(SAMPUIElement sAMPUIElement, int i, int i2, String str, View view) {
        Log.d(TAG, "Click on backendId: " + sAMPUIElement.backendID + ",  viewId: " + i + ", subId: " + i2 + ", message: " + str);
        IBackendNotifier notifier = sAMPUIElement.getNotifier();
        int i3 = sAMPUIElement.backendID;
        byte[] bytes = str.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        notifier.clickedWrapper(i3, i, i2, bytes);
    }

    public final void gone(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        view.setVisibility(8);
    }

    public final void show(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        view.setVisibility(0);
    }

    public static /* synthetic */ void bindBackendClick$default(SAMPUIElement sAMPUIElement, View view, int i, int i2, Function0 function0, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: bindBackendClick");
        }
        if ((i3 & 2) != 0) {
            i2 = -1;
        }
        sAMPUIElement.bindBackendClick(view, i, i2, function0);
    }

    public final void bindBackendClick(View view, final int i, final int i2, final Function0<String> message) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(message, "message");
        view.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.core.SAMPUIElement$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                SAMPUIElement.bindBackendClick$lambda$15(SAMPUIElement.this, i, i2, message, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindBackendClick$lambda$15(SAMPUIElement sAMPUIElement, int i, int i2, Function0 function0, View view) {
        Log.d(TAG, "Click on backendId: " + sAMPUIElement.backendID + ", id: " + i + ", subId: " + i2 + ", message: lambda function");
        IBackendNotifier notifier = sAMPUIElement.getNotifier();
        int i3 = sAMPUIElement.backendID;
        byte[] bytes = ((String) function0.invoke()).getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        notifier.clickedWrapper(i3, i, i2, bytes);
    }
}
