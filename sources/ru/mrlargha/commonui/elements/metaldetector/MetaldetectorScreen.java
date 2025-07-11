package ru.mrlargha.commonui.elements.metaldetector;

import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.runtime.ComposerKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.core.SAMPUIElement;
import ru.mrlargha.commonui.core.UIElementAbstractSpawner;
import ru.mrlargha.commonui.databinding.MetaldetectorScreenBinding;
import ru.mrlargha.commonui.elements.quest.GsonStore;
import ru.mrlargha.commonui.elements.quest.RodinaSerializableData;
/* compiled from: MetaldetectorScreen.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0002\u0019\u001aB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0005H\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n \u0011*\u0004\u0018\u00010\u00100\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lru/mrlargha/commonui/elements/metaldetector/MetaldetectorScreen;", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "<init>", "(Landroid/app/Activity;I)V", "screenLayout", "Landroidx/constraintlayout/widget/ConstraintLayout;", "binding", "Lru/mrlargha/commonui/databinding/MetaldetectorScreenBinding;", "lastDuration", "", "lastLevel", "sharedPref", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "isArizonaType", "", "onBackendMessage", "", "data", "", "subId", "MetaldetectorData", "Spawner", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MetaldetectorScreen extends SAMPUIElement {
    private final MetaldetectorScreenBinding binding;
    private final boolean isArizonaType;
    private float lastDuration;
    private int lastLevel;
    private final ConstraintLayout screenLayout;
    private final SharedPreferences sharedPref;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MetaldetectorScreen(Activity targetActivity, int i) {
        super(targetActivity, i);
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        View inflate = targetActivity.getLayoutInflater().inflate(R.layout.metaldetector_screen, (ViewGroup) null);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
        ConstraintLayout constraintLayout = (ConstraintLayout) inflate;
        this.screenLayout = constraintLayout;
        MetaldetectorScreenBinding bind = MetaldetectorScreenBinding.bind(constraintLayout);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        this.binding = bind;
        this.lastDuration = 1.0f;
        SharedPreferences sharedPreferences = targetActivity.getSharedPreferences("flavorType", 0);
        this.sharedPref = sharedPreferences;
        this.isArizonaType = sharedPreferences.getBoolean("isArizonaType", false);
        addViewToConstraintLayout(constraintLayout, -1, -1);
        MaterialButton digButton = bind.digButton;
        Intrinsics.checkNotNullExpressionValue(digButton, "digButton");
        SAMPUIElement.bindBackendClick$default(this, digButton, 0, 0, (String) null, 6, (Object) null);
    }

    /* compiled from: MetaldetectorScreen.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\fJ&\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\f¨\u0006\u0019"}, d2 = {"Lru/mrlargha/commonui/elements/metaldetector/MetaldetectorScreen$MetaldetectorData;", "Lru/mrlargha/commonui/elements/quest/RodinaSerializableData;", TypedValues.TransitionType.S_DURATION, "", FirebaseAnalytics.Param.LEVEL, "", "<init>", "(Ljava/lang/Float;Ljava/lang/Integer;)V", "getDuration", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getLevel", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "copy", "(Ljava/lang/Float;Ljava/lang/Integer;)Lru/mrlargha/commonui/elements/metaldetector/MetaldetectorScreen$MetaldetectorData;", "equals", "", "other", "", "hashCode", "toString", "", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    private static final class MetaldetectorData implements RodinaSerializableData {
        private final Float duration;
        private final Integer level;

        public static /* synthetic */ MetaldetectorData copy$default(MetaldetectorData metaldetectorData, Float f, Integer num, int i, Object obj) {
            if ((i & 1) != 0) {
                f = metaldetectorData.duration;
            }
            if ((i & 2) != 0) {
                num = metaldetectorData.level;
            }
            return metaldetectorData.copy(f, num);
        }

        public final Float component1() {
            return this.duration;
        }

        public final Integer component2() {
            return this.level;
        }

        public final MetaldetectorData copy(Float f, Integer num) {
            return new MetaldetectorData(f, num);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof MetaldetectorData) {
                MetaldetectorData metaldetectorData = (MetaldetectorData) obj;
                return Intrinsics.areEqual((Object) this.duration, (Object) metaldetectorData.duration) && Intrinsics.areEqual(this.level, metaldetectorData.level);
            }
            return false;
        }

        public int hashCode() {
            Float f = this.duration;
            int hashCode = (f == null ? 0 : f.hashCode()) * 31;
            Integer num = this.level;
            return hashCode + (num != null ? num.hashCode() : 0);
        }

        public String toString() {
            Float f = this.duration;
            return "MetaldetectorData(duration=" + f + ", level=" + this.level + ")";
        }

        public MetaldetectorData(Float f, Integer num) {
            this.duration = f;
            this.level = num;
        }

        public final Float getDuration() {
            return this.duration;
        }

        public final Integer getLevel() {
            return this.level;
        }
    }

    /* compiled from: MetaldetectorScreen.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lru/mrlargha/commonui/elements/metaldetector/MetaldetectorScreen$Spawner;", "Lru/mrlargha/commonui/core/UIElementAbstractSpawner;", "<init>", "()V", "create", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Spawner extends UIElementAbstractSpawner {
        @Override // ru.mrlargha.commonui.core.UIElementAbstractSpawner
        public SAMPUIElement create(Activity targetActivity, int i) {
            Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
            return new MetaldetectorScreen(targetActivity, i);
        }
    }

    @Override // ru.mrlargha.commonui.core.SAMPUIElement
    public void onBackendMessage(String data, int i) {
        Intrinsics.checkNotNullParameter(data, "data");
        Object fromJson = GsonStore.INSTANCE.getGson().fromJson(data, (Class<Object>) MetaldetectorData.class);
        Intrinsics.checkNotNullExpressionValue(fromJson, "fromJson(...)");
        MetaldetectorData metaldetectorData = (MetaldetectorData) ((RodinaSerializableData) fromJson);
        Float duration = metaldetectorData.getDuration();
        float floatValue = duration != null ? duration.floatValue() : this.lastDuration;
        Integer level = metaldetectorData.getLevel();
        int intValue = level != null ? level.intValue() : this.lastLevel;
        this.binding.locatorView.setupAnimation(floatValue * 1000.0f, intValue - 1);
        Float duration2 = metaldetectorData.getDuration();
        if (duration2 != null) {
            this.lastDuration = duration2.floatValue();
        }
        Integer level2 = metaldetectorData.getLevel();
        if (level2 != null) {
            this.lastLevel = level2.intValue();
            if (intValue == 1) {
                this.binding.imageView37.setColorFilter(this.isArizonaType ? Color.rgb(89, 232, 39) : Color.rgb(255, (int) ComposerKt.providerMapsKey, 51));
            } else if (intValue == 2) {
                this.binding.imageView37.setColorFilter(this.isArizonaType ? Color.rgb(255, (int) ComposerKt.providerMapsKey, 51) : Color.parseColor("#59E827"));
            } else if (intValue == 3) {
                this.binding.imageView37.setColorFilter(this.isArizonaType ? Color.rgb(240, 108, 13) : Color.rgb(255, 33, 33));
            } else if (intValue == 4) {
                if (this.isArizonaType) {
                    this.binding.imageView37.setColorFilter(Color.rgb(255, 255, 255));
                }
            } else if (intValue == 5 && this.isArizonaType) {
                this.binding.imageView37.setColorFilter(Color.rgb(215, 14, 14));
            }
        }
    }
}
