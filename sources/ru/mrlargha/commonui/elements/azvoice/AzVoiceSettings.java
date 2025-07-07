package ru.mrlargha.commonui.elements.azvoice;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.core.SAMPUIElement;
import ru.mrlargha.commonui.core.UIElementAbstractSpawner;
import ru.mrlargha.commonui.elements.azvoice.adapter.SliderVoiceAdapter;
/* compiled from: AzVoiceSettings.kt */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001!B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0017J\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0005J\u0018\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u0005H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lru/mrlargha/commonui/elements/azvoice/AzVoiceSettings;", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "<init>", "(Landroid/app/Activity;I)V", "formLayout", "Landroidx/constraintlayout/widget/ConstraintLayout;", "switch", "Landroidx/appcompat/widget/SwitchCompat;", "switchText", "Landroid/widget/TextView;", "closeButton", "Landroidx/appcompat/widget/AppCompatImageView;", "userVoiceSettingsButton", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "sliderAdapter", "Lru/mrlargha/commonui/elements/azvoice/adapter/SliderVoiceAdapter;", "sliderList", "", "Lru/mrlargha/commonui/elements/azvoice/SoundSliderData;", "idCounter", "addSlider", "sliderData", "removeSlider", "", "id", "valueChanged", "sliderId", "newValue", "Spawner", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AzVoiceSettings extends SAMPUIElement {
    private final AppCompatImageView closeButton;
    private final ConstraintLayout formLayout;
    private int idCounter;
    private final RecyclerView recyclerView;
    private final SliderVoiceAdapter sliderAdapter;
    private List<SoundSliderData> sliderList;

    /* renamed from: switch  reason: not valid java name */
    private final SwitchCompat f93switch;
    private final TextView switchText;
    private final TextView userVoiceSettingsButton;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AzVoiceSettings(final Activity targetActivity, final int i) {
        super(targetActivity, i);
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        View inflate = targetActivity.getLayoutInflater().inflate(R.layout.az_voice_settings, (ViewGroup) null);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
        ConstraintLayout constraintLayout = (ConstraintLayout) inflate;
        this.formLayout = constraintLayout;
        View findViewById = constraintLayout.findViewById(R.id.micro_switch);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        SwitchCompat switchCompat = (SwitchCompat) findViewById;
        this.f93switch = switchCompat;
        View findViewById2 = constraintLayout.findViewById(R.id.micro_state_text);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
        this.switchText = (TextView) findViewById2;
        View findViewById3 = constraintLayout.findViewById(R.id.closeButton);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
        AppCompatImageView appCompatImageView = (AppCompatImageView) findViewById3;
        this.closeButton = appCompatImageView;
        View findViewById4 = constraintLayout.findViewById(R.id.viewPlayers);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(...)");
        TextView textView = (TextView) findViewById4;
        this.userVoiceSettingsButton = textView;
        View findViewById5 = constraintLayout.findViewById(R.id.slidersRecycler);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(...)");
        RecyclerView recyclerView = (RecyclerView) findViewById5;
        this.recyclerView = recyclerView;
        SliderVoiceAdapter sliderVoiceAdapter = new SliderVoiceAdapter(new Function3() { // from class: ru.mrlargha.commonui.elements.azvoice.AzVoiceSettings$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit sliderAdapter$lambda$0;
                sliderAdapter$lambda$0 = AzVoiceSettings.sliderAdapter$lambda$0(AzVoiceSettings.this, ((Integer) obj).intValue(), ((Integer) obj2).intValue(), ((Integer) obj3).intValue());
                return sliderAdapter$lambda$0;
            }
        });
        this.sliderAdapter = sliderVoiceAdapter;
        this.sliderList = new ArrayList();
        addViewToConstraintLayout(constraintLayout, -1, -1);
        switchCompat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: ru.mrlargha.commonui.elements.azvoice.AzVoiceSettings$$ExternalSyntheticLambda3
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                AzVoiceSettings._init_$lambda$1(AzVoiceSettings.this, targetActivity, i, compoundButton, z);
            }
        });
        appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.azvoice.AzVoiceSettings$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AzVoiceSettings._init_$lambda$2(AzVoiceSettings.this, i, view);
            }
        });
        textView.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.azvoice.AzVoiceSettings$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AzVoiceSettings._init_$lambda$3(AzVoiceSettings.this, i, view);
            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(targetActivity));
        recyclerView.setAdapter(sliderVoiceAdapter);
        setVisibility(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit sliderAdapter$lambda$0(AzVoiceSettings azVoiceSettings, int i, int i2, int i3) {
        azVoiceSettings.valueChanged(i2, i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$1(AzVoiceSettings azVoiceSettings, Activity activity, int i, CompoundButton compoundButton, boolean z) {
        int color;
        TextView textView = azVoiceSettings.switchText;
        if (z) {
            color = activity.getResources().getColor(R.color.arizona_second_accent, activity.getTheme());
        } else {
            color = activity.getResources().getColor(R.color.arizona_accent, activity.getTheme());
        }
        textView.setTextColor(color);
        azVoiceSettings.getNotifier().switchStatusChangedWrapper(i, 1, z);
        azVoiceSettings.switchText.setText(z ? "Вкл." : "Выкл.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$2(AzVoiceSettings azVoiceSettings, int i, View view) {
        azVoiceSettings.getNotifier().clickedWrapper(i, 2, -1);
        azVoiceSettings.setVisibility(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$3(AzVoiceSettings azVoiceSettings, int i, View view) {
        azVoiceSettings.getNotifier().clickedWrapper(i, 1, -1);
    }

    public final int addSlider(SoundSliderData sliderData) {
        Intrinsics.checkNotNullParameter(sliderData, "sliderData");
        int i = this.idCounter + 1;
        this.idCounter = i;
        sliderData.setSliderUId(i);
        this.sliderList.add(sliderData);
        getTargetActivity().runOnUiThread(new Runnable() { // from class: ru.mrlargha.commonui.elements.azvoice.AzVoiceSettings$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                AzVoiceSettings.addSlider$lambda$4(AzVoiceSettings.this);
            }
        });
        return this.idCounter;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void addSlider$lambda$4(AzVoiceSettings azVoiceSettings) {
        azVoiceSettings.sliderAdapter.submitList(azVoiceSettings.sliderList);
        azVoiceSettings.sliderAdapter.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean removeSlider$lambda$5(int i, SoundSliderData it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getSliderUId() == i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean removeSlider$lambda$6(Function1 function1, Object obj) {
        return ((Boolean) function1.invoke(obj)).booleanValue();
    }

    public final void removeSlider(final int i) {
        List<SoundSliderData> list = this.sliderList;
        final Function1 function1 = new Function1() { // from class: ru.mrlargha.commonui.elements.azvoice.AzVoiceSettings$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                boolean removeSlider$lambda$5;
                removeSlider$lambda$5 = AzVoiceSettings.removeSlider$lambda$5(i, (SoundSliderData) obj);
                return Boolean.valueOf(removeSlider$lambda$5);
            }
        };
        Boolean.valueOf(list.removeIf(new Predicate() { // from class: ru.mrlargha.commonui.elements.azvoice.AzVoiceSettings$$ExternalSyntheticLambda1
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                boolean removeSlider$lambda$6;
                removeSlider$lambda$6 = AzVoiceSettings.removeSlider$lambda$6(Function1.this, obj);
                return removeSlider$lambda$6;
            }
        }));
        this.sliderAdapter.submitList(this.sliderList);
        this.sliderAdapter.notifyDataSetChanged();
    }

    private final void valueChanged(int i, int i2) {
        getNotifier().sliderValueChangedWrapper(getBackendID(), i, i2);
    }

    /* compiled from: AzVoiceSettings.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lru/mrlargha/commonui/elements/azvoice/AzVoiceSettings$Spawner;", "Lru/mrlargha/commonui/core/UIElementAbstractSpawner;", "<init>", "()V", "create", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Spawner extends UIElementAbstractSpawner {
        @Override // ru.mrlargha.commonui.core.UIElementAbstractSpawner
        public SAMPUIElement create(Activity targetActivity, int i) {
            Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
            return new AzVoiceSettings(targetActivity, i);
        }
    }
}
