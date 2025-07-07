package ru.mrlargha.commonui.elements;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.core.SAMPUIElement;
import ru.mrlargha.commonui.databinding.ArizonaSnackbarBinding;
import ru.mrlargha.commonui.elements.ArizonaSnackbar;
import ru.mrlargha.commonui.utils.MapperKt;
/* compiled from: ArizonaSnackbar.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 \u00172\u00020\u0001:\u0004\u0014\u0015\u0016\u0017B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0018\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0007H\u0016R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lru/mrlargha/commonui/elements/ArizonaSnackbar;", "Lru/mrlargha/commonui/core/SAMPUIElement;", "data", "", "targetActivity", "Landroid/app/Activity;", "backendID", "", "<init>", "(Ljava/lang/String;Landroid/app/Activity;I)V", "handler", "Landroid/os/Handler;", "rootLayout", "Landroidx/constraintlayout/widget/ConstraintLayout;", "binding", "Lru/mrlargha/commonui/databinding/ArizonaSnackbarBinding;", "showSnackbar", "", "onBackendMessage", "subId", "SnackbarModel", "Styles", "SnackBarListener", "Companion", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ArizonaSnackbar extends SAMPUIElement {
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "ArizonaSnackbar";
    private final ArizonaSnackbarBinding binding;
    private final Handler handler;
    private final ConstraintLayout rootLayout;

    /* compiled from: ArizonaSnackbar.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lru/mrlargha/commonui/elements/ArizonaSnackbar$SnackBarListener;", "", "asDestroy", "", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface SnackBarListener {
        void asDestroy();
    }

    /* compiled from: ArizonaSnackbar.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Styles.values().length];
            try {
                iArr[Styles.Info.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Styles.Success.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Styles.Error.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArizonaSnackbar(String data, Activity targetActivity, int i) {
        super(targetActivity, i);
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        this.handler = new Handler(Looper.getMainLooper());
        View inflate = targetActivity.getLayoutInflater().inflate(R.layout.arizona_snackbar, (ViewGroup) null);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
        ConstraintLayout constraintLayout = (ConstraintLayout) inflate;
        this.rootLayout = constraintLayout;
        ArizonaSnackbarBinding bind = ArizonaSnackbarBinding.bind(constraintLayout);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        this.binding = bind;
        if (!Intrinsics.areEqual(data, "")) {
            showSnackbar(data);
        }
        addViewToConstraintLayout(constraintLayout, -1, -1);
        setVisibility(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ArizonaSnackbar.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0082\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\bHÆ\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001c"}, d2 = {"Lru/mrlargha/commonui/elements/ArizonaSnackbar$SnackbarModel;", "", "styleInt", "", "title", "", "text", TypedValues.TransitionType.S_DURATION, "", "<init>", "(ILjava/lang/String;Ljava/lang/String;J)V", "getStyleInt", "()I", "getTitle", "()Ljava/lang/String;", "getText", "getDuration", "()J", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class SnackbarModel {
        private final long duration;
        private final int styleInt;
        private final String text;
        private final String title;

        public static /* synthetic */ SnackbarModel copy$default(SnackbarModel snackbarModel, int i, String str, String str2, long j, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = snackbarModel.styleInt;
            }
            if ((i2 & 2) != 0) {
                str = snackbarModel.title;
            }
            if ((i2 & 4) != 0) {
                str2 = snackbarModel.text;
            }
            if ((i2 & 8) != 0) {
                j = snackbarModel.duration;
            }
            String str3 = str2;
            return snackbarModel.copy(i, str, str3, j);
        }

        public final int component1() {
            return this.styleInt;
        }

        public final String component2() {
            return this.title;
        }

        public final String component3() {
            return this.text;
        }

        public final long component4() {
            return this.duration;
        }

        public final SnackbarModel copy(int i, String title, String text, long j) {
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(text, "text");
            return new SnackbarModel(i, title, text, j);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof SnackbarModel) {
                SnackbarModel snackbarModel = (SnackbarModel) obj;
                return this.styleInt == snackbarModel.styleInt && Intrinsics.areEqual(this.title, snackbarModel.title) && Intrinsics.areEqual(this.text, snackbarModel.text) && this.duration == snackbarModel.duration;
            }
            return false;
        }

        public int hashCode() {
            return (((((Integer.hashCode(this.styleInt) * 31) + this.title.hashCode()) * 31) + this.text.hashCode()) * 31) + Long.hashCode(this.duration);
        }

        public String toString() {
            int i = this.styleInt;
            String str = this.title;
            String str2 = this.text;
            return "SnackbarModel(styleInt=" + i + ", title=" + str + ", text=" + str2 + ", duration=" + this.duration + ")";
        }

        public SnackbarModel(int i, String title, String text, long j) {
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(text, "text");
            this.styleInt = i;
            this.title = title;
            this.text = text;
            this.duration = j;
        }

        public final int getStyleInt() {
            return this.styleInt;
        }

        public final String getTitle() {
            return this.title;
        }

        public final String getText() {
            return this.text;
        }

        public final long getDuration() {
            return this.duration;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: ArizonaSnackbar.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lru/mrlargha/commonui/elements/ArizonaSnackbar$Styles;", "", "id", "", "<init>", "(Ljava/lang/String;II)V", "getId", "()I", "Info", "Success", "Error", "Companion", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Styles {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Styles[] $VALUES;
        public static final Companion Companion;
        private final int id;
        public static final Styles Info = new Styles("Info", 0, 0);
        public static final Styles Success = new Styles("Success", 1, 1);
        public static final Styles Error = new Styles("Error", 2, 2);

        private static final /* synthetic */ Styles[] $values() {
            return new Styles[]{Info, Success, Error};
        }

        public static EnumEntries<Styles> getEntries() {
            return $ENTRIES;
        }

        private Styles(String str, int i, int i2) {
            this.id = i2;
        }

        public final int getId() {
            return this.id;
        }

        static {
            Styles[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
            Companion = new Companion(null);
        }

        /* compiled from: ArizonaSnackbar.kt */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lru/mrlargha/commonui/elements/ArizonaSnackbar$Styles$Companion;", "", "<init>", "()V", "getStyle", "Lru/mrlargha/commonui/elements/ArizonaSnackbar$Styles;", "id", "", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final Styles getStyle(int i) {
                for (Styles styles : Styles.getEntries()) {
                    if (styles.getId() == i) {
                        return styles;
                    }
                }
                Log.w(ArizonaSnackbar.TAG, "Incorrect style id for snack-bar - " + i);
                return Styles.Info;
            }
        }

        public static Styles valueOf(String str) {
            return (Styles) Enum.valueOf(Styles.class, str);
        }

        public static Styles[] values() {
            return (Styles[]) $VALUES.clone();
        }
    }

    private final void showSnackbar(String str) {
        int i;
        try {
            SnackbarModel snackbarModel = (SnackbarModel) MapperKt.toModel(str, SnackbarModel.class);
            this.handler.removeCallbacksAndMessages(null);
            ArizonaSnackbarBinding arizonaSnackbarBinding = this.binding;
            arizonaSnackbarBinding.snackText.setText(snackbarModel.getText());
            arizonaSnackbarBinding.snackTitle.setText(snackbarModel.getTitle());
            if (StringsKt.isBlank(snackbarModel.getTitle())) {
                arizonaSnackbarBinding.snackTitle.setVisibility(8);
            }
            Styles style = Styles.Companion.getStyle(snackbarModel.getStyleInt());
            AppCompatImageView appCompatImageView = arizonaSnackbarBinding.snackbarBg;
            int i2 = WhenMappings.$EnumSwitchMapping$0[style.ordinal()];
            if (i2 == 1) {
                i = R.drawable.info_snackbar_bg;
            } else if (i2 == 2) {
                i = R.drawable.success_snackbar_bg;
            } else if (i2 != 3) {
                throw new NoWhenBranchMatchedException();
            } else {
                i = R.drawable.error_snackbar_bg;
            }
            appCompatImageView.setImageResource(i);
            this.handler.postDelayed(new Runnable() { // from class: ru.mrlargha.commonui.elements.ArizonaSnackbar$showSnackbar$$inlined$postDelayed$default$1
                @Override // java.lang.Runnable
                public final void run() {
                    Activity targetActivity;
                    targetActivity = ArizonaSnackbar.this.getTargetActivity();
                    Intrinsics.checkNotNull(targetActivity, "null cannot be cast to non-null type ru.mrlargha.commonui.elements.ArizonaSnackbar.SnackBarListener");
                    ((ArizonaSnackbar.SnackBarListener) targetActivity).asDestroy();
                }
            }, snackbarModel.getDuration());
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(TAG, "JSon wasn't correctly");
        }
    }

    @Override // ru.mrlargha.commonui.core.SAMPUIElement
    public void onBackendMessage(String data, int i) {
        Intrinsics.checkNotNullParameter(data, "data");
        showSnackbar(data);
    }

    /* compiled from: ArizonaSnackbar.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lru/mrlargha/commonui/elements/ArizonaSnackbar$Companion;", "", "<init>", "()V", "TAG", "", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
