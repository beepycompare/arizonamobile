package ru.mrlargha.commonui.elements.hud.presentation.hud_screens.case_timer;

import android.os.CountDownTimer;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import com.google.gson.JsonParseException;
import com.miami.game.core.connection.resolver.FirebaseConfigHelper;
import com.squareup.picasso.Picasso;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import ru.mrlargha.commonui.core.SAMPUIElement;
import ru.mrlargha.commonui.databinding.HudElementCasesTimerBinding;
import ru.mrlargha.commonui.utils.MapperKt;
import ru.mrlargha.commonui.utils.TimeConverterKt;
/* compiled from: CaseTimer.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012J\u0010\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0014H\u0002J\b\u0010\u0015\u001a\u00020\u000fH\u0002J\u0006\u0010\u0016\u001a\u00020\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/case_timer/CaseTimerElement;", "", "binding", "Lru/mrlargha/commonui/databinding/HudElementCasesTimerBinding;", "notifier", "Lru/mrlargha/commonui/core/SAMPUIElement;", "<init>", "(Lru/mrlargha/commonui/databinding/HudElementCasesTimerBinding;Lru/mrlargha/commonui/core/SAMPUIElement;)V", "getBinding", "()Lru/mrlargha/commonui/databinding/HudElementCasesTimerBinding;", "getNotifier", "()Lru/mrlargha/commonui/core/SAMPUIElement;", "timer", "Landroid/os/CountDownTimer;", "setVisible", "", "setInfo", "data", "", "setData", "Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/case_timer/CaseTimerInfo;", "showButton", "close", "CommonUI"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class CaseTimerElement {
    private final HudElementCasesTimerBinding binding;
    private final SAMPUIElement notifier;
    private CountDownTimer timer;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void setData$lambda$0(View view) {
    }

    public CaseTimerElement(HudElementCasesTimerBinding binding, SAMPUIElement notifier) {
        Intrinsics.checkNotNullParameter(binding, "binding");
        Intrinsics.checkNotNullParameter(notifier, "notifier");
        this.binding = binding;
        this.notifier = notifier;
    }

    public final HudElementCasesTimerBinding getBinding() {
        return this.binding;
    }

    public final SAMPUIElement getNotifier() {
        return this.notifier;
    }

    public final void setVisible() {
        this.binding.getRoot().setVisibility(0);
        this.binding.main.setTranslationX(500.0f);
        this.binding.main.animate().translationX(0.0f).setDuration(400L).setInterpolator(new DecelerateInterpolator()).start();
    }

    public final void setInfo(String data) {
        Intrinsics.checkNotNullParameter(data, "data");
        try {
            setVisible();
            if (MapperKt.isJsonValid(data)) {
                setData((CaseTimerInfo) MapperKt.getGson().fromJson(data, (Class<Object>) CaseTimerInfo.class));
                return;
            }
            throw new JsonParseException("Json is not valid");
        } catch (Exception unused) {
            this.binding.getRoot().setVisibility(8);
        }
    }

    /* JADX WARN: Type inference failed for: r6v2, types: [ru.mrlargha.commonui.elements.hud.presentation.hud_screens.case_timer.CaseTimerElement$setData$1] */
    private final void setData(CaseTimerInfo caseTimerInfo) {
        CountDownTimer countDownTimer = this.timer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.timer = null;
        Picasso picasso = Picasso.get();
        String projectResourceUrl$default = FirebaseConfigHelper.getProjectResourceUrl$default(FirebaseConfigHelper.INSTANCE, false, 1, null);
        picasso.load(projectResourceUrl$default + "systems/cases/" + caseTimerInfo.getImage() + ".webp").into(this.binding.image);
        this.binding.timer.setText(TimeConverterKt.toTimeString(caseTimerInfo.getTime()));
        final long time = caseTimerInfo.getTime() * 1000;
        this.timer = new CountDownTimer(time) { // from class: ru.mrlargha.commonui.elements.hud.presentation.hud_screens.case_timer.CaseTimerElement$setData$1
            @Override // android.os.CountDownTimer
            public void onTick(long j) {
                CaseTimerElement.this.getBinding().timer.setText(TimeConverterKt.toTimeString((int) (j / 1000)));
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                CaseTimerElement.this.showButton();
                cancel();
            }
        }.start();
        this.binding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.hud.presentation.hud_screens.case_timer.CaseTimerElement$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CaseTimerElement.setData$lambda$0(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showButton() {
        this.binding.timer.setText("Получить");
        this.binding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.hud.presentation.hud_screens.case_timer.CaseTimerElement$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SAMPUIElement.notifyClick$default(CaseTimerElement.this.notifier, 72, 72, null, 4, null);
            }
        });
    }

    public final void close() {
        CountDownTimer countDownTimer = this.timer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.timer = null;
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new CaseTimerElement$close$1(this, null), 3, null);
    }
}
