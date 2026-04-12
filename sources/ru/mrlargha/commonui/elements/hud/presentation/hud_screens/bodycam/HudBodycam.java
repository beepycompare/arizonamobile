package ru.mrlargha.commonui.elements.hud.presentation.hud_screens.bodycam;

import android.util.Log;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.core.app.NotificationCompat;
import com.google.gson.JsonParseException;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import ru.mrlargha.commonui.databinding.HudBodycamBinding;
import ru.mrlargha.commonui.databinding.HudPageBinding;
import ru.mrlargha.commonui.utils.MapperKt;
import ru.mrlargha.commonui.utils.UtilsKt;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
/* compiled from: HudBodycam.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\t\u0018\u0000  2\u00020\u0001:\u0001 B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0018\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u0012H\u0002J\f\u0010\u001d\u001a\u00020\u0018*\u00020\u0018H\u0002J\b\u0010\u001e\u001a\u00020\u0010H\u0002J\b\u0010\u001f\u001a\u00020\u0010H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/bodycam/HudBodycam;", "", "hudBinding", "Lru/mrlargha/commonui/databinding/HudPageBinding;", "<init>", "(Lru/mrlargha/commonui/databinding/HudPageBinding;)V", "getHudBinding", "()Lru/mrlargha/commonui/databinding/HudPageBinding;", "binding", "Lru/mrlargha/commonui/databinding/HudBodycamBinding;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "timerJob", "Lkotlinx/coroutines/Job;", "serverTimerJob", NotificationCompat.CATEGORY_EVENT, "", "data", "", "show", CommonUrlParts.MODEL, "Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/bodycam/HudBodycamModel;", "startTimer", "currentTime", "", "startServerTimer", "timeConvertor", "timestamp", "format", "toSecondsOfDay", "hide", "stopTimer", "Companion", "CommonUI"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class HudBodycam {
    public static final Companion Companion = new Companion(null);
    private static final long SECOND = 1000;
    private static final String TIME_DATE_FORMAT = "dd-MM-yyyy";
    private final HudBodycamBinding binding;
    private final HudPageBinding hudBinding;
    private final CoroutineScope scope;
    private Job serverTimerJob;
    private Job timerJob;

    public HudBodycam(HudPageBinding hudBinding) {
        Intrinsics.checkNotNullParameter(hudBinding, "hudBinding");
        this.hudBinding = hudBinding;
        HudBodycamBinding bodycam = hudBinding.bodycam;
        Intrinsics.checkNotNullExpressionValue(bodycam, "bodycam");
        this.binding = bodycam;
        this.scope = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain());
    }

    public final HudPageBinding getHudBinding() {
        return this.hudBinding;
    }

    private final void show(HudBodycamModel hudBodycamModel) {
        HudBodycamBinding hudBodycamBinding = this.binding;
        CustomCardView root = hudBodycamBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        root.setVisibility(0);
        hudBodycamBinding.tvNumber.setText("#" + hudBodycamModel.getNumber());
        hudBodycamBinding.tvStartDate.setText(timeConvertor(hudBodycamModel.getTimestamp(), TIME_DATE_FORMAT));
        HudPageBinding hudPageBinding = this.hudBinding;
        hudPageBinding.rouletteContainer.setVisibility(8);
        hudPageBinding.rouletteTimeContainer.setVisibility(8);
        startTimer(hudBodycamModel.getSeconds());
        startServerTimer(toSecondsOfDay(hudBodycamModel.getTimestamp()));
        LinearLayout locationContainer = this.hudBinding.locationContainer;
        Intrinsics.checkNotNullExpressionValue(locationContainer, "locationContainer");
        locationContainer.setVisibility(8);
        FrameLayout bgForLocation = this.hudBinding.bgForLocation;
        Intrinsics.checkNotNullExpressionValue(bgForLocation, "bgForLocation");
        bgForLocation.setVisibility(8);
    }

    private final void startTimer(long j) {
        Job launch$default;
        Job job = this.timerJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        launch$default = BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new HudBodycam$startTimer$1(j, this, null), 3, null);
        this.timerJob = launch$default;
    }

    private final void startServerTimer(long j) {
        Job launch$default;
        Job job = this.serverTimerJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        launch$default = BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new HudBodycam$startServerTimer$1(j, this, null), 3, null);
        this.serverTimerJob = launch$default;
    }

    private final String timeConvertor(long j, String str) {
        Date date = new Date(j * 1000);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, Locale.getDefault());
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("Europe/Moscow"));
        String format = simpleDateFormat.format(date);
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return format;
    }

    private final long toSecondsOfDay(long j) {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("Europe/Moscow"));
        long j2 = 1000;
        calendar.setTime(new Date(j * j2));
        int i = calendar.get(11);
        int i2 = calendar.get(12);
        int i3 = calendar.get(13);
        Log.d("Tag", "toSecondsOfDay: " + i + " " + i2 + " " + i3);
        return ((i * 3600) + (i2 * 60) + i3) * j2;
    }

    private final void hide() {
        CustomCardView root = this.binding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        root.setVisibility(8);
        if (UtilsKt.isArizonaType()) {
            LinearLayout locationContainer = this.hudBinding.locationContainer;
            Intrinsics.checkNotNullExpressionValue(locationContainer, "locationContainer");
            locationContainer.setVisibility(0);
            FrameLayout bgForLocation = this.hudBinding.bgForLocation;
            Intrinsics.checkNotNullExpressionValue(bgForLocation, "bgForLocation");
            bgForLocation.setVisibility(0);
        }
        stopTimer();
    }

    private final void stopTimer() {
        Job job = this.timerJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.timerJob = null;
        Job job2 = this.serverTimerJob;
        if (job2 != null) {
            Job.DefaultImpls.cancel$default(job2, (CancellationException) null, 1, (Object) null);
        }
        this.serverTimerJob = null;
    }

    /* compiled from: HudBodycam.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/bodycam/HudBodycam$Companion;", "", "<init>", "()V", "TIME_DATE_FORMAT", "", "SECOND", "", "CommonUI"}, k = 1, mv = {2, 3, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final void event(String data) {
        Intrinsics.checkNotNullParameter(data, "data");
        try {
            if (MapperKt.isJsonValid(data)) {
                show((HudBodycamModel) MapperKt.getGson().fromJson(data, (Class<Object>) HudBodycamModel.class));
                return;
            }
            throw new JsonParseException("Json is not valid");
        } catch (Exception unused) {
            hide();
        }
    }
}
