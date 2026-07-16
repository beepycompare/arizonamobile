package ru.mrlargha.commonui.elements.hud.presentation.hud_screens.gathers_count;

import android.widget.FrameLayout;
import android.widget.TextView;
import com.google.gson.JsonParseException;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import java.util.Arrays;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.databinding.HudGathersCountBinding;
import ru.mrlargha.commonui.utils.MapperKt;
/* compiled from: HudGathersCount.kt */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0012\u0010\u0017\u001a\u00020\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\u0018H\u0002J\u0010\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0010\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\b\u0010\u001d\u001a\u00020\u0010H\u0002J\b\u0010\u001e\u001a\u00020\u0010H\u0002J\b\u0010\u001f\u001a\u00020\u0010H\u0002J\u0012\u0010 \u001a\u00020\u0010*\u00020!2\u0006\u0010\u001a\u001a\u00020\u001bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/gathers_count/HudGathersCount;", "", "binding", "Lru/mrlargha/commonui/databinding/HudGathersCountBinding;", "<init>", "(Lru/mrlargha/commonui/databinding/HudGathersCountBinding;)V", "getBinding", "()Lru/mrlargha/commonui/databinding/HudGathersCountBinding;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "jobTimer", "Lkotlinx/coroutines/Job;", "jobDebuffTimer", "adapter", "Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/gathers_count/HudGathersCountAdapter;", "event", "", "data", "", "show", CommonUrlParts.MODEL, "Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/gathers_count/HudGathersCountModel;", "update", "setDebuff", "Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/gathers_count/HudGathersCountDebuff;", "startTimer", "time", "", "startDebuffTimer", "hide", "stopTimer", "stopDebuffTimer", "timeConvertor", "Landroid/widget/TextView;", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class HudGathersCount {
    private HudGathersCountAdapter adapter;
    private final HudGathersCountBinding binding;
    private Job jobDebuffTimer;
    private Job jobTimer;
    private final CoroutineScope scope;

    /* compiled from: HudGathersCount.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[HudGathersCountDebuffType.values().length];
            try {
                iArr[HudGathersCountDebuffType.FROZEN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[HudGathersCountDebuffType.BLIND.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public HudGathersCount(HudGathersCountBinding binding) {
        Intrinsics.checkNotNullParameter(binding, "binding");
        this.binding = binding;
        this.scope = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain());
        this.adapter = new HudGathersCountAdapter();
        FrameLayout root = binding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        root.setVisibility(8);
    }

    public final HudGathersCountBinding getBinding() {
        return this.binding;
    }

    private final void show(HudGathersCountModel hudGathersCountModel) {
        HudGathersCountBinding hudGathersCountBinding = this.binding;
        FrameLayout root = hudGathersCountBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        root.setVisibility(0);
        hudGathersCountBinding.rvBonus.setAdapter(this.adapter);
        startTimer(hudGathersCountModel.getTime());
        update(hudGathersCountModel);
    }

    private final void update(HudGathersCountModel hudGathersCountModel) {
        this.adapter.submitList(hudGathersCountModel.getBonuses());
        setDebuff((HudGathersCountDebuff) CollectionsKt.getOrNull(hudGathersCountModel.getDebuffs(), 0));
    }

    private final void setDebuff(HudGathersCountDebuff hudGathersCountDebuff) {
        HudGathersCountBinding hudGathersCountBinding = this.binding;
        if (hudGathersCountDebuff != null) {
            FrameLayout debuffContainer = hudGathersCountBinding.debuffContainer;
            Intrinsics.checkNotNullExpressionValue(debuffContainer, "debuffContainer");
            debuffContainer.setVisibility(0);
            startDebuffTimer(hudGathersCountDebuff.getTime());
            hudGathersCountBinding.tvDebuff.setText(hudGathersCountDebuff.getTitle());
            int i = WhenMappings.$EnumSwitchMapping$0[hudGathersCountDebuff.m11853getType().ordinal()];
            if (i == 1) {
                hudGathersCountBinding.ivDebuffBg.setImageResource(R.drawable.hud_gathers_count_frozen_item_bg);
                hudGathersCountBinding.ivDebuffIc.setImageResource(R.drawable.hud_gathers_count_ic_snow);
                return;
            } else if (i != 2) {
                throw new NoWhenBranchMatchedException();
            } else {
                hudGathersCountBinding.ivDebuffBg.setImageResource(R.drawable.hud_gathers_count_blinding_item_bg);
                hudGathersCountBinding.ivDebuffIc.setImageResource(R.drawable.hud_gathers_count_ic_blindness);
                return;
            }
        }
        FrameLayout debuffContainer2 = hudGathersCountBinding.debuffContainer;
        Intrinsics.checkNotNullExpressionValue(debuffContainer2, "debuffContainer");
        debuffContainer2.setVisibility(8);
        stopDebuffTimer();
    }

    private final void startTimer(int i) {
        Job launch$default;
        HudGathersCountBinding hudGathersCountBinding = this.binding;
        Job job = this.jobTimer;
        if (job != null) {
            Job.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        launch$default = BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new HudGathersCount$startTimer$1$1(i, this, hudGathersCountBinding, null), 3, null);
        this.jobTimer = launch$default;
    }

    private final void startDebuffTimer(int i) {
        Job launch$default;
        HudGathersCountBinding hudGathersCountBinding = this.binding;
        Job job = this.jobDebuffTimer;
        if (job != null) {
            Job.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        launch$default = BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new HudGathersCount$startDebuffTimer$1$1(i, this, hudGathersCountBinding, null), 3, null);
        this.jobDebuffTimer = launch$default;
    }

    private final void hide() {
        FrameLayout root = this.binding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        root.setVisibility(8);
        stopTimer();
        stopDebuffTimer();
    }

    private final void stopTimer() {
        Job job = this.jobTimer;
        if (job != null) {
            Job.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.jobTimer = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void stopDebuffTimer() {
        Job job = this.jobDebuffTimer;
        if (job != null) {
            Job.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.jobDebuffTimer = null;
    }

    public final void timeConvertor(TextView textView, int i) {
        Intrinsics.checkNotNullParameter(textView, "<this>");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("%02d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(i / 60), Integer.valueOf(i % 60)}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        textView.setText(format);
    }

    public final void event(String data) {
        Intrinsics.checkNotNullParameter(data, "data");
        try {
            if (MapperKt.isJsonValid(data)) {
                HudGathersCountModel hudGathersCountModel = (HudGathersCountModel) MapperKt.getGson().fromJson(data, (Class<Object>) HudGathersCountModel.class);
                FrameLayout root = this.binding.getRoot();
                Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
                if (root.getVisibility() == 0) {
                    update(hudGathersCountModel);
                    return;
                } else {
                    show(hudGathersCountModel);
                    return;
                }
            }
            throw new JsonParseException("Json is not valid");
        } catch (Exception unused) {
            hide();
        }
    }
}
