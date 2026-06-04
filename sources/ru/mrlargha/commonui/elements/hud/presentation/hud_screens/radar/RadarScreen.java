package ru.mrlargha.commonui.elements.hud.presentation.hud_screens.radar;

import android.view.View;
import android.widget.FrameLayout;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.core.IBackendNotifier;
import ru.mrlargha.commonui.databinding.HudRadarScreenBinding;
import ru.mrlargha.commonui.elements.quest.GsonStore;
import ru.mrlargha.commonui.elements.quest.RodinaSerializableData;
/* compiled from: RadarScreen.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0018B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J\u0010\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010\u0016\u001a\u00020\u0012H\u0002J\u0010\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/radar/RadarScreen;", "", "binding", "Lru/mrlargha/commonui/databinding/HudRadarScreenBinding;", "backendID", "", "notifier", "Lru/mrlargha/commonui/core/IBackendNotifier;", "<init>", "(Lru/mrlargha/commonui/databinding/HudRadarScreenBinding;ILru/mrlargha/commonui/core/IBackendNotifier;)V", "getBinding", "()Lru/mrlargha/commonui/databinding/HudRadarScreenBinding;", "getNotifier", "()Lru/mrlargha/commonui/core/IBackendNotifier;", "lastDuration", "", "lastLevel", "getEvent", "", "data", "", "showRadar", "hideRadar", "updateDuration", "MetaldetectorData", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class RadarScreen {
    private final HudRadarScreenBinding binding;
    private float lastDuration;
    private int lastLevel;
    private final IBackendNotifier notifier;

    public RadarScreen(HudRadarScreenBinding binding, final int i, IBackendNotifier notifier) {
        Intrinsics.checkNotNullParameter(binding, "binding");
        Intrinsics.checkNotNullParameter(notifier, "notifier");
        this.binding = binding;
        this.notifier = notifier;
        this.lastDuration = 1.0f;
        binding.btnUnlock.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.hud.presentation.hud_screens.radar.RadarScreen$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RadarScreen.this.notifier.clickedWrapper(i, 61, 61);
            }
        });
    }

    public final HudRadarScreenBinding getBinding() {
        return this.binding;
    }

    public final IBackendNotifier getNotifier() {
        return this.notifier;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: RadarScreen.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\fJ&\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0011J\u0014\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0083\u0004J\n\u0010\u0016\u001a\u00020\u0005HÖ\u0081\u0004J\n\u0010\u0017\u001a\u00020\u0018HÖ\u0081\u0004R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\f¨\u0006\u0019"}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/radar/RadarScreen$MetaldetectorData;", "Lru/mrlargha/commonui/elements/quest/RodinaSerializableData;", TypedValues.TransitionType.S_DURATION, "", FirebaseAnalytics.Param.LEVEL, "", "<init>", "(Ljava/lang/Float;Ljava/lang/Integer;)V", "getDuration", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getLevel", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "copy", "(Ljava/lang/Float;Ljava/lang/Integer;)Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/radar/RadarScreen$MetaldetectorData;", "equals", "", "other", "", "hashCode", "toString", "", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class MetaldetectorData implements RodinaSerializableData {
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

    private final void showRadar(String str) {
        FrameLayout root = this.binding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        root.setVisibility(0);
        updateDuration(str);
    }

    private final void hideRadar() {
        FrameLayout root = this.binding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        root.setVisibility(8);
    }

    public final void getEvent(String data) {
        MetaldetectorData metaldetectorData;
        Intrinsics.checkNotNullParameter(data, "data");
        try {
            Object fromJson = GsonStore.INSTANCE.getGson().fromJson(data, (Class<Object>) MetaldetectorData.class);
            Intrinsics.checkNotNullExpressionValue(fromJson, "fromJson(...)");
            metaldetectorData = (MetaldetectorData) ((RodinaSerializableData) fromJson);
        } catch (Exception unused) {
            metaldetectorData = null;
        }
        if (metaldetectorData == null) {
            hideRadar();
            return;
        }
        Integer level = metaldetectorData.getLevel();
        if (level != null && level.intValue() == -1) {
            hideRadar();
            return;
        }
        FrameLayout root = this.binding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        if (root.getVisibility() == 0) {
            updateDuration(data);
        } else {
            showRadar(data);
        }
    }

    private final void updateDuration(String str) {
        Object fromJson = GsonStore.INSTANCE.getGson().fromJson(str, (Class<Object>) MetaldetectorData.class);
        Intrinsics.checkNotNullExpressionValue(fromJson, "fromJson(...)");
        MetaldetectorData metaldetectorData = (MetaldetectorData) ((RodinaSerializableData) fromJson);
        Float duration = metaldetectorData.getDuration();
        float floatValue = duration != null ? duration.floatValue() : this.lastDuration;
        Integer level = metaldetectorData.getLevel();
        this.binding.locatorView.setupAnimation(floatValue * 1000.0f, level != null ? level.intValue() : this.lastLevel);
        Float duration2 = metaldetectorData.getDuration();
        if (duration2 != null) {
            this.lastDuration = duration2.floatValue();
        }
    }
}
