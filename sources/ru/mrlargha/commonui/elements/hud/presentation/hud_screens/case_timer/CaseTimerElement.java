package ru.mrlargha.commonui.elements.hud.presentation.hud_screens.case_timer;

import android.view.View;
import android.view.animation.DecelerateInterpolator;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParseException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.core.SAMPUIElement;
import ru.mrlargha.commonui.databinding.HudElementCasesTimerBinding;
import ru.mrlargha.commonui.utils.MapperKt;
/* compiled from: CaseTimer.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010J\u0010\u0010\u0011\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0012H\u0002J\u0006\u0010\u0013\u001a\u00020\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/case_timer/CaseTimerElement;", "", "binding", "Lru/mrlargha/commonui/databinding/HudElementCasesTimerBinding;", "notifier", "Lru/mrlargha/commonui/core/SAMPUIElement;", "<init>", "(Lru/mrlargha/commonui/databinding/HudElementCasesTimerBinding;Lru/mrlargha/commonui/core/SAMPUIElement;)V", "getBinding", "()Lru/mrlargha/commonui/databinding/HudElementCasesTimerBinding;", "getNotifier", "()Lru/mrlargha/commonui/core/SAMPUIElement;", "setVisible", "", "setInfo", "data", "", "setData", "Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/case_timer/CaseTimerInfo;", "close", "CommonUI_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class CaseTimerElement {
    private final HudElementCasesTimerBinding binding;
    private final SAMPUIElement notifier;

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
        this.binding.main.setTranslationX(-300.0f);
        this.binding.main.animate().translationY(0.0f).setDuration(400L).setInterpolator(new DecelerateInterpolator()).start();
    }

    public final void setInfo(String data) {
        Intrinsics.checkNotNullParameter(data, "data");
        try {
            setVisible();
            if (MapperKt.isJsonValid(data)) {
                setData((CaseTimerInfo) new GsonBuilder().setLenient().create().fromJson(data, (Class<Object>) CaseTimerInfo.class));
                return;
            }
            throw new JsonParseException("Json is not valid");
        } catch (Exception unused) {
            this.binding.getRoot().setVisibility(8);
        }
    }

    private final void setData(CaseTimerInfo caseTimerInfo) {
        this.binding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.hud.presentation.hud_screens.case_timer.CaseTimerElement$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CaseTimerElement.setData$lambda$0(CaseTimerElement.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setData$lambda$0(CaseTimerElement caseTimerElement, View view) {
        SAMPUIElement.notifyClick$default(caseTimerElement.notifier, 74, 74, null, 4, null);
    }

    public final void close() {
        this.binding.getRoot().setVisibility(8);
    }
}
